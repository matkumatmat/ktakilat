package com.google.zxing.client.result;

public final class GeoParsedResult extends ParsedResult {
    public final String a() {
        StringBuilder sb = new StringBuilder(20);
        sb.append("0.0, 0.0");
        return sb.toString();
    }
}
