package kotlin.text;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;

@Metadata(d1 = {"kotlin/text/StringsKt__AppendableKt", "kotlin/text/StringsKt__IndentKt", "kotlin/text/StringsKt__RegexExtensionsJVMKt", "kotlin/text/StringsKt__RegexExtensionsKt", "kotlin/text/StringsKt__StringBuilderJVMKt", "kotlin/text/StringsKt__StringBuilderKt", "kotlin/text/StringsKt__StringNumberConversionsJVMKt", "kotlin/text/StringsKt__StringNumberConversionsKt", "kotlin/text/StringsKt__StringsJVMKt", "kotlin/text/StringsKt__StringsKt", "kotlin/text/StringsKt___StringsJvmKt", "kotlin/text/StringsKt___StringsKt"}, k = 4, mv = {2, 1, 0}, xi = 49)
public final class StringsKt extends StringsKt___StringsKt {
    private StringsKt() {
    }

    public static String A(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter("Client", "suffix");
        if (!StringsKt__StringsKt.b(str, "Client")) {
            return str;
        }
        String substring = str.substring(0, str.length() - 6);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public static String B(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter("\"", "delimiter");
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter("\"", "prefix");
        Intrinsics.checkNotNullParameter("\"", "suffix");
        if (str.length() < 2 || !J(str, "\"") || !StringsKt__StringsKt.b(str, "\"")) {
            return str;
        }
        String substring = str.substring(1, str.length() - 1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public static String C(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i + ClassUtils.PACKAGE_SEPARATOR_CHAR).toString());
        } else if (i == 0) {
            return "";
        } else {
            int i2 = 1;
            if (i == 1) {
                return str.toString();
            }
            int length = str.length();
            if (length == 0) {
                return "";
            }
            if (length != 1) {
                StringBuilder sb = new StringBuilder(str.length() * i);
                if (1 <= i) {
                    while (true) {
                        sb.append(str);
                        if (i2 == i) {
                            break;
                        }
                        i2++;
                    }
                }
                String sb2 = sb.toString();
                Intrinsics.c(sb2);
                return sb2;
            }
            char charAt = str.charAt(0);
            char[] cArr = new char[i];
            for (int i3 = 0; i3 < i; i3++) {
                cArr[i3] = charAt;
            }
            return new String(cArr);
        }
    }

    public static String D(String str, char c, char c2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String replace = str.replace(c, c2);
        Intrinsics.checkNotNullExpressionValue(replace, "replace(...)");
        return replace;
    }

    public static String E(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "oldValue");
        Intrinsics.checkNotNullParameter(str3, "newValue");
        int d = StringsKt__StringsKt.d(0, str, str2, false);
        if (d < 0) {
            return str;
        }
        int length = str2.length();
        int i = 1;
        if (length >= 1) {
            i = length;
        }
        int length2 = str3.length() + (str.length() - length);
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            int i2 = 0;
            do {
                sb.append(str, i2, d);
                sb.append(str3);
                i2 = d + length;
                if (d >= str.length() || (d = StringsKt__StringsKt.d(d + i, str, str2, false)) <= 0) {
                    sb.append(str, i2, str.length());
                    String sb2 = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                }
                sb.append(str, i2, d);
                sb.append(str3);
                i2 = d + length;
                break;
            } while ((d = StringsKt__StringsKt.d(d + i, str, str2, false)) <= 0);
            sb.append(str, i2, str.length());
            String sb22 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb22, "toString(...)");
            return sb22;
        }
        throw new OutOfMemoryError();
    }

    public static List F(String str, char[] cArr) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "delimiters");
        if (cArr.length == 1) {
            return StringsKt__StringsKt.i(0, str, String.valueOf(cArr[0]), false);
        }
        StringsKt__StringsKt.h(0);
        DelimitedRangesSequence delimitedRangesSequence = new DelimitedRangesSequence(str, 0, 0, new a(0, cArr, false));
        Intrinsics.checkNotNullParameter(delimitedRangesSequence, "<this>");
        ArrayList arrayList = new ArrayList(CollectionsKt.h(new SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1(delimitedRangesSequence)));
        Iterator it = delimitedRangesSequence.iterator();
        while (it.hasNext()) {
            IntRange intRange = (IntRange) it.next();
            Intrinsics.checkNotNullParameter(str, "<this>");
            Intrinsics.checkNotNullParameter(intRange, "range");
            arrayList.add(str.subSequence(intRange.c, intRange.d + 1).toString());
        }
        return arrayList;
    }

    public static boolean H(String str, String str2, int i, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "prefix");
        if (!z) {
            return str.startsWith(str2, i);
        }
        return StringsKt__StringsJVMKt.a(str, i, z, str2, 0, str2.length());
    }

    public static boolean I(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "prefix");
        if (!z) {
            return str.startsWith(str2);
        }
        return StringsKt__StringsJVMKt.a(str, 0, z, str2, 0, str2.length());
    }

    public static boolean J(CharSequence charSequence, String str) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(str, "prefix");
        if ((charSequence instanceof String) && (str instanceof String)) {
            return I((String) charSequence, str, false);
        }
        return StringsKt__StringsKt.g(charSequence, false, 0, str, 0, str.length());
    }

    public static String K(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "delimiter");
        Intrinsics.checkNotNullParameter(str, "missingDelimiterValue");
        int s = s(str, str2, 0, false, 6);
        if (s == -1) {
            return str;
        }
        String substring = str.substring(str2.length() + s, str.length());
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public static String L(String str, char c, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "missingDelimiterValue");
        int w = w(str, c, 0, 6);
        if (w == -1) {
            return str2;
        }
        String substring = str.substring(w + 1, str.length());
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public static String M(String str, char c) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str, "missingDelimiterValue");
        int w = w(str, c, 0, 6);
        if (w == -1) {
            return str;
        }
        String substring = str.substring(0, w);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public static String N(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (i >= 0) {
            int length = str.length();
            if (i > length) {
                i = length;
            }
            String substring = str.substring(0, i);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return substring;
        }
        throw new IllegalArgumentException(ba.l(i, "Requested character count ", " is less than zero.").toString());
    }

    public static Float O(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            if (ScreenFloatValueRegEx.b.matches(str)) {
                return Float.valueOf(Float.parseFloat(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Long P(java.lang.String r18) {
        /*
            r0 = r18
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r1 = 10
            kotlin.text.CharsKt__CharJVMKt.checkRadix(r1)
            int r2 = r18.length()
            r3 = 0
            if (r2 != 0) goto L_0x0018
            goto L_0x0084
        L_0x0018:
            r4 = 0
            char r5 = r0.charAt(r4)
            r6 = 48
            int r6 = kotlin.jvm.internal.Intrinsics.f(r5, r6)
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r6 >= 0) goto L_0x003c
            r6 = 1
            if (r2 != r6) goto L_0x002e
            goto L_0x0084
        L_0x002e:
            r9 = 43
            if (r5 == r9) goto L_0x003b
            r4 = 45
            if (r5 == r4) goto L_0x0037
            goto L_0x0084
        L_0x0037:
            r7 = -9223372036854775808
            r4 = 1
            goto L_0x003d
        L_0x003b:
            r4 = 1
        L_0x003c:
            r6 = 0
        L_0x003d:
            r9 = -256204778801521550(0xfc71c71c71c71c72, double:-2.772000429909333E291)
            r11 = 0
            r13 = r9
        L_0x0045:
            if (r4 >= r2) goto L_0x0076
            char r5 = r0.charAt(r4)
            int r5 = java.lang.Character.digit(r5, r1)
            if (r5 >= 0) goto L_0x0052
            goto L_0x0084
        L_0x0052:
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 >= 0) goto L_0x0062
            int r15 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r15 != 0) goto L_0x0084
            long r13 = (long) r1
            long r13 = r7 / r13
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 >= 0) goto L_0x0062
            goto L_0x0084
        L_0x0062:
            long r9 = (long) r1
            long r11 = r11 * r9
            long r9 = (long) r5
            long r16 = r7 + r9
            int r5 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r5 >= 0) goto L_0x006d
            goto L_0x0084
        L_0x006d:
            long r11 = r11 - r9
            int r4 = r4 + 1
            r9 = -256204778801521550(0xfc71c71c71c71c72, double:-2.772000429909333E291)
            goto L_0x0045
        L_0x0076:
            if (r6 == 0) goto L_0x007e
            java.lang.Long r0 = java.lang.Long.valueOf(r11)
        L_0x007c:
            r3 = r0
            goto L_0x0084
        L_0x007e:
            long r0 = -r11
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            goto L_0x007c
        L_0x0084:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt.P(java.lang.String):java.lang.Long");
    }

    public static CharSequence Q(String str) {
        int i;
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            if (!z) {
                i = i2;
            } else {
                i = length;
            }
            boolean a2 = CharsKt__CharJVMKt.a(str.charAt(i));
            if (!z) {
                if (!a2) {
                    z = true;
                } else {
                    i2++;
                }
            } else if (!a2) {
                break;
            } else {
                length--;
            }
        }
        return str.subSequence(i2, length + 1);
    }

    public static String R(String str) {
        int i;
        Comparable comparable;
        int i2;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter("", "newIndent");
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str, "<this>");
        List l = SequencesKt.l(new StringsKt__StringsKt$lineSequence$$inlined$Sequence$1(str));
        ArrayList arrayList = new ArrayList();
        for (Object next : l) {
            if (!t((String) next)) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.h(arrayList));
        Iterator it = arrayList.iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            String str2 = (String) it.next();
            int length = str2.length();
            while (true) {
                if (i >= length) {
                    i = -1;
                    break;
                } else if (!CharsKt__CharJVMKt.a(str2.charAt(i))) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                i = str2.length();
            }
            arrayList2.add(Integer.valueOf(i));
        }
        Intrinsics.checkNotNullParameter(arrayList2, "<this>");
        Iterator it2 = arrayList2.iterator();
        if (!it2.hasNext()) {
            comparable = null;
        } else {
            comparable = (Comparable) it2.next();
            while (it2.hasNext()) {
                Comparable comparable2 = (Comparable) it2.next();
                if (comparable.compareTo(comparable2) > 0) {
                    comparable = comparable2;
                }
            }
        }
        Integer num = (Integer) comparable;
        if (num != null) {
            i2 = num.intValue();
        } else {
            i2 = 0;
        }
        int length2 = str.length();
        l.size();
        int n = CollectionsKt.n(l);
        ArrayList arrayList3 = new ArrayList();
        for (Object next2 : l) {
            int i3 = i + 1;
            if (i >= 0) {
                String str3 = (String) next2;
                if ((i == 0 || i == n) && t(str3)) {
                    str3 = null;
                } else {
                    Intrinsics.checkNotNullParameter(str3, "<this>");
                    if (i2 >= 0) {
                        int length3 = str3.length();
                        if (i2 <= length3) {
                            length3 = i2;
                        }
                        String substring = str3.substring(length3);
                        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                        if (substring != null) {
                            Intrinsics.checkNotNullParameter(substring, "line");
                            str3 = substring;
                        }
                    } else {
                        throw new IllegalArgumentException(ba.l(i2, "Requested character count ", " is less than zero.").toString());
                    }
                }
                if (str3 != null) {
                    arrayList3.add(str3);
                }
                i = i3;
            } else {
                CollectionsKt.C();
                throw null;
            }
        }
        StringBuilder sb = new StringBuilder(length2);
        CollectionsKt___CollectionsKt.d(arrayList3, sb, StringUtils.LF, "", "", -1, "...", (Function1) null);
        return sb.toString();
    }

    public static String S(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter("|", "marginPrefix");
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter("", "newIndent");
        Intrinsics.checkNotNullParameter("|", "marginPrefix");
        if (!t("|")) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            Intrinsics.checkNotNullParameter(str, "<this>");
            List l = SequencesKt.l(new StringsKt__StringsKt$lineSequence$$inlined$Sequence$1(str));
            int length = str.length();
            l.size();
            int n = CollectionsKt.n(l);
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (Object next : l) {
                int i2 = i + 1;
                String str2 = null;
                if (i >= 0) {
                    String str3 = (String) next;
                    if (!(i == 0 || i == n) || !t(str3)) {
                        int length2 = str3.length();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length2) {
                                i3 = -1;
                                break;
                            } else if (!CharsKt__CharJVMKt.a(str3.charAt(i3))) {
                                break;
                            } else {
                                i3++;
                            }
                        }
                        if (i3 != -1 && H(str3, "|", i3, false)) {
                            str2 = str3.substring("|".length() + i3);
                            Intrinsics.checkNotNullExpressionValue(str2, "substring(...)");
                        }
                        if (str2 != null) {
                            Intrinsics.checkNotNullParameter(str2, "line");
                        } else {
                            str2 = str3;
                        }
                    }
                    if (str2 != null) {
                        arrayList.add(str2);
                    }
                    i = i2;
                } else {
                    CollectionsKt.C();
                    throw null;
                }
            }
            StringBuilder sb = new StringBuilder(length);
            CollectionsKt___CollectionsKt.d(arrayList, sb, StringUtils.LF, "", "", -1, "...", (Function1) null);
            return sb.toString();
        }
        throw new IllegalArgumentException("marginPrefix must be non-blank string.");
    }

    public static void j(StringBuilder sb, Object obj, Function1 function1) {
        boolean z;
        Intrinsics.checkNotNullParameter(sb, "<this>");
        if (function1 != null) {
            sb.append((CharSequence) function1.invoke(obj));
            return;
        }
        if (obj == null) {
            z = true;
        } else {
            z = obj instanceof CharSequence;
        }
        if (z) {
            sb.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            sb.append(((Character) obj).charValue());
        } else {
            sb.append(obj.toString());
        }
    }

    public static ArrayList k(String str) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str, "<this>");
        l4 l4Var = new l4(5);
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(l4Var, "transform");
        int length = str.length();
        int i3 = length / 4;
        int i4 = 0;
        if (length % 4 == 0) {
            i = 0;
        } else {
            i = 1;
        }
        ArrayList arrayList = new ArrayList(i3 + i);
        while (i4 >= 0 && i4 < length) {
            int i5 = i4 + 4;
            if (i5 < 0 || i5 > length) {
                i2 = length;
            } else {
                i2 = i5;
            }
            arrayList.add(l4Var.invoke(str.subSequence(i4, i2)));
            i4 = i5;
        }
        return arrayList;
    }

    public static String l(char[] cArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        AbstractList.Companion companion = AbstractList.Companion;
        int length = cArr.length;
        companion.getClass();
        AbstractList.Companion.a(i, i2, length);
        return new String(cArr, i, i2 - i);
    }

    public static boolean m(CharSequence charSequence, char c) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (r(charSequence, c, 0, false, 2) >= 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0018 A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean n(java.lang.String r9, java.lang.String r10) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "other"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            boolean r0 = r10 instanceof java.lang.String
            r1 = 0
            r6 = 0
            r8 = 1
            if (r0 == 0) goto L_0x001a
            r0 = 2
            int r9 = s(r9, r10, r1, r6, r0)
            if (r9 < 0) goto L_0x0029
        L_0x0018:
            r1 = 1
            goto L_0x0029
        L_0x001a:
            int r5 = r9.length()
            r7 = 0
            r4 = 0
            r2 = r9
            r3 = r10
            int r9 = kotlin.text.StringsKt__StringsKt.e(r2, r3, r4, r5, r6, r7)
            if (r9 < 0) goto L_0x0029
            goto L_0x0018
        L_0x0029:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt.n(java.lang.String, java.lang.String):boolean");
    }

    public static String o(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return new String(bArr, Charsets.UTF_8);
    }

    public static boolean p(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "suffix");
        if (!z) {
            return str.endsWith(str2);
        }
        return StringsKt__StringsJVMKt.a(str, str.length() - str2.length(), true, str2, 0, str2.length());
    }

    public static boolean q(String str, String str2, boolean z) {
        if (str == null) {
            if (str2 == null) {
                return true;
            }
            return false;
        } else if (!z) {
            return str.equals(str2);
        } else {
            return str.equalsIgnoreCase(str2);
        }
    }

    public static int r(CharSequence charSequence, char c, int i, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c, i);
        }
        return StringsKt__StringsKt.f(charSequence, new char[]{c}, i, z);
    }

    public static /* synthetic */ int s(CharSequence charSequence, String str, int i, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt__StringsKt.d(i, charSequence, str, z);
    }

    public static boolean t(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        for (int i = 0; i < charSequence.length(); i++) {
            if (!CharsKt__CharJVMKt.a(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static char u(StringBuilder sb) {
        Intrinsics.checkNotNullParameter(sb, "<this>");
        if (sb.length() != 0) {
            return sb.charAt(StringsKt__StringsKt.c(sb));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static int v(int i, String str, String str2) {
        int i2;
        if ((i & 2) != 0) {
            i2 = StringsKt__StringsKt.c(str);
        } else {
            i2 = 0;
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, TypedValues.Custom.S_STRING);
        if (!(str instanceof String)) {
            return StringsKt__StringsKt.e(str, str2, i2, 0, false, true);
        }
        return str.lastIndexOf(str2, i2);
    }

    public static int w(String str, char c, int i, int i2) {
        if ((i2 & 2) != 0) {
            i = StringsKt__StringsKt.c(str);
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str instanceof String) {
            return str.lastIndexOf(c, i);
        }
        char[] cArr = {c};
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "chars");
        if (str instanceof String) {
            return str.lastIndexOf(ArraysKt.w(cArr), i);
        }
        int c2 = StringsKt__StringsKt.c(str);
        if (i > c2) {
            i = c2;
        }
        while (-1 < i) {
            if (CharsKt__CharKt.b(cArr[0], str.charAt(i), false)) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public static String x(int i, String str) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (i >= 0) {
            if (i <= str.length()) {
                charSequence = str.subSequence(0, str.length());
            } else {
                StringBuilder sb = new StringBuilder(i);
                int length = i - str.length();
                int i2 = 1;
                if (1 <= length) {
                    while (true) {
                        sb.append('0');
                        if (i2 == length) {
                            break;
                        }
                        i2++;
                    }
                }
                sb.append(str);
                charSequence = sb;
            }
            return charSequence.toString();
        }
        throw new IllegalArgumentException(ba.l(i, "Desired length ", " is less than zero."));
    }

    public static String z(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "prefix");
        if (!J(str, str2)) {
            return str;
        }
        String substring = str.substring(str2.length());
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }
}
