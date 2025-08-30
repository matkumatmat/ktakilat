package defpackage;

import kotlin.jvm.functions.Function2;

/* renamed from: e3  reason: default package */
public final /* synthetic */ class e3 implements Function2 {
    public final /* synthetic */ int c;

    public /* synthetic */ e3(int i) {
        this.c = i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: type inference failed for: r6v8 */
    /* JADX WARNING: type inference failed for: r6v11 */
    /* JADX WARNING: type inference failed for: r6v12 */
    /* JADX WARNING: type inference failed for: r6v13 */
    /* JADX WARNING: type inference failed for: r6v14 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(java.lang.Object r9, java.lang.Object r10) {
        /*
            r8 = this;
            java.lang.String r0 = "element"
            java.lang.String r1 = "acc"
            r2 = 2
            java.lang.String r3 = "_"
            r4 = 0
            r5 = 1
            r6 = 0
            int r7 = r8.c
            switch(r7) {
                case 0: goto L_0x0175;
                case 1: goto L_0x0172;
                case 2: goto L_0x0131;
                case 3: goto L_0x011d;
                case 4: goto L_0x0105;
                case 5: goto L_0x00ae;
                case 6: goto L_0x00a5;
                case 7: goto L_0x004c;
                case 8: goto L_0x003e;
                case 9: goto L_0x001f;
                default: goto L_0x000f;
            }
        L_0x000f:
            kotlinx.coroutines.ThreadContextElement r9 = (kotlinx.coroutines.ThreadContextElement) r9
            kotlin.coroutines.CoroutineContext$Element r10 = (kotlin.coroutines.CoroutineContext.Element) r10
            if (r9 == 0) goto L_0x0016
            goto L_0x001e
        L_0x0016:
            boolean r9 = r10 instanceof kotlinx.coroutines.ThreadContextElement
            if (r9 == 0) goto L_0x001d
            r6 = r10
            kotlinx.coroutines.ThreadContextElement r6 = (kotlinx.coroutines.ThreadContextElement) r6
        L_0x001d:
            r9 = r6
        L_0x001e:
            return r9
        L_0x001f:
            kotlin.coroutines.CoroutineContext$Element r10 = (kotlin.coroutines.CoroutineContext.Element) r10
            boolean r0 = r10 instanceof kotlinx.coroutines.ThreadContextElement
            if (r0 == 0) goto L_0x003d
            boolean r0 = r9 instanceof java.lang.Integer
            if (r0 == 0) goto L_0x002c
            r6 = r9
            java.lang.Integer r6 = (java.lang.Integer) r6
        L_0x002c:
            if (r6 == 0) goto L_0x0033
            int r9 = r6.intValue()
            goto L_0x0034
        L_0x0033:
            r9 = 1
        L_0x0034:
            if (r9 != 0) goto L_0x0038
            r9 = r10
            goto L_0x003d
        L_0x0038:
            int r9 = r9 + r5
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
        L_0x003d:
            return r9
        L_0x003e:
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            kotlin.coroutines.CoroutineContext$Element r10 = (kotlin.coroutines.CoroutineContext.Element) r10
            int r9 = r9 + r5
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            return r9
        L_0x004c:
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10
            int r0 = com.katkilat.baidu_face.LivenessBaiduActivity.G
            java.lang.Object r9 = r9.getKey()
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L_0x006f
            java.lang.String[] r0 = new java.lang.String[]{r3}
            java.util.List r9 = kotlin.text.StringsKt__StringsKt.split$default(r9, r0, false, 0, 6, (java.lang.Object) null)
            if (r9 == 0) goto L_0x006f
            java.util.Collection r9 = (java.util.Collection) r9
            java.lang.String[] r0 = new java.lang.String[r4]
            java.lang.Object[] r9 = r9.toArray(r0)
            java.lang.String[] r9 = (java.lang.String[]) r9
            goto L_0x0070
        L_0x006f:
            r9 = r6
        L_0x0070:
            if (r9 == 0) goto L_0x0075
            r9 = r9[r2]
            goto L_0x0076
        L_0x0075:
            r9 = r6
        L_0x0076:
            java.lang.Object r10 = r10.getKey()
            java.lang.String r10 = (java.lang.String) r10
            if (r10 == 0) goto L_0x0093
            java.lang.String[] r0 = new java.lang.String[]{r3}
            java.util.List r10 = kotlin.text.StringsKt__StringsKt.split$default(r10, r0, false, 0, 6, (java.lang.Object) null)
            if (r10 == 0) goto L_0x0093
            java.util.Collection r10 = (java.util.Collection) r10
            java.lang.String[] r0 = new java.lang.String[r4]
            java.lang.Object[] r10 = r10.toArray(r0)
            java.lang.String[] r10 = (java.lang.String[]) r10
            goto L_0x0094
        L_0x0093:
            r10 = r6
        L_0x0094:
            if (r10 == 0) goto L_0x0098
            r6 = r10[r2]
        L_0x0098:
            if (r9 == 0) goto L_0x00a0
            if (r6 == 0) goto L_0x00a0
            int r4 = r6.compareTo(r9)
        L_0x00a0:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r4)
            return r9
        L_0x00a5:
            boolean r9 = kotlin.jvm.internal.Intrinsics.a(r9, r10)
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            return r9
        L_0x00ae:
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10
            java.lang.Object r9 = r9.getKey()
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L_0x00cf
            java.lang.String[] r0 = new java.lang.String[]{r3}
            java.util.List r9 = kotlin.text.StringsKt__StringsKt.split$default(r9, r0, false, 0, 6, (java.lang.Object) null)
            if (r9 == 0) goto L_0x00cf
            java.util.Collection r9 = (java.util.Collection) r9
            java.lang.String[] r0 = new java.lang.String[r4]
            java.lang.Object[] r9 = r9.toArray(r0)
            java.lang.String[] r9 = (java.lang.String[]) r9
            goto L_0x00d0
        L_0x00cf:
            r9 = r6
        L_0x00d0:
            if (r9 == 0) goto L_0x00d5
            r9 = r9[r2]
            goto L_0x00d6
        L_0x00d5:
            r9 = r6
        L_0x00d6:
            java.lang.Object r10 = r10.getKey()
            java.lang.String r10 = (java.lang.String) r10
            if (r10 == 0) goto L_0x00f3
            java.lang.String[] r0 = new java.lang.String[]{r3}
            java.util.List r10 = kotlin.text.StringsKt__StringsKt.split$default(r10, r0, false, 0, 6, (java.lang.Object) null)
            if (r10 == 0) goto L_0x00f3
            java.util.Collection r10 = (java.util.Collection) r10
            java.lang.String[] r0 = new java.lang.String[r4]
            java.lang.Object[] r10 = r10.toArray(r0)
            java.lang.String[] r10 = (java.lang.String[]) r10
            goto L_0x00f4
        L_0x00f3:
            r10 = r6
        L_0x00f4:
            if (r10 == 0) goto L_0x00f8
            r6 = r10[r2]
        L_0x00f8:
            if (r9 == 0) goto L_0x0100
            if (r6 == 0) goto L_0x0100
            int r4 = r6.compareTo(r9)
        L_0x0100:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r4)
            return r9
        L_0x0105:
            kotlin.coroutines.CoroutineContext r9 = (kotlin.coroutines.CoroutineContext) r9
            kotlin.coroutines.CoroutineContext$Element r10 = (kotlin.coroutines.CoroutineContext.Element) r10
            boolean r0 = r10 instanceof kotlinx.coroutines.CopyableThreadContextElement
            if (r0 == 0) goto L_0x0118
            kotlinx.coroutines.CopyableThreadContextElement r10 = (kotlinx.coroutines.CopyableThreadContextElement) r10
            kotlinx.coroutines.CopyableThreadContextElement r10 = r10.q()
            kotlin.coroutines.CoroutineContext r9 = r9.plus(r10)
            goto L_0x011c
        L_0x0118:
            kotlin.coroutines.CoroutineContext r9 = r9.plus(r10)
        L_0x011c:
            return r9
        L_0x011d:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            kotlin.coroutines.CoroutineContext$Element r10 = (kotlin.coroutines.CoroutineContext.Element) r10
            if (r9 != 0) goto L_0x012b
            boolean r9 = r10 instanceof kotlinx.coroutines.CopyableThreadContextElement
            if (r9 == 0) goto L_0x012c
        L_0x012b:
            r4 = 1
        L_0x012c:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r4)
            return r9
        L_0x0131:
            kotlin.coroutines.CoroutineContext r9 = (kotlin.coroutines.CoroutineContext) r9
            kotlin.coroutines.CoroutineContext$Element r10 = (kotlin.coroutines.CoroutineContext.Element) r10
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            kotlin.coroutines.CoroutineContext$Key r0 = r10.getKey()
            kotlin.coroutines.CoroutineContext r9 = r9.minusKey(r0)
            kotlin.coroutines.EmptyCoroutineContext r0 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            if (r9 != r0) goto L_0x0148
            goto L_0x0171
        L_0x0148:
            kotlin.coroutines.ContinuationInterceptor$Key r1 = kotlin.coroutines.ContinuationInterceptor.b
            kotlin.coroutines.CoroutineContext$Element r2 = r9.get(r1)
            kotlin.coroutines.ContinuationInterceptor r2 = (kotlin.coroutines.ContinuationInterceptor) r2
            if (r2 != 0) goto L_0x0159
            kotlin.coroutines.CombinedContext r0 = new kotlin.coroutines.CombinedContext
            r0.<init>(r9, r10)
        L_0x0157:
            r10 = r0
            goto L_0x0171
        L_0x0159:
            kotlin.coroutines.CoroutineContext r9 = r9.minusKey(r1)
            if (r9 != r0) goto L_0x0166
            kotlin.coroutines.CombinedContext r9 = new kotlin.coroutines.CombinedContext
            r9.<init>(r10, r2)
            r10 = r9
            goto L_0x0171
        L_0x0166:
            kotlin.coroutines.CombinedContext r0 = new kotlin.coroutines.CombinedContext
            kotlin.coroutines.CombinedContext r1 = new kotlin.coroutines.CombinedContext
            r1.<init>(r9, r10)
            r0.<init>(r1, r2)
            goto L_0x0157
        L_0x0171:
            return r10
        L_0x0172:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r10 = kotlinx.coroutines.debug.internal.ConcurrentWeakMap.d
            return r9
        L_0x0175:
            java.lang.String r9 = (java.lang.String) r9
            kotlin.coroutines.CoroutineContext$Element r10 = (kotlin.coroutines.CoroutineContext.Element) r10
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            int r0 = r9.length()
            if (r0 != 0) goto L_0x018a
            java.lang.String r9 = r10.toString()
            goto L_0x019e
        L_0x018a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r9)
            java.lang.String r9 = ", "
            r0.append(r9)
            r0.append(r10)
            java.lang.String r9 = r0.toString()
        L_0x019e:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.e3.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
    }
}
