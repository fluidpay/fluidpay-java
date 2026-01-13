package com.fluidpay.sdk.models.transactions;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AchSpecific {
    @JsonProperty("result_codes")
    private String[] resultCodes;
    @JsonProperty("type_codes")
    private String[] typeCodes;

    public String[] getResultCodes() {
        return resultCodes;
    }

    public String[] getTypeCodes() {
        return typeCodes;
    }
}
