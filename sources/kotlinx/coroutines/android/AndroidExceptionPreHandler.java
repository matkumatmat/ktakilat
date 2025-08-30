package kotlinx.coroutines.android;

import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlinx.coroutines.CoroutineExceptionHandler;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/android/AndroidExceptionPreHandler;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "<init>", "()V", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "D", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Throwable;)V", "", "_preHandler", "Ljava/lang/Object;", "kotlinx-coroutines-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidExceptionPreHandler extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    @Nullable
    private volatile Object _preHandler = this;

    public AndroidExceptionPreHandler() {
        super(CoroutineExceptionHandler.Key.c);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        if (java.lang.reflect.Modifier.isStatic(r3.getModifiers()) != false) goto L_0x0030;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void D(kotlin.coroutines.CoroutineContext r3, java.lang.Throwable r4) {
        /*
            r2 = this;
            int r3 = android.os.Build.VERSION.SDK_INT
            r0 = 26
            if (r0 > r3) goto L_0x004a
            r0 = 28
            if (r3 >= r0) goto L_0x004a
            java.lang.Object r3 = r2._preHandler
            r0 = 0
            if (r3 == r2) goto L_0x0012
            java.lang.reflect.Method r3 = (java.lang.reflect.Method) r3
            goto L_0x0032
        L_0x0012:
            java.lang.Class<java.lang.Thread> r3 = java.lang.Thread.class
            java.lang.String r1 = "getUncaughtExceptionPreHandler"
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r1, r0)     // Catch:{ all -> 0x002f }
            int r1 = r3.getModifiers()     // Catch:{ all -> 0x002f }
            boolean r1 = java.lang.reflect.Modifier.isPublic(r1)     // Catch:{ all -> 0x002f }
            if (r1 == 0) goto L_0x002f
            int r1 = r3.getModifiers()     // Catch:{ all -> 0x002f }
            boolean r1 = java.lang.reflect.Modifier.isStatic(r1)     // Catch:{ all -> 0x002f }
            if (r1 == 0) goto L_0x002f
            goto L_0x0030
        L_0x002f:
            r3 = r0
        L_0x0030:
            r2._preHandler = r3
        L_0x0032:
            if (r3 == 0) goto L_0x0039
            java.lang.Object r3 = r3.invoke(r0, r0)
            goto L_0x003a
        L_0x0039:
            r3 = r0
        L_0x003a:
            boolean r1 = r3 instanceof java.lang.Thread.UncaughtExceptionHandler
            if (r1 == 0) goto L_0x0041
            r0 = r3
            java.lang.Thread$UncaughtExceptionHandler r0 = (java.lang.Thread.UncaughtExceptionHandler) r0
        L_0x0041:
            if (r0 == 0) goto L_0x004a
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            r0.uncaughtException(r3, r4)
        L_0x004a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.android.AndroidExceptionPreHandler.D(kotlin.coroutines.CoroutineContext, java.lang.Throwable):void");
    }
}
