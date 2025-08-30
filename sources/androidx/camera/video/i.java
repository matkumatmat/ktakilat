package androidx.camera.video;

import android.media.MediaScannerConnection;
import android.net.Uri;
import androidx.camera.video.Recorder;

public final /* synthetic */ class i implements MediaScannerConnection.OnScanCompletedListener {
    public final void onScanCompleted(String str, Uri uri) {
        Recorder.RecordingRecord.lambda$initializeRecording$3(str, uri);
    }
}
