package defpackage;

import java.lang.reflect.Method;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Consumer;
import org.apache.commons.lang3.reflect.MethodUtils;

/* renamed from: sc  reason: default package */
public final /* synthetic */ class sc implements Consumer {
    public final /* synthetic */ Class[] c;
    public final /* synthetic */ TreeMap d;

    public /* synthetic */ sc(Class[] clsArr, TreeMap treeMap) {
        this.c = clsArr;
        this.d = treeMap;
    }

    public final void accept(Object obj) {
        ((List) this.d.computeIfAbsent(Integer.valueOf(MethodUtils.distance(this.c, ((Method) obj).getParameterTypes())), new jc(13))).add((Method) obj);
    }
}
