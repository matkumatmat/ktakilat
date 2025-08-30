package kotlin.io.path;

import java.nio.file.FileVisitOption;
import java.nio.file.LinkOption;
import java.util.Collections;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/io/path/LinkFollowing;", "", "kotlin-stdlib-jdk7"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LinkFollowing {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final LinkFollowing f715a = new Object();

    /* JADX WARNING: type inference failed for: r0v0, types: [kotlin.io.path.LinkFollowing, java.lang.Object] */
    static {
        LinkOption[] linkOptionArr = new LinkOption[1];
        LinkOption unused = LinkOption.NOFOLLOW_LINKS;
        LinkOption[] linkOptionArr2 = new LinkOption[0];
        EmptySet emptySet = EmptySet.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(Collections.singleton(FileVisitOption.FOLLOW_LINKS), "singleton(...)");
    }
}
