package androidx.camera.extensions;

import android.content.Context;
import android.os.Build;
import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraProvider;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigProvider;
import androidx.camera.core.impl.ExtendedCameraConfigProviderStore;
import androidx.camera.core.impl.Identifier;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.extensions.ExtensionsConfig;
import androidx.camera.extensions.internal.AdvancedVendorExtender;
import androidx.camera.extensions.internal.BasicVendorExtender;
import androidx.camera.extensions.internal.ClientVersion;
import androidx.camera.extensions.internal.ExtensionVersion;
import androidx.camera.extensions.internal.ExtensionsUseCaseConfigFactory;
import androidx.camera.extensions.internal.VendorExtender;
import androidx.camera.extensions.internal.Version;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class ExtensionsInfo {
    private static final String EXTENDED_CAMERA_CONFIG_PROVIDER_ID_PREFIX = ":camera:camera-extensions-";
    private final CameraProvider mCameraProvider;
    @NonNull
    private VendorExtenderFactory mVendorExtenderFactory = new Object();

    /* JADX WARNING: type inference failed for: r1v1, types: [androidx.camera.extensions.VendorExtenderFactory, java.lang.Object] */
    public ExtensionsInfo(@NonNull CameraProvider cameraProvider) {
        this.mCameraProvider = cameraProvider;
    }

    private static String getExtendedCameraConfigProviderId(int i) {
        if (i == 0) {
            return ":camera:camera-extensions-EXTENSION_MODE_NONE";
        }
        if (i == 1) {
            return ":camera:camera-extensions-EXTENSION_MODE_BOKEH";
        }
        if (i == 2) {
            return ":camera:camera-extensions-EXTENSION_MODE_HDR";
        }
        if (i == 3) {
            return ":camera:camera-extensions-EXTENSION_MODE_NIGHT";
        }
        if (i == 4) {
            return ":camera:camera-extensions-EXTENSION_MODE_FACE_RETOUCH";
        }
        if (i == 5) {
            return ":camera:camera-extensions-EXTENSION_MODE_AUTO";
        }
        throw new IllegalArgumentException("Invalid extension mode!");
    }

    private CameraFilter getFilter(int i) {
        return new ExtensionCameraFilter(getExtendedCameraConfigProviderId(i), this.mVendorExtenderFactory.createVendorExtender(i));
    }

    @NonNull
    public static VendorExtender getVendorExtender(int i) {
        if (isAdvancedExtenderSupported()) {
            return new AdvancedVendorExtender(i);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return new BasicVendorExtender(i);
        }
        return new VendorExtender() {
            public final /* synthetic */ SessionProcessor createSessionProcessor(Context context) {
                return wg.a(this, context);
            }

            public final /* synthetic */ Range getEstimatedCaptureLatencyRange(Size size) {
                return wg.b(this, size);
            }

            public final /* synthetic */ List getSupportedCaptureOutputResolutions() {
                return wg.c(this);
            }

            public final /* synthetic */ List getSupportedCaptureResultKeys() {
                return wg.d(this);
            }

            public final /* synthetic */ Map getSupportedPostviewResolutions(Size size) {
                return wg.e(this, size);
            }

            public final /* synthetic */ List getSupportedPreviewOutputResolutions() {
                return wg.f(this);
            }

            public final /* synthetic */ Size[] getSupportedYuvAnalysisResolutions() {
                return wg.g(this);
            }

            public final /* synthetic */ void init(CameraInfo cameraInfo) {
                wg.h(this, cameraInfo);
            }

            public final /* synthetic */ boolean isCaptureProcessProgressAvailable() {
                return wg.i(this);
            }

            public final /* synthetic */ boolean isCurrentExtensionModeAvailable() {
                return wg.j(this);
            }

            public final /* synthetic */ boolean isExtensionAvailable(String str, Map map) {
                return wg.k(this, str, map);
            }

            public final /* synthetic */ boolean isExtensionStrengthAvailable() {
                return wg.l(this);
            }

            public final /* synthetic */ boolean isPostviewAvailable() {
                return wg.m(this);
            }

            public final /* synthetic */ boolean willReceiveOnCaptureCompleted() {
                return wg.n(this);
            }
        };
    }

    private void injectExtensionCameraConfig(int i) {
        Identifier create = Identifier.create(getExtendedCameraConfigProviderId(i));
        if (ExtendedCameraConfigProviderStore.getConfigProvider(create) == CameraConfigProvider.EMPTY) {
            ExtendedCameraConfigProviderStore.addConfig(create, new b(this, i, create));
        }
    }

    private static boolean isAdvancedExtenderSupported() {
        Version version = Version.VERSION_1_1;
        if (ClientVersion.isMaximumCompatibleVersion(version) || ExtensionVersion.isMaximumCompatibleVersion(version)) {
            return false;
        }
        return ExtensionVersion.isAdvancedExtenderSupported();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ CameraConfig lambda$injectExtensionCameraConfig$1(int i, Identifier identifier, CameraInfo cameraInfo, Context context) {
        VendorExtender createVendorExtender = this.mVendorExtenderFactory.createVendorExtender(i);
        createVendorExtender.init(cameraInfo);
        ExtensionsConfig.Builder useCaseCombinationRequiredRule = new ExtensionsConfig.Builder().setExtensionMode(i).setUseCaseConfigFactory((UseCaseConfigFactory) new ExtensionsUseCaseConfigFactory(createVendorExtender)).setCompatibilityId(identifier).setZslDisabled(true).setPostviewSupported(createVendorExtender.isPostviewAvailable()).setCaptureProcessProgressSupported(createVendorExtender.isCaptureProcessProgressAvailable()).setUseCaseCombinationRequiredRule(1);
        SessionProcessor createSessionProcessor = createVendorExtender.createSessionProcessor(context);
        if (createSessionProcessor != null) {
            useCaseCombinationRequiredRule.setSessionProcessor(createSessionProcessor);
        }
        return useCaseCombinationRequiredRule.build();
    }

    @Nullable
    public Range<Long> getEstimatedCaptureLatencyRange(@NonNull CameraSelector cameraSelector, int i, @Nullable Size size) {
        List<CameraInfo> filter = CameraSelector.Builder.fromSelector(cameraSelector).addCameraFilter(getFilter(i)).build().filter(this.mCameraProvider.getAvailableCameraInfos());
        if (filter.isEmpty()) {
            return null;
        }
        CameraInfo cameraInfo = filter.get(0);
        if (ExtensionVersion.getRuntimeVersion().compareTo(Version.VERSION_1_2) < 0) {
            return null;
        }
        try {
            VendorExtender createVendorExtender = this.mVendorExtenderFactory.createVendorExtender(i);
            createVendorExtender.init(cameraInfo);
            return createVendorExtender.getEstimatedCaptureLatencyRange(size);
        } catch (NoSuchMethodError unused) {
            return null;
        }
    }

    @NonNull
    public CameraSelector getExtensionCameraSelectorAndInjectCameraConfig(@NonNull CameraSelector cameraSelector, int i) {
        if (isExtensionAvailable(cameraSelector, i)) {
            Iterator<CameraFilter> it = cameraSelector.getCameraFilterSet().iterator();
            while (it.hasNext()) {
                if (it.next() instanceof ExtensionCameraFilter) {
                    throw new IllegalArgumentException("An extension is already applied to the base CameraSelector.");
                }
            }
            injectExtensionCameraConfig(i);
            CameraSelector.Builder fromSelector = CameraSelector.Builder.fromSelector(cameraSelector);
            fromSelector.addCameraFilter(getFilter(i));
            return fromSelector.build();
        }
        throw new IllegalArgumentException("No camera can be found to support the specified extensions mode! isExtensionAvailable should be checked first before calling getExtensionEnabledCameraSelector.");
    }

    public boolean isExtensionAvailable(@NonNull CameraSelector cameraSelector, int i) {
        CameraSelector.Builder fromSelector = CameraSelector.Builder.fromSelector(cameraSelector);
        fromSelector.addCameraFilter(getFilter(i));
        return !fromSelector.build().filter(this.mCameraProvider.getAvailableCameraInfos()).isEmpty();
    }

    public boolean isImageAnalysisSupported(@NonNull CameraSelector cameraSelector, int i) {
        List<CameraInfo> filter = CameraSelector.Builder.fromSelector(cameraSelector).addCameraFilter(getFilter(i)).build().filter(this.mCameraProvider.getAvailableCameraInfos());
        if (filter.isEmpty()) {
            return false;
        }
        VendorExtender createVendorExtender = this.mVendorExtenderFactory.createVendorExtender(i);
        createVendorExtender.init(filter.get(0));
        Size[] supportedYuvAnalysisResolutions = createVendorExtender.getSupportedYuvAnalysisResolutions();
        if (supportedYuvAnalysisResolutions == null || supportedYuvAnalysisResolutions.length <= 0) {
            return false;
        }
        return true;
    }

    @VisibleForTesting
    public void setVendorExtenderFactory(@NonNull VendorExtenderFactory vendorExtenderFactory) {
        this.mVendorExtenderFactory = vendorExtenderFactory;
    }
}
