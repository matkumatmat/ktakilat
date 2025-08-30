package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.InternalCoroutinesApi;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002\u0001\u0001\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/selects/SelectInstance;", "R", "", "Lkotlinx/coroutines/selects/SelectInstanceInternal;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@InternalCoroutinesApi
public interface SelectInstance<R> {
    void a(DisposableHandle disposableHandle);

    boolean c(Object obj, Object obj2);

    void e(Object obj);

    CoroutineContext getContext();
}
