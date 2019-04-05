
package com.example.minimoneybox.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Personalisation {

    @SerializedName("QuickAddDeposit")
    @Expose
    private QuickAddDeposit quickAddDeposit;
    @SerializedName("HideAccounts")
    @Expose
    private HideAccounts hideAccounts;

    public QuickAddDeposit getQuickAddDeposit() {
        return quickAddDeposit;
    }

    public void setQuickAddDeposit(QuickAddDeposit quickAddDeposit) {
        this.quickAddDeposit = quickAddDeposit;
    }

    public HideAccounts getHideAccounts() {
        return hideAccounts;
    }

    public void setHideAccounts(HideAccounts hideAccounts) {
        this.hideAccounts = hideAccounts;
    }

}
