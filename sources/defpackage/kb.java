package defpackage;

import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;

/* renamed from: kb  reason: default package */
public final /* synthetic */ class kb implements ValueEncoder {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f350a;

    public /* synthetic */ kb(int i) {
        this.f350a = i;
    }

    public final void encode(Object obj, Object obj2) {
        switch (this.f350a) {
            case 0:
                ((ValueEncoderContext) obj2).add((String) obj);
                return;
            default:
                ((ValueEncoderContext) obj2).add(((Boolean) obj).booleanValue());
                return;
        }
    }
}
