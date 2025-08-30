package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.zzao;
import com.google.android.gms.location.zzap;
import com.google.android.gms.location.zzaq;
import com.google.android.gms.location.zzat;

@SafeParcelable.Class(creator = "LocationRequestUpdateDataCreator")
@SafeParcelable.Reserved({1000})
public final class zzbe extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbe> CREATOR = new zzbd();
    @SafeParcelable.Field(defaultValueUnchecked = "LocationRequestUpdateData.OPERATION_ADD", id = 1)
    private int zza;
    @SafeParcelable.Field(defaultValueUnchecked = "null", id = 2)
    private zzbc zzb;
    @SafeParcelable.Field(defaultValueUnchecked = "null", getter = "getLocationListenerBinder", id = 3, type = "android.os.IBinder")
    private zzaq zzc;
    @SafeParcelable.Field(defaultValueUnchecked = "null", id = 4)
    private PendingIntent zzd;
    @SafeParcelable.Field(defaultValueUnchecked = "null", getter = "getLocationCallbackBinder", id = 5, type = "android.os.IBinder")
    private zzap zze;
    @SafeParcelable.Field(defaultValueUnchecked = "null", getter = "getFusedLocationProviderCallbackBinder", id = 6, type = "android.os.IBinder")
    private zzai zzf;

    @SafeParcelable.Constructor
    public zzbe(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) zzbc zzbc, @SafeParcelable.Param(id = 3) IBinder iBinder, @SafeParcelable.Param(id = 4) PendingIntent pendingIntent, @SafeParcelable.Param(id = 5) IBinder iBinder2, @SafeParcelable.Param(id = 6) IBinder iBinder3) {
        zzaq zzaq;
        zzap zzap;
        this.zza = i;
        this.zzb = zzbc;
        zzai zzai = null;
        if (iBinder == null) {
            zzaq = null;
        } else {
            zzaq = zzat.zza(iBinder);
        }
        this.zzc = zzaq;
        this.zzd = pendingIntent;
        if (iBinder2 == null) {
            zzap = null;
        } else {
            zzap = zzao.zza(iBinder2);
        }
        this.zze = zzap;
        if (iBinder3 != null) {
            IInterface queryLocalInterface = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            if (queryLocalInterface instanceof zzai) {
                zzai = (zzai) queryLocalInterface;
            } else {
                zzai = new zzak(iBinder3);
            }
        }
        this.zzf = zzai;
    }

    public static zzbe zza(zzaq zzaq, @Nullable zzai zzai) {
        return new zzbe(2, (zzbc) null, zzaq.asBinder(), (PendingIntent) null, (IBinder) null, zzai != null ? zzai.asBinder() : null);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        IBinder iBinder;
        IBinder iBinder2;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        zzaq zzaq = this.zzc;
        IBinder iBinder3 = null;
        if (zzaq == null) {
            iBinder = null;
        } else {
            iBinder = zzaq.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 3, iBinder, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        zzap zzap = this.zze;
        if (zzap == null) {
            iBinder2 = null;
        } else {
            iBinder2 = zzap.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 5, iBinder2, false);
        zzai zzai = this.zzf;
        if (zzai != null) {
            iBinder3 = zzai.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 6, iBinder3, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public static zzbe zza(zzbc zzbc, PendingIntent pendingIntent, @Nullable zzai zzai) {
        return new zzbe(1, zzbc, (IBinder) null, pendingIntent, (IBinder) null, zzai != null ? zzai.asBinder() : null);
    }

    public static zzbe zza(zzap zzap, @Nullable zzai zzai) {
        return new zzbe(2, (zzbc) null, (IBinder) null, (PendingIntent) null, zzap.asBinder(), zzai != null ? zzai.asBinder() : null);
    }
}
