package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.widget.R;

public class MotionEffect extends MotionHelper {
    public static final int AUTO = -1;
    public static final int EAST = 2;
    public static final int NORTH = 0;
    public static final int SOUTH = 1;
    public static final String TAG = "FadeMove";
    private static final int UNSET = -1;
    public static final int WEST = 3;
    private int fadeMove = -1;
    private float motionEffectAlpha = 0.1f;
    private int motionEffectEnd = 50;
    private int motionEffectStart = 49;
    private boolean motionEffectStrictMove = true;
    private int motionEffectTranslationX = 0;
    private int motionEffectTranslationY = 0;
    private int viewTransitionId = -1;

    public MotionEffect(Context context) {
        super(context);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MotionEffect);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.MotionEffect_motionEffect_start) {
                    int i2 = obtainStyledAttributes.getInt(index, this.motionEffectStart);
                    this.motionEffectStart = i2;
                    this.motionEffectStart = Math.max(Math.min(i2, 99), 0);
                } else if (index == R.styleable.MotionEffect_motionEffect_end) {
                    int i3 = obtainStyledAttributes.getInt(index, this.motionEffectEnd);
                    this.motionEffectEnd = i3;
                    this.motionEffectEnd = Math.max(Math.min(i3, 99), 0);
                } else if (index == R.styleable.MotionEffect_motionEffect_translationX) {
                    this.motionEffectTranslationX = obtainStyledAttributes.getDimensionPixelOffset(index, this.motionEffectTranslationX);
                } else if (index == R.styleable.MotionEffect_motionEffect_translationY) {
                    this.motionEffectTranslationY = obtainStyledAttributes.getDimensionPixelOffset(index, this.motionEffectTranslationY);
                } else if (index == R.styleable.MotionEffect_motionEffect_alpha) {
                    this.motionEffectAlpha = obtainStyledAttributes.getFloat(index, this.motionEffectAlpha);
                } else if (index == R.styleable.MotionEffect_motionEffect_move) {
                    this.fadeMove = obtainStyledAttributes.getInt(index, this.fadeMove);
                } else if (index == R.styleable.MotionEffect_motionEffect_strict) {
                    this.motionEffectStrictMove = obtainStyledAttributes.getBoolean(index, this.motionEffectStrictMove);
                } else if (index == R.styleable.MotionEffect_motionEffect_viewTransition) {
                    this.viewTransitionId = obtainStyledAttributes.getResourceId(index, this.viewTransitionId);
                }
            }
            int i4 = this.motionEffectStart;
            int i5 = this.motionEffectEnd;
            if (i4 == i5) {
                if (i4 > 0) {
                    this.motionEffectStart = i4 - 1;
                } else {
                    this.motionEffectEnd = i5 + 1;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public boolean isDecorator() {
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x016f, code lost:
        if (r14 == 0.0f) goto L_0x0174;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0183, code lost:
        if (r14 == 0.0f) goto L_0x0174;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0193, code lost:
        if (r15 == 0.0f) goto L_0x0174;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01a3, code lost:
        if (r15 == 0.0f) goto L_0x014b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01ce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPreSetup(androidx.constraintlayout.motion.widget.MotionLayout r23, java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r24) {
        /*
            r22 = this;
            r0 = r22
            r1 = r24
            android.view.ViewParent r2 = r22.getParent()
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
            android.view.View[] r2 = r0.getViews(r2)
            if (r2 != 0) goto L_0x0014
            androidx.constraintlayout.motion.widget.Debug.getLoc()
            return
        L_0x0014:
            androidx.constraintlayout.motion.widget.KeyAttributes r3 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r3.<init>()
            androidx.constraintlayout.motion.widget.KeyAttributes r4 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r4.<init>()
            float r5 = r0.motionEffectAlpha
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            java.lang.String r6 = "alpha"
            r3.setValue(r6, r5)
            float r5 = r0.motionEffectAlpha
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r4.setValue(r6, r5)
            int r5 = r0.motionEffectStart
            r3.setFramePosition(r5)
            int r5 = r0.motionEffectEnd
            r4.setFramePosition(r5)
            androidx.constraintlayout.motion.widget.KeyPosition r5 = new androidx.constraintlayout.motion.widget.KeyPosition
            r5.<init>()
            int r6 = r0.motionEffectStart
            r5.setFramePosition(r6)
            r6 = 0
            r5.setType(r6)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            java.lang.String r8 = "percentX"
            r5.setValue(r8, r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            java.lang.String r9 = "percentY"
            r5.setValue(r9, r7)
            androidx.constraintlayout.motion.widget.KeyPosition r7 = new androidx.constraintlayout.motion.widget.KeyPosition
            r7.<init>()
            int r10 = r0.motionEffectEnd
            r7.setFramePosition(r10)
            r7.setType(r6)
            r10 = 1
            java.lang.Integer r11 = java.lang.Integer.valueOf(r10)
            r7.setValue(r8, r11)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r10)
            r7.setValue(r9, r8)
            int r8 = r0.motionEffectTranslationX
            r9 = 0
            if (r8 <= 0) goto L_0x00a5
            androidx.constraintlayout.motion.widget.KeyAttributes r8 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r8.<init>()
            androidx.constraintlayout.motion.widget.KeyAttributes r11 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r11.<init>()
            int r12 = r0.motionEffectTranslationX
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.String r13 = "translationX"
            r8.setValue(r13, r12)
            int r12 = r0.motionEffectEnd
            r8.setFramePosition(r12)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r6)
            r11.setValue(r13, r12)
            int r12 = r0.motionEffectEnd
            int r12 = r12 - r10
            r11.setFramePosition(r12)
            goto L_0x00a7
        L_0x00a5:
            r8 = r9
            r11 = r8
        L_0x00a7:
            int r12 = r0.motionEffectTranslationY
            if (r12 <= 0) goto L_0x00d3
            androidx.constraintlayout.motion.widget.KeyAttributes r9 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r9.<init>()
            androidx.constraintlayout.motion.widget.KeyAttributes r12 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r12.<init>()
            int r13 = r0.motionEffectTranslationY
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            java.lang.String r14 = "translationY"
            r9.setValue(r14, r13)
            int r13 = r0.motionEffectEnd
            r9.setFramePosition(r13)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r6)
            r12.setValue(r14, r13)
            int r13 = r0.motionEffectEnd
            int r13 = r13 - r10
            r12.setFramePosition(r13)
            goto L_0x00d4
        L_0x00d3:
            r12 = r9
        L_0x00d4:
            int r13 = r0.fadeMove
            r14 = -1
            r17 = 0
            if (r13 != r14) goto L_0x013d
            r13 = 4
            int[] r14 = new int[r13]
            r13 = 0
        L_0x00df:
            int r15 = r2.length
            if (r13 >= r15) goto L_0x012c
            r15 = r2[r13]
            java.lang.Object r15 = r1.get(r15)
            androidx.constraintlayout.motion.widget.MotionController r15 = (androidx.constraintlayout.motion.widget.MotionController) r15
            if (r15 != 0) goto L_0x00ed
            goto L_0x0129
        L_0x00ed:
            float r20 = r15.getFinalX()
            float r21 = r15.getStartX()
            float r20 = r20 - r21
            float r21 = r15.getFinalY()
            float r15 = r15.getStartY()
            float r21 = r21 - r15
            int r15 = (r21 > r17 ? 1 : (r21 == r17 ? 0 : -1))
            if (r15 >= 0) goto L_0x010a
            r15 = r14[r10]
            int r15 = r15 + r10
            r14[r10] = r15
        L_0x010a:
            int r15 = (r21 > r17 ? 1 : (r21 == r17 ? 0 : -1))
            if (r15 <= 0) goto L_0x0113
            r15 = r14[r6]
            int r15 = r15 + r10
            r14[r6] = r15
        L_0x0113:
            int r15 = (r20 > r17 ? 1 : (r20 == r17 ? 0 : -1))
            if (r15 <= 0) goto L_0x011e
            r15 = 3
            r19 = r14[r15]
            int r19 = r19 + 1
            r14[r15] = r19
        L_0x011e:
            int r15 = (r20 > r17 ? 1 : (r20 == r17 ? 0 : -1))
            if (r15 >= 0) goto L_0x0129
            r15 = 2
            r16 = r14[r15]
            int r16 = r16 + 1
            r14[r15] = r16
        L_0x0129:
            int r13 = r13 + 1
            goto L_0x00df
        L_0x012c:
            r13 = r14[r6]
            r15 = r13
            r6 = 4
            r13 = 0
        L_0x0131:
            if (r10 >= r6) goto L_0x013d
            r6 = r14[r10]
            if (r15 >= r6) goto L_0x0139
            r15 = r6
            r13 = r10
        L_0x0139:
            int r10 = r10 + 1
            r6 = 4
            goto L_0x0131
        L_0x013d:
            r6 = 0
        L_0x013e:
            int r10 = r2.length
            if (r6 >= r10) goto L_0x01d9
            r10 = r2[r6]
            java.lang.Object r10 = r1.get(r10)
            androidx.constraintlayout.motion.widget.MotionController r10 = (androidx.constraintlayout.motion.widget.MotionController) r10
            if (r10 != 0) goto L_0x0150
        L_0x014b:
            r1 = r23
            r15 = -1
            goto L_0x01d3
        L_0x0150:
            float r14 = r10.getFinalX()
            float r15 = r10.getStartX()
            float r14 = r14 - r15
            float r15 = r10.getFinalY()
            float r18 = r10.getStartY()
            float r15 = r15 - r18
            if (r13 != 0) goto L_0x0176
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 <= 0) goto L_0x0172
            boolean r15 = r0.motionEffectStrictMove
            if (r15 == 0) goto L_0x0174
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 != 0) goto L_0x0172
            goto L_0x0174
        L_0x0172:
            r1 = 3
            goto L_0x01a6
        L_0x0174:
            r1 = 3
            goto L_0x01a5
        L_0x0176:
            r1 = 1
            if (r13 != r1) goto L_0x0186
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 >= 0) goto L_0x0172
            boolean r15 = r0.motionEffectStrictMove
            if (r15 == 0) goto L_0x0174
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 != 0) goto L_0x0172
            goto L_0x0174
        L_0x0186:
            r1 = 2
            if (r13 != r1) goto L_0x0196
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 >= 0) goto L_0x0172
            boolean r14 = r0.motionEffectStrictMove
            if (r14 == 0) goto L_0x0174
            int r14 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r14 != 0) goto L_0x0172
            goto L_0x0174
        L_0x0196:
            r1 = 3
            if (r13 != r1) goto L_0x01a6
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 <= 0) goto L_0x01a6
            boolean r14 = r0.motionEffectStrictMove
            if (r14 == 0) goto L_0x014b
            int r14 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r14 != 0) goto L_0x01a6
        L_0x01a5:
            goto L_0x014b
        L_0x01a6:
            int r14 = r0.viewTransitionId
            r15 = -1
            if (r14 != r15) goto L_0x01ce
            r10.addKey(r3)
            r10.addKey(r4)
            r10.addKey(r5)
            r10.addKey(r7)
            int r14 = r0.motionEffectTranslationX
            if (r14 <= 0) goto L_0x01c1
            r10.addKey(r8)
            r10.addKey(r11)
        L_0x01c1:
            int r14 = r0.motionEffectTranslationY
            if (r14 <= 0) goto L_0x01cb
            r10.addKey(r9)
            r10.addKey(r12)
        L_0x01cb:
            r1 = r23
            goto L_0x01d3
        L_0x01ce:
            r1 = r23
            r1.applyViewTransition(r14, r10)
        L_0x01d3:
            int r6 = r6 + 1
            r1 = r24
            goto L_0x013e
        L_0x01d9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.helper.widget.MotionEffect.onPreSetup(androidx.constraintlayout.motion.widget.MotionLayout, java.util.HashMap):void");
    }

    public MotionEffect(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public MotionEffect(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }
}
