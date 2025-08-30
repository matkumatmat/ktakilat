package com.ktakilat.loan.service.sms;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.places.model.PlaceFields;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/ktakilat/loan/service/sms/SmsVerificationService;", "Landroid/app/Service;", "<init>", "()V", "Companion", "SmsBrReceiver", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SmsVerificationService extends Service {
    public static boolean e;
    public SmsRetrieverClient c;
    public SmsBrReceiver d;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/ktakilat/loan/service/sms/SmsVerificationService$Companion;", "", "", "TAG", "Ljava/lang/String;", "", "MAX_TIMEOUT", "J", "ACTION_VERIFY", "ACTION_CANCEL", "", "isRunning", "Z", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public static void a(Context context) {
            Intrinsics.checkNotNullParameter(context, PlaceFields.CONTEXT);
            try {
                Intent intent = new Intent(context, SmsVerificationService.class);
                intent.setAction("com.ktakilat.loan.service.sms.action.verify");
                context.startService(intent);
            } catch (Exception unused) {
            }
        }

        public static void b(Context context) {
            Intrinsics.checkNotNullParameter(context, PlaceFields.CONTEXT);
            if (SmsVerificationService.e) {
                try {
                    Intent intent = new Intent(context, SmsVerificationService.class);
                    intent.setAction("com.ktakilat.loan.service.sms.action.cancel");
                    context.startService(intent);
                } catch (Exception unused) {
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ktakilat/loan/service/sms/SmsVerificationService$SmsBrReceiver;", "Landroid/content/BroadcastReceiver;", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class SmsBrReceiver extends BroadcastReceiver {
        public static final /* synthetic */ int d = 0;

        /* renamed from: a  reason: collision with root package name */
        public final Handler f543a = new Handler(Looper.getMainLooper());
        public final ze b;

        public SmsBrReceiver() {
            this.b = new ze(SmsVerificationService.this, 1);
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent != null) {
                Objects.toString(context);
                if (SmsRetriever.SMS_RETRIEVED_ACTION.equals(intent.getAction())) {
                    this.f543a.removeCallbacks(this.b);
                    Bundle extras = intent.getExtras();
                    Objects.toString(extras);
                    if (extras != null) {
                        Object obj = extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS");
                        Intrinsics.d(obj, "null cannot be cast to non-null type com.google.android.gms.common.api.Status");
                        Status status = (Status) obj;
                        status.toString();
                        int statusCode = status.getStatusCode();
                        if (statusCode == 0) {
                            Object obj2 = extras.get(SmsRetriever.EXTRA_SMS_MESSAGE);
                            Intrinsics.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj2;
                            "onReceive smsMessage = ".concat(str);
                            int s = StringsKt.s(str, "$$ ", 0, false, 6);
                            int s2 = StringsKt.s(str, " ##", 0, false, 6);
                            if (s >= 0 && s2 >= 0) {
                                String substring = str.substring(s + 3, s2);
                                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                                Intent intent2 = new Intent("com.ktakilat.loan.service.sms.action.verify.code");
                                intent2.putExtra("com.ktakilat.loan.service.sms.extra.verify.code", substring);
                                if (context != null) {
                                    LocalBroadcastManager.getInstance(context).sendBroadcast(intent2);
                                }
                            }
                        } else if (statusCode == 15) {
                            boolean z = SmsVerificationService.e;
                            SmsVerificationService smsVerificationService = SmsVerificationService.this;
                            smsVerificationService.getClass();
                            smsVerificationService.stopSelf();
                        }
                    }
                }
            }
        }
    }

    public final IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not a bindable service");
    }

    public final void onCreate() {
        super.onCreate();
        if (this.d == null) {
            this.d = new SmsBrReceiver();
        }
        this.c = SmsRetriever.getClient((Context) this);
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(SmsRetriever.SMS_RETRIEVED_ACTION);
            if (Build.VERSION.SDK_INT >= 33) {
                getApplicationContext().registerReceiver(this.d, intentFilter, 1);
            } else {
                getApplicationContext().registerReceiver(this.d, intentFilter);
            }
        } catch (Exception unused) {
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        e = false;
        if (this.d != null) {
            getApplicationContext().unregisterReceiver(this.d);
            SmsBrReceiver smsBrReceiver = this.d;
            if (smsBrReceiver != null) {
                smsBrReceiver.f543a.removeCallbacks(smsBrReceiver.b);
            }
            this.d = null;
        }
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        String str;
        super.onStartCommand(intent, i, i2);
        Task<Void> task = null;
        if (intent != null) {
            str = intent.getAction();
        } else {
            str = null;
        }
        e = true;
        if (Intrinsics.a(str, "com.ktakilat.loan.service.sms.action.verify")) {
            SmsRetrieverClient smsRetrieverClient = this.c;
            if (smsRetrieverClient != null) {
                task = smsRetrieverClient.startSmsRetriever();
            }
            if (task != null) {
                task.addOnSuccessListener(new lb(new a(this, 8), 18));
            }
            if (task == null) {
                return 3;
            }
            task.addOnFailureListener(new lb(this, 19));
            return 3;
        } else if (!Intrinsics.a(str, "com.ktakilat.loan.service.sms.action.cancel")) {
            return 3;
        } else {
            stopSelf();
            return 3;
        }
    }
}
