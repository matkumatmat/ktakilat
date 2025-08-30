package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.utils.Easing;
import java.util.Arrays;
import java.util.HashMap;

public class MotionPaths implements Comparable<MotionPaths> {
    public static final int CARTESIAN = 0;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    public static final int PERPENDICULAR = 1;
    public static final int SCREEN = 2;
    public static final String TAG = "MotionPaths";
    static String[] names = {"position", "x", "y", "width", "height", "pathRotate"};
    HashMap<String, CustomVariable> customAttributes = new HashMap<>();
    float height;
    int mAnimateCircleAngleTo;
    int mAnimateRelativeTo = -1;
    int mDrawPath = 0;
    Easing mKeyFrameEasing;
    int mMode = 0;
    int mPathMotionArc = -1;
    float mPathRotate = Float.NaN;
    float mProgress = Float.NaN;
    float mRelativeAngle = Float.NaN;
    Motion mRelativeToController = null;
    double[] mTempDelta = new double[18];
    double[] mTempValue = new double[18];
    float position;
    float time;
    float width;
    float x;
    float y;

    public MotionPaths() {
    }

    private boolean diff(float f, float f2) {
        if (Float.isNaN(f) || Float.isNaN(f2)) {
            if (Float.isNaN(f) != Float.isNaN(f2)) {
                return true;
            }
            return false;
        } else if (Math.abs(f - f2) > 1.0E-6f) {
            return true;
        } else {
            return false;
        }
    }

    private static final float xRotate(float f, float f2, float f3, float f4, float f5, float f6) {
        return (((f5 - f3) * f2) - ((f6 - f4) * f)) + f3;
    }

    private static final float yRotate(float f, float f2, float f3, float f4, float f5, float f6) {
        return ((f6 - f4) * f2) + ((f5 - f3) * f) + f4;
    }

    public void applyParameters(MotionWidget motionWidget) {
        this.mKeyFrameEasing = Easing.getInterpolator(motionWidget.motion.mTransitionEasing);
        MotionWidget.Motion motion = motionWidget.motion;
        this.mPathMotionArc = motion.mPathMotionArc;
        this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
        this.mPathRotate = motion.mPathRotate;
        this.mDrawPath = motion.mDrawPath;
        this.mAnimateCircleAngleTo = motion.mAnimateCircleAngleTo;
        this.mProgress = motionWidget.propertySet.mProgress;
        this.mRelativeAngle = 0.0f;
        for (String next : motionWidget.getCustomAttributeNames()) {
            CustomVariable customAttribute = motionWidget.getCustomAttribute(next);
            if (customAttribute != null && customAttribute.isContinuous()) {
                this.customAttributes.put(next, customAttribute);
            }
        }
    }

    public void configureRelativeTo(Motion motion) {
        motion.getPos((double) this.mProgress);
    }

    public void different(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z) {
        boolean diff = diff(this.x, motionPaths.x);
        boolean diff2 = diff(this.y, motionPaths.y);
        zArr[0] = zArr[0] | diff(this.position, motionPaths.position);
        boolean z2 = diff | diff2 | z;
        zArr[1] = zArr[1] | z2;
        zArr[2] = z2 | zArr[2];
        zArr[3] = zArr[3] | diff(this.width, motionPaths.width);
        zArr[4] = diff(this.height, motionPaths.height) | zArr[4];
    }

    public void fillStandard(double[] dArr, int[] iArr) {
        float[] fArr = {this.position, this.x, this.y, this.width, this.height, this.mPathRotate};
        int i = 0;
        for (int i2 : iArr) {
            if (i2 < 6) {
                dArr[i] = (double) fArr[i2];
                i++;
            }
        }
    }

    public void getBounds(int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.width;
        float f2 = this.height;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f3 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 == 3) {
                f = f3;
            } else if (i3 == 4) {
                f2 = f3;
            }
        }
        fArr[i] = f;
        fArr[i + 1] = f2;
    }

    public void getCenter(double d, int[] iArr, double[] dArr, float[] fArr, int i) {
        int[] iArr2 = iArr;
        float f = this.x;
        float f2 = this.y;
        float f3 = this.width;
        float f4 = this.height;
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            float f5 = (float) dArr[i2];
            int i3 = iArr2[i2];
            if (i3 == 1) {
                f = f5;
            } else if (i3 == 2) {
                f2 = f5;
            } else if (i3 == 3) {
                f3 = f5;
            } else if (i3 == 4) {
                f4 = f5;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr2 = new float[2];
            motion.getCenter(d, fArr2, new float[2]);
            float f6 = fArr2[0];
            float f7 = fArr2[1];
            double d2 = (double) f6;
            double d3 = (double) f;
            double d4 = (double) f2;
            f = (float) (((Math.sin(d4) * d3) + d2) - ((double) (f3 / 2.0f)));
            f2 = (float) ((((double) f7) - (Math.cos(d4) * d3)) - ((double) (f4 / 2.0f)));
        }
        fArr[i] = (f3 / 2.0f) + f + 0.0f;
        fArr[i + 1] = (f4 / 2.0f) + f2 + 0.0f;
    }

    public void getCenterVelocity(double d, int[] iArr, double[] dArr, float[] fArr, int i) {
        int[] iArr2 = iArr;
        float f = this.x;
        float f2 = this.y;
        float f3 = this.width;
        float f4 = this.height;
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            float f5 = (float) dArr[i2];
            int i3 = iArr2[i2];
            if (i3 == 1) {
                f = f5;
            } else if (i3 == 2) {
                f2 = f5;
            } else if (i3 == 3) {
                f3 = f5;
            } else if (i3 == 4) {
                f4 = f5;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr2 = new float[2];
            motion.getCenter(d, fArr2, new float[2]);
            float f6 = fArr2[0];
            float f7 = fArr2[1];
            double d2 = (double) f6;
            double d3 = (double) f;
            double d4 = (double) f2;
            f = (float) (((Math.sin(d4) * d3) + d2) - ((double) (f3 / 2.0f)));
            f2 = (float) ((((double) f7) - (Math.cos(d4) * d3)) - ((double) (f4 / 2.0f)));
        }
        fArr[i] = (f3 / 2.0f) + f + 0.0f;
        fArr[i + 1] = (f4 / 2.0f) + f2 + 0.0f;
    }

    public int getCustomData(String str, double[] dArr, int i) {
        CustomVariable customVariable = this.customAttributes.get(str);
        int i2 = 0;
        if (customVariable == null) {
            return 0;
        }
        if (customVariable.numberOfInterpolatedValues() == 1) {
            dArr[i] = (double) customVariable.getValueToInterpolate();
            return 1;
        }
        int numberOfInterpolatedValues = customVariable.numberOfInterpolatedValues();
        float[] fArr = new float[numberOfInterpolatedValues];
        customVariable.getValuesToInterpolate(fArr);
        while (i2 < numberOfInterpolatedValues) {
            dArr[i] = (double) fArr[i2];
            i2++;
            i++;
        }
        return numberOfInterpolatedValues;
    }

    public int getCustomDataCount(String str) {
        CustomVariable customVariable = this.customAttributes.get(str);
        if (customVariable == null) {
            return 0;
        }
        return customVariable.numberOfInterpolatedValues();
    }

    public void getRect(int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.x;
        float f2 = this.y;
        float f3 = this.width;
        float f4 = this.height;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f5 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 == 1) {
                f = f5;
            } else if (i3 == 2) {
                f2 = f5;
            } else if (i3 == 3) {
                f3 = f5;
            } else if (i3 == 4) {
                f4 = f5;
            }
        }
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float centerX = motion.getCenterX();
            float centerY = this.mRelativeToController.getCenterY();
            double d = (double) f;
            double d2 = (double) f2;
            f2 = (float) ((((double) centerY) - (Math.cos(d2) * d)) - ((double) (f4 / 2.0f)));
            f = (float) (((Math.sin(d2) * d) + ((double) centerX)) - ((double) (f3 / 2.0f)));
        }
        float f6 = f3 + f;
        float f7 = f4 + f2;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        fArr[i] = f + 0.0f;
        fArr[i + 1] = f2 + 0.0f;
        fArr[i + 2] = f6 + 0.0f;
        fArr[i + 3] = f2 + 0.0f;
        fArr[i + 4] = f6 + 0.0f;
        int i4 = i + 6;
        fArr[i + 5] = f7 + 0.0f;
        fArr[i4] = f + 0.0f;
        fArr[i + 7] = f7 + 0.0f;
    }

    public boolean hasCustomData(String str) {
        return this.customAttributes.containsKey(str);
    }

    public void initCartesian(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f;
        float f2;
        float f3;
        float f4;
        MotionKeyPosition motionKeyPosition2 = motionKeyPosition;
        MotionPaths motionPaths3 = motionPaths;
        MotionPaths motionPaths4 = motionPaths2;
        float f5 = ((float) motionKeyPosition2.mFramePosition) / 100.0f;
        this.time = f5;
        this.mDrawPath = motionKeyPosition2.mDrawPath;
        if (Float.isNaN(motionKeyPosition2.mPercentWidth)) {
            f = f5;
        } else {
            f = motionKeyPosition2.mPercentWidth;
        }
        if (Float.isNaN(motionKeyPosition2.mPercentHeight)) {
            f2 = f5;
        } else {
            f2 = motionKeyPosition2.mPercentHeight;
        }
        float f6 = motionPaths4.width;
        float f7 = motionPaths3.width;
        float f8 = f6 - f7;
        float f9 = motionPaths4.height;
        float f10 = motionPaths3.height;
        float f11 = f9 - f10;
        this.position = this.time;
        float f12 = motionPaths3.x;
        float f13 = motionPaths3.y;
        float f14 = (f6 / 2.0f) + motionPaths4.x;
        float f15 = f14 - ((f7 / 2.0f) + f12);
        float f16 = ((f9 / 2.0f) + motionPaths4.y) - ((f10 / 2.0f) + f13);
        float f17 = f8 * f;
        float f18 = f17 / 2.0f;
        this.x = (float) ((int) (((f15 * f5) + f12) - f18));
        float f19 = (f16 * f5) + f13;
        float f20 = f11 * f2;
        float f21 = f20 / 2.0f;
        this.y = (float) ((int) (f19 - f21));
        this.width = (float) ((int) (f7 + f17));
        this.height = (float) ((int) (f10 + f20));
        MotionKeyPosition motionKeyPosition3 = motionKeyPosition;
        if (Float.isNaN(motionKeyPosition3.mPercentX)) {
            f3 = f5;
        } else {
            f3 = motionKeyPosition3.mPercentX;
        }
        float f22 = 0.0f;
        if (Float.isNaN(motionKeyPosition3.mAltPercentY)) {
            f4 = 0.0f;
        } else {
            f4 = motionKeyPosition3.mAltPercentY;
        }
        if (!Float.isNaN(motionKeyPosition3.mPercentY)) {
            f5 = motionKeyPosition3.mPercentY;
        }
        if (!Float.isNaN(motionKeyPosition3.mAltPercentX)) {
            f22 = motionKeyPosition3.mAltPercentX;
        }
        this.mMode = 0;
        MotionPaths motionPaths5 = motionPaths;
        float f23 = f22 * f16;
        this.x = (float) ((int) ((f23 + ((f3 * f15) + motionPaths5.x)) - f18));
        float f24 = f16 * f5;
        this.y = (float) ((int) ((f24 + ((f15 * f4) + motionPaths5.y)) - f21));
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition3.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition3.mPathMotionArc;
    }

    public void initPath(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f;
        float f2;
        float f3;
        MotionKeyPosition motionKeyPosition2 = motionKeyPosition;
        MotionPaths motionPaths3 = motionPaths;
        MotionPaths motionPaths4 = motionPaths2;
        float f4 = ((float) motionKeyPosition2.mFramePosition) / 100.0f;
        this.time = f4;
        this.mDrawPath = motionKeyPosition2.mDrawPath;
        if (Float.isNaN(motionKeyPosition2.mPercentWidth)) {
            f = f4;
        } else {
            f = motionKeyPosition2.mPercentWidth;
        }
        if (Float.isNaN(motionKeyPosition2.mPercentHeight)) {
            f2 = f4;
        } else {
            f2 = motionKeyPosition2.mPercentHeight;
        }
        float f5 = motionPaths4.width - motionPaths3.width;
        float f6 = motionPaths4.height - motionPaths3.height;
        this.position = this.time;
        if (!Float.isNaN(motionKeyPosition2.mPercentX)) {
            f4 = motionKeyPosition2.mPercentX;
        }
        float f7 = motionPaths3.x;
        float f8 = motionPaths3.width;
        float f9 = motionPaths3.y;
        float f10 = motionPaths3.height;
        float f11 = (motionPaths4.width / 2.0f) + motionPaths4.x;
        float f12 = f11 - ((f8 / 2.0f) + f7);
        float f13 = ((motionPaths4.height / 2.0f) + motionPaths4.y) - ((f10 / 2.0f) + f9);
        float f14 = f12 * f4;
        float f15 = f5 * f;
        float f16 = f15 / 2.0f;
        this.x = (float) ((int) ((f7 + f14) - f16));
        float f17 = f4 * f13;
        float f18 = f6 * f2;
        float f19 = f18 / 2.0f;
        this.y = (float) ((int) ((f9 + f17) - f19));
        this.width = (float) ((int) (f8 + f15));
        this.height = (float) ((int) (f10 + f18));
        MotionKeyPosition motionKeyPosition3 = motionKeyPosition;
        if (Float.isNaN(motionKeyPosition3.mPercentY)) {
            f3 = 0.0f;
        } else {
            f3 = motionKeyPosition3.mPercentY;
        }
        float f20 = (-f13) * f3;
        float f21 = f12 * f3;
        this.mMode = 1;
        MotionPaths motionPaths5 = motionPaths;
        this.x = ((float) ((int) ((motionPaths5.x + f14) - f16))) + f20;
        this.y = ((float) ((int) ((motionPaths5.y + f17) - f19))) + f21;
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition3.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition3.mPathMotionArc;
    }

    public void initPolar(int i, int i2, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7 = ((float) motionKeyPosition.mFramePosition) / 100.0f;
        this.time = f7;
        this.mDrawPath = motionKeyPosition.mDrawPath;
        this.mMode = motionKeyPosition.mPositionType;
        if (Float.isNaN(motionKeyPosition.mPercentWidth)) {
            f = f7;
        } else {
            f = motionKeyPosition.mPercentWidth;
        }
        if (Float.isNaN(motionKeyPosition.mPercentHeight)) {
            f2 = f7;
        } else {
            f2 = motionKeyPosition.mPercentHeight;
        }
        float f8 = motionPaths2.width;
        float f9 = motionPaths.width;
        float f10 = motionPaths2.height;
        float f11 = motionPaths.height;
        this.position = this.time;
        this.width = (float) ((int) (((f8 - f9) * f) + f9));
        this.height = (float) ((int) (((f10 - f11) * f2) + f11));
        int i3 = motionKeyPosition.mPositionType;
        if (i3 == 1) {
            if (Float.isNaN(motionKeyPosition.mPercentX)) {
                f3 = f7;
            } else {
                f3 = motionKeyPosition.mPercentX;
            }
            float f12 = motionPaths2.x;
            float f13 = motionPaths.x;
            this.x = e.a(f12, f13, f3, f13);
            if (!Float.isNaN(motionKeyPosition.mPercentY)) {
                f7 = motionKeyPosition.mPercentY;
            }
            float f14 = motionPaths2.y;
            float f15 = motionPaths.y;
            this.y = e.a(f14, f15, f7, f15);
        } else if (i3 != 2) {
            if (Float.isNaN(motionKeyPosition.mPercentX)) {
                f6 = f7;
            } else {
                f6 = motionKeyPosition.mPercentX;
            }
            float f16 = motionPaths2.x;
            float f17 = motionPaths.x;
            this.x = e.a(f16, f17, f6, f17);
            if (!Float.isNaN(motionKeyPosition.mPercentY)) {
                f7 = motionKeyPosition.mPercentY;
            }
            float f18 = motionPaths2.y;
            float f19 = motionPaths.y;
            this.y = e.a(f18, f19, f7, f19);
        } else {
            if (Float.isNaN(motionKeyPosition.mPercentX)) {
                float f20 = motionPaths2.x;
                float f21 = motionPaths.x;
                f4 = e.a(f20, f21, f7, f21);
            } else {
                f4 = Math.min(f2, f) * motionKeyPosition.mPercentX;
            }
            this.x = f4;
            if (Float.isNaN(motionKeyPosition.mPercentY)) {
                float f22 = motionPaths2.y;
                float f23 = motionPaths.y;
                f5 = e.a(f22, f23, f7, f23);
            } else {
                f5 = motionKeyPosition.mPercentY;
            }
            this.y = f5;
        }
        this.mAnimateRelativeTo = motionPaths.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition.mPathMotionArc;
    }

    public void initScreen(int i, int i2, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f;
        float f2;
        MotionKeyPosition motionKeyPosition2 = motionKeyPosition;
        MotionPaths motionPaths3 = motionPaths;
        MotionPaths motionPaths4 = motionPaths2;
        float f3 = ((float) motionKeyPosition2.mFramePosition) / 100.0f;
        this.time = f3;
        this.mDrawPath = motionKeyPosition2.mDrawPath;
        if (Float.isNaN(motionKeyPosition2.mPercentWidth)) {
            f = f3;
        } else {
            f = motionKeyPosition2.mPercentWidth;
        }
        if (Float.isNaN(motionKeyPosition2.mPercentHeight)) {
            f2 = f3;
        } else {
            f2 = motionKeyPosition2.mPercentHeight;
        }
        float f4 = motionPaths4.width;
        float f5 = motionPaths3.width;
        float f6 = f4 - f5;
        float f7 = motionPaths4.height;
        float f8 = motionPaths3.height;
        float f9 = f7 - f8;
        this.position = this.time;
        float f10 = motionPaths3.x;
        float f11 = motionPaths3.y;
        float f12 = (f4 / 2.0f) + motionPaths4.x;
        float f13 = (f7 / 2.0f) + motionPaths4.y;
        float f14 = f6 * f;
        this.x = (float) ((int) ((((f12 - ((f5 / 2.0f) + f10)) * f3) + f10) - (f14 / 2.0f)));
        float f15 = f9 * f2;
        this.y = (float) ((int) ((((f13 - ((f8 / 2.0f) + f11)) * f3) + f11) - (f15 / 2.0f)));
        this.width = (float) ((int) (f5 + f14));
        this.height = (float) ((int) (f8 + f15));
        this.mMode = 2;
        MotionKeyPosition motionKeyPosition3 = motionKeyPosition;
        if (!Float.isNaN(motionKeyPosition3.mPercentX)) {
            this.x = (float) ((int) (motionKeyPosition3.mPercentX * ((float) ((int) (((float) i) - this.width)))));
        }
        if (!Float.isNaN(motionKeyPosition3.mPercentY)) {
            this.y = (float) ((int) (motionKeyPosition3.mPercentY * ((float) ((int) (((float) i2) - this.height)))));
        }
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(motionKeyPosition3.mTransitionEasing);
        this.mPathMotionArc = motionKeyPosition3.mPathMotionArc;
    }

    public void setBounds(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.width = f3;
        this.height = f4;
    }

    public void setDpDt(float f, float f2, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        int[] iArr2 = iArr;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        for (int i = 0; i < iArr2.length; i++) {
            float f7 = (float) dArr[i];
            double d = dArr2[i];
            int i2 = iArr2[i];
            if (i2 == 1) {
                f3 = f7;
            } else if (i2 == 2) {
                f5 = f7;
            } else if (i2 == 3) {
                f4 = f7;
            } else if (i2 == 4) {
                f6 = f7;
            }
        }
        float f8 = f3 - ((0.0f * f4) / 2.0f);
        float f9 = f5 - ((0.0f * f6) / 2.0f);
        fArr[0] = (((f4 * 1.0f) + f8) * f) + ((1.0f - f) * f8) + 0.0f;
        fArr[1] = (((f6 * 1.0f) + f9) * f2) + ((1.0f - f2) * f9) + 0.0f;
    }

    public void setView(float f, MotionWidget motionWidget, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        float f2;
        float f3;
        MotionWidget motionWidget2 = motionWidget;
        int[] iArr2 = iArr;
        double[] dArr4 = dArr2;
        float f4 = this.x;
        float f5 = this.y;
        float f6 = this.width;
        float f7 = this.height;
        if (iArr2.length != 0 && this.mTempValue.length <= iArr2[iArr2.length - 1]) {
            int i = iArr2[iArr2.length - 1] + 1;
            this.mTempValue = new double[i];
            this.mTempDelta = new double[i];
        }
        Arrays.fill(this.mTempValue, Double.NaN);
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            double[] dArr5 = this.mTempValue;
            int i3 = iArr2[i2];
            dArr5[i3] = dArr[i2];
            this.mTempDelta[i3] = dArr4[i2];
        }
        float f8 = Float.NaN;
        int i4 = 0;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        while (true) {
            double[] dArr6 = this.mTempValue;
            if (i4 >= dArr6.length) {
                break;
            }
            double d = 0.0d;
            if (!Double.isNaN(dArr6[i4]) || !(dArr3 == null || dArr3[i4] == 0.0d)) {
                if (dArr3 != null) {
                    d = dArr3[i4];
                }
                if (!Double.isNaN(this.mTempValue[i4])) {
                    d = this.mTempValue[i4] + d;
                }
                f3 = f8;
                float f13 = (float) d;
                float f14 = (float) this.mTempDelta[i4];
                if (i4 == 1) {
                    f8 = f3;
                    f9 = f14;
                    f4 = f13;
                } else if (i4 == 2) {
                    f8 = f3;
                    f10 = f14;
                    f5 = f13;
                } else if (i4 == 3) {
                    f8 = f3;
                    f11 = f14;
                    f6 = f13;
                } else if (i4 == 4) {
                    f8 = f3;
                    f12 = f14;
                    f7 = f13;
                } else if (i4 == 5) {
                    f8 = f13;
                }
                i4++;
                double[] dArr7 = dArr2;
            } else {
                f3 = f8;
            }
            f8 = f3;
            i4++;
            double[] dArr72 = dArr2;
        }
        float f15 = f8;
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            motion.getCenter((double) f, fArr, fArr2);
            float f16 = fArr[0];
            float f17 = fArr[1];
            float f18 = fArr2[0];
            float f19 = fArr2[1];
            double d2 = (double) f4;
            double d3 = (double) f5;
            float sin = (float) (((Math.sin(d3) * d2) + ((double) f16)) - ((double) (f6 / 2.0f)));
            double d4 = (double) f9;
            float f20 = sin;
            double d5 = (double) f10;
            float cos = (float) ((Math.cos(d3) * d2 * d5) + (Math.sin(d3) * d4) + ((double) f18));
            f2 = f7;
            float cos2 = (float) ((((double) f17) - (Math.cos(d3) * d2)) - ((double) (f7 / 2.0f)));
            float sin2 = (float) ((Math.sin(d3) * d2 * d5) + (((double) f19) - (Math.cos(d3) * d4)));
            double[] dArr8 = dArr2;
            if (dArr8.length >= 2) {
                dArr8[0] = (double) cos;
                dArr8[1] = (double) sin2;
            }
            if (!Float.isNaN(f15)) {
                motionWidget2.setRotationZ((float) (Math.toDegrees(Math.atan2((double) sin2, (double) cos)) + ((double) f15)));
            }
            f4 = f20;
            f5 = cos2;
        } else {
            float f21 = f15;
            f2 = f7;
            if (!Float.isNaN(f21)) {
                motionWidget2.setRotationZ((float) (Math.toDegrees(Math.atan2((double) ((f12 / 2.0f) + f10), (double) ((f11 / 2.0f) + f9))) + ((double) f21) + ((double) 0.0f)));
            }
        }
        float f22 = f4 + 0.5f;
        float f23 = f5 + 0.5f;
        motionWidget2.layout((int) f22, (int) f23, (int) (f22 + f6), (int) (f23 + f2));
    }

    public void setupRelative(Motion motion, MotionPaths motionPaths) {
        double d = (double) ((((this.width / 2.0f) + this.x) - motionPaths.x) - (motionPaths.width / 2.0f));
        double d2 = (double) ((((this.height / 2.0f) + this.y) - motionPaths.y) - (motionPaths.height / 2.0f));
        this.mRelativeToController = motion;
        this.x = (float) Math.hypot(d2, d);
        if (Float.isNaN(this.mRelativeAngle)) {
            this.y = (float) (Math.atan2(d2, d) + 1.5707963267948966d);
        } else {
            this.y = (float) Math.toRadians((double) this.mRelativeAngle);
        }
    }

    public int compareTo(MotionPaths motionPaths) {
        return Float.compare(this.position, motionPaths.position);
    }

    public MotionPaths(int i, int i2, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        if (motionPaths.mAnimateRelativeTo != -1) {
            initPolar(i, i2, motionKeyPosition, motionPaths, motionPaths2);
            return;
        }
        int i3 = motionKeyPosition.mPositionType;
        if (i3 == 1) {
            initPath(motionKeyPosition, motionPaths, motionPaths2);
        } else if (i3 != 2) {
            initCartesian(motionKeyPosition, motionPaths, motionPaths2);
        } else {
            initScreen(i, i2, motionKeyPosition, motionPaths, motionPaths2);
        }
    }

    public void getCenter(double d, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        int[] iArr2 = iArr;
        float f = this.x;
        float f2 = this.y;
        float f3 = this.width;
        float f4 = this.height;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        for (int i = 0; i < iArr2.length; i++) {
            float f9 = (float) dArr[i];
            float f10 = (float) dArr2[i];
            int i2 = iArr2[i];
            if (i2 == 1) {
                f = f9;
                f5 = f10;
            } else if (i2 == 2) {
                f2 = f9;
                f7 = f10;
            } else if (i2 == 3) {
                f3 = f9;
                f6 = f10;
            } else if (i2 == 4) {
                f4 = f9;
                f8 = f10;
            }
        }
        float f11 = 2.0f;
        float f12 = (f6 / 2.0f) + f5;
        float f13 = (f8 / 2.0f) + f7;
        Motion motion = this.mRelativeToController;
        if (motion != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            motion.getCenter(d, fArr3, fArr4);
            float f14 = fArr3[0];
            float f15 = fArr3[1];
            float f16 = fArr4[0];
            double d2 = (double) f;
            float f17 = fArr4[1];
            double d3 = (double) f2;
            f2 = (float) ((((double) f15) - (Math.cos(d3) * d2)) - ((double) (f4 / 2.0f)));
            double d4 = (double) f5;
            double sin = (Math.sin(d3) * d4) + ((double) f16);
            float sin2 = (float) (((Math.sin(d3) * d2) + ((double) f14)) - ((double) (f3 / 2.0f)));
            double d5 = (double) f7;
            f13 = (float) ((Math.sin(d3) * d5) + (((double) f17) - (Math.cos(d3) * d4)));
            f12 = (float) ((Math.cos(d3) * d5) + sin);
            f = sin2;
            f11 = 2.0f;
        }
        fArr[0] = (f3 / f11) + f + 0.0f;
        fArr[1] = (f4 / f11) + f2 + 0.0f;
        fArr2[0] = f12;
        fArr2[1] = f13;
    }
}
