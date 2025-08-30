package defpackage;

import android.content.Context;
import coil3.ComponentRegistry;
import coil3.Extras;
import coil3.ImageLoader;
import coil3.RealImageLoader;
import coil3.SingletonImageLoader;
import coil3.SingletonImageLoaderKt;
import coil3.request.ImageRequest;
import coil3.size.Precision;
import coil3.size.Scale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import okio.FileSystem;

/* renamed from: we  reason: default package */
public final /* synthetic */ class we implements SingletonImageLoader.Factory {
    public final RealImageLoader a(Context context) {
        we weVar = SingletonImageLoaderKt.f64a;
        ImageLoader.Builder builder = new ImageLoader.Builder(context);
        Unit unit = Unit.f696a;
        Extras.Key key = SingletonImageLoaderKt.b;
        Extras.Builder builder2 = builder.c;
        builder2.b(key, unit);
        Extras a2 = builder2.a();
        ImageRequest.Defaults defaults = builder.b;
        FileSystem fileSystem = defaults.f139a;
        Scale scale = defaults.l;
        Precision precision = defaults.m;
        Precision precision2 = precision;
        ImageRequest.Defaults defaults2 = new ImageRequest.Defaults(fileSystem, defaults.b, defaults.c, defaults.d, defaults.e, defaults.f, defaults.g, defaults.h, defaults.i, defaults.j, defaults.k, scale, precision2, a2);
        Lazy b = LazyKt.b(new c(builder, 5));
        Lazy b2 = LazyKt.b(new q0(7));
        EmptyList emptyList = EmptyList.INSTANCE;
        return new RealImageLoader(new RealImageLoader.Options(builder.f57a, defaults2, b, b2, new ComponentRegistry(emptyList, emptyList, emptyList, emptyList, emptyList)));
    }
}
