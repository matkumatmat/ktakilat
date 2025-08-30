package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class ProduceKt$awaitClose$4$1 implements Function1<Throwable, Unit> {
    public final /* synthetic */ CancellableContinuationImpl c;

    public ProduceKt$awaitClose$4$1(CancellableContinuationImpl cancellableContinuationImpl) {
        this.c = cancellableContinuationImpl;
    }

    public final Object invoke(Object obj) {
        Throwable th = (Throwable) obj;
        Result.Companion companion = Result.Companion;
        Unit unit = Unit.f696a;
        this.c.resumeWith(Result.m16constructorimpl(unit));
        return unit;
    }
}
