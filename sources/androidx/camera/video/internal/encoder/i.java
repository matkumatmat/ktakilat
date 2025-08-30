package androidx.camera.video.internal.encoder;

import android.media.MediaFormat;
import androidx.camera.video.internal.encoder.EncoderImpl;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicReference;

public final /* synthetic */ class i implements OutputConfig, CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ Object c;

    public /* synthetic */ i(Object obj) {
        this.c = obj;
    }

    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return ((AtomicReference) this.c).set(completer);
    }

    public MediaFormat getMediaFormat() {
        return EncoderImpl.MediaCodecCallback.lambda$onOutputFormatChanged$5((MediaFormat) this.c);
    }
}
