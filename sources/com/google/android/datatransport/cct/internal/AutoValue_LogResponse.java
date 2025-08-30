package com.google.android.datatransport.cct.internal;

final class AutoValue_LogResponse extends LogResponse {
    private final long nextRequestWaitMillis;

    public AutoValue_LogResponse(long j) {
        this.nextRequestWaitMillis = j;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogResponse) || this.nextRequestWaitMillis != ((LogResponse) obj).getNextRequestWaitMillis()) {
            return false;
        }
        return true;
    }

    public long getNextRequestWaitMillis() {
        return this.nextRequestWaitMillis;
    }

    public int hashCode() {
        long j = this.nextRequestWaitMillis;
        return 1000003 ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return ba.p(new StringBuilder("LogResponse{nextRequestWaitMillis="), this.nextRequestWaitMillis, "}");
    }
}
