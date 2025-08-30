package coil3.fetch;

import coil3.Image;
import coil3.decode.DataSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/fetch/ImageFetchResult;", "Lcoil3/fetch/FetchResult;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImageFetchResult implements FetchResult {

    /* renamed from: a  reason: collision with root package name */
    public final Image f93a;
    public final boolean b;
    public final DataSource c;

    public ImageFetchResult(Image image, boolean z, DataSource dataSource) {
        this.f93a = image;
        this.b = z;
        this.c = dataSource;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageFetchResult)) {
            return false;
        }
        ImageFetchResult imageFetchResult = (ImageFetchResult) obj;
        return Intrinsics.a(this.f93a, imageFetchResult.f93a) && this.b == imageFetchResult.b && this.c == imageFetchResult.c;
    }

    public final int hashCode() {
        int i;
        int hashCode = this.f93a.hashCode() * 31;
        if (this.b) {
            i = 1231;
        } else {
            i = 1237;
        }
        return this.c.hashCode() + ((hashCode + i) * 31);
    }

    public final String toString() {
        return "ImageFetchResult(image=" + this.f93a + ", isSampled=" + this.b + ", dataSource=" + this.c + ')';
    }
}
