package coil3.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import okio.FileSystem;
import okio.Path;
import okio.Sink;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"coil-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FileSystemsKt {
    public static void a(FileSystem fileSystem, Path path) {
        if (!fileSystem.exists(path)) {
            Sink sink = fileSystem.sink(path);
            Function1 function1 = UtilsKt.f161a;
            try {
                sink.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static final void b(FileSystem fileSystem, Path path) {
        try {
            IOException iOException = null;
            for (Path next : fileSystem.list(path)) {
                try {
                    if (fileSystem.metadata(next).isDirectory()) {
                        b(fileSystem, next);
                    }
                    fileSystem.delete(next);
                } catch (IOException e) {
                    if (iOException == null) {
                        iOException = e;
                    }
                }
            }
            if (iOException != null) {
                throw iOException;
            }
        } catch (FileNotFoundException unused) {
        }
    }
}
