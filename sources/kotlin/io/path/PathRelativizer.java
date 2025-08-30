package kotlin.io.path;

import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/io/path/PathRelativizer;", "", "kotlin-stdlib-jdk7"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class PathRelativizer {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final PathRelativizer f717a = new Object();

    /* JADX WARNING: type inference failed for: r0v0, types: [kotlin.io.path.PathRelativizer, java.lang.Object] */
    static {
        Path unused = Paths.get("", new String[0]);
        Path unused2 = Paths.get("..", new String[0]);
    }
}
