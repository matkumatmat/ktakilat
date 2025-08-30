package coil3.gif;

import kotlin.Metadata;
import okio.BufferedSource;
import okio.ByteString;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"coil-gif_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DecodeUtilsKt {

    /* renamed from: a  reason: collision with root package name */
    public static final ByteString f100a;
    public static final ByteString b;
    public static final ByteString c;
    public static final ByteString d;
    public static final ByteString e;
    public static final ByteString f;
    public static final ByteString g;
    public static final ByteString h;
    public static final ByteString i;

    static {
        ByteString.Companion companion = ByteString.Companion;
        f100a = companion.encodeUtf8("GIF87a");
        b = companion.encodeUtf8("GIF89a");
        c = companion.encodeUtf8("RIFF");
        d = companion.encodeUtf8("WEBP");
        e = companion.encodeUtf8("VP8X");
        f = companion.encodeUtf8("ftyp");
        g = companion.encodeUtf8("msf1");
        h = companion.encodeUtf8("hevc");
        i = companion.encodeUtf8("hevx");
    }

    public static final boolean a(BufferedSource bufferedSource) {
        if (bufferedSource.rangeEquals(0, b) || bufferedSource.rangeEquals(0, f100a)) {
            return true;
        }
        return false;
    }
}
