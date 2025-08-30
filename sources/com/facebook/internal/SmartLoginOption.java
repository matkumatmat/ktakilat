package com.facebook.internal;

import java.util.EnumSet;
import java.util.Iterator;

public enum SmartLoginOption {
    None(0),
    Enabled(1),
    RequireConfirm(2);
    
    public static final EnumSet<SmartLoginOption> ALL = null;
    private final long mValue;

    static {
        ALL = EnumSet.allOf(SmartLoginOption.class);
    }

    private SmartLoginOption(long j) {
        this.mValue = j;
    }

    public static EnumSet<SmartLoginOption> parseOptions(long j) {
        EnumSet<SmartLoginOption> noneOf = EnumSet.noneOf(SmartLoginOption.class);
        Iterator<SmartLoginOption> it = ALL.iterator();
        while (it.hasNext()) {
            SmartLoginOption next = it.next();
            if ((next.getValue() & j) != 0) {
                noneOf.add(next);
            }
        }
        return noneOf;
    }

    public long getValue() {
        return this.mValue;
    }
}
