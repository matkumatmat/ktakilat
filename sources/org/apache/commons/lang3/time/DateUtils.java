package org.apache.commons.lang3.time;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.LocaleUtils;
import org.apache.commons.lang3.Validate;

public class DateUtils {
    public static final long MILLIS_PER_DAY = 86400000;
    public static final long MILLIS_PER_HOUR = 3600000;
    public static final long MILLIS_PER_MINUTE = 60000;
    public static final long MILLIS_PER_SECOND = 1000;
    public static final int RANGE_MONTH_MONDAY = 6;
    public static final int RANGE_MONTH_SUNDAY = 5;
    public static final int RANGE_WEEK_CENTER = 4;
    public static final int RANGE_WEEK_MONDAY = 2;
    public static final int RANGE_WEEK_RELATIVE = 3;
    public static final int RANGE_WEEK_SUNDAY = 1;
    public static final int SEMI_MONTH = 1001;
    private static final int[][] fields = {new int[]{14}, new int[]{13}, new int[]{12}, new int[]{11, 10}, new int[]{5, 5, 9}, new int[]{2, 1001}, new int[]{1}, new int[]{0}};

    public static class DateIterator implements Iterator<Calendar> {
        private final Calendar endFinal;
        private final Calendar spot;

        public DateIterator(Calendar calendar, Calendar calendar2) {
            this.endFinal = calendar2;
            this.spot = calendar;
            calendar.add(5, -1);
        }

        public boolean hasNext() {
            return this.spot.before(this.endFinal);
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Calendar next() {
            if (!this.spot.equals(this.endFinal)) {
                this.spot.add(5, 1);
                return (Calendar) this.spot.clone();
            }
            throw new NoSuchElementException();
        }
    }

    public enum ModifyType {
        TRUNCATE,
        ROUND,
        CEILING
    }

    private static Date add(Date date, int i, int i2) {
        validateDateNotNull(date);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(i, i2);
        return instance.getTime();
    }

    public static Date addDays(Date date, int i) {
        return add(date, 5, i);
    }

    public static Date addHours(Date date, int i) {
        return add(date, 11, i);
    }

    public static Date addMilliseconds(Date date, int i) {
        return add(date, 14, i);
    }

    public static Date addMinutes(Date date, int i) {
        return add(date, 12, i);
    }

    public static Date addMonths(Date date, int i) {
        return add(date, 2, i);
    }

    public static Date addSeconds(Date date, int i) {
        return add(date, 13, i);
    }

    public static Date addWeeks(Date date, int i) {
        return add(date, 3, i);
    }

    public static Date addYears(Date date, int i) {
        return add(date, 1, i);
    }

    public static Date ceiling(Date date, int i) {
        validateDateNotNull(date);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        modify(instance, i, ModifyType.CEILING);
        return instance.getTime();
    }

    private static long getFragment(Date date, int i, TimeUnit timeUnit) {
        validateDateNotNull(date);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return getFragment(instance, i, timeUnit);
    }

    public static long getFragmentInDays(Date date, int i) {
        return getFragment(date, i, TimeUnit.DAYS);
    }

    public static long getFragmentInHours(Date date, int i) {
        return getFragment(date, i, TimeUnit.HOURS);
    }

    public static long getFragmentInMilliseconds(Date date, int i) {
        return getFragment(date, i, TimeUnit.MILLISECONDS);
    }

    public static long getFragmentInMinutes(Date date, int i) {
        return getFragment(date, i, TimeUnit.MINUTES);
    }

    public static long getFragmentInSeconds(Date date, int i) {
        return getFragment(date, i, TimeUnit.SECONDS);
    }

    public static boolean isSameDay(Date date, Date date2) {
        if (date == null || date2 == null) {
            throw nullDateIllegalArgumentException();
        }
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date2);
        return isSameDay(instance, instance2);
    }

    public static boolean isSameInstant(Date date, Date date2) {
        if (date != null && date2 != null) {
            return date.getTime() == date2.getTime();
        }
        throw nullDateIllegalArgumentException();
    }

    public static boolean isSameLocalTime(Calendar calendar, Calendar calendar2) {
        if (calendar == null || calendar2 == null) {
            throw nullDateIllegalArgumentException();
        } else if (calendar.get(14) == calendar2.get(14) && calendar.get(13) == calendar2.get(13) && calendar.get(12) == calendar2.get(12) && calendar.get(11) == calendar2.get(11) && calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1) && calendar.get(0) == calendar2.get(0) && calendar.getClass() == calendar2.getClass()) {
            return true;
        } else {
            return false;
        }
    }

    public static Iterator<Calendar> iterator(Date date, int i) {
        validateDateNotNull(date);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return iterator(instance, i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:83:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0133 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void modify(java.util.Calendar r16, int r17, org.apache.commons.lang3.time.DateUtils.ModifyType r18) {
        /*
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = 1
            int r4 = r0.get(r3)
            r5 = 280000000(0x10b07600, float:6.960157E-29)
            if (r4 > r5) goto L_0x0147
            r4 = 14
            if (r1 != r4) goto L_0x0015
            return
        L_0x0015:
            java.util.Date r5 = r16.getTime()
            long r6 = r5.getTime()
            int r4 = r0.get(r4)
            org.apache.commons.lang3.time.DateUtils$ModifyType r8 = org.apache.commons.lang3.time.DateUtils.ModifyType.TRUNCATE
            if (r8 == r2) goto L_0x0029
            r9 = 500(0x1f4, float:7.0E-43)
            if (r4 >= r9) goto L_0x002b
        L_0x0029:
            long r9 = (long) r4
            long r6 = r6 - r9
        L_0x002b:
            r4 = 13
            if (r1 != r4) goto L_0x0031
            r10 = 1
            goto L_0x0032
        L_0x0031:
            r10 = 0
        L_0x0032:
            int r4 = r0.get(r4)
            r11 = 30
            if (r10 != 0) goto L_0x0044
            if (r8 == r2) goto L_0x003e
            if (r4 >= r11) goto L_0x0044
        L_0x003e:
            long r12 = (long) r4
            r14 = 1000(0x3e8, double:4.94E-321)
            long r12 = r12 * r14
            long r6 = r6 - r12
        L_0x0044:
            r4 = 12
            if (r1 != r4) goto L_0x0049
            r10 = 1
        L_0x0049:
            int r12 = r0.get(r4)
            if (r10 != 0) goto L_0x005a
            if (r8 == r2) goto L_0x0053
            if (r12 >= r11) goto L_0x005a
        L_0x0053:
            long r10 = (long) r12
            r12 = 60000(0xea60, double:2.9644E-319)
            long r10 = r10 * r12
            long r6 = r6 - r10
        L_0x005a:
            long r10 = r5.getTime()
            int r8 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0068
            r5.setTime(r6)
            r0.setTime(r5)
        L_0x0068:
            int[][] r5 = fields
            int r6 = r5.length
            r7 = 0
            r8 = 0
        L_0x006d:
            if (r7 >= r6) goto L_0x0139
            r10 = r5[r7]
            int r11 = r10.length
            r12 = 0
        L_0x0073:
            r14 = 2
            r15 = 15
            r9 = 1001(0x3e9, float:1.403E-42)
            r4 = 5
            if (r12 >= r11) goto L_0x00c6
            r13 = r10[r12]
            if (r13 != r1) goto L_0x00c0
            org.apache.commons.lang3.time.DateUtils$ModifyType r5 = org.apache.commons.lang3.time.DateUtils.ModifyType.CEILING
            if (r2 == r5) goto L_0x0089
            org.apache.commons.lang3.time.DateUtils$ModifyType r5 = org.apache.commons.lang3.time.DateUtils.ModifyType.ROUND
            if (r2 != r5) goto L_0x00bf
            if (r8 == 0) goto L_0x00bf
        L_0x0089:
            if (r1 != r9) goto L_0x009e
            int r1 = r0.get(r4)
            if (r1 != r3) goto L_0x0095
            r0.add(r4, r15)
            goto L_0x00bf
        L_0x0095:
            r1 = -15
            r0.add(r4, r1)
            r0.add(r14, r3)
            goto L_0x00bf
        L_0x009e:
            r2 = 9
            if (r1 != r2) goto L_0x00b9
            r1 = 11
            int r2 = r0.get(r1)
            if (r2 != 0) goto L_0x00b0
            r2 = 12
            r0.add(r1, r2)
            goto L_0x00bf
        L_0x00b0:
            r2 = -12
            r0.add(r1, r2)
            r0.add(r4, r3)
            goto L_0x00bf
        L_0x00b9:
            r13 = 0
            r1 = r10[r13]
            r0.add(r1, r3)
        L_0x00bf:
            return
        L_0x00c0:
            r13 = 0
            int r12 = r12 + 1
            r4 = 12
            goto L_0x0073
        L_0x00c6:
            r12 = 9
            r13 = 0
            if (r1 == r12) goto L_0x00ea
            if (r1 == r9) goto L_0x00d0
        L_0x00cd:
            r9 = 12
            goto L_0x0104
        L_0x00d0:
            r9 = r10[r13]
            if (r9 != r4) goto L_0x00cd
            int r4 = r0.get(r4)
            int r8 = r4 + -1
            if (r8 < r15) goto L_0x00df
            int r4 = r4 + -16
            goto L_0x00e0
        L_0x00df:
            r4 = r8
        L_0x00e0:
            r8 = 7
            if (r4 <= r8) goto L_0x00e5
            r8 = 1
            goto L_0x00e6
        L_0x00e5:
            r8 = 0
        L_0x00e6:
            r9 = 12
        L_0x00e8:
            r13 = 1
            goto L_0x0106
        L_0x00ea:
            r4 = 0
            r9 = r10[r4]
            r4 = 11
            if (r9 != r4) goto L_0x00cd
            int r4 = r0.get(r4)
            r9 = 12
            if (r4 < r9) goto L_0x00fb
            int r4 = r4 + -12
        L_0x00fb:
            r13 = r4
            r4 = 6
            if (r13 < r4) goto L_0x0101
            r8 = 1
            goto L_0x0102
        L_0x0101:
            r8 = 0
        L_0x0102:
            r4 = r13
            goto L_0x00e8
        L_0x0104:
            r4 = 0
            r13 = 0
        L_0x0106:
            if (r13 != 0) goto L_0x0126
            r13 = 0
            r4 = r10[r13]
            int r4 = r0.getActualMinimum(r4)
            r8 = r10[r13]
            int r8 = r0.getActualMaximum(r8)
            r11 = r10[r13]
            int r11 = r0.get(r11)
            int r11 = r11 - r4
            int r8 = r8 - r4
            int r8 = r8 / r14
            if (r11 <= r8) goto L_0x0122
            r4 = 1
            goto L_0x0123
        L_0x0122:
            r4 = 0
        L_0x0123:
            r8 = r4
            r4 = r11
            goto L_0x0127
        L_0x0126:
            r13 = 0
        L_0x0127:
            if (r4 == 0) goto L_0x0133
            r10 = r10[r13]
            int r11 = r0.get(r10)
            int r11 = r11 - r4
            r0.set(r10, r11)
        L_0x0133:
            int r7 = r7 + 1
            r4 = 12
            goto L_0x006d
        L_0x0139:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "The field "
            java.lang.String r3 = " is not supported"
            java.lang.String r1 = defpackage.ba.l(r1, r2, r3)
            r0.<init>(r1)
            throw r0
        L_0x0147:
            java.lang.ArithmeticException r0 = new java.lang.ArithmeticException
            java.lang.String r1 = "Calendar value too large for accurate calculations"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.time.DateUtils.modify(java.util.Calendar, int, org.apache.commons.lang3.time.DateUtils$ModifyType):void");
    }

    private static IllegalArgumentException nullDateIllegalArgumentException() {
        return new IllegalArgumentException("The date must not be null");
    }

    public static Date parseDate(String str, String... strArr) throws ParseException {
        return parseDate(str, (Locale) null, strArr);
    }

    public static Date parseDateStrictly(String str, String... strArr) throws ParseException {
        return parseDateStrictly(str, (Locale) null, strArr);
    }

    private static Date parseDateWithLeniency(String str, Locale locale, String[] strArr, boolean z) throws ParseException {
        if (str == null || strArr == null) {
            throw new IllegalArgumentException("Date and Patterns must not be null");
        }
        TimeZone timeZone = TimeZone.getDefault();
        Locale locale2 = LocaleUtils.toLocale(locale);
        ParsePosition parsePosition = new ParsePosition(0);
        Calendar instance = Calendar.getInstance(timeZone, locale2);
        instance.setLenient(z);
        for (String fastDateParser : strArr) {
            FastDateParser fastDateParser2 = new FastDateParser(fastDateParser, timeZone, locale2);
            instance.clear();
            try {
                if (fastDateParser2.parse(str, parsePosition, instance) && parsePosition.getIndex() == str.length()) {
                    return instance.getTime();
                }
            } catch (IllegalArgumentException unused) {
            }
            parsePosition.setIndex(0);
        }
        throw new ParseException("Unable to parse the date: ".concat(str), -1);
    }

    public static Date round(Date date, int i) {
        validateDateNotNull(date);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        modify(instance, i, ModifyType.ROUND);
        return instance.getTime();
    }

    private static Date set(Date date, int i, int i2) {
        validateDateNotNull(date);
        Calendar instance = Calendar.getInstance();
        instance.setLenient(false);
        instance.setTime(date);
        instance.set(i, i2);
        return instance.getTime();
    }

    public static Date setDays(Date date, int i) {
        return set(date, 5, i);
    }

    public static Date setHours(Date date, int i) {
        return set(date, 11, i);
    }

    public static Date setMilliseconds(Date date, int i) {
        return set(date, 14, i);
    }

    public static Date setMinutes(Date date, int i) {
        return set(date, 12, i);
    }

    public static Date setMonths(Date date, int i) {
        return set(date, 2, i);
    }

    public static Date setSeconds(Date date, int i) {
        return set(date, 13, i);
    }

    public static Date setYears(Date date, int i) {
        return set(date, 1, i);
    }

    public static Calendar toCalendar(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return instance;
    }

    public static Date truncate(Date date, int i) {
        validateDateNotNull(date);
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        modify(instance, i, ModifyType.TRUNCATE);
        return instance.getTime();
    }

    public static int truncatedCompareTo(Calendar calendar, Calendar calendar2, int i) {
        return truncate(calendar, i).compareTo(truncate(calendar2, i));
    }

    public static boolean truncatedEquals(Calendar calendar, Calendar calendar2, int i) {
        return truncatedCompareTo(calendar, calendar2, i) == 0;
    }

    private static void validateDateNotNull(Date date) {
        Validate.notNull(date, "date", new Object[0]);
    }

    public static long getFragmentInDays(Calendar calendar, int i) {
        return getFragment(calendar, i, TimeUnit.DAYS);
    }

    public static long getFragmentInHours(Calendar calendar, int i) {
        return getFragment(calendar, i, TimeUnit.HOURS);
    }

    public static long getFragmentInMilliseconds(Calendar calendar, int i) {
        return getFragment(calendar, i, TimeUnit.MILLISECONDS);
    }

    public static long getFragmentInMinutes(Calendar calendar, int i) {
        return getFragment(calendar, i, TimeUnit.MINUTES);
    }

    public static long getFragmentInSeconds(Calendar calendar, int i) {
        return getFragment(calendar, i, TimeUnit.SECONDS);
    }

    public static Date parseDate(String str, Locale locale, String... strArr) throws ParseException {
        return parseDateWithLeniency(str, locale, strArr, true);
    }

    public static Date parseDateStrictly(String str, Locale locale, String... strArr) throws ParseException {
        return parseDateWithLeniency(str, locale, strArr, false);
    }

    public static boolean truncatedEquals(Date date, Date date2, int i) {
        return truncatedCompareTo(date, date2, i) == 0;
    }

    public static boolean isSameInstant(Calendar calendar, Calendar calendar2) {
        if (calendar != null && calendar2 != null) {
            return calendar.getTime().getTime() == calendar2.getTime().getTime();
        }
        throw nullDateIllegalArgumentException();
    }

    public static Calendar toCalendar(Date date, TimeZone timeZone) {
        Calendar instance = Calendar.getInstance(timeZone);
        instance.setTime(date);
        return instance;
    }

    public static int truncatedCompareTo(Date date, Date date2, int i) {
        return truncate(date, i).compareTo(truncate(date2, i));
    }

    private static long getFragment(Calendar calendar, int i, TimeUnit timeUnit) {
        long j;
        if (calendar != null) {
            TimeUnit timeUnit2 = TimeUnit.DAYS;
            int i2 = timeUnit == timeUnit2 ? 0 : 1;
            if (i == 1) {
                j = timeUnit.convert((long) (calendar.get(6) - i2), timeUnit2);
            } else if (i != 2) {
                j = 0;
            } else {
                j = timeUnit.convert((long) (calendar.get(5) - i2), timeUnit2);
            }
            if (i == 1 || i == 2 || i == 5 || i == 6) {
                j += timeUnit.convert((long) calendar.get(11), TimeUnit.HOURS);
            } else {
                switch (i) {
                    case 11:
                        break;
                    case 12:
                        break;
                    case 13:
                        break;
                    case 14:
                        return j;
                    default:
                        throw new IllegalArgumentException(ba.l(i, "The fragment ", " is not supported"));
                }
            }
            j += timeUnit.convert((long) calendar.get(12), TimeUnit.MINUTES);
            j += timeUnit.convert((long) calendar.get(13), TimeUnit.SECONDS);
            return j + timeUnit.convert((long) calendar.get(14), TimeUnit.MILLISECONDS);
        }
        throw nullDateIllegalArgumentException();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002d, code lost:
        r8 = 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Iterator<java.util.Calendar> iterator(java.util.Calendar r8, int r9) {
        /*
            if (r8 == 0) goto L_0x0083
            r0 = -1
            r1 = 5
            r2 = 2
            r3 = 1
            r4 = 7
            switch(r9) {
                case 1: goto L_0x0034;
                case 2: goto L_0x0034;
                case 3: goto L_0x0034;
                case 4: goto L_0x0034;
                case 5: goto L_0x0018;
                case 6: goto L_0x0018;
                default: goto L_0x000a;
            }
        L_0x000a:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "The range style "
            java.lang.String r1 = " is not valid."
            java.lang.String r9 = defpackage.ba.l(r9, r0, r1)
            r8.<init>(r9)
            throw r8
        L_0x0018:
            java.util.Calendar r8 = truncate((java.util.Calendar) r8, (int) r2)
            java.lang.Object r5 = r8.clone()
            java.util.Calendar r5 = (java.util.Calendar) r5
            r5.add(r2, r3)
            r5.add(r1, r0)
            r6 = 6
            if (r9 != r6) goto L_0x002f
            r6 = r5
            r5 = r8
        L_0x002d:
            r8 = 1
            goto L_0x0059
        L_0x002f:
            r6 = r5
            r2 = 1
            r5 = r8
            r8 = 7
            goto L_0x0059
        L_0x0034:
            java.util.Calendar r5 = truncate((java.util.Calendar) r8, (int) r1)
            java.util.Calendar r6 = truncate((java.util.Calendar) r8, (int) r1)
            if (r9 == r2) goto L_0x002d
            r2 = 3
            if (r9 == r2) goto L_0x0053
            r7 = 4
            if (r9 == r7) goto L_0x0047
            r8 = 7
            r2 = 1
            goto L_0x0059
        L_0x0047:
            int r9 = r8.get(r4)
            int r9 = r9 - r2
            int r8 = r8.get(r4)
            int r8 = r8 + r2
            r2 = r9
            goto L_0x0059
        L_0x0053:
            int r2 = r8.get(r4)
            int r8 = r2 + -1
        L_0x0059:
            if (r2 >= r3) goto L_0x005d
            int r2 = r2 + 7
        L_0x005d:
            if (r2 <= r4) goto L_0x0061
            int r2 = r2 + -7
        L_0x0061:
            if (r8 >= r3) goto L_0x0065
            int r8 = r8 + 7
        L_0x0065:
            if (r8 <= r4) goto L_0x0069
            int r8 = r8 + -7
        L_0x0069:
            int r9 = r5.get(r4)
            if (r9 == r2) goto L_0x0073
            r5.add(r1, r0)
            goto L_0x0069
        L_0x0073:
            int r9 = r6.get(r4)
            if (r9 == r8) goto L_0x007d
            r6.add(r1, r3)
            goto L_0x0073
        L_0x007d:
            org.apache.commons.lang3.time.DateUtils$DateIterator r8 = new org.apache.commons.lang3.time.DateUtils$DateIterator
            r8.<init>(r5, r6)
            return r8
        L_0x0083:
            java.lang.IllegalArgumentException r8 = nullDateIllegalArgumentException()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.time.DateUtils.iterator(java.util.Calendar, int):java.util.Iterator");
    }

    public static Calendar ceiling(Calendar calendar, int i) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            modify(calendar2, i, ModifyType.CEILING);
            return calendar2;
        }
        throw nullDateIllegalArgumentException();
    }

    public static Calendar round(Calendar calendar, int i) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            modify(calendar2, i, ModifyType.ROUND);
            return calendar2;
        }
        throw nullDateIllegalArgumentException();
    }

    public static Calendar truncate(Calendar calendar, int i) {
        if (calendar != null) {
            Calendar calendar2 = (Calendar) calendar.clone();
            modify(calendar2, i, ModifyType.TRUNCATE);
            return calendar2;
        }
        throw nullDateIllegalArgumentException();
    }

    public static boolean isSameDay(Calendar calendar, Calendar calendar2) {
        if (calendar == null || calendar2 == null) {
            throw nullDateIllegalArgumentException();
        } else if (calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) {
            return true;
        } else {
            return false;
        }
    }

    public static Date ceiling(Object obj, int i) {
        if (obj == null) {
            throw nullDateIllegalArgumentException();
        } else if (obj instanceof Date) {
            return ceiling((Date) obj, i);
        } else {
            if (obj instanceof Calendar) {
                return ceiling((Calendar) obj, i).getTime();
            }
            throw new ClassCastException("Could not find ceiling of for type: " + obj.getClass());
        }
    }

    public static Date round(Object obj, int i) {
        if (obj == null) {
            throw nullDateIllegalArgumentException();
        } else if (obj instanceof Date) {
            return round((Date) obj, i);
        } else {
            if (obj instanceof Calendar) {
                return round((Calendar) obj, i).getTime();
            }
            throw new ClassCastException("Could not round " + obj);
        }
    }

    public static Date truncate(Object obj, int i) {
        if (obj == null) {
            throw nullDateIllegalArgumentException();
        } else if (obj instanceof Date) {
            return truncate((Date) obj, i);
        } else {
            if (obj instanceof Calendar) {
                return truncate((Calendar) obj, i).getTime();
            }
            throw new ClassCastException("Could not truncate " + obj);
        }
    }

    public static Iterator<?> iterator(Object obj, int i) {
        if (obj == null) {
            throw nullDateIllegalArgumentException();
        } else if (obj instanceof Date) {
            return iterator((Date) obj, i);
        } else {
            if (obj instanceof Calendar) {
                return iterator((Calendar) obj, i);
            }
            throw new ClassCastException("Could not iterate based on " + obj);
        }
    }
}
