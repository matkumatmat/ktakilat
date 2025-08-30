package coil3.decode;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.decode.BitmapFactoryDecoder", f = "BitmapFactoryDecoder.kt", i = {0, 0, 1}, l = {212, 40}, m = "decode", n = {"this", "$this$withPermit$iv", "$this$withPermit$iv"}, s = {"L$0", "L$1", "L$0"})
final class BitmapFactoryDecoder$decode$1 extends ContinuationImpl {
    public Object c;
    public Object d;
    public /* synthetic */ Object e;
    public final /* synthetic */ BitmapFactoryDecoder f;
    public int g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BitmapFactoryDecoder$decode$1(BitmapFactoryDecoder bitmapFactoryDecoder, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f = bitmapFactoryDecoder;
    }

    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.g |= Integer.MIN_VALUE;
        return this.f.a(this);
    }
}
