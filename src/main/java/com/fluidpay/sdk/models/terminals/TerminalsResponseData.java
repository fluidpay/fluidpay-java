package com.fluidpay.sdk.models.terminals;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TerminalsResponseData {
    private String id;
    @JsonProperty("merchant_id")
    private String merchantId;
    private String manufacturer;
    private String model;
    @JsonProperty("serial_number")
    private String serialNumber;
    private String tpn;
    private String description;
    private String status;
    @JsonProperty("auth_key")
    private String authKey;
    @JsonProperty("register_id")
    private String registerId;
    @JsonProperty("auto_settle")
    private boolean autoSettle;
    @JsonProperty("settle_at")
    private String settleAt;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;

    public String getId() {
        return id;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getTpn() {
        return tpn;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getAuthKey() {
        return authKey;
    }

    public String getRegisterId() {
        return registerId;
    }

    public boolean isAutoSettle() {
        return autoSettle;
    }

    public String getSettleAt() {
        return settleAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }
}