package defpackage;

import androidx.camera.core.impl.Config;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import java.io.File;
import java.util.Comparator;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.uuid.Uuid;

/* renamed from: g0  reason: default package */
public final /* synthetic */ class g0 implements Comparator {
    public final /* synthetic */ int c;

    public /* synthetic */ g0(int i) {
        this.c = i;
    }

    public final int compare(Object obj, Object obj2) {
        switch (this.c) {
            case 0:
                return ((Comparable) obj).compareTo((Comparable) obj2);
            case 1:
                return ((File) obj2).getName().compareTo(((File) obj).getName());
            case 2:
                return CrashlyticsReportPersistence.oldestEventFileFirst((File) obj, (File) obj2);
            case 3:
                return ((Config.Option) obj).getId().compareTo(((Config.Option) obj2).getId());
            case 4:
                return ((CrashlyticsReport.CustomAttribute) obj).getKey().compareTo(((CrashlyticsReport.CustomAttribute) obj2).getKey());
            case 5:
                return ((Double) obj).compareTo((Double) obj2);
            default:
                Uuid uuid = (Uuid) obj;
                Uuid uuid2 = (Uuid) obj2;
                Uuid.Companion companion = Uuid.Companion;
                Intrinsics.checkNotNullParameter(uuid, "a");
                Intrinsics.checkNotNullParameter(uuid2, "b");
                long j = uuid.c;
                long j2 = uuid2.c;
                if (j != j2) {
                    ULong.Companion companion2 = ULong.d;
                    return Long.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
                }
                ULong.Companion companion3 = ULong.d;
                return Long.compare(uuid.d ^ Long.MIN_VALUE, uuid2.d ^ Long.MIN_VALUE);
        }
    }
}
