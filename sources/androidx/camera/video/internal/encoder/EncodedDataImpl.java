package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class EncodedDataImpl implements EncodedData {
    private final int mBufferIndex;
    private final MediaCodec.BufferInfo mBufferInfo;
    private final ByteBuffer mByteBuffer;
    private final AtomicBoolean mClosed = new AtomicBoolean(false);
    private final CallbackToFutureAdapter.Completer<Void> mClosedCompleter;
    private final ListenableFuture<Void> mClosedFuture;
    private final MediaCodec mMediaCodec;

    public EncodedDataImpl(@NonNull MediaCodec mediaCodec, int i, @NonNull MediaCodec.BufferInfo bufferInfo) throws MediaCodec.CodecException {
        this.mMediaCodec = (MediaCodec) Preconditions.checkNotNull(mediaCodec);
        this.mBufferIndex = i;
        this.mByteBuffer = mediaCodec.getOutputBuffer(i);
        this.mBufferInfo = (MediaCodec.BufferInfo) Preconditions.checkNotNull(bufferInfo);
        AtomicReference atomicReference = new AtomicReference();
        this.mClosedFuture = CallbackToFutureAdapter.getFuture(new i1(atomicReference, 1));
        this.mClosedCompleter = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) atomicReference.get());
    }

    private void throwIfClosed() {
        if (this.mClosed.get()) {
            throw new IllegalStateException("encoded data is closed.");
        }
    }

    public void close() {
        if (!this.mClosed.getAndSet(true)) {
            try {
                this.mMediaCodec.releaseOutputBuffer(this.mBufferIndex, false);
                this.mClosedCompleter.set(null);
            } catch (IllegalStateException e) {
                this.mClosedCompleter.setException(e);
            }
        }
    }

    @NonNull
    public MediaCodec.BufferInfo getBufferInfo() {
        return this.mBufferInfo;
    }

    @NonNull
    public ByteBuffer getByteBuffer() {
        throwIfClosed();
        this.mByteBuffer.position(this.mBufferInfo.offset);
        ByteBuffer byteBuffer = this.mByteBuffer;
        MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
        return this.mByteBuffer;
    }

    @NonNull
    public ListenableFuture<Void> getClosedFuture() {
        return Futures.nonCancellationPropagating(this.mClosedFuture);
    }

    public long getPresentationTimeUs() {
        return this.mBufferInfo.presentationTimeUs;
    }

    public boolean isKeyFrame() {
        if ((this.mBufferInfo.flags & 1) != 0) {
            return true;
        }
        return false;
    }

    public long size() {
        return (long) this.mBufferInfo.size;
    }
}
