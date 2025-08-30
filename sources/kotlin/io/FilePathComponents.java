package kotlin.io;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/io/FilePathComponents;", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilePathComponents {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilePathComponents)) {
            return false;
        }
        ((FilePathComponents) obj).getClass();
        return Intrinsics.a((Object) null, (Object) null) && Intrinsics.a((Object) null, (Object) null);
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "FilePathComponents(root=null, segments=null)";
    }
}
