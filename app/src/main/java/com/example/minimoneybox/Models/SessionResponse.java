package com.example.minimoneybox.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SessionResponse {

    @SerializedName("Session")
    @Expose
    private Bearer session;

    public Bearer getSession() {
        return session;
    }

    public void setSession(Bearer session) {
        this.session = session;
    }

}
