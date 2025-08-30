package kotlinx.coroutines.future;

import java.util.concurrent.CompletionException;
import java.util.function.BiFunction;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0018\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0002R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/future/ContinuationHandler;", "T", "Ljava/util/function/BiFunction;", "", "", "Lkotlin/coroutines/Continuation;", "cont", "Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ContinuationHandler<T> implements BiFunction<T, Throwable, Unit> {
    @Nullable
    @JvmField
    public volatile Continuation<? super T> cont;

    public final Object apply(Object obj, Object obj2) {
        CompletionException completionException;
        Throwable p;
        Throwable th = (Throwable) obj2;
        Continuation<? super T> continuation = this.cont;
        if (continuation != null) {
            if (th == null) {
                continuation.resumeWith(Result.m16constructorimpl(obj));
            } else {
                if (l3.B(th)) {
                    completionException = l3.s(th);
                } else {
                    completionException = null;
                }
                if (!(completionException == null || (p = completionException.getCause()) == null)) {
                    th = p;
                }
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m16constructorimpl(ResultKt.a(th)));
            }
        }
        return Unit.f696a;
    }
}
