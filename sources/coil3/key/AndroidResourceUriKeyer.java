package coil3.key;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import coil3.Uri;
import coil3.request.Options;
import coil3.util.Utils_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcoil3/key/AndroidResourceUriKeyer;", "Lcoil3/key/Keyer;", "Lcoil3/Uri;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidResourceUriKeyer implements Keyer<Uri> {
    public final String a(Object obj, Options options) {
        Uri uri = (Uri) obj;
        if (!Intrinsics.a(uri.c, "android.resource")) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(uri);
        sb.append(':');
        Configuration configuration = options.f145a.getResources().getConfiguration();
        Bitmap.Config[] configArr = Utils_androidKt.f162a;
        sb.append(configuration.uiMode & 48);
        return sb.toString();
    }
}
