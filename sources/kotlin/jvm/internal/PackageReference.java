package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/jvm/internal/PackageReference;", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SinceKotlin(version = "1.1")
public final class PackageReference implements ClassBasedDeclarationContainer {
    public final Class c;

    public PackageReference(Class cls) {
        Intrinsics.checkNotNullParameter(cls, "jClass");
        Intrinsics.checkNotNullParameter("", "moduleName");
        this.c = cls;
    }

    public final Class e() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof PackageReference) {
            if (Intrinsics.a(this.c, ((PackageReference) obj).c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.c.hashCode();
    }

    public final String toString() {
        return this.c + " (Kotlin reflection is not available)";
    }
}
