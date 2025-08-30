package coil3.decode;

import coil3.decode.ImageSource;
import coil3.util.UtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Okio;
import okio.Path;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/decode/SourceImageSource;", "Lcoil3/decode/ImageSource;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nImageSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImageSource.kt\ncoil3/decode/SourceImageSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 FileSystem.kt\nokio/FileSystem\n+ 4 Okio.kt\nokio/Okio__OkioKt\n*L\n1#1,188:1\n1#2:189\n80#3:190\n165#3:191\n81#3:192\n82#3:197\n52#4,4:193\n60#4,10:198\n56#4,18:208\n*S KotlinDebug\n*F\n+ 1 ImageSource.kt\ncoil3/decode/SourceImageSource\n*L\n166#1:190\n166#1:191\n166#1:192\n166#1:197\n166#1:193,4\n166#1:198,10\n166#1:208,18\n*E\n"})
public final class SourceImageSource implements ImageSource {
    public final FileSystem c;
    public final ImageSource.Metadata d;
    public final Object e = new Object();
    public boolean f;
    public BufferedSource g;

    public SourceImageSource(BufferedSource bufferedSource, FileSystem fileSystem, ImageSource.Metadata metadata) {
        this.c = fileSystem;
        this.d = metadata;
        this.g = bufferedSource;
    }

    public final FileSystem b() {
        return this.c;
    }

    public final void close() {
        synchronized (this.e) {
            this.f = true;
            BufferedSource bufferedSource = this.g;
            if (bufferedSource != null) {
                Function1 function1 = UtilsKt.f161a;
                try {
                    bufferedSource.close();
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception unused) {
                }
            }
            Unit unit = Unit.f696a;
        }
    }

    public final ImageSource.Metadata getMetadata() {
        return this.d;
    }

    public final Path o() {
        synchronized (this.e) {
            if (this.f) {
                throw new IllegalStateException("closed");
            }
        }
        return null;
    }

    public final BufferedSource source() {
        synchronized (this.e) {
            if (!this.f) {
                BufferedSource bufferedSource = this.g;
                if (bufferedSource != null) {
                    return bufferedSource;
                }
                FileSystem fileSystem = this.c;
                Intrinsics.c((Object) null);
                BufferedSource buffer = Okio.buffer(fileSystem.source((Path) null));
                this.g = buffer;
                return buffer;
            }
            throw new IllegalStateException("closed");
        }
    }
}
