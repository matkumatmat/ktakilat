package com.ktakilat.loan.weiget;

import com.google.firebase.crashlytics.FirebaseCrashlytics;

public class ErrorCaseUpload {

    public static class ErrorCaseException extends Exception {
        public ErrorCaseException(String str) {
            super(str);
        }
    }

    public static void a(String str) {
        try {
            FirebaseCrashlytics.getInstance().recordException(new ErrorCaseException(str));
        } catch (Exception unused) {
        }
    }
}
