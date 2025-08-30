package androidx.camera.extensions;

import android.content.Context;
import android.util.Range;
import android.util.Size;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraProvider;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.ExtendedCameraConfigProviderStore;
import androidx.camera.core.impl.utils.ContextUtil;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.extensions.impl.InitializerImpl;
import androidx.camera.extensions.internal.ClientVersion;
import androidx.camera.extensions.internal.ExtensionVersion;
import androidx.camera.extensions.internal.Version;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

public final class ExtensionsManager {
    private static final Object EXTENSIONS_LOCK = new Object();
    private static final String TAG = "ExtensionsManager";
    @GuardedBy("EXTENSIONS_LOCK")
    private static ListenableFuture<Void> sDeinitializeFuture;
    @GuardedBy("EXTENSIONS_LOCK")
    private static ExtensionsManager sExtensionsManager;
    @GuardedBy("EXTENSIONS_LOCK")
    private static ListenableFuture<ExtensionsManager> sInitializeFuture;
    private final ExtensionsAvailability mExtensionsAvailability;
    private final ExtensionsInfo mExtensionsInfo;

    public enum ExtensionsAvailability {
        LIBRARY_AVAILABLE,
        LIBRARY_UNAVAILABLE_ERROR_LOADING,
        LIBRARY_UNAVAILABLE_MISSING_IMPLEMENTATION,
        NONE
    }

    private ExtensionsManager(@NonNull ExtensionsAvailability extensionsAvailability, @NonNull CameraProvider cameraProvider) {
        this.mExtensionsAvailability = extensionsAvailability;
        this.mExtensionsInfo = new ExtensionsInfo(cameraProvider);
    }

    @NonNull
    public static ListenableFuture<ExtensionsManager> getInstanceAsync(@NonNull Context context, @NonNull CameraProvider cameraProvider) {
        return getInstanceAsync(context, cameraProvider, ClientVersion.getCurrentVersion());
    }

    public static ExtensionsManager getOrCreateExtensionsManager(@NonNull ExtensionsAvailability extensionsAvailability, @NonNull CameraProvider cameraProvider) {
        synchronized (EXTENSIONS_LOCK) {
            try {
                ExtensionsManager extensionsManager = sExtensionsManager;
                if (extensionsManager != null) {
                    return extensionsManager;
                }
                ExtensionsManager extensionsManager2 = new ExtensionsManager(extensionsAvailability, cameraProvider);
                sExtensionsManager = extensionsManager2;
                return extensionsManager2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object lambda$getInstanceAsync$0(ClientVersion clientVersion, Context context, final CameraProvider cameraProvider, final CallbackToFutureAdapter.Completer completer) throws Exception {
        try {
            InitializerImpl.init(clientVersion.toVersionString(), ContextUtil.getApplicationContext(context), new InitializerImpl.OnExtensionsInitializedCallback() {
                public void onFailure(int i) {
                    Logger.e(ExtensionsManager.TAG, "Failed to initialize extensions");
                    CallbackToFutureAdapter.Completer.this.set(ExtensionsManager.getOrCreateExtensionsManager(ExtensionsAvailability.LIBRARY_UNAVAILABLE_ERROR_LOADING, cameraProvider));
                }

                public void onSuccess() {
                    Logger.d(ExtensionsManager.TAG, "Successfully initialized extensions");
                    CallbackToFutureAdapter.Completer.this.set(ExtensionsManager.getOrCreateExtensionsManager(ExtensionsAvailability.LIBRARY_AVAILABLE, cameraProvider));
                }
            }, CameraXExecutors.directExecutor());
            return "Initialize extensions";
        } catch (AbstractMethodError | NoClassDefFoundError | NoSuchMethodError e) {
            Logger.e(TAG, "Failed to initialize extensions. Some classes or methods are missed in the vendor library. " + e);
            completer.set(getOrCreateExtensionsManager(ExtensionsAvailability.LIBRARY_UNAVAILABLE_MISSING_IMPLEMENTATION, cameraProvider));
            return "Initialize extensions";
        } catch (RuntimeException e2) {
            Logger.e(TAG, "Failed to initialize extensions. Something wents wrong when initializing the vendor library. " + e2);
            completer.set(getOrCreateExtensionsManager(ExtensionsAvailability.LIBRARY_UNAVAILABLE_ERROR_LOADING, cameraProvider));
            return "Initialize extensions";
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$shutdown$1(final CallbackToFutureAdapter.Completer completer) throws Exception {
        try {
            InitializerImpl.deinit(new InitializerImpl.OnExtensionsDeinitializedCallback() {
                public void onFailure(int i) {
                    completer.setException(new Exception("Failed to deinitialize extensions."));
                }

                public void onSuccess() {
                    completer.set(null);
                }
            }, CameraXExecutors.directExecutor());
            return null;
        } catch (NoClassDefFoundError | NoSuchMethodError e) {
            completer.setException(e);
            return null;
        }
    }

    @Nullable
    public CameraExtensionsControl getCameraExtensionsControl(@NonNull CameraControl cameraControl) {
        return CameraExtensionsControls.from(cameraControl);
    }

    @NonNull
    public CameraExtensionsInfo getCameraExtensionsInfo(@NonNull CameraInfo cameraInfo) {
        return CameraExtensionsInfos.from(cameraInfo);
    }

    @Nullable
    public Range<Long> getEstimatedCaptureLatencyRange(@NonNull CameraSelector cameraSelector, int i) {
        if (i == 0 || this.mExtensionsAvailability != ExtensionsAvailability.LIBRARY_AVAILABLE) {
            return null;
        }
        return this.mExtensionsInfo.getEstimatedCaptureLatencyRange(cameraSelector, i, (Size) null);
    }

    @NonNull
    public CameraSelector getExtensionEnabledCameraSelector(@NonNull CameraSelector cameraSelector, int i) {
        if (i == 0) {
            return cameraSelector;
        }
        if (this.mExtensionsAvailability == ExtensionsAvailability.LIBRARY_AVAILABLE) {
            return this.mExtensionsInfo.getExtensionCameraSelectorAndInjectCameraConfig(cameraSelector, i);
        }
        throw new IllegalArgumentException("This device doesn't support extensions function! isExtensionAvailable should be checked first before calling getExtensionEnabledCameraSelector.");
    }

    @VisibleForTesting
    @NonNull
    public ExtensionsAvailability getExtensionsAvailability() {
        return this.mExtensionsAvailability;
    }

    public boolean isExtensionAvailable(@NonNull CameraSelector cameraSelector, int i) {
        if (i == 0) {
            return true;
        }
        if (this.mExtensionsAvailability != ExtensionsAvailability.LIBRARY_AVAILABLE) {
            return false;
        }
        return this.mExtensionsInfo.isExtensionAvailable(cameraSelector, i);
    }

    public boolean isImageAnalysisSupported(@NonNull CameraSelector cameraSelector, int i) {
        if (i == 0) {
            return true;
        }
        if (this.mExtensionsAvailability != ExtensionsAvailability.LIBRARY_AVAILABLE) {
            return false;
        }
        return this.mExtensionsInfo.isImageAnalysisSupported(cameraSelector, i);
    }

    @VisibleForTesting
    public void setVendorExtenderFactory(VendorExtenderFactory vendorExtenderFactory) {
        this.mExtensionsInfo.setVendorExtenderFactory(vendorExtenderFactory);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    @NonNull
    public ListenableFuture<Void> shutdown() {
        synchronized (EXTENSIONS_LOCK) {
            try {
                if (ExtensionVersion.getRuntimeVersion() == null) {
                    sInitializeFuture = null;
                    sExtensionsManager = null;
                    ExtensionVersion.injectInstance((ExtensionVersion) null);
                    ListenableFuture<Void> immediateFuture = Futures.immediateFuture(null);
                    return immediateFuture;
                }
                ExtensionVersion.injectInstance((ExtensionVersion) null);
                ListenableFuture<ExtensionsManager> listenableFuture = sInitializeFuture;
                if (listenableFuture == null) {
                    ListenableFuture<Void> immediateFuture2 = Futures.immediateFuture(null);
                    return immediateFuture2;
                }
                ListenableFuture<Void> listenableFuture2 = sDeinitializeFuture;
                if (listenableFuture2 != null) {
                    return listenableFuture2;
                }
                listenableFuture.get();
                sInitializeFuture = null;
                ExtensionsAvailability extensionsAvailability = sExtensionsManager.mExtensionsAvailability;
                sExtensionsManager = null;
                if (extensionsAvailability == ExtensionsAvailability.LIBRARY_AVAILABLE) {
                    ExtendedCameraConfigProviderStore.clear();
                    sDeinitializeFuture = CallbackToFutureAdapter.getFuture(new k0(this, 17));
                } else {
                    sDeinitializeFuture = Futures.immediateFuture(null);
                }
                ListenableFuture<Void> listenableFuture3 = sDeinitializeFuture;
                return listenableFuture3;
            } catch (ExecutionException e) {
                e = e;
                ListenableFuture<Void> immediateFailedFuture = Futures.immediateFailedFuture(e);
                sDeinitializeFuture = immediateFailedFuture;
                return immediateFailedFuture;
            } catch (InterruptedException e2) {
                e = e2;
                ListenableFuture<Void> immediateFailedFuture2 = Futures.immediateFailedFuture(e);
                sDeinitializeFuture = immediateFailedFuture2;
                return immediateFailedFuture2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    @NonNull
    public static ListenableFuture<ExtensionsManager> getInstanceAsync(@NonNull Context context, @NonNull CameraProvider cameraProvider, @NonNull String str) {
        ClientVersion clientVersion = new ClientVersion(str);
        ClientVersion.setCurrentVersion(clientVersion);
        return getInstanceAsync(context, cameraProvider, clientVersion);
    }

    @NonNull
    public static ListenableFuture<ExtensionsManager> getInstanceAsync(@NonNull Context context, @NonNull CameraProvider cameraProvider, @NonNull ClientVersion clientVersion) {
        synchronized (EXTENSIONS_LOCK) {
            try {
                ListenableFuture<Void> listenableFuture = sDeinitializeFuture;
                if (listenableFuture != null) {
                    if (!listenableFuture.isDone()) {
                        throw new IllegalStateException("Not yet done deinitializing extensions");
                    }
                }
                sDeinitializeFuture = null;
                if (ExtensionVersion.getRuntimeVersion() == null) {
                    ListenableFuture<ExtensionsManager> immediateFuture = Futures.immediateFuture(getOrCreateExtensionsManager(ExtensionsAvailability.NONE, cameraProvider));
                    return immediateFuture;
                }
                Version version = Version.VERSION_1_0;
                if (!ClientVersion.isMaximumCompatibleVersion(version)) {
                    if (!ExtensionVersion.isMaximumCompatibleVersion(version)) {
                        if (sInitializeFuture == null) {
                            sInitializeFuture = CallbackToFutureAdapter.getFuture(new g4(clientVersion, 5, context, cameraProvider));
                        }
                        ListenableFuture<ExtensionsManager> listenableFuture2 = sInitializeFuture;
                        return listenableFuture2;
                    }
                }
                ListenableFuture<ExtensionsManager> immediateFuture2 = Futures.immediateFuture(getOrCreateExtensionsManager(ExtensionsAvailability.LIBRARY_AVAILABLE, cameraProvider));
                return immediateFuture2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
