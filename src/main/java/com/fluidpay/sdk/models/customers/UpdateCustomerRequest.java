package com.fluidpay.sdk.models.customers;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * request to update a customer token
 */
public class UpdateCustomerRequest {
    private String description;
    @JsonProperty("payment_method")
    private String paymentMethod;
    @JsonProperty("payment_method_id")
    private String paymentMethodId;
    @JsonProperty("billing_address_id")
    private String billingAddressId;
    @JsonProperty("shipping_address_id")
    private String shippingAddressId;

    public UpdateCustomerRequest(String description, String paymentMethod, String paymentMethodId, String billingAddressId, String shippingAddressId) {
        this.description = description;
        this.paymentMethod = paymentMethod;
        this.paymentMethodId = paymentMethodId;
        this.billingAddressId = billingAddressId;
        this.shippingAddressId = shippingAddressId;
    }
}
