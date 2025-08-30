package kotlin.jvm.internal;

import kotlin.reflect.KClass;

public class Reflection {

    /* renamed from: a  reason: collision with root package name */
    public static final ReflectionFactory f727a;
    public static final KClass[] b = new KClass[0];

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: kotlin.jvm.internal.ReflectionFactory} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: kotlin.jvm.internal.ReflectionFactory} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: kotlin.jvm.internal.ReflectionFactory} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: kotlin.jvm.internal.ReflectionFactory} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: kotlin.jvm.internal.ReflectionFactory} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 0
            java.lang.String r1 = "kotlin.reflect.jvm.internal.ReflectionFactoryImpl"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException -> 0x000f }
            java.lang.Object r1 = r1.newInstance()     // Catch:{ ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException -> 0x000f }
            kotlin.jvm.internal.ReflectionFactory r1 = (kotlin.jvm.internal.ReflectionFactory) r1     // Catch:{ ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException -> 0x000f }
            r0 = r1
            goto L_0x0010
        L_0x000f:
        L_0x0010:
            if (r0 == 0) goto L_0x0013
            goto L_0x0018
        L_0x0013:
            kotlin.jvm.internal.ReflectionFactory r0 = new kotlin.jvm.internal.ReflectionFactory
            r0.<init>()
        L_0x0018:
            f727a = r0
            r0 = 0
            kotlin.reflect.KClass[] r0 = new kotlin.reflect.KClass[r0]
            b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.Reflection.<clinit>():void");
    }

    public static ClassReference a(Class cls) {
        f727a.getClass();
        return new ClassReference(cls);
    }
}
