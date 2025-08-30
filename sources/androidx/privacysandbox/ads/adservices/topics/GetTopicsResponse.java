package androidx.privacysandbox.ads.adservices.topics;

import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005B#\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0002\u0010\bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0013"}, d2 = {"Landroidx/privacysandbox/ads/adservices/topics/GetTopicsResponse;", "", "topics", "", "Landroidx/privacysandbox/ads/adservices/topics/Topic;", "(Ljava/util/List;)V", "encryptedTopics", "Landroidx/privacysandbox/ads/adservices/topics/EncryptedTopic;", "(Ljava/util/List;Ljava/util/List;)V", "getEncryptedTopics", "()Ljava/util/List;", "getTopics", "equals", "", "other", "hashCode", "", "toString", "", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GetTopicsResponse {
    @NotNull
    private final List<EncryptedTopic> encryptedTopics;
    @NotNull
    private final List<Topic> topics;

    @ExperimentalFeatures.Ext11OptIn
    public GetTopicsResponse(@NotNull List<Topic> list, @NotNull List<EncryptedTopic> list2) {
        Intrinsics.checkNotNullParameter(list, "topics");
        Intrinsics.checkNotNullParameter(list2, "encryptedTopics");
        this.topics = list;
        this.encryptedTopics = list2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetTopicsResponse)) {
            return false;
        }
        GetTopicsResponse getTopicsResponse = (GetTopicsResponse) obj;
        if (this.topics.size() != getTopicsResponse.topics.size() || this.encryptedTopics.size() != getTopicsResponse.encryptedTopics.size() || !new HashSet(this.topics).equals(new HashSet(getTopicsResponse.topics)) || !new HashSet(this.encryptedTopics).equals(new HashSet(getTopicsResponse.encryptedTopics))) {
            return false;
        }
        return true;
    }

    @NotNull
    public final List<EncryptedTopic> getEncryptedTopics() {
        return this.encryptedTopics;
    }

    @NotNull
    public final List<Topic> getTopics() {
        return this.topics;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.topics, this.encryptedTopics});
    }

    @NotNull
    public String toString() {
        return "GetTopicsResponse: Topics=" + this.topics + ", EncryptedTopics=" + this.encryptedTopics;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GetTopicsResponse(@NotNull List<Topic> list) {
        this(list, EmptyList.INSTANCE);
        Intrinsics.checkNotNullParameter(list, "topics");
    }
}
