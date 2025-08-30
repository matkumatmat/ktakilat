package androidx.privacysandbox.ads.adservices.topics;

import android.adservices.topics.EncryptedTopic;
import android.adservices.topics.GetTopicsResponse;
import android.adservices.topics.Topic;
import android.annotation.SuppressLint;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\b\u0007J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"Landroidx/privacysandbox/ads/adservices/topics/GetTopicsResponseHelper;", "", "()V", "convertResponse", "Landroidx/privacysandbox/ads/adservices/topics/GetTopicsResponse;", "response", "Landroid/adservices/topics/GetTopicsResponse;", "convertResponse$ads_adservices_release", "convertResponseWithEncryptedTopics", "convertResponseWithEncryptedTopics$ads_adservices_release", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SuppressLint({"ClassVerificationFailure"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class GetTopicsResponseHelper {
    @NotNull
    public static final GetTopicsResponseHelper INSTANCE = new GetTopicsResponseHelper();

    private GetTopicsResponseHelper() {
    }

    @NotNull
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    public final GetTopicsResponse convertResponse$ads_adservices_release(@NotNull GetTopicsResponse getTopicsResponse) {
        Intrinsics.checkNotNullParameter(getTopicsResponse, "response");
        ArrayList arrayList = new ArrayList();
        for (Object x : getTopicsResponse.getTopics()) {
            Topic x2 = w4.x(x);
            arrayList.add(new Topic(x2.getTaxonomyVersion(), x2.getModelVersion(), x2.getTopicId()));
        }
        return new GetTopicsResponse(arrayList);
    }

    @NotNull
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 11), @RequiresExtension(extension = 31, version = 11)})
    @ExperimentalFeatures.Ext11OptIn
    public final GetTopicsResponse convertResponseWithEncryptedTopics$ads_adservices_release(@NotNull GetTopicsResponse getTopicsResponse) {
        Intrinsics.checkNotNullParameter(getTopicsResponse, "response");
        ArrayList arrayList = new ArrayList();
        for (Object x : getTopicsResponse.getTopics()) {
            Topic x2 = w4.x(x);
            arrayList.add(new Topic(x2.getTaxonomyVersion(), x2.getModelVersion(), x2.getTopicId()));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object u : getTopicsResponse.getEncryptedTopics()) {
            EncryptedTopic u2 = l9.u(u);
            byte[] A = u2.getEncryptedTopic();
            Intrinsics.checkNotNullExpressionValue(A, "encryptedTopic.encryptedTopic");
            String v = u2.getKeyIdentifier();
            Intrinsics.checkNotNullExpressionValue(v, "encryptedTopic.keyIdentifier");
            byte[] C = u2.getEncapsulatedKey();
            Intrinsics.checkNotNullExpressionValue(C, "encryptedTopic.encapsulatedKey");
            arrayList2.add(new EncryptedTopic(A, v, C));
        }
        return new GetTopicsResponse(arrayList, arrayList2);
    }
}
