
package com.example.minimoneybox.Models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InverstorProducts {

    @SerializedName("MoneyboxEndOfTaxYear")
    @Expose
    private String moneyboxEndOfTaxYear;
    @SerializedName("TotalPlanValue")
    @Expose
    private Integer totalPlanValue;
    @SerializedName("TotalEarnings")
    @Expose
    private Integer totalEarnings;
    @SerializedName("TotalContributionsNet")
    @Expose
    private Integer totalContributionsNet;
    @SerializedName("TotalEarningsAsPercentage")
    @Expose
    private Double totalEarningsAsPercentage;
    @SerializedName("ProductResponses")
    @Expose
    private List<ProductResponse> productResponses = null;

    public String getMoneyboxEndOfTaxYear() {
        return moneyboxEndOfTaxYear;
    }

    public void setMoneyboxEndOfTaxYear(String moneyboxEndOfTaxYear) {
        this.moneyboxEndOfTaxYear = moneyboxEndOfTaxYear;
    }

    public Integer getTotalPlanValue() {
        return totalPlanValue;
    }

    public void setTotalPlanValue(Integer totalPlanValue) {
        this.totalPlanValue = totalPlanValue;
    }

    public Integer getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(Integer totalEarnings) {
        this.totalEarnings = totalEarnings;
    }

    public Integer getTotalContributionsNet() {
        return totalContributionsNet;
    }

    public void setTotalContributionsNet(Integer totalContributionsNet) {
        this.totalContributionsNet = totalContributionsNet;
    }

    public Double getTotalEarningsAsPercentage() {
        return totalEarningsAsPercentage;
    }

    public void setTotalEarningsAsPercentage(Double totalEarningsAsPercentage) {
        this.totalEarningsAsPercentage = totalEarningsAsPercentage;
    }

    public List<ProductResponse> getProductResponses() {
        return productResponses;
    }

    public void setProductResponses(List<ProductResponse> productResponses) {
        this.productResponses = productResponses;
    }

}
