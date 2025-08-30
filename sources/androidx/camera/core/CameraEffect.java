package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.camera.core.processing.SurfaceProcessorInternal;
import androidx.camera.core.processing.SurfaceProcessorWithExecutor;
import androidx.camera.core.processing.TargetUtils;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;

public abstract class CameraEffect {
    public static final int IMAGE_CAPTURE = 4;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int OUTPUT_OPTION_ONE_FOR_ALL_TARGETS = 0;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int OUTPUT_OPTION_ONE_FOR_EACH_TARGET = 1;
    public static final int PREVIEW = 1;
    private static final List<Integer> SURFACE_PROCESSOR_TARGETS = Arrays.asList(new Integer[]{1, 2, 3, 7});
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int TRANSFORMATION_ARBITRARY = 0;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int TRANSFORMATION_CAMERA_AND_SURFACE_ROTATION = 1;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int TRANSFORMATION_PASSTHROUGH = 2;
    public static final int VIDEO_CAPTURE = 2;
    @NonNull
    private final Consumer<Throwable> mErrorListener;
    @NonNull
    private final Executor mExecutor;
    @Nullable
    private final ImageProcessor mImageProcessor;
    private final int mOutputOption;
    @Nullable
    private final SurfaceProcessor mSurfaceProcessor;
    private final int mTargets;
    private final int mTransformation;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Formats {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface OutputOptions {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Targets {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Transformations {
    }

    public CameraEffect(int i, @NonNull Executor executor, @NonNull ImageProcessor imageProcessor, @NonNull Consumer<Throwable> consumer) {
        Preconditions.checkArgument(i == 4, "Currently ImageProcessor can only target IMAGE_CAPTURE.");
        this.mTargets = i;
        this.mTransformation = 0;
        this.mOutputOption = 0;
        this.mExecutor = executor;
        this.mSurfaceProcessor = null;
        this.mImageProcessor = imageProcessor;
        this.mErrorListener = consumer;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public SurfaceProcessorInternal createSurfaceProcessorInternal() {
        return new SurfaceProcessorWithExecutor(this);
    }

    @NonNull
    public Consumer<Throwable> getErrorListener() {
        return this.mErrorListener;
    }

    @NonNull
    public Executor getExecutor() {
        return this.mExecutor;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ImageProcessor getImageProcessor() {
        return this.mImageProcessor;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getOutputOption() {
        return this.mOutputOption;
    }

    @Nullable
    public SurfaceProcessor getSurfaceProcessor() {
        return this.mSurfaceProcessor;
    }

    public int getTargets() {
        return this.mTargets;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getTransformation() {
        return this.mTransformation;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraEffect(int i, int i2, @NonNull Executor executor, @NonNull SurfaceProcessor surfaceProcessor, @NonNull Consumer<Throwable> consumer) {
        this(i, 0, i2, executor, surfaceProcessor, consumer);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public CameraEffect(int i, int i2, int i3, @NonNull Executor executor, @NonNull SurfaceProcessor surfaceProcessor, @NonNull Consumer<Throwable> consumer) {
        TargetUtils.checkSupportedTargets(SURFACE_PROCESSOR_TARGETS, i);
        this.mTargets = i;
        this.mOutputOption = i2;
        this.mTransformation = i3;
        this.mExecutor = executor;
        this.mSurfaceProcessor = surfaceProcessor;
        this.mImageProcessor = null;
        this.mErrorListener = consumer;
    }

    public CameraEffect(int i, @NonNull Executor executor, @NonNull SurfaceProcessor surfaceProcessor, @NonNull Consumer<Throwable> consumer) {
        this(i, 0, 0, executor, surfaceProcessor, consumer);
    }
}
