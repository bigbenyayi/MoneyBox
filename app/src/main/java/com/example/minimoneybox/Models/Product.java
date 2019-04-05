
package com.example.minimoneybox.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Type")
    @Expose
    private String type;
    @SerializedName("FriendlyName")
    @Expose
    private String friendlyName;
    @SerializedName("CanWithdraw")
    @Expose
    private Boolean canWithdraw;
    @SerializedName("ProductHexCode")
    @Expose
    private String productHexCode;
    @SerializedName("AnnualLimit")
    @Expose
    private Integer annualLimit;
    @SerializedName("DepositLimit")
    @Expose
    private Integer depositLimit;
    @SerializedName("Lisa")
    @Expose
    private Lisa lisa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public void setFriendlyName(String friendlyName) {
        this.friendlyName = friendlyName;
    }

    public Boolean getCanWithdraw() {
        return canWithdraw;
    }

    public void setCanWithdraw(Boolean canWithdraw) {
        this.canWithdraw = canWithdraw;
    }

    public String getProductHexCode() {
        return productHexCode;
    }

    public void setProductHexCode(String productHexCode) {
        this.productHexCode = productHexCode;
    }

    public Integer getAnnualLimit() {
        return annualLimit;
    }

    public void setAnnualLimit(Integer annualLimit) {
        this.annualLimit = annualLimit;
    }

    public Integer getDepositLimit() {
        return depositLimit;
    }

    public void setDepositLimit(Integer depositLimit) {
        this.depositLimit = depositLimit;
    }

    public Lisa getLisa() {
        return lisa;
    }

    public void setLisa(Lisa lisa) {
        this.lisa = lisa;
    }

}
