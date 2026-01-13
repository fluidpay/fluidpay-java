package com.fluidpay.sdk;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fluidpay.sdk.models.transactions.*;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * Handles transaction processing operations including processing transactions,
 * querying transaction status, searching transactions, capturing, voiding, and refunding.
 */
public class Transactions {
    private ObjectMapper om = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    private Utils util = new Utils();

    /**
     * Process a transaction through the gateway.
     * Supports multiple payment methods: card, ACH, customer vault, terminal, token, APM, and Apple Pay.
     * 
     * All transaction request models (CardTransactionRequest, AchTransactionRequest, 
     * CustomerTransactionRequest, TerminalTransactionRequest) support all fields documented 
     * in the Fluidpay API. See the request model classes for available fields.
     * 
     * POST /api/transaction
     */
    public TerminalResponse doTransaction(HttpURLConnection conn, TransactionRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, TerminalResponse.class);
    }

    /**
     * Retrieve details for a specific transaction.
     * GET /api/transaction/{transaction_id}
     */
    public TransactionSearchResponse getTransactionStatus(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "GET", null, apiKey);

        return om.readValue(resBody, TransactionSearchResponse.class);
    }

    /**
     * Retrieve details for all transactions that match provided search criteria.
     * If no created_at date range is provided, defaults to the prior four months.
     * POST /api/transaction/search
     */
    public TransactionSearchResponse queryTransactions(HttpURLConnection conn, TransactionQueryRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, TransactionSearchResponse.class);
    }

    /**
     * Capture funds for a specified transaction that has already been authorized.
     * POST /api/transaction/{transaction_id}/capture
     */
    public TransactionResponse captureTransaction(HttpURLConnection conn, TransactionCaptureRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, TransactionResponse.class);
    }

    /**
     * Void a transaction that is pending settlement.
     * Where applicable, a void will be processed as an auth reversal.
     * POST /api/transaction/{transaction_id}/void
     */
    public TransactionResponse voidTransaction(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "POST", null, apiKey);

        return om.readValue(resBody, TransactionResponse.class);
    }

    /**
     * Process a refund for a transaction that has already been settled.
     * Multiple partial refunds can be processed, but the total amount of all refunds
     * cannot exceed the previously settled amount.
     * POST /api/transaction/{transaction_id}/refund
     */
    public TransactionResponse refundTransaction(HttpURLConnection conn, TransactionRefundRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, TransactionResponse.class);
    }
}
