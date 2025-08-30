package defpackage;

import androidx.camera.video.internal.audio.AudioSource;

/* renamed from: j0  reason: default package */
public final /* synthetic */ class j0 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ AudioSource d;

    public /* synthetic */ j0(AudioSource audioSource, int i) {
        this.c = i;
        this.d = audioSource;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$stop$3();
                return;
            default:
                this.d.lambda$start$1();
                return;
        }
    }
}
