package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002"}, d2 = {"kotlin/collections/AbstractMap$keys$1", "Lkotlin/collections/AbstractSet;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AbstractMap$keys$1 extends AbstractSet<Object> {
    public final /* synthetic */ AbstractMap d;

    public AbstractMap$keys$1(AbstractMap abstractMap) {
        this.d = abstractMap;
    }

    public final boolean contains(Object obj) {
        return this.d.containsKey(obj);
    }

    public final int getSize() {
        return this.d.size();
    }

    public final Iterator iterator() {
        return new AbstractMap$keys$1$iterator$1(this.d.a().iterator());
    }
}
