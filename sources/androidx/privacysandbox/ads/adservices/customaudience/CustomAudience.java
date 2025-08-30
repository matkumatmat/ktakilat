package androidx.privacysandbox.ads.adservices.customaudience;

import android.net.Uri;
import androidx.privacysandbox.ads.adservices.common.AdData;
import androidx.privacysandbox.ads.adservices.common.AdSelectionSignals;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import java.time.Instant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001*Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006+"}, d2 = {"Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudience;", "", "buyer", "Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "name", "", "dailyUpdateUri", "Landroid/net/Uri;", "biddingLogicUri", "ads", "", "Landroidx/privacysandbox/ads/adservices/common/AdData;", "activationTime", "Ljava/time/Instant;", "expirationTime", "userBiddingSignals", "Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;", "trustedBiddingSignals", "Landroidx/privacysandbox/ads/adservices/customaudience/TrustedBiddingData;", "(Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;Ljava/lang/String;Landroid/net/Uri;Landroid/net/Uri;Ljava/util/List;Ljava/time/Instant;Ljava/time/Instant;Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;Landroidx/privacysandbox/ads/adservices/customaudience/TrustedBiddingData;)V", "getActivationTime", "()Ljava/time/Instant;", "getAds", "()Ljava/util/List;", "getBiddingLogicUri", "()Landroid/net/Uri;", "getBuyer", "()Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "getDailyUpdateUri", "getExpirationTime", "getName", "()Ljava/lang/String;", "getTrustedBiddingSignals", "()Landroidx/privacysandbox/ads/adservices/customaudience/TrustedBiddingData;", "getUserBiddingSignals", "()Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;", "equals", "", "other", "hashCode", "", "toString", "Builder", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CustomAudience {
    @Nullable
    private final Instant activationTime;
    @NotNull
    private final List<AdData> ads;
    @NotNull
    private final Uri biddingLogicUri;
    @NotNull
    private final AdTechIdentifier buyer;
    @NotNull
    private final Uri dailyUpdateUri;
    @Nullable
    private final Instant expirationTime;
    @NotNull
    private final String name;
    @Nullable
    private final TrustedBiddingData trustedBiddingSignals;
    @Nullable
    private final AdSelectionSignals userBiddingSignals;

    @SourceDebugExtension({"SMAP\nCustomAudience.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomAudience.kt\nandroidx/privacysandbox/ads/adservices/customaudience/CustomAudience$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,252:1\n1#2:253\n*E\n"})
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u0014\u0010\u0017\u001a\u00020\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0011J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudience$Builder;", "", "buyer", "Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "name", "", "dailyUpdateUri", "Landroid/net/Uri;", "biddingLogicUri", "ads", "", "Landroidx/privacysandbox/ads/adservices/common/AdData;", "(Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;Ljava/lang/String;Landroid/net/Uri;Landroid/net/Uri;Ljava/util/List;)V", "activationTime", "Ljava/time/Instant;", "expirationTime", "trustedBiddingData", "Landroidx/privacysandbox/ads/adservices/customaudience/TrustedBiddingData;", "userBiddingSignals", "Landroidx/privacysandbox/ads/adservices/common/AdSelectionSignals;", "build", "Landroidx/privacysandbox/ads/adservices/customaudience/CustomAudience;", "setActivationTime", "setAds", "setBiddingLogicUri", "setBuyer", "setDailyUpdateUri", "setExpirationTime", "setName", "setTrustedBiddingData", "trustedBiddingSignals", "setUserBiddingSignals", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {
        @Nullable
        private Instant activationTime;
        @NotNull
        private List<AdData> ads;
        @NotNull
        private Uri biddingLogicUri;
        @NotNull
        private AdTechIdentifier buyer;
        @NotNull
        private Uri dailyUpdateUri;
        @Nullable
        private Instant expirationTime;
        @NotNull
        private String name;
        @Nullable
        private TrustedBiddingData trustedBiddingData;
        @Nullable
        private AdSelectionSignals userBiddingSignals;

        public Builder(@NotNull AdTechIdentifier adTechIdentifier, @NotNull String str, @NotNull Uri uri, @NotNull Uri uri2, @NotNull List<AdData> list) {
            Intrinsics.checkNotNullParameter(adTechIdentifier, "buyer");
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(uri, "dailyUpdateUri");
            Intrinsics.checkNotNullParameter(uri2, "biddingLogicUri");
            Intrinsics.checkNotNullParameter(list, "ads");
            this.buyer = adTechIdentifier;
            this.name = str;
            this.dailyUpdateUri = uri;
            this.biddingLogicUri = uri2;
            this.ads = list;
        }

        @NotNull
        public final CustomAudience build() {
            return new CustomAudience(this.buyer, this.name, this.dailyUpdateUri, this.biddingLogicUri, this.ads, this.activationTime, this.expirationTime, this.userBiddingSignals, this.trustedBiddingData);
        }

        @NotNull
        public final Builder setActivationTime(@NotNull Instant instant) {
            Intrinsics.checkNotNullParameter(instant, "activationTime");
            this.activationTime = instant;
            return this;
        }

        @NotNull
        public final Builder setAds(@NotNull List<AdData> list) {
            Intrinsics.checkNotNullParameter(list, "ads");
            this.ads = list;
            return this;
        }

        @NotNull
        public final Builder setBiddingLogicUri(@NotNull Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "biddingLogicUri");
            this.biddingLogicUri = uri;
            return this;
        }

        @NotNull
        public final Builder setBuyer(@NotNull AdTechIdentifier adTechIdentifier) {
            Intrinsics.checkNotNullParameter(adTechIdentifier, "buyer");
            this.buyer = adTechIdentifier;
            return this;
        }

        @NotNull
        public final Builder setDailyUpdateUri(@NotNull Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "dailyUpdateUri");
            this.dailyUpdateUri = uri;
            return this;
        }

        @NotNull
        public final Builder setExpirationTime(@NotNull Instant instant) {
            Intrinsics.checkNotNullParameter(instant, "expirationTime");
            this.expirationTime = instant;
            return this;
        }

        @NotNull
        public final Builder setName(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            this.name = str;
            return this;
        }

        @NotNull
        public final Builder setTrustedBiddingData(@NotNull TrustedBiddingData trustedBiddingData2) {
            Intrinsics.checkNotNullParameter(trustedBiddingData2, "trustedBiddingSignals");
            this.trustedBiddingData = trustedBiddingData2;
            return this;
        }

        @NotNull
        public final Builder setUserBiddingSignals(@NotNull AdSelectionSignals adSelectionSignals) {
            Intrinsics.checkNotNullParameter(adSelectionSignals, "userBiddingSignals");
            this.userBiddingSignals = adSelectionSignals;
            return this;
        }
    }

    public CustomAudience(@NotNull AdTechIdentifier adTechIdentifier, @NotNull String str, @NotNull Uri uri, @NotNull Uri uri2, @NotNull List<AdData> list, @Nullable Instant instant, @Nullable Instant instant2, @Nullable AdSelectionSignals adSelectionSignals, @Nullable TrustedBiddingData trustedBiddingData) {
        Intrinsics.checkNotNullParameter(adTechIdentifier, "buyer");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(uri, "dailyUpdateUri");
        Intrinsics.checkNotNullParameter(uri2, "biddingLogicUri");
        Intrinsics.checkNotNullParameter(list, "ads");
        this.buyer = adTechIdentifier;
        this.name = str;
        this.dailyUpdateUri = uri;
        this.biddingLogicUri = uri2;
        this.ads = list;
        this.activationTime = instant;
        this.expirationTime = instant2;
        this.userBiddingSignals = adSelectionSignals;
        this.trustedBiddingSignals = trustedBiddingData;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomAudience)) {
            return false;
        }
        CustomAudience customAudience = (CustomAudience) obj;
        if (!Intrinsics.a(this.buyer, customAudience.buyer) || !Intrinsics.a(this.name, customAudience.name) || !Intrinsics.a(this.activationTime, customAudience.activationTime) || !Intrinsics.a(this.expirationTime, customAudience.expirationTime) || !Intrinsics.a(this.dailyUpdateUri, customAudience.dailyUpdateUri) || !Intrinsics.a(this.userBiddingSignals, customAudience.userBiddingSignals) || !Intrinsics.a(this.trustedBiddingSignals, customAudience.trustedBiddingSignals) || !Intrinsics.a(this.ads, customAudience.ads)) {
            return false;
        }
        return true;
    }

    @Nullable
    public final Instant getActivationTime() {
        return this.activationTime;
    }

    @NotNull
    public final List<AdData> getAds() {
        return this.ads;
    }

    @NotNull
    public final Uri getBiddingLogicUri() {
        return this.biddingLogicUri;
    }

    @NotNull
    public final AdTechIdentifier getBuyer() {
        return this.buyer;
    }

    @NotNull
    public final Uri getDailyUpdateUri() {
        return this.dailyUpdateUri;
    }

    @Nullable
    public final Instant getExpirationTime() {
        return this.expirationTime;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final TrustedBiddingData getTrustedBiddingSignals() {
        return this.trustedBiddingSignals;
    }

    @Nullable
    public final AdSelectionSignals getUserBiddingSignals() {
        return this.userBiddingSignals;
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        int d = ba.d(this.buyer.hashCode() * 31, 31, this.name);
        Instant instant = this.activationTime;
        int i4 = 0;
        if (instant != null) {
            i = instant.hashCode();
        } else {
            i = 0;
        }
        int i5 = (d + i) * 31;
        Instant instant2 = this.expirationTime;
        if (instant2 != null) {
            i2 = instant2.hashCode();
        } else {
            i2 = 0;
        }
        int hashCode = (this.dailyUpdateUri.hashCode() + ((i5 + i2) * 31)) * 31;
        AdSelectionSignals adSelectionSignals = this.userBiddingSignals;
        if (adSelectionSignals != null) {
            i3 = adSelectionSignals.hashCode();
        } else {
            i3 = 0;
        }
        int i6 = (hashCode + i3) * 31;
        TrustedBiddingData trustedBiddingData = this.trustedBiddingSignals;
        if (trustedBiddingData != null) {
            i4 = trustedBiddingData.hashCode();
        }
        int hashCode2 = this.biddingLogicUri.hashCode();
        return this.ads.hashCode() + ((hashCode2 + ((i6 + i4) * 31)) * 31);
    }

    @NotNull
    public String toString() {
        return "CustomAudience: buyer=" + this.biddingLogicUri + ", name=" + this.name + ", activationTime=" + this.activationTime + ", expirationTime=" + this.expirationTime + ", dailyUpdateUri=" + this.dailyUpdateUri + ", userBiddingSignals=" + this.userBiddingSignals + ", trustedBiddingSignals=" + this.trustedBiddingSignals + ", biddingLogicUri=" + this.biddingLogicUri + ", ads=" + this.ads;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CustomAudience(androidx.privacysandbox.ads.adservices.common.AdTechIdentifier r14, java.lang.String r15, android.net.Uri r16, android.net.Uri r17, java.util.List r18, java.time.Instant r19, java.time.Instant r20, androidx.privacysandbox.ads.adservices.common.AdSelectionSignals r21, androidx.privacysandbox.ads.adservices.customaudience.TrustedBiddingData r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 32
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r9 = r2
            goto L_0x000b
        L_0x0009:
            r9 = r19
        L_0x000b:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0011
            r10 = r2
            goto L_0x0013
        L_0x0011:
            r10 = r20
        L_0x0013:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0019
            r11 = r2
            goto L_0x001b
        L_0x0019:
            r11 = r21
        L_0x001b:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0021
            r12 = r2
            goto L_0x0023
        L_0x0021:
            r12 = r22
        L_0x0023:
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.customaudience.CustomAudience.<init>(androidx.privacysandbox.ads.adservices.common.AdTechIdentifier, java.lang.String, android.net.Uri, android.net.Uri, java.util.List, java.time.Instant, java.time.Instant, androidx.privacysandbox.ads.adservices.common.AdSelectionSignals, androidx.privacysandbox.ads.adservices.customaudience.TrustedBiddingData, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
