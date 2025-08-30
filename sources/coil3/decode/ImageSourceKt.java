package coil3.decode;

import coil3.decode.ImageSource;
import coil3.disk.DiskCache;
import kotlin.Metadata;
import okio.FileSystem;
import okio.Path;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"coil-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ImageSourceKt {
    public static FileImageSource a(Path path, FileSystem fileSystem, String str, DiskCache.Snapshot snapshot, int i) {
        String str2;
        DiskCache.Snapshot snapshot2;
        if ((i & 4) != 0) {
            str2 = null;
        } else {
            str2 = str;
        }
        if ((i & 8) != 0) {
            snapshot2 = null;
        } else {
            snapshot2 = snapshot;
        }
        return new FileImageSource(path, fileSystem, str2, snapshot2, (ImageSource.Metadata) null);
    }
}
