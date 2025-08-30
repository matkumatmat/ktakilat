package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class zzkt extends AbstractList implements zzmn {
    private boolean zza;

    public zzkt(boolean z) {
        this.zza = z;
    }

    public void add(int i, Object obj) {
        zzcF();
        super.add(i, obj);
    }

    public final boolean addAll(int i, Collection collection) {
        zzcF();
        return super.addAll(i, collection);
    }

    public final void clear() {
        zzcF();
        super.clear();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public Object remove(int i) {
        zzcF();
        return super.remove(i);
    }

    public final boolean removeAll(Collection collection) {
        zzcF();
        return super.removeAll(collection);
    }

    public final boolean retainAll(Collection collection) {
        zzcF();
        return super.retainAll(collection);
    }

    public Object set(int i, Object obj) {
        zzcF();
        return super.set(i, obj);
    }

    public final boolean zza() {
        return this.zza;
    }

    public final void zzb() {
        if (this.zza) {
            this.zza = false;
        }
    }

    public final void zzcF() {
        if (!this.zza) {
            throw new UnsupportedOperationException();
        }
    }

    public boolean add(Object obj) {
        zzcF();
        return super.add(obj);
    }

    public boolean addAll(Collection collection) {
        zzcF();
        return super.addAll(collection);
    }

    public final boolean remove(Object obj) {
        zzcF();
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }
}
