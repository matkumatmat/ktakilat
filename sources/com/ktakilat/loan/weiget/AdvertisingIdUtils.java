package com.ktakilat.loan.weiget;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.ktakilat.cbase.ui.LogActivity;
import com.ktakilat.loan.weiget.dialog.AdvertisingDialog;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class AdvertisingIdUtils {

    /* renamed from: a  reason: collision with root package name */
    public static AdvertisingDialog f581a;
    public static final Handler b = new Handler(Looper.getMainLooper());

    /* renamed from: com.ktakilat.loan.weiget.AdvertisingIdUtils$3  reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        public final void run() {
            AdvertisingDialog advertisingDialog = AdvertisingIdUtils.f581a;
            if (advertisingDialog != null && advertisingDialog.isShowing()) {
                AdvertisingIdUtils.f581a.dismiss();
            }
        }
    }

    public enum ADVERTISING_TYPE {
        NOT_SUPPORT(1),
        NOT_ENABLE(2),
        CAN_USE(3);
        
        public int type;

        /* access modifiers changed from: public */
        ADVERTISING_TYPE(int i) {
            this.type = i;
        }
    }

    /* JADX WARNING: type inference failed for: r4v3, types: [java.lang.Object, java.lang.Runnable] */
    /* JADX WARNING: type inference failed for: r4v4, types: [java.lang.Object, java.lang.Runnable] */
    /* JADX WARNING: type inference failed for: r4v8, types: [java.lang.Object, java.lang.Runnable] */
    public static boolean a(final Activity activity) {
        Handler handler = b;
        int i = b(activity).type;
        if (i == ADVERTISING_TYPE.CAN_USE.type) {
            handler.post(new Object());
            ArrayList arrayList = LogActivity.k;
            return true;
        } else if (i == ADVERTISING_TYPE.NOT_ENABLE.type) {
            handler.post(new Runnable() {
                public final void run() {
                    Activity activity;
                    if (AdvertisingIdUtils.f581a == null && (activity = activity) != null && !activity.isFinishing() && !activity.isDestroyed()) {
                        AdvertisingDialog advertisingDialog = new AdvertisingDialog(activity);
                        AdvertisingIdUtils.f581a = advertisingDialog;
                        advertisingDialog.setCancelable(false);
                        AdvertisingIdUtils.f581a.setCanceledOnTouchOutside(false);
                        AdvertisingIdUtils.f581a.e = new AdvertisingDialog.OnClickListener(activity) {

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ Activity f582a;

                            {
                                this.f582a = r1;
                            }

                            public final void a() {
                                AdvertisingIdUtils.f581a.dismiss();
                                AdvertisingIdUtils.f581a = null;
                                this.f582a.finish();
                            }

                            public final void b() {
                                AdvertisingIdUtils.f581a.dismiss();
                                AdvertisingIdUtils.f581a = null;
                                try {
                                    this.f582a.startActivity(new Intent("com.google.android.gms.settings.ADS_PRIVACY"));
                                } catch (Exception unused) {
                                    ArrayList arrayList = LogActivity.k;
                                }
                            }
                        };
                        if (!activity.isDestroyed() && !activity.isFinishing()) {
                            AdvertisingIdUtils.f581a.show();
                        }
                    }
                }
            });
            ArrayList arrayList2 = LogActivity.k;
            return false;
        } else if (i == ADVERTISING_TYPE.NOT_SUPPORT.type) {
            handler.post(new Object());
            ArrayList arrayList3 = LogActivity.k;
            return true;
        } else {
            handler.post(new Object());
            return true;
        }
    }

    public static ADVERTISING_TYPE b(ContextWrapper contextWrapper) {
        try {
            if (AdvertisingIdClient.getAdvertisingIdInfo(contextWrapper).isLimitAdTrackingEnabled()) {
                return ADVERTISING_TYPE.NOT_ENABLE;
            }
            return ADVERTISING_TYPE.CAN_USE;
        } catch (Exception e) {
            Throwable th = e;
            while (true) {
                if (th == null) {
                    StringWriter stringWriter = new StringWriter();
                    PrintWriter printWriter = new PrintWriter(stringWriter);
                    e.printStackTrace(printWriter);
                    printWriter.flush();
                    stringWriter.toString();
                    break;
                } else if (th instanceof UnknownHostException) {
                    break;
                } else {
                    th = th.getCause();
                }
            }
            ArrayList arrayList = LogActivity.k;
            return ADVERTISING_TYPE.NOT_SUPPORT;
        }
    }
}
