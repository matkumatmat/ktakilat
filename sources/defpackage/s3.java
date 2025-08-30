package defpackage;

import com.google.firebase.FirebaseApp;
import com.google.firebase.components.ComponentDiscovery;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallations;

/* renamed from: s3  reason: default package */
public final /* synthetic */ class s3 implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f355a;
    public final /* synthetic */ Object b;

    public /* synthetic */ s3(Object obj, int i) {
        this.f355a = i;
        this.b = obj;
    }

    public final Object get() {
        switch (this.f355a) {
            case 0:
                return ComponentDiscovery.instantiate((String) this.b);
            default:
                return FirebaseInstallations.lambda$new$0((FirebaseApp) this.b);
        }
    }
}
