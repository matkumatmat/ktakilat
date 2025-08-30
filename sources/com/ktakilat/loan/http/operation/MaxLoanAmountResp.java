package com.ktakilat.loan.http.operation;

public class MaxLoanAmountResp {
    private Long amount;
    private Long term;

    public Long getAmount() {
        return this.amount;
    }

    public Long getTerm() {
        return this.term;
    }

    public void setAmount(Long l) {
        this.amount = l;
    }

    public void setTerm(Long l) {
        this.term = l;
    }
}
