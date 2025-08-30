package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/coroutines/CompletedContinuation;", "R", "", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCancellableContinuationImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancellableContinuationImpl.kt\nkotlinx/coroutines/CompletedContinuation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,701:1\n1#2:702\n*E\n"})
final class CompletedContinuation<R> {

    /* renamed from: a  reason: collision with root package name */
    public final Object f763a;
    public final CancelHandler b;
    public final Function3 c;
    public final Object d;
    public final Throwable e;

    public CompletedContinuation(Object obj, CancelHandler cancelHandler, Function3 function3, Object obj2, Throwable th) {
        this.f763a = obj;
        this.b = cancelHandler;
        this.c = function3;
        this.d = obj2;
        this.e = th;
    }

    public static CompletedContinuation a(CompletedContinuation completedContinuation, CancelHandler cancelHandler, CancellationException cancellationException, int i) {
        Object obj = completedContinuation.f763a;
        if ((i & 2) != 0) {
            cancelHandler = completedContinuation.b;
        }
        CancelHandler cancelHandler2 = cancelHandler;
        Function3 function3 = completedContinuation.c;
        Object obj2 = completedContinuation.d;
        Throwable th = cancellationException;
        if ((i & 16) != 0) {
            th = completedContinuation.e;
        }
        completedContinuation.getClass();
        return new CompletedContinuation(obj, cancelHandler2, function3, obj2, th);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompletedContinuation)) {
            return false;
        }
        CompletedContinuation completedContinuation = (CompletedContinuation) obj;
        return Intrinsics.a(this.f763a, completedContinuation.f763a) && Intrinsics.a(this.b, completedContinuation.b) && Intrinsics.a(this.c, completedContinuation.c) && Intrinsics.a(this.d, completedContinuation.d) && Intrinsics.a(this.e, completedContinuation.e);
    }

    public final int hashCode() {
        int i = 0;
        Object obj = this.f763a;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        CancelHandler cancelHandler = this.b;
        int hashCode2 = (hashCode + (cancelHandler == null ? 0 : cancelHandler.hashCode())) * 31;
        Function3 function3 = this.c;
        int hashCode3 = (hashCode2 + (function3 == null ? 0 : function3.hashCode())) * 31;
        Object obj2 = this.d;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.e;
        if (th != null) {
            i = th.hashCode();
        }
        return hashCode4 + i;
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.f763a + ", cancelHandler=" + this.b + ", onCancellation=" + this.c + ", idempotentResume=" + this.d + ", cancelCause=" + this.e + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CompletedContinuation(Object obj, CancelHandler cancelHandler, Function3 function3, CancellationException cancellationException, int i) {
        this(obj, (i & 2) != 0 ? null : cancelHandler, (i & 4) != 0 ? null : function3, (Object) null, (Throwable) (i & 16) != 0 ? null : cancellationException);
    }
}
