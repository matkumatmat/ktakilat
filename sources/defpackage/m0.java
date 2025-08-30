package defpackage;

import android.content.Context;
import android.content.Intent;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageProcessor;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.core.processing.InternalImageProcessor;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceProcessorNode;
import androidx.camera.core.processing.concurrent.DualSurfaceProcessor;
import androidx.camera.video.Recorder;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.internal.audio.AudioSource;
import androidx.camera.video.internal.audio.AudioStream;
import androidx.camera.video.internal.audio.BufferedAudioStream;
import androidx.camera.video.internal.encoder.EncoderImpl;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.appsflyer.internal.AFa1tSDK;
import com.appsflyer.internal.AFd1uSDK;
import com.appsflyer.internal.AFi1aSDK;
import com.appsflyer.internal.AFj1sSDK;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.messaging.EnhancedIntentService;
import com.google.firebase.perf.session.PerfSession;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.GaugeMetric;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import com.google.firebase.perf.v1.TraceMetric;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: m0  reason: default package */
public final /* synthetic */ class m0 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    public /* synthetic */ m0(BufferedAudioStream bufferedAudioStream, AudioStream.AudioStreamCallback audioStreamCallback, Executor executor) {
        this.c = 1;
        this.e = bufferedAudioStream;
        this.f = audioStreamCallback;
        this.d = executor;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                ((AudioSource) this.e).lambda$setAudioSourceCallback$6((Executor) this.d, (AudioSource.AudioSourceCallback) this.f);
                return;
            case 1:
                ((BufferedAudioStream) this.e).lambda$setCallback$3((AudioStream.AudioStreamCallback) this.f, (Executor) this.d);
                return;
            case 2:
                ((Camera2CameraControlImpl) this.e).lambda$addSessionCameraCaptureCallback$8((Executor) this.d, (CameraCaptureCallback) this.f);
                return;
            case 3:
                ((BiConsumer) this.e).accept((String) this.d, (ConfigContainer) this.f);
                return;
            case 4:
                ((CrashlyticsCore) this.e).lambda$logException$1((Throwable) this.d, (Map) this.f);
                return;
            case 5:
                ((DefaultSurfaceProcessor) this.e).lambda$executeSafely$12((Runnable) this.d, (Runnable) this.f);
                return;
            case 6:
                ((DualSurfaceProcessor) this.e).lambda$executeSafely$8((Runnable) this.d, (Runnable) this.f);
                return;
            case 7:
                ((EncoderImpl) this.e).lambda$stopMediaCodec$12((ArrayList) this.d, (Runnable) this.f);
                return;
            case 8:
                ((EnhancedIntentService) this.e).lambda$processIntent$0((Intent) this.d, (TaskCompletionSource) this.f);
                return;
            case 9:
                ((ImageCapture) this.e).lambda$takePicture$1((Executor) this.d, (ImageCapture.OnImageCapturedCallback) this.f);
                return;
            case 10:
                ((InternalImageProcessor) this.e).lambda$safeProcess$0((ImageProcessor.Request) this.d, (CallbackToFutureAdapter.Completer) this.f);
                return;
            case 11:
                ((Recorder) this.e).lambda$onSurfaceRequested$0((SurfaceRequest) this.d, (Timebase) this.f);
                return;
            case 12:
                ((SessionManager) this.e).lambda$setApplicationContext$0((Context) this.d, (PerfSession) this.f);
                return;
            case 13:
                ((SurfaceProcessorNode) this.e).lambda$sendSurfaceOutputs$0((SurfaceEdge) this.d, (Map.Entry) this.f);
                return;
            case 14:
                ((TransportManager) this.e).lambda$log$4((GaugeMetric) this.d, (ApplicationProcessState) this.f);
                return;
            case 15:
                ((TransportManager) this.e).lambda$log$2((TraceMetric) this.d, (ApplicationProcessState) this.f);
                return;
            case 16:
                ((TransportManager) this.e).lambda$log$3((NetworkRequestMetric) this.d, (ApplicationProcessState) this.f);
                return;
            case 17:
                VideoCapture.lambda$setupSurfaceUpdateNotifier$5((AtomicBoolean) this.e, (SessionConfig.Builder) this.d, (CameraCaptureCallback) this.f);
                return;
            case 18:
                ((AFa1tSDK) this.e).d_((Context) this.d, (Intent) this.f);
                return;
            case 19:
                AFd1uSDK.getMediationNetwork((AFd1uSDK) this.e, (Throwable) this.d, (String) this.f);
                return;
            default:
                ((AFj1sSDK) this.e).getMonetizationNetwork((AFi1aSDK) this.d, (Runnable) this.f);
                return;
        }
    }

    public /* synthetic */ m0(Object obj, int i, Object obj2, Object obj3) {
        this.c = i;
        this.e = obj;
        this.d = obj2;
        this.f = obj3;
    }
}
