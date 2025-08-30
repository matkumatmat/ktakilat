package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Comparator;

@SafeParcelable.Class(creator = "DetectedActivityCreator")
@SafeParcelable.Reserved({1000})
public class DetectedActivity extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DetectedActivity> CREATOR = new zzl();
    public static final int IN_VEHICLE = 0;
    public static final int ON_BICYCLE = 1;
    public static final int ON_FOOT = 2;
    public static final int RUNNING = 8;
    public static final int STILL = 3;
    public static final int TILTING = 5;
    public static final int UNKNOWN = 4;
    public static final int WALKING = 7;
    private static final Comparator<DetectedActivity> zza = new zzm();
    @ShowFirstParty
    private static final int[] zzb = {9, 10};
    private static final int[] zzc = {0, 1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 16, 17, 18, 19, 20, 21, 22};
    @SafeParcelable.Field(id = 1)
    private int zzd;
    @SafeParcelable.Field(id = 2)
    private int zze;

    @SafeParcelable.Constructor
    public DetectedActivity(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2) {
        this.zzd = i;
        this.zze = i2;
    }

    @ShowFirstParty
    public boolean equals(Object obj) {
        if (obj instanceof DetectedActivity) {
            DetectedActivity detectedActivity = (DetectedActivity) obj;
            if (this.zzd == detectedActivity.zzd && this.zze == detectedActivity.zze) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int getConfidence() {
        return this.zze;
    }

    public int getType() {
        int i = this.zzd;
        if (i > 22 || i < 0) {
            return 4;
        }
        return i;
    }

    @ShowFirstParty
    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzd), Integer.valueOf(this.zze));
    }

    public String toString() {
        String str;
        int type = getType();
        if (type == 0) {
            str = "IN_VEHICLE";
        } else if (type == 1) {
            str = "ON_BICYCLE";
        } else if (type == 2) {
            str = "ON_FOOT";
        } else if (type == 3) {
            str = "STILL";
        } else if (type == 4) {
            str = "UNKNOWN";
        } else if (type == 5) {
            str = "TILTING";
        } else if (type == 7) {
            str = "WALKING";
        } else if (type == 8) {
            str = "RUNNING";
        } else if (type == 16) {
            str = "IN_ROAD_VEHICLE";
        } else if (type != 17) {
            str = Integer.toString(type);
        } else {
            str = "IN_RAIL_VEHICLE";
        }
        int i = this.zze;
        StringBuilder sb = new StringBuilder(ba.e(48, str));
        sb.append("DetectedActivity [type=");
        sb.append(str);
        sb.append(", confidence=");
        sb.append(i);
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzd);
        SafeParcelWriter.writeInt(parcel, 2, this.zze);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
