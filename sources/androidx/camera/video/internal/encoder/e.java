package androidx.camera.video.internal.encoder;

import androidx.camera.video.internal.encoder.EncoderImpl;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ EncoderImpl.ByteBufferInput d;
    public final /* synthetic */ CallbackToFutureAdapter.Completer e;

    public /* synthetic */ e(EncoderImpl.ByteBufferInput byteBufferInput, CallbackToFutureAdapter.Completer completer, int i) {
        this.c = i;
        this.d = byteBufferInput;
        this.e = completer;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$acquireBuffer$4(this.e);
                return;
            default:
                this.d.lambda$fetchData$0(this.e);
                return;
        }
    }
}
