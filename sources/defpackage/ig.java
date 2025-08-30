package defpackage;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* renamed from: ig  reason: default package */
public abstract /* synthetic */ class ig {
    public static int a(String str) {
        str.getClass();
        if (str.equals(TypedValues.MotionScene.S_DEFAULT_DURATION)) {
            return 600;
        }
        if (!str.equals(TypedValues.MotionScene.S_LAYOUT_DURING_TRANSITION)) {
            return -1;
        }
        return 601;
    }

    public static int b(int i) {
        if (i == 600) {
            return 2;
        }
        if (i != 601) {
            return -1;
        }
        return 1;
    }
}
