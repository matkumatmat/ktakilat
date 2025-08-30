package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.camera.video.MediaSpec;

final class AutoValue_MediaSpec extends MediaSpec {
    private final AudioSpec audioSpec;
    private final int outputFormat;
    private final VideoSpec videoSpec;

    public static final class Builder extends MediaSpec.Builder {
        private AudioSpec audioSpec;
        private Integer outputFormat;
        private VideoSpec videoSpec;

        public MediaSpec build() {
            String str;
            if (this.videoSpec == null) {
                str = " videoSpec";
            } else {
                str = "";
            }
            if (this.audioSpec == null) {
                str = e.l(str, " audioSpec");
            }
            if (this.outputFormat == null) {
                str = e.l(str, " outputFormat");
            }
            if (str.isEmpty()) {
                return new AutoValue_MediaSpec(this.videoSpec, this.audioSpec, this.outputFormat.intValue());
            }
            throw new IllegalStateException("Missing required properties:".concat(str));
        }

        public AudioSpec getAudioSpec() {
            AudioSpec audioSpec2 = this.audioSpec;
            if (audioSpec2 != null) {
                return audioSpec2;
            }
            throw new IllegalStateException("Property \"audioSpec\" has not been set");
        }

        public VideoSpec getVideoSpec() {
            VideoSpec videoSpec2 = this.videoSpec;
            if (videoSpec2 != null) {
                return videoSpec2;
            }
            throw new IllegalStateException("Property \"videoSpec\" has not been set");
        }

        public MediaSpec.Builder setAudioSpec(AudioSpec audioSpec2) {
            if (audioSpec2 != null) {
                this.audioSpec = audioSpec2;
                return this;
            }
            throw new NullPointerException("Null audioSpec");
        }

        public MediaSpec.Builder setOutputFormat(int i) {
            this.outputFormat = Integer.valueOf(i);
            return this;
        }

        public MediaSpec.Builder setVideoSpec(VideoSpec videoSpec2) {
            if (videoSpec2 != null) {
                this.videoSpec = videoSpec2;
                return this;
            }
            throw new NullPointerException("Null videoSpec");
        }

        public Builder() {
        }

        private Builder(MediaSpec mediaSpec) {
            this.videoSpec = mediaSpec.getVideoSpec();
            this.audioSpec = mediaSpec.getAudioSpec();
            this.outputFormat = Integer.valueOf(mediaSpec.getOutputFormat());
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MediaSpec)) {
            return false;
        }
        MediaSpec mediaSpec = (MediaSpec) obj;
        if (!this.videoSpec.equals(mediaSpec.getVideoSpec()) || !this.audioSpec.equals(mediaSpec.getAudioSpec()) || this.outputFormat != mediaSpec.getOutputFormat()) {
            return false;
        }
        return true;
    }

    @NonNull
    public AudioSpec getAudioSpec() {
        return this.audioSpec;
    }

    public int getOutputFormat() {
        return this.outputFormat;
    }

    @NonNull
    public VideoSpec getVideoSpec() {
        return this.videoSpec;
    }

    public int hashCode() {
        return ((((this.videoSpec.hashCode() ^ 1000003) * 1000003) ^ this.audioSpec.hashCode()) * 1000003) ^ this.outputFormat;
    }

    public MediaSpec.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MediaSpec{videoSpec=");
        sb.append(this.videoSpec);
        sb.append(", audioSpec=");
        sb.append(this.audioSpec);
        sb.append(", outputFormat=");
        return ba.q(sb, "}", this.outputFormat);
    }

    private AutoValue_MediaSpec(VideoSpec videoSpec2, AudioSpec audioSpec2, int i) {
        this.videoSpec = videoSpec2;
        this.audioSpec = audioSpec2;
        this.outputFormat = i;
    }
}
