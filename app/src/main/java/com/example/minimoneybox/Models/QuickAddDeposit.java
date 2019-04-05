
package com.example.minimoneybox.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuickAddDeposit {

    @SerializedName("Amount")
    @Expose
    private Integer amount;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}
