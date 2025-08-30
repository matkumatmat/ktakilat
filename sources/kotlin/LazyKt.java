package kotlin;

import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"kotlin/LazyKt__LazyJVMKt", "kotlin/LazyKt__LazyKt"}, k = 4, mv = {2, 1, 0}, xi = 49)
public final class LazyKt extends LazyKt__LazyKt {
    /* JADX WARNING: type inference failed for: r3v4, types: [kotlin.SafePublicationLazyImpl, java.lang.Object, kotlin.Lazy] */
    public static Lazy a(LazyThreadSafetyMode lazyThreadSafetyMode, Function0 function0) {
        Intrinsics.checkNotNullParameter(lazyThreadSafetyMode, "mode");
        Intrinsics.checkNotNullParameter(function0, "initializer");
        int i = LazyKt__LazyJVMKt.WhenMappings.f694a[lazyThreadSafetyMode.ordinal()];
        if (i == 1) {
            return new SynchronizedLazyImpl(function0, (Object) null, 2, (DefaultConstructorMarker) null);
        }
        if (i == 2) {
            Intrinsics.checkNotNullParameter(function0, "initializer");
            ? obj = new Object();
            obj.c = function0;
            obj.d = UNINITIALIZED_VALUE.f695a;
            return obj;
        } else if (i == 3) {
            return new UnsafeLazyImpl(function0);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static Lazy b(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "initializer");
        return new SynchronizedLazyImpl(function0, (Object) null, 2, (DefaultConstructorMarker) null);
    }
}
