package coil3.fetch;

import coil3.RealImageLoader;
import coil3.decode.DataSource;
import coil3.decode.ImageSource;
import coil3.decode.SourceImageSource;
import coil3.fetch.Fetcher;
import coil3.request.Options;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Buffer;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcoil3/fetch/ByteArrayFetcher;", "Lcoil3/fetch/Fetcher;", "Factory", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nByteArrayFetcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ByteArrayFetcher.kt\ncoil3/fetch/ByteArrayFetcher\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,35:1\n1#2:36\n*E\n"})
public final class ByteArrayFetcher implements Fetcher {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f88a;
    public final Options b;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcoil3/fetch/ByteArrayFetcher$Factory;", "Lcoil3/fetch/Fetcher$Factory;", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Factory implements Fetcher.Factory<byte[]> {
        public final Fetcher a(Object obj, Options options, RealImageLoader realImageLoader) {
            return new ByteArrayFetcher((byte[]) obj, options);
        }
    }

    public ByteArrayFetcher(byte[] bArr, Options options) {
        this.f88a = bArr;
        this.b = options;
    }

    public final Object a(Continuation continuation) {
        Buffer buffer = new Buffer();
        buffer.write(this.f88a);
        return new SourceFetchResult(new SourceImageSource(buffer, this.b.f, (ImageSource.Metadata) null), (String) null, DataSource.MEMORY);
    }
}
