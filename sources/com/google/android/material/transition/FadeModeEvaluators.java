package com.google.android.material.transition;

class FadeModeEvaluators {
    private static final FadeModeEvaluator CROSS = new FadeModeEvaluator() {
        public FadeModeResult evaluate(float f, float f2, float f3, float f4) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f2, f3, f), TransitionUtils.lerp(0, 255, f2, f3, f));
        }
    };
    private static final FadeModeEvaluator IN = new FadeModeEvaluator() {
        public FadeModeResult evaluate(float f, float f2, float f3, float f4) {
            return FadeModeResult.endOnTop(255, TransitionUtils.lerp(0, 255, f2, f3, f));
        }
    };
    private static final FadeModeEvaluator OUT = new FadeModeEvaluator() {
        public FadeModeResult evaluate(float f, float f2, float f3, float f4) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f2, f3, f), 255);
        }
    };
    private static final FadeModeEvaluator THROUGH = new FadeModeEvaluator() {
        public FadeModeResult evaluate(float f, float f2, float f3, float f4) {
            float a2 = e.a(f3, f2, f4, f2);
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f2, a2, f), TransitionUtils.lerp(0, 255, a2, f3, f));
        }
    };

    private FadeModeEvaluators() {
    }

    public static FadeModeEvaluator get(int i, boolean z) {
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    return CROSS;
                }
                if (i == 3) {
                    return THROUGH;
                }
                throw new IllegalArgumentException(ba.k(i, "Invalid fade mode: "));
            } else if (z) {
                return OUT;
            } else {
                return IN;
            }
        } else if (z) {
            return IN;
        } else {
            return OUT;
        }
    }
}
