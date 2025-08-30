package androidx.camera.video;

import androidx.camera.video.Recorder;

public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ Recorder c;
    public final /* synthetic */ Recorder.RecordingRecord d;
    public final /* synthetic */ boolean e;

    public /* synthetic */ d(Recorder recorder, Recorder.RecordingRecord recordingRecord, boolean z) {
        this.c = recorder;
        this.d = recordingRecord;
        this.e = z;
    }

    public final void run() {
        this.c.lambda$mute$6(this.d, this.e);
    }
}
