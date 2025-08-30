package defpackage;

import android.content.res.AssetFileDescriptor;
import com.google.common.util.concurrent.Callables;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import com.google.firebase.remoteconfig.internal.ConfigStorageClient;
import java.util.concurrent.Callable;
import org.apache.commons.lang3.Functions;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableCallable;

/* renamed from: q1  reason: default package */
public final /* synthetic */ class q1 implements Callable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ q1(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    public final Object call() {
        switch (this.c) {
            case 0:
                return Callables.lambda$returning$0(this.d);
            case 1:
                return ((ConfigStorageClient) this.d).read();
            case 2:
                return ((CrashlyticsCore) this.d).lambda$checkForPreviousCrash$10();
            case 3:
                return Failable.call((FailableCallable) this.d);
            case 4:
                return ((FirebaseInstallations) this.d).deleteFirebaseInstallationId();
            case 5:
                return Functions.call((Functions.FailableCallable) this.d);
            case 6:
                return ((RemoteConfigComponent) this.d).getDefault();
            default:
                return (AssetFileDescriptor) this.d;
        }
    }
}
