package com.google.android.datatransport;

import androidx.annotation.Nullable;
import com.google.android.datatransport.EventContext;
import java.util.Arrays;

final class AutoValue_EventContext extends EventContext {
    private final byte[] experimentIdsClear;
    private final byte[] experimentIdsEncrypted;
    private final String pseudonymousId;

    public static final class Builder extends EventContext.Builder {
        private byte[] experimentIdsClear;
        private byte[] experimentIdsEncrypted;
        private String pseudonymousId;

        public EventContext build() {
            return new AutoValue_EventContext(this.pseudonymousId, this.experimentIdsClear, this.experimentIdsEncrypted);
        }

        public EventContext.Builder setExperimentIdsClear(byte[] bArr) {
            this.experimentIdsClear = bArr;
            return this;
        }

        public EventContext.Builder setExperimentIdsEncrypted(byte[] bArr) {
            this.experimentIdsEncrypted = bArr;
            return this;
        }

        public EventContext.Builder setPseudonymousId(String str) {
            this.pseudonymousId = str;
            return this;
        }
    }

    public boolean equals(Object obj) {
        byte[] bArr;
        byte[] bArr2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventContext)) {
            return false;
        }
        EventContext eventContext = (EventContext) obj;
        String str = this.pseudonymousId;
        if (str != null ? str.equals(eventContext.getPseudonymousId()) : eventContext.getPseudonymousId() == null) {
            byte[] bArr3 = this.experimentIdsClear;
            boolean z = eventContext instanceof AutoValue_EventContext;
            if (z) {
                bArr = ((AutoValue_EventContext) eventContext).experimentIdsClear;
            } else {
                bArr = eventContext.getExperimentIdsClear();
            }
            if (Arrays.equals(bArr3, bArr)) {
                byte[] bArr4 = this.experimentIdsEncrypted;
                if (z) {
                    bArr2 = ((AutoValue_EventContext) eventContext).experimentIdsEncrypted;
                } else {
                    bArr2 = eventContext.getExperimentIdsEncrypted();
                }
                if (Arrays.equals(bArr4, bArr2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Nullable
    public byte[] getExperimentIdsClear() {
        return this.experimentIdsClear;
    }

    @Nullable
    public byte[] getExperimentIdsEncrypted() {
        return this.experimentIdsEncrypted;
    }

    @Nullable
    public String getPseudonymousId() {
        return this.pseudonymousId;
    }

    public int hashCode() {
        int i;
        String str = this.pseudonymousId;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        return ((((i ^ 1000003) * 1000003) ^ Arrays.hashCode(this.experimentIdsClear)) * 1000003) ^ Arrays.hashCode(this.experimentIdsEncrypted);
    }

    public String toString() {
        return "EventContext{pseudonymousId=" + this.pseudonymousId + ", experimentIdsClear=" + Arrays.toString(this.experimentIdsClear) + ", experimentIdsEncrypted=" + Arrays.toString(this.experimentIdsEncrypted) + "}";
    }

    private AutoValue_EventContext(@Nullable String str, @Nullable byte[] bArr, @Nullable byte[] bArr2) {
        this.pseudonymousId = str;
        this.experimentIdsClear = bArr;
        this.experimentIdsEncrypted = bArr2;
    }
}
