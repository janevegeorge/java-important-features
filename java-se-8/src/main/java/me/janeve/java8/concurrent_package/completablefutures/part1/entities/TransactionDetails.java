package me.janeve.java8.concurrent_package.completablefutures.part1.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter
@ToString
@Builder
public class TransactionDetails {
    private Order order;
    private Customer customer;
    private Invoice invoice;
}