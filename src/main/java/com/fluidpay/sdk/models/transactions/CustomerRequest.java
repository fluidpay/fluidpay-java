package com.fluidpay.sdk.models.transactions;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerRequest {
    private String id;
    @JsonProperty("payment_method_type")
    private String paymentMethodType;
    @JsonProperty("payment_method_id")
    private String paymentMethodId;
    @JsonProperty("billing_address_id")
    private String billingAddressId;
    @JsonProperty("shipping_address_id")
    private String shippingAddressId;

    public CustomerRequest() {
    }

    public CustomerRequest(String id, String paymentMethodType, String paymentMethodId, String billingAddressId, String shippingAddressId) {
        this.id = id;
        this.paymentMethodType = paymentMethodType;
        this.paymentMethodId = paymentMethodId;
        this.billingAddressId = billingAddressId;
        this.shippingAddressId = shippingAddressId;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getPaymentMethodType() { return paymentMethodType; }
    public void setPaymentMethodType(String paymentMethodType) { this.paymentMethodType = paymentMethodType; }
    public String getPaymentMethodId() { return paymentMethodId; }
    public void setPaymentMethodId(String paymentMethodId) { this.paymentMethodId = paymentMethodId; }
    public String getBillingAddressId() { return billingAddressId; }
    public void setBillingAddressId(String billingAddressId) { this.billingAddressId = billingAddressId; }
    public String getShippingAddressId() { return shippingAddressId; }
    public void setShippingAddressId(String shippingAddressId) { this.shippingAddressId = shippingAddressId; }
}
