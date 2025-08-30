package coil3.util;

import android.os.SystemClock;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/util/FileDescriptorCounter;", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nhardwareBitmaps.kt\nKotlin\n*S Kotlin\n*F\n+ 1 hardwareBitmaps.kt\ncoil3/util/FileDescriptorCounter\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 logging.kt\ncoil3/util/LoggingKt\n*L\n1#1,218:1\n18#2:219\n68#3,4:220\n*S KotlinDebug\n*F\n+ 1 hardwareBitmaps.kt\ncoil3/util/FileDescriptorCounter\n*L\n88#1:219\n91#1:220,4\n*E\n"})
final class FileDescriptorCounter {

    /* renamed from: a  reason: collision with root package name */
    public static final FileDescriptorCounter f155a = new Object();
    public static final File b = new File("/proc/self/fd");
    public static int c = 30;
    public static long d = SystemClock.uptimeMillis();
    public static boolean e = true;
}
