package androidx.camera.core.impl.utils;

import androidx.annotation.NonNull;
import com.google.firebase.sessions.settings.RemoteSettings;

final class LongRational {
    private final long mDenominator;
    private final long mNumerator;

    public LongRational(long j, long j2) {
        this.mNumerator = j;
        this.mDenominator = j2;
    }

    public long getDenominator() {
        return this.mDenominator;
    }

    public long getNumerator() {
        return this.mNumerator;
    }

    public double toDouble() {
        return ((double) this.mNumerator) / ((double) this.mDenominator);
    }

    @NonNull
    public String toString() {
        return this.mNumerator + RemoteSettings.FORWARD_SLASH_STRING + this.mDenominator;
    }

    public LongRational(double d) {
        this((long) (d * 10000.0d), 10000);
    }
}
