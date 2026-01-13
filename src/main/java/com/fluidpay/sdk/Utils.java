package com.fluidpay.sdk;

import java.io.*;
import java.net.HttpURLConnection;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Utils {

    String urlBuilder(String[] params) {
        StringBuilder path = new StringBuilder();
        for(String param: params) {
            path.append('/').append(param);
        }
        return path.toString();
    }

    /**
     * doRequest returns the response body as String from the API
     * @param conn is for additional config on the connection
     * @param method is to set the request method
     * @param body is the request body sent
     * @param apiKey is the authentication sent in the header
     */
    String doRequest(HttpURLConnection conn, String method, byte[] body, String apiKey) throws IOException {
        try {
            if (body != null) {
                conn.setFixedLengthStreamingMode(body.length);
            }
            conn.setDoOutput(true);
            conn.setRequestMethod(method);
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setRequestProperty("Authorization", apiKey);
            conn.connect();
            if (body != null) {
                OutputStream os = conn.getOutputStream();
                try {
                    os.write(body);
                } finally {
                    os.flush();
                    os.close();
                }
            }
            // Check response code and read from appropriate stream
            int responseCode = conn.getResponseCode();
            InputStream inputStream = responseCode >= 200 && responseCode < 300 
                ? conn.getInputStream() 
                : conn.getErrorStream();
            
            if (inputStream == null) {
                throw new IOException("Server returned HTTP response code: " + responseCode + " for URL: " + conn.getURL());
            }
            
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, UTF_8));
            StringBuilder resp = new StringBuilder();
            try {
                String line;
                while ((line = in.readLine()) != null) {
                    resp.append(line);
                }
            } finally {
                in.close();
            }
            return resp.toString();
        } finally {
            conn.disconnect();
        }
    }
}
