package com.google.firebase.messaging;

import android.content.Context;
import com.google.android.gms.tasks.OnSuccessListener;

public final /* synthetic */ class g implements OnSuccessListener {
    public final /* synthetic */ Context c;
    public final /* synthetic */ boolean d;

    public /* synthetic */ g(Context context, boolean z) {
        this.c = context;
        this.d = z;
    }

    public final void onSuccess(Object obj) {
        ProxyNotificationPreferences.setProxyRetentionPreferences(this.c, this.d);
    }
}
