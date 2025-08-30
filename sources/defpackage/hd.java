package defpackage;

import androidx.profileinstaller.ProfileInstaller;

/* renamed from: hd  reason: default package */
public final /* synthetic */ class hd implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ ProfileInstaller.DiagnosticsCallback d;
    public final /* synthetic */ int e;
    public final /* synthetic */ Object f;

    public /* synthetic */ hd(ProfileInstaller.DiagnosticsCallback diagnosticsCallback, int i, Object obj, int i2) {
        this.c = i2;
        this.d = diagnosticsCallback;
        this.e = i;
        this.f = obj;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.onResultReceived(this.e, this.f);
                return;
            default:
                this.d.onDiagnosticReceived(this.e, this.f);
                return;
        }
    }
}
