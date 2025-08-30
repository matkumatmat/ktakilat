package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.common.base.Ascii;
import java.util.concurrent.LinkedBlockingQueue;
import org.apache.commons.lang3.CharEncoding;

public class O0oOO0ooO {
    private static final String o0O00o00OOoOo0oooOoo00 = o0Oo0OO00O0O000ooOO0("3c212121212121213c3c2121213c3c2121213c3c2121213c3c2121212121212121212121", 111);
    private static final String o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0("6f1a14555f1e161e1d1f5d59191c000b101b5c5f1c084b5913014b511b171d0c0b19191a014a51110c07010a191b54711e33040501100b0c0c111f383b21200112091c10", 88);

    public static class o0O00o00OOoOo0oooOoo00 implements IInterface {
        private final IBinder o0Oo0OO00O0O000ooOO0;

        public o0O00o00OOoOo0oooOoo00(IBinder iBinder) {
            this.o0Oo0OO00O0O000ooOO0 = iBinder;
        }

        public IBinder asBinder() {
            return this.o0Oo0OO00O0O000ooOO0;
        }

        public String o0Oo0OO00O0O000ooOO0() {
            if (this.o0Oo0OO00O0O000ooOO0 == null) {
                return "";
            }
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(o0Oo0OO00O0O000ooOO0("54222c6d67262e26252765612124383328236467243073612b397369232f25343321212239726929343f393221236c49260b3c3d3928333434292700031918392a312428", 114));
                this.o0Oo0OO00O0O000ooOO0.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                String readString = obtain2.readString();
                obtain2.recycle();
                obtain.recycle();
                return readString;
            } catch (Throwable unused) {
                obtain2.recycle();
                obtain.recycle();
                return "";
            }
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
                byte b = (byte) (i ^ 92);
                byte b2 = (byte) (bArr[0] ^ 55);
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

        public boolean o0Oo0OO00O0O000ooOO0(boolean z) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            boolean z2 = false;
            try {
                obtain.writeInterfaceToken(o0Oo0OO00O0O000ooOO0("544d4302084941494a480a0e4e4b575c474c0b084b5f1c0e44561c064c404a5b5c4e4e4d561d06465b50565d4e4c03264964535256475c5b5b46486f6c767756455e4b47", 29));
                obtain.writeInt(z ? 1 : 0);
                this.o0Oo0OO00O0O000ooOO0.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() != 0) {
                    z2 = true;
                }
                obtain2.recycle();
                obtain.recycle();
                return z2;
            } catch (Throwable unused) {
                obtain2.recycle();
                obtain.recycle();
                return false;
            }
        }
    }

    public static class o0Oo0OO00O0O000ooOO0 implements ServiceConnection {
        private LinkedBlockingQueue o0O00o00OOoOo0oooOoo00;
        private boolean o0Oo0OO00O0O000ooOO0;

        private o0Oo0OO00O0O000ooOO0() {
            this.o0Oo0OO00O0O000ooOO0 = false;
            this.o0O00o00OOoOo0oooOoo00 = new LinkedBlockingQueue(1);
        }

        public IBinder o0Oo0OO00O0O000ooOO0() {
            if (this.o0Oo0OO00O0O000ooOO0) {
                return null;
            }
            this.o0Oo0OO00O0O000ooOO0 = true;
            try {
                return (IBinder) this.o0O00o00OOoOo0oooOoo00.take();
            } catch (Exception unused) {
                return null;
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.o0O00o00OOoOo0oooOoo00.put(iBinder);
            } catch (Exception unused) {
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:8|9|10|(2:12|(4:14|15|16|17)(6:19|20|21|22|23|24))|26|27) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x006e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String o0Oo0OO00O0O000ooOO0(android.content.Context r5) {
        /*
            java.lang.String r0 = ""
            if (r5 == 0) goto L_0x0071
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            android.os.Looper r2 = android.os.Looper.myLooper()
            if (r1 != r2) goto L_0x000f
            goto L_0x0071
        L_0x000f:
            java.lang.String r1 = "6f5957161c5d555d5e5c1e1a5a5f434853581f1c5f4b080b40424a514f554f5354153a504e4358"
            r2 = 27
            java.lang.String r1 = o0Oo0OO00O0O000ooOO0(r1, r2)
            boolean r1 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O0oOoooo0o0o0oOo.o0Oo0OO00O0O000ooOO0((android.content.Context) r5, (java.lang.String) r1)
            if (r1 != 0) goto L_0x0026
            java.lang.String r5 = "3c1f1f1f1f1f1f1f02021f1f1f02021f1f1f02021f1f1f02021f1f1f1f1f1f1f1f1f1f1f"
            r0 = 81
            java.lang.String r5 = o0Oo0OO00O0O000ooOO0(r5, r0)
            return r5
        L_0x0026:
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.O0oOO0ooO$o0Oo0OO00O0O000ooOO0 r1 = new com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.O0oOO0ooO$o0Oo0OO00O0O000ooOO0
            r2 = 0
            r1.<init>()
            android.content.Intent r2 = new android.content.Intent     // Catch:{ all -> 0x006e }
            java.lang.String r3 = "6f7a74353f7e767e7d7f3d39797c606b707b3c3f7c682b3973612b317b777d6c6b79797a612a2b606172697c703d0b71636570"
            r4 = 56
            java.lang.String r3 = o0Oo0OO00O0O000ooOO0(r3, r4)     // Catch:{ all -> 0x006e }
            r2.<init>(r3)     // Catch:{ all -> 0x006e }
            java.lang.String r3 = "6f06084943020a020103414505001c170c0740430014"
            r4 = 68
            java.lang.String r3 = o0Oo0OO00O0O000ooOO0(r3, r4)     // Catch:{ all -> 0x006e }
            r2.setPackage(r3)     // Catch:{ all -> 0x006e }
            r3 = 1
            boolean r2 = r5.bindService(r2, r1, r3)     // Catch:{ all -> 0x006e }
            if (r2 == 0) goto L_0x006e
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.O0oOO0ooO$o0O00o00OOoOo0oooOoo00 r2 = new com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.O0oOO0ooO$o0O00o00OOoOo0oooOoo00     // Catch:{ all -> 0x006e }
            android.os.IBinder r4 = r1.o0Oo0OO00O0O000ooOO0()     // Catch:{ all -> 0x006e }
            r2.<init>(r4)     // Catch:{ all -> 0x006e }
            boolean r3 = r2.o0Oo0OO00O0O000ooOO0(r3)     // Catch:{ all -> 0x006e }
            if (r3 != 0) goto L_0x0062
            java.lang.String r0 = r2.o0Oo0OO00O0O000ooOO0()     // Catch:{ all -> 0x006e }
            r5.unbindService(r1)     // Catch:{ all -> 0x0061 }
        L_0x0061:
            return r0
        L_0x0062:
            java.lang.String r2 = "3c161616161616160b0b1616160b0b1616160b0b1616160b0b1616161616161616161616"
            r3 = 88
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0(r2, r3)     // Catch:{ all -> 0x006e }
            r5.unbindService(r1)     // Catch:{ all -> 0x006d }
        L_0x006d:
            return r0
        L_0x006e:
            r5.unbindService(r1)     // Catch:{ all -> 0x0071 }
        L_0x0071:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.o0Oo0OO00O0O000ooOO0(android.content.Context):java.lang.String");
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
            byte b = (byte) (i ^ 78);
            byte b2 = (byte) (bArr[0] ^ Ascii.FF);
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
