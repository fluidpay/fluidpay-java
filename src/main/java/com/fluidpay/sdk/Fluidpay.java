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
    private Authentication au = new Authentication();
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

    // Authentication section

    /**
     * obtains a new JWT token
     */
    public JWTTokenResponse obtainJWT(JWTTokenRequest reqBody) throws IOException {
        return au.obtainJWT(connection, reqBody, apiKey);
    }

    /**
     * requests a reminder e-mail for the username
     */
    public GeneralResponse forgottenUsername(ForgottenUsernameRequest reqBody) throws IOException {
        return au.forgottenUsername(connection, reqBody, apiKey);
    }

    /**
     * requests a reminder e-mail containing a reset code for the password
     */
    public GeneralResponse forgottenPassword(ForgottenPasswordRequest reqBody) throws IOException {
        return au.forgottenPassword(connection, reqBody, apiKey);
    }

    /**
     * resets your password to the one given in the request body
     */
    public GeneralResponse passwordReset(PasswordResetRequest reqBody) throws IOException {
        return au.passwordReset(connection, reqBody, apiKey);
    }

    /**
     * terminates a valid authentication token
     */
    public void tokenLogout() throws IOException {
        au.tokenLogout(connection, apiKey);
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
     * creates a new customer address token (customerId)
     */
    public CustomerAddressResponse createCustomerAddress(CustomerAddressRequest reqBody) throws IOException {
        return cu.createCustomerAddress(connection, reqBody, apiKey);
    }

    /**
     * returns an address token of a customer both identified by ID (customerId, addressTokenId)
     */
    public CustomerAddressesResponse getCustomerAddress() throws IOException {
        return cu.getCustomerAddress(connection, apiKey);
    }

    /**
     * returns all the address tokens of a customer identified by ID (customerId)
     */
    public CustomerAddressesResponse getCustomerAddresses() throws IOException {
        return cu.getCustomerAddresses(connection, apiKey);
    }

    /**
     * updates an address token of a customer both identified by ID (customerId, addressTokenId)
     */
    public CustomerAddressResponse updateCustomerAddress(CustomerAddressRequest reqBody) throws IOException {
        return cu.updateCustomerAddress(connection, reqBody, apiKey);
    }

    /**
     * deletes an address token of a customer both identified by the ID (customerId, addressTokenId)
     */
    public CustomerAddressResponse deleteCustomerAddress() throws IOException {
        return cu.deleteCustomerAddress(connection, apiKey);
    }

    /**
     * creates a new customer payment token (customerId)
     */
    public CustomerPaymentResponse createCustomerPayment(CustomerPaymentRequest reqBody) throws IOException {
        return cu.createCustomerPayment(connection, reqBody, apiKey);
    }

    /**
     * returns a payment token of a customer both identified by ID (customerId, paymentTokenId)
     */
    public CustomerPaymentsResponse getCustomerPayment() throws IOException {
        return cu.getCustomerPayment(connection, apiKey);
    }

    /**
     * returns all the payment tokens of a customer identified by ID (customerId)
     */
    public CustomerPaymentsResponse getCustomerPayments() throws IOException {
        return cu.getCustomerPayments(connection, apiKey);
    }

    /**
     * updates a payment token of a customer both identified by ID (customerId, paymentTokenId)
     */
    public CustomerPaymentResponse updateCustomerPayment(CustomerPaymentRequest reqBody) throws IOException {
        return cu.updateCustomerPayment(connection, reqBody, apiKey);
    }

    /**
     * deletes a payment token of a customer both identified by the ID (customerId, paymentTokenId)
     */
    public CustomerPaymentResponse deleteCustomerPayment() throws IOException {
        return cu.deleteCustomerPayment(connection, apiKey);
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
     * creates a new subscription
     */
    public SubscriptionResponse createSubscription(SubscriptionRequest reqBody) throws IOException {
        return re.createSubscription(connection, reqBody, apiKey);
    }

    /**
     * gets the subscription identified by the ID (subscriptionId)
     */
    public  SubscriptionsResponse getSubscription() throws IOException {
        return re.getSubscription(connection, apiKey);
    }

    /**
     * updates the subscription identified by the ID (subscriptionId)
     */
    public SubscriptionResponse updateSubscription(SubscriptionRequest reqBody) throws IOException {
        return re.updateSubscription(connection, reqBody, apiKey);
    }

    /**
     * deletes the subscription identified by the ID (subscriptionId)
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
