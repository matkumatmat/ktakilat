package androidx.privacysandbox.ads.adservices.adselection;

import android.annotation.SuppressLint;
import android.net.Uri;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ExperimentalFeatures.Ext10OptIn
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\r\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0002\b\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Landroidx/privacysandbox/ads/adservices/adselection/GetAdSelectionDataRequest;", "", "seller", "Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "coordinatorOriginUri", "Landroid/net/Uri;", "(Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;Landroid/net/Uri;)V", "getCoordinatorOriginUri$annotations", "()V", "getCoordinatorOriginUri", "()Landroid/net/Uri;", "getSeller", "()Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "convertToAdServices", "Landroid/adservices/adselection/GetAdSelectionDataRequest;", "convertToAdServices$ads_adservices_release", "equals", "", "other", "hashCode", "", "toString", "", "Ext10Impl", "Ext12Impl", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GetAdSelectionDataRequest {
    @Nullable
    private final Uri coordinatorOriginUri;
    @NotNull
    private final AdTechIdentifier seller;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Landroidx/privacysandbox/ads/adservices/adselection/GetAdSelectionDataRequest$Ext10Impl;", "", "()V", "Companion", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    public static final class Ext10Impl {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Landroidx/privacysandbox/ads/adservices/adselection/GetAdSelectionDataRequest$Ext10Impl$Companion;", "", "()V", "convertGetAdSelectionDataRequest", "Landroid/adservices/adselection/GetAdSelectionDataRequest;", "request", "Landroidx/privacysandbox/ads/adservices/adselection/GetAdSelectionDataRequest;", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final android.adservices.adselection.GetAdSelectionDataRequest convertGetAdSelectionDataRequest(@NotNull GetAdSelectionDataRequest getAdSelectionDataRequest) {
                Intrinsics.checkNotNullParameter(getAdSelectionDataRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
                android.adservices.adselection.GetAdSelectionDataRequest e = l9.e(l9.c(l9.b(), getAdSelectionDataRequest.getSeller().convertToAdServices$ads_adservices_release()));
                Intrinsics.checkNotNullExpressionValue(e, "Builder()\n              …                 .build()");
                return e;
            }

            private Companion() {
            }
        }

        private Ext10Impl() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Landroidx/privacysandbox/ads/adservices/adselection/GetAdSelectionDataRequest$Ext12Impl;", "", "()V", "Companion", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 12), @RequiresExtension(extension = 31, version = 12)})
    public static final class Ext12Impl {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Landroidx/privacysandbox/ads/adservices/adselection/GetAdSelectionDataRequest$Ext12Impl$Companion;", "", "()V", "convertGetAdSelectionDataRequest", "Landroid/adservices/adselection/GetAdSelectionDataRequest;", "request", "Landroidx/privacysandbox/ads/adservices/adselection/GetAdSelectionDataRequest;", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final android.adservices.adselection.GetAdSelectionDataRequest convertGetAdSelectionDataRequest(@NotNull GetAdSelectionDataRequest getAdSelectionDataRequest) {
                Intrinsics.checkNotNullParameter(getAdSelectionDataRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
                android.adservices.adselection.GetAdSelectionDataRequest e = l9.e(l9.d(l9.c(l9.b(), getAdSelectionDataRequest.getSeller().convertToAdServices$ads_adservices_release()), getAdSelectionDataRequest.getCoordinatorOriginUri()));
                Intrinsics.checkNotNullExpressionValue(e, "Builder()\n              …                 .build()");
                return e;
            }

            private Companion() {
            }
        }

        private Ext12Impl() {
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GetAdSelectionDataRequest(@NotNull AdTechIdentifier adTechIdentifier) {
        this(adTechIdentifier, (Uri) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(adTechIdentifier, "seller");
    }

    @ExperimentalFeatures.Ext12OptIn
    public static /* synthetic */ void getCoordinatorOriginUri$annotations() {
    }

    @SuppressLint({"NewApi"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @NotNull
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    public final android.adservices.adselection.GetAdSelectionDataRequest convertToAdServices$ads_adservices_release() {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        if (adServicesInfo.adServicesVersion() >= 12 || adServicesInfo.extServicesVersionS() >= 12) {
            return Ext12Impl.Companion.convertGetAdSelectionDataRequest(this);
        }
        return Ext10Impl.Companion.convertGetAdSelectionDataRequest(this);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetAdSelectionDataRequest)) {
            return false;
        }
        GetAdSelectionDataRequest getAdSelectionDataRequest = (GetAdSelectionDataRequest) obj;
        if (!Intrinsics.a(this.seller, getAdSelectionDataRequest.seller) || !Intrinsics.a(this.coordinatorOriginUri, getAdSelectionDataRequest.coordinatorOriginUri)) {
            return false;
        }
        return true;
    }

    @Nullable
    public final Uri getCoordinatorOriginUri() {
        return this.coordinatorOriginUri;
    }

    @NotNull
    public final AdTechIdentifier getSeller() {
        return this.seller;
    }

    public int hashCode() {
        int i;
        int hashCode = this.seller.hashCode() * 31;
        Uri uri = this.coordinatorOriginUri;
        if (uri != null) {
            i = uri.hashCode();
        } else {
            i = 0;
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "GetAdSelectionDataRequest: seller=" + this.seller + ", coordinatorOriginUri=" + this.coordinatorOriginUri;
    }

    @JvmOverloads
    public GetAdSelectionDataRequest(@NotNull AdTechIdentifier adTechIdentifier, @Nullable Uri uri) {
        Intrinsics.checkNotNullParameter(adTechIdentifier, "seller");
        this.seller = adTechIdentifier;
        this.coordinatorOriginUri = uri;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetAdSelectionDataRequest(AdTechIdentifier adTechIdentifier, Uri uri, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(adTechIdentifier, (i & 2) != 0 ? null : uri);
    }
}
