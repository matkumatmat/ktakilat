package defpackage;

import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.inject.Provider;

/* renamed from: w3  reason: default package */
public final /* synthetic */ class w3 implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f363a;
    public final /* synthetic */ ComponentRegistrar b;

    public /* synthetic */ w3(ComponentRegistrar componentRegistrar, int i) {
        this.f363a = i;
        this.b = componentRegistrar;
    }

    public final Object get() {
        switch (this.f363a) {
            case 0:
                return ComponentRuntime.lambda$toProviders$1(this.b);
            default:
                return ComponentRuntime.Builder.lambda$addComponentRegistrar$0(this.b);
        }
    }
}
