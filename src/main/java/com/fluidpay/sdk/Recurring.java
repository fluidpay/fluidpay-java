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

    // --------------------- Add-On section. --------------------------

    /**
     * Create a new recurring plan add-on.
     * POST /api/recurring/addon
     */
    public RecurrenceResponse createAddOn(HttpURLConnection conn, RecurrenceRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, RecurrenceResponse.class);
    }

    /**
     * Retrieve details for the specified add-on.
     * GET /api/recurring/addon/{add-on_id}
     */
    public RecurrencesResponse getAddOn(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "GET", null, apiKey);

        return om.readValue(resBody, RecurrencesResponse.class);
    }

    /**
     * Retrieve details for all add-ons associated with the gateway account.
     * GET /api/recurring/addons
     */
    public RecurrencesResponse getAddOns(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "GET", null, apiKey);

        return om.readValue(resBody, RecurrencesResponse.class);
    }

    /**
     * Edit details for the specified add-on.
     * POST /api/recurring/addon/{add-on_id}
     */
    public RecurrenceResponse updateAddOn(HttpURLConnection conn, RecurrenceRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, RecurrenceResponse.class);
    }

    /**
     * Delete the specified add-on.
     * DELETE /api/recurring/addon/{add-on_id}
     */
    public RecurrenceResponse deleteAddOn(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "DELETE", null, apiKey);

        return om.readValue(resBody, RecurrenceResponse.class);
    }

    // --------------------- Discount section. --------------------------

    /**
     * Create a new recurring plan discount.
     * POST /api/recurring/discount
     */
    public RecurrenceResponse createDiscount(HttpURLConnection conn, RecurrenceRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, RecurrenceResponse.class);
    }

    /**
     * Retrieve details for the specified discount.
     * GET /api/recurring/discount/{discount_id}
     */
    public RecurrencesResponse getDiscount(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "GET", null, apiKey);

        return om.readValue(resBody, RecurrencesResponse.class);
    }

    /**
     * Retrieve the properties of all discounts for the gateway account.
     * GET /api/recurring/discounts
     */
    public RecurrencesResponse getDiscounts(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "GET", null, apiKey);

        return om.readValue(resBody, RecurrencesResponse.class);
    }

    /**
     * Edit details for the specified discount.
     * POST /api/recurring/discount/{discount_id}
     */
    public RecurrenceResponse updateDiscount(HttpURLConnection conn, RecurrenceRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, RecurrenceResponse.class);
    }

    /**
     * Delete the specified discount.
     * DELETE /api/recurring/discount/{discount_id}
     */
    public RecurrenceResponse deleteDiscount(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "DELETE", null, apiKey);

        return om.readValue(resBody, RecurrenceResponse.class);
    }

    // --------------------- Plan section. --------------------------

    /**
     * Creates a new recurring plan with discounts and/or add-ons.
     * POST /api/recurring/plan
     */
    public PlanResponse createPlan(HttpURLConnection conn, PlanRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, PlanResponse.class);
    }

    /**
     * Retrieve details for the specified plan.
     * GET /api/recurring/plan/{plan_id}
     */
    public PlansResponse getPlan(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "GET", null, apiKey);

        return om.readValue(resBody, PlansResponse.class);
    }

    /**
     * Retrieve the properties of all plans for the gateway account.
     * GET /api/recurring/plans
     */
    public PlansResponse getPlans(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "GET", null, apiKey);

        return om.readValue(resBody, PlansResponse.class);
    }

    /**
     * Edit details for the specified plan.
     * POST /api/recurring/plan/{plan_id}
     */
    public PlanResponse updatePlan(HttpURLConnection conn, PlanRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, PlanResponse.class);
    }

    /**
     * Delete the specified plan.
     * DELETE /api/recurring/plan/{plan_id}
     */
    public PlanResponse deletePlan(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "DELETE", null, apiKey);

        return om.readValue(resBody, PlanResponse.class);
    }

    // --------------------- Subscription section. --------------------------

    /**
     * Creates a new subscription which applies a recurring billing plan to a customer.
     * POST /api/recurring/subscription
     */
    public SubscriptionResponse createSubscription(HttpURLConnection conn, SubscriptionRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, SubscriptionResponse.class);
    }

    /**
     * Retrieve details for the specified subscription.
     * GET /api/recurring/subscription/{subscription_id}
     */
    public SubscriptionResponse getSubscription(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "GET", null, apiKey);

        return om.readValue(resBody, SubscriptionResponse.class);
    }

    /**
     * Retrieve details for all subscriptions that match provided search criteria.
     * POST /api/recurring/subscription/search
     */
    public SubscriptionsResponse searchSubscriptions(HttpURLConnection conn, Object reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, SubscriptionsResponse.class);
    }

    /**
     * Edit details for the specified subscription.
     * POST /api/recurring/subscription/{subscription_id}
     */
    public SubscriptionResponse updateSubscription(HttpURLConnection conn, SubscriptionRequest reqBody, String apiKey) throws IOException {
        byte[] body = om.writeValueAsBytes(reqBody);

        String resBody = util.doRequest(conn, "POST", body, apiKey);

        return om.readValue(resBody, SubscriptionResponse.class);
    }

    /**
     * Pause the specified subscription.
     * GET /api/recurring/subscription/{subscription_id}/status/paused
     */
    public SubscriptionResponse pauseSubscription(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "GET", null, apiKey);

        return om.readValue(resBody, SubscriptionResponse.class);
    }

    /**
     * Mark the specified subscription as past due.
     * GET /api/recurring/subscription/{subscription_id}/status/past_due
     */
    public SubscriptionResponse markSubscriptionPastDue(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "GET", null, apiKey);

        return om.readValue(resBody, SubscriptionResponse.class);
    }

    /**
     * Cancel the specified subscription.
     * GET /api/recurring/subscription/{subscription_id}/status/cancelled
     */
    public SubscriptionResponse cancelSubscription(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "GET", null, apiKey);

        return om.readValue(resBody, SubscriptionResponse.class);
    }

    /**
     * Activate the specified subscription.
     * GET /api/recurring/subscription/{subscription_id}/status/active
     */
    public SubscriptionResponse activateSubscription(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "GET", null, apiKey);

        return om.readValue(resBody, SubscriptionResponse.class);
    }

    /**
     * Complete the specified subscription.
     * GET /api/recurring/subscription/{subscription_id}/status/completed
     */
    public SubscriptionResponse completeSubscription(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "GET", null, apiKey);

        return om.readValue(resBody, SubscriptionResponse.class);
    }

    /**
     * Delete the specified subscription.
     * DELETE /api/recurring/subscription/{subscription_id}
     */
    public SubscriptionResponse deleteSubscription(HttpURLConnection conn, String apiKey) throws IOException {
        String resBody = util.doRequest(conn, "DELETE", null, apiKey);

        return om.readValue(resBody, SubscriptionResponse.class);
    }
}
