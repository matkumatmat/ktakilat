package org.apache.commons.lang3.reflect;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

public class FieldUtils {
    public static Field[] getAllFields(Class<?> cls) {
        return (Field[]) getAllFieldsList(cls).toArray(ArrayUtils.EMPTY_FIELD_ARRAY);
    }

    public static List<Field> getAllFieldsList(Class<?> cls) {
        Validate.notNull(cls, "cls", new Object[0]);
        ArrayList arrayList = new ArrayList();
        for (Class<? super Object> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            Collections.addAll(arrayList, cls2.getDeclaredFields());
        }
        return arrayList;
    }

    public static Field getDeclaredField(Class<?> cls, String str) {
        return getDeclaredField(cls, str, false);
    }

    public static Field getField(Class<?> cls, String str) {
        Field field = getField(cls, str, false);
        MemberUtils.setAccessibleWorkaround(field);
        return field;
    }

    public static List<Field> getFieldsListWithAnnotation(Class<?> cls, Class<? extends Annotation> cls2) {
        Validate.notNull(cls2, "annotationCls", new Object[0]);
        List<Field> allFieldsList = getAllFieldsList(cls);
        ArrayList arrayList = new ArrayList();
        for (Field next : allFieldsList) {
            if (next.getAnnotation(cls2) != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static Field[] getFieldsWithAnnotation(Class<?> cls, Class<? extends Annotation> cls2) {
        return (Field[]) getFieldsListWithAnnotation(cls, cls2).toArray(ArrayUtils.EMPTY_FIELD_ARRAY);
    }

    public static Object readDeclaredField(Object obj, String str) throws IllegalAccessException {
        return readDeclaredField(obj, str, false);
    }

    public static Object readDeclaredStaticField(Class<?> cls, String str) throws IllegalAccessException {
        return readDeclaredStaticField(cls, str, false);
    }

    public static Object readField(Field field, Object obj) throws IllegalAccessException {
        return readField(field, obj, false);
    }

    public static Object readStaticField(Field field) throws IllegalAccessException {
        return readStaticField(field, false);
    }

    public static void removeFinalModifier(Field field) {
        removeFinalModifier(field, true);
    }

    public static void writeDeclaredField(Object obj, String str, Object obj2) throws IllegalAccessException {
        writeDeclaredField(obj, str, obj2, false);
    }

    public static void writeDeclaredStaticField(Class<?> cls, String str, Object obj) throws IllegalAccessException {
        writeDeclaredStaticField(cls, str, obj, false);
    }

    public static void writeField(Field field, Object obj, Object obj2) throws IllegalAccessException {
        writeField(field, obj, obj2, false);
    }

    public static void writeStaticField(Field field, Object obj) throws IllegalAccessException {
        writeStaticField(field, obj, false);
    }

    public static Field getDeclaredField(Class<?> cls, String str, boolean z) {
        Validate.notNull(cls, "cls", new Object[0]);
        Validate.isTrue(StringUtils.isNotBlank(str), "The field name must not be blank/empty", new Object[0]);
        try {
            Field declaredField = cls.getDeclaredField(str);
            if (!MemberUtils.isAccessible(declaredField)) {
                if (!z) {
                    return null;
                }
                declaredField.setAccessible(true);
            }
            return declaredField;
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    public static Object readDeclaredField(Object obj, String str, boolean z) throws IllegalAccessException {
        Validate.notNull(obj, TypedValues.AttributesType.S_TARGET, new Object[0]);
        Class<?> cls = obj.getClass();
        Field declaredField = getDeclaredField(cls, str, z);
        Validate.isTrue(declaredField != null, "Cannot locate declared field %s.%s", cls, str);
        return readField(declaredField, obj, false);
    }

    public static Object readDeclaredStaticField(Class<?> cls, String str, boolean z) throws IllegalAccessException {
        Field declaredField = getDeclaredField(cls, str, z);
        Validate.notNull(declaredField, "Cannot locate declared field %s.%s", cls.getName(), str);
        return readStaticField(declaredField, false);
    }

    public static Object readField(Field field, Object obj, boolean z) throws IllegalAccessException {
        Validate.notNull(field, "field", new Object[0]);
        if (!z || field.isAccessible()) {
            MemberUtils.setAccessibleWorkaround(field);
        } else {
            field.setAccessible(true);
        }
        return field.get(obj);
    }

    public static Object readStaticField(Field field, boolean z) throws IllegalAccessException {
        Validate.notNull(field, "field", new Object[0]);
        Validate.isTrue(Modifier.isStatic(field.getModifiers()), "The field '%s' is not static", field.getName());
        return readField(field, (Object) null, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void removeFinalModifier(java.lang.reflect.Field r3, boolean r4) {
        /*
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r2 = "field"
            org.apache.commons.lang3.Validate.notNull(r3, r2, r1)
            int r1 = r3.getModifiers()     // Catch:{ NoSuchFieldException -> 0x0027, IllegalAccessException -> 0x0025 }
            boolean r1 = java.lang.reflect.Modifier.isFinal(r1)     // Catch:{ NoSuchFieldException -> 0x0027, IllegalAccessException -> 0x0025 }
            if (r1 == 0) goto L_0x004d
            java.lang.Class<java.lang.reflect.Field> r1 = java.lang.reflect.Field.class
            java.lang.String r2 = "modifiers"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch:{ NoSuchFieldException -> 0x0027, IllegalAccessException -> 0x0025 }
            r2 = 1
            if (r4 == 0) goto L_0x0029
            boolean r4 = r1.isAccessible()     // Catch:{ NoSuchFieldException -> 0x0027, IllegalAccessException -> 0x0025 }
            if (r4 != 0) goto L_0x0029
            r4 = 1
            goto L_0x002a
        L_0x0025:
            r3 = move-exception
            goto L_0x0045
        L_0x0027:
            r3 = move-exception
            goto L_0x0045
        L_0x0029:
            r4 = 0
        L_0x002a:
            if (r4 == 0) goto L_0x002f
            r1.setAccessible(r2)     // Catch:{ NoSuchFieldException -> 0x0027, IllegalAccessException -> 0x0025 }
        L_0x002f:
            int r2 = r3.getModifiers()     // Catch:{ all -> 0x003e }
            r2 = r2 & -17
            r1.setInt(r3, r2)     // Catch:{ all -> 0x003e }
            if (r4 == 0) goto L_0x004d
            r1.setAccessible(r0)     // Catch:{ NoSuchFieldException -> 0x0027, IllegalAccessException -> 0x0025 }
            goto L_0x004d
        L_0x003e:
            r3 = move-exception
            if (r4 == 0) goto L_0x0044
            r1.setAccessible(r0)     // Catch:{ NoSuchFieldException -> 0x0027, IllegalAccessException -> 0x0025 }
        L_0x0044:
            throw r3     // Catch:{ NoSuchFieldException -> 0x0027, IllegalAccessException -> 0x0025 }
        L_0x0045:
            org.apache.commons.lang3.JavaVersion r4 = org.apache.commons.lang3.JavaVersion.JAVA_12
            boolean r4 = org.apache.commons.lang3.SystemUtils.isJavaVersionAtLeast(r4)
            if (r4 != 0) goto L_0x004e
        L_0x004d:
            return
        L_0x004e:
            java.lang.UnsupportedOperationException r4 = new java.lang.UnsupportedOperationException
            java.lang.String r0 = "In java 12+ final cannot be removed."
            r4.<init>(r0, r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.reflect.FieldUtils.removeFinalModifier(java.lang.reflect.Field, boolean):void");
    }

    public static void writeDeclaredField(Object obj, String str, Object obj2, boolean z) throws IllegalAccessException {
        Validate.notNull(obj, TypedValues.AttributesType.S_TARGET, new Object[0]);
        Class<?> cls = obj.getClass();
        Field declaredField = getDeclaredField(cls, str, z);
        Validate.isTrue(declaredField != null, "Cannot locate declared field %s.%s", cls.getName(), str);
        writeField(declaredField, obj, obj2, false);
    }

    public static void writeDeclaredStaticField(Class<?> cls, String str, Object obj, boolean z) throws IllegalAccessException {
        Field declaredField = getDeclaredField(cls, str, z);
        Validate.notNull(declaredField, "Cannot locate declared field %s.%s", cls.getName(), str);
        writeField(declaredField, (Object) null, obj, false);
    }

    public static void writeField(Field field, Object obj, Object obj2, boolean z) throws IllegalAccessException {
        Validate.notNull(field, "field", new Object[0]);
        if (!z || field.isAccessible()) {
            MemberUtils.setAccessibleWorkaround(field);
        } else {
            field.setAccessible(true);
        }
        field.set(obj, obj2);
    }

    public static void writeStaticField(Field field, Object obj, boolean z) throws IllegalAccessException {
        Validate.notNull(field, "field", new Object[0]);
        Validate.isTrue(Modifier.isStatic(field.getModifiers()), "The field %s.%s is not static", field.getDeclaringClass().getName(), field.getName());
        writeField(field, (Object) null, obj, z);
    }

    public static Field getField(Class<?> cls, String str, boolean z) {
        Validate.notNull(cls, "cls", new Object[0]);
        Validate.isTrue(StringUtils.isNotBlank(str), "The field name must not be blank/empty", new Object[0]);
        Class<?> cls2 = cls;
        while (cls2 != null) {
            try {
                Field declaredField = cls2.getDeclaredField(str);
                if (!Modifier.isPublic(declaredField.getModifiers())) {
                    if (z) {
                        declaredField.setAccessible(true);
                    } else {
                        cls2 = cls2.getSuperclass();
                    }
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        Field field = null;
        for (Class field2 : ClassUtils.getAllInterfaces(cls)) {
            try {
                Field field3 = field2.getField(str);
                Validate.isTrue(field == null, "Reference to field %s is ambiguous relative to %s; a matching field exists on two or more implemented interfaces.", str, cls);
                field = field3;
            } catch (NoSuchFieldException unused2) {
            }
        }
        return field;
    }

    public static Object readStaticField(Class<?> cls, String str) throws IllegalAccessException {
        return readStaticField(cls, str, false);
    }

    public static Object readStaticField(Class<?> cls, String str, boolean z) throws IllegalAccessException {
        Field field = getField(cls, str, z);
        Validate.notNull(field, "Cannot locate field '%s' on %s", str, cls);
        return readStaticField(field, false);
    }

    public static Object readField(Object obj, String str) throws IllegalAccessException {
        return readField(obj, str, false);
    }

    public static void writeField(Object obj, String str, Object obj2) throws IllegalAccessException {
        writeField(obj, str, obj2, false);
    }

    public static void writeStaticField(Class<?> cls, String str, Object obj) throws IllegalAccessException {
        writeStaticField(cls, str, obj, false);
    }

    public static Object readField(Object obj, String str, boolean z) throws IllegalAccessException {
        Validate.notNull(obj, TypedValues.AttributesType.S_TARGET, new Object[0]);
        Class<?> cls = obj.getClass();
        Field field = getField(cls, str, z);
        Validate.isTrue(field != null, "Cannot locate field %s on %s", str, cls);
        return readField(field, obj, false);
    }

    public static void writeField(Object obj, String str, Object obj2, boolean z) throws IllegalAccessException {
        Validate.notNull(obj, TypedValues.AttributesType.S_TARGET, new Object[0]);
        Class<?> cls = obj.getClass();
        Field field = getField(cls, str, z);
        Validate.isTrue(field != null, "Cannot locate declared field %s.%s", cls.getName(), str);
        writeField(field, obj, obj2, false);
    }

    public static void writeStaticField(Class<?> cls, String str, Object obj, boolean z) throws IllegalAccessException {
        Field field = getField(cls, str, z);
        Validate.notNull(field, "Cannot locate field %s on %s", str, cls);
        writeStaticField(field, obj, false);
    }
}
