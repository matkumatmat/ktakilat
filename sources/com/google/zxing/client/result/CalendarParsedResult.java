package com.google.zxing.client.result;

import java.util.regex.Pattern;

public final class CalendarParsedResult extends ParsedResult {
    static {
        Pattern.compile("P(?:(\\d+)W)?(?:(\\d+)D)?(?:T(?:(\\d+)H)?(?:(\\d+)M)?(?:(\\d+)S)?)?");
        Pattern.compile("[0-9]{8}(T[0-9]{6}Z?)?");
    }

    public final String a() {
        return new StringBuilder(100).toString();
    }
}
