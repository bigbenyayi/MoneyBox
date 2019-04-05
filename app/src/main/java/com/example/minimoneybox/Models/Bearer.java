package com.example.minimoneybox.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bearer {

    @SerializedName("BearerToken")
    @Expose
    private String bearerToken;
    @SerializedName("ExternalSessionId")
    @Expose
    private String externalSessionId;
    @SerializedName("SessionExternalId")
    @Expose
    private String sessionExternalId;
    @SerializedName("ExpiryInSeconds")
    @Expose
    private Integer expiryInSeconds;

    public String getBearerToken() {
        return bearerToken;
    }

    public void setBearerToken(String bearerToken) {
        this.bearerToken = bearerToken;
    }

    public String getExternalSessionId() {
        return externalSessionId;
    }

    public void setExternalSessionId(String externalSessionId) {
        this.externalSessionId = externalSessionId;
    }

    public String getSessionExternalId() {
        return sessionExternalId;
    }

    public void setSessionExternalId(String sessionExternalId) {
        this.sessionExternalId = sessionExternalId;
    }

    public Integer getExpiryInSeconds() {
        return expiryInSeconds;
    }

    public void setExpiryInSeconds(Integer expiryInSeconds) {
        this.expiryInSeconds = expiryInSeconds;
    }

}