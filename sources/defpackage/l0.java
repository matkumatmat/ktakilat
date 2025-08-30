package defpackage;

import androidx.camera.video.internal.audio.AudioSource;

/* renamed from: l0  reason: default package */
public final /* synthetic */ class l0 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ AudioSource.AudioSourceCallback d;
    public final /* synthetic */ boolean e;

    public /* synthetic */ l0(AudioSource.AudioSourceCallback audioSourceCallback, boolean z, int i) {
        this.c = i;
        this.d = audioSourceCallback;
        this.e = z;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.onSilenceStateChanged(this.e);
                return;
            default:
                this.d.onSuspendStateChanged(this.e);
                return;
        }
    }
}
