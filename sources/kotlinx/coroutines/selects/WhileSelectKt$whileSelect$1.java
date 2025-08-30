package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.selects.WhileSelectKt", f = "WhileSelect.kt", i = {0}, l = {34}, m = "whileSelect", n = {"builder"}, s = {"L$0"})
final class WhileSelectKt$whileSelect$1 extends ContinuationImpl {
    public Function1 c;
    public /* synthetic */ Object d;
    public int e;

    /* JADX WARNING: Removed duplicated region for block: B:13:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            r6.d = r7
            int r0 = r6.e
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 | r1
            int r0 = r0 - r1
            r6.e = r0
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            r2 = 1
            if (r0 == 0) goto L_0x0021
            if (r0 != r2) goto L_0x0019
            kotlin.jvm.functions.Function1 r0 = r6.c
            kotlin.ResultKt.b(r7)
            r3 = r0
            r0 = r6
            goto L_0x0042
        L_0x0019:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0021:
            kotlin.ResultKt.b(r7)
            r7 = 0
            r0 = r7
            r7 = r6
        L_0x0027:
            kotlinx.coroutines.selects.SelectImplementation r3 = new kotlinx.coroutines.selects.SelectImplementation
            kotlin.coroutines.CoroutineContext r4 = r7.getContext()
            r3.<init>(r4)
            r0.invoke(r3)
            r7.c = r0
            r7.e = r2
            java.lang.Object r3 = r3.g(r7)
            if (r3 != r1) goto L_0x003e
            goto L_0x004c
        L_0x003e:
            r5 = r0
            r0 = r7
            r7 = r3
            r3 = r5
        L_0x0042:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L_0x004d
            kotlin.Unit r1 = kotlin.Unit.f696a
        L_0x004c:
            return r1
        L_0x004d:
            r7 = r0
            r0 = r3
            goto L_0x0027
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.WhileSelectKt$whileSelect$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
