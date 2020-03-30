package me.janeve.java11.http_client_api.pre;

import me.janeve.java11.http_client_api.ConsolePrinterResponseHandler;
import me.janeve.java11.http_client_api.pre.async.AsyncHttpURLConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AsyncHttpExampleBeforeJava11 {

    private static Logger LOGGER = LogManager.getLogger();

    // Create your own fake APIs at beeceptor.com and replace this URL.
    // Configure a high "Response delayed by" for the endpoint for a better experience of the code
    public static final String GET_URL = "https://janeve.free.beeceptor.com/longtime";

    public static void main(String[] args) {
        simpleAsyncHttpRequest();
    }

    private static void simpleAsyncHttpRequest() {
        LOGGER.info("Before making an async request that would take a lot of time.");
        AsyncHttpURLConnection asyncConnection = new AsyncHttpURLConnection();
        asyncConnection.get(GET_URL, new ConsolePrinterResponseHandler());
        LOGGER.info("After making the async request.");
    }

}