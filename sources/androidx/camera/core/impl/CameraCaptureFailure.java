package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CameraCaptureFailure {
    private final Reason mReason;

    public enum Reason {
        ERROR
    }

    public CameraCaptureFailure(@NonNull Reason reason) {
        this.mReason = reason;
    }

    @Nullable
    public Object getCaptureFailure() {
        return null;
    }

    @NonNull
    public Reason getReason() {
        return this.mReason;
    }
}
