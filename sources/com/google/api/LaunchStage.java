package com.google.api;

import com.google.protobuf.Internal;

public enum LaunchStage implements Internal.EnumLite {
    LAUNCH_STAGE_UNSPECIFIED(0),
    EARLY_ACCESS(1),
    ALPHA(2),
    BETA(3),
    GA(4),
    DEPRECATED(5),
    UNRECOGNIZED(-1);
    
    public static final int ALPHA_VALUE = 2;
    public static final int BETA_VALUE = 3;
    public static final int DEPRECATED_VALUE = 5;
    public static final int EARLY_ACCESS_VALUE = 1;
    public static final int GA_VALUE = 4;
    public static final int LAUNCH_STAGE_UNSPECIFIED_VALUE = 0;
    public static final Internal.EnumLiteMap d = null;
    public final int c;

    /* renamed from: com.google.api.LaunchStage$1  reason: invalid class name */
    public class AnonymousClass1 implements Internal.EnumLiteMap<LaunchStage> {
        public final Internal.EnumLite findValueByNumber(int i) {
            return LaunchStage.forNumber(i);
        }
    }

    public static final class LaunchStageVerifier implements Internal.EnumVerifier {

        /* renamed from: a  reason: collision with root package name */
        public static final Internal.EnumVerifier f271a = null;

        /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.Object, com.google.protobuf.Internal$EnumVerifier] */
        static {
            f271a = new Object();
        }

        public final boolean isInRange(int i) {
            if (LaunchStage.forNumber(i) != null) {
                return true;
            }
            return false;
        }
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [com.google.protobuf.Internal$EnumLiteMap, java.lang.Object] */
    static {
        d = new Object();
    }

    /* access modifiers changed from: public */
    LaunchStage(int i) {
        this.c = i;
    }

    public static LaunchStage forNumber(int i) {
        if (i == 0) {
            return LAUNCH_STAGE_UNSPECIFIED;
        }
        if (i == 1) {
            return EARLY_ACCESS;
        }
        if (i == 2) {
            return ALPHA;
        }
        if (i == 3) {
            return BETA;
        }
        if (i == 4) {
            return GA;
        }
        if (i != 5) {
            return null;
        }
        return DEPRECATED;
    }

    public static Internal.EnumLiteMap<LaunchStage> internalGetValueMap() {
        return d;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return LaunchStageVerifier.f271a;
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.c;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static LaunchStage valueOf(int i) {
        return forNumber(i);
    }
}
