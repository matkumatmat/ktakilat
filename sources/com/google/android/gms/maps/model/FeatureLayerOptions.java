package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.maps.zzbm;

@SafeParcelable.Class(creator = "FeatureLayerOptionsCreator")
public final class FeatureLayerOptions extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<FeatureLayerOptions> CREATOR = new zzg();
    /* access modifiers changed from: private */
    public static final zzbm zza = zzbm.zzi(FeatureType.ADMINISTRATIVE_AREA_LEVEL_1, FeatureType.ADMINISTRATIVE_AREA_LEVEL_2, FeatureType.COUNTRY, FeatureType.LOCALITY, FeatureType.POSTAL_CODE, FeatureType.SCHOOL_DISTRICT, FeatureType.DATASET);
    @SafeParcelable.Field(getter = "getFeatureType", id = 1)
    @FeatureType
    private final String zzb;
    @SafeParcelable.Field(getter = "getDatasetId", id = 2)
    private final String zzc;

    public static final class Builder {
        /* access modifiers changed from: private */
        public String zza;
        /* access modifiers changed from: private */
        public String zzb;

        @NonNull
        public FeatureLayerOptions build() {
            String str = this.zza;
            if (str == null) {
                throw new IllegalArgumentException("FeatureType must be specified.");
            } else if (!str.equals(FeatureType.DATASET) || this.zzb != null) {
                return new FeatureLayerOptions(this, (zzf) null);
            } else {
                throw new IllegalArgumentException("A datasetId must be specified for DATASET feature layers.");
            }
        }

        @NonNull
        public Builder datasetId(@NonNull String str) {
            this.zzb = str;
            return this;
        }

        @NonNull
        public Builder featureType(@NonNull @FeatureType String str) {
            Preconditions.checkArgument(FeatureLayerOptions.zza.contains(str), "Invalid FeatureType value");
            this.zza = str;
            return this;
        }
    }

    public /* synthetic */ FeatureLayerOptions(Builder builder, zzf zzf) {
        this.zzb = builder.zza;
        this.zzc = builder.zzb;
    }

    @NonNull
    public static Builder builder() {
        return new Builder();
    }

    @NonNull
    public String getDatasetId() {
        return this.zzc;
    }

    @NonNull
    @FeatureType
    public String getFeatureType() {
        return this.zzb;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getFeatureType(), false);
        SafeParcelWriter.writeString(parcel, 2, getDatasetId(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public FeatureLayerOptions(@SafeParcelable.Param(id = 1) @FeatureType String str, @SafeParcelable.Param(id = 2) String str2) {
        this.zzb = str;
        this.zzc = str2;
    }
}
