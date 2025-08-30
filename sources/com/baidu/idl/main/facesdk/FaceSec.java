package com.baidu.idl.main.facesdk;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;

public class FaceSec {
    public static final String TAG = "FaceSec";
    public byte[] value;

    private native String decrypt(String str);

    private native String encrypt(String str);

    private native int init(AssetManager assetManager);

    private native String sec(byte[] bArr);

    public String d(String str) {
        if (!TextUtils.isEmpty(str)) {
            return decrypt(str);
        }
        return null;
    }

    public String e(byte[] bArr) {
        return sec(bArr);
    }

    public int i(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            int init = init(context.getAssets());
            if (init == 0) {
                return init;
            }
            throw new RuntimeException("face sdk init sec error");
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public String e(String str) {
        if (!TextUtils.isEmpty(str)) {
            return encrypt(str);
        }
        return null;
    }
}
