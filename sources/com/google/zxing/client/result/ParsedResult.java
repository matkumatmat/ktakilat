package com.google.zxing.client.result;

public abstract class ParsedResult {
    public abstract String a();

    public final String toString() {
        return a();
    }
}
