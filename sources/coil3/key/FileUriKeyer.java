package coil3.key;

import coil3.Uri;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcoil3/key/FileUriKeyer;", "Lcoil3/key/Keyer;", "Lcoil3/Uri;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FileUriKeyer implements Keyer<Uri> {
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(java.lang.Object r6, coil3.request.Options r7) {
        /*
            r5 = this;
            coil3.Uri r6 = (coil3.Uri) r6
            kotlin.jvm.functions.Function1 r0 = coil3.util.UtilsKt.f161a
            java.lang.String r0 = r6.c
            r1 = 0
            r2 = 1
            java.lang.String r3 = "file"
            if (r0 == 0) goto L_0x0012
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0033
        L_0x0012:
            java.lang.String r0 = r6.e
            if (r0 == 0) goto L_0x0033
            android.graphics.Bitmap$Config[] r0 = coil3.util.Utils_androidKt.f162a
            java.lang.String r0 = r6.c
            boolean r0 = kotlin.jvm.internal.Intrinsics.a(r0, r3)
            if (r0 == 0) goto L_0x0031
            java.util.List r0 = coil3.UriKt.c(r6)
            java.lang.Object r0 = kotlin.collections.CollectionsKt.firstOrNull(r0)
            java.lang.String r3 = "android_asset"
            boolean r0 = kotlin.jvm.internal.Intrinsics.a(r0, r3)
            if (r0 == 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r0 = 1
            goto L_0x0034
        L_0x0033:
            r0 = 0
        L_0x0034:
            r3 = 0
            if (r0 == 0) goto L_0x006f
            coil3.Extras$Key r0 = coil3.request.ImageRequestsKt.b
            java.lang.Object r0 = coil3.ExtrasKt.b(r7, r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x006f
            java.lang.String r0 = coil3.UriKt.b(r6)
            if (r0 == 0) goto L_0x006f
            okio.Path$Companion r4 = okio.Path.Companion
            okio.Path r0 = okio.Path.Companion.get$default((okio.Path.Companion) r4, (java.lang.String) r0, (boolean) r1, (int) r2, (java.lang.Object) r3)
            okio.FileSystem r7 = r7.f
            okio.FileMetadata r7 = r7.metadata(r0)
            java.lang.Long r7 = r7.getLastModifiedAtMillis()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r6)
            r6 = 45
            r0.append(r6)
            r0.append(r7)
            java.lang.String r3 = r0.toString()
        L_0x006f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.key.FileUriKeyer.a(java.lang.Object, coil3.request.Options):java.lang.String");
    }
}
