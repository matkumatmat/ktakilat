package kotlin;

import com.facebook.internal.FacebookRequestErrorClassification;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.1")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00022\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/KotlinVersion;", "", "d", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KotlinVersion implements Comparable<KotlinVersion> {
    @NotNull
    public static final Companion d = new Companion((DefaultConstructorMarker) null);
    public static final KotlinVersion e = new KotlinVersion();
    public final int c = 131328;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlin/KotlinVersion$Companion;", "", "", "MAX_COMPONENT_VALUE", "I", "Lkotlin/KotlinVersion;", "CURRENT", "Lkotlin/KotlinVersion;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public final int compareTo(Object obj) {
        KotlinVersion kotlinVersion = (KotlinVersion) obj;
        Intrinsics.checkNotNullParameter(kotlinVersion, FacebookRequestErrorClassification.KEY_OTHER);
        return this.c - kotlinVersion.c;
    }

    public final boolean equals(Object obj) {
        KotlinVersion kotlinVersion;
        if (this == obj) {
            return true;
        }
        if (obj instanceof KotlinVersion) {
            kotlinVersion = (KotlinVersion) obj;
        } else {
            kotlinVersion = null;
        }
        if (kotlinVersion != null && this.c == kotlinVersion.c) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.c;
    }

    public final String toString() {
        return "2.1.0";
    }
}
