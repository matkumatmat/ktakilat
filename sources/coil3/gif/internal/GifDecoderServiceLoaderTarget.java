package coil3.gif.internal;

import android.os.Build;
import coil3.decode.Decoder;
import coil3.gif.AnimatedImageDecoder;
import coil3.gif.GifDecoder;
import coil3.util.DecoderServiceLoaderTarget;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcoil3/gif/internal/GifDecoderServiceLoaderTarget;", "Lcoil3/util/DecoderServiceLoaderTarget;", "<init>", "()V", "factory", "Lcoil3/decode/Decoder$Factory;", "coil-gif_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GifDecoderServiceLoaderTarget implements DecoderServiceLoaderTarget {
    public Decoder.Factory factory() {
        if (Build.VERSION.SDK_INT >= 28) {
            return new AnimatedImageDecoder.Factory();
        }
        return new GifDecoder.Factory();
    }
}
