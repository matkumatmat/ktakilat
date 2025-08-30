package coil3.map;

import android.content.Context;
import android.content.res.Resources;
import coil3.Uri;
import coil3.UriKt;
import coil3.request.Options;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¨\u0006\u0004"}, d2 = {"Lcoil3/map/ResourceIntMapper;", "Lcoil3/map/Mapper;", "", "Lcoil3/Uri;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ResourceIntMapper implements Mapper<Integer, Uri> {
    public final Uri a(Object obj, Options options) {
        Context context = options.f145a;
        int intValue = ((Number) obj).intValue();
        try {
            if (context.getResources().getResourceEntryName(intValue) != null) {
                return UriKt.e("android.resource://" + context.getPackageName() + '/' + intValue);
            }
        } catch (Resources.NotFoundException unused) {
        }
        return null;
    }
}
