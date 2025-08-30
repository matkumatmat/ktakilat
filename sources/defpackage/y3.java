package defpackage;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import com.google.firebase.inject.Provider;

/* renamed from: y3  reason: default package */
public final /* synthetic */ class y3 implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f368a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ y3(int i, Object obj, Object obj2) {
        this.f368a = i;
        this.b = obj;
        this.c = obj2;
    }

    public final Object get() {
        switch (this.f368a) {
            case 0:
                return ((ComponentRuntime) this.b).lambda$discoverComponents$0((Component) this.c);
            case 1:
                return DefaultHeartBeatController.lambda$new$2((Context) this.b, (String) this.c);
            default:
                return ((FirebaseApp) this.b).lambda$new$0((Context) this.c);
        }
    }
}
