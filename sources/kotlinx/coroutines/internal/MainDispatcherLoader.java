package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.MainCoroutineDispatcher;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/internal/MainDispatcherLoader;", "", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMainDispatchers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainDispatchers.kt\nkotlinx/coroutines/internal/MainDispatcherLoader\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,130:1\n1971#2,14:131\n*S KotlinDebug\n*F\n+ 1 MainDispatchers.kt\nkotlinx/coroutines/internal/MainDispatcherLoader\n*L\n34#1:131,14\n*E\n"})
public final class MainDispatcherLoader {

    /* renamed from: a  reason: collision with root package name */
    public static final MainCoroutineDispatcher f801a;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: kotlinx.coroutines.internal.MainDispatcherFactory} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.fast.service.loader"
            java.lang.String r0 = kotlinx.coroutines.internal.SystemPropsKt.c(r0)
            if (r0 == 0) goto L_0x000b
            java.lang.Boolean.parseBoolean(r0)
        L_0x000b:
            java.lang.Class<kotlinx.coroutines.internal.MainDispatcherFactory> r0 = kotlinx.coroutines.internal.MainDispatcherFactory.class
            java.lang.ClassLoader r1 = r0.getClassLoader()
            java.util.ServiceLoader r0 = java.util.ServiceLoader.load(r0, r1)
            java.util.Iterator r0 = r0.iterator()
            kotlin.sequences.ConstrainedOnceSequence r0 = kotlin.sequences.SequencesKt.c(r0)
            java.util.List r0 = kotlin.sequences.SequencesKt.l(r0)
            r1 = r0
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
            boolean r2 = r1.hasNext()
            if (r2 != 0) goto L_0x0030
            r1 = 0
            goto L_0x0059
        L_0x0030:
            java.lang.Object r2 = r1.next()
            boolean r3 = r1.hasNext()
            if (r3 != 0) goto L_0x003c
        L_0x003a:
            r1 = r2
            goto L_0x0059
        L_0x003c:
            r3 = r2
            kotlinx.coroutines.internal.MainDispatcherFactory r3 = (kotlinx.coroutines.internal.MainDispatcherFactory) r3
            int r3 = r3.c()
        L_0x0043:
            java.lang.Object r4 = r1.next()
            r5 = r4
            kotlinx.coroutines.internal.MainDispatcherFactory r5 = (kotlinx.coroutines.internal.MainDispatcherFactory) r5
            int r5 = r5.c()
            if (r3 >= r5) goto L_0x0052
            r2 = r4
            r3 = r5
        L_0x0052:
            boolean r4 = r1.hasNext()
            if (r4 != 0) goto L_0x0043
            goto L_0x003a
        L_0x0059:
            kotlinx.coroutines.internal.MainDispatcherFactory r1 = (kotlinx.coroutines.internal.MainDispatcherFactory) r1
            if (r1 == 0) goto L_0x006b
            kotlinx.coroutines.MainCoroutineDispatcher r0 = r1.b(r0)     // Catch:{ all -> 0x0066 }
            if (r0 == 0) goto L_0x006b
            f801a = r0
            return
        L_0x0066:
            r0 = move-exception
            r1.a()
            throw r0
        L_0x006b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.MainDispatcherLoader.<clinit>():void");
    }
}
