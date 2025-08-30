package kotlin.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lkotlin/reflect/ParameterizedTypeImpl;", "Ljava/lang/reflect/ParameterizedType;", "Lkotlin/reflect/TypeImpl;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTypesJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/ParameterizedTypeImpl\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,230:1\n37#2:231\n36#2,3:232\n*S KotlinDebug\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/ParameterizedTypeImpl\n*L\n190#1:231\n190#1:232,3\n*E\n"})
@ExperimentalStdlibApi
final class ParameterizedTypeImpl implements ParameterizedType, TypeImpl {
    public final Class c;
    public final Type d;
    public final Type[] e;

    public ParameterizedTypeImpl(Class cls, Type type, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(cls, "rawType");
        Intrinsics.checkNotNullParameter(arrayList, "typeArguments");
        this.c = cls;
        this.d = type;
        this.e = (Type[]) arrayList.toArray(new Type[0]);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            if (Intrinsics.a(this.c, parameterizedType.getRawType()) && Intrinsics.a(this.d, parameterizedType.getOwnerType())) {
                if (Arrays.equals(this.e, parameterizedType.getActualTypeArguments())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final Type[] getActualTypeArguments() {
        return this.e;
    }

    public final Type getOwnerType() {
        return this.d;
    }

    public final Type getRawType() {
        return this.c;
    }

    public final String getTypeName() {
        StringBuilder sb = new StringBuilder();
        Class cls = this.c;
        Type type = this.d;
        if (type != null) {
            sb.append(TypesJVMKt.a(type));
            sb.append("$");
            sb.append(cls.getSimpleName());
        } else {
            sb.append(TypesJVMKt.a(cls));
        }
        Type[] typeArr = this.e;
        if (typeArr.length != 0) {
            ArraysKt___ArraysKt.b(typeArr, sb, ", ", "<", ">", -1, "...", ParameterizedTypeImpl$getTypeName$1$1.c);
        }
        return sb.toString();
    }

    public final int hashCode() {
        int i;
        int hashCode = this.c.hashCode();
        Type type = this.d;
        if (type != null) {
            i = type.hashCode();
        } else {
            i = 0;
        }
        return (hashCode ^ i) ^ Arrays.hashCode(this.e);
    }

    public final String toString() {
        return getTypeName();
    }
}
