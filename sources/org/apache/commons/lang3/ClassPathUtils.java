package org.apache.commons.lang3;

import com.facebook.places.model.PlaceFields;
import com.google.firebase.sessions.settings.RemoteSettings;

public class ClassPathUtils {
    public static String toFullyQualifiedName(Class<?> cls, String str) {
        Validate.notNull(cls, PlaceFields.CONTEXT, new Object[0]);
        Validate.notNull(str, "resourceName", new Object[0]);
        return toFullyQualifiedName(cls.getPackage(), str);
    }

    public static String toFullyQualifiedPath(Class<?> cls, String str) {
        Validate.notNull(cls, PlaceFields.CONTEXT, new Object[0]);
        Validate.notNull(str, "resourceName", new Object[0]);
        return toFullyQualifiedPath(cls.getPackage(), str);
    }

    public static String toFullyQualifiedName(Package packageR, String str) {
        Validate.notNull(packageR, PlaceFields.CONTEXT, new Object[0]);
        Validate.notNull(str, "resourceName", new Object[0]);
        return packageR.getName() + "." + str;
    }

    public static String toFullyQualifiedPath(Package packageR, String str) {
        Validate.notNull(packageR, PlaceFields.CONTEXT, new Object[0]);
        Validate.notNull(str, "resourceName", new Object[0]);
        return packageR.getName().replace(ClassUtils.PACKAGE_SEPARATOR_CHAR, '/') + RemoteSettings.FORWARD_SLASH_STRING + str;
    }
}
