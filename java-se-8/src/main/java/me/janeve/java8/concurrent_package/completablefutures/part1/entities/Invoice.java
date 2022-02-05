package me.janeve.java8.concurrent_package.completablefutures.part1.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter
@Builder
@ToString
public class Invoice {
    private Integer invoiceId;
    private Integer invoiceNumber;
    private List<LineItem> items;
}
