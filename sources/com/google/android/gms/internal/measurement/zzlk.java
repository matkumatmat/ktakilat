package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Locale;

public final class zzlk extends IOException {
    public zzlk() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzlk(long j, long j2, int i, Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat("Pos: " + j + ", limit: " + j2 + ", len: " + i), th);
        Locale locale = Locale.US;
    }

    public zzlk(Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
    }
}
