package androidx.camera.lifecycle;

import android.content.Context;
import androidx.annotation.GuardedBy;
import androidx.annotation.MainThread;
import androidx.annotation.OptIn;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraX;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.ExperimentalCameraInfo;
import androidx.camera.core.LayoutSettings;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.ViewPort;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigProvider;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.ExtendedCameraConfigProviderStore;
import androidx.camera.core.impl.RestrictedCameraInfo;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LifecycleOwner;
import androidx.tracing.Trace;
import com.facebook.places.model.PlaceFields;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 Z2\u00020\u0001:\u0001ZB\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jk\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010.2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\b\u00103\u001a\u0004\u0018\u0001042\u000e\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001060\u00042\u0016\u00107\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010908\"\u0004\u0018\u000109H\u0001¢\u0006\u0004\b:\u0010;J \u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010<\u001a\u00020.2\u0006\u0010=\u001a\u00020>H\u0007J5\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010<\u001a\u00020.2\u0016\u00107\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010908\"\u0004\u0018\u000109H\u0007¢\u0006\u0002\u0010?J\u0018\u0010)\u001a\u00020@2\u000e\u0010A\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010B0\u0004H\u0007J\u0010\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0002J\u000e\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0018\u0010H\u001a\u00020I2\u0006\u0010<\u001a\u00020.2\u0006\u0010J\u001a\u00020\u0005H\u0002J\u0010\u0010K\u001a\u00020\u00052\u0006\u0010<\u001a\u00020.H\u0017J\u0016\u0010L\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001f2\u0006\u0010M\u001a\u00020$H\u0002J\u0010\u0010N\u001a\u00020\u00142\u0006\u0010<\u001a\u00020.H\u0016J\u0010\u0010O\u001a\u00020\u00142\u0006\u0010P\u001a\u000209H\u0016J\u0010\u0010Q\u001a\u00020\u00142\u0006\u0010P\u001a\u000209H\u0002J\u0010\u0010R\u001a\u00020\u00142\u0006\u0010P\u001a\u000209H\u0002J\u0010\u0010S\u001a\u00020D2\u0006\u0010T\u001a\u00020\u001bH\u0002J\u0010\u0010U\u001a\u00020D2\u0006\u0010M\u001a\u00020$H\u0002J\u000e\u0010V\u001a\b\u0012\u0004\u0012\u00020!0\u001fH\u0007J%\u0010W\u001a\u00020D2\u0016\u00107\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010908\"\u0004\u0018\u000109H\u0017¢\u0006\u0002\u0010XJ\b\u0010Y\u001a\u00020DH\u0017R0\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048B@BX\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00048G¢\u0006\u0006\u001a\u0004\b\f\u0010\bR$\u0010\r\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8B@BX\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u001c\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00178\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R \u0010 \u001a\u0010\u0012\f\u0012\n \"*\u0004\u0018\u00010!0!0\u001f8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Landroidx/camera/lifecycle/ProcessCameraProvider;", "Landroidx/camera/lifecycle/LifecycleCameraProvider;", "()V", "cameraInfos", "", "Landroidx/camera/core/CameraInfo;", "activeConcurrentCameraInfos", "getActiveConcurrentCameraInfos", "()Ljava/util/List;", "setActiveConcurrentCameraInfos", "(Ljava/util/List;)V", "availableConcurrentCameraInfos", "getAvailableConcurrentCameraInfos", "cameraOperatingMode", "", "getCameraOperatingMode", "()I", "setCameraOperatingMode", "(I)V", "isConcurrentCameraModeOn", "", "()Z", "mCameraInfoMap", "", "Landroidx/camera/core/internal/CameraUseCaseAdapter$CameraId;", "Landroidx/camera/core/impl/RestrictedCameraInfo;", "mCameraX", "Landroidx/camera/core/CameraX;", "mCameraXConfigProvider", "Landroidx/camera/core/CameraXConfig$Provider;", "mCameraXInitializeFuture", "Lcom/google/common/util/concurrent/ListenableFuture;", "mCameraXShutdownFuture", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "mContext", "Landroid/content/Context;", "mLifecycleCameraRepository", "Landroidx/camera/lifecycle/LifecycleCameraRepository;", "mLock", "", "bindToLifecycle", "Landroidx/camera/core/Camera;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "primaryCameraSelector", "Landroidx/camera/core/CameraSelector;", "secondaryCameraSelector", "primaryLayoutSettings", "Landroidx/camera/core/LayoutSettings;", "secondaryLayoutSettings", "viewPort", "Landroidx/camera/core/ViewPort;", "effects", "Landroidx/camera/core/CameraEffect;", "useCases", "", "Landroidx/camera/core/UseCase;", "bindToLifecycle$camera_lifecycle_release", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/camera/core/CameraSelector;Landroidx/camera/core/CameraSelector;Landroidx/camera/core/LayoutSettings;Landroidx/camera/core/LayoutSettings;Landroidx/camera/core/ViewPort;Ljava/util/List;[Landroidx/camera/core/UseCase;)Landroidx/camera/core/Camera;", "cameraSelector", "useCaseGroup", "Landroidx/camera/core/UseCaseGroup;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/camera/core/CameraSelector;[Landroidx/camera/core/UseCase;)Landroidx/camera/core/Camera;", "Landroidx/camera/core/ConcurrentCamera;", "singleCameraConfigs", "Landroidx/camera/core/ConcurrentCamera$SingleCameraConfig;", "configureInstanceInternal", "", "cameraXConfig", "Landroidx/camera/core/CameraXConfig;", "getAvailableCameraInfos", "getCameraConfig", "Landroidx/camera/core/impl/CameraConfig;", "cameraInfo", "getCameraInfo", "getOrCreateCameraXInstance", "context", "hasCamera", "isBound", "useCase", "isPreview", "isVideoCapture", "setCameraX", "cameraX", "setContext", "shutdownAsync", "unbind", "([Landroidx/camera/core/UseCase;)V", "unbindAll", "Companion", "camera-lifecycle_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nProcessCameraProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProcessCameraProvider.kt\nandroidx/camera/lifecycle/ProcessCameraProvider\n+ 2 Trace.kt\nandroidx/tracing/TraceKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,995:1\n27#2,5:996\n27#2,3:1001\n31#2:1006\n27#2,3:1007\n31#2:1016\n27#2,3:1017\n31#2:1022\n27#2,5:1023\n27#2,5:1028\n27#2,5:1033\n27#2,5:1038\n27#2,5:1043\n27#2,5:1048\n27#2,5:1053\n37#3,2:1004\n37#3,2:1010\n37#3,2:1012\n37#3,2:1014\n1855#4,2:1020\n*S KotlinDebug\n*F\n+ 1 ProcessCameraProvider.kt\nandroidx/camera/lifecycle/ProcessCameraProvider\n*L\n204#1:996,5\n244#1:1001,3\n244#1:1006\n327#1:1007,3\n327#1:1016\n557#1:1017,3\n557#1:1022\n665#1:1023,5\n679#1:1028,5\n687#1:1033,5\n711#1:1038,5\n736#1:1043,5\n761#1:1048,5\n830#1:1053,5\n261#1:1004,2\n388#1:1010,2\n453#1:1012,2\n467#1:1014,2\n589#1:1020,2\n*E\n"})
public final class ProcessCameraProvider implements LifecycleCameraProvider {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final ProcessCameraProvider sAppInstance = new ProcessCameraProvider();
    /* access modifiers changed from: private */
    @NotNull
    @GuardedBy("mLock")
    public final Map<CameraUseCaseAdapter.CameraId, RestrictedCameraInfo> mCameraInfoMap;
    /* access modifiers changed from: private */
    @Nullable
    public CameraX mCameraX;
    /* access modifiers changed from: private */
    @Nullable
    @GuardedBy("mLock")
    public CameraXConfig.Provider mCameraXConfigProvider;
    @Nullable
    @GuardedBy("mLock")
    private ListenableFuture<CameraX> mCameraXInitializeFuture;
    @NotNull
    @GuardedBy("mLock")
    private ListenableFuture<Void> mCameraXShutdownFuture;
    /* access modifiers changed from: private */
    @Nullable
    public Context mContext;
    /* access modifiers changed from: private */
    @NotNull
    public final LifecycleCameraRepository mLifecycleCameraRepository;
    /* access modifiers changed from: private */
    @NotNull
    public final Object mLock = new Object();

    @SourceDebugExtension({"SMAP\nProcessCameraProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProcessCameraProvider.kt\nandroidx/camera/lifecycle/ProcessCameraProvider$Companion\n+ 2 Trace.kt\nandroidx/tracing/TraceKt\n*L\n1#1,995:1\n27#2,5:996\n*S KotlinDebug\n*F\n+ 1 ProcessCameraProvider.kt\nandroidx/camera/lifecycle/ProcessCameraProvider$Companion\n*L\n992#1:996,5\n*E\n"})
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/camera/lifecycle/ProcessCameraProvider$Companion;", "", "()V", "sAppInstance", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "configureInstance", "", "cameraXConfig", "Landroidx/camera/core/CameraXConfig;", "getInstance", "Lcom/google/common/util/concurrent/ListenableFuture;", "context", "Landroid/content/Context;", "camera-lifecycle_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public static final ProcessCameraProvider getInstance$lambda$0(Function1 function1, Object obj) {
            Intrinsics.checkNotNullParameter(function1, "$tmp0");
            return (ProcessCameraProvider) function1.invoke(obj);
        }

        @ExperimentalCameraProviderConfiguration
        @JvmStatic
        public final void configureInstance(@NotNull CameraXConfig cameraXConfig) {
            Intrinsics.checkNotNullParameter(cameraXConfig, "cameraXConfig");
            Trace.beginSection("CX:configureInstance");
            try {
                ProcessCameraProvider.sAppInstance.configureInstanceInternal(cameraXConfig);
                Unit unit = Unit.f696a;
            } finally {
                Trace.endSection();
            }
        }

        @JvmStatic
        @NotNull
        public final ListenableFuture<ProcessCameraProvider> getInstance(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, PlaceFields.CONTEXT);
            Preconditions.checkNotNull(context);
            ListenableFuture<ProcessCameraProvider> transform = Futures.transform(ProcessCameraProvider.sAppInstance.getOrCreateCameraXInstance(context), new g2(new ProcessCameraProvider$Companion$getInstance$1(context), 3), CameraXExecutors.directExecutor());
            Intrinsics.checkNotNullExpressionValue(transform, "context: Context): Liste…tExecutor()\n            )");
            return transform;
        }

        private Companion() {
        }
    }

    private ProcessCameraProvider() {
        ListenableFuture<Void> immediateFuture = Futures.immediateFuture(null);
        Intrinsics.checkNotNullExpressionValue(immediateFuture, "immediateFuture<Void>(null)");
        this.mCameraXShutdownFuture = immediateFuture;
        this.mLifecycleCameraRepository = new LifecycleCameraRepository();
        this.mCameraInfoMap = new HashMap();
    }

    @ExperimentalCameraProviderConfiguration
    @JvmStatic
    public static final void configureInstance(@NotNull CameraXConfig cameraXConfig) {
        Companion.configureInstance(cameraXConfig);
    }

    /* access modifiers changed from: private */
    public final void configureInstanceInternal(CameraXConfig cameraXConfig) {
        boolean z;
        Trace.beginSection("CX:configureInstanceInternal");
        try {
            synchronized (this.mLock) {
                Preconditions.checkNotNull(cameraXConfig);
                if (this.mCameraXConfigProvider == null) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkState(z, "CameraX has already been configured. To use a different configuration, shutdown() must be called.");
                this.mCameraXConfigProvider = new ProcessCameraProvider$configureInstanceInternal$1$1$1(cameraXConfig);
                Unit unit = Unit.f696a;
            }
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public final List<CameraInfo> getActiveConcurrentCameraInfos() {
        CameraX cameraX = this.mCameraX;
        if (cameraX == null) {
            return new ArrayList();
        }
        Intrinsics.c(cameraX);
        List<CameraInfo> activeConcurrentCameraInfos = cameraX.getCameraFactory().getCameraCoordinator().getActiveConcurrentCameraInfos();
        Intrinsics.checkNotNullExpressionValue(activeConcurrentCameraInfos, "mCameraX!!.cameraFactory…tiveConcurrentCameraInfos");
        return activeConcurrentCameraInfos;
    }

    /* access modifiers changed from: private */
    public final CameraConfig getCameraConfig(CameraSelector cameraSelector, CameraInfo cameraInfo) {
        Iterator<CameraFilter> it = cameraSelector.getCameraFilterSet().iterator();
        CameraConfig cameraConfig = null;
        while (it.hasNext()) {
            CameraFilter next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "cameraSelector.cameraFilterSet");
            CameraFilter cameraFilter = next;
            if (!Intrinsics.a(cameraFilter.getIdentifier(), CameraFilter.DEFAULT_ID)) {
                CameraConfigProvider configProvider = ExtendedCameraConfigProviderStore.getConfigProvider(cameraFilter.getIdentifier());
                Context context = this.mContext;
                Intrinsics.c(context);
                CameraConfig config = configProvider.getConfig(cameraInfo, context);
                if (config == null) {
                    continue;
                } else if (cameraConfig == null) {
                    cameraConfig = config;
                } else {
                    throw new IllegalArgumentException("Cannot apply multiple extended camera configs at the same time.");
                }
            }
        }
        if (cameraConfig == null) {
            return CameraConfigs.defaultConfig();
        }
        return cameraConfig;
    }

    /* access modifiers changed from: private */
    public final int getCameraOperatingMode() {
        CameraX cameraX = this.mCameraX;
        if (cameraX == null) {
            return 0;
        }
        Intrinsics.c(cameraX);
        return cameraX.getCameraFactory().getCameraCoordinator().getCameraOperatingMode();
    }

    @JvmStatic
    @NotNull
    public static final ListenableFuture<ProcessCameraProvider> getInstance(@NotNull Context context) {
        return Companion.getInstance(context);
    }

    /* access modifiers changed from: private */
    public final ListenableFuture<CameraX> getOrCreateCameraXInstance(Context context) {
        synchronized (this.mLock) {
            ListenableFuture<CameraX> listenableFuture = this.mCameraXInitializeFuture;
            if (listenableFuture != null) {
                return listenableFuture;
            }
            ListenableFuture<CameraX> future = CallbackToFutureAdapter.getFuture(new t2(this, new CameraX(context, this.mCameraXConfigProvider)));
            this.mCameraXInitializeFuture = future;
            Intrinsics.d(future, "null cannot be cast to non-null type com.google.common.util.concurrent.ListenableFuture<androidx.camera.core.CameraX>");
            return future;
        }
    }

    /* access modifiers changed from: private */
    public static final Object getOrCreateCameraXInstance$lambda$18$lambda$17(ProcessCameraProvider processCameraProvider, CameraX cameraX, CallbackToFutureAdapter.Completer completer) {
        Intrinsics.checkNotNullParameter(processCameraProvider, "this$0");
        Intrinsics.checkNotNullParameter(cameraX, "$cameraX");
        Intrinsics.checkNotNullParameter(completer, "completer");
        synchronized (processCameraProvider.mLock) {
            FutureChain<T> transformAsync = FutureChain.from(processCameraProvider.mCameraXShutdownFuture).transformAsync(new ih(new ProcessCameraProvider$getOrCreateCameraXInstance$1$1$1$future$1(cameraX), 2), CameraXExecutors.directExecutor());
            Intrinsics.checkNotNullExpressionValue(transformAsync, "cameraX = CameraX(contex…                        )");
            Futures.addCallback(transformAsync, new ProcessCameraProvider$getOrCreateCameraXInstance$1$1$1$1(completer, cameraX), CameraXExecutors.directExecutor());
            Unit unit = Unit.f696a;
        }
        return "ProcessCameraProvider-initializeCameraX";
    }

    /* access modifiers changed from: private */
    public static final ListenableFuture getOrCreateCameraXInstance$lambda$18$lambda$17$lambda$16$lambda$15(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        return (ListenableFuture) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final boolean isPreview(UseCase useCase) {
        return useCase instanceof Preview;
    }

    /* access modifiers changed from: private */
    public final boolean isVideoCapture(UseCase useCase) {
        if (!useCase.getCurrentConfig().containsOption(UseCaseConfig.OPTION_CAPTURE_TYPE) || useCase.getCurrentConfig().getCaptureType() != UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final void setActiveConcurrentCameraInfos(List<? extends CameraInfo> list) {
        CameraX cameraX = this.mCameraX;
        if (cameraX != null) {
            Intrinsics.c(cameraX);
            cameraX.getCameraFactory().getCameraCoordinator().setActiveConcurrentCameraInfos(list);
        }
    }

    /* access modifiers changed from: private */
    public final void setCameraOperatingMode(int i) {
        CameraX cameraX = this.mCameraX;
        if (cameraX != null) {
            Intrinsics.c(cameraX);
            cameraX.getCameraFactory().getCameraCoordinator().setCameraOperatingMode(i);
        }
    }

    /* access modifiers changed from: private */
    public final void setCameraX(CameraX cameraX) {
        this.mCameraX = cameraX;
    }

    /* access modifiers changed from: private */
    public final void setContext(Context context) {
        this.mContext = context;
    }

    /* access modifiers changed from: private */
    public static final void shutdownAsync$lambda$0(ProcessCameraProvider processCameraProvider) {
        Intrinsics.checkNotNullParameter(processCameraProvider, "this$0");
        processCameraProvider.unbindAll();
        processCameraProvider.mLifecycleCameraRepository.clear();
    }

    @NotNull
    @MainThread
    public final Camera bindToLifecycle(@NotNull LifecycleOwner lifecycleOwner, @NotNull CameraSelector cameraSelector, @NotNull UseCase... useCaseArr) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
        Intrinsics.checkNotNullParameter(useCaseArr, "useCases");
        Trace.beginSection("CX:bindToLifecycle");
        try {
            if (getCameraOperatingMode() != 2) {
                setCameraOperatingMode(1);
                LayoutSettings layoutSettings = LayoutSettings.DEFAULT;
                Intrinsics.checkNotNullExpressionValue(layoutSettings, MessengerShareContentUtility.PREVIEW_DEFAULT);
                Intrinsics.checkNotNullExpressionValue(layoutSettings, MessengerShareContentUtility.PREVIEW_DEFAULT);
                return bindToLifecycle$camera_lifecycle_release(lifecycleOwner, cameraSelector, (CameraSelector) null, layoutSettings, layoutSettings, (ViewPort) null, EmptyList.INSTANCE, (UseCase[]) Arrays.copyOf(useCaseArr, useCaseArr.length));
            }
            throw new UnsupportedOperationException("bindToLifecycle for single camera is not supported in concurrent camera mode, call unbindAll() first");
        } finally {
            Trace.endSection();
        }
    }

    @NotNull
    @OptIn(markerClass = {ExperimentalCameraInfo.class})
    public final Camera bindToLifecycle$camera_lifecycle_release(@NotNull LifecycleOwner lifecycleOwner, @NotNull CameraSelector cameraSelector, @Nullable CameraSelector cameraSelector2, @NotNull LayoutSettings layoutSettings, @NotNull LayoutSettings layoutSettings2, @Nullable ViewPort viewPort, @NotNull List<? extends CameraEffect> list, @NotNull UseCase... useCaseArr) {
        CameraInternal cameraInternal;
        RestrictedCameraInfo restrictedCameraInfo;
        LifecycleOwner lifecycleOwner2 = lifecycleOwner;
        CameraSelector cameraSelector3 = cameraSelector;
        CameraSelector cameraSelector4 = cameraSelector2;
        UseCase[] useCaseArr2 = useCaseArr;
        Intrinsics.checkNotNullParameter(lifecycleOwner2, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(cameraSelector3, "primaryCameraSelector");
        Intrinsics.checkNotNullParameter(layoutSettings, "primaryLayoutSettings");
        Intrinsics.checkNotNullParameter(layoutSettings2, "secondaryLayoutSettings");
        Intrinsics.checkNotNullParameter(list, "effects");
        Intrinsics.checkNotNullParameter(useCaseArr2, "useCases");
        Trace.beginSection("CX:bindToLifecycle-internal");
        try {
            Threads.checkMainThread();
            CameraX access$getMCameraX$p = this.mCameraX;
            Intrinsics.c(access$getMCameraX$p);
            CameraInternal select = cameraSelector3.select(access$getMCameraX$p.getCameraRepository().getCameras());
            Intrinsics.checkNotNullExpressionValue(select, "primaryCameraSelector.se…cameraRepository.cameras)");
            select.setPrimary(true);
            CameraInfo cameraInfo = getCameraInfo(cameraSelector3);
            Intrinsics.d(cameraInfo, "null cannot be cast to non-null type androidx.camera.core.impl.RestrictedCameraInfo");
            RestrictedCameraInfo restrictedCameraInfo2 = (RestrictedCameraInfo) cameraInfo;
            if (cameraSelector4 != null) {
                CameraX access$getMCameraX$p2 = this.mCameraX;
                Intrinsics.c(access$getMCameraX$p2);
                CameraInternal select2 = cameraSelector4.select(access$getMCameraX$p2.getCameraRepository().getCameras());
                select2.setPrimary(false);
                CameraInfo cameraInfo2 = getCameraInfo(cameraSelector4);
                Intrinsics.d(cameraInfo2, "null cannot be cast to non-null type androidx.camera.core.impl.RestrictedCameraInfo");
                cameraInternal = select2;
                restrictedCameraInfo = (RestrictedCameraInfo) cameraInfo2;
            } else {
                restrictedCameraInfo = null;
                cameraInternal = null;
            }
            LifecycleCamera lifecycleCamera = this.mLifecycleCameraRepository.getLifecycleCamera(lifecycleOwner2, CameraUseCaseAdapter.generateCameraId(restrictedCameraInfo2, restrictedCameraInfo));
            Collection<LifecycleCamera> lifecycleCameras = this.mLifecycleCameraRepository.getLifecycleCameras();
            Iterator it = ArraysKt.p(useCaseArr).iterator();
            while (it.hasNext()) {
                UseCase useCase = (UseCase) it.next();
                for (LifecycleCamera next : lifecycleCameras) {
                    Intrinsics.checkNotNullExpressionValue(next, "lifecycleCameras");
                    LifecycleCamera lifecycleCamera2 = next;
                    if (lifecycleCamera2.isBound(useCase) && !lifecycleCamera2.equals(lifecycleCamera)) {
                        String format = String.format("Use case %s already bound to a different lifecycle.", Arrays.copyOf(new Object[]{useCase}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                        throw new IllegalStateException(format);
                    }
                }
            }
            if (lifecycleCamera == null) {
                LifecycleCameraRepository access$getMLifecycleCameraRepository$p = this.mLifecycleCameraRepository;
                CameraX access$getMCameraX$p3 = this.mCameraX;
                Intrinsics.c(access$getMCameraX$p3);
                CameraCoordinator cameraCoordinator = access$getMCameraX$p3.getCameraFactory().getCameraCoordinator();
                CameraX access$getMCameraX$p4 = this.mCameraX;
                Intrinsics.c(access$getMCameraX$p4);
                CameraDeviceSurfaceManager cameraDeviceSurfaceManager = access$getMCameraX$p4.getCameraDeviceSurfaceManager();
                CameraX access$getMCameraX$p5 = this.mCameraX;
                Intrinsics.c(access$getMCameraX$p5);
                lifecycleCamera = access$getMLifecycleCameraRepository$p.createLifecycleCamera(lifecycleOwner2, new CameraUseCaseAdapter(select, cameraInternal, restrictedCameraInfo2, restrictedCameraInfo, layoutSettings, layoutSettings2, cameraCoordinator, cameraDeviceSurfaceManager, access$getMCameraX$p5.getDefaultConfigFactory()));
            }
            if (useCaseArr2.length == 0) {
                Intrinsics.c(lifecycleCamera);
            } else {
                LifecycleCameraRepository access$getMLifecycleCameraRepository$p2 = this.mLifecycleCameraRepository;
                Intrinsics.c(lifecycleCamera);
                CameraX access$getMCameraX$p6 = this.mCameraX;
                Intrinsics.c(access$getMCameraX$p6);
                access$getMLifecycleCameraRepository$p2.bindToLifecycleCamera(lifecycleCamera, viewPort, list, CollectionsKt.t(Arrays.copyOf(useCaseArr2, useCaseArr2.length)), access$getMCameraX$p6.getCameraFactory().getCameraCoordinator());
            }
            return lifecycleCamera;
        } finally {
            Trace.endSection();
        }
    }

    @NotNull
    public List<CameraInfo> getAvailableCameraInfos() {
        Trace.beginSection("CX:getAvailableCameraInfos");
        try {
            ArrayList arrayList = new ArrayList();
            CameraX access$getMCameraX$p = this.mCameraX;
            Intrinsics.c(access$getMCameraX$p);
            LinkedHashSet<CameraInternal> cameras = access$getMCameraX$p.getCameraRepository().getCameras();
            Intrinsics.checkNotNullExpressionValue(cameras, "mCameraX!!.cameraRepository.cameras");
            for (CameraInternal cameraInfo : cameras) {
                CameraInfo cameraInfo2 = cameraInfo.getCameraInfo();
                Intrinsics.checkNotNullExpressionValue(cameraInfo2, "camera.cameraInfo");
                arrayList.add(cameraInfo2);
            }
            return arrayList;
        } finally {
            Trace.endSection();
        }
    }

    @NotNull
    @OptIn(markerClass = {ExperimentalCameraInfo.class})
    public final List<List<CameraInfo>> getAvailableConcurrentCameraInfos() {
        Trace.beginSection("CX:getAvailableConcurrentCameraInfos");
        try {
            Objects.requireNonNull(this.mCameraX);
            CameraX access$getMCameraX$p = this.mCameraX;
            Intrinsics.c(access$getMCameraX$p);
            Objects.requireNonNull(access$getMCameraX$p.getCameraFactory().getCameraCoordinator());
            CameraX access$getMCameraX$p2 = this.mCameraX;
            Intrinsics.c(access$getMCameraX$p2);
            List<List<CameraSelector>> concurrentCameraSelectors = access$getMCameraX$p2.getCameraFactory().getCameraCoordinator().getConcurrentCameraSelectors();
            Intrinsics.checkNotNullExpressionValue(concurrentCameraSelectors, "mCameraX!!.cameraFactory…concurrentCameraSelectors");
            ArrayList arrayList = new ArrayList();
            for (List<CameraSelector> it : concurrentCameraSelectors) {
                ArrayList arrayList2 = new ArrayList();
                for (CameraSelector cameraSelector : it) {
                    try {
                        Intrinsics.checkNotNullExpressionValue(cameraSelector, "cameraSelector");
                        arrayList2.add(getCameraInfo(cameraSelector));
                    } catch (IllegalArgumentException unused) {
                    }
                }
                arrayList.add(arrayList2);
            }
            Trace.endSection();
            return arrayList;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @NotNull
    @ExperimentalCameraInfo
    public CameraInfo getCameraInfo(@NotNull CameraSelector cameraSelector) {
        Object obj;
        Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
        Trace.beginSection("CX:getCameraInfo");
        try {
            CameraX access$getMCameraX$p = this.mCameraX;
            Intrinsics.c(access$getMCameraX$p);
            CameraInfoInternal cameraInfoInternal = cameraSelector.select(access$getMCameraX$p.getCameraRepository().getCameras()).getCameraInfoInternal();
            Intrinsics.checkNotNullExpressionValue(cameraInfoInternal, "cameraSelector.select(mC…meras).cameraInfoInternal");
            CameraConfig access$getCameraConfig = getCameraConfig(cameraSelector, cameraInfoInternal);
            CameraUseCaseAdapter.CameraId create = CameraUseCaseAdapter.CameraId.create(cameraInfoInternal.getCameraId(), access$getCameraConfig.getCompatibilityId());
            Intrinsics.checkNotNullExpressionValue(create, "create(\n                …ilityId\n                )");
            synchronized (this.mLock) {
                obj = this.mCameraInfoMap.get(create);
                if (obj == null) {
                    obj = new RestrictedCameraInfo(cameraInfoInternal, access$getCameraConfig);
                    this.mCameraInfoMap.put(create, obj);
                }
                Unit unit = Unit.f696a;
            }
            RestrictedCameraInfo restrictedCameraInfo = (RestrictedCameraInfo) obj;
            Trace.endSection();
            return restrictedCameraInfo;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public boolean hasCamera(@NotNull CameraSelector cameraSelector) throws CameraInfoUnavailableException {
        boolean z;
        Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
        Trace.beginSection("CX:hasCamera");
        try {
            CameraX access$getMCameraX$p = this.mCameraX;
            Intrinsics.c(access$getMCameraX$p);
            cameraSelector.select(access$getMCameraX$p.getCameraRepository().getCameras());
            z = true;
        } catch (IllegalArgumentException unused) {
            z = false;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
        Trace.endSection();
        return z;
    }

    public boolean isBound(@NotNull UseCase useCase) {
        Intrinsics.checkNotNullParameter(useCase, "useCase");
        for (LifecycleCamera next : this.mLifecycleCameraRepository.getLifecycleCameras()) {
            Intrinsics.checkNotNullExpressionValue(next, "mLifecycleCameraRepository.lifecycleCameras");
            if (next.isBound(useCase)) {
                return true;
            }
        }
        return false;
    }

    @MainThread
    public final boolean isConcurrentCameraModeOn() {
        if (getCameraOperatingMode() == 2) {
            return true;
        }
        return false;
    }

    @NotNull
    @VisibleForTesting
    public final ListenableFuture<Void> shutdownAsync() {
        ListenableFuture<Void> listenableFuture;
        Threads.runOnMainSync(new gd(this, 0));
        CameraX cameraX = this.mCameraX;
        if (cameraX != null) {
            cameraX.getCameraFactory().getCameraCoordinator().shutdown();
        }
        CameraX cameraX2 = this.mCameraX;
        if (cameraX2 != null) {
            listenableFuture = cameraX2.shutdown();
        } else {
            listenableFuture = Futures.immediateFuture(null);
        }
        Intrinsics.checkNotNullExpressionValue(listenableFuture, "if (mCameraX != null) mC…mediateFuture<Void>(null)");
        synchronized (this.mLock) {
            this.mCameraXConfigProvider = null;
            this.mCameraXInitializeFuture = null;
            this.mCameraXShutdownFuture = listenableFuture;
            this.mCameraInfoMap.clear();
            Unit unit = Unit.f696a;
        }
        this.mCameraX = null;
        this.mContext = null;
        return listenableFuture;
    }

    @MainThread
    public void unbind(@NotNull UseCase... useCaseArr) {
        Intrinsics.checkNotNullParameter(useCaseArr, "useCases");
        Trace.beginSection("CX:unbind");
        try {
            Threads.checkMainThread();
            if (getCameraOperatingMode() != 2) {
                this.mLifecycleCameraRepository.unbind(CollectionsKt.t(Arrays.copyOf(useCaseArr, useCaseArr.length)));
                Unit unit = Unit.f696a;
                return;
            }
            throw new UnsupportedOperationException("Unbind usecase is not supported in concurrent camera mode, call unbindAll() first.");
        } finally {
            Trace.endSection();
        }
    }

    @MainThread
    public void unbindAll() {
        Trace.beginSection("CX:unbindAll");
        try {
            Threads.checkMainThread();
            setCameraOperatingMode(0);
            this.mLifecycleCameraRepository.unbindAll();
            Unit unit = Unit.f696a;
        } finally {
            Trace.endSection();
        }
    }

    @NotNull
    @MainThread
    public final Camera bindToLifecycle(@NotNull LifecycleOwner lifecycleOwner, @NotNull CameraSelector cameraSelector, @NotNull UseCaseGroup useCaseGroup) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(cameraSelector, "cameraSelector");
        Intrinsics.checkNotNullParameter(useCaseGroup, "useCaseGroup");
        Trace.beginSection("CX:bindToLifecycle-UseCaseGroup");
        try {
            if (getCameraOperatingMode() != 2) {
                setCameraOperatingMode(1);
                LayoutSettings layoutSettings = LayoutSettings.DEFAULT;
                Intrinsics.checkNotNullExpressionValue(layoutSettings, MessengerShareContentUtility.PREVIEW_DEFAULT);
                Intrinsics.checkNotNullExpressionValue(layoutSettings, MessengerShareContentUtility.PREVIEW_DEFAULT);
                ViewPort viewPort = useCaseGroup.getViewPort();
                List<CameraEffect> effects = useCaseGroup.getEffects();
                Intrinsics.checkNotNullExpressionValue(effects, "useCaseGroup.effects");
                List<UseCase> useCases = useCaseGroup.getUseCases();
                Intrinsics.checkNotNullExpressionValue(useCases, "useCaseGroup.useCases");
                UseCase[] useCaseArr = (UseCase[]) useCases.toArray(new UseCase[0]);
                return bindToLifecycle$camera_lifecycle_release(lifecycleOwner, cameraSelector, (CameraSelector) null, layoutSettings, layoutSettings, viewPort, effects, (UseCase[]) Arrays.copyOf(useCaseArr, useCaseArr.length));
            }
            throw new UnsupportedOperationException("bindToLifecycle for single camera is not supported in concurrent camera mode, call unbindAll() first.");
        } finally {
            Trace.endSection();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:73|74|75) */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01f9, code lost:
        if (access$isPreview(r10, r3) == false) goto L_0x01fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0208, code lost:
        if (access$isVideoCapture(r10, r3) != false) goto L_0x020a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x020a, code lost:
        r2 = r1.getLifecycleOwner();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, "firstCameraConfig.lifecycleOwner");
        r3 = r1.getCameraSelector();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "firstCameraConfig.cameraSelector");
        r0 = r4.getCameraSelector();
        r5 = r1.getLayoutSettings();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "firstCameraConfig.layoutSettings");
        r7 = r4.getLayoutSettings();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, "secondCameraConfig.layoutSettings");
        r8 = r1.getUseCaseGroup().getViewPort();
        r9 = r1.getUseCaseGroup().getEffects();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, "firstCameraConfig.useCaseGroup.effects");
        r1 = r1.getUseCaseGroup().getUseCases();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "firstCameraConfig.useCaseGroup.useCases");
        r1 = (androidx.camera.core.UseCase[]) r1.toArray(new androidx.camera.core.UseCase[0]);
        r12.add(bindToLifecycle$camera_lifecycle_release(r2, r3, r0, r5, r7, r8, r9, (androidx.camera.core.UseCase[]) java.util.Arrays.copyOf(r1, r1.length)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x02ed, code lost:
        throw new java.lang.IllegalArgumentException("Invalid camera selectors in camera configs.");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x02e6 */
    @androidx.annotation.MainThread
    @androidx.annotation.OptIn(markerClass = {androidx.camera.core.ExperimentalCameraInfo.class})
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.camera.core.ConcurrentCamera bindToLifecycle(@org.jetbrains.annotations.NotNull java.util.List<androidx.camera.core.ConcurrentCamera.SingleCameraConfig> r17) {
        /*
            r16 = this;
            r10 = r16
            r0 = r17
            java.lang.String r1 = "singleCameraConfigs"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.String r1 = "CX:bindToLifecycle-Concurrent"
            androidx.tracing.Trace.beginSection(r1)
            int r1 = r17.size()     // Catch:{ all -> 0x00fa }
            r2 = 2
            if (r1 < r2) goto L_0x0304
            int r1 = r17.size()     // Catch:{ all -> 0x00fa }
            if (r1 > r2) goto L_0x02fc
            r11 = 0
            java.lang.Object r1 = r0.get(r11)     // Catch:{ all -> 0x00fa }
            kotlin.jvm.internal.Intrinsics.c(r1)     // Catch:{ all -> 0x00fa }
            androidx.camera.core.ConcurrentCamera$SingleCameraConfig r1 = (androidx.camera.core.ConcurrentCamera.SingleCameraConfig) r1     // Catch:{ all -> 0x00fa }
            r3 = 1
            java.lang.Object r4 = r0.get(r3)     // Catch:{ all -> 0x00fa }
            kotlin.jvm.internal.Intrinsics.c(r4)     // Catch:{ all -> 0x00fa }
            androidx.camera.core.ConcurrentCamera$SingleCameraConfig r4 = (androidx.camera.core.ConcurrentCamera.SingleCameraConfig) r4     // Catch:{ all -> 0x00fa }
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ all -> 0x00fa }
            r12.<init>()     // Catch:{ all -> 0x00fa }
            androidx.camera.core.CameraSelector r5 = r1.getCameraSelector()     // Catch:{ all -> 0x00fa }
            java.lang.Integer r5 = r5.getLensFacing()     // Catch:{ all -> 0x00fa }
            androidx.camera.core.CameraSelector r6 = r4.getCameraSelector()     // Catch:{ all -> 0x00fa }
            java.lang.Integer r6 = r6.getLensFacing()     // Catch:{ all -> 0x00fa }
            boolean r5 = kotlin.jvm.internal.Intrinsics.a(r5, r6)     // Catch:{ all -> 0x00fa }
            java.lang.String r13 = "config.useCaseGroup.useCases"
            java.lang.String r6 = "firstCameraConfig.useCaseGroup.effects"
            java.lang.String r7 = "firstCameraConfig.lifecycleOwner"
            java.lang.String r8 = "Camera is already running, call unbindAll() before binding more cameras."
            java.lang.String r9 = "firstCameraConfig.cameraSelector"
            java.lang.String r14 = "DEFAULT"
            if (r5 == 0) goto L_0x0146
            int r5 = r16.getCameraOperatingMode()     // Catch:{ all -> 0x00fa }
            if (r5 == r2) goto L_0x0140
            androidx.lifecycle.LifecycleOwner r2 = r1.getLifecycleOwner()     // Catch:{ all -> 0x00fa }
            androidx.lifecycle.LifecycleOwner r5 = r4.getLifecycleOwner()     // Catch:{ all -> 0x00fa }
            boolean r2 = kotlin.jvm.internal.Intrinsics.a(r2, r5)     // Catch:{ all -> 0x00fa }
            if (r2 == 0) goto L_0x0138
            androidx.camera.core.UseCaseGroup r2 = r1.getUseCaseGroup()     // Catch:{ all -> 0x00fa }
            androidx.camera.core.ViewPort r2 = r2.getViewPort()     // Catch:{ all -> 0x00fa }
            androidx.camera.core.UseCaseGroup r5 = r4.getUseCaseGroup()     // Catch:{ all -> 0x00fa }
            androidx.camera.core.ViewPort r5 = r5.getViewPort()     // Catch:{ all -> 0x00fa }
            boolean r2 = kotlin.jvm.internal.Intrinsics.a(r2, r5)     // Catch:{ all -> 0x00fa }
            if (r2 == 0) goto L_0x0138
            androidx.camera.core.UseCaseGroup r2 = r1.getUseCaseGroup()     // Catch:{ all -> 0x00fa }
            java.util.List r2 = r2.getEffects()     // Catch:{ all -> 0x00fa }
            androidx.camera.core.UseCaseGroup r4 = r4.getUseCaseGroup()     // Catch:{ all -> 0x00fa }
            java.util.List r4 = r4.getEffects()     // Catch:{ all -> 0x00fa }
            boolean r2 = kotlin.jvm.internal.Intrinsics.a(r2, r4)     // Catch:{ all -> 0x00fa }
            if (r2 == 0) goto L_0x0138
            androidx.lifecycle.LifecycleOwner r2 = r1.getLifecycleOwner()     // Catch:{ all -> 0x00fa }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)     // Catch:{ all -> 0x00fa }
            androidx.camera.core.CameraSelector r4 = r1.getCameraSelector()     // Catch:{ all -> 0x00fa }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r9)     // Catch:{ all -> 0x00fa }
            androidx.camera.core.UseCaseGroup r5 = r1.getUseCaseGroup()     // Catch:{ all -> 0x00fa }
            androidx.camera.core.ViewPort r7 = r5.getViewPort()     // Catch:{ all -> 0x00fa }
            androidx.camera.core.UseCaseGroup r1 = r1.getUseCaseGroup()     // Catch:{ all -> 0x00fa }
            java.util.List r8 = r1.getEffects()     // Catch:{ all -> 0x00fa }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r6)     // Catch:{ all -> 0x00fa }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x00fa }
            r1.<init>()     // Catch:{ all -> 0x00fa }
            java.util.Iterator r0 = r17.iterator()     // Catch:{ all -> 0x00fa }
        L_0x00c0:
            boolean r5 = r0.hasNext()     // Catch:{ all -> 0x00fa }
            if (r5 == 0) goto L_0x010e
            java.lang.Object r5 = r0.next()     // Catch:{ all -> 0x00fa }
            androidx.camera.core.ConcurrentCamera$SingleCameraConfig r5 = (androidx.camera.core.ConcurrentCamera.SingleCameraConfig) r5     // Catch:{ all -> 0x00fa }
            kotlin.jvm.internal.Intrinsics.c(r5)     // Catch:{ all -> 0x00fa }
            androidx.camera.core.UseCaseGroup r6 = r5.getUseCaseGroup()     // Catch:{ all -> 0x00fa }
            java.util.List r6 = r6.getUseCases()     // Catch:{ all -> 0x00fa }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x00fa }
        L_0x00db:
            boolean r9 = r6.hasNext()     // Catch:{ all -> 0x00fa }
            if (r9 == 0) goto L_0x00fd
            java.lang.Object r9 = r6.next()     // Catch:{ all -> 0x00fa }
            java.lang.String r15 = "config!!.useCaseGroup.useCases"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r15)     // Catch:{ all -> 0x00fa }
            androidx.camera.core.UseCase r9 = (androidx.camera.core.UseCase) r9     // Catch:{ all -> 0x00fa }
            androidx.camera.core.CameraSelector r15 = r5.getCameraSelector()     // Catch:{ all -> 0x00fa }
            java.lang.String r15 = r15.getPhysicalCameraId()     // Catch:{ all -> 0x00fa }
            if (r15 == 0) goto L_0x00db
            r9.setPhysicalCameraId(r15)     // Catch:{ all -> 0x00fa }
            goto L_0x00db
        L_0x00fa:
            r0 = move-exception
            goto L_0x030c
        L_0x00fd:
            androidx.camera.core.UseCaseGroup r5 = r5.getUseCaseGroup()     // Catch:{ all -> 0x00fa }
            java.util.List r5 = r5.getUseCases()     // Catch:{ all -> 0x00fa }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r13)     // Catch:{ all -> 0x00fa }
            java.util.Collection r5 = (java.util.Collection) r5     // Catch:{ all -> 0x00fa }
            r1.addAll(r5)     // Catch:{ all -> 0x00fa }
            goto L_0x00c0
        L_0x010e:
            r10.setCameraOperatingMode(r3)     // Catch:{ all -> 0x00fa }
            androidx.camera.core.LayoutSettings r6 = androidx.camera.core.LayoutSettings.DEFAULT     // Catch:{ all -> 0x00fa }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r14)     // Catch:{ all -> 0x00fa }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r14)     // Catch:{ all -> 0x00fa }
            androidx.camera.core.UseCase[] r0 = new androidx.camera.core.UseCase[r11]     // Catch:{ all -> 0x00fa }
            java.lang.Object[] r0 = r1.toArray(r0)     // Catch:{ all -> 0x00fa }
            androidx.camera.core.UseCase[] r0 = (androidx.camera.core.UseCase[]) r0     // Catch:{ all -> 0x00fa }
            int r1 = r0.length     // Catch:{ all -> 0x00fa }
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r0, r1)     // Catch:{ all -> 0x00fa }
            r9 = r0
            androidx.camera.core.UseCase[] r9 = (androidx.camera.core.UseCase[]) r9     // Catch:{ all -> 0x00fa }
            r0 = 0
            r1 = r16
            r3 = r4
            r4 = r0
            r5 = r6
            androidx.camera.core.Camera r0 = r1.bindToLifecycle$camera_lifecycle_release(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00fa }
            r12.add(r0)     // Catch:{ all -> 0x00fa }
            goto L_0x02dd
        L_0x0138:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00fa }
            java.lang.String r1 = "Two camera configs need to have the same lifecycle owner, view port and effects."
            r0.<init>(r1)     // Catch:{ all -> 0x00fa }
            throw r0     // Catch:{ all -> 0x00fa }
        L_0x0140:
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException     // Catch:{ all -> 0x00fa }
            r0.<init>(r8)     // Catch:{ all -> 0x00fa }
            throw r0     // Catch:{ all -> 0x00fa }
        L_0x0146:
            android.content.Context r5 = r16.mContext     // Catch:{ all -> 0x00fa }
            kotlin.jvm.internal.Intrinsics.c(r5)     // Catch:{ all -> 0x00fa }
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch:{ all -> 0x00fa }
            java.lang.String r15 = "android.hardware.camera.concurrent"
            boolean r5 = r5.hasSystemFeature(r15)     // Catch:{ all -> 0x00fa }
            if (r5 == 0) goto L_0x02f4
            int r5 = r16.getCameraOperatingMode()     // Catch:{ all -> 0x00fa }
            if (r5 == r3) goto L_0x02ee
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ all -> 0x00fa }
            r15.<init>()     // Catch:{ all -> 0x00fa }
            androidx.camera.core.CameraSelector r5 = r1.getCameraSelector()     // Catch:{ IllegalArgumentException -> 0x02e6 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r9)     // Catch:{ IllegalArgumentException -> 0x02e6 }
            androidx.camera.core.CameraInfo r5 = r10.getCameraInfo(r5)     // Catch:{ IllegalArgumentException -> 0x02e6 }
            androidx.camera.core.CameraSelector r8 = r4.getCameraSelector()     // Catch:{ IllegalArgumentException -> 0x02e6 }
            java.lang.String r3 = "secondCameraConfig.cameraSelector"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r3)     // Catch:{ IllegalArgumentException -> 0x02e6 }
            androidx.camera.core.CameraInfo r3 = r10.getCameraInfo(r8)     // Catch:{ IllegalArgumentException -> 0x02e6 }
            r15.add(r5)     // Catch:{ all -> 0x00fa }
            r15.add(r3)     // Catch:{ all -> 0x00fa }
            java.util.List r3 = r16.getActiveConcurrentCameraInfos()     // Catch:{ all -> 0x00fa }
            java.util.Collection r3 = (java.util.Collection) r3     // Catch:{ all -> 0x00fa }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x00fa }
            if (r3 != 0) goto L_0x01a1
            java.util.List r3 = r16.getActiveConcurrentCameraInfos()     // Catch:{ all -> 0x00fa }
            boolean r3 = r15.equals(r3)     // Catch:{ all -> 0x00fa }
            if (r3 == 0) goto L_0x0199
            goto L_0x01a1
        L_0x0199:
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException     // Catch:{ all -> 0x00fa }
            java.lang.String r1 = "Cameras are already running, call unbindAll() before binding more cameras."
            r0.<init>(r1)     // Catch:{ all -> 0x00fa }
            throw r0     // Catch:{ all -> 0x00fa }
        L_0x01a1:
            r10.setCameraOperatingMode(r2)     // Catch:{ all -> 0x00fa }
            androidx.camera.core.UseCaseGroup r3 = r1.getUseCaseGroup()     // Catch:{ all -> 0x00fa }
            java.util.List r3 = r3.getUseCases()     // Catch:{ all -> 0x00fa }
            androidx.camera.core.UseCaseGroup r5 = r4.getUseCaseGroup()     // Catch:{ all -> 0x00fa }
            java.util.List r5 = r5.getUseCases()     // Catch:{ all -> 0x00fa }
            boolean r3 = java.util.Objects.equals(r3, r5)     // Catch:{ all -> 0x00fa }
            if (r3 == 0) goto L_0x026f
            androidx.camera.core.UseCaseGroup r3 = r1.getUseCaseGroup()     // Catch:{ all -> 0x00fa }
            java.util.List r3 = r3.getUseCases()     // Catch:{ all -> 0x00fa }
            int r3 = r3.size()     // Catch:{ all -> 0x00fa }
            if (r3 != r2) goto L_0x026f
            androidx.camera.core.UseCaseGroup r2 = r1.getUseCaseGroup()     // Catch:{ all -> 0x00fa }
            java.util.List r2 = r2.getUseCases()     // Catch:{ all -> 0x00fa }
            java.lang.Object r2 = r2.get(r11)     // Catch:{ all -> 0x00fa }
            androidx.camera.core.UseCase r2 = (androidx.camera.core.UseCase) r2     // Catch:{ all -> 0x00fa }
            androidx.camera.core.UseCaseGroup r3 = r1.getUseCaseGroup()     // Catch:{ all -> 0x00fa }
            java.util.List r3 = r3.getUseCases()     // Catch:{ all -> 0x00fa }
            r5 = 1
            java.lang.Object r3 = r3.get(r5)     // Catch:{ all -> 0x00fa }
            androidx.camera.core.UseCase r3 = (androidx.camera.core.UseCase) r3     // Catch:{ all -> 0x00fa }
            java.lang.String r5 = "useCase0"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)     // Catch:{ all -> 0x00fa }
            boolean r5 = r10.isVideoCapture(r2)     // Catch:{ all -> 0x00fa }
            java.lang.String r8 = "useCase1"
            if (r5 == 0) goto L_0x01fb
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r8)     // Catch:{ all -> 0x00fa }
            boolean r5 = r10.isPreview(r3)     // Catch:{ all -> 0x00fa }
            if (r5 != 0) goto L_0x020a
        L_0x01fb:
            boolean r2 = r10.isPreview(r2)     // Catch:{ all -> 0x00fa }
            if (r2 == 0) goto L_0x026f
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r8)     // Catch:{ all -> 0x00fa }
            boolean r2 = r10.isVideoCapture(r3)     // Catch:{ all -> 0x00fa }
            if (r2 == 0) goto L_0x026f
        L_0x020a:
            androidx.lifecycle.LifecycleOwner r2 = r1.getLifecycleOwner()     // Catch:{ all -> 0x00fa }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r7)     // Catch:{ all -> 0x00fa }
            androidx.camera.core.CameraSelector r3 = r1.getCameraSelector()     // Catch:{ all -> 0x00fa }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r9)     // Catch:{ all -> 0x00fa }
            androidx.camera.core.CameraSelector r0 = r4.getCameraSelector()     // Catch:{ all -> 0x00fa }
            androidx.camera.core.LayoutSettings r5 = r1.getLayoutSettings()     // Catch:{ all -> 0x00fa }
            java.lang.String r7 = "firstCameraConfig.layoutSettings"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r7)     // Catch:{ all -> 0x00fa }
            androidx.camera.core.LayoutSettings r7 = r4.getLayoutSettings()     // Catch:{ all -> 0x00fa }
            java.lang.String r4 = "secondCameraConfig.layoutSettings"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r4)     // Catch:{ all -> 0x00fa }
            androidx.camera.core.UseCaseGroup r4 = r1.getUseCaseGroup()     // Catch:{ all -> 0x00fa }
            androidx.camera.core.ViewPort r8 = r4.getViewPort()     // Catch:{ all -> 0x00fa }
            androidx.camera.core.UseCaseGroup r4 = r1.getUseCaseGroup()     // Catch:{ all -> 0x00fa }
            java.util.List r9 = r4.getEffects()     // Catch:{ all -> 0x00fa }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r6)     // Catch:{ all -> 0x00fa }
            androidx.camera.core.UseCaseGroup r1 = r1.getUseCaseGroup()     // Catch:{ all -> 0x00fa }
            java.util.List r1 = r1.getUseCases()     // Catch:{ all -> 0x00fa }
            java.lang.String r4 = "firstCameraConfig.useCaseGroup.useCases"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)     // Catch:{ all -> 0x00fa }
            java.util.Collection r1 = (java.util.Collection) r1     // Catch:{ all -> 0x00fa }
            androidx.camera.core.UseCase[] r4 = new androidx.camera.core.UseCase[r11]     // Catch:{ all -> 0x00fa }
            java.lang.Object[] r1 = r1.toArray(r4)     // Catch:{ all -> 0x00fa }
            androidx.camera.core.UseCase[] r1 = (androidx.camera.core.UseCase[]) r1     // Catch:{ all -> 0x00fa }
            int r4 = r1.length     // Catch:{ all -> 0x00fa }
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r4)     // Catch:{ all -> 0x00fa }
            r11 = r1
            androidx.camera.core.UseCase[] r11 = (androidx.camera.core.UseCase[]) r11     // Catch:{ all -> 0x00fa }
            r1 = r16
            r4 = r0
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r11
            androidx.camera.core.Camera r0 = r1.bindToLifecycle$camera_lifecycle_release(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00fa }
            r12.add(r0)     // Catch:{ all -> 0x00fa }
            goto L_0x02da
        L_0x026f:
            java.util.Iterator r0 = r17.iterator()     // Catch:{ all -> 0x00fa }
        L_0x0273:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x00fa }
            if (r1 == 0) goto L_0x02da
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x00fa }
            androidx.camera.core.ConcurrentCamera$SingleCameraConfig r1 = (androidx.camera.core.ConcurrentCamera.SingleCameraConfig) r1     // Catch:{ all -> 0x00fa }
            kotlin.jvm.internal.Intrinsics.c(r1)     // Catch:{ all -> 0x00fa }
            androidx.lifecycle.LifecycleOwner r2 = r1.getLifecycleOwner()     // Catch:{ all -> 0x00fa }
            java.lang.String r3 = "config!!.lifecycleOwner"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ all -> 0x00fa }
            androidx.camera.core.CameraSelector r3 = r1.getCameraSelector()     // Catch:{ all -> 0x00fa }
            java.lang.String r4 = "config.cameraSelector"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ all -> 0x00fa }
            androidx.camera.core.LayoutSettings r6 = androidx.camera.core.LayoutSettings.DEFAULT     // Catch:{ all -> 0x00fa }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r14)     // Catch:{ all -> 0x00fa }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r14)     // Catch:{ all -> 0x00fa }
            androidx.camera.core.UseCaseGroup r4 = r1.getUseCaseGroup()     // Catch:{ all -> 0x00fa }
            androidx.camera.core.ViewPort r7 = r4.getViewPort()     // Catch:{ all -> 0x00fa }
            androidx.camera.core.UseCaseGroup r4 = r1.getUseCaseGroup()     // Catch:{ all -> 0x00fa }
            java.util.List r8 = r4.getEffects()     // Catch:{ all -> 0x00fa }
            java.lang.String r4 = "config.useCaseGroup.effects"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r4)     // Catch:{ all -> 0x00fa }
            androidx.camera.core.UseCaseGroup r1 = r1.getUseCaseGroup()     // Catch:{ all -> 0x00fa }
            java.util.List r1 = r1.getUseCases()     // Catch:{ all -> 0x00fa }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r13)     // Catch:{ all -> 0x00fa }
            java.util.Collection r1 = (java.util.Collection) r1     // Catch:{ all -> 0x00fa }
            androidx.camera.core.UseCase[] r4 = new androidx.camera.core.UseCase[r11]     // Catch:{ all -> 0x00fa }
            java.lang.Object[] r1 = r1.toArray(r4)     // Catch:{ all -> 0x00fa }
            androidx.camera.core.UseCase[] r1 = (androidx.camera.core.UseCase[]) r1     // Catch:{ all -> 0x00fa }
            int r4 = r1.length     // Catch:{ all -> 0x00fa }
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r4)     // Catch:{ all -> 0x00fa }
            r9 = r1
            androidx.camera.core.UseCase[] r9 = (androidx.camera.core.UseCase[]) r9     // Catch:{ all -> 0x00fa }
            r4 = 0
            r1 = r16
            r5 = r6
            androidx.camera.core.Camera r1 = r1.bindToLifecycle$camera_lifecycle_release(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00fa }
            r12.add(r1)     // Catch:{ all -> 0x00fa }
            goto L_0x0273
        L_0x02da:
            r10.setActiveConcurrentCameraInfos(r15)     // Catch:{ all -> 0x00fa }
        L_0x02dd:
            androidx.camera.core.ConcurrentCamera r0 = new androidx.camera.core.ConcurrentCamera     // Catch:{ all -> 0x00fa }
            r0.<init>(r12)     // Catch:{ all -> 0x00fa }
            androidx.tracing.Trace.endSection()
            return r0
        L_0x02e6:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00fa }
            java.lang.String r1 = "Invalid camera selectors in camera configs."
            r0.<init>(r1)     // Catch:{ all -> 0x00fa }
            throw r0     // Catch:{ all -> 0x00fa }
        L_0x02ee:
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException     // Catch:{ all -> 0x00fa }
            r0.<init>(r8)     // Catch:{ all -> 0x00fa }
            throw r0     // Catch:{ all -> 0x00fa }
        L_0x02f4:
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException     // Catch:{ all -> 0x00fa }
            java.lang.String r1 = "Concurrent camera is not supported on the device."
            r0.<init>(r1)     // Catch:{ all -> 0x00fa }
            throw r0     // Catch:{ all -> 0x00fa }
        L_0x02fc:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00fa }
            java.lang.String r1 = "Concurrent camera is only supporting two cameras at maximum."
            r0.<init>(r1)     // Catch:{ all -> 0x00fa }
            throw r0     // Catch:{ all -> 0x00fa }
        L_0x0304:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00fa }
            java.lang.String r1 = "Concurrent camera needs two camera configs."
            r0.<init>(r1)     // Catch:{ all -> 0x00fa }
            throw r0     // Catch:{ all -> 0x00fa }
        L_0x030c:
            androidx.tracing.Trace.endSection()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.lifecycle.ProcessCameraProvider.bindToLifecycle(java.util.List):androidx.camera.core.ConcurrentCamera");
    }
}
