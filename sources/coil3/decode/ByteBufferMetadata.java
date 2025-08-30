package coil3.decode;

import coil3.annotation.ExperimentalCoilApi;
import coil3.decode.ImageSource;
import java.nio.ByteBuffer;
import kotlin.Metadata;

@ExperimentalCoilApi
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/decode/ByteBufferMetadata;", "Lcoil3/decode/ImageSource$Metadata;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ByteBufferMetadata extends ImageSource.Metadata {

    /* renamed from: a  reason: collision with root package name */
    public final ByteBuffer f69a;

    public ByteBufferMetadata(ByteBuffer byteBuffer) {
        this.f69a = byteBuffer;
    }
}
