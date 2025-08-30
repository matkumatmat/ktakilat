package com.trustdecision.mobrisk.oO00o0OooO0OO0o0000o;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class oO00o0OooO0OO0o0000o {
    public static Object o0Oo0OO00O0O000ooOO0(Class cls, Object obj, String str, Class[] clsArr, Object[] objArr) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (Throwable th) {
            if (th instanceof NoSuchMethodException) {
                Class superclass = cls.getSuperclass();
                if (superclass == null) {
                    return null;
                }
                return o0Oo0OO00O0O000ooOO0(superclass, obj, str, clsArr, objArr);
            }
            o0Oo0OO00O0O000ooOO0(th);
            return null;
        }
    }

    public static Object o0Oo0OO00O0O000ooOO0(Class cls, Object obj, String str, Object... objArr) {
        try {
            for (Method method : cls.getDeclaredMethods()) {
                if (method.getName().equals(str)) {
                    method.setAccessible(true);
                    return method.invoke(obj, objArr);
                }
            }
            return null;
        } catch (Throwable th) {
            o0Oo0OO00O0O000ooOO0(th);
            return null;
        }
    }

    public static Object o0Oo0OO00O0O000ooOO0(String str, Object obj, String str2, Class[] clsArr, Object[] objArr) {
        try {
            return o0Oo0OO00O0O000ooOO0((Class) Class.forName(str), obj, str2, clsArr, objArr);
        } catch (Throwable th) {
            o0Oo0OO00O0O000ooOO0(th);
            return null;
        }
    }

    public static Object o0Oo0OO00O0O000ooOO0(String str, Object obj, String str2, Object... objArr) {
        try {
            for (Method method : Class.forName(str).getDeclaredMethods()) {
                if (method.getName().equals(str2)) {
                    method.setAccessible(true);
                    return method.invoke(obj, objArr);
                }
            }
            return null;
        } catch (Throwable th) {
            o0Oo0OO00O0O000ooOO0(th);
            return null;
        }
    }

    public static void o0Oo0OO00O0O000ooOO0(Throwable th) {
        if (th instanceof InvocationTargetException) {
            Throwable targetException = ((InvocationTargetException) th).getTargetException();
            if (targetException instanceof IllegalArgumentException) {
                throw new IllegalArgumentException(targetException.getMessage());
            } else if (targetException instanceof IllegalStateException) {
                throw new IllegalStateException(targetException.getMessage());
            }
        } else if (th instanceof IllegalArgumentException) {
            throw new IllegalArgumentException(th.getMessage());
        } else if (th instanceof IllegalStateException) {
            throw new IllegalStateException(th.getMessage());
        }
    }
}
