package coil3.util;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import coil3.RealImageLoader;
import coil3.memory.MemoryCache;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcoil3/util/AndroidSystemCallbacks;", "Lcoil3/util/SystemCallbacks;", "Landroid/content/ComponentCallbacks2;", "Companion", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSystemCallbacks.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SystemCallbacks.kt\ncoil3/util/AndroidSystemCallbacks\n+ 2 logging.kt\ncoil3/util/LoggingKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,77:1\n70#1,2:78\n70#1,2:80\n70#1:82\n71#1:88\n68#2,4:83\n1#3:87\n*S KotlinDebug\n*F\n+ 1 SystemCallbacks.kt\ncoil3/util/AndroidSystemCallbacks\n*L\n32#1:78,2\n50#1:80,2\n53#1:82\n53#1:88\n54#1:83,4\n*E\n"})
public final class AndroidSystemCallbacks implements SystemCallbacks, ComponentCallbacks2 {
    public final WeakReference c;
    public Context d;
    public boolean e;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcoil3/util/AndroidSystemCallbacks$Companion;", "", "", "TAG", "Ljava/lang/String;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
    }

    public AndroidSystemCallbacks(RealImageLoader realImageLoader) {
        this.c = new WeakReference(realImageLoader);
    }

    public final synchronized void a() {
        try {
            if (!this.e) {
                this.e = true;
                Context context = this.d;
                if (context != null) {
                    context.unregisterComponentCallbacks(this);
                }
                this.c.clear();
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public final synchronized void onConfigurationChanged(Configuration configuration) {
        if (((RealImageLoader) this.c.get()) == null) {
            a();
        }
    }

    public final synchronized void onLowMemory() {
        onTrimMemory(80);
    }

    public final synchronized void onTrimMemory(int i) {
        MemoryCache c2;
        try {
            RealImageLoader realImageLoader = (RealImageLoader) this.c.get();
            if (realImageLoader == null) {
                a();
            } else if (i >= 40) {
                MemoryCache c3 = realImageLoader.c();
                if (c3 != null) {
                    c3.clear();
                }
            } else if (i >= 10 && (c2 = realImageLoader.c()) != null) {
                c2.b(c2.getSize() / ((long) 2));
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }
}
