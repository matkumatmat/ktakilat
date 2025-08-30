package coil3.intercept;

import coil3.ComponentRegistry;
import coil3.EventListener;
import coil3.fetch.SourceFetchResult;
import coil3.intercept.EngineInterceptor;
import coil3.request.ImageRequest;
import coil3.request.Options;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcoil3/intercept/EngineInterceptor$ExecuteResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.intercept.EngineInterceptor$execute$executeResult$1", f = "EngineInterceptor.kt", i = {}, l = {120}, m = "invokeSuspend", n = {}, s = {})
final class EngineInterceptor$execute$executeResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super EngineInterceptor.ExecuteResult>, Object> {
    public int c;
    public final /* synthetic */ EngineInterceptor d;
    public final /* synthetic */ Ref.ObjectRef e;
    public final /* synthetic */ Ref.ObjectRef f;
    public final /* synthetic */ ImageRequest g;
    public final /* synthetic */ Object i;
    public final /* synthetic */ Ref.ObjectRef j;
    public final /* synthetic */ EventListener k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EngineInterceptor$execute$executeResult$1(EngineInterceptor engineInterceptor, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, ImageRequest imageRequest, Object obj, Ref.ObjectRef objectRef3, EventListener eventListener, Continuation continuation) {
        super(2, continuation);
        this.d = engineInterceptor;
        this.e = objectRef;
        this.f = objectRef2;
        this.g = imageRequest;
        this.i = obj;
        this.j = objectRef3;
        this.k = eventListener;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        return new EngineInterceptor$execute$executeResult$1(this.d, this.e, this.f, this.g, this.i, this.j, this.k, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((EngineInterceptor$execute$executeResult$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f696a);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i2 = this.c;
        if (i2 == 0) {
            ResultKt.b(obj);
            this.c = 1;
            ImageRequest imageRequest = this.g;
            Object obj2 = this.i;
            EventListener eventListener = this.k;
            obj = EngineInterceptor.b(this.d, (SourceFetchResult) this.e.element, (ComponentRegistry) this.f.element, imageRequest, obj2, (Options) this.j.element, eventListener, this);
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
