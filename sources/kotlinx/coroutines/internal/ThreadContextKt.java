package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"kotlinx-coroutines-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ThreadContextKt {

    /* renamed from: a  reason: collision with root package name */
    public static final Symbol f807a = new Symbol("NO_THREAD_ELEMENTS");
    public static final e3 b = new e3(9);
    public static final e3 c = new e3(10);
    public static final a d = new Object();

    public static final void a(CoroutineContext coroutineContext, Object obj) {
        if (obj != f807a) {
            if (obj instanceof ThreadState) {
                ThreadState threadState = (ThreadState) obj;
                ThreadContextElement[] threadContextElementArr = threadState.c;
                int length = threadContextElementArr.length - 1;
                if (length >= 0) {
                    while (true) {
                        int i = length - 1;
                        ThreadContextElement threadContextElement = threadContextElementArr[length];
                        Intrinsics.c(threadContextElement);
                        threadContextElement.v(threadState.b[length]);
                        if (i >= 0) {
                            length = i;
                        } else {
                            return;
                        }
                    }
                }
            } else {
                Object fold = coroutineContext.fold((Object) null, c);
                Intrinsics.d(fold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
                ((ThreadContextElement) fold).v(obj);
            }
        }
    }

    public static final Object b(CoroutineContext coroutineContext) {
        Object fold = coroutineContext.fold(0, b);
        Intrinsics.c(fold);
        return fold;
    }

    public static final Object c(CoroutineContext coroutineContext, Object obj) {
        if (obj == null) {
            obj = b(coroutineContext);
        }
        if (obj == 0) {
            return f807a;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new ThreadState(((Number) obj).intValue(), coroutineContext), d);
        }
        return ((ThreadContextElement) obj).E(coroutineContext);
    }
}
