package com.google.zxing.client.result;

import java.util.regex.Pattern;

public final class EmailAddressResultParser extends ResultParser {
    static {
        Pattern.compile(",");
    }
}
