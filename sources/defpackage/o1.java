package defpackage;

import android.content.Context;
import android.content.Intent;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Callables;
import com.google.firebase.messaging.ServiceStarter;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import java.util.concurrent.Callable;
import org.apache.commons.lang3.concurrent.Memoizer;

/* renamed from: o1  reason: default package */
public final /* synthetic */ class o1 implements Callable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ o1(int i, Object obj, Object obj2) {
        this.c = i;
        this.d = obj;
        this.e = obj2;
    }

    public final Object call() {
        switch (this.c) {
            case 0:
                return Callables.lambda$threadRenaming$2((Supplier) this.d, (Callable) this.e);
            case 1:
                return ((ConfigCacheClient) this.d).lambda$put$0((ConfigContainer) this.e);
            case 2:
                return Integer.valueOf(ServiceStarter.getInstance().startMessagingService((Context) this.d, (Intent) this.e));
            case 3:
                return ((FirebaseRemoteConfig) this.d).lambda$setConfigSettingsAsync$5((FirebaseRemoteConfigSettings) this.e);
            default:
                return ((Memoizer) this.d).lambda$compute$0(this.e);
        }
    }
}
