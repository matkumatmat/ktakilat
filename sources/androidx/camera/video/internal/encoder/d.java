package androidx.camera.video.internal.encoder;

import androidx.camera.video.internal.encoder.EncoderImpl;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class d implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ int c;
    public final /* synthetic */ EncoderImpl.ByteBufferInput d;

    public /* synthetic */ d(EncoderImpl.ByteBufferInput byteBufferInput, int i) {
        this.c = i;
        this.d = byteBufferInput;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.c) {
            case 0:
                return this.d.lambda$fetchData$1(completer);
            default:
                return this.d.lambda$acquireBuffer$5(completer);
        }
    }
}
