package coil3.gif;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.gif.AnimatedImageDecoder", f = "AnimatedImageDecoder.kt", i = {0, 0, 1}, l = {57, 98}, m = "decode", n = {"this", "isSampled", "isSampled"}, s = {"L$0", "L$1", "L$0"})
final class AnimatedImageDecoder$decode$1 extends ContinuationImpl {
    public Object c;
    public Ref.BooleanRef d;
    public /* synthetic */ Object e;
    public final /* synthetic */ AnimatedImageDecoder f;
    public int g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimatedImageDecoder$decode$1(AnimatedImageDecoder animatedImageDecoder, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f = animatedImageDecoder;
    }

    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.g |= Integer.MIN_VALUE;
        return this.f.a(this);
    }
}
