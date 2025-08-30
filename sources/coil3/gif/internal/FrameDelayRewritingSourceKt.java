package coil3.gif.internal;

import coil3.decode.ImageSource;
import coil3.decode.SourceImageSource;
import coil3.gif.DecodeUtilsKt;
import kotlin.Metadata;
import okio.Okio;
import okio.Source;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"coil-gif_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FrameDelayRewritingSourceKt {
    public static final ImageSource a(ImageSource imageSource, boolean z) {
        if (!z || !DecodeUtilsKt.a(imageSource.source())) {
            return imageSource;
        }
        return new SourceImageSource(Okio.buffer((Source) new FrameDelayRewritingSource(imageSource.source())), imageSource.b(), (ImageSource.Metadata) null);
    }
}
