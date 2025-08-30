package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.RestrictsSuspension;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

@RestrictsSuspension
@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B\t\b\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/sequences/SequenceScope;", "T", "", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class SequenceScope<T> {
    public abstract CoroutineSingletons a(Object obj, BaseContinuationImpl baseContinuationImpl);

    public abstract Object b(Iterator it, RestrictedSuspendLambda restrictedSuspendLambda);
}
