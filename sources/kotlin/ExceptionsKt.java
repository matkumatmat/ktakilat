package kotlin;

import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"kotlin/ExceptionsKt__ExceptionsKt"}, k = 4, mv = {2, 1, 0}, xi = 49)
public final class ExceptionsKt extends ExceptionsKt__ExceptionsKt {
    public static void a(Throwable th, Throwable th2) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        Intrinsics.checkNotNullParameter(th2, "exception");
        if (th != th2) {
            PlatformImplementationsKt.f705a.a(th, th2);
        }
    }
}
