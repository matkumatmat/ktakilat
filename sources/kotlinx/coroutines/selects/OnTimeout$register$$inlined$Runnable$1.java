package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRunnable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Runnable.kt\nkotlinx/coroutines/RunnableKt$Runnable$1\n+ 2 OnTimeout.kt\nkotlinx/coroutines/selects/OnTimeout\n*L\n1#1,13:1\n53#2,2:14\n*E\n"})
public final class OnTimeout$register$$inlined$Runnable$1 implements Runnable {
    public final /* synthetic */ SelectInstance c;
    public final /* synthetic */ OnTimeout d;

    public OnTimeout$register$$inlined$Runnable$1(SelectInstance selectInstance, OnTimeout onTimeout) {
        this.c = selectInstance;
        this.d = onTimeout;
    }

    public final void run() {
        this.c.c(this.d, Unit.f696a);
    }
}
