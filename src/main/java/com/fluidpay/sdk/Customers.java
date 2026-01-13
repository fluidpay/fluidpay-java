package com.fluidpay.sdk;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fluidpay.sdk.models.customers.*;

import java.io.IOException;
import java.net.HttpURLConnection;

public class Customers {
    private ObjectMapper om = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    private Utils util = new Utils();

    /**
     * Creates a new Customer record that can contain stored preferences, payment methods, and addresses.
     * POST /api/vault/customer
     */
    public CustomerResponse createCustomer(HttpURLConnection conn, CreateCustomerRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, CustomerResponse.class);
    }

    /**
     * Retrieve details for the specified customer.
     * GET /api/vault/{customer_id}
     */
    public CustomerResponse getCustomer(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "GET", null, apiKey);

        return om.readValue(resBody, CustomerResponse.class);
    }

    /**
     * Update an existing customer record.
     * POST /api/vault/customer/{customer_id}
     */
    public CustomerResponse updateCustomer(HttpURLConnection conn, UpdateCustomerRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, CustomerResponse.class);
    }

    /**
     * Retrieve details for all customer records that match provided search criteria.
     * POST /api/vault/customer/search
     */
    public CustomersResponse searchCustomers(HttpURLConnection conn, CustomerSearchRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, CustomersResponse.class);
    }

    /**
     * Delete the specified customer record.
     * DELETE /api/vault/{customer_id}
     */
    public CustomerResponse deleteCustomer(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "DELETE", null, apiKey);

        return om.readValue(resBody, CustomerResponse.class);
    }

    // --------------------- Customer address section. --------------------------
    // Note: Address records cannot be fetched individually. Use getCustomer() to retrieve
    // the collection of address records for a specified customer.

    /**
     * Creates a new address record within a customer record.
     * POST /api/vault/customer/{customer_id}/address
     */
    public CustomerAddressResponse createCustomerAddress(HttpURLConnection conn, CustomerAddressRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, CustomerAddressResponse.class);
    }

    /**
     * Updates an existing address within a customer record.
     * POST /api/vault/customer/{customer_id}/address/{address_id}
     */
    public CustomerAddressResponse updateCustomerAddress(HttpURLConnection conn, CustomerAddressRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, CustomerAddressResponse.class);
    }

    /**
     * Deletes the specified address within a customer record.
     * DELETE /api/vault/customer/{customer_id}/address/{address_id}
     */
    public CustomerAddressResponse deleteCustomerAddress(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "DELETE", null, apiKey);

        return om.readValue(resBody, CustomerAddressResponse.class);
    }

    // --------------------- Customer payment section. --------------------------
    // Note: Payment method records cannot be fetched individually. Use getCustomer() to retrieve
    // the collection of payment method records for a specified customer.

    /**
     * Determines the payment type from the request payload and returns the appropriate ConnectionType.
     * The payload is inspected to determine if it's a card, ACH, token, Apple Pay, or Google Pay payment.
     */
    private ConnectionType determinePaymentType(Object reqBody) throws IOException {
        // Convert to JSON string to inspect structure
        String json = om.writeValueAsString(reqBody);
        com.fasterxml.jackson.databind.JsonNode node = om.readTree(json);

        // Check for Apple Pay
        if (node.has("apple_pay") || node.has("key_id") || node.has("temporary_token") || node.has("pkpaymenttoken")) {
            return ConnectionType.CUSTOMERAPPLEPAY;
        }

        // Check for Google Pay
        if (node.has("google_pay_token") || node.has("googlePayToken")) {
            return ConnectionType.CUSTOMERGOOGLEPAY;
        }

        // Check for token (simple string token or token field)
        if (node.has("token") && (node.get("token").isTextual() || node.get("token").isObject())) {
            return ConnectionType.CUSTOMERTOKEN;
        }

        // Check for ACH (has account_number and routing_number)
        if (node.has("account_number") || node.has("accountNumber") || 
            node.has("routing_number") || node.has("routingNumber") ||
            node.has("account_type") || node.has("accountType") ||
            node.has("sec_code") || node.has("secCode")) {
            return ConnectionType.CUSTOMERACH;
        }

        // Check for card (has number and expiration_date, or card_number and expiration_date)
        if (node.has("number") || node.has("card_number") || node.has("cardNumber") ||
            node.has("expiration_date") || node.has("expirationDate")) {
            return ConnectionType.CUSTOMERCARD;
        }

        // Default to card if structure is unclear (backward compatibility)
        return ConnectionType.CUSTOMERCARD;
    }

    /**
     * Creates a new stored payment method on the specified customer record.
     * The endpoint is determined automatically based on the payload structure:
     * - Card: POST /api/vault/customer/{customer_id}/card (has number/expiration_date)
     * - ACH: POST /api/vault/customer/{customer_id}/ach (has account_number/routing_number)
     * - Token: POST /api/vault/customer/{customer_id}/token (has token field)
     * - Apple Pay: POST /api/vault/customer/{customer_id}/applepay (has apple_pay fields)
     * - Google Pay: POST /api/vault/customer/{customer_id}/googlepay (has google_pay_token)
     */
    public CustomerPaymentResponse createCustomerPayment(HttpURLConnection conn, Object reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, CustomerPaymentResponse.class);
    }

    /**
     * Updates an existing payment method within a customer record.
     * The endpoint is determined automatically based on the payload structure and payment method ID.
     * - Card: POST /api/vault/customer/{customer_id}/card/{payment_method_id}
     * - ACH: POST /api/vault/customer/{customer_id}/ach/{payment_method_id}
     * - Token: POST /api/vault/customer/{customer_id}/token/{payment_method_id}
     */
    public CustomerPaymentResponse updateCustomerPayment(HttpURLConnection conn, Object reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, CustomerPaymentResponse.class);
    }

    /**
     * Deletes the specified payment method within a customer record.
     * The endpoint is determined by the connection type set on the connection:
     * - Card: DELETE /api/vault/customer/{customer_id}/card/{card_id}
     * - ACH: DELETE /api/vault/customer/{customer_id}/ach/{ach_id}
     */
    public CustomerPaymentResponse deleteCustomerPayment(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "DELETE", null, apiKey);

        return om.readValue(resBody, CustomerPaymentResponse.class);
    }

    // Helper method to get ConnectionType for payment creation
    public ConnectionType getPaymentConnectionType(Object reqBody) throws IOException {
        return determinePaymentType(reqBody);
    }
}
