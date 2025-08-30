package defpackage;

import kotlin.jvm.functions.Function0;

/* renamed from: x  reason: default package */
public final /* synthetic */ class x implements Function0 {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ x(int i, Object obj, Object obj2) {
        this.c = i;
        this.d = obj;
        this.e = obj2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0088, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        kotlin.io.CloseableKt.a(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008c, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009b, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009c, code lost:
        kotlin.jdk7.AutoCloseableKt.a(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009f, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke() {
        /*
            r7 = this;
            r0 = 0
            r1 = 1
            java.lang.Object r2 = r7.e
            java.lang.Object r3 = r7.d
            int r4 = r7.c
            switch(r4) {
                case 0: goto L_0x003a;
                case 1: goto L_0x0019;
                default: goto L_0x000b;
            }
        L_0x000b:
            kotlin.Pair r0 = new kotlin.Pair
            coil3.fetch.Fetcher$Factory r3 = (coil3.fetch.Fetcher.Factory) r3
            kotlin.jvm.internal.ClassReference r2 = (kotlin.jvm.internal.ClassReference) r2
            r0.<init>(r3, r2)
            java.util.List r0 = kotlin.collections.CollectionsKt.s(r0)
            return r0
        L_0x0019:
            int r4 = com.ktakilat.loan.verify_face.BaseVerifyFaceActivity.s
            o r4 = new o
            android.app.Activity r3 = (android.app.Activity) r3
            r4.<init>(r3, r1)
            com.ktakilat.loan.weiget.dialog.DialogUtils.e(r3, r4)
            com.google.firebase.crashlytics.FirebaseCrashlytics r1 = com.google.firebase.crashlytics.FirebaseCrashlytics.getInstance()
            java.lang.Throwable r3 = new java.lang.Throwable
            java.lang.String r4 = "百度sdk初始化失败"
            r3.<init>(r4)
            r1.recordException(r3)
            com.ktakilat.loan.verify_face.BaseVerifyFaceActivity$IntentCallback r2 = (com.ktakilat.loan.verify_face.BaseVerifyFaceActivity.IntentCallback) r2
            r2.a(r0)
            return r0
        L_0x003a:
            kotlin.jvm.internal.Ref$BooleanRef r2 = (kotlin.jvm.internal.Ref.BooleanRef) r2
            coil3.gif.AnimatedImageDecoder r3 = (coil3.gif.AnimatedImageDecoder) r3
            coil3.decode.ImageSource r4 = r3.f97a
            boolean r5 = r3.c
            coil3.decode.ImageSource r4 = coil3.gif.internal.FrameDelayRewritingSourceKt.a(r4, r5)
            coil3.request.Options r5 = r3.b     // Catch:{ all -> 0x0084 }
            android.graphics.ImageDecoder$Source r1 = coil3.decode.StaticImageDecoderKt.a(r4, r5, r1)     // Catch:{ all -> 0x0084 }
            if (r1 != 0) goto L_0x008d
            okio.BufferedSource r1 = r4.source()     // Catch:{ all -> 0x0084 }
            r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r1.request(r5)     // Catch:{ all -> 0x0086 }
            okio.Buffer r5 = r1.getBuffer()     // Catch:{ all -> 0x0086 }
            long r5 = r5.size()     // Catch:{ all -> 0x0086 }
            int r6 = (int) r5     // Catch:{ all -> 0x0086 }
            java.nio.ByteBuffer r5 = java.nio.ByteBuffer.allocateDirect(r6)     // Catch:{ all -> 0x0086 }
        L_0x0067:
            okio.Buffer r6 = r1.getBuffer()     // Catch:{ all -> 0x0086 }
            boolean r6 = r6.exhausted()     // Catch:{ all -> 0x0086 }
            if (r6 != 0) goto L_0x0079
            okio.Buffer r6 = r1.getBuffer()     // Catch:{ all -> 0x0086 }
            r6.read((java.nio.ByteBuffer) r5)     // Catch:{ all -> 0x0086 }
            goto L_0x0067
        L_0x0079:
            r5.flip()     // Catch:{ all -> 0x0086 }
            kotlin.io.CloseableKt.a(r1, r0)     // Catch:{ all -> 0x0084 }
            android.graphics.ImageDecoder$Source r1 = android.graphics.ImageDecoder.createSource(r5)     // Catch:{ all -> 0x0084 }
            goto L_0x008d
        L_0x0084:
            r0 = move-exception
            goto L_0x009a
        L_0x0086:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0088 }
        L_0x0088:
            r2 = move-exception
            kotlin.io.CloseableKt.a(r1, r0)     // Catch:{ all -> 0x0084 }
            throw r2     // Catch:{ all -> 0x0084 }
        L_0x008d:
            coil3.gif.AnimatedImageDecoder$decode$lambda$3$lambda$2$$inlined$decodeDrawable$1 r5 = new coil3.gif.AnimatedImageDecoder$decode$lambda$3$lambda$2$$inlined$decodeDrawable$1     // Catch:{ all -> 0x0084 }
            r5.<init>(r3, r2)     // Catch:{ all -> 0x0084 }
            android.graphics.drawable.Drawable r1 = android.graphics.ImageDecoder.decodeDrawable(r1, r5)     // Catch:{ all -> 0x0084 }
            kotlin.jdk7.AutoCloseableKt.a(r4, r0)
            return r1
        L_0x009a:
            throw r0     // Catch:{ all -> 0x009b }
        L_0x009b:
            r1 = move-exception
            kotlin.jdk7.AutoCloseableKt.a(r4, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.x.invoke():java.lang.Object");
    }
}
