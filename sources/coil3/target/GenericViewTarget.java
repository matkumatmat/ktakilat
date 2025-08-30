package coil3.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import coil3.Image;
import coil3.transition.TransitionTarget;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u00042\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcoil3/target/GenericViewTarget;", "Landroid/view/View;", "T", "Lcoil3/target/ViewTarget;", "Lcoil3/transition/TransitionTarget;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class GenericViewTarget<T extends View> implements ViewTarget<T>, TransitionTarget, DefaultLifecycleObserver {
    public boolean c;

    public final void b(Image image) {
        g(image);
    }

    public abstract Drawable c();

    public final void d(Image image) {
        g(image);
    }

    public abstract void e(Drawable drawable);

    public final void f() {
        Animatable animatable;
        Drawable c2 = c();
        if (c2 instanceof Animatable) {
            animatable = (Animatable) c2;
        } else {
            animatable = null;
        }
        if (animatable != null) {
            if (this.c) {
                animatable.start();
            } else {
                animatable.stop();
            }
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(coil3.Image r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L_0x0011
            r1 = r3
            coil3.target.ImageViewTarget r1 = (coil3.target.ImageViewTarget) r1
            android.widget.ImageView r1 = r1.d
            android.content.res.Resources r1 = r1.getResources()
            android.graphics.drawable.Drawable r4 = coil3.Image_androidKt.a(r4, r1)
            goto L_0x0012
        L_0x0011:
            r4 = r0
        L_0x0012:
            android.graphics.drawable.Drawable r1 = r3.c()
            boolean r2 = r1 instanceof android.graphics.drawable.Animatable
            if (r2 == 0) goto L_0x001d
            r0 = r1
            android.graphics.drawable.Animatable r0 = (android.graphics.drawable.Animatable) r0
        L_0x001d:
            if (r0 == 0) goto L_0x0022
            r0.stop()
        L_0x0022:
            r3.e(r4)
            r3.f()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.target.GenericViewTarget.g(coil3.Image):void");
    }

    public final /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        b5.a(this, lifecycleOwner);
    }

    public final /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        b5.b(this, lifecycleOwner);
    }

    public final /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        b5.c(this, lifecycleOwner);
    }

    public final /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        b5.d(this, lifecycleOwner);
    }

    public final void onStart(LifecycleOwner lifecycleOwner) {
        this.c = true;
        f();
    }

    public final void onStop(LifecycleOwner lifecycleOwner) {
        this.c = false;
        f();
    }
}
