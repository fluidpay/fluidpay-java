package com.fluidpay.sdk.models.transactions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Descriptor information for specific processor types.
 * Optional: this only applies to specific processor types.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Descriptor {
    /**
     * Name (38 characters max)
     */
    private String name;
    /**
     * Address (38 characters max)
     */
    private String address;
    /**
     * City (21 characters max)
     */
    private String city;
    /**
     * State (2 characters)
     */
    private String state;
    /**
     * Postal code (5 characters)
     */
    @JsonProperty("postal_code")
    private String postalCode;

    public Descriptor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
