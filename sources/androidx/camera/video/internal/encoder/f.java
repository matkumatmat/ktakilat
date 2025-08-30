package androidx.camera.video.internal.encoder;

import androidx.camera.video.internal.encoder.EncoderImpl;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ EncoderImpl.ByteBufferInput d;
    public final /* synthetic */ ListenableFuture e;

    public /* synthetic */ f(EncoderImpl.ByteBufferInput byteBufferInput, ListenableFuture listenableFuture, int i) {
        this.c = i;
        this.d = byteBufferInput;
        this.e = listenableFuture;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$acquireBuffer$2(this.e);
                return;
            default:
                this.d.lambda$acquireBuffer$3(this.e);
                return;
        }
    }
}
