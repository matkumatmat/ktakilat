package kotlin.io.path;

import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/io/path/PathNode;", "", "kotlin-stdlib-jdk7"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class PathNode {

    /* renamed from: a  reason: collision with root package name */
    public final Object f716a;

    public PathNode(Path path, Object obj) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.f716a = obj;
    }
}
