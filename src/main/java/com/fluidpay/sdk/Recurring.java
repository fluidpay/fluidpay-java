package com.fluidpay.sdk;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fluidpay.sdk.models.recurring.*;

import java.io.IOException;
import java.net.HttpURLConnection;

public class Recurring {
    private ObjectMapper om = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    private Utils util = new Utils();

    // --------------------- Add on section. --------------------------

    public RecurrenceResponse createAddOn(HttpURLConnection conn, RecurrenceRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, RecurrenceResponse.class);
    }

    public RecurrencesResponse getAddOn(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "GET", null, apiKey);

        return om.readValue(resBody, RecurrencesResponse.class);
    }

    public RecurrencesResponse getAddOns(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "GET", null, apiKey);

        return om.readValue(resBody, RecurrencesResponse.class);
    }

    public RecurrenceResponse updateAddOn(HttpURLConnection conn, RecurrenceRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, RecurrenceResponse.class);
    }

    public RecurrenceResponse deleteAddOn(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "DELETE", null, apiKey);

        return om.readValue(resBody, RecurrenceResponse.class);
    }

    // --------------------- Discount section. --------------------------

    public RecurrenceResponse createDiscount(HttpURLConnection conn, RecurrenceRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, RecurrenceResponse.class);
    }

    public RecurrencesResponse getDiscount(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "GET", null, apiKey);

        return om.readValue(resBody, RecurrencesResponse.class);
    }

    public RecurrencesResponse getDiscounts(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "GET", null, apiKey);

        return om.readValue(resBody, RecurrencesResponse.class);
    }

    public RecurrenceResponse updateDiscount(HttpURLConnection conn, RecurrenceRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, RecurrenceResponse.class);
    }

    public RecurrenceResponse deleteDiscount(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "DELETE", null, apiKey);

        return om.readValue(resBody, RecurrenceResponse.class);
    }

    // --------------------- Plan section. --------------------------

    public PlanResponse createPlan(HttpURLConnection conn, PlanRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, PlanResponse.class);
    }

    public PlansResponse getPlan(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "GET", null, apiKey);

        return om.readValue(resBody, PlansResponse.class);
    }

    public PlansResponse getPlans(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "GET", null, apiKey);

        return om.readValue(resBody, PlansResponse.class);
    }

    public PlanResponse updatePlan(HttpURLConnection conn, PlanRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, PlanResponse.class);
    }

    public PlanResponse deletePlan(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "DELETE", null, apiKey);

        return om.readValue(resBody, PlanResponse.class);
    }

    // --------------------- Subscription section. --------------------------

    public SubscriptionResponse createSubscription(HttpURLConnection conn, SubscriptionRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, SubscriptionResponse.class);
    }

    public SubscriptionsResponse getSubscription(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "GET", null, apiKey);

        return om.readValue(resBody, SubscriptionsResponse.class);
    }

    public SubscriptionResponse updateSubscription(HttpURLConnection conn, SubscriptionRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, SubscriptionResponse.class);
    }

    public SubscriptionResponse deleteSubscription(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "DELETE", null, apiKey);

        return om.readValue(resBody, SubscriptionResponse.class);
    }
}
