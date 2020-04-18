package me.janeve.java5.annotations.simple_annotations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        CachedRandomNumberGenerator numberGenerator = CachedRandomNumberGenerator.getInstance();
        for (int i = 1; i <= 15; i++) {
            LOGGER.info("Numbers: (" + numberGenerator.getMinuteNumber() + "m," + numberGenerator.getTenSecondsNumber() + "s)");
            sleep(5);
        }
        numberGenerator.close();
    }

    private static void sleep(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}