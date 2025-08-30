package coil3.decode;

import okio.BufferedSource;
import okio.FileSystem;
import okio.Path;

@kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\u0003\u0001\u0002\u0004\u0005ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcoil3/decode/ImageSource;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "Metadata", "Lcoil3/decode/FileImageSource;", "Lcoil3/decode/SourceImageSource;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ImageSource extends AutoCloseable {

    @kotlin.Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/decode/ImageSource$Metadata;", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static abstract class Metadata {
    }

    FileSystem b();

    Metadata getMetadata();

    Path o();

    BufferedSource source();
}
