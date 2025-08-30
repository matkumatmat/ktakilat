package defpackage;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* renamed from: m3  reason: default package */
public final /* synthetic */ class m3 implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f351a;
    public final /* synthetic */ Object b;

    public /* synthetic */ m3(Object obj, int i) {
        this.f351a = i;
        this.b = obj;
    }

    public final Object create(ComponentContainer componentContainer) {
        switch (this.f351a) {
            case 0:
                return Component.lambda$of$2(this.b, componentContainer);
            case 1:
                return Component.lambda$intoSet$4(this.b, componentContainer);
            case 2:
                return Component.lambda$intoSet$3(this.b, componentContainer);
            case 3:
                return Component.lambda$of$0(this.b, componentContainer);
            default:
                return Component.lambda$of$1(this.b, componentContainer);
        }
    }
}
