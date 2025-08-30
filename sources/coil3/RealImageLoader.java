package coil3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import coil3.ComponentRegistry;
import coil3.EventListener;
import coil3.Extras;
import coil3.decode.BitmapFactoryDecoder;
import coil3.decode.ExifOrientationStrategy;
import coil3.decode.StaticImageDecoder;
import coil3.intercept.EngineInterceptor;
import coil3.memory.MemoryCache;
import coil3.request.AndroidRequestService;
import coil3.request.Disposable;
import coil3.request.ErrorResult;
import coil3.request.ImageRequest;
import coil3.request.ImageRequests_androidKt;
import coil3.request.OneShotDisposable;
import coil3.request.ViewTargetDisposable;
import coil3.request.ViewTargetRequestManager;
import coil3.request.ViewTargetRequestManagerKt;
import coil3.target.ImageViewTarget;
import coil3.target.ViewTarget;
import coil3.transition.NoneTransition;
import coil3.transition.Transition;
import coil3.transition.TransitionTarget;
import coil3.util.AndroidSystemCallbacks;
import coil3.util.Utils_androidKt;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import okio.Path;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0004R\u000b\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¨\u0006\u0005"}, d2 = {"Lcoil3/RealImageLoader;", "Lcoil3/ImageLoader;", "Lkotlinx/atomicfu/AtomicBoolean;", "shutdown", "Options", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRealImageLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealImageLoader.kt\ncoil3/RealImageLoader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 logging.kt\ncoil3/util/LoggingKt\n+ 4 RealImageLoader.android.kt\ncoil3/RealImageLoader_androidKt\n*L\n1#1,307:1\n1#2:308\n68#3,4:309\n62#3,4:328\n68#3,4:347\n57#4,15:313\n57#4,15:332\n*S KotlinDebug\n*F\n+ 1 RealImageLoader.kt\ncoil3/RealImageLoader\n*L\n181#1:309,4\n197#1:328,4\n211#1:347,4\n184#1:313,15\n200#1:332,15\n*E\n"})
public final class RealImageLoader implements ImageLoader {
    public static final /* synthetic */ int f = 0;

    /* renamed from: a  reason: collision with root package name */
    public final Options f60a;
    public final ContextScope b;
    public final AndroidRequestService c;
    public final ComponentRegistry d;
    public volatile /* synthetic */ int e;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/RealImageLoader$Options;", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Options {

        /* renamed from: a  reason: collision with root package name */
        public final Context f61a;
        public final ImageRequest.Defaults b;
        public final Lazy c;
        public final Lazy d;
        public final ComponentRegistry e;

        public Options(Context context, ImageRequest.Defaults defaults, Lazy lazy, Lazy lazy2, ComponentRegistry componentRegistry) {
            this.f61a = context;
            this.b = defaults;
            this.c = lazy;
            this.d = lazy2;
            this.e = componentRegistry;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Options)) {
                return false;
            }
            Options options = (Options) obj;
            if (!Intrinsics.a(this.f61a, options.f61a) || !this.b.equals(options.b) || !this.c.equals(options.c) || !this.d.equals(options.d)) {
                return false;
            }
            x2 x2Var = EventListener.Factory.f52a;
            if (x2Var.equals(x2Var) && this.e.equals(options.e) && Intrinsics.a((Object) null, (Object) null)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = this.b.hashCode();
            int hashCode2 = this.c.hashCode();
            int hashCode3 = this.d.hashCode();
            int hashCode4 = EventListener.Factory.f52a.hashCode();
            return (this.e.hashCode() + ((hashCode4 + ((hashCode3 + ((hashCode2 + ((hashCode + (this.f61a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        }

        public final String toString() {
            return "Options(application=" + this.f61a + ", defaults=" + this.b + ", memoryCacheLazy=" + this.c + ", diskCacheLazy=" + this.d + ", eventListenerFactory=" + EventListener.Factory.f52a + ", componentRegistry=" + this.e + ", logger=null)";
        }
    }

    static {
        AtomicIntegerFieldUpdater.newUpdater(RealImageLoader.class, "e");
    }

    /* JADX WARNING: type inference failed for: r3v9, types: [coil3.map.Mapper, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r3v10, types: [coil3.map.Mapper, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r3v12, types: [java.lang.Object, coil3.fetch.Fetcher$Factory] */
    /* JADX WARNING: type inference failed for: r3v13, types: [java.lang.Object, coil3.fetch.Fetcher$Factory] */
    /* JADX WARNING: type inference failed for: r3v14, types: [java.lang.Object, coil3.fetch.Fetcher$Factory] */
    /* JADX WARNING: type inference failed for: r3v15, types: [java.lang.Object, coil3.fetch.Fetcher$Factory] */
    /* JADX WARNING: type inference failed for: r3v16, types: [java.lang.Object, coil3.fetch.Fetcher$Factory] */
    /* JADX WARNING: type inference failed for: r11v6, types: [coil3.map.Mapper, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r11v7, types: [java.lang.Object, coil3.fetch.Fetcher$Factory] */
    /* JADX WARNING: type inference failed for: r11v8, types: [java.lang.Object, coil3.fetch.Fetcher$Factory] */
    /* JADX WARNING: type inference failed for: r11v9, types: [coil3.map.Mapper, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r11v10, types: [coil3.map.Mapper, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r11v13, types: [java.lang.Object, coil3.fetch.Fetcher$Factory] */
    /* JADX WARNING: type inference failed for: r11v14, types: [java.lang.Object, coil3.fetch.Fetcher$Factory] */
    public RealImageLoader(Options options) {
        this.f60a = options;
        CompletableJob b2 = SupervisorKt.b();
        DefaultScheduler defaultScheduler = Dispatchers.f767a;
        this.b = CoroutineScopeKt.a(CoroutineContext.Element.DefaultImpls.c(MainDispatcherLoader.f801a.t(), (JobSupport) b2).plus(new AbstractCoroutineContextElement(CoroutineExceptionHandler.Key.c)));
        AndroidSystemCallbacks androidSystemCallbacks = new AndroidSystemCallbacks(this);
        AndroidRequestService androidRequestService = new AndroidRequestService(this, androidSystemCallbacks);
        this.c = androidRequestService;
        ComponentRegistry.Builder builder = new ComponentRegistry.Builder(options.e);
        Object obj = options.b.n.f53a.get(ImageLoadersKt.f58a);
        if (((Boolean) (obj == null ? Boolean.TRUE : obj)).booleanValue()) {
            builder.d.add(new q0(20));
            builder.e.add(new q0(21));
        }
        builder.b(new Object(), Reflection.a(Uri.class));
        builder.b(new Object(), Reflection.a(Integer.class));
        Class<Uri> cls = Uri.class;
        builder.c.add(new Pair(new Object(), Reflection.a(cls)));
        builder.a(new Object(), Reflection.a(cls));
        builder.a(new Object(), Reflection.a(cls));
        builder.a(new Object(), Reflection.a(cls));
        builder.a(new Object(), Reflection.a(Drawable.class));
        builder.a(new Object(), Reflection.a(Bitmap.class));
        Extras.Key key = ImageLoaders_androidKt.f59a;
        int i = options.b.n.f53a.get(ImageLoaders_androidKt.f59a);
        Semaphore a2 = SemaphoreKt.a(((Number) (i == null ? 4 : i)).intValue());
        int i2 = Build.VERSION.SDK_INT;
        Object obj2 = ExifOrientationStrategy.f74a;
        if (i2 >= 29) {
            Object obj3 = options.b.n.f53a.get(ImageLoaders_androidKt.b);
            ExifOrientationStrategy exifOrientationStrategy = (ExifOrientationStrategy) (obj3 == null ? obj2 : obj3);
            if (exifOrientationStrategy.equals(obj2) || exifOrientationStrategy.equals(ExifOrientationStrategy.b)) {
                builder.e.add(new v3(new StaticImageDecoder.Factory(a2), 1));
            }
        }
        Object obj4 = options.b.n.f53a.get(ImageLoaders_androidKt.b);
        builder.e.add(new v3(new BitmapFactoryDecoder.Factory(a2, (ExifOrientationStrategy) (obj4 != null ? obj4 : obj2)), 1));
        builder.b(new Object(), Reflection.a(File.class));
        builder.a(new Object(), Reflection.a(cls));
        builder.a(new Object(), Reflection.a(ByteBuffer.class));
        builder.b(new Object(), Reflection.a(String.class));
        builder.b(new Object(), Reflection.a(Path.class));
        builder.c.add(new Pair(new Object(), Reflection.a(cls)));
        builder.c.add(new Pair(new Object(), Reflection.a(cls)));
        builder.a(new Object(), Reflection.a(cls));
        builder.a(new Object(), Reflection.a(byte[].class));
        builder.f49a.add(new EngineInterceptor(this, androidSystemCallbacks, androidRequestService));
        this.d = builder.c();
        this.e = 0;
    }

    /* JADX WARNING: type inference failed for: r1v5, types: [coil3.request.ViewTargetDisposable, java.lang.Object, coil3.request.Disposable] */
    public final Disposable a(ImageRequest imageRequest) {
        Deferred a2 = BuildersKt.a(this.b, (MainCoroutineDispatcher) null, new RealImageLoader$enqueue$job$1(this, imageRequest, (Continuation) null), 3);
        ImageViewTarget imageViewTarget = imageRequest.c;
        if (!(imageViewTarget instanceof ViewTarget)) {
            return new OneShotDisposable(a2);
        }
        ViewTargetRequestManager a3 = ViewTargetRequestManagerKt.a(imageViewTarget.a());
        synchronized (a3) {
            ViewTargetDisposable viewTargetDisposable = a3.c;
            if (viewTargetDisposable != null) {
                Bitmap.Config[] configArr = Utils_androidKt.f162a;
                if (Intrinsics.a(Looper.myLooper(), Looper.getMainLooper()) && a3.f) {
                    a3.f = false;
                    viewTargetDisposable.f147a = a2;
                    return viewTargetDisposable;
                }
            }
            Job job = a3.d;
            if (job != null) {
                ((JobSupport) job).c((CancellationException) null);
            }
            a3.d = null;
            ? obj = new Object();
            obj.f147a = a2;
            a3.c = obj;
            return obj;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:132:0x021a, code lost:
        if (r7 != null) goto L_0x021c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01aa A[Catch:{ all -> 0x003f }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01d8 A[Catch:{ all -> 0x003f }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01d9 A[Catch:{ all -> 0x003f }] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0203 A[Catch:{ all -> 0x003f }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x020a A[Catch:{ all -> 0x003f }] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x023b A[Catch:{ all -> 0x003f }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(coil3.request.ImageRequest r22, int r23, kotlin.coroutines.jvm.internal.ContinuationImpl r24) {
        /*
            r21 = this;
            r1 = r21
            r0 = r22
            r2 = r24
            boolean r3 = r2 instanceof coil3.RealImageLoader$execute$3
            if (r3 == 0) goto L_0x001a
            r3 = r2
            coil3.RealImageLoader$execute$3 r3 = (coil3.RealImageLoader$execute$3) r3
            int r4 = r3.k
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x001a
            int r4 = r4 - r5
            r3.k = r4
        L_0x0018:
            r8 = r3
            goto L_0x0020
        L_0x001a:
            coil3.RealImageLoader$execute$3 r3 = new coil3.RealImageLoader$execute$3
            r3.<init>(r1, r2)
            goto L_0x0018
        L_0x0020:
            java.lang.Object r2 = r8.i
            kotlin.coroutines.intrinsics.CoroutineSingletons r9 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r3 = r8.k
            r10 = 3
            r11 = 2
            r12 = 1
            r13 = 0
            if (r3 == 0) goto L_0x0068
            if (r3 == r12) goto L_0x005b
            if (r3 == r11) goto L_0x004a
            if (r3 != r10) goto L_0x0042
            coil3.EventListener r3 = r8.f
            coil3.request.ImageRequest r4 = r8.e
            coil3.request.RequestDelegate r5 = r8.d
            coil3.RealImageLoader r6 = r8.c
            kotlin.ResultKt.b(r2)     // Catch:{ all -> 0x003f }
            goto L_0x0204
        L_0x003f:
            r0 = move-exception
            goto L_0x0257
        L_0x0042:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x004a:
            coil3.Image r0 = r8.g
            coil3.EventListener r3 = r8.f
            coil3.request.ImageRequest r4 = r8.e
            coil3.request.RequestDelegate r5 = r8.d
            coil3.RealImageLoader r6 = r8.c
            kotlin.ResultKt.b(r2)     // Catch:{ all -> 0x003f }
            r19 = r0
            goto L_0x01db
        L_0x005b:
            coil3.EventListener r3 = r8.f
            coil3.request.ImageRequest r4 = r8.e
            coil3.request.RequestDelegate r5 = r8.d
            coil3.RealImageLoader r6 = r8.c
            kotlin.ResultKt.b(r2)     // Catch:{ all -> 0x003f }
            goto L_0x01a3
        L_0x0068:
            kotlin.ResultKt.b(r2)
            kotlin.coroutines.CoroutineContext r2 = r8.getContext()
            kotlinx.coroutines.Job r7 = kotlinx.coroutines.JobKt.b(r2)
            if (r23 != 0) goto L_0x0077
            r2 = 1
            goto L_0x0078
        L_0x0077:
            r2 = 0
        L_0x0078:
            coil3.request.AndroidRequestService r14 = r1.c
            r14.getClass()
            coil3.target.ImageViewTarget r5 = r0.c
            boolean r3 = r5 instanceof coil3.target.ViewTarget
            if (r3 == 0) goto L_0x009e
            coil3.Extras$Key r2 = coil3.request.ImageRequests_androidKt.f
            java.lang.Object r2 = coil3.ExtrasKt.a(r0, r2)
            androidx.lifecycle.Lifecycle r2 = (androidx.lifecycle.Lifecycle) r2
            if (r2 != 0) goto L_0x0091
            androidx.lifecycle.Lifecycle r2 = coil3.request.AndroidRequestService.a(r22)
        L_0x0091:
            r6 = r2
            coil3.request.ViewTargetRequestDelegate r15 = new coil3.request.ViewTargetRequestDelegate
            coil3.RealImageLoader r3 = r14.f135a
            r2 = r15
            r4 = r22
            r2.<init>(r3, r4, r5, r6, r7)
            r5 = r15
            goto L_0x00bf
        L_0x009e:
            coil3.Extras$Key r3 = coil3.request.ImageRequests_androidKt.f
            java.lang.Object r3 = coil3.ExtrasKt.a(r0, r3)
            androidx.lifecycle.Lifecycle r3 = (androidx.lifecycle.Lifecycle) r3
            if (r3 != 0) goto L_0x00b0
            if (r2 == 0) goto L_0x00af
            androidx.lifecycle.Lifecycle r3 = coil3.request.AndroidRequestService.a(r22)
            goto L_0x00b0
        L_0x00af:
            r3 = r13
        L_0x00b0:
            if (r3 == 0) goto L_0x00b9
            coil3.request.LifecycleRequestDelegate r2 = new coil3.request.LifecycleRequestDelegate
            r2.<init>(r3, r7)
        L_0x00b7:
            r5 = r2
            goto L_0x00bf
        L_0x00b9:
            coil3.request.BaseRequestDelegate r2 = new coil3.request.BaseRequestDelegate
            r2.<init>(r7)
            goto L_0x00b7
        L_0x00bf:
            r5.b()
            r14.getClass()
            coil3.request.ImageRequest$Builder r2 = new coil3.request.ImageRequest$Builder
            android.content.Context r3 = r0.f137a
            r2.<init>(r0, r3)
            coil3.RealImageLoader r3 = r14.f135a
            coil3.RealImageLoader$Options r3 = r3.f60a
            coil3.request.ImageRequest$Defaults r3 = r3.b
            r2.b = r3
            coil3.request.ImageRequest$Defined r3 = r0.t
            coil3.target.ImageViewTarget r4 = r0.c
            coil3.size.SizeResolver r6 = r3.d
            if (r6 != 0) goto L_0x0103
            boolean r7 = r4 instanceof coil3.target.ViewTarget
            if (r7 == 0) goto L_0x00fe
            android.widget.ImageView r7 = r4.a()
            boolean r14 = r7 instanceof android.widget.ImageView
            if (r14 == 0) goto L_0x00f7
            android.widget.ImageView$ScaleType r14 = r7.getScaleType()
            android.widget.ImageView$ScaleType r15 = android.widget.ImageView.ScaleType.CENTER
            if (r14 == r15) goto L_0x00f4
            android.widget.ImageView$ScaleType r15 = android.widget.ImageView.ScaleType.MATRIX
            if (r14 != r15) goto L_0x00f7
        L_0x00f4:
            coil3.size.RealSizeResolver r7 = coil3.size.SizeResolver.f151a
            goto L_0x0100
        L_0x00f7:
            coil3.size.RealViewSizeResolver r14 = new coil3.size.RealViewSizeResolver
            r14.<init>(r7, r12)
            r7 = r14
            goto L_0x0100
        L_0x00fe:
            coil3.size.RealSizeResolver r7 = coil3.size.SizeResolver.f151a
        L_0x0100:
            r2.j = r7
            goto L_0x0104
        L_0x0103:
            r7 = r6
        L_0x0104:
            coil3.size.Scale r14 = r3.e
            if (r14 != 0) goto L_0x0144
            boolean r14 = r4 instanceof coil3.target.ViewTarget
            if (r14 == 0) goto L_0x010e
            r14 = r4
            goto L_0x010f
        L_0x010e:
            r14 = r13
        L_0x010f:
            if (r14 == 0) goto L_0x0116
            android.widget.ImageView r14 = r14.a()
            goto L_0x0117
        L_0x0116:
            r14 = r13
        L_0x0117:
            boolean r15 = r14 instanceof android.widget.ImageView
            if (r15 == 0) goto L_0x011c
            goto L_0x011d
        L_0x011c:
            r14 = r13
        L_0x011d:
            if (r14 == 0) goto L_0x0140
            android.graphics.Bitmap$Config[] r0 = coil3.util.Utils_androidKt.f162a
            android.widget.ImageView$ScaleType r0 = r14.getScaleType()
            if (r0 != 0) goto L_0x0129
            r0 = -1
            goto L_0x0131
        L_0x0129:
            int[] r14 = coil3.util.Utils_androidKt.WhenMappings.f163a
            int r0 = r0.ordinal()
            r0 = r14[r0]
        L_0x0131:
            if (r0 == r12) goto L_0x013d
            if (r0 == r11) goto L_0x013d
            if (r0 == r10) goto L_0x013d
            r14 = 4
            if (r0 == r14) goto L_0x013d
            coil3.size.Scale r0 = coil3.size.Scale.FILL
            goto L_0x0142
        L_0x013d:
            coil3.size.Scale r0 = coil3.size.Scale.FIT
            goto L_0x0142
        L_0x0140:
            coil3.size.Scale r0 = r0.q
        L_0x0142:
            r2.k = r0
        L_0x0144:
            coil3.size.Precision r0 = r3.f
            if (r0 != 0) goto L_0x0178
            if (r6 != 0) goto L_0x0155
            coil3.size.RealSizeResolver r0 = coil3.size.SizeResolver.f151a
            boolean r0 = kotlin.jvm.internal.Intrinsics.a(r7, r0)
            if (r0 == 0) goto L_0x0155
            coil3.size.Precision r0 = coil3.size.Precision.INEXACT
            goto L_0x0176
        L_0x0155:
            boolean r0 = r4 instanceof coil3.target.ViewTarget
            if (r0 == 0) goto L_0x0174
            boolean r0 = r7 instanceof coil3.size.ViewSizeResolver
            if (r0 == 0) goto L_0x0174
            android.widget.ImageView r0 = r4.a()
            boolean r0 = r0 instanceof android.widget.ImageView
            if (r0 == 0) goto L_0x0174
            android.widget.ImageView r0 = r4.a()
            coil3.size.ViewSizeResolver r7 = (coil3.size.ViewSizeResolver) r7
            android.view.View r3 = r7.getView()
            if (r0 != r3) goto L_0x0174
            coil3.size.Precision r0 = coil3.size.Precision.INEXACT
            goto L_0x0176
        L_0x0174:
            coil3.size.Precision r0 = coil3.size.Precision.EXACT
        L_0x0176:
            r2.l = r0
        L_0x0178:
            coil3.request.ImageRequest r4 = r2.a()
            coil3.EventListener$Companion$NONE$1 r3 = coil3.EventListener.f51a
            java.lang.Object r0 = r4.b     // Catch:{ all -> 0x019e }
            coil3.request.NullRequestData r2 = coil3.request.NullRequestData.f143a     // Catch:{ all -> 0x019e }
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x019e }
            if (r0 != 0) goto L_0x0251
            r5.start()     // Catch:{ all -> 0x019e }
            if (r23 != 0) goto L_0x01a2
            r8.c = r1     // Catch:{ all -> 0x019e }
            r8.d = r5     // Catch:{ all -> 0x019e }
            r8.e = r4     // Catch:{ all -> 0x019e }
            r8.f = r3     // Catch:{ all -> 0x019e }
            r8.k = r12     // Catch:{ all -> 0x019e }
            java.lang.Object r0 = r5.a(r8)     // Catch:{ all -> 0x019e }
            if (r0 != r9) goto L_0x01a2
            return r9
        L_0x019e:
            r0 = move-exception
            r6 = r1
            goto L_0x0257
        L_0x01a2:
            r6 = r1
        L_0x01a3:
            r4.getClass()     // Catch:{ all -> 0x003f }
            coil3.target.ImageViewTarget r0 = r4.c     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x01c1
            kotlin.jvm.functions.Function1 r2 = r4.m     // Catch:{ all -> 0x003f }
            java.lang.Object r2 = r2.invoke(r4)     // Catch:{ all -> 0x003f }
            coil3.Image r2 = (coil3.Image) r2     // Catch:{ all -> 0x003f }
            if (r2 != 0) goto L_0x01be
            coil3.request.ImageRequest$Defaults r2 = r4.u     // Catch:{ all -> 0x003f }
            kotlin.jvm.functions.Function1 r2 = r2.h     // Catch:{ all -> 0x003f }
            java.lang.Object r2 = r2.invoke(r4)     // Catch:{ all -> 0x003f }
            coil3.Image r2 = (coil3.Image) r2     // Catch:{ all -> 0x003f }
        L_0x01be:
            r0.g(r2)     // Catch:{ all -> 0x003f }
        L_0x01c1:
            r3.getClass()     // Catch:{ all -> 0x003f }
            coil3.size.SizeResolver r0 = r4.p     // Catch:{ all -> 0x003f }
            r8.c = r6     // Catch:{ all -> 0x003f }
            r8.d = r5     // Catch:{ all -> 0x003f }
            r8.e = r4     // Catch:{ all -> 0x003f }
            r8.f = r3     // Catch:{ all -> 0x003f }
            r8.g = r13     // Catch:{ all -> 0x003f }
            r8.k = r11     // Catch:{ all -> 0x003f }
            java.lang.Object r2 = r0.a(r8)     // Catch:{ all -> 0x003f }
            if (r2 != r9) goto L_0x01d9
            return r9
        L_0x01d9:
            r19 = r13
        L_0x01db:
            r17 = r2
            coil3.size.Size r17 = (coil3.size.Size) r17     // Catch:{ all -> 0x003f }
            r3.getClass()     // Catch:{ all -> 0x003f }
            kotlin.coroutines.CoroutineContext r0 = r4.g     // Catch:{ all -> 0x003f }
            coil3.RealImageLoader$execute$result$1 r2 = new coil3.RealImageLoader$execute$result$1     // Catch:{ all -> 0x003f }
            r20 = 0
            r14 = r2
            r15 = r4
            r16 = r6
            r18 = r3
            r14.<init>(r15, r16, r17, r18, r19, r20)     // Catch:{ all -> 0x003f }
            r8.c = r6     // Catch:{ all -> 0x003f }
            r8.d = r5     // Catch:{ all -> 0x003f }
            r8.e = r4     // Catch:{ all -> 0x003f }
            r8.f = r3     // Catch:{ all -> 0x003f }
            r8.g = r13     // Catch:{ all -> 0x003f }
            r8.k = r10     // Catch:{ all -> 0x003f }
            java.lang.Object r2 = kotlinx.coroutines.BuildersKt.d(r2, r0, r8)     // Catch:{ all -> 0x003f }
            if (r2 != r9) goto L_0x0204
            return r9
        L_0x0204:
            coil3.request.ImageResult r2 = (coil3.request.ImageResult) r2     // Catch:{ all -> 0x003f }
            boolean r0 = r2 instanceof coil3.request.SuccessResult     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x023b
            r0 = r2
            coil3.request.SuccessResult r0 = (coil3.request.SuccessResult) r0     // Catch:{ all -> 0x003f }
            coil3.target.ImageViewTarget r7 = r4.c     // Catch:{ all -> 0x003f }
            r6.getClass()     // Catch:{ all -> 0x003f }
            coil3.request.ImageRequest r8 = r0.b     // Catch:{ all -> 0x003f }
            boolean r9 = r7 instanceof coil3.transition.TransitionTarget     // Catch:{ all -> 0x003f }
            coil3.Image r10 = r0.f146a     // Catch:{ all -> 0x003f }
            if (r9 != 0) goto L_0x0220
            if (r7 == 0) goto L_0x0237
        L_0x021c:
            r7.g(r10)     // Catch:{ all -> 0x003f }
            goto L_0x0237
        L_0x0220:
            coil3.Extras$Key r9 = coil3.request.ImageRequests_androidKt.b     // Catch:{ all -> 0x003f }
            java.lang.Object r8 = coil3.ExtrasKt.a(r8, r9)     // Catch:{ all -> 0x003f }
            coil3.transition.Transition$Factory r8 = (coil3.transition.Transition.Factory) r8     // Catch:{ all -> 0x003f }
            coil3.transition.Transition r0 = r8.a(r7, r0)     // Catch:{ all -> 0x003f }
            boolean r8 = r0 instanceof coil3.transition.NoneTransition     // Catch:{ all -> 0x003f }
            if (r8 == 0) goto L_0x0231
            goto L_0x021c
        L_0x0231:
            r3.getClass()     // Catch:{ all -> 0x003f }
            r0.a()     // Catch:{ all -> 0x003f }
        L_0x0237:
            r3.getClass()     // Catch:{ all -> 0x003f }
            goto L_0x0247
        L_0x023b:
            boolean r0 = r2 instanceof coil3.request.ErrorResult     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x024b
            r0 = r2
            coil3.request.ErrorResult r0 = (coil3.request.ErrorResult) r0     // Catch:{ all -> 0x003f }
            coil3.target.ImageViewTarget r7 = r4.c     // Catch:{ all -> 0x003f }
            r6.d(r0, r7, r3)     // Catch:{ all -> 0x003f }
        L_0x0247:
            r5.complete()
            return r2
        L_0x024b:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException     // Catch:{ all -> 0x003f }
            r0.<init>()     // Catch:{ all -> 0x003f }
            throw r0     // Catch:{ all -> 0x003f }
        L_0x0251:
            coil3.request.NullRequestDataException r0 = new coil3.request.NullRequestDataException     // Catch:{ all -> 0x019e }
            r0.<init>()     // Catch:{ all -> 0x019e }
            throw r0     // Catch:{ all -> 0x019e }
        L_0x0257:
            boolean r2 = r0 instanceof java.util.concurrent.CancellationException     // Catch:{ all -> 0x0268 }
            if (r2 != 0) goto L_0x026a
            coil3.request.ErrorResult r0 = coil3.util.UtilsKt.a(r4, r0)     // Catch:{ all -> 0x0268 }
            coil3.target.ImageViewTarget r2 = r4.c     // Catch:{ all -> 0x0268 }
            r6.d(r0, r2, r3)     // Catch:{ all -> 0x0268 }
            r5.complete()
            return r0
        L_0x0268:
            r0 = move-exception
            goto L_0x0274
        L_0x026a:
            r6.getClass()     // Catch:{ all -> 0x0268 }
            r3.getClass()     // Catch:{ all -> 0x0268 }
            r4.getClass()     // Catch:{ all -> 0x0268 }
            throw r0     // Catch:{ all -> 0x0268 }
        L_0x0274:
            r5.complete()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.RealImageLoader.b(coil3.request.ImageRequest, int, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final MemoryCache c() {
        return (MemoryCache) this.f60a.c.getValue();
    }

    public final void d(ErrorResult errorResult, ImageViewTarget imageViewTarget, EventListener eventListener) {
        ImageRequest imageRequest = errorResult.b;
        boolean z = imageViewTarget instanceof TransitionTarget;
        Image image = errorResult.f136a;
        if (z) {
            Transition a2 = ((Transition.Factory) ExtrasKt.a(imageRequest, ImageRequests_androidKt.b)).a(imageViewTarget, errorResult);
            if (a2 instanceof NoneTransition) {
                imageViewTarget.g(image);
            } else {
                eventListener.getClass();
                a2.a();
            }
        } else if (imageViewTarget != null) {
            imageViewTarget.g(image);
        }
        eventListener.getClass();
        imageRequest.getClass();
    }
}
