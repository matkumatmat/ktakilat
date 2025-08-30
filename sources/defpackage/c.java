package defpackage;

import kotlin.jvm.functions.Function0;

/* renamed from: c  reason: default package */
public final /* synthetic */ class c implements Function0 {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ c(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    /* JADX WARNING: type inference failed for: r0v30, types: [coil3.memory.MemoryCache$Builder, java.lang.Object] */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0181, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0182, code lost:
        kotlin.jdk7.AutoCloseableKt.a(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0185, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke() {
        /*
            r7 = this;
            int r0 = r7.c
            switch(r0) {
                case 0: goto L_0x01b3;
                case 1: goto L_0x01a3;
                case 2: goto L_0x019a;
                case 3: goto L_0x0186;
                case 4: goto L_0x008c;
                case 5: goto L_0x0017;
                case 6: goto L_0x0008;
                default: goto L_0x0005;
            }
        L_0x0005:
            java.lang.Object r0 = r7.d
            return r0
        L_0x0008:
            java.lang.Object r0 = r7.d
            coil3.RealImageLoader r0 = (coil3.RealImageLoader) r0
            coil3.RealImageLoader$Options r0 = r0.f60a
            kotlin.Lazy r0 = r0.d
            java.lang.Object r0 = r0.getValue()
            coil3.disk.DiskCache r0 = (coil3.disk.DiskCache) r0
            return r0
        L_0x0017:
            coil3.memory.MemoryCache$Builder r0 = new coil3.memory.MemoryCache$Builder
            r0.<init>()
            java.lang.Object r1 = r7.d
            coil3.ImageLoader$Builder r1 = (coil3.ImageLoader.Builder) r1
            android.content.Context r1 = r1.f57a
            r2 = 4596373779694328218(0x3fc999999999999a, double:0.2)
            java.lang.Class<android.app.ActivityManager> r4 = android.app.ActivityManager.class
            java.lang.Object r4 = androidx.core.content.ContextCompat.getSystemService(r1, r4)     // Catch:{ Exception -> 0x003e }
            kotlin.jvm.internal.Intrinsics.c(r4)     // Catch:{ Exception -> 0x003e }
            android.app.ActivityManager r4 = (android.app.ActivityManager) r4     // Catch:{ Exception -> 0x003e }
            boolean r4 = r4.isLowRamDevice()     // Catch:{ Exception -> 0x003e }
            if (r4 == 0) goto L_0x003f
            r2 = 4594572339843380019(0x3fc3333333333333, double:0.15)
            goto L_0x003f
        L_0x003e:
        L_0x003f:
            r4 = 0
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 > 0) goto L_0x0084
            r4 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x0084
            oc r4 = new oc
            r4.<init>(r2, r1)
            r0.f111a = r4
            coil3.memory.RealWeakMemoryCache r1 = new coil3.memory.RealWeakMemoryCache
            r1.<init>()
            oc r0 = r0.f111a
            if (r0 == 0) goto L_0x007c
            java.lang.Object r0 = r0.invoke()
            java.lang.Number r0 = (java.lang.Number) r0
            long r2 = r0.longValue()
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0071
            coil3.memory.RealStrongMemoryCache r0 = new coil3.memory.RealStrongMemoryCache
            r0.<init>(r2, r1)
            goto L_0x0076
        L_0x0071:
            coil3.memory.EmptyStrongMemoryCache r0 = new coil3.memory.EmptyStrongMemoryCache
            r0.<init>(r1)
        L_0x0076:
            coil3.memory.RealMemoryCache r2 = new coil3.memory.RealMemoryCache
            r2.<init>(r0, r1)
            return r2
        L_0x007c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "maxSizeBytesFactory == null"
            r0.<init>(r1)
            throw r0
        L_0x0084:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "percent must be in the range [0.0, 1.0]."
            r0.<init>(r1)
            throw r0
        L_0x008c:
            java.lang.Object r0 = r7.d
            coil3.gif.GifDecoder r0 = (coil3.gif.GifDecoder) r0
            coil3.decode.ImageSource r1 = r0.f101a
            boolean r2 = r0.c
            coil3.decode.ImageSource r1 = coil3.gif.internal.FrameDelayRewritingSourceKt.a(r1, r2)
            okio.BufferedSource r2 = r1.source()     // Catch:{ all -> 0x017f }
            java.io.InputStream r2 = r2.inputStream()     // Catch:{ all -> 0x017f }
            android.graphics.Movie r2 = android.graphics.Movie.decodeStream(r2)     // Catch:{ all -> 0x017f }
            r3 = 0
            kotlin.jdk7.AutoCloseableKt.a(r1, r3)
            if (r2 == 0) goto L_0x0177
            int r1 = r2.width()
            if (r1 <= 0) goto L_0x0177
            int r1 = r2.height()
            if (r1 <= 0) goto L_0x0177
            coil3.gif.MovieDrawable r1 = new coil3.gif.MovieDrawable
            boolean r4 = r2.isOpaque()
            coil3.request.Options r0 = r0.b
            if (r4 == 0) goto L_0x00d1
            coil3.Extras$Key r4 = coil3.request.ImageRequests_androidKt.i
            java.lang.Object r4 = coil3.ExtrasKt.b(r0, r4)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x00d1
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.RGB_565
            goto L_0x00e6
        L_0x00d1:
            android.graphics.Bitmap$Config r4 = coil3.request.ImageRequests_androidKt.a(r0)
            boolean r4 = coil3.util.BitmapsKt.a(r4)
            if (r4 == 0) goto L_0x00de
            android.graphics.Bitmap$Config r4 = android.graphics.Bitmap.Config.ARGB_8888
            goto L_0x00e6
        L_0x00de:
            coil3.Extras$Key r4 = coil3.request.ImageRequests_androidKt.c
            java.lang.Object r4 = coil3.ExtrasKt.b(r0, r4)
            android.graphics.Bitmap$Config r4 = (android.graphics.Bitmap.Config) r4
        L_0x00e6:
            coil3.size.Scale r5 = r0.c
            r1.<init>(r2, r4, r5)
            coil3.Extras$Key r2 = coil3.gif.ImageRequestsKt.f103a
            java.lang.Object r2 = coil3.ExtrasKt.b(r0, r2)
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            r4 = -1
            if (r2 < r4) goto L_0x0167
            r1.t = r2
            coil3.Extras$Key r2 = coil3.gif.ImageRequestsKt.c
            java.lang.Object r2 = coil3.ExtrasKt.b(r0, r2)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            coil3.Extras$Key r4 = coil3.gif.ImageRequestsKt.d
            java.lang.Object r4 = coil3.ExtrasKt.b(r0, r4)
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            if (r2 != 0) goto L_0x0110
            if (r4 == 0) goto L_0x0118
        L_0x0110:
            coil3.gif.internal.UtilsKt$animatable2CompatCallbackOf$1 r5 = new coil3.gif.internal.UtilsKt$animatable2CompatCallbackOf$1
            r5.<init>(r2, r4)
            r1.registerAnimationCallback(r5)
        L_0x0118:
            coil3.Extras$Key r2 = coil3.gif.ImageRequestsKt.b
            java.lang.Object r0 = coil3.ExtrasKt.b(r0, r2)
            coil3.gif.AnimatedTransformation r0 = (coil3.gif.AnimatedTransformation) r0
            r1.u = r0
            r2 = 0
            if (r0 == 0) goto L_0x0152
            android.graphics.Movie r4 = r1.c
            int r5 = r4.width()
            if (r5 <= 0) goto L_0x0152
            int r5 = r4.height()
            if (r5 <= 0) goto L_0x0152
            android.graphics.Picture r3 = new android.graphics.Picture
            r3.<init>()
            int r5 = r4.width()
            int r4 = r4.height()
            r3.beginRecording(r5, r4)
            coil3.gif.PixelOpacity r0 = r0.a()
            r1.w = r0
            r3.endRecording()
            r1.v = r3
            r0 = 1
            r1.x = r0
            goto L_0x015a
        L_0x0152:
            r1.v = r3
            coil3.gif.PixelOpacity r0 = coil3.gif.PixelOpacity.UNCHANGED
            r1.w = r0
            r1.x = r2
        L_0x015a:
            r1.invalidateSelf()
            coil3.decode.DecodeResult r0 = new coil3.decode.DecodeResult
            coil3.Image r1 = coil3.Image_androidKt.b(r1)
            r0.<init>(r1, r2)
            return r0
        L_0x0167:
            java.lang.String r0 = "Invalid repeatCount: "
            java.lang.String r0 = defpackage.ba.k(r2, r0)
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x0177:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Failed to decode GIF."
            r0.<init>(r1)
            throw r0
        L_0x017f:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0181 }
        L_0x0181:
            r2 = move-exception
            kotlin.jdk7.AutoCloseableKt.a(r1, r0)
            throw r2
        L_0x0186:
            java.lang.Object r0 = r7.d
            com.ktakilat.loan.weiget.FaceLoginOnOffUtil r0 = (com.ktakilat.loan.weiget.FaceLoginOnOffUtil) r0
            r0.getClass()
            y6 r1 = new y6
            r2 = 1
            r1.<init>(r0, r2)
            com.ktakilat.cbase.ui.BaseActivity r0 = r0.f584a
            r0.runOnUiThread(r1)
            r0 = 0
            return r0
        L_0x019a:
            java.lang.Object r0 = r7.d
            kotlin.Pair r0 = (kotlin.Pair) r0
            java.util.List r0 = kotlin.collections.CollectionsKt.s(r0)
            return r0
        L_0x01a3:
            java.lang.Object r0 = r7.d
            com.ktakilat.loan.web.CommonWebFragment r0 = (com.ktakilat.loan.web.CommonWebFragment) r0
            android.content.Context r0 = r0.getContext()
            r1 = 2131755266(0x7f100102, float:1.9141406E38)
            com.ktakilat.cbase.utils.ToastUtil.b(r0, r1)
            r0 = 0
            return r0
        L_0x01b3:
            java.lang.Object r0 = r7.d
            kotlin.time.AbstractLongTimeSource r0 = (kotlin.time.AbstractLongTimeSource) r0
            r0.getClass()
            r0 = 0
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.c.invoke():java.lang.Object");
    }
}
