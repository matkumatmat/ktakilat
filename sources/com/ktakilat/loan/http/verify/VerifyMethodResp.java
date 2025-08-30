package com.ktakilat.loan.http.verify;

import com.ktakilat.cbase.checkvalue.NotEmpty;
import java.util.List;

public class VerifyMethodResp {
    @NotEmpty
    private List<Integer> availableMethods;

    public List<Integer> getAvailableMethods() {
        return this.availableMethods;
    }

    public void setAvailableMethods(List<Integer> list) {
        this.availableMethods = list;
    }
}
