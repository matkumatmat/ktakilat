package androidx.camera.video.internal.encoder;

import androidx.camera.video.internal.encoder.EncoderImpl;

public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ EncoderImpl.MediaCodecCallback c;
    public final /* synthetic */ int d;

    public /* synthetic */ g(EncoderImpl.MediaCodecCallback mediaCodecCallback, int i) {
        this.c = mediaCodecCallback;
        this.d = i;
    }

    public final void run() {
        this.c.lambda$onInputBufferAvailable$0(this.d);
    }
}
