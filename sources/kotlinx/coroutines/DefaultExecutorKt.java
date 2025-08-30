package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.internal.MainDispatchersKt;
import kotlinx.coroutines.internal.SystemPropsKt;
import kotlinx.coroutines.scheduling.DefaultScheduler;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"kotlinx-coroutines-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DefaultExecutorKt {

    /* renamed from: a  reason: collision with root package name */
    public static final Delay f766a;

    static {
        boolean z;
        Delay delay;
        String c = SystemPropsKt.c("kotlinx.coroutines.main.delay");
        if (c != null) {
            z = Boolean.parseBoolean(c);
        } else {
            z = false;
        }
        if (!z) {
            delay = DefaultExecutor.k;
        } else {
            DefaultScheduler defaultScheduler = Dispatchers.f767a;
            MainCoroutineDispatcher mainCoroutineDispatcher = MainDispatcherLoader.f801a;
            if (MainDispatchersKt.a(mainCoroutineDispatcher) || !(mainCoroutineDispatcher instanceof Delay)) {
                delay = DefaultExecutor.k;
            } else {
                delay = (Delay) mainCoroutineDispatcher;
            }
        }
        f766a = delay;
    }
}
