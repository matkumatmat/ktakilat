package androidx.tracing;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nTrace.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Trace.kt\nandroidx/tracing/TraceKt$traceAsync$1\n*L\n1#1,111:1\n*E\n"})
@Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
@DebugMetadata(c = "androidx.tracing.TraceKt", f = "Trace.kt", i = {0, 0}, l = {76}, m = "traceAsync", n = {"methodName", "cookie"}, s = {"L$0", "I$0"})
public final class TraceKt$traceAsync$1<T> extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public TraceKt$traceAsync$1(Continuation<? super TraceKt$traceAsync$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return TraceKt.traceAsync((String) null, 0, (Function1) null, this);
    }
}
