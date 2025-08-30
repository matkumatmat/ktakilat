package com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import org.apache.commons.lang3.CharEncoding;

public interface o00ooooooO00OO0O00 extends IInterface {

    public static abstract class o0Oo0OO00O0O000ooOO0 extends Binder implements o00ooooooO00OO0O00 {

        /* renamed from: com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o00ooooooO00OO0O00$o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0  reason: collision with other inner class name */
        public static class C0023o0Oo0OO00O0O000ooOO0 implements o00ooooooO00OO0O00 {
            public IBinder o0Oo0OO00O0O000ooOO0;

            public C0023o0Oo0OO00O0O000ooOO0(IBinder iBinder) {
                this.o0Oo0OO00O0O000ooOO0 = iBinder;
            }

            private static String o0Oo0OO00O0O000ooOO0(String str, int i) {
                try {
                    int length = str.length() / 2;
                    char[] charArray = str.toCharArray();
                    byte[] bArr = new byte[length];
                    for (int i2 = 0; i2 < length; i2++) {
                        int i3 = i2 * 2;
                        bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
                    }
                    byte b = (byte) (i ^ 36);
                    byte b2 = (byte) (bArr[0] ^ 124);
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

            public IBinder asBinder() {
                return this.o0Oo0OO00O0O000ooOO0;
            }

            public String o0Oo0OO00O0O000ooOO0(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(o0Oo0OO00O0O000ooOO0("1f4749080d4657465e5a150a545e404c46012c4d745e406c46", 111));
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.o0Oo0OO00O0O000ooOO0.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static o00ooooooO00OO0O00 o0Oo0OO00O0O000ooOO0(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(o0Oo0OO00O0O000ooOO0("482a2465602b3a2b3337786739332d212b6c412019332d012b", 21));
            return (queryLocalInterface == null || !(queryLocalInterface instanceof o00ooooooO00OO0O00)) ? new C0023o0Oo0OO00O0O000ooOO0(iBinder) : (o00ooooooO00OO0O00) queryLocalInterface;
        }

        private static String o0Oo0OO00O0O000ooOO0(String str, int i) {
            try {
                int length = str.length() / 2;
                char[] charArray = str.toCharArray();
                byte[] bArr = new byte[length];
                for (int i2 = 0; i2 < length; i2++) {
                    int i3 = i2 * 2;
                    bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
                }
                byte b = (byte) (i ^ 51);
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
    }
}
