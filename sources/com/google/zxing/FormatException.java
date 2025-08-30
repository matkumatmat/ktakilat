package com.google.zxing;

public final class FormatException extends ReaderException {
    public static final FormatException e;

    static {
        FormatException formatException = new FormatException();
        e = formatException;
        formatException.setStackTrace(ReaderException.d);
    }

    private FormatException() {
    }

    public static FormatException getFormatInstance() {
        return ReaderException.c ? new FormatException() : e;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [com.google.zxing.FormatException, java.lang.Exception] */
    public static FormatException getFormatInstance(Throwable th) {
        if (ReaderException.c) {
            return new Exception(th);
        }
        return e;
    }
}
