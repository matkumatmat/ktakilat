package defpackage;

import android.app.NotificationChannel;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import com.google.firebase.messaging.CommonNotificationBuilder;
import java.time.Duration;

/* renamed from: c3  reason: default package */
public abstract /* synthetic */ class c3 {
    public static /* synthetic */ NotificationChannel h(String str) {
        return new NotificationChannel(CommonNotificationBuilder.FCM_FALLBACK_NOTIFICATION_CHANNEL, str, 3);
    }

    public static /* bridge */ /* synthetic */ Duration o(Object obj) {
        return (Duration) obj;
    }

    public static /* bridge */ /* synthetic */ boolean t(Drawable drawable) {
        return drawable instanceof AdaptiveIconDrawable;
    }
}
