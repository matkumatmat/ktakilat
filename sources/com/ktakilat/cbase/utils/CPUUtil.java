package com.ktakilat.cbase.utils;

import java.io.File;
import java.io.FileFilter;

public class CPUUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final FileFilter f474a = new Object();

    /* renamed from: com.ktakilat.cbase.utils.CPUUtil$1  reason: invalid class name */
    public class AnonymousClass1 implements FileFilter {
        public final boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i = 3; i < name.length(); i++) {
                if (name.charAt(i) < '0' || name.charAt(i) > '9') {
                    return false;
                }
            }
            return true;
        }
    }

    public static int a() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(f474a).length;
        } catch (NullPointerException | SecurityException unused) {
            return -1;
        }
    }
}
