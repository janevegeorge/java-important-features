package me.janeve.java8.concurrent_package.completablefutures.part1.service;

import me.janeve.java8.concurrent_package.completablefutures.part1.entities.ProductInfo;
import me.janeve.java8.helpers.Timer;

import java.util.Random;

public class ProductInfoService {
    public static ProductInfo getProductInfo(Integer productId) {
        String timerKey = "getProductInfo::"+productId+randomString();
        Timer.start(timerKey);
        Timer.delay(50, 300);
        ProductInfo info = ProductInfo.builder().productId(productId).name(randomString()).category(randomString()).build();
        Timer.stop(timerKey);
        return info;
    }

    public static String randomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}