package com.fluidpay.sdk;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fluidpay.sdk.models.transactions.*;

import java.io.IOException;
import java.net.HttpURLConnection;

public class Transactions {
    private ObjectMapper om = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    private Utils util = new Utils();

    public TerminalResponse doTransaction(HttpURLConnection conn, TransactionRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, TerminalResponse.class);
    }

    public TransactionSearchResponse getTransactionStatus(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "GET", null, apiKey);

        return om.readValue(resBody, TransactionSearchResponse.class);
    }

    public TransactionSearchResponse queryTransactions(HttpURLConnection conn, TransactionQueryRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, TransactionSearchResponse.class);
    }

    public TransactionResponse captureTransaction(HttpURLConnection conn, TransactionCaptureRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, TransactionResponse.class);
    }

    public TransactionResponse voidTransaction(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "POST", null, apiKey);

        return om.readValue(resBody, TransactionResponse.class);
    }

    public TransactionResponse refundTransaction(HttpURLConnection conn, TransactionRefundRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, TransactionResponse.class);
    }
}
