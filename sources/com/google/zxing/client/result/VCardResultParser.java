package com.google.zxing.client.result;

import java.util.regex.Pattern;

public final class VCardResultParser extends ResultParser {
    static {
        Pattern.compile("BEGIN:VCARD", 2);
        Pattern.compile("\\d{4}-?\\d{2}-?\\d{2}");
        Pattern.compile("\r\n[ \t]");
        Pattern.compile("\\\\[nN]");
        Pattern.compile("\\\\([,;\\\\])");
        Pattern.compile("=");
        Pattern.compile(";");
        Pattern.compile("(?<!\\\\);+");
        Pattern.compile(",");
        Pattern.compile("[;,]");
    }
}
