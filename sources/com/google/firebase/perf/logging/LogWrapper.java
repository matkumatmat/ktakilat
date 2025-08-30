package com.google.firebase.perf.logging;

import android.util.Log;

class LogWrapper {
    private static final String LOG_TAG = "FirebasePerformance";
    private static LogWrapper instance;

    private LogWrapper() {
    }

    public static synchronized LogWrapper getInstance() {
        LogWrapper logWrapper;
        synchronized (LogWrapper.class) {
            try {
                if (instance == null) {
                    instance = new LogWrapper();
                }
                logWrapper = instance;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return logWrapper;
    }

    public void d(String str) {
    }

    public void e(String str) {
        Log.e(LOG_TAG, str);
    }

    public void i(String str) {
    }

    public void v(String str) {
    }

    public void w(String str) {
        Log.w(LOG_TAG, str);
    }
}
