package com.google.i18n.phonenumbers;

import com.facebook.appevents.AppEventsConstants;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.Phonemetadata;
import com.google.i18n.phonenumbers.Phonenumber;
import com.google.i18n.phonenumbers.internal.RegexBasedMatcher;
import com.google.i18n.phonenumbers.internal.RegexCache;
import com.google.i18n.phonenumbers.metadata.DefaultMetadataDependenciesProvider;
import com.google.i18n.phonenumbers.metadata.init.ClassPathResourceMetadataLoader;
import com.google.i18n.phonenumbers.metadata.source.MetadataSourceImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.ClassUtils;

public class PhoneNumberUtil {
    public static final Logger h = Logger.getLogger(PhoneNumberUtil.class.getName());
    public static final Map i;
    public static final Map j;
    public static final Map k;
    public static final Map l;
    public static final Map m;
    public static final Pattern n = Pattern.compile("[+＋]+");
    public static final Pattern o = Pattern.compile("(\\p{Nd})");
    public static final Pattern p = Pattern.compile("[+＋\\p{Nd}]");
    public static final Pattern q = Pattern.compile("[\\\\/] *x");
    public static final Pattern r = Pattern.compile("[[\\P{N}&&\\P{L}]&&[^#]]+$");
    public static final Pattern s = Pattern.compile("(?:.*?[A-Za-z]){3}.*");
    public static final String t = a(false);
    public static final Pattern u = Pattern.compile("^\\+(\\p{Nd}|[\\-\\.\\(\\)]?)*\\p{Nd}(\\p{Nd}|[\\-\\.\\(\\)]?)*$");
    public static final Pattern v;
    public static final Pattern w;
    public static final Pattern x;
    public static PhoneNumberUtil y = null;

    /* renamed from: a  reason: collision with root package name */
    public final MetadataSourceImpl f316a;
    public final HashMap b;
    public final RegexBasedMatcher c = new RegexBasedMatcher();
    public final HashSet d = new HashSet(35);
    public final RegexCache e = new RegexCache(100);
    public final HashSet f = new HashSet(320);
    public final HashSet g = new HashSet();

    /* renamed from: com.google.i18n.phonenumbers.PhoneNumberUtil$1  reason: invalid class name */
    class AnonymousClass1 implements Iterable<PhoneNumberMatch> {
        public final Iterator iterator() {
            new PhoneNumberMatcher();
            throw null;
        }
    }

    /* renamed from: com.google.i18n.phonenumbers.PhoneNumberUtil$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f317a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        /* JADX WARNING: Can't wrap try/catch for region: R(39:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|(2:27|28)|29|31|32|33|34|35|36|37|38|39|41|42|43|44|45|46|(3:47|48|50)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(40:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|(2:27|28)|29|31|32|33|34|35|36|37|38|39|41|42|43|44|45|46|(3:47|48|50)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(43:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|31|32|33|34|35|36|37|38|39|41|42|43|44|45|46|47|48|50) */
        /* JADX WARNING: Can't wrap try/catch for region: R(44:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|31|32|33|34|35|36|37|38|39|41|42|43|44|45|46|47|48|50) */
        /* JADX WARNING: Can't wrap try/catch for region: R(45:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|31|32|33|34|35|36|37|38|39|41|42|43|44|45|46|47|48|50) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0095 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x009f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00a9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00c4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00ce */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00d8 */
        static {
            /*
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType[] r0 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                c = r0
                r1 = 1
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r2 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.PREMIUM_RATE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = c     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r3 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.TOLL_FREE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = c     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r4 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.MOBILE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = c     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.FIXED_LINE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r4 = c     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.FIXED_LINE_OR_MOBILE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r6 = 5
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r4 = c     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.SHARED_COST     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6 = 6
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r4 = c     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.VOIP     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r6 = 7
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r4 = c     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.PERSONAL_NUMBER     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r6 = 8
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r4 = c     // Catch:{ NoSuchFieldError -> 0x006c }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.PAGER     // Catch:{ NoSuchFieldError -> 0x006c }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r6 = 9
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r4 = c     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.UAN     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r6 = 10
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r4 = c     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.VOICEMAIL     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r6 = 11
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberFormat[] r4 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                b = r4
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberFormat r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat.E164     // Catch:{ NoSuchFieldError -> 0x0095 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0095 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0095 }
            L_0x0095:
                int[] r4 = b     // Catch:{ NoSuchFieldError -> 0x009f }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberFormat r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat.INTERNATIONAL     // Catch:{ NoSuchFieldError -> 0x009f }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x009f }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x009f }
            L_0x009f:
                int[] r4 = b     // Catch:{ NoSuchFieldError -> 0x00a9 }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberFormat r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat.RFC3966     // Catch:{ NoSuchFieldError -> 0x00a9 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a9 }
                r4[r5] = r2     // Catch:{ NoSuchFieldError -> 0x00a9 }
            L_0x00a9:
                int[] r4 = b     // Catch:{ NoSuchFieldError -> 0x00b3 }
                com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberFormat r5 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat.NATIONAL     // Catch:{ NoSuchFieldError -> 0x00b3 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b3 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x00b3 }
            L_0x00b3:
                com.google.i18n.phonenumbers.Phonenumber$PhoneNumber$CountryCodeSource[] r4 = com.google.i18n.phonenumbers.Phonenumber.PhoneNumber.CountryCodeSource.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f317a = r4
                com.google.i18n.phonenumbers.Phonenumber$PhoneNumber$CountryCodeSource r5 = com.google.i18n.phonenumbers.Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN     // Catch:{ NoSuchFieldError -> 0x00c4 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c4 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x00c4 }
            L_0x00c4:
                int[] r1 = f317a     // Catch:{ NoSuchFieldError -> 0x00ce }
                com.google.i18n.phonenumbers.Phonenumber$PhoneNumber$CountryCodeSource r4 = com.google.i18n.phonenumbers.Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_IDD     // Catch:{ NoSuchFieldError -> 0x00ce }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ce }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x00ce }
            L_0x00ce:
                int[] r0 = f317a     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.google.i18n.phonenumbers.Phonenumber$PhoneNumber$CountryCodeSource r1 = com.google.i18n.phonenumbers.Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r0 = f317a     // Catch:{ NoSuchFieldError -> 0x00e2 }
                com.google.i18n.phonenumbers.Phonenumber$PhoneNumber$CountryCodeSource r1 = com.google.i18n.phonenumbers.Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY     // Catch:{ NoSuchFieldError -> 0x00e2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e2 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00e2 }
            L_0x00e2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.i18n.phonenumbers.PhoneNumberUtil.AnonymousClass2.<clinit>():void");
        }
    }

    public enum Leniency {
    }

    public enum MatchType {
    }

    public enum PhoneNumberFormat {
    }

    public enum PhoneNumberType {
    }

    public enum ValidationResult {
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(54, "9");
        i = Collections.unmodifiableMap(hashMap);
        HashSet hashSet = new HashSet();
        hashSet.add(86);
        Collections.unmodifiableSet(hashSet);
        HashSet hashSet2 = new HashSet();
        hashSet2.add(52);
        Collections.unmodifiableSet(hashSet2);
        HashSet hashSet3 = new HashSet();
        hashSet3.add(52);
        hashSet3.add(54);
        hashSet3.add(55);
        hashSet3.add(62);
        hashSet3.addAll(hashSet);
        Collections.unmodifiableSet(hashSet3);
        HashMap hashMap2 = new HashMap();
        hashMap2.put('0', '0');
        hashMap2.put('1', '1');
        hashMap2.put('2', '2');
        hashMap2.put('3', '3');
        hashMap2.put('4', '4');
        hashMap2.put('5', '5');
        hashMap2.put('6', '6');
        hashMap2.put('7', '7');
        hashMap2.put('8', '8');
        hashMap2.put('9', '9');
        HashMap hashMap3 = new HashMap(40);
        hashMap3.put('A', '2');
        hashMap3.put('B', '2');
        hashMap3.put('C', '2');
        hashMap3.put('D', '3');
        hashMap3.put('E', '3');
        hashMap3.put('F', '3');
        hashMap3.put('G', '4');
        hashMap3.put('H', '4');
        hashMap3.put('I', '4');
        hashMap3.put('J', '5');
        hashMap3.put('K', '5');
        hashMap3.put('L', '5');
        hashMap3.put('M', '6');
        hashMap3.put('N', '6');
        hashMap3.put('O', '6');
        hashMap3.put('P', '7');
        hashMap3.put('Q', '7');
        hashMap3.put('R', '7');
        hashMap3.put('S', '7');
        hashMap3.put('T', '8');
        hashMap3.put('U', '8');
        hashMap3.put('V', '8');
        hashMap3.put('W', '9');
        hashMap3.put('X', '9');
        hashMap3.put('Y', '9');
        hashMap3.put('Z', '9');
        Map unmodifiableMap = Collections.unmodifiableMap(hashMap3);
        k = unmodifiableMap;
        HashMap hashMap4 = new HashMap(100);
        hashMap4.putAll(unmodifiableMap);
        hashMap4.putAll(hashMap2);
        l = Collections.unmodifiableMap(hashMap4);
        HashMap hashMap5 = new HashMap();
        hashMap5.putAll(hashMap2);
        hashMap5.put('+', '+');
        hashMap5.put('*', '*');
        hashMap5.put('#', '#');
        j = Collections.unmodifiableMap(hashMap5);
        HashMap hashMap6 = new HashMap();
        for (Character ch : unmodifiableMap.keySet()) {
            hashMap6.put(Character.valueOf(Character.toLowerCase(ch.charValue())), ch);
            hashMap6.put(ch, ch);
        }
        hashMap6.putAll(hashMap2);
        hashMap6.put('-', '-');
        hashMap6.put(65293, '-');
        hashMap6.put(8208, '-');
        hashMap6.put(8209, '-');
        hashMap6.put(8210, '-');
        hashMap6.put(8211, '-');
        hashMap6.put(8212, '-');
        hashMap6.put(8213, '-');
        hashMap6.put(8722, '-');
        hashMap6.put('/', '/');
        hashMap6.put(65295, '/');
        hashMap6.put(' ', ' ');
        hashMap6.put(12288, ' ');
        hashMap6.put(8288, ' ');
        hashMap6.put(Character.valueOf(ClassUtils.PACKAGE_SEPARATOR_CHAR), Character.valueOf(ClassUtils.PACKAGE_SEPARATOR_CHAR));
        hashMap6.put(65294, Character.valueOf(ClassUtils.PACKAGE_SEPARATOR_CHAR));
        m = Collections.unmodifiableMap(hashMap6);
        Pattern.compile("[\\d]+(?:[~⁓∼～][\\d]+)?");
        StringBuilder sb = new StringBuilder();
        Map map = k;
        sb.append(Arrays.toString(map.keySet().toArray()).replaceAll("[, \\[\\]]", ""));
        sb.append(Arrays.toString(map.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", ""));
        String sb2 = sb.toString();
        Pattern.compile("[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～]+");
        String o2 = ba.o("\\p{Nd}{2}|[+＋]*+(?:[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～*]*\\p{Nd}){3,}[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～*", sb2, "\\p{Nd}]*");
        String a2 = a(true);
        String l2 = e.l(sb2, "\\p{Nd}");
        String o3 = e.o("[", l2, "]+((\\-)*[", l2, "])*");
        String o4 = e.o("[", sb2, "]+((\\-)*[", l2, "])*");
        v = Pattern.compile("^(" + o3 + "\\.)*" + o4 + "\\.?$");
        StringBuilder sb3 = new StringBuilder("(?:");
        sb3.append(a2);
        sb3.append(")$");
        w = Pattern.compile(sb3.toString(), 66);
        x = Pattern.compile(o2 + "(?:" + a2 + ")?", 66);
        Pattern.compile("(\\D+)");
        Pattern.compile("(\\$\\d)");
        Pattern.compile("\\(?\\$1\\)?");
    }

    public PhoneNumberUtil(MetadataSourceImpl metadataSourceImpl, HashMap hashMap) {
        this.f316a = metadataSourceImpl;
        this.b = hashMap;
        for (Map.Entry entry : hashMap.entrySet()) {
            List list = (List) entry.getValue();
            if (list.size() != 1 || !"001".equals(list.get(0))) {
                this.f.addAll(list);
            } else {
                this.g.add(entry.getKey());
            }
        }
        if (this.f.remove("001")) {
            h.log(Level.WARNING, "invalid metadata (country calling code was mapped to the non-geo entity as well as specific region(s))");
        }
        this.d.addAll((Collection) hashMap.get(1));
    }

    public static String a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(";ext=" + b(20));
        sb.append("|");
        sb.append("[  \\t,]*(?:e?xt(?:ensi(?:ó?|ó))?n?|ｅ?ｘｔｎ?|доб|anexo)[:\\.．]?[  \\t,-]*" + b(20) + "#?");
        sb.append("|");
        sb.append("[  \\t,]*(?:[xｘ#＃~～]|int|ｉｎｔ)[:\\.．]?[  \\t,-]*" + b(9) + "#?");
        String r2 = ba.r(sb, "|", "[- ]+" + b(6) + "#");
        if (!z) {
            return r2;
        }
        return r2 + "|" + ("[  \\t]*(?:,{2}|;)[:\\.．]?[  \\t,-]*" + b(15) + "#?") + "|" + ("[  \\t]*(?:,)+[:\\.．]?[  \\t,-]*" + b(9) + "#?");
    }

    public static String b(int i2) {
        return ba.l(i2, "(\\p{Nd}{1,", "})");
    }

    public static synchronized PhoneNumberUtil c() {
        PhoneNumberUtil phoneNumberUtil;
        synchronized (PhoneNumberUtil.class) {
            try {
                if (y == null) {
                    DefaultMetadataDependenciesProvider defaultMetadataDependenciesProvider = DefaultMetadataDependenciesProvider.e;
                    ClassPathResourceMetadataLoader classPathResourceMetadataLoader = defaultMetadataDependenciesProvider.b;
                    if (classPathResourceMetadataLoader != null) {
                        k(new PhoneNumberUtil(new MetadataSourceImpl(defaultMetadataDependenciesProvider.c, classPathResourceMetadataLoader, defaultMetadataDependenciesProvider.f322a), CountryCodeToRegionCodeMap.a()));
                    } else {
                        throw new IllegalArgumentException("metadataLoader could not be null.");
                    }
                }
                phoneNumberUtil = y;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return phoneNumberUtil;
    }

    public static Phonemetadata.PhoneNumberDesc e(Phonemetadata.PhoneMetadata phoneMetadata, PhoneNumberType phoneNumberType) {
        switch (AnonymousClass2.c[phoneNumberType.ordinal()]) {
            case 1:
                return phoneMetadata.getPremiumRate();
            case 2:
                return phoneMetadata.getTollFree();
            case 3:
                return phoneMetadata.getMobile();
            case 4:
            case 5:
                return phoneMetadata.getFixedLine();
            case 6:
                return phoneMetadata.getSharedCost();
            case 7:
                return phoneMetadata.getVoip();
            case 8:
                return phoneMetadata.getPersonalNumber();
            case 9:
                return phoneMetadata.getPager();
            case 10:
                return phoneMetadata.getUan();
            case 11:
                return phoneMetadata.getVoicemail();
            default:
                return phoneMetadata.getGeneralDesc();
        }
    }

    public static void h(StringBuilder sb) {
        if (s.matcher(sb).matches()) {
            int length = sb.length();
            StringBuilder sb2 = new StringBuilder(sb.length());
            for (int i2 = 0; i2 < sb.length(); i2++) {
                Character ch = (Character) l.get(Character.valueOf(Character.toUpperCase(sb.charAt(i2))));
                if (ch != null) {
                    sb2.append(ch);
                }
            }
            sb.replace(0, length, sb2.toString());
            return;
        }
        sb.replace(0, sb.length(), i(sb, false).toString());
    }

    public static StringBuilder i(CharSequence charSequence, boolean z) {
        StringBuilder sb = new StringBuilder(charSequence.length());
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char charAt = charSequence.charAt(i2);
            int digit = Character.digit(charAt, 10);
            if (digit != -1) {
                sb.append(digit);
            } else if (z) {
                sb.append(charAt);
            }
        }
        return sb;
    }

    public static synchronized void k(PhoneNumberUtil phoneNumberUtil) {
        synchronized (PhoneNumberUtil.class) {
            y = phoneNumberUtil;
        }
    }

    public static ValidationResult l(CharSequence charSequence, Phonemetadata.PhoneMetadata phoneMetadata, PhoneNumberType phoneNumberType) {
        ArrayList arrayList;
        List<Integer> list;
        Phonemetadata.PhoneNumberDesc e2 = e(phoneMetadata, phoneNumberType);
        if (e2.getPossibleLengthList().isEmpty()) {
            arrayList = phoneMetadata.getGeneralDesc().getPossibleLengthList();
        } else {
            arrayList = e2.getPossibleLengthList();
        }
        List<Integer> possibleLengthLocalOnlyList = e2.getPossibleLengthLocalOnlyList();
        if (phoneNumberType == PhoneNumberType.FIXED_LINE_OR_MOBILE) {
            Phonemetadata.PhoneNumberDesc e3 = e(phoneMetadata, PhoneNumberType.FIXED_LINE);
            if (e3.getPossibleLengthCount() == 1 && e3.getPossibleLength(0) == -1) {
                return l(charSequence, phoneMetadata, PhoneNumberType.MOBILE);
            }
            Phonemetadata.PhoneNumberDesc e4 = e(phoneMetadata, PhoneNumberType.MOBILE);
            if (!(e4.getPossibleLengthCount() == 1 && e4.getPossibleLength(0) == -1)) {
                ArrayList arrayList2 = new ArrayList(arrayList);
                if (e4.getPossibleLengthCount() == 0) {
                    list = phoneMetadata.getGeneralDesc().getPossibleLengthList();
                } else {
                    list = e4.getPossibleLengthList();
                }
                arrayList2.addAll(list);
                Collections.sort(arrayList2);
                if (possibleLengthLocalOnlyList.isEmpty()) {
                    possibleLengthLocalOnlyList = e4.getPossibleLengthLocalOnlyList();
                } else {
                    ArrayList arrayList3 = new ArrayList(possibleLengthLocalOnlyList);
                    arrayList3.addAll(e4.getPossibleLengthLocalOnlyList());
                    Collections.sort(arrayList3);
                    possibleLengthLocalOnlyList = arrayList3;
                }
                arrayList = arrayList2;
            }
        }
        if (((Integer) arrayList.get(0)).intValue() == -1) {
            return ValidationResult.INVALID_LENGTH;
        }
        int length = charSequence.length();
        if (possibleLengthLocalOnlyList.contains(Integer.valueOf(length))) {
            return ValidationResult.IS_POSSIBLE_LOCAL_ONLY;
        }
        int intValue = ((Integer) arrayList.get(0)).intValue();
        if (intValue == length) {
            return ValidationResult.IS_POSSIBLE;
        }
        if (intValue > length) {
            return ValidationResult.TOO_SHORT;
        }
        if (((Integer) e.f(arrayList, 1)).intValue() < length) {
            return ValidationResult.TOO_LONG;
        }
        if (arrayList.subList(1, arrayList.size()).contains(Integer.valueOf(length))) {
            return ValidationResult.IS_POSSIBLE;
        }
        return ValidationResult.INVALID_LENGTH;
    }

    public final Phonemetadata.PhoneMetadata d(String str) {
        if (str == null || !this.f.contains(str)) {
            return null;
        }
        Phonemetadata.PhoneMetadata b2 = this.f316a.b(str);
        String concat = "Missing metadata for region code ".concat(str);
        if (b2 != null) {
            return b2;
        }
        throw new MissingMetadataException(concat);
    }

    public final int f(CharSequence charSequence, Phonemetadata.PhoneMetadata phoneMetadata, StringBuilder sb, boolean z, Phonenumber.PhoneNumber phoneNumber) {
        String str;
        Phonenumber.PhoneNumber.CountryCodeSource countryCodeSource;
        int i2 = 0;
        if (charSequence.length() == 0) {
            return 0;
        }
        StringBuilder sb2 = new StringBuilder(charSequence);
        if (phoneMetadata != null) {
            str = phoneMetadata.getInternationalPrefix();
        } else {
            str = "NonMatch";
        }
        int i3 = 1;
        if (sb2.length() == 0) {
            countryCodeSource = Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY;
        } else {
            Matcher matcher = n.matcher(sb2);
            if (matcher.lookingAt()) {
                sb2.delete(0, matcher.end());
                h(sb2);
                countryCodeSource = Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN;
            } else {
                Pattern a2 = this.e.a(str);
                h(sb2);
                Matcher matcher2 = a2.matcher(sb2);
                if (matcher2.lookingAt()) {
                    int end = matcher2.end();
                    Matcher matcher3 = o.matcher(sb2.substring(end));
                    if (!matcher3.find() || !i(matcher3.group(1), false).toString().equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                        sb2.delete(0, end);
                        countryCodeSource = Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_IDD;
                    }
                }
                countryCodeSource = Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY;
            }
        }
        if (z) {
            phoneNumber.setCountryCodeSource(countryCodeSource);
        }
        if (countryCodeSource == Phonenumber.PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY) {
            if (phoneMetadata != null) {
                int countryCode = phoneMetadata.getCountryCode();
                String valueOf = String.valueOf(countryCode);
                String sb3 = sb2.toString();
                if (sb3.startsWith(valueOf)) {
                    StringBuilder sb4 = new StringBuilder(sb3.substring(valueOf.length()));
                    Phonemetadata.PhoneNumberDesc generalDesc = phoneMetadata.getGeneralDesc();
                    g(sb4, phoneMetadata, (StringBuilder) null);
                    RegexBasedMatcher regexBasedMatcher = this.c;
                    if ((!regexBasedMatcher.a(sb2, generalDesc) && regexBasedMatcher.a(sb4, generalDesc)) || l(sb2, phoneMetadata, PhoneNumberType.UNKNOWN) == ValidationResult.TOO_LONG) {
                        sb.append(sb4);
                        if (z) {
                            phoneNumber.setCountryCodeSource(Phonenumber.PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN);
                        }
                        phoneNumber.setCountryCode(countryCode);
                        return countryCode;
                    }
                }
            }
            phoneNumber.setCountryCode(0);
            return 0;
        } else if (sb2.length() > 2) {
            if (sb2.length() != 0 && sb2.charAt(0) != '0') {
                int length = sb2.length();
                while (true) {
                    if (i3 > 3 || i3 > length) {
                        break;
                    }
                    int parseInt = Integer.parseInt(sb2.substring(0, i3));
                    if (this.b.containsKey(Integer.valueOf(parseInt))) {
                        sb.append(sb2.substring(i3));
                        i2 = parseInt;
                        break;
                    }
                    i3++;
                }
            }
            if (i2 != 0) {
                phoneNumber.setCountryCode(i2);
                return i2;
            }
            throw new NumberParseException(NumberParseException.ErrorType.INVALID_COUNTRY_CODE, "Country calling code supplied was not recognised.");
        } else {
            throw new NumberParseException(NumberParseException.ErrorType.TOO_SHORT_AFTER_IDD, "Phone number had an IDD, but after this was not long enough to be a viable phone number.");
        }
    }

    public final boolean g(StringBuilder sb, Phonemetadata.PhoneMetadata phoneMetadata, StringBuilder sb2) {
        int length = sb.length();
        String nationalPrefixForParsing = phoneMetadata.getNationalPrefixForParsing();
        if (!(length == 0 || nationalPrefixForParsing.length() == 0)) {
            Matcher matcher = this.e.a(nationalPrefixForParsing).matcher(sb);
            if (matcher.lookingAt()) {
                Phonemetadata.PhoneNumberDesc generalDesc = phoneMetadata.getGeneralDesc();
                RegexBasedMatcher regexBasedMatcher = this.c;
                boolean a2 = regexBasedMatcher.a(sb, generalDesc);
                int groupCount = matcher.groupCount();
                String nationalPrefixTransformRule = phoneMetadata.getNationalPrefixTransformRule();
                if (nationalPrefixTransformRule != null && nationalPrefixTransformRule.length() != 0 && matcher.group(groupCount) != null) {
                    StringBuilder sb3 = new StringBuilder(sb);
                    sb3.replace(0, length, matcher.replaceFirst(nationalPrefixTransformRule));
                    if (a2 && !regexBasedMatcher.a(sb3.toString(), generalDesc)) {
                        return false;
                    }
                    if (sb2 != null && groupCount > 1) {
                        sb2.append(matcher.group(1));
                    }
                    sb.replace(0, sb.length(), sb3.toString());
                    return true;
                } else if (a2 && !regexBasedMatcher.a(sb.substring(matcher.end()), generalDesc)) {
                    return false;
                } else {
                    if (!(sb2 == null || groupCount <= 0 || matcher.group(groupCount) == null)) {
                        sb2.append(matcher.group(1));
                    }
                    sb.delete(0, matcher.end());
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0240, code lost:
        if (r0 != com.google.i18n.phonenumbers.PhoneNumberUtil.ValidationResult.INVALID_LENGTH) goto L_0x0244;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.i18n.phonenumbers.Phonenumber.PhoneNumber j(java.lang.String r18, java.lang.String r19) {
        /*
            r17 = this;
            r7 = r17
            r8 = r19
            com.google.i18n.phonenumbers.Phonenumber$PhoneNumber r9 = new com.google.i18n.phonenumbers.Phonenumber$PhoneNumber
            r9.<init>()
            r10 = 0
            if (r18 == 0) goto L_0x02d1
            int r0 = r18.length()
            r1 = 250(0xfa, float:3.5E-43)
            if (r0 > r1) goto L_0x02c7
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = r18.toString()
            java.lang.String r1 = ";phone-context="
            int r1 = r0.indexOf(r1)
            java.lang.String r2 = ""
            r3 = -1
            if (r1 != r3) goto L_0x002a
            r3 = 0
            goto L_0x0045
        L_0x002a:
            int r4 = r1 + 15
            int r5 = r0.length()
            if (r4 < r5) goto L_0x0034
            r3 = r2
            goto L_0x0045
        L_0x0034:
            r5 = 59
            int r5 = r0.indexOf(r5, r4)
            if (r5 == r3) goto L_0x0041
            java.lang.String r3 = r0.substring(r4, r5)
            goto L_0x0045
        L_0x0041:
            java.lang.String r3 = r0.substring(r4)
        L_0x0045:
            if (r3 != 0) goto L_0x0048
            goto L_0x0066
        L_0x0048:
            int r4 = r3.length()
            if (r4 == 0) goto L_0x02bd
            java.util.regex.Pattern r4 = u
            java.util.regex.Matcher r4 = r4.matcher(r3)
            boolean r4 = r4.matches()
            if (r4 != 0) goto L_0x0066
            java.util.regex.Pattern r4 = v
            java.util.regex.Matcher r4 = r4.matcher(r3)
            boolean r4 = r4.matches()
            if (r4 == 0) goto L_0x02bd
        L_0x0066:
            r12 = 0
            if (r3 == 0) goto L_0x0088
            char r4 = r3.charAt(r12)
            r5 = 43
            if (r4 != r5) goto L_0x0074
            r11.append(r3)
        L_0x0074:
            java.lang.String r3 = "tel:"
            int r3 = r0.indexOf(r3)
            if (r3 < 0) goto L_0x007f
            int r3 = r3 + 4
            goto L_0x0080
        L_0x007f:
            r3 = 0
        L_0x0080:
            java.lang.String r0 = r0.substring(r3, r1)
            r11.append(r0)
            goto L_0x00cd
        L_0x0088:
            java.util.regex.Pattern r1 = p
            java.util.regex.Matcher r1 = r1.matcher(r0)
            boolean r3 = r1.find()
            if (r3 == 0) goto L_0x00c9
            int r1 = r1.start()
            int r3 = r0.length()
            java.lang.CharSequence r0 = r0.subSequence(r1, r3)
            java.util.regex.Pattern r1 = r
            java.util.regex.Matcher r1 = r1.matcher(r0)
            boolean r3 = r1.find()
            if (r3 == 0) goto L_0x00b4
            int r1 = r1.start()
            java.lang.CharSequence r0 = r0.subSequence(r12, r1)
        L_0x00b4:
            java.util.regex.Pattern r1 = q
            java.util.regex.Matcher r1 = r1.matcher(r0)
            boolean r3 = r1.find()
            if (r3 == 0) goto L_0x00ca
            int r1 = r1.start()
            java.lang.CharSequence r0 = r0.subSequence(r12, r1)
            goto L_0x00ca
        L_0x00c9:
            r0 = r2
        L_0x00ca:
            r11.append(r0)
        L_0x00cd:
            java.lang.String r0 = ";isub="
            int r0 = r11.indexOf(r0)
            if (r0 <= 0) goto L_0x00dc
            int r1 = r11.length()
            r11.delete(r0, r1)
        L_0x00dc:
            int r0 = r11.length()
            java.util.regex.Pattern r1 = x
            r13 = 2
            if (r0 >= r13) goto L_0x00e7
            r0 = 0
            goto L_0x00ef
        L_0x00e7:
            java.util.regex.Matcher r0 = r1.matcher(r11)
            boolean r0 = r0.matches()
        L_0x00ef:
            if (r0 == 0) goto L_0x02b3
            r14 = 1
            java.util.regex.Pattern r15 = n
            if (r8 == 0) goto L_0x0100
            java.util.HashSet r0 = r7.f
            boolean r0 = r0.contains(r8)
            if (r0 == 0) goto L_0x0100
            r0 = 1
            goto L_0x0101
        L_0x0100:
            r0 = 0
        L_0x0101:
            if (r0 != 0) goto L_0x011e
            int r0 = r11.length()
            if (r0 == 0) goto L_0x0114
            java.util.regex.Matcher r0 = r15.matcher(r11)
            boolean r0 = r0.lookingAt()
            if (r0 == 0) goto L_0x0114
            goto L_0x011e
        L_0x0114:
            com.google.i18n.phonenumbers.NumberParseException r0 = new com.google.i18n.phonenumbers.NumberParseException
            com.google.i18n.phonenumbers.NumberParseException$ErrorType r1 = com.google.i18n.phonenumbers.NumberParseException.ErrorType.INVALID_COUNTRY_CODE
            java.lang.String r2 = "Missing or invalid default region."
            r0.<init>(r1, r2)
            throw r0
        L_0x011e:
            java.util.regex.Pattern r0 = w
            java.util.regex.Matcher r0 = r0.matcher(r11)
            boolean r3 = r0.find()
            if (r3 == 0) goto L_0x0164
            int r3 = r0.start()
            java.lang.String r3 = r11.substring(r12, r3)
            int r4 = r3.length()
            if (r4 >= r13) goto L_0x013a
            r1 = 0
            goto L_0x0142
        L_0x013a:
            java.util.regex.Matcher r1 = r1.matcher(r3)
            boolean r1 = r1.matches()
        L_0x0142:
            if (r1 == 0) goto L_0x0164
            int r1 = r0.groupCount()
            r3 = 1
        L_0x0149:
            if (r3 > r1) goto L_0x0164
            java.lang.String r4 = r0.group(r3)
            if (r4 == 0) goto L_0x0161
            java.lang.String r2 = r0.group(r3)
            int r0 = r0.start()
            int r1 = r11.length()
            r11.delete(r0, r1)
            goto L_0x0164
        L_0x0161:
            int r3 = r3 + 1
            goto L_0x0149
        L_0x0164:
            int r0 = r2.length()
            if (r0 <= 0) goto L_0x016d
            r9.setExtension(r2)
        L_0x016d:
            com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadata r16 = r7.d(r8)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r1 = r17
            r2 = r11
            r3 = r16
            r4 = r6
            r5 = r10
            r18 = r6
            r6 = r9
            int r0 = r1.f(r2, r3, r4, r5, r6)     // Catch:{ NumberParseException -> 0x0185 }
            goto L_0x01af
        L_0x0185:
            r0 = move-exception
            r1 = r0
            java.util.regex.Matcher r0 = r15.matcher(r11)
            com.google.i18n.phonenumbers.NumberParseException$ErrorType r2 = r1.getErrorType()
            com.google.i18n.phonenumbers.NumberParseException$ErrorType r3 = com.google.i18n.phonenumbers.NumberParseException.ErrorType.INVALID_COUNTRY_CODE
            if (r2 != r3) goto L_0x02a5
            boolean r2 = r0.lookingAt()
            if (r2 == 0) goto L_0x02a5
            int r0 = r0.end()
            java.lang.String r2 = r11.substring(r0)
            r1 = r17
            r3 = r16
            r4 = r18
            r5 = r10
            r6 = r9
            int r0 = r1.f(r2, r3, r4, r5, r6)
            if (r0 == 0) goto L_0x029b
        L_0x01af:
            if (r0 == 0) goto L_0x0207
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            java.util.HashMap r2 = r7.b
            java.lang.Object r1 = r2.get(r1)
            java.util.List r1 = (java.util.List) r1
            if (r1 != 0) goto L_0x01c2
            java.lang.String r1 = "ZZ"
            goto L_0x01c9
        L_0x01c2:
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = (java.lang.String) r1
        L_0x01c9:
            boolean r2 = r1.equals(r8)
            if (r2 != 0) goto L_0x0202
            java.lang.String r2 = "001"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x01fd
            java.util.HashSet r1 = r7.g
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            boolean r1 = r1.contains(r2)
            if (r1 != 0) goto L_0x01e5
            r0 = 0
            goto L_0x01f4
        L_0x01e5:
            com.google.i18n.phonenumbers.metadata.source.MetadataSourceImpl r1 = r7.f316a
            com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadata r1 = r1.a(r0)
            java.lang.String r2 = "Missing metadata for country code "
            java.lang.String r0 = defpackage.ba.k(r0, r2)
            if (r1 == 0) goto L_0x01f7
            r0 = r1
        L_0x01f4:
            r16 = r0
            goto L_0x0202
        L_0x01f7:
            com.google.i18n.phonenumbers.MissingMetadataException r1 = new com.google.i18n.phonenumbers.MissingMetadataException
            r1.<init>(r0)
            throw r1
        L_0x01fd:
            com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadata r0 = r7.d(r1)
            goto L_0x01f4
        L_0x0202:
            r1 = r18
        L_0x0204:
            r0 = r16
            goto L_0x0219
        L_0x0207:
            h(r11)
            r1 = r18
            r1.append(r11)
            if (r8 == 0) goto L_0x0204
            int r0 = r16.getCountryCode()
            r9.setCountryCode(r0)
            goto L_0x0204
        L_0x0219:
            int r2 = r1.length()
            java.lang.String r3 = "The string supplied is too short to be a phone number."
            if (r2 < r13) goto L_0x0293
            if (r0 == 0) goto L_0x0243
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r1)
            r7.g(r6, r0, r2)
            com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r2 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.UNKNOWN
            com.google.i18n.phonenumbers.PhoneNumberUtil$ValidationResult r0 = l(r6, r0, r2)
            com.google.i18n.phonenumbers.PhoneNumberUtil$ValidationResult r2 = com.google.i18n.phonenumbers.PhoneNumberUtil.ValidationResult.TOO_SHORT
            if (r0 == r2) goto L_0x0243
            com.google.i18n.phonenumbers.PhoneNumberUtil$ValidationResult r2 = com.google.i18n.phonenumbers.PhoneNumberUtil.ValidationResult.IS_POSSIBLE_LOCAL_ONLY
            if (r0 == r2) goto L_0x0243
            com.google.i18n.phonenumbers.PhoneNumberUtil$ValidationResult r2 = com.google.i18n.phonenumbers.PhoneNumberUtil.ValidationResult.INVALID_LENGTH
            if (r0 == r2) goto L_0x0243
            goto L_0x0244
        L_0x0243:
            r6 = r1
        L_0x0244:
            int r0 = r6.length()
            if (r0 < r13) goto L_0x028b
            r1 = 17
            if (r0 > r1) goto L_0x0281
            int r0 = r6.length()
            if (r0 <= r14) goto L_0x0275
            char r0 = r6.charAt(r12)
            r1 = 48
            if (r0 != r1) goto L_0x0275
            r9.setItalianLeadingZero(r14)
            r0 = 1
        L_0x0260:
            int r2 = r6.length()
            int r2 = r2 - r14
            if (r0 >= r2) goto L_0x0270
            char r2 = r6.charAt(r0)
            if (r2 != r1) goto L_0x0270
            int r0 = r0 + 1
            goto L_0x0260
        L_0x0270:
            if (r0 == r14) goto L_0x0275
            r9.setNumberOfLeadingZeros(r0)
        L_0x0275:
            java.lang.String r0 = r6.toString()
            long r0 = java.lang.Long.parseLong(r0)
            r9.setNationalNumber(r0)
            return r9
        L_0x0281:
            com.google.i18n.phonenumbers.NumberParseException r0 = new com.google.i18n.phonenumbers.NumberParseException
            com.google.i18n.phonenumbers.NumberParseException$ErrorType r1 = com.google.i18n.phonenumbers.NumberParseException.ErrorType.TOO_LONG
            java.lang.String r2 = "The string supplied is too long to be a phone number."
            r0.<init>(r1, r2)
            throw r0
        L_0x028b:
            com.google.i18n.phonenumbers.NumberParseException r0 = new com.google.i18n.phonenumbers.NumberParseException
            com.google.i18n.phonenumbers.NumberParseException$ErrorType r1 = com.google.i18n.phonenumbers.NumberParseException.ErrorType.TOO_SHORT_NSN
            r0.<init>(r1, r3)
            throw r0
        L_0x0293:
            com.google.i18n.phonenumbers.NumberParseException r0 = new com.google.i18n.phonenumbers.NumberParseException
            com.google.i18n.phonenumbers.NumberParseException$ErrorType r1 = com.google.i18n.phonenumbers.NumberParseException.ErrorType.TOO_SHORT_NSN
            r0.<init>(r1, r3)
            throw r0
        L_0x029b:
            com.google.i18n.phonenumbers.NumberParseException r0 = new com.google.i18n.phonenumbers.NumberParseException
            com.google.i18n.phonenumbers.NumberParseException$ErrorType r1 = com.google.i18n.phonenumbers.NumberParseException.ErrorType.INVALID_COUNTRY_CODE
            java.lang.String r2 = "Could not interpret numbers after plus-sign."
            r0.<init>(r1, r2)
            throw r0
        L_0x02a5:
            com.google.i18n.phonenumbers.NumberParseException r0 = new com.google.i18n.phonenumbers.NumberParseException
            com.google.i18n.phonenumbers.NumberParseException$ErrorType r2 = r1.getErrorType()
            java.lang.String r1 = r1.getMessage()
            r0.<init>(r2, r1)
            throw r0
        L_0x02b3:
            com.google.i18n.phonenumbers.NumberParseException r0 = new com.google.i18n.phonenumbers.NumberParseException
            com.google.i18n.phonenumbers.NumberParseException$ErrorType r1 = com.google.i18n.phonenumbers.NumberParseException.ErrorType.NOT_A_NUMBER
            java.lang.String r2 = "The string supplied did not seem to be a phone number."
            r0.<init>(r1, r2)
            throw r0
        L_0x02bd:
            com.google.i18n.phonenumbers.NumberParseException r0 = new com.google.i18n.phonenumbers.NumberParseException
            com.google.i18n.phonenumbers.NumberParseException$ErrorType r1 = com.google.i18n.phonenumbers.NumberParseException.ErrorType.NOT_A_NUMBER
            java.lang.String r2 = "The phone-context value is invalid."
            r0.<init>(r1, r2)
            throw r0
        L_0x02c7:
            com.google.i18n.phonenumbers.NumberParseException r0 = new com.google.i18n.phonenumbers.NumberParseException
            com.google.i18n.phonenumbers.NumberParseException$ErrorType r1 = com.google.i18n.phonenumbers.NumberParseException.ErrorType.TOO_LONG
            java.lang.String r2 = "The string supplied was too long to parse."
            r0.<init>(r1, r2)
            throw r0
        L_0x02d1:
            com.google.i18n.phonenumbers.NumberParseException r0 = new com.google.i18n.phonenumbers.NumberParseException
            com.google.i18n.phonenumbers.NumberParseException$ErrorType r1 = com.google.i18n.phonenumbers.NumberParseException.ErrorType.NOT_A_NUMBER
            java.lang.String r2 = "The phone number supplied was null."
            r0.<init>(r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.i18n.phonenumbers.PhoneNumberUtil.j(java.lang.String, java.lang.String):com.google.i18n.phonenumbers.Phonenumber$PhoneNumber");
    }
}
