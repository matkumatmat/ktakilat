package androidx.camera.video;

import android.media.MediaMuxer;
import android.os.ParcelFileDescriptor;
import androidx.camera.video.Recorder;
import androidx.core.util.Consumer;

public final /* synthetic */ class f implements Recorder.RecordingRecord.MediaMuxerSupplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OutputOptions f34a;
    public final /* synthetic */ ParcelFileDescriptor b;

    public /* synthetic */ f(OutputOptions outputOptions, ParcelFileDescriptor parcelFileDescriptor) {
        this.f34a = outputOptions;
        this.b = parcelFileDescriptor;
    }

    public final MediaMuxer get(int i, Consumer consumer) {
        return Recorder.RecordingRecord.lambda$initializeRecording$1(this.f34a, this.b, i, consumer);
    }
}
