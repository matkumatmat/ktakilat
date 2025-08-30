package kotlin.jvm.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/jvm/internal/TypeReference;", "Lkotlin/reflect/KType;", "e", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SinceKotlin(version = "1.4")
public final class TypeReference implements KType {
    @NotNull
    public static final Companion e = new Companion((DefaultConstructorMarker) null);
    public final ClassReference c;
    public final List d;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"Lkotlin/jvm/internal/TypeReference$Companion;", "", "", "IS_MARKED_NULLABLE", "I", "IS_MUTABLE_COLLECTION_TYPE", "IS_NOTHING_TYPE", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                kotlin.reflect.KVariance[] r0 = kotlin.reflect.KVariance.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.reflect.KVariance r1 = kotlin.reflect.KVariance.INVARIANT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlin.reflect.KVariance r1 = kotlin.reflect.KVariance.IN     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlin.reflect.KVariance r1 = kotlin.reflect.KVariance.OUT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.TypeReference.WhenMappings.<clinit>():void");
        }
    }

    public TypeReference(ClassReference classReference, List list) {
        Intrinsics.checkNotNullParameter(classReference, "classifier");
        Intrinsics.checkNotNullParameter(list, "arguments");
        Intrinsics.checkNotNullParameter(classReference, "classifier");
        Intrinsics.checkNotNullParameter(list, "arguments");
        this.c = classReference;
        this.d = list;
    }

    public final List b() {
        return this.d;
    }

    public final KClassifier c() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof TypeReference) {
            TypeReference typeReference = (TypeReference) obj;
            if (!this.c.equals(typeReference.c) || !Intrinsics.a(this.d, typeReference.d) || !Intrinsics.a((Object) null, (Object) null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((this.d.hashCode() + (this.c.hashCode() * 31)) * 31) + 1;
    }

    public final String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        Class a2 = JvmClassMappingKt.a(this.c);
        if (!a2.isArray()) {
            str = a2.getName();
        } else if (a2.equals(boolean[].class)) {
            str = "kotlin.BooleanArray";
        } else if (a2.equals(char[].class)) {
            str = "kotlin.CharArray";
        } else if (a2.equals(byte[].class)) {
            str = "kotlin.ByteArray";
        } else if (a2.equals(short[].class)) {
            str = "kotlin.ShortArray";
        } else if (a2.equals(int[].class)) {
            str = "kotlin.IntArray";
        } else if (a2.equals(float[].class)) {
            str = "kotlin.FloatArray";
        } else if (a2.equals(long[].class)) {
            str = "kotlin.LongArray";
        } else if (a2.equals(double[].class)) {
            str = "kotlin.DoubleArray";
        } else {
            str = "kotlin.Array";
        }
        List list = this.d;
        if (list.isEmpty()) {
            str2 = "";
        } else {
            str2 = CollectionsKt.p(list, ", ", "<", ">", new a(this, 10), 24);
        }
        sb.append(e.m(str, str2, "?"));
        sb.append(" (Kotlin reflection is not available)");
        return sb.toString();
    }
}
