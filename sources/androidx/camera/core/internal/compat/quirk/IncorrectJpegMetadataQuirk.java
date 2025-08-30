package androidx.camera.core.internal.compat.quirk;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.Quirk;
import com.google.common.primitives.UnsignedBytes;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public final class IncorrectJpegMetadataQuirk implements Quirk {
    private static final Set<String> SAMSUNG_DEVICES = new HashSet(Arrays.asList(new String[]{"A24"}));

    private boolean canParseSosMarker(@NonNull byte[] bArr) {
        byte b;
        int i = 2;
        while (i + 4 <= bArr.length && (b = bArr[i]) == -1) {
            if (b == -1 && bArr[i + 1] == -38) {
                return true;
            }
            i += (((bArr[i + 2] & UnsignedBytes.MAX_VALUE) << 8) | (bArr[i + 3] & UnsignedBytes.MAX_VALUE)) + 2;
        }
        return false;
    }

    private int findSecondFfd8Position(@NonNull byte[] bArr) {
        int i = 2;
        while (true) {
            int i2 = i + 1;
            if (i2 > bArr.length) {
                return -1;
            }
            if (bArr[i] == -1 && bArr[i2] == -40) {
                return i;
            }
            i = i2;
        }
    }

    private static boolean isSamsungProblematicDevice() {
        if (!"Samsung".equalsIgnoreCase(Build.BRAND) || !SAMSUNG_DEVICES.contains(Build.DEVICE.toUpperCase(Locale.US))) {
            return false;
        }
        return true;
    }

    public static boolean load() {
        return isSamsungProblematicDevice();
    }

    @NonNull
    public byte[] jpegImageToJpegByteArray(@NonNull ImageProxy imageProxy) {
        int i = 0;
        ByteBuffer buffer = imageProxy.getPlanes()[0].getBuffer();
        byte[] bArr = new byte[buffer.capacity()];
        buffer.rewind();
        buffer.get(bArr);
        if (canParseSosMarker(bArr) || (i = findSecondFfd8Position(bArr)) != -1) {
            return Arrays.copyOfRange(bArr, i, buffer.limit());
        }
        return bArr;
    }
}
