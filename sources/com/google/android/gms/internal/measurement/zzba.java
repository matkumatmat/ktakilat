package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Iterator;

public final class zzba {
    /* JADX WARNING: type inference failed for: r0v120, types: [com.google.android.gms.internal.measurement.zzao] */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x020b, code lost:
        if (r26.size() <= 1) goto L_0x0273;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x020d, code lost:
        r1 = java.lang.Math.max(0, (int) com.google.android.gms.internal.measurement.zzh.zzi(r3.zza((com.google.android.gms.internal.measurement.zzao) r0.get(1)).zzd().doubleValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0229, code lost:
        if (r1 <= 0) goto L_0x0245;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x022b, code lost:
        r7 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0232, code lost:
        if (r7 >= java.lang.Math.min(r2, r4 + r1)) goto L_0x0245;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0234, code lost:
        r6.zzn(r6.zzh(), r5.zzl(r4));
        r5.zzr(r4);
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x024a, code lost:
        if (r26.size() <= 2) goto L_0x0286;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x024c, code lost:
        r7 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0251, code lost:
        if (r7 >= r26.size()) goto L_0x0286;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0253, code lost:
        r1 = r3.zza((com.google.android.gms.internal.measurement.zzao) r0.get(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x025f, code lost:
        if ((r1 instanceof com.google.android.gms.internal.measurement.zzag) != false) goto L_0x026b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0261, code lost:
        r5.zzq((r4 + r7) - 2, r1);
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0272, code lost:
        throw new java.lang.IllegalArgumentException("Failed to parse elements to add");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0273, code lost:
        if (r4 >= r2) goto L_0x0286;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0275, code lost:
        r6.zzn(r6.zzh(), r5.zzl(r4));
        r5.zzn(r4, (com.google.android.gms.internal.measurement.zzao) null);
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0289, code lost:
        r5 = r24;
        r3 = r25;
        r0 = r26;
        com.google.android.gms.internal.measurement.zzh.zzc("sort", 1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0298, code lost:
        if (r24.zzh() < 2) goto L_0x043b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x029a, code lost:
        r2 = r24.zzb();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02a2, code lost:
        if (r26.isEmpty() != false) goto L_0x02bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02a4, code lost:
        r0 = r3.zza((com.google.android.gms.internal.measurement.zzao) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02b1, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzai) == false) goto L_0x02b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02b3, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x02be, code lost:
        throw new java.lang.IllegalArgumentException("Comparator should be a method");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x02bf, code lost:
        java.util.Collections.sort(r2, new com.google.android.gms.internal.measurement.zzaz(r1, r3));
        r24.zzp();
        r0 = r2.iterator();
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x02d3, code lost:
        if (r0.hasNext() == false) goto L_0x043b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02d5, code lost:
        r5.zzn(r7, (com.google.android.gms.internal.measurement.zzao) r0.next());
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02e3, code lost:
        r5 = r24;
        r3 = r25;
        r0 = r26;
        com.google.android.gms.internal.measurement.zzh.zza("some", 1, r0);
        r0 = r3.zza((com.google.android.gms.internal.measurement.zzao) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x02fa, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzai) == false) goto L_0x0356;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0300, code lost:
        if (r24.zzh() != 0) goto L_0x0306;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0306, code lost:
        r0 = (com.google.android.gms.internal.measurement.zzai) r0;
        r1 = r24.zzg();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0310, code lost:
        if (r1.hasNext() == false) goto L_0x0352;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0312, code lost:
        r2 = ((java.lang.Integer) r1.next()).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0320, code lost:
        if (r5.zzo(r2) == false) goto L_0x030c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x034c, code lost:
        if (r0.zza(r3, java.util.Arrays.asList(new com.google.android.gms.internal.measurement.zzao[]{r5.zzl(r2), new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r2)), r5})).zze().booleanValue() == false) goto L_0x030c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x035b, code lost:
        throw new java.lang.IllegalArgumentException("Callback should be a method");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x035c, code lost:
        r5 = r24;
        r0 = r26;
        r3 = r25;
        com.google.android.gms.internal.measurement.zzh.zzc("slice", 2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x036b, code lost:
        if (r26.isEmpty() == false) goto L_0x0373;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0373, code lost:
        r1 = (double) r24.zzh();
        r6 = com.google.android.gms.internal.measurement.zzh.zzi(r3.zza((com.google.android.gms.internal.measurement.zzao) r0.get(0)).zzd().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0393, code lost:
        if (r6 >= 0.0d) goto L_0x039b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0395, code lost:
        r6 = java.lang.Math.max(r6 + r1, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x039b, code lost:
        r6 = java.lang.Math.min(r6, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x03a4, code lost:
        if (r26.size() != 2) goto L_0x03cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x03a6, code lost:
        r3 = com.google.android.gms.internal.measurement.zzh.zzi(r3.zza((com.google.android.gms.internal.measurement.zzao) r0.get(1)).zzd().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x03c1, code lost:
        if (r3 >= 0.0d) goto L_0x03c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x03c3, code lost:
        r1 = java.lang.Math.max(r1 + r3, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x03c9, code lost:
        r1 = java.lang.Math.min(r1, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x03cd, code lost:
        r0 = new com.google.android.gms.internal.measurement.zzae();
        r3 = (int) r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x03d6, code lost:
        if (((double) r3) >= r1) goto L_0x07a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x03d8, code lost:
        r0.zzn(r0.zzh(), r5.zzl(r3));
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x03e6, code lost:
        r5 = r24;
        com.google.android.gms.internal.measurement.zzh.zza("shift", 0, r26);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x03f2, code lost:
        if (r24.zzh() != 0) goto L_0x03f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x03f8, code lost:
        r0 = r5.zzl(0);
        r5.zzr(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0401, code lost:
        r5 = r24;
        com.google.android.gms.internal.measurement.zzh.zza(r21, 0, r26);
        r0 = r24.zzh();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x040f, code lost:
        if (r0 == 0) goto L_0x043b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0411, code lost:
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0415, code lost:
        if (r7 >= (r0 / 2)) goto L_0x043b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x041b, code lost:
        if (r5.zzo(r7) == false) goto L_0x0437;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x041d, code lost:
        r2 = r5.zzl(r7);
        r5.zzn(r7, (com.google.android.gms.internal.measurement.zzao) null);
        r3 = (r0 - 1) - r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x042b, code lost:
        if (r5.zzo(r3) == false) goto L_0x0434;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x042d, code lost:
        r5.zzn(r7, r5.zzl(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0434, code lost:
        r5.zzn(r3, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0437, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0458, code lost:
        r5 = r24;
        r3 = r25;
        r0 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0462, code lost:
        if (r26.isEmpty() != false) goto L_0x0480;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0464, code lost:
        r0 = r26.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x046c, code lost:
        if (r0.hasNext() == false) goto L_0x0480;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x046e, code lost:
        r5.zzn(r24.zzh(), r3.zza((com.google.android.gms.internal.measurement.zzao) r0.next()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0490, code lost:
        r5 = r24;
        com.google.android.gms.internal.measurement.zzh.zza("pop", 0, r26);
        r0 = r24.zzh();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x049c, code lost:
        if (r0 != 0) goto L_0x04a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x04a2, code lost:
        r0 = r0 - 1;
        r1 = r5.zzl(r0);
        r5.zzr(r0);
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x04ae, code lost:
        r5 = r24;
        r3 = r25;
        r0 = r26;
        com.google.android.gms.internal.measurement.zzh.zza("map", 1, r0);
        r0 = r3.zza((com.google.android.gms.internal.measurement.zzao) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x04c5, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzan) == false) goto L_0x04dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x04cb, code lost:
        if (r24.zzh() != 0) goto L_0x04d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x04e1, code lost:
        throw new java.lang.IllegalArgumentException("Callback should be a method");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x04e2, code lost:
        r5 = r24;
        r3 = r25;
        r0 = r26;
        com.google.android.gms.internal.measurement.zzh.zzc("lastIndexOf", 2, r0);
        r1 = com.google.android.gms.internal.measurement.zzao.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x04f2, code lost:
        if (r26.isEmpty() != false) goto L_0x04ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x04f4, code lost:
        r1 = r3.zza((com.google.android.gms.internal.measurement.zzao) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x04ff, code lost:
        r2 = r24.zzh() - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x050a, code lost:
        if (r26.size() <= 1) goto L_0x0546;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x050c, code lost:
        r0 = r3.zza((com.google.android.gms.internal.measurement.zzao) r0.get(1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x0522, code lost:
        if (java.lang.Double.isNaN(r0.zzd().doubleValue()) == false) goto L_0x052e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x0524, code lost:
        r2 = (double) (r24.zzh() - 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x052b, code lost:
        r6 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x052e, code lost:
        r2 = com.google.android.gms.internal.measurement.zzh.zzi(r0.zzd().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x053d, code lost:
        if (r2 >= 0.0d) goto L_0x0549;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x053f, code lost:
        r2 = r2 + ((double) r24.zzh());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x0546, code lost:
        r6 = 0.0d;
        r2 = (double) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x054b, code lost:
        if (r2 >= r6) goto L_0x0558;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x0558, code lost:
        r0 = (int) java.lang.Math.min((double) r24.zzh(), r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x0562, code lost:
        if (r0 < 0) goto L_0x0584;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x0568, code lost:
        if (r5.zzo(r0) == false) goto L_0x0581;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x0572, code lost:
        if (com.google.android.gms.internal.measurement.zzh.zzf(r5.zzl(r0), r1) == false) goto L_0x0581;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x0581, code lost:
        r0 = r0 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x058f, code lost:
        r5 = r24;
        r3 = r25;
        r0 = r26;
        r1 = r16;
        com.google.android.gms.internal.measurement.zzh.zzc("join", 1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x059f, code lost:
        if (r24.zzh() != 0) goto L_0x05a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x05a9, code lost:
        if (r26.isEmpty() != false) goto L_0x05c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x05ab, code lost:
        r0 = r3.zza((com.google.android.gms.internal.measurement.zzao) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x05b8, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzam) != false) goto L_0x05c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x05bc, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzat) == false) goto L_0x05bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x05bf, code lost:
        r4 = r0.zzc();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x05c4, code lost:
        r4 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x05c7, code lost:
        r4 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x05d3, code lost:
        r5 = r24;
        r3 = r25;
        r0 = r26;
        com.google.android.gms.internal.measurement.zzh.zzc(r22, 2, r0);
        r1 = com.google.android.gms.internal.measurement.zzao.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x05e5, code lost:
        if (r26.isEmpty() != false) goto L_0x05f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x05e7, code lost:
        r1 = r3.zza((com.google.android.gms.internal.measurement.zzao) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x05f7, code lost:
        if (r26.size() <= 1) goto L_0x0630;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x05f9, code lost:
        r2 = com.google.android.gms.internal.measurement.zzh.zzi(r3.zza((com.google.android.gms.internal.measurement.zzao) r0.get(1)).zzd().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x0616, code lost:
        if (r2 < ((double) r24.zzh())) goto L_0x0623;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x0627, code lost:
        if (r2 >= 0.0d) goto L_0x0633;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x0629, code lost:
        r2 = r2 + ((double) r24.zzh());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x0630, code lost:
        r2 = 0.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x0633, code lost:
        r0 = r24.zzg();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x063b, code lost:
        if (r0.hasNext() == false) goto L_0x0661;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:259:0x063d, code lost:
        r4 = ((java.lang.Integer) r0.next()).intValue();
        r6 = (double) r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x064a, code lost:
        if (r6 < r2) goto L_0x0637;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:0x0654, code lost:
        if (com.google.android.gms.internal.measurement.zzh.zzf(r5.zzl(r4), r1) == false) goto L_0x0637;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x066c, code lost:
        r5 = r24;
        r3 = r25;
        r0 = r26;
        com.google.android.gms.internal.measurement.zzh.zza("forEach", 1, r0);
        r0 = r3.zza((com.google.android.gms.internal.measurement.zzao) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:266:0x0683, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzan) == false) goto L_0x0698;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:268:0x0689, code lost:
        if (r24.zzi() != 0) goto L_0x068f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x068f, code lost:
        zzc(r5, r3, (com.google.android.gms.internal.measurement.zzan) r0, (java.lang.Boolean) null, (java.lang.Boolean) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:272:0x069d, code lost:
        throw new java.lang.IllegalArgumentException("Callback should be a method");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x069e, code lost:
        r5 = r24;
        r3 = r25;
        r0 = r26;
        com.google.android.gms.internal.measurement.zzh.zza("filter", 1, r0);
        r0 = r3.zza((com.google.android.gms.internal.measurement.zzao) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:274:0x06b5, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzan) == false) goto L_0x06f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:276:0x06bb, code lost:
        if (r24.zzi() != 0) goto L_0x06c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:278:0x06c4, code lost:
        r2 = (com.google.android.gms.internal.measurement.zzae) r24.zzt();
        r0 = zzc(r5, r3, (com.google.android.gms.internal.measurement.zzan) r0, (java.lang.Boolean) null, java.lang.Boolean.TRUE);
        r1 = new com.google.android.gms.internal.measurement.zzae();
        r0 = r0.zzg();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:280:0x06df, code lost:
        if (r0.hasNext() == false) goto L_0x04ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:0x06e1, code lost:
        r1.zzn(r1.zzh(), r2.zzl(((java.lang.Integer) r0.next()).intValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x06fc, code lost:
        throw new java.lang.IllegalArgumentException("Callback should be a method");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:284:0x06fd, code lost:
        r1 = r24;
        r3 = r25;
        r0 = r26;
        com.google.android.gms.internal.measurement.zzh.zza("every", 1, r0);
        r0 = r3.zza((com.google.android.gms.internal.measurement.zzao) r0.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:285:0x0714, code lost:
        if ((r0 instanceof com.google.android.gms.internal.measurement.zzan) == false) goto L_0x073a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x071a, code lost:
        if (r24.zzh() != 0) goto L_0x0720;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:290:0x0732, code lost:
        if (zzc(r1, r3, (com.google.android.gms.internal.measurement.zzan) r0, java.lang.Boolean.FALSE, java.lang.Boolean.TRUE).zzh() == r24.zzh()) goto L_0x0737;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:294:0x073f, code lost:
        throw new java.lang.IllegalArgumentException("Callback should be a method");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:295:0x0740, code lost:
        r1 = r24;
        r3 = r25;
        r0 = r26;
        r1 = (com.google.android.gms.internal.measurement.zzae) r24.zzt();
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:296:0x0750, code lost:
        if (r26.isEmpty() != false) goto L_0x04ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x0752, code lost:
        r0 = r26.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x075a, code lost:
        if (r0.hasNext() == false) goto L_0x04ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0033, code lost:
        r6 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:300:0x075c, code lost:
        r2 = r3.zza((com.google.android.gms.internal.measurement.zzao) r0.next());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:301:0x0768, code lost:
        if ((r2 instanceof com.google.android.gms.internal.measurement.zzag) != false) goto L_0x0799;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:302:0x076a, code lost:
        r4 = r1.zzh();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x0770, code lost:
        if ((r2 instanceof com.google.android.gms.internal.measurement.zzae) == false) goto L_0x0795;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:304:0x0772, code lost:
        r2 = (com.google.android.gms.internal.measurement.zzae) r2;
        r5 = r2.zzg();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:306:0x077c, code lost:
        if (r5.hasNext() == false) goto L_0x0756;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x077e, code lost:
        r6 = (java.lang.Integer) r5.next();
        r1.zzn(r6.intValue() + r4, r2.zzl(r6.intValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x0795, code lost:
        r1.zzn(r4, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:310:0x07a0, code lost:
        throw new java.lang.IllegalStateException("Failed evaluation of arguments");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:339:0x04ab, code lost:
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:342:0x04ab, code lost:
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:345:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r24.zzh()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:346:?, code lost:
        return new com.google.android.gms.internal.measurement.zzas(r24.zzs(r16));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:347:?, code lost:
        return new com.google.android.gms.internal.measurement.zzae();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:348:?, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:349:?, code lost:
        return com.google.android.gms.internal.measurement.zzao.zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:350:?, code lost:
        return com.google.android.gms.internal.measurement.zzao.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:351:?, code lost:
        return com.google.android.gms.internal.measurement.zzao.zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:352:?, code lost:
        return r24.zzt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:353:?, code lost:
        return com.google.android.gms.internal.measurement.zzao.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:354:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:355:?, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:356:?, code lost:
        return zzb(r24, r25, r26, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:357:?, code lost:
        return zzb(r24, r25, r26, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:358:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r24.zzh()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:359:?, code lost:
        return com.google.android.gms.internal.measurement.zzao.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:360:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:361:?, code lost:
        return new com.google.android.gms.internal.measurement.zzae();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:362:?, code lost:
        return zzc(r5, r3, (com.google.android.gms.internal.measurement.zzan) r0, (java.lang.Boolean) null, (java.lang.Boolean) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:363:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:364:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf((double) r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:365:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:366:?, code lost:
        return com.google.android.gms.internal.measurement.zzao.zzm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:367:?, code lost:
        return new com.google.android.gms.internal.measurement.zzas(r5.zzs(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:368:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:369:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:370:?, code lost:
        return new com.google.android.gms.internal.measurement.zzah(java.lang.Double.valueOf(-1.0d));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:371:?, code lost:
        return com.google.android.gms.internal.measurement.zzao.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:372:?, code lost:
        return com.google.android.gms.internal.measurement.zzao.zzf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:373:?, code lost:
        return new com.google.android.gms.internal.measurement.zzae();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:374:?, code lost:
        return com.google.android.gms.internal.measurement.zzao.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:375:?, code lost:
        return com.google.android.gms.internal.measurement.zzao.zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:376:?, code lost:
        return com.google.android.gms.internal.measurement.zzao.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:377:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00ff, code lost:
        r0 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0100, code lost:
        r21 = "reverse";
        r22 = "indexOf";
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0109, code lost:
        switch(r0) {
            case 0: goto L_0x0740;
            case 1: goto L_0x06fd;
            case 2: goto L_0x069e;
            case 3: goto L_0x066c;
            case 4: goto L_0x05d3;
            case 5: goto L_0x058f;
            case 6: goto L_0x04e2;
            case 7: goto L_0x04ae;
            case 8: goto L_0x0490;
            case 9: goto L_0x0458;
            case 10: goto L_0x044b;
            case 11: goto L_0x043e;
            case 12: goto L_0x0401;
            case 13: goto L_0x03e6;
            case 14: goto L_0x035c;
            case 15: goto L_0x02e3;
            case 16: goto L_0x0289;
            case 17: goto L_0x01bc;
            case 18: goto L_0x01a7;
            case 19: goto L_0x0114;
            default: goto L_0x010c;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0113, code lost:
        throw new java.lang.IllegalArgumentException("Command not supported");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x003e, code lost:
        r6 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0118, code lost:
        if (r26.isEmpty() != false) goto L_0x0195;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x011a, code lost:
        r0 = new com.google.android.gms.internal.measurement.zzae();
        r1 = r26.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0127, code lost:
        if (r1.hasNext() == false) goto L_0x0149;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0129, code lost:
        r2 = r25.zza((com.google.android.gms.internal.measurement.zzao) r1.next());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0137, code lost:
        if ((r2 instanceof com.google.android.gms.internal.measurement.zzag) != false) goto L_0x0141;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0139, code lost:
        r0.zzn(r0.zzh(), r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0148, code lost:
        throw new java.lang.IllegalStateException("Argument evaluation failed");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0149, code lost:
        r1 = r0.zzh();
        r2 = r24.zzg();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0155, code lost:
        if (r2.hasNext() == false) goto L_0x0170;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0157, code lost:
        r3 = (java.lang.Integer) r2.next();
        r0.zzn(r3.intValue() + r1, r24.zzl(r3.intValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0170, code lost:
        r5 = r24;
        r24.zzp();
        r1 = r0.zzg();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x017d, code lost:
        if (r1.hasNext() == false) goto L_0x0197;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x017f, code lost:
        r2 = (java.lang.Integer) r1.next();
        r5.zzn(r2.intValue(), r0.zzl(r2.intValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0195, code lost:
        r5 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01a7, code lost:
        com.google.android.gms.internal.measurement.zzh.zza(r6, 0, r26);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01bc, code lost:
        r5 = r24;
        r3 = r25;
        r0 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01c7, code lost:
        if (r26.isEmpty() == false) goto L_0x01d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01d0, code lost:
        r4 = (int) com.google.android.gms.internal.measurement.zzh.zzi(r3.zza((com.google.android.gms.internal.measurement.zzao) r0.get(0)).zzd().doubleValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01e7, code lost:
        if (r4 >= 0) goto L_0x01f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01e9, code lost:
        r4 = java.lang.Math.max(0, r24.zzh() + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01f7, code lost:
        if (r4 <= r24.zzh()) goto L_0x01fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01f9, code lost:
        r4 = r24.zzh();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01fd, code lost:
        r2 = r24.zzh();
        r6 = new com.google.android.gms.internal.measurement.zzae();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.measurement.zzao zza(java.lang.String r23, com.google.android.gms.internal.measurement.zzae r24, com.google.android.gms.internal.measurement.zzg r25, java.util.List r26) {
        /*
            r0 = r23
            r1 = r24
            r2 = r25
            r3 = r26
            java.lang.String r4 = ","
            int r6 = r23.hashCode()
            java.lang.String r7 = "toString"
            java.lang.String r8 = "filter"
            java.lang.String r9 = "forEach"
            java.lang.String r10 = "lastIndexOf"
            java.lang.String r11 = "map"
            java.lang.String r12 = "pop"
            java.lang.String r13 = "join"
            java.lang.String r14 = "some"
            java.lang.String r15 = "sort"
            java.lang.String r5 = "every"
            r16 = r4
            java.lang.String r4 = "shift"
            java.lang.String r3 = "slice"
            java.lang.String r1 = "reverse"
            java.lang.String r2 = "indexOf"
            r17 = -1
            r18 = r7
            switch(r6) {
                case -1776922004: goto L_0x00f4;
                case -1354795244: goto L_0x00e8;
                case -1274492040: goto L_0x00de;
                case -934873754: goto L_0x00d2;
                case -895859076: goto L_0x00c6;
                case -678635926: goto L_0x00bc;
                case -467511597: goto L_0x00b4;
                case -277637751: goto L_0x00a9;
                case 107868: goto L_0x00a1;
                case 111185: goto L_0x0098;
                case 3267882: goto L_0x0090;
                case 3452698: goto L_0x0085;
                case 3536116: goto L_0x007c;
                case 3536286: goto L_0x0073;
                case 96891675: goto L_0x0068;
                case 109407362: goto L_0x005f;
                case 109526418: goto L_0x0056;
                case 965561430: goto L_0x004b;
                case 1099846370: goto L_0x0042;
                case 1943291465: goto L_0x0037;
                default: goto L_0x0033;
            }
        L_0x0033:
            r6 = r18
            goto L_0x00ff
        L_0x0037:
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0033
            r0 = 4
        L_0x003e:
            r6 = r18
            goto L_0x0100
        L_0x0042:
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0033
            r0 = 12
            goto L_0x003e
        L_0x004b:
            java.lang.String r6 = "reduceRight"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0033
            r0 = 11
            goto L_0x003e
        L_0x0056:
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0033
            r0 = 14
            goto L_0x003e
        L_0x005f:
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0033
            r0 = 13
            goto L_0x003e
        L_0x0068:
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x0033
            r6 = r18
            r0 = 1
            goto L_0x0100
        L_0x0073:
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x0033
            r0 = 16
            goto L_0x003e
        L_0x007c:
            boolean r0 = r0.equals(r14)
            if (r0 == 0) goto L_0x0033
            r0 = 15
            goto L_0x003e
        L_0x0085:
            java.lang.String r6 = "push"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0033
            r0 = 9
            goto L_0x003e
        L_0x0090:
            boolean r0 = r0.equals(r13)
            if (r0 == 0) goto L_0x0033
            r0 = 5
            goto L_0x003e
        L_0x0098:
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x0033
            r0 = 8
            goto L_0x003e
        L_0x00a1:
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L_0x0033
            r0 = 7
            goto L_0x003e
        L_0x00a9:
            java.lang.String r6 = "unshift"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0033
            r0 = 19
            goto L_0x003e
        L_0x00b4:
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x0033
            r0 = 6
            goto L_0x003e
        L_0x00bc:
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x0033
            r6 = r18
            r0 = 3
            goto L_0x0100
        L_0x00c6:
            java.lang.String r6 = "splice"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0033
            r0 = 17
            goto L_0x003e
        L_0x00d2:
            java.lang.String r6 = "reduce"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0033
            r0 = 10
            goto L_0x003e
        L_0x00de:
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x0033
            r6 = r18
            r0 = 2
            goto L_0x0100
        L_0x00e8:
            java.lang.String r6 = "concat"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0033
            r6 = r18
            r0 = 0
            goto L_0x0100
        L_0x00f4:
            r6 = r18
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x00ff
            r0 = 18
            goto L_0x0100
        L_0x00ff:
            r0 = -1
        L_0x0100:
            r19 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            java.lang.String r7 = "Callback should be a method"
            r21 = r1
            r22 = r2
            r1 = 0
            switch(r0) {
                case 0: goto L_0x0740;
                case 1: goto L_0x06fd;
                case 2: goto L_0x069e;
                case 3: goto L_0x066c;
                case 4: goto L_0x05d3;
                case 5: goto L_0x058f;
                case 6: goto L_0x04e2;
                case 7: goto L_0x04ae;
                case 8: goto L_0x0490;
                case 9: goto L_0x0458;
                case 10: goto L_0x044b;
                case 11: goto L_0x043e;
                case 12: goto L_0x0401;
                case 13: goto L_0x03e6;
                case 14: goto L_0x035c;
                case 15: goto L_0x02e3;
                case 16: goto L_0x0289;
                case 17: goto L_0x01bc;
                case 18: goto L_0x01a7;
                case 19: goto L_0x0114;
                default: goto L_0x010c;
            }
        L_0x010c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Command not supported"
            r0.<init>(r1)
            throw r0
        L_0x0114:
            boolean r0 = r26.isEmpty()
            if (r0 != 0) goto L_0x0195
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>()
            java.util.Iterator r1 = r26.iterator()
        L_0x0123:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0149
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.measurement.zzao r2 = (com.google.android.gms.internal.measurement.zzao) r2
            r3 = r25
            com.google.android.gms.internal.measurement.zzao r2 = r3.zza(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.measurement.zzag
            if (r4 != 0) goto L_0x0141
            int r4 = r0.zzh()
            r0.zzn(r4, r2)
            goto L_0x0123
        L_0x0141:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Argument evaluation failed"
            r0.<init>(r1)
            throw r0
        L_0x0149:
            int r1 = r0.zzh()
            java.util.Iterator r2 = r24.zzg()
        L_0x0151:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0170
            java.lang.Object r3 = r2.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r4 = r3.intValue()
            int r4 = r4 + r1
            int r3 = r3.intValue()
            r5 = r24
            com.google.android.gms.internal.measurement.zzao r3 = r5.zzl(r3)
            r0.zzn(r4, r3)
            goto L_0x0151
        L_0x0170:
            r5 = r24
            r24.zzp()
            java.util.Iterator r1 = r0.zzg()
        L_0x0179:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0197
            java.lang.Object r2 = r1.next()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r3 = r2.intValue()
            int r2 = r2.intValue()
            com.google.android.gms.internal.measurement.zzao r2 = r0.zzl(r2)
            r5.zzn(r3, r2)
            goto L_0x0179
        L_0x0195:
            r5 = r24
        L_0x0197:
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            int r1 = r24.zzh()
            double r1 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r0.<init>(r1)
            goto L_0x07a1
        L_0x01a7:
            r5 = r24
            r0 = r26
            r2 = 0
            com.google.android.gms.internal.measurement.zzh.zza(r6, r2, r0)
            com.google.android.gms.internal.measurement.zzas r0 = new com.google.android.gms.internal.measurement.zzas
            r1 = r16
            java.lang.String r1 = r5.zzs(r1)
            r0.<init>(r1)
            goto L_0x07a1
        L_0x01bc:
            r5 = r24
            r3 = r25
            r0 = r26
            r2 = 0
            boolean r4 = r26.isEmpty()
            if (r4 == 0) goto L_0x01d0
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>()
            goto L_0x07a1
        L_0x01d0:
            java.lang.Object r4 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzao r4 = (com.google.android.gms.internal.measurement.zzao) r4
            com.google.android.gms.internal.measurement.zzao r4 = r3.zza(r4)
            java.lang.Double r4 = r4.zzd()
            double r6 = r4.doubleValue()
            double r6 = com.google.android.gms.internal.measurement.zzh.zzi(r6)
            int r4 = (int) r6
            if (r4 >= 0) goto L_0x01f3
            int r6 = r24.zzh()
            int r6 = r6 + r4
            int r4 = java.lang.Math.max(r2, r6)
            goto L_0x01fd
        L_0x01f3:
            int r2 = r24.zzh()
            if (r4 <= r2) goto L_0x01fd
            int r4 = r24.zzh()
        L_0x01fd:
            int r2 = r24.zzh()
            com.google.android.gms.internal.measurement.zzae r6 = new com.google.android.gms.internal.measurement.zzae
            r6.<init>()
            int r7 = r26.size()
            r8 = 1
            if (r7 <= r8) goto L_0x0273
            java.lang.Object r1 = r0.get(r8)
            com.google.android.gms.internal.measurement.zzao r1 = (com.google.android.gms.internal.measurement.zzao) r1
            com.google.android.gms.internal.measurement.zzao r1 = r3.zza(r1)
            java.lang.Double r1 = r1.zzd()
            double r7 = r1.doubleValue()
            double r7 = com.google.android.gms.internal.measurement.zzh.zzi(r7)
            int r1 = (int) r7
            r7 = 0
            int r1 = java.lang.Math.max(r7, r1)
            if (r1 <= 0) goto L_0x0245
            r7 = r4
        L_0x022c:
            int r8 = r4 + r1
            int r8 = java.lang.Math.min(r2, r8)
            if (r7 >= r8) goto L_0x0245
            com.google.android.gms.internal.measurement.zzao r8 = r5.zzl(r4)
            int r9 = r6.zzh()
            r6.zzn(r9, r8)
            r5.zzr(r4)
            r8 = 1
            int r7 = r7 + r8
            goto L_0x022c
        L_0x0245:
            int r1 = r26.size()
            r2 = 2
            if (r1 <= r2) goto L_0x0286
            r7 = 2
        L_0x024d:
            int r1 = r26.size()
            if (r7 >= r1) goto L_0x0286
            java.lang.Object r1 = r0.get(r7)
            com.google.android.gms.internal.measurement.zzao r1 = (com.google.android.gms.internal.measurement.zzao) r1
            com.google.android.gms.internal.measurement.zzao r1 = r3.zza(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzag
            if (r2 != 0) goto L_0x026b
            int r2 = r4 + r7
            int r2 = r2 + -2
            r5.zzq(r2, r1)
            r1 = 1
            int r7 = r7 + r1
            goto L_0x024d
        L_0x026b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Failed to parse elements to add"
            r0.<init>(r1)
            throw r0
        L_0x0273:
            if (r4 >= r2) goto L_0x0286
            com.google.android.gms.internal.measurement.zzao r0 = r5.zzl(r4)
            int r3 = r6.zzh()
            r6.zzn(r3, r0)
            r5.zzn(r4, r1)
            r7 = 1
            int r4 = r4 + r7
            goto L_0x0273
        L_0x0286:
            r0 = r6
            goto L_0x07a1
        L_0x0289:
            r5 = r24
            r3 = r25
            r0 = r26
            r7 = 1
            com.google.android.gms.internal.measurement.zzh.zzc(r15, r7, r0)
            int r2 = r24.zzh()
            r4 = 2
            if (r2 < r4) goto L_0x043b
            java.util.List r2 = r24.zzb()
            boolean r4 = r26.isEmpty()
            if (r4 != 0) goto L_0x02bf
            r4 = 0
            java.lang.Object r0 = r0.get(r4)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r3.zza(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzai
            if (r1 == 0) goto L_0x02b7
            r1 = r0
            com.google.android.gms.internal.measurement.zzai r1 = (com.google.android.gms.internal.measurement.zzai) r1
            goto L_0x02bf
        L_0x02b7:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Comparator should be a method"
            r0.<init>(r1)
            throw r0
        L_0x02bf:
            com.google.android.gms.internal.measurement.zzaz r0 = new com.google.android.gms.internal.measurement.zzaz
            r0.<init>(r1, r3)
            java.util.Collections.sort(r2, r0)
            r24.zzp()
            java.util.Iterator r0 = r2.iterator()
            r7 = 0
        L_0x02cf:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x043b
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzao r1 = (com.google.android.gms.internal.measurement.zzao) r1
            r2 = 1
            int r3 = r7 + 1
            r5.zzn(r7, r1)
            r7 = r3
            goto L_0x02cf
        L_0x02e3:
            r5 = r24
            r3 = r25
            r0 = r26
            r2 = 1
            com.google.android.gms.internal.measurement.zzh.zza(r14, r2, r0)
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r3.zza(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzai
            if (r1 == 0) goto L_0x0356
            int r1 = r24.zzh()
            if (r1 != 0) goto L_0x0306
            com.google.android.gms.internal.measurement.zzao r0 = com.google.android.gms.internal.measurement.zzao.zzl
            goto L_0x07a1
        L_0x0306:
            com.google.android.gms.internal.measurement.zzai r0 = (com.google.android.gms.internal.measurement.zzai) r0
            java.util.Iterator r1 = r24.zzg()
        L_0x030c:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0352
            java.lang.Object r2 = r1.next()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            boolean r4 = r5.zzo(r2)
            if (r4 == 0) goto L_0x030c
            com.google.android.gms.internal.measurement.zzao r4 = r5.zzl(r2)
            double r6 = (double) r2
            com.google.android.gms.internal.measurement.zzah r2 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r6 = java.lang.Double.valueOf(r6)
            r2.<init>(r6)
            r6 = 3
            com.google.android.gms.internal.measurement.zzao[] r7 = new com.google.android.gms.internal.measurement.zzao[r6]
            r8 = 0
            r7[r8] = r4
            r4 = 1
            r7[r4] = r2
            r2 = 2
            r7[r2] = r5
            java.util.List r2 = java.util.Arrays.asList(r7)
            com.google.android.gms.internal.measurement.zzao r2 = r0.zza(r3, r2)
            java.lang.Boolean r2 = r2.zze()
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x030c
            com.google.android.gms.internal.measurement.zzao r0 = com.google.android.gms.internal.measurement.zzao.zzk
            goto L_0x07a1
        L_0x0352:
            com.google.android.gms.internal.measurement.zzao r0 = com.google.android.gms.internal.measurement.zzao.zzl
            goto L_0x07a1
        L_0x0356:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r7)
            throw r0
        L_0x035c:
            r5 = r24
            r0 = r26
            r1 = r3
            r2 = 2
            r3 = r25
            com.google.android.gms.internal.measurement.zzh.zzc(r1, r2, r0)
            boolean r1 = r26.isEmpty()
            if (r1 == 0) goto L_0x0373
            com.google.android.gms.internal.measurement.zzao r0 = r24.zzt()
            goto L_0x07a1
        L_0x0373:
            int r1 = r24.zzh()
            double r1 = (double) r1
            r4 = 0
            java.lang.Object r4 = r0.get(r4)
            com.google.android.gms.internal.measurement.zzao r4 = (com.google.android.gms.internal.measurement.zzao) r4
            com.google.android.gms.internal.measurement.zzao r4 = r3.zza(r4)
            java.lang.Double r4 = r4.zzd()
            double r6 = r4.doubleValue()
            double r6 = com.google.android.gms.internal.measurement.zzh.zzi(r6)
            r8 = 0
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 >= 0) goto L_0x039b
            double r6 = r6 + r1
            double r6 = java.lang.Math.max(r6, r8)
            goto L_0x039f
        L_0x039b:
            double r6 = java.lang.Math.min(r6, r1)
        L_0x039f:
            int r4 = r26.size()
            r8 = 2
            if (r4 != r8) goto L_0x03cd
            r4 = 1
            java.lang.Object r0 = r0.get(r4)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r3.zza(r0)
            java.lang.Double r0 = r0.zzd()
            double r3 = r0.doubleValue()
            double r3 = com.google.android.gms.internal.measurement.zzh.zzi(r3)
            r8 = 0
            int r0 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x03c9
            double r1 = r1 + r3
            double r1 = java.lang.Math.max(r1, r8)
            goto L_0x03cd
        L_0x03c9:
            double r1 = java.lang.Math.min(r1, r3)
        L_0x03cd:
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>()
            int r3 = (int) r6
        L_0x03d3:
            double r6 = (double) r3
            int r4 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r4 >= 0) goto L_0x07a1
            com.google.android.gms.internal.measurement.zzao r4 = r5.zzl(r3)
            int r6 = r0.zzh()
            r0.zzn(r6, r4)
            r4 = 1
            int r3 = r3 + r4
            goto L_0x03d3
        L_0x03e6:
            r5 = r24
            r0 = r26
            r2 = 0
            com.google.android.gms.internal.measurement.zzh.zza(r4, r2, r0)
            int r0 = r24.zzh()
            if (r0 != 0) goto L_0x03f8
            com.google.android.gms.internal.measurement.zzao r0 = com.google.android.gms.internal.measurement.zzao.zzf
            goto L_0x07a1
        L_0x03f8:
            com.google.android.gms.internal.measurement.zzao r0 = r5.zzl(r2)
            r5.zzr(r2)
            goto L_0x07a1
        L_0x0401:
            r5 = r24
            r0 = r26
            r3 = r21
            r2 = 0
            com.google.android.gms.internal.measurement.zzh.zza(r3, r2, r0)
            int r0 = r24.zzh()
            if (r0 == 0) goto L_0x043b
            r2 = 2
            r7 = 0
        L_0x0413:
            int r3 = r0 / 2
            if (r7 >= r3) goto L_0x043b
            boolean r2 = r5.zzo(r7)
            if (r2 == 0) goto L_0x0437
            com.google.android.gms.internal.measurement.zzao r2 = r5.zzl(r7)
            r5.zzn(r7, r1)
            int r3 = r0 + -1
            int r3 = r3 - r7
            boolean r4 = r5.zzo(r3)
            if (r4 == 0) goto L_0x0434
            com.google.android.gms.internal.measurement.zzao r4 = r5.zzl(r3)
            r5.zzn(r7, r4)
        L_0x0434:
            r5.zzn(r3, r2)
        L_0x0437:
            r2 = 1
            int r7 = r7 + r2
            r2 = 2
            goto L_0x0413
        L_0x043b:
            r0 = r5
            goto L_0x07a1
        L_0x043e:
            r5 = r24
            r3 = r25
            r0 = r26
            r1 = 0
            com.google.android.gms.internal.measurement.zzao r0 = zzb(r5, r3, r0, r1)
            goto L_0x07a1
        L_0x044b:
            r5 = r24
            r3 = r25
            r0 = r26
            r2 = 1
            com.google.android.gms.internal.measurement.zzao r0 = zzb(r5, r3, r0, r2)
            goto L_0x07a1
        L_0x0458:
            r5 = r24
            r3 = r25
            r0 = r26
            boolean r1 = r26.isEmpty()
            if (r1 != 0) goto L_0x0480
            java.util.Iterator r0 = r26.iterator()
        L_0x0468:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0480
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzao r1 = (com.google.android.gms.internal.measurement.zzao) r1
            com.google.android.gms.internal.measurement.zzao r1 = r3.zza(r1)
            int r2 = r24.zzh()
            r5.zzn(r2, r1)
            goto L_0x0468
        L_0x0480:
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            int r1 = r24.zzh()
            double r1 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            r0.<init>(r1)
            goto L_0x07a1
        L_0x0490:
            r5 = r24
            r0 = r26
            r2 = 0
            com.google.android.gms.internal.measurement.zzh.zza(r12, r2, r0)
            int r0 = r24.zzh()
            if (r0 != 0) goto L_0x04a2
            com.google.android.gms.internal.measurement.zzao r0 = com.google.android.gms.internal.measurement.zzao.zzf
            goto L_0x07a1
        L_0x04a2:
            int r0 = r0 + -1
            com.google.android.gms.internal.measurement.zzao r1 = r5.zzl(r0)
            r5.zzr(r0)
        L_0x04ab:
            r0 = r1
            goto L_0x07a1
        L_0x04ae:
            r5 = r24
            r3 = r25
            r0 = r26
            r2 = 0
            r4 = 1
            com.google.android.gms.internal.measurement.zzh.zza(r11, r4, r0)
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r3.zza(r0)
            boolean r2 = r0 instanceof com.google.android.gms.internal.measurement.zzan
            if (r2 == 0) goto L_0x04dc
            int r2 = r24.zzh()
            if (r2 != 0) goto L_0x04d4
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>()
            goto L_0x07a1
        L_0x04d4:
            com.google.android.gms.internal.measurement.zzan r0 = (com.google.android.gms.internal.measurement.zzan) r0
            com.google.android.gms.internal.measurement.zzae r0 = zzc(r5, r3, r0, r1, r1)
            goto L_0x07a1
        L_0x04dc:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r7)
            throw r0
        L_0x04e2:
            r5 = r24
            r3 = r25
            r0 = r26
            r1 = 2
            com.google.android.gms.internal.measurement.zzh.zzc(r10, r1, r0)
            com.google.android.gms.internal.measurement.zzao r1 = com.google.android.gms.internal.measurement.zzao.zzf
            boolean r2 = r26.isEmpty()
            if (r2 != 0) goto L_0x04ff
            r2 = 0
            java.lang.Object r1 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzao r1 = (com.google.android.gms.internal.measurement.zzao) r1
            com.google.android.gms.internal.measurement.zzao r1 = r3.zza(r1)
        L_0x04ff:
            int r2 = r24.zzh()
            int r2 = r2 + -1
            int r4 = r26.size()
            r6 = 1
            if (r4 <= r6) goto L_0x0546
            java.lang.Object r0 = r0.get(r6)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r3.zza(r0)
            java.lang.Double r2 = r0.zzd()
            double r2 = r2.doubleValue()
            boolean r2 = java.lang.Double.isNaN(r2)
            if (r2 == 0) goto L_0x052e
            int r0 = r24.zzh()
            int r0 = r0 + -1
            double r2 = (double) r0
        L_0x052b:
            r6 = 0
            goto L_0x053b
        L_0x052e:
            java.lang.Double r0 = r0.zzd()
            double r2 = r0.doubleValue()
            double r2 = com.google.android.gms.internal.measurement.zzh.zzi(r2)
            goto L_0x052b
        L_0x053b:
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x0549
            int r0 = r24.zzh()
            double r8 = (double) r0
            double r2 = r2 + r8
            goto L_0x0549
        L_0x0546:
            r6 = 0
            double r2 = (double) r2
        L_0x0549:
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x0558
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r1 = java.lang.Double.valueOf(r19)
            r0.<init>(r1)
            goto L_0x07a1
        L_0x0558:
            int r0 = r24.zzh()
            double r6 = (double) r0
            double r2 = java.lang.Math.min(r6, r2)
            int r0 = (int) r2
        L_0x0562:
            if (r0 < 0) goto L_0x0584
            boolean r2 = r5.zzo(r0)
            if (r2 == 0) goto L_0x0581
            com.google.android.gms.internal.measurement.zzao r2 = r5.zzl(r0)
            boolean r2 = com.google.android.gms.internal.measurement.zzh.zzf(r2, r1)
            if (r2 == 0) goto L_0x0581
            double r0 = (double) r0
            com.google.android.gms.internal.measurement.zzah r2 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            r2.<init>(r0)
            r0 = r2
            goto L_0x07a1
        L_0x0581:
            int r0 = r0 + -1
            goto L_0x0562
        L_0x0584:
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r1 = java.lang.Double.valueOf(r19)
            r0.<init>(r1)
            goto L_0x07a1
        L_0x058f:
            r5 = r24
            r3 = r25
            r0 = r26
            r1 = r16
            r2 = 1
            com.google.android.gms.internal.measurement.zzh.zzc(r13, r2, r0)
            int r2 = r24.zzh()
            if (r2 != 0) goto L_0x05a5
            com.google.android.gms.internal.measurement.zzao r0 = com.google.android.gms.internal.measurement.zzao.zzm
            goto L_0x07a1
        L_0x05a5:
            boolean r2 = r26.isEmpty()
            if (r2 != 0) goto L_0x05c7
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r3.zza(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzam
            if (r1 != 0) goto L_0x05c4
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzat
            if (r1 == 0) goto L_0x05bf
            goto L_0x05c4
        L_0x05bf:
            java.lang.String r4 = r0.zzc()
            goto L_0x05c8
        L_0x05c4:
            java.lang.String r4 = ""
            goto L_0x05c8
        L_0x05c7:
            r4 = r1
        L_0x05c8:
            com.google.android.gms.internal.measurement.zzas r0 = new com.google.android.gms.internal.measurement.zzas
            java.lang.String r1 = r5.zzs(r4)
            r0.<init>(r1)
            goto L_0x07a1
        L_0x05d3:
            r5 = r24
            r3 = r25
            r0 = r26
            r1 = r22
            r2 = 2
            com.google.android.gms.internal.measurement.zzh.zzc(r1, r2, r0)
            com.google.android.gms.internal.measurement.zzao r1 = com.google.android.gms.internal.measurement.zzao.zzf
            boolean r2 = r26.isEmpty()
            if (r2 != 0) goto L_0x05f2
            r2 = 0
            java.lang.Object r1 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzao r1 = (com.google.android.gms.internal.measurement.zzao) r1
            com.google.android.gms.internal.measurement.zzao r1 = r3.zza(r1)
        L_0x05f2:
            int r2 = r26.size()
            r4 = 1
            if (r2 <= r4) goto L_0x0630
            java.lang.Object r0 = r0.get(r4)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r3.zza(r0)
            java.lang.Double r0 = r0.zzd()
            double r2 = r0.doubleValue()
            double r2 = com.google.android.gms.internal.measurement.zzh.zzi(r2)
            int r0 = r24.zzh()
            double r6 = (double) r0
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 < 0) goto L_0x0623
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r1 = java.lang.Double.valueOf(r19)
            r0.<init>(r1)
            goto L_0x07a1
        L_0x0623:
            r6 = 0
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x0633
            int r0 = r24.zzh()
            double r6 = (double) r0
            double r2 = r2 + r6
            goto L_0x0633
        L_0x0630:
            r6 = 0
            r2 = r6
        L_0x0633:
            java.util.Iterator r0 = r24.zzg()
        L_0x0637:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0661
            java.lang.Object r4 = r0.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            double r6 = (double) r4
            int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r8 < 0) goto L_0x0637
            com.google.android.gms.internal.measurement.zzao r4 = r5.zzl(r4)
            boolean r4 = com.google.android.gms.internal.measurement.zzh.zzf(r4, r1)
            if (r4 == 0) goto L_0x0637
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r1 = java.lang.Double.valueOf(r6)
            r0.<init>(r1)
            goto L_0x07a1
        L_0x0661:
            com.google.android.gms.internal.measurement.zzah r0 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r1 = java.lang.Double.valueOf(r19)
            r0.<init>(r1)
            goto L_0x07a1
        L_0x066c:
            r5 = r24
            r3 = r25
            r0 = r26
            r2 = 1
            com.google.android.gms.internal.measurement.zzh.zza(r9, r2, r0)
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r3.zza(r0)
            boolean r2 = r0 instanceof com.google.android.gms.internal.measurement.zzan
            if (r2 == 0) goto L_0x0698
            int r2 = r24.zzi()
            if (r2 != 0) goto L_0x068f
            com.google.android.gms.internal.measurement.zzao r0 = com.google.android.gms.internal.measurement.zzao.zzf
            goto L_0x07a1
        L_0x068f:
            com.google.android.gms.internal.measurement.zzan r0 = (com.google.android.gms.internal.measurement.zzan) r0
            zzc(r5, r3, r0, r1, r1)
            com.google.android.gms.internal.measurement.zzao r0 = com.google.android.gms.internal.measurement.zzao.zzf
            goto L_0x07a1
        L_0x0698:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r7)
            throw r0
        L_0x069e:
            r5 = r24
            r3 = r25
            r0 = r26
            r2 = 1
            com.google.android.gms.internal.measurement.zzh.zza(r8, r2, r0)
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r3.zza(r0)
            boolean r2 = r0 instanceof com.google.android.gms.internal.measurement.zzan
            if (r2 == 0) goto L_0x06f7
            int r2 = r24.zzi()
            if (r2 != 0) goto L_0x06c4
            com.google.android.gms.internal.measurement.zzae r0 = new com.google.android.gms.internal.measurement.zzae
            r0.<init>()
            goto L_0x07a1
        L_0x06c4:
            com.google.android.gms.internal.measurement.zzao r2 = r24.zzt()
            com.google.android.gms.internal.measurement.zzae r2 = (com.google.android.gms.internal.measurement.zzae) r2
            com.google.android.gms.internal.measurement.zzan r0 = (com.google.android.gms.internal.measurement.zzan) r0
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            com.google.android.gms.internal.measurement.zzae r0 = zzc(r5, r3, r0, r1, r4)
            com.google.android.gms.internal.measurement.zzae r1 = new com.google.android.gms.internal.measurement.zzae
            r1.<init>()
            java.util.Iterator r0 = r0.zzg()
        L_0x06db:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x04ab
            java.lang.Object r3 = r0.next()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            com.google.android.gms.internal.measurement.zzao r3 = r2.zzl(r3)
            int r4 = r1.zzh()
            r1.zzn(r4, r3)
            goto L_0x06db
        L_0x06f7:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r7)
            throw r0
        L_0x06fd:
            r1 = r24
            r3 = r25
            r0 = r26
            r2 = 1
            com.google.android.gms.internal.measurement.zzh.zza(r5, r2, r0)
            r2 = 0
            java.lang.Object r0 = r0.get(r2)
            com.google.android.gms.internal.measurement.zzao r0 = (com.google.android.gms.internal.measurement.zzao) r0
            com.google.android.gms.internal.measurement.zzao r0 = r3.zza(r0)
            boolean r2 = r0 instanceof com.google.android.gms.internal.measurement.zzan
            if (r2 == 0) goto L_0x073a
            int r2 = r24.zzh()
            if (r2 != 0) goto L_0x0720
            com.google.android.gms.internal.measurement.zzao r0 = com.google.android.gms.internal.measurement.zzao.zzk
            goto L_0x07a1
        L_0x0720:
            com.google.android.gms.internal.measurement.zzan r0 = (com.google.android.gms.internal.measurement.zzan) r0
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            com.google.android.gms.internal.measurement.zzae r0 = zzc(r1, r3, r0, r2, r4)
            int r0 = r0.zzh()
            int r1 = r24.zzh()
            if (r0 == r1) goto L_0x0737
            com.google.android.gms.internal.measurement.zzao r0 = com.google.android.gms.internal.measurement.zzao.zzl
            goto L_0x07a1
        L_0x0737:
            com.google.android.gms.internal.measurement.zzao r0 = com.google.android.gms.internal.measurement.zzao.zzk
            goto L_0x07a1
        L_0x073a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r7)
            throw r0
        L_0x0740:
            r1 = r24
            r3 = r25
            r0 = r26
            com.google.android.gms.internal.measurement.zzao r1 = r24.zzt()
            com.google.android.gms.internal.measurement.zzae r1 = (com.google.android.gms.internal.measurement.zzae) r1
            boolean r2 = r26.isEmpty()
            if (r2 != 0) goto L_0x04ab
            java.util.Iterator r0 = r26.iterator()
        L_0x0756:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x04ab
            java.lang.Object r2 = r0.next()
            com.google.android.gms.internal.measurement.zzao r2 = (com.google.android.gms.internal.measurement.zzao) r2
            com.google.android.gms.internal.measurement.zzao r2 = r3.zza(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.measurement.zzag
            if (r4 != 0) goto L_0x0799
            int r4 = r1.zzh()
            boolean r5 = r2 instanceof com.google.android.gms.internal.measurement.zzae
            if (r5 == 0) goto L_0x0795
            com.google.android.gms.internal.measurement.zzae r2 = (com.google.android.gms.internal.measurement.zzae) r2
            java.util.Iterator r5 = r2.zzg()
        L_0x0778:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0756
            java.lang.Object r6 = r5.next()
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r7 = r6.intValue()
            int r7 = r7 + r4
            int r6 = r6.intValue()
            com.google.android.gms.internal.measurement.zzao r6 = r2.zzl(r6)
            r1.zzn(r7, r6)
            goto L_0x0778
        L_0x0795:
            r1.zzn(r4, r2)
            goto L_0x0756
        L_0x0799:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Failed evaluation of arguments"
            r0.<init>(r1)
            throw r0
        L_0x07a1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzba.zza(java.lang.String, com.google.android.gms.internal.measurement.zzae, com.google.android.gms.internal.measurement.zzg, java.util.List):com.google.android.gms.internal.measurement.zzao");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0095 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.measurement.zzao zzb(com.google.android.gms.internal.measurement.zzae r10, com.google.android.gms.internal.measurement.zzg r11, java.util.List r12, boolean r13) {
        /*
            r0 = -1
            java.lang.String r1 = "reduce"
            r2 = 1
            com.google.android.gms.internal.measurement.zzh.zzb(r1, r2, r12)
            r3 = 2
            com.google.android.gms.internal.measurement.zzh.zzc(r1, r3, r12)
            r1 = 0
            java.lang.Object r4 = r12.get(r1)
            com.google.android.gms.internal.measurement.zzao r4 = (com.google.android.gms.internal.measurement.zzao) r4
            com.google.android.gms.internal.measurement.zzao r4 = r11.zza(r4)
            boolean r5 = r4 instanceof com.google.android.gms.internal.measurement.zzai
            if (r5 == 0) goto L_0x009e
            int r5 = r12.size()
            if (r5 != r3) goto L_0x0037
            java.lang.Object r12 = r12.get(r2)
            com.google.android.gms.internal.measurement.zzao r12 = (com.google.android.gms.internal.measurement.zzao) r12
            com.google.android.gms.internal.measurement.zzao r12 = r11.zza(r12)
            boolean r5 = r12 instanceof com.google.android.gms.internal.measurement.zzag
            if (r5 != 0) goto L_0x002f
            goto L_0x003e
        L_0x002f:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "Failed to parse initial value"
            r10.<init>(r11)
            throw r10
        L_0x0037:
            int r12 = r10.zzh()
            if (r12 == 0) goto L_0x0096
            r12 = 0
        L_0x003e:
            com.google.android.gms.internal.measurement.zzai r4 = (com.google.android.gms.internal.measurement.zzai) r4
            int r5 = r10.zzh()
            if (r13 == 0) goto L_0x0048
            r6 = 0
            goto L_0x004a
        L_0x0048:
            int r6 = r5 + -1
        L_0x004a:
            if (r13 == 0) goto L_0x004e
            int r5 = r5 + r0
            goto L_0x004f
        L_0x004e:
            r5 = 0
        L_0x004f:
            if (r2 == r13) goto L_0x0052
            goto L_0x0053
        L_0x0052:
            r0 = 1
        L_0x0053:
            if (r12 != 0) goto L_0x005a
            com.google.android.gms.internal.measurement.zzao r12 = r10.zzl(r6)
        L_0x0059:
            int r6 = r6 + r0
        L_0x005a:
            int r13 = r5 - r6
            int r13 = r13 * r0
            if (r13 < 0) goto L_0x0095
            boolean r13 = r10.zzo(r6)
            if (r13 == 0) goto L_0x0059
            com.google.android.gms.internal.measurement.zzao r13 = r10.zzl(r6)
            double r7 = (double) r6
            com.google.android.gms.internal.measurement.zzah r9 = new com.google.android.gms.internal.measurement.zzah
            java.lang.Double r7 = java.lang.Double.valueOf(r7)
            r9.<init>(r7)
            r7 = 4
            com.google.android.gms.internal.measurement.zzao[] r7 = new com.google.android.gms.internal.measurement.zzao[r7]
            r7[r1] = r12
            r7[r2] = r13
            r7[r3] = r9
            r12 = 3
            r7[r12] = r10
            java.util.List r12 = java.util.Arrays.asList(r7)
            com.google.android.gms.internal.measurement.zzao r12 = r4.zza(r11, r12)
            boolean r13 = r12 instanceof com.google.android.gms.internal.measurement.zzag
            if (r13 != 0) goto L_0x008d
            goto L_0x0059
        L_0x008d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "Reduce operation failed"
            r10.<init>(r11)
            throw r10
        L_0x0095:
            return r12
        L_0x0096:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "Empty array with no initial value error"
            r10.<init>(r11)
            throw r10
        L_0x009e:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r11 = "Callback should be a method"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzba.zzb(com.google.android.gms.internal.measurement.zzae, com.google.android.gms.internal.measurement.zzg, java.util.List, boolean):com.google.android.gms.internal.measurement.zzao");
    }

    private static zzae zzc(zzae zzae, zzg zzg, zzai zzai, Boolean bool, Boolean bool2) {
        zzae zzae2 = new zzae();
        Iterator zzg2 = zzae.zzg();
        while (zzg2.hasNext()) {
            int intValue = ((Integer) zzg2.next()).intValue();
            if (zzae.zzo(intValue)) {
                zzao zza = zzai.zza(zzg, Arrays.asList(new zzao[]{zzae.zzl(intValue), new zzah(Double.valueOf((double) intValue)), zzae}));
                if (zza.zze().equals(bool)) {
                    break;
                } else if (bool2 == null || zza.zze().equals(bool2)) {
                    zzae2.zzn(intValue, zza);
                }
            }
        }
        return zzae2;
    }
}
