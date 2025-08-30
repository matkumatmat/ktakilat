package com.google.type;

import com.google.protobuf.Internal;

public enum DayOfWeek implements Internal.EnumLite {
    DAY_OF_WEEK_UNSPECIFIED(0),
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7),
    UNRECOGNIZED(-1);
    
    public static final int DAY_OF_WEEK_UNSPECIFIED_VALUE = 0;
    public static final int FRIDAY_VALUE = 5;
    public static final int MONDAY_VALUE = 1;
    public static final int SATURDAY_VALUE = 6;
    public static final int SUNDAY_VALUE = 7;
    public static final int THURSDAY_VALUE = 4;
    public static final int TUESDAY_VALUE = 2;
    public static final int WEDNESDAY_VALUE = 3;
    public static final Internal.EnumLiteMap d = null;
    public final int c;

    /* renamed from: com.google.type.DayOfWeek$1  reason: invalid class name */
    public class AnonymousClass1 implements Internal.EnumLiteMap<DayOfWeek> {
        public final Internal.EnumLite findValueByNumber(int i) {
            return DayOfWeek.forNumber(i);
        }
    }

    public static final class DayOfWeekVerifier implements Internal.EnumVerifier {

        /* renamed from: a  reason: collision with root package name */
        public static final Internal.EnumVerifier f395a = null;

        /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.Object, com.google.protobuf.Internal$EnumVerifier] */
        static {
            f395a = new Object();
        }

        public final boolean isInRange(int i) {
            if (DayOfWeek.forNumber(i) != null) {
                return true;
            }
            return false;
        }
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [com.google.protobuf.Internal$EnumLiteMap, java.lang.Object] */
    static {
        d = new Object();
    }

    /* access modifiers changed from: public */
    DayOfWeek(int i) {
        this.c = i;
    }

    public static DayOfWeek forNumber(int i) {
        switch (i) {
            case 0:
                return DAY_OF_WEEK_UNSPECIFIED;
            case 1:
                return MONDAY;
            case 2:
                return TUESDAY;
            case 3:
                return WEDNESDAY;
            case 4:
                return THURSDAY;
            case 5:
                return FRIDAY;
            case 6:
                return SATURDAY;
            case 7:
                return SUNDAY;
            default:
                return null;
        }
    }

    public static Internal.EnumLiteMap<DayOfWeek> internalGetValueMap() {
        return d;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return DayOfWeekVerifier.f395a;
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.c;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static DayOfWeek valueOf(int i) {
        return forNumber(i);
    }
}
