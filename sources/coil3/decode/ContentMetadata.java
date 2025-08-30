package coil3.decode;

import android.content.res.AssetFileDescriptor;
import coil3.decode.ImageSource;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/decode/ContentMetadata;", "Lcoil3/decode/ImageSource$Metadata;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContentMetadata extends ImageSource.Metadata {

    /* renamed from: a  reason: collision with root package name */
    public final AssetFileDescriptor f70a;

    public ContentMetadata(AssetFileDescriptor assetFileDescriptor) {
        this.f70a = assetFileDescriptor;
    }
}
