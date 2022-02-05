package me.janeve.java8.concurrent_package.completablefutures.part1.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@Builder
@ToString
public class LineItem {
    private Integer slNo;
    private Integer productId;
    private Integer quantity;
    private Double amount;
    private ProductInfo productInfo;
}
