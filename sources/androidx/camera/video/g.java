package androidx.camera.video;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.video.Recorder;
import androidx.core.util.Consumer;

public final /* synthetic */ class g implements Consumer {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ g(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    public final void accept(Object obj) {
        switch (this.c) {
            case 0:
                Recorder.RecordingRecord.lambda$initializeRecording$2((MediaStoreOutputOptions) this.d, (Uri) obj);
                return;
            case 1:
                Recorder.RecordingRecord.lambda$initializeRecording$5((ParcelFileDescriptor) this.d, (Uri) obj);
                return;
            default:
                ((VideoEncoderSession) this.d).onSurfaceRequestComplete((SurfaceRequest.Result) obj);
                return;
        }
    }
}
