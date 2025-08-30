package com.google.zxing;

public class ResultPoint {
    public final boolean equals(Object obj) {
        if (!(obj instanceof ResultPoint)) {
            return false;
        }
        ((ResultPoint) obj).getClass();
        return true;
    }

    public final int hashCode() {
        return Float.floatToIntBits(0.0f) + (Float.floatToIntBits(0.0f) * 31);
    }

    public final String toString() {
        return "(0.0,0.0)";
    }
}
