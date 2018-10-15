package com.fluidpay.sdk.models.transactions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TerminalResponseBody {
    private String id;
    @JsonProperty("terminal_id")
    private String terminalId;
    @JsonProperty("terminal_description")
    private String terminalDescription;
    @JsonProperty("card_type")
    private String cardType;
    @JsonProperty("payment_type")
    private String paymentType;
    @JsonProperty("entry_type")
    private String entryType;
    @JsonProperty("first_four")
    private String firstFour;
    @JsonProperty("last_four")
    private String lastFour;
    @JsonProperty("masked_card")
    private String maskedCard;
    @JsonProperty("cardholder_name")
    private String cardholderName;
    @JsonProperty("auth_code")
    private String authCode;
    @JsonProperty("response_code")
    private String responseCode;
    @JsonProperty("processor_response_text")
    private String processorResponseText;
    @JsonProperty("processor_specific")
    private ProcessorSpecific processorSpecific;
    @JsonProperty("emv_aid")
    private String emvAid;
    @JsonProperty("emv_app_name")
    private String emvAppName;
    @JsonProperty("emv_tvr")
    private String emvTvr;
    @JsonProperty("emv_tsi")
    private String emvTsi;
    @JsonProperty("signature_data")
    private String signatureData;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;

    public String getId() {
        return id;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public String getTerminalDescription() {
        return terminalDescription;
    }

    public String getCardType() {
        return cardType;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public String getEntryType() {
        return entryType;
    }

    public String getFirstFour() {
        return firstFour;
    }

    public String getLastFour() {
        return lastFour;
    }

    public String getMaskedCard() {
        return maskedCard;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public String getAuthCode() {
        return authCode;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public String getProcessorResponseText() {
        return processorResponseText;
    }

    public ProcessorSpecific getProcessorSpecific() {
        return processorSpecific;
    }

    public String getEmvAid() {
        return emvAid;
    }

    public String getEmvAppName() {
        return emvAppName;
    }

    public String getEmvTvr() {
        return emvTvr;
    }

    public String getEmvTsi() {
        return emvTsi;
    }

    public String getSignatureData() {
        return signatureData;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}
