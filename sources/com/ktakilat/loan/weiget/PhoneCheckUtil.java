package com.ktakilat.loan.weiget;

import android.app.Activity;
import android.text.TextUtils;
import com.ktakilat.cbase.utils.ToastUtil;
import com.ktakilat.loan.R;

public class PhoneCheckUtil {
    public static int a(Activity activity, String str) {
        if (TextUtils.isEmpty(str)) {
            return 1;
        }
        if (TextUtils.isEmpty(b(activity, str, true))) {
            return 2;
        }
        return 0;
    }

    public static String b(Activity activity, String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("+86")) {
            str = str.substring(3);
        }
        if (TextUtils.isEmpty(str)) {
            if (z) {
                ToastUtil.d(activity, activity.getString(R.string.verify_input_phone_error));
            }
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (!(c == '0' && sb.length() == 0) && c >= '0' && c <= '9') {
                sb.append(c);
            }
        }
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(sb2)) {
            if (z) {
                ToastUtil.d(activity, activity.getString(R.string.verify_input_phone_error));
            }
            return null;
        }
        if (sb2.startsWith("62")) {
            sb2 = sb2.substring(2);
        }
        if (TextUtils.isEmpty(sb2)) {
            if (z) {
                ToastUtil.d(activity, activity.getString(R.string.verify_input_phone_error));
            }
            return null;
        }
        StringBuilder sb3 = new StringBuilder();
        for (char c2 : sb2.toCharArray()) {
            if (c2 != '0' || sb3.length() != 0) {
                sb3.append(c2);
            }
        }
        String sb4 = sb3.toString();
        if (TextUtils.isEmpty(sb4)) {
            if (z) {
                ToastUtil.d(activity, activity.getString(R.string.verify_input_phone_error));
            }
            return null;
        } else if (!sb4.startsWith("8")) {
            if (z) {
                ToastUtil.d(activity, activity.getString(R.string.verify_input_phone_error));
            }
            return null;
        } else if (sb4.length() >= 9 && sb4.length() <= 12) {
            return sb4;
        } else {
            if (z) {
                ToastUtil.d(activity, activity.getString(R.string.verify_input_phone_error));
            }
            return null;
        }
    }
}
