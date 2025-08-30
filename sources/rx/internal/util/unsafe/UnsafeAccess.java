package rx.internal.util.unsafe;

import java.lang.reflect.Field;
import rx.internal.util.SuppressAnimalSniffer;
import sun.misc.Unsafe;

@SuppressAnimalSniffer
public final class UnsafeAccess {
    private static final boolean DISABLED_BY_USER;
    public static final Unsafe UNSAFE;

    static {
        boolean z;
        if (System.getProperty("rx.unsafe-disable") != null) {
            z = true;
        } else {
            z = false;
        }
        DISABLED_BY_USER = z;
        Unsafe unsafe = null;
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            unsafe = (Unsafe) declaredField.get((Object) null);
        } catch (Throwable unused) {
        }
        UNSAFE = unsafe;
    }

    private UnsafeAccess() {
        throw new IllegalStateException("No instances!");
    }

    public static long addressOf(Class<?> cls, String str) {
        try {
            return UNSAFE.objectFieldOffset(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e) {
            InternalError internalError = new InternalError();
            internalError.initCause(e);
            throw internalError;
        }
    }

    public static boolean compareAndSwapInt(Object obj, long j, int i, int i2) {
        return UNSAFE.compareAndSwapInt(obj, j, i, i2);
    }

    public static int getAndAddInt(Object obj, long j, int i) {
        Unsafe unsafe;
        int intVolatile;
        do {
            unsafe = UNSAFE;
            intVolatile = unsafe.getIntVolatile(obj, j);
        } while (!unsafe.compareAndSwapInt(obj, j, intVolatile, intVolatile + i));
        return intVolatile;
    }

    public static int getAndIncrementInt(Object obj, long j) {
        Unsafe unsafe;
        int intVolatile;
        do {
            unsafe = UNSAFE;
            intVolatile = unsafe.getIntVolatile(obj, j);
        } while (!unsafe.compareAndSwapInt(obj, j, intVolatile, intVolatile + 1));
        return intVolatile;
    }

    public static int getAndSetInt(Object obj, long j, int i) {
        Unsafe unsafe;
        int intVolatile;
        do {
            unsafe = UNSAFE;
            intVolatile = unsafe.getIntVolatile(obj, j);
        } while (!unsafe.compareAndSwapInt(obj, j, intVolatile, i));
        return intVolatile;
    }

    public static boolean isUnsafeAvailable() {
        if (UNSAFE == null || DISABLED_BY_USER) {
            return false;
        }
        return true;
    }
}
