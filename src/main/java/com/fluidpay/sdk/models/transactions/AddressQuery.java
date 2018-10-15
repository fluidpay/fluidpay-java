package com.fluidpay.sdk.models.transactions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressQuery {
    @JsonProperty("address_id")
    private StringQuery addressId;
    @JsonProperty("first_name")
    private StringQuery firstName;
    @JsonProperty("last_name")
    private StringQuery lastName;
    private StringQuery company;
    @JsonProperty("address_line_1")
    private StringQuery addressLine1;
    @JsonProperty("address_line_2")
    private StringQuery addressLine2;
    private StringQuery city;
    private StringQuery state;
    @JsonProperty("postal_code")
    private StringQuery postalCode;
    private StringQuery country;
    private StringQuery email;
    private StringQuery phone;
    private StringQuery fax;

    public void setAddressId(StringQuery addressId) {
        this.addressId = addressId;
    }

    public void setFirstName(StringQuery firstName) {
        this.firstName = firstName;
    }

    public void setLastName(StringQuery lastName) {
        this.lastName = lastName;
    }

    public void setCompany(StringQuery company) {
        this.company = company;
    }

    public void setAddressLine1(StringQuery addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public void setAddressLine2(StringQuery addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public void setCity(StringQuery city) {
        this.city = city;
    }

    public void setState(StringQuery state) {
        this.state = state;
    }

    public void setPostalCode(StringQuery postalCode) {
        this.postalCode = postalCode;
    }

    public void setCountry(StringQuery country) {
        this.country = country;
    }

    public void setEmail(StringQuery email) {
        this.email = email;
    }

    public void setPhone(StringQuery phone) {
        this.phone = phone;
    }

    public void setFax(StringQuery fax) {
        this.fax = fax;
    }
}
