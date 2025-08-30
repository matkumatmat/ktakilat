package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.ExternalPrivacyContext;

final class AutoValue_ExternalPrivacyContext extends ExternalPrivacyContext {
    private final ExternalPRequestContext prequest;

    public static final class Builder extends ExternalPrivacyContext.Builder {
        private ExternalPRequestContext prequest;

        public ExternalPrivacyContext build() {
            return new AutoValue_ExternalPrivacyContext(this.prequest);
        }

        public ExternalPrivacyContext.Builder setPrequest(@Nullable ExternalPRequestContext externalPRequestContext) {
            this.prequest = externalPRequestContext;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ExternalPrivacyContext)) {
            return false;
        }
        ExternalPRequestContext externalPRequestContext = this.prequest;
        ExternalPRequestContext prequest2 = ((ExternalPrivacyContext) obj).getPrequest();
        if (externalPRequestContext != null) {
            return externalPRequestContext.equals(prequest2);
        }
        if (prequest2 == null) {
            return true;
        }
        return false;
    }

    @Nullable
    public ExternalPRequestContext getPrequest() {
        return this.prequest;
    }

    public int hashCode() {
        int i;
        ExternalPRequestContext externalPRequestContext = this.prequest;
        if (externalPRequestContext == null) {
            i = 0;
        } else {
            i = externalPRequestContext.hashCode();
        }
        return i ^ 1000003;
    }

    public String toString() {
        return "ExternalPrivacyContext{prequest=" + this.prequest + "}";
    }

    private AutoValue_ExternalPrivacyContext(@Nullable ExternalPRequestContext externalPRequestContext) {
        this.prequest = externalPRequestContext;
    }
}
