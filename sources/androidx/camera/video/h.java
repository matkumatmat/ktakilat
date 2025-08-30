package androidx.camera.video;

import android.content.Context;
import android.net.Uri;
import androidx.camera.video.Recorder;
import androidx.core.util.Consumer;

public final /* synthetic */ class h implements Consumer {
    public final /* synthetic */ MediaStoreOutputOptions c;
    public final /* synthetic */ Context d;

    public /* synthetic */ h(Context context, MediaStoreOutputOptions mediaStoreOutputOptions) {
        this.c = mediaStoreOutputOptions;
        this.d = context;
    }

    public final void accept(Object obj) {
        Recorder.RecordingRecord.lambda$initializeRecording$4(this.c, this.d, (Uri) obj);
    }
}
