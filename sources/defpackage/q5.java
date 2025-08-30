package defpackage;

import android.animation.ValueAnimator;
import android.view.KeyEvent;

/* renamed from: q5  reason: default package */
public final /* synthetic */ class q5 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f354a;
    public final /* synthetic */ KeyEvent.Callback b;

    public /* synthetic */ q5(KeyEvent.Callback callback, int i) {
        this.f354a = i;
        this.b = callback;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0058 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onAnimationUpdate(android.animation.ValueAnimator r3) {
        /*
            r2 = this;
            int r0 = r2.f354a
            switch(r0) {
                case 0: goto L_0x0061;
                case 1: goto L_0x0015;
                case 2: goto L_0x000d;
                default: goto L_0x0005;
            }
        L_0x0005:
            android.view.KeyEvent$Callback r0 = r2.b
            androidx.camera.view.ScreenFlashView r0 = (androidx.camera.view.ScreenFlashView) r0
            r0.lambda$animateToFullOpacity$0(r3)
            return
        L_0x000d:
            android.view.KeyEvent$Callback r0 = r2.b
            com.google.android.material.internal.ClippableRoundedCornerLayout r0 = (com.google.android.material.internal.ClippableRoundedCornerLayout) r0
            r0.updateCornerRadius(((java.lang.Float) r3.getAnimatedValue()).floatValue())
            return
        L_0x0015:
            android.view.KeyEvent$Callback r0 = r2.b
            com.ktakilat.loan.launch.LauncherActivity r0 = (com.ktakilat.loan.launch.LauncherActivity) r0
            int r1 = com.ktakilat.loan.launch.LauncherActivity.q
            r0.getClass()
            java.lang.Object r3 = r3.getAnimatedValue()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r1 = 100
            if (r3 == r1) goto L_0x003b
            int r1 = r0.m
            if (r3 >= r1) goto L_0x0031
            goto L_0x003b
        L_0x0031:
            com.pendanaan.kta.databinding.ActivityLaunchLauncherBinding r1 = r0.p
            com.ktakilat.cbase.weight.circleprogress.CircleProgressBar r1 = r1.ignoreProgress
            r1.setProgress(r3)
            r0.m = r3
            goto L_0x005e
        L_0x003b:
            android.animation.ValueAnimator r3 = r0.j
            if (r3 == 0) goto L_0x004a
            boolean r3 = r3.isRunning()
            if (r3 == 0) goto L_0x004a
            android.animation.ValueAnimator r3 = r0.j
            r3.cancel()
        L_0x004a:
            monitor-enter(r0)
            android.animation.ValueAnimator r3 = r0.j     // Catch:{ Exception -> 0x0058 }
            if (r3 == 0) goto L_0x0058
            r3.cancel()     // Catch:{ Exception -> 0x0058 }
            r3 = 0
            r0.j = r3     // Catch:{ Exception -> 0x0058 }
            goto L_0x0058
        L_0x0056:
            r3 = move-exception
            goto L_0x005f
        L_0x0058:
            com.ktakilat.loan.launch.LauncherPresenter r3 = r0.i     // Catch:{ all -> 0x0056 }
            r3.b()     // Catch:{ all -> 0x0056 }
            monitor-exit(r0)
        L_0x005e:
            return
        L_0x005f:
            monitor-exit(r0)     // Catch:{ all -> 0x0056 }
            throw r3
        L_0x0061:
            android.view.KeyEvent$Callback r0 = r2.b
            androidx.drawerlayout.widget.DrawerLayout r0 = (androidx.drawerlayout.widget.DrawerLayout) r0
            r0.setScrimColor(androidx.core.graphics.ColorUtils.setAlphaComponent(com.google.android.material.navigation.DrawerLayoutUtils.DEFAULT_SCRIM_COLOR, com.google.android.material.animation.AnimationUtils.lerp(com.google.android.material.navigation.DrawerLayoutUtils.DEFAULT_SCRIM_ALPHA, 0, r3.getAnimatedFraction())))
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.q5.onAnimationUpdate(android.animation.ValueAnimator):void");
    }
}
