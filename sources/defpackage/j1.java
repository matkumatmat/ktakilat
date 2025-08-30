package defpackage;

import androidx.camera.video.internal.audio.BufferedAudioStream;

/* renamed from: j1  reason: default package */
public final /* synthetic */ class j1 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ BufferedAudioStream d;

    public /* synthetic */ j1(BufferedAudioStream bufferedAudioStream, int i) {
        this.c = i;
        this.d = bufferedAudioStream;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$stop$1();
                return;
            case 1:
                this.d.lambda$start$0();
                return;
            case 2:
                this.d.collectAudioData();
                return;
            default:
                this.d.lambda$release$2();
                return;
        }
    }
}
