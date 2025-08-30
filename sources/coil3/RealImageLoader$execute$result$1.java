package coil3;

import coil3.intercept.RealInterceptorChain;
import coil3.request.ImageRequest;
import coil3.request.ImageResult;
import coil3.size.Size;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcoil3/request/ImageResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.RealImageLoader$execute$result$1", f = "RealImageLoader.kt", i = {}, l = {141}, m = "invokeSuspend", n = {}, s = {})
final class RealImageLoader$execute$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ImageResult>, Object> {
    public int c;
    public final /* synthetic */ ImageRequest d;
    public final /* synthetic */ RealImageLoader e;
    public final /* synthetic */ Size f;
    public final /* synthetic */ EventListener g;
    public final /* synthetic */ Image i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RealImageLoader$execute$result$1(ImageRequest imageRequest, RealImageLoader realImageLoader, Size size, EventListener eventListener, Image image, Continuation continuation) {
        super(2, continuation);
        this.d = imageRequest;
        this.e = realImageLoader;
        this.f = size;
        this.g = eventListener;
        this.i = image;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        return new RealImageLoader$execute$result$1(this.d, this.e, this.f, this.g, this.i, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((RealImageLoader$execute$result$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f696a);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i2 = this.c;
        if (i2 == 0) {
            ResultKt.b(obj);
            List list = this.e.d.f48a;
            if (this.i != null) {
                z = true;
            } else {
                z = false;
            }
            ImageRequest imageRequest = this.d;
            ImageRequest imageRequest2 = imageRequest;
            RealInterceptorChain realInterceptorChain = new RealInterceptorChain(imageRequest2, list, 0, imageRequest, this.f, this.g, z);
            this.c = 1;
            obj = realInterceptorChain.b(this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else if (i2 == 1) {
            ResultKt.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
