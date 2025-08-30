package defpackage;

import com.google.firebase.FirebaseApp;

/* renamed from: a9  reason: default package */
public final /* synthetic */ class a9 implements FirebaseApp.BackgroundStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseApp f222a;

    public /* synthetic */ a9(FirebaseApp firebaseApp) {
        this.f222a = firebaseApp;
    }

    public final void onBackgroundStateChanged(boolean z) {
        this.f222a.lambda$new$1(z);
    }
}
