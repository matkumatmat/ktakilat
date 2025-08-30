package com.ktakilat.loan.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003JC\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/ktakilat/loan/utils/LivenessResult;", "", "code", "", "message", "", "liveness_id", "sequence_id", "image", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getLiveness_id", "getSequence_id", "getImage", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LivenessResult {
    private final int code;
    @Nullable
    private final String image;
    @Nullable
    private final String liveness_id;
    @Nullable
    private final String message;
    @Nullable
    private final String sequence_id;

    public LivenessResult(int i, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.code = i;
        this.message = str;
        this.liveness_id = str2;
        this.sequence_id = str3;
        this.image = str4;
    }

    public static /* synthetic */ LivenessResult copy$default(LivenessResult livenessResult, int i, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = livenessResult.code;
        }
        if ((i2 & 2) != 0) {
            str = livenessResult.message;
        }
        String str5 = str;
        if ((i2 & 4) != 0) {
            str2 = livenessResult.liveness_id;
        }
        String str6 = str2;
        if ((i2 & 8) != 0) {
            str3 = livenessResult.sequence_id;
        }
        String str7 = str3;
        if ((i2 & 16) != 0) {
            str4 = livenessResult.image;
        }
        return livenessResult.copy(i, str5, str6, str7, str4);
    }

    public final int component1() {
        return this.code;
    }

    @Nullable
    public final String component2() {
        return this.message;
    }

    @Nullable
    public final String component3() {
        return this.liveness_id;
    }

    @Nullable
    public final String component4() {
        return this.sequence_id;
    }

    @Nullable
    public final String component5() {
        return this.image;
    }

    @NotNull
    public final LivenessResult copy(int i, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        return new LivenessResult(i, str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LivenessResult)) {
            return false;
        }
        LivenessResult livenessResult = (LivenessResult) obj;
        return this.code == livenessResult.code && Intrinsics.a(this.message, livenessResult.message) && Intrinsics.a(this.liveness_id, livenessResult.liveness_id) && Intrinsics.a(this.sequence_id, livenessResult.sequence_id) && Intrinsics.a(this.image, livenessResult.image);
    }

    public final int getCode() {
        return this.code;
    }

    @Nullable
    public final String getImage() {
        return this.image;
    }

    @Nullable
    public final String getLiveness_id() {
        return this.liveness_id;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final String getSequence_id() {
        return this.sequence_id;
    }

    public int hashCode() {
        int i = this.code * 31;
        String str = this.message;
        int i2 = 0;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.liveness_id;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.sequence_id;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.image;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    @NotNull
    public String toString() {
        int i = this.code;
        String str = this.message;
        String str2 = this.liveness_id;
        String str3 = this.sequence_id;
        String str4 = this.image;
        StringBuilder sb = new StringBuilder("LivenessResult(code=");
        sb.append(i);
        sb.append(", message=");
        sb.append(str);
        sb.append(", liveness_id=");
        sb.append(str2);
        sb.append(", sequence_id=");
        sb.append(str3);
        sb.append(", image=");
        return ba.r(sb, str4, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LivenessResult(int i, String str, String str2, String str3, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : str4);
    }
}
