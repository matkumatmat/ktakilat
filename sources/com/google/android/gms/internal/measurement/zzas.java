package com.google.android.gms.internal.measurement;

import java.util.Iterator;

public final class zzas implements Iterable, zzao {
    private final String zza;

    public zzas(String str) {
        if (str != null) {
            this.zza = str;
            return;
        }
        throw new IllegalArgumentException("StringValue cannot be null.");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzas)) {
            return false;
        }
        return this.zza.equals(((zzas) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Iterator iterator() {
        return new zzar(this);
    }

    public final String toString() {
        String str = this.zza;
        return e.q(new StringBuilder(str.length() + 2), "\"", str, "\"");
    }

    public final /* synthetic */ String zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zza;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x017e, code lost:
        com.google.android.gms.internal.measurement.zzh.zza("toUpperCase", 0, r22);
        r6 = r19;
        r1 = new com.google.android.gms.internal.measurement.zzas(r6.zza.trim());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0191, code lost:
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0195, code lost:
        r6 = r19;
        com.google.android.gms.internal.measurement.zzh.zza("toUpperCase", 0, r22);
        r1 = new com.google.android.gms.internal.measurement.zzas(r6.zza.toUpperCase(java.util.Locale.ENGLISH));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01ab, code lost:
        r6 = r19;
        com.google.android.gms.internal.measurement.zzh.zza("toString", 0, r22);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01b5, code lost:
        r6 = r19;
        com.google.android.gms.internal.measurement.zzh.zza("toLowerCase", 0, r22);
        r1 = new com.google.android.gms.internal.measurement.zzas(r6.zza.toLowerCase(java.util.Locale.ENGLISH));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01cb, code lost:
        r6 = r19;
        com.google.android.gms.internal.measurement.zzh.zza("toLocaleLowerCase", 0, r22);
        r1 = new com.google.android.gms.internal.measurement.zzas(r6.zza.toLowerCase());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01df, code lost:
        r6 = r19;
        com.google.android.gms.internal.measurement.zzh.zza(r11, 0, r22);
        r1 = new com.google.android.gms.internal.measurement.zzas(r6.zza.toUpperCase());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01f3, code lost:
        r6 = r19;
        r0 = r22;
        com.google.android.gms.internal.measurement.zzh.zzc("substring", 2, r0);
        r2 = r6.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0202, code lost:
        if (r22.isEmpty() != false) goto L_0x021e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0204, code lost:
        r1 = r21;
        r3 = (int) com.google.android.gms.internal.measurement.zzh.zzi(r1.zza((com.google.android.gms.internal.measurement.zzao) r0.get(0)).zzd().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x021e, code lost:
        r1 = r21;
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0226, code lost:
        if (r22.size() <= 1) goto L_0x0241;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0228, code lost:
        r0 = (int) com.google.android.gms.internal.measurement.zzh.zzi(r1.zza((com.google.android.gms.internal.measurement.zzao) r0.get(1)).zzd().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0241, code lost:
        r0 = r2.length();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0246, code lost:
        r3 = java.lang.Math.min(java.lang.Math.max(r3, 0), r2.length());
        r0 = java.lang.Math.min(java.lang.Math.max(r0, 0), r2.length());
        r1 = new com.google.android.gms.internal.measurement.zzas(r2.substring(java.lang.Math.min(r3, r0), java.lang.Math.max(r3, r0)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0271, code lost:
        r6 = r19;
        r1 = r21;
        r0 = r22;
        com.google.android.gms.internal.measurement.zzh.zzc("split", 2, r0);
        r2 = r6.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0281, code lost:
        if (r2.length() != 0) goto L_0x0296;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0283, code lost:
        r0 = new com.google.android.gms.internal.measurement.zzae(java.util.Arrays.asList(new com.google.android.gms.internal.measurement.zzao[]{r6}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0292, code lost:
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0296, code lost:
        r4 = new java.util.ArrayList();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02a0, code lost:
        if (r22.isEmpty() == false) goto L_0x02a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02a2, code lost:
        r4.add(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02a7, code lost:
        r3 = r1.zza((com.google.android.gms.internal.measurement.zzao) r0.get(0)).zzc();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02ba, code lost:
        if (r22.size() <= 1) goto L_0x02d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02bc, code lost:
        r0 = com.google.android.gms.internal.measurement.zzh.zzh(r1.zza((com.google.android.gms.internal.measurement.zzao) r0.get(1)).zzd().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02d3, code lost:
        r0 = 2147483647L;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x02da, code lost:
        if (r0 != 0) goto L_0x02e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x02dc, code lost:
        r0 = new com.google.android.gms.internal.measurement.zzae();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x02e2, code lost:
        r2 = r2.split(java.util.regex.Pattern.quote(r3), ((int) r0) + 1);
        r5 = r2.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02f2, code lost:
        if (r3.isEmpty() == false) goto L_0x030a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02f4, code lost:
        if (r5 <= 0) goto L_0x030a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x02f6, code lost:
        r8 = r2[0].isEmpty();
        r3 = -1;
        r7 = r5 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0306, code lost:
        if (r2[r7].isEmpty() != false) goto L_0x030d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0308, code lost:
        r7 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x030a, code lost:
        r3 = -1;
        r7 = r5;
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0310, code lost:
        if (((long) r5) <= r0) goto L_0x0313;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0312, code lost:
        r7 = r7 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0313, code lost:
        if (r8 >= r7) goto L_0x0322;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0315, code lost:
        r4.add(new com.google.android.gms.internal.measurement.zzas(r2[r8]));
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0322, code lost:
        r0 = new com.google.android.gms.internal.measurement.zzae(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0329, code lost:
        r6 = r19;
        r1 = r21;
        r0 = r22;
        com.google.android.gms.internal.measurement.zzh.zzc("slice", 2, r0);
        r4 = r6.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0339, code lost:
        if (r22.isEmpty() != false) goto L_0x034f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x033b, code lost:
        r7 = r1.zza((com.google.android.gms.internal.measurement.zzao) r0.get(0)).zzd().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x034f, code lost:
        r7 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0350, code lost:
        r7 = com.google.android.gms.internal.measurement.zzh.zzi(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0356, code lost:
        if (r7 >= 0.0d) goto L_0x0363;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0358, code lost:
        r7 = java.lang.Math.max(((double) r4.length()) + r7, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0363, code lost:
        r7 = java.lang.Math.min(r7, (double) r4.length());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0371, code lost:
        if (r22.size() <= 1) goto L_0x0386;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0373, code lost:
        r0 = r1.zza((com.google.android.gms.internal.measurement.zzao) r0.get(1)).zzd().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0386, code lost:
        r0 = (double) r4.length();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x038b, code lost:
        r0 = com.google.android.gms.internal.measurement.zzh.zzi(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0391, code lost:
        if (r0 >= 0.0d) goto L_0x039e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0393, code lost:
        r0 = java.lang.Math.max(((double) r4.length()) + r0, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x039e, code lost:
        r0 = java.lang.Math.min(r0, (double) r4.length());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x03a7, code lost:
        r2 = (int) r7;
        r1 = new com.google.android.gms.internal.measurement.zzas(r4.substring(r2, java.lang.Math.max(0, ((int) r0) - r2) + r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x03bb, code lost:
        r6 = r19;
        r1 = r21;
        r0 = r22;
        com.google.android.gms.internal.measurement.zzh.zzc(com.google.firebase.analytics.FirebaseAnalytics.Event.SEARCH, 1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03ca, code lost:
        if (r22.isEmpty() != false) goto L_0x03da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x03cc, code lost:
        r16 = r1.zza((com.google.android.gms.internal.measurement.zzao) r0.get(0)).zzc();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x03da, code lost:
        r0 = java.util.regex.Pattern.compile(r16).matcher(r6.zza);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x03e8, code lost:
        if (r0.find() == false) goto L_0x03fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x03ea, code lost:
        r1 = new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r0.start()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x03fa, code lost:
        r0 = new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0407, code lost:
        r6 = r19;
        r1 = r21;
        r0 = r22;
        com.google.android.gms.internal.measurement.zzh.zzc(r17, 2, r0);
        r2 = com.google.android.gms.internal.measurement.zzao.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0419, code lost:
        if (r22.isEmpty() != false) goto L_0x043b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x041b, code lost:
        r16 = r1.zza((com.google.android.gms.internal.measurement.zzao) r0.get(0)).zzc();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x042f, code lost:
        if (r22.size() <= 1) goto L_0x043b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0431, code lost:
        r2 = r1.zza((com.google.android.gms.internal.measurement.zzao) r0.get(1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x043b, code lost:
        r0 = r16;
        r3 = r6.zza;
        r4 = r3.indexOf(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0443, code lost:
        if (r4 < 0) goto L_0x0632;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0447, code lost:
        if ((r2 instanceof com.google.android.gms.internal.measurement.zzai) == false) goto L_0x046f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0449, code lost:
        r8 = 0;
        r2 = ((com.google.android.gms.internal.measurement.zzai) r2).zza(r1, java.util.Arrays.asList(new com.google.android.gms.internal.measurement.zzao[]{new com.google.android.gms.internal.measurement.zzas(r0), new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r4)), r6}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x046f, code lost:
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0470, code lost:
        r5 = r3.substring(r8, r4);
        r2 = r2.zzc();
        r0 = r3.substring(r0.length() + r4);
        r1 = new com.google.android.gms.internal.measurement.zzas(defpackage.e.q(new java.lang.StringBuilder((java.lang.String.valueOf(r5).length() + java.lang.String.valueOf(r2).length()) + java.lang.String.valueOf(r0).length()), r5, r2, r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x04ab, code lost:
        r6 = r19;
        r1 = r21;
        r0 = r22;
        com.google.android.gms.internal.measurement.zzh.zzc("match", 1, r0);
        r2 = r6.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x04bc, code lost:
        if (r22.size() > 0) goto L_0x04c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x04be, code lost:
        r0 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x04c1, code lost:
        r0 = r1.zza((com.google.android.gms.internal.measurement.zzao) r0.get(0)).zzc();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x04d0, code lost:
        r0 = java.util.regex.Pattern.compile(r0).matcher(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x04dc, code lost:
        if (r0.find() == false) goto L_0x04f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x04de, code lost:
        r1 = new com.google.android.gms.internal.measurement.zzae(java.util.Arrays.asList(new com.google.android.gms.internal.measurement.zzao[]{new com.google.android.gms.internal.measurement.zzas(r0.group())}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x04f8, code lost:
        r0 = com.google.android.gms.internal.measurement.zzao.zzg;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x04fc, code lost:
        r6 = r19;
        r1 = r21;
        r0 = r22;
        com.google.android.gms.internal.measurement.zzh.zzc(r18, 2, r0);
        r2 = r6.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x050f, code lost:
        if (r22.size() > 0) goto L_0x0514;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0511, code lost:
        r3 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x0514, code lost:
        r16 = r1.zza((com.google.android.gms.internal.measurement.zzao) r0.get(0)).zzc();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0527, code lost:
        if (r22.size() >= 2) goto L_0x052c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0529, code lost:
        r0 = Double.NaN;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x052c, code lost:
        r0 = r1.zza((com.google.android.gms.internal.measurement.zzao) r0.get(1)).zzd().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0543, code lost:
        if (java.lang.Double.isNaN(r0) == false) goto L_0x0548;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0545, code lost:
        r0 = Double.POSITIVE_INFINITY;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0548, code lost:
        r0 = com.google.android.gms.internal.measurement.zzh.zzi(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x054c, code lost:
        r1 = new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r2.lastIndexOf(r3, (int) r0)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x055d, code lost:
        r6 = r19;
        r1 = r21;
        r0 = r22;
        com.google.android.gms.internal.measurement.zzh.zzc("indexOf", 2, r0);
        r5 = r6.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x056d, code lost:
        if (r22.size() > 0) goto L_0x0572;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x056f, code lost:
        r7 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x0572, code lost:
        r16 = r1.zza((com.google.android.gms.internal.measurement.zzao) r0.get(0)).zzc();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x0586, code lost:
        if (r22.size() >= 2) goto L_0x0589;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x0589, code lost:
        r2 = r1.zza((com.google.android.gms.internal.measurement.zzao) r0.get(1)).zzd().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x059c, code lost:
        r1 = new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r5.indexOf(r7, (int) com.google.android.gms.internal.measurement.zzh.zzi(r2))));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x05b1, code lost:
        r6 = r19;
        r0 = r22;
        com.google.android.gms.internal.measurement.zzh.zza(r12, 1, r0);
        r2 = r6.zza;
        r0 = r21.zza((com.google.android.gms.internal.measurement.zzao) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x05d2, code lost:
        if ("length".equals(r0.zzc()) == false) goto L_0x05d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x05d4, code lost:
        r0 = com.google.android.gms.internal.measurement.zzao.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x05d8, code lost:
        r0 = r0.zzd().doubleValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x05e6, code lost:
        if (r0 != java.lang.Math.floor(r0)) goto L_0x05f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x05e8, code lost:
        r0 = (int) r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x05e9, code lost:
        if (r0 < 0) goto L_0x05f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x05ef, code lost:
        if (r0 >= r2.length()) goto L_0x05f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x05f1, code lost:
        r0 = com.google.android.gms.internal.measurement.zzao.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x05f5, code lost:
        r0 = com.google.android.gms.internal.measurement.zzao.zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x05f9, code lost:
        r6 = r19;
        r1 = r21;
        r0 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x0603, code lost:
        if (r22.isEmpty() != false) goto L_0x0632;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x0605, code lost:
        r3 = new java.lang.StringBuilder(r6.zza);
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x0611, code lost:
        if (r8 >= r22.size()) goto L_0x0627;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x0613, code lost:
        r3.append(r1.zza((com.google.android.gms.internal.measurement.zzao) r0.get(r8)).zzc());
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x0627, code lost:
        r1 = new com.google.android.gms.internal.measurement.zzas(r3.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x0632, code lost:
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x0634, code lost:
        r3 = r19;
        r1 = r21;
        r0 = r22;
        com.google.android.gms.internal.measurement.zzh.zzc(r6, 1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x0642, code lost:
        if (r22.isEmpty() != false) goto L_0x065d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x0644, code lost:
        r8 = (int) com.google.android.gms.internal.measurement.zzh.zzi(r1.zza((com.google.android.gms.internal.measurement.zzao) r0.get(0)).zzd().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x065d, code lost:
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x065f, code lost:
        r0 = r3.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x0661, code lost:
        if (r8 < 0) goto L_0x0678;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x0667, code lost:
        if (r8 < r0.length()) goto L_0x066a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:?, code lost:
        return com.google.android.gms.internal.measurement.zzao.zzm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:?, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:?, code lost:
        return new com.google.android.gms.internal.measurement.zzas(java.lang.String.valueOf(r0.charAt(r8)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b8, code lost:
        r6 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ba, code lost:
        r12 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d2, code lost:
        r6 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d4, code lost:
        r12 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x016a, code lost:
        r1 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x016b, code lost:
        r16 = "undefined";
        r17 = "replace";
        r18 = "lastIndexOf";
        r2 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0173, code lost:
        switch(r1) {
            case 0: goto L_0x0634;
            case 1: goto L_0x05f9;
            case 2: goto L_0x05b1;
            case 3: goto L_0x055d;
            case 4: goto L_0x04fc;
            case 5: goto L_0x04ab;
            case 6: goto L_0x0407;
            case 7: goto L_0x03bb;
            case 8: goto L_0x0329;
            case 9: goto L_0x0271;
            case 10: goto L_0x01f3;
            case 11: goto L_0x01df;
            case 12: goto L_0x01cb;
            case 13: goto L_0x01b5;
            case 14: goto L_0x01ab;
            case 15: goto L_0x0195;
            case 16: goto L_0x017e;
            default: goto L_0x0176;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x017d, code lost:
        throw new java.lang.IllegalArgumentException("Command not supported");
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x015e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzao zzcA(java.lang.String r20, com.google.android.gms.internal.measurement.zzg r21, java.util.List r22) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            java.lang.String r6 = "trim"
            java.lang.String r10 = "charAt"
            boolean r11 = r10.equals(r1)
            java.lang.String r12 = "concat"
            java.lang.String r13 = "toLocaleUpperCase"
            java.lang.String r14 = "toString"
            java.lang.String r15 = "toLocaleLowerCase"
            java.lang.String r4 = "toLowerCase"
            java.lang.String r7 = "substring"
            java.lang.String r9 = "split"
            java.lang.String r5 = "slice"
            java.lang.String r8 = "search"
            java.lang.String r2 = "replace"
            java.lang.String r0 = "match"
            java.lang.String r3 = "lastIndexOf"
            r16 = r10
            java.lang.String r10 = "indexOf"
            r17 = r6
            java.lang.String r6 = "hasOwnProperty"
            r18 = r13
            java.lang.String r13 = "toUpperCase"
            if (r11 != 0) goto L_0x00ae
            boolean r11 = r12.equals(r1)
            if (r11 != 0) goto L_0x00ae
            boolean r11 = r6.equals(r1)
            if (r11 != 0) goto L_0x00ae
            boolean r11 = r10.equals(r1)
            if (r11 != 0) goto L_0x00ae
            boolean r11 = r3.equals(r1)
            if (r11 != 0) goto L_0x00ae
            boolean r11 = r0.equals(r1)
            if (r11 != 0) goto L_0x00ae
            boolean r11 = r2.equals(r1)
            if (r11 != 0) goto L_0x00ae
            boolean r11 = r8.equals(r1)
            if (r11 != 0) goto L_0x00ae
            boolean r11 = r5.equals(r1)
            if (r11 != 0) goto L_0x00ae
            boolean r11 = r9.equals(r1)
            if (r11 != 0) goto L_0x00ae
            boolean r11 = r7.equals(r1)
            if (r11 != 0) goto L_0x00ae
            boolean r11 = r4.equals(r1)
            if (r11 != 0) goto L_0x00ae
            boolean r11 = r15.equals(r1)
            if (r11 != 0) goto L_0x00ae
            boolean r11 = r14.equals(r1)
            if (r11 != 0) goto L_0x00ae
            boolean r11 = r13.equals(r1)
            if (r11 != 0) goto L_0x00ae
            r11 = r18
            boolean r18 = r11.equals(r1)
            if (r18 != 0) goto L_0x00a9
            r18 = r6
            r6 = r17
            boolean r17 = r6.equals(r1)
            if (r17 == 0) goto L_0x009d
            goto L_0x00b1
        L_0x009d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r2 = " is not a String function"
            java.lang.String r1 = defpackage.e.l(r1, r2)
            r0.<init>(r1)
            throw r0
        L_0x00a9:
            r18 = r6
            r6 = r17
            goto L_0x00b1
        L_0x00ae:
            r11 = r18
            goto L_0x00a9
        L_0x00b1:
            int r17 = r20.hashCode()
            switch(r17) {
                case -1789698943: goto L_0x015e;
                case -1776922004: goto L_0x0152;
                case -1464939364: goto L_0x0147;
                case -1361633751: goto L_0x013b;
                case -1354795244: goto L_0x012f;
                case -1137582698: goto L_0x0126;
                case -906336856: goto L_0x011e;
                case -726908483: goto L_0x0115;
                case -467511597: goto L_0x010d;
                case -399551817: goto L_0x0104;
                case 3568674: goto L_0x00fb;
                case 103668165: goto L_0x00f3;
                case 109526418: goto L_0x00ea;
                case 109648666: goto L_0x00e1;
                case 530542161: goto L_0x00d8;
                case 1094496948: goto L_0x00cb;
                case 1943291465: goto L_0x00be;
                default: goto L_0x00b8;
            }
        L_0x00b8:
            r6 = r16
        L_0x00ba:
            r12 = r18
            goto L_0x016a
        L_0x00be:
            boolean r1 = r1.equals(r10)
            if (r1 == 0) goto L_0x00b8
            r6 = r16
            r12 = r18
            r1 = 3
            goto L_0x016b
        L_0x00cb:
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00b8
            r1 = 6
        L_0x00d2:
            r6 = r16
        L_0x00d4:
            r12 = r18
            goto L_0x016b
        L_0x00d8:
            boolean r1 = r1.equals(r7)
            if (r1 == 0) goto L_0x00b8
            r1 = 10
            goto L_0x00d2
        L_0x00e1:
            boolean r1 = r1.equals(r9)
            if (r1 == 0) goto L_0x00b8
            r1 = 9
            goto L_0x00d2
        L_0x00ea:
            boolean r1 = r1.equals(r5)
            if (r1 == 0) goto L_0x00b8
            r1 = 8
            goto L_0x00d2
        L_0x00f3:
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x00b8
            r1 = 5
            goto L_0x00d2
        L_0x00fb:
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x00b8
            r1 = 16
            goto L_0x00d2
        L_0x0104:
            boolean r1 = r1.equals(r13)
            if (r1 == 0) goto L_0x00b8
            r1 = 15
            goto L_0x00d2
        L_0x010d:
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00b8
            r1 = 4
            goto L_0x00d2
        L_0x0115:
            boolean r1 = r1.equals(r11)
            if (r1 == 0) goto L_0x00b8
            r1 = 11
            goto L_0x00d2
        L_0x011e:
            boolean r1 = r1.equals(r8)
            if (r1 == 0) goto L_0x00b8
            r1 = 7
            goto L_0x00d2
        L_0x0126:
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00b8
            r1 = 13
            goto L_0x00d2
        L_0x012f:
            boolean r1 = r1.equals(r12)
            if (r1 == 0) goto L_0x00b8
            r6 = r16
            r12 = r18
            r1 = 1
            goto L_0x016b
        L_0x013b:
            r6 = r16
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x00ba
            r12 = r18
            r1 = 0
            goto L_0x016b
        L_0x0147:
            r6 = r16
            boolean r1 = r1.equals(r15)
            if (r1 == 0) goto L_0x00ba
            r1 = 12
            goto L_0x00d4
        L_0x0152:
            r6 = r16
            boolean r1 = r1.equals(r14)
            if (r1 == 0) goto L_0x00ba
            r1 = 14
            goto L_0x00d4
        L_0x015e:
            r6 = r16
            r12 = r18
            boolean r1 = r1.equals(r12)
            if (r1 == 0) goto L_0x016a
            r1 = 2
            goto L_0x016b
        L_0x016a:
            r1 = -1
        L_0x016b:
            java.lang.String r16 = "undefined"
            r17 = r2
            r18 = r3
            r2 = 0
            switch(r1) {
                case 0: goto L_0x0634;
                case 1: goto L_0x05f9;
                case 2: goto L_0x05b1;
                case 3: goto L_0x055d;
                case 4: goto L_0x04fc;
                case 5: goto L_0x04ab;
                case 6: goto L_0x0407;
                case 7: goto L_0x03bb;
                case 8: goto L_0x0329;
                case 9: goto L_0x0271;
                case 10: goto L_0x01f3;
                case 11: goto L_0x01df;
                case 12: goto L_0x01cb;
                case 13: goto L_0x01b5;
                case 14: goto L_0x01ab;
                case 15: goto L_0x0195;
                case 16: goto L_0x017e;
                default: goto L_0x0176;
            }
        L_0x0176:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Command not supported"
            r0.<init>(r1)
            throw r0
        L_0x017e:
            r0 = r22
            r1 = 0
            com.google.android.gms.internal.measurement.zzh.zza(r13, r1, r0)
            r6 = r19
            java.lang.String r0 = r6.zza
            com.google.android.gms.internal.measurement.zzas r1 = new com.google.android.gms.internal.measurement.zzas
            java.lang.String r0 = r0.trim()
            r1.<init>(r0)
        L_0x0191:
            r3 = r6
            r6 = r1
            goto L_0x067a
        L_0x0195:
            r1 = 0
            r6 = r19
            r0 = r22
            com.google.android.gms.internal.measurement.zzh.zza(r13, r1, r0)
            java.lang.String r0 = r6.zza
            com.google.android.gms.internal.measurement.zzas r1 = new com.google.android.gms.internal.measurement.zzas
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.String r0 = r0.toUpperCase(r2)
            r1.<init>(r0)
            goto L_0x0191
        L_0x01ab:
            r1 = 0
            r6 = r19
            r0 = r22
            com.google.android.gms.internal.measurement.zzh.zza(r14, r1, r0)
            goto L_0x0632
        L_0x01b5:
            r1 = 0
            r6 = r19
            r0 = r22
            com.google.android.gms.internal.measurement.zzh.zza(r4, r1, r0)
            java.lang.String r0 = r6.zza
            com.google.android.gms.internal.measurement.zzas r1 = new com.google.android.gms.internal.measurement.zzas
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.String r0 = r0.toLowerCase(r2)
            r1.<init>(r0)
            goto L_0x0191
        L_0x01cb:
            r1 = 0
            r6 = r19
            r0 = r22
            com.google.android.gms.internal.measurement.zzh.zza(r15, r1, r0)
            java.lang.String r0 = r6.zza
            com.google.android.gms.internal.measurement.zzas r1 = new com.google.android.gms.internal.measurement.zzas
            java.lang.String r0 = r0.toLowerCase()
            r1.<init>(r0)
            goto L_0x0191
        L_0x01df:
            r1 = 0
            r6 = r19
            r0 = r22
            com.google.android.gms.internal.measurement.zzh.zza(r11, r1, r0)
            java.lang.String r0 = r6.zza
            com.google.android.gms.internal.measurement.zzas r1 = new com.google.android.gms.internal.measurement.zzas
            java.lang.String r0 = r0.toUpperCase()
            r1.<init>(r0)
            goto L_0x0191
        L_0x01f3:
            r6 = r19
            r0 = r22
            r1 = 0
            r2 = 2
            com.google.android.gms.internal.measurement.zzh.zzc(r7, r2, r0)
            java.lang.String r2 = r6.zza
            boolean r3 = r22.isEmpty()
            if (r3 != 0) goto L_0x021e
            java.lang.Object r3 = r0.get(r1)
            com.google.android.gms.internal.measurement.zzao r3 = (com.google.android.gms.internal.measurement.zzao) r3
            r1 = r21
            com.google.android.gms.internal.measurement.zzao r3 = r1.zza(r3)
            java.lang.Double r3 = r3.zzd()
            double r3 = r3.doubleValue()
            double r3 = com.google.android.gms.internal.measurement.zzh.zzi(r3)
            int r3 = (int) r3
            goto L_0x0221
        L_0x021e:
            r1 = r21
            r3 = 0
        L_0x0221:
            int r4 = r22.size()
            r5 = 1
            if (r4 <= r5) goto L_0x0241
            java.lang.Object r0 = r0.get(r5)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r1.zza(r0)
            java.lang.Double r0 = r0.zzd()
            double r0 = r0.doubleValue()
            double r0 = com.google.android.gms.internal.measurement.zzh.zzi(r0)
            int r0 = (int) r0
        L_0x023f:
            r1 = 0
            goto L_0x0246
        L_0x0241:
            int r0 = r2.length()
            goto L_0x023f
        L_0x0246:
            int r3 = java.lang.Math.max(r3, r1)
            int r4 = r2.length()
            int r3 = java.lang.Math.min(r3, r4)
            int r0 = java.lang.Math.max(r0, r1)
            int r1 = r2.length()
            int r0 = java.lang.Math.min(r0, r1)
            com.google.android.gms.internal.measurement.zzas r1 = new com.google.android.gms.internal.measurement.zzas
            int r4 = java.lang.Math.min(r3, r0)
            int r0 = java.lang.Math.max(r3, r0)
            java.lang.String r0 = r2.substring(r4, r0)
            r1.<init>(r0)
            goto L_0x0191
        L_0x0271:
            r6 = r19
            r1 = r21
            r0 = r22
            r2 = 2
            com.google.android.gms.internal.measurement.zzh.zzc(r9, r2, r0)
            java.lang.String r2 = r6.zza
            int r3 = r2.length()
            if (r3 != 0) goto L_0x0296
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r1 = 1
            com.google.android.gms.internal.measurement.zzao[] r1 = new com.google.android.gms.internal.measurement.zzao[r1]
            r3 = 0
            r1[r3] = r6
            java.util.List r1 = java.util.Arrays.asList(r1)
            r0.<init>(r1)
        L_0x0292:
            r3 = r6
            r6 = r0
            goto L_0x067a
        L_0x0296:
            r3 = 0
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            boolean r5 = r22.isEmpty()
            if (r5 == 0) goto L_0x02a7
            r4.add(r6)
            goto L_0x0322
        L_0x02a7:
            java.lang.Object r5 = r0.get(r3)
            com.google.android.gms.internal.measurement.zzao r5 = (com.google.android.gms.internal.measurement.zzao) r5
            com.google.android.gms.internal.measurement.zzao r3 = r1.zza(r5)
            java.lang.String r3 = r3.zzc()
            int r5 = r22.size()
            r7 = 1
            if (r5 <= r7) goto L_0x02d3
            java.lang.Object r0 = r0.get(r7)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r1.zza(r0)
            java.lang.Double r0 = r0.zzd()
            double r0 = r0.doubleValue()
            long r0 = com.google.android.gms.internal.measurement.zzh.zzh(r0)
            goto L_0x02d6
        L_0x02d3:
            r0 = 2147483647(0x7fffffff, double:1.060997895E-314)
        L_0x02d6:
            r7 = 0
            int r5 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r5 != 0) goto L_0x02e2
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>()
            goto L_0x0292
        L_0x02e2:
            java.lang.String r5 = java.util.regex.Pattern.quote(r3)
            int r7 = (int) r0
            r8 = 1
            int r7 = r7 + r8
            java.lang.String[] r2 = r2.split(r5, r7)
            int r5 = r2.length
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x030a
            if (r5 <= 0) goto L_0x030a
            r3 = 0
            r3 = r2[r3]
            boolean r8 = r3.isEmpty()
            r3 = -1
            int r7 = r5 + -1
            r9 = r2[r7]
            boolean r9 = r9.isEmpty()
            if (r9 != 0) goto L_0x030d
            r7 = r5
            goto L_0x030d
        L_0x030a:
            r3 = -1
            r7 = r5
            r8 = 0
        L_0x030d:
            long r9 = (long) r5
            int r5 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r5 <= 0) goto L_0x0313
            int r7 = r7 + r3
        L_0x0313:
            if (r8 >= r7) goto L_0x0322
            com.google.android.gms.internal.measurement.zzas r0 = new com.google.android.gms.internal.measurement.zzas
            r1 = r2[r8]
            r0.<init>(r1)
            r4.add(r0)
            r0 = 1
            int r8 = r8 + r0
            goto L_0x0313
        L_0x0322:
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>(r4)
            goto L_0x0292
        L_0x0329:
            r6 = r19
            r1 = r21
            r0 = r22
            r4 = 2
            com.google.android.gms.internal.measurement.zzh.zzc(r5, r4, r0)
            java.lang.String r4 = r6.zza
            boolean r5 = r22.isEmpty()
            if (r5 != 0) goto L_0x034f
            r5 = 0
            java.lang.Object r7 = r0.get(r5)
            com.google.android.gms.internal.measurement.zzao r7 = (com.google.android.gms.internal.measurement.zzao) r7
            com.google.android.gms.internal.measurement.zzao r5 = r1.zza(r7)
            java.lang.Double r5 = r5.zzd()
            double r7 = r5.doubleValue()
            goto L_0x0350
        L_0x034f:
            r7 = r2
        L_0x0350:
            double r7 = com.google.android.gms.internal.measurement.zzh.zzi(r7)
            int r5 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r5 >= 0) goto L_0x0363
            int r5 = r4.length()
            double r9 = (double) r5
            double r9 = r9 + r7
            double r7 = java.lang.Math.max(r9, r2)
            goto L_0x036c
        L_0x0363:
            int r5 = r4.length()
            double r9 = (double) r5
            double r7 = java.lang.Math.min(r7, r9)
        L_0x036c:
            int r5 = r22.size()
            r9 = 1
            if (r5 <= r9) goto L_0x0386
            java.lang.Object r0 = r0.get(r9)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r1.zza(r0)
            java.lang.Double r0 = r0.zzd()
            double r0 = r0.doubleValue()
            goto L_0x038b
        L_0x0386:
            int r0 = r4.length()
            double r0 = (double) r0
        L_0x038b:
            double r0 = com.google.android.gms.internal.measurement.zzh.zzi(r0)
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 >= 0) goto L_0x039e
            int r5 = r4.length()
            double r9 = (double) r5
            double r9 = r9 + r0
            double r0 = java.lang.Math.max(r9, r2)
            goto L_0x03a7
        L_0x039e:
            int r2 = r4.length()
            double r2 = (double) r2
            double r0 = java.lang.Math.min(r0, r2)
        L_0x03a7:
            int r2 = (int) r7
            int r0 = (int) r0
            int r0 = r0 - r2
            r3 = 0
            int r0 = java.lang.Math.max(r3, r0)
            int r0 = r0 + r2
            com.google.android.gms.internal.measurement.zzas r1 = new com.google.android.gms.internal.measurement.zzas
            java.lang.String r0 = r4.substring(r2, r0)
            r1.<init>(r0)
            goto L_0x0191
        L_0x03bb:
            r6 = r19
            r1 = r21
            r0 = r22
            r2 = 1
            r3 = 0
            com.google.android.gms.internal.measurement.zzh.zzc(r8, r2, r0)
            boolean r2 = r22.isEmpty()
            if (r2 != 0) goto L_0x03da
            java.lang.Object r0 = r0.get(r3)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r1.zza(r0)
            java.lang.String r16 = r0.zzc()
        L_0x03da:
            java.lang.String r0 = r6.zza
            java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r16)
            java.util.regex.Matcher r0 = r1.matcher(r0)
            boolean r1 = r0.find()
            if (r1 == 0) goto L_0x03fa
            com.google.android.gms.internal.measurement.zzah r1 = new com.google.android.gms.internal.measurement.zzah
            int r0 = r0.start()
            double r2 = (double) r0
            java.lang.Double r0 = java.lang.Double.valueOf(r2)
            r1.<init>(r0)
            goto L_0x0191
        L_0x03fa:
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            r1 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r0.<init>(r1)
            goto L_0x0292
        L_0x0407:
            r3 = 2
            r6 = r19
            r1 = r21
            r0 = r22
            r2 = r17
            com.google.android.gms.internal.measurement.zzh.zzc(r2, r3, r0)
            com.google.android.gms.internal.measurement.zzao r2 = com.google.android.gms.internal.measurement.zzao.zzf
            boolean r3 = r22.isEmpty()
            if (r3 != 0) goto L_0x043b
            r3 = 0
            java.lang.Object r4 = r0.get(r3)
            com.google.android.gms.internal.measurement.zzao r4 = (com.google.android.gms.internal.measurement.zzao) r4
            com.google.android.gms.internal.measurement.zzao r3 = r1.zza(r4)
            java.lang.String r16 = r3.zzc()
            int r3 = r22.size()
            r4 = 1
            if (r3 <= r4) goto L_0x043b
            java.lang.Object r0 = r0.get(r4)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r2 = r1.zza(r0)
        L_0x043b:
            r0 = r16
            java.lang.String r3 = r6.zza
            int r4 = r3.indexOf(r0)
            if (r4 < 0) goto L_0x0632
            boolean r5 = r2 instanceof com.google.android.gms.internal.measurement.zzai
            if (r5 == 0) goto L_0x046f
            com.google.android.gms.internal.measurement.zzai r2 = (com.google.android.gms.internal.measurement.zzai) r2
            com.google.android.gms.internal.measurement.zzas r5 = new com.google.android.gms.internal.measurement.zzas
            r5.<init>(r0)
            double r7 = (double) r4
            com.google.android.gms.internal.measurement.zzah r9 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r7 = java.lang.Double.valueOf(r7)
            r9.<init>(r7)
            r7 = 3
            com.google.android.gms.internal.measurement.zzao[] r7 = new com.google.android.gms.internal.measurement.zzao[r7]
            r8 = 0
            r7[r8] = r5
            r5 = 1
            r7[r5] = r9
            r5 = 2
            r7[r5] = r6
            java.util.List r5 = java.util.Arrays.asList(r7)
            com.google.android.gms.internal.measurement.zzao r2 = r2.zza(r1, r5)
            goto L_0x0470
        L_0x046f:
            r8 = 0
        L_0x0470:
            com.google.android.gms.internal.measurement.zzas r1 = new com.google.android.gms.internal.measurement.zzas
            java.lang.String r5 = r3.substring(r8, r4)
            java.lang.String r2 = r2.zzc()
            int r0 = r0.length()
            int r0 = r0 + r4
            java.lang.String r0 = r3.substring(r0)
            java.lang.String r3 = java.lang.String.valueOf(r5)
            int r3 = r3.length()
            java.lang.String r4 = java.lang.String.valueOf(r2)
            int r4 = r4.length()
            java.lang.String r7 = java.lang.String.valueOf(r0)
            int r7 = r7.length()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            int r3 = r3 + r4
            int r3 = r3 + r7
            r8.<init>(r3)
            java.lang.String r0 = defpackage.e.q(r8, r5, r2, r0)
            r1.<init>(r0)
            goto L_0x0191
        L_0x04ab:
            r6 = r19
            r1 = r21
            r2 = r0
            r3 = 1
            r0 = r22
            com.google.android.gms.internal.measurement.zzh.zzc(r2, r3, r0)
            java.lang.String r2 = r6.zza
            int r3 = r22.size()
            if (r3 > 0) goto L_0x04c1
            java.lang.String r0 = ""
            goto L_0x04d0
        L_0x04c1:
            r3 = 0
            java.lang.Object r0 = r0.get(r3)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r1.zza(r0)
            java.lang.String r0 = r0.zzc()
        L_0x04d0:
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            java.util.regex.Matcher r0 = r0.matcher(r2)
            boolean r1 = r0.find()
            if (r1 == 0) goto L_0x04f8
            com.google.android.gms.internal.measurement.zzae r1 = new com.google.android.gms.internal.measurement.zzae
            com.google.android.gms.internal.measurement.zzas r2 = new com.google.android.gms.internal.measurement.zzas
            java.lang.String r0 = r0.group()
            r2.<init>(r0)
            r0 = 1
            com.google.android.gms.internal.measurement.zzao[] r0 = new com.google.android.gms.internal.measurement.zzao[r0]
            r3 = 0
            r0[r3] = r2
            java.util.List r0 = java.util.Arrays.asList(r0)
            r1.<init>(r0)
            goto L_0x0191
        L_0x04f8:
            com.google.android.gms.internal.measurement.zzao r0 = com.google.android.gms.internal.measurement.zzao.zzg
            goto L_0x0292
        L_0x04fc:
            r6 = r19
            r1 = r21
            r0 = r22
            r2 = r18
            r3 = 0
            r4 = 2
            com.google.android.gms.internal.measurement.zzh.zzc(r2, r4, r0)
            java.lang.String r2 = r6.zza
            int r5 = r22.size()
            if (r5 > 0) goto L_0x0514
        L_0x0511:
            r3 = r16
            goto L_0x0523
        L_0x0514:
            java.lang.Object r3 = r0.get(r3)
            com.google.android.gms.internal.measurement.zzao r3 = (com.google.android.gms.internal.measurement.zzao) r3
            com.google.android.gms.internal.measurement.zzao r3 = r1.zza(r3)
            java.lang.String r16 = r3.zzc()
            goto L_0x0511
        L_0x0523:
            int r5 = r22.size()
            if (r5 >= r4) goto L_0x052c
            r0 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            goto L_0x053f
        L_0x052c:
            r4 = 1
            java.lang.Object r0 = r0.get(r4)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r1.zza(r0)
            java.lang.Double r0 = r0.zzd()
            double r0 = r0.doubleValue()
        L_0x053f:
            boolean r4 = java.lang.Double.isNaN(r0)
            if (r4 == 0) goto L_0x0548
            r0 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            goto L_0x054c
        L_0x0548:
            double r0 = com.google.android.gms.internal.measurement.zzh.zzi(r0)
        L_0x054c:
            int r0 = (int) r0
            com.google.android.gms.internal.measurement.zzah r1 = new com.google.android.gms.internal.measurement.zzah
            int r0 = r2.lastIndexOf(r3, r0)
            double r2 = (double) r0
            java.lang.Double r0 = java.lang.Double.valueOf(r2)
            r1.<init>(r0)
            goto L_0x0191
        L_0x055d:
            r6 = r19
            r1 = r21
            r0 = r22
            r4 = 2
            com.google.android.gms.internal.measurement.zzh.zzc(r10, r4, r0)
            java.lang.String r5 = r6.zza
            int r7 = r22.size()
            if (r7 > 0) goto L_0x0572
        L_0x056f:
            r7 = r16
            goto L_0x0582
        L_0x0572:
            r7 = 0
            java.lang.Object r7 = r0.get(r7)
            com.google.android.gms.internal.measurement.zzao r7 = (com.google.android.gms.internal.measurement.zzao) r7
            com.google.android.gms.internal.measurement.zzao r7 = r1.zza(r7)
            java.lang.String r16 = r7.zzc()
            goto L_0x056f
        L_0x0582:
            int r8 = r22.size()
            if (r8 >= r4) goto L_0x0589
            goto L_0x059c
        L_0x0589:
            r2 = 1
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r1.zza(r0)
            java.lang.Double r0 = r0.zzd()
            double r2 = r0.doubleValue()
        L_0x059c:
            double r0 = com.google.android.gms.internal.measurement.zzh.zzi(r2)
            int r0 = (int) r0
            com.google.android.gms.internal.measurement.zzah r1 = new com.google.android.gms.internal.measurement.zzah
            int r0 = r5.indexOf(r7, r0)
            double r2 = (double) r0
            java.lang.Double r0 = java.lang.Double.valueOf(r2)
            r1.<init>(r0)
            goto L_0x0191
        L_0x05b1:
            r6 = r19
            r1 = r21
            r0 = r22
            r2 = 1
            com.google.android.gms.internal.measurement.zzh.zza(r12, r2, r0)
            java.lang.String r2 = r6.zza
            r3 = 0
            java.lang.Object r0 = r0.get(r3)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r1.zza(r0)
            java.lang.String r1 = r0.zzc()
            java.lang.String r3 = "length"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x05d8
            com.google.android.gms.internal.measurement.zzao r0 = com.google.android.gms.internal.measurement.zzao.zzk
            goto L_0x0292
        L_0x05d8:
            java.lang.Double r0 = r0.zzd()
            double r0 = r0.doubleValue()
            double r3 = java.lang.Math.floor(r0)
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x05f5
            int r0 = (int) r0
            if (r0 < 0) goto L_0x05f5
            int r1 = r2.length()
            if (r0 >= r1) goto L_0x05f5
            com.google.android.gms.internal.measurement.zzao r0 = com.google.android.gms.internal.measurement.zzao.zzk
            goto L_0x0292
        L_0x05f5:
            com.google.android.gms.internal.measurement.zzao r0 = com.google.android.gms.internal.measurement.zzao.zzl
            goto L_0x0292
        L_0x05f9:
            r6 = r19
            r1 = r21
            r0 = r22
            boolean r2 = r22.isEmpty()
            if (r2 != 0) goto L_0x0632
            java.lang.String r2 = r6.zza
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            r8 = 0
        L_0x060d:
            int r2 = r22.size()
            if (r8 >= r2) goto L_0x0627
            java.lang.Object r2 = r0.get(r8)
            com.google.android.gms.internal.measurement.zzao r2 = (com.google.android.gms.internal.measurement.zzao) r2
            com.google.android.gms.internal.measurement.zzao r2 = r1.zza(r2)
            java.lang.String r2 = r2.zzc()
            r3.append(r2)
            r2 = 1
            int r8 = r8 + r2
            goto L_0x060d
        L_0x0627:
            java.lang.String r0 = r3.toString()
            com.google.android.gms.internal.measurement.zzas r1 = new com.google.android.gms.internal.measurement.zzas
            r1.<init>(r0)
            goto L_0x0191
        L_0x0632:
            r3 = r6
            goto L_0x067a
        L_0x0634:
            r3 = r19
            r1 = r21
            r0 = r22
            r2 = 1
            com.google.android.gms.internal.measurement.zzh.zzc(r6, r2, r0)
            boolean r2 = r22.isEmpty()
            if (r2 != 0) goto L_0x065d
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r1.zza(r0)
            java.lang.Double r0 = r0.zzd()
            double r0 = r0.doubleValue()
            double r0 = com.google.android.gms.internal.measurement.zzh.zzi(r0)
            int r8 = (int) r0
            goto L_0x065f
        L_0x065d:
            r2 = 0
            r8 = 0
        L_0x065f:
            java.lang.String r0 = r3.zza
            if (r8 < 0) goto L_0x0678
            int r1 = r0.length()
            if (r8 < r1) goto L_0x066a
            goto L_0x0678
        L_0x066a:
            com.google.android.gms.internal.measurement.zzas r6 = new com.google.android.gms.internal.measurement.zzas
            char r0 = r0.charAt(r8)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r6.<init>(r0)
            goto L_0x067a
        L_0x0678:
            com.google.android.gms.internal.measurement.zzao r6 = com.google.android.gms.internal.measurement.zzao.zzm
        L_0x067a:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzas.zzcA(java.lang.String, com.google.android.gms.internal.measurement.zzg, java.util.List):com.google.android.gms.internal.measurement.zzao");
    }

    public final Double zzd() {
        String str = this.zza;
        if (str.isEmpty()) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    public final Boolean zze() {
        return Boolean.valueOf(!this.zza.isEmpty());
    }

    public final Iterator zzf() {
        return new zzaq(this);
    }

    public final zzao zzt() {
        return new zzas(this.zza);
    }
}
