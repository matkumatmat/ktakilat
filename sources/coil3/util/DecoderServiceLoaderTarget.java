package coil3.util;

import coil3.annotation.InternalCoilApi;
import coil3.decode.Decoder;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0002À\u0006\u0001"}, d2 = {"Lcoil3/util/DecoderServiceLoaderTarget;", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@InternalCoilApi
public interface DecoderServiceLoaderTarget {
    Decoder.Factory factory();
}
