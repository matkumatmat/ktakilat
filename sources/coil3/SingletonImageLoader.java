package coil3;

import android.content.Context;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004R\u0013\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00028\u0002X\u0004¨\u0006\u0005"}, d2 = {"Lcoil3/SingletonImageLoader;", "", "Lkotlinx/atomicfu/AtomicRef;", "reference", "Factory", "coil_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSingletonImageLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SingletonImageLoader.kt\ncoil3/SingletonImageLoader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,132:1\n1#2:133\n*E\n"})
public final class SingletonImageLoader {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private f62a = new Object();

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0002À\u0006\u0001"}, d2 = {"Lcoil3/SingletonImageLoader$Factory;", "", "coil_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Factory {
        RealImageLoader a(Context context);
    }

    public static final ImageLoader a(Context context) {
        ImageLoader imageLoader;
        RealImageLoader realImageLoader;
        ImageLoader imageLoader2;
        Factory factory;
        Factory factory2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private.b;
        SingletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private singletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private = f62a;
        Object obj = atomicReferenceFieldUpdater.get(singletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private);
        if (obj instanceof ImageLoader) {
            imageLoader = (ImageLoader) obj;
        } else {
            imageLoader = null;
        }
        if (imageLoader != null) {
            return imageLoader;
        }
        RealImageLoader realImageLoader2 = null;
        while (true) {
            Object obj2 = atomicReferenceFieldUpdater.get(singletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private);
            if (obj2 instanceof ImageLoader) {
                imageLoader2 = (ImageLoader) obj2;
                realImageLoader = realImageLoader2;
            } else {
                if (realImageLoader2 == null) {
                    if (obj2 instanceof Factory) {
                        factory = (Factory) obj2;
                    } else {
                        factory = null;
                    }
                    if (factory != null) {
                        realImageLoader2 = factory.a(context);
                    } else {
                        Context applicationContext = context.getApplicationContext();
                        if (applicationContext instanceof Factory) {
                            factory2 = (Factory) applicationContext;
                        } else {
                            factory2 = null;
                        }
                        if (factory2 != null) {
                            realImageLoader2 = factory2.a(context);
                        } else {
                            realImageLoader2 = SingletonImageLoaderKt.f64a.a(context);
                        }
                    }
                }
                imageLoader2 = realImageLoader2;
                realImageLoader = imageLoader2;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(singletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private, obj2, imageLoader2)) {
                if (atomicReferenceFieldUpdater.get(singletonImageLoader$SingletonImageLoader$VolatileWrapper$atomicfu$private) != obj2) {
                    realImageLoader2 = realImageLoader;
                }
            }
            Intrinsics.d(imageLoader2, "null cannot be cast to non-null type coil3.ImageLoader");
            return imageLoader2;
        }
    }
}
