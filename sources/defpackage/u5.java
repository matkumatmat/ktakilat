package defpackage;

import android.app.NotificationChannel;
import android.app.job.JobWorkItem;
import android.content.Intent;
import android.graphics.ColorSpace;

/* renamed from: u5  reason: default package */
public abstract /* synthetic */ class u5 {
    public static /* synthetic */ NotificationChannel e(String str) {
        return new NotificationChannel("com.google.android.gms.availability", str, 4);
    }

    public static /* synthetic */ JobWorkItem g(Intent intent) {
        return new JobWorkItem(intent);
    }

    public static /* bridge */ /* synthetic */ ColorSpace i(Object obj) {
        return (ColorSpace) obj;
    }
}
