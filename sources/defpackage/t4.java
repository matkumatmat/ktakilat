package defpackage;

import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import java.io.File;
import java.io.FilenameFilter;

/* renamed from: t4  reason: default package */
public final /* synthetic */ class t4 implements FilenameFilter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f357a;

    public /* synthetic */ t4(int i) {
        this.f357a = i;
    }

    public final boolean accept(File file, String str) {
        switch (this.f357a) {
            case 0:
                return str.startsWith("event");
            default:
                return CrashlyticsReportPersistence.isNormalPriorityEventFile(file, str);
        }
    }
}
