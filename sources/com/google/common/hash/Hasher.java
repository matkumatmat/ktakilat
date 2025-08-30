package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@ElementTypesAreNonnullByDefault
@CanIgnoreReturnValue
@Beta
public interface Hasher extends PrimitiveSink {
    HashCode hash();

    @Deprecated
    int hashCode();

    Hasher putBoolean(boolean z);

    /* bridge */ /* synthetic */ PrimitiveSink putBoolean(boolean z);

    Hasher putByte(byte b);

    /* bridge */ /* synthetic */ PrimitiveSink putByte(byte b);

    Hasher putBytes(ByteBuffer byteBuffer);

    Hasher putBytes(byte[] bArr);

    Hasher putBytes(byte[] bArr, int i, int i2);

    /* bridge */ /* synthetic */ PrimitiveSink putBytes(ByteBuffer byteBuffer);

    /* bridge */ /* synthetic */ PrimitiveSink putBytes(byte[] bArr);

    /* bridge */ /* synthetic */ PrimitiveSink putBytes(byte[] bArr, int i, int i2);

    Hasher putChar(char c);

    /* bridge */ /* synthetic */ PrimitiveSink putChar(char c);

    Hasher putDouble(double d);

    /* bridge */ /* synthetic */ PrimitiveSink putDouble(double d);

    Hasher putFloat(float f);

    /* bridge */ /* synthetic */ PrimitiveSink putFloat(float f);

    Hasher putInt(int i);

    /* bridge */ /* synthetic */ PrimitiveSink putInt(int i);

    Hasher putLong(long j);

    /* bridge */ /* synthetic */ PrimitiveSink putLong(long j);

    <T> Hasher putObject(@ParametricNullness T t, Funnel<? super T> funnel);

    Hasher putShort(short s);

    /* bridge */ /* synthetic */ PrimitiveSink putShort(short s);

    Hasher putString(CharSequence charSequence, Charset charset);

    /* bridge */ /* synthetic */ PrimitiveSink putString(CharSequence charSequence, Charset charset);

    Hasher putUnencodedChars(CharSequence charSequence);

    /* bridge */ /* synthetic */ PrimitiveSink putUnencodedChars(CharSequence charSequence);
}
