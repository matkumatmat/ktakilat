package androidx.privacysandbox.ads.adservices.customaudience;

import android.net.Uri;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Landroidx/privacysandbox/ads/adservices/customaudience/TrustedBiddingData;", "", "trustedBiddingUri", "Landroid/net/Uri;", "trustedBiddingKeys", "", "", "(Landroid/net/Uri;Ljava/util/List;)V", "getTrustedBiddingKeys", "()Ljava/util/List;", "getTrustedBiddingUri", "()Landroid/net/Uri;", "equals", "", "other", "hashCode", "", "toString", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TrustedBiddingData {
    @NotNull
    private final List<String> trustedBiddingKeys;
    @NotNull
    private final Uri trustedBiddingUri;

    public TrustedBiddingData(@NotNull Uri uri, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(uri, "trustedBiddingUri");
        Intrinsics.checkNotNullParameter(list, "trustedBiddingKeys");
        this.trustedBiddingUri = uri;
        this.trustedBiddingKeys = list;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TrustedBiddingData)) {
            return false;
        }
        TrustedBiddingData trustedBiddingData = (TrustedBiddingData) obj;
        if (!Intrinsics.a(this.trustedBiddingUri, trustedBiddingData.trustedBiddingUri) || !Intrinsics.a(this.trustedBiddingKeys, trustedBiddingData.trustedBiddingKeys)) {
            return false;
        }
        return true;
    }

    @NotNull
    public final List<String> getTrustedBiddingKeys() {
        return this.trustedBiddingKeys;
    }

    @NotNull
    public final Uri getTrustedBiddingUri() {
        return this.trustedBiddingUri;
    }

    public int hashCode() {
        return this.trustedBiddingKeys.hashCode() + (this.trustedBiddingUri.hashCode() * 31);
    }

    @NotNull
    public String toString() {
        return "TrustedBiddingData: trustedBiddingUri=" + this.trustedBiddingUri + " trustedBiddingKeys=" + this.trustedBiddingKeys;
    }
}
