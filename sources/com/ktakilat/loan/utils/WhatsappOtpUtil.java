package com.ktakilat.loan.utils;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ktakilat/loan/utils/WhatsappOtpUtil;", "", "Companion", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WhatsappOtpUtil {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/ktakilat/loan/utils/WhatsappOtpUtil$Companion;", "", "", "MAIN_APP", "Ljava/lang/String;", "SUB_APP", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public static boolean a(Context context, String str) {
            try {
                Intent intent = new Intent();
                intent.setPackage(str);
                intent.setAction("com.whatsapp.otp.OTP_REQUESTED");
                List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
                Intrinsics.checkNotNullExpressionValue(queryBroadcastReceivers, "queryBroadcastReceivers(...)");
                return !queryBroadcastReceivers.isEmpty();
            } catch (Exception unused) {
                return false;
            }
        }

        public static void b(Context context, String str) {
            int i;
            try {
                if (Build.VERSION.SDK_INT >= 31) {
                    i = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                } else {
                    i = 0;
                }
                PendingIntent activity = PendingIntent.getActivity(context.getApplicationContext(), 0, new Intent(), i);
                Intent intent = new Intent();
                intent.setPackage(str);
                intent.setAction("com.whatsapp.otp.OTP_REQUESTED");
                Bundle extras = intent.getExtras();
                if (extras == null) {
                    extras = new Bundle();
                }
                extras.putParcelable("_ci_", activity);
                intent.putExtras(extras);
                context.getApplicationContext().sendBroadcast(intent);
            } catch (Exception unused) {
            }
        }
    }
}
