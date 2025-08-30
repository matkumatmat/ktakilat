package defpackage;

import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import java.util.HashMap;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: e4  reason: default package */
public final /* synthetic */ class e4 implements Continuation, CallbackToFutureAdapter.Resolver, SynchronizationGuard.CriticalSection {
    public final /* synthetic */ long c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ e4(ConfigFetchHandler configFetchHandler, long j, HashMap hashMap) {
        this.d = configFetchHandler;
        this.c = j;
        this.e = hashMap;
    }

    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return Futures.lambda$makeTimeoutFuture$3((ListenableFuture) this.d, (ScheduledExecutorService) this.e, this.c, completer);
    }

    public Object execute() {
        return ((Uploader) this.d).lambda$logAndUpdateState$8((TransportContext) this.e, this.c);
    }

    public Object then(Task task) {
        return ((ConfigFetchHandler) this.d).lambda$fetch$0(this.c, (HashMap) this.e, task);
    }

    public /* synthetic */ e4(Object obj, Object obj2, long j) {
        this.d = obj;
        this.e = obj2;
        this.c = j;
    }
}
