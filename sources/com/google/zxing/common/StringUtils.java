package com.google.zxing.common;

import java.nio.charset.Charset;

public final class StringUtils {
    static {
        String name = Charset.defaultCharset().name();
        if (!"SJIS".equalsIgnoreCase(name)) {
            "EUC_JP".equalsIgnoreCase(name);
        }
    }
}
