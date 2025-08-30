package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import androidx.camera.video.internal.encoder.EncoderImpl;

public final /* synthetic */ class h implements Runnable {
    public final /* synthetic */ EncoderImpl.MediaCodecCallback c;
    public final /* synthetic */ MediaCodec.BufferInfo d;
    public final /* synthetic */ MediaCodec e;
    public final /* synthetic */ int f;

    public /* synthetic */ h(EncoderImpl.MediaCodecCallback mediaCodecCallback, MediaCodec.BufferInfo bufferInfo, MediaCodec mediaCodec, int i) {
        this.c = mediaCodecCallback;
        this.d = bufferInfo;
        this.e = mediaCodec;
        this.f = i;
    }

    public final void run() {
        this.c.lambda$onOutputBufferAvailable$1(this.d, this.e, this.f);
    }
}
