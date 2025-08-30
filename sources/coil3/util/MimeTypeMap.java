package coil3.util;

import coil3.annotation.InternalCoilApi;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.ClassUtils;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/util/MimeTypeMap;", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@InternalCoilApi
public final class MimeTypeMap {
    public static String a(String str) {
        if (StringsKt.t(str)) {
            return null;
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str2 = (String) MimeTypesKt.f159a.get(lowerCase);
        if (str2 == null) {
            return android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(lowerCase);
        }
        return str2;
    }

    public static String b(String str) {
        if (StringsKt.t(str)) {
            return null;
        }
        String M = StringsKt.M(StringsKt.M(str, '#'), '?');
        return a(StringsKt.L(StringsKt.L(M, '/', M), ClassUtils.PACKAGE_SEPARATOR_CHAR, ""));
    }
}
