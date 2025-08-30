package coil3.decode;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.RequiresApi;
import coil3.decode.Decoder;
import coil3.fetch.SourceFetchResult;
import coil3.request.ImageRequests_androidKt;
import coil3.request.Options;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.sync.Semaphore;

@RequiresApi(29)
@SourceDebugExtension({"SMAP\nStaticImageDecoder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StaticImageDecoder.kt\ncoil3/decode/StaticImageDecoder\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 ImageDecoder.kt\nandroidx/core/graphics/ImageDecoderKt\n*L\n1#1,167:1\n81#2,3:168\n85#2,2:172\n38#3:171\n*S KotlinDebug\n*F\n+ 1 StaticImageDecoder.kt\ncoil3/decode/StaticImageDecoder\n*L\n41#1:168,3\n41#1:172,2\n44#1:171\n*E\n"})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcoil3/decode/StaticImageDecoder;", "Lcoil3/decode/Decoder;", "Factory", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class StaticImageDecoder implements Decoder {

    /* renamed from: a  reason: collision with root package name */
    public final ImageDecoder.Source f77a;
    public final AutoCloseable b;
    public final Options c;
    public final Semaphore d;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/decode/StaticImageDecoder$Factory;", "Lcoil3/decode/Decoder$Factory;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Factory implements Decoder.Factory {

        /* renamed from: a  reason: collision with root package name */
        public final Semaphore f79a;

        public Factory(Semaphore semaphore) {
            this.f79a = semaphore;
        }

        public final Decoder a(SourceFetchResult sourceFetchResult, Options options) {
            ImageDecoder.Source a2;
            Bitmap.Config a3 = ImageRequests_androidKt.a(options);
            if ((a3 != Bitmap.Config.ARGB_8888 && a3 != Bitmap.Config.HARDWARE) || (a2 = StaticImageDecoderKt.a(sourceFetchResult.f96a, options, false)) == null) {
                return null;
            }
            return new StaticImageDecoder(a2, sourceFetchResult.f96a, options, this.f79a);
        }
    }

    public StaticImageDecoder(ImageDecoder.Source source, AutoCloseable autoCloseable, Options options, Semaphore semaphore) {
        this.f77a = source;
        this.b = autoCloseable;
        this.c = options;
        this.d = semaphore;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0078, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        kotlin.jdk7.AutoCloseableKt.a(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007c, code lost:
        throw r2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlin.coroutines.Continuation r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof coil3.decode.StaticImageDecoder$decode$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            coil3.decode.StaticImageDecoder$decode$1 r0 = (coil3.decode.StaticImageDecoder$decode$1) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.g = r1
            goto L_0x001a
        L_0x0013:
            coil3.decode.StaticImageDecoder$decode$1 r0 = new coil3.decode.StaticImageDecoder$decode$1
            kotlin.coroutines.jvm.internal.ContinuationImpl r7 = (kotlin.coroutines.jvm.internal.ContinuationImpl) r7
            r0.<init>(r6, r7)
        L_0x001a:
            java.lang.Object r7 = r0.e
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.g
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r1 = r0.d
            kotlinx.coroutines.sync.Semaphore r1 = (kotlinx.coroutines.sync.Semaphore) r1
            coil3.decode.StaticImageDecoder r0 = r0.c
            kotlin.ResultKt.b(r7)
            goto L_0x004e
        L_0x002f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0037:
            kotlin.ResultKt.b(r7)
            r0.c = r6
            kotlinx.coroutines.sync.Semaphore r7 = r6.d
            r0.d = r7
            r0.g = r3
            r2 = r7
            kotlinx.coroutines.sync.SemaphoreAndMutexImpl r2 = (kotlinx.coroutines.sync.SemaphoreAndMutexImpl) r2
            java.lang.Object r0 = r2.e(r0)
            if (r0 != r1) goto L_0x004c
            return r1
        L_0x004c:
            r0 = r6
            r1 = r7
        L_0x004e:
            java.lang.AutoCloseable r7 = r0.b     // Catch:{ all -> 0x0074 }
            kotlin.jvm.internal.Ref$BooleanRef r2 = new kotlin.jvm.internal.Ref$BooleanRef     // Catch:{ all -> 0x0076 }
            r2.<init>()     // Catch:{ all -> 0x0076 }
            android.graphics.ImageDecoder$Source r4 = r0.f77a     // Catch:{ all -> 0x0076 }
            coil3.decode.StaticImageDecoder$decode$lambda$2$lambda$1$$inlined$decodeBitmap$1 r5 = new coil3.decode.StaticImageDecoder$decode$lambda$2$lambda$1$$inlined$decodeBitmap$1     // Catch:{ all -> 0x0076 }
            r5.<init>(r0, r2)     // Catch:{ all -> 0x0076 }
            android.graphics.Bitmap r0 = android.graphics.ImageDecoder.decodeBitmap(r4, r5)     // Catch:{ all -> 0x0076 }
            coil3.decode.DecodeResult r4 = new coil3.decode.DecodeResult     // Catch:{ all -> 0x0076 }
            coil3.BitmapImage r5 = new coil3.BitmapImage     // Catch:{ all -> 0x0076 }
            r5.<init>(r0, r3)     // Catch:{ all -> 0x0076 }
            boolean r0 = r2.element     // Catch:{ all -> 0x0076 }
            r4.<init>(r5, r0)     // Catch:{ all -> 0x0076 }
            r0 = 0
            kotlin.jdk7.AutoCloseableKt.a(r7, r0)     // Catch:{ all -> 0x0074 }
            r1.release()
            return r4
        L_0x0074:
            r7 = move-exception
            goto L_0x007d
        L_0x0076:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0078 }
        L_0x0078:
            r2 = move-exception
            kotlin.jdk7.AutoCloseableKt.a(r7, r0)     // Catch:{ all -> 0x0074 }
            throw r2     // Catch:{ all -> 0x0074 }
        L_0x007d:
            r1.release()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.decode.StaticImageDecoder.a(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
