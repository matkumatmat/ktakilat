package androidx.camera.camera2.internal;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Range;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.interop.ExperimentalCamera2Interop;
import androidx.camera.core.CameraControl;
import androidx.camera.core.ExposureState;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

public class ExposureControl {
    private static final int DEFAULT_EXPOSURE_COMPENSATION = 0;
    @NonNull
    private final Camera2CameraControlImpl mCameraControl;
    @NonNull
    private final Executor mExecutor;
    @NonNull
    private final ExposureStateImpl mExposureStateImpl;
    private boolean mIsActive = false;
    @Nullable
    private Camera2CameraControlImpl.CaptureResultListener mRunningCaptureResultListener;
    @Nullable
    private CallbackToFutureAdapter.Completer<Integer> mRunningCompleter;

    public ExposureControl(@NonNull Camera2CameraControlImpl camera2CameraControlImpl, @NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat, @NonNull Executor executor) {
        this.mCameraControl = camera2CameraControlImpl;
        this.mExposureStateImpl = new ExposureStateImpl(cameraCharacteristicsCompat, 0);
        this.mExecutor = executor;
    }

    private void clearRunningTask() {
        CallbackToFutureAdapter.Completer<Integer> completer = this.mRunningCompleter;
        if (completer != null) {
            completer.setException(new CameraControl.OperationCanceledException("Cancelled by another setExposureCompensationIndex()"));
            this.mRunningCompleter = null;
        }
        Camera2CameraControlImpl.CaptureResultListener captureResultListener = this.mRunningCaptureResultListener;
        if (captureResultListener != null) {
            this.mCameraControl.removeCaptureResultListener(captureResultListener);
            this.mRunningCaptureResultListener = null;
        }
    }

    public static ExposureState getDefaultExposureState(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        return new ExposureStateImpl(cameraCharacteristicsCompat, 0);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$setExposureCompensationIndex$0(int i, CallbackToFutureAdapter.Completer completer, TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION);
        if (num != null && num2 != null) {
            int intValue = num.intValue();
            if ((intValue != 2 && intValue != 3 && intValue != 4) || num2.intValue() != i) {
                return false;
            }
            completer.set(Integer.valueOf(i));
            return true;
        } else if (num2 == null || num2.intValue() != i) {
            return false;
        } else {
            completer.set(Integer.valueOf(i));
            return true;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setExposureCompensationIndex$1(CallbackToFutureAdapter.Completer completer, int i) {
        boolean z;
        boolean z2 = false;
        if (!this.mIsActive) {
            this.mExposureStateImpl.setExposureCompensationIndex(0);
            completer.setException(new CameraControl.OperationCanceledException("Camera is not active."));
            return;
        }
        clearRunningTask();
        if (this.mRunningCompleter == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "mRunningCompleter should be null when starting set a new exposure compensation value");
        if (this.mRunningCaptureResultListener == null) {
            z2 = true;
        }
        Preconditions.checkState(z2, "mRunningCaptureResultListener should be null when starting set a new exposure compensation value");
        u6 u6Var = new u6(i, completer);
        this.mRunningCaptureResultListener = u6Var;
        this.mRunningCompleter = completer;
        this.mCameraControl.addCaptureResultListener(u6Var);
        this.mCameraControl.updateSessionConfigSynchronous();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$setExposureCompensationIndex$2(int i, CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new r0(i, this, completer));
        return ba.q(new StringBuilder("setExposureCompensationIndex["), "]", i);
    }

    @NonNull
    public ExposureState getExposureState() {
        return this.mExposureStateImpl;
    }

    public void setActive(boolean z) {
        if (z != this.mIsActive) {
            this.mIsActive = z;
            if (!z) {
                this.mExposureStateImpl.setExposureCompensationIndex(0);
                clearRunningTask();
            }
        }
    }

    @OptIn(markerClass = {ExperimentalCamera2Interop.class})
    public void setCaptureRequestOption(@NonNull Camera2ImplConfig.Builder builder) {
        builder.setCaptureRequestOptionWithPriority(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(this.mExposureStateImpl.getExposureCompensationIndex()), Config.OptionPriority.REQUIRED);
    }

    @NonNull
    public ListenableFuture<Integer> setExposureCompensationIndex(int i) {
        if (!this.mExposureStateImpl.isExposureCompensationSupported()) {
            return Futures.immediateFailedFuture(new IllegalArgumentException("ExposureCompensation is not supported"));
        }
        Range<Integer> exposureCompensationRange = this.mExposureStateImpl.getExposureCompensationRange();
        if (!exposureCompensationRange.contains(Integer.valueOf(i))) {
            StringBuilder t = ba.t(i, "Requested ExposureCompensation ", " is not within valid range [");
            t.append(exposureCompensationRange.getUpper());
            t.append("..");
            t.append(exposureCompensationRange.getLower());
            t.append("]");
            return Futures.immediateFailedFuture(new IllegalArgumentException(t.toString()));
        }
        this.mExposureStateImpl.setExposureCompensationIndex(i);
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new g3((Object) this, i)));
    }
}
