package com.fluidpay.sdk.models.customers;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * request to update a customer token
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateCustomerRequest {
    private String description;
    private String notes;
    private List<String> flags;
    private CustomerDefaults defaults;

    // Legacy constructor for backward compatibility
    public UpdateCustomerRequest(String description, String paymentMethod, String paymentMethodId, String billingAddressId, String shippingAddressId) {
        this.description = description;
        this.defaults = new CustomerDefaults(billingAddressId, shippingAddressId, paymentMethodId, paymentMethod);
    }

    public UpdateCustomerRequest() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<String> getFlags() {
        return flags;
    }

    public void setFlags(List<String> flags) {
        this.flags = flags;
    }

    public CustomerDefaults getDefaults() {
        return defaults;
    }

    public void setDefaults(CustomerDefaults defaults) {
        this.defaults = defaults;
    }
}
