package coil3.network;

import kotlin.Metadata;
import kotlin.Unit;
import okio.Buffer;
import okio.FileSystem;
import okio.Path;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00060\u0001j\u0002`\u0002ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Lcoil3/network/NetworkResponseBody;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface NetworkResponseBody extends AutoCloseable {
    Unit a(Buffer buffer);

    Unit n(FileSystem fileSystem, Path path);
}
