package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.ExternalPRequestContext;

final class AutoValue_ExternalPRequestContext extends ExternalPRequestContext {
    private final Integer originAssociatedProductId;

    public static final class Builder extends ExternalPRequestContext.Builder {
        private Integer originAssociatedProductId;

        public ExternalPRequestContext build() {
            return new AutoValue_ExternalPRequestContext(this.originAssociatedProductId);
        }

        public ExternalPRequestContext.Builder setOriginAssociatedProductId(@Nullable Integer num) {
            this.originAssociatedProductId = num;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ExternalPRequestContext)) {
            return false;
        }
        Integer num = this.originAssociatedProductId;
        Integer originAssociatedProductId2 = ((ExternalPRequestContext) obj).getOriginAssociatedProductId();
        if (num != null) {
            return num.equals(originAssociatedProductId2);
        }
        if (originAssociatedProductId2 == null) {
            return true;
        }
        return false;
    }

    @Nullable
    public Integer getOriginAssociatedProductId() {
        return this.originAssociatedProductId;
    }

    public int hashCode() {
        int i;
        Integer num = this.originAssociatedProductId;
        if (num == null) {
            i = 0;
        } else {
            i = num.hashCode();
        }
        return i ^ 1000003;
    }

    public String toString() {
        return "ExternalPRequestContext{originAssociatedProductId=" + this.originAssociatedProductId + "}";
    }

    private AutoValue_ExternalPRequestContext(@Nullable Integer num) {
        this.originAssociatedProductId = num;
    }
}
