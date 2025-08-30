package coil3.request;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import coil3.Extras;
import coil3.ExtrasKt;
import coil3.transition.Transition;
import coil3.util.Utils_androidKt;
import kotlin.Metadata;
import kotlin.collections.EmptyList;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"coil-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ImageRequests_androidKt {

    /* renamed from: a  reason: collision with root package name */
    public static final Extras.Key f142a = new Extras.Key(EmptyList.INSTANCE);
    public static final Extras.Key b = new Extras.Key(Transition.Factory.f154a);
    public static final Extras.Key c = new Extras.Key(Utils_androidKt.b);
    public static final Extras.Key d = new Extras.Key((Object) null);
    public static final Extras.Key e;
    public static final Extras.Key f = new Extras.Key((Object) null);
    public static final Extras.Key g;
    public static final Extras.Key h;
    public static final Extras.Key i = new Extras.Key(Boolean.FALSE);

    static {
        Boolean bool = Boolean.TRUE;
        e = new Extras.Key(bool);
        g = new Extras.Key(bool);
        h = new Extras.Key(bool);
    }

    public static final Bitmap.Config a(Options options) {
        return (Bitmap.Config) ExtrasKt.b(options, c);
    }

    public static final ColorSpace b(Options options) {
        return u5.i(ExtrasKt.b(options, d));
    }
}
