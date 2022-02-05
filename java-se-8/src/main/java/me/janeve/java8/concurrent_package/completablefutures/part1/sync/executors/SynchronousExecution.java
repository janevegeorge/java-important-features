package me.janeve.java8.concurrent_package.completablefutures.part1.sync.executors;

import me.janeve.java8.concurrent_package.completablefutures.part1.entities.*;
import me.janeve.java8.concurrent_package.completablefutures.part1.service.CustomerService;
import me.janeve.java8.concurrent_package.completablefutures.part1.service.InvoiceService;
import me.janeve.java8.concurrent_package.completablefutures.part1.service.OrderService;
import me.janeve.java8.concurrent_package.completablefutures.part1.service.ProductInfoService;
import me.janeve.java8.helpers.Timer;

public class SynchronousExecution {
    public TransactionDetails fetchTransactionDetails(TransactionData payload){
        Timer.start("SynchronousExecution::"+payload.getOrderId());
        Order order = OrderService.fetchOrder(payload.getOrderId());
        Customer customer = CustomerService.fetchCustomer(payload.getCustomerId());
        Invoice invoice = InvoiceService.fetchInvoice(payload.getInvoiceId());

        for(LineItem item: invoice.getItems()) {
            item.setProductInfo( ProductInfoService.getProductInfo(item.getProductId()) );
        }

        TransactionDetails data = TransactionDetails.builder()
                .order(order)
                .customer(customer)
                .invoice(invoice)
                .build();
        Timer.stop("SynchronousExecution::"+payload.getOrderId());
        return data;
    }
}