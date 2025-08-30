package kotlin.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"kotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt", "kotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsKt"}, k = 4, mv = {2, 1, 0}, xi = 49)
public final class IntrinsicsKt extends IntrinsicsKt__IntrinsicsKt {
    public static Continuation a(Function2 function2, Object obj, Continuation continuation) {
        Intrinsics.checkNotNullParameter(function2, "<this>");
        Intrinsics.checkNotNullParameter(continuation, "completion");
        Intrinsics.checkNotNullParameter(continuation, "completion");
        if (function2 instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) function2).create(obj, continuation);
        }
        CoroutineContext context = continuation.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$3(continuation, function2, obj);
        }
        return new IntrinsicsKt__IntrinsicsJvmKt$createCoroutineUnintercepted$$inlined$createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt$4(continuation, context, function2, obj);
    }

    public static Continuation b(Continuation continuation) {
        ContinuationImpl continuationImpl;
        Continuation<Object> intercepted;
        Intrinsics.checkNotNullParameter(continuation, "<this>");
        if (continuation instanceof ContinuationImpl) {
            continuationImpl = (ContinuationImpl) continuation;
        } else {
            continuationImpl = null;
        }
        if (continuationImpl == null || (intercepted = continuationImpl.intercepted()) == null) {
            return continuation;
        }
        return intercepted;
    }

    public static Object c(Function2 function2, Object obj, Continuation continuation) {
        Object obj2;
        Intrinsics.checkNotNullParameter(function2, "<this>");
        Intrinsics.checkNotNullParameter(continuation, "completion");
        Intrinsics.checkNotNullParameter(continuation, "completion");
        CoroutineContext context = continuation.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            Intrinsics.d(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            obj2 = new RestrictedContinuationImpl(continuation);
        } else {
            Intrinsics.d(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            obj2 = new ContinuationImpl(continuation, context);
        }
        TypeIntrinsics.c(2, function2);
        return function2.invoke(obj, obj2);
    }
}
