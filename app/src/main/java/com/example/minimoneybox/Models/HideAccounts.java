
package com.example.minimoneybox.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HideAccounts {

    @SerializedName("Enabled")
    @Expose
    private Boolean enabled;
    @SerializedName("IsHidden")
    @Expose
    private Boolean isHidden;
    @SerializedName("Sequence")
    @Expose
    private Integer sequence;

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

}
