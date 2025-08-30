package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class SettableImageProxy extends ForwardingImageProxy {
    @GuardedBy("mLock")
    @Nullable
    private Rect mCropRect;
    private final int mHeight;
    private final ImageInfo mImageInfo;
    private final Object mLock;
    private final int mWidth;

    public SettableImageProxy(ImageProxy imageProxy, ImageInfo imageInfo) {
        this(imageProxy, (Size) null, imageInfo);
    }

    @NonNull
    public Rect getCropRect() {
        synchronized (this.mLock) {
            try {
                if (this.mCropRect == null) {
                    Rect rect = new Rect(0, 0, getWidth(), getHeight());
                    return rect;
                }
                Rect rect2 = new Rect(this.mCropRect);
                return rect2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int getHeight() {
        return this.mHeight;
    }

    @NonNull
    public ImageInfo getImageInfo() {
        return this.mImageInfo;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public void setCropRect(@Nullable Rect rect) {
        if (rect != null) {
            Rect rect2 = new Rect(rect);
            if (!rect2.intersect(0, 0, getWidth(), getHeight())) {
                rect2.setEmpty();
            }
            rect = rect2;
        }
        synchronized (this.mLock) {
            this.mCropRect = rect;
        }
    }

    public SettableImageProxy(@NonNull ImageProxy imageProxy, @Nullable Size size, @NonNull ImageInfo imageInfo) {
        super(imageProxy);
        this.mLock = new Object();
        if (size == null) {
            this.mWidth = super.getWidth();
            this.mHeight = super.getHeight();
        } else {
            this.mWidth = size.getWidth();
            this.mHeight = size.getHeight();
        }
        this.mImageInfo = imageInfo;
    }
}
