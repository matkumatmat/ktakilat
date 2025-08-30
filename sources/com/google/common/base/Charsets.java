package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.nio.charset.Charset;
import org.apache.commons.lang3.CharEncoding;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Charsets {
    public static final Charset ISO_8859_1 = Charset.forName(CharEncoding.ISO_8859_1);
    @GwtIncompatible
    public static final Charset US_ASCII = Charset.forName(CharEncoding.US_ASCII);
    @GwtIncompatible
    public static final Charset UTF_16 = Charset.forName(CharEncoding.UTF_16);
    @GwtIncompatible
    public static final Charset UTF_16BE = Charset.forName(CharEncoding.UTF_16BE);
    @GwtIncompatible
    public static final Charset UTF_16LE = Charset.forName(CharEncoding.UTF_16LE);
    public static final Charset UTF_8 = Charset.forName(CharEncoding.UTF_8);

    private Charsets() {
    }
}
