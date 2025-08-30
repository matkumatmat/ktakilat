package com.google.i18n.phonenumbers.metadata.init;

import com.google.i18n.phonenumbers.MetadataLoader;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class ClassPathResourceMetadataLoader implements MetadataLoader {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f323a = Logger.getLogger(ClassPathResourceMetadataLoader.class.getName());

    public final InputStream a(String str) {
        InputStream resourceAsStream = ClassPathResourceMetadataLoader.class.getResourceAsStream(str);
        if (resourceAsStream == null) {
            Level level = Level.WARNING;
            f323a.log(level, "File " + str + " not found");
        }
        return resourceAsStream;
    }
}
