package androidx.camera.view.video;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;

public class AudioConfig {
    @NonNull
    public static final AudioConfig AUDIO_DISABLED = new AudioConfig(false);
    private final boolean mIsAudioEnabled;

    public AudioConfig(boolean z) {
        this.mIsAudioEnabled = z;
    }

    @RequiresPermission("android.permission.RECORD_AUDIO")
    @NonNull
    public static AudioConfig create(boolean z) {
        return new AudioConfig(z);
    }

    public boolean getAudioEnabled() {
        return this.mIsAudioEnabled;
    }
}
