package com.ktakilat.loan.http.phone_code;

public class PhoneCodeType {
    public static final PhoneCodeType DEVICE_CHANGE_PHONE_VEIRIFY = new PhoneCodeType(14);
    public static final PhoneCodeType DEVICE_LOGIN_VEIRIFY = new PhoneCodeType(13);
    public static final PhoneCodeType EDIT_PHONE_NUM = new PhoneCodeType(3);
    public static final PhoneCodeType EDIT_PWD = new PhoneCodeType(5);
    public static final PhoneCodeType FORGET_PWD = new PhoneCodeType(6);
    public static final PhoneCodeType LOAN_EDIT_PHONE_NUM = new PhoneCodeType(17);
    public static final PhoneCodeType LOAN_VERIFY = new PhoneCodeType(16);
    public static final PhoneCodeType LOGIN = new PhoneCodeType(2);
    public static final PhoneCodeType LONG_TIME_NO_LOGIN = new PhoneCodeType(4);
    public static final PhoneCodeType PHONE_CHANGE_PHONE_VEIRIFY = new PhoneCodeType(15);
    public static final PhoneCodeType REGISTER = new PhoneCodeType(1);
    private final int value;

    public PhoneCodeType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
