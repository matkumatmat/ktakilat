package coil3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/Uri;", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Uri {

    /* renamed from: a  reason: collision with root package name */
    public final String f65a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;

    public Uri(String str, String str2, String str3, String str4, String str5) {
        this.f65a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Uri) || !Intrinsics.a(((Uri) obj).f65a, this.f65a)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f65a.hashCode();
    }

    public final String toString() {
        return this.f65a;
    }
}
