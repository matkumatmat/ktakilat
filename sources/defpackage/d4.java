package defpackage;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FcmBroadcastProcessor;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;

/* renamed from: d4  reason: default package */
public final /* synthetic */ class d4 implements SuccessContinuation, Continuation {
    public final /* synthetic */ boolean c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ d4(Context context, Intent intent, boolean z) {
        this.d = context;
        this.e = intent;
        this.c = z;
    }

    public Task then(Object obj) {
        return ((ConfigCacheClient) this.d).lambda$put$1(this.c, (ConfigContainer) this.e, (Void) obj);
    }

    public /* synthetic */ d4(ConfigCacheClient configCacheClient, boolean z, ConfigContainer configContainer) {
        this.d = configCacheClient;
        this.c = z;
        this.e = configContainer;
    }

    public Object then(Task task) {
        return FcmBroadcastProcessor.lambda$startMessagingService$2((Context) this.d, (Intent) this.e, this.c, task);
    }
}
