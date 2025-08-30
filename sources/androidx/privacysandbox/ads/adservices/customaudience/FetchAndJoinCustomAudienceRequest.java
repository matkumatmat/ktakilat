package androidx.privacysandbox.ads.adservices.customaudience;

import android.adservices.customaudience.FetchAndJoinCustomAudienceRequest;
import android.net.Uri;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.AdSelectionSignals;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ExperimentalFeatures.Ext10OptIn
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\r\u0010\u0015\u001a\u00020\u0016H\u0001¢\u0006\u0002\b\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Landroidx/privacysandbox/ads/adservices/customaudience/FetchAndJoinCustomAudienceRequest;", "", "fetchUri", "Landroid/net/Uri;", "name", "", "activationTime", "Ljava/time/Instant;", "expirationTime", "userBiddingSignals", "Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;", "(Landroid/net/Uri;Ljava/lang/String;Ljava/time/Instant;Ljava/time/Instant;Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;)V", "getActivationTime", "()Ljava/time/Instant;", "getExpirationTime", "getFetchUri", "()Landroid/net/Uri;", "getName", "()Ljava/lang/String;", "getUserBiddingSignals", "()Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;", "convertToAdServices", "Landroid/adservices/customaudience/FetchAndJoinCustomAudienceRequest;", "convertToAdServices$ads_adservices_release", "equals", "", "other", "hashCode", "", "toString", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FetchAndJoinCustomAudienceRequest {
    @Nullable
    private final Instant activationTime;
    @Nullable
    private final Instant expirationTime;
    @NotNull
    private final Uri fetchUri;
    @Nullable
    private final String name;
    @Nullable
    private final AdSelectionSignals userBiddingSignals;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FetchAndJoinCustomAudienceRequest(@NotNull Uri uri) {
        this(uri, (String) null, (Instant) null, (Instant) null, (AdSelectionSignals) null, 30, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(uri, "fetchUri");
    }

    @NotNull
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.customaudience.FetchAndJoinCustomAudienceRequest convertToAdServices$ads_adservices_release() {
        android.adservices.common.AdSelectionSignals adSelectionSignals;
        s.t();
        FetchAndJoinCustomAudienceRequest.Builder B = s.r(this.fetchUri).setName(this.name).setActivationTime(this.activationTime).setExpirationTime(this.expirationTime);
        AdSelectionSignals adSelectionSignals2 = this.userBiddingSignals;
        if (adSelectionSignals2 != null) {
            adSelectionSignals = adSelectionSignals2.convertToAdServices$ads_adservices_release();
        } else {
            adSelectionSignals = null;
        }
        android.adservices.customaudience.FetchAndJoinCustomAudienceRequest s = B.setUserBiddingSignals(adSelectionSignals).build();
        Intrinsics.checkNotNullExpressionValue(s, "Builder(fetchUri)\n      …s())\n            .build()");
        return s;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FetchAndJoinCustomAudienceRequest)) {
            return false;
        }
        FetchAndJoinCustomAudienceRequest fetchAndJoinCustomAudienceRequest = (FetchAndJoinCustomAudienceRequest) obj;
        if (!Intrinsics.a(this.fetchUri, fetchAndJoinCustomAudienceRequest.fetchUri) || !Intrinsics.a(this.name, fetchAndJoinCustomAudienceRequest.name) || !Intrinsics.a(this.activationTime, fetchAndJoinCustomAudienceRequest.activationTime) || !Intrinsics.a(this.expirationTime, fetchAndJoinCustomAudienceRequest.expirationTime) || !Intrinsics.a(this.userBiddingSignals, fetchAndJoinCustomAudienceRequest.userBiddingSignals)) {
            return false;
        }
        return true;
    }

    @Nullable
    public final Instant getActivationTime() {
        return this.activationTime;
    }

    @Nullable
    public final Instant getExpirationTime() {
        return this.expirationTime;
    }

    @NotNull
    public final Uri getFetchUri() {
        return this.fetchUri;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final AdSelectionSignals getUserBiddingSignals() {
        return this.userBiddingSignals;
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        int hashCode = this.fetchUri.hashCode() * 31;
        String str = this.name;
        int i4 = 0;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i5 = (hashCode + i) * 31;
        Instant instant = this.activationTime;
        if (instant != null) {
            i2 = instant.hashCode();
        } else {
            i2 = 0;
        }
        int i6 = (i5 + i2) * 31;
        Instant instant2 = this.expirationTime;
        if (instant2 != null) {
            i3 = instant2.hashCode();
        } else {
            i3 = 0;
        }
        int i7 = (i6 + i3) * 31;
        AdSelectionSignals adSelectionSignals = this.userBiddingSignals;
        if (adSelectionSignals != null) {
            i4 = adSelectionSignals.hashCode();
        }
        return i7 + i4;
    }

    @NotNull
    public String toString() {
        return "FetchAndJoinCustomAudienceRequest: fetchUri=" + this.fetchUri + ", name=" + this.name + ", activationTime=" + this.activationTime + ", expirationTime=" + this.expirationTime + ", userBiddingSignals=" + this.userBiddingSignals;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FetchAndJoinCustomAudienceRequest(@NotNull Uri uri, @Nullable String str) {
        this(uri, str, (Instant) null, (Instant) null, (AdSelectionSignals) null, 28, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(uri, "fetchUri");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FetchAndJoinCustomAudienceRequest(@NotNull Uri uri, @Nullable String str, @Nullable Instant instant) {
        this(uri, str, instant, (Instant) null, (AdSelectionSignals) null, 24, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(uri, "fetchUri");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FetchAndJoinCustomAudienceRequest(@NotNull Uri uri, @Nullable String str, @Nullable Instant instant, @Nullable Instant instant2) {
        this(uri, str, instant, instant2, (AdSelectionSignals) null, 16, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(uri, "fetchUri");
    }

    @JvmOverloads
    public FetchAndJoinCustomAudienceRequest(@NotNull Uri uri, @Nullable String str, @Nullable Instant instant, @Nullable Instant instant2, @Nullable AdSelectionSignals adSelectionSignals) {
        Intrinsics.checkNotNullParameter(uri, "fetchUri");
        this.fetchUri = uri;
        this.name = str;
        this.activationTime = instant;
        this.expirationTime = instant2;
        this.userBiddingSignals = adSelectionSignals;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FetchAndJoinCustomAudienceRequest(Uri uri, String str, Instant instant, Instant instant2, AdSelectionSignals adSelectionSignals, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uri, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : instant, (i & 8) != 0 ? null : instant2, (i & 16) != 0 ? null : adSelectionSignals);
    }
}
