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

    public CustomerResponse createCustomer(HttpURLConnection conn, CreateCustomerRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, CustomerResponse.class);
    }

    public CustomerResponse getCustomer(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "GET", null, apiKey);

        return om.readValue(resBody, CustomerResponse.class);
    }

    public CustomerResponse updateCustomer(HttpURLConnection conn, UpdateCustomerRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, CustomerResponse.class);
    }

    public CustomerResponse deleteCustomer(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "DELETE", null, apiKey);

        return om.readValue(resBody, CustomerResponse.class);
    }

    // --------------------- Customer address section. --------------------------

    public CustomerAddressResponse createCustomerAddress(HttpURLConnection conn, CustomerAddressRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, CustomerAddressResponse.class);
    }

    public CustomerAddressesResponse getCustomerAddresses(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "GET", null, apiKey);

        return om.readValue(resBody, CustomerAddressesResponse.class);
    }

    public CustomerAddressesResponse getCustomerAddress(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "GET", null, apiKey);

        return om.readValue(resBody, CustomerAddressesResponse.class);
    }

    public CustomerAddressResponse updateCustomerAddress(HttpURLConnection conn, CustomerAddressRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, CustomerAddressResponse.class);
    }

    public CustomerAddressResponse deleteCustomerAddress(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "DELETE", null, apiKey);

        return om.readValue(resBody, CustomerAddressResponse.class);
    }

    // --------------------- Customer payment section. --------------------------

    public CustomerPaymentResponse createCustomerPayment(HttpURLConnection conn, CustomerPaymentRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, CustomerPaymentResponse.class);
    }

    public CustomerPaymentsResponse getCustomerPayments(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "GET", null, apiKey);

        return om.readValue(resBody, CustomerPaymentsResponse.class);
    }

    public CustomerPaymentsResponse getCustomerPayment(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "GET", null, apiKey);

        return om.readValue(resBody, CustomerPaymentsResponse.class);
    }

    public CustomerPaymentResponse updateCustomerPayment(HttpURLConnection conn, CustomerPaymentRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, CustomerPaymentResponse.class);
    }

    public CustomerPaymentResponse deleteCustomerPayment(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "DELETE", null, apiKey);

        return om.readValue(resBody, CustomerPaymentResponse.class);
    }
}
