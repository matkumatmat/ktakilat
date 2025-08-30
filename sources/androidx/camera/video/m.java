package androidx.camera.video;

import androidx.camera.video.Recorder;

public final /* synthetic */ class m implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ m(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                ((Recorder.SetupVideoTask.AnonymousClass1) this.d).lambda$onFailure$0();
                return;
            default:
                ((VideoEncoderSession) this.d).lambda$terminateNow$3();
                return;
        }
    }
}
