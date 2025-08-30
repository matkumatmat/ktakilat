package kotlin.uuid;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "2.0")
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u0000 \"2\u00060\u0001j\u0002`\u0002:\u0001\"B\u0019\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\rJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R \u0010\u0004\u001a\u00020\u00038\u0000X\u0004¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR \u0010\u0005\u001a\u00020\u00038\u0000X\u0004¢\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u0012\u0004\b!\u0010\u001e\u001a\u0004\b \u0010\u001c¨\u0006#"}, d2 = {"Lkotlin/uuid/Uuid;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "mostSignificantBits", "leastSignificantBits", "<init>", "(JJ)V", "", "writeReplace", "()Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "toHexString", "", "toByteArray", "()[B", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "c", "J", "getMostSignificantBits", "()J", "getMostSignificantBits$annotations", "()V", "d", "getLeastSignificantBits", "getLeastSignificantBits$annotations", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@ExperimentalUuidApi
public final class Uuid implements Serializable {
    @NotNull
    public static final Companion Companion = new Object();
    public static final int SIZE_BITS = 128;
    public static final int SIZE_BYTES = 16;
    public static final Uuid e = new Uuid(0, 0);
    public static final g0 f = new g0(6);
    public final long c;
    public final long d;

    @SourceDebugExtension({"SMAP\nUuid.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Uuid.kt\nkotlin/uuid/Uuid$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,452:1\n1#2:453\n*E\n"})
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"Lkotlin/uuid/Uuid$Companion;", "", "", "SIZE_BYTES", "I", "SIZE_BITS", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
    }

    public Uuid(long j, long j2) {
        this.c = j;
        this.d = j2;
    }

    @PublishedApi
    public static /* synthetic */ void getLeastSignificantBits$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getMostSignificantBits$annotations() {
    }

    private final Object writeReplace() {
        Intrinsics.checkNotNullParameter(this, "uuid");
        return new UuidSerialized(getMostSignificantBits(), getLeastSignificantBits());
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Uuid)) {
            return false;
        }
        Uuid uuid = (Uuid) obj;
        if (this.c == uuid.c && this.d == uuid.d) {
            return true;
        }
        return false;
    }

    public final long getLeastSignificantBits() {
        return this.d;
    }

    public final long getMostSignificantBits() {
        return this.c;
    }

    public int hashCode() {
        long j = this.c ^ this.d;
        return ((int) (j >> 32)) ^ ((int) j);
    }

    @NotNull
    public final byte[] toByteArray() {
        byte[] bArr = new byte[16];
        for (int i = 0; i < 8; i++) {
            bArr[i] = (byte) ((int) (this.c >>> ((7 - i) * 8)));
        }
        for (int i2 = 0; i2 < 8; i2++) {
            bArr[8 + i2] = (byte) ((int) (this.d >>> ((7 - i2) * 8)));
        }
        return bArr;
    }

    @NotNull
    public final String toHexString() {
        byte[] bArr = new byte[32];
        UuidKt__UuidKt.a(this.d, bArr, 16, 8);
        UuidKt__UuidKt.a(this.c, bArr, 0, 8);
        return StringsKt.o(bArr);
    }

    @NotNull
    public String toString() {
        byte[] bArr = new byte[36];
        long j = this.d;
        UuidKt__UuidKt.a(j, bArr, 24, 6);
        bArr[23] = 45;
        UuidKt__UuidKt.a(j >>> 48, bArr, 19, 2);
        bArr[18] = 45;
        long j2 = this.c;
        UuidKt__UuidKt.a(j2, bArr, 14, 2);
        bArr[13] = 45;
        UuidKt__UuidKt.a(j2 >>> 16, bArr, 9, 2);
        bArr[8] = 45;
        UuidKt__UuidKt.a(j2 >>> 32, bArr, 0, 4);
        return StringsKt.o(bArr);
    }
}
