package me.janeve.java11.http_client_api.pre.async;

import me.janeve.java11.http_client_api.AsyncHttpResponseHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncHttpURLConnection {

    private static Logger LOGGER = LogManager.getLogger();

    private final ExecutorService threadPool = Executors.newCachedThreadPool();

    public void get(final String get_url, final AsyncHttpResponseHandler handler) {
        threadPool.execute(() -> {
            try {
                LOGGER.info("Starting to make request");
                // The code to actually request starts here...
                URL url = new URL(get_url);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");

                // Setting the connection and read timeouts
                con.setConnectTimeout(240000);
                con.setReadTimeout(240000);

                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuilder responseBuilder = new StringBuilder();
                for(String str; (str = in.readLine()) != null; ){
                    responseBuilder.append(str);
                }
                in.close();
                LOGGER.info("Response received");
                handler.handle(responseBuilder.toString());
                // The code to actually request ends here ...

            } catch (MalformedURLException e) {
                handler.handleError(e);
            } catch (ProtocolException e) {
                handler.handleError(e);
            } catch (IOException e) {
                handler.handleError(e);
            }
        });
        threadPool.shutdown();
    }

}