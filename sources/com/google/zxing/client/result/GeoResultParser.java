package com.google.zxing.client.result;

import java.util.regex.Pattern;

public final class GeoResultParser extends ResultParser {
    static {
        Pattern.compile("geo:([\\-0-9.]+),([\\-0-9.]+)(?:,([\\-0-9.]+))?(?:\\?(.*))?", 2);
    }
}
