package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SinceKotlin(version = "1.3")
public interface CoroutineStackFrame {
    CoroutineStackFrame getCallerFrame();

    StackTraceElement getStackTraceElement();
}
