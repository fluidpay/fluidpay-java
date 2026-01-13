package com.fluidpay.sdk.models.customers;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Default payment methods and addresses for customer update
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDefaults {
    @JsonProperty("billing_address_id")
    private String billingAddressId;
    @JsonProperty("shipping_address_id")
    private String shippingAddressId;
    @JsonProperty("payment_method_id")
    private String paymentMethodId;
    @JsonProperty("payment_method_type")
    private String paymentMethodType;

    public CustomerDefaults() {
    }

    public CustomerDefaults(String billingAddressId, String shippingAddressId, String paymentMethodId, String paymentMethodType) {
        this.billingAddressId = billingAddressId;
        this.shippingAddressId = shippingAddressId;
        this.paymentMethodId = paymentMethodId;
        this.paymentMethodType = paymentMethodType;
    }

    public String getBillingAddressId() {
        return billingAddressId;
    }

    public void setBillingAddressId(String billingAddressId) {
        this.billingAddressId = billingAddressId;
    }

    public String getShippingAddressId() {
        return shippingAddressId;
    }

    public void setShippingAddressId(String shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getPaymentMethodType() {
        return paymentMethodType;
    }

    public void setPaymentMethodType(String paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
    }
}
