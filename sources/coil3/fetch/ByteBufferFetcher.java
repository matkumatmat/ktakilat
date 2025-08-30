package coil3.fetch;

import coil3.RealImageLoader;
import coil3.decode.ByteBufferMetadata;
import coil3.decode.DataSource;
import coil3.decode.SourceImageSource;
import coil3.fetch.Fetcher;
import coil3.request.Options;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okio.Okio;
import okio.Source;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcoil3/fetch/ByteBufferFetcher;", "Lcoil3/fetch/Fetcher;", "Factory", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ByteBufferFetcher implements Fetcher {

    /* renamed from: a  reason: collision with root package name */
    public final ByteBuffer f89a;
    public final Options b;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcoil3/fetch/ByteBufferFetcher$Factory;", "Lcoil3/fetch/Fetcher$Factory;", "Ljava/nio/ByteBuffer;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Factory implements Fetcher.Factory<ByteBuffer> {
        public final Fetcher a(Object obj, Options options, RealImageLoader realImageLoader) {
            return new ByteBufferFetcher((ByteBuffer) obj, options);
        }
    }

    public ByteBufferFetcher(ByteBuffer byteBuffer, Options options) {
        this.f89a = byteBuffer;
        this.b = options;
    }

    public final Object a(Continuation continuation) {
        ByteBuffer byteBuffer = this.f89a;
        return new SourceFetchResult(new SourceImageSource(Okio.buffer((Source) new ByteBufferFetcherKt$asSource$1(byteBuffer)), this.b.f, new ByteBufferMetadata(byteBuffer)), (String) null, DataSource.MEMORY);
    }
}
