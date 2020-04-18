package me.janeve.java5.annotations.simple_annotations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * The CacheManager classes uses reflection to read the annotations
 * and process the cache of the registered objects accordingly
 *
 * If the @me.janeve.java5.annotations.simple_annotations.Cached annotation is used,
 * but the object is not registered with the cache manager, then the cached item will not be cleared.
 */
public class CacheManager extends Thread {

    private static Logger LOGGER = LogManager.getLogger();

    private static final Map<Object, CacheManager> objectThreads = new HashMap<Object, CacheManager>();

    private final Map<String, Date> cachedItems = new HashMap<String, Date>();

    private Object objectWithCachedProperties;
    private boolean shutdownSignalled = false;

    private CacheManager(Object objectWithCachedProperties) {
        this.objectWithCachedProperties = objectWithCachedProperties;
        Field[] allFields = objectWithCachedProperties.getClass().getDeclaredFields();
        for (Field field:allFields) {
            renewCache(field);
        }
    }

    private void renewCache(Field field) {
        if(field.isAnnotationPresent(Cached.class)) {
            Cached annotation = field.getAnnotation(Cached.class);

            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            c.add(Calendar.MILLISECOND, annotation.expireIn());

            cachedItems.put(field.getName(), c.getTime());
        }
    }

    public synchronized static void register(Object objectWithCachedProperties) {
        if(objectThreads.get(objectWithCachedProperties) == null) {
            CacheManager cacheManagerThread = new CacheManager(objectWithCachedProperties);
            cacheManagerThread.setName("Thread - " + objectWithCachedProperties.toString());
            cacheManagerThread.start();

            objectThreads.put(objectWithCachedProperties, cacheManagerThread);
        }
    }

    public synchronized static void shutdown(Object obj){
        CacheManager thread = objectThreads.get(obj);
        if(thread!=null) {
            thread.shutdownSignalled = true;
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        objectThreads.remove(obj);
    }

    @Override
    public void run() {
        while (!shutdownSignalled) {
            for (Map.Entry<String, Date> entry:cachedItems.entrySet()) {

                if (new Date().after(entry.getValue())) {
                    LOGGER.info(entry.getKey() + " expired at " + new SimpleDateFormat("HH:mm:ss.SSS").format(entry.getValue()));
                    try {
                        Field field = objectWithCachedProperties.getClass().getDeclaredField(entry.getKey());
                        boolean fieldAccessibility = field.isAccessible();
                        field.setAccessible(true);
                        field.set(objectWithCachedProperties, null);
                        field.setAccessible(fieldAccessibility);
                        renewCache(field);
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}