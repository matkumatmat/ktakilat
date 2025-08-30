package com.ktakilat.loan.weiget;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.ktakilat.cbase.http.ApiObserver;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.cbase.utils.LogUtil;
import com.ktakilat.cbase.weight.DanaDialog;
import com.ktakilat.loan.KtakilatApplication;
import com.ktakilat.loan.R;
import com.ktakilat.loan.global.H5Kv;
import com.ktakilat.loan.http.AppHttp;
import com.ktakilat.loan.http.version.VersionResp;
import com.trello.rxlifecycle2.LifecycleTransformer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class VersionUtil {

    /* renamed from: a  reason: collision with root package name */
    public static DanaDialog f600a;
    public static final Handler b = new Handler(Looper.getMainLooper());

    public interface VersionCall {
    }

    public static void a(final Runnable runnable, final u4 u4Var) {
        AppHttp.getVersion((LifecycleTransformer<BaseResponse<VersionResp>>) null).subscribe(new ApiObserver<BaseResponse<VersionResp>>() {
            public final void a(BaseResponse baseResponse) {
                VersionUtil.b.postDelayed(new Runnable() {
                    public final void run() {
                        AnonymousClass1 r0 = AnonymousClass1.this;
                        VersionUtil.a(runnable, u4Var);
                    }
                }, 2000);
            }

            public final void b(BaseResponse baseResponse) {
                int i;
                Activity activity;
                Object data = baseResponse.getData();
                Runnable runnable = runnable;
                if (data == null) {
                    runnable.run();
                    return;
                }
                int i2 = 0;
                int i3 = 534;
                try {
                    i3 = Integer.parseInt("5.3.4".replaceAll("\\.", ""));
                    i = Integer.parseInt(((VersionResp) baseResponse.getData()).getStartVersion().replaceAll("\\.", ""));
                    try {
                        i2 = Integer.parseInt(((VersionResp) baseResponse.getData()).getEndVersion().replaceAll("\\.", ""));
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    i = 0;
                }
                if (i3 > i2 || i3 < i) {
                    runnable.run();
                    return;
                }
                u4 u4Var = u4Var;
                boolean isCurForce = ((VersionResp) baseResponse.getData()).isCurForce();
                String content = ((VersionResp) baseResponse.getData()).getContent();
                String downloadLink = ((VersionResp) baseResponse.getData()).getDownloadLink();
                DanaDialog danaDialog = VersionUtil.f600a;
                if (isCurForce || TextUtils.isEmpty(H5Kv.a().f465a.getString("versionDialog", ""))) {
                    if (!isCurForce) {
                        H5Kv.a().b("versionDialog", AppEventsConstants.EVENT_PARAM_VALUE_YES);
                    }
                    ArrayList arrayList = KtakilatApplication.m.d;
                    Runnable runnable2 = u4Var.c;
                    if (arrayList == null || arrayList.isEmpty()) {
                        runnable2.run();
                        return;
                    }
                    int size = arrayList.size() - 1;
                    while (true) {
                        if (size >= 0) {
                            WeakReference weakReference = (WeakReference) arrayList.get(size);
                            if (weakReference != null && weakReference.get() != null && !((Activity) weakReference.get()).isFinishing() && !((Activity) weakReference.get()).isDestroyed()) {
                                activity = (Activity) weakReference.get();
                                break;
                            }
                            size--;
                        } else {
                            activity = null;
                            break;
                        }
                    }
                    if (activity == null || !(activity instanceof BaseActivity)) {
                        runnable2.run();
                        return;
                    }
                    DanaDialog danaDialog2 = VersionUtil.f600a;
                    if (danaDialog2 == null || !danaDialog2.isShowing()) {
                        VersionUtil.f600a = new DanaDialog((BaseActivity) activity);
                    }
                    VersionUtil.f600a.l = activity.getString(R.string.alert_prompt);
                    if (!TextUtils.isEmpty(content)) {
                        VersionUtil.f600a.k = content;
                    } else {
                        VersionUtil.f600a.k = activity.getString(R.string.update_dialog);
                    }
                    VersionUtil.f600a.setCancelable(!isCurForce);
                    DanaDialog danaDialog3 = VersionUtil.f600a;
                    danaDialog3.n = activity.getString(R.string.update_dialog_ok);
                    danaDialog3.m = activity.getString(R.string.update_dialog_cancel);
                    danaDialog3.q = new DanaDialog.OnClickListener(isCurForce, runnable2, downloadLink, activity) {

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ boolean f601a;
                        public final /* synthetic */ Runnable b;
                        public final /* synthetic */ String c;
                        public final /* synthetic */ Activity d;

                        {
                            this.f601a = r1;
                            this.b = r2;
                            this.c = r3;
                            this.d = r4;
                        }

                        public final void a(DanaDialog danaDialog) {
                            danaDialog.dismiss();
                            if (this.f601a) {
                                KtakilatApplication.m.getClass();
                                KtakilatApplication.c();
                                return;
                            }
                            this.b.run();
                        }

                        public final void b(DanaDialog danaDialog) {
                            if (!this.f601a) {
                                danaDialog.dismiss();
                                this.b.run();
                            }
                            String str = this.c;
                            boolean isEmpty = TextUtils.isEmpty(str);
                            Activity activity = this.d;
                            if (isEmpty || str.startsWith("https://play.google.com/store/apps/details?id=") || str.startsWith("market://details?id=") || !str.startsWith("http")) {
                                VersionUtil.b((BaseActivity) activity, str);
                            } else {
                                VersionUtil.c((BaseActivity) activity, str);
                            }
                        }
                    };
                    VersionUtil.f600a.setOnDismissListener(new DialogInterface.OnDismissListener(isCurForce, runnable2) {
                        public final /* synthetic */ boolean c;
                        public final /* synthetic */ Runnable d;

                        {
                            this.c = r1;
                            this.d = r2;
                        }

                        public final void onDismiss(DialogInterface dialogInterface) {
                            if (!this.c) {
                                this.d.run();
                            }
                        }
                    });
                    VersionUtil.f600a.show();
                }
            }
        });
    }

    public static void b(BaseActivity baseActivity, String str) {
        String packageName = baseActivity.getPackageName();
        try {
            if (!TextUtils.isEmpty(str)) {
                if (!str.startsWith("https://play.google.com/store/apps/details?id=")) {
                }
                str = str.substring(str.indexOf("=") + 1);
                packageName = str;
                baseActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName)));
            }
            if (!str.startsWith("market://details?id=")) {
                if (TextUtils.isEmpty(str)) {
                    str = packageName;
                }
                packageName = str;
                baseActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName)));
            }
            str = str.substring(str.indexOf("=") + 1);
            packageName = str;
        } catch (Exception e) {
            new Thread(new gd(e, 10)).start();
        }
        try {
            baseActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName)));
        } catch (ActivityNotFoundException unused) {
            baseActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + packageName)));
        }
    }

    public static void c(BaseActivity baseActivity, String str) {
        try {
            baseActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (Exception e) {
            PhoneUploadUtil.h(LogUtil.b(e));
        }
    }
}
