package coil3.size;

import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class ViewSizeResolver$size$3$1 implements Function1<Throwable, Unit> {
    public final /* synthetic */ RealViewSizeResolver c;
    public final /* synthetic */ ViewTreeObserver d;
    public final /* synthetic */ ViewSizeResolver$size$3$preDrawListener$1 e;

    public ViewSizeResolver$size$3$1(RealViewSizeResolver realViewSizeResolver, ViewTreeObserver viewTreeObserver, ViewSizeResolver$size$3$preDrawListener$1 viewSizeResolver$size$3$preDrawListener$1) {
        this.c = realViewSizeResolver;
        this.d = viewTreeObserver;
        this.e = viewSizeResolver$size$3$preDrawListener$1;
    }

    public final Object invoke(Object obj) {
        Throwable th = (Throwable) obj;
        ViewSizeResolver$size$3$preDrawListener$1 viewSizeResolver$size$3$preDrawListener$1 = this.e;
        RealViewSizeResolver realViewSizeResolver = this.c;
        ViewTreeObserver viewTreeObserver = this.d;
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(viewSizeResolver$size$3$preDrawListener$1);
        } else {
            realViewSizeResolver.b.getViewTreeObserver().removeOnPreDrawListener(viewSizeResolver$size$3$preDrawListener$1);
        }
        return Unit.f696a;
    }
}
