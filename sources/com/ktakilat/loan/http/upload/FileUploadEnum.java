package com.ktakilat.loan.http.upload;

public enum FileUploadEnum {
    OCR("one"),
    FACE("two"),
    SOCIAL_SECURITY_CARD("three"),
    BANK_FLOW("four"),
    FEED_BACK("six");
    
    private String mValue;

    private FileUploadEnum(String str) {
        this.mValue = str;
    }

    public String getValue() {
        return this.mValue;
    }
}
