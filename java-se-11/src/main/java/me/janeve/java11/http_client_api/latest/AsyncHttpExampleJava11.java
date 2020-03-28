package me.janeve.java11.http_client_api.latest;

import me.janeve.java11.http_client_api.ConsolePrinterResponseHandler;
import org.apache.log4j.Logger;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class AsyncHttpExampleJava11 {

    static Logger LOGGER = Logger.getLogger(AsyncHttpExampleJava11.class);

    // Create your own fake APIs at beeceptor.com and replace this URL.
    // Configure a high "Response delayed by" for the endpoint for a better experience of the code
    public static final String GET_URL = "<< API ENDPOINT HERE >>";

    public static void main(String[] args) {
        simpleAsyncHttpRequest();
    }

    private static void simpleAsyncHttpRequest() {
        LOGGER.info("Before making an async request that would take a lot of time.");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(GET_URL)).build();
        CompletableFuture<HttpResponse<String>> completableFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
        .thenApply(response -> {
            new ConsolePrinterResponseHandler().handle(response.body());
            return response;
        });
        LOGGER.info("After making the async request.");
        completableFuture.join();
    }

}