package defpackage;

import android.net.Uri;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.processing.SurfaceProcessorNode;
import androidx.camera.video.QualitySelector;
import androidx.camera.video.Recorder;
import androidx.camera.video.VideoSpec;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import java.util.Map;

/* renamed from: od  reason: default package */
public final /* synthetic */ class od implements Consumer {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ od(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    public final void accept(Object obj) {
        switch (this.c) {
            case 0:
                ((Recorder) this.d).lambda$setupAndStartMediaMuxer$9((Uri) obj);
                return;
            case 1:
                ((VideoSpec.Builder) obj).setQualitySelector((QualitySelector) this.d);
                return;
            case 2:
                SurfaceProcessorNode.lambda$setUpRotationUpdates$1((Map) this.d, (SurfaceRequest.TransformationInfo) obj);
                return;
            default:
                ((CallbackToFutureAdapter.Completer) this.d).set((SurfaceRequest.Result) obj);
                return;
        }
    }
}
