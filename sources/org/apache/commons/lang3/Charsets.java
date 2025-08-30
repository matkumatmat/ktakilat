package org.apache.commons.lang3;

import java.nio.charset.Charset;

class Charsets {
    public static Charset toCharset(Charset charset) {
        return charset == null ? Charset.defaultCharset() : charset;
    }

    public static String toCharsetName(String str) {
        if (str == null) {
            return Charset.defaultCharset().name();
        }
        return str;
    }

    public static Charset toCharset(String str) {
        return str == null ? Charset.defaultCharset() : Charset.forName(str);
    }
}
