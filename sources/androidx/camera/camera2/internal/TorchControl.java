package androidx.camera.camera2.internal;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.workaround.FlashAvailabilityChecker;
import androidx.camera.core.CameraControl;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;

final class TorchControl {
    static final int DEFAULT_TORCH_STATE = 0;
    private static final String TAG = "TorchControl";
    private final Camera2CameraControlImpl mCamera2CameraControlImpl;
    CallbackToFutureAdapter.Completer<Void> mEnableTorchCompleter;
    private final Executor mExecutor;
    private final boolean mHasFlashUnit;
    private boolean mIsActive;
    boolean mTargetTorchEnabled;
    private final MutableLiveData<Integer> mTorchState = new MutableLiveData<>(0);

    public TorchControl(@NonNull Camera2CameraControlImpl camera2CameraControlImpl, @NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat, @NonNull Executor executor) {
        this.mCamera2CameraControlImpl = camera2CameraControlImpl;
        this.mExecutor = executor;
        Objects.requireNonNull(cameraCharacteristicsCompat);
        this.mHasFlashUnit = FlashAvailabilityChecker.isFlashAvailable(new k0(cameraCharacteristicsCompat, 6));
        camera2CameraControlImpl.addCaptureResultListener(new q0(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$enableTorch$2(boolean z, CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new d0(this, completer, z));
        return "enableTorch: " + z;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$0(TotalCaptureResult totalCaptureResult) {
        boolean z;
        if (this.mEnableTorchCompleter != null) {
            Integer num = (Integer) totalCaptureResult.getRequest().get(CaptureRequest.FLASH_MODE);
            if (num == null || num.intValue() != 2) {
                z = false;
            } else {
                z = true;
            }
            if (z == this.mTargetTorchEnabled) {
                this.mEnableTorchCompleter.set(null);
                this.mEnableTorchCompleter = null;
            }
        }
        return false;
    }

    private <T> void setLiveDataValue(@NonNull MutableLiveData<T> mutableLiveData, T t) {
        if (Threads.isMainThread()) {
            mutableLiveData.setValue(t);
        } else {
            mutableLiveData.postValue(t);
        }
    }

    public ListenableFuture<Void> enableTorch(boolean z) {
        if (!this.mHasFlashUnit) {
            Logger.d(TAG, "Unable to enableTorch due to there is no flash unit.");
            return Futures.immediateFailedFuture(new IllegalStateException("No flash unit"));
        }
        setLiveDataValue(this.mTorchState, Integer.valueOf(z ? 1 : 0));
        return CallbackToFutureAdapter.getFuture(new b0(1, this, z));
    }

    /* renamed from: enableTorchInternal */
    public void lambda$enableTorch$1(@Nullable CallbackToFutureAdapter.Completer<Void> completer, boolean z) {
        if (!this.mHasFlashUnit) {
            if (completer != null) {
                completer.setException(new IllegalStateException("No flash unit"));
            }
        } else if (!this.mIsActive) {
            setLiveDataValue(this.mTorchState, 0);
            if (completer != null) {
                completer.setException(new CameraControl.OperationCanceledException("Camera is not active."));
            }
        } else {
            this.mTargetTorchEnabled = z;
            this.mCamera2CameraControlImpl.enableTorchInternal(z);
            setLiveDataValue(this.mTorchState, Integer.valueOf(z ? 1 : 0));
            CallbackToFutureAdapter.Completer<Void> completer2 = this.mEnableTorchCompleter;
            if (completer2 != null) {
                completer2.setException(new CameraControl.OperationCanceledException("There is a new enableTorch being set"));
            }
            this.mEnableTorchCompleter = completer;
        }
    }

    @NonNull
    public LiveData<Integer> getTorchState() {
        return this.mTorchState;
    }

    public void setActive(boolean z) {
        if (this.mIsActive != z) {
            this.mIsActive = z;
            if (!z) {
                if (this.mTargetTorchEnabled) {
                    this.mTargetTorchEnabled = false;
                    this.mCamera2CameraControlImpl.enableTorchInternal(false);
                    setLiveDataValue(this.mTorchState, 0);
                }
                CallbackToFutureAdapter.Completer<Void> completer = this.mEnableTorchCompleter;
                if (completer != null) {
                    completer.setException(new CameraControl.OperationCanceledException("Camera is not active."));
                    this.mEnableTorchCompleter = null;
                }
            }
        }
    }
}
