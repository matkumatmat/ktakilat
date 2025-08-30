package coil3.gif.internal;

import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"coil3/gif/internal/UtilsKt$animatable2CallbackOf$1", "Landroid/graphics/drawable/Animatable2$AnimationCallback;", "coil-gif_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UtilsKt$animatable2CallbackOf$1 extends Animatable2.AnimationCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function0 f105a;
    public final /* synthetic */ Function0 b;

    public UtilsKt$animatable2CallbackOf$1(Function0 function0, Function0 function02) {
        this.f105a = function0;
        this.b = function02;
    }

    public final void onAnimationEnd(Drawable drawable) {
        Function0 function0 = this.b;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void onAnimationStart(Drawable drawable) {
        Function0 function0 = this.f105a;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
