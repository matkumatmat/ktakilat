package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

class InputBufferImpl implements InputBuffer {
    private final int mBufferIndex;
    private final ByteBuffer mByteBuffer;
    private boolean mIsEndOfStream = false;
    private final MediaCodec mMediaCodec;
    private long mPresentationTimeUs = 0;
    private final AtomicBoolean mTerminated = new AtomicBoolean(false);
    private final CallbackToFutureAdapter.Completer<Void> mTerminationCompleter;
    private final ListenableFuture<Void> mTerminationFuture;

    public InputBufferImpl(@NonNull MediaCodec mediaCodec, @IntRange(from = 0) int i) throws MediaCodec.CodecException {
        this.mMediaCodec = (MediaCodec) Preconditions.checkNotNull(mediaCodec);
        this.mBufferIndex = Preconditions.checkArgumentNonnegative(i);
        this.mByteBuffer = mediaCodec.getInputBuffer(i);
        AtomicReference atomicReference = new AtomicReference();
        this.mTerminationFuture = CallbackToFutureAdapter.getFuture(new i(atomicReference));
        this.mTerminationCompleter = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) atomicReference.get());
    }

    private void throwIfTerminated() {
        if (this.mTerminated.get()) {
            throw new IllegalStateException("The buffer is submitted or canceled.");
        }
    }

    public boolean cancel() {
        if (this.mTerminated.getAndSet(true)) {
            return false;
        }
        try {
            this.mMediaCodec.queueInputBuffer(this.mBufferIndex, 0, 0, 0, 0);
            this.mTerminationCompleter.set(null);
        } catch (IllegalStateException e) {
            this.mTerminationCompleter.setException(e);
        }
        return true;
    }

    @NonNull
    public ByteBuffer getByteBuffer() {
        throwIfTerminated();
        return this.mByteBuffer;
    }

    @NonNull
    public ListenableFuture<Void> getTerminationFuture() {
        return Futures.nonCancellationPropagating(this.mTerminationFuture);
    }

    public void setEndOfStream(boolean z) {
        throwIfTerminated();
        this.mIsEndOfStream = z;
    }

    public void setPresentationTimeUs(long j) {
        boolean z;
        throwIfTerminated();
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.mPresentationTimeUs = j;
    }

    public boolean submit() {
        int i;
        if (this.mTerminated.getAndSet(true)) {
            return false;
        }
        try {
            MediaCodec mediaCodec = this.mMediaCodec;
            int i2 = this.mBufferIndex;
            int position = this.mByteBuffer.position();
            int limit = this.mByteBuffer.limit();
            long j = this.mPresentationTimeUs;
            if (this.mIsEndOfStream) {
                i = 4;
            } else {
                i = 0;
            }
            mediaCodec.queueInputBuffer(i2, position, limit, j, i);
            this.mTerminationCompleter.set(null);
            return true;
        } catch (IllegalStateException e) {
            this.mTerminationCompleter.setException(e);
            return false;
        }
    }
}
