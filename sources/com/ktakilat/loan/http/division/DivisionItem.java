package com.ktakilat.loan.http.division;

import com.ktakilat.cbase.checkvalue.NotEmpty;
import com.ktakilat.cbase.checkvalue.NotNull;
import java.io.Serializable;

public class DivisionItem implements Serializable {
    private static final long serialVersionUID = -1162254783396942340L;
    private String appName;
    private String appVersion;
    private String area;
    private String code;
    private String countryCode;
    private String countryName;
    @NotNull
    private Integer id;
    private Boolean isTop;
    @NotEmpty
    private String name;
    private String nameRaw;
    private Integer parentId;
    private String postCode;
    @NotNull
    private Integer type;

    public String getAppName() {
        return this.appName;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getArea() {
        return this.area;
    }

    public String getCode() {
        return this.code;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getNameRaw() {
        return this.nameRaw;
    }

    public Integer getParentId() {
        return this.parentId;
    }

    public String getPostCode() {
        return this.postCode;
    }

    public Boolean getTop() {
        return this.isTop;
    }

    public Integer getType() {
        return this.type;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setArea(String str) {
        this.area = str;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setCountryName(String str) {
        this.countryName = str;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNameRaw(String str) {
        this.nameRaw = str;
    }

    public void setParentId(Integer num) {
        this.parentId = num;
    }

    public void setPostCode(String str) {
        this.postCode = str;
    }

    public void setTop(Boolean bool) {
        this.isTop = bool;
    }

    public void setType(Integer num) {
        this.type = num;
    }
}
