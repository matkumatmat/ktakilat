package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.VisibleForTesting;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.workaround.FlashAvailabilityChecker;
import androidx.camera.camera2.internal.compat.workaround.OverrideAeModeForStillCapture;
import androidx.camera.camera2.internal.compat.workaround.UseFlashModeTorchFor3aUpdate;
import androidx.camera.camera2.internal.compat.workaround.UseTorchAsFlash;
import androidx.camera.camera2.interop.ExperimentalCamera2Interop;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.imagecapture.CameraCapturePipeline;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraCaptureResults;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.ConvergenceUtils;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

class Camera2CapturePipeline {
    private static final String TAG = "Camera2CapturePipeline";
    @NonNull
    private final Camera2CameraControlImpl mCameraControl;
    @NonNull
    private final Quirks mCameraQuirk;
    @NonNull
    private final Executor mExecutor;
    private final boolean mHasFlashUnit;
    private final boolean mIsLegacyDevice;
    @NonNull
    private final ScheduledExecutorService mScheduler;
    private int mTemplate = 1;
    @NonNull
    private final UseTorchAsFlash mUseTorchAsFlash;

    public static class AePreCaptureTask implements PipelineTask {
        private final Camera2CameraControlImpl mCameraControl;
        private final int mFlashMode;
        private boolean mIsExecuted = false;
        private final OverrideAeModeForStillCapture mOverrideAeModeForStillCapture;

        public AePreCaptureTask(@NonNull Camera2CameraControlImpl camera2CameraControlImpl, int i, @NonNull OverrideAeModeForStillCapture overrideAeModeForStillCapture) {
            this.mCameraControl = camera2CameraControlImpl;
            this.mFlashMode = i;
            this.mOverrideAeModeForStillCapture = overrideAeModeForStillCapture;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Object lambda$preCapture$0(CallbackToFutureAdapter.Completer completer) throws Exception {
            this.mCameraControl.getFocusMeteringControl().lambda$triggerAePrecapture$2(completer);
            this.mOverrideAeModeForStillCapture.onAePrecaptureStarted();
            return "AePreCapture";
        }

        public boolean isCaptureResultNeeded() {
            if (this.mFlashMode == 0) {
                return true;
            }
            return false;
        }

        public void postCapture() {
            if (this.mIsExecuted) {
                Logger.d(Camera2CapturePipeline.TAG, "cancel TriggerAePreCapture");
                this.mCameraControl.getFocusMeteringControl().cancelAfAeTrigger(false, true);
                this.mOverrideAeModeForStillCapture.onAePrecaptureFinished();
            }
        }

        @NonNull
        public ListenableFuture<Boolean> preCapture(@Nullable TotalCaptureResult totalCaptureResult) {
            if (!Camera2CapturePipeline.isFlashRequired(this.mFlashMode, totalCaptureResult)) {
                return Futures.immediateFuture(Boolean.FALSE);
            }
            Logger.d(Camera2CapturePipeline.TAG, "Trigger AE");
            this.mIsExecuted = true;
            return FutureChain.from(CallbackToFutureAdapter.getFuture(new p(this, 0))).transform(new q(0), CameraXExecutors.directExecutor());
        }
    }

    public static class AfTask implements PipelineTask {
        private final Camera2CameraControlImpl mCameraControl;
        private boolean mIsExecuted = false;

        public AfTask(@NonNull Camera2CameraControlImpl camera2CameraControlImpl) {
            this.mCameraControl = camera2CameraControlImpl;
        }

        public boolean isCaptureResultNeeded() {
            return true;
        }

        public void postCapture() {
            if (this.mIsExecuted) {
                Logger.d(Camera2CapturePipeline.TAG, "cancel TriggerAF");
                this.mCameraControl.getFocusMeteringControl().cancelAfAeTrigger(true, false);
            }
        }

        @NonNull
        public ListenableFuture<Boolean> preCapture(@Nullable TotalCaptureResult totalCaptureResult) {
            Integer num;
            ListenableFuture<Boolean> immediateFuture = Futures.immediateFuture(Boolean.TRUE);
            if (totalCaptureResult == null || (num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_MODE)) == null) {
                return immediateFuture;
            }
            int intValue = num.intValue();
            if (intValue == 1 || intValue == 2) {
                Logger.d(Camera2CapturePipeline.TAG, "TriggerAf? AF mode auto");
                Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
                if (num2 != null && num2.intValue() == 0) {
                    Logger.d(Camera2CapturePipeline.TAG, "Trigger AF");
                    this.mIsExecuted = true;
                    this.mCameraControl.getFocusMeteringControl().triggerAf((CallbackToFutureAdapter.Completer<CameraCaptureResult>) null, false);
                }
            }
            return immediateFuture;
        }
    }

    public static class CameraCapturePipelineImpl implements CameraCapturePipeline {
        private final Executor mExecutor;
        private int mFlashMode;
        private final Pipeline mPipelineDelegate;

        public CameraCapturePipelineImpl(Pipeline pipeline, Executor executor, int i) {
            this.mPipelineDelegate = pipeline;
            this.mExecutor = executor;
            this.mFlashMode = i;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Object lambda$invokePostCapture$1(CallbackToFutureAdapter.Completer completer) throws Exception {
            this.mPipelineDelegate.executePostCapture();
            completer.set(null);
            return "invokePostCaptureFuture";
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ Void lambda$invokePreCapture$0(TotalCaptureResult totalCaptureResult) {
            return null;
        }

        @NonNull
        public ListenableFuture<Void> invokePostCapture() {
            return CallbackToFutureAdapter.getFuture(new p(this, 1));
        }

        @NonNull
        public ListenableFuture<Void> invokePreCapture() {
            Logger.d(Camera2CapturePipeline.TAG, "invokePreCapture");
            return FutureChain.from(this.mPipelineDelegate.executePreCapture(this.mFlashMode)).transform(new q(1), this.mExecutor);
        }
    }

    @VisibleForTesting
    public static class Pipeline {
        private static final long CHECK_3A_TIMEOUT_IN_NS;
        private static final long CHECK_3A_WITH_FLASH_TIMEOUT_IN_NS;
        private final Camera2CameraControlImpl mCameraControl;
        private final Executor mExecutor;
        private final boolean mIsLegacyDevice;
        private final OverrideAeModeForStillCapture mOverrideAeModeForStillCapture;
        private final PipelineTask mPipelineSubTask = new PipelineTask() {
            public boolean isCaptureResultNeeded() {
                for (PipelineTask isCaptureResultNeeded : Pipeline.this.mTasks) {
                    if (isCaptureResultNeeded.isCaptureResultNeeded()) {
                        return true;
                    }
                }
                return false;
            }

            public void postCapture() {
                for (PipelineTask postCapture : Pipeline.this.mTasks) {
                    postCapture.postCapture();
                }
            }

            @NonNull
            public ListenableFuture<Boolean> preCapture(@Nullable TotalCaptureResult totalCaptureResult) {
                ArrayList arrayList = new ArrayList();
                for (PipelineTask preCapture : Pipeline.this.mTasks) {
                    arrayList.add(preCapture.preCapture(totalCaptureResult));
                }
                return Futures.transform(Futures.allAsList(arrayList), new q(2), CameraXExecutors.directExecutor());
            }
        };
        private final ScheduledExecutorService mScheduler;
        final List<PipelineTask> mTasks = new ArrayList();
        private final int mTemplate;
        private long mTimeout3A = CHECK_3A_TIMEOUT_IN_NS;

        static {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            CHECK_3A_TIMEOUT_IN_NS = timeUnit.toNanos(1);
            CHECK_3A_WITH_FLASH_TIMEOUT_IN_NS = timeUnit.toNanos(5);
        }

        public Pipeline(int i, @NonNull Executor executor, @NonNull ScheduledExecutorService scheduledExecutorService, @NonNull Camera2CameraControlImpl camera2CameraControlImpl, boolean z, @NonNull OverrideAeModeForStillCapture overrideAeModeForStillCapture) {
            this.mTemplate = i;
            this.mExecutor = executor;
            this.mScheduler = scheduledExecutorService;
            this.mCameraControl = camera2CameraControlImpl;
            this.mIsLegacyDevice = z;
            this.mOverrideAeModeForStillCapture = overrideAeModeForStillCapture;
        }

        @OptIn(markerClass = {ExperimentalCamera2Interop.class})
        private void applyAeModeQuirk(@NonNull CaptureConfig.Builder builder) {
            Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
            builder2.setCaptureRequestOption(CaptureRequest.CONTROL_AE_MODE, 3);
            builder.addImplementationOptions(builder2.build());
        }

        private void applyStillCaptureTemplate(@NonNull CaptureConfig.Builder builder, @NonNull CaptureConfig captureConfig) {
            int i;
            if (this.mTemplate == 3 && !this.mIsLegacyDevice) {
                i = 4;
            } else if (captureConfig.getTemplateType() == -1 || captureConfig.getTemplateType() == 5) {
                i = 2;
            } else {
                i = -1;
            }
            if (i != -1) {
                builder.setTemplateType(i);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ ListenableFuture lambda$executeCapture$0(List list, int i, TotalCaptureResult totalCaptureResult) throws Exception {
            return submitConfigsInternal(list, i);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ ListenableFuture lambda$executePreCapture$1(int i, TotalCaptureResult totalCaptureResult) throws Exception {
            if (Camera2CapturePipeline.isFlashRequired(i, totalCaptureResult)) {
                setTimeout3A(CHECK_3A_WITH_FLASH_TIMEOUT_IN_NS);
            }
            return this.mPipelineSubTask.preCapture(totalCaptureResult);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ ListenableFuture lambda$executePreCapture$3(Boolean bool) throws Exception {
            if (Boolean.TRUE.equals(bool)) {
                return Camera2CapturePipeline.waitForResult(this.mTimeout3A, this.mScheduler, this.mCameraControl, new t(0));
            }
            return Futures.immediateFuture(null);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Object lambda$submitConfigsInternal$4(CaptureConfig.Builder builder, final CallbackToFutureAdapter.Completer completer) throws Exception {
            builder.addCameraCaptureCallback(new CameraCaptureCallback() {
                public void onCaptureCancelled(int i) {
                    completer.setException(new ImageCaptureException(3, "Capture request is cancelled because camera is closed", (Throwable) null));
                }

                public void onCaptureCompleted(int i, @NonNull CameraCaptureResult cameraCaptureResult) {
                    completer.set(null);
                }

                public void onCaptureFailed(int i, @NonNull CameraCaptureFailure cameraCaptureFailure) {
                    completer.setException(new ImageCaptureException(2, "Capture request failed with reason " + cameraCaptureFailure.getReason(), (Throwable) null));
                }
            });
            return "submitStillCapture";
        }

        private void setTimeout3A(long j) {
            this.mTimeout3A = j;
        }

        public void addTask(@NonNull PipelineTask pipelineTask) {
            this.mTasks.add(pipelineTask);
        }

        @NonNull
        public ListenableFuture<List<Void>> executeCapture(@NonNull List<CaptureConfig> list, int i) {
            FutureChain<T> transformAsync = FutureChain.from(executePreCapture(i)).transformAsync(new r(this, list, i), this.mExecutor);
            transformAsync.addListener(new n(this, 1), this.mExecutor);
            return transformAsync;
        }

        public void executePostCapture() {
            this.mPipelineSubTask.postCapture();
        }

        @NonNull
        public ListenableFuture<TotalCaptureResult> executePreCapture(int i) {
            ListenableFuture<TotalCaptureResult> listenableFuture;
            ListenableFuture<TotalCaptureResult> immediateFuture = Futures.immediateFuture(null);
            if (this.mTasks.isEmpty()) {
                return immediateFuture;
            }
            if (this.mPipelineSubTask.isCaptureResultNeeded()) {
                listenableFuture = Camera2CapturePipeline.waitForResult(this.mCameraControl, (ResultListener.Checker) null);
            } else {
                listenableFuture = Futures.immediateFuture(null);
            }
            return FutureChain.from(listenableFuture).transformAsync(new s(this, i), this.mExecutor).transformAsync(new x(this, 2), this.mExecutor);
        }

        @NonNull
        public ListenableFuture<List<Void>> submitConfigsInternal(@NonNull List<CaptureConfig> list, int i) {
            CameraCaptureResult cameraCaptureResult;
            ImageProxy dequeueImageFromBuffer;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (CaptureConfig next : list) {
                CaptureConfig.Builder from = CaptureConfig.Builder.from(next);
                if (next.getTemplateType() != 5 || this.mCameraControl.getZslControl().isZslDisabledByFlashMode() || this.mCameraControl.getZslControl().isZslDisabledByUserCaseConfig() || (dequeueImageFromBuffer = this.mCameraControl.getZslControl().dequeueImageFromBuffer()) == null || !this.mCameraControl.getZslControl().enqueueImageToImageWriter(dequeueImageFromBuffer)) {
                    cameraCaptureResult = null;
                } else {
                    cameraCaptureResult = CameraCaptureResults.retrieveCameraCaptureResult(dequeueImageFromBuffer.getImageInfo());
                }
                if (cameraCaptureResult != null) {
                    from.setCameraCaptureResult(cameraCaptureResult);
                } else {
                    applyStillCaptureTemplate(from, next);
                }
                if (this.mOverrideAeModeForStillCapture.shouldSetAeModeAlwaysFlash(i)) {
                    applyAeModeQuirk(from);
                }
                arrayList.add(CallbackToFutureAdapter.getFuture(new f(1, this, from)));
                arrayList2.add(from.build());
            }
            this.mCameraControl.submitCaptureRequestsInternal(arrayList2);
            return Futures.allAsList(arrayList);
        }
    }

    public interface PipelineTask {
        boolean isCaptureResultNeeded();

        void postCapture();

        @NonNull
        ListenableFuture<Boolean> preCapture(@Nullable TotalCaptureResult totalCaptureResult);
    }

    public static class ResultListener implements Camera2CameraControlImpl.CaptureResultListener {
        private final Checker mChecker;
        private CallbackToFutureAdapter.Completer<TotalCaptureResult> mCompleter;
        private final ListenableFuture<TotalCaptureResult> mFuture = CallbackToFutureAdapter.getFuture(new p(this, 2));

        public interface Checker {
            boolean check(@NonNull TotalCaptureResult totalCaptureResult);
        }

        public ResultListener(@Nullable Checker checker) {
            this.mChecker = checker;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Object lambda$new$0(CallbackToFutureAdapter.Completer completer) throws Exception {
            this.mCompleter = completer;
            return "waitFor3AResult";
        }

        @NonNull
        public ListenableFuture<TotalCaptureResult> getFuture() {
            return this.mFuture;
        }

        public boolean onCaptureResult(@NonNull TotalCaptureResult totalCaptureResult) {
            Checker checker = this.mChecker;
            if (checker != null && !checker.check(totalCaptureResult)) {
                return false;
            }
            this.mCompleter.set(totalCaptureResult);
            return true;
        }
    }

    public static class ScreenFlashTask implements PipelineTask {
        private static final long CHECK_3A_WITH_SCREEN_FLASH_TIMEOUT_IN_NS = TimeUnit.SECONDS.toNanos(2);
        private final Camera2CameraControlImpl mCameraControl;
        private final Executor mExecutor;
        private final ScheduledExecutorService mScheduler;
        private final ImageCapture.ScreenFlash mScreenFlash;
        private final UseFlashModeTorchFor3aUpdate mUseFlashModeTorchFor3aUpdate;

        public ScreenFlashTask(@NonNull Camera2CameraControlImpl camera2CameraControlImpl, @NonNull Executor executor, @NonNull ScheduledExecutorService scheduledExecutorService, @NonNull UseFlashModeTorchFor3aUpdate useFlashModeTorchFor3aUpdate) {
            this.mCameraControl = camera2CameraControlImpl;
            this.mExecutor = executor;
            this.mScheduler = scheduledExecutorService;
            this.mUseFlashModeTorchFor3aUpdate = useFlashModeTorchFor3aUpdate;
            ImageCapture.ScreenFlash screenFlash = camera2CameraControlImpl.getScreenFlash();
            Objects.requireNonNull(screenFlash);
            this.mScreenFlash = screenFlash;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$postCapture$12() {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$preCapture$0(CallbackToFutureAdapter.Completer completer) {
            Logger.d(Camera2CapturePipeline.TAG, "ScreenFlashTask#preCapture: UI change applied");
            completer.set(null);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ ListenableFuture lambda$preCapture$10(Void voidR) throws Exception {
            return Camera2CapturePipeline.waitForResult(CHECK_3A_WITH_SCREEN_FLASH_TIMEOUT_IN_NS, this.mScheduler, this.mCameraControl, new t(1));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$preCapture$2(AtomicReference atomicReference, CallbackToFutureAdapter.Completer completer) {
            Logger.d(Camera2CapturePipeline.TAG, "ScreenFlashTask#preCapture: invoking applyScreenFlashUi");
            this.mScreenFlash.apply(TimeUnit.SECONDS.toMillis(3) + System.currentTimeMillis(), (ImageCapture.ScreenFlashListener) atomicReference.get());
            completer.set(null);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Object lambda$preCapture$3(AtomicReference atomicReference, CallbackToFutureAdapter.Completer completer) throws Exception {
            CameraXExecutors.mainThreadExecutor().execute(new j(this, atomicReference, completer));
            return "OnScreenFlashStart";
        }

        /* access modifiers changed from: private */
        public /* synthetic */ ListenableFuture lambda$preCapture$4(Void voidR) throws Exception {
            return this.mCameraControl.getFocusMeteringControl().enableExternalFlashAeMode(true);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Object lambda$preCapture$5(CallbackToFutureAdapter.Completer completer) throws Exception {
            if (!this.mUseFlashModeTorchFor3aUpdate.shouldUseFlashModeTorch()) {
                completer.set(null);
                return "EnableTorchInternal";
            }
            Logger.d(Camera2CapturePipeline.TAG, "ScreenFlashTask#preCapture: enable torch");
            this.mCameraControl.enableTorchInternal(true);
            completer.set(null);
            return "EnableTorchInternal";
        }

        /* access modifiers changed from: private */
        public /* synthetic */ ListenableFuture lambda$preCapture$6(Void voidR) throws Exception {
            return CallbackToFutureAdapter.getFuture(new p(this, 3));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ ListenableFuture lambda$preCapture$7(ListenableFuture listenableFuture, Object obj) throws Exception {
            return Futures.makeTimeoutFuture(TimeUnit.SECONDS.toMillis(3), this.mScheduler, null, true, listenableFuture);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ ListenableFuture lambda$preCapture$8(Void voidR) throws Exception {
            return this.mCameraControl.getFocusMeteringControl().triggerAePrecapture();
        }

        public boolean isCaptureResultNeeded() {
            return false;
        }

        /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Object, java.lang.Runnable] */
        public void postCapture() {
            Logger.d(Camera2CapturePipeline.TAG, "ScreenFlashTask#postCapture");
            if (this.mUseFlashModeTorchFor3aUpdate.shouldUseFlashModeTorch()) {
                this.mCameraControl.enableTorchInternal(false);
            }
            this.mCameraControl.getFocusMeteringControl().enableExternalFlashAeMode(false).addListener(new Object(), this.mExecutor);
            this.mCameraControl.getFocusMeteringControl().cancelAfAeTrigger(false, true);
            ScheduledExecutorService mainThreadExecutor = CameraXExecutors.mainThreadExecutor();
            ImageCapture.ScreenFlash screenFlash = this.mScreenFlash;
            Objects.requireNonNull(screenFlash);
            mainThreadExecutor.execute(new x0(screenFlash, 6));
        }

        @NonNull
        public ListenableFuture<Boolean> preCapture(@Nullable TotalCaptureResult totalCaptureResult) {
            Logger.d(Camera2CapturePipeline.TAG, "ScreenFlashTask#preCapture");
            AtomicReference atomicReference = new AtomicReference();
            return FutureChain.from(CallbackToFutureAdapter.getFuture(new f(2, this, atomicReference))).transformAsync(new u(this, 1), this.mExecutor).transformAsync(new u(this, 2), this.mExecutor).transformAsync(new k(1, this, CallbackToFutureAdapter.getFuture(new p(atomicReference, 4))), this.mExecutor).transformAsync(new u(this, 3), this.mExecutor).transformAsync(new u(this, 0), this.mExecutor).transform(new q(3), CameraXExecutors.directExecutor());
        }
    }

    public static class TorchTask implements PipelineTask {
        private static final long CHECK_3A_WITH_TORCH_TIMEOUT_IN_NS = TimeUnit.SECONDS.toNanos(2);
        private final Camera2CameraControlImpl mCameraControl;
        private final Executor mExecutor;
        private final int mFlashMode;
        private boolean mIsExecuted = false;
        private final ScheduledExecutorService mScheduler;
        private final boolean mTriggerAePrecapture;

        public TorchTask(@NonNull Camera2CameraControlImpl camera2CameraControlImpl, int i, @NonNull Executor executor, ScheduledExecutorService scheduledExecutorService, boolean z) {
            this.mCameraControl = camera2CameraControlImpl;
            this.mFlashMode = i;
            this.mExecutor = executor;
            this.mScheduler = scheduledExecutorService;
            this.mTriggerAePrecapture = z;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Object lambda$preCapture$0(CallbackToFutureAdapter.Completer completer) throws Exception {
            this.mCameraControl.getTorchControl().lambda$enableTorch$1(completer, true);
            return "TorchOn";
        }

        /* access modifiers changed from: private */
        public /* synthetic */ ListenableFuture lambda$preCapture$1(Void voidR) throws Exception {
            if (this.mTriggerAePrecapture) {
                return this.mCameraControl.getFocusMeteringControl().triggerAePrecapture();
            }
            return Futures.immediateFuture(null);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ ListenableFuture lambda$preCapture$3(Void voidR) throws Exception {
            return Camera2CapturePipeline.waitForResult(CHECK_3A_WITH_TORCH_TIMEOUT_IN_NS, this.mScheduler, this.mCameraControl, new t(2));
        }

        public boolean isCaptureResultNeeded() {
            if (this.mFlashMode == 0) {
                return true;
            }
            return false;
        }

        public void postCapture() {
            if (this.mIsExecuted) {
                this.mCameraControl.getTorchControl().lambda$enableTorch$1((CallbackToFutureAdapter.Completer<Void>) null, false);
                Logger.d(Camera2CapturePipeline.TAG, "Turning off torch");
                if (this.mTriggerAePrecapture) {
                    this.mCameraControl.getFocusMeteringControl().cancelAfAeTrigger(false, true);
                }
            }
        }

        @NonNull
        public ListenableFuture<Boolean> preCapture(@Nullable TotalCaptureResult totalCaptureResult) {
            boolean isFlashRequired = Camera2CapturePipeline.isFlashRequired(this.mFlashMode, totalCaptureResult);
            Logger.d(Camera2CapturePipeline.TAG, "TorchTask#preCapture: isFlashRequired = " + isFlashRequired);
            if (Camera2CapturePipeline.isFlashRequired(this.mFlashMode, totalCaptureResult)) {
                if (this.mCameraControl.isTorchOn()) {
                    Logger.d(Camera2CapturePipeline.TAG, "Torch already on, not turn on");
                } else {
                    Logger.d(Camera2CapturePipeline.TAG, "Turn on torch");
                    this.mIsExecuted = true;
                    return FutureChain.from(CallbackToFutureAdapter.getFuture(new p(this, 5))).transformAsync(new x(this, 0), this.mExecutor).transformAsync(new x(this, 1), this.mExecutor).transform(new q(4), CameraXExecutors.directExecutor());
                }
            }
            return Futures.immediateFuture(Boolean.FALSE);
        }
    }

    public Camera2CapturePipeline(@NonNull Camera2CameraControlImpl camera2CameraControlImpl, @NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat, @NonNull Quirks quirks, @NonNull Executor executor, @NonNull ScheduledExecutorService scheduledExecutorService) {
        boolean z = true;
        this.mCameraControl = camera2CameraControlImpl;
        Integer num = (Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        this.mIsLegacyDevice = (num == null || num.intValue() != 2) ? false : z;
        this.mExecutor = executor;
        this.mScheduler = scheduledExecutorService;
        this.mCameraQuirk = quirks;
        this.mUseTorchAsFlash = new UseTorchAsFlash(quirks);
        this.mHasFlashUnit = FlashAvailabilityChecker.isFlashAvailable(new k0(cameraCharacteristicsCompat, 6));
    }

    public static boolean is3AConverged(@Nullable TotalCaptureResult totalCaptureResult, boolean z) {
        if (totalCaptureResult == null) {
            return false;
        }
        return ConvergenceUtils.is3AConverged(new Camera2CameraCaptureResult(totalCaptureResult), z);
    }

    public static boolean isFlashRequired(int i, @Nullable TotalCaptureResult totalCaptureResult) {
        Integer num;
        Logger.d(TAG, "isFlashRequired: flashMode = " + i);
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    return false;
                }
                if (i != 3) {
                    throw new AssertionError(i);
                }
            }
            return true;
        }
        if (totalCaptureResult != null) {
            num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        } else {
            num = null;
        }
        Logger.d(TAG, "isFlashRequired: aeState = " + num);
        if (num == null || num.intValue() != 4) {
            return false;
        }
        return true;
    }

    private boolean isTorchAsFlash(int i) {
        if (this.mUseTorchAsFlash.shouldUseTorchAsFlash() || this.mTemplate == 3 || i == 1) {
            return true;
        }
        return false;
    }

    @NonNull
    public static ListenableFuture<TotalCaptureResult> waitForResult(long j, @NonNull ScheduledExecutorService scheduledExecutorService, @NonNull Camera2CameraControlImpl camera2CameraControlImpl, @Nullable ResultListener.Checker checker) {
        return Futures.makeTimeoutFuture(TimeUnit.NANOSECONDS.toMillis(j), scheduledExecutorService, null, true, waitForResult(camera2CameraControlImpl, checker));
    }

    @VisibleForTesting
    public Pipeline createPipeline(int i, int i2, int i3) {
        boolean z;
        OverrideAeModeForStillCapture overrideAeModeForStillCapture = new OverrideAeModeForStillCapture(this.mCameraQuirk);
        Pipeline pipeline = new Pipeline(this.mTemplate, this.mExecutor, this.mScheduler, this.mCameraControl, this.mIsLegacyDevice, overrideAeModeForStillCapture);
        if (i == 0) {
            pipeline.addTask(new AfTask(this.mCameraControl));
        }
        if (i2 == 3) {
            pipeline.addTask(new ScreenFlashTask(this.mCameraControl, this.mExecutor, this.mScheduler, new UseFlashModeTorchFor3aUpdate(this.mCameraQuirk)));
        } else if (this.mHasFlashUnit) {
            if (isTorchAsFlash(i3)) {
                if (this.mUseTorchAsFlash.shouldUseTorchAsFlash() || this.mCameraControl.isInVideoUsage()) {
                    z = false;
                } else {
                    z = true;
                }
                pipeline.addTask(new TorchTask(this.mCameraControl, i2, this.mExecutor, this.mScheduler, z));
            } else {
                pipeline.addTask(new AePreCaptureTask(this.mCameraControl, i2, overrideAeModeForStillCapture));
            }
        }
        StringBuilder r = e.r(i, "createPipeline: captureMode = ", i2, ", flashMode = ", ", flashType = ");
        r.append(i3);
        r.append(", pipeline tasks = ");
        r.append(pipeline.mTasks);
        Logger.d(TAG, r.toString());
        return pipeline;
    }

    @NonNull
    public CameraCapturePipeline getCameraCapturePipeline(int i, int i2, int i3) {
        return new CameraCapturePipelineImpl(createPipeline(i, i2, i3), this.mExecutor, i2);
    }

    public void setTemplate(int i) {
        this.mTemplate = i;
    }

    @NonNull
    public ListenableFuture<List<Void>> submitStillCaptures(@NonNull List<CaptureConfig> list, int i, int i2, int i3) {
        return Futures.nonCancellationPropagating(createPipeline(i, i2, i3).executeCapture(list, i2));
    }

    @NonNull
    public static ListenableFuture<TotalCaptureResult> waitForResult(@NonNull Camera2CameraControlImpl camera2CameraControlImpl, @Nullable ResultListener.Checker checker) {
        ResultListener resultListener = new ResultListener(checker);
        camera2CameraControlImpl.addCaptureResultListener(resultListener);
        ListenableFuture<TotalCaptureResult> future = resultListener.getFuture();
        future.addListener(new c(4, camera2CameraControlImpl, resultListener), camera2CameraControlImpl.mExecutor);
        return future;
    }
}
