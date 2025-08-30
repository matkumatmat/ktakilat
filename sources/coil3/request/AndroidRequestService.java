package coil3.request;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import coil3.Extras;
import coil3.ExtrasKt;
import coil3.RealImageLoader;
import coil3.size.Size;
import coil3.target.ImageViewTarget;
import coil3.target.ViewTarget;
import coil3.util.AndroidSystemCallbacks;
import coil3.util.BitmapsKt;
import coil3.util.HardwareBitmapService;
import coil3.util.HardwareBitmapsKt;
import coil3.util.Utils_androidKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/request/AndroidRequestService;", "Lcoil3/request/RequestService;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRequestService.android.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RequestService.android.kt\ncoil3/request/AndroidRequestService\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,258:1\n1#2:259\n*E\n"})
public final class AndroidRequestService implements RequestService {

    /* renamed from: a  reason: collision with root package name */
    public final RealImageLoader f135a;
    public final HardwareBitmapService b = HardwareBitmapsKt.a();

    public AndroidRequestService(RealImageLoader realImageLoader, AndroidSystemCallbacks androidSystemCallbacks) {
        this.f135a = realImageLoader;
    }

    public static Lifecycle a(ImageRequest imageRequest) {
        Context context;
        ImageViewTarget imageViewTarget = imageRequest.c;
        if (imageViewTarget instanceof ViewTarget) {
            context = imageViewTarget.a().getContext();
        } else {
            context = imageRequest.f137a;
        }
        while (!(context instanceof LifecycleOwner)) {
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return ((LifecycleOwner) context).getLifecycle();
    }

    public static boolean b(ImageRequest imageRequest, Bitmap.Config config) {
        if (!BitmapsKt.a(config)) {
            return true;
        }
        if (!((Boolean) ExtrasKt.a(imageRequest, ImageRequests_androidKt.h)).booleanValue()) {
            return false;
        }
        ImageViewTarget imageViewTarget = imageRequest.c;
        if (imageViewTarget instanceof ViewTarget) {
            ImageView a2 = imageViewTarget.a();
            if (!a2.isAttachedToWindow() || a2.isHardwareAccelerated()) {
                return true;
            }
            return false;
        }
        return true;
    }

    public final Options c(ImageRequest imageRequest, Size size) {
        boolean z;
        boolean z2;
        Extras.Key key = ImageRequests_androidKt.c;
        Bitmap.Config config = (Bitmap.Config) ExtrasKt.a(imageRequest, key);
        Extras.Key key2 = ImageRequests_androidKt.i;
        boolean booleanValue = ((Boolean) ExtrasKt.a(imageRequest, key2)).booleanValue();
        Extras.Key key3 = ImageRequests_androidKt.f142a;
        boolean z3 = false;
        if (((List) ExtrasKt.a(imageRequest, key3)).isEmpty() || ArraysKt.h(Utils_androidKt.f162a, (Bitmap.Config) ExtrasKt.a(imageRequest, key))) {
            z = true;
        } else {
            z = false;
        }
        if (!BitmapsKt.a((Bitmap.Config) ExtrasKt.a(imageRequest, key)) || (b(imageRequest, (Bitmap.Config) ExtrasKt.a(imageRequest, key)) && this.b.a(size))) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z || !z2) {
            config = Bitmap.Config.ARGB_8888;
        }
        if (booleanValue && ((List) ExtrasKt.a(imageRequest, key3)).isEmpty() && config != Bitmap.Config.ALPHA_8) {
            z3 = true;
        }
        Map map = imageRequest.u.n.f53a;
        Map map2 = imageRequest.s.f53a;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        Extras.Builder builder = new Extras.Builder(linkedHashMap);
        if (config != ((Bitmap.Config) ExtrasKt.a(imageRequest, key))) {
            builder.b(key, config);
        }
        if (z3 != ((Boolean) ExtrasKt.a(imageRequest, key2)).booleanValue()) {
            builder.b(key2, Boolean.valueOf(z3));
        }
        Extras a2 = builder.a();
        return new Options(imageRequest.f137a, size, imageRequest.q, imageRequest.r, (String) null, imageRequest.e, imageRequest.j, imageRequest.k, imageRequest.l, a2);
    }

    public final Options d(Options options) {
        boolean z;
        Extras extras = options.j;
        Extras.Key key = ImageRequests_androidKt.c;
        if (!BitmapsKt.a((Bitmap.Config) ExtrasKt.b(options, key)) || this.b.b()) {
            z = false;
        } else {
            extras.getClass();
            Extras.Builder builder = new Extras.Builder(extras);
            builder.b(key, Bitmap.Config.ARGB_8888);
            extras = builder.a();
            z = true;
        }
        Extras extras2 = extras;
        if (!z) {
            return options;
        }
        return new Options(options.f145a, options.b, options.c, options.d, options.e, options.f, options.g, options.h, options.i, extras2);
    }
}
