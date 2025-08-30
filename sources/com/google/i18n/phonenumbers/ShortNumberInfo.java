package com.google.i18n.phonenumbers;

import com.google.i18n.phonenumbers.internal.RegexBasedMatcher;
import com.google.i18n.phonenumbers.metadata.DefaultMetadataDependenciesProvider;
import com.google.i18n.phonenumbers.metadata.source.RegionMetadataSourceImpl;
import java.util.HashSet;
import java.util.logging.Logger;

public class ShortNumberInfo {

    /* renamed from: com.google.i18n.phonenumbers.ShortNumberInfo$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f318a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.google.i18n.phonenumbers.ShortNumberInfo$ShortNumberCost[] r0 = com.google.i18n.phonenumbers.ShortNumberInfo.ShortNumberCost.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f318a = r0
                com.google.i18n.phonenumbers.ShortNumberInfo$ShortNumberCost r1 = com.google.i18n.phonenumbers.ShortNumberInfo.ShortNumberCost.PREMIUM_RATE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f318a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.i18n.phonenumbers.ShortNumberInfo$ShortNumberCost r1 = com.google.i18n.phonenumbers.ShortNumberInfo.ShortNumberCost.UNKNOWN_COST     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f318a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.i18n.phonenumbers.ShortNumberInfo$ShortNumberCost r1 = com.google.i18n.phonenumbers.ShortNumberInfo.ShortNumberCost.STANDARD_RATE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f318a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.i18n.phonenumbers.ShortNumberInfo$ShortNumberCost r1 = com.google.i18n.phonenumbers.ShortNumberInfo.ShortNumberCost.TOLL_FREE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.i18n.phonenumbers.ShortNumberInfo.AnonymousClass1.<clinit>():void");
        }
    }

    public enum ShortNumberCost {
    }

    static {
        Logger.getLogger(ShortNumberInfo.class.getName());
        new RegexBasedMatcher();
        RegionMetadataSourceImpl regionMetadataSourceImpl = DefaultMetadataDependenciesProvider.e.d;
        CountryCodeToRegionCodeMap.a();
        HashSet hashSet = new HashSet();
        hashSet.add("BR");
        hashSet.add("CL");
        hashSet.add("NI");
    }
}
