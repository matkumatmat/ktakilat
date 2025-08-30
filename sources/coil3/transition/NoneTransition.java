package coil3.transition;

import coil3.request.ErrorResult;
import coil3.request.ImageResult;
import coil3.request.SuccessResult;
import coil3.transition.Transition;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcoil3/transition/NoneTransition;", "Lcoil3/transition/Transition;", "Factory", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NoneTransition implements Transition {

    /* renamed from: a  reason: collision with root package name */
    public final TransitionTarget f153a;
    public final ImageResult b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/transition/NoneTransition$Factory;", "Lcoil3/transition/Transition$Factory;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Factory implements Transition.Factory {
        public final Transition a(TransitionTarget transitionTarget, ImageResult imageResult) {
            return new NoneTransition(transitionTarget, imageResult);
        }
    }

    public NoneTransition(TransitionTarget transitionTarget, ImageResult imageResult) {
        this.f153a = transitionTarget;
        this.b = imageResult;
    }

    public final void a() {
        ImageResult imageResult = this.b;
        boolean z = imageResult instanceof SuccessResult;
        TransitionTarget transitionTarget = this.f153a;
        if (z) {
            transitionTarget.d(((SuccessResult) imageResult).f146a);
        } else if (imageResult instanceof ErrorResult) {
            transitionTarget.b(((ErrorResult) imageResult).f136a);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
