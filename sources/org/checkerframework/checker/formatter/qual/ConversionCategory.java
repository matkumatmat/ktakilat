package org.checkerframework.checker.formatter.qual;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.StringJoiner;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.dataflow.qual.Pure;

public enum ConversionCategory {
    GENERAL("bBhHsS", (String) null),
    CHAR("cC", Character.class, r3, r5, r6),
    INT("doxX", r3, r5, r6, r12, BigInteger.class),
    FLOAT("eEfgGaA", Float.class, Double.class, BigDecimal.class),
    TIME("tT", r12, Calendar.class, Date.class),
    CHAR_AND_INT((int) null, r3, r5, r6),
    INT_AND_TIME((int) null, r12),
    NULL((int) null, new Class[0]),
    UNUSED((int) null, (String) null);
    
    public final String chars;
    public final Class<?>[] types;

    /* access modifiers changed from: public */
    ConversionCategory(String str, Class... clsArr) {
        Class cls;
        this.chars = str;
        if (clsArr == null) {
            this.types = clsArr;
            return;
        }
        ArrayList arrayList = new ArrayList(clsArr.length);
        for (Class<Boolean> cls2 : clsArr) {
            arrayList.add(cls2);
            if (cls2 == Byte.class) {
                cls = Byte.TYPE;
            } else if (cls2 == Character.class) {
                cls = Character.TYPE;
            } else if (cls2 == Short.class) {
                cls = Short.TYPE;
            } else if (cls2 == Integer.class) {
                cls = Integer.TYPE;
            } else if (cls2 == Long.class) {
                cls = Long.TYPE;
            } else if (cls2 == Float.class) {
                cls = Float.TYPE;
            } else if (cls2 == Double.class) {
                cls = Double.TYPE;
            } else if (cls2 == Boolean.class) {
                cls = Boolean.TYPE;
            } else {
                cls = null;
            }
            if (cls != null) {
                arrayList.add(cls);
            }
        }
        this.types = (Class[]) arrayList.toArray(new Class[arrayList.size()]);
    }

    public static HashSet b(Object[] objArr) {
        return new HashSet(Arrays.asList(objArr));
    }

    public static ConversionCategory fromConversionChar(char c2) {
        ConversionCategory[] conversionCategoryArr = {GENERAL, CHAR, INT, FLOAT, TIME};
        for (int i = 0; i < 5; i++) {
            ConversionCategory conversionCategory = conversionCategoryArr[i];
            if (conversionCategory.chars.contains(String.valueOf(c2))) {
                return conversionCategory;
            }
        }
        throw new IllegalArgumentException("Bad conversion character " + c2);
    }

    public static ConversionCategory intersect(ConversionCategory conversionCategory, ConversionCategory conversionCategory2) {
        ConversionCategory conversionCategory3 = UNUSED;
        if (conversionCategory == conversionCategory3) {
            return conversionCategory2;
        }
        if (conversionCategory2 == conversionCategory3) {
            return conversionCategory;
        }
        ConversionCategory conversionCategory4 = GENERAL;
        if (conversionCategory == conversionCategory4) {
            return conversionCategory2;
        }
        if (conversionCategory2 == conversionCategory4) {
            return conversionCategory;
        }
        HashSet b = b(conversionCategory.types);
        b.retainAll(b(conversionCategory2.types));
        ConversionCategory[] conversionCategoryArr = {CHAR, INT, FLOAT, TIME, CHAR_AND_INT, INT_AND_TIME, NULL};
        for (int i = 0; i < 7; i++) {
            ConversionCategory conversionCategory5 = conversionCategoryArr[i];
            if (b(conversionCategory5.types).equals(b)) {
                return conversionCategory5;
            }
        }
        throw new RuntimeException();
    }

    public static boolean isSubsetOf(ConversionCategory conversionCategory, ConversionCategory conversionCategory2) {
        if (intersect(conversionCategory, conversionCategory2) == conversionCategory) {
            return true;
        }
        return false;
    }

    public static ConversionCategory union(ConversionCategory conversionCategory, ConversionCategory conversionCategory2) {
        ConversionCategory conversionCategory3;
        ConversionCategory conversionCategory4 = UNUSED;
        if (conversionCategory == conversionCategory4 || conversionCategory2 == conversionCategory4 || conversionCategory == (conversionCategory4 = GENERAL) || conversionCategory2 == conversionCategory4) {
            return conversionCategory4;
        }
        ConversionCategory conversionCategory5 = CHAR_AND_INT;
        if ((conversionCategory == conversionCategory5 && conversionCategory2 == INT_AND_TIME) || (conversionCategory == (conversionCategory3 = INT_AND_TIME) && conversionCategory2 == conversionCategory5)) {
            return INT;
        }
        HashSet b = b(conversionCategory.types);
        b.addAll(b(conversionCategory2.types));
        ConversionCategory[] conversionCategoryArr = {NULL, conversionCategory5, conversionCategory3, CHAR, INT, FLOAT, TIME};
        for (int i = 0; i < 7; i++) {
            ConversionCategory conversionCategory6 = conversionCategoryArr[i];
            if (b(conversionCategory6.types).equals(b)) {
                return conversionCategory6;
            }
        }
        return GENERAL;
    }

    public boolean isAssignableFrom(Class<?> cls) {
        Class<?>[] clsArr = this.types;
        if (clsArr == null || cls == Void.TYPE) {
            return true;
        }
        for (Class<?> isAssignableFrom : clsArr) {
            if (isAssignableFrom.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    @Pure
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name());
        sb.append(" conversion category");
        Class<?>[] clsArr = this.types;
        if (clsArr == null || clsArr.length == 0) {
            return sb.toString();
        }
        StringJoiner r = l3.r();
        for (Class<?> simpleName : this.types) {
            r.add(simpleName.getSimpleName());
        }
        sb.append(StringUtils.SPACE);
        sb.append(r);
        return sb.toString();
    }
}
