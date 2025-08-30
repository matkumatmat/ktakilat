package com.google.zxing.client.result;

public final class WifiParsedResult extends ParsedResult {
    public final String a() {
        StringBuilder sb = new StringBuilder(80);
        String bool = Boolean.toString(false);
        if (bool != null && !bool.isEmpty()) {
            if (sb.length() > 0) {
                sb.append(10);
            }
            sb.append(bool);
        }
        return sb.toString();
    }
}
