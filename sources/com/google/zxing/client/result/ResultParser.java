package com.google.zxing.client.result;

import java.util.regex.Pattern;

public abstract class ResultParser {
    static {
        Pattern.compile("\\d+");
        Pattern.compile("&");
        Pattern.compile("=");
    }
}
