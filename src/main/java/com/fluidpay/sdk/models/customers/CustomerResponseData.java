package com.fluidpay.sdk.models.customers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerResponseData{
    private String id;
    private String description;
    @JsonProperty("payment_method")
    private CustomerPaymentMethodResponse paymentMethod;
    @JsonProperty("payment_method_type")
    private String paymentMethodType;
    @JsonProperty("billing_address")
    private CustomerAddressResponseData billingAddress;
    @JsonProperty("shipping_address")
    private CustomerAddressResponseData shippingAddress;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;

    public String getId() {
        return id;
    }

    public CustomerPaymentMethodResponse getPaymentMethod() {
        return paymentMethod;
    }

    public CustomerAddressResponseData getBillingAddress() {
        return billingAddress;
    }

    public CustomerAddressResponseData getShippingAddress() {
        return shippingAddress;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}
