package com.ktakilat.loan.verify_face;

import com.google.common.net.HttpHeaders;
import com.ktakilat.cbase.http.ApiManager;
import com.ktakilat.cbase.utils.JsonUtil;
import com.ktakilat.loan.KtakilatApplication;
import com.ktakilat.loan.global.AppKv;
import com.ktakilat.loan.weiget.WebCookieManager;

public class ChangeMobileAndForgotPwdTmpLoginUtil {

    /* renamed from: a  reason: collision with root package name */
    public static volatile TmpLoginMsg f557a;

    public static class TmpLoginMsg {

        /* renamed from: a  reason: collision with root package name */
        public String f558a;
        public String b;
        public String c;
    }

    public static synchronized void a() {
        synchronized (ChangeMobileAndForgotPwdTmpLoginUtil.class) {
            f557a = null;
            if (!AppKv.g().f465a.getBoolean("entry_is_loggined_cq", true)) {
                ApiManager.b().a(HttpHeaders.AUTHORIZATION, (String) null);
                AppKv.g().b("auth_status", JsonUtil.a((Object) null));
                AppKv.g().f465a.putBoolean("entry_is_loggined_cq", true);
            }
        }
    }

    public static synchronized void b(WebCookieManager.CookieCallback cookieCallback) {
        synchronized (ChangeMobileAndForgotPwdTmpLoginUtil.class) {
            try {
                if (f557a != null) {
                    KtakilatApplication ktakilatApplication = KtakilatApplication.m;
                    String str = f557a.f558a;
                    String str2 = f557a.b;
                    String str3 = f557a.c;
                    ktakilatApplication.getClass();
                    KtakilatApplication.k(str, str2, str3, cookieCallback);
                    AppKv.g().f465a.putBoolean("entry_is_loggined_cq", true);
                    AppKv.g().b("auth_status", JsonUtil.a((Object) null));
                    f557a = null;
                } else {
                    cookieCallback.d();
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public static synchronized String c() {
        synchronized (ChangeMobileAndForgotPwdTmpLoginUtil.class) {
            if (f557a == null) {
                return null;
            }
            String str = f557a.c;
            return str;
        }
    }

    public static synchronized String d() {
        synchronized (ChangeMobileAndForgotPwdTmpLoginUtil.class) {
            if (f557a == null) {
                return null;
            }
            String str = f557a.f558a;
            return str;
        }
    }

    /* JADX WARNING: type inference failed for: r1v4, types: [com.ktakilat.loan.verify_face.ChangeMobileAndForgotPwdTmpLoginUtil$TmpLoginMsg, java.lang.Object] */
    public static synchronized void e(String str, String str2, String str3) {
        synchronized (ChangeMobileAndForgotPwdTmpLoginUtil.class) {
            AppKv.g().b("auth_status", JsonUtil.a((Object) null));
            KtakilatApplication.m.getClass();
            if (!KtakilatApplication.h()) {
                AppKv.g().f465a.putBoolean("entry_is_loggined_cq", false);
            } else {
                KtakilatApplication.m.getClass();
                KtakilatApplication.k(str, str2, str3, (WebCookieManager.CookieCallback) null);
            }
            ApiManager.b().a(HttpHeaders.AUTHORIZATION, str);
            ? obj = new Object();
            obj.f558a = str;
            obj.b = str2;
            obj.c = str3;
            f557a = obj;
        }
    }
}
