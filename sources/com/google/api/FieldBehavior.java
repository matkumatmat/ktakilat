package com.google.api;

import com.google.protobuf.Internal;

public enum FieldBehavior implements Internal.EnumLite {
    FIELD_BEHAVIOR_UNSPECIFIED(0),
    OPTIONAL(1),
    REQUIRED(2),
    OUTPUT_ONLY(3),
    INPUT_ONLY(4),
    IMMUTABLE(5),
    UNRECOGNIZED(-1);
    
    public static final int FIELD_BEHAVIOR_UNSPECIFIED_VALUE = 0;
    public static final int IMMUTABLE_VALUE = 5;
    public static final int INPUT_ONLY_VALUE = 4;
    public static final int OPTIONAL_VALUE = 1;
    public static final int OUTPUT_ONLY_VALUE = 3;
    public static final int REQUIRED_VALUE = 2;
    public static final Internal.EnumLiteMap d = null;
    public final int c;

    /* renamed from: com.google.api.FieldBehavior$1  reason: invalid class name */
    public class AnonymousClass1 implements Internal.EnumLiteMap<FieldBehavior> {
        public final Internal.EnumLite findValueByNumber(int i) {
            return FieldBehavior.forNumber(i);
        }
    }

    public static final class FieldBehaviorVerifier implements Internal.EnumVerifier {

        /* renamed from: a  reason: collision with root package name */
        public static final Internal.EnumVerifier f264a = null;

        /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.Object, com.google.protobuf.Internal$EnumVerifier] */
        static {
            f264a = new Object();
        }

        public final boolean isInRange(int i) {
            if (FieldBehavior.forNumber(i) != null) {
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
    FieldBehavior(int i) {
        this.c = i;
    }

    public static FieldBehavior forNumber(int i) {
        if (i == 0) {
            return FIELD_BEHAVIOR_UNSPECIFIED;
        }
        if (i == 1) {
            return OPTIONAL;
        }
        if (i == 2) {
            return REQUIRED;
        }
        if (i == 3) {
            return OUTPUT_ONLY;
        }
        if (i == 4) {
            return INPUT_ONLY;
        }
        if (i != 5) {
            return null;
        }
        return IMMUTABLE;
    }

    public static Internal.EnumLiteMap<FieldBehavior> internalGetValueMap() {
        return d;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return FieldBehaviorVerifier.f264a;
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.c;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static FieldBehavior valueOf(int i) {
        return forNumber(i);
    }
}
