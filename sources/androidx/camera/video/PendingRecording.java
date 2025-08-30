package androidx.camera.video;

import android.content.Context;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.camera.core.impl.utils.ContextUtil;
import androidx.core.content.PermissionChecker;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;

public final class PendingRecording {
    private boolean mAudioEnabled = false;
    private final Context mContext;
    private Consumer<VideoRecordEvent> mEventListener;
    private boolean mIsPersistent = false;
    private Executor mListenerExecutor;
    private final OutputOptions mOutputOptions;
    private final Recorder mRecorder;

    public PendingRecording(@NonNull Context context, @NonNull Recorder recorder, @NonNull OutputOptions outputOptions) {
        this.mContext = ContextUtil.getApplicationContext(context);
        this.mRecorder = recorder;
        this.mOutputOptions = outputOptions;
    }

    @NonNull
    @ExperimentalPersistentRecording
    public PendingRecording asPersistentRecording() {
        this.mIsPersistent = true;
        return this;
    }

    @NonNull
    public Context getApplicationContext() {
        return this.mContext;
    }

    @Nullable
    public Consumer<VideoRecordEvent> getEventListener() {
        return this.mEventListener;
    }

    @Nullable
    public Executor getListenerExecutor() {
        return this.mListenerExecutor;
    }

    @NonNull
    public OutputOptions getOutputOptions() {
        return this.mOutputOptions;
    }

    @NonNull
    public Recorder getRecorder() {
        return this.mRecorder;
    }

    public boolean isAudioEnabled() {
        return this.mAudioEnabled;
    }

    public boolean isPersistent() {
        return this.mIsPersistent;
    }

    @CheckResult
    @NonNull
    public Recording start(@NonNull Executor executor, @NonNull Consumer<VideoRecordEvent> consumer) {
        Preconditions.checkNotNull(executor, "Listener Executor can't be null.");
        Preconditions.checkNotNull(consumer, "Event listener can't be null");
        this.mListenerExecutor = executor;
        this.mEventListener = consumer;
        return this.mRecorder.start(this);
    }

    @RequiresPermission("android.permission.RECORD_AUDIO")
    @NonNull
    public PendingRecording withAudioEnabled() {
        if (PermissionChecker.checkSelfPermission(this.mContext, "android.permission.RECORD_AUDIO") != -1) {
            Preconditions.checkState(this.mRecorder.isAudioSupported(), "The Recorder this recording is associated to doesn't support audio.");
            this.mAudioEnabled = true;
            return this;
        }
        throw new SecurityException("Attempted to enable audio for recording but application does not have RECORD_AUDIO permission granted.");
    }
}
