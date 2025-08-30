package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class c implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f227a;
    public final /* synthetic */ SQLiteEventStore b;
    public final /* synthetic */ Object c;

    public /* synthetic */ c(SQLiteEventStore sQLiteEventStore, Object obj, int i) {
        this.f227a = i;
        this.b = sQLiteEventStore;
        this.c = obj;
    }

    public final Object apply(Object obj) {
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        switch (this.f227a) {
            case 0:
                return this.b.lambda$hasPendingEventsFor$6((TransportContext) this.c, sQLiteDatabase);
            case 1:
                return this.b.lambda$loadBatch$8((TransportContext) this.c, sQLiteDatabase);
            default:
                return this.b.lambda$recordFailure$4((String) this.c, "SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name", sQLiteDatabase);
        }
    }
}
