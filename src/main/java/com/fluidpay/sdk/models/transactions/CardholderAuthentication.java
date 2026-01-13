package com.fluidpay.sdk.models.transactions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Cardholder authentication data for 3DS (3D Secure) transactions.
 * Optionally pass 3DS collected data. If passed, it must contain valid values.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CardholderAuthentication {
    private String condition;
    /**
     * ECI indicator (e.g., 01, 02, 05, 07, etc.)
     */
    private String eci;
    /**
     * CAVV (Cardholder Authentication Verification Value)
     */
    private String cavv;
    /**
     * XID (Transaction Identifier)
     */
    private String xid;
    /**
     * Cryptogram
     */
    private String cryptogram;
    /**
     * Version (1 or 2)
     */
    private String version;
    /**
     * DS Transaction ID
     */
    @JsonProperty("ds_transaction_id")
    private String dsTransactionId;
    /**
     * ACS Transaction ID
     */
    @JsonProperty("acs_transaction_id")
    private String acsTransactionId;

    public CardholderAuthentication() {
    }

    public CardholderAuthentication(String condition, String eci, String cavv, String xid) {
        this.condition = condition;
        this.eci = eci;
        this.cavv = cavv;
        this.xid = xid;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getEci() {
        return eci;
    }

    public void setEci(String eci) {
        this.eci = eci;
    }

    public String getCavv() {
        return cavv;
    }

    public void setCavv(String cavv) {
        this.cavv = cavv;
    }

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

    public String getCryptogram() {
        return cryptogram;
    }

    public void setCryptogram(String cryptogram) {
        this.cryptogram = cryptogram;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDsTransactionId() {
        return dsTransactionId;
    }

    public void setDsTransactionId(String dsTransactionId) {
        this.dsTransactionId = dsTransactionId;
    }

    public String getAcsTransactionId() {
        return acsTransactionId;
    }

    public void setAcsTransactionId(String acsTransactionId) {
        this.acsTransactionId = acsTransactionId;
    }
}
