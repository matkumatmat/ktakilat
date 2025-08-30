package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

@SafeParcelable.Class(creator = "ActivityTransitionRequestCreator")
@SafeParcelable.Reserved({1000})
public class ActivityTransitionRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityTransitionRequest> CREATOR = new zzj();
    public static final Comparator<ActivityTransition> IS_SAME_TRANSITION = new zzi();
    @SafeParcelable.Field(getter = "getActivityTransitions", id = 1)
    private final List<ActivityTransition> zza;
    @SafeParcelable.Field(getter = "getTag", id = 2)
    @Nullable
    private final String zzb;
    @SafeParcelable.Field(getter = "getClients", id = 3)
    private final List<ClientIdentity> zzc;

    @SafeParcelable.Constructor
    public ActivityTransitionRequest(@SafeParcelable.Param(id = 1) List<ActivityTransition> list, @SafeParcelable.Param(id = 2) @Nullable String str, @SafeParcelable.Param(id = 3) @Nullable List<ClientIdentity> list2) {
        List<ClientIdentity> list3;
        Preconditions.checkNotNull(list, "transitions can't be null");
        Preconditions.checkArgument(list.size() > 0, "transitions can't be empty.");
        TreeSet treeSet = new TreeSet(IS_SAME_TRANSITION);
        for (ActivityTransition next : list) {
            Preconditions.checkArgument(treeSet.add(next), String.format("Found duplicated transition: %s.", new Object[]{next}));
        }
        this.zza = Collections.unmodifiableList(list);
        this.zzb = str;
        if (list2 == null) {
            list3 = Collections.emptyList();
        } else {
            list3 = Collections.unmodifiableList(list2);
        }
        this.zzc = list3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ActivityTransitionRequest activityTransitionRequest = (ActivityTransitionRequest) obj;
            if (!Objects.equal(this.zza, activityTransitionRequest.zza) || !Objects.equal(this.zzb, activityTransitionRequest.zzb) || !Objects.equal(this.zzc, activityTransitionRequest.zzc)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int hashCode = this.zza.hashCode() * 31;
        String str = this.zzb;
        int i2 = 0;
        if (str != null) {
            i = str.hashCode();
        } else {
            i = 0;
        }
        int i3 = (hashCode + i) * 31;
        List<ClientIdentity> list = this.zzc;
        if (list != null) {
            i2 = list.hashCode();
        }
        return i3 + i2;
    }

    public void serializeToIntentExtra(Intent intent) {
        SafeParcelableSerializer.serializeToIntentExtra(this, intent, "com.google.android.location.internal.EXTRA_ACTIVITY_TRANSITION_REQUEST");
    }

    public String toString() {
        String valueOf = String.valueOf(this.zza);
        String str = this.zzb;
        String valueOf2 = String.valueOf(this.zzc);
        StringBuilder u = ba.u(valueOf2.length() + ba.e(valueOf.length() + 61, str), "ActivityTransitionRequest [mTransitions=", valueOf, ", mTag='", str);
        u.append("', mClients=");
        u.append(valueOf2);
        u.append(']');
        return u.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeTypedList(parcel, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public ActivityTransitionRequest(List<ActivityTransition> list) {
        this(list, (String) null, (List<ClientIdentity>) null);
    }
}
