package com.ktakilat.loan.login_gesture;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.AppEventsConstants;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.cbase.utils.PhoneValidator;
import com.ktakilat.cbase.utils.location.LocationUtils;
import com.ktakilat.loan.R;
import com.ktakilat.loan.global.AppKv;
import com.ktakilat.loan.login_face.BaseLoginActivity;
import com.ktakilat.loan.login_gesture.LoginGestureContact;
import com.ktakilat.loan.weiget.CommonPopUtil;
import com.ktakilat.loan.weiget.GestureUtil;
import com.ktakilat.loan.weiget.LoginUtil;
import com.ktakilat.loan.weiget.PhoneUploadUtil;
import com.ktakilat.loan.weiget.TongDunEnum;
import com.ktakilat.loan.weiget.gesture.OnPatternChangeListener;
import com.pendanaan.kta.databinding.ActivityGestureLoginBinding;
import java.util.ArrayList;
import java.util.HashMap;

@SuppressLint({"NonConstantResourceId"})
public class LoginGestureActivity extends BaseLoginActivity implements LoginGestureContact.View {
    public static final /* synthetic */ int s = 0;
    public LoginGesturePresenter n;
    public GestureUtil o;
    public boolean p;
    public String q;
    public ActivityGestureLoginBinding r;

    public static void C(Context context, String str, boolean z) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent(context, LoginGestureActivity.class);
            intent.putExtra("mobile", str);
            intent.putExtra("initSend", z);
            context.startActivity(intent);
        }
    }

    public final void B() {
        this.k = false;
        super.B();
    }

    public final void D(Intent intent) {
        if (intent != null) {
            this.q = intent.getStringExtra("mobile");
            int i = 0;
            this.p = intent.getBooleanExtra("initSend", false);
            this.r.mobileTv.setText(PhoneValidator.a(this.q));
            TextView textView = this.r.tipTv;
            if (AppKv.f()) {
                i = 8;
            }
            textView.setVisibility(i);
        }
        new CommonPopUtil(this).b(CommonPopUtil.PageType.LoginGesture, (CommonPopUtil.CheckCallback) null);
    }

    /* JADX WARNING: type inference failed for: r3v13, types: [java.lang.Object, com.ktakilat.loan.login_gesture.LoginGesturePresenter] */
    public final void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        ActivityGestureLoginBinding inflate = ActivityGestureLoginBinding.inflate(getLayoutInflater());
        this.r = inflate;
        setContentView((View) inflate.getRoot());
        D(getIntent());
        if (!AppKv.f()) {
            str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
        } else {
            str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        KtaCollect.n_login_page_exposure(str, ExifInterface.GPS_MEASUREMENT_3D);
        this.o = new GestureUtil((BaseActivity) this);
        this.r.pageTitle.title.setText(R.string.application_name);
        this.r.touchView.setOnPatternChangedListener(new OnPatternChangeListener() {
            public final void a(ArrayList arrayList) {
                double d;
                LoginGestureActivity loginGestureActivity = LoginGestureActivity.this;
                if (arrayList == null || arrayList.size() < 4) {
                    loginGestureActivity.r.statusTv.setVisibility(0);
                    return;
                }
                HashMap b = LocationUtils.b(loginGestureActivity);
                double d2 = 0.0d;
                if (b.get("lat") == null) {
                    d = 0.0d;
                } else {
                    d = ((Double) b.get("lat")).doubleValue();
                }
                if (b.get("lon") != null) {
                    d2 = ((Double) b.get("lon")).doubleValue();
                }
                loginGestureActivity.o.k(loginGestureActivity.q, arrayList, d, d2, new b(this));
            }

            public final void onStart() {
                LoginGestureActivity.this.r.statusTv.setVisibility(4);
            }
        });
        ? obj = new Object();
        obj.f516a = this;
        obj.b = new LoginUtil(this);
        this.n = obj;
        this.r.pageTitle.backward.setOnClickListener(new t0(this, 11));
        this.r.moreTv.setOnClickListener(new a(this));
    }

    public final void onDestroy() {
        LoginGesturePresenter loginGesturePresenter = this.n;
        if (loginGesturePresenter != null) {
            loginGesturePresenter.getClass();
        }
        super.onDestroy();
    }

    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        D(intent);
    }

    public final void onResume() {
        super.onResume();
        PhoneUploadUtil.a(TongDunEnum.USER_LOGIN_SUC);
    }
}
