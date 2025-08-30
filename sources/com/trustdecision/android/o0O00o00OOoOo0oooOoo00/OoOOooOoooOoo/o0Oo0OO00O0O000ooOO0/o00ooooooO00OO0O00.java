package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.o0Oo0OO00O0O000ooOO0;

import com.google.common.primitives.UnsignedBytes;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.commons.lang3.CharEncoding;

public class o00ooooooO00OO0O00 implements oO00o0OooO0OO0o0000o, Closeable {
    private final FileChannel o0O00o00OOoOo0oooOoo00;
    private final int o0Oo0OO00O0O000ooOO0 = 1179403647;

    public o00ooooooO00OO0O00(File file) throws FileNotFoundException {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException(o0Oo0OO00O0O000ooOO0("46567c703c30632a376260793536642b3d72736f2a3778622d3c6468637e", 122));
        }
        this.o0O00o00OOoOo0oooOoo00 = new FileInputStream(file).getChannel();
    }

    private long o0Oo0OO00O0O000ooOO0(oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00 o0o00o00ooooo0oooooo00, long j, long j2) throws IOException {
        for (long j3 = 0; j3 < j; j3++) {
            oO00o0OooO0OO0o0000o.C0018oO00o0OooO0OO0o0000o o0Oo0OO00O0O000ooOO02 = o0o00o00ooooo0oooooo00.o0Oo0OO00O0O000ooOO0(j3);
            if (o0Oo0OO00O0O000ooOO02.o0Oo0OO00O0O000ooOO0 == 1) {
                long j4 = o0Oo0OO00O0O000ooOO02.oO00o0OooO0OO0o0000o;
                if (j4 <= j2 && j2 <= o0Oo0OO00O0O000ooOO02.O00OO0oOOooooO00000Oo + j4) {
                    return (j2 - j4) + o0Oo0OO00O0O000ooOO02.o0O00o00OOoOo0oooOoo00;
                }
            }
        }
        throw new IllegalStateException(o0Oo0OO00O0O000ooOO0("43370102135f551a004f56170a4b4d00175a4f00545d141e125e54121b0e0d0a4e", 24));
    }

    public int O00OO0oOOooooO00000Oo(ByteBuffer byteBuffer, long j) throws IOException {
        o0Oo0OO00O0O000ooOO0(byteBuffer, j, 2);
        return byteBuffer.getShort() & 65535;
    }

    public short O0oOO0ooO(ByteBuffer byteBuffer, long j) throws IOException {
        o0Oo0OO00O0O000ooOO0(byteBuffer, j, 1);
        return (short) (byteBuffer.get() & UnsignedBytes.MAX_VALUE);
    }

    public void close() throws IOException {
        this.o0O00o00OOoOo0oooOoo00.close();
    }

    public long o0O00o00OOoOo0oooOoo00(ByteBuffer byteBuffer, long j) throws IOException {
        o0Oo0OO00O0O000ooOO0(byteBuffer, j, 8);
        return byteBuffer.getLong();
    }

    public long oO00o0OooO0OO0o0000o(ByteBuffer byteBuffer, long j) throws IOException {
        o0Oo0OO00O0O000ooOO0(byteBuffer, j, 4);
        return ((long) byteBuffer.getInt()) & 4294967295L;
    }

    public List o0O00o00OOoOo0oooOoo00() throws IOException {
        long j;
        this.o0O00o00OOoOo0oooOoo00.position(0);
        ArrayList arrayList = new ArrayList();
        oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00 o0Oo0OO00O0O000ooOO02 = o0Oo0OO00O0O000ooOO0();
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(o0Oo0OO00O0O000ooOO02.o0Oo0OO00O0O000ooOO0 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j2 = (long) o0Oo0OO00O0O000ooOO02.o00ooooooO00OO0O00;
        int i = 0;
        if (j2 == WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            j2 = o0Oo0OO00O0O000ooOO02.o0Oo0OO00O0O000ooOO0(0).o0Oo0OO00O0O000ooOO0;
        }
        long j3 = 0;
        while (true) {
            if (j3 >= j2) {
                j = 0;
                break;
            }
            oO00o0OooO0OO0o0000o.C0018oO00o0OooO0OO0o0000o o0Oo0OO00O0O000ooOO03 = o0Oo0OO00O0O000ooOO02.o0Oo0OO00O0O000ooOO0(j3);
            if (o0Oo0OO00O0O000ooOO03.o0Oo0OO00O0O000ooOO0 == 2) {
                j = o0Oo0OO00O0O000ooOO03.o0O00o00OOoOo0oooOoo00;
                break;
            }
            j3++;
        }
        if (j == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        long j4 = 0;
        while (true) {
            oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0 o0Oo0OO00O0O000ooOO04 = o0Oo0OO00O0O000ooOO02.o0Oo0OO00O0O000ooOO0(j, i);
            long j5 = j;
            long j6 = o0Oo0OO00O0O000ooOO04.o0Oo0OO00O0O000ooOO0;
            if (j6 == 1) {
                arrayList2.add(Long.valueOf(o0Oo0OO00O0O000ooOO04.o0O00o00OOoOo0oooOoo00));
            } else if (j6 == 5) {
                j4 = o0Oo0OO00O0O000ooOO04.o0O00o00OOoOo0oooOoo00;
            }
            i++;
            if (o0Oo0OO00O0O000ooOO04.o0Oo0OO00O0O000ooOO0 == 0) {
                break;
            }
            j = j5;
        }
        if (j4 != 0) {
            long o0Oo0OO00O0O000ooOO05 = o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO02, j2, j4);
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(o0Oo0OO00O0O000ooOO0(allocate, ((Long) it.next()).longValue() + o0Oo0OO00O0O000ooOO05));
            }
            return arrayList;
        }
        throw new IllegalStateException(o0Oo0OO00O0O000ooOO0("537b5a475b551b08495f52551913555c494a4d08125d47081a5546475619", 95));
    }

    public oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00 o0Oo0OO00O0O000ooOO0() throws IOException {
        this.o0O00o00OOoOo0oooOoo00.position(0);
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (oO00o0OooO0OO0o0000o(allocate, 0) == 1179403647) {
            short O0oOO0ooO = O0oOO0ooO(allocate, 4);
            boolean z = O0oOO0ooO(allocate, 5) == 2;
            if (O0oOO0ooO == 1) {
                return new O00OO0oOOooooO00000Oo(z, this);
            }
            if (O0oOO0ooO == 2) {
                return new O0oOO0ooO(z, this);
            }
            throw new IllegalStateException(o0Oo0OO00O0O000ooOO0("491629263c343c75723e3c233162653c382475", 50));
        }
        throw new IllegalArgumentException(o0Oo0OO00O0O000ooOO0("49152a253f373f76573b38545f1e343c3870", 49));
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
            byte b = (byte) (i ^ 3);
            byte b2 = (byte) bArr[0];
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

    public String o0Oo0OO00O0O000ooOO0(ByteBuffer byteBuffer, long j) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j2 = 1 + j;
            short O0oOO0ooO = O0oOO0ooO(byteBuffer, j);
            if (O0oOO0ooO == 0) {
                return sb.toString();
            }
            sb.append((char) O0oOO0ooO);
            j = j2;
        }
    }

    public void o0Oo0OO00O0O000ooOO0(ByteBuffer byteBuffer, long j, int i) throws IOException {
        byteBuffer.position(0);
        byteBuffer.limit(i);
        long j2 = 0;
        while (j2 < ((long) i)) {
            int read = this.o0O00o00OOoOo0oooOoo00.read(byteBuffer, j + j2);
            if (read != -1) {
                j2 += (long) read;
            } else {
                throw new EOFException();
            }
        }
        byteBuffer.position(0);
    }
}
