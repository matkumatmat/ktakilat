package okio;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B/\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0000J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0000J\u0006\u0010\u0013\u001a\u00020\u0000J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\u0000J\u0016\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lokio/Segment;", "", "()V", "data", "", "pos", "", "limit", "shared", "", "owner", "([BIIZZ)V", "next", "prev", "compact", "", "pop", "push", "segment", "sharedCopy", "split", "byteCount", "unsharedCopy", "writeTo", "sink", "Companion", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSegment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Segment.kt\nokio/Segment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,187:1\n1#2:188\n*E\n"})
public final class Segment {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int SHARE_MINIMUM = 1024;
    public static final int SIZE = 8192;
    @NotNull
    @JvmField
    public final byte[] data;
    @JvmField
    public int limit;
    @Nullable
    @JvmField
    public Segment next;
    @JvmField
    public boolean owner;
    @JvmField
    public int pos;
    @Nullable
    @JvmField
    public Segment prev;
    @JvmField
    public boolean shared;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lokio/Segment$Companion;", "", "()V", "SHARE_MINIMUM", "", "SIZE", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    public final void compact() {
        int i;
        Segment segment = this.prev;
        if (segment != this) {
            Intrinsics.c(segment);
            if (segment.owner) {
                int i2 = this.limit - this.pos;
                Segment segment2 = this.prev;
                Intrinsics.c(segment2);
                int i3 = 8192 - segment2.limit;
                Segment segment3 = this.prev;
                Intrinsics.c(segment3);
                if (segment3.shared) {
                    i = 0;
                } else {
                    Segment segment4 = this.prev;
                    Intrinsics.c(segment4);
                    i = segment4.pos;
                }
                if (i2 <= i3 + i) {
                    Segment segment5 = this.prev;
                    Intrinsics.c(segment5);
                    writeTo(segment5, i2);
                    pop();
                    SegmentPool.recycle(this);
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("cannot compact");
    }

    @Nullable
    public final Segment pop() {
        Segment segment = this.next;
        if (segment == this) {
            segment = null;
        }
        Segment segment2 = this.prev;
        Intrinsics.c(segment2);
        segment2.next = this.next;
        Segment segment3 = this.next;
        Intrinsics.c(segment3);
        segment3.prev = this.prev;
        this.next = null;
        this.prev = null;
        return segment;
    }

    @NotNull
    public final Segment push(@NotNull Segment segment) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        segment.prev = this;
        segment.next = this.next;
        Segment segment2 = this.next;
        Intrinsics.c(segment2);
        segment2.prev = segment;
        this.next = segment;
        return segment;
    }

    @NotNull
    public final Segment sharedCopy() {
        this.shared = true;
        return new Segment(this.data, this.pos, this.limit, true, false);
    }

    @NotNull
    public final Segment split(int i) {
        Segment segment;
        if (i <= 0 || i > this.limit - this.pos) {
            throw new IllegalArgumentException("byteCount out of range");
        }
        if (i >= 1024) {
            segment = sharedCopy();
        } else {
            segment = SegmentPool.take();
            byte[] bArr = this.data;
            byte[] bArr2 = segment.data;
            int i2 = this.pos;
            ArraysKt.i(bArr, 0, bArr2, i2, i2 + i);
        }
        segment.limit = segment.pos + i;
        this.pos += i;
        Segment segment2 = this.prev;
        Intrinsics.c(segment2);
        segment2.push(segment);
        return segment;
    }

    @NotNull
    public final Segment unsharedCopy() {
        byte[] bArr = this.data;
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        return new Segment(copyOf, this.pos, this.limit, false, true);
    }

    public final void writeTo(@NotNull Segment segment, int i) {
        Intrinsics.checkNotNullParameter(segment, "sink");
        if (segment.owner) {
            int i2 = segment.limit;
            int i3 = i2 + i;
            if (i3 > 8192) {
                if (!segment.shared) {
                    int i4 = segment.pos;
                    if (i3 - i4 <= 8192) {
                        byte[] bArr = segment.data;
                        ArraysKt.i(bArr, 0, bArr, i4, i2);
                        segment.limit -= segment.pos;
                        segment.pos = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            byte[] bArr2 = this.data;
            byte[] bArr3 = segment.data;
            int i5 = segment.limit;
            int i6 = this.pos;
            ArraysKt.i(bArr2, i5, bArr3, i6, i6 + i);
            segment.limit += i;
            this.pos += i;
            return;
        }
        throw new IllegalStateException("only owner can write");
    }

    public Segment(@NotNull byte[] bArr, int i, int i2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        this.data = bArr;
        this.pos = i;
        this.limit = i2;
        this.shared = z;
        this.owner = z2;
    }
}
