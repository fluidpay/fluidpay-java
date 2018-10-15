package com.fluidpay.sdk.models.customers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fluidpay.sdk.models.transactions.Address;

/**
 * request to create a new customer token
 */
public class CreateCustomerRequest {
    private String description;
    @JsonProperty("payment_method")
    private CustomerPaymentMethodRequest paymentMethod;
    @JsonProperty("billing_address")
    private Address billingAddress;
    @JsonProperty("shipping_address")
    private Address shippingAddress;

    public CreateCustomerRequest(String description, CustomerPaymentMethodRequest paymentMethod, Address billingAddress, Address shippingAddress) {
        this.description = description;
        this.paymentMethod = paymentMethod;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
    }
}
