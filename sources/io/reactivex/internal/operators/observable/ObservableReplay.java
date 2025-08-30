package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableReplay<T> extends ConnectableObservable<T> implements HasUpstreamObservableSource<T>, Disposable {
    public static final UnBoundedFactory g = new Object();
    public final Observable c;
    public final AtomicReference d;
    public final BufferSupplier e;
    public final ObservableSource f;

    public static abstract class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        public Node c;
        public int d;

        public BoundedReplayBuffer() {
            Node node = new Node((Object) null);
            this.c = node;
            set(node);
        }

        public final void a(InnerDisposable innerDisposable) {
            if (innerDisposable.getAndIncrement() == 0) {
                int i = 1;
                do {
                    Node node = (Node) innerDisposable.e;
                    if (node == null) {
                        node = c();
                        innerDisposable.e = node;
                    }
                    while (!innerDisposable.f) {
                        Node node2 = (Node) node.get();
                        if (node2 == null) {
                            innerDisposable.e = node;
                            i = innerDisposable.addAndGet(-i);
                        } else if (NotificationLite.accept(d(node2.c), innerDisposable.d)) {
                            innerDisposable.e = null;
                            return;
                        } else {
                            node = node2;
                        }
                    }
                    return;
                } while (i != 0);
            }
        }

        public Object b(Object obj) {
            return obj;
        }

        public Node c() {
            return (Node) get();
        }

        public final void complete() {
            Node node = new Node(b(NotificationLite.complete()));
            this.c.set(node);
            this.c = node;
            this.d++;
            f();
        }

        public Object d(Object obj) {
            return obj;
        }

        public abstract void e();

        public final void error(Throwable th) {
            Node node = new Node(b(NotificationLite.error(th)));
            this.c.set(node);
            this.c = node;
            this.d++;
            f();
        }

        public void f() {
            Node node = (Node) get();
            if (node.c != null) {
                Node node2 = new Node((Object) null);
                node2.lazySet(node.get());
                set(node2);
            }
        }

        public final void next(Object obj) {
            Node node = new Node(b(NotificationLite.next(obj)));
            this.c.set(node);
            this.c = node;
            this.d++;
            e();
        }
    }

    public interface BufferSupplier<T> {
        ReplayBuffer call();
    }

    public static final class DisposeConsumer<R> implements Consumer<Disposable> {
        public final ObserverResourceWrapper c;

        public DisposeConsumer(ObserverResourceWrapper observerResourceWrapper) {
            this.c = observerResourceWrapper;
        }

        public final void accept(Object obj) {
            this.c.setResource((Disposable) obj);
        }
    }

    public static final class InnerDisposable<T> extends AtomicInteger implements Disposable {
        private static final long serialVersionUID = 2728361546769921047L;
        public final ReplayObserver c;
        public final Observer d;
        public Serializable e;
        public volatile boolean f;

        public InnerDisposable(ReplayObserver replayObserver, Observer observer) {
            this.c = replayObserver;
            this.d = observer;
        }

        public final void dispose() {
            if (!this.f) {
                this.f = true;
                this.c.a(this);
            }
        }

        public final boolean isDisposed() {
            return this.f;
        }
    }

    public static final class MulticastReplay<R, U> extends Observable<R> {
        public final Callable c;
        public final Function d;

        public MulticastReplay(Function function, Callable callable) {
            this.c = callable;
            this.d = function;
        }

        public final void subscribeActual(Observer observer) {
            try {
                Object call = this.c.call();
                ObjectHelper.b(call, "The connectableFactory returned a null ConnectableObservable");
                ConnectableObservable connectableObservable = (ConnectableObservable) call;
                Object apply = this.d.apply(connectableObservable);
                ObjectHelper.b(apply, "The selector returned a null ObservableSource");
                ObservableSource observableSource = (ObservableSource) apply;
                ObserverResourceWrapper observerResourceWrapper = new ObserverResourceWrapper(observer);
                observableSource.subscribe(observerResourceWrapper);
                connectableObservable.c(new DisposeConsumer(observerResourceWrapper));
            } catch (Throwable th) {
                Exceptions.a(th);
                EmptyDisposable.error(th, (Observer<?>) observer);
            }
        }
    }

    public static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        public final Object c;

        public Node(Object obj) {
            this.c = obj;
        }
    }

    public static final class Replay<T> extends ConnectableObservable<T> {
        public final ConnectableObservable c;
        public final Observable d;

        public Replay(ConnectableObservable connectableObservable, Observable observable) {
            this.c = connectableObservable;
            this.d = observable;
        }

        public final void c(Consumer consumer) {
            this.c.c(consumer);
        }

        public final void subscribeActual(Observer observer) {
            this.d.subscribe(observer);
        }
    }

    public interface ReplayBuffer<T> {
        void a(InnerDisposable innerDisposable);

        void complete();

        void error(Throwable th);

        void next(Object obj);
    }

    public static final class ReplayBufferSupplier<T> implements BufferSupplier<T> {

        /* renamed from: a  reason: collision with root package name */
        public final int f672a;

        public ReplayBufferSupplier(int i) {
            this.f672a = i;
        }

        public final ReplayBuffer call() {
            return new SizeBoundReplayBuffer(this.f672a);
        }
    }

    public static final class ReplayObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
        public static final InnerDisposable[] g = new InnerDisposable[0];
        public static final InnerDisposable[] i = new InnerDisposable[0];
        private static final long serialVersionUID = -533785617179540163L;
        public final ReplayBuffer c;
        public boolean d;
        public final AtomicReference e = new AtomicReference(g);
        public final AtomicBoolean f = new AtomicBoolean();

        public ReplayObserver(ReplayBuffer replayBuffer) {
            this.c = replayBuffer;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: io.reactivex.internal.operators.observable.ObservableReplay$InnerDisposable[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: io.reactivex.internal.operators.observable.ObservableReplay$InnerDisposable} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(io.reactivex.internal.operators.observable.ObservableReplay.InnerDisposable r8) {
            /*
                r7 = this;
            L_0x0000:
                java.util.concurrent.atomic.AtomicReference r0 = r7.e
                java.lang.Object r1 = r0.get()
                io.reactivex.internal.operators.observable.ObservableReplay$InnerDisposable[] r1 = (io.reactivex.internal.operators.observable.ObservableReplay.InnerDisposable[]) r1
                int r2 = r1.length
                if (r2 != 0) goto L_0x000c
                return
            L_0x000c:
                r3 = 0
                r4 = 0
            L_0x000e:
                if (r4 >= r2) goto L_0x001c
                r5 = r1[r4]
                boolean r5 = r5.equals(r8)
                if (r5 == 0) goto L_0x0019
                goto L_0x001d
            L_0x0019:
                int r4 = r4 + 1
                goto L_0x000e
            L_0x001c:
                r4 = -1
            L_0x001d:
                if (r4 >= 0) goto L_0x0020
                return
            L_0x0020:
                r5 = 1
                if (r2 != r5) goto L_0x0026
                io.reactivex.internal.operators.observable.ObservableReplay$InnerDisposable[] r2 = g
                goto L_0x0035
            L_0x0026:
                int r6 = r2 + -1
                io.reactivex.internal.operators.observable.ObservableReplay$InnerDisposable[] r6 = new io.reactivex.internal.operators.observable.ObservableReplay.InnerDisposable[r6]
                java.lang.System.arraycopy(r1, r3, r6, r3, r4)
                int r3 = r4 + 1
                int r2 = r2 - r4
                int r2 = r2 - r5
                java.lang.System.arraycopy(r1, r3, r6, r4, r2)
                r2 = r6
            L_0x0035:
                boolean r3 = r0.compareAndSet(r1, r2)
                if (r3 == 0) goto L_0x003c
                return
            L_0x003c:
                java.lang.Object r3 = r0.get()
                if (r3 == r1) goto L_0x0035
                goto L_0x0000
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableReplay.ReplayObserver.a(io.reactivex.internal.operators.observable.ObservableReplay$InnerDisposable):void");
        }

        public final void dispose() {
            this.e.set(i);
            DisposableHelper.dispose(this);
        }

        public final boolean isDisposed() {
            if (this.e.get() == i) {
                return true;
            }
            return false;
        }

        public final void onComplete() {
            if (!this.d) {
                this.d = true;
                ReplayBuffer replayBuffer = this.c;
                replayBuffer.complete();
                for (InnerDisposable a2 : (InnerDisposable[]) this.e.getAndSet(i)) {
                    replayBuffer.a(a2);
                }
            }
        }

        public final void onError(Throwable th) {
            if (!this.d) {
                this.d = true;
                ReplayBuffer replayBuffer = this.c;
                replayBuffer.error(th);
                for (InnerDisposable a2 : (InnerDisposable[]) this.e.getAndSet(i)) {
                    replayBuffer.a(a2);
                }
                return;
            }
            RxJavaPlugins.b(th);
        }

        public final void onNext(Object obj) {
            if (!this.d) {
                ReplayBuffer replayBuffer = this.c;
                replayBuffer.next(obj);
                for (InnerDisposable a2 : (InnerDisposable[]) this.e.get()) {
                    replayBuffer.a(a2);
                }
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.setOnce(this, disposable)) {
                for (InnerDisposable a2 : (InnerDisposable[]) this.e.get()) {
                    this.c.a(a2);
                }
            }
        }
    }

    public static final class ReplaySource<T> implements ObservableSource<T> {
        public final AtomicReference c;
        public final BufferSupplier d;

        public ReplaySource(AtomicReference atomicReference, BufferSupplier bufferSupplier) {
            this.c = atomicReference;
            this.d = bufferSupplier;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: io.reactivex.internal.operators.observable.ObservableReplay$InnerDisposable[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.Object} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void subscribe(io.reactivex.Observer r7) {
            /*
                r6 = this;
            L_0x0000:
                java.util.concurrent.atomic.AtomicReference r0 = r6.c
                java.lang.Object r0 = r0.get()
                io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver r0 = (io.reactivex.internal.operators.observable.ObservableReplay.ReplayObserver) r0
                if (r0 != 0) goto L_0x0027
                io.reactivex.internal.operators.observable.ObservableReplay$BufferSupplier r0 = r6.d
                io.reactivex.internal.operators.observable.ObservableReplay$ReplayBuffer r0 = r0.call()
                io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver r1 = new io.reactivex.internal.operators.observable.ObservableReplay$ReplayObserver
                r1.<init>(r0)
                java.util.concurrent.atomic.AtomicReference r2 = r6.c
            L_0x0017:
                r0 = 0
                boolean r0 = r2.compareAndSet(r0, r1)
                if (r0 == 0) goto L_0x0020
                r0 = r1
                goto L_0x0027
            L_0x0020:
                java.lang.Object r0 = r2.get()
                if (r0 == 0) goto L_0x0017
                goto L_0x0000
            L_0x0027:
                io.reactivex.internal.operators.observable.ObservableReplay$InnerDisposable r1 = new io.reactivex.internal.operators.observable.ObservableReplay$InnerDisposable
                r1.<init>(r0, r7)
                r7.onSubscribe(r1)
            L_0x002f:
                java.util.concurrent.atomic.AtomicReference r7 = r0.e
                java.lang.Object r2 = r7.get()
                io.reactivex.internal.operators.observable.ObservableReplay$InnerDisposable[] r2 = (io.reactivex.internal.operators.observable.ObservableReplay.InnerDisposable[]) r2
                io.reactivex.internal.operators.observable.ObservableReplay$InnerDisposable[] r3 = io.reactivex.internal.operators.observable.ObservableReplay.ReplayObserver.i
                if (r2 != r3) goto L_0x003c
                goto L_0x004d
            L_0x003c:
                int r3 = r2.length
                int r4 = r3 + 1
                io.reactivex.internal.operators.observable.ObservableReplay$InnerDisposable[] r4 = new io.reactivex.internal.operators.observable.ObservableReplay.InnerDisposable[r4]
                r5 = 0
                java.lang.System.arraycopy(r2, r5, r4, r5, r3)
                r4[r3] = r1
            L_0x0047:
                boolean r3 = r7.compareAndSet(r2, r4)
                if (r3 == 0) goto L_0x005b
            L_0x004d:
                boolean r7 = r1.f
                if (r7 == 0) goto L_0x0055
                r0.a(r1)
                return
            L_0x0055:
                io.reactivex.internal.operators.observable.ObservableReplay$ReplayBuffer r7 = r0.c
                r7.a(r1)
                return
            L_0x005b:
                java.lang.Object r3 = r7.get()
                if (r3 == r2) goto L_0x0047
                goto L_0x002f
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableReplay.ReplaySource.subscribe(io.reactivex.Observer):void");
        }
    }

    public static final class ScheduledReplaySupplier<T> implements BufferSupplier<T> {

        /* renamed from: a  reason: collision with root package name */
        public final int f673a;
        public final long b;
        public final TimeUnit c;
        public final Scheduler d;

        public ScheduledReplaySupplier(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.f673a = i;
            this.b = j;
            this.c = timeUnit;
            this.d = scheduler;
        }

        public final ReplayBuffer call() {
            return new SizeAndTimeBoundReplayBuffer(this.f673a, this.b, this.c, this.d);
        }
    }

    public static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        public final Scheduler e;
        public final long f;
        public final TimeUnit g;
        public final int i;

        public SizeAndTimeBoundReplayBuffer(int i2, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.e = scheduler;
            this.i = i2;
            this.f = j;
            this.g = timeUnit;
        }

        public final Object b(Object obj) {
            Scheduler scheduler = this.e;
            TimeUnit timeUnit = this.g;
            return new Timed(obj, scheduler.b(timeUnit), timeUnit);
        }

        public final Node c() {
            Node node;
            long b = this.e.b(this.g) - this.f;
            Node node2 = (Node) get();
            Object obj = node2.get();
            while (true) {
                Node node3 = (Node) obj;
                node = node2;
                node2 = node3;
                if (node2 != null) {
                    Timed timed = (Timed) node2.c;
                    if (NotificationLite.isComplete(timed.f689a) || NotificationLite.isError(timed.f689a) || timed.b > b) {
                        break;
                    }
                    obj = node2.get();
                } else {
                    break;
                }
            }
            return node;
        }

        public final Object d(Object obj) {
            return ((Timed) obj).f689a;
        }

        public final void e() {
            Node node;
            long b = this.e.b(this.g) - this.f;
            Node node2 = (Node) get();
            Node node3 = (Node) node2.get();
            int i2 = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 != null) {
                    int i3 = this.d;
                    if (i3 <= this.i) {
                        if (((Timed) node2.c).b > b) {
                            break;
                        }
                        i2++;
                        this.d = i3 - 1;
                        node3 = (Node) node2.get();
                    } else {
                        i2++;
                        this.d = i3 - 1;
                        node3 = (Node) node2.get();
                    }
                } else {
                    break;
                }
            }
            if (i2 != 0) {
                set(node);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x003b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void f() {
            /*
                r10 = this;
                io.reactivex.Scheduler r0 = r10.e
                java.util.concurrent.TimeUnit r1 = r10.g
                long r0 = r0.b(r1)
                long r2 = r10.f
                long r0 = r0 - r2
                java.lang.Object r2 = r10.get()
                io.reactivex.internal.operators.observable.ObservableReplay$Node r2 = (io.reactivex.internal.operators.observable.ObservableReplay.Node) r2
                java.lang.Object r3 = r2.get()
                io.reactivex.internal.operators.observable.ObservableReplay$Node r3 = (io.reactivex.internal.operators.observable.ObservableReplay.Node) r3
                r4 = 0
            L_0x0018:
                r9 = r3
                r3 = r2
                r2 = r9
                if (r2 == 0) goto L_0x0039
                int r5 = r10.d
                r6 = 1
                if (r5 <= r6) goto L_0x0039
                java.lang.Object r6 = r2.c
                io.reactivex.schedulers.Timed r6 = (io.reactivex.schedulers.Timed) r6
                long r6 = r6.b
                int r8 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
                if (r8 > 0) goto L_0x0039
                int r4 = r4 + 1
                int r5 = r5 + -1
                r10.d = r5
                java.lang.Object r3 = r2.get()
                io.reactivex.internal.operators.observable.ObservableReplay$Node r3 = (io.reactivex.internal.operators.observable.ObservableReplay.Node) r3
                goto L_0x0018
            L_0x0039:
                if (r4 == 0) goto L_0x003e
                r10.set(r3)
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableReplay.SizeAndTimeBoundReplayBuffer.f():void");
        }
    }

    public static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        public final int e;

        public SizeBoundReplayBuffer(int i) {
            this.e = i;
        }

        public final void e() {
            if (this.d > this.e) {
                this.d--;
                set((Node) ((Node) get()).get());
            }
        }
    }

    public static final class UnBoundedFactory implements BufferSupplier<Object> {
        /* JADX WARNING: type inference failed for: r0v0, types: [io.reactivex.internal.operators.observable.ObservableReplay$ReplayBuffer, java.util.ArrayList] */
        public final ReplayBuffer call() {
            return new ArrayList(16);
        }
    }

    public static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        public volatile int c;

        public final void a(InnerDisposable innerDisposable) {
            int i;
            if (innerDisposable.getAndIncrement() == 0) {
                Observer observer = innerDisposable.d;
                int i2 = 1;
                while (!innerDisposable.f) {
                    int i3 = this.c;
                    Integer num = (Integer) innerDisposable.e;
                    if (num != null) {
                        i = num.intValue();
                    } else {
                        i = 0;
                    }
                    while (i < i3) {
                        if (!NotificationLite.accept(get(i), observer) && !innerDisposable.f) {
                            i++;
                        } else {
                            return;
                        }
                    }
                    innerDisposable.e = Integer.valueOf(i);
                    i2 = innerDisposable.addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        public final void complete() {
            add(NotificationLite.complete());
            this.c++;
        }

        public final void error(Throwable th) {
            add(NotificationLite.error(th));
            this.c++;
        }

        public final void next(Object obj) {
            add(NotificationLite.next(obj));
            this.c++;
        }
    }

    public ObservableReplay(ObservableSource observableSource, Observable observable, AtomicReference atomicReference, BufferSupplier bufferSupplier) {
        this.f = observableSource;
        this.c = observable;
        this.d = atomicReference;
        this.e = bufferSupplier;
    }

    public static ObservableReplay d(int i, long j, Observable observable, Scheduler scheduler, TimeUnit timeUnit) {
        return f(observable, new ScheduledReplaySupplier(i, j, timeUnit, scheduler));
    }

    public static ObservableReplay e(Observable observable, int i) {
        if (i == Integer.MAX_VALUE) {
            return f(observable, g);
        }
        return f(observable, new ReplayBufferSupplier(i));
    }

    public static ObservableReplay f(Observable observable, BufferSupplier bufferSupplier) {
        AtomicReference atomicReference = new AtomicReference();
        return new ObservableReplay(new ReplaySource(atomicReference, bufferSupplier), observable, atomicReference, bufferSupplier);
    }

    public static Observable g(Function function, Callable callable) {
        return new MulticastReplay(function, callable);
    }

    public static ConnectableObservable h(ConnectableObservable connectableObservable, Scheduler scheduler) {
        return new Replay(connectableObservable, connectableObservable.observeOn(scheduler));
    }

    public final void c(Consumer consumer) {
        ReplayObserver replayObserver;
        boolean z;
        loop0:
        while (true) {
            AtomicReference atomicReference = this.d;
            replayObserver = (ReplayObserver) atomicReference.get();
            if (replayObserver != null && !replayObserver.isDisposed()) {
                break;
            }
            ReplayObserver replayObserver2 = new ReplayObserver(this.e.call());
            while (true) {
                if (atomicReference.compareAndSet(replayObserver, replayObserver2)) {
                    replayObserver = replayObserver2;
                    break loop0;
                } else if (atomicReference.get() != replayObserver) {
                }
            }
        }
        AtomicBoolean atomicBoolean = replayObserver.f;
        if (atomicBoolean.get() || !atomicBoolean.compareAndSet(false, true)) {
            z = false;
        } else {
            z = true;
        }
        try {
            consumer.accept(replayObserver);
            if (z) {
                this.c.subscribe(replayObserver);
            }
        } catch (Throwable th) {
            if (z) {
                atomicBoolean.compareAndSet(true, false);
            }
            Exceptions.a(th);
            throw ExceptionHelper.c(th);
        }
    }

    public final void dispose() {
        this.d.lazySet((Object) null);
    }

    public final boolean isDisposed() {
        Disposable disposable = (Disposable) this.d.get();
        if (disposable == null || disposable.isDisposed()) {
            return true;
        }
        return false;
    }

    public final void subscribeActual(Observer observer) {
        ((ReplaySource) this.f).subscribe(observer);
    }
}
