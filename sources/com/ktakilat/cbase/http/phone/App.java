package com.ktakilat.cbase.http.phone;

import java.io.Serializable;

public class App implements Serializable {
    private static final long serialVersionUID = 2364616591409908843L;
    public int appFlags;
    public String appName;
    public int appType;
    public long inTime;
    public String packageName;
    public long upTime;
    public String versionCode;
    public String versionName;
}
