package com.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import org.apache.commons.lang3.CharEncoding;

public interface o0Oo0OO00O0O000ooOO0 extends IInterface {

    /* renamed from: com.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0  reason: collision with other inner class name */
    public static abstract class C0008o0Oo0OO00O0O000ooOO0 extends Binder implements o0Oo0OO00O0O000ooOO0 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int f622a = 0;

        /* renamed from: com.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0  reason: collision with other inner class name */
        public static class C0009o0Oo0OO00O0O000ooOO0 implements o0Oo0OO00O0O000ooOO0 {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f623a;

            public static String a(String str, int i) {
                try {
                    int length = str.length() / 2;
                    char[] charArray = str.toCharArray();
                    byte[] bArr = new byte[length];
                    for (int i2 = 0; i2 < length; i2++) {
                        int i3 = i2 * 2;
                        bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
                    }
                    byte b = (byte) (i ^ 92);
                    byte b2 = (byte) (bArr[0] ^ 36);
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
                return this.f623a;
            }

            public final boolean o0Oo0OO00O0O000ooOO0() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a("470d03424e1307075c421f134e7c2704011d0809090a1b14120a3c0c0c6b660c2c0c24290c0924261b101615060307", 93));
                    boolean z = false;
                    if (!this.f623a.transact(1, obtain, obtain2, 0)) {
                        int i = C0008o0Oo0OO00O0O000ooOO0.f622a;
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
                    obtain.writeInterfaceToken(a("4757591814495d5d0618454914267d5e5b4752535350414e4850665656313c5676567e7356537e7c414a4c4f5c595d", 7));
                    if (!this.f623a.transact(3, obtain, obtain2, 0)) {
                        int i = C0008o0Oo0OO00O0O000ooOO0.f622a;
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
            g("4b4d43020e5347471c025f530e3c6744415d4849494a5b54524a7c4c4c2b264c6c4c64694c4964665b505655464347", 55);
        }

        /* JADX WARNING: type inference failed for: r0v3, types: [java.lang.Object, com.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0, com.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0] */
        public static o0Oo0OO00O0O000ooOO0 a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(g("4b717f3e326f7b7b203e636f32005b787d617475757667686e76407070171a70507058557075585a676c6a697a7f7b", 11));
            if (queryLocalInterface != null && (queryLocalInterface instanceof o0Oo0OO00O0O000ooOO0)) {
                return (o0Oo0OO00O0O000ooOO0) queryLocalInterface;
            }
            ? obj = new Object();
            obj.f623a = iBinder;
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
                byte b = (byte) (i ^ 118);
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
            String o0O00o00OOoOo0oooOoo00;
            String g = g("4b6b6524287561613a247975281a4162677b6e6f6f6c7d72746c5a6a6a0d006a4a6a424f6a6f42407d767073606561", 17);
            if (i != 1) {
                if (i == 2) {
                    parcel.enforceInterface(g);
                    o0O00o00OOoOo0oooOoo00 = o0O00o00OOoOo0oooOoo00();
                } else if (i == 3) {
                    parcel.enforceInterface(g);
                    o0O00o00OOoOo0oooOoo00 = oO00o0OooO0OO0o0000o();
                } else if (i == 4) {
                    parcel.enforceInterface(g);
                    o0O00o00OOoOo0oooOoo00 = c();
                } else if (i == 5) {
                    parcel.enforceInterface(g);
                    o0O00o00OOoOo0oooOoo00 = e();
                } else if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    parcel2.writeString(g);
                    return true;
                }
                parcel2.writeNoException();
                parcel2.writeString(o0O00o00OOoOo0oooOoo00);
                return true;
            }
            parcel.enforceInterface(g);
            boolean o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0();
            parcel2.writeNoException();
            parcel2.writeInt(o0Oo0OO00O0O000ooOO0 ? 1 : 0);
            return true;
        }
    }

    String c();

    String e();

    String o0O00o00OOoOo0oooOoo00();

    boolean o0Oo0OO00O0O000ooOO0();

    String oO00o0OooO0OO0o0000o();
}
