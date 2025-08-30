package com.google.zxing.client.result;

import java.util.regex.Pattern;

public final class URIParsedResult extends ParsedResult {
    static {
        Pattern.compile(":/*([^/@]+)@[^/]+");
    }

    public final String a() {
        return new StringBuilder(30).toString();
    }
}
