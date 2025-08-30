package defpackage;

import android.location.GnssMeasurementsEvent;
import android.os.LocaleList;
import java.util.StringJoiner;
import java.util.concurrent.locks.StampedLock;
import java.util.function.Supplier;

/* renamed from: v9  reason: default package */
public abstract /* synthetic */ class v9 {
    public static /* bridge */ /* synthetic */ GnssMeasurementsEvent.Callback g(Object obj) {
        return (GnssMeasurementsEvent.Callback) obj;
    }

    public static /* bridge */ /* synthetic */ LocaleList i(Object obj) {
        return (LocaleList) obj;
    }

    public static /* bridge */ /* synthetic */ Class j() {
        return GnssMeasurementsEvent.Callback.class;
    }

    public static /* synthetic */ StringJoiner o() {
        return new StringJoiner(", ", " conversion category (one of: ", ")");
    }

    public static /* synthetic */ StampedLock q() {
        return new StampedLock();
    }

    public static /* bridge */ /* synthetic */ Supplier r(Object obj) {
        return (Supplier) obj;
    }
}
