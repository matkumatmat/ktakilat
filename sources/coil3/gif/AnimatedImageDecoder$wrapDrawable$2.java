package coil3.gif;

import android.graphics.drawable.Drawable;
import coil3.gif.internal.UtilsKt$animatable2CallbackOf$1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.gif.AnimatedImageDecoder$wrapDrawable$2", f = "AnimatedImageDecoder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AnimatedImageDecoder$wrapDrawable$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Drawable c;
    public final /* synthetic */ Function0 d;
    public final /* synthetic */ Function0 e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimatedImageDecoder$wrapDrawable$2(Drawable drawable, Function0 function0, Function0 function02, Continuation continuation) {
        super(2, continuation);
        this.c = drawable;
        this.d = function0;
        this.e = function02;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        return new AnimatedImageDecoder$wrapDrawable$2(this.c, this.d, this.e, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((AnimatedImageDecoder$wrapDrawable$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f696a);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ResultKt.b(obj);
        h.e(this.c).registerAnimationCallback(new UtilsKt$animatable2CallbackOf$1(this.d, this.e));
        return Unit.f696a;
    }
}
