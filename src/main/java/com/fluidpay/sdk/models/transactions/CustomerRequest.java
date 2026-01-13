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

    public CustomerRequest(String id, String paymentMethodType, String paymentMethodId, String billingAddressId, String shippingAddressId) {
        this.id = id;
        this.paymentMethodType = paymentMethodType;
        this.paymentMethodId = paymentMethodId;
        this.billingAddressId = billingAddressId;
        this.shippingAddressId = shippingAddressId;
    }
}
