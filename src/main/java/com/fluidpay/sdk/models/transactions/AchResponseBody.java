package com.fluidpay.sdk.models.transactions;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AchResponseBody {
    private String id;
    @JsonProperty("sec_code")
    private String secCode;
    @JsonProperty("account_type")
    private String accountType;
    @JsonProperty("masked_account_number")
    private String maskedAccountNumber;
    @JsonProperty("routing_number")
    private String routingNumber;
    @JsonProperty("auth_code")
    private String authCode;
    private String response;
    @JsonProperty("response_code")
    private int responseCode;
    @JsonProperty("processor_response_code")
    private String processorResponseCode;
    @JsonProperty("processor_response_text")
    private String processorResponseText;
    @JsonProperty("processor_type")
    private String processorType;
    @JsonProperty("processor_id")
    private String processorId;
    @JsonProperty("processor_specific")
    @JsonDeserialize(using = AchSpecificDeserializer.class)
    private AchSpecific processorSpecific;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
}
