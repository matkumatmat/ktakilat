package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.apache.commons.lang3.StringUtils;

@SafeParcelable.Class(creator = "ActivityTransitionEventCreator")
@SafeParcelable.Reserved({1000})
public class ActivityTransitionEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityTransitionEvent> CREATOR = new zzh();
    @SafeParcelable.Field(getter = "getActivityType", id = 1)
    private final int zza;
    @SafeParcelable.Field(getter = "getTransitionType", id = 2)
    private final int zzb;
    @SafeParcelable.Field(getter = "getElapsedRealTimeNanos", id = 3)
    private final long zzc;

    @SafeParcelable.Constructor
    public ActivityTransitionEvent(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) long j) {
        ActivityTransition.zza(i2);
        this.zza = i;
        this.zzb = i2;
        this.zzc = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityTransitionEvent)) {
            return false;
        }
        ActivityTransitionEvent activityTransitionEvent = (ActivityTransitionEvent) obj;
        if (this.zza == activityTransitionEvent.zza && this.zzb == activityTransitionEvent.zzb && this.zzc == activityTransitionEvent.zzc) {
            return true;
        }
        return false;
    }

    public int getActivityType() {
        return this.zza;
    }

    public long getElapsedRealTimeNanos() {
        return this.zzc;
    }

    public int getTransitionType() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Long.valueOf(this.zzc));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = this.zza;
        StringBuilder sb2 = new StringBuilder(24);
        sb2.append("ActivityType ");
        sb2.append(i);
        sb.append(sb2.toString());
        sb.append(StringUtils.SPACE);
        int i2 = this.zzb;
        StringBuilder sb3 = new StringBuilder(26);
        sb3.append("TransitionType ");
        sb3.append(i2);
        sb.append(sb3.toString());
        sb.append(StringUtils.SPACE);
        long j = this.zzc;
        StringBuilder sb4 = new StringBuilder(41);
        sb4.append("ElapsedRealTimeNanos ");
        sb4.append(j);
        sb.append(sb4.toString());
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getActivityType());
        SafeParcelWriter.writeInt(parcel, 2, getTransitionType());
        SafeParcelWriter.writeLong(parcel, 3, getElapsedRealTimeNanos());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
