package androidx.privacysandbox.ads.adservices.adselection;

import android.net.Uri;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.AdSelectionSignals;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ExperimentalFeatures.Ext10OptIn
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\r\u0010\u0016\u001a\u00020\u0017H\u0001¢\u0006\u0002\b\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionFromOutcomesConfig;", "", "seller", "Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "adSelectionIds", "", "", "adSelectionSignals", "Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;", "selectionLogicUri", "Landroid/net/Uri;", "(Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;Ljava/util/List;Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;Landroid/net/Uri;)V", "getAdSelectionIds", "()Ljava/util/List;", "getAdSelectionSignals", "()Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;", "getSelectionLogicUri", "()Landroid/net/Uri;", "setSelectionLogicUri", "(Landroid/net/Uri;)V", "getSeller", "()Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "convertToAdServices", "Landroid/adservices/adselection/AdSelectionFromOutcomesConfig;", "convertToAdServices$ads_adservices_release", "equals", "", "other", "hashCode", "", "toString", "", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AdSelectionFromOutcomesConfig {
    @NotNull
    private final List<Long> adSelectionIds;
    @NotNull
    private final AdSelectionSignals adSelectionSignals;
    @NotNull
    private Uri selectionLogicUri;
    @NotNull
    private final AdTechIdentifier seller;

    public AdSelectionFromOutcomesConfig(@NotNull AdTechIdentifier adTechIdentifier, @NotNull List<Long> list, @NotNull AdSelectionSignals adSelectionSignals2, @NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(adTechIdentifier, "seller");
        Intrinsics.checkNotNullParameter(list, "adSelectionIds");
        Intrinsics.checkNotNullParameter(adSelectionSignals2, "adSelectionSignals");
        Intrinsics.checkNotNullParameter(uri, "selectionLogicUri");
        this.seller = adTechIdentifier;
        this.adSelectionIds = list;
        this.adSelectionSignals = adSelectionSignals2;
        this.selectionLogicUri = uri;
    }

    @NotNull
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.adselection.AdSelectionFromOutcomesConfig convertToAdServices$ads_adservices_release() {
        android.adservices.adselection.AdSelectionFromOutcomesConfig f = s.a().setSelectionSignals(this.adSelectionSignals.convertToAdServices$ads_adservices_release()).setAdSelectionIds(this.adSelectionIds).setSelectionLogicUri(this.selectionLogicUri).setSeller(this.seller.convertToAdServices$ads_adservices_release()).build();
        Intrinsics.checkNotNullExpressionValue(f, "Builder()\n            .s…s())\n            .build()");
        return f;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdSelectionFromOutcomesConfig)) {
            return false;
        }
        AdSelectionFromOutcomesConfig adSelectionFromOutcomesConfig = (AdSelectionFromOutcomesConfig) obj;
        if (!Intrinsics.a(this.seller, adSelectionFromOutcomesConfig.seller) || !Intrinsics.a(this.adSelectionIds, adSelectionFromOutcomesConfig.adSelectionIds) || !Intrinsics.a(this.adSelectionSignals, adSelectionFromOutcomesConfig.adSelectionSignals) || !Intrinsics.a(this.selectionLogicUri, adSelectionFromOutcomesConfig.selectionLogicUri)) {
            return false;
        }
        return true;
    }

    @NotNull
    public final List<Long> getAdSelectionIds() {
        return this.adSelectionIds;
    }

    @NotNull
    public final AdSelectionSignals getAdSelectionSignals() {
        return this.adSelectionSignals;
    }

    @NotNull
    public final Uri getSelectionLogicUri() {
        return this.selectionLogicUri;
    }

    @NotNull
    public final AdTechIdentifier getSeller() {
        return this.seller;
    }

    public int hashCode() {
        int hashCode = this.adSelectionIds.hashCode();
        int hashCode2 = this.adSelectionSignals.hashCode();
        return this.selectionLogicUri.hashCode() + ((hashCode2 + ((hashCode + (this.seller.hashCode() * 31)) * 31)) * 31);
    }

    public final void setSelectionLogicUri(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<set-?>");
        this.selectionLogicUri = uri;
    }

    @NotNull
    public String toString() {
        return "AdSelectionFromOutcomesConfig: seller=" + this.seller + ", adSelectionIds='" + this.adSelectionIds + "', adSelectionSignals=" + this.adSelectionSignals + ", selectionLogicUri=" + this.selectionLogicUri;
    }
}
