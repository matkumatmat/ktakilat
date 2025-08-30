package androidx.constraintlayout.motion.utils;

public class CustomSupport {
    private static final String TAG = "CustomSupport";

    /* renamed from: androidx.constraintlayout.motion.utils.CustomSupport$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.constraintlayout.widget.ConstraintAttribute$AttributeType[] r0 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType = r0
                androidx.constraintlayout.widget.ConstraintAttribute$AttributeType r1 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.INT_TYPE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.widget.ConstraintAttribute$AttributeType r1 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.FLOAT_TYPE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.widget.ConstraintAttribute$AttributeType r1 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.COLOR_DRAWABLE_TYPE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.widget.ConstraintAttribute$AttributeType r1 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.COLOR_TYPE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.constraintlayout.widget.ConstraintAttribute$AttributeType r1 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.STRING_TYPE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.constraintlayout.widget.ConstraintAttribute$AttributeType r1 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.BOOLEAN_TYPE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.constraintlayout.widget.ConstraintAttribute$AttributeType r1 = androidx.constraintlayout.widget.ConstraintAttribute.AttributeType.DIMENSION_TYPE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.utils.CustomSupport.AnonymousClass1.<clinit>():void");
        }
    }

    private static int clamp(int i) {
        int i2 = (i & (~(i >> 31))) - 255;
        return (i2 & (i2 >> 31)) + 255;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0058, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0059, code lost:
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005a, code lost:
        r15 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005e, code lost:
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00f4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00f7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00f8, code lost:
        r3 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00fb, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00fc, code lost:
        r2 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0100, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0101, code lost:
        r2 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0104, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0105, code lost:
        r2 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0109, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x010a, code lost:
        r2 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0112, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0113, code lost:
        r2 = r1;
        r15 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01b2, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01b6, code lost:
        r1 = defpackage.e.t("cannot access method ", r8, " on View \"");
        r1.append(androidx.constraintlayout.motion.widget.Debug.getName(r17));
        r1.append(r15);
        android.util.Log.e(TAG, r1.toString());
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0055, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0058 A[Catch:{ NoSuchMethodException -> 0x005d, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }, ExcHandler: IllegalAccessException (e java.lang.IllegalAccessException), Splitter:B:1:0x0022] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0055 A[Catch:{ NoSuchMethodException -> 0x005d, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }, ExcHandler: InvocationTargetException (r0v6 'e' java.lang.reflect.InvocationTargetException A[CUSTOM_DECLARE, Catch:{ NoSuchMethodException -> 0x005d, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }]), Splitter:B:1:0x0022] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void setInterpolatedValue(androidx.constraintlayout.widget.ConstraintAttribute r16, android.view.View r17, float[] r18) {
        /*
            r1 = r17
            r0 = 0
            r2 = 1
            java.lang.String r3 = "\""
            java.lang.String r4 = " on View \""
            java.lang.String r5 = "CustomSupport"
            java.lang.String r6 = "unable to interpolate strings "
            java.lang.Class r7 = r17.getClass()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "set"
            r8.<init>(r9)
            java.lang.String r9 = r16.getName()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            int[] r9 = androidx.constraintlayout.motion.utils.CustomSupport.AnonymousClass1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType     // Catch:{ NoSuchMethodException -> 0x005d, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
            androidx.constraintlayout.widget.ConstraintAttribute$AttributeType r10 = r16.getType()     // Catch:{ NoSuchMethodException -> 0x010f, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
            int r10 = r10.ordinal()     // Catch:{ NoSuchMethodException -> 0x010f, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
            r9 = r9[r10]     // Catch:{ NoSuchMethodException -> 0x010f, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
            r10 = 3
            r11 = 2
            r12 = 4601859982876761367(0x3fdd1745d1745d17, double:0.45454545454545453)
            r14 = 1132396544(0x437f0000, float:255.0)
            switch(r9) {
                case 1: goto L_0x0194;
                case 2: goto L_0x0177;
                case 3: goto L_0x0116;
                case 4: goto L_0x0099;
                case 5: goto L_0x0083;
                case 6: goto L_0x0061;
                case 7: goto L_0x003c;
                default: goto L_0x003a;
            }
        L_0x003a:
            goto L_0x01ec
        L_0x003c:
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x005d, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
            java.lang.Class r9 = java.lang.Float.TYPE     // Catch:{ NoSuchMethodException -> 0x005d, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
            r6[r0] = r9     // Catch:{ NoSuchMethodException -> 0x005d, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
            java.lang.reflect.Method r6 = r7.getMethod(r8, r6)     // Catch:{ NoSuchMethodException -> 0x005d, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
            r7 = r18[r0]     // Catch:{ NoSuchMethodException -> 0x005d, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
            java.lang.Float r7 = java.lang.Float.valueOf(r7)     // Catch:{ NoSuchMethodException -> 0x005d, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ NoSuchMethodException -> 0x005d, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
            r2[r0] = r7     // Catch:{ NoSuchMethodException -> 0x005d, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
            r6.invoke(r1, r2)     // Catch:{ NoSuchMethodException -> 0x005d, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
            goto L_0x01ec
        L_0x0055:
            r0 = move-exception
            goto L_0x01b2
        L_0x0058:
            r0 = move-exception
            r2 = r1
        L_0x005a:
            r15 = r3
            goto L_0x01b6
        L_0x005d:
            r0 = move-exception
            r2 = r1
            goto L_0x01d2
        L_0x0061:
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x005d, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
            java.lang.Class r9 = java.lang.Boolean.TYPE     // Catch:{ NoSuchMethodException -> 0x005d, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
            r6[r0] = r9     // Catch:{ NoSuchMethodException -> 0x005d, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
            java.lang.reflect.Method r6 = r7.getMethod(r8, r6)     // Catch:{ NoSuchMethodException -> 0x005d, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
            r7 = r18[r0]     // Catch:{ NoSuchMethodException -> 0x005d, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
            r9 = 1056964608(0x3f000000, float:0.5)
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 <= 0) goto L_0x0075
            r7 = 1
            goto L_0x0076
        L_0x0075:
            r7 = 0
        L_0x0076:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)     // Catch:{ NoSuchMethodException -> 0x005d, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ NoSuchMethodException -> 0x005d, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
            r2[r0] = r7     // Catch:{ NoSuchMethodException -> 0x005d, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
            r6.invoke(r1, r2)     // Catch:{ NoSuchMethodException -> 0x005d, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
            goto L_0x01ec
        L_0x0083:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ NoSuchMethodException -> 0x005d, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ NoSuchMethodException -> 0x005d, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
            r2.<init>(r6)     // Catch:{ NoSuchMethodException -> 0x005d, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
            java.lang.String r6 = r16.getName()     // Catch:{ NoSuchMethodException -> 0x005d, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
            r2.append(r6)     // Catch:{ NoSuchMethodException -> 0x005d, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
            java.lang.String r2 = r2.toString()     // Catch:{ NoSuchMethodException -> 0x005d, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
            r0.<init>(r2)     // Catch:{ NoSuchMethodException -> 0x005d, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
            throw r0     // Catch:{ NoSuchMethodException -> 0x005d, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
        L_0x0099:
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x0112, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x0112, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
            r6[r0] = r9     // Catch:{ NoSuchMethodException -> 0x0112, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
            java.lang.reflect.Method r6 = r7.getMethod(r8, r6)     // Catch:{ NoSuchMethodException -> 0x010f, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
            r7 = r18[r0]     // Catch:{ NoSuchMethodException -> 0x010f, IllegalAccessException -> 0x0058, InvocationTargetException -> 0x0055 }
            double r0 = (double) r7
            double r0 = java.lang.Math.pow(r0, r12)     // Catch:{ NoSuchMethodException -> 0x0109, IllegalAccessException -> 0x0104, InvocationTargetException -> 0x0055 }
            float r0 = (float) r0     // Catch:{ NoSuchMethodException -> 0x0109, IllegalAccessException -> 0x0104, InvocationTargetException -> 0x0055 }
            float r0 = r0 * r14
            int r0 = (int) r0     // Catch:{ NoSuchMethodException -> 0x0109, IllegalAccessException -> 0x0104, InvocationTargetException -> 0x0055 }
            int r0 = clamp(r0)     // Catch:{ NoSuchMethodException -> 0x0109, IllegalAccessException -> 0x0104, InvocationTargetException -> 0x0055 }
            r1 = r18[r2]     // Catch:{ NoSuchMethodException -> 0x0109, IllegalAccessException -> 0x0104, InvocationTargetException -> 0x0055 }
            r15 = r3
            double r2 = (double) r1
            double r1 = java.lang.Math.pow(r2, r12)     // Catch:{ NoSuchMethodException -> 0x0100, IllegalAccessException -> 0x00fb, InvocationTargetException -> 0x0055 }
            float r1 = (float) r1     // Catch:{ NoSuchMethodException -> 0x0100, IllegalAccessException -> 0x00fb, InvocationTargetException -> 0x0055 }
            float r1 = r1 * r14
            int r1 = (int) r1     // Catch:{ NoSuchMethodException -> 0x0100, IllegalAccessException -> 0x00fb, InvocationTargetException -> 0x0055 }
            int r1 = clamp(r1)     // Catch:{ NoSuchMethodException -> 0x0100, IllegalAccessException -> 0x00fb, InvocationTargetException -> 0x0055 }
            r2 = r18[r11]     // Catch:{ NoSuchMethodException -> 0x0100, IllegalAccessException -> 0x00fb, InvocationTargetException -> 0x0055 }
            double r2 = (double) r2     // Catch:{ NoSuchMethodException -> 0x0100, IllegalAccessException -> 0x00fb, InvocationTargetException -> 0x0055 }
            double r2 = java.lang.Math.pow(r2, r12)     // Catch:{ NoSuchMethodException -> 0x0100, IllegalAccessException -> 0x00fb, InvocationTargetException -> 0x0055 }
            float r2 = (float) r2     // Catch:{ NoSuchMethodException -> 0x0100, IllegalAccessException -> 0x00fb, InvocationTargetException -> 0x0055 }
            float r2 = r2 * r14
            int r2 = (int) r2     // Catch:{ NoSuchMethodException -> 0x0100, IllegalAccessException -> 0x00fb, InvocationTargetException -> 0x0055 }
            int r2 = clamp(r2)     // Catch:{ NoSuchMethodException -> 0x0100, IllegalAccessException -> 0x00fb, InvocationTargetException -> 0x0055 }
            r3 = r18[r10]     // Catch:{ NoSuchMethodException -> 0x0100, IllegalAccessException -> 0x00fb, InvocationTargetException -> 0x0055 }
            float r3 = r3 * r14
            int r3 = (int) r3     // Catch:{ NoSuchMethodException -> 0x0100, IllegalAccessException -> 0x00fb, InvocationTargetException -> 0x0055 }
            int r3 = clamp(r3)     // Catch:{ NoSuchMethodException -> 0x0100, IllegalAccessException -> 0x00fb, InvocationTargetException -> 0x0055 }
            int r3 = r3 << 24
            int r0 = r0 << 16
            r0 = r0 | r3
            int r1 = r1 << 8
            r0 = r0 | r1
            r0 = r0 | r2
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NoSuchMethodException -> 0x0100, IllegalAccessException -> 0x00fb, InvocationTargetException -> 0x0055 }
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ NoSuchMethodException -> 0x0100, IllegalAccessException -> 0x00fb, InvocationTargetException -> 0x0055 }
            r2 = 0
            r1[r2] = r0     // Catch:{ NoSuchMethodException -> 0x0100, IllegalAccessException -> 0x00fb, InvocationTargetException -> 0x0055 }
            r2 = r17
            r6.invoke(r2, r1)     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            goto L_0x01ec
        L_0x00f4:
            r0 = move-exception
            goto L_0x01b6
        L_0x00f7:
            r0 = move-exception
        L_0x00f8:
            r3 = r15
            goto L_0x01d2
        L_0x00fb:
            r0 = move-exception
            r2 = r17
            goto L_0x01b6
        L_0x0100:
            r0 = move-exception
            r2 = r17
            goto L_0x00f8
        L_0x0104:
            r0 = move-exception
            r2 = r17
            goto L_0x005a
        L_0x0109:
            r0 = move-exception
            r2 = r17
        L_0x010c:
            r15 = r3
            goto L_0x01d2
        L_0x010f:
            r0 = move-exception
            r2 = r1
            goto L_0x010c
        L_0x0112:
            r0 = move-exception
            r2 = r1
            r15 = r3
            goto L_0x00f8
        L_0x0116:
            r2 = r1
            r15 = r3
            r0 = 1
            java.lang.Class[] r1 = new java.lang.Class[r0]     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            java.lang.Class<android.graphics.drawable.Drawable> r0 = android.graphics.drawable.Drawable.class
            r3 = 0
            r1[r3] = r0     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            java.lang.reflect.Method r0 = r7.getMethod(r8, r1)     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            r1 = r18[r3]     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            double r6 = (double) r1     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            double r6 = java.lang.Math.pow(r6, r12)     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            float r1 = (float) r6     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            float r1 = r1 * r14
            int r1 = (int) r1     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            int r1 = clamp(r1)     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            r3 = 1
            r6 = r18[r3]     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            double r6 = (double) r6     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            double r6 = java.lang.Math.pow(r6, r12)     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            float r3 = (float) r6     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            float r3 = r3 * r14
            int r3 = (int) r3     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            int r3 = clamp(r3)     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            r6 = r18[r11]     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            double r6 = (double) r6     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            double r6 = java.lang.Math.pow(r6, r12)     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            float r6 = (float) r6     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            float r6 = r6 * r14
            int r6 = (int) r6     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            int r6 = clamp(r6)     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            r7 = r18[r10]     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            float r7 = r7 * r14
            int r7 = (int) r7     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            int r7 = clamp(r7)     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            int r7 = r7 << 24
            int r1 = r1 << 16
            r1 = r1 | r7
            int r3 = r3 << 8
            r1 = r1 | r3
            r1 = r1 | r6
            android.graphics.drawable.ColorDrawable r3 = new android.graphics.drawable.ColorDrawable     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            r3.<init>()     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            r3.setColor(r1)     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            r6 = 0
            r1[r6] = r3     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            r0.invoke(r2, r1)     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            goto L_0x01ec
        L_0x0177:
            r2 = r1
            r15 = r3
            r0 = 1
            java.lang.Class[] r1 = new java.lang.Class[r0]     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            java.lang.Class r0 = java.lang.Float.TYPE     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            r3 = 0
            r1[r3] = r0     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            java.lang.reflect.Method r0 = r7.getMethod(r8, r1)     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            r1 = r18[r3]     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            java.lang.Float r1 = java.lang.Float.valueOf(r1)     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            r6 = 1
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            r6[r3] = r1     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            r0.invoke(r2, r6)     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            goto L_0x01ec
        L_0x0194:
            r2 = r1
            r15 = r3
            r0 = 1
            java.lang.Class[] r1 = new java.lang.Class[r0]     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            java.lang.Class r0 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            r3 = 0
            r1[r3] = r0     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            java.lang.reflect.Method r0 = r7.getMethod(r8, r1)     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            r1 = r18[r3]     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            int r1 = (int) r1     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            r6 = 1
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            r6[r3] = r1     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            r0.invoke(r2, r6)     // Catch:{ NoSuchMethodException -> 0x00f7, IllegalAccessException -> 0x00f4, InvocationTargetException -> 0x0055 }
            goto L_0x01ec
        L_0x01b2:
            r0.printStackTrace()
            goto L_0x01ec
        L_0x01b6:
            java.lang.String r1 = "cannot access method "
            java.lang.StringBuilder r1 = defpackage.e.t(r1, r8, r4)
            java.lang.String r2 = androidx.constraintlayout.motion.widget.Debug.getName(r17)
            r1.append(r2)
            r3 = r15
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r5, r1)
            r0.printStackTrace()
            goto L_0x01ec
        L_0x01d2:
            java.lang.String r1 = "no method "
            java.lang.StringBuilder r1 = defpackage.e.t(r1, r8, r4)
            java.lang.String r2 = androidx.constraintlayout.motion.widget.Debug.getName(r17)
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r5, r1)
            r0.printStackTrace()
        L_0x01ec:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.utils.CustomSupport.setInterpolatedValue(androidx.constraintlayout.widget.ConstraintAttribute, android.view.View, float[]):void");
    }
}
