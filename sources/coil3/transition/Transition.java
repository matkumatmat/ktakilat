package coil3.transition;

import coil3.request.ImageResult;
import coil3.transition.NoneTransition;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bæ\u0001\u0018\u00002\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Lcoil3/transition/Transition;", "", "Factory", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface Transition {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bæ\u0001\u0018\u00002\u00020\u0001:\u0001\u0002ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0003À\u0006\u0001"}, d2 = {"Lcoil3/transition/Transition$Factory;", "", "Companion", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Factory {

        /* renamed from: a  reason: collision with root package name */
        public static final NoneTransition.Factory f154a = new Object();

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0001¨\u0006\u0005"}, d2 = {"Lcoil3/transition/Transition$Factory$Companion;", "", "Lcoil3/transition/Transition$Factory;", "NONE", "Lcoil3/transition/Transition$Factory;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
        }

        Transition a(TransitionTarget transitionTarget, ImageResult imageResult);
    }

    void a();
}
