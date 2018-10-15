package com.fluidpay.sdk.models.transactions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DateQuery {
    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("end_date")
    private String endDate;

    public DateQuery(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
