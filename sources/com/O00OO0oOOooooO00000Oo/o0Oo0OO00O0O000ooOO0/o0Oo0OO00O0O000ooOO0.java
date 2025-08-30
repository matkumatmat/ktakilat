package com.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.common.base.Ascii;
import org.apache.commons.lang3.CharEncoding;

public interface o0Oo0OO00O0O000ooOO0 extends IInterface {

    /* renamed from: com.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0  reason: collision with other inner class name */
    public static abstract class C0000o0Oo0OO00O0O000ooOO0 extends Binder implements o0Oo0OO00O0O000ooOO0 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int f164a = 0;

        /* renamed from: com.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0  reason: collision with other inner class name */
        public static class C0001o0Oo0OO00O0O000ooOO0 implements o0Oo0OO00O0O000ooOO0 {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f165a;

            public static String o0Oo0OO00O0O000ooOO0() {
                try {
                    char[] charArray = "43101e5f51101c1f000d1956561d0f03161a10110b1a191c03011a467b113d0f03161a3031353013131a1e0b".toCharArray();
                    byte[] bArr = new byte[44];
                    for (int i = 0; i < 44; i++) {
                        int i2 = i * 2;
                        bArr[i] = (byte) ("0123456789abcdef".indexOf(charArray[i2 + 1]) | ("0123456789abcdef".indexOf(charArray[i2]) << 4));
                    }
                    byte b = (byte) 28;
                    byte b2 = (byte) (bArr[0] ^ 32);
                    bArr[0] = b2;
                    for (int i3 = 1; i3 < 44; i3++) {
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
                return this.f165a;
            }

            public final String o0O00o00OOoOo0oooOoo00(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(o0Oo0OO00O0O000ooOO0());
                    obtain.writeString(str);
                    if (!this.f165a.transact(2, obtain, obtain2, 0)) {
                        int i = C0000o0Oo0OO00O0O000ooOO0.f164a;
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
            g("7a727c3d33727e7d626f7b34347f6d617478727369787b7e6163782419735f6d617478525357527171787c69", 114);
        }

        /* JADX WARNING: type inference failed for: r0v3, types: [com.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0, com.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0, java.lang.Object] */
        public static o0Oo0OO00O0O000ooOO0 a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(g("7a6b65242a6b67647b76622d2d6674786d616b6a70616267787a613d006a4674786d614b4a4e4b6868616570", 107));
            if (queryLocalInterface != null && (queryLocalInterface instanceof o0Oo0OO00O0O000ooOO0)) {
                return (o0Oo0OO00O0O000ooOO0) queryLocalInterface;
            }
            ? obj = new Object();
            obj.f165a = iBinder;
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
                byte b = (byte) (i ^ 12);
                byte b2 = (byte) (bArr[0] ^ Ascii.EM);
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
            String g = g("7a7b75343a7b77746b66723d3d7664687d717b7a60717277686a712d107a5664687d715b5a5e5b7878717560", 123);
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface(g);
                        parcel.readString();
                        b = b();
                        break;
                    case 2:
                        parcel.enforceInterface(g);
                        b = o0O00o00OOoOo0oooOoo00(parcel.readString());
                        break;
                    case 3:
                        parcel.enforceInterface(g);
                        parcel.readString();
                        b = oO00o0OooO0OO0o0000o();
                        break;
                    case 4:
                        parcel.enforceInterface(g);
                        parcel.readString();
                        b = c();
                        break;
                    case 5:
                        parcel.enforceInterface(g);
                        boolean o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0();
                        parcel2.writeNoException();
                        parcel2.writeInt(o0Oo0OO00O0O000ooOO0 ? 1 : 0);
                        return true;
                    case 6:
                        parcel.enforceInterface(g);
                        b = o0O00o00OOoOo0oooOoo00();
                        break;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeNoException();
                parcel2.writeString(b);
                return true;
            }
            parcel2.writeString(g);
            return true;
        }
    }

    String b();

    String c();

    String o0O00o00OOoOo0oooOoo00();

    String o0O00o00OOoOo0oooOoo00(String str);

    boolean o0Oo0OO00O0O000ooOO0();

    String oO00o0OooO0OO0o0000o();
}
