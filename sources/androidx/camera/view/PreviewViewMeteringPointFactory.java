package androidx.camera.view;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.AnyThread;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.impl.utils.Threads;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class PreviewViewMeteringPointFactory extends MeteringPointFactory {
    static final PointF INVALID_POINT = new PointF(2.0f, 2.0f);
    @GuardedBy("this")
    @Nullable
    private Matrix mMatrix;
    @NonNull
    private final PreviewTransformation mPreviewTransformation;
    @GuardedBy("this")
    @Nullable
    private Rect mSensorRect = null;

    public PreviewViewMeteringPointFactory(@NonNull PreviewTransformation previewTransformation) {
        this.mPreviewTransformation = previewTransformation;
    }

    @NonNull
    @AnyThread
    public PointF convertPoint(float f, float f2) {
        float[] fArr = {f, f2};
        synchronized (this) {
            try {
                Matrix matrix = this.mMatrix;
                if (matrix == null) {
                    PointF pointF = INVALID_POINT;
                    return pointF;
                }
                matrix.mapPoints(fArr);
                return new PointF(fArr[0], fArr[1]);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    @UiThread
    public void recalculate(@NonNull Size size, int i) {
        Threads.checkMainThread();
        synchronized (this) {
            try {
                if (!(size.getWidth() == 0 || size.getHeight() == 0)) {
                    Rect rect = this.mSensorRect;
                    if (rect != null) {
                        this.mMatrix = this.mPreviewTransformation.getPreviewViewToNormalizedSensorMatrix(size, i, rect);
                        return;
                    }
                }
                this.mMatrix = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setSensorRect(Rect rect) {
        setSurfaceAspectRatio(new Rational(rect.width(), rect.height()));
        synchronized (this) {
            this.mSensorRect = rect;
        }
    }
}
