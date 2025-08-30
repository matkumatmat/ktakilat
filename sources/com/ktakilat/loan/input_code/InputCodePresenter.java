package com.ktakilat.loan.input_code;

import com.ktakilat.loan.http.phone_code.PhoneCodeType;
import com.ktakilat.loan.http.user.OtpTypeEnum;
import com.ktakilat.loan.input_code.InputCodeContact;
import com.ktakilat.loan.weiget.PhoneCodeUtil;

public class InputCodePresenter implements InputCodeContact.Presenter {
    public static int c;
    public static long d;
    public static String e;
    public static String f;

    /* renamed from: a  reason: collision with root package name */
    public InputCodeActivity f498a;
    public PhoneCodeUtil b;

    public final void a(String str, PhoneCodeType phoneCodeType) {
        boolean equals = str.equals(e);
        PhoneCodeUtil phoneCodeUtil = this.b;
        if (equals) {
            int max = Math.max(c - ((int) ((System.currentTimeMillis() - d) / 1000)), 0);
            if (d == 0 && c != 0) {
                return;
            }
            if (max > 0) {
                phoneCodeUtil.f = f;
                phoneCodeUtil.e = true;
                phoneCodeUtil.c(max);
                return;
            }
            PhoneCodeUtil phoneCodeUtil2 = this.b;
            phoneCodeUtil2.getClass();
            phoneCodeUtil2.a(str, phoneCodeType, OtpTypeEnum.NORMAL);
            return;
        }
        d = 0;
        c = 0;
        e = str;
        f = null;
        phoneCodeUtil.e();
        PhoneCodeUtil phoneCodeUtil3 = this.b;
        phoneCodeUtil3.getClass();
        phoneCodeUtil3.a(str, phoneCodeType, OtpTypeEnum.NORMAL);
    }
}
