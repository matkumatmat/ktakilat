package coil3.decode;

import coil3.annotation.ExperimentalCoilApi;
import coil3.decode.Decoder;
import coil3.fetch.SourceFetchResult;
import coil3.request.Options;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@ExperimentalCoilApi
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcoil3/decode/BlackholeDecoder;", "Lcoil3/decode/Decoder;", "Factory", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BlackholeDecoder implements Decoder {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcoil3/decode/BlackholeDecoder$Factory;", "Lcoil3/decode/Decoder$Factory;", "Companion", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Factory implements Decoder.Factory {

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcoil3/decode/BlackholeDecoder$Factory$Companion;", "", "Lcoil3/Image;", "EMPTY_IMAGE", "Lcoil3/Image;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
        }

        /* JADX WARNING: type inference failed for: r1v1, types: [java.lang.Object, coil3.decode.Decoder] */
        public final Decoder a(SourceFetchResult sourceFetchResult, Options options) {
            return new Object();
        }
    }

    public final Object a(Continuation continuation) {
        throw null;
    }
}
