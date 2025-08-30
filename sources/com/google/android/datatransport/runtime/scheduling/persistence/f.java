package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.HashMap;

public final /* synthetic */ class f implements SQLiteEventStore.Function, SQLiteEventStore.Producer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f230a;
    public final /* synthetic */ Object b;

    public /* synthetic */ f(Object obj, int i) {
        this.f230a = i;
        this.b = obj;
    }

    public Object apply(Object obj) {
        return SQLiteEventStore.lambda$loadMetadata$16((HashMap) this.b, (Cursor) obj);
    }

    public Object produce() {
        switch (this.f230a) {
            case 1:
                return ((SQLiteDatabase) this.b).beginTransaction();
            default:
                return ((SchemaManager) this.b).getWritableDatabase();
        }
    }
}
