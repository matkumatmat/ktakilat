package com.ktakilat.loan;

import android.text.TextUtils;
import com.android.installreferrer.api.InstallReferrerClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.FirebaseMessaging;
import com.ktakilat.cbase.datacollect.DataCollectManager;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.http.ApiInfoUtil;
import com.ktakilat.cbase.ui.BaseApplication;
import com.ktakilat.cbase.utils.DeviceUtils;
import com.ktakilat.loan.global.AppKv;
import com.ktakilat.loan.http.AppHttp;
import com.ktakilat.loan.weiget.PhoneUploadUtil;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public final /* synthetic */ class a implements ObservableOnSubscribe, OnCompleteListener {
    /* JADX WARNING: type inference failed for: r1v3, types: [java.lang.Object, io.reactivex.functions.Consumer] */
    /* JADX WARNING: type inference failed for: r2v1, types: [java.lang.Object, com.google.android.gms.tasks.OnCompleteListener] */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.lang.Object, com.google.android.gms.tasks.OnCompleteListener] */
    public void d(ObservableEmitter observableEmitter) {
        InstallReferrerClient installReferrerClient = KtakilatApplication.j;
        if (TextUtils.isEmpty(AppKv.d())) {
            AppKv.g().b("gaid", DeviceUtils.a(BaseApplication.e));
        }
        Thread.sleep(1000);
        ApiInfoUtil.b().c();
        Observable.create(new lb(BaseApplication.e, 11)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a()).subscribe(new Object());
        synchronized (KtakilatApplication.class) {
            FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new Object());
            FirebaseAnalytics.getInstance(BaseApplication.e).getAppInstanceId().addOnCompleteListener(new Object());
        }
        KtakilatApplication.e();
        KtaCollect.n_app_start_up();
        PhoneUploadUtil.g(BaseApplication.e);
        PhoneUploadUtil.e();
        BaseApplication baseApplication = BaseApplication.e;
        AppKv.d();
        DataCollectManager.e(baseApplication);
        PhoneUploadUtil.b();
        observableEmitter.onNext(Boolean.TRUE);
        observableEmitter.onComplete();
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [io.reactivex.Observer, java.lang.Object] */
    public void onComplete(Task task) {
        InstallReferrerClient installReferrerClient = KtakilatApplication.j;
        if (task.isSuccessful()) {
            String str = (String) task.getResult();
            if (!TextUtils.isEmpty(str) && !"".equals(str)) {
                AppHttp.commonFirebaseBind(str).subscribe(new Object());
            }
        }
    }
}
