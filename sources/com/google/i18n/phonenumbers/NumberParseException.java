package com.google.i18n.phonenumbers;

public class NumberParseException extends Exception {
    public final ErrorType c;
    public final String d;

    public enum ErrorType {
    }

    public NumberParseException(ErrorType errorType, String str) {
        super(str);
        this.d = str;
        this.c = errorType;
    }

    public ErrorType getErrorType() {
        return this.c;
    }

    public String toString() {
        return "Error type: " + this.c + ". " + this.d;
    }
}
