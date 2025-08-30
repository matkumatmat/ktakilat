package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class h implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f232a;
    public final /* synthetic */ long b;

    public /* synthetic */ h(long j, int i) {
        this.f232a = i;
        this.b = j;
    }

    public final Object apply(Object obj) {
        switch (this.f232a) {
            case 0:
                return SQLiteEventStore.lambda$getTimeWindow$22(this.b, (SQLiteDatabase) obj);
            default:
                return ((Cursor) obj).moveToNext();
        }
    }
}
