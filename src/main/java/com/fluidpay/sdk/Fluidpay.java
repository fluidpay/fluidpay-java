package com.fluidpay.sdk;

import com.fluidpay.sdk.models.apikey.KeyRequest;
import com.fluidpay.sdk.models.apikey.KeyResponse;
import com.fluidpay.sdk.models.apikey.KeysResponse;
import com.fluidpay.sdk.models.authentication.*;
import com.fluidpay.sdk.models.customers.*;
import com.fluidpay.sdk.models.recurring.*;
import com.fluidpay.sdk.models.terminals.TerminalsResponse;
import com.fluidpay.sdk.models.transactions.*;
import com.fluidpay.sdk.models.users.*;

import java.io.IOException;
import java.net.HttpURLConnection;

public class Fluidpay {
    private String apiKey;
    public HttpURLConnection connection;

    public Fluidpay(String apiKey) {
        this.apiKey = apiKey;
    }

    public Fluidpay(HttpURLConnection connection, String apiKey) {
        this.apiKey = apiKey;
        this.connection = connection;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    private ApiKey ak = new ApiKey();
    private Customers cu = new Customers();
    private Recurring re = new Recurring();
    private Terminals te = new Terminals();
    private Transactions tr = new Transactions();
    private Users us = new Users();

    // API key section

    /**
     * creates a new API key
     */
    public KeyResponse createKey(KeyRequest reqBody) throws IOException {
        return ak.createKey(connection, reqBody, apiKey);
    }

    /**
     * get all the API keys to a user
     */
    public KeysResponse getKeys() throws IOException {
        return ak.getKeys(connection, apiKey);
    }

    /**
     * deletes the API key identified by the ID (apiKeyId)
     */
    public KeyResponse deleteKey() throws IOException {
        return ak.deleteKey(connection, apiKey);
    }

    // Customers section

    /**
     * creates a new customer token
     */
    public CustomerResponse createCustomer(CreateCustomerRequest reqBody) throws IOException {
        return cu.createCustomer(connection, reqBody, apiKey);
    }

    /**
     * returns a specific customer identified by the ID (customerId)
     */
    public CustomerResponse getCustomer() throws IOException {
        return cu.getCustomer(connection, apiKey);
    }

    /**
     * updates a specific customer identified by the ID (customerId)
     */
    public CustomerResponse updateCustomer(UpdateCustomerRequest reqBody) throws IOException {
        return cu.updateCustomer(connection, reqBody, apiKey);
    }

    /**
     * deletes a specific customer identified by the ID (customerId)
     */
    public CustomerResponse deleteCustomer() throws IOException {
        return cu.deleteCustomer(connection, apiKey);
    }

    /**
     * searches for customers matching the provided criteria
     */
    public CustomersResponse searchCustomers(CustomerSearchRequest reqBody) throws IOException {
        return cu.searchCustomers(connection, reqBody, apiKey);
    }

    /**
     * Creates a new address record within a customer record.
     * POST /api/vault/customer/{customer_id}/address
     * Note: Address records cannot be fetched individually. Use getCustomer() to retrieve
     * the collection of address records for a specified customer.
     */
    public CustomerAddressResponse createCustomerAddress(CustomerAddressRequest reqBody) throws IOException {
        return cu.createCustomerAddress(connection, reqBody, apiKey);
    }

    /**
     * Updates an existing address within a customer record.
     * POST /api/vault/customer/{customer_id}/address/{address_id}
     */
    public CustomerAddressResponse updateCustomerAddress(CustomerAddressRequest reqBody) throws IOException {
        return cu.updateCustomerAddress(connection, reqBody, apiKey);
    }

    /**
     * Deletes the specified address within a customer record.
     * DELETE /api/vault/customer/{customer_id}/address/{address_id}
     */
    public CustomerAddressResponse deleteCustomerAddress() throws IOException {
        return cu.deleteCustomerAddress(connection, apiKey);
    }

    // Payment methods
    /**
     * Creates a new stored payment method on the specified customer record.
     * The endpoint is determined automatically based on the payload structure:
     * - Card: POST /api/vault/customer/{customer_id}/card (has number/expiration_date)
     * - ACH: POST /api/vault/customer/{customer_id}/ach (has account_number/routing_number)
     * - Token: POST /api/vault/customer/{customer_id}/token (has token field)
     * - Apple Pay: POST /api/vault/customer/{customer_id}/applepay (has apple_pay fields)
     * - Google Pay: POST /api/vault/customer/{customer_id}/googlepay (has google_pay_token)
     * 
     * Note: Payment method records cannot be fetched individually. Use getCustomer() to retrieve
     * the collection of payment method records for a specified customer.
     * 
     * Note: The connection must be set up by the caller before calling this method.
     * Use getPaymentConnectionType() to determine the correct ConnectionType for the payload.
     * 
     * @param reqBody The payment request payload. Can be CustomerPaymentRequest (card), ACH object, token object, Apple Pay object, or Google Pay object.
     * @return CustomerPaymentResponse containing the created payment method details
     * @throws IOException if the request fails
     */
    public CustomerPaymentResponse createCustomerPayment(Object reqBody) throws IOException {
        return cu.createCustomerPayment(connection, reqBody, apiKey);
    }

    /**
     * Updates an existing payment method within a customer record.
     * The endpoint is determined automatically based on the payload structure and payment method ID.
     * - Card: POST /api/vault/customer/{customer_id}/card/{payment_method_id}
     * - ACH: POST /api/vault/customer/{customer_id}/ach/{payment_method_id}
     * - Token: POST /api/vault/customer/{customer_id}/token/{payment_method_id}
     * 
     * @param reqBody The payment update request payload
     * @return CustomerPaymentResponse containing the updated payment method details
     * @throws IOException if the request fails
     */
    public CustomerPaymentResponse updateCustomerPayment(Object reqBody) throws IOException {
        return cu.updateCustomerPayment(connection, reqBody, apiKey);
    }

    /**
     * Deletes the specified payment method within a customer record.
     * The endpoint is determined by the connection type set on the connection:
     * - Card: DELETE /api/vault/customer/{customer_id}/card/{card_id}
     * - ACH: DELETE /api/vault/customer/{customer_id}/ach/{ach_id}
     * 
     * @return CustomerPaymentResponse confirming deletion
     * @throws IOException if the request fails
     */
    public CustomerPaymentResponse deleteCustomerPayment() throws IOException {
        return cu.deleteCustomerPayment(connection, apiKey);
    }

    /**
     * Helper method to determine the ConnectionType needed for a payment payload.
     * Use this to set up the connection before calling createCustomerPayment.
     * 
     * @param reqBody The payment request payload
     * @return ConnectionType that should be used for the connection
     * @throws IOException if payload cannot be parsed
     */
    public ConnectionType getPaymentConnectionType(Object reqBody) throws IOException {
        return cu.getPaymentConnectionType(reqBody);
    }

    // Recurring section

    /**
     * creates a new add on
     */
    public RecurrenceResponse createAddOn(RecurrenceRequest reqBody) throws IOException {
        return re.createAddOn(connection, reqBody, apiKey);
    }

    /**
     * gets the add on identified by the ID (addOnId)
     */
    public RecurrencesResponse getAddOn() throws IOException {
        return re.getAddOn(connection, apiKey);
    }

    /**
     * gets all add ons
     */
    public RecurrencesResponse getAddOns() throws IOException {
        return re.getAddOns(connection, apiKey);
    }

    /**
     * updates the add on identified by the ID (addOnId)
     */
    public RecurrenceResponse updateAddOn(RecurrenceRequest reqBody) throws IOException {
        return re.updateAddOn(connection, reqBody, apiKey);
    }

    /**
     * deletes the add on identified by the ID (addOnId)
     */
    public RecurrenceResponse deleteAddOn() throws IOException {
        return re.deleteAddOn(connection, apiKey);
    }

    /**
     * creates a new discount
     */
    public RecurrenceResponse createDiscount(RecurrenceRequest reqBody) throws IOException {
        return re.createDiscount(connection, reqBody, apiKey);
    }

    /**
     * gets the discount identified by the ID (discountId)
     */
    public RecurrencesResponse getDiscount() throws IOException {
        return re.getDiscount(connection, apiKey);
    }

    /**
     * gets all discounts
     */
    public RecurrencesResponse getDiscounts() throws IOException {
        return re.getDiscounts(connection, apiKey);
    }

    /**
     * updates the discount identified by the ID (discountId)
     */
    public RecurrenceResponse updateDiscount(RecurrenceRequest reqBody) throws IOException {
        return re.updateDiscount(connection, reqBody, apiKey);
    }

    /**
     * deletes the discount identified by the ID (discountId)
     */
    public RecurrenceResponse deleteDiscount() throws IOException {
        return re.deleteDiscount(connection, apiKey);
    }

    /**
     * creates a new plan
     */
    public PlanResponse createPlan(PlanRequest reqBody) throws IOException {
        return re.createPlan(connection, reqBody, apiKey);
    }

    /**
     * gets the plan identified by the ID (planId)
     */
    public PlansResponse getPlan() throws IOException {
        return re.getPlan(connection, apiKey);
    }

    /**
     * gets all plans
     */
    public PlansResponse getPlans() throws IOException {
        return re.getPlans(connection, apiKey);
    }

    /**
     * updates the plan identified by the ID (planId)
     */
    public PlanResponse updatePlan(PlanRequest reqBody) throws IOException {
        return re.updatePlan(connection, reqBody, apiKey);
    }

    /**
     * deletes the plan identified by the ID (planId)
     */
    public PlanResponse deletePlan() throws IOException {
        return re.deletePlan(connection, apiKey);
    }

    /**
     * Creates a new subscription which applies a recurring billing plan to a customer.
     * POST /api/recurring/subscription
     */
    public SubscriptionResponse createSubscription(SubscriptionRequest reqBody) throws IOException {
        return re.createSubscription(connection, reqBody, apiKey);
    }

    /**
     * Retrieve details for the specified subscription.
     * GET /api/recurring/subscription/{subscription_id}
     */
    public SubscriptionResponse getSubscription() throws IOException {
        return re.getSubscription(connection, apiKey);
    }

    /**
     * Retrieve details for all subscriptions that match provided search criteria.
     * POST /api/recurring/subscription/search
     */
    public SubscriptionsResponse searchSubscriptions(Object reqBody) throws IOException {
        return re.searchSubscriptions(connection, reqBody, apiKey);
    }

    /**
     * Edit details for the specified subscription.
     * POST /api/recurring/subscription/{subscription_id}
     */
    public SubscriptionResponse updateSubscription(SubscriptionRequest reqBody) throws IOException {
        return re.updateSubscription(connection, reqBody, apiKey);
    }

    /**
     * Pause the specified subscription.
     * GET /api/recurring/subscription/{subscription_id}/status/paused
     */
    public SubscriptionResponse pauseSubscription() throws IOException {
        return re.pauseSubscription(connection, apiKey);
    }

    /**
     * Mark the specified subscription as past due.
     * GET /api/recurring/subscription/{subscription_id}/status/past_due
     */
    public SubscriptionResponse markSubscriptionPastDue() throws IOException {
        return re.markSubscriptionPastDue(connection, apiKey);
    }

    /**
     * Cancel the specified subscription.
     * GET /api/recurring/subscription/{subscription_id}/status/cancelled
     */
    public SubscriptionResponse cancelSubscription() throws IOException {
        return re.cancelSubscription(connection, apiKey);
    }

    /**
     * Activate the specified subscription.
     * GET /api/recurring/subscription/{subscription_id}/status/active
     */
    public SubscriptionResponse activateSubscription() throws IOException {
        return re.activateSubscription(connection, apiKey);
    }

    /**
     * Complete the specified subscription.
     * GET /api/recurring/subscription/{subscription_id}/status/completed
     */
    public SubscriptionResponse completeSubscription() throws IOException {
        return re.completeSubscription(connection, apiKey);
    }

    /**
     * Delete the specified subscription.
     * DELETE /api/recurring/subscription/{subscription_id}
     */
    public SubscriptionResponse deleteSubscription() throws IOException {
        return re.deleteSubscription(connection, apiKey);
    }

    // Terminals section

    /**
     * gets all the terminals
     */
    public TerminalsResponse getTerminals() throws IOException {
        return te.getTerminals(connection, apiKey);
    }

    // Transaction section

    /**
     * handles one transaction process
     */
    public TerminalResponse doTransaction(TransactionRequest reqBody) throws IOException{
        return tr.doTransaction(connection, reqBody, apiKey);
    }

    /**
     * gets the status of a transaction identified by ID (transactionId)
     */
    public TransactionSearchResponse getTransactionStatus() throws IOException {
        return tr.getTransactionStatus(connection, apiKey);
    }

    /**
     * gets transaction identified by the values in the request body
     */
    public TransactionSearchResponse queryTransactions(TransactionQueryRequest reqBody) throws IOException {
        return tr.queryTransactions(connection, reqBody, apiKey);
    }

    /**
     * captures an already authorized transaction identified by ID (transactionId)
     */
    public TransactionResponse captureTransaction(TransactionCaptureRequest reqBody) throws IOException {
        return tr.captureTransaction(connection, reqBody, apiKey);
    }

    /**
     * voids a transaction with pending settlement identified by ID (transactionId)
     */
    public TransactionResponse voidTransaction() throws IOException {
        return tr.voidTransaction(connection, apiKey);
    }

    /**
     * refunds a previously settled amount
     */
    public TransactionResponse refundTransaction(TransactionRefundRequest reqBody) throws IOException {
        return tr.refundTransaction(connection, reqBody, apiKey);
    }

    // Users section

    /**
     * changes your password to the one given in the request body
     */
    public UserResponse changePassword(ChangePasswordRequest reqBody) throws IOException {
        return us.changePassword(connection, reqBody, apiKey);
    }

    /**
     * creates a new user
     */
    public UserResponse createUser(CreateUserRequest reqBody) throws IOException {
        return us.createUser(connection, reqBody, apiKey);
    }

    /**
     * gets the current user
     */
    public UserResponse currentUser() throws IOException {
        return us.currentUser(connection, apiKey);
    }

    /**
     * gets the user identified by the ID (userId)
     */
    public UserResponse getUser() throws IOException {
        return us.getUser(connection, apiKey);
    }

    /**
     * gets all users
     */
    public UsersResponse getUsers() throws IOException {
        return us.getUsers(connection, apiKey);
    }

    /**
     * updates the user identified by the ID (userId)
     */
    public UserResponse updateUser(UpdateUserRequest reqBody) throws IOException {
        return us.updateUser(connection, reqBody, apiKey);
    }

    /**
     * deletes the user identified by the ID (userId)
     */
    public GeneralResponse deleteUser() throws IOException {
        return us.deleteUser(connection, apiKey);
    }
}
