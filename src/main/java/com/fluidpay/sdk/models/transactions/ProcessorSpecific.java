package com.fluidpay.sdk.models.transactions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProcessorSpecific {
    @JsonProperty("BatchNum")
    private String batchNum;
    @JsonProperty("CashBack")
    private String cashBack;
    @JsonProperty("ClerkID")
    private String clerkId;
    @JsonProperty("DISC")
    private String disc;
    @JsonProperty("EBTCashAvailBalance")
    private String ebtCashAvailBalance;
    @JsonProperty("EBTCashBeginBalance")
    private String ebtCashBeginBalance;
    @JsonProperty("EBTCashLedgerBalance")
    private String ebtCashLedgerBalance;
    @JsonProperty("EBTFSAvailBalance")
    private String ebtfsAvailBalance;
    @JsonProperty("EBTFSBeginBalance")
    private String ebtfsBeginBalance;
    @JsonProperty("EBTFSLedgerBalance")
    private String ebtfsLedgerBalance;
    @JsonProperty("Fee")
    private String fee;
    @JsonProperty("InvNum")
    private String invNum;
    @JsonProperty("Language")
    private String language;
    @JsonProperty("ProcessData")
    private String processData;
    @JsonProperty("RefNo")
    private String refNo;
    @JsonProperty("RewardCode")
    private String rewardCode;
    @JsonProperty("RewardQR")
    private String rewardQr;
    @JsonProperty("RwdBalance")
    private String rwdBalance;
    @JsonProperty("RwdIssued")
    private String rwdIssued;
    @JsonProperty("RwdPoints")
    private String rwdPoints;
    @JsonProperty("SHFee")
    private String shFee;
    @JsonProperty("SVC")
    private String svc;
    @JsonProperty("TableNum")
    private String tableNum;
    @JsonProperty("TaxCity")
    private String taxCity;
    @JsonProperty("TaxState")
    private String taxState;
    @JsonProperty("TicketNum")
    private String ticketNum;
    @JsonProperty("Tip")
    private String tip;
    @JsonProperty("TotalAmt")
    private String totalAmt;
}
