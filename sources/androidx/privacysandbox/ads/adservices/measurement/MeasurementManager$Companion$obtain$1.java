package androidx.privacysandbox.ads.adservices.measurement;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/privacysandbox/ads/adservices/measurement/MeasurementManagerApi31Ext9Impl;", "it", "Landroid/content/Context;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class MeasurementManager$Companion$obtain$1 extends Lambda implements Function1<Context, MeasurementManagerApi31Ext9Impl> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MeasurementManager$Companion$obtain$1(Context context) {
        super(1);
        this.$context = context;
    }

    public final MeasurementManagerApi31Ext9Impl invoke(Context context) {
        Intrinsics.checkNotNullParameter(context, "it");
        return new MeasurementManagerApi31Ext9Impl(this.$context);
    }
}
