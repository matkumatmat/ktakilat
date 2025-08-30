package coil3.decode;

import coil3.Image;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/decode/DecodeResult;", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DecodeResult {

    /* renamed from: a  reason: collision with root package name */
    public final Image f71a;
    public final boolean b;

    public DecodeResult(Image image, boolean z) {
        this.f71a = image;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DecodeResult)) {
            return false;
        }
        DecodeResult decodeResult = (DecodeResult) obj;
        return Intrinsics.a(this.f71a, decodeResult.f71a) && this.b == decodeResult.b;
    }

    public final int hashCode() {
        int i;
        int hashCode = this.f71a.hashCode() * 31;
        if (this.b) {
            i = 1231;
        } else {
            i = 1237;
        }
        return hashCode + i;
    }

    public final String toString() {
        return "DecodeResult(image=" + this.f71a + ", isSampled=" + this.b + ')';
    }
}
