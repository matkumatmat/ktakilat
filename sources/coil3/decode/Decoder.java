package coil3.decode;

import coil3.fetch.SourceFetchResult;
import coil3.request.Options;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bæ\u0001\u0018\u00002\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Lcoil3/decode/Decoder;", "", "Factory", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface Decoder {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0002À\u0006\u0001"}, d2 = {"Lcoil3/decode/Decoder$Factory;", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Factory {
        Decoder a(SourceFetchResult sourceFetchResult, Options options);
    }

    Object a(Continuation continuation);
}
