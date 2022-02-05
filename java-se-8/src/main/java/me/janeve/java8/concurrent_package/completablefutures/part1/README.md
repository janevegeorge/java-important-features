# Java Asynchronous Programming  using CompletableFuture - Part 1
The interface `java.util.concurrent.CompletionStage` and the class `java.util.concurrent.CompletableFuture` were introduced in Java 8 as a part of Concurrency API improvements.

You can read more about asynchronous programming in the article [Java CompletableFutures - Part - 1](https://www.janeve.me/software-programming).

## Running the Main methods
There are two classes that has the main method:
* `me.janeve.java8.concurrent_package.completablefutures.part1.sync.Part1SyncMain`
* `me.janeve.java8.concurrent_package.completablefutures.part1.async.Part1AsyncMain`

You will need a JSON payload to provide in the command line. Use the following string for your command line argument. You can make any changes in the JSON to suite your executions.
```json
[
  {
    "orderId":1,
    "customerId":1,
    "invoiceId":1
  },
  {
    "orderId":2,
    "customerId":2,
    "invoiceId":2
  }
]
```

## Website
http://www.janeve.me