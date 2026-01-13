package com.fluidpay.sdk.models.customers;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Default payment method for customer creation
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DefaultPayment {
    private DefaultPaymentCard card;
    private DefaultPaymentAch ach;
    private String token;
    @JsonProperty("apple_pay")
    private Object applePay;
    @JsonProperty("google_pay_token")
    private Object googlePayToken;

    public DefaultPayment() {
    }

    public DefaultPaymentCard getCard() {
        return card;
    }

    public void setCard(DefaultPaymentCard card) {
        this.card = card;
    }

    public DefaultPaymentAch getAch() {
        return ach;
    }

    public void setAch(DefaultPaymentAch ach) {
        this.ach = ach;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Object getApplePay() {
        return applePay;
    }

    public void setApplePay(Object applePay) {
        this.applePay = applePay;
    }

    public Object getGooglePayToken() {
        return googlePayToken;
    }

    public void setGooglePayToken(Object googlePayToken) {
        this.googlePayToken = googlePayToken;
    }
}
