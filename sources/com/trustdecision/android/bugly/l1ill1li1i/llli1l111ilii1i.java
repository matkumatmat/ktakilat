package com.trustdecision.android.bugly.l1ill1li1i;

import com.facebook.appevents.AppEventsConstants;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.lang3.CharEncoding;

public class llli1l111ilii1i {
    public static String l1l11i111l(String str) {
        return liii1l1lll1(str).substring(8, 24);
    }

    public static String liii1l1lll1(String str) {
        String str2 = "";
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(str.getBytes(CharEncoding.UTF_8));
            str2 = new BigInteger(1, instance.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        return llli1l111ilii1i(str2);
    }

    private static String llli1l111ilii1i(String str) {
        if (str.length() == 32) {
            return str;
        }
        return llli1l111ilii1i(AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(str));
    }
}
