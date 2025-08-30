package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class e implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f229a;
    public final /* synthetic */ SQLiteEventStore b;

    public /* synthetic */ e(SQLiteEventStore sQLiteEventStore, int i) {
        this.f229a = i;
        this.b = sQLiteEventStore;
    }

    public final Object apply(Object obj) {
        switch (this.f229a) {
            case 0:
                return this.b.lambda$resetClientMetrics$23((SQLiteDatabase) obj);
            case 1:
                return this.b.lambda$cleanUp$11((Cursor) obj);
            default:
                return this.b.lambda$recordFailure$3((Cursor) obj);
        }
    }
}
