package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.camera.core.impl.Observable;
import androidx.camera.video.internal.BufferProvider;
import androidx.camera.video.internal.encoder.Encoder;
import androidx.camera.video.internal.encoder.EncoderImpl;
import java.util.Map;
import java.util.concurrent.Executor;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ a(int i, Object obj, Object obj2) {
        this.c = i;
        this.d = obj;
        this.e = obj2;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                EncoderImpl.lambda$addSignalEosTimeoutIfNeeded$9((Executor) this.d, (EncoderImpl.MediaCodecCallback) this.e);
                return;
            case 1:
                ((EncoderImpl) this.d).lambda$matchAcquisitionsAndFreeBufferIndexes$15((InputBufferImpl) this.e);
                return;
            case 2:
                ((Observable.Observer) ((Map.Entry) this.d).getKey()).onNewData((BufferProvider.State) this.e);
                return;
            case 3:
                ((Observable.Observer) this.d).onNewData((BufferProvider.State) this.e);
                return;
            case 4:
                ((EncoderImpl.ByteBufferInput) this.d).lambda$removeObserver$8((Observable.Observer) this.e);
                return;
            case 5:
                ((EncoderImpl.MediaCodecCallback) this.e).lambda$onOutputFormatChanged$7((MediaFormat) this.d);
                return;
            case 6:
                ((EncoderCallback) this.d).onEncodedData((EncodedDataImpl) this.e);
                return;
            case 7:
                ((EncoderCallback) this.d).onOutputConfigUpdate(new i((MediaFormat) this.e));
                return;
            case 8:
                ((EncoderImpl.MediaCodecCallback) this.e).lambda$onError$4((MediaCodec.CodecException) this.d);
                return;
            default:
                ((Encoder.SurfaceInput.OnSurfaceUpdateListener) this.d).onSurfaceUpdate((Surface) this.e);
                return;
        }
    }

    public /* synthetic */ a(EncoderImpl.MediaCodecCallback mediaCodecCallback, Object obj, int i) {
        this.c = i;
        this.e = mediaCodecCallback;
        this.d = obj;
    }
}
