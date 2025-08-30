package androidx.camera.video.internal.encoder;

import androidx.camera.core.impl.Observable;
import androidx.camera.video.internal.encoder.EncoderImpl;
import java.util.concurrent.Executor;

public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ int c = 0;
    public final /* synthetic */ Executor d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    public /* synthetic */ c(EncoderImpl.ByteBufferInput byteBufferInput, Observable.Observer observer, Executor executor) {
        this.e = byteBufferInput;
        this.f = observer;
        this.d = executor;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                ((EncoderImpl.ByteBufferInput) this.e).lambda$addObserver$7((Observable.Observer) this.f, this.d);
                return;
            default:
                ((EncoderImpl.MediaCodecCallback) this.e).lambda$reachEndData$2(this.d, (EncoderCallback) this.f);
                return;
        }
    }

    public /* synthetic */ c(EncoderImpl.MediaCodecCallback mediaCodecCallback, Executor executor, EncoderCallback encoderCallback) {
        this.e = mediaCodecCallback;
        this.d = executor;
        this.f = encoderCallback;
    }
}
