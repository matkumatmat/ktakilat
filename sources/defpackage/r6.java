package defpackage;

import java.lang.reflect.Constructor;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ExceptionsConstructorKt;

/* renamed from: r6  reason: default package */
public final /* synthetic */ class r6 implements Function1 {
    public final /* synthetic */ int c;
    public final /* synthetic */ Constructor d;

    public /* synthetic */ r6(Constructor constructor, int i) {
        this.c = i;
        this.d = constructor;
    }

    public final Object invoke(Object obj) {
        Constructor constructor = this.d;
        Throwable th = (Throwable) obj;
        switch (this.c) {
            case 0:
                int i = ExceptionsConstructorKt.f796a;
                Object newInstance = constructor.newInstance(new Object[]{th.getMessage(), th});
                Intrinsics.d(newInstance, "null cannot be cast to non-null type kotlin.Throwable");
                return (Throwable) newInstance;
            case 1:
                int i2 = ExceptionsConstructorKt.f796a;
                Object newInstance2 = constructor.newInstance(new Object[]{th.getMessage()});
                Intrinsics.d(newInstance2, "null cannot be cast to non-null type kotlin.Throwable");
                Throwable th2 = (Throwable) newInstance2;
                th2.initCause(th);
                return th2;
            case 2:
                int i3 = ExceptionsConstructorKt.f796a;
                Object newInstance3 = constructor.newInstance(new Object[]{th});
                Intrinsics.d(newInstance3, "null cannot be cast to non-null type kotlin.Throwable");
                return (Throwable) newInstance3;
            default:
                int i4 = ExceptionsConstructorKt.f796a;
                Object newInstance4 = constructor.newInstance((Object[]) null);
                Intrinsics.d(newInstance4, "null cannot be cast to non-null type kotlin.Throwable");
                Throwable th3 = (Throwable) newInstance4;
                th3.initCause(th);
                return th3;
        }
    }
}
