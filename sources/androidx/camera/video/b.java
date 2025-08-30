package androidx.camera.video;

import androidx.camera.video.Recorder;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class b implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ int c;
    public final /* synthetic */ Recorder d;
    public final /* synthetic */ Recorder.RecordingRecord e;

    public /* synthetic */ b(Recorder recorder, Recorder.RecordingRecord recordingRecord, int i) {
        this.c = i;
        this.d = recorder;
        this.e = recordingRecord;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.c) {
            case 0:
                return this.d.lambda$updateEncoderCallbacks$10(this.e, completer);
            default:
                return this.d.lambda$updateEncoderCallbacks$12(this.e, completer);
        }
    }
}
