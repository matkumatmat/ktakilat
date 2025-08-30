package com.OO0000O0Ooo0OO000oo.o0Oo0OO00O0O000ooOO0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.common.base.Ascii;
import org.apache.commons.lang3.CharEncoding;

public interface o0Oo0OO00O0O000ooOO0 extends IInterface {

    /* renamed from: com.OO0000O0Ooo0OO000oo.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0  reason: collision with other inner class name */
    public static abstract class C0004o0Oo0OO00O0O000ooOO0 extends Binder implements o0Oo0OO00O0O000ooOO0 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int f168a = 0;

        /* renamed from: com.OO0000O0Ooo0OO000oo.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0  reason: collision with other inner class name */
        public static class C0005o0Oo0OO00O0O000ooOO0 implements o0Oo0OO00O0O000ooOO0 {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f169a;

            public static String a(String str, int i) {
                try {
                    int length = str.length() / 2;
                    char[] charArray = str.toCharArray();
                    byte[] bArr = new byte[length];
                    for (int i2 = 0; i2 < length; i2++) {
                        int i3 = i2 * 2;
                        bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
                    }
                    byte b = (byte) (i ^ 5);
                    byte b2 = (byte) (bArr[0] ^ 3);
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
                return this.f169a;
            }

            public final String o0Oo0OO00O0O000ooOO0() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a("600f0140570c1f444902101c09050f0e141514071c090548640e22101c09050f0e2e2419121417040105", 6));
                    if (!this.f169a.transact(1, obtain, obtain2, 0)) {
                        int i = C0004o0Oo0OO00O0O000ooOO0.f168a;
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public final boolean oO00o0OooO0OO0o0000o() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a("604b450413485b000d4654584d414b4a50515043584d410c204a6654584d414b4a6a605d565053404541", 66));
                    boolean z = false;
                    if (!this.f169a.transact(3, obtain, obtain2, 0)) {
                        int i = C0004o0Oo0OO00O0O000ooOO0.f168a;
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
            g("75393776613a29727f34262a3f333938222322312a3f337e523814262a3f33393818122f242221323733", 12);
        }

        /* JADX WARNING: type inference failed for: r0v3, types: [com.OO0000O0Ooo0OO000oo.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0, com.OO0000O0Ooo0OO000oo.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0, java.lang.Object] */
        public static o0Oo0OO00O0O000ooOO0 a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(g("751f1150471c0f545912000c19151f1e040504170c191558741e32000c19151f1e3e3409020407141115", 42));
            if (queryLocalInterface != null && (queryLocalInterface instanceof o0Oo0OO00O0O000ooOO0)) {
                return (o0Oo0OO00O0O000ooOO0) queryLocalInterface;
            }
            ? obj = new Object();
            obj.f169a = iBinder;
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
                byte b = (byte) (i ^ 57);
                byte b2 = (byte) (bArr[0] ^ Ascii.SYN);
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
            String g = g("752628697e25366d602b3935202c26273d3c3d2e35202c614d270b3935202c2627070d303b3d3e2d282c", 19);
            if (i == 1) {
                parcel.enforceInterface(g);
                o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0();
            } else if (i == 2) {
                parcel.enforceInterface(g);
                o0Oo0OO00O0O000ooOO0 = o0O00o00OOoOo0oooOoo00();
            } else if (i == 3) {
                parcel.enforceInterface(g);
                boolean oO00o0OooO0OO0o0000o = oO00o0OooO0OO0o0000o();
                parcel2.writeNoException();
                parcel2.writeInt(oO00o0OooO0OO0o0000o ? 1 : 0);
                return true;
            } else if (i == 4) {
                parcel.enforceInterface(g);
                parcel.readString();
                o0Oo0OO00O0O000ooOO0 = b();
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
    }

    String b();

    String d();

    String o0O00o00OOoOo0oooOoo00();

    String o0Oo0OO00O0O000ooOO0();

    boolean oO00o0OooO0OO0o0000o();
}
