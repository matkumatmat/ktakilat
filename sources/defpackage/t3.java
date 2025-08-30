package defpackage;

import android.content.Context;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.tracing.ComponentMonitor;

/* renamed from: t3  reason: default package */
public final /* synthetic */ class t3 implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f356a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Object c;

    public /* synthetic */ t3(Object obj, String str, int i) {
        this.f356a = i;
        this.b = str;
        this.c = obj;
    }

    public final Object create(ComponentContainer componentContainer) {
        switch (this.f356a) {
            case 0:
                return ComponentMonitor.lambda$processRegistrar$0(this.b, (Component) this.c, componentContainer);
            default:
                return LibraryVersion.create(this.b, ((LibraryVersionComponent.VersionExtractor) this.c).extract((Context) componentContainer.get(Context.class)));
        }
    }
}
