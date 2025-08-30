package com.google.android.gms.internal.measurement;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.baidu.idl.face.platform.FaceEnvironment;
import java.util.List;

public final class zzid extends zzme implements zznm {
    /* access modifiers changed from: private */
    public static final zzid zzat;
    private int zzA;
    private String zzB = "";
    private String zzC = "";
    private boolean zzD;
    private zzmn zzE = zzme.zzcv();
    private String zzF = "";
    private int zzG;
    private int zzH;
    private int zzI;
    private String zzJ = "";
    private long zzK;
    private long zzL;
    private String zzM = "";
    private String zzN = "";
    private int zzO;
    private String zzP = "";
    private zzig zzQ;
    private zzml zzR = zzme.zzcs();
    private long zzS;
    private long zzT;
    private String zzU = "";
    private String zzV = "";
    private int zzW;
    private boolean zzX;
    private String zzY = "";
    private boolean zzZ;
    private zzhy zzaa;
    private String zzab = "";
    private zzmn zzac = zzme.zzcv();
    private String zzad = "";
    private long zzae;
    private boolean zzaf;
    private String zzag = "";
    private boolean zzah;
    private String zzai = "";
    private int zzaj;
    private String zzak = "";
    private zzhe zzal;
    private int zzam;
    private zzha zzan;
    private String zzao = "";
    private zzis zzap;
    private long zzaq;
    private String zzar = "";
    private zzho zzas;
    private int zzb;
    private int zzd;
    private int zze;
    private zzmn zzf = zzme.zzcv();
    private zzmn zzg = zzme.zzcv();
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;
    private String zzm = "";
    private String zzn = "";
    private String zzo = "";
    private String zzp = "";
    private int zzq;
    private String zzr = "";
    private String zzs = "";
    private String zzt = "";
    private long zzu;
    private long zzv;
    private String zzw = "";
    private boolean zzx;
    private String zzy = "";
    private long zzz;

    static {
        zzid zzid = new zzid();
        zzat = zzid;
        zzme.zzcp(zzid.class, zzid);
    }

    private zzid() {
    }

    public static zzic zzaE() {
        return (zzic) zzat.zzck();
    }

    public static zzic zzaF(zzid zzid) {
        zzma zzck = zzat.zzck();
        zzck.zzbd(zzid);
        return (zzic) zzck;
    }

    private final void zzcy() {
        zzmn zzmn = this.zzf;
        if (!zzmn.zza()) {
            this.zzf = zzme.zzcw(zzmn);
        }
    }

    private final void zzcz() {
        zzmn zzmn = this.zzg;
        if (!zzmn.zza()) {
            this.zzg = zzme.zzcw(zzmn);
        }
    }

    public final String zzA() {
        return this.zzs;
    }

    public final String zzB() {
        return this.zzt;
    }

    public final boolean zzC() {
        return (this.zzb & 16384) != 0;
    }

    public final long zzD() {
        return this.zzu;
    }

    public final boolean zzE() {
        return (this.zzb & 32768) != 0;
    }

    public final long zzF() {
        return this.zzv;
    }

    public final String zzG() {
        return this.zzw;
    }

    public final boolean zzH() {
        return (this.zzb & 131072) != 0;
    }

    public final boolean zzI() {
        return this.zzx;
    }

    public final String zzJ() {
        return this.zzy;
    }

    public final boolean zzK() {
        return (this.zzb & 524288) != 0;
    }

    public final long zzL() {
        return this.zzz;
    }

    public final boolean zzM() {
        return (this.zzb & 1048576) != 0;
    }

    public final int zzN() {
        return this.zzA;
    }

    public final String zzO() {
        return this.zzB;
    }

    public final String zzP() {
        return this.zzC;
    }

    public final boolean zzQ() {
        return (this.zzb & 8388608) != 0;
    }

    public final boolean zzR() {
        return this.zzD;
    }

    public final List zzS() {
        return this.zzE;
    }

    public final String zzT() {
        return this.zzF;
    }

    public final boolean zzU() {
        return (this.zzb & 33554432) != 0;
    }

    public final int zzV() {
        return this.zzG;
    }

    public final boolean zzW() {
        return (this.zzb & 536870912) != 0;
    }

    public final long zzX() {
        return this.zzK;
    }

    public final boolean zzY() {
        return (this.zzb & Integer.MIN_VALUE) != 0;
    }

    public final String zzZ() {
        return this.zzM;
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final boolean zzaA() {
        return (this.zzd & 134217728) != 0;
    }

    public final long zzaB() {
        return this.zzaq;
    }

    public final boolean zzaC() {
        return (this.zzd & 536870912) != 0;
    }

    public final zzho zzaD() {
        zzho zzho = this.zzas;
        if (zzho == null) {
            return zzho.zzc();
        }
        return zzho;
    }

    public final /* synthetic */ void zzaG(int i) {
        this.zzb |= 1;
        this.zze = 1;
    }

    public final /* synthetic */ void zzaH(int i, zzhs zzhs) {
        zzhs.getClass();
        zzcy();
        this.zzf.set(i, zzhs);
    }

    public final /* synthetic */ void zzaI(zzhs zzhs) {
        zzhs.getClass();
        zzcy();
        this.zzf.add(zzhs);
    }

    public final /* synthetic */ void zzaJ(Iterable iterable) {
        zzcy();
        zzkr.zzce(iterable, this.zzf);
    }

    public final /* synthetic */ void zzaK() {
        this.zzf = zzme.zzcv();
    }

    public final /* synthetic */ void zzaL(int i) {
        zzcy();
        this.zzf.remove(i);
    }

    public final /* synthetic */ void zzaM(int i, zziu zziu) {
        zziu.getClass();
        zzcz();
        this.zzg.set(i, zziu);
    }

    public final /* synthetic */ void zzaN(zziu zziu) {
        zziu.getClass();
        zzcz();
        this.zzg.add(zziu);
    }

    public final /* synthetic */ void zzaO(Iterable iterable) {
        zzcz();
        zzkr.zzce(iterable, this.zzg);
    }

    public final /* synthetic */ void zzaP(int i) {
        zzcz();
        this.zzg.remove(i);
    }

    public final /* synthetic */ void zzaQ(long j) {
        this.zzb |= 2;
        this.zzh = j;
    }

    public final /* synthetic */ void zzaR() {
        this.zzb &= -3;
        this.zzh = 0;
    }

    public final /* synthetic */ void zzaS(long j) {
        this.zzb |= 4;
        this.zzi = j;
    }

    public final /* synthetic */ void zzaT(long j) {
        this.zzb |= 8;
        this.zzj = j;
    }

    public final /* synthetic */ void zzaU(long j) {
        this.zzb |= 16;
        this.zzk = j;
    }

    public final /* synthetic */ void zzaV() {
        this.zzb &= -17;
        this.zzk = 0;
    }

    public final /* synthetic */ void zzaW(long j) {
        this.zzb |= 32;
        this.zzl = j;
    }

    public final /* synthetic */ void zzaX() {
        this.zzb &= -33;
        this.zzl = 0;
    }

    public final /* synthetic */ void zzaY(String str) {
        this.zzb |= 64;
        this.zzm = FaceEnvironment.OS;
    }

    public final /* synthetic */ void zzaZ(String str) {
        str.getClass();
        this.zzb |= 128;
        this.zzn = str;
    }

    public final boolean zzaa() {
        return (this.zzd & 2) != 0;
    }

    public final int zzab() {
        return this.zzO;
    }

    public final boolean zzac() {
        return (this.zzd & 16) != 0;
    }

    public final long zzad() {
        return this.zzS;
    }

    public final boolean zzae() {
        return (this.zzd & 128) != 0;
    }

    public final String zzaf() {
        return this.zzV;
    }

    public final boolean zzag() {
        return (this.zzd & 8192) != 0;
    }

    public final String zzah() {
        return this.zzab;
    }

    public final boolean zzai() {
        return (this.zzd & 32768) != 0;
    }

    public final long zzaj() {
        return this.zzae;
    }

    public final boolean zzak() {
        return this.zzaf;
    }

    public final boolean zzal() {
        return (this.zzd & 131072) != 0;
    }

    public final String zzam() {
        return this.zzag;
    }

    public final boolean zzan() {
        return (this.zzd & 262144) != 0;
    }

    public final boolean zzao() {
        return this.zzah;
    }

    public final boolean zzap() {
        return (this.zzd & 524288) != 0;
    }

    public final String zzaq() {
        return this.zzai;
    }

    public final int zzar() {
        return this.zzaj;
    }

    public final boolean zzas() {
        return (this.zzd & 4194304) != 0;
    }

    public final zzhe zzat() {
        zzhe zzhe = this.zzal;
        if (zzhe == null) {
            return zzhe.zzi();
        }
        return zzhe;
    }

    public final boolean zzau() {
        return (this.zzd & 8388608) != 0;
    }

    public final int zzav() {
        return this.zzam;
    }

    public final boolean zzaw() {
        return (this.zzd & 16777216) != 0;
    }

    public final zzha zzax() {
        zzha zzha = this.zzan;
        if (zzha == null) {
            return zzha.zzs();
        }
        return zzha;
    }

    public final boolean zzay() {
        return (this.zzd & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0;
    }

    public final zzis zzaz() {
        zzis zzis = this.zzap;
        if (zzis == null) {
            return zzis.zzc();
        }
        return zzis;
    }

    public final int zzb() {
        return this.zze;
    }

    public final /* synthetic */ void zzbA(long j) {
        this.zzb |= 536870912;
        this.zzK = j;
    }

    public final /* synthetic */ void zzbB(String str) {
        str.getClass();
        this.zzb |= Integer.MIN_VALUE;
        this.zzM = str;
    }

    public final /* synthetic */ void zzbC() {
        this.zzb &= Integer.MAX_VALUE;
        this.zzM = zzat.zzM;
    }

    public final /* synthetic */ void zzbD(int i) {
        this.zzd |= 2;
        this.zzO = i;
    }

    public final /* synthetic */ void zzbE(zzig zzig) {
        zzig.getClass();
        this.zzQ = zzig;
        this.zzd |= 8;
    }

    public final /* synthetic */ void zzbF(Iterable iterable) {
        zzml zzml = this.zzR;
        if (!zzml.zza()) {
            int size = zzml.size();
            this.zzR = zzml.zze(size + size);
        }
        zzkr.zzce(iterable, this.zzR);
    }

    public final /* synthetic */ void zzbG(long j) {
        this.zzd |= 16;
        this.zzS = j;
    }

    public final /* synthetic */ void zzbH(long j) {
        this.zzd |= 32;
        this.zzT = j;
    }

    public final /* synthetic */ void zzbI(String str) {
        this.zzd |= 128;
        this.zzV = str;
    }

    public final /* synthetic */ void zzbJ(String str) {
        str.getClass();
        this.zzd |= 8192;
        this.zzab = str;
    }

    public final /* synthetic */ void zzbK() {
        this.zzd &= -8193;
        this.zzab = zzat.zzab;
    }

    public final /* synthetic */ void zzbL(Iterable iterable) {
        zzmn zzmn = this.zzac;
        if (!zzmn.zza()) {
            this.zzac = zzme.zzcw(zzmn);
        }
        zzkr.zzce(iterable, this.zzac);
    }

    public final /* synthetic */ void zzbM(String str) {
        str.getClass();
        this.zzd |= 16384;
        this.zzad = str;
    }

    public final /* synthetic */ void zzbN(long j) {
        this.zzd |= 32768;
        this.zzae = j;
    }

    public final /* synthetic */ void zzbO(boolean z) {
        this.zzd |= 65536;
        this.zzaf = z;
    }

    public final /* synthetic */ void zzbP(String str) {
        this.zzd |= 131072;
        this.zzag = str;
    }

    public final /* synthetic */ void zzbQ(boolean z) {
        this.zzd |= 262144;
        this.zzah = z;
    }

    public final /* synthetic */ void zzbR(String str) {
        str.getClass();
        this.zzd |= 524288;
        this.zzai = str;
    }

    public final /* synthetic */ void zzbS(int i) {
        this.zzd |= 1048576;
        this.zzaj = i;
    }

    public final /* synthetic */ void zzbT(zzhe zzhe) {
        zzhe.getClass();
        this.zzal = zzhe;
        this.zzd |= 4194304;
    }

    public final /* synthetic */ void zzbU(int i) {
        this.zzd |= 8388608;
        this.zzam = i;
    }

    public final /* synthetic */ void zzbV(zzha zzha) {
        zzha.getClass();
        this.zzan = zzha;
        this.zzd |= 16777216;
    }

    public final /* synthetic */ void zzbW(zzis zzis) {
        this.zzap = zzis;
        this.zzd |= AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
    }

    public final /* synthetic */ void zzbX(long j) {
        this.zzd |= 134217728;
        this.zzaq = j;
    }

    public final /* synthetic */ void zzbY(String str) {
        this.zzd |= 268435456;
        this.zzar = "";
    }

    public final /* synthetic */ void zzbZ(zzho zzho) {
        zzho.getClass();
        this.zzas = zzho;
        this.zzd |= 536870912;
    }

    public final /* synthetic */ void zzba(String str) {
        str.getClass();
        this.zzb |= 256;
        this.zzo = str;
    }

    public final /* synthetic */ void zzbb() {
        this.zzb &= -257;
        this.zzo = zzat.zzo;
    }

    public final /* synthetic */ void zzbc(String str) {
        str.getClass();
        this.zzb |= 512;
        this.zzp = str;
    }

    public final /* synthetic */ void zzbd(int i) {
        this.zzb |= 1024;
        this.zzq = i;
    }

    public final /* synthetic */ void zzbe(String str) {
        str.getClass();
        this.zzb |= 2048;
        this.zzr = str;
    }

    public final /* synthetic */ void zzbf(String str) {
        str.getClass();
        this.zzb |= 4096;
        this.zzs = str;
    }

    public final /* synthetic */ void zzbg(String str) {
        str.getClass();
        this.zzb |= 8192;
        this.zzt = str;
    }

    public final /* synthetic */ void zzbh(long j) {
        this.zzb |= 16384;
        this.zzu = j;
    }

    public final /* synthetic */ void zzbi(long j) {
        this.zzb |= 32768;
        this.zzv = 130000;
    }

    public final /* synthetic */ void zzbj(String str) {
        str.getClass();
        this.zzb |= 65536;
        this.zzw = str;
    }

    public final /* synthetic */ void zzbk() {
        this.zzb &= -65537;
        this.zzw = zzat.zzw;
    }

    public final /* synthetic */ void zzbl(boolean z) {
        this.zzb |= 131072;
        this.zzx = z;
    }

    public final /* synthetic */ void zzbm() {
        this.zzb &= -131073;
        this.zzx = false;
    }

    public final /* synthetic */ void zzbn(String str) {
        str.getClass();
        this.zzb |= 262144;
        this.zzy = str;
    }

    public final /* synthetic */ void zzbo() {
        this.zzb &= -262145;
        this.zzy = zzat.zzy;
    }

    public final /* synthetic */ void zzbp(long j) {
        this.zzb |= 524288;
        this.zzz = j;
    }

    public final /* synthetic */ void zzbq(int i) {
        this.zzb |= 1048576;
        this.zzA = i;
    }

    public final /* synthetic */ void zzbr(String str) {
        this.zzb |= 2097152;
        this.zzB = str;
    }

    public final /* synthetic */ void zzbs() {
        this.zzb &= -2097153;
        this.zzB = zzat.zzB;
    }

    public final /* synthetic */ void zzbt(String str) {
        str.getClass();
        this.zzb |= 4194304;
        this.zzC = str;
    }

    public final /* synthetic */ void zzbu(boolean z) {
        this.zzb |= 8388608;
        this.zzD = z;
    }

    public final /* synthetic */ void zzbv(Iterable iterable) {
        zzmn zzmn = this.zzE;
        if (!zzmn.zza()) {
            this.zzE = zzme.zzcw(zzmn);
        }
        zzkr.zzce(iterable, this.zzE);
    }

    public final /* synthetic */ void zzbw() {
        this.zzE = zzme.zzcv();
    }

    public final /* synthetic */ void zzbx(String str) {
        str.getClass();
        this.zzb |= 16777216;
        this.zzF = str;
    }

    public final /* synthetic */ void zzby(int i) {
        this.zzb |= 33554432;
        this.zzG = i;
    }

    public final /* synthetic */ void zzbz() {
        this.zzb &= -268435457;
        this.zzJ = zzat.zzJ;
    }

    public final List zzc() {
        return this.zzf;
    }

    public final int zzd() {
        return this.zzf.size();
    }

    public final zzhs zze(int i) {
        return (zzhs) this.zzf.get(i);
    }

    public final List zzf() {
        return this.zzg;
    }

    public final int zzg() {
        return this.zzg.size();
    }

    public final zziu zzh(int i) {
        return (zziu) this.zzg.get(i);
    }

    public final boolean zzi() {
        return (this.zzb & 2) != 0;
    }

    public final long zzj() {
        return this.zzh;
    }

    public final boolean zzk() {
        return (this.zzb & 4) != 0;
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzme.zzcq(zzat, "\u0004C\u0000\u0002\u0001VC\u0000\u0005\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဂ\u0001\u0005ဂ\u0002\u0006ဂ\u0003\u0007ဂ\u0005\bဈ\u0006\tဈ\u0007\nဈ\b\u000bဈ\t\fင\n\rဈ\u000b\u000eဈ\f\u0010ဈ\r\u0011ဂ\u000e\u0012ဂ\u000f\u0013ဈ\u0010\u0014ဇ\u0011\u0015ဈ\u0012\u0016ဂ\u0013\u0017င\u0014\u0018ဈ\u0015\u0019ဈ\u0016\u001aဂ\u0004\u001cဇ\u0017\u001d\u001b\u001eဈ\u0018\u001fင\u0019 င\u001a!င\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဈ\u001f&ဈ 'င!)ဈ\",ဉ#-\u001d.ဂ$/ဂ%2ဈ&4ဈ'5᠌(7ဇ)9ဈ*:ဇ+;ဉ,?ဈ-@\u001aAဈ.Cဂ/Dဇ0Gဈ1Hဇ2Iဈ3Jင4Kဈ5Lဉ6Mင7Oဉ8Pဈ9Qဉ:Rဂ;Sဈ<Vဉ=", new Object[]{"zzb", "zzd", "zze", "zzf", zzhs.class, "zzg", zziu.class, "zzh", "zzi", "zzj", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzk", "zzD", "zzE", zzhg.class, "zzF", "zzG", "zzH", "zzI", "zzJ", "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzR", "zzS", "zzT", "zzU", "zzV", "zzW", zzgw.zza, "zzX", "zzY", "zzZ", "zzaa", "zzab", "zzac", "zzad", "zzae", "zzaf", "zzag", "zzah", "zzai", "zzaj", "zzak", "zzal", "zzam", "zzan", "zzao", "zzap", "zzaq", "zzar", "zzas"});
        } else if (i2 == 3) {
            return new zzid();
        } else {
            if (i2 == 4) {
                return new zzic((byte[]) null);
            }
            if (i2 == 5) {
                return zzat;
            }
            throw null;
        }
    }

    public final long zzm() {
        return this.zzi;
    }

    public final boolean zzn() {
        return (this.zzb & 8) != 0;
    }

    public final long zzo() {
        return this.zzj;
    }

    public final boolean zzp() {
        return (this.zzb & 16) != 0;
    }

    public final long zzq() {
        return this.zzk;
    }

    public final boolean zzr() {
        return (this.zzb & 32) != 0;
    }

    public final long zzs() {
        return this.zzl;
    }

    public final String zzt() {
        return this.zzm;
    }

    public final String zzu() {
        return this.zzn;
    }

    public final String zzv() {
        return this.zzo;
    }

    public final String zzw() {
        return this.zzp;
    }

    public final boolean zzx() {
        return (this.zzb & 1024) != 0;
    }

    public final int zzy() {
        return this.zzq;
    }

    public final String zzz() {
        return this.zzr;
    }
}
