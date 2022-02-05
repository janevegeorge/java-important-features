package me.janeve.java8.concurrent_package.completablefutures.part1.service;

import me.janeve.java8.concurrent_package.completablefutures.part1.entities.Order;
import me.janeve.java8.helpers.Timer;

public class OrderService {
    public static Order fetchOrder(Integer orderId) {
        Timer.start("fetchOrder::"+orderId);
        Timer.delay(100, 300);
        Order order = Order.builder().orderId(orderId).build();
        Timer.stop("fetchOrder::"+orderId);
        return order;
    }
}