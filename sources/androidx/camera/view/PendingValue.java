package androidx.camera.view;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Pair;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

class PendingValue<T> {
    @Nullable
    private Pair<CallbackToFutureAdapter.Completer<Void>, T> mCompleterAndValue;

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$setValue$0(Object obj, CallbackToFutureAdapter.Completer completer) throws Exception {
        Pair<CallbackToFutureAdapter.Completer<Void>, T> pair = this.mCompleterAndValue;
        if (pair != null) {
            CallbackToFutureAdapter.Completer completer2 = (CallbackToFutureAdapter.Completer) pair.first;
            Objects.requireNonNull(completer2);
            completer2.setCancelled();
        }
        this.mCompleterAndValue = new Pair<>(completer, obj);
        return "PendingValue " + obj;
    }

    @MainThread
    public void propagateIfHasValue(Function<T, ListenableFuture<Void>> function) {
        Threads.checkMainThread();
        Pair<CallbackToFutureAdapter.Completer<Void>, T> pair = this.mCompleterAndValue;
        if (pair != null) {
            CallbackToFutureAdapter.Completer completer = (CallbackToFutureAdapter.Completer) this.mCompleterAndValue.first;
            Objects.requireNonNull(completer);
            Futures.propagate(function.apply(pair.second), completer);
            this.mCompleterAndValue = null;
        }
    }

    @MainThread
    public ListenableFuture<Void> setValue(@NonNull T t) {
        Threads.checkMainThread();
        return CallbackToFutureAdapter.getFuture(new e(0, this, t));
    }
}
