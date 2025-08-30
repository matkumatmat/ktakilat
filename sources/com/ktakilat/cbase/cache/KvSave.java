package com.ktakilat.cbase.cache;

import com.tencent.mmkv.MMKV;

public class KvSave {

    /* renamed from: a  reason: collision with root package name */
    public final MMKV f465a;

    public enum PROGRESS_MODE {
    }

    public KvSave(MMKV mmkv) {
        this.f465a = mmkv;
    }

    public static KvSave a(String str, PROGRESS_MODE progress_mode) {
        if (progress_mode == PROGRESS_MODE.SINGLE_PROGRESS_MODE) {
            return new KvSave(MMKV.d(1, str));
        }
        return new KvSave(MMKV.d(2, str));
    }

    public final void b(String str, String str2) {
        this.f465a.putString(str, str2);
    }
}
