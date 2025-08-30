package defpackage;

import androidx.emoji2.text.flatbuffer.Utf8Old;
import java.util.ArrayList;
import java.util.function.Supplier;

/* renamed from: if  reason: invalid class name and default package */
public final /* synthetic */ class Cif implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f655a;

    public /* synthetic */ Cif(int i) {
        this.f655a = i;
    }

    public final Object get() {
        switch (this.f655a) {
            case 0:
                return new ArrayList();
            default:
                return Utf8Old.lambda$static$0();
        }
    }
}
