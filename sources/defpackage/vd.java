package defpackage;

import com.google.android.gms.common.util.BiConsumer;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.Personalization;

/* renamed from: vd  reason: default package */
public final /* synthetic */ class vd implements BiConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Personalization f360a;

    public /* synthetic */ vd(Personalization personalization) {
        this.f360a = personalization;
    }

    public final void accept(Object obj, Object obj2) {
        this.f360a.logArmActive((String) obj, (ConfigContainer) obj2);
    }
}
