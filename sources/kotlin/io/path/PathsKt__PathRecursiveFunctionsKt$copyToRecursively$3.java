package kotlin.io.path;

import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final class PathsKt__PathRecursiveFunctionsKt$copyToRecursively$3 implements Function3 {
    public final Void a(Path path, Path path2, Exception exc) {
        Intrinsics.checkNotNullParameter(path, "<unused var>");
        Intrinsics.checkNotNullParameter(path2, "<unused var>");
        Intrinsics.checkNotNullParameter(exc, "exception");
        throw exc;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return a(qb.n(obj), qb.n(obj2), (Exception) obj3);
    }
}
