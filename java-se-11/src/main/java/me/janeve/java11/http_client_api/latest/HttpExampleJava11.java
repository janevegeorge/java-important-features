package me.janeve.java11.http_client_api.latest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class HttpExampleJava11 {

    private static Logger LOGGER = LogManager.getLogger();

    // Create your own fake APIs at beeceptor.com and replace this URL.
    public static final String GET_URL = "https://janeve.free.beeceptor.com/users";
    public static final String POST_URL = "https://janeve.free.beeceptor.com/users";

    public static void main(String[] args) {
        simpleGetRequest();
        postRequestWithParametersAndHeaders();
        getRequestWithTimeouts();
    }

    private static void simpleGetRequest() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(URI.create(GET_URL)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            LOGGER.info("simpleGetRequest Response: " + response.body());
        } catch (IOException | InterruptedException e) {
            LOGGER.error(e);
        }
    }

    private static void postRequestWithParametersAndHeaders() {
        try {
            // Adding HTTP Request Parameters
            Map<Object, Object> data = new HashMap<>();
            data.put("fname", "Janeve");
            data.put("lname", "George");

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .POST(ofFormData(data))
                    .uri(URI.create(POST_URL))
                    .header("Content-Type", "application/json") // Adding Headers
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            LOGGER.info("postRequestWithParametersAndHeaders Response: " + response.body());
        } catch (IOException | InterruptedException e) {
            LOGGER.error(e);
        }
    }

    private static void getRequestWithTimeouts() {
        try {
            HttpClient client = HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(5))  // Setting Connection Timeout of 5 Seconds
                    .build();
            HttpRequest request = HttpRequest.newBuilder(URI.create(GET_URL))
                    .timeout(Duration.ofSeconds(5))         // Setting Read Timeout of 5 Seconds
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            LOGGER.info("getRequestWithTimeouts Response: " + response.body());
        } catch (IOException | InterruptedException e) {
            LOGGER.error(e);
        }
    }

    public static HttpRequest.BodyPublisher ofFormData(Map<Object, Object> data) {
        var builder = new StringBuilder();
        for (Map.Entry<Object, Object> entry : data.entrySet()) {
            if (builder.length() > 0) {
                builder.append("&");
            }
            builder.append(encode(entry.getKey()));
            builder.append("=");
            builder.append(encode(entry.getValue()));
        }
        return HttpRequest.BodyPublishers.ofString(builder.toString());
    }

    private static String encode(Object key) {
        return URLEncoder.encode(key.toString(), StandardCharsets.UTF_8);
    }

}