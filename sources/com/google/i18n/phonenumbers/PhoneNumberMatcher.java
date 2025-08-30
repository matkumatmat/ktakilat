package com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.internal.RegexCache;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class PhoneNumberMatcher implements Iterator<PhoneNumberMatch> {
    public static final Pattern g;
    public static final Pattern i = Pattern.compile("\\d{1,5}-+\\d{1,5}\\s{0,4}\\(\\d{1,4}");
    public static final Pattern j = Pattern.compile("(?:(?:[0-3]?\\d/[01]?\\d)|(?:[01]?\\d/[0-3]?\\d))/(?:[12]\\d)?\\d{2}");
    public static final Pattern k = Pattern.compile("[12]\\d{3}[-/]?[01]\\d[-/]?[0-3]\\d +[0-2]\\d$");
    public static final Pattern l = Pattern.compile(":[0-5]\\d");
    public static final Pattern m = Pattern.compile("(?:[(\\[（［])?(?:[^(\\[（［)\\]）］]+[)\\]）］])?[^(\\[（［)\\]）］]+(?:[(\\[（［][^(\\[（［)\\]）］]+[)\\]）］])" + a(0, 3) + "[^(\\[（［)\\]）］]*");
    public static final Pattern[] n = {Pattern.compile("/+(.*)"), Pattern.compile("(\\([^(]*)"), Pattern.compile("(?:\\p{Z}-|-\\p{Z})\\p{Z}*(.+)"), Pattern.compile("[‒-―－]\\p{Z}*(.+)"), Pattern.compile("\\.+\\p{Z}*([^.]+)"), Pattern.compile("\\p{Z}+(\\P{Z}+)")};
    public long c;
    public State d = State.c;
    public PhoneNumberMatch e = null;
    public final int f = 0;

    public interface NumberGroupingChecker {
    }

    public enum State {
    }

    static {
        String a2 = a(0, 2);
        String a3 = a(0, 4);
        String a4 = a(0, 20);
        String B = e.B("[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～]", a3);
        String str = "\\p{Nd}" + a(1, 20);
        Pattern.compile("[(\\[（［+＋]");
        StringBuilder u = e.u("(?:[(\\[（［+＋]", B, ")", a2, str);
        u.append("(?:");
        u.append(B);
        u.append(str);
        u.append(")");
        u.append(a4);
        u.append("(?:");
        u.append(PhoneNumberUtil.t);
        u.append(")?");
        g = Pattern.compile(u.toString(), 66);
    }

    public PhoneNumberMatcher() {
        new RegexCache(32);
        throw null;
    }

    public static String a(int i2, int i3) {
        if (i2 < 0 || i3 <= 0 || i3 < i2) {
            throw new IllegalArgumentException();
        }
        return "{" + i2 + "," + i3 + "}";
    }

    public static CharSequence c(Pattern pattern, CharSequence charSequence) {
        Matcher matcher = pattern.matcher(charSequence);
        if (matcher.find()) {
            return charSequence.subSequence(0, matcher.start());
        }
        return charSequence;
    }

    public final PhoneNumberMatch b(CharSequence charSequence, int i2) {
        try {
            if (m.matcher(charSequence).matches() && !i.matcher(charSequence).find()) {
                throw null;
            }
        } catch (NumberParseException unused) {
        }
        return null;
    }

    public final boolean hasNext() {
        State state = this.d;
        State state2 = State.c;
        State state3 = State.d;
        if (state == state2) {
            int i2 = this.f;
            Matcher matcher = g.matcher((CharSequence) null);
            if (this.c <= 0 || !matcher.find(i2)) {
                this.e = null;
                this.d = State.e;
            } else {
                matcher.start();
                matcher.end();
                throw null;
            }
        }
        if (this.d == state3) {
            return true;
        }
        return false;
    }

    public final Object next() {
        if (hasNext()) {
            PhoneNumberMatch phoneNumberMatch = this.e;
            this.e = null;
            this.d = State.c;
            return phoneNumberMatch;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
