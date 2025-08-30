package com.ktakilat.cbase.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.ktakilat.cbase.R;
import com.ktakilat.cbase.ui.BaseApplication;
import com.ktakilat.cbase.ui.LogActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class ToastUtil {

    /* renamed from: a  reason: collision with root package name */
    public static Toast f478a;
    public static final Handler b = new Handler(Looper.getMainLooper());

    public static Activity a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            ArrayList arrayList = ((BaseApplication) context.getApplicationContext()).d;
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    WeakReference weakReference = (WeakReference) arrayList.get(size);
                    if (weakReference != null && weakReference.get() != null && !((Activity) weakReference.get()).isFinishing() && !((Activity) weakReference.get()).isDestroyed()) {
                        return (Activity) weakReference.get();
                    }
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static void b(Context context, int i) {
        if (context != null) {
            try {
                Toast.makeText(context, context.getString(i), 0).show();
            } catch (Exception unused) {
            }
        }
    }

    public static void c(Context context, int i) {
        if (context != null) {
            d(context, context.getString(i));
        }
    }

    public static void d(final Context context, final String str) {
        if (!TextUtils.isEmpty(str)) {
            b.post(new Runnable() {
                public final void run() {
                    Activity a2;
                    Context context = context;
                    String str = str;
                    try {
                        if (!TextUtils.isEmpty(str) && (a2 = ToastUtil.a(context)) != null) {
                            Toast toast = ToastUtil.f478a;
                            if (toast != null) {
                                toast.cancel();
                                ToastUtil.f478a = null;
                            }
                            ToastUtil.f478a = Toast.makeText(context, str, 0);
                            try {
                                TextView textView = new TextView(a2);
                                textView.setTextSize(1, 14.0f);
                                textView.setPadding(Dp2PxUtil.a(a2, 26.0f), Dp2PxUtil.a(a2, 6.0f), Dp2PxUtil.a(a2, 26.0f), Dp2PxUtil.a(a2, 6.0f));
                                textView.setTextColor(-1);
                                textView.setBackgroundResource(R.drawable.bg_toast);
                                textView.setText(str);
                                ToastUtil.f478a.setView(textView);
                            } catch (Exception e) {
                                FirebaseCrashlytics.getInstance().recordException(e);
                                ArrayList arrayList = LogActivity.k;
                            }
                            ToastUtil.f478a.show();
                        }
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }
}
