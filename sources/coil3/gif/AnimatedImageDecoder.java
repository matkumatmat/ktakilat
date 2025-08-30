package coil3.gif;

import android.os.Build;
import androidx.annotation.RequiresApi;
import coil3.decode.Decoder;
import coil3.decode.ImageSource;
import coil3.fetch.SourceFetchResult;
import coil3.request.Options;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.BufferedSource;

@RequiresApi(28)
@SourceDebugExtension({"SMAP\nAnimatedImageDecoder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimatedImageDecoder.kt\ncoil3/gif/AnimatedImageDecoder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ImageDecoder.kt\nandroidx/core/graphics/ImageDecoderKt\n*L\n1#1,162:1\n1#2:163\n52#3:164\n*S KotlinDebug\n*F\n+ 1 AnimatedImageDecoder.kt\ncoil3/gif/AnimatedImageDecoder\n*L\n61#1:164\n*E\n"})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcoil3/gif/AnimatedImageDecoder;", "Lcoil3/decode/Decoder;", "Factory", "coil-gif_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AnimatedImageDecoder implements Decoder {

    /* renamed from: a  reason: collision with root package name */
    public final ImageSource f97a;
    public final Options b;
    public final boolean c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/gif/AnimatedImageDecoder$Factory;", "Lcoil3/decode/Decoder$Factory;", "coil-gif_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Factory implements Decoder.Factory {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f99a;

        public Factory() {
            boolean z;
            if (Build.VERSION.SDK_INT < 34) {
                z = true;
            } else {
                z = false;
            }
            this.f99a = z;
        }

        public final Decoder a(SourceFetchResult sourceFetchResult, Options options) {
            BufferedSource source = sourceFetchResult.f96a.source();
            if (!DecodeUtilsKt.a(source) && (!source.rangeEquals(0, DecodeUtilsKt.c) || !source.rangeEquals(8, DecodeUtilsKt.d) || !source.rangeEquals(12, DecodeUtilsKt.e) || !source.request(21) || ((byte) (source.getBuffer().getByte(20) & 2)) <= 0)) {
                if (Build.VERSION.SDK_INT < 30 || !source.rangeEquals(4, DecodeUtilsKt.f)) {
                    return null;
                }
                if (!source.rangeEquals(8, DecodeUtilsKt.g) && !source.rangeEquals(8, DecodeUtilsKt.h) && !source.rangeEquals(8, DecodeUtilsKt.i)) {
                    return null;
                }
            }
            return new AnimatedImageDecoder(sourceFetchResult.f96a, options, this.f99a);
        }
    }

    public AnimatedImageDecoder(ImageSource imageSource, Options options, boolean z) {
        this.f97a = imageSource;
        this.b = options;
        this.c = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0070 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlin.coroutines.Continuation r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof coil3.gif.AnimatedImageDecoder$decode$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            coil3.gif.AnimatedImageDecoder$decode$1 r0 = (coil3.gif.AnimatedImageDecoder$decode$1) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.g = r1
            goto L_0x001a
        L_0x0013:
            coil3.gif.AnimatedImageDecoder$decode$1 r0 = new coil3.gif.AnimatedImageDecoder$decode$1
            kotlin.coroutines.jvm.internal.ContinuationImpl r8 = (kotlin.coroutines.jvm.internal.ContinuationImpl) r8
            r0.<init>(r7, r8)
        L_0x001a:
            java.lang.Object r8 = r0.e
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.g
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0042
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            java.lang.Object r0 = r0.c
            kotlin.jvm.internal.Ref$BooleanRef r0 = (kotlin.jvm.internal.Ref.BooleanRef) r0
            kotlin.ResultKt.b(r8)
            goto L_0x0072
        L_0x0030:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0038:
            kotlin.jvm.internal.Ref$BooleanRef r2 = r0.d
            java.lang.Object r4 = r0.c
            coil3.gif.AnimatedImageDecoder r4 = (coil3.gif.AnimatedImageDecoder) r4
            kotlin.ResultKt.b(r8)
            goto L_0x0061
        L_0x0042:
            kotlin.ResultKt.b(r8)
            kotlin.jvm.internal.Ref$BooleanRef r8 = new kotlin.jvm.internal.Ref$BooleanRef
            r8.<init>()
            x r2 = new x
            r5 = 0
            r2.<init>(r5, r7, r8)
            r0.c = r7
            r0.d = r8
            r0.g = r4
            java.lang.Object r2 = kotlinx.coroutines.InterruptibleKt.a(r2, r0)
            if (r2 != r1) goto L_0x005d
            return r1
        L_0x005d:
            r4 = r7
            r6 = r2
            r2 = r8
            r8 = r6
        L_0x0061:
            android.graphics.drawable.Drawable r8 = (android.graphics.drawable.Drawable) r8
            r0.c = r2
            r5 = 0
            r0.d = r5
            r0.g = r3
            java.lang.Object r8 = r4.b(r8, r0)
            if (r8 != r1) goto L_0x0071
            return r1
        L_0x0071:
            r0 = r2
        L_0x0072:
            android.graphics.drawable.Drawable r8 = (android.graphics.drawable.Drawable) r8
            coil3.Image r8 = coil3.Image_androidKt.b(r8)
            boolean r0 = r0.element
            coil3.decode.DecodeResult r1 = new coil3.decode.DecodeResult
            r1.<init>(r8, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.gif.AnimatedImageDecoder.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(android.graphics.drawable.Drawable r8, kotlin.coroutines.jvm.internal.ContinuationImpl r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof coil3.gif.AnimatedImageDecoder$wrapDrawable$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            coil3.gif.AnimatedImageDecoder$wrapDrawable$1 r0 = (coil3.gif.AnimatedImageDecoder$wrapDrawable$1) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.g = r1
            goto L_0x0018
        L_0x0013:
            coil3.gif.AnimatedImageDecoder$wrapDrawable$1 r0 = new coil3.gif.AnimatedImageDecoder$wrapDrawable$1
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.e
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.g
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            android.graphics.drawable.Drawable r8 = r0.d
            coil3.gif.AnimatedImageDecoder r0 = r0.c
            kotlin.ResultKt.b(r9)
            goto L_0x0084
        L_0x002b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0033:
            kotlin.ResultKt.b(r9)
            boolean r9 = defpackage.h.t(r8)
            if (r9 != 0) goto L_0x003d
            return r8
        L_0x003d:
            android.graphics.drawable.AnimatedImageDrawable r9 = defpackage.h.d(r8)
            coil3.Extras$Key r2 = coil3.gif.ImageRequestsKt.f103a
            coil3.request.Options r4 = r7.b
            java.lang.Object r2 = coil3.ExtrasKt.b(r4, r2)
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            r9.setRepeatCount(r2)
            coil3.Extras$Key r9 = coil3.gif.ImageRequestsKt.c
            java.lang.Object r9 = coil3.ExtrasKt.b(r4, r9)
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            coil3.Extras$Key r2 = coil3.gif.ImageRequestsKt.d
            java.lang.Object r2 = coil3.ExtrasKt.b(r4, r2)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            if (r9 != 0) goto L_0x0069
            if (r2 == 0) goto L_0x0067
            goto L_0x0069
        L_0x0067:
            r0 = r7
            goto L_0x0084
        L_0x0069:
            kotlinx.coroutines.scheduling.DefaultScheduler r4 = kotlinx.coroutines.Dispatchers.f767a
            kotlinx.coroutines.MainCoroutineDispatcher r4 = kotlinx.coroutines.internal.MainDispatcherLoader.f801a
            kotlinx.coroutines.MainCoroutineDispatcher r4 = r4.t()
            coil3.gif.AnimatedImageDecoder$wrapDrawable$2 r5 = new coil3.gif.AnimatedImageDecoder$wrapDrawable$2
            r6 = 0
            r5.<init>(r8, r9, r2, r6)
            r0.c = r7
            r0.d = r8
            r0.g = r3
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.d(r5, r4, r0)
            if (r9 != r1) goto L_0x0067
            return r1
        L_0x0084:
            coil3.size.ScaleDrawable r9 = new coil3.size.ScaleDrawable
            coil3.request.Options r0 = r0.b
            coil3.size.Scale r0 = r0.c
            r9.<init>(r8, r0)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.gif.AnimatedImageDecoder.b(android.graphics.drawable.Drawable, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
