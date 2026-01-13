package com.fluidpay.sdk.models.transactions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Additional amounts for HSA/FSA transactions.
 * Required for HSA/FSA transactions.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdditionalAmounts {
    /**
     * HSA/FSA amounts
     */
    private HsaAmounts hsa;

    public AdditionalAmounts() {
    }

    public HsaAmounts getHsa() {
        return hsa;
    }

    public void setHsa(HsaAmounts hsa) {
        this.hsa = hsa;
    }

    /**
     * HSA/FSA amount details
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class HsaAmounts {
        /**
         * Total amount for HSA/FSA, passed as an unsigned integer
         */
        private Integer total;
        /**
         * RX Amount for HSA/FSA, passed as an unsigned integer
         */
        @JsonProperty("rx_amount")
        private Integer rxAmount;
        /**
         * Vision Amount for HSA/FSA, passed as an unsigned integer
         */
        @JsonProperty("vision_amount")
        private Integer visionAmount;
        /**
         * Clinic Amount for HSA/FSA, passed as an unsigned integer
         */
        @JsonProperty("clinic_amount")
        private Integer clinicAmount;
        /**
         * Dental Amount for HSA/FSA, passed as an unsigned integer
         */
        @JsonProperty("dental_amount")
        private Integer dentalAmount;

        public HsaAmounts() {
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public Integer getRxAmount() {
            return rxAmount;
        }

        public void setRxAmount(Integer rxAmount) {
            this.rxAmount = rxAmount;
        }

        public Integer getVisionAmount() {
            return visionAmount;
        }

        public void setVisionAmount(Integer visionAmount) {
            this.visionAmount = visionAmount;
        }

        public Integer getClinicAmount() {
            return clinicAmount;
        }

        public void setClinicAmount(Integer clinicAmount) {
            this.clinicAmount = clinicAmount;
        }

        public Integer getDentalAmount() {
            return dentalAmount;
        }

        public void setDentalAmount(Integer dentalAmount) {
            this.dentalAmount = dentalAmount;
        }
    }
}
