package me.janeve.java8.concurrent_package.completablefutures.part1.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class TransactionData {
    private Integer orderId;
    private Integer customerId;
    private Integer invoiceId;
}