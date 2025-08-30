package com.ktakilat.loan.http.login;

import android.text.TextUtils;
import com.ktakilat.cbase.checkvalue.NotEmpty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginMoreResp {
    @NotEmpty
    private String key;
    @NotEmpty
    private String value;

    public List<String> getGenerValue() {
        ArrayList arrayList = new ArrayList(0);
        if (!TextUtils.isEmpty(getValue())) {
            arrayList.addAll(Arrays.asList(getValue().split("\\|")));
        }
        return arrayList;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
