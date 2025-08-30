package com.ktakilat.loan.weiget;

import android.text.TextUtils;
import com.ktakilat.cbase.http.ApiObserver;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.loan.KtakilatApplication;
import com.ktakilat.loan.global.Config;
import com.ktakilat.loan.http.AppHttp;
import com.trello.rxlifecycle2.LifecycleTransformer;

public class PushTokenUtil {

    /* renamed from: com.ktakilat.loan.weiget.PushTokenUtil$1  reason: invalid class name */
    class AnonymousClass1 extends ApiObserver<BaseResponse<Object>> {
        public final void a(BaseResponse baseResponse) {
        }

        public final void b(BaseResponse baseResponse) {
        }
    }

    /* JADX WARNING: type inference failed for: r0v4, types: [io.reactivex.Observer, java.lang.Object] */
    public static void a(String str) {
        KtakilatApplication.m.getClass();
        if (KtakilatApplication.h() && !TextUtils.isEmpty(str)) {
            Config.f495a = str;
            AppHttp.bindPushToken((LifecycleTransformer<BaseResponse<Object>>) null, str).subscribe(new Object());
        }
    }
}
