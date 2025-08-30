package defpackage;

import androidx.camera.video.internal.encoder.EncoderCallback;

/* renamed from: p6  reason: default package */
public final /* synthetic */ class p6 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ EncoderCallback d;

    public /* synthetic */ p6(EncoderCallback encoderCallback, int i) {
        this.c = i;
        this.d = encoderCallback;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.onEncodeStop();
                return;
            case 1:
                this.d.onEncodeStart();
                return;
            default:
                this.d.onEncodePaused();
                return;
        }
    }
}
