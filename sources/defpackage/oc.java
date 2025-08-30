package defpackage;

import android.app.ActivityManager;
import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.content.ContextCompat;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: oc  reason: default package */
public final /* synthetic */ class oc implements Function0 {
    public final /* synthetic */ double c;
    public final /* synthetic */ Context d;

    public /* synthetic */ oc(double d2, Context context) {
        this.c = d2;
        this.d = context;
    }

    public final Object invoke() {
        int i;
        Context context = this.d;
        try {
            Object systemService = ContextCompat.getSystemService(context, ActivityManager.class);
            Intrinsics.c(systemService);
            ActivityManager activityManager = (ActivityManager) systemService;
            if ((context.getApplicationInfo().flags & 1048576) != 0) {
                i = activityManager.getLargeMemoryClass();
            } else {
                i = activityManager.getMemoryClass();
            }
        } catch (Exception unused) {
            i = 256;
        }
        return Long.valueOf((long) (this.c * ((double) (((long) i) * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED))));
    }
}
