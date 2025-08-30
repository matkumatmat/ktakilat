package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

final class zzh {
    @Nullable
    private Long zzA;
    private long zzB;
    @Nullable
    private String zzC;
    private int zzD;
    private int zzE;
    private long zzF;
    private String zzG;
    @Nullable
    private byte[] zzH;
    private int zzI;
    private long zzJ;
    private long zzK;
    private long zzL;
    private long zzM;
    private long zzN;
    private long zzO;
    @Nullable
    private String zzP;
    private boolean zzQ;
    private long zzR;
    private long zzS;
    private final zzib zza;
    private final String zzb;
    @Nullable
    private String zzc;
    @Nullable
    private String zzd;
    @Nullable
    private String zze;
    @Nullable
    private String zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    @Nullable
    private String zzj;
    private long zzk;
    @Nullable
    private String zzl;
    private long zzm;
    private long zzn;
    private boolean zzo;
    private boolean zzp;
    @Nullable
    private Boolean zzq;
    private long zzr;
    @Nullable
    private List zzs;
    @Nullable
    private String zzt;
    private boolean zzu;
    private long zzv;
    private long zzw;
    private int zzx;
    private boolean zzy;
    @Nullable
    private Long zzz;

    @WorkerThread
    public zzh(zzib zzib, String str) {
        Preconditions.checkNotNull(zzib);
        Preconditions.checkNotEmpty(str);
        this.zza = zzib;
        this.zzb = str;
        zzib.zzaW().zzg();
    }

    @WorkerThread
    public final void zzA(long j) {
        boolean z;
        this.zza.zzaW().zzg();
        boolean z2 = this.zzQ;
        if (this.zzn != j) {
            z = true;
        } else {
            z = false;
        }
        this.zzQ = z2 | z;
        this.zzn = j;
    }

    @WorkerThread
    public final long zzB() {
        this.zza.zzaW().zzg();
        return this.zzr;
    }

    @WorkerThread
    public final void zzC(long j) {
        boolean z;
        this.zza.zzaW().zzg();
        boolean z2 = this.zzQ;
        if (this.zzr != j) {
            z = true;
        } else {
            z = false;
        }
        this.zzQ = z2 | z;
        this.zzr = j;
    }

    @WorkerThread
    public final boolean zzD() {
        this.zza.zzaW().zzg();
        return this.zzo;
    }

    @WorkerThread
    public final void zzE(boolean z) {
        boolean z2;
        this.zza.zzaW().zzg();
        boolean z3 = this.zzQ;
        if (this.zzo != z) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.zzQ = z3 | z2;
        this.zzo = z;
    }

    @WorkerThread
    public final void zzF(long j) {
        boolean z;
        boolean z2 = false;
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.zza.zzaW().zzg();
        boolean z3 = this.zzQ;
        if (this.zzg != j) {
            z2 = true;
        }
        this.zzQ = z3 | z2;
        this.zzg = j;
    }

    @WorkerThread
    public final long zzG() {
        this.zza.zzaW().zzg();
        return this.zzg;
    }

    @WorkerThread
    public final long zzH() {
        this.zza.zzaW().zzg();
        return this.zzR;
    }

    @WorkerThread
    public final void zzI(long j) {
        boolean z;
        this.zza.zzaW().zzg();
        boolean z2 = this.zzQ;
        if (this.zzR != j) {
            z = true;
        } else {
            z = false;
        }
        this.zzQ = z2 | z;
        this.zzR = j;
    }

    @WorkerThread
    public final long zzJ() {
        this.zza.zzaW().zzg();
        return this.zzS;
    }

    @WorkerThread
    public final void zzK(long j) {
        boolean z;
        this.zza.zzaW().zzg();
        boolean z2 = this.zzQ;
        if (this.zzS != j) {
            z = true;
        } else {
            z = false;
        }
        this.zzQ = z2 | z;
        this.zzS = j;
    }

    @WorkerThread
    public final void zzL() {
        zzib zzib = this.zza;
        zzib.zzaW().zzg();
        long j = this.zzg + 1;
        if (j > 2147483647L) {
            zzib.zzaV().zze().zzb("Bundle index overflow. appId", zzgt.zzl(this.zzb));
            j = 0;
        }
        this.zzQ = true;
        this.zzg = j;
    }

    @WorkerThread
    public final void zzM(long j) {
        zzib zzib = this.zza;
        zzib.zzaW().zzg();
        long j2 = this.zzg + j;
        if (j2 > 2147483647L) {
            zzib.zzaV().zze().zzb("Bundle index overflow. appId", zzgt.zzl(this.zzb));
            j2 = -1 + j;
        }
        long j3 = this.zzF + 1;
        if (j3 > 2147483647L) {
            zzib.zzaV().zze().zzb("Delivery index overflow. appId", zzgt.zzl(this.zzb));
            j3 = 0;
        }
        this.zzQ = true;
        this.zzg = j2;
        this.zzF = j3;
    }

    @WorkerThread
    public final long zzN() {
        this.zza.zzaW().zzg();
        return this.zzJ;
    }

    @WorkerThread
    public final void zzO(long j) {
        boolean z;
        this.zza.zzaW().zzg();
        boolean z2 = this.zzQ;
        if (this.zzJ != j) {
            z = true;
        } else {
            z = false;
        }
        this.zzQ = z2 | z;
        this.zzJ = j;
    }

    @WorkerThread
    public final long zzP() {
        this.zza.zzaW().zzg();
        return this.zzK;
    }

    @WorkerThread
    public final void zzQ(long j) {
        boolean z;
        this.zza.zzaW().zzg();
        boolean z2 = this.zzQ;
        if (this.zzK != j) {
            z = true;
        } else {
            z = false;
        }
        this.zzQ = z2 | z;
        this.zzK = j;
    }

    @WorkerThread
    public final long zzR() {
        this.zza.zzaW().zzg();
        return this.zzL;
    }

    @WorkerThread
    public final void zzS(long j) {
        boolean z;
        this.zza.zzaW().zzg();
        boolean z2 = this.zzQ;
        if (this.zzL != j) {
            z = true;
        } else {
            z = false;
        }
        this.zzQ = z2 | z;
        this.zzL = j;
    }

    @WorkerThread
    public final long zzT() {
        this.zza.zzaW().zzg();
        return this.zzM;
    }

    @WorkerThread
    public final void zzU(long j) {
        boolean z;
        this.zza.zzaW().zzg();
        boolean z2 = this.zzQ;
        if (this.zzM != j) {
            z = true;
        } else {
            z = false;
        }
        this.zzQ = z2 | z;
        this.zzM = j;
    }

    @WorkerThread
    public final long zzV() {
        this.zza.zzaW().zzg();
        return this.zzO;
    }

    @WorkerThread
    public final void zzW(long j) {
        boolean z;
        this.zza.zzaW().zzg();
        boolean z2 = this.zzQ;
        if (this.zzO != j) {
            z = true;
        } else {
            z = false;
        }
        this.zzQ = z2 | z;
        this.zzO = j;
    }

    @WorkerThread
    public final long zzX() {
        this.zza.zzaW().zzg();
        return this.zzN;
    }

    @WorkerThread
    public final void zzY(long j) {
        boolean z;
        this.zza.zzaW().zzg();
        boolean z2 = this.zzQ;
        if (this.zzN != j) {
            z = true;
        } else {
            z = false;
        }
        this.zzQ = z2 | z;
        this.zzN = j;
    }

    @WorkerThread
    @Nullable
    public final String zzZ() {
        this.zza.zzaW().zzg();
        return this.zzP;
    }

    @WorkerThread
    public final boolean zza() {
        this.zza.zzaW().zzg();
        return this.zzQ;
    }

    @WorkerThread
    public final int zzaA() {
        this.zza.zzaW().zzg();
        return this.zzD;
    }

    @WorkerThread
    public final void zzaB(int i) {
        boolean z;
        this.zza.zzaW().zzg();
        boolean z2 = this.zzQ;
        if (this.zzD != i) {
            z = true;
        } else {
            z = false;
        }
        this.zzQ = z2 | z;
        this.zzD = i;
    }

    @WorkerThread
    public final int zzaC() {
        this.zza.zzaW().zzg();
        return this.zzE;
    }

    @WorkerThread
    public final void zzaD(int i) {
        boolean z;
        this.zza.zzaW().zzg();
        boolean z2 = this.zzQ;
        if (this.zzE != i) {
            z = true;
        } else {
            z = false;
        }
        this.zzQ = z2 | z;
        this.zzE = i;
    }

    @WorkerThread
    public final void zzaE(long j) {
        boolean z;
        this.zza.zzaW().zzg();
        boolean z2 = this.zzQ;
        if (this.zzF != j) {
            z = true;
        } else {
            z = false;
        }
        this.zzQ = z2 | z;
        this.zzF = j;
    }

    @WorkerThread
    public final long zzaF() {
        this.zza.zzaW().zzg();
        return this.zzF;
    }

    @WorkerThread
    public final void zzaG(String str) {
        boolean z;
        this.zza.zzaW().zzg();
        boolean z2 = this.zzQ;
        if (this.zzG != str) {
            z = true;
        } else {
            z = false;
        }
        this.zzQ = z2 | z;
        this.zzG = str;
    }

    @WorkerThread
    public final String zzaH() {
        this.zza.zzaW().zzg();
        return this.zzG;
    }

    @WorkerThread
    public final void zzaI(@Nullable byte[] bArr) {
        boolean z;
        this.zza.zzaW().zzg();
        boolean z2 = this.zzQ;
        if (this.zzH != bArr) {
            z = true;
        } else {
            z = false;
        }
        this.zzQ = z2 | z;
        this.zzH = bArr;
    }

    @WorkerThread
    @Nullable
    public final byte[] zzaJ() {
        this.zza.zzaW().zzg();
        return this.zzH;
    }

    @WorkerThread
    public final void zzaK(int i) {
        boolean z;
        this.zza.zzaW().zzg();
        boolean z2 = this.zzQ;
        if (this.zzI != i) {
            z = true;
        } else {
            z = false;
        }
        this.zzQ = z2 | z;
        this.zzI = i;
    }

    @WorkerThread
    public final int zzaL() {
        this.zza.zzaW().zzg();
        return this.zzI;
    }

    @WorkerThread
    @Nullable
    public final String zzaa() {
        this.zza.zzaW().zzg();
        String str = this.zzP;
        zzab((String) null);
        return str;
    }

    @WorkerThread
    public final void zzab(@Nullable String str) {
        this.zza.zzaW().zzg();
        this.zzQ |= !Objects.equals(this.zzP, str);
        this.zzP = str;
    }

    @WorkerThread
    public final boolean zzac() {
        this.zza.zzaW().zzg();
        return this.zzp;
    }

    @WorkerThread
    public final void zzad(boolean z) {
        boolean z2;
        this.zza.zzaW().zzg();
        boolean z3 = this.zzQ;
        if (this.zzp != z) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.zzQ = z3 | z2;
        this.zzp = z;
    }

    @WorkerThread
    @Nullable
    public final Boolean zzae() {
        this.zza.zzaW().zzg();
        return this.zzq;
    }

    @WorkerThread
    public final void zzaf(@Nullable Boolean bool) {
        this.zza.zzaW().zzg();
        this.zzQ |= !Objects.equals(this.zzq, bool);
        this.zzq = bool;
    }

    @WorkerThread
    @Nullable
    public final List zzag() {
        this.zza.zzaW().zzg();
        return this.zzs;
    }

    @WorkerThread
    public final void zzah(@Nullable List list) {
        ArrayList arrayList;
        this.zza.zzaW().zzg();
        if (!Objects.equals(this.zzs, list)) {
            this.zzQ = true;
            if (list != null) {
                arrayList = new ArrayList(list);
            } else {
                arrayList = null;
            }
            this.zzs = arrayList;
        }
    }

    @WorkerThread
    public final boolean zzai() {
        this.zza.zzaW().zzg();
        return this.zzu;
    }

    @WorkerThread
    public final void zzaj(boolean z) {
        boolean z2;
        this.zza.zzaW().zzg();
        boolean z3 = this.zzQ;
        if (this.zzu != z) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.zzQ = z3 | z2;
        this.zzu = z;
    }

    @WorkerThread
    public final long zzak() {
        this.zza.zzaW().zzg();
        return this.zzv;
    }

    @WorkerThread
    public final void zzal(long j) {
        boolean z;
        this.zza.zzaW().zzg();
        boolean z2 = this.zzQ;
        if (this.zzv != j) {
            z = true;
        } else {
            z = false;
        }
        this.zzQ = z2 | z;
        this.zzv = j;
    }

    @WorkerThread
    public final long zzam() {
        this.zza.zzaW().zzg();
        return this.zzw;
    }

    @WorkerThread
    public final void zzan(long j) {
        boolean z;
        this.zza.zzaW().zzg();
        boolean z2 = this.zzQ;
        if (this.zzw != j) {
            z = true;
        } else {
            z = false;
        }
        this.zzQ = z2 | z;
        this.zzw = j;
    }

    @WorkerThread
    public final int zzao() {
        this.zza.zzaW().zzg();
        return this.zzx;
    }

    @WorkerThread
    public final void zzap(int i) {
        boolean z;
        this.zza.zzaW().zzg();
        boolean z2 = this.zzQ;
        if (this.zzx != i) {
            z = true;
        } else {
            z = false;
        }
        this.zzQ = z2 | z;
        this.zzx = i;
    }

    @WorkerThread
    public final boolean zzaq() {
        this.zza.zzaW().zzg();
        return this.zzy;
    }

    @WorkerThread
    public final void zzar(boolean z) {
        boolean z2;
        this.zza.zzaW().zzg();
        boolean z3 = this.zzQ;
        if (this.zzy != z) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.zzQ = z3 | z2;
        this.zzy = z;
    }

    @WorkerThread
    @Nullable
    public final Long zzas() {
        this.zza.zzaW().zzg();
        return this.zzz;
    }

    @WorkerThread
    public final void zzat(@Nullable Long l) {
        this.zza.zzaW().zzg();
        this.zzQ |= !Objects.equals(this.zzz, l);
        this.zzz = l;
    }

    @WorkerThread
    @Nullable
    public final Long zzau() {
        this.zza.zzaW().zzg();
        return this.zzA;
    }

    @WorkerThread
    public final void zzav(@Nullable Long l) {
        this.zza.zzaW().zzg();
        this.zzQ |= !Objects.equals(this.zzA, l);
        this.zzA = l;
    }

    @WorkerThread
    public final long zzaw() {
        this.zza.zzaW().zzg();
        return this.zzB;
    }

    @WorkerThread
    public final void zzax(long j) {
        boolean z;
        this.zza.zzaW().zzg();
        boolean z2 = this.zzQ;
        if (this.zzB != j) {
            z = true;
        } else {
            z = false;
        }
        this.zzQ = z2 | z;
        this.zzB = j;
    }

    @WorkerThread
    @Nullable
    public final String zzay() {
        this.zza.zzaW().zzg();
        return this.zzC;
    }

    @WorkerThread
    public final void zzaz(@Nullable String str) {
        boolean z;
        this.zza.zzaW().zzg();
        boolean z2 = this.zzQ;
        if (this.zzC != str) {
            z = true;
        } else {
            z = false;
        }
        this.zzQ = z2 | z;
        this.zzC = str;
    }

    @WorkerThread
    public final void zzb() {
        this.zza.zzaW().zzg();
        this.zzQ = false;
    }

    @WorkerThread
    public final String zzc() {
        this.zza.zzaW().zzg();
        return this.zzb;
    }

    @WorkerThread
    @Nullable
    public final String zzd() {
        this.zza.zzaW().zzg();
        return this.zzc;
    }

    @WorkerThread
    public final void zze(@Nullable String str) {
        this.zza.zzaW().zzg();
        this.zzQ |= !Objects.equals(this.zzc, str);
        this.zzc = str;
    }

    @WorkerThread
    @Nullable
    public final String zzf() {
        this.zza.zzaW().zzg();
        return this.zzd;
    }

    @WorkerThread
    public final void zzg(@Nullable String str) {
        this.zza.zzaW().zzg();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzQ |= true ^ Objects.equals(this.zzd, str);
        this.zzd = str;
    }

    @WorkerThread
    @Nullable
    public final String zzh() {
        this.zza.zzaW().zzg();
        return this.zzt;
    }

    @WorkerThread
    public final void zzi(@Nullable String str) {
        this.zza.zzaW().zzg();
        this.zzQ |= !Objects.equals(this.zzt, str);
        this.zzt = str;
    }

    @WorkerThread
    @Nullable
    public final String zzj() {
        this.zza.zzaW().zzg();
        return this.zze;
    }

    @WorkerThread
    public final void zzk(@Nullable String str) {
        this.zza.zzaW().zzg();
        this.zzQ |= !Objects.equals(this.zze, str);
        this.zze = str;
    }

    @WorkerThread
    @Nullable
    public final String zzl() {
        this.zza.zzaW().zzg();
        return this.zzf;
    }

    @WorkerThread
    public final void zzm(@Nullable String str) {
        this.zza.zzaW().zzg();
        this.zzQ |= !Objects.equals(this.zzf, str);
        this.zzf = str;
    }

    @WorkerThread
    public final long zzn() {
        this.zza.zzaW().zzg();
        return this.zzh;
    }

    @WorkerThread
    public final void zzo(long j) {
        boolean z;
        this.zza.zzaW().zzg();
        boolean z2 = this.zzQ;
        if (this.zzh != j) {
            z = true;
        } else {
            z = false;
        }
        this.zzQ = z2 | z;
        this.zzh = j;
    }

    @WorkerThread
    public final long zzp() {
        this.zza.zzaW().zzg();
        return this.zzi;
    }

    @WorkerThread
    public final void zzq(long j) {
        boolean z;
        this.zza.zzaW().zzg();
        boolean z2 = this.zzQ;
        if (this.zzi != j) {
            z = true;
        } else {
            z = false;
        }
        this.zzQ = z2 | z;
        this.zzi = j;
    }

    @WorkerThread
    @Nullable
    public final String zzr() {
        this.zza.zzaW().zzg();
        return this.zzj;
    }

    @WorkerThread
    public final void zzs(@Nullable String str) {
        this.zza.zzaW().zzg();
        this.zzQ |= !Objects.equals(this.zzj, str);
        this.zzj = str;
    }

    @WorkerThread
    public final long zzt() {
        this.zza.zzaW().zzg();
        return this.zzk;
    }

    @WorkerThread
    public final void zzu(long j) {
        boolean z;
        this.zza.zzaW().zzg();
        boolean z2 = this.zzQ;
        if (this.zzk != j) {
            z = true;
        } else {
            z = false;
        }
        this.zzQ = z2 | z;
        this.zzk = j;
    }

    @WorkerThread
    @Nullable
    public final String zzv() {
        this.zza.zzaW().zzg();
        return this.zzl;
    }

    @WorkerThread
    public final void zzw(@Nullable String str) {
        this.zza.zzaW().zzg();
        this.zzQ |= !Objects.equals(this.zzl, str);
        this.zzl = str;
    }

    @WorkerThread
    public final long zzx() {
        this.zza.zzaW().zzg();
        return this.zzm;
    }

    @WorkerThread
    public final void zzy(long j) {
        boolean z;
        this.zza.zzaW().zzg();
        boolean z2 = this.zzQ;
        if (this.zzm != j) {
            z = true;
        } else {
            z = false;
        }
        this.zzQ = z2 | z;
        this.zzm = j;
    }

    @WorkerThread
    public final long zzz() {
        this.zza.zzaW().zzg();
        return this.zzn;
    }
}
