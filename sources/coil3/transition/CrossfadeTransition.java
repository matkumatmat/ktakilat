package coil3.transition;

import android.graphics.drawable.Drawable;
import coil3.Image;
import coil3.Image_androidKt;
import coil3.decode.DataSource;
import coil3.request.ErrorResult;
import coil3.request.ImageResult;
import coil3.request.SuccessResult;
import coil3.size.Scale;
import coil3.transition.Transition;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcoil3/transition/CrossfadeTransition;", "Lcoil3/transition/Transition;", "Factory", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCrossfadeTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CrossfadeTransition.kt\ncoil3/transition/CrossfadeTransition\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,67:1\n1#2:68\n*E\n"})
public final class CrossfadeTransition implements Transition {

    /* renamed from: a  reason: collision with root package name */
    public final TransitionTarget f152a;
    public final ImageResult b;
    public final int c;
    public final boolean d;

    @SourceDebugExtension({"SMAP\nCrossfadeTransition.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CrossfadeTransition.kt\ncoil3/transition/CrossfadeTransition$Factory\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,67:1\n1#2:68\n*E\n"})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/transition/CrossfadeTransition$Factory;", "Lcoil3/transition/Transition$Factory;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Factory implements Transition.Factory {
        public final int b;
        public final boolean c = false;

        public Factory(int i) {
            this.b = i;
            if (i <= 0) {
                throw new IllegalArgumentException("durationMillis must be > 0.");
            }
        }

        public final Transition a(TransitionTarget transitionTarget, ImageResult imageResult) {
            if (!(imageResult instanceof SuccessResult)) {
                return new NoneTransition(transitionTarget, imageResult);
            }
            if (((SuccessResult) imageResult).c == DataSource.MEMORY_CACHE) {
                return new NoneTransition(transitionTarget, imageResult);
            }
            return new CrossfadeTransition(transitionTarget, imageResult, this.b, this.c);
        }
    }

    public CrossfadeTransition(TransitionTarget transitionTarget, ImageResult imageResult, int i, boolean z) {
        this.f152a = transitionTarget;
        this.b = imageResult;
        this.c = i;
        this.d = z;
        if (i <= 0) {
            throw new IllegalArgumentException("durationMillis must be > 0.");
        }
    }

    public final void a() {
        Drawable drawable;
        boolean z;
        TransitionTarget transitionTarget = this.f152a;
        Drawable c2 = transitionTarget.c();
        ImageResult imageResult = this.b;
        Image image = imageResult.getImage();
        if (image != null) {
            drawable = Image_androidKt.a(image, transitionTarget.a().getResources());
        } else {
            drawable = null;
        }
        Drawable drawable2 = drawable;
        Scale scale = imageResult.a().q;
        boolean z2 = imageResult instanceof SuccessResult;
        if (!z2 || !((SuccessResult) imageResult).g) {
            z = true;
        } else {
            z = false;
        }
        CrossfadeDrawable crossfadeDrawable = new CrossfadeDrawable(c2, drawable2, scale, this.c, z, this.d);
        if (z2) {
            transitionTarget.d(Image_androidKt.b(crossfadeDrawable));
        } else if (imageResult instanceof ErrorResult) {
            transitionTarget.b(Image_androidKt.b(crossfadeDrawable));
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
