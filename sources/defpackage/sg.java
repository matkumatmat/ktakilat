package defpackage;

import android.graphics.Canvas;
import android.graphics.PostProcessor;
import coil3.gif.AnimatedTransformation;
import coil3.gif.internal.UtilsKt;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: sg  reason: default package */
public final /* synthetic */ class sg implements PostProcessor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnimatedTransformation f209a;

    public /* synthetic */ sg(AnimatedTransformation animatedTransformation) {
        this.f209a = animatedTransformation;
    }

    public final int onPostProcess(Canvas canvas) {
        int i = UtilsKt.WhenMappings.f104a[this.f209a.a().ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return -3;
        }
        if (i == 3) {
            return -1;
        }
        throw new NoWhenBranchMatchedException();
    }
}
