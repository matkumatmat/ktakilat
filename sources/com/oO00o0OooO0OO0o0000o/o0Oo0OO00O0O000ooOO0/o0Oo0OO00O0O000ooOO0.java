package com.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import org.apache.commons.lang3.CharEncoding;

public interface o0Oo0OO00O0O000ooOO0 extends IInterface {

    /* renamed from: com.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0  reason: collision with other inner class name */
    public static abstract class C0012o0Oo0OO00O0O000ooOO0 extends Binder implements o0Oo0OO00O0O000ooOO0 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int f626a = 0;

        /* renamed from: com.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0  reason: collision with other inner class name */
        public static class C0013o0Oo0OO00O0O000ooOO0 implements o0Oo0OO00O0O000ooOO0 {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f627a;

            public static String a(String str, int i) {
                try {
                    int length = str.length() / 2;
                    char[] charArray = str.toCharArray();
                    byte[] bArr = new byte[length];
                    for (int i2 = 0; i2 < length; i2++) {
                        int i3 = i2 * 2;
                        bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
                    }
                    byte b = (byte) (i ^ 12);
                    byte b2 = (byte) (bArr[0] ^ 38);
                    bArr[0] = b2;
                    for (int i4 = 1; i4 < length; i4++) {
                        b2 = (byte) ((b2 ^ bArr[i4]) ^ b);
                        bArr[i4] = b2;
                    }
                    return new String(bArr, CharEncoding.UTF_8);
                } catch (Exception e) {
                    e.printStackTrace();
                    return "";
                }
            }

            public final IBinder asBinder() {
                return this.f627a;
            }

            public final boolean o0Oo0OO00O0O000ooOO0() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a("451b15545b000c5755121c5b7429053f3a3a300d060003101511", 27));
                    boolean z = false;
                    if (!this.f627a.transact(1, obtain, obtain2, 0)) {
                        int i = C0012o0Oo0OO00O0O000ooOO0.f626a;
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final String oO00o0OooO0OO0o0000o() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a("45727c3d3269653e3c7b75321d406c56535359646f696a797c78", 114));
                    if (!this.f627a.transact(3, obtain, obtain2, 0)) {
                        int i = C0012o0Oo0OO00O0O000ooOO0.f626a;
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        static {
            g("4b030d4c4318144f4d0a04436c311d27222228151e181b080d09", 97);
        }

        /* JADX WARNING: type inference failed for: r0v3, types: [com.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0, java.lang.Object, com.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0] */
        public static o0Oo0OO00O0O000ooOO0 a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(g("4b0a04454a111d4644030d4a6538142e2b2b211c171112010400", 104));
            if (queryLocalInterface != null && (queryLocalInterface instanceof o0Oo0OO00O0O000ooOO0)) {
                return (o0Oo0OO00O0O000ooOO0) queryLocalInterface;
            }
            ? obj = new Object();
            obj.f627a = iBinder;
            return obj;
        }

        public static String g(String str, int i) {
            try {
                int length = str.length() / 2;
                char[] charArray = str.toCharArray();
                byte[] bArr = new byte[length];
                for (int i2 = 0; i2 < length; i2++) {
                    int i3 = i2 * 2;
                    bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
                }
                byte b = (byte) (i ^ 110);
                byte b2 = (byte) (bArr[0] ^ 40);
                bArr[0] = b2;
                for (int i4 = 1; i4 < length; i4++) {
                    b2 = (byte) ((b2 ^ bArr[i4]) ^ b);
                    bArr[i4] = b2;
                }
                return new String(bArr, CharEncoding.UTF_8);
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }

        public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            String g = g("4b656b2a257e72292b6c62250a577b4144444e73787e7d6e6b6f", 7);
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface(g);
                        boolean o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0();
                        parcel2.writeNoException();
                        parcel2.writeInt(o0Oo0OO00O0O000ooOO0 ? 1 : 0);
                        return true;
                    case 2:
                        parcel.enforceInterface(g);
                        boolean o0O00o00OOoOo0oooOoo00 = o0O00o00OOoOo0oooOoo00();
                        parcel2.writeNoException();
                        parcel2.writeInt(o0O00o00OOoOo0oooOoo00 ? 1 : 0);
                        return true;
                    case 3:
                        parcel.enforceInterface(g);
                        String oO00o0OooO0OO0o0000o = oO00o0OooO0OO0o0000o();
                        parcel2.writeNoException();
                        parcel2.writeString(oO00o0OooO0OO0o0000o);
                        return true;
                    case 4:
                        parcel.enforceInterface(g);
                        String c = c();
                        parcel2.writeNoException();
                        parcel2.writeString(c);
                        return true;
                    case 5:
                        parcel.enforceInterface(g);
                        String e = e();
                        parcel2.writeNoException();
                        parcel2.writeString(e);
                        return true;
                    case 6:
                        parcel.enforceInterface(g);
                        o00ooooooO00OO0O00();
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString(g);
                return true;
            }
        }
    }

    String c();

    String e();

    void o00ooooooO00OO0O00();

    boolean o0O00o00OOoOo0oooOoo00();

    boolean o0Oo0OO00O0O000ooOO0();

    String oO00o0OooO0OO0o0000o();
}
