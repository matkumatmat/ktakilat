package defpackage;

import kotlin.jvm.functions.Function0;
import kotlin.text.Regex;

/* renamed from: qd  reason: default package */
public final /* synthetic */ class qd implements Function0 {
    public final /* synthetic */ Regex c;
    public final /* synthetic */ CharSequence d;
    public final /* synthetic */ int e;

    public /* synthetic */ qd(Regex regex, CharSequence charSequence, int i) {
        this.c = regex;
        this.d = charSequence;
        this.e = i;
    }

    public final Object invoke() {
        Regex.Companion companion = Regex.Companion;
        return this.c.find(this.d, this.e);
    }
}
