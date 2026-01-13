package com.fluidpay.sdk.models.transactions;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CardResponse{
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
    private String status;
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

    public String getStatus() {
        return status;
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

    public ProcessorSpecific getProcessorSpecific() {
        return processorSpecific;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}
