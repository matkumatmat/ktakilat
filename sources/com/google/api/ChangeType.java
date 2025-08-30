package com.google.api;

import com.google.protobuf.Internal;

public enum ChangeType implements Internal.EnumLite {
    CHANGE_TYPE_UNSPECIFIED(0),
    ADDED(1),
    REMOVED(2),
    MODIFIED(3),
    UNRECOGNIZED(-1);
    
    public static final int ADDED_VALUE = 1;
    public static final int CHANGE_TYPE_UNSPECIFIED_VALUE = 0;
    public static final int MODIFIED_VALUE = 3;
    public static final int REMOVED_VALUE = 2;
    public static final Internal.EnumLiteMap d = null;
    public final int c;

    /* renamed from: com.google.api.ChangeType$1  reason: invalid class name */
    public class AnonymousClass1 implements Internal.EnumLiteMap<ChangeType> {
        public final Internal.EnumLite findValueByNumber(int i) {
            return ChangeType.forNumber(i);
        }
    }

    public static final class ChangeTypeVerifier implements Internal.EnumVerifier {

        /* renamed from: a  reason: collision with root package name */
        public static final Internal.EnumVerifier f254a = null;

        /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.Object, com.google.protobuf.Internal$EnumVerifier] */
        static {
            f254a = new Object();
        }

        public final boolean isInRange(int i) {
            if (ChangeType.forNumber(i) != null) {
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
    ChangeType(int i) {
        this.c = i;
    }

    public static ChangeType forNumber(int i) {
        if (i == 0) {
            return CHANGE_TYPE_UNSPECIFIED;
        }
        if (i == 1) {
            return ADDED;
        }
        if (i == 2) {
            return REMOVED;
        }
        if (i != 3) {
            return null;
        }
        return MODIFIED;
    }

    public static Internal.EnumLiteMap<ChangeType> internalGetValueMap() {
        return d;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return ChangeTypeVerifier.f254a;
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.c;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static ChangeType valueOf(int i) {
        return forNumber(i);
    }
}
