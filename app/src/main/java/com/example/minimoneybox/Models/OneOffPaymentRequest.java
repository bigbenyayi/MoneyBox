package com.example.minimoneybox.Models;

public class OneOffPaymentRequest {
    Integer Amount;
    Integer InvestorProductId;

    public OneOffPaymentRequest(Integer amount, Integer investorProductId) {
        Amount = amount;
        InvestorProductId = investorProductId;
    }

    public Integer getAmount() {
        return Amount;
    }

    public Integer getInvestorProductId() {
        return InvestorProductId;
    }
}
