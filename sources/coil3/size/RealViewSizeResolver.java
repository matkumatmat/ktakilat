package coil3.size;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003¨\u0006\u0004"}, d2 = {"Lcoil3/size/RealViewSizeResolver;", "Landroid/view/View;", "T", "Lcoil3/size/ViewSizeResolver;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RealViewSizeResolver<T extends View> implements ViewSizeResolver<T> {
    public final View b;
    public final boolean c;

    public RealViewSizeResolver(View view, boolean z) {
        this.b = view;
        this.c = z;
    }

    public final Object a(Continuation continuation) {
        Object b2 = ba.b(this);
        if (b2 == null) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt.b(continuation));
            cancellableContinuationImpl.q();
            ViewTreeObserver viewTreeObserver = this.b.getViewTreeObserver();
            ViewSizeResolver$size$3$preDrawListener$1 viewSizeResolver$size$3$preDrawListener$1 = new ViewSizeResolver$size$3$preDrawListener$1(this, viewTreeObserver, cancellableContinuationImpl);
            viewTreeObserver.addOnPreDrawListener(viewSizeResolver$size$3$preDrawListener$1);
            cancellableContinuationImpl.s(new ViewSizeResolver$size$3$1(this, viewTreeObserver, viewSizeResolver$size$3$preDrawListener$1));
            b2 = cancellableContinuationImpl.p();
            if (b2 == CoroutineSingletons.COROUTINE_SUSPENDED) {
                Intrinsics.checkNotNullParameter(continuation, TypedValues.AttributesType.S_FRAME);
            }
        }
        return b2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RealViewSizeResolver)) {
            return false;
        }
        RealViewSizeResolver realViewSizeResolver = (RealViewSizeResolver) obj;
        return Intrinsics.a(this.b, realViewSizeResolver.b) && this.c == realViewSizeResolver.c;
    }

    public final View getView() {
        return this.b;
    }

    public final int hashCode() {
        int i;
        int hashCode = this.b.hashCode() * 31;
        if (this.c) {
            i = 1231;
        } else {
            i = 1237;
        }
        return hashCode + i;
    }

    public final String toString() {
        return "RealViewSizeResolver(view=" + this.b + ", subtractPadding=" + this.c + ')';
    }
}
