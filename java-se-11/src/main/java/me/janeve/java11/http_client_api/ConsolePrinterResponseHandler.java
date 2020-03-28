package me.janeve.java11.http_client_api;

import org.apache.log4j.Logger;

public class ConsolePrinterResponseHandler implements AsyncHttpResponseHandler {

    static Logger LOGGER = Logger.getLogger(ConsolePrinterResponseHandler.class);

    @Override
    public void handle(String response) {
        LOGGER.info("Handled response" + response);
    }

    @Override
    public void handleError(Exception e) {
        LOGGER.error("Error with the request", e);
    }
}
