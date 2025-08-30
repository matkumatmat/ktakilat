package androidx.core.app;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.PendingIntentCompat;

public final /* synthetic */ class b implements PendingIntent.OnFinished {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PendingIntentCompat.GatedCallback f41a;

    public /* synthetic */ b(PendingIntentCompat.GatedCallback gatedCallback) {
        this.f41a = gatedCallback;
    }

    public final void onSendFinished(PendingIntent pendingIntent, Intent intent, int i, String str, Bundle bundle) {
        this.f41a.onSendFinished(pendingIntent, intent, i, str, bundle);
    }
}
