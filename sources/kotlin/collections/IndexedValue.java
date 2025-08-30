package kotlin.collections;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lkotlin/collections/IndexedValue;", "T", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IndexedValue<T> {

    /* renamed from: a  reason: collision with root package name */
    public final int f700a;
    public final Object b;

    public IndexedValue(int i, Object obj) {
        this.f700a = i;
        this.b = obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000a, code lost:
        r5 = (kotlin.collections.IndexedValue) r5;
        r1 = r5.f700a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof kotlin.collections.IndexedValue
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            kotlin.collections.IndexedValue r5 = (kotlin.collections.IndexedValue) r5
            int r1 = r5.f700a
            int r3 = r4.f700a
            if (r3 == r1) goto L_0x0013
            return r2
        L_0x0013:
            java.lang.Object r1 = r4.b
            java.lang.Object r5 = r5.b
            boolean r5 = kotlin.jvm.internal.Intrinsics.a(r1, r5)
            if (r5 != 0) goto L_0x001e
            return r2
        L_0x001e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.IndexedValue.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i = this.f700a * 31;
        Object obj = this.b;
        return i + (obj == null ? 0 : obj.hashCode());
    }

    public final String toString() {
        return "IndexedValue(index=" + this.f700a + ", value=" + this.b + ')';
    }
}
