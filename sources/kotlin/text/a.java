package kotlin.text;

import kotlin.jvm.functions.Function2;

public final /* synthetic */ class a implements Function2 {
    public final /* synthetic */ int c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ Object e;

    public /* synthetic */ a(int i, Object obj, boolean z) {
        this.c = i;
        this.e = obj;
        this.d = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(java.lang.Object r14, java.lang.Object r15) {
        /*
            r13 = this;
            int r0 = r13.c
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            java.lang.Integer r15 = (java.lang.Integer) r15
            int r15 = r15.intValue()
            switch(r0) {
                case 0: goto L_0x013a;
                default: goto L_0x000d;
            }
        L_0x000d:
            java.lang.String r0 = "$this$DelimitedRangesSequence"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.Object r0 = r13.e
            java.util.List r0 = (java.util.List) r0
            java.util.Collection r0 = (java.util.Collection) r0
            r1 = 0
            boolean r8 = r13.d
            r9 = 0
            r2 = 1
            if (r8 != 0) goto L_0x008d
            int r3 = r0.size()
            if (r3 != r2) goto L_0x008d
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.lang.String r3 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            boolean r4 = r0 instanceof java.util.List
            if (r4 == 0) goto L_0x0052
            java.util.List r0 = (java.util.List) r0
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            int r3 = r0.size()
            if (r3 == 0) goto L_0x004a
            if (r3 != r2) goto L_0x0042
            java.lang.Object r0 = r0.get(r1)
            goto L_0x0067
        L_0x0042:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.String r15 = "List has more than one element."
            r14.<init>(r15)
            throw r14
        L_0x004a:
            java.util.NoSuchElementException r14 = new java.util.NoSuchElementException
            java.lang.String r15 = "List is empty."
            r14.<init>(r15)
            throw r14
        L_0x0052:
            java.util.Iterator r0 = r0.iterator()
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0085
            java.lang.Object r2 = r0.next()
            boolean r0 = r0.hasNext()
            if (r0 != 0) goto L_0x007d
            r0 = r2
        L_0x0067:
            java.lang.String r0 = (java.lang.String) r0
            r2 = 4
            int r14 = kotlin.text.StringsKt.s(r14, r0, r15, r1, r2)
            if (r14 >= 0) goto L_0x0072
            goto L_0x011f
        L_0x0072:
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            kotlin.Pair r15 = new kotlin.Pair
            r15.<init>(r14, r0)
            goto L_0x0120
        L_0x007d:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.String r15 = "Collection has more than one element."
            r14.<init>(r15)
            throw r14
        L_0x0085:
            java.util.NoSuchElementException r14 = new java.util.NoSuchElementException
            java.lang.String r15 = "Collection is empty."
            r14.<init>(r15)
            throw r14
        L_0x008d:
            kotlin.ranges.IntRange r3 = new kotlin.ranges.IntRange
            if (r15 >= 0) goto L_0x0092
            r15 = 0
        L_0x0092:
            int r1 = r14.length()
            r3.<init>(r15, r1, r2)
            boolean r1 = r14 instanceof java.lang.String
            int r10 = r3.e
            int r11 = r3.d
            if (r1 == 0) goto L_0x00e1
            if (r10 <= 0) goto L_0x00a5
            if (r15 <= r11) goto L_0x00a9
        L_0x00a5:
            if (r10 >= 0) goto L_0x011f
            if (r11 > r15) goto L_0x011f
        L_0x00a9:
            r1 = r0
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x00b0:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00ce
            java.lang.Object r12 = r1.next()
            r2 = r12
            java.lang.String r2 = (java.lang.String) r2
            r5 = r14
            java.lang.String r5 = (java.lang.String) r5
            int r7 = r2.length()
            r3 = 0
            r4 = r8
            r6 = r15
            boolean r2 = kotlin.text.StringsKt__StringsJVMKt.a(r2, r3, r4, r5, r6, r7)
            if (r2 == 0) goto L_0x00b0
            goto L_0x00cf
        L_0x00ce:
            r12 = r9
        L_0x00cf:
            java.lang.String r12 = (java.lang.String) r12
            if (r12 == 0) goto L_0x00dd
            java.lang.Integer r14 = java.lang.Integer.valueOf(r15)
            kotlin.Pair r15 = new kotlin.Pair
            r15.<init>(r14, r12)
            goto L_0x0120
        L_0x00dd:
            if (r15 == r11) goto L_0x011f
            int r15 = r15 + r10
            goto L_0x00a9
        L_0x00e1:
            if (r10 <= 0) goto L_0x00e5
            if (r15 <= r11) goto L_0x00e9
        L_0x00e5:
            if (r10 >= 0) goto L_0x011f
            if (r11 > r15) goto L_0x011f
        L_0x00e9:
            r1 = r0
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r7 = r1.iterator()
        L_0x00f0:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x010c
            java.lang.Object r12 = r7.next()
            r1 = r12
            java.lang.String r1 = (java.lang.String) r1
            int r6 = r1.length()
            r3 = 0
            r2 = r8
            r4 = r14
            r5 = r15
            boolean r1 = kotlin.text.StringsKt__StringsKt.g(r1, r2, r3, r4, r5, r6)
            if (r1 == 0) goto L_0x00f0
            goto L_0x010d
        L_0x010c:
            r12 = r9
        L_0x010d:
            java.lang.String r12 = (java.lang.String) r12
            if (r12 == 0) goto L_0x011b
            java.lang.Integer r14 = java.lang.Integer.valueOf(r15)
            kotlin.Pair r15 = new kotlin.Pair
            r15.<init>(r14, r12)
            goto L_0x0120
        L_0x011b:
            if (r15 == r11) goto L_0x011f
            int r15 = r15 + r10
            goto L_0x00e9
        L_0x011f:
            r15 = r9
        L_0x0120:
            if (r15 == 0) goto L_0x0139
            java.lang.Object r14 = r15.getFirst()
            java.lang.Object r15 = r15.getSecond()
            java.lang.String r15 = (java.lang.String) r15
            int r15 = r15.length()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            kotlin.Pair r9 = new kotlin.Pair
            r9.<init>(r14, r15)
        L_0x0139:
            return r9
        L_0x013a:
            java.lang.String r0 = "$this$DelimitedRangesSequence"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.Object r0 = r13.e
            char[] r0 = (char[]) r0
            boolean r1 = r13.d
            int r14 = kotlin.text.StringsKt__StringsKt.f(r14, r0, r15, r1)
            if (r14 >= 0) goto L_0x014d
            r14 = 0
            goto L_0x015c
        L_0x014d:
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            r15 = 1
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            kotlin.Pair r0 = new kotlin.Pair
            r0.<init>(r14, r15)
            r14 = r0
        L_0x015c:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.a.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
    }
}
