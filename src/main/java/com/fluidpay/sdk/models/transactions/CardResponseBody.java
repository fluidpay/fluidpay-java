package com.fluidpay.sdk.models.transactions;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CardResponseBody {
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
    private String response;
    @JsonProperty("response_code")
    private int responseCode;
    @JsonProperty("auth_code")
    private String authCode;
    @JsonProperty("processor_response_code")
    private String processorResponseCode;
    @JsonProperty("processor_response_text")
    private String processorResponseText;
    @JsonProperty("processor_type")
    private String processorType;
    @JsonProperty("processor_id")
    private String processorId;
    @JsonProperty("avs_response_code")
    private String avsResponseCode;
    @JsonProperty("cvv_response_code")
    private String cvvResponseCode;
    @JsonProperty("processor_specific")
    @JsonDeserialize(using = ProcessorSpecificDeserializer.class)
    private ProcessorSpecific processorSpecific;
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

    public String getResponse() {
        return response;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getAuthCode() {
        return authCode;
    }

    public String getProcessorResponseCode() {
        return processorResponseCode;
    }

    public String getProcessorResponseText() {
        return processorResponseText;
    }

    public String getProcessorType() {
        return processorType;
    }

    public String getProcessorId() {
        return processorId;
    }

    public String getAvsResponseCode() {
        return avsResponseCode;
    }

    public String getCvvResponseCode() {
        return cvvResponseCode;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}
