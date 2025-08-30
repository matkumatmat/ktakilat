package androidx.privacysandbox.ads.adservices.topics;

import android.adservices.topics.GetTopicsRequest;
import android.annotation.SuppressLint;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\b\u0007J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"Landroidx/privacysandbox/ads/adservices/topics/GetTopicsRequestHelper;", "", "()V", "convertRequestWithRecordObservation", "Landroid/adservices/topics/GetTopicsRequest;", "request", "Landroidx/privacysandbox/ads/adservices/topics/GetTopicsRequest;", "convertRequestWithRecordObservation$ads_adservices_release", "convertRequestWithoutRecordObservation", "convertRequestWithoutRecordObservation$ads_adservices_release", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SuppressLint({"ClassVerificationFailure"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class GetTopicsRequestHelper {
    @NotNull
    public static final GetTopicsRequestHelper INSTANCE = new GetTopicsRequestHelper();

    private GetTopicsRequestHelper() {
    }

    @NotNull
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 5), @RequiresExtension(extension = 31, version = 9)})
    public final GetTopicsRequest convertRequestWithRecordObservation$ads_adservices_release(@NotNull GetTopicsRequest getTopicsRequest) {
        Intrinsics.checkNotNullParameter(getTopicsRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        GetTopicsRequest w = w4.t().setAdsSdkName(getTopicsRequest.getAdsSdkName()).setShouldRecordObservation(getTopicsRequest.shouldRecordObservation()).build();
        Intrinsics.checkNotNullExpressionValue(w, "Builder()\n            .s…ion)\n            .build()");
        return w;
    }

    @NotNull
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    public final GetTopicsRequest convertRequestWithoutRecordObservation$ads_adservices_release(@NotNull GetTopicsRequest getTopicsRequest) {
        Intrinsics.checkNotNullParameter(getTopicsRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        GetTopicsRequest w = w4.t().setAdsSdkName(getTopicsRequest.getAdsSdkName()).build();
        Intrinsics.checkNotNullExpressionValue(w, "Builder()\n            .s…ame)\n            .build()");
        return w;
    }
}
