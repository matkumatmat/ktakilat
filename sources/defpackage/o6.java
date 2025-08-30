package defpackage;

import androidx.camera.video.internal.encoder.EncoderImpl;

/* renamed from: o6  reason: default package */
public final /* synthetic */ class o6 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ EncoderImpl d;

    public /* synthetic */ o6(EncoderImpl encoderImpl, int i) {
        this.c = i;
        this.d = encoderImpl;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$stop$2();
                return;
            case 1:
                this.d.lambda$release$6();
                return;
            case 2:
                this.d.lambda$requestKeyFrame$8();
                return;
            case 3:
                this.d.lambda$signalSourceStopped$7();
                return;
            case 4:
                this.d.signalEndOfInputStream();
                return;
            default:
                this.d.lambda$stop$3();
                return;
        }
    }
}
