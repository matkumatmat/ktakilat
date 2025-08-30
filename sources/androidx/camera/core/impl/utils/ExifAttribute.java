package androidx.camera.core.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

final class ExifAttribute {
    static final Charset ASCII = StandardCharsets.US_ASCII;
    public static final long BYTES_OFFSET_UNKNOWN = -1;
    static final byte[] EXIF_ASCII_PREFIX = {65, 83, 67, 73, 73, 0, 0, 0};
    static final int IFD_FORMAT_BYTE = 1;
    static final int[] IFD_FORMAT_BYTES_PER_FORMAT = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    static final int IFD_FORMAT_DOUBLE = 12;
    static final String[] IFD_FORMAT_NAMES = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    static final int IFD_FORMAT_SBYTE = 6;
    static final int IFD_FORMAT_SINGLE = 11;
    static final int IFD_FORMAT_SLONG = 9;
    static final int IFD_FORMAT_SRATIONAL = 10;
    static final int IFD_FORMAT_SSHORT = 8;
    static final int IFD_FORMAT_STRING = 2;
    static final int IFD_FORMAT_ULONG = 4;
    static final int IFD_FORMAT_UNDEFINED = 7;
    static final int IFD_FORMAT_URATIONAL = 5;
    static final int IFD_FORMAT_USHORT = 3;
    private static final String TAG = "ExifAttribute";
    public final byte[] bytes;
    public final long bytesOffset;
    public final int format;
    public final int numberOfComponents;

    public ExifAttribute(int i, int i2, byte[] bArr) {
        this(i, i2, -1, bArr);
    }

    @NonNull
    public static ExifAttribute createByte(@NonNull String str) {
        if (str.length() != 1 || str.charAt(0) < '0' || str.charAt(0) > '1') {
            byte[] bytes2 = str.getBytes(ASCII);
            return new ExifAttribute(1, bytes2.length, bytes2);
        }
        return new ExifAttribute(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
    }

    @NonNull
    public static ExifAttribute createDouble(@NonNull double[] dArr, @NonNull ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[(IFD_FORMAT_BYTES_PER_FORMAT[12] * dArr.length)]);
        wrap.order(byteOrder);
        for (double putDouble : dArr) {
            wrap.putDouble(putDouble);
        }
        return new ExifAttribute(12, dArr.length, wrap.array());
    }

    @NonNull
    public static ExifAttribute createSLong(@NonNull int[] iArr, @NonNull ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[(IFD_FORMAT_BYTES_PER_FORMAT[9] * iArr.length)]);
        wrap.order(byteOrder);
        for (int putInt : iArr) {
            wrap.putInt(putInt);
        }
        return new ExifAttribute(9, iArr.length, wrap.array());
    }

    @NonNull
    public static ExifAttribute createSRational(@NonNull LongRational[] longRationalArr, @NonNull ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[(IFD_FORMAT_BYTES_PER_FORMAT[10] * longRationalArr.length)]);
        wrap.order(byteOrder);
        for (LongRational longRational : longRationalArr) {
            wrap.putInt((int) longRational.getNumerator());
            wrap.putInt((int) longRational.getDenominator());
        }
        return new ExifAttribute(10, longRationalArr.length, wrap.array());
    }

    @NonNull
    public static ExifAttribute createString(@NonNull String str) {
        byte[] bytes2 = (str + 0).getBytes(ASCII);
        return new ExifAttribute(2, bytes2.length, bytes2);
    }

    @NonNull
    public static ExifAttribute createULong(@NonNull long[] jArr, @NonNull ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[(IFD_FORMAT_BYTES_PER_FORMAT[4] * jArr.length)]);
        wrap.order(byteOrder);
        for (long j : jArr) {
            wrap.putInt((int) j);
        }
        return new ExifAttribute(4, jArr.length, wrap.array());
    }

    @NonNull
    public static ExifAttribute createURational(@NonNull LongRational[] longRationalArr, @NonNull ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[(IFD_FORMAT_BYTES_PER_FORMAT[5] * longRationalArr.length)]);
        wrap.order(byteOrder);
        for (LongRational longRational : longRationalArr) {
            wrap.putInt((int) longRational.getNumerator());
            wrap.putInt((int) longRational.getDenominator());
        }
        return new ExifAttribute(5, longRationalArr.length, wrap.array());
    }

    @NonNull
    public static ExifAttribute createUShort(@NonNull int[] iArr, @NonNull ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[(IFD_FORMAT_BYTES_PER_FORMAT[3] * iArr.length)]);
        wrap.order(byteOrder);
        for (int i : iArr) {
            wrap.putShort((short) i);
        }
        return new ExifAttribute(3, iArr.length, wrap.array());
    }

    public double getDoubleValue(@NonNull ByteOrder byteOrder) {
        Object value = getValue(byteOrder);
        if (value == null) {
            throw new NumberFormatException("NULL can't be converted to a double value");
        } else if (value instanceof String) {
            return Double.parseDouble((String) value);
        } else {
            if (value instanceof long[]) {
                long[] jArr = (long[]) value;
                if (jArr.length == 1) {
                    return (double) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            } else if (value instanceof int[]) {
                int[] iArr = (int[]) value;
                if (iArr.length == 1) {
                    return (double) iArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            } else if (value instanceof double[]) {
                double[] dArr = (double[]) value;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            } else if (value instanceof LongRational[]) {
                LongRational[] longRationalArr = (LongRational[]) value;
                if (longRationalArr.length == 1) {
                    return longRationalArr[0].toDouble();
                }
                throw new NumberFormatException("There are more than one component");
            } else {
                throw new NumberFormatException("Couldn't find a double value");
            }
        }
    }

    public int getIntValue(@NonNull ByteOrder byteOrder) {
        Object value = getValue(byteOrder);
        if (value == null) {
            throw new NumberFormatException("NULL can't be converted to a integer value");
        } else if (value instanceof String) {
            return Integer.parseInt((String) value);
        } else {
            if (value instanceof long[]) {
                long[] jArr = (long[]) value;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            } else if (value instanceof int[]) {
                int[] iArr = (int[]) value;
                if (iArr.length == 1) {
                    return iArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            } else {
                throw new NumberFormatException("Couldn't find a integer value");
            }
        }
    }

    @Nullable
    public String getStringValue(@NonNull ByteOrder byteOrder) {
        Object value = getValue(byteOrder);
        if (value == null) {
            return null;
        }
        if (value instanceof String) {
            return (String) value;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (value instanceof long[]) {
            long[] jArr = (long[]) value;
            while (i < jArr.length) {
                sb.append(jArr[i]);
                i++;
                if (i != jArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        } else if (value instanceof int[]) {
            int[] iArr = (int[]) value;
            while (i < iArr.length) {
                sb.append(iArr[i]);
                i++;
                if (i != iArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        } else if (value instanceof double[]) {
            double[] dArr = (double[]) value;
            while (i < dArr.length) {
                sb.append(dArr[i]);
                i++;
                if (i != dArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        } else if (!(value instanceof LongRational[])) {
            return null;
        } else {
            LongRational[] longRationalArr = (LongRational[]) value;
            while (i < longRationalArr.length) {
                sb.append(longRationalArr[i].getNumerator());
                sb.append('/');
                sb.append(longRationalArr[i].getDenominator());
                i++;
                if (i != longRationalArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:162:0x018f A[SYNTHETIC, Splitter:B:162:0x018f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getValue(java.nio.ByteOrder r12) {
        /*
            r11 = this;
            r0 = 0
            r1 = 1
            java.lang.String r2 = "IOException occurred while closing InputStream"
            java.lang.String r3 = "ExifAttribute"
            r4 = 0
            androidx.camera.core.impl.utils.ByteOrderedDataInputStream r5 = new androidx.camera.core.impl.utils.ByteOrderedDataInputStream     // Catch:{ IOException -> 0x017b, all -> 0x0179 }
            byte[] r6 = r11.bytes     // Catch:{ IOException -> 0x017b, all -> 0x0179 }
            r5.<init>((byte[]) r6)     // Catch:{ IOException -> 0x017b, all -> 0x0179 }
            r5.setByteOrder(r12)     // Catch:{ IOException -> 0x0033 }
            int r12 = r11.format     // Catch:{ IOException -> 0x0033 }
            switch(r12) {
                case 1: goto L_0x0149;
                case 2: goto L_0x0103;
                case 3: goto L_0x00ea;
                case 4: goto L_0x00d1;
                case 5: goto L_0x00af;
                case 6: goto L_0x0149;
                case 7: goto L_0x0103;
                case 8: goto L_0x0096;
                case 9: goto L_0x007d;
                case 10: goto L_0x0059;
                case 11: goto L_0x003f;
                case 12: goto L_0x001f;
                default: goto L_0x0016;
            }
        L_0x0016:
            r5.close()     // Catch:{ IOException -> 0x001a }
            goto L_0x001e
        L_0x001a:
            r12 = move-exception
            androidx.camera.core.Logger.e(r3, r2, r12)
        L_0x001e:
            return r4
        L_0x001f:
            int r12 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
            double[] r12 = new double[r12]     // Catch:{ IOException -> 0x0033 }
        L_0x0023:
            int r6 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
            if (r0 >= r6) goto L_0x0036
            double r6 = r5.readDouble()     // Catch:{ IOException -> 0x0033 }
            r12[r0] = r6     // Catch:{ IOException -> 0x0033 }
            int r0 = r0 + r1
            goto L_0x0023
        L_0x002f:
            r12 = move-exception
            r4 = r5
            goto L_0x018d
        L_0x0033:
            r12 = move-exception
            goto L_0x017d
        L_0x0036:
            r5.close()     // Catch:{ IOException -> 0x003a }
            goto L_0x003e
        L_0x003a:
            r0 = move-exception
            androidx.camera.core.Logger.e(r3, r2, r0)
        L_0x003e:
            return r12
        L_0x003f:
            int r12 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
            double[] r12 = new double[r12]     // Catch:{ IOException -> 0x0033 }
        L_0x0043:
            int r6 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
            if (r0 >= r6) goto L_0x0050
            float r6 = r5.readFloat()     // Catch:{ IOException -> 0x0033 }
            double r6 = (double) r6     // Catch:{ IOException -> 0x0033 }
            r12[r0] = r6     // Catch:{ IOException -> 0x0033 }
            int r0 = r0 + r1
            goto L_0x0043
        L_0x0050:
            r5.close()     // Catch:{ IOException -> 0x0054 }
            goto L_0x0058
        L_0x0054:
            r0 = move-exception
            androidx.camera.core.Logger.e(r3, r2, r0)
        L_0x0058:
            return r12
        L_0x0059:
            int r12 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
            androidx.camera.core.impl.utils.LongRational[] r12 = new androidx.camera.core.impl.utils.LongRational[r12]     // Catch:{ IOException -> 0x0033 }
        L_0x005d:
            int r6 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
            if (r0 >= r6) goto L_0x0074
            int r6 = r5.readInt()     // Catch:{ IOException -> 0x0033 }
            long r6 = (long) r6     // Catch:{ IOException -> 0x0033 }
            int r8 = r5.readInt()     // Catch:{ IOException -> 0x0033 }
            long r8 = (long) r8     // Catch:{ IOException -> 0x0033 }
            androidx.camera.core.impl.utils.LongRational r10 = new androidx.camera.core.impl.utils.LongRational     // Catch:{ IOException -> 0x0033 }
            r10.<init>(r6, r8)     // Catch:{ IOException -> 0x0033 }
            r12[r0] = r10     // Catch:{ IOException -> 0x0033 }
            int r0 = r0 + r1
            goto L_0x005d
        L_0x0074:
            r5.close()     // Catch:{ IOException -> 0x0078 }
            goto L_0x007c
        L_0x0078:
            r0 = move-exception
            androidx.camera.core.Logger.e(r3, r2, r0)
        L_0x007c:
            return r12
        L_0x007d:
            int r12 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
            int[] r12 = new int[r12]     // Catch:{ IOException -> 0x0033 }
        L_0x0081:
            int r6 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
            if (r0 >= r6) goto L_0x008d
            int r6 = r5.readInt()     // Catch:{ IOException -> 0x0033 }
            r12[r0] = r6     // Catch:{ IOException -> 0x0033 }
            int r0 = r0 + r1
            goto L_0x0081
        L_0x008d:
            r5.close()     // Catch:{ IOException -> 0x0091 }
            goto L_0x0095
        L_0x0091:
            r0 = move-exception
            androidx.camera.core.Logger.e(r3, r2, r0)
        L_0x0095:
            return r12
        L_0x0096:
            int r12 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
            int[] r12 = new int[r12]     // Catch:{ IOException -> 0x0033 }
        L_0x009a:
            int r6 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
            if (r0 >= r6) goto L_0x00a6
            short r6 = r5.readShort()     // Catch:{ IOException -> 0x0033 }
            r12[r0] = r6     // Catch:{ IOException -> 0x0033 }
            int r0 = r0 + r1
            goto L_0x009a
        L_0x00a6:
            r5.close()     // Catch:{ IOException -> 0x00aa }
            goto L_0x00ae
        L_0x00aa:
            r0 = move-exception
            androidx.camera.core.Logger.e(r3, r2, r0)
        L_0x00ae:
            return r12
        L_0x00af:
            int r12 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
            androidx.camera.core.impl.utils.LongRational[] r12 = new androidx.camera.core.impl.utils.LongRational[r12]     // Catch:{ IOException -> 0x0033 }
        L_0x00b3:
            int r6 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
            if (r0 >= r6) goto L_0x00c8
            long r6 = r5.readUnsignedInt()     // Catch:{ IOException -> 0x0033 }
            long r8 = r5.readUnsignedInt()     // Catch:{ IOException -> 0x0033 }
            androidx.camera.core.impl.utils.LongRational r10 = new androidx.camera.core.impl.utils.LongRational     // Catch:{ IOException -> 0x0033 }
            r10.<init>(r6, r8)     // Catch:{ IOException -> 0x0033 }
            r12[r0] = r10     // Catch:{ IOException -> 0x0033 }
            int r0 = r0 + r1
            goto L_0x00b3
        L_0x00c8:
            r5.close()     // Catch:{ IOException -> 0x00cc }
            goto L_0x00d0
        L_0x00cc:
            r0 = move-exception
            androidx.camera.core.Logger.e(r3, r2, r0)
        L_0x00d0:
            return r12
        L_0x00d1:
            int r12 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
            long[] r12 = new long[r12]     // Catch:{ IOException -> 0x0033 }
        L_0x00d5:
            int r6 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
            if (r0 >= r6) goto L_0x00e1
            long r6 = r5.readUnsignedInt()     // Catch:{ IOException -> 0x0033 }
            r12[r0] = r6     // Catch:{ IOException -> 0x0033 }
            int r0 = r0 + r1
            goto L_0x00d5
        L_0x00e1:
            r5.close()     // Catch:{ IOException -> 0x00e5 }
            goto L_0x00e9
        L_0x00e5:
            r0 = move-exception
            androidx.camera.core.Logger.e(r3, r2, r0)
        L_0x00e9:
            return r12
        L_0x00ea:
            int r12 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
            int[] r12 = new int[r12]     // Catch:{ IOException -> 0x0033 }
        L_0x00ee:
            int r6 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
            if (r0 >= r6) goto L_0x00fa
            int r6 = r5.readUnsignedShort()     // Catch:{ IOException -> 0x0033 }
            r12[r0] = r6     // Catch:{ IOException -> 0x0033 }
            int r0 = r0 + r1
            goto L_0x00ee
        L_0x00fa:
            r5.close()     // Catch:{ IOException -> 0x00fe }
            goto L_0x0102
        L_0x00fe:
            r0 = move-exception
            androidx.camera.core.Logger.e(r3, r2, r0)
        L_0x0102:
            return r12
        L_0x0103:
            int r12 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
            byte[] r6 = EXIF_ASCII_PREFIX     // Catch:{ IOException -> 0x0033 }
            int r6 = r6.length     // Catch:{ IOException -> 0x0033 }
            if (r12 < r6) goto L_0x011c
            r12 = 0
        L_0x010b:
            byte[] r6 = EXIF_ASCII_PREFIX     // Catch:{ IOException -> 0x0033 }
            int r7 = r6.length     // Catch:{ IOException -> 0x0033 }
            if (r12 >= r7) goto L_0x011b
            byte[] r7 = r11.bytes     // Catch:{ IOException -> 0x0033 }
            byte r7 = r7[r12]     // Catch:{ IOException -> 0x0033 }
            byte r6 = r6[r12]     // Catch:{ IOException -> 0x0033 }
            if (r7 == r6) goto L_0x0119
            goto L_0x011c
        L_0x0119:
            int r12 = r12 + r1
            goto L_0x010b
        L_0x011b:
            int r0 = r6.length     // Catch:{ IOException -> 0x0033 }
        L_0x011c:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0033 }
            r12.<init>()     // Catch:{ IOException -> 0x0033 }
        L_0x0121:
            int r6 = r11.numberOfComponents     // Catch:{ IOException -> 0x0033 }
            if (r0 >= r6) goto L_0x013c
            byte[] r6 = r11.bytes     // Catch:{ IOException -> 0x0033 }
            byte r6 = r6[r0]     // Catch:{ IOException -> 0x0033 }
            if (r6 != 0) goto L_0x012c
            goto L_0x013c
        L_0x012c:
            r7 = 32
            if (r6 < r7) goto L_0x0135
            char r6 = (char) r6     // Catch:{ IOException -> 0x0033 }
            r12.append(r6)     // Catch:{ IOException -> 0x0033 }
            goto L_0x013a
        L_0x0135:
            r6 = 63
            r12.append(r6)     // Catch:{ IOException -> 0x0033 }
        L_0x013a:
            int r0 = r0 + r1
            goto L_0x0121
        L_0x013c:
            java.lang.String r12 = r12.toString()     // Catch:{ IOException -> 0x0033 }
            r5.close()     // Catch:{ IOException -> 0x0144 }
            goto L_0x0148
        L_0x0144:
            r0 = move-exception
            androidx.camera.core.Logger.e(r3, r2, r0)
        L_0x0148:
            return r12
        L_0x0149:
            byte[] r12 = r11.bytes     // Catch:{ IOException -> 0x0033 }
            int r6 = r12.length     // Catch:{ IOException -> 0x0033 }
            if (r6 != r1) goto L_0x0169
            byte r6 = r12[r0]     // Catch:{ IOException -> 0x0033 }
            if (r6 < 0) goto L_0x0169
            if (r6 > r1) goto L_0x0169
            java.lang.String r12 = new java.lang.String     // Catch:{ IOException -> 0x0033 }
            int r6 = r6 + 48
            char r6 = (char) r6     // Catch:{ IOException -> 0x0033 }
            char[] r1 = new char[r1]     // Catch:{ IOException -> 0x0033 }
            r1[r0] = r6     // Catch:{ IOException -> 0x0033 }
            r12.<init>(r1)     // Catch:{ IOException -> 0x0033 }
            r5.close()     // Catch:{ IOException -> 0x0164 }
            goto L_0x0168
        L_0x0164:
            r0 = move-exception
            androidx.camera.core.Logger.e(r3, r2, r0)
        L_0x0168:
            return r12
        L_0x0169:
            java.lang.String r0 = new java.lang.String     // Catch:{ IOException -> 0x0033 }
            java.nio.charset.Charset r1 = ASCII     // Catch:{ IOException -> 0x0033 }
            r0.<init>(r12, r1)     // Catch:{ IOException -> 0x0033 }
            r5.close()     // Catch:{ IOException -> 0x0174 }
            goto L_0x0178
        L_0x0174:
            r12 = move-exception
            androidx.camera.core.Logger.e(r3, r2, r12)
        L_0x0178:
            return r0
        L_0x0179:
            r12 = move-exception
            goto L_0x018d
        L_0x017b:
            r12 = move-exception
            r5 = r4
        L_0x017d:
            java.lang.String r0 = "IOException occurred during reading a value"
            androidx.camera.core.Logger.w(r3, r0, r12)     // Catch:{ all -> 0x002f }
            if (r5 == 0) goto L_0x018c
            r5.close()     // Catch:{ IOException -> 0x0188 }
            goto L_0x018c
        L_0x0188:
            r12 = move-exception
            androidx.camera.core.Logger.e(r3, r2, r12)
        L_0x018c:
            return r4
        L_0x018d:
            if (r4 == 0) goto L_0x0197
            r4.close()     // Catch:{ IOException -> 0x0193 }
            goto L_0x0197
        L_0x0193:
            r0 = move-exception
            androidx.camera.core.Logger.e(r3, r2, r0)
        L_0x0197:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.utils.ExifAttribute.getValue(java.nio.ByteOrder):java.lang.Object");
    }

    public int size() {
        return IFD_FORMAT_BYTES_PER_FORMAT[this.format] * this.numberOfComponents;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(IFD_FORMAT_NAMES[this.format]);
        sb.append(", data length:");
        return ba.q(sb, ")", this.bytes.length);
    }

    public ExifAttribute(int i, int i2, long j, byte[] bArr) {
        this.format = i;
        this.numberOfComponents = i2;
        this.bytesOffset = j;
        this.bytes = bArr;
    }

    @NonNull
    public static ExifAttribute createDouble(double d, @NonNull ByteOrder byteOrder) {
        return createDouble(new double[]{d}, byteOrder);
    }

    @NonNull
    public static ExifAttribute createSLong(int i, @NonNull ByteOrder byteOrder) {
        return createSLong(new int[]{i}, byteOrder);
    }

    @NonNull
    public static ExifAttribute createULong(long j, @NonNull ByteOrder byteOrder) {
        return createULong(new long[]{j}, byteOrder);
    }

    @NonNull
    public static ExifAttribute createUShort(int i, @NonNull ByteOrder byteOrder) {
        return createUShort(new int[]{i}, byteOrder);
    }

    @NonNull
    public static ExifAttribute createSRational(@NonNull LongRational longRational, @NonNull ByteOrder byteOrder) {
        return createSRational(new LongRational[]{longRational}, byteOrder);
    }

    @NonNull
    public static ExifAttribute createURational(@NonNull LongRational longRational, @NonNull ByteOrder byteOrder) {
        return createURational(new LongRational[]{longRational}, byteOrder);
    }
}
