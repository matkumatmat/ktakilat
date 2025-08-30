package defpackage;

import androidx.camera.core.impl.SessionConfig;
import androidx.camera.video.VideoCapture;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.HashMap;

/* renamed from: pg  reason: default package */
public final /* synthetic */ class pg implements SynchronizationGuard.CriticalSection, CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ pg(int i, Object obj, Object obj2) {
        this.c = i;
        this.d = obj;
        this.e = obj2;
    }

    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return ((VideoCapture) this.d).lambda$setupSurfaceUpdateNotifier$6((SessionConfig.Builder) this.e, completer);
    }

    public Object execute() {
        switch (this.c) {
            case 0:
                return ((Uploader) this.d).lambda$logAndUpdateState$5((Iterable) this.e);
            default:
                return ((Uploader) this.d).lambda$logAndUpdateState$7((HashMap) this.e);
        }
    }
}
