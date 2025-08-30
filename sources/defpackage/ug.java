package defpackage;

import java.util.function.Supplier;

/* renamed from: ug  reason: default package */
public final /* synthetic */ class ug implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f842a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Object[] c;

    public /* synthetic */ ug(String str, int i, Object[] objArr) {
        this.f842a = i;
        this.b = str;
        this.c = objArr;
    }

    public final Object get() {
        switch (this.f842a) {
            case 0:
                return String.format(this.b, this.c);
            case 1:
                return String.format(this.b, this.c);
            case 2:
                return String.format(this.b, this.c);
            case 3:
                return String.format(this.b, this.c);
            case 4:
                return String.format(this.b, this.c);
            default:
                return String.format(this.b, this.c);
        }
    }
}
