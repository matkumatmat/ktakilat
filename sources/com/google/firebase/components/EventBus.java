package com.google.firebase.components;

import androidx.annotation.GuardedBy;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

class EventBus implements Subscriber, Publisher {
    private final Executor defaultExecutor;
    @GuardedBy("this")
    private final Map<Class<?>, ConcurrentHashMap<EventHandler<Object>, Executor>> handlerMap = new HashMap();
    @GuardedBy("this")
    private Queue<Event<?>> pendingEvents = new ArrayDeque();

    public EventBus(Executor executor) {
        this.defaultExecutor = executor;
    }

    private synchronized Set<Map.Entry<EventHandler<Object>, Executor>> getHandlers(Event<?> event) {
        Set<Map.Entry<EventHandler<Object>, Executor>> set;
        try {
            Map map = this.handlerMap.get(event.getType());
            if (map == null) {
                set = Collections.emptySet();
            } else {
                set = map.entrySet();
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return set;
    }

    public void enablePublishingAndFlushPending() {
        Queue<Event<?>> queue;
        synchronized (this) {
            try {
                queue = this.pendingEvents;
                if (queue != null) {
                    this.pendingEvents = null;
                } else {
                    queue = null;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (queue != null) {
            for (Event<?> publish : queue) {
                publish(publish);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0010, code lost:
        r0 = getHandlers(r6).iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
        if (r0.hasNext() == false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001e, code lost:
        r1 = r0.next();
        ((java.util.concurrent.Executor) r1.getValue()).execute(new com.google.firebase.components.a(2, r1, r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void publish(com.google.firebase.events.Event<?> r6) {
        /*
            r5 = this;
            com.google.firebase.components.Preconditions.checkNotNull(r6)
            monitor-enter(r5)
            java.util.Queue<com.google.firebase.events.Event<?>> r0 = r5.pendingEvents     // Catch:{ all -> 0x000d }
            if (r0 == 0) goto L_0x000f
            r0.add(r6)     // Catch:{ all -> 0x000d }
            monitor-exit(r5)     // Catch:{ all -> 0x000d }
            return
        L_0x000d:
            r6 = move-exception
            goto L_0x0035
        L_0x000f:
            monitor-exit(r5)     // Catch:{ all -> 0x000d }
            java.util.Set r0 = r5.getHandlers(r6)
            java.util.Iterator r0 = r0.iterator()
        L_0x0018:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0034
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getValue()
            java.util.concurrent.Executor r2 = (java.util.concurrent.Executor) r2
            com.google.firebase.components.a r3 = new com.google.firebase.components.a
            r4 = 2
            r3.<init>(r4, r1, r6)
            r2.execute(r3)
            goto L_0x0018
        L_0x0034:
            return
        L_0x0035:
            monitor-exit(r5)     // Catch:{ all -> 0x000d }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.components.EventBus.publish(com.google.firebase.events.Event):void");
    }

    public synchronized <T> void subscribe(Class<T> cls, Executor executor, EventHandler<? super T> eventHandler) {
        try {
            Preconditions.checkNotNull(cls);
            Preconditions.checkNotNull(eventHandler);
            Preconditions.checkNotNull(executor);
            if (!this.handlerMap.containsKey(cls)) {
                this.handlerMap.put(cls, new ConcurrentHashMap());
            }
            this.handlerMap.get(cls).put(eventHandler, executor);
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized <T> void unsubscribe(java.lang.Class<T> r2, com.google.firebase.events.EventHandler<? super T> r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            com.google.firebase.components.Preconditions.checkNotNull(r2)     // Catch:{ all -> 0x0028 }
            com.google.firebase.components.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x0028 }
            java.util.Map<java.lang.Class<?>, java.util.concurrent.ConcurrentHashMap<com.google.firebase.events.EventHandler<java.lang.Object>, java.util.concurrent.Executor>> r0 = r1.handlerMap     // Catch:{ all -> 0x0028 }
            boolean r0 = r0.containsKey(r2)     // Catch:{ all -> 0x0028 }
            if (r0 != 0) goto L_0x0011
            monitor-exit(r1)
            return
        L_0x0011:
            java.util.Map<java.lang.Class<?>, java.util.concurrent.ConcurrentHashMap<com.google.firebase.events.EventHandler<java.lang.Object>, java.util.concurrent.Executor>> r0 = r1.handlerMap     // Catch:{ all -> 0x0028 }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x0028 }
            java.util.concurrent.ConcurrentHashMap r0 = (java.util.concurrent.ConcurrentHashMap) r0     // Catch:{ all -> 0x0028 }
            r0.remove(r3)     // Catch:{ all -> 0x0028 }
            boolean r3 = r0.isEmpty()     // Catch:{ all -> 0x0028 }
            if (r3 == 0) goto L_0x002a
            java.util.Map<java.lang.Class<?>, java.util.concurrent.ConcurrentHashMap<com.google.firebase.events.EventHandler<java.lang.Object>, java.util.concurrent.Executor>> r3 = r1.handlerMap     // Catch:{ all -> 0x0028 }
            r3.remove(r2)     // Catch:{ all -> 0x0028 }
            goto L_0x002a
        L_0x0028:
            r2 = move-exception
            goto L_0x002c
        L_0x002a:
            monitor-exit(r1)
            return
        L_0x002c:
            monitor-exit(r1)     // Catch:{ all -> 0x0028 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.components.EventBus.unsubscribe(java.lang.Class, com.google.firebase.events.EventHandler):void");
    }

    public <T> void subscribe(Class<T> cls, EventHandler<? super T> eventHandler) {
        subscribe(cls, this.defaultExecutor, eventHandler);
    }
}
