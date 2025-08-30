package coil3.gif;

import coil3.decode.Decoder;
import coil3.decode.ImageSource;
import coil3.fetch.SourceFetchResult;
import coil3.request.Options;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.InterruptibleKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcoil3/gif/GifDecoder;", "Lcoil3/decode/Decoder;", "Factory", "coil-gif_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGifDecoder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GifDecoder.kt\ncoil3/gif/GifDecoder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,84:1\n1#2:85\n*E\n"})
public final class GifDecoder implements Decoder {

    /* renamed from: a  reason: collision with root package name */
    public final ImageSource f101a;
    public final Options b;
    public final boolean c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/gif/GifDecoder$Factory;", "Lcoil3/decode/Decoder$Factory;", "coil-gif_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Factory implements Decoder.Factory {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f102a = true;

        public final Decoder a(SourceFetchResult sourceFetchResult, Options options) {
            if (!DecodeUtilsKt.a(sourceFetchResult.f96a.source())) {
                return null;
            }
            return new GifDecoder(sourceFetchResult.f96a, options, this.f102a);
        }
    }

    public GifDecoder(ImageSource imageSource, Options options, boolean z) {
        this.f101a = imageSource;
        this.b = options;
        this.c = z;
    }

    public final Object a(Continuation continuation) {
        return InterruptibleKt.a(new c(this, 4), (ContinuationImpl) continuation);
    }
}
