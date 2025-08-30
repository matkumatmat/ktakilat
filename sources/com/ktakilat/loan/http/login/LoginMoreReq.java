package com.ktakilat.loan.http.login;

import java.util.ArrayList;
import java.util.List;

public class LoginMoreReq {
    public List<String> keys;

    public LoginMoreReq(String str) {
        ArrayList arrayList = new ArrayList(1);
        this.keys = arrayList;
        arrayList.add(str);
    }
}
