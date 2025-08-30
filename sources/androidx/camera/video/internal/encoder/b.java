package androidx.camera.video.internal.encoder;

import androidx.camera.video.internal.encoder.EncoderImpl;

public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ EncoderImpl.MediaCodecCallback c;

    public /* synthetic */ b(EncoderImpl.MediaCodecCallback mediaCodecCallback) {
        this.c = mediaCodecCallback;
    }

    public final void run() {
        this.c.reachEndData();
    }
}
