package kotlin.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u0000 \u00032\u00020\u00012\u00020\u0002:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/reflect/WildcardTypeImpl;", "Ljava/lang/reflect/WildcardType;", "Lkotlin/reflect/TypeImpl;", "e", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@ExperimentalStdlibApi
final class WildcardTypeImpl implements WildcardType, TypeImpl {
    @NotNull
    public static final Companion e = new Companion((DefaultConstructorMarker) null);
    public static final WildcardTypeImpl f = new WildcardTypeImpl((Type) null, (Type) null);
    public final Type c;
    public final Type d;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0003\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/reflect/WildcardTypeImpl$Companion;", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public WildcardTypeImpl(Type type, Type type2) {
        this.c = type;
        this.d = type2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) obj;
            if (!Arrays.equals(getUpperBounds(), wildcardType.getUpperBounds()) || !Arrays.equals(getLowerBounds(), wildcardType.getLowerBounds())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final Type[] getLowerBounds() {
        Type type = this.d;
        if (type == null) {
            return new Type[0];
        }
        return new Type[]{type};
    }

    public final String getTypeName() {
        Type type = this.d;
        if (type != null) {
            return "? super " + TypesJVMKt.a(type);
        }
        Type type2 = this.c;
        if (type2 == null || Intrinsics.a(type2, Object.class)) {
            return "?";
        }
        return "? extends " + TypesJVMKt.a(type2);
    }

    public final Type[] getUpperBounds() {
        Type type = this.c;
        if (type == null) {
            type = Object.class;
        }
        return new Type[]{type};
    }

    public final int hashCode() {
        return Arrays.hashCode(getUpperBounds()) ^ Arrays.hashCode(getLowerBounds());
    }

    public final String toString() {
        return getTypeName();
    }
}
