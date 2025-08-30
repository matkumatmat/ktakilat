package com.appsflyer.internal;

import com.appsflyer.deeplink.DeepLink;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rH×\u0001¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u00028\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014"}, d2 = {"Lcom/appsflyer/internal/AFa1mSDK;", "", "", "p0", "Lcom/appsflyer/deeplink/DeepLink;", "p1", "<init>", "(ZLcom/appsflyer/deeplink/DeepLink;)V", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getCurrencyIso4217Code", "Lcom/appsflyer/deeplink/DeepLink;", "getRevenue", "Z", "()Z", "getMonetizationNetwork"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AFa1mSDK {
    @Nullable
    public final DeepLink getCurrencyIso4217Code;
    private final boolean getRevenue;

    public AFa1mSDK(boolean z, @Nullable DeepLink deepLink) {
        this.getRevenue = z;
        this.getCurrencyIso4217Code = deepLink;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AFa1mSDK)) {
            return false;
        }
        AFa1mSDK aFa1mSDK = (AFa1mSDK) obj;
        if (this.getRevenue == aFa1mSDK.getRevenue && Intrinsics.a(this.getCurrencyIso4217Code, aFa1mSDK.getCurrencyIso4217Code)) {
            return true;
        }
        return false;
    }

    @JvmName(name = "getRevenue")
    public final boolean getRevenue() {
        return this.getRevenue;
    }

    public final int hashCode() {
        int i;
        boolean z = this.getRevenue;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        DeepLink deepLink = this.getCurrencyIso4217Code;
        if (deepLink == null) {
            i = 0;
        } else {
            i = deepLink.hashCode();
        }
        return i2 + i;
    }

    @NotNull
    public final String toString() {
        boolean z = this.getRevenue;
        DeepLink deepLink = this.getCurrencyIso4217Code;
        return "DdlResponse(secondPing=" + z + ", deepLink=" + deepLink + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AFa1mSDK(boolean z, DeepLink deepLink, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? null : deepLink);
    }

    public AFa1mSDK() {
        this(false, (DeepLink) null, 3, (DefaultConstructorMarker) null);
    }
}
