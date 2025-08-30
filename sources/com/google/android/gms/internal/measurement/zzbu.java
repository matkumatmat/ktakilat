package com.google.android.gms.internal.measurement;

final class zzbu extends zzca {
    private final String zzc;
    private final int zzd;
    private final int zze;

    public /* synthetic */ zzbu(String str, boolean z, int i, zzbr zzbr, zzbs zzbs, int i2, byte[] bArr) {
        this.zzc = str;
        this.zzd = i;
        this.zze = i2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzca) {
            zzca zzca = (zzca) obj;
            if (this.zzc.equals(zzca.zza())) {
                zzca.zzb();
                int i = this.zzd;
                int zze2 = zzca.zze();
                if (i == 0) {
                    throw null;
                } else if (i == zze2) {
                    zzca.zzc();
                    zzca.zzd();
                    int i2 = this.zze;
                    int zzf = zzca.zzf();
                    if (i2 == 0) {
                        throw null;
                    } else if (zzf == 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.zzc.hashCode() ^ 1000003;
        int i = this.zzd;
        if (i != 0) {
            int i2 = (((hashCode * 1000003) ^ 1237) * 1000003) ^ i;
            if (this.zze != 0) {
                return (i2 * 583896283) ^ 1;
            }
            throw null;
        }
        throw null;
    }

    public final String toString() {
        String str;
        int i = this.zzd;
        String str2 = "null";
        if (i == 1) {
            str = "ALL_CHECKS";
        } else if (i == 2) {
            str = "SKIP_COMPLIANCE_CHECK";
        } else if (i == 3) {
            str = "SKIP_SECURITY_CHECK";
        } else if (i != 4) {
            str = str2;
        } else {
            str = "NO_CHECKS";
        }
        if (this.zze == 1) {
            str2 = "READ_AND_WRITE";
        }
        String str3 = this.zzc;
        int e = ba.e(73, str3);
        StringBuilder sb = new StringBuilder(str2.length() + str.length() + e + 91 + 1);
        sb.append("FileComplianceOptions{fileOwner=");
        sb.append(str3);
        sb.append(", hasDifferentDmaOwner=false, fileChecks=");
        sb.append(str);
        return e.q(sb, ", dataForwardingNotAllowedResolver=null, multipleProductIdGroupsResolver=null, filePurpose=", str2, "}");
    }

    public final String zza() {
        return this.zzc;
    }

    public final boolean zzb() {
        return false;
    }

    public final zzbr zzc() {
        return null;
    }

    public final zzbs zzd() {
        return null;
    }

    public final int zze() {
        return this.zzd;
    }

    public final int zzf() {
        return this.zze;
    }
}
