package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingNavigableSet<E> extends ForwardingSortedSet<E> implements NavigableSet<E> {

    @Beta
    public class StandardDescendingSet extends Sets.DescendingSet<E> {
        public StandardDescendingSet(ForwardingNavigableSet forwardingNavigableSet) {
            super(forwardingNavigableSet);
        }
    }

    @CheckForNull
    public E ceiling(@ParametricNullness E e) {
        return delegate().ceiling(e);
    }

    public abstract NavigableSet<E> delegate();

    public Iterator<E> descendingIterator() {
        return delegate().descendingIterator();
    }

    public NavigableSet<E> descendingSet() {
        return delegate().descendingSet();
    }

    @CheckForNull
    public E floor(@ParametricNullness E e) {
        return delegate().floor(e);
    }

    public NavigableSet<E> headSet(@ParametricNullness E e, boolean z) {
        return delegate().headSet(e, z);
    }

    @CheckForNull
    public E higher(@ParametricNullness E e) {
        return delegate().higher(e);
    }

    @CheckForNull
    public E lower(@ParametricNullness E e) {
        return delegate().lower(e);
    }

    @CheckForNull
    public E pollFirst() {
        return delegate().pollFirst();
    }

    @CheckForNull
    public E pollLast() {
        return delegate().pollLast();
    }

    @CheckForNull
    public E standardCeiling(@ParametricNullness E e) {
        return Iterators.getNext(tailSet(e, true).iterator(), null);
    }

    @ParametricNullness
    public E standardFirst() {
        return iterator().next();
    }

    @CheckForNull
    public E standardFloor(@ParametricNullness E e) {
        return Iterators.getNext(headSet(e, true).descendingIterator(), null);
    }

    public SortedSet<E> standardHeadSet(@ParametricNullness E e) {
        return headSet(e, false);
    }

    @CheckForNull
    public E standardHigher(@ParametricNullness E e) {
        return Iterators.getNext(tailSet(e, false).iterator(), null);
    }

    @ParametricNullness
    public E standardLast() {
        return descendingIterator().next();
    }

    @CheckForNull
    public E standardLower(@ParametricNullness E e) {
        return Iterators.getNext(headSet(e, false).descendingIterator(), null);
    }

    @CheckForNull
    public E standardPollFirst() {
        return Iterators.pollNext(iterator());
    }

    @CheckForNull
    public E standardPollLast() {
        return Iterators.pollNext(descendingIterator());
    }

    @Beta
    public NavigableSet<E> standardSubSet(@ParametricNullness E e, boolean z, @ParametricNullness E e2, boolean z2) {
        return tailSet(e, z).headSet(e2, z2);
    }

    public SortedSet<E> standardTailSet(@ParametricNullness E e) {
        return tailSet(e, true);
    }

    public NavigableSet<E> subSet(@ParametricNullness E e, boolean z, @ParametricNullness E e2, boolean z2) {
        return delegate().subSet(e, z, e2, z2);
    }

    public NavigableSet<E> tailSet(@ParametricNullness E e, boolean z) {
        return delegate().tailSet(e, z);
    }

    public SortedSet<E> standardSubSet(@ParametricNullness E e, @ParametricNullness E e2) {
        return subSet(e, true, e2, false);
    }
}
