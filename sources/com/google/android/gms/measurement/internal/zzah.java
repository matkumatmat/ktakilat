package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ConditionalUserPropertyParcelCreator")
public final class zzah extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzah> CREATOR = new zzai();
    @SafeParcelable.Field(id = 2)
    @Nullable
    public String zza;
    @SafeParcelable.Field(id = 3)
    public String zzb;
    @SafeParcelable.Field(id = 4)
    public zzpk zzc;
    @SafeParcelable.Field(id = 5)
    public long zzd;
    @SafeParcelable.Field(id = 6)
    public boolean zze;
    @SafeParcelable.Field(id = 7)
    @Nullable
    public String zzf;
    @SafeParcelable.Field(id = 8)
    @Nullable
    public final zzbg zzg;
    @SafeParcelable.Field(id = 9)
    public long zzh;
    @SafeParcelable.Field(id = 10)
    @Nullable
    public zzbg zzi;
    @SafeParcelable.Field(id = 11)
    public final long zzj;
    @SafeParcelable.Field(id = 12)
    @Nullable
    public final zzbg zzk;

    public zzah(zzah zzah) {
        Preconditions.checkNotNull(zzah);
        this.zza = zzah.zza;
        this.zzb = zzah.zzb;
        this.zzc = zzah.zzc;
        this.zzd = zzah.zzd;
        this.zze = zzah.zze;
        this.zzf = zzah.zzf;
        this.zzg = zzah.zzg;
        this.zzh = zzah.zzh;
        this.zzi = zzah.zzi;
        this.zzj = zzah.zzj;
        this.zzk = zzah.zzk;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzc, i, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zze);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzg, i, false);
        SafeParcelWriter.writeLong(parcel, 9, this.zzh);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzi, i, false);
        SafeParcelWriter.writeLong(parcel, 11, this.zzj);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzk, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzah(@SafeParcelable.Param(id = 2) @Nullable String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) zzpk zzpk, @SafeParcelable.Param(id = 5) long j, @SafeParcelable.Param(id = 6) boolean z, @SafeParcelable.Param(id = 7) @Nullable String str3, @SafeParcelable.Param(id = 8) @Nullable zzbg zzbg, @SafeParcelable.Param(id = 9) long j2, @SafeParcelable.Param(id = 10) @Nullable zzbg zzbg2, @SafeParcelable.Param(id = 11) long j3, @SafeParcelable.Param(id = 12) @Nullable zzbg zzbg3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzpk;
        this.zzd = j;
        this.zze = z;
        this.zzf = str3;
        this.zzg = zzbg;
        this.zzh = j2;
        this.zzi = zzbg2;
        this.zzj = j3;
        this.zzk = zzbg3;
    }
}
