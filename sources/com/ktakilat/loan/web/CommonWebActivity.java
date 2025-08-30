package com.ktakilat.loan.web;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.android.installreferrer.api.InstallReferrerClient;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.cbase.ui.BaseApplication;
import com.ktakilat.cbase.utils.BarUtil;
import com.ktakilat.cbase.weight.CommonWebView;
import com.ktakilat.loan.KtakilatApplication;
import com.ktakilat.loan.R;
import com.ktakilat.loan.global.Domain;
import com.ktakilat.loan.utils.StatusBarTool;
import com.ktakilat.loan.web.CommonWebContact;
import com.ktakilat.loan.webtool.CommonWebViewSetting;
import com.pendanaan.kta.databinding.CActivityCommonWebviewBinding;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class CommonWebActivity extends BaseActivity implements CommonWebContact.View {
    public static final /* synthetic */ int p = 0;
    public CommonWebPresenter i;
    public String j;
    public String k;
    public Integer l;
    public CommonWebFragment m;
    public String n;
    public CActivityCommonWebviewBinding o;

    public static void C(Activity activity, String str, String str2, boolean z, int i2) {
        InstallReferrerClient installReferrerClient = KtakilatApplication.j;
        ArrayList arrayList = BaseApplication.e.d;
        CommonWebActivity commonWebActivity = null;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference != null && weakReference.get() != null && !((Activity) weakReference.get()).isFinishing() && !((Activity) weakReference.get()).isDestroyed()) {
                    if (commonWebActivity != null) {
                        ((Activity) weakReference.get()).finish();
                    } else if ((weakReference.get() instanceof CommonWebActivity) && ((CommonWebActivity) weakReference.get()).k.equals(str2)) {
                        commonWebActivity = (CommonWebActivity) weakReference.get();
                    }
                }
            }
        }
        if (commonWebActivity != null) {
            commonWebActivity.k = str2;
            CommonWebFragment A = commonWebActivity.A(str2);
            commonWebActivity.m = A;
            commonWebActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, A).commitAllowingStateLoss();
            if (TextUtils.isEmpty(str) || "null".equalsIgnoreCase(str)) {
                commonWebActivity.o.pageTitle.title.setText(R.string.application_name);
            } else {
                commonWebActivity.o.pageTitle.title.setText(str);
            }
        } else {
            Intent intent = new Intent(activity, CommonWebActivity.class);
            intent.putExtra("title", str);
            intent.putExtra("url", str2);
            intent.putExtra("isShowTitle", false);
            intent.putExtra("showStatusBar", z);
            intent.putExtra("SURFACE_COLOR", i2);
            activity.startActivityForResult(intent, 11000);
        }
    }

    public final CommonWebFragment A(String str) {
        if (this.n == null) {
            this.n = System.currentTimeMillis() + "" + UUID.randomUUID().toString().hashCode();
        }
        CommonWebFragment e = CommonWebFragment.e(str, this.n, false);
        e.k = new h3(this);
        return e;
    }

    public final void B() {
        LinearLayout root = this.o.getRoot();
        int intExtra = getIntent().getIntExtra("SURFACE_COLOR", 0);
        this.l = Integer.valueOf(intExtra);
        if (intExtra != 0) {
            ColorDrawable colorDrawable = new ColorDrawable(this.l.intValue());
            if (Build.VERSION.SDK_INT >= 35) {
                root.setBackground(colorDrawable);
            } else {
                try {
                    Window window = getWindow();
                    window.addFlags(Integer.MIN_VALUE);
                    window.setStatusBarColor(0);
                    window.setBackgroundDrawable(colorDrawable);
                } catch (Exception unused) {
                }
            }
            StatusBarTool.Companion.a(getWindow(), this.o.getRoot());
        } else if (Build.VERSION.SDK_INT >= 35) {
            root.setBackgroundResource(R.drawable.gradient_color_edge_to_edge);
        } else {
            BarUtil.a(this, R.drawable.gradient_color_edge_to_edge);
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        CommonWebFragment commonWebFragment;
        super.onActivityResult(i2, i3, intent);
        if ((i3 == -1 || i2 == 800) && (commonWebFragment = this.m) != null) {
            commonWebFragment.onActivityResult(i2, i3, intent);
        }
    }

    public final void onBackPressed() {
        z(true);
    }

    /* JADX WARNING: type inference failed for: r0v10, types: [com.ktakilat.loan.web.CommonWebPresenter, java.lang.Object] */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) this.o.getRoot());
        this.o.pageTitle.backward.setOnClickListener(new t0(this, 2));
        if (getIntent() == null) {
            finish();
            return;
        }
        if (bundle != null) {
            this.n = bundle.getString("mCreateKey");
        }
        this.j = getIntent().getStringExtra("title");
        this.k = getIntent().getStringExtra("url");
        int i2 = 0;
        this.l = Integer.valueOf(getIntent().getIntExtra("SURFACE_COLOR", 0));
        String str = this.k;
        if (str != null && !str.startsWith("http")) {
            if (this.k.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                this.k = Domain.a() + this.k.substring(1);
            } else {
                this.k = Domain.a() + this.k;
            }
        }
        boolean booleanExtra = getIntent().getBooleanExtra("isShowTitle", false);
        this.i = new Object();
        if (!getSupportFragmentManager().getFragments().isEmpty()) {
            this.m = (CommonWebFragment) getSupportFragmentManager().getFragments().get(0);
        }
        if (this.m == null) {
            CommonWebFragment A = A(this.k);
            this.m = A;
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, A).commitAllowingStateLoss();
        }
        TextView textView = this.o.pageTitle.title;
        if (!booleanExtra) {
            i2 = 8;
        }
        textView.setVisibility(i2);
        if (TextUtils.isEmpty(this.j) || "null".equalsIgnoreCase(this.j)) {
            this.o.pageTitle.title.setText(R.string.application_name);
        } else {
            this.o.pageTitle.title.setText(this.j);
        }
        if (this.l.intValue() != 0) {
            this.m.l = this.l;
        }
    }

    public final void onDestroy() {
        CommonWebPresenter commonWebPresenter = this.i;
        if (commonWebPresenter != null) {
            commonWebPresenter.getClass();
        }
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EventWebAct eventWebAct) {
        String str = this.k;
        eventWebAct.getClass();
        str.equals((Object) null);
    }

    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putString("mCreateKey", this.n);
        CommonWebFragment commonWebFragment = this.m;
        if (commonWebFragment != null) {
            commonWebFragment.k();
        }
        super.onSaveInstanceState(bundle);
    }

    public final String p() {
        String str;
        int i2;
        CommonWebFragment commonWebFragment = this.m;
        if (commonWebFragment != null) {
            CommonWebView commonWebView = commonWebFragment.e;
            if (commonWebView != null) {
                str = commonWebView.getUrl();
            } else {
                str = commonWebFragment.f;
            }
        } else {
            str = this.k;
        }
        if (TextUtils.isEmpty(str)) {
            return "empty";
        }
        int lastIndexOf = str.lastIndexOf("?");
        int lastIndexOf2 = str.lastIndexOf(RemoteSettings.FORWARD_SLASH_STRING);
        if (lastIndexOf <= -1 || lastIndexOf2 <= -1 || (i2 = lastIndexOf2 + 1) >= lastIndexOf) {
            return str;
        }
        return str.substring(i2, lastIndexOf);
    }

    public final void t() {
        CommonWebViewSetting commonWebViewSetting;
        CommonWebFragment commonWebFragment = this.m;
        if (commonWebFragment != null && (commonWebViewSetting = commonWebFragment.m) != null && commonWebViewSetting.g != null) {
            commonWebViewSetting.b();
        }
    }

    public final void v() {
    }

    public final void w() {
        this.o = CActivityCommonWebviewBinding.inflate(getLayoutInflater());
    }

    public final void x() {
        if (Build.VERSION.SDK_INT >= 35) {
            ViewCompat.setOnApplyWindowInsetsListener(this.o.getRoot(), new h3(this));
        } else {
            B();
        }
    }

    public final void z(boolean z) {
        if (!z) {
            finish();
            return;
        }
        CommonWebFragment commonWebFragment = this.m;
        if (commonWebFragment != null && !commonWebFragment.d()) {
            finish();
        }
    }
}
