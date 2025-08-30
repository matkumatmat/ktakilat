package com.O0oOO0ooO.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import org.apache.commons.lang3.CharEncoding;

public interface o0Oo0OO00O0O000ooOO0 extends IInterface {

    /* renamed from: com.O0oOO0ooO.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0  reason: collision with other inner class name */
    public static abstract class C0002o0Oo0OO00O0O000ooOO0 extends Binder implements o0Oo0OO00O0O000ooOO0 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int f166a = 0;

        /* renamed from: com.O0oOO0ooO.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0  reason: collision with other inner class name */
        public static class C0003o0Oo0OO00O0O000ooOO0 implements o0Oo0OO00O0O000ooOO0 {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f167a;

            public static String o0Oo0OO00O0O000ooOO0() {
                try {
                    char[] charArray = "12111f5e400f11031b0614545212170b001b1057571c0e02171b11100a0b0a1902171b567a103c0e02171b31302a2b0a1902171b".toCharArray();
                    byte[] bArr = new byte[52];
                    for (int i = 0; i < 52; i++) {
                        int i2 = i * 2;
                        bArr[i] = (byte) ("0123456789abcdef".indexOf(charArray[i2 + 1]) | ("0123456789abcdef".indexOf(charArray[i2]) << 4));
                    }
                    byte b = (byte) 29;
                    byte b2 = (byte) (bArr[0] ^ 113);
                    bArr[0] = b2;
                    for (int i3 = 1; i3 < 52; i3++) {
                        b2 = (byte) ((b2 ^ bArr[i3]) ^ b);
                        bArr[i3] = b2;
                    }
                    return new String(bArr, CharEncoding.UTF_8);
                } catch (Exception e) {
                    e.printStackTrace();
                    return "";
                }
            }

            public final IBinder asBinder() {
                return this.f167a;
            }

            public final String b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(o0Oo0OO00O0O000ooOO0());
                    if (!this.f167a.transact(1, obtain, obtain2, 0)) {
                        int i = C0002o0Oo0OO00O0O000ooOO0.f166a;
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
            g("48646a2b357a64766e7361212767627e756e652222697b77626e64657f7e7f6c77626e230f65497b77626e44455f5e7f6c77626e", 13);
        }

        /* JADX WARNING: type inference failed for: r0v3, types: [com.O0oOO0ooO.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0, com.O0oOO0ooO.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0, java.lang.Object] */
        public static o0Oo0OO00O0O000ooOO0 a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(g("48373978662937253d2032727434312d263d3671713a2824313d37362c2d2c3f24313d705c361a2824313d17160c0d2c3f24313d", 94));
            if (queryLocalInterface != null && (queryLocalInterface instanceof o0Oo0OO00O0O000ooOO0)) {
                return (o0Oo0OO00O0O000ooOO0) queryLocalInterface;
            }
            ? obj = new Object();
            obj.f167a = iBinder;
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
                byte b = (byte) (i ^ 101);
                byte b2 = (byte) (bArr[0] ^ 43);
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
            String b;
            String g = g("48353b7a642b35273f2230707636332f243f347373382a26333f35342e2f2e3d26333f725e34182a26333f15140e0f2e3d26333f", 92);
            if (i == 1) {
                parcel.enforceInterface(g);
                b = b();
            } else if (i == 2) {
                parcel.enforceInterface(g);
                parcel.readString();
                b = f();
            } else if (i == 3) {
                parcel.enforceInterface(g);
                parcel.readString();
                b = o0O00o00OOoOo0oooOoo00();
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(g);
                return true;
            }
            parcel2.writeNoException();
            parcel2.writeString(b);
            return true;
        }
    }

    String b();

    String f();

    String o0O00o00OOoOo0oooOoo00();
}
