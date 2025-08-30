package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
final class SingletonImmutableSet<E> extends ImmutableSet<E> {
    final transient E element;

    public SingletonImmutableSet(E e) {
        this.element = Preconditions.checkNotNull(e);
    }

    public ImmutableList<E> asList() {
        return ImmutableList.of(this.element);
    }

    public boolean contains(@CheckForNull Object obj) {
        return this.element.equals(obj);
    }

    public int copyIntoArray(Object[] objArr, int i) {
        objArr[i] = this.element;
        return i + 1;
    }

    public final int hashCode() {
        return this.element.hashCode();
    }

    public boolean isPartialView() {
        return false;
    }

    public int size() {
        return 1;
    }

    public String toString() {
        String obj = this.element.toString();
        StringBuilder sb = new StringBuilder(ba.e(2, obj));
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }

    public UnmodifiableIterator<E> iterator() {
        return Iterators.singletonIterator(this.element);
    }
}
