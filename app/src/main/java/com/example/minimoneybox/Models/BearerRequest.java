package com.example.minimoneybox.Models;

public class BearerRequest {
    String Email;
    String Password;
    String Idfa;

    public BearerRequest(String email, String password, String idfa) {
        Email = email;
        Password = password;
        Idfa = idfa;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public String getIdfa() {
        return Idfa;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setIdfa(String idfa) {
        Idfa = idfa;
    }
}
