package com.ktakilat.cbase.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.ktakilat.cbase.R;
import com.ktakilat.cbase.datacollect.DataCollectManager;
import com.ktakilat.cbase.utils.BarUtil;
import com.ktakilat.cbase.weight.LoadingDialog;
import com.ktakilat.loan.launch.LauncherActivity;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import java.util.ArrayList;

public abstract class BaseActivity extends RxAppCompatActivity {
    public static Typeface g;
    public LoadingDialog d;
    public int e = 0;
    public long f = 0;

    /* renamed from: com.ktakilat.cbase.ui.BaseActivity$2  reason: invalid class name */
    class AnonymousClass2 extends OnSafeClickListener {
        public final void a(View view) {
            ArrayList arrayList = LogActivity.k;
            new Intent((Context) null, LogActivity.class);
            throw null;
        }
    }

    public final void n() {
        int i = this.e;
        if (i <= 0) {
            this.e = 1;
            y();
            return;
        }
        this.e = i + 1;
    }

    public final void o() {
        try {
            LoadingDialog loadingDialog = this.d;
            if (loadingDialog != null && loadingDialog.isShowing()) {
                this.d.dismiss();
            }
        } catch (Exception unused) {
        }
    }

    public void onCreate(Bundle bundle) {
        try {
            if (g == null) {
                g = Typeface.createFromAsset(getAssets(), "OpenSans.ttf");
            }
            LayoutInflaterCompat.setFactory(LayoutInflater.from(this), new u0(this));
        } catch (Exception unused) {
        }
        super.onCreate(bundle);
        w();
        if (BaseApplication.f.booleanValue()) {
            finish();
        }
        LoadingDialog loadingDialog = new LoadingDialog(this);
        this.d = loadingDialog;
        loadingDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i == 4) {
                    BaseActivity.this.t();
                }
                return false;
            }
        });
        int i = Build.VERSION.SDK_INT;
        if (!(i == 26 || i == 27)) {
            setRequestedOrientation(1);
        }
        x();
        v();
    }

    public void onDestroy() {
        this.e = 0;
        o();
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        Bundle bundle = new Bundle();
        bundle.putLong(TypedValues.TransitionType.S_DURATION, System.currentTimeMillis() - this.f);
        String simpleName = getClass().getSimpleName();
        if (!TextUtils.isEmpty(p())) {
            bundle.putString("pageTag", p());
        }
        simpleName.concat("_out");
        DataCollectManager.b("n_" + simpleName + "_out", bundle);
    }

    public void onResume() {
        super.onResume();
        this.f = System.currentTimeMillis();
        String simpleName = getClass().getSimpleName();
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(p())) {
            bundle.putString("pageTag", p());
        }
        simpleName.concat("_in");
        DataCollectManager.b("n_" + simpleName + "_in", bundle);
    }

    public String p() {
        return null;
    }

    public String q() {
        return null;
    }

    public int r() {
        return WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.navigationBars() | WindowInsetsCompat.Type.ime();
    }

    public final boolean s() {
        if (isFinishing() || isDestroyed()) {
            return false;
        }
        return true;
    }

    public final void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.activity_in_right, R.anim.activity_out_left);
    }

    public void t() {
    }

    public final void u() {
        int i = this.e;
        if (i > 0) {
            int i2 = i - 1;
            this.e = i2;
            if (i2 <= 0) {
                o();
            }
        }
    }

    public void v() {
        if (getWindow() != null) {
            if (Build.VERSION.SDK_INT < 35) {
                BarUtil.a(this, R.drawable.main_gradient_color);
            } else if (!(this instanceof LauncherActivity)) {
                BarUtil.a(this, R.drawable.gradient_color_edge_to_edge);
            }
        }
    }

    public void w() {
    }

    public void x() {
        if (Build.VERSION.SDK_INT >= 35 && !(this instanceof LauncherActivity)) {
            ViewCompat.setOnApplyWindowInsetsListener(getWindow().getDecorView(), new u0(this));
        }
    }

    public final void y() {
        try {
            LoadingDialog loadingDialog = this.d;
            if (loadingDialog != null && !loadingDialog.isShowing()) {
                this.d.show();
            }
        } catch (Exception unused) {
        }
    }
}
