package me.janeve.java8.concurrent_package.completablefutures.part1.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.ZonedDateTime;

@Getter @Setter
@ToString
@Builder
public class Order {
    private Integer orderId;
    private ZonedDateTime executedAt;
    private Integer terminalType;
    private Integer customerId;
    private Integer invoiceId;
}