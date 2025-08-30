package androidx.camera.video.internal.audio;

import android.annotation.SuppressLint;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.video.internal.audio.AudioStream;
import androidx.core.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class BufferedAudioStream implements AudioStream {
    private static final int DATA_WAITING_TIME_MILLIS = 1;
    private static final int DEFAULT_BUFFER_SIZE_IN_FRAME = 1024;
    private static final int DEFAULT_QUEUE_SIZE = 500;
    private static final String TAG = "BufferedAudioStream";
    @GuardedBy("mLock")
    @Nullable
    private AudioData mAudioDataNotFullyRead = null;
    @GuardedBy("mLock")
    private final Queue<AudioData> mAudioDataQueue = new ConcurrentLinkedQueue();
    private final AudioStream mAudioStream;
    private int mBufferSize;
    private final int mBytesPerFrame;
    private final AtomicBoolean mIsCollectingAudioData = new AtomicBoolean(false);
    private final AtomicBoolean mIsReleased = new AtomicBoolean(false);
    private final AtomicBoolean mIsStarted = new AtomicBoolean(false);
    private final Object mLock = new Object();
    private final Executor mProducerExecutor = CameraXExecutors.newSequentialExecutor(CameraXExecutors.audioExecutor());
    private final int mQueueMaxSize;
    private final int mSampleRate;

    public static class AudioData {
        private final ByteBuffer mByteBuffer;
        private final int mBytesPerFrame;
        private final int mSampleRate;
        private long mTimestampNs;

        public AudioData(@NonNull ByteBuffer byteBuffer, @NonNull AudioStream.PacketInfo packetInfo, int i, int i2) {
            byteBuffer.rewind();
            int limit = byteBuffer.limit() - byteBuffer.position();
            if (limit == packetInfo.getSizeInBytes()) {
                this.mBytesPerFrame = i;
                this.mSampleRate = i2;
                this.mByteBuffer = byteBuffer;
                this.mTimestampNs = packetInfo.getTimestampNs();
                return;
            }
            StringBuilder t = ba.t(limit, "Byte buffer size is not match with packet info: ", " != ");
            t.append(packetInfo.getSizeInBytes());
            throw new IllegalStateException(t.toString());
        }

        public int getRemainingBufferSizeInBytes() {
            return this.mByteBuffer.remaining();
        }

        public AudioStream.PacketInfo read(@NonNull ByteBuffer byteBuffer) {
            int i;
            long j = this.mTimestampNs;
            int position = this.mByteBuffer.position();
            int position2 = byteBuffer.position();
            if (this.mByteBuffer.remaining() > byteBuffer.remaining()) {
                i = byteBuffer.remaining();
                this.mTimestampNs += AudioUtils.frameCountToDurationNs(AudioUtils.sizeToFrameCount((long) i, this.mBytesPerFrame), this.mSampleRate);
                ByteBuffer duplicate = this.mByteBuffer.duplicate();
                duplicate.position(position).limit(position + i);
                byteBuffer.put(duplicate).limit(position2 + i).position(position2);
            } else {
                i = this.mByteBuffer.remaining();
                byteBuffer.put(this.mByteBuffer).limit(position2 + i).position(position2);
            }
            this.mByteBuffer.position(position + i);
            return AudioStream.PacketInfo.of(i, j);
        }
    }

    public BufferedAudioStream(@NonNull AudioStream audioStream, @NonNull AudioSettings audioSettings) {
        boolean z;
        boolean z2 = false;
        this.mAudioStream = audioStream;
        int bytesPerFrame = audioSettings.getBytesPerFrame();
        this.mBytesPerFrame = bytesPerFrame;
        int sampleRate = audioSettings.getSampleRate();
        this.mSampleRate = sampleRate;
        if (((long) bytesPerFrame) > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "mBytesPerFrame must be greater than 0.");
        Preconditions.checkArgument(((long) sampleRate) > 0 ? true : z2, "mSampleRate must be greater than 0.");
        this.mQueueMaxSize = 500;
        this.mBufferSize = bytesPerFrame * 1024;
    }

    private void checkNotReleasedOrThrow() {
        Preconditions.checkState(!this.mIsReleased.get(), "AudioStream has been released.");
    }

    private void checkStartedOrThrow() {
        Preconditions.checkState(this.mIsStarted.get(), "AudioStream has not been started.");
    }

    /* access modifiers changed from: private */
    public void collectAudioData() {
        if (this.mIsCollectingAudioData.get()) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.mBufferSize);
            AudioData audioData = new AudioData(allocateDirect, this.mAudioStream.read(allocateDirect), this.mBytesPerFrame, this.mSampleRate);
            int i = this.mQueueMaxSize;
            synchronized (this.mLock) {
                try {
                    this.mAudioDataQueue.offer(audioData);
                    while (this.mAudioDataQueue.size() > i) {
                        this.mAudioDataQueue.poll();
                        Logger.w(TAG, "Drop audio data due to full of queue.");
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            if (this.mIsCollectingAudioData.get()) {
                this.mProducerExecutor.execute(new j1(this, 2));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$release$2() {
        this.mIsCollectingAudioData.set(false);
        this.mAudioStream.release();
        synchronized (this.mLock) {
            this.mAudioDataNotFullyRead = null;
            this.mAudioDataQueue.clear();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setCallback$3(AudioStream.AudioStreamCallback audioStreamCallback, Executor executor) {
        this.mAudioStream.setCallback(audioStreamCallback, executor);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$start$0() {
        try {
            this.mAudioStream.start();
            startCollectingAudioData();
        } catch (AudioStream.AudioStreamException e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$stop$1() {
        this.mIsCollectingAudioData.set(false);
        this.mAudioStream.stop();
        synchronized (this.mLock) {
            this.mAudioDataNotFullyRead = null;
            this.mAudioDataQueue.clear();
        }
    }

    private void startCollectingAudioData() {
        if (!this.mIsCollectingAudioData.getAndSet(true)) {
            collectAudioData();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: updateCollectionBufferSize */
    public void lambda$updateCollectionBufferSizeAsync$4(int i) {
        int i2 = this.mBufferSize;
        if (i2 != i) {
            int i3 = this.mBytesPerFrame;
            this.mBufferSize = (i / i3) * i3;
            StringBuilder t = ba.t(i2, "Update buffer size from ", " to ");
            t.append(this.mBufferSize);
            Logger.d(TAG, t.toString());
        }
    }

    private void updateCollectionBufferSizeAsync(int i) {
        this.mProducerExecutor.execute(new k1(this, i, 0));
    }

    @SuppressLint({"BanThreadSleep"})
    @NonNull
    public AudioStream.PacketInfo read(@NonNull ByteBuffer byteBuffer) {
        boolean z;
        checkNotReleasedOrThrow();
        checkStartedOrThrow();
        updateCollectionBufferSizeAsync(byteBuffer.remaining());
        AudioStream.PacketInfo of = AudioStream.PacketInfo.of(0, 0);
        do {
            synchronized (this.mLock) {
                try {
                    AudioData audioData = this.mAudioDataNotFullyRead;
                    this.mAudioDataNotFullyRead = null;
                    if (audioData == null) {
                        audioData = this.mAudioDataQueue.poll();
                    }
                    if (audioData != null) {
                        of = audioData.read(byteBuffer);
                        if (audioData.getRemainingBufferSizeInBytes() > 0) {
                            this.mAudioDataNotFullyRead = audioData;
                        }
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            if (of.getSizeInBytes() > 0 || !this.mIsStarted.get() || this.mIsReleased.get()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                try {
                    Thread.sleep(1);
                    continue;
                } catch (InterruptedException e) {
                    Logger.w(TAG, "Interruption while waiting for audio data", e);
                }
            }
        } while (z);
        return of;
    }

    public void release() {
        if (!this.mIsReleased.getAndSet(true)) {
            this.mProducerExecutor.execute(new j1(this, 3));
        }
    }

    public void setCallback(@Nullable AudioStream.AudioStreamCallback audioStreamCallback, @Nullable Executor executor) {
        boolean z = true;
        Preconditions.checkState(!this.mIsStarted.get(), "AudioStream can not be started when setCallback.");
        checkNotReleasedOrThrow();
        if (audioStreamCallback != null && executor == null) {
            z = false;
        }
        Preconditions.checkArgument(z, "executor can't be null with non-null callback.");
        this.mProducerExecutor.execute(new m0(this, audioStreamCallback, executor));
    }

    public void start() throws AudioStream.AudioStreamException, IllegalStateException {
        checkNotReleasedOrThrow();
        if (!this.mIsStarted.getAndSet(true)) {
            FutureTask futureTask = new FutureTask(new j1(this, 1), (Object) null);
            this.mProducerExecutor.execute(futureTask);
            try {
                futureTask.get();
            } catch (InterruptedException | ExecutionException e) {
                this.mIsStarted.set(false);
                throw new AudioStream.AudioStreamException(e);
            }
        }
    }

    public void stop() throws IllegalStateException {
        checkNotReleasedOrThrow();
        if (this.mIsStarted.getAndSet(false)) {
            this.mProducerExecutor.execute(new j1(this, 0));
        }
    }
}
