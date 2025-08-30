package kotlin.sequences;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004B\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlin/sequences/SequenceBuilderIterator;", "T", "Lkotlin/sequences/SequenceScope;", "", "Lkotlin/coroutines/Continuation;", "", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class SequenceBuilderIterator<T> extends SequenceScope<T> implements Iterator<T>, Continuation<Unit>, KMappedMarker {
    public int c;
    public Object d;
    public Iterator e;
    public Continuation f;

    public final CoroutineSingletons a(Object obj, BaseContinuationImpl baseContinuationImpl) {
        this.d = obj;
        this.c = 3;
        this.f = baseContinuationImpl;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Intrinsics.checkNotNullParameter(baseContinuationImpl, TypedValues.AttributesType.S_FRAME);
        return coroutineSingletons;
    }

    public final Object b(Iterator it, RestrictedSuspendLambda restrictedSuspendLambda) {
        if (!it.hasNext()) {
            return Unit.f696a;
        }
        this.e = it;
        this.c = 2;
        this.f = restrictedSuspendLambda;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Intrinsics.checkNotNullParameter(restrictedSuspendLambda, TypedValues.AttributesType.S_FRAME);
        return coroutineSingletons;
    }

    public final RuntimeException c() {
        int i = this.c;
        if (i == 4) {
            return new NoSuchElementException();
        }
        if (i == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.c);
    }

    public final CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    public final boolean hasNext() {
        while (true) {
            int i = this.c;
            if (i != 0) {
                if (i == 1) {
                    Iterator it = this.e;
                    Intrinsics.c(it);
                    if (it.hasNext()) {
                        this.c = 2;
                        return true;
                    }
                    this.e = null;
                } else if (i == 2 || i == 3) {
                    return true;
                } else {
                    if (i == 4) {
                        return false;
                    }
                    throw c();
                }
            }
            this.c = 5;
            Continuation continuation = this.f;
            Intrinsics.c(continuation);
            this.f = null;
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m16constructorimpl(Unit.f696a));
        }
    }

    public final Object next() {
        int i = this.c;
        if (i == 0 || i == 1) {
            if (hasNext()) {
                return next();
            }
            throw new NoSuchElementException();
        } else if (i == 2) {
            this.c = 1;
            Iterator it = this.e;
            Intrinsics.c(it);
            return it.next();
        } else if (i == 3) {
            this.c = 0;
            Object obj = this.d;
            this.d = null;
            return obj;
        } else {
            throw c();
        }
    }

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void resumeWith(Object obj) {
        ResultKt.b(obj);
        this.c = 4;
    }
}
