package defpackage;

import android.content.Context;
import android.view.Choreographer;
import androidx.profileinstaller.ProfileInstallerInitializer;

/* renamed from: id  reason: default package */
public final /* synthetic */ class id implements Choreographer.FrameCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProfileInstallerInitializer f201a;
    public final /* synthetic */ Context b;

    public /* synthetic */ id(ProfileInstallerInitializer profileInstallerInitializer, Context context) {
        this.f201a = profileInstallerInitializer;
        this.b = context;
    }

    public final void doFrame(long j) {
        this.f201a.lambda$create$0(this.b, j);
    }
}
