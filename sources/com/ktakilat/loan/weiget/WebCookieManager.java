package com.ktakilat.loan.weiget;

import android.webkit.CookieManager;
import com.google.common.net.HttpHeaders;
import com.google.gson.JsonObject;
import com.ktakilat.cbase.http.ApiManager;
import com.ktakilat.loan.KtakilatApplication;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class WebCookieManager {

    public interface CookieCallback {
        void d();
    }

    public static void a(final CookieCallback cookieCallback) {
        Observable.create(new t9(27)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a()).subscribe(new Observer<Boolean>() {
            public final void onComplete() {
            }

            public final void onError(Throwable th) {
                CookieCallback cookieCallback = CookieCallback.this;
                if (cookieCallback != null) {
                    cookieCallback.d();
                }
            }

            public final void onNext(Object obj) {
                Boolean bool = (Boolean) obj;
                CookieCallback cookieCallback = CookieCallback.this;
                if (cookieCallback != null) {
                    cookieCallback.d();
                }
            }

            public final void onSubscribe(Disposable disposable) {
            }
        });
    }

    public static void b(String str) {
        CookieManager instance = CookieManager.getInstance();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(HttpHeaders.ACCEPT, ApiManager.b().c(HttpHeaders.ACCEPT));
        KtakilatApplication.m.getClass();
        jsonObject.addProperty("userLogin", Boolean.valueOf(KtakilatApplication.h()));
        KtakilatApplication.m.getClass();
        if (KtakilatApplication.h()) {
            KtakilatApplication.m.getClass();
            jsonObject.addProperty(HttpHeaders.AUTHORIZATION, KtakilatApplication.f().getToken());
            KtakilatApplication.m.getClass();
            jsonObject.addProperty("token", KtakilatApplication.f().getToken());
            KtakilatApplication.m.getClass();
            jsonObject.addProperty("userId", KtakilatApplication.f().getUserId());
            KtakilatApplication.m.getClass();
            jsonObject.addProperty("mobileNo", KtakilatApplication.f().getMobileNo());
        }
        instance.setCookie(str, jsonObject.toString());
    }
}
