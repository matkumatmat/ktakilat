package com.tencent.mmkv;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import java.io.IOException;

public final class ParcelableMMKV implements Parcelable {
    public static final Parcelable.Creator<ParcelableMMKV> CREATOR = new Object();
    public final String c;
    public final int d;
    public final int e;
    public final String f;

    /* renamed from: com.tencent.mmkv.ParcelableMMKV$1  reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<ParcelableMMKV> {
        public final Object createFromParcel(Parcel parcel) {
            String readString = parcel.readString();
            Parcelable.Creator creator = ParcelFileDescriptor.CREATOR;
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) creator.createFromParcel(parcel);
            ParcelFileDescriptor parcelFileDescriptor2 = (ParcelFileDescriptor) creator.createFromParcel(parcel);
            String readString2 = parcel.readString();
            if (parcelFileDescriptor == null || parcelFileDescriptor2 == null) {
                return null;
            }
            return new ParcelableMMKV(readString, parcelFileDescriptor.detachFd(), parcelFileDescriptor2.detachFd(), readString2);
        }

        public final Object[] newArray(int i) {
            return new ParcelableMMKV[i];
        }
    }

    public ParcelableMMKV(MMKV mmkv) {
        this.d = -1;
        this.e = -1;
        this.f = null;
        this.c = mmkv.mmapID();
        this.d = mmkv.ashmemFD();
        this.e = mmkv.ashmemMetaFD();
        this.f = mmkv.cryptKey();
    }

    public final int describeContents() {
        return 1;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        try {
            parcel.writeString(this.c);
            ParcelFileDescriptor fromFd = ParcelFileDescriptor.fromFd(this.d);
            ParcelFileDescriptor fromFd2 = ParcelFileDescriptor.fromFd(this.e);
            int i2 = i | 1;
            fromFd.writeToParcel(parcel, i2);
            fromFd2.writeToParcel(parcel, i2);
            String str = this.f;
            if (str != null) {
                parcel.writeString(str);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public ParcelableMMKV(String str, int i, int i2, String str2) {
        this.c = str;
        this.d = i;
        this.e = i2;
        this.f = str2;
    }
}
