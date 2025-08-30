package kotlin.reflect;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@SourceDebugExtension({"SMAP\nTypesJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/TypeVariableImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,230:1\n1557#2:231\n1628#2,3:232\n37#3:235\n36#3,3:236\n*S KotlinDebug\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/TypeVariableImpl\n*L\n116#1:231\n116#1:232,3\n116#1:235\n116#1:236,3\n*E\n"})
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/reflect/TypeVariableImpl;", "Ljava/lang/reflect/TypeVariable;", "Ljava/lang/reflect/GenericDeclaration;", "Lkotlin/reflect/TypeImpl;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@ExperimentalStdlibApi
final class TypeVariableImpl implements TypeVariable<GenericDeclaration>, TypeImpl {
    public final KTypeParameter c;

    public TypeVariableImpl(KTypeParameter kTypeParameter) {
        Intrinsics.checkNotNullParameter(kTypeParameter, "typeParameter");
        this.c = kTypeParameter;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TypeVariable)) {
            return false;
        }
        this.c.getClass();
        if (!Intrinsics.a((Object) null, ((TypeVariable) obj).getName())) {
            return false;
        }
        getGenericDeclaration();
        throw null;
    }

    public final Type[] getBounds() {
        Object obj;
        Object obj2;
        Iterable<KType> upperBounds = this.c.getUpperBounds();
        ArrayList arrayList = new ArrayList(CollectionsKt.h(upperBounds));
        for (KType kType : upperBounds) {
            KClassifier c2 = kType.c();
            if (c2 instanceof KTypeParameter) {
                obj = new TypeVariableImpl((KTypeParameter) c2);
            } else if (c2 instanceof KClass) {
                Class b = JvmClassMappingKt.b((KClass) c2);
                List b2 = kType.b();
                if (!b2.isEmpty()) {
                    if (!b.isArray()) {
                        obj = TypesJVMKt.b(b, b2);
                    } else if (!b.getComponentType().isPrimitive()) {
                        Intrinsics.checkNotNullParameter(b2, "<this>");
                        if (b2.size() == 1) {
                            obj2 = b2.get(0);
                        } else {
                            obj2 = null;
                        }
                        if (((KTypeProjection) obj2) == null) {
                            throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + kType);
                        }
                    }
                }
                obj = b;
            } else {
                throw new UnsupportedOperationException("Unsupported type classifier: " + kType);
            }
            arrayList.add(obj);
        }
        return (Type[]) arrayList.toArray(new Type[0]);
    }

    public final GenericDeclaration getGenericDeclaration() {
        throw new NotImplementedError(e.B("An operation is not implemented: ", "getGenericDeclaration() is not yet supported for type variables created from KType: " + this.c));
    }

    public final String getName() {
        this.c.getClass();
        return null;
    }

    public final String getTypeName() {
        this.c.getClass();
        return null;
    }

    public final int hashCode() {
        this.c.getClass();
        throw null;
    }

    public final String toString() {
        this.c.getClass();
        return null;
    }
}
