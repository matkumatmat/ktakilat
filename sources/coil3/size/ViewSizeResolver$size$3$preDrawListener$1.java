package coil3.size;

import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.Result;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"coil3/size/ViewSizeResolver$size$3$preDrawListener$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ViewSizeResolver$size$3$preDrawListener$1 implements ViewTreeObserver.OnPreDrawListener {
    public boolean c;
    public final /* synthetic */ RealViewSizeResolver d;
    public final /* synthetic */ ViewTreeObserver e;
    public final /* synthetic */ CancellableContinuationImpl f;

    public ViewSizeResolver$size$3$preDrawListener$1(RealViewSizeResolver realViewSizeResolver, ViewTreeObserver viewTreeObserver, CancellableContinuationImpl cancellableContinuationImpl) {
        this.d = realViewSizeResolver;
        this.e = viewTreeObserver;
        this.f = cancellableContinuationImpl;
    }

    public final boolean onPreDraw() {
        RealViewSizeResolver realViewSizeResolver = this.d;
        Size b = ba.b(realViewSizeResolver);
        if (b != null) {
            ViewTreeObserver viewTreeObserver = this.e;
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
            } else {
                realViewSizeResolver.b.getViewTreeObserver().removeOnPreDrawListener(this);
            }
            if (!this.c) {
                this.c = true;
                this.f.resumeWith(Result.m16constructorimpl(b));
            }
        }
        return true;
    }
}
