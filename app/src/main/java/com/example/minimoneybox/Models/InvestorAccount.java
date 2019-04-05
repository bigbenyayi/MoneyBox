
package com.example.minimoneybox.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InvestorAccount {

    @SerializedName("ContributionsNet")
    @Expose
    private Integer contributionsNet;
    @SerializedName("EarningsNet")
    @Expose
    private Double earningsNet;
    @SerializedName("EarningsAsPercentage")
    @Expose
    private Double earningsAsPercentage;

    public Integer getContributionsNet() {
        return contributionsNet;
    }

    public void setContributionsNet(Integer contributionsNet) {
        this.contributionsNet = contributionsNet;
    }

    public Double getEarningsNet() {
        return earningsNet;
    }

    public void setEarningsNet(Double earningsNet) {
        this.earningsNet = earningsNet;
    }

    public Double getEarningsAsPercentage() {
        return earningsAsPercentage;
    }

    public void setEarningsAsPercentage(Double earningsAsPercentage) {
        this.earningsAsPercentage = earningsAsPercentage;
    }

}
