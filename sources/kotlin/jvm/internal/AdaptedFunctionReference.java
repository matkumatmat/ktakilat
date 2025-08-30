package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.SinceKotlin;
import kotlin.reflect.KDeclarationContainer;

@SinceKotlin(version = "1.4")
public class AdaptedFunctionReference implements FunctionBase, Serializable {
    public final Object c;
    public final Class d;
    public final String e;
    public final String f;
    public final boolean g;
    public final int i;
    public final int j;

    public AdaptedFunctionReference(int i2, Class cls, String str, String str2, int i3) {
        this(i2, CallableReference.NO_RECEIVER, cls, str, str2, i3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000a, code lost:
        r5 = (kotlin.jvm.internal.AdaptedFunctionReference) r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof kotlin.jvm.internal.AdaptedFunctionReference
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            kotlin.jvm.internal.AdaptedFunctionReference r5 = (kotlin.jvm.internal.AdaptedFunctionReference) r5
            boolean r1 = r5.g
            boolean r3 = r4.g
            if (r3 != r1) goto L_0x0047
            int r1 = r4.i
            int r3 = r5.i
            if (r1 != r3) goto L_0x0047
            int r1 = r4.j
            int r3 = r5.j
            if (r1 != r3) goto L_0x0047
            java.lang.Object r1 = r4.c
            java.lang.Object r3 = r5.c
            boolean r1 = kotlin.jvm.internal.Intrinsics.a(r1, r3)
            if (r1 == 0) goto L_0x0047
            java.lang.Class r1 = r4.d
            java.lang.Class r3 = r5.d
            boolean r1 = kotlin.jvm.internal.Intrinsics.a(r1, r3)
            if (r1 == 0) goto L_0x0047
            java.lang.String r1 = r4.e
            java.lang.String r3 = r5.e
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0047
            java.lang.String r1 = r4.f
            java.lang.String r5 = r5.f
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x0047
            goto L_0x0048
        L_0x0047:
            r0 = 0
        L_0x0048:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.AdaptedFunctionReference.equals(java.lang.Object):boolean");
    }

    public int getArity() {
        return this.i;
    }

    public KDeclarationContainer getOwner() {
        Class cls = this.d;
        if (cls == null) {
            return null;
        }
        if (!this.g) {
            return Reflection.a(cls);
        }
        Reflection.f727a.getClass();
        return new PackageReference(cls);
    }

    public int hashCode() {
        int i2;
        int i3;
        int i4 = 0;
        Object obj = this.c;
        if (obj != null) {
            i2 = obj.hashCode();
        } else {
            i2 = 0;
        }
        int i5 = i2 * 31;
        Class cls = this.d;
        if (cls != null) {
            i4 = cls.hashCode();
        }
        int d2 = ba.d(ba.d((i5 + i4) * 31, 31, this.e), 31, this.f);
        if (this.g) {
            i3 = 1231;
        } else {
            i3 = 1237;
        }
        return ((((d2 + i3) * 31) + this.i) * 31) + this.j;
    }

    public String toString() {
        Reflection.f727a.getClass();
        return ReflectionFactory.a(this);
    }

    public AdaptedFunctionReference(int i2, Object obj, Class cls, String str, String str2, int i3) {
        this.c = obj;
        this.d = cls;
        this.e = str;
        this.f = str2;
        this.g = (i3 & 1) == 1;
        this.i = i2;
        this.j = i3 >> 1;
    }
}
