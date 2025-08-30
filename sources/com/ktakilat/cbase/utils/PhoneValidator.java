package com.ktakilat.cbase.utils;

import android.content.Context;
import android.text.TextUtils;

public class PhoneValidator {
    public PhoneValidator(Context context) {
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String replaceAll = str.replaceAll("\\s*", "");
        int i = 2;
        int i2 = 4;
        int i3 = 3;
        switch (replaceAll.length()) {
            case 6:
                i2 = 2;
                break;
            case 7:
                i2 = 3;
                break;
            case 8:
                break;
            case 9:
                i = 3;
                i2 = 3;
                break;
            case 10:
                i = 3;
                break;
            case 11:
                i = 3;
                i3 = 4;
                break;
            case 12:
                i = 3;
                i3 = 5;
                break;
            default:
                if (replaceAll.length() < 3) {
                    return replaceAll;
                }
                return replaceAll.substring(0, 1) + "***" + replaceAll.substring(replaceAll.length() - 2, replaceAll.length());
        }
        i3 = 2;
        StringBuilder r = e.r(i, "(\\d{", i2, "})\\d{", "}(\\d{");
        r.append(i3);
        r.append("})");
        return replaceAll.replaceAll(r.toString(), "$1****$2");
    }
}
