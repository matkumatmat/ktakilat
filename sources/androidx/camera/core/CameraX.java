package androidx.camera.core;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.annotation.GuardedBy;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.arch.core.util.Function;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.RetryPolicy;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.CameraRepository;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.MetadataHolderService;
import androidx.camera.core.impl.QuirkSettings;
import androidx.camera.core.impl.QuirkSettingsHolder;
import androidx.camera.core.impl.QuirkSettingsLoader;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.ContextUtil;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.os.HandlerCompat;
import androidx.core.util.Preconditions;
import androidx.tracing.Trace;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Executor;

@MainThread
@OptIn(markerClass = {ExperimentalRetryPolicy.class})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class CameraX {
    private static final Object MIN_LOG_LEVEL_LOCK = new Object();
    private static final String RETRY_TOKEN = "retry_token";
    private static final String TAG = "CameraX";
    @GuardedBy("MIN_LOG_LEVEL_LOCK")
    private static final SparseArray<Integer> sMinLogLevelReferenceCountMap = new SparseArray<>();
    private final Executor mCameraExecutor;
    private CameraFactory mCameraFactory;
    final CameraRepository mCameraRepository;
    private final CameraXConfig mCameraXConfig;
    private UseCaseConfigFactory mDefaultConfigFactory;
    private final ListenableFuture<Void> mInitInternalFuture;
    @GuardedBy("mInitializeLock")
    private InternalInitState mInitState;
    private final Object mInitializeLock;
    private final Integer mMinLogLevel;
    private final RetryPolicy mRetryPolicy;
    private final Handler mSchedulerHandler;
    @Nullable
    private final HandlerThread mSchedulerThread;
    @GuardedBy("mInitializeLock")
    private ListenableFuture<Void> mShutdownInternalFuture;
    private CameraDeviceSurfaceManager mSurfaceManager;

    public enum InternalInitState {
        UNINITIALIZED,
        INITIALIZING,
        INITIALIZING_ERROR,
        INITIALIZED,
        SHUTDOWN
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraX(@NonNull Context context, @Nullable CameraXConfig.Provider provider) {
        this(context, provider, new QuirkSettingsLoader());
    }

    private static void decreaseMinLogLevelReference(@Nullable Integer num) {
        synchronized (MIN_LOG_LEVEL_LOCK) {
            if (num == null) {
                try {
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                SparseArray<Integer> sparseArray = sMinLogLevelReferenceCountMap;
                int intValue = sparseArray.get(num.intValue()).intValue() - 1;
                if (intValue == 0) {
                    sparseArray.remove(num.intValue());
                } else {
                    sparseArray.put(num.intValue(), Integer.valueOf(intValue));
                }
                updateOrResetMinLogLevel();
            }
        }
    }

    @Nullable
    private static CameraXConfig.Provider getConfigProvider(@NonNull Context context) {
        String str;
        Application applicationFromContext = ContextUtil.getApplicationFromContext(context);
        if (applicationFromContext instanceof CameraXConfig.Provider) {
            return (CameraXConfig.Provider) applicationFromContext;
        }
        try {
            Context applicationContext = ContextUtil.getApplicationContext(context);
            Bundle bundle = applicationContext.getPackageManager().getServiceInfo(new ComponentName(applicationContext, MetadataHolderService.class), FaceEnvironment.VALUE_CROP_HEIGHT).metaData;
            if (bundle != null) {
                str = bundle.getString("androidx.camera.core.impl.MetadataHolderService.DEFAULT_CONFIG_PROVIDER");
            } else {
                str = null;
            }
            if (str != null) {
                return (CameraXConfig.Provider) Class.forName(str).getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
            }
            Logger.e(TAG, "No default CameraXConfig.Provider specified in meta-data. The most likely cause is you did not include a default implementation in your build such as 'camera-camera2'.");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            e = e;
            Logger.e(TAG, "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            return null;
        } catch (ClassNotFoundException e2) {
            e = e2;
            Logger.e(TAG, "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            return null;
        } catch (InstantiationException e3) {
            e = e3;
            Logger.e(TAG, "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            return null;
        } catch (InvocationTargetException e4) {
            e = e4;
            Logger.e(TAG, "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            return null;
        } catch (NoSuchMethodException e5) {
            e = e5;
            Logger.e(TAG, "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            return null;
        } catch (IllegalAccessException e6) {
            e = e6;
            Logger.e(TAG, "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            return null;
        } catch (NullPointerException e7) {
            e = e7;
            Logger.e(TAG, "Failed to retrieve default CameraXConfig.Provider from meta-data", e);
            return null;
        }
    }

    private static void increaseMinLogLevelReference(@Nullable Integer num) {
        synchronized (MIN_LOG_LEVEL_LOCK) {
            if (num == null) {
                try {
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                Preconditions.checkArgumentInRange(num.intValue(), 3, 6, "minLogLevel");
                SparseArray<Integer> sparseArray = sMinLogLevelReferenceCountMap;
                int i = 1;
                if (sparseArray.get(num.intValue()) != null) {
                    i = 1 + sparseArray.get(num.intValue()).intValue();
                }
                sparseArray.put(num.intValue(), Integer.valueOf(i));
                updateOrResetMinLogLevel();
            }
        }
    }

    private void initAndRetryRecursively(@NonNull Executor executor, long j, int i, @NonNull Context context, @NonNull CallbackToFutureAdapter.Completer<Void> completer) {
        executor.execute(new s2(this, context, executor, i, (CallbackToFutureAdapter.Completer) completer, j));
    }

    private ListenableFuture<Void> initInternal(@NonNull Context context) {
        boolean z;
        ListenableFuture<Void> future;
        synchronized (this.mInitializeLock) {
            if (this.mInitState == InternalInitState.UNINITIALIZED) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "CameraX.initInternal() should only be called once per instance");
            this.mInitState = InternalInitState.INITIALIZING;
            future = CallbackToFutureAdapter.getFuture(new t2(0, this, context));
        }
        return future;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initAndRetryRecursively$1(Executor executor, long j, int i, Context context, CallbackToFutureAdapter.Completer completer) {
        initAndRetryRecursively(executor, j, i + 1, context, completer);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e7 A[Catch:{ all -> 0x0075 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0121 A[Catch:{ all -> 0x0075 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void lambda$initAndRetryRecursively$2(android.content.Context r19, java.util.concurrent.Executor r20, int r21, androidx.concurrent.futures.CallbackToFutureAdapter.Completer r22, long r23) {
        /*
            r18 = this;
            r9 = r18
            r3 = r20
            r6 = r21
            r8 = r22
            r4 = r23
            java.lang.String r1 = "Device reporting less cameras than anticipated. On real devices: Retrying initialization might resolve temporary camera errors. On emulators: Ensure virtual camera configuration matches supported camera features as reported by PackageManager#hasSystemFeature. Available cameras: "
            java.lang.String r2 = "Retry init. Start time "
            java.lang.String r0 = "CX:initAndRetryRecursively"
            androidx.tracing.Trace.beginSection(r0)
            android.content.Context r7 = androidx.camera.core.impl.utils.ContextUtil.getApplicationContext(r19)
            r14 = 0
            androidx.camera.core.CameraXConfig r0 = r9.mCameraXConfig     // Catch:{ CameraIdListIncorrectException -> 0x00bc, InitializationException -> 0x00ba, RuntimeException -> 0x00b5 }
            androidx.camera.core.impl.CameraFactory$Provider r10 = r0.getCameraFactoryProvider(r14)     // Catch:{ CameraIdListIncorrectException -> 0x00bc, InitializationException -> 0x00ba, RuntimeException -> 0x00b5 }
            if (r10 == 0) goto L_0x00be
            java.util.concurrent.Executor r0 = r9.mCameraExecutor     // Catch:{ CameraIdListIncorrectException -> 0x00bc, InitializationException -> 0x00ba, RuntimeException -> 0x00b5 }
            android.os.Handler r11 = r9.mSchedulerHandler     // Catch:{ CameraIdListIncorrectException -> 0x00bc, InitializationException -> 0x00ba, RuntimeException -> 0x00b5 }
            androidx.camera.core.impl.CameraThreadConfig r12 = androidx.camera.core.impl.CameraThreadConfig.create(r0, r11)     // Catch:{ CameraIdListIncorrectException -> 0x00bc, InitializationException -> 0x00ba, RuntimeException -> 0x00b5 }
            androidx.camera.core.CameraXConfig r0 = r9.mCameraXConfig     // Catch:{ CameraIdListIncorrectException -> 0x00bc, InitializationException -> 0x00ba, RuntimeException -> 0x00b5 }
            androidx.camera.core.CameraSelector r0 = r0.getAvailableCamerasLimiter(r14)     // Catch:{ CameraIdListIncorrectException -> 0x00bc, InitializationException -> 0x00ba, RuntimeException -> 0x00b5 }
            androidx.camera.core.CameraXConfig r11 = r9.mCameraXConfig     // Catch:{ CameraIdListIncorrectException -> 0x00bc, InitializationException -> 0x00ba, RuntimeException -> 0x00b5 }
            long r15 = r11.getCameraOpenRetryMaxTimeoutInMillisWhileResuming()     // Catch:{ CameraIdListIncorrectException -> 0x00bc, InitializationException -> 0x00ba, RuntimeException -> 0x00b5 }
            r11 = r7
            r13 = r0
            r17 = r1
            r1 = r14
            r14 = r15
            androidx.camera.core.impl.CameraFactory r10 = r10.newInstance(r11, r12, r13, r14)     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            r9.mCameraFactory = r10     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            androidx.camera.core.CameraXConfig r10 = r9.mCameraXConfig     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            androidx.camera.core.impl.CameraDeviceSurfaceManager$Provider r10 = r10.getDeviceSurfaceManagerProvider(r1)     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            if (r10 == 0) goto L_0x00a8
            androidx.camera.core.impl.CameraFactory r11 = r9.mCameraFactory     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            java.lang.Object r11 = r11.getCameraManager()     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            androidx.camera.core.impl.CameraFactory r12 = r9.mCameraFactory     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            java.util.Set r12 = r12.getAvailableCameraIds()     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            androidx.camera.core.impl.CameraDeviceSurfaceManager r10 = r10.newInstance(r7, r11, r12)     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            r9.mSurfaceManager = r10     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            androidx.camera.core.CameraXConfig r10 = r9.mCameraXConfig     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            androidx.camera.core.impl.UseCaseConfigFactory$Provider r10 = r10.getUseCaseConfigFactoryProvider(r1)     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            if (r10 == 0) goto L_0x009b
            androidx.camera.core.impl.UseCaseConfigFactory r10 = r10.newInstance(r7)     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            r9.mDefaultConfigFactory = r10     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            boolean r10 = r3 instanceof androidx.camera.core.CameraExecutor     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            if (r10 == 0) goto L_0x007e
            r10 = r3
            androidx.camera.core.CameraExecutor r10 = (androidx.camera.core.CameraExecutor) r10     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            androidx.camera.core.impl.CameraFactory r11 = r9.mCameraFactory     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            r10.init(r11)     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            goto L_0x007e
        L_0x0075:
            r0 = move-exception
            goto L_0x017c
        L_0x0078:
            r0 = move-exception
            goto L_0x00ce
        L_0x007a:
            r0 = move-exception
            goto L_0x00ce
        L_0x007c:
            r0 = move-exception
            goto L_0x00ce
        L_0x007e:
            androidx.camera.core.impl.CameraRepository r10 = r9.mCameraRepository     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            androidx.camera.core.impl.CameraFactory r11 = r9.mCameraFactory     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            r10.init(r11)     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            androidx.camera.core.impl.CameraRepository r10 = r9.mCameraRepository     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            androidx.camera.core.impl.CameraValidator.validateCameras(r7, r10, r0)     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            r0 = 1
            if (r6 <= r0) goto L_0x0090
            r9.traceExecutionState(r1)     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
        L_0x0090:
            r18.setStateToInitialized()     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            r8.set(r1)     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
        L_0x0096:
            androidx.tracing.Trace.endSection()
            goto L_0x0178
        L_0x009b:
            androidx.camera.core.InitializationException r0 = new androidx.camera.core.InitializationException     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            java.lang.String r11 = "Invalid app configuration provided. Missing UseCaseConfigFactory."
            r10.<init>(r11)     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            r0.<init>((java.lang.Throwable) r10)     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            throw r0     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
        L_0x00a8:
            androidx.camera.core.InitializationException r0 = new androidx.camera.core.InitializationException     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            java.lang.String r11 = "Invalid app configuration provided. Missing CameraDeviceSurfaceManager."
            r10.<init>(r11)     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            r0.<init>((java.lang.Throwable) r10)     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            throw r0     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
        L_0x00b5:
            r0 = move-exception
        L_0x00b6:
            r17 = r1
            r1 = r14
            goto L_0x00ce
        L_0x00ba:
            r0 = move-exception
            goto L_0x00b6
        L_0x00bc:
            r0 = move-exception
            goto L_0x00b6
        L_0x00be:
            r17 = r1
            r1 = r14
            androidx.camera.core.InitializationException r0 = new androidx.camera.core.InitializationException     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            java.lang.String r11 = "Invalid app configuration provided. Missing CameraFactory."
            r10.<init>(r11)     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            r0.<init>((java.lang.Throwable) r10)     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
            throw r0     // Catch:{ CameraIdListIncorrectException -> 0x007c, InitializationException -> 0x007a, RuntimeException -> 0x0078 }
        L_0x00ce:
            androidx.camera.core.impl.CameraProviderExecutionState r10 = new androidx.camera.core.impl.CameraProviderExecutionState     // Catch:{ all -> 0x0075 }
            r10.<init>(r4, r6, r0)     // Catch:{ all -> 0x0075 }
            androidx.camera.core.RetryPolicy r11 = r9.mRetryPolicy     // Catch:{ all -> 0x0075 }
            androidx.camera.core.RetryPolicy$RetryConfig r11 = r11.onRetryDecisionRequested(r10)     // Catch:{ all -> 0x0075 }
            r9.traceExecutionState(r10)     // Catch:{ all -> 0x0075 }
            boolean r10 = r11.shouldRetry()     // Catch:{ all -> 0x0075 }
            if (r10 == 0) goto L_0x0121
            r10 = 2147483647(0x7fffffff, float:NaN)
            if (r6 >= r10) goto L_0x0121
            java.lang.String r1 = "CameraX"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0075 }
            r10.<init>(r2)     // Catch:{ all -> 0x0075 }
            r10.append(r4)     // Catch:{ all -> 0x0075 }
            java.lang.String r2 = " current time "
            r10.append(r2)     // Catch:{ all -> 0x0075 }
            long r12 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0075 }
            r10.append(r12)     // Catch:{ all -> 0x0075 }
            java.lang.String r2 = r10.toString()     // Catch:{ all -> 0x0075 }
            androidx.camera.core.Logger.w(r1, r2, r0)     // Catch:{ all -> 0x0075 }
            android.os.Handler r0 = r9.mSchedulerHandler     // Catch:{ all -> 0x0075 }
            s2 r10 = new s2     // Catch:{ all -> 0x0075 }
            r1 = r10
            r2 = r18
            r3 = r20
            r4 = r23
            r6 = r21
            r8 = r22
            r1.<init>((androidx.camera.core.CameraX) r2, (java.util.concurrent.Executor) r3, (long) r4, (int) r6, (android.content.Context) r7, (androidx.concurrent.futures.CallbackToFutureAdapter.Completer) r8)     // Catch:{ all -> 0x0075 }
            java.lang.String r1 = "retry_token"
            long r2 = r11.getRetryDelayInMillis()     // Catch:{ all -> 0x0075 }
            androidx.core.os.HandlerCompat.postDelayed(r0, r10, r1, r2)     // Catch:{ all -> 0x0075 }
            goto L_0x0096
        L_0x0121:
            java.lang.Object r2 = r9.mInitializeLock     // Catch:{ all -> 0x0075 }
            monitor-enter(r2)     // Catch:{ all -> 0x0075 }
            androidx.camera.core.CameraX$InternalInitState r3 = androidx.camera.core.CameraX.InternalInitState.INITIALIZING_ERROR     // Catch:{ all -> 0x0179 }
            r9.mInitState = r3     // Catch:{ all -> 0x0179 }
            monitor-exit(r2)     // Catch:{ all -> 0x0179 }
            boolean r2 = r11.shouldCompleteWithoutFailure()     // Catch:{ all -> 0x0075 }
            if (r2 == 0) goto L_0x0137
            r18.setStateToInitialized()     // Catch:{ all -> 0x0075 }
            r8.set(r1)     // Catch:{ all -> 0x0075 }
            goto L_0x0096
        L_0x0137:
            boolean r1 = r0 instanceof androidx.camera.core.impl.CameraValidator.CameraIdListIncorrectException     // Catch:{ all -> 0x0075 }
            if (r1 == 0) goto L_0x0165
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0075 }
            r2 = r17
            r1.<init>(r2)     // Catch:{ all -> 0x0075 }
            r2 = r0
            androidx.camera.core.impl.CameraValidator$CameraIdListIncorrectException r2 = (androidx.camera.core.impl.CameraValidator.CameraIdListIncorrectException) r2     // Catch:{ all -> 0x0075 }
            int r2 = r2.getAvailableCameraCount()     // Catch:{ all -> 0x0075 }
            r1.append(r2)     // Catch:{ all -> 0x0075 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0075 }
            java.lang.String r2 = "CameraX"
            androidx.camera.core.Logger.e(r2, r1, r0)     // Catch:{ all -> 0x0075 }
            androidx.camera.core.InitializationException r0 = new androidx.camera.core.InitializationException     // Catch:{ all -> 0x0075 }
            androidx.camera.core.CameraUnavailableException r2 = new androidx.camera.core.CameraUnavailableException     // Catch:{ all -> 0x0075 }
            r3 = 3
            r2.<init>((int) r3, (java.lang.String) r1)     // Catch:{ all -> 0x0075 }
            r0.<init>((java.lang.Throwable) r2)     // Catch:{ all -> 0x0075 }
            r8.setException(r0)     // Catch:{ all -> 0x0075 }
            goto L_0x0096
        L_0x0165:
            boolean r1 = r0 instanceof androidx.camera.core.InitializationException     // Catch:{ all -> 0x0075 }
            if (r1 == 0) goto L_0x016e
            r8.setException(r0)     // Catch:{ all -> 0x0075 }
            goto L_0x0096
        L_0x016e:
            androidx.camera.core.InitializationException r1 = new androidx.camera.core.InitializationException     // Catch:{ all -> 0x0075 }
            r1.<init>((java.lang.Throwable) r0)     // Catch:{ all -> 0x0075 }
            r8.setException(r1)     // Catch:{ all -> 0x0075 }
            goto L_0x0096
        L_0x0178:
            return
        L_0x0179:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0179 }
            throw r0     // Catch:{ all -> 0x0075 }
        L_0x017c:
            androidx.tracing.Trace.endSection()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.CameraX.lambda$initAndRetryRecursively$2(android.content.Context, java.util.concurrent.Executor, int, androidx.concurrent.futures.CallbackToFutureAdapter$Completer, long):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$initInternal$0(Context context, CallbackToFutureAdapter.Completer completer) throws Exception {
        initAndRetryRecursively(this.mCameraExecutor, SystemClock.elapsedRealtime(), 1, context, completer);
        return "CameraX initInternal";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$shutdownInternal$3(CallbackToFutureAdapter.Completer completer) {
        if (this.mSchedulerThread != null) {
            Executor executor = this.mCameraExecutor;
            if (executor instanceof CameraExecutor) {
                ((CameraExecutor) executor).deinit();
            }
            this.mSchedulerThread.quit();
        }
        completer.set(null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$shutdownInternal$4(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mCameraRepository.deinit().addListener(new e0(10, this, completer), this.mCameraExecutor);
        return "CameraX shutdownInternal";
    }

    private void setStateToInitialized() {
        synchronized (this.mInitializeLock) {
            this.mInitState = InternalInitState.INITIALIZED;
        }
    }

    @NonNull
    private ListenableFuture<Void> shutdownInternal() {
        synchronized (this.mInitializeLock) {
            try {
                this.mSchedulerHandler.removeCallbacksAndMessages(RETRY_TOKEN);
                int ordinal = this.mInitState.ordinal();
                if (ordinal == 0) {
                    this.mInitState = InternalInitState.SHUTDOWN;
                    ListenableFuture<Void> immediateFuture = Futures.immediateFuture(null);
                    return immediateFuture;
                } else if (ordinal != 1) {
                    if (ordinal == 2 || ordinal == 3) {
                        this.mInitState = InternalInitState.SHUTDOWN;
                        decreaseMinLogLevelReference(this.mMinLogLevel);
                        this.mShutdownInternalFuture = CallbackToFutureAdapter.getFuture(new k0(this, 9));
                    }
                    ListenableFuture<Void> listenableFuture = this.mShutdownInternalFuture;
                    return listenableFuture;
                } else {
                    throw new IllegalStateException("CameraX could not be shutdown when it is initializing.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void traceExecutionState(@Nullable RetryPolicy.ExecutionState executionState) {
        int i;
        if (Trace.isEnabled()) {
            if (executionState != null) {
                i = executionState.getStatus();
            } else {
                i = -1;
            }
            Trace.setCounter("CX:CameraProvider-RetryStatus", i);
        }
    }

    @GuardedBy("MIN_LOG_LEVEL_LOCK")
    private static void updateOrResetMinLogLevel() {
        SparseArray<Integer> sparseArray = sMinLogLevelReferenceCountMap;
        if (sparseArray.size() == 0) {
            Logger.resetMinLogLevel();
        } else if (sparseArray.get(3) != null) {
            Logger.setMinLogLevel(3);
        } else if (sparseArray.get(4) != null) {
            Logger.setMinLogLevel(4);
        } else if (sparseArray.get(5) != null) {
            Logger.setMinLogLevel(5);
        } else if (sparseArray.get(6) != null) {
            Logger.setMinLogLevel(6);
        }
    }

    private static void updateQuirkSettings(@NonNull Context context, @Nullable QuirkSettings quirkSettings, @NonNull Function<Context, QuirkSettings> function) {
        if (quirkSettings != null) {
            Logger.d(TAG, "QuirkSettings from CameraXConfig: " + quirkSettings);
        } else {
            quirkSettings = function.apply(context);
            Logger.d(TAG, "QuirkSettings from app metadata: " + quirkSettings);
        }
        if (quirkSettings == null) {
            quirkSettings = QuirkSettingsHolder.DEFAULT;
            Logger.d(TAG, "QuirkSettings by default: " + quirkSettings);
        }
        QuirkSettingsHolder.instance().set(quirkSettings);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraDeviceSurfaceManager getCameraDeviceSurfaceManager() {
        CameraDeviceSurfaceManager cameraDeviceSurfaceManager = this.mSurfaceManager;
        if (cameraDeviceSurfaceManager != null) {
            return cameraDeviceSurfaceManager;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraFactory getCameraFactory() {
        CameraFactory cameraFactory = this.mCameraFactory;
        if (cameraFactory != null) {
            return cameraFactory;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraRepository getCameraRepository() {
        return this.mCameraRepository;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public UseCaseConfigFactory getDefaultConfigFactory() {
        UseCaseConfigFactory useCaseConfigFactory = this.mDefaultConfigFactory;
        if (useCaseConfigFactory != null) {
            return useCaseConfigFactory;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ListenableFuture<Void> getInitializeFuture() {
        return this.mInitInternalFuture;
    }

    public boolean isInitialized() {
        boolean z;
        synchronized (this.mInitializeLock) {
            if (this.mInitState == InternalInitState.INITIALIZED) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ListenableFuture<Void> shutdown() {
        return shutdownInternal();
    }

    @VisibleForTesting
    public CameraX(@NonNull Context context, @Nullable CameraXConfig.Provider provider, @NonNull Function<Context, QuirkSettings> function) {
        this.mCameraRepository = new CameraRepository();
        this.mInitializeLock = new Object();
        this.mInitState = InternalInitState.UNINITIALIZED;
        this.mShutdownInternalFuture = Futures.immediateFuture(null);
        if (provider != null) {
            this.mCameraXConfig = provider.getCameraXConfig();
        } else {
            CameraXConfig.Provider configProvider = getConfigProvider(context);
            if (configProvider != null) {
                this.mCameraXConfig = configProvider.getCameraXConfig();
            } else {
                throw new IllegalStateException("CameraX is not configured properly. The most likely cause is you did not include a default implementation in your build such as 'camera-camera2'.");
            }
        }
        updateQuirkSettings(context, this.mCameraXConfig.getQuirkSettings(), function);
        Executor cameraExecutor = this.mCameraXConfig.getCameraExecutor((Executor) null);
        Handler schedulerHandler = this.mCameraXConfig.getSchedulerHandler((Handler) null);
        this.mCameraExecutor = cameraExecutor == null ? new CameraExecutor() : cameraExecutor;
        if (schedulerHandler == null) {
            HandlerThread handlerThread = new HandlerThread("CameraX-scheduler", 10);
            this.mSchedulerThread = handlerThread;
            handlerThread.start();
            this.mSchedulerHandler = HandlerCompat.createAsync(handlerThread.getLooper());
        } else {
            this.mSchedulerThread = null;
            this.mSchedulerHandler = schedulerHandler;
        }
        CameraXConfig cameraXConfig = this.mCameraXConfig;
        Config.Option<Integer> option = CameraXConfig.OPTION_MIN_LOGGING_LEVEL;
        cameraXConfig.getClass();
        Integer num = (Integer) ld.g(cameraXConfig, option, (Object) null);
        this.mMinLogLevel = num;
        increaseMinLogLevelReference(num);
        this.mRetryPolicy = new RetryPolicy.Builder(this.mCameraXConfig.getCameraProviderInitRetryPolicy()).build();
        this.mInitInternalFuture = initInternal(context);
    }
}
