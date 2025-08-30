package org.apache.commons.lang3.arch;

import com.facebook.internal.AnalyticsEvents;

public class Processor {
    private final Arch arch;
    private final Type type;

    public enum Arch {
        BIT_32("32-bit"),
        BIT_64("64-bit"),
        UNKNOWN(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);
        
        private final String label;

        private Arch(String str) {
            this.label = str;
        }

        public String getLabel() {
            return this.label;
        }
    }

    public enum Type {
        X86,
        IA_64,
        PPC,
        UNKNOWN
    }

    public Processor(Arch arch2, Type type2) {
        this.arch = arch2;
        this.type = type2;
    }

    public Arch getArch() {
        return this.arch;
    }

    public Type getType() {
        return this.type;
    }

    public boolean is32Bit() {
        if (Arch.BIT_32 == this.arch) {
            return true;
        }
        return false;
    }

    public boolean is64Bit() {
        if (Arch.BIT_64 == this.arch) {
            return true;
        }
        return false;
    }

    public boolean isIA64() {
        if (Type.IA_64 == this.type) {
            return true;
        }
        return false;
    }

    public boolean isPPC() {
        if (Type.PPC == this.type) {
            return true;
        }
        return false;
    }

    public boolean isX86() {
        if (Type.X86 == this.type) {
            return true;
        }
        return false;
    }
}
