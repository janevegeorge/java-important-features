package me.janeve.java11.http_client_api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsolePrinterResponseHandler implements AsyncHttpResponseHandler {

    private static Logger LOGGER = LogManager.getLogger();

    @Override
    public void handle(String response) {
        LOGGER.info("Handled response" + response);
    }

    @Override
    public void handleError(Exception e) {
        LOGGER.error("Error with the request", e);
    }
}
