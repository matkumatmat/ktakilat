package coil3.disk;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.ForwardingFileSystem;
import okio.Path;
import okio.Sink;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"coil3/disk/DiskLruCache$fileSystem$1", "Lokio/ForwardingFileSystem;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDiskLruCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DiskLruCache.kt\ncoil3/disk/DiskLruCache$fileSystem$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,864:1\n1#2:865\n*E\n"})
public final class DiskLruCache$fileSystem$1 extends ForwardingFileSystem {
    public final Sink sink(Path path, boolean z) {
        Path parent = path.parent();
        if (parent != null) {
            createDirectories(parent);
        }
        return super.sink(path, z);
    }
}
