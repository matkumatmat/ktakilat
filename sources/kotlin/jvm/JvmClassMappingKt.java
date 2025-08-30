package kotlin.jvm;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
@JvmName(name = "JvmClassMappingKt")
public final class JvmClassMappingKt {
    public static final Class a(KClass kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Class e = ((ClassBasedDeclarationContainer) kClass).e();
        Intrinsics.d(e, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return e;
    }

    public static final Class b(KClass kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Class e = ((ClassBasedDeclarationContainer) kClass).e();
        if (!e.isPrimitive()) {
            return e;
        }
        String name = e.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (!name.equals("double")) {
                    return e;
                }
                return Double.class;
            case 104431:
                if (!name.equals("int")) {
                    return e;
                }
                return Integer.class;
            case 3039496:
                if (!name.equals("byte")) {
                    return e;
                }
                return Byte.class;
            case 3052374:
                if (!name.equals("char")) {
                    return e;
                }
                return Character.class;
            case 3327612:
                if (!name.equals("long")) {
                    return e;
                }
                return Long.class;
            case 3625364:
                if (!name.equals("void")) {
                    return e;
                }
                return Void.class;
            case 64711720:
                if (!name.equals(TypedValues.Custom.S_BOOLEAN)) {
                    return e;
                }
                return Boolean.class;
            case 97526364:
                if (!name.equals(TypedValues.Custom.S_FLOAT)) {
                    return e;
                }
                return Float.class;
            case 109413500:
                if (!name.equals("short")) {
                    return e;
                }
                return Short.class;
            default:
                return e;
        }
    }
}
