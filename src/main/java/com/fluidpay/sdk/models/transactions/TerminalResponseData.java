package com.fluidpay.sdk.models.transactions;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TerminalResponseData{
    private String id;
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("idempotency_key")
    private String idempotencyKey;
    @JsonProperty("idempotency_time")
    private String idempotencyTime;
    private String type;
    private int amount;
    @JsonProperty("amount_authorized")
    private int amountAuthorized;
    @JsonProperty("amount_captured")
    private int amountCaptured;
    @JsonProperty("amount_settled")
    private int amountSettled;
    @JsonProperty("tip_amount")
    private int tipAmount;
    @JsonProperty("payment_adjustment")
    private int paymentAdjustment;
    @JsonProperty("payment_adjustment_add")
    private boolean paymentAdjustmentAdd;
    @JsonProperty("processor_id")
    private String processorId;
    @JsonProperty("processor_type")
    private String processorType;
    @JsonProperty("processor_name")
    private String processorName;
    @JsonProperty("payment_method")
    private String paymentMethod;
    @JsonProperty("payment_type")
    private String paymentType;
    @JsonProperty("tax_amount")
    private int taxAmount;
    @JsonProperty("tax_exempt")
    private boolean taxExempt;
    @JsonProperty("shipping_amount")
    private int shippingAmount;
    private String currency;
    private String description;
    @JsonProperty("order_id")
    private String orderId;
    @JsonProperty("po_number")
    private String poNumber;
    @JsonProperty("ip_address")
    private String ipAddress;
    @JsonProperty("transaction_source")
    private String transactionSource;
    @JsonProperty("email_receipt")
    private boolean emailReceipt;
    @JsonProperty("email_address")
    private String emailAddress;
    @JsonProperty("customer_id")
    private String customerId;
    @JsonProperty("referenced_transaction_id")
    private String referencedTransactionId;
    @JsonProperty("response_body")
    private ResponseBody responseBody;
    private String status;
    private String response;
    @JsonProperty("response_code")
    private int responseCode;
    @JsonProperty("billing_address")
    private Address billingAddress;
    @JsonProperty("shipping_address")
    private Address shippingAddress;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("captured_at")
    private String capturedAt;
    @JsonProperty("settled_at")
    private String settledAt;

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    public String getIdempotencyTime() {
        return idempotencyTime;
    }

    public String getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    public int getAmountAuthorized() {
        return amountAuthorized;
    }

    public int getAmountCaptured() {
        return amountCaptured;
    }

    public int getAmountSettled() {
        return amountSettled;
    }

    public String getUserName() {
        return userName;
    }

    public int getPaymentAdjustment() {
        return paymentAdjustment;
    }

    public boolean isPaymentAdjustmentAdd() {
        return paymentAdjustmentAdd;
    }

    public String getProcessorName() {
        return processorName;
    }

    public int getTipAmount() {
        return tipAmount;
    }

    public String getProcessorId() {
        return processorId;
    }

    public String getProcessorType() {
        return processorType;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public int getTaxAmount() {
        return taxAmount;
    }

    public boolean isTaxExempt() {
        return taxExempt;
    }

    public int getShippingAmount() {
        return shippingAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getDescription() {
        return description;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getTransactionSource() {
        return transactionSource;
    }

    public boolean isEmailReceipt() {
        return emailReceipt;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getReferencedTransactionId() {
        return referencedTransactionId;
    }

    public ResponseBody getResponseBody() {
        return responseBody;
    }

    public String getStatus() {
        return status;
    }

    public String getResponse() {
        return response;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getCapturedAt() {
        return capturedAt;
    }

    public String getSettledAt() {
        return settledAt;
    }
}
