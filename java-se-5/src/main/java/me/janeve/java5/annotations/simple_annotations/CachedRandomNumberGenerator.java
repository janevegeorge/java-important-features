package me.janeve.java5.annotations.simple_annotations;

import java.util.Random;

public class CachedRandomNumberGenerator {

    @Cached private Integer minuteNumber;   // Cache field for one minute (default)
    @Cached(expireIn = 10000) private Integer tenSecondsNumber; // Cache the field for 10 seconds

    private static final CachedRandomNumberGenerator instance = new CachedRandomNumberGenerator();

    private CachedRandomNumberGenerator() {
        // Registering this object for cache management.
        CacheManager.register(this);
    }

    public static CachedRandomNumberGenerator getInstance(){
        return instance;
    }

    private Random randomNumberGenerator = new Random();

    public Integer getMinuteNumber() {
        if(minuteNumber == null) {
            minuteNumber = randomNumberGenerator.nextInt(1000);
        }
        return minuteNumber;
    }

    public Integer getTenSecondsNumber(){
        if (tenSecondsNumber == null) {
            tenSecondsNumber = randomNumberGenerator.nextInt(1000);
        }
        return tenSecondsNumber;
    }

    public void close(){
        CacheManager.shutdown(instance);
    }
}