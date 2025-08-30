package com.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.common.base.Ascii;
import org.apache.commons.lang3.CharEncoding;

public interface o0Oo0OO00O0O000ooOO0 extends IInterface {

    /* renamed from: com.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0  reason: collision with other inner class name */
    public static abstract class C0010o0Oo0OO00O0O000ooOO0 extends Binder implements o0Oo0OO00O0O000ooOO0 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int f624a = 0;

        /* renamed from: com.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0  reason: collision with other inner class name */
        public static class C0011o0Oo0OO00O0O000ooOO0 implements o0Oo0OO00O0O000ooOO0 {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f625a;

            public static String a(String str, int i) {
                try {
                    int length = str.length() / 2;
                    char[] charArray = str.toCharArray();
                    byte[] bArr = new byte[length];
                    for (int i2 = 0; i2 < length; i2++) {
                        int i3 = i2 * 2;
                        bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
                    }
                    byte b = (byte) (i ^ 54);
                    byte b2 = (byte) (bArr[0] ^ Ascii.DC4);
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
                return this.f625a;
            }

            public final String o0O00o00OOoOo0oooOoo00() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a("776e60212d6d68747f646f282f73756677797f3e054f75424467627e676e75", 84));
                    if (!this.f625a.transact(3, obtain, obtain2, 0)) {
                        int i = C0010o0Oo0OO00O0O000ooOO0.f624a;
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean o0Oo0OO00O0O000ooOO0() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a("77444a0b0747425e554e450205595f4c5d5355142f655f686e4d48544d445f", 126));
                    boolean z = false;
                    if (!this.f625a.transact(1, obtain, obtain2, 0)) {
                        int i = C0010o0Oo0OO00O0O000ooOO0.f624a;
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
        }

        static {
            g("656967262a6a6f737863682f28747261707e78390248724543606579606972", 25);
        }

        /* JADX WARNING: type inference failed for: r0v3, types: [com.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0, com.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0, java.lang.Object] */
        public static o0Oo0OO00O0O000ooOO0 a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(g("65050b4a4606031f140f044344181e0d1c1214556e241e292f0c09150c051e", 117));
            if (queryLocalInterface != null && (queryLocalInterface instanceof o0Oo0OO00O0O000ooOO0)) {
                return (o0Oo0OO00O0O000ooOO0) queryLocalInterface;
            }
            ? obj = new Object();
            obj.f625a = iBinder;
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
                byte b = (byte) (i ^ 124);
                byte b2 = (byte) (bArr[0] ^ 6);
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
            String o0Oo0OO00O0O000ooOO0;
            String g = g("655856171b5b5e424952591e19454350414f49083379437472515448515843", 40);
            if (i != 1) {
                if (i == 2) {
                    parcel.enforceInterface(g);
                    parcel.readString();
                    o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0();
                } else if (i == 3) {
                    parcel.enforceInterface(g);
                    o0Oo0OO00O0O000ooOO0 = o0O00o00OOoOo0oooOoo00();
                } else if (i == 4) {
                    parcel.enforceInterface(g);
                    o0Oo0OO00O0O000ooOO0 = oO00o0OooO0OO0o0000o();
                } else if (i == 5) {
                    parcel.enforceInterface(g);
                    parcel.readString();
                    o0Oo0OO00O0O000ooOO0 = d();
                } else if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    parcel2.writeString(g);
                    return true;
                }
                parcel2.writeNoException();
                parcel2.writeString(o0Oo0OO00O0O000ooOO0);
                return true;
            }
            parcel.enforceInterface(g);
            boolean o0Oo0OO00O0O000ooOO02 = o0Oo0OO00O0O000ooOO0();
            parcel2.writeNoException();
            parcel2.writeInt(o0Oo0OO00O0O000ooOO02 ? 1 : 0);
            return true;
        }
    }

    String d();

    String o0O00o00OOoOo0oooOoo00();

    String o0Oo0OO00O0O000ooOO0();

    /* renamed from: o0Oo0OO00O0O000ooOO0  reason: collision with other method in class */
    boolean m14o0Oo0OO00O0O000ooOO0();

    String oO00o0OooO0OO0o0000o();
}
