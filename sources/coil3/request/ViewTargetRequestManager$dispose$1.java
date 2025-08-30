package coil3.request;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.request.ViewTargetRequestManager$dispose$1", f = "ViewTargetRequestManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ViewTargetRequestManager$dispose$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ ViewTargetRequestManager c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewTargetRequestManager$dispose$1(ViewTargetRequestManager viewTargetRequestManager, Continuation continuation) {
        super(2, continuation);
        this.c = viewTargetRequestManager;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        return new ViewTargetRequestManager$dispose$1(this.c, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ViewTargetRequestManager$dispose$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f696a);
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ResultKt.b(obj);
        ViewTargetRequestManager viewTargetRequestManager = this.c;
        ViewTargetRequestDelegate viewTargetRequestDelegate = viewTargetRequestManager.e;
        if (viewTargetRequestDelegate != null) {
            viewTargetRequestDelegate.c();
        }
        viewTargetRequestManager.e = null;
        return Unit.f696a;
    }
}
