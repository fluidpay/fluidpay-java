package com.fluidpay.sdk.models.customers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fluidpay.sdk.models.transactions.DateQuery;
import com.fluidpay.sdk.models.transactions.StringQuery;

/**
 * Request for searching customers
 */
public class CustomerSearchRequest {
    private StringQuery id;
    private StringQuery description;
    private StringQuery notes;
    private StringQuery flags;
    @JsonProperty("created_at")
    private DateQuery createdAt;
    @JsonProperty("updated_at")
    private DateQuery updatedAt;

    public CustomerSearchRequest() {
    }

    public StringQuery getId() {
        return id;
    }

    public void setId(StringQuery id) {
        this.id = id;
    }

    public StringQuery getDescription() {
        return description;
    }

    public void setDescription(StringQuery description) {
        this.description = description;
    }

    public StringQuery getNotes() {
        return notes;
    }

    public void setNotes(StringQuery notes) {
        this.notes = notes;
    }

    public StringQuery getFlags() {
        return flags;
    }

    public void setFlags(StringQuery flags) {
        this.flags = flags;
    }

    public DateQuery getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(DateQuery createdAt) {
        this.createdAt = createdAt;
    }

    public DateQuery getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(DateQuery updatedAt) {
        this.updatedAt = updatedAt;
    }
}
