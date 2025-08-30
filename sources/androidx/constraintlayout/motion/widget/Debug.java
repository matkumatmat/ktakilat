package androidx.constraintlayout.motion.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.vis.unified.license.BuildConfig;
import com.facebook.appevents.AppEventsConstants;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.CharBuffer;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;

@SuppressLint({"LogConditional"})
public class Debug {
    public static void dumpLayoutParams(ViewGroup viewGroup, String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str2 = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + str + "  ";
        int childCount = viewGroup.getChildCount();
        System.out.println(str + " children " + childCount);
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            PrintStream printStream = System.out;
            StringBuilder s = e.s(str2, "     ");
            s.append(getName(childAt));
            printStream.println(s.toString());
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            Field[] fields = layoutParams.getClass().getFields();
            for (Field field : fields) {
                try {
                    Object obj = field.get(layoutParams);
                    if (field.getName().contains("To")) {
                        if (!obj.toString().equals("-1")) {
                            System.out.println(str2 + "       " + field.getName() + StringUtils.SPACE + obj);
                        }
                    }
                } catch (IllegalAccessException unused) {
                }
            }
        }
    }

    public static void dumpPoc(Object obj) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
        Class<?> cls = obj.getClass();
        PrintStream printStream = System.out;
        StringBuilder s = e.s(str, "------------- ");
        s.append(cls.getName());
        s.append(" --------------------");
        printStream.println(s.toString());
        Field[] fields = cls.getFields();
        for (Field field : fields) {
            try {
                Object obj2 = field.get(obj);
                if (field.getName().startsWith("layout_constraint")) {
                    if (!(obj2 instanceof Integer) || !obj2.toString().equals("-1")) {
                        if (!(obj2 instanceof Integer) || !obj2.toString().equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                            if (!(obj2 instanceof Float) || !obj2.toString().equals(BuildConfig.VERSION_NAME)) {
                                if (!(obj2 instanceof Float) || !obj2.toString().equals("0.5")) {
                                    System.out.println(str + "    " + field.getName() + StringUtils.SPACE + obj2);
                                }
                            }
                        }
                    }
                }
            } catch (IllegalAccessException unused) {
            }
        }
        PrintStream printStream2 = System.out;
        StringBuilder s2 = e.s(str, "------------- ");
        s2.append(cls.getSimpleName());
        s2.append(" --------------------");
        printStream2.println(s2.toString());
    }

    public static String getActionType(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        Field[] fields = MotionEvent.class.getFields();
        for (Field field : fields) {
            try {
                if (Modifier.isStatic(field.getModifiers()) && field.getType().equals(Integer.TYPE) && field.getInt((Object) null) == action) {
                    return field.getName();
                }
            } catch (IllegalAccessException unused) {
            }
        }
        return "---";
    }

    public static String getCallFrom(int i) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[i + 2];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
    }

    public static String getLoc() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName() + "()";
    }

    public static String getLocation() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
    }

    public static String getLocation2() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")";
    }

    public static String getName(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }

    public static String getState(MotionLayout motionLayout, int i) {
        return getState(motionLayout, i, -1);
    }

    public static void logStack(String str, String str2, int i) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int min = Math.min(i, stackTrace.length - 1);
        String str3 = StringUtils.SPACE;
        for (int i2 = 1; i2 <= min; i2++) {
            StackTraceElement stackTraceElement = stackTrace[i2];
            StringBuilder sb = new StringBuilder(".(");
            sb.append(stackTrace[i2].getFileName());
            sb.append(":");
            sb.append(stackTrace[i2].getLineNumber());
            sb.append(") ");
            sb.append(stackTrace[i2].getMethodName());
            str3 = str3 + StringUtils.SPACE;
        }
    }

    public static void printStack(String str, int i) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int min = Math.min(i, stackTrace.length - 1);
        String str2 = StringUtils.SPACE;
        for (int i2 = 1; i2 <= min; i2++) {
            StackTraceElement stackTraceElement = stackTrace[i2];
            str2 = e.l(str2, StringUtils.SPACE);
            PrintStream printStream = System.out;
            printStream.println(str + str2 + (".(" + stackTrace[i2].getFileName() + ":" + stackTrace[i2].getLineNumber() + ") ") + str2);
        }
    }

    public static String getState(MotionLayout motionLayout, int i, int i2) {
        int length;
        if (i == -1) {
            return "UNDEFINED";
        }
        String resourceEntryName = motionLayout.getContext().getResources().getResourceEntryName(i);
        if (i2 == -1) {
            return resourceEntryName;
        }
        if (resourceEntryName.length() > i2) {
            resourceEntryName = resourceEntryName.replaceAll("([^_])[aeiou]+", "$1");
        }
        if (resourceEntryName.length() <= i2 || (length = resourceEntryName.replaceAll("[^_]", "").length()) <= 0) {
            return resourceEntryName;
        }
        int length2 = (resourceEntryName.length() - i2) / length;
        return resourceEntryName.replaceAll(CharBuffer.allocate(length2).toString().replace(0, ClassUtils.PACKAGE_SEPARATOR_CHAR) + "_", "_");
    }

    public static String getName(Context context, int i) {
        if (i == -1) {
            return "UNKNOWN";
        }
        try {
            return context.getResources().getResourceEntryName(i);
        } catch (Exception unused) {
            return ba.k(i, "?");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r0 = "? " + r6[r1] + org.apache.commons.lang3.StringUtils.SPACE;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x003a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getName(android.content.Context r5, int[] r6) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0025 }
            r0.<init>()     // Catch:{ Exception -> 0x0025 }
            int r1 = r6.length     // Catch:{ Exception -> 0x0025 }
            r0.append(r1)     // Catch:{ Exception -> 0x0025 }
            java.lang.String r1 = "["
            r0.append(r1)     // Catch:{ Exception -> 0x0025 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0025 }
            r1 = 0
        L_0x0013:
            int r2 = r6.length     // Catch:{ Exception -> 0x0025 }
            if (r1 >= r2) goto L_0x0062
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0025 }
            r2.<init>()     // Catch:{ Exception -> 0x0025 }
            r2.append(r0)     // Catch:{ Exception -> 0x0025 }
            java.lang.String r0 = " "
            if (r1 != 0) goto L_0x0027
            java.lang.String r3 = ""
            goto L_0x0028
        L_0x0025:
            r5 = move-exception
            goto L_0x0074
        L_0x0027:
            r3 = r0
        L_0x0028:
            r2.append(r3)     // Catch:{ Exception -> 0x0025 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0025 }
            android.content.res.Resources r3 = r5.getResources()     // Catch:{ NotFoundException -> 0x003a }
            r4 = r6[r1]     // Catch:{ NotFoundException -> 0x003a }
            java.lang.String r0 = r3.getResourceEntryName(r4)     // Catch:{ NotFoundException -> 0x003a }
            goto L_0x0050
        L_0x003a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0025 }
            r3.<init>()     // Catch:{ Exception -> 0x0025 }
            java.lang.String r4 = "? "
            r3.append(r4)     // Catch:{ Exception -> 0x0025 }
            r4 = r6[r1]     // Catch:{ Exception -> 0x0025 }
            r3.append(r4)     // Catch:{ Exception -> 0x0025 }
            r3.append(r0)     // Catch:{ Exception -> 0x0025 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0025 }
        L_0x0050:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0025 }
            r3.<init>()     // Catch:{ Exception -> 0x0025 }
            r3.append(r2)     // Catch:{ Exception -> 0x0025 }
            r3.append(r0)     // Catch:{ Exception -> 0x0025 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0025 }
            int r1 = r1 + 1
            goto L_0x0013
        L_0x0062:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0025 }
            r5.<init>()     // Catch:{ Exception -> 0x0025 }
            r5.append(r0)     // Catch:{ Exception -> 0x0025 }
            java.lang.String r6 = "]"
            r5.append(r6)     // Catch:{ Exception -> 0x0025 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0025 }
            return r5
        L_0x0074:
            r5.toString()
            java.lang.String r5 = "UNKNOWN"
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.Debug.getName(android.content.Context, int[]):java.lang.String");
    }

    public static void dumpLayoutParams(ViewGroup.LayoutParams layoutParams, String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str2 = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + str + "  ";
        PrintStream printStream = System.out;
        StringBuilder t = e.t(" >>>>>>>>>>>>>>>>>>. dump ", str2, "  ");
        t.append(layoutParams.getClass().getName());
        printStream.println(t.toString());
        Field[] fields = layoutParams.getClass().getFields();
        for (Field field : fields) {
            try {
                Object obj = field.get(layoutParams);
                String name = field.getName();
                if (name.contains("To")) {
                    if (!obj.toString().equals("-1")) {
                        System.out.println(str2 + "       " + name + StringUtils.SPACE + obj);
                    }
                }
            } catch (IllegalAccessException unused) {
            }
        }
        System.out.println(" <<<<<<<<<<<<<<<<< dump " + str2);
    }
}
