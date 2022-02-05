package me.janeve.java8.concurrent_package.completablefutures.part1.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@Builder
@ToString
public class Customer {
    private Integer customerId;
    private String fName;
    private String lName;
    private String username;
}