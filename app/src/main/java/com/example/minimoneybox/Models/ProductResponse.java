
package com.example.minimoneybox.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductResponse {

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("PlanValue")
    @Expose
    private Double planValue;
    @SerializedName("Moneybox")
    @Expose
    private Integer moneybox;
    @SerializedName("SubscriptionAmount")
    @Expose
    private Integer subscriptionAmount;
    @SerializedName("TotalFees")
    @Expose
    private Integer totalFees;
    @SerializedName("IsSelected")
    @Expose
    private Boolean isSelected;
    @SerializedName("IsFavourite")
    @Expose
    private Boolean isFavourite;
    @SerializedName("Product")
    @Expose
    private Product product;
    @SerializedName("InvestorAccount")
    @Expose
    private InvestorAccount investorAccount;
    @SerializedName("Personalisation")
    @Expose
    private Personalisation personalisation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPlanValue() {
        return planValue;
    }

    public void setPlanValue(Double planValue) {
        this.planValue = planValue;
    }

    public Integer getMoneybox() {
        return moneybox;
    }

    public void setMoneybox(Integer moneybox) {
        this.moneybox = moneybox;
    }

    public Integer getSubscriptionAmount() {
        return subscriptionAmount;
    }

    public void setSubscriptionAmount(Integer subscriptionAmount) {
        this.subscriptionAmount = subscriptionAmount;
    }

    public Integer getTotalFees() {
        return totalFees;
    }

    public void setTotalFees(Integer totalFees) {
        this.totalFees = totalFees;
    }

    public Boolean getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(Boolean isSelected) {
        this.isSelected = isSelected;
    }

    public Boolean getIsFavourite() {
        return isFavourite;
    }

    public void setIsFavourite(Boolean isFavourite) {
        this.isFavourite = isFavourite;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public InvestorAccount getInvestorAccount() {
        return investorAccount;
    }

    public void setInvestorAccount(InvestorAccount investorAccount) {
        this.investorAccount = investorAccount;
    }

    public Personalisation getPersonalisation() {
        return personalisation;
    }

    public void setPersonalisation(Personalisation personalisation) {
        this.personalisation = personalisation;
    }

}
