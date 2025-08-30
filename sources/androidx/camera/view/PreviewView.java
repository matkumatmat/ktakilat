package androidx.camera.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Rational;
import android.util.Size;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.AnyThread;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.ViewPort;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.view.impl.ZoomGestureDetector;
import androidx.camera.view.internal.ScreenFlashUiInfo;
import androidx.camera.view.internal.compat.quirk.DeviceQuirks;
import androidx.camera.view.internal.compat.quirk.SurfaceViewNotCroppedByParentQuirk;
import androidx.camera.view.internal.compat.quirk.SurfaceViewStretchedQuirk;
import androidx.camera.view.transform.OutputTransform;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public final class PreviewView extends FrameLayout {
    @ColorRes
    static final int DEFAULT_BACKGROUND_COLOR = 17170444;
    private static final ImplementationMode DEFAULT_IMPL_MODE = ImplementationMode.PERFORMANCE;
    private static final String TAG = "PreviewView";
    @Nullable
    final AtomicReference<PreviewStreamStateObserver> mActiveStreamStateObserver;
    CameraController mCameraController;
    @Nullable
    CameraInfoInternal mCameraInfoInternal;
    @NonNull
    private final DisplayRotationListener mDisplayRotationListener;
    @VisibleForTesting
    @Nullable
    PreviewViewImplementation mImplementation;
    @NonNull
    ImplementationMode mImplementationMode;
    @Nullable
    OnFrameUpdateListener mOnFrameUpdateListener;
    @Nullable
    Executor mOnFrameUpdateListenerExecutor;
    private final View.OnLayoutChangeListener mOnLayoutChangeListener;
    @NonNull
    final MutableLiveData<StreamState> mPreviewStreamStateLiveData;
    @NonNull
    final PreviewTransformation mPreviewTransform;
    @NonNull
    PreviewViewMeteringPointFactory mPreviewViewMeteringPointFactory;
    @NonNull
    final ScreenFlashView mScreenFlashView;
    final Preview.SurfaceProvider mSurfaceProvider;
    @Nullable
    private MotionEvent mTouchUpEvent;
    boolean mUseDisplayRotation;
    @NonNull
    private final ZoomGestureDetector mZoomGestureDetector;

    public class DisplayRotationListener implements DisplayManager.DisplayListener {
        public DisplayRotationListener() {
        }

        public void onDisplayAdded(int i) {
        }

        public void onDisplayChanged(int i) {
            Display display = PreviewView.this.getDisplay();
            if (display != null && display.getDisplayId() == i) {
                PreviewView.this.redrawPreview();
            }
        }

        public void onDisplayRemoved(int i) {
        }
    }

    public enum ImplementationMode {
        PERFORMANCE(0),
        COMPATIBLE(1);
        
        private final int mId;

        private ImplementationMode(int i) {
            this.mId = i;
        }

        public static ImplementationMode fromId(int i) {
            for (ImplementationMode implementationMode : values()) {
                if (implementationMode.mId == i) {
                    return implementationMode;
                }
            }
            throw new IllegalArgumentException(ba.k(i, "Unknown implementation mode id "));
        }

        public int getId() {
            return this.mId;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface OnFrameUpdateListener {
        void onFrameUpdate(long j);
    }

    public enum ScaleType {
        FILL_START(0),
        FILL_CENTER(1),
        FILL_END(2),
        FIT_START(3),
        FIT_CENTER(4),
        FIT_END(5);
        
        private final int mId;

        private ScaleType(int i) {
            this.mId = i;
        }

        public static ScaleType fromId(int i) {
            for (ScaleType scaleType : values()) {
                if (scaleType.mId == i) {
                    return scaleType;
                }
            }
            throw new IllegalArgumentException(ba.k(i, "Unknown scale type id "));
        }

        public int getId() {
            return this.mId;
        }
    }

    public enum StreamState {
        IDLE,
        STREAMING
    }

    @UiThread
    public PreviewView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    @MainThread
    private void attachToControllerIfReady(boolean z) {
        Threads.checkMainThread();
        ViewPort viewPort = getViewPort();
        if (this.mCameraController != null && viewPort != null && isAttachedToWindow()) {
            try {
                this.mCameraController.attachPreviewSurface(getSurfaceProvider(), viewPort);
            } catch (IllegalStateException e) {
                if (z) {
                    Logger.e(TAG, e.toString(), e);
                    return;
                }
                throw e;
            }
        }
    }

    @Nullable
    private DisplayManager getDisplayManager() {
        Context context = getContext();
        if (context == null) {
            return null;
        }
        return (DisplayManager) context.getApplicationContext().getSystemService("display");
    }

    @UiThread
    @Nullable
    private ImageCapture.ScreenFlash getScreenFlashInternal() {
        return this.mScreenFlashView.getScreenFlash();
    }

    private int getViewPortScaleType() {
        int ordinal = getScaleType().ordinal();
        if (ordinal == 0) {
            return 0;
        }
        int i = 1;
        if (ordinal != 1) {
            i = 2;
            if (ordinal != 2) {
                i = 3;
                if (!(ordinal == 3 || ordinal == 4 || ordinal == 5)) {
                    throw new IllegalStateException("Unexpected scale type: " + getScaleType());
                }
            }
        }
        return i;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i3 - i != i7 - i5 || i4 - i2 != i8 - i6) {
            redrawPreview();
            attachToControllerIfReady(true);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$1(ZoomGestureDetector.ZoomEvent zoomEvent) {
        CameraController cameraController;
        if (!(zoomEvent instanceof ZoomGestureDetector.ZoomEvent.Move) || (cameraController = this.mCameraController) == null) {
            return true;
        }
        cameraController.onPinchToZoom(((ZoomGestureDetector.ZoomEvent.Move) zoomEvent).getIncrementalScaleFactor());
        return true;
    }

    private void setScreenFlashUiInfo(ImageCapture.ScreenFlash screenFlash) {
        CameraController cameraController = this.mCameraController;
        if (cameraController == null) {
            Logger.d(TAG, "setScreenFlashUiInfo: mCameraController is null!");
        } else {
            cameraController.setScreenFlashUiInfo(new ScreenFlashUiInfo(ScreenFlashUiInfo.ProviderType.PREVIEW_VIEW, screenFlash));
        }
    }

    @VisibleForTesting
    public static boolean shouldReuseImplementation(@Nullable PreviewViewImplementation previewViewImplementation, @NonNull SurfaceRequest surfaceRequest, @NonNull ImplementationMode implementationMode) {
        if (!(previewViewImplementation instanceof SurfaceViewImplementation) || shouldUseTextureView(surfaceRequest, implementationMode)) {
            return false;
        }
        return true;
    }

    public static boolean shouldUseTextureView(@NonNull SurfaceRequest surfaceRequest, @NonNull ImplementationMode implementationMode) {
        boolean z;
        boolean equals = surfaceRequest.getCamera().getCameraInfoInternal().getImplementationType().equals(CameraInfo.IMPLEMENTATION_TYPE_CAMERA2_LEGACY);
        if (DeviceQuirks.get(SurfaceViewStretchedQuirk.class) == null && DeviceQuirks.get(SurfaceViewNotCroppedByParentQuirk.class) == null) {
            z = false;
        } else {
            z = true;
        }
        if (Build.VERSION.SDK_INT <= 24 || equals || z) {
            return true;
        }
        int ordinal = implementationMode.ordinal();
        if (ordinal == 0) {
            return false;
        }
        if (ordinal == 1) {
            return true;
        }
        throw new IllegalArgumentException("Invalid implementation mode: " + implementationMode);
    }

    private void startListeningToDisplayChange() {
        DisplayManager displayManager = getDisplayManager();
        if (displayManager != null) {
            displayManager.registerDisplayListener(this.mDisplayRotationListener, new Handler(Looper.getMainLooper()));
        }
    }

    private void stopListeningToDisplayChange() {
        DisplayManager displayManager = getDisplayManager();
        if (displayManager != null) {
            displayManager.unregisterDisplayListener(this.mDisplayRotationListener);
        }
    }

    @UiThread
    @Nullable
    public Bitmap getBitmap() {
        Threads.checkMainThread();
        PreviewViewImplementation previewViewImplementation = this.mImplementation;
        if (previewViewImplementation == null) {
            return null;
        }
        return previewViewImplementation.getBitmap();
    }

    @UiThread
    @Nullable
    public CameraController getController() {
        Threads.checkMainThread();
        return this.mCameraController;
    }

    @UiThread
    @NonNull
    public ImplementationMode getImplementationMode() {
        Threads.checkMainThread();
        return this.mImplementationMode;
    }

    @UiThread
    @NonNull
    public MeteringPointFactory getMeteringPointFactory() {
        Threads.checkMainThread();
        return this.mPreviewViewMeteringPointFactory;
    }

    @TransformExperimental
    @Nullable
    public OutputTransform getOutputTransform() {
        Matrix matrix;
        Threads.checkMainThread();
        try {
            matrix = this.mPreviewTransform.getSurfaceToPreviewViewMatrix(new Size(getWidth(), getHeight()), getLayoutDirection());
        } catch (IllegalStateException unused) {
            matrix = null;
        }
        Rect surfaceCropRect = this.mPreviewTransform.getSurfaceCropRect();
        if (matrix == null || surfaceCropRect == null) {
            Logger.d(TAG, "Transform info is not ready");
            return null;
        }
        matrix.preConcat(TransformUtils.getNormalizedToBuffer(surfaceCropRect));
        if (this.mImplementation instanceof TextureViewImplementation) {
            matrix.postConcat(getMatrix());
        } else if (!getMatrix().isIdentity()) {
            Logger.w(TAG, "PreviewView needs to be in COMPATIBLE mode for the transform to work correctly.");
        }
        return new OutputTransform(matrix, new Size(surfaceCropRect.width(), surfaceCropRect.height()));
    }

    @NonNull
    public LiveData<StreamState> getPreviewStreamState() {
        return this.mPreviewStreamStateLiveData;
    }

    @UiThread
    @NonNull
    public ScaleType getScaleType() {
        Threads.checkMainThread();
        return this.mPreviewTransform.getScaleType();
    }

    @UiThread
    @ExperimentalPreviewViewScreenFlash
    @Nullable
    public ImageCapture.ScreenFlash getScreenFlash() {
        return getScreenFlashInternal();
    }

    @UiThread
    @Nullable
    public Matrix getSensorToViewTransform() {
        Threads.checkMainThread();
        if (getWidth() == 0 || getHeight() == 0) {
            return null;
        }
        return this.mPreviewTransform.getSensorToViewTransform(new Size(getWidth(), getHeight()), getLayoutDirection());
    }

    @UiThread
    @NonNull
    public Preview.SurfaceProvider getSurfaceProvider() {
        Threads.checkMainThread();
        return this.mSurfaceProvider;
    }

    @UiThread
    @Nullable
    public ViewPort getViewPort() {
        Threads.checkMainThread();
        if (getDisplay() == null) {
            return null;
        }
        return getViewPort(getDisplay().getRotation());
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        startListeningToDisplayChange();
        addOnLayoutChangeListener(this.mOnLayoutChangeListener);
        PreviewViewImplementation previewViewImplementation = this.mImplementation;
        if (previewViewImplementation != null) {
            previewViewImplementation.onAttachedToWindow();
        }
        attachToControllerIfReady(true);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeOnLayoutChangeListener(this.mOnLayoutChangeListener);
        PreviewViewImplementation previewViewImplementation = this.mImplementation;
        if (previewViewImplementation != null) {
            previewViewImplementation.onDetachedFromWindow();
        }
        CameraController cameraController = this.mCameraController;
        if (cameraController != null) {
            cameraController.clearPreviewSurface();
        }
        stopListeningToDisplayChange();
    }

    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        if (this.mCameraController == null) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getPointerCount() == 1) {
            z = true;
        } else {
            z = false;
        }
        if (motionEvent.getAction() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (motionEvent.getEventTime() - motionEvent.getDownTime() < ((long) ViewConfiguration.getLongPressTimeout())) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z && z2 && z3) {
            this.mTouchUpEvent = motionEvent;
            performClick();
            return true;
        } else if (this.mZoomGestureDetector.onTouchEvent(motionEvent) || super.onTouchEvent(motionEvent)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean performClick() {
        float f;
        float f2;
        if (this.mCameraController != null) {
            MotionEvent motionEvent = this.mTouchUpEvent;
            if (motionEvent != null) {
                f = motionEvent.getX();
            } else {
                f = ((float) getWidth()) / 2.0f;
            }
            MotionEvent motionEvent2 = this.mTouchUpEvent;
            if (motionEvent2 != null) {
                f2 = motionEvent2.getY();
            } else {
                f2 = ((float) getHeight()) / 2.0f;
            }
            this.mCameraController.onTapToFocus(this.mPreviewViewMeteringPointFactory, f, f2);
        }
        this.mTouchUpEvent = null;
        return super.performClick();
    }

    @MainThread
    @OptIn(markerClass = {TransformExperimental.class})
    public void redrawPreview() {
        Threads.checkMainThread();
        if (this.mImplementation != null) {
            updateDisplayRotationIfNeeded();
            this.mImplementation.redrawPreview();
        }
        this.mPreviewViewMeteringPointFactory.recalculate(new Size(getWidth(), getHeight()), getLayoutDirection());
        CameraController cameraController = this.mCameraController;
        if (cameraController != null) {
            cameraController.updatePreviewViewTransform(getSensorToViewTransform());
        }
    }

    @UiThread
    public void setController(@Nullable CameraController cameraController) {
        Threads.checkMainThread();
        CameraController cameraController2 = this.mCameraController;
        if (!(cameraController2 == null || cameraController2 == cameraController)) {
            cameraController2.clearPreviewSurface();
            setScreenFlashUiInfo((ImageCapture.ScreenFlash) null);
        }
        this.mCameraController = cameraController;
        attachToControllerIfReady(false);
        setScreenFlashUiInfo(getScreenFlashInternal());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setFrameUpdateListener(@NonNull Executor executor, @NonNull OnFrameUpdateListener onFrameUpdateListener) {
        if (this.mImplementationMode != ImplementationMode.PERFORMANCE) {
            this.mOnFrameUpdateListener = onFrameUpdateListener;
            this.mOnFrameUpdateListenerExecutor = executor;
            PreviewViewImplementation previewViewImplementation = this.mImplementation;
            if (previewViewImplementation != null) {
                previewViewImplementation.setFrameUpdateListener(executor, onFrameUpdateListener);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("PERFORMANCE mode doesn't support frame update listener");
    }

    @UiThread
    public void setImplementationMode(@NonNull ImplementationMode implementationMode) {
        Threads.checkMainThread();
        this.mImplementationMode = implementationMode;
        if (implementationMode == ImplementationMode.PERFORMANCE && this.mOnFrameUpdateListener != null) {
            throw new IllegalArgumentException("PERFORMANCE mode doesn't support frame update listener");
        }
    }

    @UiThread
    public void setScaleType(@NonNull ScaleType scaleType) {
        Threads.checkMainThread();
        this.mPreviewTransform.setScaleType(scaleType);
        redrawPreview();
        attachToControllerIfReady(false);
    }

    @ExperimentalPreviewViewScreenFlash
    public void setScreenFlashOverlayColor(@ColorInt int i) {
        this.mScreenFlashView.setBackgroundColor(i);
    }

    @UiThread
    public void setScreenFlashWindow(@Nullable Window window) {
        Threads.checkMainThread();
        this.mScreenFlashView.setScreenFlashWindow(window);
        setScreenFlashUiInfo(getScreenFlashInternal());
    }

    public void updateDisplayRotationIfNeeded() {
        Display display;
        CameraInfoInternal cameraInfoInternal;
        if (this.mUseDisplayRotation && (display = getDisplay()) != null && (cameraInfoInternal = this.mCameraInfoInternal) != null) {
            this.mPreviewTransform.overrideWithDisplayRotation(cameraInfoInternal.getSensorRotationDegrees(display.getRotation()), display.getRotation());
        }
    }

    @UiThread
    public PreviewView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @UiThread
    public PreviewView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    /* JADX INFO: finally extract failed */
    @UiThread
    public PreviewView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        ImplementationMode implementationMode = DEFAULT_IMPL_MODE;
        this.mImplementationMode = implementationMode;
        PreviewTransformation previewTransformation = new PreviewTransformation();
        this.mPreviewTransform = previewTransformation;
        this.mUseDisplayRotation = true;
        this.mPreviewStreamStateLiveData = new MutableLiveData<>(StreamState.IDLE);
        this.mActiveStreamStateObserver = new AtomicReference<>();
        this.mPreviewViewMeteringPointFactory = new PreviewViewMeteringPointFactory(previewTransformation);
        this.mDisplayRotationListener = new DisplayRotationListener();
        this.mOnLayoutChangeListener = new fd(this);
        this.mSurfaceProvider = new Preview.SurfaceProvider() {
            /* access modifiers changed from: private */
            public /* synthetic */ void lambda$onSurfaceRequested$0(SurfaceRequest surfaceRequest) {
                PreviewView.this.mSurfaceProvider.onSurfaceRequested(surfaceRequest);
            }

            /* access modifiers changed from: private */
            /* JADX WARNING: Code restructure failed: missing block: B:6:0x0034, code lost:
                r4 = r3.this$0;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public /* synthetic */ void lambda$onSurfaceRequested$1(androidx.camera.core.impl.CameraInternal r4, androidx.camera.core.SurfaceRequest r5, androidx.camera.core.SurfaceRequest.TransformationInfo r6) {
                /*
                    r3 = this;
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    java.lang.String r1 = "Preview transformation info updated. "
                    r0.<init>(r1)
                    r0.append(r6)
                    java.lang.String r0 = r0.toString()
                    java.lang.String r1 = "PreviewView"
                    androidx.camera.core.Logger.d(r1, r0)
                    androidx.camera.core.impl.CameraInfoInternal r4 = r4.getCameraInfoInternal()
                    int r4 = r4.getLensFacing()
                    r0 = 0
                    r1 = 1
                    if (r4 != 0) goto L_0x0021
                    r4 = 1
                    goto L_0x0022
                L_0x0021:
                    r4 = 0
                L_0x0022:
                    androidx.camera.view.PreviewView r2 = androidx.camera.view.PreviewView.this
                    androidx.camera.view.PreviewTransformation r2 = r2.mPreviewTransform
                    android.util.Size r5 = r5.getResolution()
                    r2.setTransformationInfo(r6, r5, r4)
                    int r4 = r6.getTargetRotation()
                    r5 = -1
                    if (r4 == r5) goto L_0x0042
                    androidx.camera.view.PreviewView r4 = androidx.camera.view.PreviewView.this
                    androidx.camera.view.PreviewViewImplementation r5 = r4.mImplementation
                    if (r5 == 0) goto L_0x003f
                    boolean r5 = r5 instanceof androidx.camera.view.SurfaceViewImplementation
                    if (r5 == 0) goto L_0x003f
                    goto L_0x0042
                L_0x003f:
                    r4.mUseDisplayRotation = r0
                    goto L_0x0046
                L_0x0042:
                    androidx.camera.view.PreviewView r4 = androidx.camera.view.PreviewView.this
                    r4.mUseDisplayRotation = r1
                L_0x0046:
                    androidx.camera.view.PreviewView r4 = androidx.camera.view.PreviewView.this
                    r4.redrawPreview()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.camera.view.PreviewView.AnonymousClass1.lambda$onSurfaceRequested$1(androidx.camera.core.impl.CameraInternal, androidx.camera.core.SurfaceRequest, androidx.camera.core.SurfaceRequest$TransformationInfo):void");
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void lambda$onSurfaceRequested$2(PreviewStreamStateObserver previewStreamStateObserver, CameraInternal cameraInternal) {
                AtomicReference<PreviewStreamStateObserver> atomicReference = PreviewView.this.mActiveStreamStateObserver;
                while (true) {
                    if (!atomicReference.compareAndSet(previewStreamStateObserver, (Object) null)) {
                        if (atomicReference.get() != previewStreamStateObserver) {
                            break;
                        }
                    } else {
                        previewStreamStateObserver.updatePreviewStreamState(StreamState.IDLE);
                        break;
                    }
                }
                previewStreamStateObserver.clear();
                cameraInternal.getCameraState().removeObserver(previewStreamStateObserver);
            }

            @AnyThread
            public void onSurfaceRequested(@NonNull SurfaceRequest surfaceRequest) {
                Executor executor;
                PreviewViewImplementation previewViewImplementation;
                if (!Threads.isMainThread()) {
                    ContextCompat.getMainExecutor(PreviewView.this.getContext()).execute(new h(0, this, surfaceRequest));
                    return;
                }
                Logger.d(PreviewView.TAG, "Surface requested by Preview.");
                CameraInternal camera = surfaceRequest.getCamera();
                PreviewView.this.mCameraInfoInternal = camera.getCameraInfoInternal();
                PreviewView.this.mPreviewViewMeteringPointFactory.setSensorRect(camera.getCameraControlInternal().getSensorRect());
                surfaceRequest.setTransformationInfoListener(ContextCompat.getMainExecutor(PreviewView.this.getContext()), new f((Object) this, (Object) camera, (Object) surfaceRequest));
                PreviewView previewView = PreviewView.this;
                if (!PreviewView.shouldReuseImplementation(previewView.mImplementation, surfaceRequest, previewView.mImplementationMode)) {
                    PreviewView previewView2 = PreviewView.this;
                    if (PreviewView.shouldUseTextureView(surfaceRequest, previewView2.mImplementationMode)) {
                        PreviewView previewView3 = PreviewView.this;
                        previewViewImplementation = new TextureViewImplementation(previewView3, previewView3.mPreviewTransform);
                    } else {
                        PreviewView previewView4 = PreviewView.this;
                        previewViewImplementation = new SurfaceViewImplementation(previewView4, previewView4.mPreviewTransform);
                    }
                    previewView2.mImplementation = previewViewImplementation;
                }
                CameraInfoInternal cameraInfoInternal = camera.getCameraInfoInternal();
                PreviewView previewView5 = PreviewView.this;
                PreviewStreamStateObserver previewStreamStateObserver = new PreviewStreamStateObserver(cameraInfoInternal, previewView5.mPreviewStreamStateLiveData, previewView5.mImplementation);
                PreviewView.this.mActiveStreamStateObserver.set(previewStreamStateObserver);
                camera.getCameraState().addObserver(ContextCompat.getMainExecutor(PreviewView.this.getContext()), previewStreamStateObserver);
                PreviewView.this.mImplementation.onSurfaceRequested(surfaceRequest, new f(this, previewStreamStateObserver, camera));
                PreviewView previewView6 = PreviewView.this;
                if (previewView6.indexOfChild(previewView6.mScreenFlashView) == -1) {
                    PreviewView previewView7 = PreviewView.this;
                    previewView7.addView(previewView7.mScreenFlashView);
                }
                PreviewView previewView8 = PreviewView.this;
                OnFrameUpdateListener onFrameUpdateListener = previewView8.mOnFrameUpdateListener;
                if (onFrameUpdateListener != null && (executor = previewView8.mOnFrameUpdateListenerExecutor) != null) {
                    previewView8.mImplementation.setFrameUpdateListener(executor, onFrameUpdateListener);
                }
            }
        };
        Threads.checkMainThread();
        Resources.Theme theme = context.getTheme();
        int[] iArr = R.styleable.PreviewView;
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr, i, i2);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes, i, i2);
        try {
            setScaleType(ScaleType.fromId(obtainStyledAttributes.getInteger(R.styleable.PreviewView_scaleType, previewTransformation.getScaleType().getId())));
            setImplementationMode(ImplementationMode.fromId(obtainStyledAttributes.getInteger(R.styleable.PreviewView_implementationMode, implementationMode.getId())));
            obtainStyledAttributes.recycle();
            this.mZoomGestureDetector = new ZoomGestureDetector(context, new lb(this, 12));
            if (getBackground() == null) {
                setBackgroundColor(ContextCompat.getColor(getContext(), DEFAULT_BACKGROUND_COLOR));
            }
            ScreenFlashView screenFlashView = new ScreenFlashView(context);
            this.mScreenFlashView = screenFlashView;
            screenFlashView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    @UiThread
    @SuppressLint({"WrongConstant"})
    @Nullable
    public ViewPort getViewPort(int i) {
        Threads.checkMainThread();
        if (getWidth() == 0 || getHeight() == 0) {
            return null;
        }
        return new ViewPort.Builder(new Rational(getWidth(), getHeight()), i).setScaleType(getViewPortScaleType()).setLayoutDirection(getLayoutDirection()).build();
    }
}
