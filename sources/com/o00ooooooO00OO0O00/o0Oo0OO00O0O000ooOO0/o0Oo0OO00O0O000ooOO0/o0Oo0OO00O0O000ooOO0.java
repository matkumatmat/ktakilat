package com.o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import org.apache.commons.lang3.CharEncoding;

public interface o0Oo0OO00O0O000ooOO0 extends IInterface {

    /* renamed from: com.o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0  reason: collision with other inner class name */
    public static abstract class C0006o0Oo0OO00O0O000ooOO0 extends Binder implements o0Oo0OO00O0O000ooOO0 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int f620a = 0;

        /* renamed from: com.o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0  reason: collision with other inner class name */
        public static class C0007o0Oo0OO00O0O000ooOO0 implements o0Oo0OO00O0O000ooOO0 {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f621a;

            public static String o0Oo0OO00O0O000ooOO0() {
                try {
                    char[] charArray = "326769283071606671362a747e60616a7874616d2024636663290a547e60414a7874616d47466a6071766464677c4a5d7c6f74616d".toCharArray();
                    byte[] bArr = new byte[53];
                    for (int i = 0; i < 53; i++) {
                        int i2 = i * 2;
                        bArr[i] = (byte) ("0123456789abcdef".indexOf(charArray[i2 + 1]) | ("0123456789abcdef".indexOf(charArray[i2]) << 4));
                    }
                    byte b = (byte) 107;
                    byte b2 = (byte) (bArr[0] ^ 81);
                    bArr[0] = b2;
                    for (int i3 = 1; i3 < 53; i3++) {
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
                return this.f621a;
            }

            public final String b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(o0Oo0OO00O0O000ooOO0());
                    if (!this.f621a.transact(1, obtain, obtain2, 0)) {
                        int i = C0006o0Oo0OO00O0O000ooOO0.f620a;
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
            g("57757b3a22637274632438666c7273786a66737f32367174713b18466c7253586a66737f5554787263647676756e584f6e7d66737f", 81);
        }

        /* JADX WARNING: type inference failed for: r0v3, types: [com.o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0, java.lang.Object, com.o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0] */
        public static o0Oo0OO00O0O000ooOO0 a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(g("573c32736b2a3b3d2a6d712f253b3a31232f3a367b7f383d3872510f253b1a11232f3a361c1d313b2a2d3f3f3c27110627342f3a36", 24));
            if (queryLocalInterface != null && (queryLocalInterface instanceof o0Oo0OO00O0O000ooOO0)) {
                return (o0Oo0OO00O0O000ooOO0) queryLocalInterface;
            }
            ? obj = new Object();
            obj.f621a = iBinder;
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
                byte b = (byte) (i ^ 40);
                byte b2 = (byte) (bArr[0] ^ 52);
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
            String g = g("573a34756d2c3d3b2c6b7729233d3c3725293c307d793e3b3e745709233d1c1725293c301a1b373d2c2b39393a2117002132293c30", 30);
            if (i == 1) {
                parcel.enforceInterface(g);
                String b = b();
                parcel2.writeNoException();
                parcel2.writeString(b);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(g);
                boolean o0O00o00OOoOo0oooOoo00 = o0O00o00OOoOo0oooOoo00();
                parcel2.writeNoException();
                parcel2.writeInt(o0O00o00OOoOo0oooOoo00 ? 1 : 0);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(g);
                return true;
            }
        }
    }

    String b();

    boolean o0O00o00OOoOo0oooOoo00();
}
