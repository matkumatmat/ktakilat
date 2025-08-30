package coil3.decode;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.decode.StaticImageDecoder", f = "StaticImageDecoder.kt", i = {0, 0}, l = {168}, m = "decode", n = {"this", "$this$withPermit$iv"}, s = {"L$0", "L$1"})
final class StaticImageDecoder$decode$1 extends ContinuationImpl {
    public StaticImageDecoder c;
    public Object d;
    public /* synthetic */ Object e;
    public final /* synthetic */ StaticImageDecoder f;
    public int g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StaticImageDecoder$decode$1(StaticImageDecoder staticImageDecoder, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f = staticImageDecoder;
    }

    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.g |= Integer.MIN_VALUE;
        return this.f.a(this);
    }
}
