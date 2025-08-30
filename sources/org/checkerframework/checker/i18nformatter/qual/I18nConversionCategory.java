package org.checkerframework.checker.i18nformatter.qual;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.StringJoiner;

public enum I18nConversionCategory {
    UNUSED((String) null, (int) null),
    GENERAL((String) null, (int) null),
    DATE(new Class[]{Date.class, r4}, new String[]{"date", "time"}),
    NUMBER(new Class[]{r4}, new String[]{"number", "choice"});
    
    public static final I18nConversionCategory[] c = null;
    public final String[] strings;
    public final Class<?>[] types;

    static {
        I18nConversionCategory i18nConversionCategory;
        I18nConversionCategory i18nConversionCategory2;
        c = new I18nConversionCategory[]{i18nConversionCategory, i18nConversionCategory2};
    }

    /* access modifiers changed from: public */
    I18nConversionCategory(Class[] clsArr, String[] strArr) {
        this.types = clsArr;
        this.strings = strArr;
    }

    public static I18nConversionCategory intersect(I18nConversionCategory i18nConversionCategory, I18nConversionCategory i18nConversionCategory2) {
        I18nConversionCategory i18nConversionCategory3 = UNUSED;
        if (i18nConversionCategory == i18nConversionCategory3) {
            return i18nConversionCategory2;
        }
        if (i18nConversionCategory2 == i18nConversionCategory3) {
            return i18nConversionCategory;
        }
        I18nConversionCategory i18nConversionCategory4 = GENERAL;
        if (i18nConversionCategory == i18nConversionCategory4) {
            return i18nConversionCategory2;
        }
        if (i18nConversionCategory2 == i18nConversionCategory4) {
            return i18nConversionCategory;
        }
        HashSet hashSet = new HashSet(Arrays.asList(i18nConversionCategory.types));
        hashSet.retainAll(new HashSet(Arrays.asList(i18nConversionCategory2.types)));
        I18nConversionCategory[] i18nConversionCategoryArr = {DATE, NUMBER};
        for (int i = 0; i < 2; i++) {
            I18nConversionCategory i18nConversionCategory5 = i18nConversionCategoryArr[i];
            if (new HashSet(Arrays.asList(i18nConversionCategory5.types)).equals(hashSet)) {
                return i18nConversionCategory5;
            }
        }
        throw new RuntimeException();
    }

    public static boolean isSubsetOf(I18nConversionCategory i18nConversionCategory, I18nConversionCategory i18nConversionCategory2) {
        if (intersect(i18nConversionCategory, i18nConversionCategory2) == i18nConversionCategory) {
            return true;
        }
        return false;
    }

    public static I18nConversionCategory stringToI18nConversionCategory(String str) {
        String lowerCase = str.toLowerCase();
        I18nConversionCategory[] i18nConversionCategoryArr = c;
        for (int i = 0; i < 2; i++) {
            I18nConversionCategory i18nConversionCategory = i18nConversionCategoryArr[i];
            for (String equals : i18nConversionCategory.strings) {
                if (equals.equals(lowerCase)) {
                    return i18nConversionCategory;
                }
            }
        }
        throw new IllegalArgumentException(e.B("Invalid format type ", lowerCase));
    }

    public static I18nConversionCategory union(I18nConversionCategory i18nConversionCategory, I18nConversionCategory i18nConversionCategory2) {
        I18nConversionCategory i18nConversionCategory3 = UNUSED;
        if (i18nConversionCategory == i18nConversionCategory3 || i18nConversionCategory2 == i18nConversionCategory3 || i18nConversionCategory == (i18nConversionCategory3 = GENERAL) || i18nConversionCategory2 == i18nConversionCategory3 || i18nConversionCategory == (i18nConversionCategory3 = DATE) || i18nConversionCategory2 == i18nConversionCategory3) {
            return i18nConversionCategory3;
        }
        return NUMBER;
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

    public String toString() {
        StringBuilder sb = new StringBuilder(name());
        if (this.types == null) {
            sb.append(" conversion category (all types)");
        } else {
            StringJoiner o = v9.o();
            for (Class<?> canonicalName : this.types) {
                o.add(canonicalName.getCanonicalName());
            }
            sb.append(o);
        }
        return sb.toString();
    }
}
