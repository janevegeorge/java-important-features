package me.janeve.java8.concurrent_package.completablefutures.part1.async;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import me.janeve.java8.concurrent_package.completablefutures.part1.async.executors.ASynchronousExecution;
import me.janeve.java8.concurrent_package.completablefutures.part1.entities.TransactionData;
import me.janeve.java8.helpers.Timer;


public class Part1AsyncMain {

    public static final Gson CONVERTER = new Gson();
    public static final String VALID_ARGUMENT_FORMAT = "[{\"orderId\": \"[Order ID]\", \"customerId\":\"[Customer ID]\", \"invoiceId\":\"[Invoice ID]\"}, {...}]";

    public static void main(String[] args) {
        if(args.length != 1) {noArguments(args.length); return;}
        TransactionData[] payloads = new TransactionData[0];
        try{
            payloads = CONVERTER.fromJson(args[0], TransactionData[].class);
        } catch (JsonSyntaxException exp) {
            invalidData();
        }
        Timer.start("MAIN");
        for(TransactionData payload: payloads) {
            System.out.println("Result: " + new ASynchronousExecution().fetchTransactionDetails(payload));
        }
        Timer.stop("MAIN");
    }

    private static void invalidData() {
        System.err.println("Invalid JSON Argument. Format: " + VALID_ARGUMENT_FORMAT);
    }

    private static void noArguments(int length) {
        System.err.println(length + " Arguments. No JSON payload provided. Format: " + VALID_ARGUMENT_FORMAT);
    }

}