package androidx.camera.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import android.view.Display;
import android.view.TextureView;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.view.PreviewView;
import androidx.core.util.Preconditions;
import org.apache.commons.lang3.StringUtils;

final class PreviewTransformation {
    private static final PreviewView.ScaleType DEFAULT_SCALE_TYPE = PreviewView.ScaleType.FILL_CENTER;
    private static final String TAG = "PreviewTransform";
    private boolean mHasCameraTransform;
    private boolean mIsFrontCamera;
    private int mPreviewRotationDegrees;
    private Size mResolution;
    private PreviewView.ScaleType mScaleType = DEFAULT_SCALE_TYPE;
    private Matrix mSensorToBufferTransform;
    private Rect mSurfaceCropRect;
    private int mTargetRotation;

    /* renamed from: androidx.camera.view.PreviewTransformation$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$view$PreviewView$ScaleType;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.camera.view.PreviewView$ScaleType[] r0 = androidx.camera.view.PreviewView.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$camera$view$PreviewView$ScaleType = r0
                androidx.camera.view.PreviewView$ScaleType r1 = androidx.camera.view.PreviewView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$androidx$camera$view$PreviewView$ScaleType     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.view.PreviewView$ScaleType r1 = androidx.camera.view.PreviewView.ScaleType.FILL_CENTER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$androidx$camera$view$PreviewView$ScaleType     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.camera.view.PreviewView$ScaleType r1 = androidx.camera.view.PreviewView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$androidx$camera$view$PreviewView$ScaleType     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.camera.view.PreviewView$ScaleType r1 = androidx.camera.view.PreviewView.ScaleType.FILL_END     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$androidx$camera$view$PreviewView$ScaleType     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.camera.view.PreviewView$ScaleType r1 = androidx.camera.view.PreviewView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$androidx$camera$view$PreviewView$ScaleType     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.camera.view.PreviewView$ScaleType r1 = androidx.camera.view.PreviewView.ScaleType.FILL_START     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.view.PreviewTransformation.AnonymousClass1.<clinit>():void");
        }
    }

    private static RectF flipHorizontally(RectF rectF, float f) {
        float f2 = f + f;
        return new RectF(f2 - rectF.right, rectF.top, f2 - rectF.left, rectF.bottom);
    }

    private int getRemainingRotationDegrees() {
        if (!this.mHasCameraTransform) {
            return this.mPreviewRotationDegrees;
        }
        return -CameraOrientationUtil.surfaceRotationToDegrees(this.mTargetRotation);
    }

    private Size getRotatedViewportSize() {
        if (TransformUtils.is90or270(this.mPreviewRotationDegrees)) {
            return new Size(this.mSurfaceCropRect.height(), this.mSurfaceCropRect.width());
        }
        return new Size(this.mSurfaceCropRect.width(), this.mSurfaceCropRect.height());
    }

    private RectF getTransformedSurfaceRect(Size size, int i) {
        Preconditions.checkState(isTransformationInfoReady());
        Matrix surfaceToPreviewViewMatrix = getSurfaceToPreviewViewMatrix(size, i);
        RectF rectF = new RectF(0.0f, 0.0f, (float) this.mResolution.getWidth(), (float) this.mResolution.getHeight());
        surfaceToPreviewViewMatrix.mapRect(rectF);
        return rectF;
    }

    private boolean isTransformationInfoReady() {
        boolean z;
        if (!this.mHasCameraTransform || this.mTargetRotation != -1) {
            z = true;
        } else {
            z = false;
        }
        if (this.mSurfaceCropRect == null || this.mResolution == null || !z) {
            return false;
        }
        return true;
    }

    private static void setMatrixRectToRect(Matrix matrix, RectF rectF, RectF rectF2, PreviewView.ScaleType scaleType) {
        Matrix.ScaleToFit scaleToFit;
        switch (AnonymousClass1.$SwitchMap$androidx$camera$view$PreviewView$ScaleType[scaleType.ordinal()]) {
            case 1:
            case 2:
                scaleToFit = Matrix.ScaleToFit.CENTER;
                break;
            case 3:
            case 4:
                scaleToFit = Matrix.ScaleToFit.END;
                break;
            case 5:
            case 6:
                scaleToFit = Matrix.ScaleToFit.START;
                break;
            default:
                Logger.e(TAG, "Unexpected crop rect: " + scaleType);
                scaleToFit = Matrix.ScaleToFit.FILL;
                break;
        }
        if (scaleType == PreviewView.ScaleType.FIT_CENTER || scaleType == PreviewView.ScaleType.FIT_START || scaleType == PreviewView.ScaleType.FIT_END) {
            matrix.setRectToRect(rectF, rectF2, scaleToFit);
            return;
        }
        matrix.setRectToRect(rectF2, rectF, scaleToFit);
        matrix.invert(matrix);
    }

    public Bitmap createTransformedBitmap(@NonNull Bitmap bitmap, Size size, int i) {
        if (!isTransformationInfoReady()) {
            return bitmap;
        }
        Matrix textureViewCorrectionMatrix = getTextureViewCorrectionMatrix();
        RectF transformedSurfaceRect = getTransformedSurfaceRect(size, i);
        Bitmap createBitmap = Bitmap.createBitmap(size.getWidth(), size.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        Matrix matrix = new Matrix();
        matrix.postConcat(textureViewCorrectionMatrix);
        matrix.postScale(transformedSurfaceRect.width() / ((float) this.mResolution.getWidth()), transformedSurfaceRect.height() / ((float) this.mResolution.getHeight()));
        matrix.postTranslate(transformedSurfaceRect.left, transformedSurfaceRect.top);
        canvas.drawBitmap(bitmap, matrix, new Paint(7));
        return createBitmap;
    }

    @Nullable
    public Matrix getPreviewViewToNormalizedSensorMatrix(Size size, int i, Rect rect) {
        if (!isTransformationInfoReady()) {
            return null;
        }
        Matrix matrix = new Matrix();
        getSensorToViewTransform(size, i).invert(matrix);
        Matrix matrix2 = new Matrix();
        matrix2.setRectToRect(new RectF(0.0f, 0.0f, (float) rect.width(), (float) rect.height()), new RectF(0.0f, 0.0f, 1.0f, 1.0f), Matrix.ScaleToFit.FILL);
        matrix.postConcat(matrix2);
        return matrix;
    }

    public RectF getPreviewViewViewportRectForMismatchedAspectRatios(Size size, int i) {
        RectF rectF = new RectF(0.0f, 0.0f, (float) size.getWidth(), (float) size.getHeight());
        Size rotatedViewportSize = getRotatedViewportSize();
        RectF rectF2 = new RectF(0.0f, 0.0f, (float) rotatedViewportSize.getWidth(), (float) rotatedViewportSize.getHeight());
        Matrix matrix = new Matrix();
        setMatrixRectToRect(matrix, rectF2, rectF, this.mScaleType);
        matrix.mapRect(rectF2);
        if (i == 1) {
            return flipHorizontally(rectF2, ((float) size.getWidth()) / 2.0f);
        }
        return rectF2;
    }

    public PreviewView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    @Nullable
    public Matrix getSensorToViewTransform(@NonNull Size size, int i) {
        if (!isTransformationInfoReady()) {
            return null;
        }
        Matrix matrix = new Matrix(this.mSensorToBufferTransform);
        matrix.postConcat(getSurfaceToPreviewViewMatrix(size, i));
        return matrix;
    }

    @Nullable
    public Rect getSurfaceCropRect() {
        return this.mSurfaceCropRect;
    }

    public Matrix getSurfaceToPreviewViewMatrix(Size size, int i) {
        RectF rectF;
        Preconditions.checkState(isTransformationInfoReady());
        if (isViewportAspectRatioMatchPreviewView(size)) {
            rectF = new RectF(0.0f, 0.0f, (float) size.getWidth(), (float) size.getHeight());
        } else {
            rectF = getPreviewViewViewportRectForMismatchedAspectRatios(size, i);
        }
        Matrix rectToRect = TransformUtils.getRectToRect(new RectF(this.mSurfaceCropRect), rectF, this.mPreviewRotationDegrees);
        if (this.mIsFrontCamera && this.mHasCameraTransform) {
            if (TransformUtils.is90or270(this.mPreviewRotationDegrees)) {
                rectToRect.preScale(1.0f, -1.0f, (float) this.mSurfaceCropRect.centerX(), (float) this.mSurfaceCropRect.centerY());
            } else {
                rectToRect.preScale(-1.0f, 1.0f, (float) this.mSurfaceCropRect.centerX(), (float) this.mSurfaceCropRect.centerY());
            }
        }
        return rectToRect;
    }

    @VisibleForTesting
    public Matrix getTextureViewCorrectionMatrix() {
        Preconditions.checkState(isTransformationInfoReady());
        RectF rectF = new RectF(0.0f, 0.0f, (float) this.mResolution.getWidth(), (float) this.mResolution.getHeight());
        return TransformUtils.getRectToRect(rectF, rectF, getRemainingRotationDegrees());
    }

    @VisibleForTesting
    public boolean isViewportAspectRatioMatchPreviewView(Size size) {
        return TransformUtils.isAspectRatioMatchingWithRoundingError(size, true, getRotatedViewportSize(), false);
    }

    public void overrideWithDisplayRotation(int i, int i2) {
        if (this.mHasCameraTransform) {
            this.mPreviewRotationDegrees = i;
            this.mTargetRotation = i2;
        }
    }

    public void setScaleType(PreviewView.ScaleType scaleType) {
        this.mScaleType = scaleType;
    }

    public void setTransformationInfo(@NonNull SurfaceRequest.TransformationInfo transformationInfo, Size size, boolean z) {
        Logger.d(TAG, "Transformation info set: " + transformationInfo + StringUtils.SPACE + size + StringUtils.SPACE + z);
        this.mSurfaceCropRect = transformationInfo.getCropRect();
        this.mPreviewRotationDegrees = transformationInfo.getRotationDegrees();
        this.mTargetRotation = transformationInfo.getTargetRotation();
        this.mResolution = size;
        this.mIsFrontCamera = z;
        this.mHasCameraTransform = transformationInfo.hasCameraTransform();
        this.mSensorToBufferTransform = transformationInfo.getSensorToBufferTransform();
    }

    public void transformView(Size size, int i, @NonNull View view) {
        boolean z;
        if (size.getHeight() == 0 || size.getWidth() == 0) {
            Logger.w(TAG, "Transform not applied due to PreviewView size: " + size);
        } else if (isTransformationInfoReady()) {
            if (view instanceof TextureView) {
                ((TextureView) view).setTransform(getTextureViewCorrectionMatrix());
            } else {
                Display display = view.getDisplay();
                boolean z2 = false;
                if (!this.mHasCameraTransform || display == null || display.getRotation() == this.mTargetRotation) {
                    z = false;
                } else {
                    z = true;
                }
                if (!this.mHasCameraTransform && getRemainingRotationDegrees() != 0) {
                    z2 = true;
                }
                if (z || z2) {
                    Logger.e(TAG, "Custom rotation not supported with SurfaceView/PERFORMANCE mode.");
                }
            }
            RectF transformedSurfaceRect = getTransformedSurfaceRect(size, i);
            view.setPivotX(0.0f);
            view.setPivotY(0.0f);
            view.setScaleX(transformedSurfaceRect.width() / ((float) this.mResolution.getWidth()));
            view.setScaleY(transformedSurfaceRect.height() / ((float) this.mResolution.getHeight()));
            view.setTranslationX(transformedSurfaceRect.left - ((float) view.getLeft()));
            view.setTranslationY(transformedSurfaceRect.top - ((float) view.getTop()));
        }
    }
}
