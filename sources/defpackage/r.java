package defpackage;

import android.adservices.adid.AdId;
import android.adservices.adid.AdIdManager;
import android.adservices.adselection.AdSelectionConfig;
import android.adservices.adselection.AdSelectionManager;
import android.adservices.adselection.AdSelectionOutcome;
import android.adservices.common.AdData;

/* renamed from: r  reason: default package */
public abstract /* synthetic */ class r {
    public static /* bridge */ /* synthetic */ Class D() {
        return AdSelectionManager.class;
    }

    public static /* bridge */ /* synthetic */ AdId b(Object obj) {
        return (AdId) obj;
    }

    public static /* bridge */ /* synthetic */ AdIdManager d(Object obj) {
        return (AdIdManager) obj;
    }

    public static /* synthetic */ AdSelectionConfig.Builder e() {
        return new AdSelectionConfig.Builder();
    }

    public static /* bridge */ /* synthetic */ AdSelectionManager m(Object obj) {
        return (AdSelectionManager) obj;
    }

    public static /* bridge */ /* synthetic */ AdSelectionOutcome n(Object obj) {
        return (AdSelectionOutcome) obj;
    }

    public static /* synthetic */ AdData.Builder o() {
        return new AdData.Builder();
    }

    public static /* bridge */ /* synthetic */ Class u() {
        return AdIdManager.class;
    }

    public static /* bridge */ /* synthetic */ void z(Object obj) {
        AdSelectionManager adSelectionManager = (AdSelectionManager) obj;
    }
}
