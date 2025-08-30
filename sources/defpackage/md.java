package defpackage;

import androidx.camera.video.Recorder;

/* renamed from: md  reason: default package */
public final /* synthetic */ class md implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Recorder d;

    public /* synthetic */ md(Recorder recorder, int i) {
        this.c = i;
        this.d = recorder;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.tryServicePendingRecording();
                return;
            default:
                this.d.lambda$start$2();
                return;
        }
    }
}
