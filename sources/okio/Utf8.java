package okio;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0001H\b\u001a\u0011\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0007H\b\u001a4\u0010\u0010\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\bø\u0001\u0000\u001a4\u0010\u0017\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\bø\u0001\u0000\u001a4\u0010\u0018\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\bø\u0001\u0000\u001a4\u0010\u0019\u001a\u00020\u0016*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00160\u0015H\bø\u0001\u0000\u001a4\u0010\u001a\u001a\u00020\u0016*\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00160\u0015H\bø\u0001\u0000\u001a4\u0010\u001c\u001a\u00020\u0016*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0015H\bø\u0001\u0000\u001a%\u0010\u001d\u001a\u00020\u001e*\u00020\u001b2\b\b\u0002\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u0013\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u001f\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006 "}, d2 = {"HIGH_SURROGATE_HEADER", "", "LOG_SURROGATE_HEADER", "MASK_2BYTES", "MASK_3BYTES", "MASK_4BYTES", "REPLACEMENT_BYTE", "", "REPLACEMENT_CHARACTER", "", "REPLACEMENT_CODE_POINT", "isIsoControl", "", "codePoint", "isUtf8Continuation", "byte", "process2Utf8Bytes", "", "beginIndex", "endIndex", "yield", "Lkotlin/Function1;", "", "process3Utf8Bytes", "process4Utf8Bytes", "processUtf16Chars", "processUtf8Bytes", "", "processUtf8CodePoints", "utf8Size", "", "size", "okio"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUtf8.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utf8.kt\nokio/Utf8\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,559:1\n397#1,9:563\n127#1:572\n406#1,20:574\n440#1,4:595\n127#1:599\n446#1,10:601\n127#1:611\n456#1,5:612\n127#1:617\n461#1,24:618\n500#1,4:643\n127#1:647\n506#1,2:649\n127#1:651\n510#1,10:652\n127#1:662\n520#1,5:663\n127#1:668\n525#1,5:669\n127#1:674\n530#1,28:675\n397#1,9:704\n127#1:713\n406#1,20:715\n440#1,4:736\n127#1:740\n446#1,10:742\n127#1:752\n456#1,5:753\n127#1:758\n461#1,24:759\n500#1,4:784\n127#1:788\n506#1,2:790\n127#1:792\n510#1,10:793\n127#1:803\n520#1,5:804\n127#1:809\n525#1,5:810\n127#1:815\n530#1,28:816\n127#1:844\n127#1:846\n127#1:848\n127#1:850\n127#1:852\n127#1:854\n127#1:856\n127#1:858\n127#1:860\n1#2:560\n74#3:561\n68#3:562\n74#3:573\n68#3:594\n74#3:600\n68#3:642\n74#3:648\n68#3:703\n74#3:714\n68#3:735\n74#3:741\n68#3:783\n74#3:789\n74#3:845\n74#3:847\n74#3:849\n74#3:851\n74#3:853\n74#3:855\n74#3:857\n74#3:859\n74#3:861\n*S KotlinDebug\n*F\n+ 1 Utf8.kt\nokio/Utf8\n*L\n228#1:563,9\n228#1:572\n228#1:574,20\n232#1:595,4\n232#1:599\n232#1:601,10\n232#1:611\n232#1:612,5\n232#1:617\n232#1:618,24\n236#1:643,4\n236#1:647\n236#1:649,2\n236#1:651\n236#1:652,10\n236#1:662\n236#1:663,5\n236#1:668\n236#1:669,5\n236#1:674\n236#1:675,28\n277#1:704,9\n277#1:713\n277#1:715,20\n281#1:736,4\n281#1:740\n281#1:742,10\n281#1:752\n281#1:753,5\n281#1:758\n281#1:759,24\n285#1:784,4\n285#1:788\n285#1:790,2\n285#1:792\n285#1:793,10\n285#1:803\n285#1:804,5\n285#1:809\n285#1:810,5\n285#1:815\n285#1:816,28\n405#1:844\n443#1:846\n455#1:848\n460#1:850\n503#1:852\n507#1:854\n519#1:856\n524#1:858\n529#1:860\n127#1:561\n226#1:562\n228#1:573\n230#1:594\n232#1:600\n234#1:642\n236#1:648\n275#1:703\n277#1:714\n279#1:735\n281#1:741\n283#1:783\n285#1:789\n405#1:845\n443#1:847\n455#1:849\n460#1:851\n503#1:853\n507#1:855\n519#1:857\n524#1:859\n529#1:861\n*E\n"})
@JvmName(name = "Utf8")
public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = '�';
    public static final int REPLACEMENT_CODE_POINT = 65533;

    public static final boolean isIsoControl(int i) {
        return (i >= 0 && i < 32) || (127 <= i && i < 160);
    }

    public static final boolean isUtf8Continuation(byte b) {
        return (b & 192) == 128;
    }

    public static final int process2Utf8Bytes(@NotNull byte[] bArr, int i, int i2, @NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(function1, "yield");
        int i3 = i + 1;
        Integer valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i2 <= i3) {
            function1.invoke(valueOf);
            return 1;
        }
        byte b = bArr[i];
        byte b2 = bArr[i3];
        if ((b2 & 192) == 128) {
            byte b3 = (b2 ^ UnsignedBytes.MAX_POWER_OF_TWO) ^ (b << 6);
            if (b3 < 128) {
                function1.invoke(valueOf);
                return 2;
            }
            function1.invoke(Integer.valueOf(b3));
            return 2;
        }
        function1.invoke(valueOf);
        return 1;
    }

    public static final int process3Utf8Bytes(@NotNull byte[] bArr, int i, int i2, @NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(function1, "yield");
        int i3 = i + 2;
        Integer valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i2 <= i3) {
            function1.invoke(valueOf);
            int i4 = i + 1;
            if (i2 <= i4 || (bArr[i4] & 192) != 128) {
                return 1;
            }
            return 2;
        }
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        if ((b2 & 192) == 128) {
            byte b3 = bArr[i3];
            if ((b3 & 192) == 128) {
                byte b4 = ((b3 ^ UnsignedBytes.MAX_POWER_OF_TWO) ^ (b2 << 6)) ^ (b << Ascii.FF);
                if (b4 < 2048) {
                    function1.invoke(valueOf);
                    return 3;
                } else if (55296 > b4 || b4 >= 57344) {
                    function1.invoke(Integer.valueOf(b4));
                    return 3;
                } else {
                    function1.invoke(valueOf);
                    return 3;
                }
            } else {
                function1.invoke(valueOf);
                return 2;
            }
        } else {
            function1.invoke(valueOf);
            return 1;
        }
    }

    public static final int process4Utf8Bytes(@NotNull byte[] bArr, int i, int i2, @NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(function1, "yield");
        int i3 = i + 3;
        Integer valueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i2 <= i3) {
            function1.invoke(valueOf);
            int i4 = i + 1;
            if (i2 <= i4 || (bArr[i4] & 192) != 128) {
                return 1;
            }
            int i5 = i + 2;
            if (i2 <= i5 || (bArr[i5] & 192) != 128) {
                return 2;
            }
            return 3;
        }
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        if ((b2 & 192) == 128) {
            byte b3 = bArr[i + 2];
            if ((b3 & 192) == 128) {
                byte b4 = bArr[i3];
                if ((b4 & 192) == 128) {
                    byte b5 = (((b4 ^ UnsignedBytes.MAX_POWER_OF_TWO) ^ (b3 << 6)) ^ (b2 << Ascii.FF)) ^ (b << Ascii.DC2);
                    if (b5 > 1114111) {
                        function1.invoke(valueOf);
                        return 4;
                    } else if (55296 <= b5 && b5 < 57344) {
                        function1.invoke(valueOf);
                        return 4;
                    } else if (b5 < 65536) {
                        function1.invoke(valueOf);
                        return 4;
                    } else {
                        function1.invoke(Integer.valueOf(b5));
                        return 4;
                    }
                } else {
                    function1.invoke(valueOf);
                    return 3;
                }
            } else {
                function1.invoke(valueOf);
                return 2;
            }
        } else {
            function1.invoke(valueOf);
            return 1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008c, code lost:
        if ((r0[r8] & 192) == 128) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00f9, code lost:
        if ((r0[r8] & 192) == 128) goto L_0x00fb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void processUtf16Chars(@org.jetbrains.annotations.NotNull byte[] r16, int r17, int r18, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, kotlin.Unit> r19) {
        /*
            r0 = r16
            r1 = r18
            r2 = r19
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            java.lang.String r7 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r7)
            java.lang.String r7 = "yield"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r7)
            r7 = r17
        L_0x0016:
            if (r7 >= r1) goto L_0x018c
            byte r8 = r0[r7]
            if (r8 < 0) goto L_0x0035
            char r8 = (char) r8
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r2.invoke(r8)
            int r7 = r7 + r6
        L_0x0025:
            if (r7 >= r1) goto L_0x0016
            byte r8 = r0[r7]
            if (r8 < 0) goto L_0x0016
            int r7 = r7 + r6
            char r8 = (char) r8
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r2.invoke(r8)
            goto L_0x0025
        L_0x0035:
            int r9 = r8 >> 5
            r10 = -2
            r11 = 128(0x80, float:1.794E-43)
            r12 = 65533(0xfffd, float:9.1831E-41)
            if (r9 != r10) goto L_0x006c
            int r9 = r7 + 1
            if (r1 > r9) goto L_0x004f
        L_0x0043:
            char r8 = (char) r12
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r2.invoke(r8)
            kotlin.Unit r8 = kotlin.Unit.f696a
        L_0x004d:
            r8 = 1
            goto L_0x006a
        L_0x004f:
            byte r9 = r0[r9]
            r10 = r9 & 192(0xc0, float:2.69E-43)
            if (r10 != r11) goto L_0x0043
            r9 = r9 ^ 3968(0xf80, float:5.56E-42)
            int r8 = r8 << 6
            r8 = r8 ^ r9
            if (r8 >= r11) goto L_0x0067
            char r8 = (char) r12
        L_0x005d:
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r2.invoke(r8)
            kotlin.Unit r8 = kotlin.Unit.f696a
            goto L_0x0069
        L_0x0067:
            char r8 = (char) r8
            goto L_0x005d
        L_0x0069:
            r8 = 2
        L_0x006a:
            int r7 = r7 + r8
            goto L_0x0016
        L_0x006c:
            int r9 = r8 >> 4
            r13 = 57344(0xe000, float:8.0356E-41)
            r14 = 55296(0xd800, float:7.7486E-41)
            if (r9 != r10) goto L_0x00d6
            int r9 = r7 + 2
            if (r1 > r9) goto L_0x008f
            char r8 = (char) r12
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r2.invoke(r8)
            kotlin.Unit r8 = kotlin.Unit.f696a
            int r8 = r7 + 1
            if (r1 <= r8) goto L_0x004d
            byte r8 = r0[r8]
            r8 = r8 & 192(0xc0, float:2.69E-43)
            if (r8 != r11) goto L_0x004d
        L_0x008e:
            goto L_0x0069
        L_0x008f:
            int r10 = r7 + 1
            byte r10 = r0[r10]
            r15 = r10 & 192(0xc0, float:2.69E-43)
            if (r15 != r11) goto L_0x00ca
            byte r9 = r0[r9]
            r15 = r9 & 192(0xc0, float:2.69E-43)
            if (r15 != r11) goto L_0x00bf
            r11 = -123008(0xfffffffffffe1f80, float:NaN)
            r9 = r9 ^ r11
            int r10 = r10 << 6
            r9 = r9 ^ r10
            int r8 = r8 << 12
            r8 = r8 ^ r9
            r9 = 2048(0x800, float:2.87E-42)
            if (r8 >= r9) goto L_0x00b6
        L_0x00ab:
            char r8 = (char) r12
        L_0x00ac:
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r2.invoke(r8)
            kotlin.Unit r8 = kotlin.Unit.f696a
            goto L_0x00bd
        L_0x00b6:
            if (r14 > r8) goto L_0x00bb
            if (r8 >= r13) goto L_0x00bb
            goto L_0x00ab
        L_0x00bb:
            char r8 = (char) r8
            goto L_0x00ac
        L_0x00bd:
            r8 = 3
            goto L_0x006a
        L_0x00bf:
            char r8 = (char) r12
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r2.invoke(r8)
            kotlin.Unit r8 = kotlin.Unit.f696a
            goto L_0x008e
        L_0x00ca:
            char r8 = (char) r12
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r2.invoke(r8)
            kotlin.Unit r8 = kotlin.Unit.f696a
            goto L_0x004d
        L_0x00d6:
            int r9 = r8 >> 3
            if (r9 != r10) goto L_0x0183
            int r9 = r7 + 3
            if (r1 > r9) goto L_0x0104
            java.lang.Character r8 = java.lang.Character.valueOf(r12)
            r2.invoke(r8)
            kotlin.Unit r8 = kotlin.Unit.f696a
            int r8 = r7 + 1
            if (r1 <= r8) goto L_0x0101
            byte r8 = r0[r8]
            r8 = r8 & 192(0xc0, float:2.69E-43)
            if (r8 != r11) goto L_0x0101
            int r8 = r7 + 2
            if (r1 <= r8) goto L_0x00fe
            byte r8 = r0[r8]
            r8 = r8 & 192(0xc0, float:2.69E-43)
            if (r8 != r11) goto L_0x00fe
        L_0x00fb:
            r3 = 3
            goto L_0x017f
        L_0x00fe:
            r3 = 2
            goto L_0x017f
        L_0x0101:
            r3 = 1
            goto L_0x017f
        L_0x0104:
            int r10 = r7 + 1
            byte r10 = r0[r10]
            r15 = r10 & 192(0xc0, float:2.69E-43)
            if (r15 != r11) goto L_0x0175
            int r15 = r7 + 2
            byte r15 = r0[r15]
            r3 = r15 & 192(0xc0, float:2.69E-43)
            if (r3 != r11) goto L_0x016b
            byte r3 = r0[r9]
            r9 = r3 & 192(0xc0, float:2.69E-43)
            if (r9 != r11) goto L_0x0161
            r9 = 3678080(0x381f80, float:5.154088E-39)
            r3 = r3 ^ r9
            int r9 = r15 << 6
            r3 = r3 ^ r9
            int r9 = r10 << 12
            r3 = r3 ^ r9
            int r8 = r8 << 18
            r3 = r3 ^ r8
            r8 = 1114111(0x10ffff, float:1.561202E-39)
            if (r3 <= r8) goto L_0x0136
        L_0x012c:
            java.lang.Character r3 = java.lang.Character.valueOf(r12)
            r2.invoke(r3)
        L_0x0133:
            kotlin.Unit r3 = kotlin.Unit.f696a
            goto L_0x015f
        L_0x0136:
            if (r14 > r3) goto L_0x013b
            if (r3 >= r13) goto L_0x013b
            goto L_0x012c
        L_0x013b:
            r8 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r8) goto L_0x0140
            goto L_0x012c
        L_0x0140:
            if (r3 == r12) goto L_0x012c
            int r8 = r3 >>> 10
            r9 = 55232(0xd7c0, float:7.7397E-41)
            int r8 = r8 + r9
            char r8 = (char) r8
            java.lang.Character r8 = java.lang.Character.valueOf(r8)
            r2.invoke(r8)
            r3 = r3 & 1023(0x3ff, float:1.434E-42)
            r8 = 56320(0xdc00, float:7.8921E-41)
            int r3 = r3 + r8
            char r3 = (char) r3
            java.lang.Character r3 = java.lang.Character.valueOf(r3)
            r2.invoke(r3)
            goto L_0x0133
        L_0x015f:
            r3 = 4
            goto L_0x017f
        L_0x0161:
            java.lang.Character r3 = java.lang.Character.valueOf(r12)
            r2.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f696a
            goto L_0x00fb
        L_0x016b:
            java.lang.Character r3 = java.lang.Character.valueOf(r12)
            r2.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f696a
            goto L_0x00fe
        L_0x0175:
            java.lang.Character r3 = java.lang.Character.valueOf(r12)
            r2.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f696a
            goto L_0x0101
        L_0x017f:
            int r7 = r7 + r3
        L_0x0180:
            r3 = 4
            goto L_0x0016
        L_0x0183:
            java.lang.Character r3 = java.lang.Character.valueOf(r12)
            r2.invoke(r3)
            int r7 = r7 + r6
            goto L_0x0180
        L_0x018c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Utf8.processUtf16Chars(byte[], int, int, kotlin.jvm.functions.Function1):void");
    }

    public static final void processUtf8Bytes(@NotNull String str, int i, int i2, @NotNull Function1<? super Byte, Unit> function1) {
        int i3;
        char charAt;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(function1, "yield");
        while (i < i2) {
            char charAt2 = str.charAt(i);
            if (Intrinsics.f(charAt2, 128) < 0) {
                function1.invoke(Byte.valueOf((byte) charAt2));
                i++;
                while (i < i2 && Intrinsics.f(str.charAt(i), 128) < 0) {
                    function1.invoke(Byte.valueOf((byte) str.charAt(i)));
                    i++;
                }
            } else {
                if (Intrinsics.f(charAt2, 2048) < 0) {
                    function1.invoke(Byte.valueOf((byte) ((charAt2 >> 6) | 192)));
                    function1.invoke(Byte.valueOf((byte) ((charAt2 & '?') | 128)));
                } else if (55296 > charAt2 || charAt2 >= 57344) {
                    function1.invoke(Byte.valueOf((byte) ((charAt2 >> 12) | 224)));
                    function1.invoke(Byte.valueOf((byte) (((charAt2 >> 6) & 63) | 128)));
                    function1.invoke(Byte.valueOf((byte) ((charAt2 & '?') | 128)));
                } else if (Intrinsics.f(charAt2, 56319) > 0 || i2 <= (i3 = i + 1) || 56320 > (charAt = str.charAt(i3)) || charAt >= 57344) {
                    function1.invoke(Byte.valueOf(REPLACEMENT_BYTE));
                } else {
                    int charAt3 = (str.charAt(i3) + (charAt2 << 10)) - 56613888;
                    function1.invoke(Byte.valueOf((byte) ((charAt3 >> 18) | 240)));
                    function1.invoke(Byte.valueOf((byte) (((charAt3 >> 12) & 63) | 128)));
                    function1.invoke(Byte.valueOf((byte) (((charAt3 >> 6) & 63) | 128)));
                    function1.invoke(Byte.valueOf((byte) ((charAt3 & 63) | 128)));
                    i += 2;
                }
                i++;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008a, code lost:
        if ((r0[r8] & 192) == 128) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00f7, code lost:
        if ((r0[r8] & 192) == 128) goto L_0x00f9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void processUtf8CodePoints(@org.jetbrains.annotations.NotNull byte[] r16, int r17, int r18, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r19) {
        /*
            r0 = r16
            r1 = r18
            r2 = r19
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            java.lang.String r7 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r7)
            java.lang.String r7 = "yield"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r7)
            r7 = r17
        L_0x0016:
            if (r7 >= r1) goto L_0x016e
            byte r8 = r0[r7]
            if (r8 < 0) goto L_0x0033
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r2.invoke(r8)
            int r7 = r7 + r6
        L_0x0024:
            if (r7 >= r1) goto L_0x0016
            byte r8 = r0[r7]
            if (r8 < 0) goto L_0x0016
            int r7 = r7 + r6
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r2.invoke(r8)
            goto L_0x0024
        L_0x0033:
            int r9 = r8 >> 5
            r10 = -2
            r11 = 128(0x80, float:1.794E-43)
            r12 = 65533(0xfffd, float:9.1831E-41)
            if (r9 != r10) goto L_0x006b
            int r9 = r7 + 1
            if (r1 > r9) goto L_0x004c
        L_0x0041:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r12)
            r2.invoke(r8)
            kotlin.Unit r8 = kotlin.Unit.f696a
        L_0x004a:
            r8 = 1
            goto L_0x0069
        L_0x004c:
            byte r9 = r0[r9]
            r10 = r9 & 192(0xc0, float:2.69E-43)
            if (r10 != r11) goto L_0x0041
            r9 = r9 ^ 3968(0xf80, float:5.56E-42)
            int r8 = r8 << 6
            r8 = r8 ^ r9
            if (r8 >= r11) goto L_0x0063
            java.lang.Integer r8 = java.lang.Integer.valueOf(r12)
        L_0x005d:
            r2.invoke(r8)
            kotlin.Unit r8 = kotlin.Unit.f696a
            goto L_0x0068
        L_0x0063:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            goto L_0x005d
        L_0x0068:
            r8 = 2
        L_0x0069:
            int r7 = r7 + r8
            goto L_0x0016
        L_0x006b:
            int r9 = r8 >> 4
            r13 = 57344(0xe000, float:8.0356E-41)
            r14 = 55296(0xd800, float:7.7486E-41)
            if (r9 != r10) goto L_0x00d4
            int r9 = r7 + 2
            if (r1 > r9) goto L_0x008d
            java.lang.Integer r8 = java.lang.Integer.valueOf(r12)
            r2.invoke(r8)
            kotlin.Unit r8 = kotlin.Unit.f696a
            int r8 = r7 + 1
            if (r1 <= r8) goto L_0x004a
            byte r8 = r0[r8]
            r8 = r8 & 192(0xc0, float:2.69E-43)
            if (r8 != r11) goto L_0x004a
        L_0x008c:
            goto L_0x0068
        L_0x008d:
            int r10 = r7 + 1
            byte r10 = r0[r10]
            r15 = r10 & 192(0xc0, float:2.69E-43)
            if (r15 != r11) goto L_0x00c9
            byte r9 = r0[r9]
            r15 = r9 & 192(0xc0, float:2.69E-43)
            if (r15 != r11) goto L_0x00bf
            r11 = -123008(0xfffffffffffe1f80, float:NaN)
            r9 = r9 ^ r11
            int r10 = r10 << 6
            r9 = r9 ^ r10
            int r8 = r8 << 12
            r8 = r8 ^ r9
            r9 = 2048(0x800, float:2.87E-42)
            if (r8 >= r9) goto L_0x00b3
        L_0x00a9:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r12)
        L_0x00ad:
            r2.invoke(r8)
            kotlin.Unit r8 = kotlin.Unit.f696a
            goto L_0x00bd
        L_0x00b3:
            if (r14 > r8) goto L_0x00b8
            if (r8 >= r13) goto L_0x00b8
            goto L_0x00a9
        L_0x00b8:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            goto L_0x00ad
        L_0x00bd:
            r8 = 3
            goto L_0x0069
        L_0x00bf:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r12)
            r2.invoke(r8)
            kotlin.Unit r8 = kotlin.Unit.f696a
            goto L_0x008c
        L_0x00c9:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r12)
            r2.invoke(r8)
            kotlin.Unit r8 = kotlin.Unit.f696a
            goto L_0x004a
        L_0x00d4:
            int r9 = r8 >> 3
            if (r9 != r10) goto L_0x0165
            int r9 = r7 + 3
            if (r1 > r9) goto L_0x0100
            java.lang.Integer r8 = java.lang.Integer.valueOf(r12)
            r2.invoke(r8)
            kotlin.Unit r8 = kotlin.Unit.f696a
            int r8 = r7 + 1
            if (r1 <= r8) goto L_0x00fe
            byte r8 = r0[r8]
            r8 = r8 & 192(0xc0, float:2.69E-43)
            if (r8 != r11) goto L_0x00fe
            int r8 = r7 + 2
            if (r1 <= r8) goto L_0x00fc
            byte r8 = r0[r8]
            r8 = r8 & 192(0xc0, float:2.69E-43)
            if (r8 != r11) goto L_0x00fc
        L_0x00f9:
            r3 = 3
            goto L_0x0161
        L_0x00fc:
            r3 = 2
            goto L_0x0161
        L_0x00fe:
            r3 = 1
            goto L_0x0161
        L_0x0100:
            int r10 = r7 + 1
            byte r10 = r0[r10]
            r15 = r10 & 192(0xc0, float:2.69E-43)
            if (r15 != r11) goto L_0x0157
            int r15 = r7 + 2
            byte r15 = r0[r15]
            r3 = r15 & 192(0xc0, float:2.69E-43)
            if (r3 != r11) goto L_0x014d
            byte r3 = r0[r9]
            r9 = r3 & 192(0xc0, float:2.69E-43)
            if (r9 != r11) goto L_0x0143
            r9 = 3678080(0x381f80, float:5.154088E-39)
            r3 = r3 ^ r9
            int r9 = r15 << 6
            r3 = r3 ^ r9
            int r9 = r10 << 12
            r3 = r3 ^ r9
            int r8 = r8 << 18
            r3 = r3 ^ r8
            r8 = 1114111(0x10ffff, float:1.561202E-39)
            if (r3 <= r8) goto L_0x0132
        L_0x0128:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r12)
        L_0x012c:
            r2.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f696a
            goto L_0x0141
        L_0x0132:
            if (r14 > r3) goto L_0x0137
            if (r3 >= r13) goto L_0x0137
            goto L_0x0128
        L_0x0137:
            r8 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r8) goto L_0x013c
            goto L_0x0128
        L_0x013c:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x012c
        L_0x0141:
            r3 = 4
            goto L_0x0161
        L_0x0143:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r12)
            r2.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f696a
            goto L_0x00f9
        L_0x014d:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r12)
            r2.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f696a
            goto L_0x00fc
        L_0x0157:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r12)
            r2.invoke(r3)
            kotlin.Unit r3 = kotlin.Unit.f696a
            goto L_0x00fe
        L_0x0161:
            int r7 = r7 + r3
        L_0x0162:
            r3 = 4
            goto L_0x0016
        L_0x0165:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r12)
            r2.invoke(r3)
            int r7 = r7 + r6
            goto L_0x0162
        L_0x016e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Utf8.processUtf8CodePoints(byte[], int, int, kotlin.jvm.functions.Function1):void");
    }

    @JvmOverloads
    @JvmName(name = "size")
    public static final long size(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return size$default(str, 0, 0, 3, (Object) null);
    }

    public static /* synthetic */ long size$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return size(str, i, i2);
    }

    @JvmOverloads
    @JvmName(name = "size")
    public static final long size(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return size$default(str, i, 0, 2, (Object) null);
    }

    @JvmOverloads
    @JvmName(name = "size")
    public static final long size(@NotNull String str, int i, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(ba.k(i, "beginIndex < 0: ").toString());
        } else if (i2 < i) {
            throw new IllegalArgumentException(e.h(i2, "endIndex < beginIndex: ", " < ", i).toString());
        } else if (i2 <= str.length()) {
            long j = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt < 128) {
                    j++;
                } else {
                    if (charAt < 2048) {
                        i3 = 2;
                    } else if (charAt < 55296 || charAt > 57343) {
                        i3 = 3;
                    } else {
                        int i4 = i + 1;
                        char charAt2 = i4 < i2 ? str.charAt(i4) : 0;
                        if (charAt > 56319 || charAt2 < 56320 || charAt2 > 57343) {
                            j++;
                            i = i4;
                        } else {
                            j += (long) 4;
                            i += 2;
                        }
                    }
                    j += (long) i3;
                }
                i++;
            }
            return j;
        } else {
            StringBuilder t = ba.t(i2, "endIndex > string.length: ", " > ");
            t.append(str.length());
            throw new IllegalArgumentException(t.toString().toString());
        }
    }
}
