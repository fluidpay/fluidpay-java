package com.fluidpay.sdk.models.customers;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * request to create or update a customer address token
 */
public class CustomerAddressRequest {
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String company;
    @JsonProperty("address_line_1")
    private String addressLine1;
    @JsonProperty("address_line_2")
    private String addressLine2;
    private String city;
    private String state;
    @JsonProperty("postal_code")
    private String postalCode;
    private String country;
    private String phone;
    private String fax;
    private String email;

    public CustomerAddressRequest(String firstName, String lastName, String company, String addressLine1, String addressLine2, String city, String state, String postalCode, String country, String phone, String fax, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
    }

    public CustomerAddressRequest(String firstName, String lastName, String company, String addressLine1, String city, String state, String postalCode, String country, String phone, String fax, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.addressLine1 = addressLine1;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
    }
}
