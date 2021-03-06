package me.janeve.java11.http_client_api.pre;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HttpExampleBeforeJava11 {

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
            // The code to actually request starts here...
            URL url = new URL(GET_URL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            for(String str; (str = in.readLine()) != null; ){
                responseBuilder.append(str);
            }
            in.close();
            LOGGER.info("simpleGetRequest Response: " + responseBuilder.toString());
            // The code to actually request ends here ...

        } catch (MalformedURLException e) {
            LOGGER.error(e);
        } catch (ProtocolException e) {
            LOGGER.error(e);
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }

    private static void postRequestWithParametersAndHeaders() {
        try {
            // The code to actually request starts here...
            URL url = new URL(POST_URL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");

            // Adding headers to the request
            con.setRequestProperty("Content-Type", "application/json");

            // Adding HTTP Request Parameters
            con.setDoOutput(true);
            DataOutputStream dos = new DataOutputStream(con.getOutputStream());
            dos.writeChars("fname=Janeve&lname=George");
            dos.flush();
            dos.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            for(String str; (str = in.readLine()) != null; ){
                responseBuilder.append(str);
            }
            in.close();
            LOGGER.info("postRequestWithParametersAndHeaders Response: " + responseBuilder.toString());
            // The code to actually request ends here ...

        } catch (MalformedURLException e) {
            LOGGER.error(e);
        } catch (ProtocolException e) {
            LOGGER.error(e);
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }

    private static void getRequestWithTimeouts() {
        try {
            URL url = new URL(GET_URL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // Setting the connection and read timeouts
            con.setConnectTimeout(1000);
            con.setReadTimeout(1000);

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder responseBuilder = new StringBuilder();
            for(String str; (str = in.readLine()) != null; ){
                responseBuilder.append(str);
            }
            in.close();
            LOGGER.info("getRequestWithTimeouts Response: " + responseBuilder.toString());

        } catch (MalformedURLException e) {
            LOGGER.error(e);
        } catch (ProtocolException e) {
            LOGGER.error(e);
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }

}