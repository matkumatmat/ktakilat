package com.ktakilat.cbase.utils;

import android.os.Build;
import android.widget.ImageView;
import coil3.Extras;
import coil3.ImageLoader;
import coil3.SingletonImageLoader;
import coil3.decode.Decoder;
import coil3.gif.AnimatedImageDecoder;
import coil3.gif.GifDecoder;
import coil3.request.ImageRequest;
import coil3.request.ImageRequests_androidKt;
import coil3.target.ImageViewTarget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ktakilat/cbase/utils/ImageDataLoader;", "", "Companion", "CBase_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageDataLoader {

    @SourceDebugExtension({"SMAP\nImageDataLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImageDataLoader.kt\ncom/ktakilat/cbase/utils/ImageDataLoader$Companion\n+ 2 singletonImageLoaders.android.kt\ncoil3/SingletonImageLoaders_androidKt\n*L\n1#1,37:1\n35#2,3:38\n17#2:41\n40#2,6:42\n35#2,3:48\n17#2:51\n40#2,6:52\n*S KotlinDebug\n*F\n+ 1 ImageDataLoader.kt\ncom/ktakilat/cbase/utils/ImageDataLoader$Companion\n*L\n26#1:38,3\n26#1:41\n26#1:42,6\n32#1:48,3\n32#1:51\n32#1:52,6\n*E\n"})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0003\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ktakilat/cbase/utils/ImageDataLoader$Companion;", "", "CBase_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public static void a(ImageView imageView, Integer num) {
            Decoder.Factory factory;
            Intrinsics.checkNotNullParameter(imageView, "iv");
            Intrinsics.checkNotNullParameter(num, "data");
            if (Build.VERSION.SDK_INT >= 28) {
                factory = new AnimatedImageDecoder.Factory();
            } else {
                factory = new GifDecoder.Factory();
            }
            ImageLoader a2 = SingletonImageLoader.a(imageView.getContext());
            ImageRequest.Builder builder = new ImageRequest.Builder(imageView.getContext());
            builder.c = num;
            Extras.Key key = ImageRequests_androidKt.f142a;
            builder.d = new ImageViewTarget(imageView);
            builder.f = factory;
            a2.a(builder.a());
        }
    }
}
