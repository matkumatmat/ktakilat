package coil3.util;

import android.os.SystemClock;
import coil3.size.Dimension;
import coil3.size.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcoil3/util/LimitedFileDescriptorHardwareBitmapService;", "Lcoil3/util/HardwareBitmapService;", "Companion", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nhardwareBitmaps.kt\nKotlin\n*S Kotlin\n*F\n+ 1 hardwareBitmaps.kt\ncoil3/util/LimitedFileDescriptorHardwareBitmapService\n+ 2 Dimension.kt\ncoil3/size/DimensionKt\n*L\n1#1,218:1\n43#2:219\n43#2:220\n*S KotlinDebug\n*F\n+ 1 hardwareBitmaps.kt\ncoil3/util/LimitedFileDescriptorHardwareBitmapService\n*L\n46#1:219\n47#1:220\n*E\n"})
final class LimitedFileDescriptorHardwareBitmapService implements HardwareBitmapService {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcoil3/util/LimitedFileDescriptorHardwareBitmapService$Companion;", "", "", "MIN_SIZE_DIMENSION", "I", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
    }

    public final boolean a(Size size) {
        int i;
        Dimension dimension = size.f150a;
        int i2 = Integer.MAX_VALUE;
        if (dimension instanceof Dimension.Pixels) {
            i = ((Dimension.Pixels) dimension).f148a;
        } else {
            i = Integer.MAX_VALUE;
        }
        if (i > 100) {
            Dimension dimension2 = size.b;
            if (dimension2 instanceof Dimension.Pixels) {
                i2 = ((Dimension.Pixels) dimension2).f148a;
            }
            if (i2 > 100) {
                return true;
            }
        }
        return false;
    }

    public final boolean b() {
        boolean z;
        synchronized (FileDescriptorCounter.f155a) {
            try {
                int i = FileDescriptorCounter.c;
                FileDescriptorCounter.c = i + 1;
                if (i >= 30 || SystemClock.uptimeMillis() > FileDescriptorCounter.d + ((long) 30000)) {
                    boolean z2 = false;
                    FileDescriptorCounter.c = 0;
                    FileDescriptorCounter.d = SystemClock.uptimeMillis();
                    String[] list = FileDescriptorCounter.b.list();
                    if (list == null) {
                        list = new String[0];
                    }
                    if (list.length < 800) {
                        z2 = true;
                    }
                    FileDescriptorCounter.e = z2;
                }
                z = FileDescriptorCounter.e;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return z;
    }
}
