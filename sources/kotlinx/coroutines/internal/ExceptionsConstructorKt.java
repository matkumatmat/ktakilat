package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002*(\b\u0002\u0010\u0002\"\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000¨\u0006\u0003"}, d2 = {"Lkotlin/Function1;", "", "Ctor", "kotlinx-coroutines-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExceptionsConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExceptionsConstructor.kt\nkotlinx/coroutines/internal/ExceptionsConstructorKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,112:1\n1#2:113\n11102#3:114\n11437#3,3:115\n12671#3,3:132\n1971#4,14:118\n*S KotlinDebug\n*F\n+ 1 ExceptionsConstructor.kt\nkotlinx/coroutines/internal/ExceptionsConstructorKt\n*L\n41#1:114\n41#1:115,3\n78#1:132,3\n59#1:118,14\n*E\n"})
public final class ExceptionsConstructorKt {

    /* renamed from: a  reason: collision with root package name */
    public static final int f796a = b(Throwable.class, -1);

    static {
        WeakMapCtorCache weakMapCtorCache = WeakMapCtorCache.f810a;
        try {
            int i = FastServiceLoaderKt.f797a;
        } catch (Throwable unused) {
            WeakMapCtorCache weakMapCtorCache2 = WeakMapCtorCache.f810a;
        }
    }

    public static final Function1 a(Class cls) {
        Object obj;
        Function1 function1;
        Pair pair;
        ExceptionsConstructorKt$createConstructor$nullResult$1 exceptionsConstructorKt$createConstructor$nullResult$1 = ExceptionsConstructorKt$createConstructor$nullResult$1.c;
        if (f796a != b(cls, 0)) {
            return exceptionsConstructorKt$createConstructor$nullResult$1;
        }
        Constructor[] constructors = cls.getConstructors();
        ArrayList arrayList = new ArrayList(constructors.length);
        int length = constructors.length;
        int i = 0;
        while (true) {
            obj = null;
            if (i >= length) {
                break;
            }
            Constructor constructor = constructors[i];
            Class[] parameterTypes = constructor.getParameterTypes();
            int length2 = parameterTypes.length;
            if (length2 != 0) {
                Class<Throwable> cls2 = Throwable.class;
                Class<String> cls3 = String.class;
                if (length2 == 1) {
                    Class cls4 = parameterTypes[0];
                    if (Intrinsics.a(cls4, cls3)) {
                        pair = new Pair(new a(new r6(constructor, 1), 4), 2);
                    } else if (Intrinsics.a(cls4, cls2)) {
                        pair = new Pair(new a(new r6(constructor, 2), 4), 1);
                    } else {
                        pair = new Pair(null, -1);
                    }
                } else if (length2 != 2) {
                    pair = new Pair(null, -1);
                } else if (!Intrinsics.a(parameterTypes[0], cls3) || !Intrinsics.a(parameterTypes[1], cls2)) {
                    pair = new Pair(null, -1);
                } else {
                    pair = new Pair(new a(new r6(constructor, 0), 4), 3);
                }
            } else {
                pair = new Pair(new a(new r6(constructor, 3), 4), 0);
            }
            arrayList.add(pair);
            i++;
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            obj = it.next();
            if (it.hasNext()) {
                int intValue = ((Number) ((Pair) obj).getSecond()).intValue();
                do {
                    Object next = it.next();
                    int intValue2 = ((Number) ((Pair) next).getSecond()).intValue();
                    if (intValue < intValue2) {
                        obj = next;
                        intValue = intValue2;
                    }
                } while (it.hasNext());
            }
        }
        Pair pair2 = (Pair) obj;
        if (pair2 == null || (function1 = (Function1) pair2.getFirst()) == null) {
            return exceptionsConstructorKt$createConstructor$nullResult$1;
        }
        return function1;
    }

    public static final int b(Class cls, int i) {
        Integer num;
        Intrinsics.checkNotNullParameter(cls, "<this>");
        Reflection.a(cls);
        try {
            Result.Companion companion = Result.Companion;
            int i2 = 0;
            do {
                int i3 = 0;
                for (Field modifiers : cls.getDeclaredFields()) {
                    if (!Modifier.isStatic(modifiers.getModifiers())) {
                        i3++;
                    }
                }
                i2 += i3;
                cls = cls.getSuperclass();
            } while (cls != null);
            num = Result.m16constructorimpl(Integer.valueOf(i2));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            num = Result.m16constructorimpl(ResultKt.a(th));
        }
        Integer valueOf = Integer.valueOf(i);
        if (Result.m21isFailureimpl(num)) {
            num = valueOf;
        }
        return ((Number) num).intValue();
    }
}
