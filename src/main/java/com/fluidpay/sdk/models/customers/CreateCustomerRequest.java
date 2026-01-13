package com.fluidpay.sdk.models.customers;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fluidpay.sdk.models.transactions.Address;

import java.util.List;

/**
 * request to create a new customer token
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateCustomerRequest {
    private String id;
    @JsonProperty("id_format")
    private String idFormat;
    private String description;
    private List<String> flags;
    @JsonProperty("default_payment")
    private DefaultPayment defaultPayment;
    @JsonProperty("default_billing_address")
    private Address defaultBillingAddress;
    @JsonProperty("default_shipping_address")
    private Address defaultShippingAddress;

    // Legacy constructor for backward compatibility
    public CreateCustomerRequest(String description, CustomerPaymentMethodRequest paymentMethod, Address billingAddress, Address shippingAddress) {
        this.description = description;
        // Convert legacy payment method to new format
        if (paymentMethod != null && paymentMethod.getCard() != null) {
            this.defaultPayment = new DefaultPayment();
            CustomerPaymentRequest cardReq = paymentMethod.getCard();
            this.defaultPayment.setCard(new DefaultPaymentCard(cardReq.getCardNumber(), cardReq.getExpirationDate()));
        }
        this.defaultBillingAddress = billingAddress;
        this.defaultShippingAddress = shippingAddress;
    }

    public CreateCustomerRequest() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdFormat() {
        return idFormat;
    }

    public void setIdFormat(String idFormat) {
        this.idFormat = idFormat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getFlags() {
        return flags;
    }

    public void setFlags(List<String> flags) {
        this.flags = flags;
    }

    public DefaultPayment getDefaultPayment() {
        return defaultPayment;
    }

    public void setDefaultPayment(DefaultPayment defaultPayment) {
        this.defaultPayment = defaultPayment;
    }

    public Address getDefaultBillingAddress() {
        return defaultBillingAddress;
    }

    public void setDefaultBillingAddress(Address defaultBillingAddress) {
        this.defaultBillingAddress = defaultBillingAddress;
    }

    public Address getDefaultShippingAddress() {
        return defaultShippingAddress;
    }

    public void setDefaultShippingAddress(Address defaultShippingAddress) {
        this.defaultShippingAddress = defaultShippingAddress;
    }
}
