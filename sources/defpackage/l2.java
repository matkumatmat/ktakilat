package defpackage;

import androidx.camera.core.CameraFilter;
import androidx.camera.core.impl.CameraFilters;
import androidx.camera.core.impl.Identifier;
import java.util.Collections;
import java.util.List;

/* renamed from: l2  reason: default package */
public final /* synthetic */ class l2 implements CameraFilter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f204a;

    public /* synthetic */ l2(int i) {
        this.f204a = i;
    }

    public final List filter(List list) {
        switch (this.f204a) {
            case 0:
                return CameraFilters.lambda$static$0(list);
            default:
                return Collections.emptyList();
        }
    }

    public final /* synthetic */ Identifier getIdentifier() {
        switch (this.f204a) {
            case 0:
                return k2.a(this);
            default:
                return k2.a(this);
        }
    }
}
