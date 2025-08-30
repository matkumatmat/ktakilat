package androidx.privacysandbox.ads.adservices.common;

import android.adservices.common.AdFilters;
import android.adservices.common.FrequencyCapFilters;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\b\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Landroidx/privacysandbox/ads/adservices/common/AdFilters;", "", "frequencyCapFilters", "Landroidx/privacysandbox/ads/adservices/common/FrequencyCapFilters;", "(Landroidx/privacysandbox/ads/adservices/common/FrequencyCapFilters;)V", "getFrequencyCapFilters", "()Landroidx/privacysandbox/ads/adservices/common/FrequencyCapFilters;", "convertToAdServices", "Landroid/adservices/common/AdFilters;", "convertToAdServices$ads_adservices_release", "equals", "", "other", "hashCode", "", "toString", "", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@ExperimentalFeatures.Ext8OptIn
public final class AdFilters {
    @Nullable
    private final FrequencyCapFilters frequencyCapFilters;

    public AdFilters(@Nullable FrequencyCapFilters frequencyCapFilters2) {
        this.frequencyCapFilters = frequencyCapFilters2;
    }

    @NotNull
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 8), @RequiresExtension(extension = 31, version = 9)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.common.AdFilters convertToAdServices$ads_adservices_release() {
        FrequencyCapFilters frequencyCapFilters2;
        AdFilters.Builder k = s.k();
        FrequencyCapFilters frequencyCapFilters3 = this.frequencyCapFilters;
        if (frequencyCapFilters3 != null) {
            frequencyCapFilters2 = frequencyCapFilters3.convertToAdServices$ads_adservices_release();
        } else {
            frequencyCapFilters2 = null;
        }
        android.adservices.common.AdFilters m = k.setFrequencyCapFilters(frequencyCapFilters2).build();
        Intrinsics.checkNotNullExpressionValue(m, "Builder()\n            .s…s())\n            .build()");
        return m;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdFilters)) {
            return false;
        }
        return Intrinsics.a(this.frequencyCapFilters, ((AdFilters) obj).frequencyCapFilters);
    }

    @Nullable
    public final FrequencyCapFilters getFrequencyCapFilters() {
        return this.frequencyCapFilters;
    }

    public int hashCode() {
        FrequencyCapFilters frequencyCapFilters2 = this.frequencyCapFilters;
        if (frequencyCapFilters2 != null) {
            return frequencyCapFilters2.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return "AdFilters: frequencyCapFilters=" + this.frequencyCapFilters;
    }
}
