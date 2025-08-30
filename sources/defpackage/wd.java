package defpackage;

import com.google.firebase.remoteconfig.ConfigUpdate;
import com.google.firebase.remoteconfig.ktx.RemoteConfigKt$configUpdates$1$registration$1;
import kotlinx.coroutines.channels.ProducerScope;

/* renamed from: wd  reason: default package */
public final /* synthetic */ class wd implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ ProducerScope d;
    public final /* synthetic */ ConfigUpdate e;

    public /* synthetic */ wd(ProducerScope producerScope, ConfigUpdate configUpdate, int i) {
        this.c = i;
        this.d = producerScope;
        this.e = configUpdate;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                RemoteConfigKt$configUpdates$1$registration$1.m6onUpdate$lambda0(this.d, this.e);
                return;
            default:
                com.google.firebase.remoteconfig.RemoteConfigKt$configUpdates$1$registration$1.m5onUpdate$lambda0(this.d, this.e);
                return;
        }
    }
}
