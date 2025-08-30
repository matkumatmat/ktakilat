package com.google.zxing;

public final class ChecksumException extends ReaderException {
    public static final ChecksumException e;

    static {
        ChecksumException checksumException = new ChecksumException();
        e = checksumException;
        checksumException.setStackTrace(ReaderException.d);
    }

    private ChecksumException() {
    }

    public static ChecksumException getChecksumInstance() {
        return ReaderException.c ? new ChecksumException() : e;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [com.google.zxing.ChecksumException, java.lang.Exception] */
    public static ChecksumException getChecksumInstance(Throwable th) {
        if (ReaderException.c) {
            return new Exception(th);
        }
        return e;
    }
}
