package androidx.camera.extensions.internal.sessionprocessor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.media.Image;
import android.os.Build;
import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.OutputSurface;
import androidx.camera.core.impl.OutputSurfaceConfiguration;
import androidx.camera.core.impl.RequestProcessor;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.extensions.impl.advanced.Camera2OutputConfigImpl;
import androidx.camera.extensions.impl.advanced.Camera2SessionConfigImpl;
import androidx.camera.extensions.impl.advanced.ImageProcessorImpl;
import androidx.camera.extensions.impl.advanced.ImageReferenceImpl;
import androidx.camera.extensions.impl.advanced.OutputSurfaceConfigurationImpl;
import androidx.camera.extensions.impl.advanced.OutputSurfaceImpl;
import androidx.camera.extensions.impl.advanced.RequestProcessorImpl;
import androidx.camera.extensions.impl.advanced.SessionProcessorImpl;
import androidx.camera.extensions.internal.ClientVersion;
import androidx.camera.extensions.internal.ExtensionVersion;
import androidx.camera.extensions.internal.RequestOptionConfig;
import androidx.camera.extensions.internal.VendorExtender;
import androidx.camera.extensions.internal.Version;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class AdvancedSessionProcessor extends SessionProcessorBase {
    private static final String TAG = "AdvancedSessionProcessor";
    @NonNull
    private final Context mContext;
    @Nullable
    private final MutableLiveData<Integer> mCurrentExtensionTypeLiveData;
    @Nullable
    private final ExtensionMetadataMonitor mExtensionMetadataMonitor;
    @Nullable
    private final MutableLiveData<Integer> mExtensionStrengthLiveData;
    @NonNull
    private final SessionProcessorImpl mImpl;
    private boolean mIsPostviewConfigured;
    private final int mMode;
    @GuardedBy("mLock")
    private SessionProcessorImplCaptureCallbackAdapter mRepeatingCaptureCallbackAdapter;
    @NonNull
    private final VendorExtender mVendorExtender;
    private final boolean mWillReceiveOnCaptureCompleted;
    @GuardedBy("mLock")
    private HashMap<CaptureRequest.Key<?>, Object> mWorkingCaptureConfigMap;

    public static class CallbackAdapter implements RequestProcessor.Callback {
        private final RequestProcessorImpl.Callback mCallback;

        public CallbackAdapter(@NonNull RequestProcessorImpl.Callback callback) {
            this.mCallback = callback;
        }

        private RequestProcessorImpl.Request getImplRequest(RequestProcessor.Request request) {
            Preconditions.checkArgument(request instanceof RequestAdapter);
            return ((RequestAdapter) request).getImplRequest();
        }

        public void onCaptureBufferLost(@NonNull RequestProcessor.Request request, long j, int i) {
            this.mCallback.onCaptureBufferLost(getImplRequest(request), j, i);
        }

        public void onCaptureCompleted(@NonNull RequestProcessor.Request request, @Nullable CameraCaptureResult cameraCaptureResult) {
            CaptureResult captureResult = cameraCaptureResult.getCaptureResult();
            Preconditions.checkArgument(captureResult instanceof TotalCaptureResult, "CaptureResult in cameraCaptureResult is not a TotalCaptureResult");
            this.mCallback.onCaptureCompleted(getImplRequest(request), (TotalCaptureResult) captureResult);
        }

        public void onCaptureFailed(@NonNull RequestProcessor.Request request, @Nullable CameraCaptureFailure cameraCaptureFailure) {
            Object captureFailure = cameraCaptureFailure.getCaptureFailure();
            Preconditions.checkArgument(captureFailure instanceof CaptureFailure, "CameraCaptureFailure does not contain CaptureFailure.");
            this.mCallback.onCaptureFailed(getImplRequest(request), (CaptureFailure) captureFailure);
        }

        public void onCaptureProgressed(@NonNull RequestProcessor.Request request, @NonNull CameraCaptureResult cameraCaptureResult) {
            boolean z;
            CaptureResult captureResult = cameraCaptureResult.getCaptureResult();
            if (captureResult != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "Cannot get CaptureResult from the cameraCaptureResult ");
            this.mCallback.onCaptureProgressed(getImplRequest(request), captureResult);
        }

        public void onCaptureSequenceAborted(int i) {
            this.mCallback.onCaptureSequenceAborted(i);
        }

        public void onCaptureSequenceCompleted(int i, long j) {
            this.mCallback.onCaptureSequenceCompleted(i, j);
        }

        public void onCaptureStarted(@NonNull RequestProcessor.Request request, long j, long j2) {
            this.mCallback.onCaptureStarted(getImplRequest(request), j, j2);
        }
    }

    public static class ExtensionMetadataMonitor {
        @Nullable
        private final MutableLiveData<Integer> mCurrentExtensionTypeLiveData;
        @Nullable
        private final MutableLiveData<Integer> mExtensionStrengthLiveData;

        public ExtensionMetadataMonitor(@Nullable MutableLiveData<Integer> mutableLiveData, @Nullable MutableLiveData<Integer> mutableLiveData2) {
            this.mCurrentExtensionTypeLiveData = mutableLiveData;
            this.mExtensionStrengthLiveData = mutableLiveData2;
        }

        private int convertExtensionMode(int i) {
            if (i == 0) {
                return 5;
            }
            if (i == 1) {
                return 4;
            }
            if (i == 2) {
                return 1;
            }
            if (i != 3) {
                return i != 4 ? 0 : 3;
            }
            return 2;
        }

        public void checkExtensionMetadata(Map<CaptureResult.Key, Object> map) {
            Object obj;
            Object obj2;
            if (Build.VERSION.SDK_INT >= 34) {
                if (!(this.mCurrentExtensionTypeLiveData == null || (obj2 = map.get(CaptureResult.EXTENSION_CURRENT_TYPE)) == null)) {
                    Integer num = (Integer) obj2;
                    if (!Objects.equals(this.mCurrentExtensionTypeLiveData.getValue(), Integer.valueOf(convertExtensionMode(num.intValue())))) {
                        this.mCurrentExtensionTypeLiveData.postValue(Integer.valueOf(convertExtensionMode(num.intValue())));
                    }
                }
                if (this.mExtensionStrengthLiveData != null && (obj = map.get(CaptureResult.EXTENSION_STRENGTH)) != null && !Objects.equals(this.mExtensionStrengthLiveData.getValue(), obj)) {
                    this.mExtensionStrengthLiveData.postValue((Integer) obj);
                }
            }
        }
    }

    public static class ImageProcessorAdapter implements ImageProcessor {
        private final ImageProcessorImpl mImpl;

        public ImageProcessorAdapter(ImageProcessorImpl imageProcessorImpl) {
            this.mImpl = imageProcessorImpl;
        }

        public void onNextImageAvailable(int i, long j, @NonNull ImageReference imageReference, @Nullable String str) {
            this.mImpl.onNextImageAvailable(i, j, new ImageReferenceImplAdapter(imageReference), str);
        }
    }

    public static class ImageReferenceImplAdapter implements ImageReferenceImpl {
        private final ImageReference mImageReference;

        public ImageReferenceImplAdapter(ImageReference imageReference) {
            this.mImageReference = imageReference;
        }

        public boolean decrement() {
            return this.mImageReference.decrement();
        }

        @Nullable
        public Image get() {
            return this.mImageReference.get();
        }

        public boolean increment() {
            return this.mImageReference.increment();
        }
    }

    public static class OutputSurfaceConfigurationImplAdapter implements OutputSurfaceConfigurationImpl {
        private final OutputSurfaceImpl mAnalysisOutputSurface;
        private final OutputSurfaceImpl mCaptureOutputSurface;
        private final OutputSurfaceImpl mPostviewOutputSurface;
        private final OutputSurfaceImpl mPreviewOutputSurface;

        public OutputSurfaceConfigurationImplAdapter(@NonNull OutputSurfaceConfiguration outputSurfaceConfiguration) {
            OutputSurfaceImplAdapter outputSurfaceImplAdapter;
            this.mPreviewOutputSurface = new OutputSurfaceImplAdapter(outputSurfaceConfiguration.getPreviewOutputSurface());
            this.mCaptureOutputSurface = new OutputSurfaceImplAdapter(outputSurfaceConfiguration.getImageCaptureOutputSurface());
            OutputSurfaceImplAdapter outputSurfaceImplAdapter2 = null;
            if (outputSurfaceConfiguration.getImageAnalysisOutputSurface() != null) {
                outputSurfaceImplAdapter = new OutputSurfaceImplAdapter(outputSurfaceConfiguration.getImageAnalysisOutputSurface());
            } else {
                outputSurfaceImplAdapter = null;
            }
            this.mAnalysisOutputSurface = outputSurfaceImplAdapter;
            this.mPostviewOutputSurface = outputSurfaceConfiguration.getPostviewOutputSurface() != null ? new OutputSurfaceImplAdapter(outputSurfaceConfiguration.getPostviewOutputSurface()) : outputSurfaceImplAdapter2;
        }

        @Nullable
        public OutputSurfaceImpl getImageAnalysisOutputSurface() {
            return this.mAnalysisOutputSurface;
        }

        @NonNull
        public OutputSurfaceImpl getImageCaptureOutputSurface() {
            return this.mCaptureOutputSurface;
        }

        @Nullable
        public OutputSurfaceImpl getPostviewOutputSurface() {
            return this.mPostviewOutputSurface;
        }

        @NonNull
        public OutputSurfaceImpl getPreviewOutputSurface() {
            return this.mPreviewOutputSurface;
        }
    }

    public static class OutputSurfaceImplAdapter implements OutputSurfaceImpl {
        private final OutputSurface mOutputSurface;

        public OutputSurfaceImplAdapter(OutputSurface outputSurface) {
            this.mOutputSurface = outputSurface;
        }

        public int getImageFormat() {
            return this.mOutputSurface.getImageFormat();
        }

        @NonNull
        public Size getSize() {
            return this.mOutputSurface.getSize();
        }

        @NonNull
        public Surface getSurface() {
            return this.mOutputSurface.getSurface();
        }
    }

    public static class RequestAdapter implements RequestProcessor.Request {
        private final RequestProcessorImpl.Request mImplRequest;
        private final Config mParameters;
        private final List<Integer> mTargetOutputConfigIds;
        private final int mTemplateId;

        public RequestAdapter(@NonNull RequestProcessorImpl.Request request) {
            this.mImplRequest = request;
            ArrayList arrayList = new ArrayList();
            for (Integer add : request.getTargetOutputConfigIds()) {
                arrayList.add(add);
            }
            this.mTargetOutputConfigIds = arrayList;
            RequestOptionConfig.Builder builder = new RequestOptionConfig.Builder();
            for (CaptureRequest.Key key : request.getParameters().keySet()) {
                builder.setCaptureRequestOption(key, request.getParameters().get(key));
            }
            this.mParameters = builder.build();
            this.mTemplateId = request.getTemplateId().intValue();
        }

        @Nullable
        public RequestProcessorImpl.Request getImplRequest() {
            return this.mImplRequest;
        }

        @NonNull
        public Config getParameters() {
            return this.mParameters;
        }

        @NonNull
        public List<Integer> getTargetOutputConfigIds() {
            return this.mTargetOutputConfigIds;
        }

        public int getTemplateId() {
            return this.mTemplateId;
        }
    }

    public class RequestProcessorImplAdapter implements RequestProcessorImpl {
        private final RequestProcessor mRequestProcessor;

        public RequestProcessorImplAdapter(@NonNull RequestProcessor requestProcessor) {
            this.mRequestProcessor = requestProcessor;
        }

        public void abortCaptures() {
            this.mRequestProcessor.abortCaptures();
        }

        public void setImageProcessor(int i, @NonNull ImageProcessorImpl imageProcessorImpl) {
            AdvancedSessionProcessor.this.setImageProcessor(i, new ImageProcessorAdapter(imageProcessorImpl));
        }

        public int setRepeating(@NonNull RequestProcessorImpl.Request request, @NonNull RequestProcessorImpl.Callback callback) {
            return this.mRequestProcessor.setRepeating(new RequestAdapter(request), new CallbackAdapter(callback));
        }

        public void stopRepeating() {
            this.mRequestProcessor.stopRepeating();
        }

        public int submit(@NonNull RequestProcessorImpl.Request request, @NonNull RequestProcessorImpl.Callback callback) {
            return this.mRequestProcessor.submit((RequestProcessor.Request) new RequestAdapter(request), (RequestProcessor.Callback) new CallbackAdapter(callback));
        }

        public int submit(@NonNull List<RequestProcessorImpl.Request> list, @NonNull RequestProcessorImpl.Callback callback) {
            ArrayList arrayList = new ArrayList();
            for (RequestProcessorImpl.Request requestAdapter : list) {
                arrayList.add(new RequestAdapter(requestAdapter));
            }
            return this.mRequestProcessor.submit((List<RequestProcessor.Request>) arrayList, (RequestProcessor.Callback) new CallbackAdapter(callback));
        }
    }

    public static class SessionProcessorImplCaptureCallbackAdapter implements SessionProcessorImpl.CaptureCallback {
        private final SessionProcessor.CaptureCallback mCaptureCallback;
        @Nullable
        private final ExtensionMetadataMonitor mExtensionMetadataMonitor;
        private long mOnCaptureStartedTimestamp;
        @NonNull
        private final TagBundle mTagBundle;
        private boolean mWillReceiveOnCaptureCompleted;

        public SessionProcessorImplCaptureCallbackAdapter(@NonNull SessionProcessor.CaptureCallback captureCallback, @NonNull TagBundle tagBundle, boolean z) {
            this(captureCallback, tagBundle, (ExtensionMetadataMonitor) null, z);
        }

        public void onCaptureCompleted(long j, int i, Map<CaptureResult.Key, Object> map) {
            ExtensionMetadataMonitor extensionMetadataMonitor = this.mExtensionMetadataMonitor;
            if (extensionMetadataMonitor != null) {
                extensionMetadataMonitor.checkExtensionMetadata(map);
            }
            if (this.mWillReceiveOnCaptureCompleted) {
                this.mCaptureCallback.onCaptureCompleted(j, i, new KeyValueMapCameraCaptureResult(j, this.mTagBundle, map));
                this.mCaptureCallback.onCaptureSequenceCompleted(i);
            }
        }

        public void onCaptureFailed(int i) {
            this.mCaptureCallback.onCaptureFailed(i);
        }

        public void onCaptureProcessProgressed(int i) {
            this.mCaptureCallback.onCaptureProcessProgressed(i);
        }

        public void onCaptureProcessStarted(int i) {
            this.mCaptureCallback.onCaptureProcessStarted(i);
        }

        public void onCaptureSequenceAborted(int i) {
            this.mCaptureCallback.onCaptureSequenceAborted(i);
        }

        public void onCaptureSequenceCompleted(int i) {
            if (!this.mWillReceiveOnCaptureCompleted) {
                SessionProcessor.CaptureCallback captureCallback = this.mCaptureCallback;
                long j = this.mOnCaptureStartedTimestamp;
                captureCallback.onCaptureCompleted(j, i, new KeyValueMapCameraCaptureResult(j, this.mTagBundle, Collections.emptyMap()));
                this.mCaptureCallback.onCaptureSequenceCompleted(i);
            }
        }

        public void onCaptureStarted(int i, long j) {
            this.mOnCaptureStartedTimestamp = j;
            this.mCaptureCallback.onCaptureStarted(i, j);
        }

        public SessionProcessorImplCaptureCallbackAdapter(@NonNull SessionProcessor.CaptureCallback captureCallback, @NonNull TagBundle tagBundle, @Nullable ExtensionMetadataMonitor extensionMetadataMonitor, boolean z) {
            this.mOnCaptureStartedTimestamp = -1;
            this.mCaptureCallback = captureCallback;
            this.mTagBundle = tagBundle;
            this.mExtensionMetadataMonitor = extensionMetadataMonitor;
            this.mWillReceiveOnCaptureCompleted = z;
        }
    }

    public AdvancedSessionProcessor(@NonNull SessionProcessorImpl sessionProcessorImpl, @NonNull List<CaptureRequest.Key> list, @NonNull VendorExtender vendorExtender, @NonNull Context context) {
        this(sessionProcessorImpl, list, vendorExtender, context, 0);
    }

    @NonNull
    private static HashMap<CaptureRequest.Key<?>, Object> convertConfigToMap(@NonNull Config config) {
        HashMap<CaptureRequest.Key<?>, Object> hashMap = new HashMap<>();
        RequestOptionConfig build = RequestOptionConfig.Builder.from(config).build();
        build.getClass();
        for (Config.Option option : ld.e(build)) {
            hashMap.put((CaptureRequest.Key) option.getToken(), ld.f(build, option));
        }
        return hashMap;
    }

    private Camera2SessionConfig convertToCamera2SessionConfig(@NonNull Camera2SessionConfigImpl camera2SessionConfigImpl) {
        Camera2SessionConfigBuilder camera2SessionConfigBuilder = new Camera2SessionConfigBuilder();
        for (Camera2OutputConfigImpl fromImpl : camera2SessionConfigImpl.getOutputConfigs()) {
            camera2SessionConfigBuilder.addOutputConfig(Camera2OutputConfigConverter.fromImpl(fromImpl));
        }
        for (CaptureRequest.Key key : camera2SessionConfigImpl.getSessionParameters().keySet()) {
            camera2SessionConfigBuilder.addSessionParameter(key, camera2SessionConfigImpl.getSessionParameters().get(key));
        }
        camera2SessionConfigBuilder.setSessionTemplateId(camera2SessionConfigImpl.getSessionTemplateId());
        Version version = Version.VERSION_1_4;
        if (ClientVersion.isMinimumCompatibleVersion(version) && ExtensionVersion.isMinimumCompatibleVersion(version)) {
            try {
                int sessionType = camera2SessionConfigImpl.getSessionType();
                if (sessionType == -1) {
                    sessionType = 0;
                }
                camera2SessionConfigBuilder.setSessionType(sessionType);
            } catch (NoSuchMethodError unused) {
                camera2SessionConfigBuilder.setSessionType(0);
            }
        }
        return camera2SessionConfigBuilder.build();
    }

    public void abortCapture(int i) {
        this.mImpl.abortCapture(i);
    }

    public void deInitSessionInternal() {
        synchronized (this.mLock) {
            this.mWorkingCaptureConfigMap = new HashMap<>();
            this.mRepeatingCaptureCallbackAdapter = null;
        }
        this.mImpl.deInitSession();
    }

    @NonNull
    public LiveData<Integer> getCurrentExtensionMode() {
        return this.mCurrentExtensionTypeLiveData;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    @NonNull
    public LiveData<Integer> getExtensionStrength() {
        return this.mExtensionStrengthLiveData;
    }

    @Nullable
    public Pair<Long, Long> getRealtimeCaptureLatency() {
        Version version = Version.VERSION_1_4;
        if (!ClientVersion.isMinimumCompatibleVersion(version) || !ExtensionVersion.isMinimumCompatibleVersion(version)) {
            return null;
        }
        return this.mImpl.getRealtimeCaptureLatency();
    }

    @NonNull
    public /* bridge */ /* synthetic */ Set getSupportedCameraOperations() {
        return super.getSupportedCameraOperations();
    }

    @NonNull
    public Map<Integer, List<Size>> getSupportedPostviewSize(@NonNull Size size) {
        return this.mVendorExtender.getSupportedPostviewResolutions(size);
    }

    @NonNull
    public Camera2SessionConfig initSessionInternal(@NonNull String str, @NonNull Map<String, CameraCharacteristics> map, @NonNull OutputSurfaceConfiguration outputSurfaceConfiguration) {
        Camera2SessionConfigImpl camera2SessionConfigImpl;
        boolean z;
        Version version = Version.VERSION_1_4;
        OutputSurfaceImplAdapter outputSurfaceImplAdapter = null;
        if (!ClientVersion.isMinimumCompatibleVersion(version) || !ExtensionVersion.isMinimumCompatibleVersion(version)) {
            camera2SessionConfigImpl = null;
        } else {
            camera2SessionConfigImpl = this.mImpl.initSession(str, map, this.mContext, new OutputSurfaceConfigurationImplAdapter(outputSurfaceConfiguration));
        }
        if (camera2SessionConfigImpl == null) {
            SessionProcessorImpl sessionProcessorImpl = this.mImpl;
            Context context = this.mContext;
            OutputSurfaceImplAdapter outputSurfaceImplAdapter2 = new OutputSurfaceImplAdapter(outputSurfaceConfiguration.getPreviewOutputSurface());
            OutputSurfaceImplAdapter outputSurfaceImplAdapter3 = new OutputSurfaceImplAdapter(outputSurfaceConfiguration.getImageCaptureOutputSurface());
            if (outputSurfaceConfiguration.getImageAnalysisOutputSurface() != null) {
                outputSurfaceImplAdapter = new OutputSurfaceImplAdapter(outputSurfaceConfiguration.getImageAnalysisOutputSurface());
            }
            camera2SessionConfigImpl = sessionProcessorImpl.initSession(str, map, context, outputSurfaceImplAdapter2, outputSurfaceImplAdapter3, outputSurfaceImplAdapter);
        }
        if (outputSurfaceConfiguration.getPostviewOutputSurface() != null) {
            z = true;
        } else {
            z = false;
        }
        this.mIsPostviewConfigured = z;
        MutableLiveData<Integer> mutableLiveData = this.mCurrentExtensionTypeLiveData;
        if (mutableLiveData != null) {
            mutableLiveData.postValue(Integer.valueOf(this.mMode));
        }
        MutableLiveData<Integer> mutableLiveData2 = this.mExtensionStrengthLiveData;
        if (mutableLiveData2 != null) {
            mutableLiveData2.postValue(100);
        }
        return convertToCamera2SessionConfig(camera2SessionConfigImpl);
    }

    public boolean isCurrentExtensionModeAvailable() {
        return this.mVendorExtender.isCurrentExtensionModeAvailable();
    }

    public boolean isExtensionStrengthAvailable() {
        return this.mVendorExtender.isExtensionStrengthAvailable();
    }

    public void onCaptureSessionEnd() {
        this.mImpl.onCaptureSessionEnd();
    }

    public void onCaptureSessionStart(@NonNull RequestProcessor requestProcessor) {
        this.mImpl.onCaptureSessionStart(new RequestProcessorImplAdapter(requestProcessor));
    }

    public void setExtensionStrength(@IntRange(from = 0, to = 100) int i) {
        SessionProcessorImplCaptureCallbackAdapter sessionProcessorImplCaptureCallbackAdapter;
        HashMap hashMap;
        if (isExtensionStrengthAvailable() && Build.VERSION.SDK_INT >= 34) {
            synchronized (this.mLock) {
                this.mExtensionStrength = i;
                this.mWorkingCaptureConfigMap.put(CaptureRequest.EXTENSION_STRENGTH, Integer.valueOf(this.mExtensionStrength));
                sessionProcessorImplCaptureCallbackAdapter = this.mRepeatingCaptureCallbackAdapter;
                hashMap = (HashMap) this.mWorkingCaptureConfigMap.clone();
            }
            this.mImpl.setParameters(hashMap);
            if (sessionProcessorImplCaptureCallbackAdapter != null) {
                this.mImpl.startRepeating(sessionProcessorImplCaptureCallbackAdapter);
            }
        }
    }

    public void setParameters(@NonNull Config config) {
        HashMap<CaptureRequest.Key<?>, Object> convertConfigToMap;
        synchronized (this.mLock) {
            try {
                convertConfigToMap = convertConfigToMap(config);
                if (this.mExtensionStrength != -1 && Build.VERSION.SDK_INT >= 34) {
                    convertConfigToMap.put(CaptureRequest.EXTENSION_STRENGTH, Integer.valueOf(this.mExtensionStrength));
                }
                this.mWorkingCaptureConfigMap = convertConfigToMap;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        this.mImpl.setParameters(convertConfigToMap);
    }

    public int startCapture(boolean z, @NonNull TagBundle tagBundle, @NonNull SessionProcessor.CaptureCallback captureCallback) {
        Logger.d(TAG, "startCapture postviewEnabled = " + z + " mWillReceiveOnCaptureCompleted = " + this.mWillReceiveOnCaptureCompleted);
        SessionProcessorImplCaptureCallbackAdapter sessionProcessorImplCaptureCallbackAdapter = new SessionProcessorImplCaptureCallbackAdapter(captureCallback, tagBundle, this.mWillReceiveOnCaptureCompleted);
        Version version = Version.VERSION_1_4;
        if (!ClientVersion.isMinimumCompatibleVersion(version) || !ExtensionVersion.isMinimumCompatibleVersion(version) || !this.mIsPostviewConfigured || !z || !this.mVendorExtender.isPostviewAvailable()) {
            return this.mImpl.startCapture(sessionProcessorImplCaptureCallbackAdapter);
        }
        return this.mImpl.startCaptureWithPostview(sessionProcessorImplCaptureCallbackAdapter);
    }

    public int startRepeating(@NonNull TagBundle tagBundle, @NonNull SessionProcessor.CaptureCallback captureCallback) {
        SessionProcessorImplCaptureCallbackAdapter sessionProcessorImplCaptureCallbackAdapter;
        synchronized (this.mLock) {
            sessionProcessorImplCaptureCallbackAdapter = new SessionProcessorImplCaptureCallbackAdapter(captureCallback, tagBundle, this.mExtensionMetadataMonitor, this.mWillReceiveOnCaptureCompleted);
            this.mRepeatingCaptureCallbackAdapter = sessionProcessorImplCaptureCallbackAdapter;
        }
        return this.mImpl.startRepeating(sessionProcessorImplCaptureCallbackAdapter);
    }

    public int startTrigger(@NonNull Config config, @NonNull TagBundle tagBundle, @NonNull SessionProcessor.CaptureCallback captureCallback) {
        HashMap<CaptureRequest.Key<?>, Object> convertConfigToMap = convertConfigToMap(config);
        Version version = Version.VERSION_1_3;
        if (!ClientVersion.isMinimumCompatibleVersion(version) || !ExtensionVersion.isMinimumCompatibleVersion(version)) {
            return -1;
        }
        return this.mImpl.startTrigger(convertConfigToMap, new SessionProcessorImplCaptureCallbackAdapter(captureCallback, tagBundle, this.mWillReceiveOnCaptureCompleted));
    }

    public void stopRepeating() {
        this.mImpl.stopRepeating();
        synchronized (this.mLock) {
            this.mRepeatingCaptureCallbackAdapter = null;
        }
    }

    public AdvancedSessionProcessor(@NonNull SessionProcessorImpl sessionProcessorImpl, @NonNull List<CaptureRequest.Key> list, @NonNull VendorExtender vendorExtender, @NonNull Context context, int i) {
        super(list);
        this.mIsPostviewConfigured = false;
        this.mWorkingCaptureConfigMap = new HashMap<>();
        this.mRepeatingCaptureCallbackAdapter = null;
        this.mImpl = sessionProcessorImpl;
        this.mVendorExtender = vendorExtender;
        this.mContext = context;
        this.mWillReceiveOnCaptureCompleted = vendorExtender.willReceiveOnCaptureCompleted();
        this.mMode = i;
        MutableLiveData<Integer> mutableLiveData = isCurrentExtensionModeAvailable() ? new MutableLiveData<>(Integer.valueOf(i)) : null;
        this.mCurrentExtensionTypeLiveData = mutableLiveData;
        MutableLiveData<Integer> mutableLiveData2 = isExtensionStrengthAvailable() ? new MutableLiveData<>(100) : null;
        this.mExtensionStrengthLiveData = mutableLiveData2;
        if (mutableLiveData == null && mutableLiveData2 == null) {
            this.mExtensionMetadataMonitor = null;
        } else {
            this.mExtensionMetadataMonitor = new ExtensionMetadataMonitor(mutableLiveData, mutableLiveData2);
        }
    }
}
