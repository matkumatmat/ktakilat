package androidx.privacysandbox.ads.adservices.adselection;

import android.annotation.SuppressLint;
import android.net.Uri;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.AdSelectionSignals;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\f\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0002\u0010\u000eJ\r\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0002\b\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020$H\u0016J\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020&0%*\b\u0012\u0004\u0012\u00020\u00030\u0007H\u0003J&\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0006\u0012\u0004\u0018\u00010(0'*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\fH\u0003R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014¨\u0006*"}, d2 = {"Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionConfig;", "", "seller", "Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "decisionLogicUri", "Landroid/net/Uri;", "customAudienceBuyers", "", "adSelectionSignals", "Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;", "sellerSignals", "perBuyerSignals", "", "trustedScoringSignalsUri", "(Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;Landroid/net/Uri;Ljava/util/List;Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;Ljava/util/Map;Landroid/net/Uri;)V", "getAdSelectionSignals", "()Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;", "getCustomAudienceBuyers", "()Ljava/util/List;", "getDecisionLogicUri", "()Landroid/net/Uri;", "getPerBuyerSignals", "()Ljava/util/Map;", "getSeller", "()Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "getSellerSignals", "getTrustedScoringSignalsUri", "convertToAdServices", "Landroid/adservices/adselection/AdSelectionConfig;", "convertToAdServices$ads_adservices_release", "equals", "", "other", "hashCode", "", "toString", "", "", "Landroid/adservices/common/AdTechIdentifier;", "", "Landroid/adservices/common/AdSelectionSignals;", "Companion", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SuppressLint({"ClassVerificationFailure"})
public final class AdSelectionConfig {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final AdSelectionConfig EMPTY;
    @NotNull
    private final AdSelectionSignals adSelectionSignals;
    @NotNull
    private final List<AdTechIdentifier> customAudienceBuyers;
    @NotNull
    private final Uri decisionLogicUri;
    @NotNull
    private final Map<AdTechIdentifier, AdSelectionSignals> perBuyerSignals;
    @NotNull
    private final AdTechIdentifier seller;
    @NotNull
    private final AdSelectionSignals sellerSignals;
    @NotNull
    private final Uri trustedScoringSignalsUri;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionConfig$Companion;", "", "()V", "EMPTY", "Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionConfig;", "getEMPTY", "()Landroidx/privacysandbox/ads/adservices/adselection/AdSelectionConfig;", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AdSelectionConfig getEMPTY() {
            return AdSelectionConfig.EMPTY;
        }

        private Companion() {
        }
    }

    static {
        AdTechIdentifier adTechIdentifier = new AdTechIdentifier("");
        Uri uri = Uri.EMPTY;
        Intrinsics.checkNotNullExpressionValue(uri, "EMPTY");
        EmptyList emptyList = EmptyList.INSTANCE;
        AdSelectionSignals adSelectionSignals2 = new AdSelectionSignals("");
        AdSelectionSignals adSelectionSignals3 = new AdSelectionSignals("");
        Map b = MapsKt.b();
        Intrinsics.checkNotNullExpressionValue(uri, "EMPTY");
        EMPTY = new AdSelectionConfig(adTechIdentifier, uri, emptyList, adSelectionSignals2, adSelectionSignals3, b, uri);
    }

    public AdSelectionConfig(@NotNull AdTechIdentifier adTechIdentifier, @NotNull Uri uri, @NotNull List<AdTechIdentifier> list, @NotNull AdSelectionSignals adSelectionSignals2, @NotNull AdSelectionSignals adSelectionSignals3, @NotNull Map<AdTechIdentifier, AdSelectionSignals> map, @NotNull Uri uri2) {
        Intrinsics.checkNotNullParameter(adTechIdentifier, "seller");
        Intrinsics.checkNotNullParameter(uri, "decisionLogicUri");
        Intrinsics.checkNotNullParameter(list, "customAudienceBuyers");
        Intrinsics.checkNotNullParameter(adSelectionSignals2, "adSelectionSignals");
        Intrinsics.checkNotNullParameter(adSelectionSignals3, "sellerSignals");
        Intrinsics.checkNotNullParameter(map, "perBuyerSignals");
        Intrinsics.checkNotNullParameter(uri2, "trustedScoringSignalsUri");
        this.seller = adTechIdentifier;
        this.decisionLogicUri = uri;
        this.customAudienceBuyers = list;
        this.adSelectionSignals = adSelectionSignals2;
        this.sellerSignals = adSelectionSignals3;
        this.perBuyerSignals = map;
        this.trustedScoringSignalsUri = uri2;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    private final List<android.adservices.common.AdTechIdentifier> convertToAdServices(List<AdTechIdentifier> list) {
        ArrayList arrayList = new ArrayList();
        for (AdTechIdentifier convertToAdServices$ads_adservices_release : list) {
            arrayList.add(convertToAdServices$ads_adservices_release.convertToAdServices$ads_adservices_release());
        }
        return arrayList;
    }

    @NotNull
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.adselection.AdSelectionConfig convertToAdServices$ads_adservices_release() {
        android.adservices.adselection.AdSelectionConfig k = r.e().setAdSelectionSignals(this.adSelectionSignals.convertToAdServices$ads_adservices_release()).setCustomAudienceBuyers(convertToAdServices(this.customAudienceBuyers)).setDecisionLogicUri(this.decisionLogicUri).setSeller(this.seller.convertToAdServices$ads_adservices_release()).setPerBuyerSignals(convertToAdServices(this.perBuyerSignals)).setSellerSignals(this.sellerSignals.convertToAdServices$ads_adservices_release()).setTrustedScoringSignalsUri(this.trustedScoringSignalsUri).build();
        Intrinsics.checkNotNullExpressionValue(k, "Builder()\n            .s…Uri)\n            .build()");
        return k;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdSelectionConfig)) {
            return false;
        }
        AdSelectionConfig adSelectionConfig = (AdSelectionConfig) obj;
        if (!Intrinsics.a(this.seller, adSelectionConfig.seller) || !Intrinsics.a(this.decisionLogicUri, adSelectionConfig.decisionLogicUri) || !Intrinsics.a(this.customAudienceBuyers, adSelectionConfig.customAudienceBuyers) || !Intrinsics.a(this.adSelectionSignals, adSelectionConfig.adSelectionSignals) || !Intrinsics.a(this.sellerSignals, adSelectionConfig.sellerSignals) || !Intrinsics.a(this.perBuyerSignals, adSelectionConfig.perBuyerSignals) || !Intrinsics.a(this.trustedScoringSignalsUri, adSelectionConfig.trustedScoringSignalsUri)) {
            return false;
        }
        return true;
    }

    @NotNull
    public final AdSelectionSignals getAdSelectionSignals() {
        return this.adSelectionSignals;
    }

    @NotNull
    public final List<AdTechIdentifier> getCustomAudienceBuyers() {
        return this.customAudienceBuyers;
    }

    @NotNull
    public final Uri getDecisionLogicUri() {
        return this.decisionLogicUri;
    }

    @NotNull
    public final Map<AdTechIdentifier, AdSelectionSignals> getPerBuyerSignals() {
        return this.perBuyerSignals;
    }

    @NotNull
    public final AdTechIdentifier getSeller() {
        return this.seller;
    }

    @NotNull
    public final AdSelectionSignals getSellerSignals() {
        return this.sellerSignals;
    }

    @NotNull
    public final Uri getTrustedScoringSignalsUri() {
        return this.trustedScoringSignalsUri;
    }

    public int hashCode() {
        int hashCode = this.decisionLogicUri.hashCode();
        int hashCode2 = this.customAudienceBuyers.hashCode();
        int hashCode3 = this.adSelectionSignals.hashCode();
        int hashCode4 = this.sellerSignals.hashCode();
        int hashCode5 = this.perBuyerSignals.hashCode();
        return this.trustedScoringSignalsUri.hashCode() + ((hashCode5 + ((hashCode4 + ((hashCode3 + ((hashCode2 + ((hashCode + (this.seller.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    @NotNull
    public String toString() {
        return "AdSelectionConfig: seller=" + this.seller + ", decisionLogicUri='" + this.decisionLogicUri + "', customAudienceBuyers=" + this.customAudienceBuyers + ", adSelectionSignals=" + this.adSelectionSignals + ", sellerSignals=" + this.sellerSignals + ", perBuyerSignals=" + this.perBuyerSignals + ", trustedScoringSignalsUri=" + this.trustedScoringSignalsUri;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    private final Map<android.adservices.common.AdTechIdentifier, android.adservices.common.AdSelectionSignals> convertToAdServices(Map<AdTechIdentifier, AdSelectionSignals> map) {
        HashMap hashMap = new HashMap();
        for (AdTechIdentifier next : map.keySet()) {
            android.adservices.common.AdTechIdentifier convertToAdServices$ads_adservices_release = next.convertToAdServices$ads_adservices_release();
            AdSelectionSignals adSelectionSignals2 = map.get(next);
            hashMap.put(convertToAdServices$ads_adservices_release, adSelectionSignals2 != null ? adSelectionSignals2.convertToAdServices$ads_adservices_release() : null);
        }
        return hashMap;
    }
}
