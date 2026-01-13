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
    @JsonProperty("line_1")
    private String line1;
    @JsonProperty("line_2")
    private String line2;
    private String city;
    private String state;
    @JsonProperty("postal_code")
    private String postalCode;
    private String country;
    private String phone;
    private String fax;
    private String email;

    public CustomerAddressRequest(String firstName, String lastName, String company, String line1, String line2, String city, String state, String postalCode, String country, String phone, String fax, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
    }

    public CustomerAddressRequest(String firstName, String lastName, String company, String line1, String city, String state, String postalCode, String country, String phone, String fax, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.line1 = line1;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }
}
