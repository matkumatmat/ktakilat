package com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o00ooooooO00OO0O00;
import java.lang.reflect.Method;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.commons.lang3.CharEncoding;

public class O0OoOo00O000 extends com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0 {
    private static final String O00OO0oOOooooO00000Oo = o0Oo0OO00O0O000ooOO0("17292124", 53);
    private static final String O0OoOo00O000 = o0Oo0OO00O0O000ooOO0("132b3e2f2d2137", 42);
    private static final String O0o0o0O0OOOooOo0OOoOOO = o0Oo0OO00O0O000ooOO0("057b787d62607b6c7c", 97);
    private static final String O0oOO0ooO = o0Oo0OO00O0O000ooOO0("00706f6a", 123);
    private static final String OO0000O0Ooo0OO000oo = o0Oo0OO00O0O000ooOO0("00253f2b22", 46);
    private static final String OoOOooOoooOoo = o0Oo0OO00O0O000ooOO0("1537303a", 39);
    private static final String o00ooooooO00OO0O00 = o0Oo0OO00O0O000ooOO0("1549445f544e5f0b504509494706064d49564a1e0d4f50514d0e045a504e424852524a01", 89);
    private static final String oO00o0OooO0OO0o0000o = o0Oo0OO00O0O000ooOO0("19585e5b", 74);
    private boolean oO0oOOOOoo;

    public static class o0Oo0OO00O0O000ooOO0 {
        int o0O00o00OOoOo0oooOoo00;
        String o0Oo0OO00O0O000ooOO0;
        long oO00o0OooO0OO0o0000o;
    }

    public O0OoOo00O000(Context context, o00ooooooO00OO0O00 o00ooooooo00oo0o00) {
        super(context, o00ooooooo00oo0o00);
    }

    private String o0O00o00OOoOo0oooOoo00(String str) {
        Cursor cursor;
        try {
            cursor = this.o0Oo0OO00O0O000ooOO0.getContentResolver().query(Uri.parse(o0Oo0OO00O0O000ooOO0("1538352e253f2e7a213478383677773c38273b6f7c3e21203c7f752b213f333923233b70", 40)), (String[]) null, (String) null, new String[]{str}, (String) null);
        } catch (Throwable unused) {
            cursor = null;
        }
        o0Oo0OO00O0O000ooOO0 o0Oo0OO00O0O000ooOO02 = o0Oo0OO00O0O000ooOO0(cursor);
        if (o0Oo0OO00O0O000ooOO02 == null) {
            return null;
        }
        return o0Oo0OO00O0O000ooOO02.o0Oo0OO00O0O000ooOO0;
    }

    private o0Oo0OO00O0O000ooOO0 o0Oo0OO00O0O000ooOO0(Cursor cursor) {
        o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo0 = new o0Oo0OO00O0O000ooOO0();
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        try {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(o0Oo0OO00O0O000ooOO0("00706a7e77", 123));
            if (columnIndex < 0) {
                o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("002c36222b373c313a266327272b25", 39));
            }
            o0oo0oo00o0o000oooo0.o0Oo0OO00O0O000ooOO0 = cursor.getString(columnIndex);
            int columnIndex2 = cursor.getColumnIndex(o0Oo0OO00O0O000ooOO0("15383f35", 40));
            if (columnIndex2 < 0) {
                o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("152e2923676b2528233f7a3e3e323c", 62));
            }
            o0oo0oo00o0o000oooo0.o0O00o00OOoOo0oooOoo00 = cursor.getInt(columnIndex2);
            int columnIndex3 = cursor.getColumnIndex(o0Oo0OO00O0O000ooOO0("13495c4d4f4355", 72));
            if (columnIndex3 < 0) {
                o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("13100514161a0c49440a070c105511111d13", 17));
            }
            o0oo0oo00o0o000oooo0.oO00o0OooO0OO0o0000o = cursor.getLong(columnIndex3);
        } catch (Throwable th) {
            cursor.close();
            throw th;
        }
        cursor.close();
        return o0oo0oo00o0o000oooo0;
    }

    public String OO0000O0Ooo0OO000oo() {
        return o0Oo0OO00O0O000ooOO0("3b7f7b6478", 107);
    }

    public boolean OoOOooOoooOoo() {
        Context context = null;
        try {
            Method method = Class.forName(o0Oo0OO00O0O000ooOO0("1702071b100b0047421c0d53622f1a10121210002031171a0908", 17)).getMethod(o0Oo0OO00O0O000ooOO0("1568797e6975644b4f7e627b747c6b63787f", 98), (Class[]) null);
            method.setAccessible(true);
            context = (Context) method.invoke((Object) null, (Object[]) null);
        } catch (Throwable unused) {
        }
        if (context == null) {
            return false;
        }
        return o0Oo0OO00O0O000ooOO0(context);
    }

    @Nullable
    public String o00ooooooO00OO0O00() {
        if (!this.oO0oOOOOoo) {
            return null;
        }
        return o0O00o00OOoOo0oooOoo00(o0Oo0OO00O0O000ooOO0("195b5d58", 73));
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
            byte b = (byte) (i ^ 28);
            byte b2 = (byte) (bArr[0] ^ 118);
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

    public void o0Oo0OO00O0O000ooOO0(ThreadPoolExecutor threadPoolExecutor) {
        this.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(this);
    }

    private boolean o0Oo0OO00O0O000ooOO0(Context context) {
        Cursor query = context.getContentResolver().query(Uri.parse(o0Oo0OO00O0O000ooOO0("15131e050e1405510a1f53131d5c5c17130c104457150a0b17545e000a1418120808105b", 3)), (String[]) null, (String) null, new String[]{o0Oo0OO00O0O000ooOO0("05515257484a514656", 75)}, (String) null);
        if (query == null || !query.moveToFirst()) {
            return false;
        }
        try {
            boolean equals = o0Oo0OO00O0O000ooOO0("46", 50).equals(query.getString(query.getColumnIndex(o0Oo0OO00O0O000ooOO0("003822363f", 51))));
            query.close();
            return equals;
        } catch (Throwable unused) {
            query.close();
            return false;
        }
    }
}
