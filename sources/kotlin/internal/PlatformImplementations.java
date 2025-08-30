package kotlin.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lkotlin/internal/PlatformImplementations;", "", "<init>", "()V", "ReflectThrowable", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPlatformImplementations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlatformImplementations.kt\nkotlin/internal/PlatformImplementations\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,79:1\n1#2:80\n*E\n"})
public class PlatformImplementations {

    @SourceDebugExtension({"SMAP\nPlatformImplementations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlatformImplementations.kt\nkotlin/internal/PlatformImplementations$ReflectThrowable\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,79:1\n1#2:80\n*E\n"})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/internal/PlatformImplementations$ReflectThrowable;", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ReflectThrowable {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final ReflectThrowable f704a = new Object();
        public static final Method b;

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.Class[]} */
        /* JADX WARNING: type inference failed for: r0v0, types: [kotlin.internal.PlatformImplementations$ReflectThrowable, java.lang.Object] */
        /* JADX WARNING: type inference failed for: r5v5 */
        /* JADX WARNING: Multi-variable type inference failed */
        static {
            /*
                kotlin.internal.PlatformImplementations$ReflectThrowable r0 = new kotlin.internal.PlatformImplementations$ReflectThrowable
                r0.<init>()
                f704a = r0
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                kotlin.jvm.internal.Intrinsics.c(r1)
                int r2 = r1.length
                r3 = 0
                r4 = 0
            L_0x0013:
                r5 = 0
                if (r4 >= r2) goto L_0x0043
                r6 = r1[r4]
                java.lang.String r7 = r6.getName()
                java.lang.String r8 = "addSuppressed"
                boolean r7 = kotlin.jvm.internal.Intrinsics.a(r7, r8)
                if (r7 == 0) goto L_0x0040
                java.lang.Class[] r7 = r6.getParameterTypes()
                java.lang.String r8 = "getParameterTypes(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
                java.lang.String r8 = "<this>"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r8)
                int r8 = r7.length
                r9 = 1
                if (r8 != r9) goto L_0x0038
                r5 = r7[r3]
            L_0x0038:
                boolean r5 = kotlin.jvm.internal.Intrinsics.a(r5, r0)
                if (r5 == 0) goto L_0x0040
                r5 = r6
                goto L_0x0043
            L_0x0040:
                int r4 = r4 + 1
                goto L_0x0013
            L_0x0043:
                b = r5
                int r0 = r1.length
            L_0x0046:
                if (r3 >= r0) goto L_0x005a
                r2 = r1[r3]
                java.lang.String r2 = r2.getName()
                java.lang.String r4 = "getSuppressed"
                boolean r2 = kotlin.jvm.internal.Intrinsics.a(r2, r4)
                if (r2 == 0) goto L_0x0057
                goto L_0x005a
            L_0x0057:
                int r3 = r3 + 1
                goto L_0x0046
            L_0x005a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.internal.PlatformImplementations.ReflectThrowable.<clinit>():void");
        }
    }

    public void a(Throwable th, Throwable th2) {
        Intrinsics.checkNotNullParameter(th, "cause");
        Intrinsics.checkNotNullParameter(th2, "exception");
        Method method = ReflectThrowable.b;
        if (method != null) {
            method.invoke(th, new Object[]{th2});
        }
    }
}
