package me.janeve.java8.concurrent_package.completablefutures.part1.service;

import me.janeve.java8.concurrent_package.completablefutures.part1.entities.Customer;
import me.janeve.java8.helpers.Timer;

public class CustomerService {
    public static Customer fetchCustomer(Integer customerId) {
        Timer.start("fetchCustomer::"+customerId);
        Timer.delay(50, 150);
        Customer customer = Customer.builder().customerId(customerId).build();
        Timer.stop("fetchCustomer::"+customerId);
        return customer;
    }
}
