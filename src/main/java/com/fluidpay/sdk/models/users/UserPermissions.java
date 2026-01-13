package com.fluidpay.sdk.models.users;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPermissions {
    @JsonProperty("manage_users")
    private boolean manageUsers;
    @JsonProperty("manage_api_keys")
    private boolean manageApiKeys;
    @JsonProperty("view_billing_reports")
    private boolean viewBillingReports;
    @JsonProperty("manage_terminals")
    private boolean manageTerminals;
    @JsonProperty("manage_rule_engine")
    private boolean manageRuleEngine;
    @JsonProperty("view_settlement_batches")
    private boolean viewSettlementBatches;
    @JsonProperty("process_authorization")
    private boolean processAuthorization;
    @JsonProperty("process_capture")
    private boolean processCapture;
    @JsonProperty("process_sale")
    private boolean processSale;
    @JsonProperty("process_void")
    private boolean processVoid;
    @JsonProperty("process_credit")
    private boolean processCredit;
    @JsonProperty("process_refund")
    private boolean processRefund;
    @JsonProperty("process_verification")
    private boolean processVerification;

    public boolean isManageUsers() {
        return manageUsers;
    }

    public boolean isManageApiKeys() {
        return manageApiKeys;
    }

    public boolean isViewBillingReports() {
        return viewBillingReports;
    }

    public boolean isManageTerminals() {
        return manageTerminals;
    }

    public boolean isManageRuleEngine() {
        return manageRuleEngine;
    }

    public boolean isViewSettlementBatches() {
        return viewSettlementBatches;
    }

    public boolean isProcessAuthorization() {
        return processAuthorization;
    }

    public boolean isProcessCapture() {
        return processCapture;
    }

    public boolean isProcessSale() {
        return processSale;
    }

    public boolean isProcessVoid() {
        return processVoid;
    }

    public boolean isProcessCredit() {
        return processCredit;
    }

    public boolean isProcessRefund() {
        return processRefund;
    }

    public boolean isProcessVerification() {
        return processVerification;
    }
}
