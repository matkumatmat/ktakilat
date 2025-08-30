package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.LimitedDispatcherKt;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.internal.NamedDispatcher;
import kotlinx.coroutines.scheduling.DefaultScheduler;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class MainCoroutineDispatcher extends CoroutineDispatcher {
    public CoroutineDispatcher limitedParallelism(int i, String str) {
        LimitedDispatcherKt.a(i);
        if (str != null) {
            return new NamedDispatcher(this, str);
        }
        return this;
    }

    public abstract MainCoroutineDispatcher t();

    public String toString() {
        String str;
        MainCoroutineDispatcher mainCoroutineDispatcher;
        DefaultScheduler defaultScheduler = Dispatchers.f767a;
        MainCoroutineDispatcher mainCoroutineDispatcher2 = MainDispatcherLoader.f801a;
        if (this == mainCoroutineDispatcher2) {
            str = "Dispatchers.Main";
        } else {
            try {
                mainCoroutineDispatcher = mainCoroutineDispatcher2.t();
            } catch (UnsupportedOperationException unused) {
                mainCoroutineDispatcher = null;
            }
            if (this == mainCoroutineDispatcher) {
                str = "Dispatchers.Main.immediate";
            } else {
                str = null;
            }
        }
        if (str != null) {
            return str;
        }
        return getClass().getSimpleName() + '@' + DebugStringsKt.a(this);
    }
}
