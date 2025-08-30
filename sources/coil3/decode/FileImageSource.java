package coil3.decode;

import coil3.decode.ImageSource;
import coil3.util.UtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/decode/FileImageSource;", "Lcoil3/decode/ImageSource;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nImageSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImageSource.kt\ncoil3/decode/FileImageSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,188:1\n1#2:189\n*E\n"})
public final class FileImageSource implements ImageSource {
    public final Path c;
    public final FileSystem d;
    public final String e;
    public final AutoCloseable f;
    public final ImageSource.Metadata g;
    public final Object i = new Object();
    public boolean j;
    public BufferedSource k;

    public FileImageSource(Path path, FileSystem fileSystem, String str, AutoCloseable autoCloseable, ImageSource.Metadata metadata) {
        this.c = path;
        this.d = fileSystem;
        this.e = str;
        this.f = autoCloseable;
        this.g = metadata;
    }

    public final FileSystem b() {
        return this.d;
    }

    public final void close() {
        synchronized (this.i) {
            this.j = true;
            BufferedSource bufferedSource = this.k;
            if (bufferedSource != null) {
                Function1 function1 = UtilsKt.f161a;
                try {
                    bufferedSource.close();
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception unused) {
                } catch (RuntimeException e3) {
                    throw e3;
                } catch (Exception unused2) {
                }
            }
            AutoCloseable autoCloseable = this.f;
            if (autoCloseable != null) {
                Function1 function12 = UtilsKt.f161a;
                autoCloseable.close();
            }
            Unit unit = Unit.f696a;
        }
    }

    public final ImageSource.Metadata getMetadata() {
        return this.g;
    }

    public final Path o() {
        Path path;
        synchronized (this.i) {
            if (!this.j) {
                path = this.c;
            } else {
                throw new IllegalStateException("closed");
            }
        }
        return path;
    }

    public final BufferedSource source() {
        synchronized (this.i) {
            if (!this.j) {
                BufferedSource bufferedSource = this.k;
                if (bufferedSource != null) {
                    return bufferedSource;
                }
                BufferedSource buffer = Okio.buffer(this.d.source(this.c));
                this.k = buffer;
                return buffer;
            }
            throw new IllegalStateException("closed");
        }
    }
}
