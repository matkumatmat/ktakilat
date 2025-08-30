package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final /* synthetic */ class a implements SQLiteEventStore.Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f225a;
    public final /* synthetic */ SQLiteEventStore b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ a(SQLiteEventStore sQLiteEventStore, Object obj, Object obj2, int i) {
        this.f225a = i;
        this.b = sQLiteEventStore;
        this.c = obj;
        this.d = obj2;
    }

    public final Object apply(Object obj) {
        switch (this.f225a) {
            case 0:
                HashMap hashMap = (HashMap) this.c;
                return this.b.lambda$loadClientMetrics$20("SELECT log_source, reason, events_dropped_count FROM log_event_dropped", hashMap, (ClientMetrics.Builder) this.d, (SQLiteDatabase) obj);
            case 1:
                ArrayList arrayList = (ArrayList) this.c;
                return this.b.lambda$loadEvents$14(arrayList, (TransportContext) this.d, (Cursor) obj);
            case 2:
                return this.b.lambda$persist$1((EventInternal) this.c, (TransportContext) this.d, (SQLiteDatabase) obj);
            default:
                return this.b.lambda$loadClientMetrics$19((Map) this.c, (ClientMetrics.Builder) this.d, (Cursor) obj);
        }
    }
}
