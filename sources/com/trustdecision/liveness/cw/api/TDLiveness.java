package com.trustdecision.liveness.cw.api;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import com.trustdecision.liveness.cw.api.illill1ll1.illill1ll1;

public class TDLiveness {
    public static final String COUNTRY_CN = illill1ll1("Ljs=");
    public static final String COUNTRY_FRA = illill1ll1("Kycs");
    public static final String COUNTRY_IDNA = illill1ll1("JDEjMw==");
    public static final String COUNTRY_SG = illill1ll1("0f0b", 46);
    public static final String COUNTRY_TEST = illill1ll1("0838423f", 24);
    public static final String COUNTRY_US = illill1ll1("OCY=");
    public static final String LANG_CN = illill1ll1("064b", 104);
    public static final String LANG_EN = illill1ll1("KDs=");
    public static final String LANG_ES = illill1ll1("KCY=");
    public static final String LANG_ID = illill1ll1("1530", 12);
    private static volatile TDLivenessOption il111liilil;
    private static boolean illill1ll1 = false;
    public static Context mContext;

    public static class Builder {
        private TDLivenessOption illill1ll1 = new TDLivenessOption();

        public Builder actionStageTimeout(int i) {
            this.illill1ll1.setActionStageTimeout(i);
            return this;
        }

        public TDLivenessOption build() {
            return this.illill1ll1;
        }

        public Builder country(String str) {
            this.illill1ll1.setCountry(str);
            return this;
        }

        public Builder detection(String str) {
            this.illill1ll1.setDetectionThreshold(str);
            return this;
        }

        public Builder env(String str) {
            this.illill1ll1.setEnv(str);
            return this;
        }

        public Builder faceMissingInterval(int i) {
            this.illill1ll1.setFaceMissingInterval(i);
            return this;
        }

        public Builder httpTimeout(int i) {
            this.illill1ll1.setHttpTimeout(i);
            return this;
        }

        public Builder language(String str) {
            this.illill1ll1.setLanguage(str);
            return this;
        }

        public Builder partner(String str) {
            return partnerCode(str);
        }

        public Builder partnerCode(String str) {
            this.illill1ll1.setPartnerCode(str);
            return this;
        }

        public Builder partnerKey(String str) {
            this.illill1ll1.setPartnerKey(str);
            return this;
        }

        public Builder playAudio(boolean z) {
            this.illill1ll1.setPlayAudio(z);
            return this;
        }

        public Builder prepareStageTimeout(int i) {
            this.illill1ll1.setPrepareStageTimeout(i);
            return this;
        }

        public Builder showFailResultPage(boolean z) {
            this.illill1ll1.setShowFailResultPage(z);
            return this;
        }

        public Builder showReadyPage(boolean z) {
            this.illill1ll1.setShowReadyPage(z);
            return this;
        }

        public Builder showSuccessResultPage(boolean z) {
            this.illill1ll1.setShowSuccessResultPage(z);
            return this;
        }

        public Builder webViewUrl(String str) {
            this.illill1ll1.setWebViewUrl(str);
            return this;
        }
    }

    public static synchronized TDLivenessOption getOption() {
        TDLivenessOption tDLivenessOption;
        synchronized (TDLiveness.class) {
            tDLivenessOption = il111liilil;
        }
        return tDLivenessOption;
    }

    public static String getSDKVersion() {
        return illill1ll1.lillllil1i1;
    }

    private static String illill1ll1(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 49);
            byte b2 = (byte) (bArr[0] ^ 92);
            bArr[0] = b2;
            int i4 = 1;
            while (i4 < length) {
                byte b3 = bArr[i4];
                bArr[i4] = (byte) ((b2 ^ b3) ^ b);
                i4++;
                b2 = b3;
            }
            return new String(bArr, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0027, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void init(android.content.Context r1, com.trustdecision.liveness.cw.api.TDLivenessOption r2) {
        /*
            java.lang.Class<com.trustdecision.liveness.cw.api.TDLiveness> r0 = com.trustdecision.liveness.cw.api.TDLiveness.class
            monitor-enter(r0)
            if (r1 != 0) goto L_0x0007
            monitor-exit(r0)
            return
        L_0x0007:
            if (r2 != 0) goto L_0x000b
            monitor-exit(r0)
            return
        L_0x000b:
            android.content.Context r1 = r1.getApplicationContext()     // Catch:{ all -> 0x0024 }
            mContext = r1     // Catch:{ all -> 0x0024 }
            setOption(r2)     // Catch:{ all -> 0x0024 }
            boolean r1 = illill1ll1     // Catch:{ all -> 0x0024 }
            if (r1 != 0) goto L_0x0026
            android.content.Context r1 = mContext     // Catch:{ all -> 0x0024 }
            com.trustdecision.liveness.cw.api.i11iliil1li1.illill1ll1.il111liilil(r1)     // Catch:{ all -> 0x0024 }
            com.trustdecision.liveness.cw.api.il111liilil.i11iliil1li1.illill1ll1()     // Catch:{ all -> 0x0024 }
            r1 = 1
            illill1ll1 = r1     // Catch:{ all -> 0x0024 }
            goto L_0x0026
        L_0x0024:
            r1 = move-exception
            goto L_0x0028
        L_0x0026:
            monitor-exit(r0)
            return
        L_0x0028:
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.liveness.cw.api.TDLiveness.init(android.content.Context, com.trustdecision.liveness.cw.api.TDLivenessOption):void");
    }

    public static synchronized void setOption(TDLivenessOption tDLivenessOption) {
        synchronized (TDLiveness.class) {
            il111liilil = tDLivenessOption;
        }
    }

    public static synchronized void showLiveness(String str, TDShowLivenessCallback tDShowLivenessCallback) {
        synchronized (TDLiveness.class) {
            if (getOption() != null || tDShowLivenessCallback == null) {
                illill1ll1.illill1ll1(mContext, str, tDShowLivenessCallback);
            } else {
                tDShowLivenessCallback.onError(illill1ll1.li1i1l1l1iiii1iiii1l1, illill1ll1("KRwJUgQCAU0bBBsaBhdKBBsEBg=="), "");
            }
        }
    }

    public static synchronized void showLiveness(Activity activity, String str, TDShowLivenessCallback tDShowLivenessCallback) {
        synchronized (TDLiveness.class) {
            if (getOption() != null || tDShowLivenessCallback == null) {
                illill1ll1.illill1ll1((Context) activity, str, tDShowLivenessCallback);
            } else {
                tDShowLivenessCallback.onError(illill1ll1.li1i1l1l1iiii1iiii1l1, illill1ll1("1815495107501c0455034d1a49140c5d0b5a16", 9), "");
            }
        }
    }

    private static String illill1ll1(String str) {
        try {
            byte[] decode = Base64.decode(str, 0);
            int length = decode.length;
            byte[] bytes = "mumrj".getBytes();
            int length2 = bytes.length;
            for (int i = 0; i < length; i++) {
                decode[i] = (byte) (decode[i] ^ bytes[i % length2]);
            }
            return new String(decode, "utf-8");
        } catch (Exception unused) {
            return null;
        }
    }
}
