package coil3.gif;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.gif.AnimatedImageDecoder", f = "AnimatedImageDecoder.kt", i = {0, 0}, l = {132}, m = "wrapDrawable", n = {"this", "baseDrawable"}, s = {"L$0", "L$1"})
final class AnimatedImageDecoder$wrapDrawable$1 extends ContinuationImpl {
    public AnimatedImageDecoder c;
    public Drawable d;
    public /* synthetic */ Object e;
    public final /* synthetic */ AnimatedImageDecoder f;
    public int g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimatedImageDecoder$wrapDrawable$1(AnimatedImageDecoder animatedImageDecoder, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f = animatedImageDecoder;
    }

    public final Object invokeSuspend(Object obj) {
        this.e = obj;
        this.g |= Integer.MIN_VALUE;
        return this.f.b((Drawable) null, this);
    }
}
