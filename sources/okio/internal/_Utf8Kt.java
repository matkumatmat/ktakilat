package okio.internal;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001e\u0010\u0003\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"commonAsUtf8ToByteArray", "", "", "commonToUtf8String", "beginIndex", "", "endIndex", "okio"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\n-Utf8.kt\nKotlin\n*S Kotlin\n*F\n+ 1 -Utf8.kt\nokio/internal/_Utf8Kt\n+ 2 Utf8.kt\nokio/Utf8\n+ 3 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,60:1\n260#2,16:61\n277#2:78\n397#2,9:79\n127#2:88\n406#2,20:90\n279#2,3:110\n440#2,4:113\n127#2:117\n446#2,10:118\n127#2:128\n456#2,5:129\n127#2:134\n461#2,24:135\n283#2,3:159\n500#2,3:162\n286#2,12:165\n503#2:177\n127#2:178\n506#2,2:179\n127#2:181\n510#2,10:182\n127#2:192\n520#2,5:193\n127#2:198\n525#2,5:199\n127#2:204\n530#2,28:205\n302#2,6:233\n138#2,67:239\n68#3:77\n74#3:89\n*S KotlinDebug\n*F\n+ 1 -Utf8.kt\nokio/internal/_Utf8Kt\n*L\n34#1:61,16\n34#1:78\n34#1:79,9\n34#1:88\n34#1:90,20\n34#1:110,3\n34#1:113,4\n34#1:117\n34#1:118,10\n34#1:128\n34#1:129,5\n34#1:134\n34#1:135,24\n34#1:159,3\n34#1:162,3\n34#1:165,12\n34#1:177\n34#1:178\n34#1:179,2\n34#1:181\n34#1:182,10\n34#1:192\n34#1:193,5\n34#1:198\n34#1:199,5\n34#1:204\n34#1:205,28\n34#1:233,6\n50#1:239,67\n34#1:77\n34#1:89\n*E\n"})
public final class _Utf8Kt {
    @NotNull
    public static final byte[] commonAsUtf8ToByteArray(@NotNull String str) {
        int i;
        int i2;
        char charAt;
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bArr = new byte[(str.length() * 4)];
        int length = str.length();
        int i3 = 0;
        while (i < length) {
            char charAt2 = str.charAt(i);
            if (Intrinsics.f(charAt2, 128) >= 0) {
                int length2 = str.length();
                int i4 = i;
                while (i < length2) {
                    char charAt3 = str.charAt(i);
                    if (Intrinsics.f(charAt3, 128) < 0) {
                        int i5 = i4 + 1;
                        bArr[i4] = (byte) charAt3;
                        i++;
                        while (true) {
                            i4 = i5;
                            if (i >= length2 || Intrinsics.f(str.charAt(i), 128) >= 0) {
                                break;
                            }
                            i5 = i4 + 1;
                            bArr[i4] = (byte) str.charAt(i);
                            i++;
                        }
                    } else {
                        if (Intrinsics.f(charAt3, 2048) < 0) {
                            bArr[i4] = (byte) ((charAt3 >> 6) | 192);
                            i4 += 2;
                            bArr[i4 + 1] = (byte) ((charAt3 & '?') | 128);
                        } else if (55296 > charAt3 || charAt3 >= 57344) {
                            bArr[i4] = (byte) ((charAt3 >> 12) | 224);
                            bArr[i4 + 1] = (byte) (((charAt3 >> 6) & 63) | 128);
                            i4 += 3;
                            bArr[i4 + 2] = (byte) ((charAt3 & '?') | 128);
                        } else if (Intrinsics.f(charAt3, 56319) > 0 || length2 <= (i2 = i + 1) || 56320 > (charAt = str.charAt(i2)) || charAt >= 57344) {
                            bArr[i4] = Utf8.REPLACEMENT_BYTE;
                            i++;
                            i4++;
                        } else {
                            int charAt4 = (str.charAt(i2) + (charAt3 << 10)) - 56613888;
                            bArr[i4] = (byte) ((charAt4 >> 18) | 240);
                            bArr[i4 + 1] = (byte) (((charAt4 >> 12) & 63) | 128);
                            bArr[i4 + 2] = (byte) (((charAt4 >> 6) & 63) | 128);
                            i4 += 4;
                            bArr[i4 + 3] = (byte) ((charAt4 & 63) | 128);
                            i += 2;
                        }
                        i++;
                    }
                }
                byte[] copyOf = Arrays.copyOf(bArr, i4);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                return copyOf;
            }
            bArr[i] = (byte) charAt2;
            i3 = i + 1;
        }
        byte[] copyOf2 = Arrays.copyOf(bArr, str.length());
        Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(...)");
        return copyOf2;
    }

    @NotNull
    public static final String commonToUtf8String(@NotNull byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        byte b;
        byte[] bArr2 = bArr;
        int i14 = i;
        int i15 = i2;
        int i16 = 3;
        Intrinsics.checkNotNullParameter(bArr2, "<this>");
        if (i14 < 0 || i15 > bArr2.length || i14 > i15) {
            throw new ArrayIndexOutOfBoundsException("size=" + bArr2.length + " beginIndex=" + i14 + " endIndex=" + i15);
        }
        char[] cArr = new char[(i15 - i14)];
        int i17 = 0;
        while (i14 < i15) {
            byte b2 = bArr2[i14];
            if (b2 >= 0) {
                int i18 = i17 + 1;
                cArr[i17] = (char) b2;
                i14++;
                while (true) {
                    i17 = i18;
                    if (i14 >= i15 || (b = bArr2[i14]) < 0) {
                        break;
                    }
                    i14++;
                    i18 = i17 + 1;
                    cArr[i17] = (char) b;
                }
            } else if ((b2 >> 5) == -2) {
                int i19 = i14 + 1;
                if (i15 <= i19) {
                    i12 = i17 + 1;
                    cArr[i17] = (char) Utf8.REPLACEMENT_CODE_POINT;
                } else {
                    byte b3 = bArr2[i19];
                    if ((b3 & 192) == 128) {
                        byte b4 = (b2 << 6) ^ (b3 ^ UnsignedBytes.MAX_POWER_OF_TWO);
                        if (b4 < 128) {
                            i13 = i17 + 1;
                            cArr[i17] = (char) Utf8.REPLACEMENT_CODE_POINT;
                        } else {
                            i13 = i17 + 1;
                            cArr[i17] = (char) b4;
                        }
                        Unit unit = Unit.f696a;
                        i17 = i13;
                        i11 = 2;
                        i14 += i11;
                    } else {
                        i12 = i17 + 1;
                        cArr[i17] = (char) Utf8.REPLACEMENT_CODE_POINT;
                    }
                }
                Unit unit2 = Unit.f696a;
                i17 = i12;
                i11 = 1;
                i14 += i11;
            } else if ((b2 >> 4) == -2) {
                int i20 = i14 + 2;
                if (i15 <= i20) {
                    int i21 = i17 + 1;
                    cArr[i17] = (char) Utf8.REPLACEMENT_CODE_POINT;
                    Unit unit3 = Unit.f696a;
                    int i22 = i14 + 1;
                    if (i15 <= i22 || (bArr2[i22] & 192) != 128) {
                        i8 = i21;
                        i7 = 1;
                        i14 += i7;
                    } else {
                        i9 = i21;
                    }
                } else {
                    byte b5 = bArr2[i14 + 1];
                    if ((b5 & 192) == 128) {
                        byte b6 = bArr2[i20];
                        if ((b6 & 192) == 128) {
                            byte b7 = ((b6 ^ UnsignedBytes.MAX_POWER_OF_TWO) ^ (b5 << 6)) ^ (b2 << Ascii.FF);
                            if (b7 < 2048) {
                                i10 = i17 + 1;
                                cArr[i17] = (char) Utf8.REPLACEMENT_CODE_POINT;
                            } else if (55296 > b7 || b7 >= 57344) {
                                char c = (char) b7;
                                i10 = i17 + 1;
                                cArr[i17] = c;
                            } else {
                                i10 = i17 + 1;
                                cArr[i17] = (char) Utf8.REPLACEMENT_CODE_POINT;
                            }
                            Unit unit4 = Unit.f696a;
                            i9 = i10;
                            i7 = 3;
                            i14 += i7;
                        } else {
                            cArr[i17] = (char) Utf8.REPLACEMENT_CODE_POINT;
                            Unit unit5 = Unit.f696a;
                            i9 = i17 + 1;
                        }
                    } else {
                        cArr[i17] = (char) Utf8.REPLACEMENT_CODE_POINT;
                        Unit unit6 = Unit.f696a;
                        i8 = i17 + 1;
                        i7 = 1;
                        i14 += i7;
                    }
                }
                i7 = 2;
                i14 += i7;
            } else {
                if ((b2 >> 3) == -2) {
                    int i23 = i14 + 3;
                    if (i15 <= i23) {
                        i5 = i17 + 1;
                        cArr[i17] = Utf8.REPLACEMENT_CHARACTER;
                        Unit unit7 = Unit.f696a;
                        int i24 = i14 + 1;
                        if (i15 > i24 && (bArr2[i24] & 192) == 128) {
                            int i25 = i14 + 2;
                            if (i15 > i25 && (bArr2[i25] & 192) == 128) {
                                i4 = i5;
                                i3 = i14 + i16;
                            }
                        }
                        i4 = i5;
                        i16 = 1;
                        i3 = i14 + i16;
                    } else {
                        byte b8 = bArr2[i14 + 1];
                        if ((b8 & 192) == 128) {
                            byte b9 = bArr2[i14 + 2];
                            if ((b9 & 192) == 128) {
                                byte b10 = bArr2[i23];
                                if ((b10 & 192) == 128) {
                                    byte b11 = (((b10 ^ UnsignedBytes.MAX_POWER_OF_TWO) ^ (b9 << 6)) ^ (b8 << Ascii.FF)) ^ (b2 << Ascii.DC2);
                                    if (b11 > 1114111) {
                                        i6 = i17 + 1;
                                        cArr[i17] = Utf8.REPLACEMENT_CHARACTER;
                                    } else if (55296 <= b11 && b11 < 57344) {
                                        i6 = i17 + 1;
                                        cArr[i17] = Utf8.REPLACEMENT_CHARACTER;
                                    } else if (b11 < 65536) {
                                        i6 = i17 + 1;
                                        cArr[i17] = Utf8.REPLACEMENT_CHARACTER;
                                    } else if (b11 != 65533) {
                                        cArr[i17] = (char) ((b11 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                                        cArr[i17 + 1] = (char) ((b11 & UnsignedBytes.MAX_VALUE) + Utf8.LOG_SURROGATE_HEADER);
                                        i6 = i17 + 2;
                                    } else {
                                        i6 = i17 + 1;
                                        cArr[i17] = Utf8.REPLACEMENT_CHARACTER;
                                    }
                                    Unit unit8 = Unit.f696a;
                                    i4 = i6;
                                    i16 = 4;
                                } else {
                                    cArr[i17] = Utf8.REPLACEMENT_CHARACTER;
                                    Unit unit9 = Unit.f696a;
                                    i4 = i17 + 1;
                                    i16 = 3;
                                }
                                i3 = i14 + i16;
                            } else {
                                i5 = i17 + 1;
                                cArr[i17] = Utf8.REPLACEMENT_CHARACTER;
                                Unit unit10 = Unit.f696a;
                            }
                        } else {
                            i5 = i17 + 1;
                            cArr[i17] = Utf8.REPLACEMENT_CHARACTER;
                            Unit unit11 = Unit.f696a;
                            i4 = i5;
                            i16 = 1;
                            i3 = i14 + i16;
                        }
                    }
                    i4 = i5;
                    i16 = 2;
                    i3 = i14 + i16;
                } else {
                    cArr[i17] = Utf8.REPLACEMENT_CHARACTER;
                    i3 = i14 + 1;
                    i4 = i17 + 1;
                }
                i16 = 3;
            }
        }
        return StringsKt.l(cArr, 0, i17);
    }

    public static /* synthetic */ String commonToUtf8String$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        return commonToUtf8String(bArr, i, i2);
    }
}
