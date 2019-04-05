
package com.example.minimoneybox.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Lisa {

    @SerializedName("MaximumBonus")
    @Expose
    private Integer maximumBonus;

    public Integer getMaximumBonus() {
        return maximumBonus;
    }

    public void setMaximumBonus(Integer maximumBonus) {
        this.maximumBonus = maximumBonus;
    }

}
