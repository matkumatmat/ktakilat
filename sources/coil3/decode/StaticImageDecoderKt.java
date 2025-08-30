package coil3.decode;

import android.content.res.AssetFileDescriptor;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import coil3.decode.ImageSource;
import coil3.request.Options;
import kotlin.Metadata;
import okio.FileSystem;
import okio.Path;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"coil-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class StaticImageDecoderKt {
    public static final ImageDecoder.Source a(ImageSource imageSource, Options options, boolean z) {
        Path o;
        if (imageSource.b() == FileSystem.SYSTEM && (o = imageSource.o()) != null) {
            return ImageDecoder.createSource(o.toFile());
        }
        ImageSource.Metadata metadata = imageSource.getMetadata();
        if (metadata instanceof AssetMetadata) {
            return ImageDecoder.createSource(options.f145a.getAssets(), ((AssetMetadata) metadata).f66a);
        }
        if (!(metadata instanceof ContentMetadata) || Build.VERSION.SDK_INT < 29) {
            if (metadata instanceof ResourceMetadata) {
                ResourceMetadata resourceMetadata = (ResourceMetadata) metadata;
                if (resourceMetadata.f76a.equals(options.f145a.getPackageName())) {
                    return ImageDecoder.createSource(options.f145a.getResources(), resourceMetadata.b);
                }
            }
            if (!(metadata instanceof ByteBufferMetadata)) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 30 || !z || ((ByteBufferMetadata) metadata).f69a.isDirect()) {
                return ImageDecoder.createSource(((ByteBufferMetadata) metadata).f69a);
            }
            return null;
        }
        try {
            AssetFileDescriptor assetFileDescriptor = ((ContentMetadata) metadata).f70a;
            Os.lseek(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), OsConstants.SEEK_SET);
            return ImageDecoder.createSource(new q1(assetFileDescriptor, 7));
        } catch (ErrnoException unused) {
            return null;
        }
    }
}
