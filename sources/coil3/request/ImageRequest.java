package coil3.request;

import android.content.Context;
import coil3.Extras;
import coil3.decode.Decoder;
import coil3.size.Precision;
import coil3.size.Scale;
import coil3.size.SizeResolver;
import coil3.target.ImageViewTarget;
import coil3.util.Collections_jvmCommonKt;
import coil3.util.UtilsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okio.FileSystem;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcoil3/request/ImageRequest;", "", "Listener", "Defined", "Defaults", "Builder", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImageRequest {

    /* renamed from: a  reason: collision with root package name */
    public final Context f137a;
    public final Object b;
    public final ImageViewTarget c;
    public final Map d;
    public final FileSystem e;
    public final Decoder.Factory f;
    public final CoroutineContext g;
    public final CoroutineContext h;
    public final CoroutineContext i;
    public final CachePolicy j;
    public final CachePolicy k;
    public final CachePolicy l;
    public final Function1 m;
    public final Function1 n;
    public final Function1 o;
    public final SizeResolver p;
    public final Scale q;
    public final Precision r;
    public final Extras s;
    public final Defined t;
    public final Defaults u;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcoil3/request/ImageRequest$Defaults;", "", "Companion", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Defaults {
        public static final Defaults o;

        /* renamed from: a  reason: collision with root package name */
        public final FileSystem f139a;
        public final CoroutineContext b;
        public final CoroutineContext c;
        public final CoroutineContext d;
        public final CachePolicy e;
        public final CachePolicy f;
        public final CachePolicy g;
        public final Function1 h;
        public final Function1 i;
        public final Function1 j;
        public final SizeResolver k;
        public final Scale l;
        public final Precision m;
        public final Extras n;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcoil3/request/ImageRequest$Defaults$Companion;", "", "Lcoil3/request/ImageRequest$Defaults;", "DEFAULT", "Lcoil3/request/ImageRequest$Defaults;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
        }

        static {
            FileSystem fileSystem = FileSystem.SYSTEM;
            EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
            DefaultScheduler defaultScheduler = Dispatchers.f767a;
            DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.c;
            CachePolicy cachePolicy = CachePolicy.ENABLED;
            o = new Defaults(fileSystem, emptyCoroutineContext, defaultIoScheduler, defaultIoScheduler, cachePolicy, cachePolicy, cachePolicy, UtilsKt.b(), UtilsKt.b(), UtilsKt.b(), SizeResolver.f151a, Scale.FIT, Precision.EXACT, Extras.b);
        }

        public Defaults(FileSystem fileSystem, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, CoroutineContext coroutineContext3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, Function1 function1, Function1 function12, Function1 function13, SizeResolver sizeResolver, Scale scale, Precision precision, Extras extras) {
            this.f139a = fileSystem;
            this.b = coroutineContext;
            this.c = coroutineContext2;
            this.d = coroutineContext3;
            this.e = cachePolicy;
            this.f = cachePolicy2;
            this.g = cachePolicy3;
            this.h = function1;
            this.i = function12;
            this.j = function13;
            this.k = sizeResolver;
            this.l = scale;
            this.m = precision;
            this.n = extras;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Defaults)) {
                return false;
            }
            Defaults defaults = (Defaults) obj;
            return Intrinsics.a(this.f139a, defaults.f139a) && Intrinsics.a(this.b, defaults.b) && Intrinsics.a(this.c, defaults.c) && Intrinsics.a(this.d, defaults.d) && this.e == defaults.e && this.f == defaults.f && this.g == defaults.g && Intrinsics.a(this.h, defaults.h) && Intrinsics.a(this.i, defaults.i) && Intrinsics.a(this.j, defaults.j) && Intrinsics.a(this.k, defaults.k) && this.l == defaults.l && this.m == defaults.m && Intrinsics.a(this.n, defaults.n);
        }

        public final int hashCode() {
            int hashCode = this.b.hashCode();
            int hashCode2 = this.c.hashCode();
            int hashCode3 = this.d.hashCode();
            int hashCode4 = this.e.hashCode();
            int hashCode5 = this.f.hashCode();
            int hashCode6 = this.g.hashCode();
            int hashCode7 = this.h.hashCode();
            int hashCode8 = this.i.hashCode();
            int hashCode9 = this.j.hashCode();
            int hashCode10 = this.k.hashCode();
            int hashCode11 = this.l.hashCode();
            int hashCode12 = this.m.hashCode();
            return this.n.f53a.hashCode() + ((hashCode12 + ((hashCode11 + ((hashCode10 + ((hashCode9 + ((hashCode8 + ((hashCode7 + ((hashCode6 + ((hashCode5 + ((hashCode4 + ((hashCode3 + ((hashCode2 + ((hashCode + (this.f139a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
        }

        public final String toString() {
            return "Defaults(fileSystem=" + this.f139a + ", interceptorCoroutineContext=" + this.b + ", fetcherCoroutineContext=" + this.c + ", decoderCoroutineContext=" + this.d + ", memoryCachePolicy=" + this.e + ", diskCachePolicy=" + this.f + ", networkCachePolicy=" + this.g + ", placeholderFactory=" + this.h + ", errorFactory=" + this.i + ", fallbackFactory=" + this.j + ", sizeResolver=" + this.k + ", scale=" + this.l + ", precision=" + this.m + ", extras=" + this.n + ')';
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/request/ImageRequest$Defined;", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Defined {

        /* renamed from: a  reason: collision with root package name */
        public final Function1 f140a;
        public final Function1 b;
        public final Function1 c;
        public final SizeResolver d;
        public final Scale e;
        public final Precision f;

        public Defined(Function1 function1, Function1 function12, Function1 function13, SizeResolver sizeResolver, Scale scale, Precision precision) {
            this.f140a = function1;
            this.b = function12;
            this.c = function13;
            this.d = sizeResolver;
            this.e = scale;
            this.f = precision;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Defined)) {
                return false;
            }
            Defined defined = (Defined) obj;
            defined.getClass();
            return Intrinsics.a((Object) null, (Object) null) && Intrinsics.a((Object) null, (Object) null) && Intrinsics.a((Object) null, (Object) null) && Intrinsics.a((Object) null, (Object) null) && Intrinsics.a(this.f140a, defined.f140a) && Intrinsics.a(this.b, defined.b) && Intrinsics.a(this.c, defined.c) && Intrinsics.a(this.d, defined.d) && this.e == defined.e && this.f == defined.f;
        }

        public final int hashCode() {
            Function1 function1 = this.f140a;
            int i = 0;
            int hashCode = (function1 == null ? 0 : function1.hashCode()) * 31;
            Function1 function12 = this.b;
            int hashCode2 = (hashCode + (function12 == null ? 0 : function12.hashCode())) * 31;
            Function1 function13 = this.c;
            int hashCode3 = (hashCode2 + (function13 == null ? 0 : function13.hashCode())) * 31;
            SizeResolver sizeResolver = this.d;
            int hashCode4 = (hashCode3 + (sizeResolver == null ? 0 : sizeResolver.hashCode())) * 31;
            Scale scale = this.e;
            int hashCode5 = (hashCode4 + (scale == null ? 0 : scale.hashCode())) * 31;
            Precision precision = this.f;
            if (precision != null) {
                i = precision.hashCode();
            }
            return hashCode5 + i;
        }

        public final String toString() {
            return "Defined(fileSystem=null, interceptorCoroutineContext=null, fetcherCoroutineContext=null, decoderCoroutineContext=null, memoryCachePolicy=null, diskCachePolicy=null, networkCachePolicy=null, placeholderFactory=" + this.f140a + ", errorFactory=" + this.b + ", fallbackFactory=" + this.c + ", sizeResolver=" + this.d + ", scale=" + this.e + ", precision=" + this.f + ')';
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0002À\u0006\u0001"}, d2 = {"Lcoil3/request/ImageRequest$Listener;", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Listener {
    }

    public ImageRequest(Context context, Object obj, ImageViewTarget imageViewTarget, Map map, FileSystem fileSystem, Decoder.Factory factory, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, CoroutineContext coroutineContext3, CachePolicy cachePolicy, CachePolicy cachePolicy2, CachePolicy cachePolicy3, Function1 function1, Function1 function12, Function1 function13, SizeResolver sizeResolver, Scale scale, Precision precision, Extras extras, Defined defined, Defaults defaults) {
        this.f137a = context;
        this.b = obj;
        this.c = imageViewTarget;
        this.d = map;
        this.e = fileSystem;
        this.f = factory;
        this.g = coroutineContext;
        this.h = coroutineContext2;
        this.i = coroutineContext3;
        this.j = cachePolicy;
        this.k = cachePolicy2;
        this.l = cachePolicy3;
        this.m = function1;
        this.n = function12;
        this.o = function13;
        this.p = sizeResolver;
        this.q = scale;
        this.r = precision;
        this.s = extras;
        this.t = defined;
        this.u = defaults;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageRequest)) {
            return false;
        }
        ImageRequest imageRequest = (ImageRequest) obj;
        if (Intrinsics.a(this.f137a, imageRequest.f137a) && this.b.equals(imageRequest.b) && Intrinsics.a(this.c, imageRequest.c) && Intrinsics.a((Object) null, (Object) null) && Intrinsics.a((Object) null, (Object) null) && this.d.equals(imageRequest.d) && Intrinsics.a((Object) null, (Object) null) && Intrinsics.a(this.e, imageRequest.e) && Intrinsics.a((Object) null, (Object) null) && Intrinsics.a(this.f, imageRequest.f) && Intrinsics.a(this.g, imageRequest.g) && Intrinsics.a(this.h, imageRequest.h) && Intrinsics.a(this.i, imageRequest.i) && this.j == imageRequest.j && this.k == imageRequest.k && this.l == imageRequest.l && Intrinsics.a((Object) null, (Object) null) && Intrinsics.a(this.m, imageRequest.m) && Intrinsics.a(this.n, imageRequest.n) && Intrinsics.a(this.o, imageRequest.o) && Intrinsics.a(this.p, imageRequest.p) && this.q == imageRequest.q && this.r == imageRequest.r && Intrinsics.a(this.s, imageRequest.s) && this.t.equals(imageRequest.t) && Intrinsics.a(this.u, imageRequest.u)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i2;
        int hashCode = (this.b.hashCode() + (this.f137a.hashCode() * 31)) * 31;
        ImageViewTarget imageViewTarget = this.c;
        int i3 = 0;
        if (imageViewTarget == null) {
            i2 = 0;
        } else {
            i2 = imageViewTarget.d.hashCode();
        }
        int hashCode2 = this.d.hashCode();
        int hashCode3 = (this.e.hashCode() + ((hashCode2 + ((hashCode + i2) * 29791)) * 961)) * 961;
        Decoder.Factory factory = this.f;
        if (factory != null) {
            i3 = factory.hashCode();
        }
        int hashCode4 = this.g.hashCode();
        int hashCode5 = this.h.hashCode();
        int hashCode6 = this.i.hashCode();
        int hashCode7 = this.j.hashCode();
        int hashCode8 = this.k.hashCode();
        int hashCode9 = this.l.hashCode();
        int hashCode10 = this.m.hashCode();
        int hashCode11 = this.n.hashCode();
        int hashCode12 = this.o.hashCode();
        int hashCode13 = this.p.hashCode();
        int hashCode14 = this.q.hashCode();
        int hashCode15 = this.r.hashCode();
        int hashCode16 = this.s.f53a.hashCode();
        int hashCode17 = this.t.hashCode();
        return this.u.hashCode() + ((hashCode17 + ((hashCode16 + ((hashCode15 + ((hashCode14 + ((hashCode13 + ((hashCode12 + ((hashCode11 + ((hashCode10 + ((hashCode9 + ((hashCode8 + ((hashCode7 + ((hashCode6 + ((hashCode5 + ((hashCode4 + ((hashCode3 + i3) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 961)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "ImageRequest(context=" + this.f137a + ", data=" + this.b + ", target=" + this.c + ", listener=null, memoryCacheKey=null, memoryCacheKeyExtras=" + this.d + ", diskCacheKey=null, fileSystem=" + this.e + ", fetcherFactory=null, decoderFactory=" + this.f + ", interceptorCoroutineContext=" + this.g + ", fetcherCoroutineContext=" + this.h + ", decoderCoroutineContext=" + this.i + ", memoryCachePolicy=" + this.j + ", diskCachePolicy=" + this.k + ", networkCachePolicy=" + this.l + ", placeholderMemoryCacheKey=null, placeholderFactory=" + this.m + ", errorFactory=" + this.n + ", fallbackFactory=" + this.o + ", sizeResolver=" + this.p + ", scale=" + this.q + ", precision=" + this.r + ", extras=" + this.s + ", defined=" + this.t + ", defaults=" + this.u + ')';
    }

    @SourceDebugExtension({"SMAP\nImageRequest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImageRequest.kt\ncoil3/request/ImageRequest$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,749:1\n1#2:750\n*E\n"})
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\b\u0016\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcoil3/request/ImageRequest$Builder;", "", "Landroid/content/Context;", "Lcoil3/PlatformContext;", "context", "<init>", "(Landroid/content/Context;)V", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public final Context f138a;
        public Defaults b;
        public Object c;
        public ImageViewTarget d;
        public final Map e;
        public Decoder.Factory f;
        public final Function1 g;
        public final Function1 h;
        public final Function1 i;
        public SizeResolver j;
        public Scale k;
        public Precision l;
        public Object m;

        public Builder(@NotNull Context context) {
            this.f138a = context;
            this.b = Defaults.o;
            this.c = null;
            this.d = null;
            this.e = MapsKt.b();
            this.f = null;
            this.g = UtilsKt.b();
            this.h = UtilsKt.b();
            this.i = UtilsKt.b();
            this.j = null;
            this.k = null;
            this.l = null;
            this.m = Extras.b;
        }

        public final ImageRequest a() {
            Map map;
            Precision precision;
            Extras extras;
            Object obj = this.c;
            if (obj == null) {
                obj = NullRequestData.f143a;
            }
            Object obj2 = obj;
            ImageViewTarget imageViewTarget = this.d;
            Boolean bool = Boolean.FALSE;
            Map map2 = this.e;
            if (Intrinsics.a(map2, bool)) {
                Intrinsics.d(map2, "null cannot be cast to non-null type kotlin.collections.MutableMap<*, *>");
                map = Collections_jvmCommonKt.b(TypeIntrinsics.b(map2));
            } else if (map2 instanceof Map) {
                map = map2;
            } else {
                throw new AssertionError();
            }
            Intrinsics.d(map, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
            Defaults defaults = this.b;
            FileSystem fileSystem = defaults.f139a;
            Decoder.Factory factory = this.f;
            CachePolicy cachePolicy = defaults.e;
            CachePolicy cachePolicy2 = defaults.f;
            CachePolicy cachePolicy3 = defaults.g;
            CoroutineContext coroutineContext = defaults.b;
            CoroutineContext coroutineContext2 = defaults.c;
            CoroutineContext coroutineContext3 = defaults.d;
            Function1 function1 = this.g;
            if (function1 == null) {
                function1 = defaults.h;
            }
            Function1 function12 = function1;
            Function1 function13 = this.h;
            if (function13 == null) {
                function13 = defaults.i;
            }
            Function1 function14 = function13;
            Function1 function15 = this.i;
            if (function15 == null) {
                function15 = defaults.j;
            }
            Function1 function16 = function15;
            SizeResolver sizeResolver = this.j;
            if (sizeResolver == null) {
                sizeResolver = defaults.k;
            }
            SizeResolver sizeResolver2 = sizeResolver;
            Scale scale = this.k;
            if (scale == null) {
                scale = defaults.l;
            }
            Scale scale2 = scale;
            Precision precision2 = this.l;
            if (precision2 == null) {
                precision = defaults.m;
            } else {
                precision = precision2;
            }
            Object obj3 = this.m;
            if (obj3 instanceof Extras.Builder) {
                extras = ((Extras.Builder) obj3).a();
            } else if (obj3 instanceof Extras) {
                extras = (Extras) obj3;
            } else {
                throw new AssertionError();
            }
            Extras extras2 = extras;
            SizeResolver sizeResolver3 = this.j;
            Scale scale3 = this.k;
            Precision precision3 = this.l;
            Defined defined = r23;
            Function1 function17 = function12;
            CachePolicy cachePolicy4 = cachePolicy3;
            Defined defined2 = new Defined(this.g, this.h, this.i, sizeResolver3, scale3, precision3);
            return new ImageRequest(this.f138a, obj2, imageViewTarget, map, fileSystem, factory, coroutineContext, coroutineContext2, coroutineContext3, cachePolicy, cachePolicy2, cachePolicy4, function17, function14, function16, sizeResolver2, scale2, precision, extras2, defined, this.b);
        }

        public Builder(ImageRequest imageRequest, Context context) {
            this.f138a = context;
            this.b = imageRequest.u;
            this.c = imageRequest.b;
            this.d = imageRequest.c;
            this.e = imageRequest.d;
            Defined defined = imageRequest.t;
            this.f = imageRequest.f;
            this.g = defined.f140a;
            this.h = defined.b;
            this.i = defined.c;
            this.j = defined.d;
            this.k = defined.e;
            this.l = defined.f;
            this.m = imageRequest.s;
        }
    }
}
