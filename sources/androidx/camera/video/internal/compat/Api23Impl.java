package androidx.camera.video.internal.compat;

import android.media.AudioFormat;
import android.media.AudioRecord;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;

@RequiresApi(23)
public final class Api23Impl {
    private Api23Impl() {
    }

    @RequiresPermission("android.permission.RECORD_AUDIO")
    @NonNull
    public static AudioRecord build(@NonNull AudioRecord.Builder builder) {
        return builder.build();
    }

    @NonNull
    public static AudioRecord.Builder createAudioRecordBuilder() {
        return new AudioRecord.Builder();
    }

    public static void setAudioFormat(@NonNull AudioRecord.Builder builder, @NonNull AudioFormat audioFormat) {
        builder.setAudioFormat(audioFormat);
    }

    public static void setAudioSource(@NonNull AudioRecord.Builder builder, int i) {
        builder.setAudioSource(i);
    }

    public static void setBufferSizeInBytes(@NonNull AudioRecord.Builder builder, int i) {
        builder.setBufferSizeInBytes(i);
    }
}
