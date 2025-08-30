package com.google.zxing;

public final class Dimension {
    public final boolean equals(Object obj) {
        if (!(obj instanceof Dimension)) {
            return false;
        }
        ((Dimension) obj).getClass();
        return true;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "0x0";
    }
}
