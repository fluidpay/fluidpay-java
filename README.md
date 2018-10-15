# fluidpay-java
This is the official SDK for the Fluid Pay API written in the JAVA programming language.

## Getting started
Import the SDK from the [Maven Repository](link needs to be inserted).

## General Information
HttpsURLConnection should be initialized through Connection.init() using the proper ConnectionType (E.g. USER for the api/user endpoint and USERID for api/usr/<user_id>) and a map containing the proper path variables (E.g. userId, paymentType or addressTokenId).
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
    
    // The HttpsURLConnection can be customized before use.
    Connection c = new Connection();
    
    // The ConnectionType Enum contains the different paths.
    fp.connection = c.init(ConnectionType.USER, pathVariables);
    
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
    
    fp.connection = c.init(ConnectionType.CREATEKEY, id);
    fp.createKey(KeyRequest reqBody) // creates a new api key

    fp.connection = c.init(ConnectionType.GETKEYS, id);
    fp.getKeys() // returns all keys for the current user

    id.put("apiKeyId", "yourAPIKeyId");
    fp.connection = c.init(ConnectionType.DELETEKEY, id);
    fp.deleteKey(HttpURLConnection conn, String apiKey) // deletes the key

    // Authentication section
    
    fp.connection = c.init(ConnectionType.OBTAINJWT, id);
    fp.obtainJWT(JWTTokenRequest reqBody) // returns a new JWT token

    fp.connection = c.init(ConnectionType.FORGOTTENUSERNAME, id);
    fp.forgottenUsername(ForgottenUsernameRequest reqBody) // sends an email with the username
    
    fp.connection = c.init(ConnectionType.FORGOTTENPASSWORD, id);
    fp.forgottenPassword(ForgottenPasswordRequest reqBody) // sends an email with the password

    fp.connection = c.init(ConnectionType.PASSWORDRESET, id);
    fp.passwordReset(PasswordResetRequest reqBody) // resets password

    fp.connection = c.init(ConnectionType.TOKENLOGOUT, id);
    fp.tokenLogout() // logs out the JWT token

    // Customer section

    fp.connection = c.init(ConnectionType.CUSTOMER, id);
    fp.createCustomer(CreateCustomerRequest reqBody) // creates a new customer token
    
    id.put("customerId", "yourCustomerId");
    fp.connection = c.init(ConnectionType.CUSTOMERID, id);
    fp.getCustomer() // returns the customer token

    id.put("customerId", "yourCustomerId");
    fp.connection = c.init(ConnectionType.CUSTOMERID, id);
    fp.updateCustomer(UpdateCustomerRequest reqBody) // updates the customer token
    
    id.put("customerId", "yourCustomerId");
    fp.connection = c.init(ConnectionType.CUSTOMERID, id);
    fp.deleteCustomer() // deletes the customer token
    
    id.put("customerId", "yourCustomerId");
    fp.connection = c.init(ConnectionType.CUSTOMERADDRESS, id);
    fp.createCustomerAddress(CustomerAddressRequest reqBody) // creates a new address token
    
    id.put("customerId", "yourCustomerId");
    id.put("addressTokenId", "yourAddressTokenId");
    fp.connection = c.init(ConnectionType.CUSTOMERADDRESSID, id);
    fp.getCustomerAddress() // returns the address token
    
    id.put("customerId", "yourCustomerId");
    fp.connection = c.init(ConnectionType.CUSTOMERADDRESSES, id);
    fp.getCustomerAddresses() // returns all address tokens
    
    id.put("customerId", "yourCustomerId");
    id.put("addressTokenId", "yourAddressTokenId");
    fp.connection = c.init(ConnectionType.CUSTOMERADDRESSID, id);
    fp.updateCustomerAddress(CustomerAddressRequest reqBody) // updates the address token
    
    id.put("customerId", "yourCustomerId");
    id.put("addressTokenId", "yourAddressTokenId");
    fp.connection = c.init(ConnectionType.CUSTOMERADDRESSID, id);
    fp.deleteCustomerAddress() // deletes the address token
    
    id.put("customerId", "yourCustomerId");
    id.put("paymentType", "yourPaymentType");
    fp.connection = c.init(ConnectionType.CUSTOMERPAYMENT, id);
    fp.createCustomerPayment(CustomerPaymentRequest reqBody) // creates a new payment token
    
    id.put("customerId", "yourCustomerId");
    id.put("paymentType", "yourPaymentType");
    id.put("paymentTokenId", "yourPaymentTokenId");
    fp.connection = c.init(ConnectionType.CUSTOMERPAYMENTID, id);
    fp.getCustomerPayment() // returns the payment token
    
    id.put("customerId", "yourCustomerId");
    id.put("paymentType", "yourPaymentType");
    fp.connection = c.init(ConnectionType.CUSTOMERPAYMENT, id);
    fp.getCustomerPayments() // returns all payment tokens
    
    id.put("customerId", "yourCustomerId");
    id.put("paymentType", "yourPaymentType");
    id.put("paymentTokenId", "yourPaymentTokenId");
    fp.connection = c.init(ConnectionType.CUSTOMERPAYMENTID, id);
    fp.updateCustomerPayment(CustomerPaymentRequest reqBody) // updates the payment token
    
    id.put("customerId", "yourCustomerId");
    id.put("paymentType", "yourPaymentType");
    id.put("paymentTokenId", "yourPaymentTokenId");
    fp.connection = c.init(ConnectionType.CUSTOMERPAYMENTID, id);
    fp.deleteCustomerPayment() // deletes the payment token
    
    // Recurring section
    
    fp.connection = c.init(ConnectionType.ADDON, id);
    fp.createAddOn(RecurrenceRequest reqBody) // creates a new add on
    
    id.put("addOnId", "yourAddOnId");
    fp.connection = c.init(ConnectionType.ADDONID, id);
    fp.getAddOn() // returns the add on
    
    fp.connection = c.init(ConnectionType.ADDONS, id);
    fp.getAddons() // returns all add ons
    
    id.put("addOnId", "yourAddOnId");
    fp.connection = c.init(ConnectionType.ADDONID, id);
    fp.updateAddOn(RecurrenceRequest reqBody) // updates the add on
    
    id.put("addOnId", "yourAddOnId");
    fp.connection = c.init(ConnectionType.ADDONID, id);
    fp.deleteAddOn() // deletes the add on
    
    fp.connection = c.init(ConnectionType.DISCOUNT, id);
    fp.createDiscount(RecurrenceRequest reqBody) // creates a new discount
    
    id.put("discountId", "yourDiscountId");
    fp.connection = c.init(ConnectionType.DISCOUNTID, id);
    fp.getDiscount() // returns the discount
    
    fp.connection = c.init(ConnectionType.DISCOUNTS, id);
    fp.getDiscounts() // returns all discounts
    
    id.put("discountId", "yourDiscountId");
    fp.connection = c.init(ConnectionType.DISCOUNTID, id);
    fp.updateDiscount(RecurrenceRequest reqBody) // updates the discount
    
    id.put("discountId", "yourDiscountId");
    fp.connection = c.init(ConnectionType.DISCOUNTID, id);
    fp.deleteDiscount() // deletes the discount
    
    fp.connection = c.init(ConnectionType.PLAN, id);
    fp.createPlan(PlanRequest reqBody) // creates a new plan
    
    id.put("planId", "yourPlanId");
    fp.connection = c.init(ConnectionType.PLANID, id);
    fp.getPlan() // returns the plan
    
    fp.connection = c.init(ConnectionType.PLANS, id);
    fp.getPlans() // returns all plans
    
    id.put("planId", "yourPlanId");
    fp.connection = c.init(ConnectionType.PLANID, id);
    fp.updatePlan(PlanRequest reqBody) // updates the plan
    
    id.put("planId", "yourPlanId");
    fp.connection = c.init(ConnectionType.PLANID, id);
    fp.deletePlan() // deletes the plan
    
    fp.connection = c.init(ConnectionType.SUBSCRIPTION, id);
    fp.createSubscription(SubscriptionRequest reqBody) // creates a new subscription
    
    id.put("subscriptionId", "yourSubscriptionId");
    fp.connection = c.init(ConnectionType.SUBSCRIPTIONID, id);
    fp.getSubscription() // returns the subscription
    
    id.put("subscriptionId", "yourSubscriptionId");
    fp.connection = c.init(ConnectionType.SUBSCRIPTIONID, id);
    fp.updateSubscription(SubscriptionRequest reqBody) // updates the subscription
    
    id.put("subscriptionId", "yourSubscriptionId");
    fp.connection = c.init(ConnectionType.SUBSCRIPTIONID, id);
    fp.deleteSubscription() // deletes the subscription
    
    // Terminals section
    
    fp.connection = c.init(ConnectionType.TERMINALS, id);
    fp.getTerminals() // returns all terminals
    
    // Transactions section
    
    fp.connection = c.init(ConnectionType.TRANSACTION, id);
    fp.doTransaction(TransactionRquest reqBody) // initiates a transaction
    
    id.put("transactionId", "yourTransactionId");
    fp.connection = c.init(ConnectionType.TRANSACTIONSTATUS, id);
    fp.getTransactionStatus() // returns the state of the transaction

    fp.connection = c.init(ConnectionType.TRANSACTIONQUERY, id);
    fp.queryTransaction(TransactionQueryRequest reqBody) // returns the qualified transactions
    
    id.put("transactionId", "yourTransactionId");
    fp.connection = c.init(ConnectionType.TRANSACTIONCAPTURE, id);
    fp.captureTransaction(TransactionCaptureRequest reqBody) // captures the transaction
    
    id.put("transactionId", "yourTransactionId");
    fp.connection = c.init(ConnectionType.TRANSACTIONVOID, id);
    fp.voidTransaction() // voids the transaction
    
    id.put("transactionId", "yourTransactionId");
    fp.connection = c.init(ConnectionType.TRANSACTIONREFUND, id);
    fp.refundTransaction(TransactionRefundRequest reqBody) // refunds the transaction
    
    // Users section
    
    fp.connection = c.init(ConnectionType.CHANGEPASSWORD, id);
    fp.changePassword(ChangePasswordRequest reqBody) // changes the password
    
    fp.connection = c.init(ConnectionType.USER, id);
    fp.createUser(CreateUserRequest reqBody) // creates a new user
    
    fp.connection = c.init(ConnectionType.USER, id);
    fp.getCurrentUser() // returns the currently active user
    
    id.put("userId", "yourUserId");
    fp.connection = c.init(ConnectionType.USERID, id);
    fp.getUser() // returns the user
    
    fp.connection = c.init(ConnectionType.USERS, id);
    fp.getUsers() // returns all users
    
    id.put("userId", "yourUserId");
    fp.connection = c.init(ConnectionType.USERID, id);
    fp.updateUser(UpdateUserRequest reqBody) // updates the user
    
    id.put("userId", "yourUserId");
    fp.connection = c.init(ConnectionType.USERID, id);
    fp.deleteUser() // deletes the user
}
```

## Documentation
Further information can be found on the [Fluid Pay website](https://sandbox.fluidpay.com/docs/index.html#introduction).