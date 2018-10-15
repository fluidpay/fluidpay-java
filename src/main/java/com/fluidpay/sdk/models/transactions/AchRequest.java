package com.fluidpay.sdk.models.transactions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AchRequest {
    @JsonProperty("routing_number")
    private String routingNumber;
    @JsonProperty("account_number")
    private String accountNumber;
    @JsonProperty("sec_code")
    private String secCode;
    @JsonProperty("account_type")
    private String accountType;
    @JsonProperty("check_number")
    private String checkNumber;
    @JsonProperty("accountholder_authentication")
    private AccountholderAuthentication accountholderAuthentication;

    public AchRequest(String routingNumber, String accountNumber, String secCode, String accountType, String checkNumber, AccountholderAuthentication accountholderAuthentication) {
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
        this.secCode = secCode;
        this.accountType = accountType;
        this.checkNumber = checkNumber;
        this.accountholderAuthentication = accountholderAuthentication;
    }
}
