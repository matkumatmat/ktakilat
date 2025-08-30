package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.Arrays;

@SafeParcelable.Class(creator = "PublicKeyCredentialCreator")
public class PublicKeyCredential extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<PublicKeyCredential> CREATOR = new zzal();
    @SafeParcelable.Field(getter = "getId", id = 1)
    @NonNull
    private final String zza;
    @SafeParcelable.Field(getter = "getType", id = 2)
    @NonNull
    private final String zzb;
    @SafeParcelable.Field(getter = "getRawId", id = 3)
    @NonNull
    private final byte[] zzc;
    @SafeParcelable.Field(getter = "getRegisterResponse", id = 4)
    @Nullable
    private final AuthenticatorAttestationResponse zzd;
    @SafeParcelable.Field(getter = "getSignResponse", id = 5)
    @Nullable
    private final AuthenticatorAssertionResponse zze;
    @SafeParcelable.Field(getter = "getErrorResponse", id = 6)
    @Nullable
    private final AuthenticatorErrorResponse zzf;
    @SafeParcelable.Field(getter = "getClientExtensionResults", id = 7)
    @Nullable
    private final AuthenticationExtensionsClientOutputs zzg;
    @SafeParcelable.Field(getter = "getAuthenticatorAttachment", id = 8)
    @Nullable
    private final String zzh;

    public static class Builder {
        private String zza;
        private byte[] zzb;
        private AuthenticatorResponse zzc;
        private AuthenticationExtensionsClientOutputs zzd;
        private String zze;

        @NonNull
        public PublicKeyCredential build() {
            AuthenticatorAttestationResponse authenticatorAttestationResponse;
            AuthenticatorAssertionResponse authenticatorAssertionResponse;
            AuthenticatorResponse authenticatorResponse = this.zzc;
            AuthenticatorErrorResponse authenticatorErrorResponse = null;
            if (authenticatorResponse instanceof AuthenticatorAttestationResponse) {
                authenticatorAttestationResponse = (AuthenticatorAttestationResponse) authenticatorResponse;
            } else {
                authenticatorAttestationResponse = null;
            }
            if (authenticatorResponse instanceof AuthenticatorAssertionResponse) {
                authenticatorAssertionResponse = (AuthenticatorAssertionResponse) authenticatorResponse;
            } else {
                authenticatorAssertionResponse = null;
            }
            if (authenticatorResponse instanceof AuthenticatorErrorResponse) {
                authenticatorErrorResponse = (AuthenticatorErrorResponse) authenticatorResponse;
            }
            return new PublicKeyCredential(this.zza, PublicKeyCredentialType.PUBLIC_KEY.toString(), this.zzb, authenticatorAttestationResponse, authenticatorAssertionResponse, authenticatorErrorResponse, this.zzd, this.zze);
        }

        @NonNull
        public Builder setAuthenticationExtensionsClientOutputs(@Nullable AuthenticationExtensionsClientOutputs authenticationExtensionsClientOutputs) {
            this.zzd = authenticationExtensionsClientOutputs;
            return this;
        }

        @NonNull
        public Builder setAuthenticatorAttachment(@NonNull String str) {
            this.zze = str;
            return this;
        }

        @NonNull
        public Builder setId(@NonNull String str) {
            this.zza = str;
            return this;
        }

        @NonNull
        public Builder setRawId(@NonNull byte[] bArr) {
            this.zzb = bArr;
            return this;
        }

        @NonNull
        public Builder setResponse(@NonNull AuthenticatorResponse authenticatorResponse) {
            this.zzc = authenticatorResponse;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public PublicKeyCredential(@SafeParcelable.Param(id = 1) @NonNull String str, @SafeParcelable.Param(id = 2) @NonNull String str2, @SafeParcelable.Param(id = 3) @NonNull byte[] bArr, @SafeParcelable.Param(id = 4) @Nullable AuthenticatorAttestationResponse authenticatorAttestationResponse, @SafeParcelable.Param(id = 5) @Nullable AuthenticatorAssertionResponse authenticatorAssertionResponse, @SafeParcelable.Param(id = 6) @Nullable AuthenticatorErrorResponse authenticatorErrorResponse, @SafeParcelable.Param(id = 7) @Nullable AuthenticationExtensionsClientOutputs authenticationExtensionsClientOutputs, @SafeParcelable.Param(id = 8) @Nullable String str3) {
        boolean z = true;
        if (!((authenticatorAttestationResponse != null && authenticatorAssertionResponse == null && authenticatorErrorResponse == null) || ((authenticatorAttestationResponse == null && authenticatorAssertionResponse != null && authenticatorErrorResponse == null) || (authenticatorAttestationResponse == null && authenticatorAssertionResponse == null && authenticatorErrorResponse != null)))) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.zza = str;
        this.zzb = str2;
        this.zzc = bArr;
        this.zzd = authenticatorAttestationResponse;
        this.zze = authenticatorAssertionResponse;
        this.zzf = authenticatorErrorResponse;
        this.zzg = authenticationExtensionsClientOutputs;
        this.zzh = str3;
    }

    @NonNull
    public static PublicKeyCredential deserializeFromBytes(@NonNull byte[] bArr) {
        return (PublicKeyCredential) SafeParcelableSerializer.deserializeFromBytes(bArr, CREATOR);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof PublicKeyCredential)) {
            return false;
        }
        PublicKeyCredential publicKeyCredential = (PublicKeyCredential) obj;
        if (!Objects.equal(this.zza, publicKeyCredential.zza) || !Objects.equal(this.zzb, publicKeyCredential.zzb) || !Arrays.equals(this.zzc, publicKeyCredential.zzc) || !Objects.equal(this.zzd, publicKeyCredential.zzd) || !Objects.equal(this.zze, publicKeyCredential.zze) || !Objects.equal(this.zzf, publicKeyCredential.zzf) || !Objects.equal(this.zzg, publicKeyCredential.zzg) || !Objects.equal(this.zzh, publicKeyCredential.zzh)) {
            return false;
        }
        return true;
    }

    @Nullable
    public String getAuthenticatorAttachment() {
        return this.zzh;
    }

    @Nullable
    public AuthenticationExtensionsClientOutputs getClientExtensionResults() {
        return this.zzg;
    }

    @NonNull
    public String getId() {
        return this.zza;
    }

    @NonNull
    public byte[] getRawId() {
        return this.zzc;
    }

    @NonNull
    public AuthenticatorResponse getResponse() {
        AuthenticatorAttestationResponse authenticatorAttestationResponse = this.zzd;
        if (authenticatorAttestationResponse != null) {
            return authenticatorAttestationResponse;
        }
        AuthenticatorAssertionResponse authenticatorAssertionResponse = this.zze;
        if (authenticatorAssertionResponse != null) {
            return authenticatorAssertionResponse;
        }
        AuthenticatorErrorResponse authenticatorErrorResponse = this.zzf;
        if (authenticatorErrorResponse != null) {
            return authenticatorErrorResponse;
        }
        throw new IllegalStateException("No response set.");
    }

    @NonNull
    public String getType() {
        return this.zzb;
    }

    public int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zze, this.zzd, this.zzf, this.zzg, this.zzh);
    }

    @NonNull
    public byte[] serializeToBytes() {
        return SafeParcelableSerializer.serializeToBytes(this);
    }

    public void writeToParcel(@NonNull Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getId(), false);
        SafeParcelWriter.writeString(parcel, 2, getType(), false);
        SafeParcelWriter.writeByteArray(parcel, 3, getRawId(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, getClientExtensionResults(), i, false);
        SafeParcelWriter.writeString(parcel, 8, getAuthenticatorAttachment(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
