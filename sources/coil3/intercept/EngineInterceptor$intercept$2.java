package coil3.intercept;

import android.content.Context;
import coil3.EventListener;
import coil3.Image;
import coil3.RealImageLoader;
import coil3.intercept.EngineInterceptor;
import coil3.memory.MemoryCache;
import coil3.memory.MemoryCacheService;
import coil3.request.ImageRequest;
import coil3.request.Options;
import coil3.request.SuccessResult;
import coil3.util.AndroidSystemCallbacks;
import coil3.util.UtilsKt;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

@SourceDebugExtension({"SMAP\nEngineInterceptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EngineInterceptor.kt\ncoil3/intercept/EngineInterceptor$intercept$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,229:1\n1#2:230\n*E\n"})
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcoil3/request/SuccessResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.intercept.EngineInterceptor$intercept$2", f = "EngineInterceptor.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
final class EngineInterceptor$intercept$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SuccessResult>, Object> {
    public int c;
    public final /* synthetic */ EngineInterceptor d;
    public final /* synthetic */ ImageRequest e;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Options g;
    public final /* synthetic */ EventListener i;
    public final /* synthetic */ MemoryCache.Key j;
    public final /* synthetic */ RealInterceptorChain k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EngineInterceptor$intercept$2(EngineInterceptor engineInterceptor, ImageRequest imageRequest, Object obj, Options options, EventListener eventListener, MemoryCache.Key key, RealInterceptorChain realInterceptorChain, Continuation continuation) {
        super(2, continuation);
        this.d = engineInterceptor;
        this.e = imageRequest;
        this.f = obj;
        this.g = options;
        this.i = eventListener;
        this.j = key;
        this.k = realInterceptorChain;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        return new EngineInterceptor$intercept$2(this.d, this.e, this.f, this.g, this.i, this.j, this.k, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((EngineInterceptor$intercept$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f696a);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z;
        boolean z2;
        MemoryCache c2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i2 = this.c;
        if (i2 == 0) {
            ResultKt.b(obj);
            this.c = 1;
            obj = EngineInterceptor.c(this.d, this.e, this.f, this.g, this.i, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else if (i2 == 1) {
            ResultKt.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        EngineInterceptor.ExecuteResult executeResult = (EngineInterceptor.ExecuteResult) obj;
        EngineInterceptor engineInterceptor = this.d;
        AndroidSystemCallbacks androidSystemCallbacks = engineInterceptor.b;
        synchronized (androidSystemCallbacks) {
            try {
                RealImageLoader realImageLoader = (RealImageLoader) androidSystemCallbacks.c.get();
                if (realImageLoader == null) {
                    androidSystemCallbacks.a();
                } else if (androidSystemCallbacks.d == null) {
                    Context context = realImageLoader.f60a.f61a;
                    androidSystemCallbacks.d = context;
                    context.registerComponentCallbacks(androidSystemCallbacks);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        MemoryCacheService memoryCacheService = engineInterceptor.d;
        MemoryCache.Key key = this.j;
        if (key == null || !this.e.j.getWriteEnabled() || !executeResult.f108a.a() || (c2 = memoryCacheService.f114a.c()) == null) {
            z = false;
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("coil#is_sampled", Boolean.valueOf(executeResult.b));
            String str = executeResult.d;
            if (str != null) {
                linkedHashMap.put("coil#disk_cache_key", str);
            }
            c2.c(key, new MemoryCache.Value(executeResult.f108a, linkedHashMap));
            z = true;
        }
        Image image = executeResult.f108a;
        if (!z) {
            key = null;
        }
        MemoryCache.Key key2 = key;
        RealInterceptorChain realInterceptorChain = this.k;
        Function1 function1 = UtilsKt.f161a;
        if (!(realInterceptorChain instanceof RealInterceptorChain) || !realInterceptorChain.g) {
            z2 = false;
        } else {
            z2 = true;
        }
        return new SuccessResult(image, this.e, executeResult.c, key2, executeResult.d, executeResult.b, z2);
    }
}
