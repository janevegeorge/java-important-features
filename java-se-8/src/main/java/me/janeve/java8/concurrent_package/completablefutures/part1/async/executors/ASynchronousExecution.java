package me.janeve.java8.concurrent_package.completablefutures.part1.async.executors;

import me.janeve.java8.concurrent_package.completablefutures.part1.entities.TransactionData;
import me.janeve.java8.concurrent_package.completablefutures.part1.entities.TransactionDetails;
import me.janeve.java8.concurrent_package.completablefutures.part1.service.CustomerService;
import me.janeve.java8.concurrent_package.completablefutures.part1.service.InvoiceService;
import me.janeve.java8.concurrent_package.completablefutures.part1.service.OrderService;
import me.janeve.java8.concurrent_package.completablefutures.part1.service.ProductInfoService;
import me.janeve.java8.helpers.Timer;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ASynchronousExecution {
    public TransactionDetails fetchTransactionDetails(final TransactionData payload) {
        Timer.start("ASynchronousExecution::"+payload.getOrderId());

        final TransactionDetails.TransactionDetailsBuilder builder = TransactionDetails.builder();

        CompletableFuture.allOf(
                    fetchInvoice(payload, builder),
                    fetchOrder(payload, builder),
                    fetchCustomer(payload, builder)
                ).join();

        TransactionDetails data = builder.build();
        Timer.stop("ASynchronousExecution::"+payload.getOrderId());
        return data;
    }

    private CompletableFuture<Void> fetchCustomer(TransactionData payload, TransactionDetails.TransactionDetailsBuilder builder) {
        return CompletableFuture.supplyAsync(() -> CustomerService.fetchCustomer(payload.getCustomerId())).thenAccept(builder::customer);
    }

    private CompletableFuture<Void> fetchOrder(TransactionData payload, TransactionDetails.TransactionDetailsBuilder builder) {
        return CompletableFuture.supplyAsync(() -> OrderService.fetchOrder(payload.getOrderId())).thenAccept(builder::order);
    }

    private CompletableFuture<Void> fetchInvoice(TransactionData payload, TransactionDetails.TransactionDetailsBuilder builder) {
        return CompletableFuture.supplyAsync(() -> InvoiceService.fetchInvoice(payload.getInvoiceId()))
                .thenApply(invoice -> {
                    List<CompletableFuture<Void>> futures = invoice.getItems().stream()
                            .map(lineItem -> CompletableFuture.supplyAsync(() -> ProductInfoService.getProductInfo(lineItem.getProductId()))
                                    .thenAccept(lineItem::setProductInfo))
                            .collect(Collectors.toList());
                    CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()])).join();
                    return invoice;
                })
                .thenAccept(builder::invoice);
    }
}