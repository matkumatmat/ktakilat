package androidx.camera.core;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.Image;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.camera.core.ImageProxy;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class ForwardingImageProxy implements ImageProxy {
    protected final ImageProxy mImage;
    private final Object mLock = new Object();
    @GuardedBy("mLock")
    private final Set<OnImageCloseListener> mOnImageCloseListeners = new HashSet();

    public interface OnImageCloseListener {
        void onImageClose(@NonNull ImageProxy imageProxy);
    }

    public ForwardingImageProxy(@NonNull ImageProxy imageProxy) {
        this.mImage = imageProxy;
    }

    public void addOnImageCloseListener(@NonNull OnImageCloseListener onImageCloseListener) {
        synchronized (this.mLock) {
            this.mOnImageCloseListeners.add(onImageCloseListener);
        }
    }

    public void close() {
        this.mImage.close();
        notifyOnImageCloseListeners();
    }

    @NonNull
    public Rect getCropRect() {
        return this.mImage.getCropRect();
    }

    public int getFormat() {
        return this.mImage.getFormat();
    }

    public int getHeight() {
        return this.mImage.getHeight();
    }

    @ExperimentalGetImage
    @Nullable
    public Image getImage() {
        return this.mImage.getImage();
    }

    @NonNull
    public ImageInfo getImageInfo() {
        return this.mImage.getImageInfo();
    }

    @NonNull
    public ImageProxy.PlaneProxy[] getPlanes() {
        return this.mImage.getPlanes();
    }

    public int getWidth() {
        return this.mImage.getWidth();
    }

    public void notifyOnImageCloseListeners() {
        HashSet hashSet;
        synchronized (this.mLock) {
            hashSet = new HashSet(this.mOnImageCloseListeners);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((OnImageCloseListener) it.next()).onImageClose(this);
        }
    }

    public void setCropRect(@Nullable Rect rect) {
        this.mImage.setCropRect(rect);
    }

    public final /* synthetic */ Bitmap toBitmap() {
        return pa.a(this);
    }
}
