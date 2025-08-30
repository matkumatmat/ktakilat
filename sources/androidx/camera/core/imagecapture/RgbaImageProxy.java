package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.Image;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.camera.core.ExperimentalGetImage;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.processing.Packet;
import androidx.core.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.Objects;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class RgbaImageProxy implements ImageProxy {
    @NonNull
    private final Rect mCropRect;
    private final int mHeight;
    @NonNull
    private final ImageInfo mImageInfo;
    private final Object mLock;
    @GuardedBy("mLock")
    @Nullable
    ImageProxy.PlaneProxy[] mPlaneProxy;
    private final int mWidth;

    public RgbaImageProxy(@NonNull Packet<Bitmap> packet) {
        this(packet.getData(), packet.getCropRect(), packet.getRotationDegrees(), packet.getSensorToBufferTransform(), packet.getCameraCaptureResult().getTimestamp());
    }

    private void checkNotClosed() {
        boolean z;
        synchronized (this.mLock) {
            if (this.mPlaneProxy != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z, "The image is closed.");
        }
    }

    private static ImageInfo createImageInfo(final long j, final int i, @NonNull final Matrix matrix) {
        return new ImageInfo() {
            public int getRotationDegrees() {
                return i;
            }

            @NonNull
            public Matrix getSensorToBufferTransformMatrix() {
                return new Matrix(matrix);
            }

            @NonNull
            public TagBundle getTagBundle() {
                throw new UnsupportedOperationException("Custom ImageProxy does not contain TagBundle");
            }

            public long getTimestamp() {
                return j;
            }

            public void populateExifData(@NonNull ExifData.Builder builder) {
                throw new UnsupportedOperationException("Custom ImageProxy does not contain Exif data.");
            }
        };
    }

    private static ImageProxy.PlaneProxy createPlaneProxy(@NonNull final ByteBuffer byteBuffer, final int i, final int i2) {
        return new ImageProxy.PlaneProxy() {
            @NonNull
            public ByteBuffer getBuffer() {
                return byteBuffer;
            }

            public int getPixelStride() {
                return i2;
            }

            public int getRowStride() {
                return i;
            }
        };
    }

    public void close() {
        synchronized (this.mLock) {
            checkNotClosed();
            this.mPlaneProxy = null;
        }
    }

    @NonNull
    public Bitmap createBitmap() {
        Bitmap createBitmapFromPlane;
        synchronized (this.mLock) {
            checkNotClosed();
            createBitmapFromPlane = ImageUtil.createBitmapFromPlane(getPlanes(), getWidth(), getHeight());
        }
        return createBitmapFromPlane;
    }

    @NonNull
    public Rect getCropRect() {
        Rect rect;
        synchronized (this.mLock) {
            checkNotClosed();
            rect = this.mCropRect;
        }
        return rect;
    }

    public int getFormat() {
        synchronized (this.mLock) {
            checkNotClosed();
        }
        return 1;
    }

    public int getHeight() {
        int i;
        synchronized (this.mLock) {
            checkNotClosed();
            i = this.mHeight;
        }
        return i;
    }

    @ExperimentalGetImage
    @Nullable
    public Image getImage() {
        synchronized (this.mLock) {
            checkNotClosed();
        }
        return null;
    }

    @NonNull
    public ImageInfo getImageInfo() {
        ImageInfo imageInfo;
        synchronized (this.mLock) {
            checkNotClosed();
            imageInfo = this.mImageInfo;
        }
        return imageInfo;
    }

    @NonNull
    public ImageProxy.PlaneProxy[] getPlanes() {
        ImageProxy.PlaneProxy[] planeProxyArr;
        synchronized (this.mLock) {
            checkNotClosed();
            ImageProxy.PlaneProxy[] planeProxyArr2 = this.mPlaneProxy;
            Objects.requireNonNull(planeProxyArr2);
            planeProxyArr = planeProxyArr2;
        }
        return planeProxyArr;
    }

    public int getWidth() {
        int i;
        synchronized (this.mLock) {
            checkNotClosed();
            i = this.mWidth;
        }
        return i;
    }

    public void setCropRect(@Nullable Rect rect) {
        synchronized (this.mLock) {
            try {
                checkNotClosed();
                if (rect != null) {
                    this.mCropRect.set(rect);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ Bitmap toBitmap() {
        return pa.a(this);
    }

    public RgbaImageProxy(@NonNull Bitmap bitmap, @NonNull Rect rect, int i, @NonNull Matrix matrix, long j) {
        this(ImageUtil.createDirectByteBuffer(bitmap), 4, bitmap.getWidth(), bitmap.getHeight(), rect, i, matrix, j);
    }

    public RgbaImageProxy(@NonNull ByteBuffer byteBuffer, int i, int i2, int i3, @NonNull Rect rect, int i4, @NonNull Matrix matrix, long j) {
        this.mLock = new Object();
        this.mWidth = i2;
        this.mHeight = i3;
        this.mCropRect = rect;
        this.mImageInfo = createImageInfo(j, i4, matrix);
        byteBuffer.rewind();
        this.mPlaneProxy = new ImageProxy.PlaneProxy[]{createPlaneProxy(byteBuffer, i2 * i, i)};
    }
}
