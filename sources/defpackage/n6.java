package defpackage;

import androidx.camera.video.internal.encoder.EncoderImpl;

/* renamed from: n6  reason: default package */
public final /* synthetic */ class n6 implements Runnable {
    public final /* synthetic */ EncoderImpl c;
    public final /* synthetic */ long d;
    public final /* synthetic */ long e;

    public /* synthetic */ n6(EncoderImpl encoderImpl, long j, long j2) {
        this.c = encoderImpl;
        this.d = j;
        this.e = j2;
    }

    public final void run() {
        this.c.lambda$stop$4(this.d, this.e);
    }
}
