package coil3.request;

import coil3.Image;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/request/ErrorResult;", "Lcoil3/request/ImageResult;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ErrorResult implements ImageResult {

    /* renamed from: a  reason: collision with root package name */
    public final Image f136a;
    public final ImageRequest b;
    public final Throwable c;

    public ErrorResult(Image image, ImageRequest imageRequest, Throwable th) {
        this.f136a = image;
        this.b = imageRequest;
        this.c = th;
    }

    public final ImageRequest a() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ErrorResult)) {
            return false;
        }
        ErrorResult errorResult = (ErrorResult) obj;
        return Intrinsics.a(this.f136a, errorResult.f136a) && Intrinsics.a(this.b, errorResult.b) && Intrinsics.a(this.c, errorResult.c);
    }

    public final Image getImage() {
        return this.f136a;
    }

    public final int hashCode() {
        Image image = this.f136a;
        int hashCode = image == null ? 0 : image.hashCode();
        return this.c.hashCode() + ((this.b.hashCode() + (hashCode * 31)) * 31);
    }

    public final String toString() {
        return "ErrorResult(image=" + this.f136a + ", request=" + this.b + ", throwable=" + this.c + ')';
    }
}
