package com.appsflyer.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.appsflyer.AFLogger;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

public final class AFj1cSDK {
    @Nullable
    public static byte[] getCurrencyIso4217Code(@NonNull String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(str.getBytes(Charset.defaultCharset()));
            return instance.digest();
        } catch (Exception e) {
            AFLogger.afErrorLog("Error turning string to SHA-256 byte array", e);
            return null;
        }
    }

    public static long getMediationNetwork(@Nullable byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return -1;
        }
        if (bArr.length > 8) {
            bArr = Arrays.copyOfRange(bArr, 0, 8);
        }
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.put(bArr);
        allocate.flip();
        return allocate.getLong();
    }

    public static String getMonetizationNetwork(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(str.getBytes(Charset.defaultCharset()));
            return getRevenue(instance.digest());
        } catch (Exception e) {
            AFLogger.afErrorLog("Error turning data to SHA-256 string", e);
            return null;
        }
    }

    private static String getRevenue(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(Integer.toString((b & UnsignedBytes.MAX_VALUE) + Ascii.NUL, 16).substring(1));
        }
        return sb.toString();
    }

    public static String getRevenue(String str, String str2) {
        try {
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(new SecretKeySpec(str2.getBytes(Charset.defaultCharset()), "HmacSHA256"));
            return getRevenue(instance.doFinal(str.getBytes(Charset.defaultCharset()))).toLowerCase(Locale.getDefault());
        } catch (InvalidKeyException | NoSuchAlgorithmException e) {
            AFLogger.afErrorLog(e.getMessage(), e, true);
            return e.getMessage();
        }
    }

    public static boolean getMediationNetwork(Map<String, Object> map, String[] strArr, AFc1pSDK aFc1pSDK) throws IllegalStateException {
        if (map == null || map.isEmpty()) {
            return false;
        }
        for (String containsKey : strArr) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        String str = (String) map.remove("sig");
        if (str == null) {
            return false;
        }
        String component1 = AFc1pSDK.component1();
        StringBuilder sb = new StringBuilder();
        sb.append(new JSONObject(map));
        sb.append(component1);
        return getRevenue(sb.toString(), AFb1iSDK.getRevenue(aFc1pSDK.getMonetizationNetwork)).equals(str);
    }
}
