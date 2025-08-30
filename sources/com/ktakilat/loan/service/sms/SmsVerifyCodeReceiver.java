package com.ktakilat.loan.service.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.places.model.PlaceFields;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/ktakilat/loan/service/sms/SmsVerifyCodeReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Companion", "CallBack", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SmsVerifyCodeReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public CallBack f544a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ktakilat/loan/service/sms/SmsVerifyCodeReceiver$CallBack;", "", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface CallBack {
        void a(String str);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/ktakilat/loan/service/sms/SmsVerifyCodeReceiver$Companion;", "", "", "TAG", "Ljava/lang/String;", "ACTION_VERIFY_CODE", "EXTRA_VERIFY_CODE", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
    }

    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, PlaceFields.CONTEXT);
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.ktakilat.loan.service.sms.action.verify.code");
            LocalBroadcastManager.getInstance(context).registerReceiver(this, intentFilter);
        } catch (Exception unused) {
        }
    }

    public final void onReceive(Context context, Intent intent) {
        CallBack callBack;
        if (intent != null) {
            intent.getAction();
            if (Intrinsics.a(intent.getAction(), "com.ktakilat.loan.service.sms.action.verify.code")) {
                String stringExtra = intent.getStringExtra("com.ktakilat.loan.service.sms.extra.verify.code");
                if (stringExtra == null) {
                    stringExtra = "";
                }
                "onReceive code = ".concat(stringExtra);
                if (!TextUtils.isEmpty(stringExtra) && (callBack = this.f544a) != null) {
                    callBack.a(stringExtra);
                }
            }
        }
    }
}
