package androidx.camera.core;

import androidx.annotation.Nullable;
import androidx.camera.core.CameraState;

final class AutoValue_CameraState_StateError extends CameraState.StateError {
    private final Throwable cause;
    private final int code;

    public AutoValue_CameraState_StateError(int i, @Nullable Throwable th) {
        this.code = i;
        this.cause = th;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CameraState.StateError)) {
            return false;
        }
        CameraState.StateError stateError = (CameraState.StateError) obj;
        if (this.code == stateError.getCode()) {
            Throwable th = this.cause;
            if (th == null) {
                if (stateError.getCause() == null) {
                    return true;
                }
            } else if (th.equals(stateError.getCause())) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public Throwable getCause() {
        return this.cause;
    }

    public int getCode() {
        return this.code;
    }

    public int hashCode() {
        int i;
        int i2 = (this.code ^ 1000003) * 1000003;
        Throwable th = this.cause;
        if (th == null) {
            i = 0;
        } else {
            i = th.hashCode();
        }
        return i2 ^ i;
    }

    public String toString() {
        return "StateError{code=" + this.code + ", cause=" + this.cause + "}";
    }
}
