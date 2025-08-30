package androidx.camera.lifecycle;

import androidx.camera.core.CameraX;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"androidx/camera/lifecycle/ProcessCameraProvider$getOrCreateCameraXInstance$1$1$1$1", "Landroidx/camera/core/impl/utils/futures/FutureCallback;", "Ljava/lang/Void;", "onFailure", "", "t", "", "onSuccess", "result", "camera-lifecycle_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ProcessCameraProvider$getOrCreateCameraXInstance$1$1$1$1 implements FutureCallback<Void> {
    final /* synthetic */ CameraX $cameraX;
    final /* synthetic */ CallbackToFutureAdapter.Completer<CameraX> $completer;

    public ProcessCameraProvider$getOrCreateCameraXInstance$1$1$1$1(CallbackToFutureAdapter.Completer<CameraX> completer, CameraX cameraX) {
        this.$completer = completer;
        this.$cameraX = cameraX;
    }

    public void onFailure(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "t");
        this.$completer.setException(th);
    }

    public void onSuccess(@Nullable Void voidR) {
        this.$completer.set(this.$cameraX);
    }
}
