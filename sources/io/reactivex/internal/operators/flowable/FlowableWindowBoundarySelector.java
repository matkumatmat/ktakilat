package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableWindowBoundarySelector<T, B, V> extends AbstractFlowableWithUpstream<T, Flowable<T>> {

    public static final class OperatorWindowBoundaryCloseSubscriber<T, V> extends DisposableSubscriber<V> {
        public boolean d;

        public final void onComplete() {
            if (!this.d) {
                this.d = true;
                throw null;
            }
        }

        public final void onError(Throwable th) {
            if (this.d) {
                RxJavaPlugins.b(th);
            } else {
                this.d = true;
                throw null;
            }
        }

        public final void onNext(Object obj) {
            dispose();
            onComplete();
        }
    }

    public static final class OperatorWindowBoundaryOpenSubscriber<T, B> extends DisposableSubscriber<B> {
        public final WindowBoundaryMainSubscriber d;

        public OperatorWindowBoundaryOpenSubscriber(WindowBoundaryMainSubscriber windowBoundaryMainSubscriber) {
            this.d = windowBoundaryMainSubscriber;
        }

        public final void onComplete() {
            this.d.onComplete();
        }

        public final void onError(Throwable th) {
            WindowBoundaryMainSubscriber windowBoundaryMainSubscriber = this.d;
            windowBoundaryMainSubscriber.l.cancel();
            windowBoundaryMainSubscriber.k.dispose();
            DisposableHelper.dispose(windowBoundaryMainSubscriber.m);
            windowBoundaryMainSubscriber.e.onError(th);
        }

        public final void onNext(Object obj) {
            WindowBoundaryMainSubscriber windowBoundaryMainSubscriber = this.d;
            windowBoundaryMainSubscriber.getClass();
            windowBoundaryMainSubscriber.f.offer(new WindowOperation((UnicastProcessor) null, obj));
            if (windowBoundaryMainSubscriber.b()) {
                windowBoundaryMainSubscriber.i();
            }
        }
    }

    public static final class WindowBoundaryMainSubscriber<T, B, V> extends QueueDrainSubscriber<T, Object, Flowable<T>> implements Subscription {
        public final CompositeDisposable k;
        public Subscription l;
        public final AtomicReference m = new AtomicReference();
        public final ArrayList n;
        public final AtomicLong o;

        /* JADX WARNING: type inference failed for: r0v1, types: [io.reactivex.disposables.CompositeDisposable, java.lang.Object] */
        public WindowBoundaryMainSubscriber(SerializedSubscriber serializedSubscriber) {
            super(serializedSubscriber, new MpscLinkedQueue());
            AtomicLong atomicLong = new AtomicLong();
            this.o = atomicLong;
            this.k = new Object();
            this.n = new ArrayList();
            atomicLong.lazySet(1);
        }

        public final void cancel() {
            this.g = true;
        }

        public final void i() {
            boolean z;
            MpscLinkedQueue mpscLinkedQueue = this.f;
            SerializedSubscriber serializedSubscriber = this.e;
            ArrayList arrayList = this.n;
            int i = 1;
            while (true) {
                boolean z2 = this.i;
                Object poll = mpscLinkedQueue.poll();
                if (poll == null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z2 && z) {
                    this.k.dispose();
                    DisposableHelper.dispose(this.m);
                    Throwable th = this.j;
                    if (th != null) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ((UnicastProcessor) it.next()).onError(th);
                        }
                    } else {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            ((UnicastProcessor) it2.next()).onComplete();
                        }
                    }
                    arrayList.clear();
                    return;
                } else if (z) {
                    i = f(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (poll instanceof WindowOperation) {
                    WindowOperation windowOperation = (WindowOperation) poll;
                    UnicastProcessor unicastProcessor = windowOperation.f670a;
                    if (unicastProcessor != null) {
                        if (arrayList.remove(unicastProcessor)) {
                            windowOperation.f670a.onComplete();
                            if (this.o.decrementAndGet() == 0) {
                                this.k.dispose();
                                DisposableHelper.dispose(this.m);
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.g) {
                        UnicastProcessor unicastProcessor2 = new UnicastProcessor((Runnable) null, 0);
                        long h = h();
                        if (h != 0) {
                            arrayList.add(unicastProcessor2);
                            serializedSubscriber.onNext(unicastProcessor2);
                            if (h != LocationRequestCompat.PASSIVE_INTERVAL) {
                                g();
                            }
                            try {
                                throw null;
                            } catch (Throwable th2) {
                                this.g = true;
                                serializedSubscriber.onError(th2);
                            }
                        } else {
                            this.g = true;
                            serializedSubscriber.onError(new MissingBackpressureException("Could not deliver new window due to lack of requests"));
                        }
                    }
                } else {
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        ((UnicastProcessor) it3.next()).onNext(NotificationLite.getValue(poll));
                    }
                }
            }
        }

        public final void onComplete() {
            if (!this.i) {
                this.i = true;
                if (b()) {
                    i();
                }
                if (this.o.decrementAndGet() == 0) {
                    this.k.dispose();
                }
                this.e.onComplete();
            }
        }

        public final void onError(Throwable th) {
            if (this.i) {
                RxJavaPlugins.b(th);
                return;
            }
            this.j = th;
            this.i = true;
            if (b()) {
                i();
            }
            if (this.o.decrementAndGet() == 0) {
                this.k.dispose();
            }
            this.e.onError(th);
        }

        public final void onNext(Object obj) {
            if (!this.i) {
                if (d()) {
                    Iterator it = this.n.iterator();
                    while (it.hasNext()) {
                        ((UnicastProcessor) it.next()).onNext(obj);
                    }
                    if (f(-1) == 0) {
                        return;
                    }
                } else {
                    this.f.offer(NotificationLite.next(obj));
                    if (!b()) {
                        return;
                    }
                }
                i();
            }
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.l, subscription)) {
                this.l = subscription;
                this.e.onSubscribe(this);
                if (!this.g) {
                    OperatorWindowBoundaryOpenSubscriber operatorWindowBoundaryOpenSubscriber = new OperatorWindowBoundaryOpenSubscriber(this);
                    AtomicReference atomicReference = this.m;
                    while (!atomicReference.compareAndSet((Object) null, operatorWindowBoundaryOpenSubscriber)) {
                        if (atomicReference.get() != null) {
                            return;
                        }
                    }
                    this.o.getAndIncrement();
                    subscription.request(LocationRequestCompat.PASSIVE_INTERVAL);
                    throw null;
                }
            }
        }
    }

    public static final class WindowOperation<T, B> {

        /* renamed from: a  reason: collision with root package name */
        public final UnicastProcessor f670a;
        public final Object b;

        public WindowOperation(UnicastProcessor unicastProcessor, Object obj) {
            this.f670a = unicastProcessor;
            this.b = obj;
        }
    }

    public final void b(FlowableSubscriber flowableSubscriber) {
        this.d.a(new WindowBoundaryMainSubscriber(new SerializedSubscriber(flowableSubscriber)));
    }
}
