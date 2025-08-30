package com.ktakilat.loan.global;

import com.ktakilat.cbase.cache.KvSave;

public class H5Kv {

    /* renamed from: a  reason: collision with root package name */
    public static volatile KvSave f496a;

    public static KvSave a() {
        if (f496a == null) {
            synchronized (AppKv.class) {
                try {
                    if (f496a == null) {
                        f496a = KvSave.a("h5_tmp_kv_file", KvSave.PROGRESS_MODE.MULTI_PROGRESS_MODE);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f496a;
    }
}
