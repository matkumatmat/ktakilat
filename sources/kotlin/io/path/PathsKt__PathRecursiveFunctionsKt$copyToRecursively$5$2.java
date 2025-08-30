package kotlin.io.path;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$2 extends FunctionReferenceImpl implements Function2<Path, BasicFileAttributes, FileVisitResult> {
    public final Object invoke(Object obj, Object obj2) {
        Path n = qb.n(obj);
        BasicFileAttributes s = qb.s(obj2);
        Intrinsics.checkNotNullParameter(n, "p0");
        Intrinsics.checkNotNullParameter(s, "p1");
        try {
            throw null;
        } catch (Exception e) {
            PathsKt__PathRecursiveFunctionsKt.a(n, e);
            throw null;
        }
    }
}
