package defpackage;

import android.content.Context;
import androidx.camera.core.CameraProvider;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.core.processing.concurrent.DualSurfaceProcessor;
import androidx.camera.extensions.ExtensionsManager;
import androidx.camera.extensions.internal.ClientVersion;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsTasks;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.lang3.Functions;
import org.apache.commons.lang3.function.FailableBiConsumer;
import org.apache.commons.lang3.function.FailableBiFunction;
import org.apache.commons.lang3.function.FailableBiPredicate;
import org.apache.commons.lang3.function.FailableBooleanSupplier;
import org.apache.commons.lang3.function.FailableRunnable;
import org.apache.commons.lang3.function.FailableSupplier;

/* renamed from: g4  reason: default package */
public final /* synthetic */ class g4 implements Continuation, SynchronizationGuard.CriticalSection, CallbackToFutureAdapter.Resolver, FailableBooleanSupplier, FailableRunnable, FailableSupplier, Functions.FailableRunnable, Functions.FailableSupplier {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    public /* synthetic */ g4(Object obj, int i, Object obj2, Object obj3) {
        this.c = i;
        this.d = obj;
        this.e = obj2;
        this.f = obj3;
    }

    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.c) {
            case 3:
                return ((DefaultSurfaceProcessor) this.d).lambda$initGlRenderer$10((DynamicRange) this.e, (Map) this.f, completer);
            case 4:
                return ((DualSurfaceProcessor) this.d).lambda$initGlRenderer$6((DynamicRange) this.e, (Map) this.f, completer);
            default:
                return ExtensionsManager.lambda$getInstanceAsync$0((ClientVersion) this.d, (Context) this.e, (CameraProvider) this.f, completer);
        }
    }

    public Object execute() {
        return ((DefaultScheduler) this.d).lambda$schedule$0((TransportContext) this.e, (EventInternal) this.f);
    }

    public Object get() {
        switch (this.c) {
            case 8:
                return ((FailableBiFunction) this.d).apply(this.e, this.f);
            default:
                return ((Functions.FailableBiFunction) this.d).apply(this.e, this.f);
        }
    }

    public boolean getAsBoolean() {
        switch (this.c) {
            case 6:
                return ((FailableBiPredicate) this.d).test(this.e, this.f);
            default:
                return ((Functions.FailableBiPredicate) this.d).test(this.e, this.f);
        }
    }

    public void run() {
        switch (this.c) {
            case 7:
                ((FailableBiConsumer) this.d).accept(this.e, this.f);
                return;
            default:
                ((Functions.FailableBiConsumer) this.d).accept(this.e, this.f);
                return;
        }
    }

    public Object then(Task task) {
        switch (this.c) {
            case 0:
                return ((ConfigRealtimeHttpClient) this.d).lambda$createRealtimeConnection$0((Task) this.e, (Task) this.f, task);
            case 1:
                return CrashlyticsTasks.lambda$race$0((TaskCompletionSource) this.d, (AtomicBoolean) this.e, (CancellationTokenSource) this.f, task);
            default:
                return ((FirebaseRemoteConfig) this.d).lambda$activate$2((Task) this.e, (Task) this.f, task);
        }
    }
}
