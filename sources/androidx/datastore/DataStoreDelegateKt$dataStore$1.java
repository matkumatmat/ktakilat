package androidx.datastore;

import android.content.Context;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Landroidx/datastore/core/DataMigration;", "T", "it", "Landroid/content/Context;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class DataStoreDelegateKt$dataStore$1 extends Lambda implements Function1 {
    public static final DataStoreDelegateKt$dataStore$1 INSTANCE = new DataStoreDelegateKt$dataStore$1();

    public DataStoreDelegateKt$dataStore$1() {
        super(1);
    }

    @NotNull
    public final List invoke(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "it");
        return EmptyList.INSTANCE;
    }
}
