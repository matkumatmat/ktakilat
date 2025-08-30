package defpackage;

import androidx.camera.video.internal.encoder.EncoderImpl;

/* renamed from: m6  reason: default package */
public final /* synthetic */ class m6 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ EncoderImpl d;
    public final /* synthetic */ long e;

    public /* synthetic */ m6(EncoderImpl encoderImpl, long j, int i) {
        this.c = i;
        this.d = encoderImpl;
        this.e = j;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$start$1(this.e);
                return;
            default:
                this.d.lambda$pause$5(this.e);
                return;
        }
    }
}
