package kotlinx.coroutines.future;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class FutureKt$setupCancellation$1 implements Function2 {
    public final Object invoke(Object obj, Object obj2) {
        CancellationException cancellationException;
        Throwable th = (Throwable) obj2;
        if (th != null) {
            if (th instanceof CancellationException) {
                cancellationException = (CancellationException) th;
            } else {
                cancellationException = null;
            }
            if (cancellationException == null) {
                new CancellationException("CompletableFuture was completed exceptionally").initCause(th);
            }
        }
        throw null;
    }
}
