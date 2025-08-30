package coil3.request;

import coil3.Image;
import coil3.decode.DataSource;
import coil3.memory.MemoryCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/request/SuccessResult;", "Lcoil3/request/ImageResult;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SuccessResult implements ImageResult {

    /* renamed from: a  reason: collision with root package name */
    public final Image f146a;
    public final ImageRequest b;
    public final DataSource c;
    public final MemoryCache.Key d;
    public final String e;
    public final boolean f;
    public final boolean g;

    public SuccessResult(Image image, ImageRequest imageRequest, DataSource dataSource, MemoryCache.Key key, String str, boolean z, boolean z2) {
        this.f146a = image;
        this.b = imageRequest;
        this.c = dataSource;
        this.d = key;
        this.e = str;
        this.f = z;
        this.g = z2;
    }

    public final ImageRequest a() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuccessResult)) {
            return false;
        }
        SuccessResult successResult = (SuccessResult) obj;
        return Intrinsics.a(this.f146a, successResult.f146a) && Intrinsics.a(this.b, successResult.b) && this.c == successResult.c && Intrinsics.a(this.d, successResult.d) && Intrinsics.a(this.e, successResult.e) && this.f == successResult.f && this.g == successResult.g;
    }

    public final Image getImage() {
        return this.f146a;
    }

    public final int hashCode() {
        int i;
        int i2;
        int hashCode = this.b.hashCode();
        int hashCode2 = (this.c.hashCode() + ((hashCode + (this.f146a.hashCode() * 31)) * 31)) * 31;
        int i3 = 0;
        MemoryCache.Key key = this.d;
        if (key == null) {
            i = 0;
        } else {
            i = key.hashCode();
        }
        int i4 = (hashCode2 + i) * 31;
        String str = this.e;
        if (str != null) {
            i3 = str.hashCode();
        }
        int i5 = (i4 + i3) * 31;
        int i6 = 1237;
        if (this.f) {
            i2 = 1231;
        } else {
            i2 = 1237;
        }
        int i7 = (i5 + i2) * 31;
        if (this.g) {
            i6 = 1231;
        }
        return i7 + i6;
    }

    public final String toString() {
        return "SuccessResult(image=" + this.f146a + ", request=" + this.b + ", dataSource=" + this.c + ", memoryCacheKey=" + this.d + ", diskCacheKey=" + this.e + ", isSampled=" + this.f + ", isPlaceholderCached=" + this.g + ')';
    }
}
