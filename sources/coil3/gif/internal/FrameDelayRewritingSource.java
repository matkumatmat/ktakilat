package coil3.gif.internal;

import kotlin.Metadata;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSource;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcoil3/gif/internal/FrameDelayRewritingSource;", "Lokio/ForwardingSource;", "Companion", "coil-gif_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FrameDelayRewritingSource extends ForwardingSource {
    public static final ByteString d = ByteString.Companion.decodeHex("0021F904");
    public final Buffer c = new Buffer();

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcoil3/gif/internal/FrameDelayRewritingSource$Companion;", "", "Lokio/ByteString;", "FRAME_DELAY_START_MARKER", "Lokio/ByteString;", "", "FRAME_DELAY_START_MARKER_SIZE_BYTES", "I", "MINIMUM_FRAME_DELAY", "DEFAULT_FRAME_DELAY", "coil-gif_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
    }

    public FrameDelayRewritingSource(BufferedSource bufferedSource) {
        super(bufferedSource);
    }

    public final boolean c(long j) {
        Buffer buffer = this.c;
        if (buffer.size() >= j) {
            return true;
        }
        long size = j - buffer.size();
        if (super.read(buffer, size) == size) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x009c A[EDGE_INSN: B:37:0x009c->B:26:0x009c ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long read(okio.Buffer r17, long r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r0.c(r2)
            okio.Buffer r4 = r0.c
            long r5 = r4.size()
            r7 = -1
            r9 = 0
            int r11 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r11 != 0) goto L_0x001d
            int r1 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r1 != 0) goto L_0x001c
            r7 = r9
        L_0x001c:
            return r7
        L_0x001d:
            r5 = r9
        L_0x001e:
            r11 = r7
        L_0x001f:
            okio.ByteString r13 = d
            r14 = 0
            byte r15 = r13.getByte(r14)
            r9 = 1
            long r11 = r11 + r9
            long r11 = r4.indexOf((byte) r15, (long) r11)
            int r15 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r15 == 0) goto L_0x0048
            int r7 = r13.size()
            long r7 = (long) r7
            boolean r7 = r0.c(r7)
            if (r7 == 0) goto L_0x0043
            boolean r7 = r4.rangeEquals(r11, r13)
            if (r7 == 0) goto L_0x0043
            goto L_0x0048
        L_0x0043:
            r7 = -1
            r9 = 0
            goto L_0x001f
        L_0x0048:
            if (r15 == 0) goto L_0x009c
            r7 = 4
            long r7 = (long) r7
            long r11 = r11 + r7
            long r7 = r4.read(r1, r11)
            r11 = 0
            int r13 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x0059
            r7 = 0
        L_0x0059:
            long r5 = r5 + r7
            r7 = 5
            boolean r7 = r0.c(r7)
            if (r7 == 0) goto L_0x0097
            r7 = 4
            byte r7 = r4.getByte(r7)
            if (r7 == 0) goto L_0x006b
            goto L_0x0097
        L_0x006b:
            r7 = 2
            byte r7 = r4.getByte(r7)
            kotlin.UByte$Companion r8 = kotlin.UByte.c
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r7 = r7 << 8
            byte r8 = r4.getByte(r9)
            r8 = r8 & 255(0xff, float:3.57E-43)
            r7 = r7 | r8
            r8 = 2
            if (r7 >= r8) goto L_0x0097
            r7 = 0
            byte r9 = r4.getByte(r7)
            r1.writeByte((int) r9)
            r7 = 10
            r1.writeByte((int) r7)
            r1.writeByte((int) r14)
            r7 = 3
            r4.skip(r7)
        L_0x0097:
            r7 = -1
            r9 = 0
            goto L_0x001e
        L_0x009c:
            int r7 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r7 >= 0) goto L_0x00ae
            long r2 = r2 - r5
            long r11 = r4.read(r1, r2)
            r1 = 0
            int r3 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r3 >= 0) goto L_0x00ac
            r11 = r1
        L_0x00ac:
            long r5 = r5 + r11
            goto L_0x00b0
        L_0x00ae:
            r1 = 0
        L_0x00b0:
            int r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x00b7
            r7 = -1
            goto L_0x00b8
        L_0x00b7:
            r7 = r5
        L_0x00b8:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.gif.internal.FrameDelayRewritingSource.read(okio.Buffer, long):long");
    }
}
