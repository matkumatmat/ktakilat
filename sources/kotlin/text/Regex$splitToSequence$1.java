package kotlin.text;

import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "kotlin.text.Regex$splitToSequence$1", f = "Regex.kt", i = {1, 1, 1}, l = {275, 283, 287}, m = "invokeSuspend", n = {"$this$sequence", "matcher", "splitCount"}, s = {"L$0", "L$1", "I$0"})
public final class Regex$splitToSequence$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super String>, Continuation<? super Unit>, Object> {
    public Matcher c;
    public int d;
    public int e;
    public /* synthetic */ Object f;
    public final /* synthetic */ Regex g;
    public final /* synthetic */ CharSequence i;
    public final /* synthetic */ int j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Regex$splitToSequence$1(Regex regex, CharSequence charSequence, int i2, Continuation continuation) {
        super(2, continuation);
        this.g = regex;
        this.i = charSequence;
        this.j = i2;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        Regex$splitToSequence$1 regex$splitToSequence$1 = new Regex$splitToSequence$1(this.g, this.i, this.j, continuation);
        regex$splitToSequence$1.f = obj;
        return regex$splitToSequence$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((Regex$splitToSequence$1) create((SequenceScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f696a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0093 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r10.e
            int r2 = r10.j
            r3 = 3
            r4 = 2
            java.lang.CharSequence r5 = r10.i
            r6 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 == r6) goto L_0x002d
            if (r1 == r4) goto L_0x0020
            if (r1 != r3) goto L_0x0018
            kotlin.ResultKt.b(r11)
            goto L_0x0094
        L_0x0018:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0020:
            int r1 = r10.d
            java.util.regex.Matcher r7 = r10.c
            java.lang.Object r8 = r10.f
            kotlin.sequences.SequenceScope r8 = (kotlin.sequences.SequenceScope) r8
            kotlin.ResultKt.b(r11)
            r11 = r7
            goto L_0x006b
        L_0x002d:
            kotlin.ResultKt.b(r11)
            goto L_0x00a4
        L_0x0032:
            kotlin.ResultKt.b(r11)
            java.lang.Object r11 = r10.f
            kotlin.sequences.SequenceScope r11 = (kotlin.sequences.SequenceScope) r11
            kotlin.text.Regex r1 = r10.g
            java.util.regex.Pattern r1 = r1.c
            java.util.regex.Matcher r1 = r1.matcher(r5)
            if (r2 == r6) goto L_0x0097
            boolean r7 = r1.find()
            if (r7 != 0) goto L_0x004c
            goto L_0x0097
        L_0x004c:
            r7 = 0
            r8 = r11
            r11 = r1
            r1 = 0
        L_0x0050:
            int r9 = r11.start()
            java.lang.CharSequence r7 = r5.subSequence(r7, r9)
            java.lang.String r7 = r7.toString()
            r10.f = r8
            r10.c = r11
            r10.d = r1
            r10.e = r4
            kotlin.coroutines.intrinsics.CoroutineSingletons r7 = r8.a(r7, r10)
            if (r7 != r0) goto L_0x006b
            return r0
        L_0x006b:
            int r7 = r11.end()
            int r1 = r1 + r6
            int r9 = r2 + -1
            if (r1 == r9) goto L_0x007a
            boolean r9 = r11.find()
            if (r9 != 0) goto L_0x0050
        L_0x007a:
            int r11 = r5.length()
            java.lang.CharSequence r11 = r5.subSequence(r7, r11)
            java.lang.String r11 = r11.toString()
            r1 = 0
            r10.f = r1
            r10.c = r1
            r10.e = r3
            kotlin.coroutines.intrinsics.CoroutineSingletons r11 = r8.a(r11, r10)
            if (r11 != r0) goto L_0x0094
            return r0
        L_0x0094:
            kotlin.Unit r11 = kotlin.Unit.f696a
            return r11
        L_0x0097:
            java.lang.String r1 = r5.toString()
            r10.e = r6
            kotlin.coroutines.intrinsics.CoroutineSingletons r11 = r11.a(r1, r10)
            if (r11 != r0) goto L_0x00a4
            return r0
        L_0x00a4:
            kotlin.Unit r11 = kotlin.Unit.f696a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex$splitToSequence$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
