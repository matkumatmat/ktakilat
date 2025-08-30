package com.google.zxing.client.result;

public final class ExpandedProductParsedResult extends ParsedResult {
    public final String a() {
        return "null";
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ExpandedProductParsedResult)) {
            return false;
        }
        ((ExpandedProductParsedResult) obj).getClass();
        return true;
    }

    public final int hashCode() {
        return 0;
    }
}
