package com.google.android.material.transition.platform;

import android.graphics.RectF;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
class FitModeEvaluators {
    private static final FitModeEvaluator HEIGHT = new FitModeEvaluator() {
        public void applyMask(RectF rectF, float f, FitModeResult fitModeResult) {
            float abs = (Math.abs(fitModeResult.currentEndWidth - fitModeResult.currentStartWidth) / 2.0f) * f;
            rectF.left += abs;
            rectF.right -= abs;
        }

        public FitModeResult evaluate(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
            float lerp = TransitionUtils.lerp(f5, f7, f2, f3, f, true);
            float f8 = lerp / f5;
            float f9 = lerp / f7;
            return new FitModeResult(f8, f9, f4 * f8, lerp, f6 * f9, lerp);
        }

        public boolean shouldMaskStartBounds(FitModeResult fitModeResult) {
            if (fitModeResult.currentStartWidth > fitModeResult.currentEndWidth) {
                return true;
            }
            return false;
        }
    };
    private static final FitModeEvaluator WIDTH = new FitModeEvaluator() {
        public void applyMask(RectF rectF, float f, FitModeResult fitModeResult) {
            rectF.bottom -= Math.abs(fitModeResult.currentEndHeight - fitModeResult.currentStartHeight) * f;
        }

        public FitModeResult evaluate(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
            float lerp = TransitionUtils.lerp(f4, f6, f2, f3, f, true);
            float f8 = lerp / f4;
            float f9 = lerp / f6;
            return new FitModeResult(f8, f9, lerp, f5 * f8, lerp, f7 * f9);
        }

        public boolean shouldMaskStartBounds(FitModeResult fitModeResult) {
            if (fitModeResult.currentStartHeight > fitModeResult.currentEndHeight) {
                return true;
            }
            return false;
        }
    };

    private FitModeEvaluators() {
    }

    public static FitModeEvaluator get(int i, boolean z, RectF rectF, RectF rectF2) {
        if (i != 0) {
            if (i == 1) {
                return WIDTH;
            }
            if (i == 2) {
                return HEIGHT;
            }
            throw new IllegalArgumentException(ba.k(i, "Invalid fit mode: "));
        } else if (shouldAutoFitToWidth(z, rectF, rectF2)) {
            return WIDTH;
        } else {
            return HEIGHT;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x001e A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean shouldAutoFitToWidth(boolean r4, android.graphics.RectF r5, android.graphics.RectF r6) {
        /*
            float r0 = r5.width()
            float r5 = r5.height()
            float r1 = r6.width()
            float r6 = r6.height()
            float r2 = r6 * r0
            float r2 = r2 / r1
            float r1 = r1 * r5
            float r1 = r1 / r0
            r0 = 0
            r3 = 1
            if (r4 == 0) goto L_0x0020
            int r4 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r4 < 0) goto L_0x0025
        L_0x001e:
            r0 = 1
            goto L_0x0025
        L_0x0020:
            int r4 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r4 < 0) goto L_0x0025
            goto L_0x001e
        L_0x0025:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.transition.platform.FitModeEvaluators.shouldAutoFitToWidth(boolean, android.graphics.RectF, android.graphics.RectF):boolean");
    }
}
