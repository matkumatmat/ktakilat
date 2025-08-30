package io.reactivex.internal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.atomic.AtomicInteger;

public final class VolatileSizeArrayList<T> extends AtomicInteger implements List<T>, RandomAccess {
    private static final long serialVersionUID = 3972397474470203923L;
    public final ArrayList c;

    public VolatileSizeArrayList() {
        this.c = new ArrayList();
    }

    public boolean add(T t) {
        ArrayList arrayList = this.c;
        boolean add = arrayList.add(t);
        lazySet(arrayList.size());
        return add;
    }

    public boolean addAll(Collection<? extends T> collection) {
        ArrayList arrayList = this.c;
        boolean addAll = arrayList.addAll(collection);
        lazySet(arrayList.size());
        return addAll;
    }

    public void clear() {
        this.c.clear();
        lazySet(0);
    }

    public boolean contains(Object obj) {
        return this.c.contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return this.c.containsAll(collection);
    }

    public boolean equals(Object obj) {
        boolean z = obj instanceof VolatileSizeArrayList;
        ArrayList arrayList = this.c;
        if (z) {
            return arrayList.equals(((VolatileSizeArrayList) obj).c);
        }
        return arrayList.equals(obj);
    }

    public T get(int i) {
        return this.c.get(i);
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public int indexOf(Object obj) {
        return this.c.indexOf(obj);
    }

    public boolean isEmpty() {
        if (get() == 0) {
            return true;
        }
        return false;
    }

    public Iterator<T> iterator() {
        return this.c.iterator();
    }

    public int lastIndexOf(Object obj) {
        return this.c.lastIndexOf(obj);
    }

    public ListIterator<T> listIterator() {
        return this.c.listIterator();
    }

    public boolean remove(Object obj) {
        ArrayList arrayList = this.c;
        boolean remove = arrayList.remove(obj);
        lazySet(arrayList.size());
        return remove;
    }

    public boolean removeAll(Collection<?> collection) {
        ArrayList arrayList = this.c;
        boolean removeAll = arrayList.removeAll(collection);
        lazySet(arrayList.size());
        return removeAll;
    }

    public boolean retainAll(Collection<?> collection) {
        ArrayList arrayList = this.c;
        boolean retainAll = arrayList.retainAll(collection);
        lazySet(arrayList.size());
        return retainAll;
    }

    public T set(int i, T t) {
        return this.c.set(i, t);
    }

    public int size() {
        return get();
    }

    public List<T> subList(int i, int i2) {
        return this.c.subList(i, i2);
    }

    public Object[] toArray() {
        return this.c.toArray();
    }

    public String toString() {
        return this.c.toString();
    }

    public ListIterator<T> listIterator(int i) {
        return this.c.listIterator(i);
    }

    public <E> E[] toArray(E[] eArr) {
        return this.c.toArray(eArr);
    }

    public VolatileSizeArrayList(int i) {
        this.c = new ArrayList(i);
    }

    public void add(int i, T t) {
        ArrayList arrayList = this.c;
        arrayList.add(i, t);
        lazySet(arrayList.size());
    }

    public boolean addAll(int i, Collection<? extends T> collection) {
        ArrayList arrayList = this.c;
        boolean addAll = arrayList.addAll(i, collection);
        lazySet(arrayList.size());
        return addAll;
    }

    public T remove(int i) {
        ArrayList arrayList = this.c;
        T remove = arrayList.remove(i);
        lazySet(arrayList.size());
        return remove;
    }
}
