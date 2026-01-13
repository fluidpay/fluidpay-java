package com.fluidpay.sdk.models.transactions;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * request for querying a transaction,
 * all fields are optional, modified by setters
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionQueryRequest {
    @JsonProperty("transaction_id")
    private StringQuery transactionId;
    @JsonProperty("user_id")
    private StringQuery userId;
    private StringQuery type;
    @JsonProperty("ip_address")
    private StringQuery ipAddress;
    private IntQuery amount;
    @JsonProperty("amount_authorized")
    private IntQuery amountAuthorized;
    @JsonProperty("amount_captured")
    private IntQuery amountCaptured;
    @JsonProperty("tax_amount")
    private IntQuery taxAmount;
    @JsonProperty("po_number")
    private StringQuery poNumber;
    @JsonProperty("order_id")
    private StringQuery orderId;
    @JsonProperty("payment_method")
    private StringQuery paymentMethod;
    @JsonProperty("payment_type")
    private StringQuery paymentType;
    private StringQuery status;
    @JsonProperty("processor_id")
    private StringQuery processorId;
    @JsonProperty("customer_id")
    private StringQuery customerId;
    @JsonProperty("created_at")
    private DateQuery createdAt;
    @JsonProperty("captured_at")
    private DateQuery capturedAt;
    @JsonProperty("settled_at")
    private DateQuery settledAt;
    @JsonProperty("billing_address")
    private AddressQuery billingAddress;
    @JsonProperty("shipping_address")
    private AddressQuery shippingAddress;
    private int limit;
    private int offset;

    public void setTransactionId(StringQuery transactionId) {
        this.transactionId = transactionId;
    }

    public void setUserId(StringQuery userId) {
        this.userId = userId;
    }

    public void setType(StringQuery type) {
        this.type = type;
    }

    public void setIpAddress(StringQuery ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setAmount(IntQuery amount) {
        this.amount = amount;
    }

    public void setAmountAuthorized(IntQuery amountAuthorized) {
        this.amountAuthorized = amountAuthorized;
    }

    public void setAmountCaptured(IntQuery amountCaptured) {
        this.amountCaptured = amountCaptured;
    }

    public void setTaxAmount(IntQuery taxAmount) {
        this.taxAmount = taxAmount;
    }

    public void setPoNumber(StringQuery poNumber) {
        this.poNumber = poNumber;
    }

    public void setOrderId(StringQuery orderId) {
        this.orderId = orderId;
    }

    public void setPaymentMethod(StringQuery paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentType(StringQuery paymentType) {
        this.paymentType = paymentType;
    }

    public void setStatus(StringQuery status) {
        this.status = status;
    }

    public void setProcessorId(StringQuery processorId) {
        this.processorId = processorId;
    }

    public void setCustomerId(StringQuery customerId) {
        this.customerId = customerId;
    }

    public void setCreatedAt(DateQuery createdAt) {
        this.createdAt = createdAt;
    }

    public void setCapturedAt(DateQuery capturedAt) {
        this.capturedAt = capturedAt;
    }

    public void setSettledAt(DateQuery settledAt) {
        this.settledAt = settledAt;
    }

    public void setBillingAddress(AddressQuery billingAddress) {
        this.billingAddress = billingAddress;
    }

    public void setShippingAddress(AddressQuery shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
