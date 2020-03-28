package me.janeve.java11.http_client_api;

public interface AsyncHttpResponseHandler {

    void handle(String response);
    void handleError(Exception e);

}