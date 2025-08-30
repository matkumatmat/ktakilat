package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class d implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f228a = 0;
    public final /* synthetic */ long b;
    public final /* synthetic */ Object c;

    public /* synthetic */ d(TransportContext transportContext, long j) {
        this.b = j;
        this.c = transportContext;
    }

    public final Object apply(Object obj) {
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        switch (this.f228a) {
            case 0:
                return SQLiteEventStore.lambda$recordNextCallTime$7(this.b, (TransportContext) this.c, sQLiteDatabase);
            default:
                return ((SQLiteEventStore) this.c).lambda$cleanUp$12(this.b, sQLiteDatabase);
        }
    }

    public /* synthetic */ d(SQLiteEventStore sQLiteEventStore, long j) {
        this.c = sQLiteEventStore;
        this.b = j;
    }
}
