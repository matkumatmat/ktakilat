package coil3.decode;

import coil3.decode.Decoder;
import coil3.fetch.SourceFetchResult;
import coil3.request.Options;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.sync.Semaphore;
import okio.Buffer;
import okio.ForwardingSource;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcoil3/decode/BitmapFactoryDecoder;", "Lcoil3/decode/Decoder;", "Factory", "ExceptionCatchingSource", "Companion", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBitmapFactoryDecoder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BitmapFactoryDecoder.kt\ncoil3/decode/BitmapFactoryDecoder\n+ 2 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 bitmaps.kt\ncoil3/util/BitmapsKt\n+ 5 BitmapDrawable.kt\nandroidx/core/graphics/drawable/BitmapDrawableKt\n+ 6 collections.kt\ncoil3/util/CollectionsKt\n*L\n1#1,211:1\n81#2,6:212\n1#3:218\n51#4:219\n28#5:220\n23#6,3:221\n*S KotlinDebug\n*F\n+ 1 BitmapFactoryDecoder.kt\ncoil3/decode/BitmapFactoryDecoder\n*L\n39#1:212,6\n86#1:219\n86#1:220\n127#1:221,3\n*E\n"})
public final class BitmapFactoryDecoder implements Decoder {

    /* renamed from: a  reason: collision with root package name */
    public final ImageSource f67a;
    public final Options b;
    public final Semaphore c;
    public final ExifOrientationStrategy d;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcoil3/decode/BitmapFactoryDecoder$Companion;", "", "", "DEFAULT_MAX_PARALLELISM", "I", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/decode/BitmapFactoryDecoder$ExceptionCatchingSource;", "Lokio/ForwardingSource;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ExceptionCatchingSource extends ForwardingSource {
        public Exception c;

        public final long read(Buffer buffer, long j) {
            try {
                return super.read(buffer, j);
            } catch (Exception e) {
                this.c = e;
                throw e;
            }
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/decode/BitmapFactoryDecoder$Factory;", "Lcoil3/decode/Decoder$Factory;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Factory implements Decoder.Factory {

        /* renamed from: a  reason: collision with root package name */
        public final Semaphore f68a;
        public final ExifOrientationStrategy b;

        public Factory(Semaphore semaphore, ExifOrientationStrategy exifOrientationStrategy) {
            this.f68a = semaphore;
            this.b = exifOrientationStrategy;
        }

        public final Decoder a(SourceFetchResult sourceFetchResult, Options options) {
            return new BitmapFactoryDecoder(sourceFetchResult.f96a, options, this.f68a, this.b);
        }
    }

    public BitmapFactoryDecoder(ImageSource imageSource, Options options, Semaphore semaphore, ExifOrientationStrategy exifOrientationStrategy) {
        this.f67a = imageSource;
        this.b = options;
        this.c = semaphore;
        this.d = exifOrientationStrategy;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlin.coroutines.Continuation r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof coil3.decode.BitmapFactoryDecoder$decode$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            coil3.decode.BitmapFactoryDecoder$decode$1 r0 = (coil3.decode.BitmapFactoryDecoder$decode$1) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.g = r1
            goto L_0x001a
        L_0x0013:
            coil3.decode.BitmapFactoryDecoder$decode$1 r0 = new coil3.decode.BitmapFactoryDecoder$decode$1
            kotlin.coroutines.jvm.internal.ContinuationImpl r7 = (kotlin.coroutines.jvm.internal.ContinuationImpl) r7
            r0.<init>(r6, r7)
        L_0x001a:
            java.lang.Object r7 = r0.e
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.g
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0047
            if (r2 == r4) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r0 = r0.c
            kotlinx.coroutines.sync.Semaphore r0 = (kotlinx.coroutines.sync.Semaphore) r0
            kotlin.ResultKt.b(r7)     // Catch:{ all -> 0x0030 }
            goto L_0x0073
        L_0x0030:
            r7 = move-exception
            goto L_0x007f
        L_0x0032:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x003a:
            java.lang.Object r2 = r0.d
            kotlinx.coroutines.sync.Semaphore r2 = (kotlinx.coroutines.sync.Semaphore) r2
            java.lang.Object r4 = r0.c
            coil3.decode.BitmapFactoryDecoder r4 = (coil3.decode.BitmapFactoryDecoder) r4
            kotlin.ResultKt.b(r7)
            r7 = r2
            goto L_0x005d
        L_0x0047:
            kotlin.ResultKt.b(r7)
            r0.c = r6
            kotlinx.coroutines.sync.Semaphore r7 = r6.c
            r0.d = r7
            r0.g = r4
            r2 = r7
            kotlinx.coroutines.sync.SemaphoreAndMutexImpl r2 = (kotlinx.coroutines.sync.SemaphoreAndMutexImpl) r2
            java.lang.Object r2 = r2.e(r0)
            if (r2 != r1) goto L_0x005c
            return r1
        L_0x005c:
            r4 = r6
        L_0x005d:
            coil3.decode.a r2 = new coil3.decode.a     // Catch:{ all -> 0x007d }
            r2.<init>(r4)     // Catch:{ all -> 0x007d }
            r0.c = r7     // Catch:{ all -> 0x007d }
            r4 = 0
            r0.d = r4     // Catch:{ all -> 0x007d }
            r0.g = r3     // Catch:{ all -> 0x007d }
            java.lang.Object r0 = kotlinx.coroutines.InterruptibleKt.a(r2, r0)     // Catch:{ all -> 0x007d }
            if (r0 != r1) goto L_0x0070
            return r1
        L_0x0070:
            r5 = r0
            r0 = r7
            r7 = r5
        L_0x0073:
            coil3.decode.DecodeResult r7 = (coil3.decode.DecodeResult) r7     // Catch:{ all -> 0x0030 }
            r0.release()
            return r7
        L_0x0079:
            r5 = r0
            r0 = r7
            r7 = r5
            goto L_0x007f
        L_0x007d:
            r0 = move-exception
            goto L_0x0079
        L_0x007f:
            r0.release()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.decode.BitmapFactoryDecoder.a(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
