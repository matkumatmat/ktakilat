package androidx.camera.core.impl;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.InputConfiguration;
import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.AutoValue_SessionConfig_OutputConfig;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.internal.compat.workaround.SurfaceSorter;
import com.google.auto.value.AutoValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class SessionConfig {
    public static final int DEFAULT_SESSION_TYPE = 0;
    private static final List<Integer> SUPPORTED_TEMPLATE_PRIORITY = Arrays.asList(new Integer[]{1, 5, 3});
    private final List<CameraDevice.StateCallback> mDeviceStateCallbacks;
    private final ErrorListener mErrorListener;
    @Nullable
    private InputConfiguration mInputConfiguration;
    private final List<OutputConfig> mOutputConfigs;
    /* access modifiers changed from: private */
    public final OutputConfig mPostviewOutputConfig;
    private final CaptureConfig mRepeatingCaptureConfig;
    private final List<CameraCaptureSession.StateCallback> mSessionStateCallbacks;
    private final int mSessionType;
    private final List<CameraCaptureCallback> mSingleCameraCaptureCallbacks;

    public static class BaseBuilder {
        final CaptureConfig.Builder mCaptureConfigBuilder = new CaptureConfig.Builder();
        final List<CameraDevice.StateCallback> mDeviceStateCallbacks = new ArrayList();
        @Nullable
        ErrorListener mErrorListener;
        @Nullable
        InputConfiguration mInputConfiguration;
        final Set<OutputConfig> mOutputConfigs = new LinkedHashSet();
        @Nullable
        OutputConfig mPostviewOutputConfig;
        final List<CameraCaptureSession.StateCallback> mSessionStateCallbacks = new ArrayList();
        int mSessionType = 0;
        final List<CameraCaptureCallback> mSingleCameraCaptureCallbacks = new ArrayList();
    }

    public static class Builder extends BaseBuilder {
        @NonNull
        public static Builder createFrom(@NonNull UseCaseConfig<?> useCaseConfig, @NonNull Size size) {
            OptionUnpacker sessionOptionUnpacker = useCaseConfig.getSessionOptionUnpacker((OptionUnpacker) null);
            if (sessionOptionUnpacker != null) {
                Builder builder = new Builder();
                sessionOptionUnpacker.unpack(size, useCaseConfig, builder);
                return builder;
            }
            throw new IllegalStateException("Implementation is missing option unpacker for " + useCaseConfig.getTargetName(useCaseConfig.toString()));
        }

        @NonNull
        public Builder addAllCameraCaptureCallbacks(@NonNull Collection<CameraCaptureCallback> collection) {
            for (CameraCaptureCallback next : collection) {
                this.mCaptureConfigBuilder.addCameraCaptureCallback(next);
                if (!this.mSingleCameraCaptureCallbacks.contains(next)) {
                    this.mSingleCameraCaptureCallbacks.add(next);
                }
            }
            return this;
        }

        @NonNull
        public Builder addAllDeviceStateCallbacks(@NonNull Collection<CameraDevice.StateCallback> collection) {
            for (CameraDevice.StateCallback addDeviceStateCallback : collection) {
                addDeviceStateCallback(addDeviceStateCallback);
            }
            return this;
        }

        @NonNull
        public Builder addAllRepeatingCameraCaptureCallbacks(@NonNull Collection<CameraCaptureCallback> collection) {
            this.mCaptureConfigBuilder.addAllCameraCaptureCallbacks(collection);
            return this;
        }

        @NonNull
        public Builder addAllSessionStateCallbacks(@NonNull List<CameraCaptureSession.StateCallback> list) {
            for (CameraCaptureSession.StateCallback addSessionStateCallback : list) {
                addSessionStateCallback(addSessionStateCallback);
            }
            return this;
        }

        @NonNull
        public Builder addCameraCaptureCallback(@NonNull CameraCaptureCallback cameraCaptureCallback) {
            this.mCaptureConfigBuilder.addCameraCaptureCallback(cameraCaptureCallback);
            if (!this.mSingleCameraCaptureCallbacks.contains(cameraCaptureCallback)) {
                this.mSingleCameraCaptureCallbacks.add(cameraCaptureCallback);
            }
            return this;
        }

        @NonNull
        public Builder addDeviceStateCallback(@NonNull CameraDevice.StateCallback stateCallback) {
            if (this.mDeviceStateCallbacks.contains(stateCallback)) {
                return this;
            }
            this.mDeviceStateCallbacks.add(stateCallback);
            return this;
        }

        @NonNull
        public Builder addImplementationOptions(@NonNull Config config) {
            this.mCaptureConfigBuilder.addImplementationOptions(config);
            return this;
        }

        @NonNull
        public Builder addNonRepeatingSurface(@NonNull DeferrableSurface deferrableSurface) {
            return addNonRepeatingSurface(deferrableSurface, DynamicRange.SDR);
        }

        @NonNull
        public Builder addOutputConfig(@NonNull OutputConfig outputConfig) {
            this.mOutputConfigs.add(outputConfig);
            this.mCaptureConfigBuilder.addSurface(outputConfig.getSurface());
            for (DeferrableSurface addSurface : outputConfig.getSharedSurfaces()) {
                this.mCaptureConfigBuilder.addSurface(addSurface);
            }
            return this;
        }

        @NonNull
        public Builder addRepeatingCameraCaptureCallback(@NonNull CameraCaptureCallback cameraCaptureCallback) {
            this.mCaptureConfigBuilder.addCameraCaptureCallback(cameraCaptureCallback);
            return this;
        }

        @NonNull
        public Builder addSessionStateCallback(@NonNull CameraCaptureSession.StateCallback stateCallback) {
            if (this.mSessionStateCallbacks.contains(stateCallback)) {
                return this;
            }
            this.mSessionStateCallbacks.add(stateCallback);
            return this;
        }

        @NonNull
        public Builder addSurface(@NonNull DeferrableSurface deferrableSurface) {
            return addSurface(deferrableSurface, DynamicRange.SDR, (String) null, -1);
        }

        @NonNull
        public Builder addTag(@NonNull String str, @NonNull Object obj) {
            this.mCaptureConfigBuilder.addTag(str, obj);
            return this;
        }

        @NonNull
        public SessionConfig build() {
            return new SessionConfig(new ArrayList(this.mOutputConfigs), new ArrayList(this.mDeviceStateCallbacks), new ArrayList(this.mSessionStateCallbacks), new ArrayList(this.mSingleCameraCaptureCallbacks), this.mCaptureConfigBuilder.build(), this.mErrorListener, this.mInputConfiguration, this.mSessionType, this.mPostviewOutputConfig);
        }

        @NonNull
        public Builder clearSurfaces() {
            this.mOutputConfigs.clear();
            this.mCaptureConfigBuilder.clearSurfaces();
            return this;
        }

        @NonNull
        public List<CameraCaptureCallback> getSingleCameraCaptureCallbacks() {
            return Collections.unmodifiableList(this.mSingleCameraCaptureCallbacks);
        }

        public boolean removeCameraCaptureCallback(@NonNull CameraCaptureCallback cameraCaptureCallback) {
            boolean removeCameraCaptureCallback = this.mCaptureConfigBuilder.removeCameraCaptureCallback(cameraCaptureCallback);
            boolean remove = this.mSingleCameraCaptureCallbacks.remove(cameraCaptureCallback);
            if (removeCameraCaptureCallback || remove) {
                return true;
            }
            return false;
        }

        @NonNull
        public Builder removeSurface(@NonNull DeferrableSurface deferrableSurface) {
            OutputConfig outputConfig;
            Iterator<OutputConfig> it = this.mOutputConfigs.iterator();
            while (true) {
                if (!it.hasNext()) {
                    outputConfig = null;
                    break;
                }
                outputConfig = it.next();
                if (outputConfig.getSurface().equals(deferrableSurface)) {
                    break;
                }
            }
            if (outputConfig != null) {
                this.mOutputConfigs.remove(outputConfig);
            }
            this.mCaptureConfigBuilder.removeSurface(deferrableSurface);
            return this;
        }

        @NonNull
        public Builder setErrorListener(@NonNull ErrorListener errorListener) {
            this.mErrorListener = errorListener;
            return this;
        }

        @NonNull
        public Builder setExpectedFrameRateRange(@NonNull Range<Integer> range) {
            this.mCaptureConfigBuilder.setExpectedFrameRateRange(range);
            return this;
        }

        @NonNull
        public Builder setImplementationOptions(@NonNull Config config) {
            this.mCaptureConfigBuilder.setImplementationOptions(config);
            return this;
        }

        @NonNull
        public Builder setInputConfiguration(@Nullable InputConfiguration inputConfiguration) {
            this.mInputConfiguration = inputConfiguration;
            return this;
        }

        @NonNull
        public Builder setPostviewSurface(@NonNull DeferrableSurface deferrableSurface) {
            this.mPostviewOutputConfig = OutputConfig.builder(deferrableSurface).build();
            return this;
        }

        @NonNull
        public Builder setPreviewStabilization(int i) {
            if (i != 0) {
                this.mCaptureConfigBuilder.setPreviewStabilization(i);
            }
            return this;
        }

        @NonNull
        public Builder setSessionType(int i) {
            this.mSessionType = i;
            return this;
        }

        @NonNull
        public Builder setTemplateType(int i) {
            this.mCaptureConfigBuilder.setTemplateType(i);
            return this;
        }

        @NonNull
        public Builder setVideoStabilization(int i) {
            if (i != 0) {
                this.mCaptureConfigBuilder.setVideoStabilization(i);
            }
            return this;
        }

        @NonNull
        public Builder addNonRepeatingSurface(@NonNull DeferrableSurface deferrableSurface, @NonNull DynamicRange dynamicRange) {
            this.mOutputConfigs.add(OutputConfig.builder(deferrableSurface).setDynamicRange(dynamicRange).build());
            return this;
        }

        @NonNull
        public Builder addSurface(@NonNull DeferrableSurface deferrableSurface, @NonNull DynamicRange dynamicRange, @Nullable String str, int i) {
            this.mOutputConfigs.add(OutputConfig.builder(deferrableSurface).setPhysicalCameraId(str).setDynamicRange(dynamicRange).setMirrorMode(i).build());
            this.mCaptureConfigBuilder.addSurface(deferrableSurface);
            return this;
        }
    }

    public static final class CloseableErrorListener implements ErrorListener {
        private final ErrorListener mErrorListener;
        private final AtomicBoolean mIsClosed = new AtomicBoolean(false);

        public CloseableErrorListener(@NonNull ErrorListener errorListener) {
            this.mErrorListener = errorListener;
        }

        public void close() {
            this.mIsClosed.set(true);
        }

        public void onError(@NonNull SessionConfig sessionConfig, @NonNull SessionError sessionError) {
            if (!this.mIsClosed.get()) {
                this.mErrorListener.onError(sessionConfig, sessionError);
            }
        }
    }

    public interface ErrorListener {
        void onError(@NonNull SessionConfig sessionConfig, @NonNull SessionError sessionError);
    }

    public interface OptionUnpacker {
        void unpack(@NonNull Size size, @NonNull UseCaseConfig<?> useCaseConfig, @NonNull Builder builder);
    }

    @AutoValue
    public static abstract class OutputConfig {
        public static final int SURFACE_GROUP_ID_NONE = -1;

        @AutoValue.Builder
        public static abstract class Builder {
            @NonNull
            public abstract OutputConfig build();

            @NonNull
            public abstract Builder setDynamicRange(@NonNull DynamicRange dynamicRange);

            @NonNull
            public abstract Builder setMirrorMode(int i);

            @NonNull
            public abstract Builder setPhysicalCameraId(@Nullable String str);

            @NonNull
            public abstract Builder setSharedSurfaces(@NonNull List<DeferrableSurface> list);

            @NonNull
            public abstract Builder setSurface(@NonNull DeferrableSurface deferrableSurface);

            @NonNull
            public abstract Builder setSurfaceGroupId(int i);
        }

        @NonNull
        public static Builder builder(@NonNull DeferrableSurface deferrableSurface) {
            return new AutoValue_SessionConfig_OutputConfig.Builder().setSurface(deferrableSurface).setSharedSurfaces(Collections.emptyList()).setPhysicalCameraId((String) null).setMirrorMode(-1).setSurfaceGroupId(-1).setDynamicRange(DynamicRange.SDR);
        }

        @NonNull
        public abstract DynamicRange getDynamicRange();

        public abstract int getMirrorMode();

        @Nullable
        public abstract String getPhysicalCameraId();

        @NonNull
        public abstract List<DeferrableSurface> getSharedSurfaces();

        @NonNull
        public abstract DeferrableSurface getSurface();

        public abstract int getSurfaceGroupId();
    }

    public enum SessionError {
        SESSION_ERROR_SURFACE_NEEDS_RESET,
        SESSION_ERROR_UNKNOWN
    }

    public static final class ValidatingBuilder extends BaseBuilder {
        private static final String TAG = "ValidatingBuilder";
        private List<ErrorListener> mErrorListeners = new ArrayList();
        private final SurfaceSorter mSurfaceSorter = new SurfaceSorter();
        private boolean mTemplateSet = false;
        private boolean mValid = true;

        private List<DeferrableSurface> getSurfaces() {
            ArrayList arrayList = new ArrayList();
            for (OutputConfig next : this.mOutputConfigs) {
                arrayList.add(next.getSurface());
                for (DeferrableSurface add : next.getSharedSurfaces()) {
                    arrayList.add(add);
                }
            }
            return arrayList;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$build$0(SessionConfig sessionConfig, SessionError sessionError) {
            for (ErrorListener onError : this.mErrorListeners) {
                onError.onError(sessionConfig, sessionError);
            }
        }

        private void setOrVerifyExpectFrameRateRange(@NonNull Range<Integer> range) {
            Range<Integer> range2 = StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
            if (!range.equals(range2)) {
                if (this.mCaptureConfigBuilder.getExpectedFrameRateRange().equals(range2)) {
                    this.mCaptureConfigBuilder.setExpectedFrameRateRange(range);
                } else if (!this.mCaptureConfigBuilder.getExpectedFrameRateRange().equals(range)) {
                    this.mValid = false;
                    Logger.d(TAG, "Different ExpectedFrameRateRange values");
                }
            }
        }

        private void setPreviewStabilizationMode(int i) {
            if (i != 0) {
                this.mCaptureConfigBuilder.setPreviewStabilization(i);
            }
        }

        private void setVideoStabilizationMode(int i) {
            if (i != 0) {
                this.mCaptureConfigBuilder.setVideoStabilization(i);
            }
        }

        public void add(@NonNull SessionConfig sessionConfig) {
            CaptureConfig repeatingCaptureConfig = sessionConfig.getRepeatingCaptureConfig();
            if (repeatingCaptureConfig.getTemplateType() != -1) {
                this.mTemplateSet = true;
                this.mCaptureConfigBuilder.setTemplateType(SessionConfig.getHigherPriorityTemplateType(repeatingCaptureConfig.getTemplateType(), this.mCaptureConfigBuilder.getTemplateType()));
            }
            setOrVerifyExpectFrameRateRange(repeatingCaptureConfig.getExpectedFrameRateRange());
            setPreviewStabilizationMode(repeatingCaptureConfig.getPreviewStabilizationMode());
            setVideoStabilizationMode(repeatingCaptureConfig.getVideoStabilizationMode());
            this.mCaptureConfigBuilder.addAllTags(sessionConfig.getRepeatingCaptureConfig().getTagBundle());
            this.mDeviceStateCallbacks.addAll(sessionConfig.getDeviceStateCallbacks());
            this.mSessionStateCallbacks.addAll(sessionConfig.getSessionStateCallbacks());
            this.mCaptureConfigBuilder.addAllCameraCaptureCallbacks(sessionConfig.getRepeatingCameraCaptureCallbacks());
            this.mSingleCameraCaptureCallbacks.addAll(sessionConfig.getSingleCameraCaptureCallbacks());
            if (sessionConfig.getErrorListener() != null) {
                this.mErrorListeners.add(sessionConfig.getErrorListener());
            }
            if (sessionConfig.getInputConfiguration() != null) {
                this.mInputConfiguration = sessionConfig.getInputConfiguration();
            }
            this.mOutputConfigs.addAll(sessionConfig.getOutputConfigs());
            this.mCaptureConfigBuilder.getSurfaces().addAll(repeatingCaptureConfig.getSurfaces());
            if (!getSurfaces().containsAll(this.mCaptureConfigBuilder.getSurfaces())) {
                Logger.d(TAG, "Invalid configuration due to capture request surfaces are not a subset of surfaces");
                this.mValid = false;
            }
            if (sessionConfig.getSessionType() != this.mSessionType && sessionConfig.getSessionType() != 0 && this.mSessionType != 0) {
                Logger.d(TAG, "Invalid configuration due to that two non-default session types are set");
                this.mValid = false;
            } else if (sessionConfig.getSessionType() != 0) {
                this.mSessionType = sessionConfig.getSessionType();
            }
            if (sessionConfig.mPostviewOutputConfig != null) {
                if (this.mPostviewOutputConfig == sessionConfig.mPostviewOutputConfig || this.mPostviewOutputConfig == null) {
                    this.mPostviewOutputConfig = sessionConfig.mPostviewOutputConfig;
                } else {
                    Logger.d(TAG, "Invalid configuration due to that two different postview output configs are set");
                    this.mValid = false;
                }
            }
            this.mCaptureConfigBuilder.addImplementationOptions(repeatingCaptureConfig.getImplementationOptions());
        }

        public <T> void addImplementationOption(@NonNull Config.Option<T> option, @NonNull T t) {
            this.mCaptureConfigBuilder.addImplementationOption(option, t);
        }

        @NonNull
        public SessionConfig build() {
            ha haVar;
            if (this.mValid) {
                ArrayList arrayList = new ArrayList(this.mOutputConfigs);
                this.mSurfaceSorter.sort(arrayList);
                if (!this.mErrorListeners.isEmpty()) {
                    haVar = new ha(this, 3);
                } else {
                    haVar = null;
                }
                return new SessionConfig(arrayList, new ArrayList(this.mDeviceStateCallbacks), new ArrayList(this.mSessionStateCallbacks), new ArrayList(this.mSingleCameraCaptureCallbacks), this.mCaptureConfigBuilder.build(), haVar, this.mInputConfiguration, this.mSessionType, this.mPostviewOutputConfig);
            }
            throw new IllegalArgumentException("Unsupported session configuration combination");
        }

        public void clearSurfaces() {
            this.mOutputConfigs.clear();
            this.mCaptureConfigBuilder.clearSurfaces();
        }

        public boolean isValid() {
            if (!this.mTemplateSet || !this.mValid) {
                return false;
            }
            return true;
        }
    }

    public SessionConfig(List<OutputConfig> list, List<CameraDevice.StateCallback> list2, List<CameraCaptureSession.StateCallback> list3, List<CameraCaptureCallback> list4, CaptureConfig captureConfig, @Nullable ErrorListener errorListener, @Nullable InputConfiguration inputConfiguration, int i, @Nullable OutputConfig outputConfig) {
        this.mOutputConfigs = list;
        this.mDeviceStateCallbacks = Collections.unmodifiableList(list2);
        this.mSessionStateCallbacks = Collections.unmodifiableList(list3);
        this.mSingleCameraCaptureCallbacks = Collections.unmodifiableList(list4);
        this.mErrorListener = errorListener;
        this.mRepeatingCaptureConfig = captureConfig;
        this.mInputConfiguration = inputConfiguration;
        this.mSessionType = i;
        this.mPostviewOutputConfig = outputConfig;
    }

    @NonNull
    public static SessionConfig defaultEmptySessionConfig() {
        return new SessionConfig(new ArrayList(), new ArrayList(0), new ArrayList(0), new ArrayList(0), new CaptureConfig.Builder().build(), (ErrorListener) null, (InputConfiguration) null, 0, (OutputConfig) null);
    }

    public static int getHigherPriorityTemplateType(int i, int i2) {
        List<Integer> list = SUPPORTED_TEMPLATE_PRIORITY;
        if (list.indexOf(Integer.valueOf(i)) >= list.indexOf(Integer.valueOf(i2))) {
            return i;
        }
        return i2;
    }

    @NonNull
    public List<CameraDevice.StateCallback> getDeviceStateCallbacks() {
        return this.mDeviceStateCallbacks;
    }

    @Nullable
    public ErrorListener getErrorListener() {
        return this.mErrorListener;
    }

    @NonNull
    public Range<Integer> getExpectedFrameRateRange() {
        return this.mRepeatingCaptureConfig.getExpectedFrameRateRange();
    }

    @NonNull
    public Config getImplementationOptions() {
        return this.mRepeatingCaptureConfig.getImplementationOptions();
    }

    @Nullable
    public InputConfiguration getInputConfiguration() {
        return this.mInputConfiguration;
    }

    @NonNull
    public List<OutputConfig> getOutputConfigs() {
        return this.mOutputConfigs;
    }

    @Nullable
    public OutputConfig getPostviewOutputConfig() {
        return this.mPostviewOutputConfig;
    }

    @NonNull
    public List<CameraCaptureCallback> getRepeatingCameraCaptureCallbacks() {
        return this.mRepeatingCaptureConfig.getCameraCaptureCallbacks();
    }

    @NonNull
    public CaptureConfig getRepeatingCaptureConfig() {
        return this.mRepeatingCaptureConfig;
    }

    @NonNull
    public List<CameraCaptureSession.StateCallback> getSessionStateCallbacks() {
        return this.mSessionStateCallbacks;
    }

    public int getSessionType() {
        return this.mSessionType;
    }

    @NonNull
    public List<CameraCaptureCallback> getSingleCameraCaptureCallbacks() {
        return this.mSingleCameraCaptureCallbacks;
    }

    @NonNull
    public List<DeferrableSurface> getSurfaces() {
        ArrayList arrayList = new ArrayList();
        for (OutputConfig next : this.mOutputConfigs) {
            arrayList.add(next.getSurface());
            for (DeferrableSurface add : next.getSharedSurfaces()) {
                arrayList.add(add);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public int getTemplateType() {
        return this.mRepeatingCaptureConfig.getTemplateType();
    }
}
