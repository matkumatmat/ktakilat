package com.google.logging.type;

import com.google.protobuf.Internal;

public enum LogSeverity implements Internal.EnumLite {
    DEFAULT(0),
    DEBUG(100),
    INFO(200),
    NOTICE(300),
    WARNING(WARNING_VALUE),
    ERROR(500),
    CRITICAL(600),
    ALERT(700),
    EMERGENCY(EMERGENCY_VALUE),
    UNRECOGNIZED(-1);
    
    public static final int ALERT_VALUE = 700;
    public static final int CRITICAL_VALUE = 600;
    public static final int DEBUG_VALUE = 100;
    public static final int DEFAULT_VALUE = 0;
    public static final int EMERGENCY_VALUE = 800;
    public static final int ERROR_VALUE = 500;
    public static final int INFO_VALUE = 200;
    public static final int NOTICE_VALUE = 300;
    public static final int WARNING_VALUE = 400;
    public static final Internal.EnumLiteMap d = null;
    public final int c;

    /* renamed from: com.google.logging.type.LogSeverity$1  reason: invalid class name */
    public class AnonymousClass1 implements Internal.EnumLiteMap<LogSeverity> {
        public final Internal.EnumLite findValueByNumber(int i) {
            return LogSeverity.forNumber(i);
        }
    }

    public static final class LogSeverityVerifier implements Internal.EnumVerifier {

        /* renamed from: a  reason: collision with root package name */
        public static final Internal.EnumVerifier f332a = null;

        /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.Object, com.google.protobuf.Internal$EnumVerifier] */
        static {
            f332a = new Object();
        }

        public final boolean isInRange(int i) {
            if (LogSeverity.forNumber(i) != null) {
                return true;
            }
            return false;
        }
    }

    /* JADX WARNING: type inference failed for: r0v7, types: [com.google.protobuf.Internal$EnumLiteMap, java.lang.Object] */
    static {
        d = new Object();
    }

    /* access modifiers changed from: public */
    LogSeverity(int i) {
        this.c = i;
    }

    public static LogSeverity forNumber(int i) {
        if (i == 0) {
            return DEFAULT;
        }
        if (i == 100) {
            return DEBUG;
        }
        if (i == 200) {
            return INFO;
        }
        if (i == 300) {
            return NOTICE;
        }
        if (i == 400) {
            return WARNING;
        }
        if (i == 500) {
            return ERROR;
        }
        if (i == 600) {
            return CRITICAL;
        }
        if (i == 700) {
            return ALERT;
        }
        if (i != 800) {
            return null;
        }
        return EMERGENCY;
    }

    public static Internal.EnumLiteMap<LogSeverity> internalGetValueMap() {
        return d;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return LogSeverityVerifier.f332a;
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.c;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static LogSeverity valueOf(int i) {
        return forNumber(i);
    }
}
