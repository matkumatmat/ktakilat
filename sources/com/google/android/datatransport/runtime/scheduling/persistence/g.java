package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

public final /* synthetic */ class g implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f231a;
    public final /* synthetic */ LogEventDropped.Reason b;
    public final /* synthetic */ long c;

    public /* synthetic */ g(long j, LogEventDropped.Reason reason, String str) {
        this.f231a = str;
        this.b = reason;
        this.c = j;
    }

    public final Object apply(Object obj) {
        return SQLiteEventStore.lambda$recordLogEventDropped$18(this.f231a, this.b, this.c, (SQLiteDatabase) obj);
    }
}
