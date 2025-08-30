package defpackage;

import android.app.Activity;
import android.app.job.JobParameters;
import android.content.Context;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraX;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraRepository;
import androidx.camera.core.impl.ConstantObservable;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.core.processing.concurrent.DualSurfaceProcessor;
import androidx.camera.video.internal.BufferProvider;
import androidx.camera.video.internal.audio.AudioSource;
import androidx.camera.video.internal.encoder.EncoderImpl;
import androidx.camera.view.CameraController;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.Violation;
import androidx.lifecycle.DispatchQueue;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Callables;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.messaging.ImageDownload;
import com.google.firebase.perf.config.DeviceCacheManager;
import com.google.firebase.perf.metrics.AppStartTrace;
import com.google.firebase.perf.v1.TraceMetric;
import com.google.gson.JsonObject;
import com.ktakilat.cbase.utils.LogUtil;
import com.ktakilat.loan.web.CommonWebActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* renamed from: e0  reason: default package */
public final /* synthetic */ class e0 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ e0(int i, Object obj, Object obj2) {
        this.c = i;
        this.d = obj;
        this.e = obj2;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                ((AppStartTrace) this.d).lambda$logExperimentTrace$0((TraceMetric.Builder) this.e);
                return;
            case 1:
                ((AudioSource) this.d).lambda$setBufferProvider$0((BufferProvider) this.e);
                return;
            case 2:
                ((AudioSource.AudioSourceCallback) this.d).onError((Throwable) this.e);
                return;
            case 3:
                ((AudioSource) this.d).lambda$release$4((CallbackToFutureAdapter.Completer) this.e);
                return;
            case 4:
                ((AudioSource) this.d).lambda$postMaxAmplitude$11((AudioSource.AudioSourceCallback) this.e);
                return;
            case 5:
                Callables.lambda$threadRenaming$3((Supplier) this.d, (Runnable) this.e);
                return;
            case 6:
                ((Camera2CameraControlImpl) this.d).lambda$updateSessionConfigAsync$6((CallbackToFutureAdapter.Completer) this.e);
                return;
            case 7:
                ((Camera2CameraControlImpl) this.d).lambda$removeSessionCameraCaptureCallback$9((CameraCaptureCallback) this.e);
                return;
            case 8:
                ((CameraController) this.d).lambda$setCameraSelector$3((CameraSelector) this.e);
                return;
            case 9:
                ((CameraRepository) this.d).lambda$deinit$1((CameraInternal) this.e);
                return;
            case 10:
                ((CameraX) this.d).lambda$shutdownInternal$3((CallbackToFutureAdapter.Completer) this.e);
                return;
            case 11:
                try {
                    String asString = ((JsonObject) this.d).get("url").getAsString();
                    ArrayList arrayList = (ArrayList) this.e;
                    CommonWebActivity commonWebActivity = null;
                    if (arrayList != null) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            WeakReference weakReference = (WeakReference) it.next();
                            if (weakReference != null && weakReference.get() != null && !((Activity) weakReference.get()).isFinishing() && !((Activity) weakReference.get()).isDestroyed()) {
                                if (commonWebActivity != null) {
                                    ((Activity) weakReference.get()).finish();
                                } else if ((weakReference.get() instanceof CommonWebActivity) && ((CommonWebActivity) weakReference.get()).k.equals(asString)) {
                                    commonWebActivity = (CommonWebActivity) weakReference.get();
                                }
                            }
                        }
                    }
                    if (commonWebActivity != null) {
                        commonWebActivity.finish();
                        return;
                    }
                    return;
                } catch (Exception e2) {
                    LogUtil.a(e2);
                    return;
                }
            case 12:
                ((ConstantObservable) this.d).lambda$addObserver$0((Observable.Observer) this.e);
                return;
            case 13:
                ((CrashlyticsCore) this.d).lambda$setCustomKeys$6((Map) this.e);
                return;
            case 14:
                ((CrashlyticsCore) this.d).lambda$logFatalException$8((Throwable) this.e);
                return;
            case 15:
                ((CrashlyticsCore) this.d).lambda$setUserId$4((String) this.e);
                return;
            case 16:
                DefaultSpecialEffectsController.collectEffects$lambda$2((DefaultSpecialEffectsController) this.d, (SpecialEffectsController.Operation) this.e);
                return;
            case 17:
                ((DefaultSurfaceProcessor) this.d).lambda$onInputSurface$2((SurfaceRequest) this.e);
                return;
            case 18:
                ((DefaultSurfaceProcessor) this.d).lambda$onOutputSurface$4((SurfaceOutput) this.e);
                return;
            case 19:
                ((DeferrableSurface) this.d).lambda$new$2((String) this.e);
                return;
            case 20:
                ((DeviceCacheManager) this.d).lambda$setContext$0((Context) this.e);
                return;
            case 21:
                DispatchQueue.dispatchAndEnqueue$lambda$2$lambda$1((DispatchQueue) this.d, (Runnable) this.e);
                return;
            case 22:
                ((DualSurfaceProcessor) this.d).lambda$onInputSurface$1((SurfaceRequest) this.e);
                return;
            case 23:
                ((DualSurfaceProcessor) this.d).lambda$onOutputSurface$3((SurfaceOutput) this.e);
                return;
            case 24:
                ((EncoderImpl) this.d).lambda$acquireInputBuffer$14((CallbackToFutureAdapter.Completer) this.e);
                return;
            case 25:
                FragmentStrictMode.handlePolicyViolation$lambda$0((FragmentStrictMode.Policy) this.d, (Violation) this.e);
                return;
            case 26:
                FragmentStrictMode.handlePolicyViolation$lambda$1((String) this.d, (Violation) this.e);
                return;
            case 27:
                ImageAnalysis.lambda$createPipeline$1((SafeCloseImageReaderProxy) this.d, (SafeCloseImageReaderProxy) this.e);
                return;
            case 28:
                ((ImageDownload) this.d).lambda$start$0((TaskCompletionSource) this.e);
                return;
            default:
                ((JobInfoSchedulerService) this.d).lambda$onStartJob$0((JobParameters) this.e);
                return;
        }
    }
}
