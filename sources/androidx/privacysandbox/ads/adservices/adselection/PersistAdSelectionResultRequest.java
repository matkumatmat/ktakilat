package androidx.privacysandbox.ads.adservices.adselection;

import android.adservices.adselection.PersistAdSelectionResultRequest;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ExperimentalFeatures.Ext10OptIn
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\r\u0010\u000f\u001a\u00020\u0010H\u0001¢\u0006\u0002\b\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Landroidx/privacysandbox/ads/adservices/adselection/PersistAdSelectionResultRequest;", "", "adSelectionId", "", "seller", "Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "adSelectionResult", "", "(JLandroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;[B)V", "getAdSelectionId", "()J", "getAdSelectionResult", "()[B", "getSeller", "()Landroidx/privacysandbox/ads/adservices/common/AdTechIdentifier;", "convertToAdServices", "Landroid/adservices/adselection/PersistAdSelectionResultRequest;", "convertToAdServices$ads_adservices_release", "equals", "", "other", "hashCode", "", "toString", "", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PersistAdSelectionResultRequest {
    private final long adSelectionId;
    @Nullable
    private final byte[] adSelectionResult;
    @Nullable
    private final AdTechIdentifier seller;

    @JvmOverloads
    public PersistAdSelectionResultRequest(long j) {
        this(j, (AdTechIdentifier) null, (byte[]) null, 6, (DefaultConstructorMarker) null);
    }

    @NotNull
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.adselection.PersistAdSelectionResultRequest convertToAdServices$ads_adservices_release() {
        android.adservices.common.AdTechIdentifier adTechIdentifier;
        PersistAdSelectionResultRequest.Builder g = l9.f().setAdSelectionId(this.adSelectionId);
        AdTechIdentifier adTechIdentifier2 = this.seller;
        if (adTechIdentifier2 != null) {
            adTechIdentifier = adTechIdentifier2.convertToAdServices$ads_adservices_release();
        } else {
            adTechIdentifier = null;
        }
        android.adservices.adselection.PersistAdSelectionResultRequest j = g.setSeller(adTechIdentifier).setAdSelectionResult(this.adSelectionResult).build();
        Intrinsics.checkNotNullExpressionValue(j, "Builder()\n            .s…ult)\n            .build()");
        return j;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PersistAdSelectionResultRequest)) {
            return false;
        }
        PersistAdSelectionResultRequest persistAdSelectionResultRequest = (PersistAdSelectionResultRequest) obj;
        if (this.adSelectionId != persistAdSelectionResultRequest.adSelectionId || !Intrinsics.a(this.seller, persistAdSelectionResultRequest.seller) || !Arrays.equals(this.adSelectionResult, persistAdSelectionResultRequest.adSelectionResult)) {
            return false;
        }
        return true;
    }

    public final long getAdSelectionId() {
        return this.adSelectionId;
    }

    @Nullable
    public final byte[] getAdSelectionResult() {
        return this.adSelectionResult;
    }

    @Nullable
    public final AdTechIdentifier getSeller() {
        return this.seller;
    }

    public int hashCode() {
        int i;
        long j = this.adSelectionId;
        int i2 = ((int) (j ^ (j >>> 32))) * 31;
        AdTechIdentifier adTechIdentifier = this.seller;
        int i3 = 0;
        if (adTechIdentifier != null) {
            i = adTechIdentifier.hashCode();
        } else {
            i = 0;
        }
        int i4 = (i2 + i) * 31;
        byte[] bArr = this.adSelectionResult;
        if (bArr != null) {
            i3 = bArr.hashCode();
        }
        return i4 + i3;
    }

    @NotNull
    public String toString() {
        return "PersistAdSelectionResultRequest: adSelectionId=" + this.adSelectionId + ", seller=" + this.seller + ", adSelectionResult=" + this.adSelectionResult;
    }

    @JvmOverloads
    public PersistAdSelectionResultRequest(long j, @Nullable AdTechIdentifier adTechIdentifier) {
        this(j, adTechIdentifier, (byte[]) null, 4, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public PersistAdSelectionResultRequest(long j, @Nullable AdTechIdentifier adTechIdentifier, @Nullable byte[] bArr) {
        this.adSelectionId = j;
        this.seller = adTechIdentifier;
        this.adSelectionResult = bArr;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PersistAdSelectionResultRequest(long j, AdTechIdentifier adTechIdentifier, byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? null : adTechIdentifier, (i & 4) != 0 ? null : bArr);
    }
}
