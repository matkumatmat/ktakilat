package androidx.privacysandbox.ads.adservices.internal;

import android.content.Context;
import com.facebook.places.model.PlaceFields;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J9\u0010\u0003\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u0001H\u00040\n¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/privacysandbox/ads/adservices/internal/BackCompatManager;", "", "()V", "getManager", "T", "context", "Landroid/content/Context;", "tag", "", "manager", "Lkotlin/Function1;", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BackCompatManager {
    @NotNull
    public static final BackCompatManager INSTANCE = new BackCompatManager();

    private BackCompatManager() {
    }

    @Nullable
    public final <T> T getManager(@NotNull Context context, @NotNull String str, @NotNull Function1<? super Context, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(context, PlaceFields.CONTEXT);
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(function1, "manager");
        try {
            return function1.invoke(context);
        } catch (NoClassDefFoundError unused) {
            AdServicesInfo.INSTANCE.extServicesVersionS();
            return null;
        }
    }
}
