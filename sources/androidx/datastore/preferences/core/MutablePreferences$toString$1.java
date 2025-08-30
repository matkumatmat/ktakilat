package androidx.datastore.preferences.core;

import androidx.datastore.preferences.core.Preferences;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010'\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "entry", "", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class MutablePreferences$toString$1 extends Lambda implements Function1<Map.Entry<Preferences.Key<?>, Object>, CharSequence> {
    public static final MutablePreferences$toString$1 INSTANCE = new MutablePreferences$toString$1();

    public MutablePreferences$toString$1() {
        super(1);
    }

    @NotNull
    public final CharSequence invoke(@NotNull Map.Entry<Preferences.Key<?>, Object> entry) {
        String str;
        Intrinsics.checkNotNullParameter(entry, "entry");
        Object value = entry.getValue();
        if (value instanceof byte[]) {
            byte[] bArr = (byte[]) value;
            Intrinsics.checkNotNullParameter(bArr, "<this>");
            Intrinsics.checkNotNullParameter(", ", "separator");
            Intrinsics.checkNotNullParameter("[", "prefix");
            Intrinsics.checkNotNullParameter("]", "postfix");
            Intrinsics.checkNotNullParameter("...", "truncated");
            StringBuilder sb = new StringBuilder();
            Intrinsics.checkNotNullParameter(bArr, "<this>");
            Intrinsics.checkNotNullParameter(sb, "buffer");
            Intrinsics.checkNotNullParameter(", ", "separator");
            Intrinsics.checkNotNullParameter("[", "prefix");
            Intrinsics.checkNotNullParameter("]", "postfix");
            Intrinsics.checkNotNullParameter("...", "truncated");
            sb.append("[");
            int i = 0;
            for (byte b : bArr) {
                i++;
                if (i > 1) {
                    sb.append(", ");
                }
                sb.append(String.valueOf(b));
            }
            sb.append("]");
            str = sb.toString();
        } else {
            str = String.valueOf(entry.getValue());
        }
        return "  " + entry.getKey().getName() + " = " + str;
    }
}
