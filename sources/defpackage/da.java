package defpackage;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1;

/* renamed from: da  reason: default package */
public final /* synthetic */ class da implements Function1 {
    public final /* synthetic */ HandlerContext c;
    public final /* synthetic */ HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1 d;

    public /* synthetic */ da(HandlerContext handlerContext, HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1 handlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1) {
        this.c = handlerContext;
        this.d = handlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1;
    }

    public final Object invoke(Object obj) {
        Throwable th = (Throwable) obj;
        this.c.c.removeCallbacks(this.d);
        return Unit.f696a;
    }
}
