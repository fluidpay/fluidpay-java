package com.fluidpay.sdk.models.transactions;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Map;

/**
 * Request to process a terminal transaction.
 * Supports all transaction fields as documented in the Fluidpay API.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TerminalTransactionRequest implements TransactionRequest{
    private String type;
    private Integer amount;
    @JsonProperty("base_amount")
    private Integer baseAmount;
    @JsonProperty("tax_exempt")
    private Boolean taxExempt;
    @JsonProperty("tax_amount")
    private Integer taxAmount;
    @JsonProperty("shipping_amount")
    private Integer shippingAmount;
    @JsonProperty("discount_amount")
    private Integer discountAmount;
    @JsonProperty("tip_amount")
    private Integer tipAmount;
    private String currency;
    private String description;
    @JsonProperty("order_id")
    private String orderId;
    @JsonProperty("po_number")
    private String poNumber;
    @JsonProperty("processor_id")
    private String processorId;
    @JsonProperty("ip_address")
    private String ipAddress;
    @JsonProperty("allow_partial_payment")
    private Boolean allowPartialPayment;
    @JsonProperty("email_receipt")
    private Boolean emailReceipt;
    @JsonProperty("email_address")
    private String emailAddress;
    @JsonProperty("create_vault_record")
    private Boolean createVaultRecord;
    @JsonProperty("create_vault_record_for")
    private String createVaultRecordFor;
    @JsonProperty("vendor_id")
    private String vendorId;
    @JsonProperty("billing_method")
    private String billingMethod;
    @JsonProperty("summary_commodity_code")
    private String summaryCommodityCode;
    @JsonProperty("ship_from_postal_code")
    private String shipFromPostalCode;
    @JsonProperty("payment_adjustment")
    private PaymentAdjustment paymentAdjustment;
    @JsonProperty("payment_method")
    private TerminalPayment paymentMethod;
    @JsonProperty("billing_address")
    private Address billingAddress;
    @JsonProperty("shipping_address")
    private Address shippingAddress;
    @JsonProperty("line_items")
    private LineItem[] lineItems;
    @JsonProperty("processor_specific")
    private ProcessorSpecific processorSpecific;
    private Descriptor descriptor;
    private Object[] subscriptions;
    @JsonProperty("custom_fields")
    private Map<String, String[]> customFields;
    @JsonProperty("group_name")
    private String groupName;
    @JsonProperty("iias_status")
    private String iiasStatus;
    @JsonProperty("additional_amounts")
    private AdditionalAmounts additionalAmounts;
    @JsonProperty("card_on_file_indicator")
    private String cardOnFileIndicator;
    @JsonProperty("initiated_by")
    private String initiatedBy;
    @JsonProperty("initial_transaction_id")
    private String initialTransactionId;
    @JsonProperty("stored_credential_indicator")
    private String storedCredentialIndicator;
    @JsonProperty("split_transaction_amount")
    private Integer splitTransactionAmount;
    @JsonProperty("idempotency_key")
    private String idempotencyKey;
    @JsonProperty("idempotency_time")
    private Integer idempotencyTime;

    public TerminalTransactionRequest() {
    }

    public TerminalTransactionRequest(String type, int amount, boolean taxExempt, int taxAmount, int shippingAmount, String currency, String description, String orderId, String poNumber, String ipAddress, boolean emailReciept, String emailAddress, TerminalPayment paymentMethod, Address billingAddress, Address shippingAddress) {
        this.type = type;
        this.amount = amount;
        this.taxExempt = taxExempt;
        this.taxAmount = taxAmount;
        this.shippingAmount = shippingAmount;
        this.currency = currency;
        this.description = description;
        this.orderId = orderId;
        this.poNumber = poNumber;
        this.ipAddress = ipAddress;
        this.emailReceipt = emailReciept;
        this.emailAddress = emailAddress;
        this.paymentMethod = paymentMethod;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
    }

    // Getters and Setters
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public Integer getAmount() { return amount; }
    public void setAmount(Integer amount) { this.amount = amount; }
    public Integer getBaseAmount() { return baseAmount; }
    public void setBaseAmount(Integer baseAmount) { this.baseAmount = baseAmount; }
    public Boolean getTaxExempt() { return taxExempt; }
    public void setTaxExempt(Boolean taxExempt) { this.taxExempt = taxExempt; }
    public Integer getTaxAmount() { return taxAmount; }
    public void setTaxAmount(Integer taxAmount) { this.taxAmount = taxAmount; }
    public Integer getShippingAmount() { return shippingAmount; }
    public void setShippingAmount(Integer shippingAmount) { this.shippingAmount = shippingAmount; }
    public Integer getDiscountAmount() { return discountAmount; }
    public void setDiscountAmount(Integer discountAmount) { this.discountAmount = discountAmount; }
    public Integer getTipAmount() { return tipAmount; }
    public void setTipAmount(Integer tipAmount) { this.tipAmount = tipAmount; }
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    public String getPoNumber() { return poNumber; }
    public void setPoNumber(String poNumber) { this.poNumber = poNumber; }
    public String getProcessorId() { return processorId; }
    public void setProcessorId(String processorId) { this.processorId = processorId; }
    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }
    public Boolean getAllowPartialPayment() { return allowPartialPayment; }
    public void setAllowPartialPayment(Boolean allowPartialPayment) { this.allowPartialPayment = allowPartialPayment; }
    public Boolean getEmailReceipt() { return emailReceipt; }
    public void setEmailReceipt(Boolean emailReceipt) { this.emailReceipt = emailReceipt; }
    public String getEmailAddress() { return emailAddress; }
    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }
    public Boolean getCreateVaultRecord() { return createVaultRecord; }
    public void setCreateVaultRecord(Boolean createVaultRecord) { this.createVaultRecord = createVaultRecord; }
    public String getCreateVaultRecordFor() { return createVaultRecordFor; }
    public void setCreateVaultRecordFor(String createVaultRecordFor) { this.createVaultRecordFor = createVaultRecordFor; }
    public String getVendorId() { return vendorId; }
    public void setVendorId(String vendorId) { this.vendorId = vendorId; }
    public String getBillingMethod() { return billingMethod; }
    public void setBillingMethod(String billingMethod) { this.billingMethod = billingMethod; }
    public String getSummaryCommodityCode() { return summaryCommodityCode; }
    public void setSummaryCommodityCode(String summaryCommodityCode) { this.summaryCommodityCode = summaryCommodityCode; }
    public String getShipFromPostalCode() { return shipFromPostalCode; }
    public void setShipFromPostalCode(String shipFromPostalCode) { this.shipFromPostalCode = shipFromPostalCode; }
    public PaymentAdjustment getPaymentAdjustment() { return paymentAdjustment; }
    public void setPaymentAdjustment(PaymentAdjustment paymentAdjustment) { this.paymentAdjustment = paymentAdjustment; }
    public TerminalPayment getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(TerminalPayment paymentMethod) { this.paymentMethod = paymentMethod; }
    public Address getBillingAddress() { return billingAddress; }
    public void setBillingAddress(Address billingAddress) { this.billingAddress = billingAddress; }
    public Address getShippingAddress() { return shippingAddress; }
    public void setShippingAddress(Address shippingAddress) { this.shippingAddress = shippingAddress; }
    public LineItem[] getLineItems() { return lineItems; }
    public void setLineItems(LineItem[] lineItems) { this.lineItems = lineItems; }
    public ProcessorSpecific getProcessorSpecific() { return processorSpecific; }
    public void setProcessorSpecific(ProcessorSpecific processorSpecific) { this.processorSpecific = processorSpecific; }
    public Descriptor getDescriptor() { return descriptor; }
    public void setDescriptor(Descriptor descriptor) { this.descriptor = descriptor; }
    public Object[] getSubscriptions() { return subscriptions; }
    public void setSubscriptions(Object[] subscriptions) { this.subscriptions = subscriptions; }
    public Map<String, String[]> getCustomFields() { return customFields; }
    public void setCustomFields(Map<String, String[]> customFields) { this.customFields = customFields; }
    public String getGroupName() { return groupName; }
    public void setGroupName(String groupName) { this.groupName = groupName; }
    public String getIiasStatus() { return iiasStatus; }
    public void setIiasStatus(String iiasStatus) { this.iiasStatus = iiasStatus; }
    public AdditionalAmounts getAdditionalAmounts() { return additionalAmounts; }
    public void setAdditionalAmounts(AdditionalAmounts additionalAmounts) { this.additionalAmounts = additionalAmounts; }
    public String getCardOnFileIndicator() { return cardOnFileIndicator; }
    public void setCardOnFileIndicator(String cardOnFileIndicator) { this.cardOnFileIndicator = cardOnFileIndicator; }
    public String getInitiatedBy() { return initiatedBy; }
    public void setInitiatedBy(String initiatedBy) { this.initiatedBy = initiatedBy; }
    public String getInitialTransactionId() { return initialTransactionId; }
    public void setInitialTransactionId(String initialTransactionId) { this.initialTransactionId = initialTransactionId; }
    public String getStoredCredentialIndicator() { return storedCredentialIndicator; }
    public void setStoredCredentialIndicator(String storedCredentialIndicator) { this.storedCredentialIndicator = storedCredentialIndicator; }
    public Integer getSplitTransactionAmount() { return splitTransactionAmount; }
    public void setSplitTransactionAmount(Integer splitTransactionAmount) { this.splitTransactionAmount = splitTransactionAmount; }
    public String getIdempotencyKey() { return idempotencyKey; }
    public void setIdempotencyKey(String idempotencyKey) { this.idempotencyKey = idempotencyKey; }
    public Integer getIdempotencyTime() { return idempotencyTime; }
    public void setIdempotencyTime(Integer idempotencyTime) { this.idempotencyTime = idempotencyTime; }
}
