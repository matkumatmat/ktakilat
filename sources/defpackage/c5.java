package defpackage;

import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.core.processing.concurrent.DualSurfaceProcessor;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* renamed from: c5  reason: default package */
public final /* synthetic */ class c5 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object g;

    public /* synthetic */ c5(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.c = i;
        this.d = obj;
        this.e = obj2;
        this.f = obj3;
        this.g = obj4;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                ((DefaultScheduler) this.d).lambda$schedule$1((TransportContext) this.e, (TransportScheduleCallback) this.f, (EventInternal) this.g);
                return;
            case 1:
                ((DefaultSurfaceProcessor) this.d).lambda$initGlRenderer$9((DynamicRange) this.e, (Map) this.f, (CallbackToFutureAdapter.Completer) this.g);
                return;
            case 2:
                ((DualSurfaceProcessor) this.d).lambda$initGlRenderer$5((DynamicRange) this.e, (Map) this.f, (CallbackToFutureAdapter.Completer) this.g);
                return;
            case 3:
                ((ImageCapture) this.d).lambda$takePicture$2((ImageCapture.OutputFileOptions) this.e, (Executor) this.f, (ImageCapture.OnImageSavedCallback) this.g);
                return;
            default:
                ((UserMetadata) this.d).lambda$setNewSession$0((String) this.e, (Map) this.f, (List) this.g);
                return;
        }
    }
}
