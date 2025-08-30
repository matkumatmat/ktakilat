package androidx.privacysandbox.ads.adservices.common;

import android.adservices.common.KeyedFrequencyCap;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import kotlin.collections.EmptyList;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bBG\b\u0007\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\bJ\r\u0010\u000e\u001a\u00020\u000fH\u0001¢\u0006\u0002\b\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018*\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0003R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001c"}, d2 = {"Landroidx/privacysandbox/ads/adservices/common/FrequencyCapFilters;", "", "keyedFrequencyCapsForWinEvents", "", "Landroidx/privacysandbox/ads/adservices/common/KeyedFrequencyCap;", "keyedFrequencyCapsForImpressionEvents", "keyedFrequencyCapsForViewEvents", "keyedFrequencyCapsForClickEvents", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getKeyedFrequencyCapsForClickEvents", "()Ljava/util/List;", "getKeyedFrequencyCapsForImpressionEvents", "getKeyedFrequencyCapsForViewEvents", "getKeyedFrequencyCapsForWinEvents", "convertToAdServices", "Landroid/adservices/common/FrequencyCapFilters;", "convertToAdServices$ads_adservices_release", "equals", "", "other", "hashCode", "", "toString", "", "", "Landroid/adservices/common/KeyedFrequencyCap;", "AdEventType", "Companion", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@ExperimentalFeatures.Ext8OptIn
public final class FrequencyCapFilters {
    public static final int AD_EVENT_TYPE_CLICK = 3;
    public static final int AD_EVENT_TYPE_IMPRESSION = 1;
    public static final int AD_EVENT_TYPE_VIEW = 2;
    public static final int AD_EVENT_TYPE_WIN = 0;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final List<KeyedFrequencyCap> keyedFrequencyCapsForClickEvents;
    @NotNull
    private final List<KeyedFrequencyCap> keyedFrequencyCapsForImpressionEvents;
    @NotNull
    private final List<KeyedFrequencyCap> keyedFrequencyCapsForViewEvents;
    @NotNull
    private final List<KeyedFrequencyCap> keyedFrequencyCapsForWinEvents;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/privacysandbox/ads/adservices/common/FrequencyCapFilters$AdEventType;", "", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    public @interface AdEventType {
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/privacysandbox/ads/adservices/common/FrequencyCapFilters$Companion;", "", "()V", "AD_EVENT_TYPE_CLICK", "", "AD_EVENT_TYPE_IMPRESSION", "AD_EVENT_TYPE_VIEW", "AD_EVENT_TYPE_WIN", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @JvmOverloads
    public FrequencyCapFilters() {
        this((List) null, (List) null, (List) null, (List) null, 15, (DefaultConstructorMarker) null);
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 8), @RequiresExtension(extension = 31, version = 9)})
    private final List<KeyedFrequencyCap> convertToAdServices(List<KeyedFrequencyCap> list) {
        ArrayList arrayList = new ArrayList();
        for (KeyedFrequencyCap convertToAdServices$ads_adservices_release : list) {
            arrayList.add(convertToAdServices$ads_adservices_release.convertToAdServices$ads_adservices_release());
        }
        return arrayList;
    }

    @NotNull
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 8), @RequiresExtension(extension = 31, version = 9)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.common.FrequencyCapFilters convertToAdServices$ads_adservices_release() {
        android.adservices.common.FrequencyCapFilters o = l9.n().setKeyedFrequencyCapsForWinEvents(convertToAdServices(this.keyedFrequencyCapsForWinEvents)).setKeyedFrequencyCapsForImpressionEvents(convertToAdServices(this.keyedFrequencyCapsForImpressionEvents)).setKeyedFrequencyCapsForViewEvents(convertToAdServices(this.keyedFrequencyCapsForViewEvents)).setKeyedFrequencyCapsForClickEvents(convertToAdServices(this.keyedFrequencyCapsForClickEvents)).build();
        Intrinsics.checkNotNullExpressionValue(o, "Builder()\n            .s…   )\n            .build()");
        return o;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FrequencyCapFilters)) {
            return false;
        }
        FrequencyCapFilters frequencyCapFilters = (FrequencyCapFilters) obj;
        if (!Intrinsics.a(this.keyedFrequencyCapsForWinEvents, frequencyCapFilters.keyedFrequencyCapsForWinEvents) || !Intrinsics.a(this.keyedFrequencyCapsForImpressionEvents, frequencyCapFilters.keyedFrequencyCapsForImpressionEvents) || !Intrinsics.a(this.keyedFrequencyCapsForViewEvents, frequencyCapFilters.keyedFrequencyCapsForViewEvents) || !Intrinsics.a(this.keyedFrequencyCapsForClickEvents, frequencyCapFilters.keyedFrequencyCapsForClickEvents)) {
            return false;
        }
        return true;
    }

    @NotNull
    public final List<KeyedFrequencyCap> getKeyedFrequencyCapsForClickEvents() {
        return this.keyedFrequencyCapsForClickEvents;
    }

    @NotNull
    public final List<KeyedFrequencyCap> getKeyedFrequencyCapsForImpressionEvents() {
        return this.keyedFrequencyCapsForImpressionEvents;
    }

    @NotNull
    public final List<KeyedFrequencyCap> getKeyedFrequencyCapsForViewEvents() {
        return this.keyedFrequencyCapsForViewEvents;
    }

    @NotNull
    public final List<KeyedFrequencyCap> getKeyedFrequencyCapsForWinEvents() {
        return this.keyedFrequencyCapsForWinEvents;
    }

    public int hashCode() {
        int hashCode = this.keyedFrequencyCapsForImpressionEvents.hashCode();
        int hashCode2 = this.keyedFrequencyCapsForViewEvents.hashCode();
        return this.keyedFrequencyCapsForClickEvents.hashCode() + ((hashCode2 + ((hashCode + (this.keyedFrequencyCapsForWinEvents.hashCode() * 31)) * 31)) * 31);
    }

    @NotNull
    public String toString() {
        return "FrequencyCapFilters: keyedFrequencyCapsForWinEvents=" + this.keyedFrequencyCapsForWinEvents + ", keyedFrequencyCapsForImpressionEvents=" + this.keyedFrequencyCapsForImpressionEvents + ", keyedFrequencyCapsForViewEvents=" + this.keyedFrequencyCapsForViewEvents + ", keyedFrequencyCapsForClickEvents=" + this.keyedFrequencyCapsForClickEvents;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FrequencyCapFilters(@NotNull List<KeyedFrequencyCap> list) {
        this(list, (List) null, (List) null, (List) null, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(list, "keyedFrequencyCapsForWinEvents");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FrequencyCapFilters(@NotNull List<KeyedFrequencyCap> list, @NotNull List<KeyedFrequencyCap> list2) {
        this(list, list2, (List) null, (List) null, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(list, "keyedFrequencyCapsForWinEvents");
        Intrinsics.checkNotNullParameter(list2, "keyedFrequencyCapsForImpressionEvents");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FrequencyCapFilters(@NotNull List<KeyedFrequencyCap> list, @NotNull List<KeyedFrequencyCap> list2, @NotNull List<KeyedFrequencyCap> list3) {
        this(list, list2, list3, (List) null, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(list, "keyedFrequencyCapsForWinEvents");
        Intrinsics.checkNotNullParameter(list2, "keyedFrequencyCapsForImpressionEvents");
        Intrinsics.checkNotNullParameter(list3, "keyedFrequencyCapsForViewEvents");
    }

    @JvmOverloads
    public FrequencyCapFilters(@NotNull List<KeyedFrequencyCap> list, @NotNull List<KeyedFrequencyCap> list2, @NotNull List<KeyedFrequencyCap> list3, @NotNull List<KeyedFrequencyCap> list4) {
        Intrinsics.checkNotNullParameter(list, "keyedFrequencyCapsForWinEvents");
        Intrinsics.checkNotNullParameter(list2, "keyedFrequencyCapsForImpressionEvents");
        Intrinsics.checkNotNullParameter(list3, "keyedFrequencyCapsForViewEvents");
        Intrinsics.checkNotNullParameter(list4, "keyedFrequencyCapsForClickEvents");
        this.keyedFrequencyCapsForWinEvents = list;
        this.keyedFrequencyCapsForImpressionEvents = list2;
        this.keyedFrequencyCapsForViewEvents = list3;
        this.keyedFrequencyCapsForClickEvents = list4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FrequencyCapFilters(List list, List list2, List list3, List list4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? EmptyList.INSTANCE : list, (i & 2) != 0 ? EmptyList.INSTANCE : list2, (i & 4) != 0 ? EmptyList.INSTANCE : list3, (i & 8) != 0 ? EmptyList.INSTANCE : list4);
    }
}
