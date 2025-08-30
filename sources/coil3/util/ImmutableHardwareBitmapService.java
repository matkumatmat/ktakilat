package coil3.util;

import coil3.size.Size;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/util/ImmutableHardwareBitmapService;", "Lcoil3/util/HardwareBitmapService;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ImmutableHardwareBitmapService implements HardwareBitmapService {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f157a;

    public ImmutableHardwareBitmapService(boolean z) {
        this.f157a = z;
    }

    public final boolean a(Size size) {
        return this.f157a;
    }

    public final boolean b() {
        return this.f157a;
    }
}
