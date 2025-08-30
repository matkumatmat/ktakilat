package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.ThreadContextElement;

public final /* synthetic */ class a implements Function2 {
    public final Object invoke(Object obj, Object obj2) {
        ThreadState threadState = (ThreadState) obj;
        CoroutineContext.Element element = (CoroutineContext.Element) obj2;
        if (element instanceof ThreadContextElement) {
            ThreadContextElement threadContextElement = (ThreadContextElement) element;
            Object E = threadContextElement.E(threadState.f809a);
            int i = threadState.d;
            threadState.b[i] = E;
            threadState.d = i + 1;
            threadState.c[i] = threadContextElement;
        }
        return threadState;
    }
}
