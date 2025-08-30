package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "FeatureStyleCreator")
public final class FeatureStyle extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<FeatureStyle> CREATOR = new zzi();
    @SafeParcelable.Field(getter = "getFillColor", id = 1)
    @Nullable
    private final Integer zza;
    @SafeParcelable.Field(getter = "getStrokeColor", id = 2)
    @Nullable
    private final Integer zzb;
    @SafeParcelable.Field(getter = "getStrokeWidth", id = 3)
    @Nullable
    private final Float zzc;
    @SafeParcelable.Field(getter = "getPointRadius", id = 4)
    @Nullable
    private final Float zzd;

    public static final class Builder {
        /* access modifiers changed from: private */
        public Integer zza;
        /* access modifiers changed from: private */
        public Integer zzb;
        /* access modifiers changed from: private */
        public Float zzc;
        /* access modifiers changed from: private */
        public Float zzd;

        @NonNull
        public FeatureStyle build() {
            return new FeatureStyle(this, (zzh) null);
        }

        @NonNull
        public Builder fillColor(int i) {
            this.zza = Integer.valueOf(i);
            return this;
        }

        @NonNull
        public Builder pointRadius(float f) {
            boolean z;
            boolean z2 = false;
            if (f >= 0.0f) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "Point radius cannot be negative.");
            if (f <= 128.0f) {
                z2 = true;
            }
            Preconditions.checkArgument(z2, "The max allowed pointRadius value is 128px.");
            this.zzd = Float.valueOf(f);
            return this;
        }

        @NonNull
        public Builder strokeColor(int i) {
            this.zzb = Integer.valueOf(i);
            return this;
        }

        @NonNull
        public Builder strokeWidth(float f) {
            boolean z;
            if (f >= 0.0f) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "Stroke width cannot be negative.");
            this.zzc = Float.valueOf(f);
            return this;
        }
    }

    public /* synthetic */ FeatureStyle(Builder builder, zzh zzh) {
        this.zza = builder.zza;
        this.zzb = builder.zzb;
        this.zzc = builder.zzc;
        this.zzd = builder.zzd;
    }

    @NonNull
    public static Builder builder() {
        return new Builder();
    }

    @Nullable
    public Integer getFillColor() {
        return this.zza;
    }

    @Nullable
    public Float getPointRadius() {
        return this.zzd;
    }

    @Nullable
    public Integer getStrokeColor() {
        return this.zzb;
    }

    @Nullable
    public Float getStrokeWidth() {
        return this.zzc;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIntegerObject(parcel, 1, getFillColor(), false);
        SafeParcelWriter.writeIntegerObject(parcel, 2, getStrokeColor(), false);
        SafeParcelWriter.writeFloatObject(parcel, 3, getStrokeWidth(), false);
        SafeParcelWriter.writeFloatObject(parcel, 4, getPointRadius(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public FeatureStyle(@SafeParcelable.Param(id = 1) @Nullable Integer num, @SafeParcelable.Param(id = 2) @Nullable Integer num2, @SafeParcelable.Param(id = 3) @Nullable Float f, @SafeParcelable.Param(id = 4) @Nullable Float f2) {
        this.zza = num;
        this.zzb = num2;
        this.zzc = f;
        this.zzd = f2;
    }
}
