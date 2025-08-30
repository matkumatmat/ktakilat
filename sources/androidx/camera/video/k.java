package androidx.camera.video;

import android.view.Surface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.video.Recorder;
import androidx.camera.video.VideoCapture;

public final /* synthetic */ class k implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ k(int i, Object obj, Object obj2) {
        this.c = i;
        this.d = obj;
        this.e = obj2;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                ((Recorder.RecordingRecord) this.d).lambda$updateVideoRecordEvent$6((VideoRecordEvent) this.e);
                return;
            case 1:
                ((VideoCapture.AnonymousClass2) this.d).lambda$onCaptureCompleted$0((SessionConfig.Builder) this.e);
                return;
            default:
                ((VideoEncoderSession) this.d).lambda$configureVideoEncoderInternal$4((Surface) this.e);
                return;
        }
    }
}
