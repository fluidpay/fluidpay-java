# fluidpay-java
This is the official SDK for the Fluid Pay API written in the Java programming language.

## Getting started
Import the SDK from the [Maven Repository](link needs to be inserted).

## General Information
HttpURLConnection should be initialized through `Connection.init()` using the proper `ConnectionType` (e.g., `CUSTOMER` for the `/api/vault/customer` endpoint and `CUSTOMERID` for `/api/vault/customer/{customer_id}`) and a map containing the proper path variables (e.g., `customerId`, `paymentTokenId`, or `addressTokenId`).

**Note:** This SDK uses API key authentication only. JWT authentication is not supported.
```
import com.fluidpay.sdk.*;

public class Example {
    Fluidpay fp = new Fluidpay("yourAPIKey");
    
    CreateUserRequest creUsrReq = new CreateUserRequest(
        "testmerchant1124",
        "test merchant user",
        "6305555555",
        "info@website.com",
        "CET",
        "T@est12345678",
        "active",
        "admin"
    );
    
    // Map to contain the different IDs.
    HashMap<String, String> pathVariables = new HashMap<>();
    
    // The HttpURLConnection can be customized before use.
    Connection c = new Connection();
    
    // The ConnectionType Enum contains the different paths.
    // Parameters: ConnectionType, pathVariables map, sandbox (false), localDev (true for localhost)
    fp.connection = c.init(ConnectionType.USER, pathVariables, false, true);
    
    UserResponse creUsrRes = fp.createUser(creUsrReq);
}

```
## Function List
```
import com.fluidpay.sdk.*;

public class FunctionList {
    Fluidpay fp = new Fluidpay("yourAPIKey");
    Connection c = new Connection();
    HashMap<String, String> id = new HashMap<>();
    
    // API key section
    
    fp.connection = c.init(ConnectionType.CREATEKEY, id, false, true);
    fp.createKey(KeyRequest reqBody) // creates a new API key

    fp.connection = c.init(ConnectionType.GETKEYS, id, false, true);
    fp.getKeys() // returns all keys for the current user

    id.put("apiKeyId", "yourAPIKeyId");
    fp.connection = c.init(ConnectionType.DELETEKEY, id, false, true);
    fp.deleteKey() // deletes the API key

    // Customer section
    // POST /api/vault/customer

    fp.connection = c.init(ConnectionType.CUSTOMER, id, false, true);
    fp.createCustomer(CreateCustomerRequest reqBody) // creates a new customer record
    
    id.put("customerId", "yourCustomerId");
    fp.connection = c.init(ConnectionType.CUSTOMERID, id, false, true);
    fp.getCustomer() // returns the customer record

    id.put("customerId", "yourCustomerId");
    fp.connection = c.init(ConnectionType.CUSTOMERUPDATE, id, false, true);
    fp.updateCustomer(UpdateCustomerRequest reqBody) // updates the customer record
    
    id.put("customerId", "yourCustomerId");
    fp.connection = c.init(ConnectionType.CUSTOMERID, id, false, true);
    fp.deleteCustomer() // deletes the customer record
    
    // Search customers
    fp.connection = c.init(ConnectionType.CUSTOMERSEARCH, id, false, true);
    fp.searchCustomers(CustomerSearchRequest reqBody) // searches for customers matching criteria
    
    // Address operations
    // POST /api/vault/customer/{customer_id}/address
    
    id.put("customerId", "yourCustomerId");
    fp.connection = c.init(ConnectionType.CUSTOMERADDRESS, id, false, true);
    fp.createCustomerAddress(CustomerAddressRequest reqBody) // creates a new address record
    
    id.put("customerId", "yourCustomerId");
    id.put("addressTokenId", "yourAddressTokenId");
    fp.connection = c.init(ConnectionType.CUSTOMERADDRESSID, id, false, true);
    fp.updateCustomerAddress(CustomerAddressRequest reqBody) // updates the address record
    
    id.put("customerId", "yourCustomerId");
    id.put("addressTokenId", "yourAddressTokenId");
    fp.connection = c.init(ConnectionType.CUSTOMERADDRESSID, id, false, true);
    fp.deleteCustomerAddress() // deletes the address record
    
    // Note: Address records cannot be fetched individually. Use getCustomer() to retrieve all addresses.
    
    // Payment method operations
    // Unified payment method creation - endpoint determined by payload type
    
    id.put("customerId", "yourCustomerId");
    // Determine connection type based on payload
    ConnectionType paymentType = fp.getPaymentConnectionType(paymentRequest);
    fp.connection = c.init(paymentType, id, false, true);
    fp.createCustomerPayment(Object reqBody) // creates a new payment method (card, ACH, token, Apple Pay, or Google Pay)
    
    id.put("customerId", "yourCustomerId");
    // For update/delete, set connection type based on payment method type
    fp.connection = c.init(ConnectionType.CUSTOMERCARDID, id, false, true); // or CUSTOMERACHID, CUSTOMERTOKENID
    fp.updateCustomerPayment(Object reqBody) // updates the payment method
    
    id.put("customerId", "yourCustomerId");
    id.put("paymentTokenId", "yourPaymentTokenId");
    fp.connection = c.init(ConnectionType.CUSTOMERCARDID, id, false, true); // or CUSTOMERACHID, CUSTOMERTOKENID
    fp.deleteCustomerPayment() // deletes the payment method
    
    // Note: Payment method records cannot be fetched individually. Use getCustomer() to retrieve all payment methods.
    
    // Recurring section
    
    // Add-Ons
    fp.connection = c.init(ConnectionType.ADDON, id, false, true);
    fp.createAddOn(RecurrenceRequest reqBody) // creates a new add on
    
    id.put("addOnId", "yourAddOnId");
    fp.connection = c.init(ConnectionType.ADDONID, id, false, true);
    fp.getAddOn() // returns the add on
    
    fp.connection = c.init(ConnectionType.ADDONS, id, false, true);
    fp.getAddOns() // returns all add ons
    
    id.put("addOnId", "yourAddOnId");
    fp.connection = c.init(ConnectionType.ADDONID, id, false, true);
    fp.updateAddOn(RecurrenceRequest reqBody) // updates the add on
    
    id.put("addOnId", "yourAddOnId");
    fp.connection = c.init(ConnectionType.ADDONID, id, false, true);
    fp.deleteAddOn() // deletes the add on
    
    // Discounts
    fp.connection = c.init(ConnectionType.DISCOUNT, id, false, true);
    fp.createDiscount(RecurrenceRequest reqBody) // creates a new discount
    
    id.put("discountId", "yourDiscountId");
    fp.connection = c.init(ConnectionType.DISCOUNTID, id, false, true);
    fp.getDiscount() // returns the discount
    
    fp.connection = c.init(ConnectionType.DISCOUNTS, id, false, true);
    fp.getDiscounts() // returns all discounts
    
    id.put("discountId", "yourDiscountId");
    fp.connection = c.init(ConnectionType.DISCOUNTID, id, false, true);
    fp.updateDiscount(RecurrenceRequest reqBody) // updates the discount
    
    id.put("discountId", "yourDiscountId");
    fp.connection = c.init(ConnectionType.DISCOUNTID, id, false, true);
    fp.deleteDiscount() // deletes the discount
    
    // Plans
    fp.connection = c.init(ConnectionType.PLAN, id, false, true);
    fp.createPlan(PlanRequest reqBody) // creates a new plan
    
    id.put("planId", "yourPlanId");
    fp.connection = c.init(ConnectionType.PLANID, id, false, true);
    fp.getPlan() // returns the plan
    
    fp.connection = c.init(ConnectionType.PLANS, id, false, true);
    fp.getPlans() // returns all plans
    
    id.put("planId", "yourPlanId");
    fp.connection = c.init(ConnectionType.PLANID, id, false, true);
    fp.updatePlan(PlanRequest reqBody) // updates the plan
    
    id.put("planId", "yourPlanId");
    fp.connection = c.init(ConnectionType.PLANID, id, false, true);
    fp.deletePlan() // deletes the plan
    
    // Subscriptions
    fp.connection = c.init(ConnectionType.SUBSCRIPTION, id, false, true);
    fp.createSubscription(SubscriptionRequest reqBody) // creates a new subscription
    
    id.put("subscriptionId", "yourSubscriptionId");
    fp.connection = c.init(ConnectionType.SUBSCRIPTIONID, id, false, true);
    fp.getSubscription() // returns the subscription
    
    // Search subscriptions
    fp.connection = c.init(ConnectionType.SUBSCRIPTIONSEARCH, id, false, true);
    fp.searchSubscriptions(Object reqBody) // searches for subscriptions matching criteria
    
    id.put("subscriptionId", "yourSubscriptionId");
    fp.connection = c.init(ConnectionType.SUBSCRIPTIONID, id, false, true);
    fp.updateSubscription(SubscriptionRequest reqBody) // updates the subscription
    
    // Subscription status operations
    id.put("subscriptionId", "yourSubscriptionId");
    fp.connection = c.init(ConnectionType.SUBSCRIPTIONPAUSED, id, false, true);
    fp.pauseSubscription() // pauses the subscription
    
    id.put("subscriptionId", "yourSubscriptionId");
    fp.connection = c.init(ConnectionType.SUBSCRIPTIONPASTDUE, id, false, true);
    fp.markSubscriptionPastDue() // marks subscription as past due
    
    id.put("subscriptionId", "yourSubscriptionId");
    fp.connection = c.init(ConnectionType.SUBSCRIPTIONCANCELLED, id, false, true);
    fp.cancelSubscription() // cancels the subscription
    
    id.put("subscriptionId", "yourSubscriptionId");
    fp.connection = c.init(ConnectionType.SUBSCRIPTIONACTIVE, id, false, true);
    fp.activateSubscription() // activates the subscription
    
    id.put("subscriptionId", "yourSubscriptionId");
    fp.connection = c.init(ConnectionType.SUBSCRIPTIONCOMPLETED, id, false, true);
    fp.completeSubscription() // completes the subscription
    
    id.put("subscriptionId", "yourSubscriptionId");
    fp.connection = c.init(ConnectionType.SUBSCRIPTIONID, id, false, true);
    fp.deleteSubscription() // deletes the subscription
    
    // Terminals section
    
    fp.connection = c.init(ConnectionType.TERMINALS, id, false, true);
    fp.getTerminals() // returns all terminals
    
    // Transactions section
    // All transaction request models (CardTransactionRequest, AchTransactionRequest, 
    // CustomerTransactionRequest, TerminalTransactionRequest) support all fields 
    // documented in the Fluidpay API. See the request model classes for available fields.
    
    fp.connection = c.init(ConnectionType.TRANSACTION, id, false, true);
    fp.doTransaction(TransactionRequest reqBody) // processes a transaction (card, ACH, customer, terminal, etc.)
    
    id.put("transactionId", "yourTransactionId");
    fp.connection = c.init(ConnectionType.TRANSACTIONSTATUS, id, false, true);
    fp.getTransactionStatus() // returns the state of the transaction

    fp.connection = c.init(ConnectionType.TRANSACTIONQUERY, id, false, true);
    fp.queryTransactions(TransactionQueryRequest reqBody) // searches for transactions matching criteria
    
    id.put("transactionId", "yourTransactionId");
    fp.connection = c.init(ConnectionType.TRANSACTIONCAPTURE, id, false, true);
    fp.captureTransaction(TransactionCaptureRequest reqBody) // captures an authorized transaction
    
    id.put("transactionId", "yourTransactionId");
    fp.connection = c.init(ConnectionType.TRANSACTIONVOID, id, false, true);
    fp.voidTransaction() // voids a transaction pending settlement
    
    id.put("transactionId", "yourTransactionId");
    fp.connection = c.init(ConnectionType.TRANSACTIONREFUND, id, false, true);
    fp.refundTransaction(TransactionRefundRequest reqBody) // refunds a settled transaction
    
    // Users section
    
    fp.connection = c.init(ConnectionType.CHANGEPASSWORD, id, false, true);
    fp.changePassword(ChangePasswordRequest reqBody) // changes the password
    
    fp.connection = c.init(ConnectionType.USER, id, false, true);
    fp.createUser(CreateUserRequest reqBody) // creates a new user
    
    fp.connection = c.init(ConnectionType.USER, id, false, true);
    fp.currentUser() // returns the currently active user
    
    id.put("userId", "yourUserId");
    fp.connection = c.init(ConnectionType.USERID, id, false, true);
    fp.getUser() // returns the user
    
    fp.connection = c.init(ConnectionType.USERS, id, false, true);
    fp.getUsers() // returns all users
    
    id.put("userId", "yourUserId");
    fp.connection = c.init(ConnectionType.USERID, id, false, true);
    fp.updateUser(UpdateUserRequest reqBody) // updates the user
    
    id.put("userId", "yourUserId");
    fp.connection = c.init(ConnectionType.USERID, id, false, true);
    fp.deleteUser() // deletes the user
}
```

## Documentation
Further information can be found on the [Fluid Pay website](https://sandbox.fluidpay.com/docs).