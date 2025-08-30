package okio.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import okio.TypedOptions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\b¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"commonSelect", "T", "", "Lokio/BufferedSource;", "options", "Lokio/TypedOptions;", "(Lokio/BufferedSource;Lokio/TypedOptions;)Ljava/lang/Object;", "okio"}, k = 2, mv = {1, 9, 0}, xi = 48)
@JvmName(name = "-BufferedSource")
/* renamed from: okio.internal.-BufferedSource  reason: invalid class name */
public final class BufferedSource {
    @Nullable
    public static final <T> T commonSelect(@NotNull okio.BufferedSource bufferedSource, @NotNull TypedOptions<T> typedOptions) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(typedOptions, "options");
        int select = bufferedSource.select(typedOptions.getOptions$okio());
        if (select == -1) {
            return null;
        }
        return typedOptions.get(select);
    }
}
