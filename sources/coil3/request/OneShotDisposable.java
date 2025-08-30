package coil3.request;

import kotlin.Metadata;
import kotlinx.coroutines.Deferred;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/request/OneShotDisposable;", "Lcoil3/request/Disposable;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OneShotDisposable implements Disposable {

    /* renamed from: a  reason: collision with root package name */
    public final Deferred f144a;

    public OneShotDisposable(Deferred deferred) {
        this.f144a = deferred;
    }
}
