package com.google.zxing;

public final class NotFoundException extends ReaderException {
    public static final NotFoundException e;

    static {
        NotFoundException notFoundException = new NotFoundException();
        e = notFoundException;
        notFoundException.setStackTrace(ReaderException.d);
    }

    private NotFoundException() {
    }

    public static NotFoundException getNotFoundInstance() {
        return e;
    }
}
