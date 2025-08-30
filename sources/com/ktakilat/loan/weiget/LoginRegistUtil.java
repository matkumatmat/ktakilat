package com.ktakilat.loan.weiget;

import android.content.Context;
import android.content.Intent;
import com.facebook.places.model.PlaceFields;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.loan.KtakilatApplication;
import com.ktakilat.loan.global.AppKv;
import com.ktakilat.loan.mobile_check.MobileCheckV2Activity;
import com.ktakilat.loan.regist_otp.RegistOtpActivity;
import com.ktakilat.loan.weiget.LoginUtil;
import kotlin.jvm.internal.Intrinsics;

public class LoginRegistUtil {
    public static void a(BaseActivity baseActivity) {
        KtakilatApplication.m.getClass();
        if (!KtakilatApplication.h()) {
            LoginUtil loginUtil = new LoginUtil(baseActivity);
            if (loginUtil.b()) {
                if (AppKv.f()) {
                    loginUtil.e(new LoginUtil.LastLoginMobileCall() {
                        public final void a(String str, Boolean bool, int i) {
                            LoginUtil loginUtil = LoginUtil.this;
                            if (bool == null || bool.booleanValue()) {
                                loginUtil.d(i, str);
                                return;
                            }
                            int i2 = MobileCheckV2Activity.g;
                            Context context = loginUtil.f593a;
                            Intrinsics.checkNotNullParameter(context, PlaceFields.CONTEXT);
                            context.startActivity(new Intent(context, MobileCheckV2Activity.class));
                            Context context2 = loginUtil.f593a;
                            int i3 = RegistOtpActivity.s;
                            Intent intent = new Intent(context2, RegistOtpActivity.class);
                            intent.putExtra("mobile", str);
                            intent.putExtra("processRequestCode", 300);
                            context2.startActivity(intent);
                        }
                    });
                } else {
                    loginUtil.d(-1, (String) null);
                }
            }
        }
    }
}
