package androidx.camera.core;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.imagecapture.RequestWithCallback;
import androidx.camera.core.imagecapture.TakePictureRequest;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0001\u001aT\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tH@¢\u0006\u0002\u0010\r\u001a\\\u0010\u0003\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tH@¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"getTakePictureRequest", "Landroidx/camera/core/imagecapture/TakePictureRequest;", "Landroidx/camera/core/ImageCapture;", "takePicture", "Landroidx/camera/core/ImageProxy;", "onCaptureStarted", "Lkotlin/Function0;", "", "onCaptureProcessProgressed", "Lkotlin/Function1;", "", "onPostviewBitmapAvailable", "Landroid/graphics/Bitmap;", "(Landroidx/camera/core/ImageCapture;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/camera/core/ImageCapture$OutputFileResults;", "outputFileOptions", "Landroidx/camera/core/ImageCapture$OutputFileOptions;", "(Landroidx/camera/core/ImageCapture;Landroidx/camera/core/ImageCapture$OutputFileOptions;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "camera-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nImageCaptureExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImageCaptureExt.kt\nandroidx/camera/core/ImageCaptureExtKt\n+ 2 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,203:1\n329#2:204\n329#2:216\n314#3,11:205\n314#3,11:217\n*S KotlinDebug\n*F\n+ 1 ImageCaptureExt.kt\nandroidx/camera/core/ImageCaptureExtKt\n*L\n50#1:204\n102#1:216\n52#1:205,11\n104#1:217,11\n*E\n"})
public final class ImageCaptureExtKt {
    @VisibleForTesting
    @Nullable
    public static final TakePictureRequest getTakePictureRequest(@NotNull ImageCapture imageCapture) {
        Intrinsics.checkNotNullParameter(imageCapture, "<this>");
        RequestWithCallback capturingRequest = imageCapture.getTakePictureManager().getCapturingRequest();
        if (capturingRequest != null) {
            return capturingRequest.getTakePictureRequest();
        }
        return null;
    }

    @Nullable
    public static final Object takePicture(@NotNull ImageCapture imageCapture, @Nullable Function0<Unit> function0, @Nullable Function1<? super Integer, Unit> function1, @Nullable Function1<? super Bitmap, Unit> function12, @NotNull Continuation<? super ImageProxy> continuation) {
        Executor executor;
        CoroutineContext.Element element = continuation.getContext().get(ContinuationInterceptor.b);
        CoroutineDispatcher coroutineDispatcher = element instanceof CoroutineDispatcher ? (CoroutineDispatcher) element : null;
        if (coroutineDispatcher != null) {
            executor = ExecutorsKt.a(coroutineDispatcher);
        } else {
            executor = CameraXExecutors.directExecutor();
            Intrinsics.checkNotNullExpressionValue(executor, "directExecutor()");
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt.b(continuation));
        cancellableContinuationImpl.q();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new DelegatingImageCapturedCallback(new ImageCaptureExtKt$takePicture$2$1(function0, function1, function12, objectRef, cancellableContinuationImpl));
        cancellableContinuationImpl.s(new ImageCaptureExtKt$takePicture$2$2(objectRef));
        T t = objectRef.element;
        if (t != null) {
            ImageCapture imageCapture2 = imageCapture;
            imageCapture.lambda$takePicture$1(executor, (DelegatingImageCapturedCallback) t);
            Object p = cancellableContinuationImpl.p();
            if (p == CoroutineSingletons.COROUTINE_SUSPENDED) {
                Intrinsics.checkNotNullParameter(continuation, TypedValues.AttributesType.S_FRAME);
            }
            return p;
        }
        Intrinsics.k("delegatingCallback");
        throw null;
    }

    public static /* synthetic */ Object takePicture$default(ImageCapture imageCapture, Function0 function0, Function1 function1, Function1 function12, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function12 = null;
        }
        return takePicture(imageCapture, function0, function1, function12, continuation);
    }

    public static /* synthetic */ Object takePicture$default(ImageCapture imageCapture, ImageCapture.OutputFileOptions outputFileOptions, Function0 function0, Function1 function1, Function1 function12, Continuation continuation, int i, Object obj) {
        return takePicture(imageCapture, outputFileOptions, (i & 2) != 0 ? null : function0, (i & 4) != 0 ? null : function1, (i & 8) != 0 ? null : function12, continuation);
    }

    @Nullable
    public static final Object takePicture(@NotNull ImageCapture imageCapture, @NotNull ImageCapture.OutputFileOptions outputFileOptions, @Nullable Function0<Unit> function0, @Nullable Function1<? super Integer, Unit> function1, @Nullable Function1<? super Bitmap, Unit> function12, @NotNull Continuation<? super ImageCapture.OutputFileResults> continuation) {
        Executor executor;
        CoroutineContext.Element element = continuation.getContext().get(ContinuationInterceptor.b);
        CoroutineDispatcher coroutineDispatcher = element instanceof CoroutineDispatcher ? (CoroutineDispatcher) element : null;
        if (coroutineDispatcher != null) {
            executor = ExecutorsKt.a(coroutineDispatcher);
        } else {
            executor = CameraXExecutors.directExecutor();
            Intrinsics.checkNotNullExpressionValue(executor, "directExecutor()");
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt.b(continuation));
        cancellableContinuationImpl.q();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new DelegatingImageSavedCallback(new ImageCaptureExtKt$takePicture$4$1(function0, function1, function12, objectRef, cancellableContinuationImpl));
        cancellableContinuationImpl.s(new ImageCaptureExtKt$takePicture$4$2(objectRef));
        T t = objectRef.element;
        if (t != null) {
            ImageCapture imageCapture2 = imageCapture;
            ImageCapture.OutputFileOptions outputFileOptions2 = outputFileOptions;
            imageCapture.lambda$takePicture$2(outputFileOptions, executor, (DelegatingImageSavedCallback) t);
            Object p = cancellableContinuationImpl.p();
            if (p == CoroutineSingletons.COROUTINE_SUSPENDED) {
                Intrinsics.checkNotNullParameter(continuation, TypedValues.AttributesType.S_FRAME);
            }
            return p;
        }
        Intrinsics.k("delegatingCallback");
        throw null;
    }
}
