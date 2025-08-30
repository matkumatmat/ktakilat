package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func0;
import rx.observables.ConnectableObservable;
import rx.subjects.Subject;

public final class OperatorMulticast<T, R> extends ConnectableObservable<R> {
    final AtomicReference<Subject<? super T, ? extends R>> connectedSubject;
    final Object guard;
    Subscription guardedSubscription;
    final Observable<? extends T> source;
    final Func0<? extends Subject<? super T, ? extends R>> subjectFactory;
    Subscriber<T> subscription;
    final List<Subscriber<? super R>> waitingForConnect;

    public OperatorMulticast(Observable<? extends T> observable, Func0<? extends Subject<? super T, ? extends R>> func0) {
        this(new Object(), new AtomicReference(), new ArrayList(), observable, func0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005d, code lost:
        r6.call(r5.guardedSubscription);
        r6 = r5.guard;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0064, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r0 = r5.subscription;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0067, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0068, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006a, code lost:
        r5.source.subscribe(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(rx.functions.Action1<? super rx.Subscription> r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.guard
            monitor-enter(r0)
            rx.Subscriber<T> r1 = r5.subscription     // Catch:{ all -> 0x000e }
            if (r1 == 0) goto L_0x0010
            rx.Subscription r1 = r5.guardedSubscription     // Catch:{ all -> 0x000e }
            r6.call(r1)     // Catch:{ all -> 0x000e }
            monitor-exit(r0)     // Catch:{ all -> 0x000e }
            return
        L_0x000e:
            r6 = move-exception
            goto L_0x0073
        L_0x0010:
            rx.functions.Func0<? extends rx.subjects.Subject<? super T, ? extends R>> r1 = r5.subjectFactory     // Catch:{ all -> 0x000e }
            java.lang.Object r1 = r1.call()     // Catch:{ all -> 0x000e }
            rx.subjects.Subject r1 = (rx.subjects.Subject) r1     // Catch:{ all -> 0x000e }
            rx.Subscriber r2 = rx.observers.Subscribers.from(r1)     // Catch:{ all -> 0x000e }
            r5.subscription = r2     // Catch:{ all -> 0x000e }
            java.util.concurrent.atomic.AtomicReference r2 = new java.util.concurrent.atomic.AtomicReference     // Catch:{ all -> 0x000e }
            r2.<init>()     // Catch:{ all -> 0x000e }
            rx.internal.operators.OperatorMulticast$2 r3 = new rx.internal.operators.OperatorMulticast$2     // Catch:{ all -> 0x000e }
            r3.<init>(r2)     // Catch:{ all -> 0x000e }
            rx.Subscription r3 = rx.subscriptions.Subscriptions.create(r3)     // Catch:{ all -> 0x000e }
            r2.set(r3)     // Catch:{ all -> 0x000e }
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x000e }
            rx.Subscription r2 = (rx.Subscription) r2     // Catch:{ all -> 0x000e }
            r5.guardedSubscription = r2     // Catch:{ all -> 0x000e }
            java.util.List<rx.Subscriber<? super R>> r2 = r5.waitingForConnect     // Catch:{ all -> 0x000e }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x000e }
        L_0x003d:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x000e }
            if (r3 == 0) goto L_0x0052
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x000e }
            rx.Subscriber r3 = (rx.Subscriber) r3     // Catch:{ all -> 0x000e }
            rx.internal.operators.OperatorMulticast$3 r4 = new rx.internal.operators.OperatorMulticast$3     // Catch:{ all -> 0x000e }
            r4.<init>(r3, r3)     // Catch:{ all -> 0x000e }
            r1.unsafeSubscribe(r4)     // Catch:{ all -> 0x000e }
            goto L_0x003d
        L_0x0052:
            java.util.List<rx.Subscriber<? super R>> r2 = r5.waitingForConnect     // Catch:{ all -> 0x000e }
            r2.clear()     // Catch:{ all -> 0x000e }
            java.util.concurrent.atomic.AtomicReference<rx.subjects.Subject<? super T, ? extends R>> r2 = r5.connectedSubject     // Catch:{ all -> 0x000e }
            r2.set(r1)     // Catch:{ all -> 0x000e }
            monitor-exit(r0)     // Catch:{ all -> 0x000e }
            rx.Subscription r0 = r5.guardedSubscription
            r6.call(r0)
            java.lang.Object r6 = r5.guard
            monitor-enter(r6)
            rx.Subscriber<T> r0 = r5.subscription     // Catch:{ all -> 0x0070 }
            monitor-exit(r6)     // Catch:{ all -> 0x0070 }
            if (r0 == 0) goto L_0x006f
            rx.Observable<? extends T> r6 = r5.source
            r6.subscribe(r0)
        L_0x006f:
            return
        L_0x0070:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0070 }
            throw r0
        L_0x0073:
            monitor-exit(r0)     // Catch:{ all -> 0x000e }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorMulticast.connect(rx.functions.Action1):void");
    }

    private OperatorMulticast(final Object obj, final AtomicReference<Subject<? super T, ? extends R>> atomicReference, final List<Subscriber<? super R>> list, Observable<? extends T> observable, Func0<? extends Subject<? super T, ? extends R>> func0) {
        super(new Observable.OnSubscribe<R>() {
            public void call(Subscriber<? super R> subscriber) {
                synchronized (obj) {
                    try {
                        if (atomicReference.get() == null) {
                            list.add(subscriber);
                        } else {
                            ((Subject) atomicReference.get()).unsafeSubscribe(subscriber);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
        this.guard = obj;
        this.connectedSubject = atomicReference;
        this.waitingForConnect = list;
        this.source = observable;
        this.subjectFactory = func0;
    }
}
