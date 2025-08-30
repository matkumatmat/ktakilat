package org.apache.commons.lang3;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import org.apache.commons.lang3.function.ToBooleanBiFunction;

public class StringUtils {
    public static final String CR = "\r";
    public static final String EMPTY = "";
    public static final int INDEX_NOT_FOUND = -1;
    public static final String LF = "\n";
    private static final int PAD_LIMIT = 8192;
    public static final String SPACE = " ";
    private static final int STRING_BUILDER_SIZE = 256;
    private static final Pattern STRIP_ACCENTS_PATTERN = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");

    public static String abbreviate(String str, int i) {
        return abbreviate(str, "...", 0, i);
    }

    public static String abbreviateMiddle(String str, String str2, int i) {
        if (isAnyEmpty(str, str2) || i >= str.length() || i < str2.length() + 2) {
            return str;
        }
        int length = i - str2.length();
        int i2 = length / 2;
        int i3 = (length % 2) + i2;
        int length2 = str.length() - i2;
        return str.substring(0, i3) + str2 + str.substring(length2);
    }

    private static String appendIfMissing(String str, CharSequence charSequence, boolean z, CharSequence... charSequenceArr) {
        if (str == null || isEmpty(charSequence) || endsWith(str, charSequence, z)) {
            return str;
        }
        if (ArrayUtils.isNotEmpty((T[]) charSequenceArr)) {
            for (CharSequence endsWith : charSequenceArr) {
                if (endsWith(str, endsWith, z)) {
                    return str;
                }
            }
        }
        StringBuilder v = ba.v(str);
        v.append(charSequence.toString());
        return v.toString();
    }

    public static String appendIfMissingIgnoreCase(String str, CharSequence charSequence, CharSequence... charSequenceArr) {
        return appendIfMissing(str, charSequence, true, charSequenceArr);
    }

    public static String capitalize(String str) {
        int codePointAt;
        int titleCase;
        int length = length(str);
        if (length == 0 || (codePointAt = str.codePointAt(0)) == (titleCase = Character.toTitleCase(codePointAt))) {
            return str;
        }
        int[] iArr = new int[length];
        iArr[0] = titleCase;
        int charCount = Character.charCount(codePointAt);
        int i = 1;
        while (charCount < length) {
            int codePointAt2 = str.codePointAt(charCount);
            iArr[i] = codePointAt2;
            charCount += Character.charCount(codePointAt2);
            i++;
        }
        return new String(iArr, 0, i);
    }

    public static String center(String str, int i) {
        return center(str, i, ' ');
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0037, code lost:
        if (r5 != 13) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String chomp(java.lang.String r6) {
        /*
            boolean r0 = isEmpty(r6)
            if (r0 == 0) goto L_0x0007
            return r6
        L_0x0007:
            int r0 = r6.length()
            r1 = 10
            r2 = 0
            r3 = 1
            r4 = 13
            if (r0 != r3) goto L_0x0020
            char r0 = r6.charAt(r2)
            if (r0 == r4) goto L_0x001d
            if (r0 != r1) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            return r6
        L_0x001d:
            java.lang.String r6 = ""
            return r6
        L_0x0020:
            int r0 = r6.length()
            int r3 = r0 + -1
            char r5 = r6.charAt(r3)
            if (r5 != r1) goto L_0x0037
            int r1 = r0 + -2
            char r1 = r6.charAt(r1)
            if (r1 != r4) goto L_0x003a
            int r0 = r0 + -2
            goto L_0x003b
        L_0x0037:
            if (r5 == r4) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            r0 = r3
        L_0x003b:
            java.lang.String r6 = r6.substring(r2, r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.StringUtils.chomp(java.lang.String):java.lang.String");
    }

    public static String chop(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length < 2) {
            return "";
        }
        int i = length - 1;
        String substring = str.substring(0, i);
        if (str.charAt(i) == 10) {
            int i2 = length - 2;
            if (substring.charAt(i2) == 13) {
                return substring.substring(0, i2);
            }
        }
        return substring;
    }

    public static int compare(String str, String str2) {
        return compare(str, str2, true);
    }

    public static int compareIgnoreCase(String str, String str2) {
        return compareIgnoreCase(str, str2, true);
    }

    public static boolean contains(CharSequence charSequence, CharSequence charSequence2) {
        return (charSequence == null || charSequence2 == null || CharSequenceUtils.indexOf(charSequence, charSequence2, 0) < 0) ? false : true;
    }

    public static boolean containsAny(CharSequence charSequence, char... cArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty(cArr)) {
            int length = charSequence.length();
            int length2 = cArr.length;
            int i = length - 1;
            int i2 = length2 - 1;
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = charSequence.charAt(i3);
                for (int i4 = 0; i4 < length2; i4++) {
                    if (cArr[i4] == charAt) {
                        if (!Character.isHighSurrogate(charAt) || i4 == i2) {
                            return true;
                        }
                        if (i3 < i && cArr[i4 + 1] == charSequence.charAt(i3 + 1)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean containsAnyIgnoreCase(CharSequence charSequence, CharSequence... charSequenceArr) {
        return containsAny(new t9(14), charSequence, charSequenceArr);
    }

    public static boolean containsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        if (!(charSequence == null || charSequence2 == null)) {
            int length = charSequence2.length();
            int length2 = charSequence.length() - length;
            for (int i = 0; i <= length2; i++) {
                if (CharSequenceUtils.regionMatches(charSequence, true, i, charSequence2, 0, length)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsNone(CharSequence charSequence, char... cArr) {
        if (!(charSequence == null || cArr == null)) {
            int length = charSequence.length();
            int i = length - 1;
            int length2 = cArr.length;
            int i2 = length2 - 1;
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = charSequence.charAt(i3);
                for (int i4 = 0; i4 < length2; i4++) {
                    if (cArr[i4] == charAt) {
                        if (!Character.isHighSurrogate(charAt) || i4 == i2) {
                            return false;
                        }
                        if (i3 < i && cArr[i4 + 1] == charSequence.charAt(i3 + 1)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean containsOnly(CharSequence charSequence, char... cArr) {
        if (cArr == null || charSequence == null) {
            return false;
        }
        if (charSequence.length() == 0) {
            return true;
        }
        if (cArr.length != 0 && indexOfAnyBut(charSequence, cArr) == -1) {
            return true;
        }
        return false;
    }

    public static boolean containsWhitespace(CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (Character.isWhitespace(charSequence.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static void convertRemainingAccentCharacters(StringBuilder sb) {
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == 321) {
                sb.setCharAt(i, 'L');
            } else if (sb.charAt(i) == 322) {
                sb.setCharAt(i, 'l');
            }
        }
    }

    public static int countMatches(CharSequence charSequence, char c) {
        if (isEmpty(charSequence)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            if (c == charSequence.charAt(i2)) {
                i++;
            }
        }
        return i;
    }

    public static <T extends CharSequence> T defaultIfBlank(T t, T t2) {
        if (isBlank(t)) {
            return t2;
        }
        return t;
    }

    public static <T extends CharSequence> T defaultIfEmpty(T t, T t2) {
        if (isEmpty(t)) {
            return t2;
        }
        return t;
    }

    public static String defaultString(String str, String str2) {
        return str == null ? str2 : str;
    }

    public static String deleteWhitespace(String str) {
        if (isEmpty(str)) {
            return str;
        }
        int length = str.length();
        char[] cArr = new char[length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isWhitespace(str.charAt(i2))) {
                cArr[i] = str.charAt(i2);
                i++;
            }
        }
        if (i == length) {
            return str;
        }
        if (i == 0) {
            return "";
        }
        return new String(cArr, 0, i);
    }

    public static String difference(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        int indexOfDifference = indexOfDifference(str, str2);
        if (indexOfDifference == -1) {
            return "";
        }
        return str2.substring(indexOfDifference);
    }

    public static boolean endsWith(CharSequence charSequence, CharSequence charSequence2) {
        return endsWith(charSequence, charSequence2, false);
    }

    public static boolean endsWithAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty((Object[]) charSequenceArr)) {
            for (CharSequence endsWith : charSequenceArr) {
                if (endsWith(charSequence, endsWith)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean endsWithIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return endsWith(charSequence, charSequence2, true);
    }

    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return charSequence.equals(charSequence2);
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean equalsAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (ArrayUtils.isNotEmpty((T[]) charSequenceArr)) {
            for (CharSequence equals : charSequenceArr) {
                if (equals(charSequence, equals)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean equalsAnyIgnoreCase(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (ArrayUtils.isNotEmpty((T[]) charSequenceArr)) {
            for (CharSequence equalsIgnoreCase : charSequenceArr) {
                if (equalsIgnoreCase(charSequence, equalsIgnoreCase)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean equalsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        return CharSequenceUtils.regionMatches(charSequence, true, 0, charSequence2, 0, charSequence.length());
    }

    @SafeVarargs
    public static <T extends CharSequence> T firstNonBlank(T... tArr) {
        if (tArr == null) {
            return null;
        }
        for (T t : tArr) {
            if (isNotBlank(t)) {
                return t;
            }
        }
        return null;
    }

    @SafeVarargs
    public static <T extends CharSequence> T firstNonEmpty(T... tArr) {
        if (tArr == null) {
            return null;
        }
        for (T t : tArr) {
            if (isNotEmpty(t)) {
                return t;
            }
        }
        return null;
    }

    public static byte[] getBytes(String str, Charset charset) {
        return str == null ? ArrayUtils.EMPTY_BYTE_ARRAY : str.getBytes(Charsets.toCharset(charset));
    }

    public static String getCommonPrefix(String... strArr) {
        if (ArrayUtils.isEmpty((Object[]) strArr)) {
            return "";
        }
        int indexOfDifference = indexOfDifference(strArr);
        if (indexOfDifference == -1) {
            String str = strArr[0];
            if (str == null) {
                return "";
            }
            return str;
        } else if (indexOfDifference == 0) {
            return "";
        } else {
            return strArr[0].substring(0, indexOfDifference);
        }
    }

    public static String getDigits(String str) {
        if (isEmpty(str)) {
            return str;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Character.isDigit(charAt)) {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    @Deprecated
    public static int getFuzzyDistance(CharSequence charSequence, CharSequence charSequence2, Locale locale) {
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        } else if (locale != null) {
            String lowerCase = charSequence.toString().toLowerCase(locale);
            String lowerCase2 = charSequence2.toString().toLowerCase(locale);
            int i = Integer.MIN_VALUE;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < lowerCase2.length(); i4++) {
                char charAt = lowerCase2.charAt(i4);
                boolean z = false;
                while (i3 < lowerCase.length() && !z) {
                    if (charAt == lowerCase.charAt(i3)) {
                        int i5 = i2 + 1;
                        if (i + 1 == i3) {
                            i5 = i2 + 3;
                        }
                        i = i3;
                        i2 = i5;
                        z = true;
                    }
                    i3++;
                }
            }
            return i2;
        } else {
            throw new IllegalArgumentException("Locale must not be null");
        }
    }

    public static <T extends CharSequence> T getIfBlank(T t, Supplier<T> supplier) {
        if (!isBlank(t)) {
            return t;
        }
        if (supplier == null) {
            return null;
        }
        return (CharSequence) supplier.get();
    }

    public static <T extends CharSequence> T getIfEmpty(T t, Supplier<T> supplier) {
        if (!isEmpty(t)) {
            return t;
        }
        if (supplier == null) {
            return null;
        }
        return (CharSequence) supplier.get();
    }

    @Deprecated
    public static double getJaroWinklerDistance(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }
        int[] matches = matches(charSequence, charSequence2);
        double d = (double) matches[0];
        if (d == 0.0d) {
            return 0.0d;
        }
        double length = (((d - ((double) matches[1])) / d) + ((d / ((double) charSequence2.length())) + (d / ((double) charSequence.length())))) / 3.0d;
        if (length >= 0.7d) {
            length += (1.0d - length) * Math.min(0.1d, 1.0d / ((double) matches[3])) * ((double) matches[2]);
        }
        return ((double) Math.round(length * 100.0d)) / 100.0d;
    }

    @Deprecated
    public static int getLevenshteinDistance(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }
        int length = charSequence.length();
        int length2 = charSequence2.length();
        if (length == 0) {
            return length2;
        }
        if (length2 == 0) {
            return length;
        }
        if (length > length2) {
            int i = length2;
            length2 = charSequence.length();
            length = i;
        } else {
            CharSequence charSequence3 = charSequence2;
            charSequence2 = charSequence;
            charSequence = charSequence3;
        }
        int[] iArr = new int[(length + 1)];
        for (int i2 = 0; i2 <= length; i2++) {
            iArr[i2] = i2;
        }
        for (int i3 = 1; i3 <= length2; i3++) {
            int i4 = iArr[0];
            char charAt = charSequence.charAt(i3 - 1);
            iArr[0] = i3;
            int i5 = 1;
            while (i5 <= length) {
                int i6 = iArr[i5];
                int i7 = i5 - 1;
                iArr[i5] = Math.min(Math.min(iArr[i7] + 1, iArr[i5] + 1), i4 + (charSequence2.charAt(i7) == charAt ? 0 : 1));
                i5++;
                i4 = i6;
            }
        }
        return iArr[length];
    }

    public static int indexOf(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return CharSequenceUtils.indexOf(charSequence, charSequence2, 0);
    }

    public static int indexOfAny(CharSequence charSequence, char... cArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty(cArr)) {
            int length = charSequence.length();
            int i = length - 1;
            int length2 = cArr.length;
            int i2 = length2 - 1;
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = charSequence.charAt(i3);
                for (int i4 = 0; i4 < length2; i4++) {
                    if (cArr[i4] == charAt && (i3 >= i || i4 >= i2 || !Character.isHighSurrogate(charAt) || cArr[i4 + 1] == charSequence.charAt(i3 + 1))) {
                        return i3;
                    }
                }
            }
        }
        return -1;
    }

    public static int indexOfAnyBut(CharSequence charSequence, char... cArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty(cArr)) {
            int length = charSequence.length();
            int i = length - 1;
            int length2 = cArr.length;
            int i2 = length2 - 1;
            int i3 = 0;
            while (i3 < length) {
                char charAt = charSequence.charAt(i3);
                int i4 = 0;
                while (i4 < length2) {
                    if (cArr[i4] != charAt || (i3 < i && i4 < i2 && Character.isHighSurrogate(charAt) && cArr[i4 + 1] != charSequence.charAt(i3 + 1))) {
                        i4++;
                    } else {
                        i3++;
                    }
                }
                return i3;
            }
        }
        return -1;
    }

    public static int indexOfDifference(CharSequence... charSequenceArr) {
        if (ArrayUtils.getLength(charSequenceArr) <= 1) {
            return -1;
        }
        int length = charSequenceArr.length;
        int i = Integer.MAX_VALUE;
        boolean z = true;
        int i2 = 0;
        boolean z2 = false;
        for (CharSequence charSequence : charSequenceArr) {
            if (charSequence == null) {
                i = 0;
                z2 = true;
            } else {
                i = Math.min(charSequence.length(), i);
                i2 = Math.max(charSequence.length(), i2);
                z = false;
            }
        }
        if (z || (i2 == 0 && !z2)) {
            return -1;
        }
        if (i == 0) {
            return 0;
        }
        int i3 = -1;
        for (int i4 = 0; i4 < i; i4++) {
            char charAt = charSequenceArr[0].charAt(i4);
            int i5 = 1;
            while (true) {
                if (i5 >= length) {
                    break;
                } else if (charSequenceArr[i5].charAt(i4) != charAt) {
                    i3 = i4;
                    break;
                } else {
                    i5++;
                }
            }
            if (i3 != -1) {
                break;
            }
        }
        return (i3 != -1 || i == i2) ? i3 : i;
    }

    public static int indexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return indexOfIgnoreCase(charSequence, charSequence2, 0);
    }

    public static boolean isAllBlank(CharSequence... charSequenceArr) {
        if (ArrayUtils.isEmpty((Object[]) charSequenceArr)) {
            return true;
        }
        for (CharSequence isNotBlank : charSequenceArr) {
            if (isNotBlank(isNotBlank)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllEmpty(CharSequence... charSequenceArr) {
        if (ArrayUtils.isEmpty((Object[]) charSequenceArr)) {
            return true;
        }
        for (CharSequence isNotEmpty : charSequenceArr) {
            if (isNotEmpty(isNotEmpty)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllLowerCase(CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isLowerCase(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllUpperCase(CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isUpperCase(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlpha(CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isLetter(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphaSpace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            char charAt = charSequence.charAt(i);
            if (charAt != ' ' && !Character.isLetter(charAt)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphanumeric(CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isLetterOrDigit(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphanumericSpace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            char charAt = charSequence.charAt(i);
            if (charAt != ' ' && !Character.isLetterOrDigit(charAt)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnyBlank(CharSequence... charSequenceArr) {
        if (ArrayUtils.isEmpty((Object[]) charSequenceArr)) {
            return false;
        }
        for (CharSequence isBlank : charSequenceArr) {
            if (isBlank(isBlank)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAnyEmpty(CharSequence... charSequenceArr) {
        if (ArrayUtils.isEmpty((Object[]) charSequenceArr)) {
            return false;
        }
        for (CharSequence isEmpty : charSequenceArr) {
            if (isEmpty(isEmpty)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAsciiPrintable(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!CharUtils.isAsciiPrintable(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isBlank(CharSequence charSequence) {
        int length = length(charSequence);
        if (length == 0) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEmpty(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isMixedCase(CharSequence charSequence) {
        if (isEmpty(charSequence) || charSequence.length() == 1) {
            return false;
        }
        int length = charSequence.length();
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < length; i++) {
            if (z && z2) {
                return true;
            }
            if (Character.isUpperCase(charSequence.charAt(i))) {
                z = true;
            } else if (Character.isLowerCase(charSequence.charAt(i))) {
                z2 = true;
            }
        }
        if (!z || !z2) {
            return false;
        }
        return true;
    }

    public static boolean isNoneBlank(CharSequence... charSequenceArr) {
        return !isAnyBlank(charSequenceArr);
    }

    public static boolean isNoneEmpty(CharSequence... charSequenceArr) {
        return !isAnyEmpty(charSequenceArr);
    }

    public static boolean isNotBlank(CharSequence charSequence) {
        return !isBlank(charSequence);
    }

    public static boolean isNotEmpty(CharSequence charSequence) {
        return !isEmpty(charSequence);
    }

    public static boolean isNumeric(CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumericSpace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            char charAt = charSequence.charAt(i);
            if (charAt != ' ' && !Character.isDigit(charAt)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isWhitespace(CharSequence charSequence) {
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String join(boolean[] zArr, char c) {
        if (zArr == null) {
            return null;
        }
        return join(zArr, c, 0, zArr.length);
    }

    public static String joinWith(String str, Object... objArr) {
        if (objArr != null) {
            return join(objArr, str);
        }
        throw new IllegalArgumentException("Object varargs must not be null");
    }

    public static int lastIndexOf(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null) {
            return -1;
        }
        return CharSequenceUtils.lastIndexOf(charSequence, charSequence2, charSequence.length());
    }

    public static int lastIndexOfAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        int lastIndexOf;
        int i = -1;
        if (!(charSequence == null || charSequenceArr == null)) {
            for (CharSequence charSequence2 : charSequenceArr) {
                if (charSequence2 != null && (lastIndexOf = CharSequenceUtils.lastIndexOf(charSequence, charSequence2, charSequence.length())) > i) {
                    i = lastIndexOf;
                }
            }
        }
        return i;
    }

    public static int lastIndexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return lastIndexOfIgnoreCase(charSequence, charSequence2, charSequence.length());
    }

    public static int lastOrdinalIndexOf(CharSequence charSequence, CharSequence charSequence2, int i) {
        return ordinalIndexOf(charSequence, charSequence2, i, true);
    }

    public static String left(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i < 0) {
            return "";
        }
        if (str.length() <= i) {
            return str;
        }
        return str.substring(0, i);
    }

    public static String leftPad(String str, int i) {
        return leftPad(str, i, ' ');
    }

    public static int length(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        return charSequence.length();
    }

    public static String lowerCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase();
    }

    private static int[] matches(CharSequence charSequence, CharSequence charSequence2) {
        CharSequence charSequence3;
        CharSequence charSequence4;
        if (charSequence.length() > charSequence2.length()) {
            charSequence4 = charSequence;
            charSequence3 = charSequence2;
        } else {
            charSequence3 = charSequence;
            charSequence4 = charSequence2;
        }
        int i = 0;
        int max = Math.max((charSequence4.length() / 2) - 1, 0);
        int[] iArr = new int[charSequence3.length()];
        Arrays.fill(iArr, -1);
        boolean[] zArr = new boolean[charSequence4.length()];
        int i2 = 0;
        for (int i3 = 0; i3 < charSequence3.length(); i3++) {
            char charAt = charSequence3.charAt(i3);
            int max2 = Math.max(i3 - max, 0);
            int min = Math.min(i3 + max + 1, charSequence4.length());
            while (true) {
                if (max2 < min) {
                    if (!zArr[max2] && charAt == charSequence4.charAt(max2)) {
                        iArr[i3] = max2;
                        zArr[max2] = true;
                        i2++;
                        break;
                    }
                    max2++;
                } else {
                    break;
                }
            }
        }
        char[] cArr = new char[i2];
        char[] cArr2 = new char[i2];
        int i4 = 0;
        for (int i5 = 0; i5 < charSequence3.length(); i5++) {
            if (iArr[i5] != -1) {
                cArr[i4] = charSequence3.charAt(i5);
                i4++;
            }
        }
        int i6 = 0;
        for (int i7 = 0; i7 < charSequence4.length(); i7++) {
            if (zArr[i7]) {
                cArr2[i6] = charSequence4.charAt(i7);
                i6++;
            }
        }
        int i8 = 0;
        for (int i9 = 0; i9 < i2; i9++) {
            if (cArr[i9] != cArr2[i9]) {
                i8++;
            }
        }
        int i10 = 0;
        while (i < charSequence3.length() && charSequence.charAt(i) == charSequence2.charAt(i)) {
            i10++;
            i++;
        }
        return new int[]{i2, i8 / 2, i10, charSequence4.length()};
    }

    public static String mid(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        if (i2 < 0 || i > str.length()) {
            return "";
        }
        if (i < 0) {
            i = 0;
        }
        int i3 = i2 + i;
        if (str.length() <= i3) {
            return str.substring(i);
        }
        return str.substring(i, i3);
    }

    private static StringJoiner newStringJoiner(char c) {
        cd.r();
        return cd.n(String.valueOf(c));
    }

    public static String normalizeSpace(String str) {
        if (isEmpty(str)) {
            return str;
        }
        int length = str.length();
        char[] cArr = new char[length];
        int i = 1;
        boolean z = true;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            if (Character.isWhitespace(charAt)) {
                if (i3 == 0 && !z) {
                    cArr[i2] = SPACE.charAt(0);
                    i2++;
                }
                i3++;
            } else {
                int i5 = i2 + 1;
                if (charAt == 160) {
                    charAt = ' ';
                }
                cArr[i2] = charAt;
                i2 = i5;
                z = false;
                i3 = 0;
            }
        }
        if (z) {
            return "";
        }
        if (i3 <= 0) {
            i = 0;
        }
        return new String(cArr, 0, i2 - i).trim();
    }

    public static int ordinalIndexOf(CharSequence charSequence, CharSequence charSequence2, int i) {
        return ordinalIndexOf(charSequence, charSequence2, i, false);
    }

    public static String overlay(String str, String str2, int i, int i2) {
        if (str == null) {
            return null;
        }
        if (str2 == null) {
            str2 = "";
        }
        int length = str.length();
        if (i < 0) {
            i = 0;
        }
        if (i > length) {
            i = length;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 <= length) {
            length = i2;
        }
        if (i > length) {
            int i3 = length;
            length = i;
            i = i3;
        }
        return str.substring(0, i) + str2 + str.substring(length);
    }

    private static String prependIfMissing(String str, CharSequence charSequence, boolean z, CharSequence... charSequenceArr) {
        if (str == null || isEmpty(charSequence) || startsWith(str, charSequence, z)) {
            return str;
        }
        if (ArrayUtils.isNotEmpty((T[]) charSequenceArr)) {
            for (CharSequence startsWith : charSequenceArr) {
                if (startsWith(str, startsWith, z)) {
                    return str;
                }
            }
        }
        return charSequence.toString() + str;
    }

    public static String prependIfMissingIgnoreCase(String str, CharSequence charSequence, CharSequence... charSequenceArr) {
        return prependIfMissing(str, charSequence, true, charSequenceArr);
    }

    public static String remove(String str, char c) {
        if (isEmpty(str) || str.indexOf(c) == -1) {
            return str;
        }
        char[] charArray = str.toCharArray();
        int i = 0;
        for (char c2 : charArray) {
            if (c2 != c) {
                charArray[i] = c2;
                i++;
            }
        }
        return new String(charArray, 0, i);
    }

    @Deprecated
    public static String removeAll(String str, String str2) {
        return RegExUtils.removeAll(str, str2);
    }

    public static String removeEnd(String str, String str2) {
        if (isEmpty(str) || isEmpty(str2) || !str.endsWith(str2)) {
            return str;
        }
        return str.substring(0, str.length() - str2.length());
    }

    public static String removeEndIgnoreCase(String str, String str2) {
        if (isEmpty(str) || isEmpty(str2) || !endsWithIgnoreCase(str, str2)) {
            return str;
        }
        return str.substring(0, str.length() - str2.length());
    }

    @Deprecated
    public static String removeFirst(String str, String str2) {
        return replaceFirst(str, str2, "");
    }

    public static String removeIgnoreCase(String str, String str2) {
        return replaceIgnoreCase(str, str2, "", -1);
    }

    @Deprecated
    public static String removePattern(String str, String str2) {
        return RegExUtils.removePattern(str, str2);
    }

    public static String removeStart(String str, String str2) {
        if (isEmpty(str) || isEmpty(str2) || !str.startsWith(str2)) {
            return str;
        }
        return str.substring(str2.length());
    }

    public static String removeStartIgnoreCase(String str, String str2) {
        if (str == null || !startsWithIgnoreCase(str, str2)) {
            return str;
        }
        return str.substring(length(str2));
    }

    public static String repeat(char c, int i) {
        if (i <= 0) {
            return "";
        }
        char[] cArr = new char[i];
        Arrays.fill(cArr, c);
        return new String(cArr);
    }

    public static String replace(String str, String str2, String str3) {
        return replace(str, str2, str3, -1);
    }

    @Deprecated
    public static String replaceAll(String str, String str2, String str3) {
        return RegExUtils.replaceAll(str, str2, str3);
    }

    public static String replaceChars(String str, char c, char c2) {
        if (str == null) {
            return null;
        }
        return str.replace(c, c2);
    }

    public static String replaceEach(String str, String[] strArr, String[] strArr2) {
        return replaceEach(str, strArr, strArr2, false, 0);
    }

    public static String replaceEachRepeatedly(String str, String[] strArr, String[] strArr2) {
        int i;
        if (strArr == null) {
            i = 0;
        } else {
            i = strArr.length;
        }
        return replaceEach(str, strArr, strArr2, true, i);
    }

    @Deprecated
    public static String replaceFirst(String str, String str2, String str3) {
        return RegExUtils.replaceFirst(str, str2, str3);
    }

    public static String replaceIgnoreCase(String str, String str2, String str3) {
        return replaceIgnoreCase(str, str2, str3, -1);
    }

    public static String replaceOnce(String str, String str2, String str3) {
        return replace(str, str2, str3, 1);
    }

    public static String replaceOnceIgnoreCase(String str, String str2, String str3) {
        return replaceIgnoreCase(str, str2, str3, 1);
    }

    @Deprecated
    public static String replacePattern(String str, String str2, String str3) {
        return RegExUtils.replacePattern(str, str2, str3);
    }

    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }

    public static String reverseDelimited(String str, char c) {
        if (str == null) {
            return null;
        }
        String[] split = split(str, c);
        ArrayUtils.reverse((Object[]) split);
        return join((Object[]) split, c);
    }

    public static String right(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i < 0) {
            return "";
        }
        if (str.length() <= i) {
            return str;
        }
        return str.substring(str.length() - i);
    }

    public static String rightPad(String str, int i) {
        return rightPad(str, i, ' ');
    }

    public static String rotate(String str, int i) {
        int i2;
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (i == 0 || length == 0 || (i2 = i % length) == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder(length);
        int i3 = -i2;
        sb.append(substring(str, i3));
        sb.append(substring(str, 0, i3));
        return sb.toString();
    }

    public static String[] split(String str) {
        return split(str, (String) null, -1);
    }

    public static String[] splitByCharacterType(String str) {
        return splitByCharacterType(str, false);
    }

    public static String[] splitByCharacterTypeCamelCase(String str) {
        return splitByCharacterType(str, true);
    }

    public static String[] splitByWholeSeparator(String str, String str2) {
        return splitByWholeSeparatorWorker(str, str2, -1, false);
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String str2) {
        return splitByWholeSeparatorWorker(str, str2, -1, true);
    }

    private static String[] splitByWholeSeparatorWorker(String str, String str2, int i, boolean z) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        if (str2 == null || "".equals(str2)) {
            return splitWorker(str, (String) null, i, z);
        }
        int length2 = str2.length();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            i2 = str.indexOf(str2, i3);
            if (i2 > -1) {
                if (i2 > i3) {
                    i4++;
                    if (i4 == i) {
                        arrayList.add(str.substring(i3));
                    } else {
                        arrayList.add(str.substring(i3, i2));
                    }
                } else if (z) {
                    i4++;
                    if (i4 == i) {
                        arrayList.add(str.substring(i3));
                        i2 = length;
                    } else {
                        arrayList.add("");
                    }
                }
                i3 = i2 + length2;
            } else {
                arrayList.add(str.substring(i3));
            }
            i2 = length;
        }
        return (String[]) arrayList.toArray(ArrayUtils.EMPTY_STRING_ARRAY);
    }

    public static String[] splitPreserveAllTokens(String str) {
        return splitWorker(str, (String) null, -1, true);
    }

    private static String[] splitWorker(String str, char c, boolean z) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z2 = false;
        boolean z3 = false;
        int i2 = 0;
        while (i < length) {
            if (str.charAt(i) == c) {
                if (z2 || z) {
                    arrayList.add(str.substring(i2, i));
                    z2 = false;
                    z3 = true;
                }
                i2 = i + 1;
                i = i2;
            } else {
                i++;
                z2 = true;
                z3 = false;
            }
        }
        if (z2 || (z && z3)) {
            arrayList.add(str.substring(i2, i));
        }
        return (String[]) arrayList.toArray(ArrayUtils.EMPTY_STRING_ARRAY);
    }

    public static boolean startsWith(CharSequence charSequence, CharSequence charSequence2) {
        return startsWith(charSequence, charSequence2, false);
    }

    public static boolean startsWithAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty((Object[]) charSequenceArr)) {
            for (CharSequence startsWith : charSequenceArr) {
                if (startsWith(charSequence, startsWith)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean startsWithIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return startsWith(charSequence, charSequence2, true);
    }

    public static String strip(String str) {
        return strip(str, (String) null);
    }

    public static String stripAccents(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(Normalizer.normalize(str, Normalizer.Form.NFD));
        convertRemainingAccentCharacters(sb);
        return STRIP_ACCENTS_PATTERN.matcher(sb).replaceAll("");
    }

    public static String[] stripAll(String... strArr) {
        return stripAll(strArr, (String) null);
    }

    public static String stripEnd(String str, String str2) {
        int length = length(str);
        if (length == 0) {
            return str;
        }
        if (str2 == null) {
            while (length != 0 && Character.isWhitespace(str.charAt(length - 1))) {
                length--;
            }
        } else if (str2.isEmpty()) {
            return str;
        } else {
            while (length != 0 && str2.indexOf(str.charAt(length - 1)) != -1) {
                length--;
            }
        }
        return str.substring(0, length);
    }

    public static String stripStart(String str, String str2) {
        int length = length(str);
        if (length == 0) {
            return str;
        }
        int i = 0;
        if (str2 == null) {
            while (i != length && Character.isWhitespace(str.charAt(i))) {
                i++;
            }
        } else if (str2.isEmpty()) {
            return str;
        } else {
            while (i != length && str2.indexOf(str.charAt(i)) != -1) {
                i++;
            }
        }
        return str.substring(i);
    }

    public static String stripToEmpty(String str) {
        if (str == null) {
            return "";
        }
        return strip(str, (String) null);
    }

    public static String stripToNull(String str) {
        if (str == null) {
            return null;
        }
        String strip = strip(str, (String) null);
        if (strip.isEmpty()) {
            return null;
        }
        return strip;
    }

    public static String substring(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i < 0) {
            i += str.length();
        }
        if (i < 0) {
            i = 0;
        }
        if (i > str.length()) {
            return "";
        }
        return str.substring(i);
    }

    public static String substringAfter(String str, int i) {
        if (isEmpty(str)) {
            return str;
        }
        int indexOf = str.indexOf(i);
        if (indexOf == -1) {
            return "";
        }
        return str.substring(indexOf + 1);
    }

    public static String substringAfterLast(String str, int i) {
        if (isEmpty(str)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(i);
        if (lastIndexOf == -1 || lastIndexOf == str.length() - 1) {
            return "";
        }
        return str.substring(lastIndexOf + 1);
    }

    public static String substringBefore(String str, int i) {
        int indexOf;
        if (!isEmpty(str) && (indexOf = str.indexOf(i)) != -1) {
            return str.substring(0, indexOf);
        }
        return str;
    }

    public static String substringBeforeLast(String str, String str2) {
        int lastIndexOf;
        if (isEmpty(str) || isEmpty(str2) || (lastIndexOf = str.lastIndexOf(str2)) == -1) {
            return str;
        }
        return str.substring(0, lastIndexOf);
    }

    public static String substringBetween(String str, String str2) {
        return substringBetween(str, str2, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
        r5 = r5 + r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String[] substringsBetween(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            r0 = 0
            if (r7 == 0) goto L_0x0054
            boolean r1 = isEmpty(r8)
            if (r1 != 0) goto L_0x0054
            boolean r1 = isEmpty(r9)
            if (r1 == 0) goto L_0x0010
            goto L_0x0054
        L_0x0010:
            int r1 = r7.length()
            if (r1 != 0) goto L_0x0019
            java.lang.String[] r7 = org.apache.commons.lang3.ArrayUtils.EMPTY_STRING_ARRAY
            return r7
        L_0x0019:
            int r2 = r9.length()
            int r3 = r8.length()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r5 = 0
        L_0x0027:
            int r6 = r1 - r2
            if (r5 >= r6) goto L_0x0044
            int r5 = r7.indexOf(r8, r5)
            if (r5 >= 0) goto L_0x0032
            goto L_0x0044
        L_0x0032:
            int r5 = r5 + r3
            int r6 = r7.indexOf(r9, r5)
            if (r6 >= 0) goto L_0x003a
            goto L_0x0044
        L_0x003a:
            java.lang.String r5 = r7.substring(r5, r6)
            r4.add(r5)
            int r5 = r6 + r2
            goto L_0x0027
        L_0x0044:
            boolean r7 = r4.isEmpty()
            if (r7 == 0) goto L_0x004b
            return r0
        L_0x004b:
            java.lang.String[] r7 = org.apache.commons.lang3.ArrayUtils.EMPTY_STRING_ARRAY
            java.lang.Object[] r7 = r4.toArray(r7)
            java.lang.String[] r7 = (java.lang.String[]) r7
            return r7
        L_0x0054:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.StringUtils.substringsBetween(java.lang.String, java.lang.String, java.lang.String):java.lang.String[]");
    }

    public static String swapCase(String str) {
        if (isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int[] iArr = new int[length];
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (Character.isUpperCase(codePointAt) || Character.isTitleCase(codePointAt)) {
                codePointAt = Character.toLowerCase(codePointAt);
            } else if (Character.isLowerCase(codePointAt)) {
                codePointAt = Character.toUpperCase(codePointAt);
            }
            iArr[i2] = codePointAt;
            i += Character.charCount(codePointAt);
            i2++;
        }
        return new String(iArr, 0, i2);
    }

    public static int[] toCodePoints(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        if (charSequence.length() == 0) {
            return ArrayUtils.EMPTY_INT_ARRAY;
        }
        String charSequence2 = charSequence.toString();
        int codePointCount = charSequence2.codePointCount(0, charSequence2.length());
        int[] iArr = new int[codePointCount];
        int i = 0;
        for (int i2 = 0; i2 < codePointCount; i2++) {
            int codePointAt = charSequence2.codePointAt(i);
            iArr[i2] = codePointAt;
            i += Character.charCount(codePointAt);
        }
        return iArr;
    }

    public static String toEncodedString(byte[] bArr, Charset charset) {
        return new String(bArr, Charsets.toCharset(charset));
    }

    public static String toRootLowerCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase(Locale.ROOT);
    }

    public static String toRootUpperCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase(Locale.ROOT);
    }

    @Deprecated
    public static String toString(byte[] bArr, String str) throws UnsupportedEncodingException {
        return new String(bArr, Charsets.toCharset(str));
    }

    private static String toStringOrEmpty(Object obj) {
        return Objects.toString(obj, "");
    }

    public static String trim(String str) {
        if (str == null) {
            return null;
        }
        return str.trim();
    }

    public static String trimToEmpty(String str) {
        if (str == null) {
            return "";
        }
        return str.trim();
    }

    public static String trimToNull(String str) {
        String trim = trim(str);
        if (isEmpty(trim)) {
            return null;
        }
        return trim;
    }

    public static String truncate(String str, int i) {
        return truncate(str, 0, i);
    }

    public static String uncapitalize(String str) {
        int codePointAt;
        int lowerCase;
        int length = length(str);
        if (length == 0 || (codePointAt = str.codePointAt(0)) == (lowerCase = Character.toLowerCase(codePointAt))) {
            return str;
        }
        int[] iArr = new int[length];
        iArr[0] = lowerCase;
        int charCount = Character.charCount(codePointAt);
        int i = 1;
        while (charCount < length) {
            int codePointAt2 = str.codePointAt(charCount);
            iArr[i] = codePointAt2;
            charCount += Character.charCount(codePointAt2);
            i++;
        }
        return new String(iArr, 0, i);
    }

    public static String unwrap(String str, char c) {
        return (isEmpty(str) || c == 0 || str.length() == 1 || str.charAt(0) != c || str.charAt(str.length() - 1) != c) ? str : str.substring(1, str.length() - 1);
    }

    public static String upperCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase();
    }

    public static String valueOf(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return String.valueOf(cArr);
    }

    public static String wrap(String str, char c) {
        if (isEmpty(str) || c == 0) {
            return str;
        }
        return c + str + c;
    }

    public static String wrapIfMissing(String str, char c) {
        if (isEmpty(str) || c == 0) {
            return str;
        }
        boolean z = false;
        boolean z2 = str.charAt(0) != c;
        if (str.charAt(str.length() - 1) != c) {
            z = true;
        }
        if (!z2 && !z) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length() + 2);
        if (z2) {
            sb.append(c);
        }
        sb.append(str);
        if (z) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static String abbreviate(String str, int i, int i2) {
        return abbreviate(str, "...", i, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r2.length();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String center(java.lang.String r2, int r3, char r4) {
        /*
            if (r2 == 0) goto L_0x0019
            if (r3 > 0) goto L_0x0005
            goto L_0x0019
        L_0x0005:
            int r0 = r2.length()
            int r1 = r3 - r0
            if (r1 > 0) goto L_0x000e
            return r2
        L_0x000e:
            int r1 = r1 / 2
            int r1 = r1 + r0
            java.lang.String r2 = leftPad((java.lang.String) r2, (int) r1, (char) r4)
            java.lang.String r2 = rightPad((java.lang.String) r2, (int) r3, (char) r4)
        L_0x0019:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.StringUtils.center(java.lang.String, int, char):java.lang.String");
    }

    public static int compare(String str, String str2, boolean z) {
        if (str == str2) {
            return 0;
        }
        if (str == null) {
            return z ? -1 : 1;
        }
        if (str2 == null) {
            return z ? 1 : -1;
        }
        return str.compareTo(str2);
    }

    public static int compareIgnoreCase(String str, String str2, boolean z) {
        if (str == str2) {
            return 0;
        }
        if (str == null) {
            return z ? -1 : 1;
        }
        if (str2 == null) {
            return z ? 1 : -1;
        }
        return str.compareToIgnoreCase(str2);
    }

    public static boolean contains(CharSequence charSequence, int i) {
        if (!isEmpty(charSequence) && CharSequenceUtils.indexOf(charSequence, i, 0) >= 0) {
            return true;
        }
        return false;
    }

    public static String defaultString(String str) {
        return defaultString(str, "");
    }

    private static boolean endsWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        if (charSequence == null || charSequence2 == null) {
            if (charSequence == charSequence2) {
                return true;
            }
            return false;
        } else if (charSequence2.length() > charSequence.length()) {
            return false;
        } else {
            return CharSequenceUtils.regionMatches(charSequence, z, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length());
        }
    }

    public static byte[] getBytes(String str, String str2) throws UnsupportedEncodingException {
        return str == null ? ArrayUtils.EMPTY_BYTE_ARRAY : str.getBytes(Charsets.toCharsetName(str2));
    }

    public static int indexOf(CharSequence charSequence, CharSequence charSequence2, int i) {
        if (charSequence == null || charSequence2 == null) {
            return -1;
        }
        return CharSequenceUtils.indexOf(charSequence, charSequence2, i);
    }

    public static int indexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2, int i) {
        if (!(charSequence == null || charSequence2 == null)) {
            if (i < 0) {
                i = 0;
            }
            int length = (charSequence.length() - charSequence2.length()) + 1;
            if (i > length) {
                return -1;
            }
            if (charSequence2.length() == 0) {
                return i;
            }
            while (i < length) {
                if (CharSequenceUtils.regionMatches(charSequence, true, i, charSequence2, 0, charSequence2.length())) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    public static String join(boolean[] zArr, char c, int i, int i2) {
        if (zArr == null) {
            return null;
        }
        if (i2 - i <= 0) {
            return "";
        }
        StringJoiner newStringJoiner = newStringJoiner(c);
        while (i < i2) {
            newStringJoiner.add(String.valueOf(zArr[i]));
            i++;
        }
        return newStringJoiner.toString();
    }

    public static int lastIndexOf(CharSequence charSequence, CharSequence charSequence2, int i) {
        return CharSequenceUtils.lastIndexOf(charSequence, charSequence2, i);
    }

    public static int lastIndexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2, int i) {
        if (!(charSequence == null || charSequence2 == null)) {
            int length = charSequence2.length();
            int length2 = charSequence.length() - length;
            if (i > length2) {
                i = length2;
            }
            if (i < 0) {
                return -1;
            }
            if (length == 0) {
                return i;
            }
            while (i >= 0) {
                if (CharSequenceUtils.regionMatches(charSequence, true, i, charSequence2, 0, length)) {
                    return i;
                }
                i--;
            }
        }
        return -1;
    }

    public static String leftPad(String str, int i, char c) {
        if (str == null) {
            return null;
        }
        int length = i - str.length();
        if (length <= 0) {
            return str;
        }
        if (length > 8192) {
            return leftPad(str, i, String.valueOf(c));
        }
        return repeat(c, length).concat(str);
    }

    public static String lowerCase(String str, Locale locale) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase(LocaleUtils.toLocale(locale));
    }

    private static int ordinalIndexOf(CharSequence charSequence, CharSequence charSequence2, int i, boolean z) {
        int i2 = -1;
        if (charSequence == null || charSequence2 == null || i <= 0) {
            return i2;
        }
        int i3 = 0;
        if (charSequence2.length() != 0) {
            if (z) {
                i2 = charSequence.length();
            }
            do {
                if (z) {
                    i2 = CharSequenceUtils.lastIndexOf(charSequence, charSequence2, i2 - 1);
                } else {
                    i2 = CharSequenceUtils.indexOf(charSequence, charSequence2, i2 + 1);
                }
                if (i2 < 0) {
                    return i2;
                }
                i3++;
            } while (i3 < i);
            return i2;
        } else if (z) {
            return charSequence.length();
        } else {
            return 0;
        }
    }

    public static String replace(String str, String str2, String str3, int i) {
        return replace(str, str2, str3, i, false);
    }

    public static String replaceChars(String str, String str2, String str3) {
        if (isEmpty(str) || isEmpty(str2)) {
            return str;
        }
        if (str3 == null) {
            str3 = "";
        }
        int length = str3.length();
        int length2 = str.length();
        StringBuilder sb = new StringBuilder(length2);
        boolean z = false;
        for (int i = 0; i < length2; i++) {
            char charAt = str.charAt(i);
            int indexOf = str2.indexOf(charAt);
            if (indexOf >= 0) {
                if (indexOf < length) {
                    sb.append(str3.charAt(indexOf));
                }
                z = true;
            } else {
                sb.append(charAt);
            }
        }
        return z ? sb.toString() : str;
    }

    private static String replaceEach(String str, String[] strArr, String[] strArr2, boolean z, int i) {
        String str2;
        String str3;
        int length;
        if (i < 0) {
            HashSet hashSet = new HashSet(Arrays.asList(strArr));
            hashSet.retainAll(new HashSet(Arrays.asList(strArr2)));
            if (!hashSet.isEmpty()) {
                throw new IllegalStateException("Aborting to protect against StackOverflowError - output of one loop is the input of another");
            }
        }
        if (isEmpty(str) || ArrayUtils.isEmpty((Object[]) strArr) || ArrayUtils.isEmpty((Object[]) strArr2) || (ArrayUtils.isNotEmpty((T[]) strArr) && i == -1)) {
            return str;
        }
        int length2 = strArr.length;
        int length3 = strArr2.length;
        if (length2 == length3) {
            boolean[] zArr = new boolean[length2];
            int i2 = -1;
            int i3 = -1;
            for (int i4 = 0; i4 < length2; i4++) {
                if (!zArr[i4] && !isEmpty(strArr[i4]) && strArr2[i4] != null) {
                    int indexOf = str.indexOf(strArr[i4]);
                    if (indexOf == -1) {
                        zArr[i4] = true;
                    } else if (i2 == -1 || indexOf < i2) {
                        i3 = i4;
                        i2 = indexOf;
                    }
                }
            }
            if (i2 == -1) {
                return str;
            }
            int i5 = 0;
            for (int i6 = 0; i6 < strArr.length; i6++) {
                if (!(strArr[i6] == null || (str3 = strArr2[i6]) == null || (length = str3.length() - strArr[i6].length()) <= 0)) {
                    i5 += length * 3;
                }
            }
            StringBuilder sb = new StringBuilder(str.length() + Math.min(i5, str.length() / 5));
            int i7 = 0;
            while (i2 != -1) {
                while (i7 < i2) {
                    sb.append(str.charAt(i7));
                    i7++;
                }
                sb.append(strArr2[i3]);
                i7 = strArr[i3].length() + i2;
                i2 = -1;
                i3 = -1;
                for (int i8 = 0; i8 < length2; i8++) {
                    if (!zArr[i8] && (str2 = strArr[i8]) != null && !str2.isEmpty() && strArr2[i8] != null) {
                        int indexOf2 = str.indexOf(strArr[i8], i7);
                        if (indexOf2 == -1) {
                            zArr[i8] = true;
                        } else if (i2 == -1 || indexOf2 < i2) {
                            i3 = i8;
                            i2 = indexOf2;
                        }
                    }
                }
            }
            int length4 = str.length();
            while (i7 < length4) {
                sb.append(str.charAt(i7));
                i7++;
            }
            String sb2 = sb.toString();
            if (!z) {
                return sb2;
            }
            return replaceEach(sb2, strArr, strArr2, z, i - 1);
        }
        throw new IllegalArgumentException(e.h(length2, "Search and Replace array lengths don't match: ", " vs ", length3));
    }

    public static String replaceIgnoreCase(String str, String str2, String str3, int i) {
        return replace(str, str2, str3, i, true);
    }

    public static String rightPad(String str, int i, char c) {
        if (str == null) {
            return null;
        }
        int length = i - str.length();
        if (length <= 0) {
            return str;
        }
        if (length > 8192) {
            return rightPad(str, i, String.valueOf(c));
        }
        return str.concat(repeat(c, length));
    }

    public static String[] split(String str, char c) {
        return splitWorker(str, c, false);
    }

    private static String[] splitByCharacterType(String str, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int type = Character.getType(charArray[0]);
        for (int i2 = 1; i2 < charArray.length; i2++) {
            int type2 = Character.getType(charArray[i2]);
            if (type2 != type) {
                if (z && type2 == 2 && type == 1) {
                    int i3 = i2 - 1;
                    if (i3 != i) {
                        arrayList.add(new String(charArray, i, i3 - i));
                        i = i3;
                    }
                } else {
                    arrayList.add(new String(charArray, i, i2 - i));
                    i = i2;
                }
                type = type2;
            }
        }
        arrayList.add(new String(charArray, i, charArray.length - i));
        return (String[]) arrayList.toArray(ArrayUtils.EMPTY_STRING_ARRAY);
    }

    public static String[] splitByWholeSeparator(String str, String str2, int i) {
        return splitByWholeSeparatorWorker(str, str2, i, false);
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String str2, int i) {
        return splitByWholeSeparatorWorker(str, str2, i, true);
    }

    public static String[] splitPreserveAllTokens(String str, char c) {
        return splitWorker(str, c, true);
    }

    private static boolean startsWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        if (charSequence != null && charSequence2 != null) {
            int length = charSequence2.length();
            if (length > charSequence.length()) {
                return false;
            }
            return CharSequenceUtils.regionMatches(charSequence, z, 0, charSequence2, 0, length);
        } else if (charSequence == charSequence2) {
            return true;
        } else {
            return false;
        }
    }

    public static String strip(String str, String str2) {
        return stripEnd(stripStart(str, str2), str2);
    }

    public static String[] stripAll(String[] strArr, String str) {
        int length = ArrayUtils.getLength(strArr);
        if (length == 0) {
            return strArr;
        }
        String[] strArr2 = new String[length];
        for (int i = 0; i < length; i++) {
            strArr2[i] = strip(strArr[i], str);
        }
        return strArr2;
    }

    public static String substringBetween(String str, String str2, String str3) {
        int indexOf;
        int indexOf2;
        if (!ObjectUtils.allNotNull(str, str2, str3) || (indexOf = str.indexOf(str2)) == -1 || (indexOf2 = str.indexOf(str3, str2.length() + indexOf)) == -1) {
            return null;
        }
        return str.substring(str2.length() + indexOf, indexOf2);
    }

    public static String truncate(String str, int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("offset cannot be negative");
        } else if (i2 < 0) {
            throw new IllegalArgumentException("maxWith cannot be negative");
        } else if (str == null) {
            return null;
        } else {
            if (i > str.length()) {
                return "";
            }
            if (str.length() > i2) {
                return str.substring(i, Math.min(i2 + i, str.length()));
            }
            return str.substring(i);
        }
    }

    public static String upperCase(String str, Locale locale) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase(LocaleUtils.toLocale(locale));
    }

    public static String abbreviate(String str, String str2, int i) {
        return abbreviate(str, str2, 0, i);
    }

    public static int indexOf(CharSequence charSequence, int i) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.indexOf(charSequence, i, 0);
    }

    public static int lastIndexOf(CharSequence charSequence, int i) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.lastIndexOf(charSequence, i, charSequence.length());
    }

    private static String replace(String str, String str2, String str3, int i, boolean z) {
        int i2;
        if (isEmpty(str) || isEmpty(str2) || str3 == null || i == 0) {
            return str;
        }
        if (z) {
            str2 = str2.toLowerCase();
        }
        int i3 = 0;
        int indexOfIgnoreCase = z ? indexOfIgnoreCase(str, str2, 0) : indexOf((CharSequence) str, (CharSequence) str2, 0);
        if (indexOfIgnoreCase == -1) {
            return str;
        }
        int length = str2.length();
        int max = Math.max(str3.length() - length, 0);
        if (i < 0) {
            i2 = 16;
        } else {
            i2 = Math.min(i, 64);
        }
        StringBuilder sb = new StringBuilder(str.length() + (max * i2));
        while (indexOfIgnoreCase != -1) {
            sb.append(str, i3, indexOfIgnoreCase);
            sb.append(str3);
            i3 = indexOfIgnoreCase + length;
            i--;
            if (i == 0) {
                break;
            }
            indexOfIgnoreCase = z ? indexOfIgnoreCase(str, str2, i3) : indexOf((CharSequence) str, (CharSequence) str2, i3);
        }
        sb.append(str, i3, str.length());
        return sb.toString();
    }

    public static String[] split(String str, String str2) {
        return splitWorker(str, str2, -1, false);
    }

    public static String[] splitPreserveAllTokens(String str, String str2) {
        return splitWorker(str, str2, -1, true);
    }

    public static String wrap(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2)) ? str : str2.concat(str).concat(str2);
    }

    public static String abbreviate(String str, String str2, int i, int i2) {
        if (isNotEmpty(str) && "".equals(str2) && i2 > 0) {
            return substring(str, 0, i2);
        }
        if (isAnyEmpty(str, str2)) {
            return str;
        }
        int length = str2.length();
        int i3 = length + 1;
        int i4 = length + length + 1;
        if (i2 >= i3) {
            int length2 = str.length();
            if (length2 <= i2) {
                return str;
            }
            if (i > length2) {
                i = length2;
            }
            int i5 = i2 - length;
            if (length2 - i < i5) {
                i = length2 - i5;
            }
            if (i <= i3) {
                return str.substring(0, i5) + str2;
            } else if (i2 < i4) {
                throw new IllegalArgumentException(String.format("Minimum abbreviation width with offset is %d", new Object[]{Integer.valueOf(i4)}));
            } else if ((i2 + i) - length < length2) {
                StringBuilder v = ba.v(str2);
                v.append(abbreviate(str.substring(i), str2, i5));
                return v.toString();
            } else {
                StringBuilder v2 = ba.v(str2);
                v2.append(str.substring(length2 - i5));
                return v2.toString();
            }
        } else {
            throw new IllegalArgumentException(String.format("Minimum abbreviation width is %d", new Object[]{Integer.valueOf(i3)}));
        }
    }

    public static boolean containsOnly(CharSequence charSequence, String str) {
        if (charSequence == null || str == null) {
            return false;
        }
        return containsOnly(charSequence, str.toCharArray());
    }

    public static int countMatches(CharSequence charSequence, CharSequence charSequence2) {
        int i = 0;
        if (isEmpty(charSequence) || isEmpty(charSequence2)) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            int indexOf = CharSequenceUtils.indexOf(charSequence, charSequence2, i);
            if (indexOf == -1) {
                return i2;
            }
            i2++;
            i = indexOf + charSequence2.length();
        }
    }

    public static String[] split(String str, String str2, int i) {
        return splitWorker(str, str2, i, false);
    }

    public static String[] splitPreserveAllTokens(String str, String str2, int i) {
        return splitWorker(str, str2, i, true);
    }

    public static String substringBefore(String str, String str2) {
        if (isEmpty(str) || str2 == null) {
            return str;
        }
        if (str2.isEmpty()) {
            return "";
        }
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return str;
        }
        return str.substring(0, indexOf);
    }

    public static String center(String str, int i, String str2) {
        if (str == null || i <= 0) {
            return str;
        }
        if (isEmpty(str2)) {
            str2 = SPACE;
        }
        int length = str.length();
        int i2 = i - length;
        if (i2 <= 0) {
            return str;
        }
        return rightPad(leftPad(str, (i2 / 2) + length, str2), i, str2);
    }

    public static int indexOf(CharSequence charSequence, int i, int i2) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.indexOf(charSequence, i, i2);
    }

    public static int lastIndexOf(CharSequence charSequence, int i, int i2) {
        if (isEmpty(charSequence)) {
            return -1;
        }
        return CharSequenceUtils.lastIndexOf(charSequence, i, i2);
    }

    public static String leftPad(String str, int i, String str2) {
        if (str == null) {
            return null;
        }
        if (isEmpty(str2)) {
            str2 = SPACE;
        }
        int length = str2.length();
        int length2 = i - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length == 1 && length2 <= 8192) {
            return leftPad(str, i, str2.charAt(0));
        }
        if (length2 == length) {
            return str2.concat(str);
        }
        if (length2 < length) {
            return str2.substring(0, length2).concat(str);
        }
        char[] cArr = new char[length2];
        char[] charArray = str2.toCharArray();
        for (int i2 = 0; i2 < length2; i2++) {
            cArr[i2] = charArray[i2 % length];
        }
        return new String(cArr).concat(str);
    }

    public static String repeat(String str, int i) {
        if (str == null) {
            return null;
        }
        if (i <= 0) {
            return "";
        }
        int length = str.length();
        if (i == 1 || length == 0) {
            return str;
        }
        if (length == 1 && i <= 8192) {
            return repeat(str.charAt(0), i);
        }
        int i2 = length * i;
        if (length == 1) {
            return repeat(str.charAt(0), i);
        }
        if (length != 2) {
            StringBuilder sb = new StringBuilder(i2);
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(str);
            }
            return sb.toString();
        }
        char charAt = str.charAt(0);
        char charAt2 = str.charAt(1);
        char[] cArr = new char[i2];
        for (int i4 = (i * 2) - 2; i4 >= 0; i4 -= 2) {
            cArr[i4] = charAt;
            cArr[i4 + 1] = charAt2;
        }
        return new String(cArr);
    }

    public static String rightPad(String str, int i, String str2) {
        if (str == null) {
            return null;
        }
        if (isEmpty(str2)) {
            str2 = SPACE;
        }
        int length = str2.length();
        int length2 = i - str.length();
        if (length2 <= 0) {
            return str;
        }
        if (length == 1 && length2 <= 8192) {
            return rightPad(str, i, str2.charAt(0));
        }
        if (length2 == length) {
            return str.concat(str2);
        }
        if (length2 < length) {
            return str.concat(str2.substring(0, length2));
        }
        char[] cArr = new char[length2];
        char[] charArray = str2.toCharArray();
        for (int i2 = 0; i2 < length2; i2++) {
            cArr[i2] = charArray[i2 % length];
        }
        return str.concat(new String(cArr));
    }

    public static String substring(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        if (i2 < 0) {
            i2 += str.length();
        }
        if (i < 0) {
            i += str.length();
        }
        if (i2 > str.length()) {
            i2 = str.length();
        }
        if (i > i2) {
            return "";
        }
        if (i < 0) {
            i = 0;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        return str.substring(i, i2);
    }

    public static String substringAfter(String str, String str2) {
        int indexOf;
        if (isEmpty(str)) {
            return str;
        }
        if (str2 == null || (indexOf = str.indexOf(str2)) == -1) {
            return "";
        }
        return str.substring(str2.length() + indexOf);
    }

    public static String unwrap(String str, String str2) {
        if (isEmpty(str) || isEmpty(str2) || str.length() < str2.length() * 2 || !startsWith(str, str2) || !endsWith(str, str2)) {
            return str;
        }
        int indexOf = str.indexOf(str2);
        int lastIndexOf = str.lastIndexOf(str2);
        return (indexOf == -1 || lastIndexOf == -1) ? str : str.substring(indexOf + str2.length(), lastIndexOf);
    }

    public static String join(byte[] bArr, char c) {
        if (bArr == null) {
            return null;
        }
        return join(bArr, c, 0, bArr.length);
    }

    public static String prependIfMissing(String str, CharSequence charSequence, CharSequence... charSequenceArr) {
        return prependIfMissing(str, charSequence, false, charSequenceArr);
    }

    public static String substringAfterLast(String str, String str2) {
        int lastIndexOf;
        if (isEmpty(str)) {
            return str;
        }
        if (isEmpty(str2) || (lastIndexOf = str.lastIndexOf(str2)) == -1 || lastIndexOf == str.length() - str2.length()) {
            return "";
        }
        return str.substring(str2.length() + lastIndexOf);
    }

    public static boolean containsNone(CharSequence charSequence, String str) {
        if (str == null) {
            return true;
        }
        return containsNone(charSequence, str.toCharArray());
    }

    public static String join(byte[] bArr, char c, int i, int i2) {
        if (bArr == null) {
            return null;
        }
        if (i2 - i <= 0) {
            return "";
        }
        StringJoiner newStringJoiner = newStringJoiner(c);
        while (i < i2) {
            newStringJoiner.add(String.valueOf(bArr[i]));
            i++;
        }
        return newStringJoiner.toString();
    }

    public static String remove(String str, String str2) {
        return (isEmpty(str) || isEmpty(str2)) ? str : replace(str, str2, "", -1);
    }

    public static boolean containsAny(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence2 == null) {
            return false;
        }
        return containsAny(charSequence, CharSequenceUtils.toCharArray(charSequence2));
    }

    public static int indexOfAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        int indexOf;
        if (charSequence == null || charSequenceArr == null) {
            return -1;
        }
        int i = Integer.MAX_VALUE;
        for (CharSequence charSequence2 : charSequenceArr) {
            if (!(charSequence2 == null || (indexOf = CharSequenceUtils.indexOf(charSequence, charSequence2, 0)) == -1 || indexOf >= i)) {
                i = indexOf;
            }
        }
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i;
    }

    public static int indexOfAnyBut(CharSequence charSequence, CharSequence charSequence2) {
        if (!isEmpty(charSequence) && !isEmpty(charSequence2)) {
            int length = charSequence.length();
            int i = 0;
            while (i < length) {
                char charAt = charSequence.charAt(i);
                boolean z = CharSequenceUtils.indexOf(charSequence2, (int) charAt, 0) >= 0;
                int i2 = i + 1;
                if (i2 < length && Character.isHighSurrogate(charAt)) {
                    char charAt2 = charSequence.charAt(i2);
                    if (z && CharSequenceUtils.indexOf(charSequence2, (int) charAt2, 0) < 0) {
                        return i;
                    }
                } else if (!z) {
                    return i;
                }
                i = i2;
            }
        }
        return -1;
    }

    public static int indexOfDifference(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == charSequence2) {
            return -1;
        }
        int i = 0;
        if (!(charSequence == null || charSequence2 == null)) {
            while (i < charSequence.length() && i < charSequence2.length() && charSequence.charAt(i) == charSequence2.charAt(i)) {
                i++;
            }
            if (i < charSequence2.length() || i < charSequence.length()) {
                return i;
            }
            return -1;
        }
        return i;
    }

    private static String[] splitWorker(String str, String str2, int i, boolean z) {
        int i2;
        int i3;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i4;
        int i5;
        boolean z6;
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        ArrayList arrayList = new ArrayList();
        if (str2 == null) {
            i2 = 0;
            z3 = false;
            z2 = false;
            i3 = 0;
            int i6 = 1;
            while (i2 < length) {
                if (Character.isWhitespace(str.charAt(i2))) {
                    if (z3 || z) {
                        int i7 = i6 + 1;
                        if (i6 == i) {
                            i2 = length;
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        arrayList.add(str.substring(i3, i2));
                        i6 = i7;
                        z3 = false;
                    }
                    i3 = i2 + 1;
                    i2 = i3;
                } else {
                    i2++;
                    z3 = true;
                    z2 = false;
                }
            }
        } else {
            if (str2.length() == 1) {
                char charAt = str2.charAt(0);
                i5 = 0;
                z4 = false;
                z5 = false;
                i4 = 0;
                int i8 = 1;
                while (i5 < length) {
                    if (str.charAt(i5) == charAt) {
                        if (z4 || z) {
                            int i9 = i8 + 1;
                            if (i8 == i) {
                                i5 = length;
                                z5 = false;
                            } else {
                                z5 = true;
                            }
                            arrayList.add(str.substring(i4, i5));
                            i8 = i9;
                            z4 = false;
                        }
                        i4 = i5 + 1;
                        i5 = i4;
                    } else {
                        i5++;
                        z4 = true;
                        z5 = false;
                    }
                }
            } else {
                int i10 = 0;
                z4 = false;
                z5 = false;
                i4 = 0;
                int i11 = 1;
                while (i5 < length) {
                    if (str2.indexOf(str.charAt(i5)) >= 0) {
                        if (z4 || z) {
                            int i12 = i11 + 1;
                            if (i11 == i) {
                                i5 = length;
                                z6 = false;
                            } else {
                                z6 = true;
                            }
                            arrayList.add(str.substring(i4, i5));
                            i11 = i12;
                            z4 = false;
                        }
                        i4 = i5 + 1;
                        i10 = i4;
                    } else {
                        i10 = i5 + 1;
                        z4 = true;
                        z5 = false;
                    }
                }
            }
            i2 = i5;
            z3 = z4;
            z2 = z5;
            i3 = i4;
        }
        if (z3 || (z && z2)) {
            arrayList.add(str.substring(i3, i2));
        }
        return (String[]) arrayList.toArray(ArrayUtils.EMPTY_STRING_ARRAY);
    }

    @Deprecated
    public static String chomp(String str, String str2) {
        return removeEnd(str, str2);
    }

    public static boolean containsAny(CharSequence charSequence, CharSequence... charSequenceArr) {
        return containsAny(new t9(13), charSequence, charSequenceArr);
    }

    public static String wrapIfMissing(String str, String str2) {
        if (isEmpty(str) || isEmpty(str2)) {
            return str;
        }
        boolean startsWith = str.startsWith(str2);
        boolean endsWith = str.endsWith(str2);
        if (startsWith && endsWith) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str2.length() + str2.length() + str.length());
        if (!startsWith) {
            sb.append(str2);
        }
        sb.append(str);
        if (!endsWith) {
            sb.append(str2);
        }
        return sb.toString();
    }

    public static String appendIfMissing(String str, CharSequence charSequence, CharSequence... charSequenceArr) {
        return appendIfMissing(str, charSequence, false, charSequenceArr);
    }

    private static boolean containsAny(ToBooleanBiFunction<CharSequence, CharSequence> toBooleanBiFunction, CharSequence charSequence, CharSequence... charSequenceArr) {
        if (!isEmpty(charSequence) && !ArrayUtils.isEmpty((Object[]) charSequenceArr)) {
            for (CharSequence applyAsBoolean : charSequenceArr) {
                if (toBooleanBiFunction.applyAsBoolean(charSequence, applyAsBoolean)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int indexOfAny(CharSequence charSequence, String str) {
        if (isEmpty(charSequence) || isEmpty(str)) {
            return -1;
        }
        return indexOfAny(charSequence, str.toCharArray());
    }

    public static String join(char[] cArr, char c) {
        if (cArr == null) {
            return null;
        }
        return join(cArr, c, 0, cArr.length);
    }

    public static String join(char[] cArr, char c, int i, int i2) {
        if (cArr == null) {
            return null;
        }
        if (i2 - i <= 0) {
            return "";
        }
        StringJoiner newStringJoiner = newStringJoiner(c);
        while (i < i2) {
            newStringJoiner.add(String.valueOf(cArr[i]));
            i++;
        }
        return newStringJoiner.toString();
    }

    @Deprecated
    public static int getLevenshteinDistance(CharSequence charSequence, CharSequence charSequence2, int i) {
        int i2;
        int i3;
        CharSequence charSequence3;
        CharSequence charSequence4;
        int i4;
        int i5 = i;
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        } else if (i5 >= 0) {
            int length = charSequence.length();
            int length2 = charSequence2.length();
            if (length == 0) {
                if (length2 <= i5) {
                    return length2;
                }
                return -1;
            } else if (length2 == 0) {
                if (length <= i5) {
                    return length;
                }
                return -1;
            } else if (Math.abs(length - length2) > i5) {
                return -1;
            } else {
                if (length > length2) {
                    i2 = charSequence.length();
                    i3 = length2;
                    charSequence4 = charSequence;
                    charSequence3 = charSequence2;
                } else {
                    i3 = length;
                    i2 = length2;
                    charSequence3 = charSequence;
                    charSequence4 = charSequence2;
                }
                int i6 = i3 + 1;
                int[] iArr = new int[i6];
                int[] iArr2 = new int[i6];
                int min = Math.min(i3, i5) + 1;
                char c = 0;
                for (int i7 = 0; i7 < min; i7++) {
                    iArr[i7] = i7;
                }
                int i8 = Integer.MAX_VALUE;
                Arrays.fill(iArr, min, i6, Integer.MAX_VALUE);
                Arrays.fill(iArr2, Integer.MAX_VALUE);
                int i9 = 1;
                while (i9 <= i2) {
                    char charAt = charSequence4.charAt(i9 - 1);
                    iArr2[c] = i9;
                    int max = Math.max(1, i9 - i5);
                    if (i9 > i8 - i5) {
                        i4 = i3;
                    } else {
                        i4 = Math.min(i3, i9 + i5);
                    }
                    if (max > i4) {
                        return -1;
                    }
                    if (max > 1) {
                        iArr2[max - 1] = i8;
                    }
                    while (max <= i4) {
                        int i10 = max - 1;
                        if (charSequence3.charAt(i10) == charAt) {
                            iArr2[max] = iArr[i10];
                        } else {
                            iArr2[max] = Math.min(Math.min(iArr2[i10], iArr[max]), iArr[i10]) + 1;
                        }
                        max++;
                    }
                    i9++;
                    c = 0;
                    i8 = Integer.MAX_VALUE;
                    int[] iArr3 = iArr2;
                    iArr2 = iArr;
                    iArr = iArr3;
                }
                int i11 = iArr[i3];
                if (i11 <= i5) {
                    return i11;
                }
                return -1;
            }
        } else {
            throw new IllegalArgumentException("Threshold must not be negative");
        }
    }

    public static String join(double[] dArr, char c) {
        if (dArr == null) {
            return null;
        }
        return join(dArr, c, 0, dArr.length);
    }

    public static String join(double[] dArr, char c, int i, int i2) {
        if (dArr == null) {
            return null;
        }
        if (i2 - i <= 0) {
            return "";
        }
        StringJoiner newStringJoiner = newStringJoiner(c);
        while (i < i2) {
            newStringJoiner.add(String.valueOf(dArr[i]));
            i++;
        }
        return newStringJoiner.toString();
    }

    public static String repeat(String str, String str2, int i) {
        if (str == null || str2 == null) {
            return repeat(str, i);
        }
        return removeEnd(repeat(str.concat(str2), i), str2);
    }

    public static String join(float[] fArr, char c) {
        if (fArr == null) {
            return null;
        }
        return join(fArr, c, 0, fArr.length);
    }

    public static String join(float[] fArr, char c, int i, int i2) {
        if (fArr == null) {
            return null;
        }
        if (i2 - i <= 0) {
            return "";
        }
        StringJoiner newStringJoiner = newStringJoiner(c);
        while (i < i2) {
            newStringJoiner.add(String.valueOf(fArr[i]));
            i++;
        }
        return newStringJoiner.toString();
    }

    public static String join(int[] iArr, char c) {
        if (iArr == null) {
            return null;
        }
        return join(iArr, c, 0, iArr.length);
    }

    public static String join(int[] iArr, char c, int i, int i2) {
        if (iArr == null) {
            return null;
        }
        if (i2 - i <= 0) {
            return "";
        }
        StringJoiner newStringJoiner = newStringJoiner(c);
        while (i < i2) {
            newStringJoiner.add(String.valueOf(iArr[i]));
            i++;
        }
        return newStringJoiner.toString();
    }

    public static String join(Iterable<?> iterable, char c) {
        if (iterable == null) {
            return null;
        }
        return join(iterable.iterator(), c);
    }

    public static String join(Iterable<?> iterable, String str) {
        if (iterable == null) {
            return null;
        }
        return join(iterable.iterator(), str);
    }

    public static String join(Iterator<?> it, char c) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "";
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return toStringOrEmpty(next);
        }
        StringBuilder sb = new StringBuilder(256);
        if (next != null) {
            sb.append(next);
        }
        while (it.hasNext()) {
            sb.append(c);
            Object next2 = it.next();
            if (next2 != null) {
                sb.append(next2);
            }
        }
        return sb.toString();
    }

    public static String join(Iterator<?> it, String str) {
        if (it == null) {
            return null;
        }
        if (!it.hasNext()) {
            return "";
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return Objects.toString(next, "");
        }
        StringBuilder sb = new StringBuilder(256);
        if (next != null) {
            sb.append(next);
        }
        while (it.hasNext()) {
            if (str != null) {
                sb.append(str);
            }
            Object next2 = it.next();
            if (next2 != null) {
                sb.append(next2);
            }
        }
        return sb.toString();
    }

    public static String join(List<?> list, char c, int i, int i2) {
        if (list == null) {
            return null;
        }
        if (i2 - i <= 0) {
            return "";
        }
        return join(list.subList(i, i2).iterator(), c);
    }

    public static String join(List<?> list, String str, int i, int i2) {
        if (list == null) {
            return null;
        }
        if (i2 - i <= 0) {
            return "";
        }
        return join(list.subList(i, i2).iterator(), str);
    }

    public static String join(long[] jArr, char c) {
        if (jArr == null) {
            return null;
        }
        return join(jArr, c, 0, jArr.length);
    }

    public static String join(long[] jArr, char c, int i, int i2) {
        if (jArr == null) {
            return null;
        }
        if (i2 - i <= 0) {
            return "";
        }
        StringJoiner newStringJoiner = newStringJoiner(c);
        while (i < i2) {
            newStringJoiner.add(String.valueOf(jArr[i]));
            i++;
        }
        return newStringJoiner.toString();
    }

    public static String join(Object[] objArr, char c) {
        if (objArr == null) {
            return null;
        }
        return join(objArr, c, 0, objArr.length);
    }

    public static String join(Object[] objArr, char c, int i, int i2) {
        if (objArr == null) {
            return null;
        }
        if (i2 - i <= 0) {
            return "";
        }
        StringJoiner newStringJoiner = newStringJoiner(c);
        while (i < i2) {
            newStringJoiner.add(toStringOrEmpty(objArr[i]));
            i++;
        }
        return newStringJoiner.toString();
    }

    public static String join(Object[] objArr, String str) {
        if (objArr == null) {
            return null;
        }
        return join(objArr, str, 0, objArr.length);
    }

    public static String join(Object[] objArr, String str, int i, int i2) {
        if (objArr == null) {
            return null;
        }
        if (i2 - i <= 0) {
            return "";
        }
        cd.r();
        StringJoiner n = cd.n(toStringOrEmpty(str));
        while (i < i2) {
            n.add(toStringOrEmpty(objArr[i]));
            i++;
        }
        return n.toString();
    }

    public static String join(short[] sArr, char c) {
        if (sArr == null) {
            return null;
        }
        return join(sArr, c, 0, sArr.length);
    }

    public static String join(short[] sArr, char c, int i, int i2) {
        if (sArr == null) {
            return null;
        }
        if (i2 - i <= 0) {
            return "";
        }
        StringJoiner newStringJoiner = newStringJoiner(c);
        while (i < i2) {
            newStringJoiner.add(String.valueOf(sArr[i]));
            i++;
        }
        return newStringJoiner.toString();
    }

    @SafeVarargs
    public static <T> String join(T... tArr) {
        return join((Object[]) tArr, (String) null);
    }
}
