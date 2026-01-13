package com.fluidpay.sdk.models.customers;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerCardResponse {
    private String id;
    @JsonProperty("card_type")
    private String cardType;
    @JsonProperty("first_six")
    private String firstSix;
    @JsonProperty("last_four")
    private String lastFour;
    @JsonProperty("masked_card")
    private String maskedCard;
    @JsonProperty("expiration_date")
    private String expirationDate;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;

    public String getId() {
        return id;
    }

    public String getCardType() {
        return cardType;
    }

    public String getFirstSix() {
        return firstSix;
    }

    public String getLastFour() {
        return lastFour;
    }

    public String getMaskedCard() {
        return maskedCard;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}