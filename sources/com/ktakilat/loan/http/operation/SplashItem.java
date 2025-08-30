package com.ktakilat.loan.http.operation;

import com.ktakilat.cbase.checkvalue.NotEmpty;

public class SplashItem {
    private Integer id;
    @NotEmpty
    private String openingPagePicture;

    public Integer getId() {
        return this.id;
    }

    public String getOpeningPagePicture() {
        return this.openingPagePicture;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public void setOpeningPagePicture(String str) {
        this.openingPagePicture = str;
    }
}
