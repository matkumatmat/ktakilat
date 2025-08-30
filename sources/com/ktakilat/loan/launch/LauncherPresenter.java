package com.ktakilat.loan.launch;

import com.ktakilat.cbase.http.ApiObserver;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.loan.KtakilatApplication;
import com.ktakilat.loan.global.AppKv;
import com.ktakilat.loan.launch.LauncherContact;
import com.ktakilat.loan.main.HomeActivity;
import com.ktakilat.loan.weiget.GestureUtil;
import com.ktakilat.loan.weiget.LoginUtil;

public class LauncherPresenter implements LauncherContact.Presenter {

    /* renamed from: a  reason: collision with root package name */
    public LauncherActivity f506a;
    public GestureUtil b;
    public LoginUtil c;

    /* renamed from: com.ktakilat.loan.launch.LauncherPresenter$2  reason: invalid class name */
    class AnonymousClass2 extends ApiObserver<BaseResponse<String>> {
        public final void a(BaseResponse baseResponse) {
        }

        public final void b(BaseResponse baseResponse) {
            AppKv.g().b("commonconfigkey_password_verification_key", (String) baseResponse.getData());
        }
    }

    public final synchronized void a() {
        LauncherActivity launcherActivity = this.f506a;
        launcherActivity.getClass();
        HomeActivity.C(launcherActivity, (String) null, false);
    }

    public final void b() {
        KtakilatApplication.m.getClass();
        boolean h = KtakilatApplication.h();
        LauncherActivity launcherActivity = this.f506a;
        if (!h) {
            boolean f = AppKv.f();
            LoginUtil loginUtil = this.c;
            if (f) {
                loginUtil.e(new LoginUtil.LastLoginMobileCall() {
                    public final void a(String str, Boolean bool, int i) {
                        LauncherPresenter launcherPresenter = LauncherPresenter.this;
                        launcherPresenter.a();
                        launcherPresenter.c.d(i, str);
                        LauncherActivity launcherActivity = launcherPresenter.f506a;
                        launcherActivity.getClass();
                        launcherActivity.finish();
                    }
                });
                return;
            }
            a();
            loginUtil.d(-1, (String) null);
            launcherActivity.getClass();
            launcherActivity.finish();
            return;
        }
        a();
        launcherActivity.getClass();
        launcherActivity.finish();
    }
}
