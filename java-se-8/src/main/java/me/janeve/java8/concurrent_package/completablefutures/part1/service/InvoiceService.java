package me.janeve.java8.concurrent_package.completablefutures.part1.service;

import me.janeve.java8.concurrent_package.completablefutures.part1.entities.Invoice;
import me.janeve.java8.concurrent_package.completablefutures.part1.entities.LineItem;
import me.janeve.java8.helpers.Timer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InvoiceService {

    private static final Random randomizer = new Random();

    public static Invoice fetchInvoice(Integer invoiceId) {
        Timer.start("fetchInvoice::"+invoiceId);
        Timer.delay(200, 600);
        int N = 5;

        List<LineItem> lineItems = new ArrayList<>();

        for(int i=0; i<N; i++) {
            lineItems.add(LineItem.builder()
                    .productId(100 + randomizer.nextInt(10000))
                    .amount(randomizer.nextDouble())
                    .quantity(randomizer.nextInt(10))
                    .slNo(20000 + randomizer.nextInt(1000000))
                    .build());
        }
        Invoice invoice = Invoice.builder().invoiceId(invoiceId).items(lineItems).build();

        Timer.stop("fetchInvoice::"+invoiceId);
        return invoice;
    }
}
