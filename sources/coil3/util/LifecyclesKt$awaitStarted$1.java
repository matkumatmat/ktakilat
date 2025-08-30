package coil3.util;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.util.LifecyclesKt", f = "lifecycles.kt", i = {0, 0}, l = {42}, m = "awaitStarted", n = {"$this$awaitStarted", "observer"}, s = {"L$0", "L$1"})
final class LifecyclesKt$awaitStarted$1 extends ContinuationImpl {
    public Lifecycle c;
    public Ref.ObjectRef d;
    public /* synthetic */ Object e;
    public int f;

    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.f |= Integer.MIN_VALUE;
        return LifecyclesKt.a((Lifecycle) null, this);
    }
}
