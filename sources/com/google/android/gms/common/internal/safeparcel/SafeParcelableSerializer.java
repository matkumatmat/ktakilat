package com.google.android.gms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.internal.common.zzak;
import java.util.ArrayList;

@KeepForSdk
public final class SafeParcelableSerializer {
    private SafeParcelableSerializer() {
    }

    @NonNull
    @KeepForSdk
    public static <T extends SafeParcelable> T deserializeFromBytes(@NonNull byte[] bArr, @NonNull Parcelable.Creator<T> creator) {
        Preconditions.checkNotNull(creator);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        T t = (SafeParcelable) creator.createFromParcel(obtain);
        obtain.recycle();
        return t;
    }

    @KeepForSdk
    @Nullable
    public static <T extends SafeParcelable> T deserializeFromIntentExtra(@NonNull Intent intent, @NonNull String str, @NonNull Parcelable.Creator<T> creator) {
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        if (byteArrayExtra == null) {
            return null;
        }
        return deserializeFromBytes(byteArrayExtra, creator);
    }

    @NonNull
    @KeepForSdk
    public static <T extends SafeParcelable> T deserializeFromString(@NonNull String str, @NonNull Parcelable.Creator<T> creator) {
        return deserializeFromBytes(Base64Utils.decodeUrlSafe(str), creator);
    }

    @Deprecated
    @Nullable
    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromBundle(@NonNull Bundle bundle, @NonNull String str, @NonNull Parcelable.Creator<T> creator) {
        ArrayList arrayList = (ArrayList) bundle.getSerializable(str);
        if (arrayList == null) {
            return null;
        }
        ArrayList<T> arrayList2 = new ArrayList<>(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add(deserializeFromBytes((byte[]) arrayList.get(i), creator));
        }
        return arrayList2;
    }

    @KeepForSdk
    @Nullable
    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromBundleSafe(@NonNull Bundle bundle, @NonNull String str, @NonNull Parcelable.Creator<T> creator) {
        return deserializeIterableFromBytes(bundle.getByteArray(str), creator);
    }

    @KeepForSdk
    @Nullable
    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromBytes(@Nullable byte[] bArr, @NonNull Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        try {
            ArrayList<T> arrayList = new ArrayList<>();
            obtain.readTypedList(arrayList, creator);
            return arrayList;
        } finally {
            obtain.recycle();
        }
    }

    @Nullable
    @KeepForSdk
    @Deprecated
    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromIntentExtra(@NonNull Intent intent, @NonNull String str, @NonNull Parcelable.Creator<T> creator) {
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra(str);
        if (arrayList == null) {
            return null;
        }
        ArrayList<T> arrayList2 = new ArrayList<>(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add(deserializeFromBytes((byte[]) arrayList.get(i), creator));
        }
        return arrayList2;
    }

    @KeepForSdk
    @Nullable
    public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromIntentExtraSafe(@NonNull Intent intent, @NonNull String str, @NonNull Parcelable.Creator<T> creator) {
        return deserializeIterableFromBytes(intent.getByteArrayExtra(str), creator);
    }

    @Deprecated
    public static <T extends SafeParcelable> void serializeIterableToBundle(@NonNull Iterable<T> iterable, @NonNull Bundle bundle, @NonNull String str) {
        ArrayList arrayList = new ArrayList();
        for (T serializeToBytes : iterable) {
            arrayList.add(serializeToBytes(serializeToBytes));
        }
        bundle.putSerializable(str, arrayList);
    }

    @KeepForSdk
    public static <T extends SafeParcelable> void serializeIterableToBundleSafe(@NonNull Iterable<T> iterable, @NonNull Bundle bundle, @NonNull String str) {
        bundle.putByteArray(str, serializeIterableToBytes(iterable));
    }

    @NonNull
    @KeepForSdk
    public static <T extends SafeParcelable> byte[] serializeIterableToBytes(@NonNull Iterable<T> iterable) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeTypedList(zzak.zzj(iterable));
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    @KeepForSdk
    @Deprecated
    public static <T extends SafeParcelable> void serializeIterableToIntentExtra(@NonNull Iterable<T> iterable, @NonNull Intent intent, @NonNull String str) {
        ArrayList arrayList = new ArrayList();
        for (T serializeToBytes : iterable) {
            arrayList.add(serializeToBytes(serializeToBytes));
        }
        intent.putExtra(str, arrayList);
    }

    @KeepForSdk
    public static <T extends SafeParcelable> void serializeIterableToIntentExtraSafe(@NonNull Iterable<T> iterable, @NonNull Intent intent, @NonNull String str) {
        intent.putExtra(str, serializeIterableToBytes(iterable));
    }

    @NonNull
    @KeepForSdk
    public static <T extends SafeParcelable> byte[] serializeToBytes(@NonNull T t) {
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    @KeepForSdk
    public static <T extends SafeParcelable> void serializeToIntentExtra(@NonNull T t, @NonNull Intent intent, @NonNull String str) {
        intent.putExtra(str, serializeToBytes(t));
    }

    @NonNull
    @KeepForSdk
    public static <T extends SafeParcelable> String serializeToString(@NonNull T t) {
        return Base64Utils.encodeUrlSafe(serializeToBytes(t));
    }
}
