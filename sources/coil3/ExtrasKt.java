package coil3;

import coil3.Extras;
import coil3.request.ImageRequest;
import coil3.request.Options;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"coil-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ExtrasKt {
    public static final Object a(ImageRequest imageRequest, Extras.Key key) {
        Object obj = imageRequest.s.f53a.get(key);
        if (obj != null) {
            return obj;
        }
        Object obj2 = imageRequest.u.n.f53a.get(key);
        if (obj2 == null) {
            return key.f55a;
        }
        return obj2;
    }

    public static final Object b(Options options, Extras.Key key) {
        Object obj = options.j.f53a.get(key);
        if (obj == null) {
            return key.f55a;
        }
        return obj;
    }
}
