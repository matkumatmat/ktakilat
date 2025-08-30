package androidx.privacysandbox.ads.adservices.adselection;

import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ExperimentalFeatures.Ext10OptIn
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Landroidx/privacysandbox/ads/adservices/adselection/GetAdSelectionDataOutcome;", "", "response", "Landroid/adservices/adselection/GetAdSelectionDataOutcome;", "(Landroid/adservices/adselection/GetAdSelectionDataOutcome;)V", "adSelectionId", "", "adSelectionData", "", "(J[B)V", "getAdSelectionData", "()[B", "getAdSelectionId", "()J", "equals", "", "other", "hashCode", "", "toString", "", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GetAdSelectionDataOutcome {
    @Nullable
    private final byte[] adSelectionData;
    private final long adSelectionId;

    @JvmOverloads
    public GetAdSelectionDataOutcome(long j) {
        this(j, (byte[]) null, 2, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetAdSelectionDataOutcome)) {
            return false;
        }
        GetAdSelectionDataOutcome getAdSelectionDataOutcome = (GetAdSelectionDataOutcome) obj;
        if (this.adSelectionId != getAdSelectionDataOutcome.adSelectionId || !Arrays.equals(this.adSelectionData, getAdSelectionDataOutcome.adSelectionData)) {
            return false;
        }
        return true;
    }

    @Nullable
    public final byte[] getAdSelectionData() {
        return this.adSelectionData;
    }

    public final long getAdSelectionId() {
        return this.adSelectionId;
    }

    public int hashCode() {
        int i;
        long j = this.adSelectionId;
        int i2 = ((int) (j ^ (j >>> 32))) * 31;
        byte[] bArr = this.adSelectionData;
        if (bArr != null) {
            i = bArr.hashCode();
        } else {
            i = 0;
        }
        return i2 + i;
    }

    @NotNull
    public String toString() {
        return "GetAdSelectionDataOutcome: adSelectionId=" + this.adSelectionId + ", adSelectionData=" + this.adSelectionData;
    }

    @JvmOverloads
    public GetAdSelectionDataOutcome(long j, @Nullable byte[] bArr) {
        this.adSelectionId = j;
        this.adSelectionData = bArr;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetAdSelectionDataOutcome(long j, byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? null : bArr);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public GetAdSelectionDataOutcome(@NotNull android.adservices.adselection.GetAdSelectionDataOutcome getAdSelectionDataOutcome) {
        this(getAdSelectionDataOutcome.getAdSelectionId(), l9.z(getAdSelectionDataOutcome));
        Intrinsics.checkNotNullParameter(getAdSelectionDataOutcome, "response");
    }
}
