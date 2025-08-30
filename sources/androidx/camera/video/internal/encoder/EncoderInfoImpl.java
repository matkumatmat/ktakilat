package androidx.camera.video.internal.encoder;

import android.media.MediaCodecInfo;
import androidx.annotation.NonNull;
import java.util.Objects;

public abstract class EncoderInfoImpl implements EncoderInfo {
    protected final MediaCodecInfo.CodecCapabilities mCodecCapabilities;
    private final MediaCodecInfo mMediaCodecInfo;

    public EncoderInfoImpl(@NonNull MediaCodecInfo mediaCodecInfo, @NonNull String str) throws InvalidConfigException {
        this.mMediaCodecInfo = mediaCodecInfo;
        try {
            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
            Objects.requireNonNull(capabilitiesForType);
            this.mCodecCapabilities = capabilitiesForType;
        } catch (RuntimeException e) {
            throw new InvalidConfigException(e.B("Unable to get CodecCapabilities for mime: ", str), e);
        }
    }

    @NonNull
    public String getName() {
        return this.mMediaCodecInfo.getName();
    }
}
