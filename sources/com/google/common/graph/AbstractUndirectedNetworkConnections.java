package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class AbstractUndirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {
    final Map<E, N> incidentEdgeMap;

    public AbstractUndirectedNetworkConnections(Map<E, N> map) {
        this.incidentEdgeMap = (Map) Preconditions.checkNotNull(map);
    }

    public void addInEdge(E e, N n, boolean z) {
        if (!z) {
            addOutEdge(e, n);
        }
    }

    public void addOutEdge(E e, N n) {
        boolean z;
        if (this.incidentEdgeMap.put(e, n) == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
    }

    public N adjacentNode(E e) {
        N n = this.incidentEdgeMap.get(e);
        Objects.requireNonNull(n);
        return n;
    }

    public Set<E> inEdges() {
        return incidentEdges();
    }

    public Set<E> incidentEdges() {
        return Collections.unmodifiableSet(this.incidentEdgeMap.keySet());
    }

    public Set<E> outEdges() {
        return incidentEdges();
    }

    public Set<N> predecessors() {
        return adjacentNodes();
    }

    @CheckForNull
    public N removeInEdge(E e, boolean z) {
        if (!z) {
            return removeOutEdge(e);
        }
        return null;
    }

    public N removeOutEdge(E e) {
        N remove = this.incidentEdgeMap.remove(e);
        Objects.requireNonNull(remove);
        return remove;
    }

    public Set<N> successors() {
        return adjacentNodes();
    }
}
