package coil3.intercept;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"coil-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nEngineInterceptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EngineInterceptor.kt\ncoil3/intercept/EngineInterceptorKt\n+ 2 logging.kt\ncoil3/util/LoggingKt\n+ 3 collections.kt\ncoil3/util/CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 bitmaps.kt\ncoil3/util/BitmapsKt\n+ 6 BitmapDrawable.kt\nandroidx/core/graphics/drawable/BitmapDrawableKt\n*L\n1#1,93:1\n68#2,4:94\n68#2,4:105\n68#2,4:109\n78#3,3:98\n82#3:102\n1#4:101\n51#5:103\n28#6:104\n*S KotlinDebug\n*F\n+ 1 EngineInterceptor.kt\ncoil3/intercept/EngineInterceptorKt\n*L\n41#1:94,4\n72#1:105,4\n78#1:109,4\n51#1:98,3\n51#1:102\n55#1:103\n55#1:104\n*E\n"})
public final class EngineInterceptorKt {
    /* JADX WARNING: type inference failed for: r0v8, types: [kotlin.coroutines.jvm.internal.ContinuationImpl] */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0090, code lost:
        if (kotlin.collections.ArraysKt.h(coil3.util.Utils_androidKt.f162a, r6) != false) goto L_0x00a8;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(coil3.intercept.EngineInterceptor.ExecuteResult r11, coil3.request.ImageRequest r12, coil3.request.Options r13, coil3.EventListener r14, kotlin.coroutines.jvm.internal.ContinuationImpl r15) {
        /*
            boolean r0 = r15 instanceof coil3.intercept.EngineInterceptorKt$transform$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            coil3.intercept.EngineInterceptorKt$transform$1 r0 = (coil3.intercept.EngineInterceptorKt$transform$1) r0
            int r1 = r0.l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.l = r1
            goto L_0x0018
        L_0x0013:
            coil3.intercept.EngineInterceptorKt$transform$1 r0 = new coil3.intercept.EngineInterceptorKt$transform$1
            r0.<init>(r15)
        L_0x0018:
            java.lang.Object r15 = r0.k
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.l
            r3 = 1
            if (r2 == 0) goto L_0x0047
            if (r2 != r3) goto L_0x003f
            int r11 = r0.j
            int r12 = r0.i
            java.util.List r13 = r0.g
            java.util.List r13 = (java.util.List) r13
            coil3.EventListener r14 = r0.f
            coil3.request.Options r2 = r0.e
            coil3.request.ImageRequest r4 = r0.d
            coil3.intercept.EngineInterceptor$ExecuteResult r5 = r0.c
            kotlin.ResultKt.b(r15)
            r9 = r0
            r0 = r13
            r13 = r4
            r4 = r9
            r10 = r2
            r2 = r14
            r14 = r10
            goto L_0x00e5
        L_0x003f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0047:
            kotlin.ResultKt.b(r15)
            coil3.Extras$Key r15 = coil3.request.ImageRequests_androidKt.f142a
            java.lang.Object r15 = coil3.ExtrasKt.a(r12, r15)
            java.util.List r15 = (java.util.List) r15
            boolean r2 = r15.isEmpty()
            if (r2 == 0) goto L_0x0059
            return r11
        L_0x0059:
            coil3.Image r2 = r11.f108a
            android.content.Context r4 = r12.f137a
            android.content.res.Resources r4 = r4.getResources()
            android.graphics.drawable.Drawable r2 = coil3.Image_androidKt.a(r2, r4)
            boolean r4 = r2 instanceof android.graphics.drawable.BitmapDrawable
            if (r4 != 0) goto L_0x0078
            coil3.Extras$Key r5 = coil3.request.ImageRequests_androidKt.g
            java.lang.Object r5 = coil3.ExtrasKt.a(r12, r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L_0x0078
            return r11
        L_0x0078:
            r5 = 0
            if (r4 == 0) goto L_0x0093
            r4 = r2
            android.graphics.drawable.BitmapDrawable r4 = (android.graphics.drawable.BitmapDrawable) r4
            android.graphics.Bitmap r4 = r4.getBitmap()
            android.graphics.Bitmap$Config r6 = r4.getConfig()
            if (r6 != 0) goto L_0x008a
            android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.ARGB_8888
        L_0x008a:
            android.graphics.Bitmap$Config[] r7 = coil3.util.Utils_androidKt.f162a
            boolean r6 = kotlin.collections.ArraysKt.h(r7, r6)
            if (r6 == 0) goto L_0x0093
            goto L_0x00a8
        L_0x0093:
            android.graphics.Bitmap$Config r4 = coil3.request.ImageRequests_androidKt.a(r13)
            coil3.size.Precision r6 = coil3.size.Precision.INEXACT
            coil3.size.Precision r7 = r13.d
            if (r7 != r6) goto L_0x009f
            r6 = 1
            goto L_0x00a0
        L_0x009f:
            r6 = 0
        L_0x00a0:
            coil3.size.Size r7 = r13.b
            coil3.size.Scale r8 = r13.c
            android.graphics.Bitmap r4 = coil3.util.DrawableUtils.a(r2, r4, r7, r8, r6)
        L_0x00a8:
            r14.getClass()
            r2 = r15
            java.util.Collection r2 = (java.util.Collection) r2
            int r2 = r2.size()
            r9 = r12
            r12 = r11
            r11 = r2
            r2 = r0
            r0 = r14
            r14 = r13
            r13 = r9
        L_0x00b9:
            if (r5 >= r11) goto L_0x00f8
            java.lang.Object r6 = r15.get(r5)
            coil3.transform.Transformation r6 = (coil3.transform.Transformation) r6
            coil3.size.Size r7 = r14.b
            r2.c = r12
            r2.d = r13
            r2.e = r14
            r2.f = r0
            r8 = r15
            java.util.List r8 = (java.util.List) r8
            r2.g = r8
            r2.i = r5
            r2.j = r11
            r2.l = r3
            android.graphics.Bitmap r4 = r6.a(r4, r7)
            if (r4 != r1) goto L_0x00dd
            return r1
        L_0x00dd:
            r9 = r5
            r5 = r12
            r12 = r9
            r10 = r0
            r0 = r15
            r15 = r4
            r4 = r2
            r2 = r10
        L_0x00e5:
            android.graphics.Bitmap r15 = (android.graphics.Bitmap) r15
            kotlin.coroutines.CoroutineContext r6 = r4.getContext()
            kotlinx.coroutines.JobKt.a(r6)
            int r12 = r12 + r3
            r9 = r5
            r5 = r12
            r12 = r9
            r10 = r4
            r4 = r15
            r15 = r0
            r0 = r2
            r2 = r10
            goto L_0x00b9
        L_0x00f8:
            r0.getClass()
            android.content.Context r11 = r13.f137a
            android.content.res.Resources r11 = r11.getResources()
            android.graphics.drawable.BitmapDrawable r13 = new android.graphics.drawable.BitmapDrawable
            r13.<init>(r11, r4)
            coil3.Image r11 = coil3.Image_androidKt.b(r13)
            boolean r13 = r12.b
            coil3.intercept.EngineInterceptor$ExecuteResult r14 = new coil3.intercept.EngineInterceptor$ExecuteResult
            coil3.decode.DataSource r15 = r12.c
            java.lang.String r12 = r12.d
            r14.<init>(r11, r13, r15, r12)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.intercept.EngineInterceptorKt.a(coil3.intercept.EngineInterceptor$ExecuteResult, coil3.request.ImageRequest, coil3.request.Options, coil3.EventListener, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
