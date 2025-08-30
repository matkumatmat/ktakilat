package androidx.camera.video;

import androidx.camera.video.Recorder;

public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ Recorder c;
    public final /* synthetic */ Recorder.RecordingRecord d;
    public final /* synthetic */ long e;
    public final /* synthetic */ int f;
    public final /* synthetic */ Throwable g;

    public /* synthetic */ e(Recorder recorder, Recorder.RecordingRecord recordingRecord, long j, int i, Throwable th) {
        this.c = recorder;
        this.d = recordingRecord;
        this.e = j;
        this.f = i;
        this.g = th;
    }

    public final void run() {
        this.c.lambda$stop$5(this.d, this.e, this.f, this.g);
    }
}
