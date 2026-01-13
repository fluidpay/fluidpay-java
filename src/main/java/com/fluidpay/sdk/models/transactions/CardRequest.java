package com.fluidpay.sdk.models.transactions;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Card payment method details for processing a transaction.
 * Must be "keyed" or "swiped" entry type.
 * Supports both plain card data and encrypted track data.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CardRequest {
    /**
     * Entry type: "keyed" or "swiped"
     */
    @JsonProperty("entry_type")
    private String entryType;
    /**
     * Card number (digits only). Required if payment_method.card is present.
     */
    private String number;
    /**
     * Expiration date (format MM/YY). Required if payment_method.card is present.
     */
    @JsonProperty("expiration_date")
    private String expirationDate;
    /**
     * Card Verification Code. Required if the applicable rule is set on the gateway.
     */
    private String cvc;
    /**
     * Decrypted track_1 data
     */
    @JsonProperty("track_1")
    private String track1;
    /**
     * Decrypted track_2 data
     */
    @JsonProperty("track_2")
    private String track2;
    /**
     * Encrypted Track 1
     */
    @JsonProperty("encrypted_track_1")
    private String encryptedTrack1;
    /**
     * Encrypted Track 2
     */
    @JsonProperty("encrypted_track_2")
    private String encryptedTrack2;
    /**
     * KSN used to encrypt the supplied encrypted tracks
     */
    private String ksn;
    /**
     * Optionally pass 3DS collected data. If passed, it must contain valid values.
     */
    @JsonProperty("cardholder_authentication")
    private CardholderAuthentication cardholderAuthentication;

    public CardRequest(String entryType, String number, String expirationDate, String cvc, CardholderAuthentication cardholderAuthentication) {
        this.entryType = entryType;
        this.number = number;
        this.expirationDate = expirationDate;
        this.cvc = cvc;
        this.cardholderAuthentication = cardholderAuthentication;
    }

    public CardRequest() {
    }

    public String getEntryType() {
        return entryType;
    }

    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getTrack1() {
        return track1;
    }

    public void setTrack1(String track1) {
        this.track1 = track1;
    }

    public String getTrack2() {
        return track2;
    }

    public void setTrack2(String track2) {
        this.track2 = track2;
    }

    public String getEncryptedTrack1() {
        return encryptedTrack1;
    }

    public void setEncryptedTrack1(String encryptedTrack1) {
        this.encryptedTrack1 = encryptedTrack1;
    }

    public String getEncryptedTrack2() {
        return encryptedTrack2;
    }

    public void setEncryptedTrack2(String encryptedTrack2) {
        this.encryptedTrack2 = encryptedTrack2;
    }

    public String getKsn() {
        return ksn;
    }

    public void setKsn(String ksn) {
        this.ksn = ksn;
    }

    public CardholderAuthentication getCardholderAuthentication() {
        return cardholderAuthentication;
    }

    public void setCardholderAuthentication(CardholderAuthentication cardholderAuthentication) {
        this.cardholderAuthentication = cardholderAuthentication;
    }
}
