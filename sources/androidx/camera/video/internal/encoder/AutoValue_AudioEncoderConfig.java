package androidx.camera.video.internal.encoder;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.internal.encoder.AudioEncoderConfig;

final class AutoValue_AudioEncoderConfig extends AudioEncoderConfig {
    private final int bitrate;
    private final int channelCount;
    private final Timebase inputTimebase;
    private final String mimeType;
    private final int profile;
    private final int sampleRate;

    public static final class Builder extends AudioEncoderConfig.Builder {
        private Integer bitrate;
        private Integer channelCount;
        private Timebase inputTimebase;
        private String mimeType;
        private Integer profile;
        private Integer sampleRate;

        public AudioEncoderConfig autoBuild() {
            String str;
            if (this.mimeType == null) {
                str = " mimeType";
            } else {
                str = "";
            }
            if (this.profile == null) {
                str = e.l(str, " profile");
            }
            if (this.inputTimebase == null) {
                str = e.l(str, " inputTimebase");
            }
            if (this.bitrate == null) {
                str = e.l(str, " bitrate");
            }
            if (this.sampleRate == null) {
                str = e.l(str, " sampleRate");
            }
            if (this.channelCount == null) {
                str = e.l(str, " channelCount");
            }
            if (str.isEmpty()) {
                return new AutoValue_AudioEncoderConfig(this.mimeType, this.profile.intValue(), this.inputTimebase, this.bitrate.intValue(), this.sampleRate.intValue(), this.channelCount.intValue());
            }
            throw new IllegalStateException("Missing required properties:".concat(str));
        }

        public AudioEncoderConfig.Builder setBitrate(int i) {
            this.bitrate = Integer.valueOf(i);
            return this;
        }

        public AudioEncoderConfig.Builder setChannelCount(int i) {
            this.channelCount = Integer.valueOf(i);
            return this;
        }

        public AudioEncoderConfig.Builder setInputTimebase(Timebase timebase) {
            if (timebase != null) {
                this.inputTimebase = timebase;
                return this;
            }
            throw new NullPointerException("Null inputTimebase");
        }

        public AudioEncoderConfig.Builder setMimeType(String str) {
            if (str != null) {
                this.mimeType = str;
                return this;
            }
            throw new NullPointerException("Null mimeType");
        }

        public AudioEncoderConfig.Builder setProfile(int i) {
            this.profile = Integer.valueOf(i);
            return this;
        }

        public AudioEncoderConfig.Builder setSampleRate(int i) {
            this.sampleRate = Integer.valueOf(i);
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AudioEncoderConfig)) {
            return false;
        }
        AudioEncoderConfig audioEncoderConfig = (AudioEncoderConfig) obj;
        if (this.mimeType.equals(audioEncoderConfig.getMimeType()) && this.profile == audioEncoderConfig.getProfile() && this.inputTimebase.equals(audioEncoderConfig.getInputTimebase()) && this.bitrate == audioEncoderConfig.getBitrate() && this.sampleRate == audioEncoderConfig.getSampleRate() && this.channelCount == audioEncoderConfig.getChannelCount()) {
            return true;
        }
        return false;
    }

    public int getBitrate() {
        return this.bitrate;
    }

    public int getChannelCount() {
        return this.channelCount;
    }

    @NonNull
    public Timebase getInputTimebase() {
        return this.inputTimebase;
    }

    @NonNull
    public String getMimeType() {
        return this.mimeType;
    }

    public int getProfile() {
        return this.profile;
    }

    public int getSampleRate() {
        return this.sampleRate;
    }

    public int hashCode() {
        return ((((((((((this.mimeType.hashCode() ^ 1000003) * 1000003) ^ this.profile) * 1000003) ^ this.inputTimebase.hashCode()) * 1000003) ^ this.bitrate) * 1000003) ^ this.sampleRate) * 1000003) ^ this.channelCount;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioEncoderConfig{mimeType=");
        sb.append(this.mimeType);
        sb.append(", profile=");
        sb.append(this.profile);
        sb.append(", inputTimebase=");
        sb.append(this.inputTimebase);
        sb.append(", bitrate=");
        sb.append(this.bitrate);
        sb.append(", sampleRate=");
        sb.append(this.sampleRate);
        sb.append(", channelCount=");
        return ba.q(sb, "}", this.channelCount);
    }

    private AutoValue_AudioEncoderConfig(String str, int i, Timebase timebase, int i2, int i3, int i4) {
        this.mimeType = str;
        this.profile = i;
        this.inputTimebase = timebase;
        this.bitrate = i2;
        this.sampleRate = i3;
        this.channelCount = i4;
    }
}
