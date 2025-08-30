package com.google.zxing;

public abstract class ReaderException extends Exception {
    public static final boolean c;
    public static final StackTraceElement[] d = new StackTraceElement[0];

    static {
        boolean z;
        if (System.getProperty("surefire.test.class.path") != null) {
            z = true;
        } else {
            z = false;
        }
        c = z;
    }

    public final synchronized Throwable fillInStackTrace() {
        return null;
    }
}
