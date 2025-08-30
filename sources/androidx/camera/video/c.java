package androidx.camera.video;

import androidx.camera.video.Recorder;

public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Recorder d;
    public final /* synthetic */ Recorder.RecordingRecord e;

    public /* synthetic */ c(Recorder recorder, Recorder.RecordingRecord recordingRecord, int i) {
        this.c = i;
        this.d = recorder;
        this.e = recordingRecord;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$resume$4(this.e);
                return;
            default:
                this.d.lambda$pause$3(this.e);
                return;
        }
    }
}
