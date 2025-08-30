package defpackage;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.net.MediaType;
import java.util.Collection;
import java.util.Map;

/* renamed from: nc  reason: default package */
public final /* synthetic */ class nc implements Function {
    public final /* synthetic */ int c;

    public /* synthetic */ nc(int i) {
        this.c = i;
    }

    public final Object apply(Object obj) {
        switch (this.c) {
            case 0:
                return MediaType.lambda$computeToString$0((String) obj);
            case 1:
                return ImmutableMultiset.copyOf((Collection) obj);
            default:
                return ((Map) obj).keySet().iterator();
        }
    }
}
