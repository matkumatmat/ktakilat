package kotlinx.coroutines.stream;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.stream.StreamFlow", f = "Stream.kt", i = {0, 0}, l = {22}, m = "collect", n = {"this", "collector"}, s = {"L$0", "L$1"})
final class StreamFlow$collect$1 extends ContinuationImpl {
    public FlowCollector c;
    public Iterator d;
    public /* synthetic */ Object e;
    public final /* synthetic */ StreamFlow f;
    public int g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StreamFlow$collect$1(StreamFlow streamFlow, Continuation continuation) {
        super(continuation);
        this.f = streamFlow;
    }

    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.g |= Integer.MIN_VALUE;
        return this.f.collect((FlowCollector) null, this);
    }
}
