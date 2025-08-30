package com.google.zxing.client.result;

import java.util.regex.Pattern;

public final class VINResultParser extends ResultParser {
    static {
        Pattern.compile("[IOQ]");
        Pattern.compile("[A-Z0-9]{17}");
    }
}
