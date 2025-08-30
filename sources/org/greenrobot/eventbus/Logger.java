package org.greenrobot.eventbus;

import android.util.Log;
import java.io.PrintStream;
import java.util.logging.Level;
import org.apache.commons.lang3.StringUtils;

public interface Logger {

    public static class AndroidLogger implements Logger {

        /* renamed from: a  reason: collision with root package name */
        public static final boolean f830a;

        static {
            boolean z;
            try {
                Class.forName("android.util.Log");
                z = true;
            } catch (ClassNotFoundException unused) {
                z = false;
            }
            f830a = z;
        }

        public static int c(Level level) {
            int intValue = level.intValue();
            if (intValue < 800) {
                if (intValue < 500) {
                    return 2;
                }
                return 3;
            } else if (intValue < 900) {
                return 4;
            } else {
                if (intValue < 1000) {
                    return 5;
                }
                return 6;
            }
        }

        public final void a(Level level, String str) {
            if (level != Level.OFF) {
                Log.println(c(level), "EventBus", str);
            }
        }

        public final void b(Level level, String str, Throwable th) {
            if (level != Level.OFF) {
                int c = c(level);
                StringBuilder s = e.s(str, StringUtils.LF);
                s.append(Log.getStackTraceString(th));
                Log.println(c, "EventBus", s.toString());
            }
        }
    }

    public static class JavaLogger implements Logger {
        public final void a(Level level, String str) {
            throw null;
        }

        public final void b(Level level, String str, Throwable th) {
            throw null;
        }
    }

    public static class SystemOutLogger implements Logger {
        public final void a(Level level, String str) {
            PrintStream printStream = System.out;
            printStream.println("[" + level + "] " + str);
        }

        public final void b(Level level, String str, Throwable th) {
            PrintStream printStream = System.out;
            printStream.println("[" + level + "] " + str);
            th.printStackTrace(printStream);
        }
    }

    void a(Level level, String str);

    void b(Level level, String str, Throwable th);
}
