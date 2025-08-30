package coil3.gif;

import android.graphics.ImageDecoder;
import android.util.Size;
import coil3.Extras;
import coil3.ExtrasKt;
import coil3.decode.DecodeUtils;
import coil3.request.ImageRequestsKt;
import coil3.request.ImageRequests_androidKt;
import coil3.request.Options;
import coil3.size.Precision;
import coil3.util.BitmapsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b¨\u0006\t"}, d2 = {"<anonymous>", "", "decoder", "Landroid/graphics/ImageDecoder;", "info", "Landroid/graphics/ImageDecoder$ImageInfo;", "source", "Landroid/graphics/ImageDecoder$Source;", "onHeaderDecoded", "androidx/core/graphics/ImageDecoderKt$decodeDrawable$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nImageDecoder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImageDecoder.kt\nandroidx/core/graphics/ImageDecoderKt$decodeDrawable$1\n+ 2 AnimatedImageDecoder.kt\ncoil3/gif/AnimatedImageDecoder\n+ 3 Size.kt\nandroidx/core/util/SizeKt\n+ 4 collections.kt\ncoil3/util/CollectionsKt\n*L\n1#1,56:1\n63#2:57\n65#2,5:60\n64#2:65\n71#2,24:69\n37#3:58\n49#3:59\n23#4,3:66\n*S KotlinDebug\n*F\n+ 1 AnimatedImageDecoder.kt\ncoil3/gif/AnimatedImageDecoder\n*L\n63#1:58\n63#1:59\n64#1:66,3\n*E\n"})
public final class AnimatedImageDecoder$decode$lambda$3$lambda$2$$inlined$decodeDrawable$1 implements ImageDecoder.OnHeaderDecodedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnimatedImageDecoder f98a;
    public final /* synthetic */ Ref.BooleanRef b;

    public AnimatedImageDecoder$decode$lambda$3$lambda$2$$inlined$decodeDrawable$1(AnimatedImageDecoder animatedImageDecoder, Ref.BooleanRef booleanRef) {
        this.f98a = animatedImageDecoder;
        this.b = booleanRef;
    }

    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        int i;
        sg sgVar;
        boolean z;
        Size i2 = imageInfo.getSize();
        int width = i2.getWidth();
        int height = i2.getHeight();
        Options options = this.f98a.b;
        long a2 = DecodeUtils.a(width, height, options.b, options.c, (coil3.size.Size) ExtrasKt.b(options, ImageRequestsKt.f141a));
        int i3 = (int) (a2 >> 32);
        int i4 = (int) (a2 & 4294967295L);
        if (width > 0 && height > 0 && !(width == i3 && height == i4)) {
            double b2 = DecodeUtils.b(width, height, i3, i4, this.f98a.b.c);
            Ref.BooleanRef booleanRef = this.b;
            if (b2 < 1.0d) {
                z = true;
            } else {
                z = false;
            }
            booleanRef.element = z;
            if (z || this.f98a.b.d == Precision.EXACT) {
                imageDecoder.setTargetSize(MathKt.a(((double) width) * b2), MathKt.a(b2 * ((double) height)));
            }
        }
        Options options2 = this.f98a.b;
        if (BitmapsKt.a(ImageRequests_androidKt.a(options2))) {
            i = 3;
        } else {
            i = 1;
        }
        imageDecoder.setAllocator(i);
        imageDecoder.setMemorySizePolicy(((Boolean) ExtrasKt.b(options2, ImageRequests_androidKt.i)).booleanValue() ^ true ? 1 : 0);
        Extras.Key key = ImageRequests_androidKt.d;
        if (u5.i(ExtrasKt.b(options2, key)) != null) {
            imageDecoder.setTargetColorSpace(u5.i(ExtrasKt.b(options2, key)));
        }
        AnimatedTransformation animatedTransformation = (AnimatedTransformation) ExtrasKt.b(options2, ImageRequestsKt.b);
        if (animatedTransformation != null) {
            sgVar = new sg(animatedTransformation);
        } else {
            sgVar = null;
        }
        imageDecoder.setPostProcessor(sgVar);
    }
}
