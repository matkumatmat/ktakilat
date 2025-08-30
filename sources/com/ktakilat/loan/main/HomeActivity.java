package com.ktakilat.loan.main;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.gson.JsonObject;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.http.ApiObserver;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.cbase.ui.BaseApplication;
import com.ktakilat.cbase.ui.EventThirdError;
import com.ktakilat.cbase.utils.ToastUtil;
import com.ktakilat.cbase.weight.CommonWebView;
import com.ktakilat.loan.KtakilatApplication;
import com.ktakilat.loan.R;
import com.ktakilat.loan.device.DeviceUtil;
import com.ktakilat.loan.global.Config;
import com.ktakilat.loan.global.Domain;
import com.ktakilat.loan.main.HomeContact;
import com.ktakilat.loan.web.CommonWebActivity;
import com.ktakilat.loan.web.CommonWebFragment;
import com.ktakilat.loan.webtool.CommonWebViewSetting;
import com.ktakilat.loan.weiget.LoginRegistUtil;
import com.ktakilat.loan.weiget.PhoneUploadUtil;
import com.pendanaan.kta.databinding.ActivityHomeHomeBinding;
import com.tbruyelle.rxpermissions2.RxPermissions;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.UUID;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class HomeActivity extends BaseActivity implements HomeContact.View {
    public static final /* synthetic */ int p = 0;
    public HomePresenter i;
    public long j = 0;
    public boolean k = false;
    public String l = null;
    public String m = null;
    public CommonWebFragment n;
    public String o;

    /* renamed from: com.ktakilat.loan.main.HomeActivity$1  reason: invalid class name */
    class AnonymousClass1 implements Observer<Boolean> {
        public final void onComplete() {
        }

        public final void onError(Throwable th) {
            KtaCollect.n_request_permission("Post_Notifications", ExifInterface.GPS_MEASUREMENT_2D);
        }

        public final void onNext(Object obj) {
            String str;
            if (((Boolean) obj).booleanValue()) {
                str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
            } else {
                str = "-1";
            }
            KtaCollect.n_request_permission("Post_Notifications", str);
        }

        public final void onSubscribe(Disposable disposable) {
        }
    }

    /* renamed from: com.ktakilat.loan.main.HomeActivity$2  reason: invalid class name */
    class AnonymousClass2 extends ApiObserver<BaseResponse<Object>> {
        public final void a(BaseResponse baseResponse) {
        }

        public final void b(BaseResponse baseResponse) {
        }
    }

    public static void B(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        intent.putExtra("isNeedCheckAndJumpLogin", false);
        if (!TextUtils.isEmpty((CharSequence) null)) {
            intent.putExtra("paramsStr", (String) null);
        }
        if (!TextUtils.isEmpty((CharSequence) null)) {
            intent.putExtra("openUrl", (String) null);
        }
        context.startActivity(intent);
    }

    public static void C(Context context, String str, boolean z) {
        Intent intent = new Intent(context, HomeActivity.class);
        intent.putExtra("isNeedCheckAndJumpLogin", z);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("paramsStr", str);
        }
        context.startActivity(intent);
    }

    public final void A() {
        if (this.n == null) {
            if (this.o == null) {
                this.o = System.currentTimeMillis() + "" + UUID.randomUUID().toString().hashCode();
            }
            CommonWebFragment e = CommonWebFragment.e(Domain.a(), this.o, true);
            this.n = e;
            getSupportFragmentManager().beginTransaction().replace(R.id.vp_frame_layout, e).commitAllowingStateLoss();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void distributeEvent(EventHomeAct eventHomeAct) {
        Boolean bool = eventHomeAct.f525a;
        String str = eventHomeAct.b;
        if (bool != null && bool.booleanValue()) {
            this.l = str;
            A();
        } else if (!TextUtils.isEmpty(str)) {
            this.l = str;
            CommonWebFragment commonWebFragment = this.n;
            if (commonWebFragment != null) {
                commonWebFragment.c(str);
                this.l = null;
            }
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        CommonWebFragment commonWebFragment;
        super.onActivityResult(i2, i3, intent);
        if ((i3 == -1 || i2 == 800) && (commonWebFragment = this.n) != null) {
            commonWebFragment.onActivityResult(i2, i3, intent);
        }
    }

    public final void onBackPressed() {
        z();
    }

    /* JADX WARNING: type inference failed for: r5v1, types: [com.ktakilat.loan.main.HomePresenter, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r0v12, types: [io.reactivex.Observer, java.lang.Object] */
    public final void onCreate(Bundle bundle) {
        boolean containsKey;
        Intent intent = getIntent();
        if (intent != null) {
            this.k = intent.getBooleanExtra("isNeedCheckAndJumpLogin", false);
            this.l = intent.getStringExtra("paramsStr");
            this.m = intent.getStringExtra("openUrl");
            if (BaseApplication.f.booleanValue()) {
                BaseApplication.f = Boolean.valueOf(intent.getBooleanExtra("finishAll", true));
            }
        }
        super.onCreate(bundle);
        setContentView((View) ActivityHomeHomeBinding.inflate(getLayoutInflater()).getRoot());
        if (bundle != null) {
            this.o = bundle.getString("mCreateKey");
        }
        this.i = new Object();
        A();
        new Thread(new Runnable() {
            public final void run() {
                DeviceUtil.a(HomeActivity.this);
            }
        }).start();
        EventBus b = EventBus.b();
        synchronized (b) {
            containsKey = b.b.containsKey(this);
        }
        if (!containsKey) {
            EventBus.b().i(this);
        }
        if (!TextUtils.isEmpty(this.m)) {
            CommonWebActivity.C(this, (String) null, this.m, false, 0);
        }
        if (Build.VERSION.SDK_INT >= 33) {
            KtaCollect.n_request_permission("Post_Notifications", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            new RxPermissions(this).b("android.permission.POST_NOTIFICATIONS").subscribe(new Object());
        }
    }

    public final void onDestroy() {
        boolean containsKey;
        EventBus b = EventBus.b();
        synchronized (b) {
            containsKey = b.b.containsKey(this);
        }
        if (containsKey) {
            EventBus.b().k(this);
        }
        if (this.n != null) {
            try {
                getSupportFragmentManager().beginTransaction().remove(this.n).commit();
                this.n = null;
            } catch (Exception unused) {
            }
        }
        super.onDestroy();
    }

    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        z();
        return true;
    }

    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            this.k = intent.getBooleanExtra("isNeedCheckAndJumpLogin", false);
            String stringExtra = intent.getStringExtra("paramsStr");
            String stringExtra2 = intent.getStringExtra("openUrl");
            this.m = stringExtra2;
            if (!TextUtils.isEmpty(stringExtra2)) {
                CommonWebActivity.C(this, (String) null, this.m, false, 0);
            }
            if (TextUtils.isEmpty(this.l) || !this.l.equals(stringExtra)) {
                this.l = stringExtra;
                if (this.n != null) {
                    if (!TextUtils.isEmpty(stringExtra)) {
                        this.n.c(this.l);
                    } else {
                        this.n.i(true);
                    }
                    this.l = null;
                }
            }
        }
    }

    public final void onResume() {
        super.onResume();
        if (this.k) {
            this.i.getClass();
            KtakilatApplication.m.getClass();
            if (!KtakilatApplication.h()) {
                this.k = false;
                LoginRegistUtil.a(this);
            }
        }
        KtakilatApplication.m.getClass();
        if (KtakilatApplication.h() && TextUtils.isEmpty(Config.f495a)) {
            FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new t9(1));
            FirebaseAnalytics.getInstance(this).getAppInstanceId().addOnCompleteListener(new a(this));
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putString("mCreateKey", this.o);
        CommonWebFragment commonWebFragment = this.n;
        if (commonWebFragment != null) {
            commonWebFragment.k();
        }
        super.onSaveInstanceState(bundle);
    }

    public final String p() {
        String str;
        int i2;
        CommonWebFragment commonWebFragment = this.n;
        if (commonWebFragment != null) {
            CommonWebView commonWebView = commonWebFragment.e;
            if (commonWebView != null) {
                str = commonWebView.getUrl();
            } else {
                str = commonWebFragment.f;
            }
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return "Home";
        }
        int lastIndexOf = str.lastIndexOf("?");
        int lastIndexOf2 = str.lastIndexOf(RemoteSettings.FORWARD_SLASH_STRING);
        if (lastIndexOf <= -1 || lastIndexOf2 <= -1 || (i2 = lastIndexOf2 + 1) >= lastIndexOf) {
            return "Home";
        }
        return str.substring(i2, lastIndexOf);
    }

    public final String q() {
        String str = this.l;
        this.l = null;
        return str;
    }

    public final void t() {
        CommonWebViewSetting commonWebViewSetting;
        CommonWebFragment commonWebFragment = this.n;
        if (commonWebFragment != null && (commonWebViewSetting = commonWebFragment.m) != null && commonWebViewSetting.g != null) {
            commonWebViewSetting.b();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void thirdErrorEvent(EventThirdError eventThirdError) {
        JsonObject jsonObject = new JsonObject();
        eventThirdError.getClass();
        jsonObject.addProperty(FirebaseAnalytics.Param.CONTENT, (String) null);
        jsonObject.addProperty("type", (String) null);
        jsonObject.addProperty("sub_type", (String) null);
        PhoneUploadUtil.h(jsonObject.toString());
    }

    public final void z() {
        CommonWebFragment commonWebFragment = this.n;
        if (commonWebFragment != null && commonWebFragment.d()) {
            return;
        }
        if (System.currentTimeMillis() - this.j > 2000) {
            ToastUtil.d(this, getResources().getString(R.string.home_back_toast));
            this.j = System.currentTimeMillis();
            return;
        }
        finish();
    }
}
