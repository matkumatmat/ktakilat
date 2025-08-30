package defpackage;

import androidx.camera.video.internal.audio.AudioSource;

/* renamed from: i0  reason: default package */
public final /* synthetic */ class i0 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ AudioSource d;
    public final /* synthetic */ boolean e;

    public /* synthetic */ i0(AudioSource audioSource, boolean z, int i) {
        this.c = i;
        this.d = audioSource;
        this.e = z;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$mute$7(this.e);
                return;
            default:
                this.d.lambda$start$2(this.e);
                return;
        }
    }
}
