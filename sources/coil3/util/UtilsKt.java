package coil3.util;

import coil3.Image;
import coil3.request.ErrorResult;
import coil3.request.ImageRequest;
import coil3.request.NullRequestDataException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"coil-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nutils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 utils.kt\ncoil3/util/UtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,100:1\n1#2:101\n*E\n"})
public final class UtilsKt {

    /* renamed from: a  reason: collision with root package name */
    public static final Function1 f161a = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                coil3.decode.DataSource[] r0 = coil3.decode.DataSource.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                coil3.decode.DataSource r1 = coil3.decode.DataSource.MEMORY_CACHE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                coil3.decode.DataSource r1 = coil3.decode.DataSource.MEMORY     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                coil3.decode.DataSource r1 = coil3.decode.DataSource.DISK     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                coil3.decode.DataSource r1 = coil3.decode.DataSource.NETWORK     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: coil3.util.UtilsKt.WhenMappings.<clinit>():void");
        }
    }

    public static final ErrorResult a(ImageRequest imageRequest, Throwable th) {
        Image image;
        if (th instanceof NullRequestDataException) {
            image = (Image) imageRequest.o.invoke(imageRequest);
            ImageRequest.Defaults defaults = imageRequest.u;
            if (image == null) {
                image = (Image) defaults.j.invoke(imageRequest);
            }
            if (image == null && (image = (Image) imageRequest.n.invoke(imageRequest)) == null) {
                image = (Image) defaults.i.invoke(imageRequest);
            }
        } else {
            image = (Image) imageRequest.n.invoke(imageRequest);
            if (image == null) {
                image = (Image) imageRequest.u.i.invoke(imageRequest);
            }
        }
        return new ErrorResult(image, imageRequest, th);
    }

    public static final Function1 b() {
        return UtilsKt$EMPTY_IMAGE_FACTORY$1.c;
    }
}
