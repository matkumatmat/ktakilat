package com.google.zxing.qrcode.decoder;

final class FormatInformation {
    public final boolean equals(Object obj) {
        if (!(obj instanceof FormatInformation)) {
            return false;
        }
        ((FormatInformation) obj).getClass();
        return true;
    }

    public final int hashCode() {
        throw null;
    }
}
