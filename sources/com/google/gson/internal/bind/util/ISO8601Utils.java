package com.google.gson.internal.bind.util;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.commons.lang3.ClassUtils;

public class ISO8601Utils {
    private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone(UTC_ID);
    private static final String UTC_ID = "UTC";

    private static boolean checkOffset(String str, int i, char c) {
        if (i >= str.length() || str.charAt(i) != c) {
            return false;
        }
        return true;
    }

    public static String format(Date date) {
        return format(date, false, TIMEZONE_UTC);
    }

    private static int indexOfNonDigit(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }

    private static void padInt(StringBuilder sb, int i, int i2) {
        String num = Integer.toString(i);
        for (int length = i2 - num.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(num);
    }

    /* JADX WARNING: Removed duplicated region for block: B:87:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Date parse(java.lang.String r19, java.text.ParsePosition r20) throws java.text.ParseException {
        /*
            r1 = r19
            r2 = r20
            java.lang.String r0 = "Mismatching time zone indicator: "
            java.lang.String r3 = "GMT"
            java.lang.String r4 = "00"
            java.lang.String r5 = "Invalid time zone indicator '"
            int r6 = r20.getIndex()     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            int r7 = r6 + 4
            int r8 = parseInt(r1, r6, r7)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            r9 = 45
            boolean r10 = checkOffset(r1, r7, r9)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            r11 = 5
            if (r10 == 0) goto L_0x0021
            int r7 = r6 + 5
        L_0x0021:
            int r6 = r7 + 2
            int r10 = parseInt(r1, r7, r6)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            boolean r12 = checkOffset(r1, r6, r9)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            if (r12 == 0) goto L_0x002f
            int r6 = r7 + 3
        L_0x002f:
            int r7 = r6 + 2
            int r12 = parseInt(r1, r6, r7)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            r13 = 84
            boolean r13 = checkOffset(r1, r7, r13)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            r14 = 1
            if (r13 != 0) goto L_0x005b
            int r15 = r19.length()     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            if (r15 > r7) goto L_0x005b
            java.util.GregorianCalendar r0 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            int r10 = r10 - r14
            r0.<init>(r8, r10, r12)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            r2.setIndex(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            java.util.Date r0 = r0.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            return r0
        L_0x0052:
            r0 = move-exception
            goto L_0x01b9
        L_0x0055:
            r0 = move-exception
            goto L_0x01b9
        L_0x0058:
            r0 = move-exception
            goto L_0x01b9
        L_0x005b:
            r15 = 43
            r11 = 90
            if (r13 == 0) goto L_0x00e0
            int r7 = r6 + 3
            int r13 = r6 + 5
            int r7 = parseInt(r1, r7, r13)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            r14 = 58
            boolean r16 = checkOffset(r1, r13, r14)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            if (r16 == 0) goto L_0x0073
            int r13 = r6 + 6
        L_0x0073:
            int r6 = r13 + 2
            int r16 = parseInt(r1, r13, r6)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            boolean r14 = checkOffset(r1, r6, r14)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            if (r14 == 0) goto L_0x0082
            int r13 = r13 + 3
            r6 = r13
        L_0x0082:
            int r13 = r19.length()     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            if (r13 <= r6) goto L_0x00d6
            char r13 = r1.charAt(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            if (r13 == r11) goto L_0x00d6
            if (r13 == r15) goto L_0x00d6
            if (r13 == r9) goto L_0x00d6
            int r13 = r6 + 2
            int r14 = parseInt(r1, r6, r13)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            r9 = 59
            if (r14 <= r9) goto L_0x00a2
            r9 = 63
            if (r14 >= r9) goto L_0x00a2
            r14 = 59
        L_0x00a2:
            r9 = 46
            boolean r9 = checkOffset(r1, r13, r9)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            if (r9 == 0) goto L_0x00d0
            int r9 = r6 + 3
            int r13 = r6 + 4
            int r13 = indexOfNonDigit(r1, r13)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            int r6 = r6 + 6
            int r6 = java.lang.Math.min(r13, r6)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            int r17 = parseInt(r1, r9, r6)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            int r6 = r6 - r9
            r9 = 1
            if (r6 == r9) goto L_0x00c7
            r9 = 2
            if (r6 == r9) goto L_0x00c4
            goto L_0x00c9
        L_0x00c4:
            int r17 = r17 * 10
            goto L_0x00c9
        L_0x00c7:
            int r17 = r17 * 100
        L_0x00c9:
            r6 = r7
            r7 = r13
            r9 = r16
            r13 = r17
            goto L_0x00e4
        L_0x00d0:
            r6 = r7
            r7 = r13
            r9 = r16
            r13 = 0
            goto L_0x00e4
        L_0x00d6:
            r9 = r16
            r13 = 0
            r14 = 0
            r18 = r7
            r7 = r6
            r6 = r18
            goto L_0x00e4
        L_0x00e0:
            r6 = 0
            r9 = 0
            r13 = 0
            r14 = 0
        L_0x00e4:
            int r15 = r19.length()     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            if (r15 <= r7) goto L_0x01b1
            char r15 = r1.charAt(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            if (r15 != r11) goto L_0x00f6
            java.util.TimeZone r0 = TIMEZONE_UTC     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            r3 = 1
            int r7 = r7 + r3
            goto L_0x017f
        L_0x00f6:
            r11 = 43
            if (r15 == r11) goto L_0x0116
            r11 = 45
            if (r15 != r11) goto L_0x00ff
            goto L_0x0116
        L_0x00ff:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            r3.<init>(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            r3.append(r15)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            java.lang.String r4 = "'"
            r3.append(r4)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            java.lang.String r3 = r3.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            r0.<init>(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
        L_0x0116:
            java.lang.String r5 = r1.substring(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            int r11 = r5.length()     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            r15 = 5
            if (r11 < r15) goto L_0x0122
            goto L_0x0126
        L_0x0122:
            java.lang.String r5 = r5.concat(r4)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
        L_0x0126:
            int r4 = r5.length()     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            int r7 = r7 + r4
            java.lang.String r4 = "+0000"
            boolean r4 = r4.equals(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            if (r4 != 0) goto L_0x017d
            java.lang.String r4 = "+00:00"
            boolean r4 = r4.equals(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            if (r4 == 0) goto L_0x013c
            goto L_0x017d
        L_0x013c:
            java.lang.String r3 = r3.concat(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            java.util.TimeZone r4 = java.util.TimeZone.getTimeZone(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            java.lang.String r5 = r4.getID()     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            boolean r11 = r5.equals(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            if (r11 != 0) goto L_0x017b
            java.lang.String r11 = ":"
            java.lang.String r15 = ""
            java.lang.String r5 = r5.replace(r11, r15)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            boolean r5 = r5.equals(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            if (r5 == 0) goto L_0x015d
            goto L_0x017b
        L_0x015d:
            java.lang.IndexOutOfBoundsException r5 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            r6.<init>(r0)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            r6.append(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            java.lang.String r0 = " given, resolves to "
            r6.append(r0)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            java.lang.String r0 = r4.getID()     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            r6.append(r0)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            java.lang.String r0 = r6.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            r5.<init>(r0)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            throw r5     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
        L_0x017b:
            r0 = r4
            goto L_0x017f
        L_0x017d:
            java.util.TimeZone r0 = TIMEZONE_UTC     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
        L_0x017f:
            java.util.GregorianCalendar r3 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            r3.<init>(r0)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            r0 = 0
            r3.setLenient(r0)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            r0 = 1
            r3.set(r0, r8)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            int r10 = r10 - r0
            r0 = 2
            r3.set(r0, r10)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            r0 = 5
            r3.set(r0, r12)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            r0 = 11
            r3.set(r0, r6)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            r0 = 12
            r3.set(r0, r9)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            r0 = 13
            r3.set(r0, r14)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            r0 = 14
            r3.set(r0, r13)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            r2.setIndex(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            java.util.Date r0 = r3.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            return r0
        L_0x01b1:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            java.lang.String r3 = "No time zone indicator"
            r0.<init>(r3)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
            throw r0     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0055, IllegalArgumentException -> 0x0052 }
        L_0x01b9:
            if (r1 != 0) goto L_0x01bd
            r1 = 0
            goto L_0x01d0
        L_0x01bd:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "\""
            r3.<init>(r4)
            r3.append(r1)
            r1 = 34
            r3.append(r1)
            java.lang.String r1 = r3.toString()
        L_0x01d0:
            java.lang.String r3 = r0.getMessage()
            if (r3 == 0) goto L_0x01dc
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x01f7
        L_0x01dc:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "("
            r3.<init>(r4)
            java.lang.Class r4 = r0.getClass()
            java.lang.String r4 = r4.getName()
            r3.append(r4)
            java.lang.String r4 = ")"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
        L_0x01f7:
            java.text.ParseException r4 = new java.text.ParseException
            java.lang.String r5 = "Failed to parse date ["
            java.lang.String r6 = "]: "
            java.lang.String r1 = defpackage.e.n(r5, r1, r6, r3)
            int r2 = r20.getIndex()
            r4.<init>(r1, r2)
            r4.initCause(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.util.ISO8601Utils.parse(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    private static int parseInt(String str, int i, int i2) throws NumberFormatException {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int digit = Character.digit(str.charAt(i), 10);
            if (digit >= 0) {
                i3 = -digit;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
        } else {
            i3 = 0;
            i4 = i;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int digit2 = Character.digit(str.charAt(i4), 10);
            if (digit2 >= 0) {
                i3 = (i3 * 10) - digit2;
                i4 = i5;
            } else {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i2));
            }
        }
        return -i3;
    }

    public static String format(Date date, boolean z) {
        return format(date, z, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(19 + (z ? 4 : 0) + (timeZone.getRawOffset() == 0 ? 1 : 6));
        padInt(sb, gregorianCalendar.get(1), 4);
        char c = '-';
        sb.append('-');
        padInt(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        padInt(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(13), 2);
        if (z) {
            sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            padInt(sb, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i = offset / 60000;
            int abs = Math.abs(i / 60);
            int abs2 = Math.abs(i % 60);
            if (offset >= 0) {
                c = '+';
            }
            sb.append(c);
            padInt(sb, abs, 2);
            sb.append(':');
            padInt(sb, abs2, 2);
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }
}
