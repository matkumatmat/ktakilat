package com.ktakilat.cbase.http.phone;

import java.io.Serializable;
import java.util.List;

public class AppCacheModel implements Serializable {
    private static final long serialVersionUID = -4740021886624102572L;
    private List<App> appList;
    private String date;

    public List<App> getAppList() {
        return this.appList;
    }

    public String getDate() {
        return this.date;
    }

    public void setAppList(List<App> list) {
        this.appList = list;
    }

    public void setDate(String str) {
        this.date = str;
    }
}
