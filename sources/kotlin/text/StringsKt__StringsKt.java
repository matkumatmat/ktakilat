package kotlin.text;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.internal.FacebookRequestErrorClassification;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/text/StringsKt")
@SourceDebugExtension({"SMAP\nStrings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Strings.kt\nkotlin/text/StringsKt__StringsKt\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1560:1\n80#1,22:1561\n114#1,5:1583\n131#1,5:1588\n80#1,22:1593\n108#1:1615\n80#1,22:1616\n114#1,5:1638\n125#1:1643\n114#1,5:1644\n131#1,5:1649\n142#1:1654\n131#1,5:1655\n80#1,22:1660\n114#1,5:1682\n131#1,5:1687\n1069#2,2:1692\n12647#3,2:1694\n12647#3,2:1696\n295#4,2:1698\n295#4,2:1700\n1557#4:1703\n1628#4,3:1704\n1557#4:1707\n1628#4,3:1708\n1#5:1702\n*S KotlinDebug\n*F\n+ 1 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n108#1:1561,22\n125#1:1583,5\n142#1:1588,5\n147#1:1593,22\n152#1:1615\n152#1:1616,22\n157#1:1638,5\n162#1:1643\n162#1:1644,5\n167#1:1649,5\n172#1:1654\n172#1:1655,5\n177#1:1660,22\n188#1:1682,5\n199#1:1687,5\n312#1:1692,2\n952#1:1694,2\n976#1:1696,2\n1015#1:1698,2\n1021#1:1700,2\n1382#1:1703\n1382#1:1704,3\n1407#1:1707\n1407#1:1708,3\n*E\n"})
class StringsKt__StringsKt extends StringsKt__StringsJVMKt {
    public static boolean b(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "suffix");
        if (str instanceof String) {
            return StringsKt.p(str, str2, false);
        }
        return g(str, false, str.length() - str2.length(), str2, 0, str2.length());
    }

    public static final int c(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int d(int i, CharSequence charSequence, String str, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i);
        }
        return e(charSequence, str, i, charSequence.length(), z, false);
    }

    public static final int e(CharSequence charSequence, String str, int i, int i2, boolean z, boolean z2) {
        IntProgression intProgression;
        if (!z2) {
            if (i < 0) {
                i = 0;
            }
            int length = charSequence.length();
            if (i2 > length) {
                i2 = length;
            }
            intProgression = new IntProgression(i, i2, 1);
        } else {
            int c = c(charSequence);
            if (i > c) {
                i = c;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            IntProgression.f.getClass();
            intProgression = new IntProgression(i, i2, -1);
        }
        boolean z3 = charSequence instanceof String;
        int i3 = intProgression.e;
        int i4 = intProgression.d;
        int i5 = intProgression.c;
        if (!z3 || !(str instanceof String)) {
            if ((i3 > 0 && i5 <= i4) || (i3 < 0 && i4 <= i5)) {
                while (true) {
                    if (!g(str, z, 0, charSequence, i5, str.length())) {
                        if (i5 == i4) {
                            break;
                        }
                        i5 += i3;
                    } else {
                        return i5;
                    }
                }
            }
        } else if ((i3 > 0 && i5 <= i4) || (i3 < 0 && i4 <= i5)) {
            while (true) {
                if (!StringsKt__StringsJVMKt.a(str, 0, z, (String) charSequence, i5, str.length())) {
                    if (i5 == i4) {
                        break;
                    }
                    i5 += i3;
                } else {
                    return i5;
                }
            }
        }
        return -1;
    }

    public static final int f(CharSequence charSequence, char[] cArr, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "chars");
        if (z || cArr.length != 1 || !(charSequence instanceof String)) {
            if (i < 0) {
                i = 0;
            }
            int c = c(charSequence);
            if (i > c) {
                return -1;
            }
            while (true) {
                char charAt = charSequence.charAt(i);
                for (char b : cArr) {
                    if (CharsKt__CharKt.b(b, charAt, z)) {
                        return i;
                    }
                }
                if (i == c) {
                    return -1;
                }
                i++;
            }
        } else {
            return ((String) charSequence).indexOf(ArraysKt.w(cArr), i);
        }
    }

    public static final boolean g(CharSequence charSequence, boolean z, int i, CharSequence charSequence2, int i2, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(charSequence2, FacebookRequestErrorClassification.KEY_OTHER);
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!CharsKt__CharKt.b(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static final void h(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(ba.k(i, "Limit must be non-negative, but was ").toString());
        }
    }

    public static final List i(int i, CharSequence charSequence, String str, boolean z) {
        boolean z2;
        h(i);
        int i2 = 0;
        int d = d(0, charSequence, str, z);
        if (d == -1 || i == 1) {
            return CollectionsKt.s(charSequence.toString());
        }
        if (i > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        int i3 = 10;
        if (z2 && i <= 10) {
            i3 = i;
        }
        ArrayList arrayList = new ArrayList(i3);
        do {
            arrayList.add(charSequence.subSequence(i2, d).toString());
            i2 = str.length() + d;
            if ((z2 && arrayList.size() == i - 1) || (d = d(i2, charSequence, str, z)) == -1) {
                arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
            }
            arrayList.add(charSequence.subSequence(i2, d).toString());
            i2 = str.length() + d;
            break;
        } while ((d = d(i2, charSequence, str, z)) == -1);
        arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
        return arrayList;
    }

    public static List split$default(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(strArr, "delimiters");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                return i(i, charSequence, str, z);
            }
        }
        h(i);
        DelimitedRangesSequence delimitedRangesSequence = new DelimitedRangesSequence(charSequence, 0, i, new a(1, ArraysKt.c(strArr), z));
        Intrinsics.checkNotNullParameter(delimitedRangesSequence, "<this>");
        ArrayList arrayList = new ArrayList(CollectionsKt.h(new SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1(delimitedRangesSequence)));
        Iterator it = delimitedRangesSequence.iterator();
        while (it.hasNext()) {
            IntRange intRange = (IntRange) it.next();
            Intrinsics.checkNotNullParameter(charSequence, "<this>");
            Intrinsics.checkNotNullParameter(intRange, "range");
            arrayList.add(charSequence.subSequence(intRange.c, intRange.d + 1).toString());
        }
        return arrayList;
    }
}
