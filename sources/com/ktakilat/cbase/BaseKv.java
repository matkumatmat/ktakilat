package com.ktakilat.cbase;

import com.ktakilat.cbase.cache.KvSave;

public class BaseKv {

    /* renamed from: a  reason: collision with root package name */
    public static volatile KvSave f464a;

    public static KvSave a() {
        if (f464a == null) {
            synchronized (BaseKv.class) {
                try {
                    if (f464a == null) {
                        f464a = KvSave.a("base_kv_file", KvSave.PROGRESS_MODE.MULTI_PROGRESS_MODE);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f464a;
    }
}
