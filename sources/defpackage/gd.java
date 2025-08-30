package defpackage;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.processing.SurfaceProcessorNode;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.video.Recorder;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.internal.audio.AudioStream;
import androidx.camera.video.internal.encoder.Encoder;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.appsflyer.AFLogger;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.material.search.SearchBar;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.ktakilat.cbase.utils.LogUtil;
import com.ktakilat.cbase.weight.DanaDialog;
import com.ktakilat.loan.weiget.PhoneUploadUtil;
import com.ktakilat.loan.weiget.VersionUtil;
import com.trustdecision.liveness.cw.api.ui.TDH5LivenessActivity;
import kotlin.jvm.functions.Function1;
import org.apache.commons.lang3.concurrent.TimedSemaphore;

/* renamed from: gd  reason: default package */
public final /* synthetic */ class gd implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ gd(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    public final void run() {
        Object obj = this.d;
        switch (this.c) {
            case 0:
                ProcessCameraProvider.shutdownAsync$lambda$0((ProcessCameraProvider) obj);
                return;
            case 1:
                ProcessLifecycleOwner.delayedPauseRunnable$lambda$0((ProcessLifecycleOwner) obj);
                return;
            case 2:
                Recorder.lambda$stopInternal$13((Encoder) obj);
                return;
            case 3:
                ((ImageCapture.ScreenFlashListener) obj).onCompleted();
                return;
            case 4:
                ((SearchBar) obj).lambda$startOnLoadAnimation$1();
                return;
            case 5:
                ((AudioStream.AudioStreamCallback) obj).onSilenceStateChanged(true);
                return;
            case 6:
                ((SurfaceProcessorNode) obj).lambda$release$2();
                return;
            case 7:
                ((TDH5LivenessActivity) obj).finish();
                return;
            case 8:
                ((TimedSemaphore) obj).endOfPeriod();
                return;
            case 9:
                ((UserMetadata) obj).serializeUserDataIfNeeded();
                return;
            case 10:
                DanaDialog danaDialog = VersionUtil.f600a;
                PhoneUploadUtil.h(LogUtil.b((Exception) obj));
                return;
            case 11:
                ((VideoCapture) obj).notifyReset();
                return;
            case 12:
                ((WorkInitializer) obj).lambda$ensureContextsScheduled$1();
                return;
            case 13:
                ((SafeCloseImageReaderProxy) obj).safeClose();
                return;
            default:
                AFLogger.getMediationNetwork((Function1) obj);
                return;
        }
    }
}
