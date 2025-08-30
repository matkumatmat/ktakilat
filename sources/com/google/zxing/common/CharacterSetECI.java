package com.google.zxing.common;

import com.google.zxing.FormatException;
import java.util.HashMap;
import org.apache.commons.lang3.CharEncoding;

public enum CharacterSetECI {
    Cp437((String) new int[]{0, 2}, (int) new String[0]),
    ISO8859_1((String) new int[]{1, 3}, (int) new String[]{CharEncoding.ISO_8859_1}),
    ISO8859_2((String) new String[]{"ISO-8859-2"}, 4),
    ISO8859_3((String) new String[]{"ISO-8859-3"}, 5),
    ISO8859_4((String) new String[]{"ISO-8859-4"}, 6),
    ISO8859_5((String) new String[]{"ISO-8859-5"}, 7),
    ISO8859_6((String) new String[]{"ISO-8859-6"}, 8),
    ISO8859_7((String) new String[]{"ISO-8859-7"}, 9),
    ISO8859_8((String) new String[]{"ISO-8859-8"}, 10),
    ISO8859_9((String) new String[]{"ISO-8859-9"}, 11),
    ISO8859_10((String) new String[]{"ISO-8859-10"}, 12),
    ISO8859_11((String) new String[]{"ISO-8859-11"}, 13),
    ISO8859_13((String) new String[]{"ISO-8859-13"}, 15),
    ISO8859_14((String) new String[]{"ISO-8859-14"}, 16),
    ISO8859_15((String) new String[]{"ISO-8859-15"}, 17),
    ISO8859_16((String) new String[]{"ISO-8859-16"}, 18),
    SJIS((String) new String[]{"Shift_JIS"}, 20),
    Cp1250((String) new String[]{"windows-1250"}, 21),
    Cp1251((String) new String[]{"windows-1251"}, 22),
    Cp1252((String) new String[]{"windows-1252"}, 23),
    Cp1256((String) new String[]{"windows-1256"}, 24),
    UnicodeBigUnmarked((String) new String[]{CharEncoding.UTF_16BE, "UnicodeBig"}, 25),
    UTF8((String) new String[]{CharEncoding.UTF_8}, 26),
    ASCII((String) new int[]{27, 170}, (int) new String[]{CharEncoding.US_ASCII}),
    Big5((String) new int[]{28}, (int) new String[0]),
    GB18030((String) new String[]{"GB2312", "EUC_CN", "GBK"}, 29),
    EUC_KR((String) new String[]{"EUC-KR"}, 30);
    
    public static final HashMap e = null;
    public static final HashMap f = null;
    public final int[] c;
    public final String[] d;

    static {
        e = new HashMap();
        f = new HashMap();
        for (CharacterSetECI characterSetECI : values()) {
            for (int valueOf : characterSetECI.c) {
                e.put(Integer.valueOf(valueOf), characterSetECI);
            }
            f.put(characterSetECI.name(), characterSetECI);
            for (String put : characterSetECI.d) {
                f.put(put, characterSetECI);
            }
        }
    }

    /* access modifiers changed from: public */
    CharacterSetECI(String[] strArr, int i) {
        this.c = new int[]{i};
        this.d = strArr;
    }

    public static CharacterSetECI getCharacterSetECIByName(String str) {
        return (CharacterSetECI) f.get(str);
    }

    public static CharacterSetECI getCharacterSetECIByValue(int i) throws FormatException {
        if (i >= 0 && i < 900) {
            return (CharacterSetECI) e.get(Integer.valueOf(i));
        }
        throw FormatException.getFormatInstance();
    }

    public int getValue() {
        return this.c[0];
    }

    /* access modifiers changed from: public */
    CharacterSetECI(int[] iArr, String... strArr) {
        this.c = iArr;
        this.d = strArr;
    }
}
