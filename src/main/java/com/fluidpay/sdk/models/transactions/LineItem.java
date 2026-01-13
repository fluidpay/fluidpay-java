package com.fluidpay.sdk.models.transactions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Line item for Level 3 transaction data.
 * Required for L3 transactions.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LineItem {
    /**
     * Friendly name up to 50 alpha characters
     */
    private String name;
    /**
     * Product Description up to 50 alpha characters
     */
    private String description;
    /**
     * Product Code/SKU up to 50 alpha characters
     */
    @JsonProperty("product_code")
    private String productCode;
    /**
     * Commodity Code up to 12 alpha characters
     */
    @JsonProperty("commodity_code")
    private String commodityCode;
    /**
     * Quantity (format: ##.##)
     */
    private Double quantity;
    /**
     * Discount amount in cents
     */
    @JsonProperty("discount_amount")
    private Integer discountAmount;
    /**
     * Freight amount in cents
     */
    @JsonProperty("freight_amount")
    private Integer freightAmount;
    /**
     * Unit price in cents
     */
    @JsonProperty("unit_price")
    private Integer unitPrice;
    /**
     * Tax amount in cents
     */
    @JsonProperty("tax_amount")
    private Integer taxAmount;
    /**
     * National tax amount in cents
     */
    @JsonProperty("national_tax_amount")
    private Integer nationalTaxAmount;
    /**
     * Amount in cents
     */
    private Integer amount;
    /**
     * National tax rate (3 decimal rate. 10% = 10.000)
     */
    @JsonProperty("national_tax_rate")
    private String nationalTaxRate;
    /**
     * Tax rate (3 decimal rate. 10% = 10.000)
     */
    @JsonProperty("tax_rate")
    private String taxRate;
    /**
     * Unit of measure
     */
    @JsonProperty("unit_of_measure")
    private String unitOfMeasure;

    public LineItem() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Integer getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Integer discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Integer getFreightAmount() {
        return freightAmount;
    }

    public void setFreightAmount(Integer freightAmount) {
        this.freightAmount = freightAmount;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Integer taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Integer getNationalTaxAmount() {
        return nationalTaxAmount;
    }

    public void setNationalTaxAmount(Integer nationalTaxAmount) {
        this.nationalTaxAmount = nationalTaxAmount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getNationalTaxRate() {
        return nationalTaxRate;
    }

    public void setNationalTaxRate(String nationalTaxRate) {
        this.nationalTaxRate = nationalTaxRate;
    }

    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }
}
