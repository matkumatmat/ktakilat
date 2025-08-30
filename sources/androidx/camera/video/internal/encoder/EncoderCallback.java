package androidx.camera.video.internal.encoder;

import androidx.annotation.NonNull;

public interface EncoderCallback {
    public static final EncoderCallback EMPTY = new EncoderCallback() {
        public void onEncodeError(@NonNull EncodeException encodeException) {
        }

        public final /* synthetic */ void onEncodePaused() {
            k6.a(this);
        }

        public void onEncodeStart() {
        }

        public void onEncodeStop() {
        }

        public void onEncodedData(@NonNull EncodedData encodedData) {
        }

        public void onOutputConfigUpdate(@NonNull OutputConfig outputConfig) {
        }
    };

    void onEncodeError(@NonNull EncodeException encodeException);

    void onEncodePaused();

    void onEncodeStart();

    void onEncodeStop();

    void onEncodedData(@NonNull EncodedData encodedData);

    void onOutputConfigUpdate(@NonNull OutputConfig outputConfig);
}
