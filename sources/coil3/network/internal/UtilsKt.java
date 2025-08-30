package coil3.network.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"coil-network-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nutils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 utils.kt\ncoil3/network/internal/UtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,92:1\n1#2:93\n*E\n"})
public final class UtilsKt {
    /* JADX WARNING: type inference failed for: r0v8, types: [kotlin.coroutines.jvm.internal.ContinuationImpl] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(coil3.network.NetworkResponseBody r4, kotlin.coroutines.jvm.internal.ContinuationImpl r5) {
        /*
            boolean r0 = r5 instanceof coil3.network.internal.UtilsKt$readBuffer$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            coil3.network.internal.UtilsKt$readBuffer$1 r0 = (coil3.network.internal.UtilsKt$readBuffer$1) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f = r1
            goto L_0x0018
        L_0x0013:
            coil3.network.internal.UtilsKt$readBuffer$1 r0 = new coil3.network.internal.UtilsKt$readBuffer$1
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.e
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.f
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            okio.Buffer r4 = r0.d
            coil3.network.NetworkResponseBody r0 = r0.c
            kotlin.ResultKt.b(r5)     // Catch:{ all -> 0x002b }
            goto L_0x004c
        L_0x002b:
            r4 = move-exception
            goto L_0x0056
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.ResultKt.b(r5)
            okio.Buffer r5 = new okio.Buffer     // Catch:{ all -> 0x0054 }
            r5.<init>()     // Catch:{ all -> 0x0054 }
            r0.c = r4     // Catch:{ all -> 0x0054 }
            r0.d = r5     // Catch:{ all -> 0x0054 }
            r0.f = r3     // Catch:{ all -> 0x0054 }
            kotlin.Unit r0 = r4.a(r5)     // Catch:{ all -> 0x0054 }
            if (r0 != r1) goto L_0x004a
            return r1
        L_0x004a:
            r0 = r4
            r4 = r5
        L_0x004c:
            r5 = 0
            kotlin.jdk7.AutoCloseableKt.a(r0, r5)
            return r4
        L_0x0051:
            r0 = r4
            r4 = r5
            goto L_0x0056
        L_0x0054:
            r5 = move-exception
            goto L_0x0051
        L_0x0056:
            throw r4     // Catch:{ all -> 0x0057 }
        L_0x0057:
            r5 = move-exception
            kotlin.jdk7.AutoCloseableKt.a(r0, r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.network.internal.UtilsKt.a(coil3.network.NetworkResponseBody, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
