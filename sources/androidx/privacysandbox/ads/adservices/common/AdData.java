package androidx.privacysandbox.ads.adservices.common;

import android.adservices.common.AdData;
import android.adservices.common.AdFilters;
import android.annotation.SuppressLint;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0003 !\"B3\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\fB?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000eJ\r\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0002\b\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Landroidx/privacysandbox/ads/adservices/common/AdData;", "", "renderUri", "Landroid/net/Uri;", "metadata", "", "adCounterKeys", "", "", "adFilters", "Landroidx/privacysandbox/ads/adservices/common/AdFilters;", "(Landroid/net/Uri;Ljava/lang/String;Ljava/util/Set;Landroidx/privacysandbox/ads/adservices/common/AdFilters;)V", "(Landroid/net/Uri;Ljava/lang/String;)V", "adRenderId", "(Landroid/net/Uri;Ljava/lang/String;Ljava/util/Set;Landroidx/privacysandbox/ads/adservices/common/AdFilters;Ljava/lang/String;)V", "getAdCounterKeys", "()Ljava/util/Set;", "getAdFilters", "()Landroidx/privacysandbox/ads/adservices/common/AdFilters;", "getAdRenderId", "()Ljava/lang/String;", "getMetadata", "getRenderUri", "()Landroid/net/Uri;", "convertToAdServices", "Landroid/adservices/common/AdData;", "convertToAdServices$ads_adservices_release", "equals", "", "other", "hashCode", "toString", "Ext10Impl", "Ext4Impl", "Ext8Impl", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SuppressLint({"ClassVerificationFailure"})
public final class AdData {
    @NotNull
    private final Set<Integer> adCounterKeys;
    @Nullable
    private final AdFilters adFilters;
    @Nullable
    private final String adRenderId;
    @NotNull
    private final String metadata;
    @NotNull
    private final Uri renderUri;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Landroidx/privacysandbox/ads/adservices/common/AdData$Ext10Impl;", "", "()V", "Companion", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    public static final class Ext10Impl {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Landroidx/privacysandbox/ads/adservices/common/AdData$Ext10Impl$Companion;", "", "()V", "convertAdData", "Landroid/adservices/common/AdData;", "adData", "Landroidx/privacysandbox/ads/adservices/common/AdData;", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final android.adservices.common.AdData convertAdData(@NotNull AdData adData) {
                AdFilters adFilters;
                Intrinsics.checkNotNullParameter(adData, "adData");
                AdData.Builder j = r.o().setMetadata(adData.getMetadata()).setRenderUri(adData.getRenderUri()).setAdCounterKeys(adData.getAdCounterKeys());
                AdFilters adFilters2 = adData.getAdFilters();
                if (adFilters2 != null) {
                    adFilters = adFilters2.convertToAdServices$ads_adservices_release();
                } else {
                    adFilters = null;
                }
                android.adservices.common.AdData r = j.setAdFilters(adFilters).setAdRenderId(adData.getAdRenderId()).build();
                Intrinsics.checkNotNullExpressionValue(r, "Builder()\n              …                 .build()");
                return r;
            }

            private Companion() {
            }
        }

        private Ext10Impl() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Landroidx/privacysandbox/ads/adservices/common/AdData$Ext4Impl;", "", "()V", "Companion", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    public static final class Ext4Impl {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Landroidx/privacysandbox/ads/adservices/common/AdData$Ext4Impl$Companion;", "", "()V", "convertAdData", "Landroid/adservices/common/AdData;", "adData", "Landroidx/privacysandbox/ads/adservices/common/AdData;", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final android.adservices.common.AdData convertAdData(@NotNull AdData adData) {
                Intrinsics.checkNotNullParameter(adData, "adData");
                if (!adData.getAdCounterKeys().isEmpty()) {
                    Log.w("AdData", "adCounterKeys is ignored. Min version to use adCounterKeys is API 33 ext 8 or API 31/32 ext 9");
                }
                if (adData.getAdFilters() != null) {
                    Log.w("AdData", "adFilters is ignored. Min version to use adFilters is API 33 ext 8 or API 31/32 ext 9");
                }
                if (adData.getAdRenderId() != null) {
                    Log.w("AdData", "adRenderId is ignored. Min version to use adRenderId is API 31 ext 10");
                }
                android.adservices.common.AdData r = r.o().setMetadata(adData.getMetadata()).setRenderUri(adData.getRenderUri()).build();
                Intrinsics.checkNotNullExpressionValue(r, "Builder()\n              …                 .build()");
                return r;
            }

            private Companion() {
            }
        }

        private Ext4Impl() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Landroidx/privacysandbox/ads/adservices/common/AdData$Ext8Impl;", "", "()V", "Companion", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 8), @RequiresExtension(extension = 31, version = 9)})
    public static final class Ext8Impl {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Landroidx/privacysandbox/ads/adservices/common/AdData$Ext8Impl$Companion;", "", "()V", "convertAdData", "Landroid/adservices/common/AdData;", "adData", "Landroidx/privacysandbox/ads/adservices/common/AdData;", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final android.adservices.common.AdData convertAdData(@NotNull AdData adData) {
                AdFilters adFilters;
                Intrinsics.checkNotNullParameter(adData, "adData");
                if (adData.getAdRenderId() != null) {
                    Log.w("AdData", "adRenderId is ignored. Min version to use adRenderId is API 31 ext 10");
                }
                AdData.Builder j = r.o().setMetadata(adData.getMetadata()).setRenderUri(adData.getRenderUri()).setAdCounterKeys(adData.getAdCounterKeys());
                AdFilters adFilters2 = adData.getAdFilters();
                if (adFilters2 != null) {
                    adFilters = adFilters2.convertToAdServices$ads_adservices_release();
                } else {
                    adFilters = null;
                }
                android.adservices.common.AdData r = j.setAdFilters(adFilters).build();
                Intrinsics.checkNotNullExpressionValue(r, "Builder()\n              …                 .build()");
                return r;
            }

            private Companion() {
            }
        }

        private Ext8Impl() {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AdData(@NotNull Uri uri, @NotNull String str) {
        this(uri, str, EmptySet.INSTANCE, (AdFilters) null);
        Intrinsics.checkNotNullParameter(uri, "renderUri");
        Intrinsics.checkNotNullParameter(str, "metadata");
    }

    @NotNull
    @SuppressLint({"NewApi"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.common.AdData convertToAdServices$ads_adservices_release() {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        if (adServicesInfo.adServicesVersion() >= 10 || adServicesInfo.extServicesVersionS() >= 10) {
            return Ext10Impl.Companion.convertAdData(this);
        }
        if (adServicesInfo.adServicesVersion() >= 8 || adServicesInfo.extServicesVersionS() >= 9) {
            return Ext8Impl.Companion.convertAdData(this);
        }
        return Ext4Impl.Companion.convertAdData(this);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdData)) {
            return false;
        }
        AdData adData = (AdData) obj;
        if (!Intrinsics.a(this.renderUri, adData.renderUri) || !Intrinsics.a(this.metadata, adData.metadata) || !Intrinsics.a(this.adCounterKeys, adData.adCounterKeys) || !Intrinsics.a(this.adFilters, adData.adFilters) || !Intrinsics.a(this.adRenderId, adData.adRenderId)) {
            return false;
        }
        return true;
    }

    @NotNull
    public final Set<Integer> getAdCounterKeys() {
        return this.adCounterKeys;
    }

    @Nullable
    public final AdFilters getAdFilters() {
        return this.adFilters;
    }

    @Nullable
    public final String getAdRenderId() {
        return this.adRenderId;
    }

    @NotNull
    public final String getMetadata() {
        return this.metadata;
    }

    @NotNull
    public final Uri getRenderUri() {
        return this.renderUri;
    }

    public int hashCode() {
        int i;
        int hashCode = (this.adCounterKeys.hashCode() + ba.d(this.renderUri.hashCode() * 31, 31, this.metadata)) * 31;
        AdFilters adFilters2 = this.adFilters;
        int i2 = 0;
        if (adFilters2 != null) {
            i = adFilters2.hashCode();
        } else {
            i = 0;
        }
        int i3 = (hashCode + i) * 31;
        String str = this.adRenderId;
        if (str != null) {
            i2 = str.hashCode();
        }
        return i3 + i2;
    }

    @NotNull
    public String toString() {
        return "AdData: renderUri=" + this.renderUri + ", metadata='" + this.metadata + "', adCounterKeys=" + this.adCounterKeys + ", adFilters=" + this.adFilters + ", adRenderId=" + this.adRenderId;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AdData(Uri uri, String str, Set set, AdFilters adFilters2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uri, str, (i & 4) != 0 ? EmptySet.INSTANCE : set, (i & 8) != 0 ? null : adFilters2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AdData(Uri uri, String str, Set set, AdFilters adFilters2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(uri, str, (i & 4) != 0 ? EmptySet.INSTANCE : set, (i & 8) != 0 ? null : adFilters2, (i & 16) != 0 ? null : str2);
    }

    @ExperimentalFeatures.Ext10OptIn
    public AdData(@NotNull Uri uri, @NotNull String str, @NotNull Set<Integer> set, @Nullable AdFilters adFilters2, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(uri, "renderUri");
        Intrinsics.checkNotNullParameter(str, "metadata");
        Intrinsics.checkNotNullParameter(set, "adCounterKeys");
        this.renderUri = uri;
        this.metadata = str;
        this.adCounterKeys = set;
        this.adFilters = adFilters2;
        this.adRenderId = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @ExperimentalFeatures.Ext8OptIn
    public AdData(@NotNull Uri uri, @NotNull String str, @NotNull Set<Integer> set, @Nullable AdFilters adFilters2) {
        this(uri, str, set, adFilters2, (String) null);
        Intrinsics.checkNotNullParameter(uri, "renderUri");
        Intrinsics.checkNotNullParameter(str, "metadata");
        Intrinsics.checkNotNullParameter(set, "adCounterKeys");
    }
}
