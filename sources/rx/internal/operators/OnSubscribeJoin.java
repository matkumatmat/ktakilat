package rx.internal.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.SerialSubscription;

public final class OnSubscribeJoin<TLeft, TRight, TLeftDuration, TRightDuration, R> implements Observable.OnSubscribe<R> {
    final Observable<TLeft> left;
    final Func1<TLeft, Observable<TLeftDuration>> leftDurationSelector;
    final Func2<TLeft, TRight, R> resultSelector;
    final Observable<TRight> right;
    final Func1<TRight, Observable<TRightDuration>> rightDurationSelector;

    public final class ResultSink extends HashMap<Integer, TLeft> {
        private static final long serialVersionUID = 3491669543549085380L;
        final CompositeSubscription group = new CompositeSubscription();
        boolean leftDone;
        int leftId;
        boolean rightDone;
        int rightId;
        final Map<Integer, TRight> rightMap = new HashMap();
        final Subscriber<? super R> subscriber;

        public final class LeftSubscriber extends Subscriber<TLeft> {

            public final class LeftDurationSubscriber extends Subscriber<TLeftDuration> {
                final int id;
                boolean once = true;

                public LeftDurationSubscriber(int i) {
                    this.id = i;
                }

                public void onCompleted() {
                    if (this.once) {
                        this.once = false;
                        LeftSubscriber.this.expire(this.id, this);
                    }
                }

                public void onError(Throwable th) {
                    LeftSubscriber.this.onError(th);
                }

                public void onNext(TLeftDuration tleftduration) {
                    onCompleted();
                }
            }

            public LeftSubscriber() {
            }

            public void expire(int i, Subscription subscription) {
                boolean z;
                synchronized (ResultSink.this) {
                    try {
                        if (ResultSink.this.leftMap().remove(Integer.valueOf(i)) == null || !ResultSink.this.leftMap().isEmpty() || !ResultSink.this.leftDone) {
                            z = false;
                        } else {
                            z = true;
                        }
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
                if (z) {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                    return;
                }
                ResultSink.this.group.remove(subscription);
            }

            public void onCompleted() {
                boolean z;
                synchronized (ResultSink.this) {
                    try {
                        ResultSink resultSink = ResultSink.this;
                        z = true;
                        resultSink.leftDone = true;
                        if (!resultSink.rightDone) {
                            if (!resultSink.leftMap().isEmpty()) {
                                z = false;
                            }
                        }
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
                if (z) {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                    return;
                }
                ResultSink.this.group.remove(this);
            }

            public void onError(Throwable th) {
                ResultSink.this.subscriber.onError(th);
                ResultSink.this.subscriber.unsubscribe();
            }

            public void onNext(TLeft tleft) {
                int i;
                ResultSink resultSink;
                int i2;
                synchronized (ResultSink.this) {
                    ResultSink resultSink2 = ResultSink.this;
                    i = resultSink2.leftId;
                    resultSink2.leftId = i + 1;
                    resultSink2.leftMap().put(Integer.valueOf(i), tleft);
                    resultSink = ResultSink.this;
                    i2 = resultSink.rightId;
                }
                try {
                    LeftDurationSubscriber leftDurationSubscriber = new LeftDurationSubscriber(i);
                    ResultSink.this.group.add(leftDurationSubscriber);
                    OnSubscribeJoin.this.leftDurationSelector.call(tleft).unsafeSubscribe(leftDurationSubscriber);
                    ArrayList arrayList = new ArrayList();
                    synchronized (ResultSink.this) {
                        for (Map.Entry next : ResultSink.this.rightMap.entrySet()) {
                            if (((Integer) next.getKey()).intValue() < i2) {
                                arrayList.add(next.getValue());
                            }
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ResultSink.this.subscriber.onNext(OnSubscribeJoin.this.resultSelector.call(tleft, it.next()));
                    }
                } catch (Throwable th) {
                    Exceptions.throwOrReport(th, (Observer<?>) this);
                }
            }
        }

        public final class RightSubscriber extends Subscriber<TRight> {

            public final class RightDurationSubscriber extends Subscriber<TRightDuration> {
                final int id;
                boolean once = true;

                public RightDurationSubscriber(int i) {
                    this.id = i;
                }

                public void onCompleted() {
                    if (this.once) {
                        this.once = false;
                        RightSubscriber.this.expire(this.id, this);
                    }
                }

                public void onError(Throwable th) {
                    RightSubscriber.this.onError(th);
                }

                public void onNext(TRightDuration trightduration) {
                    onCompleted();
                }
            }

            public RightSubscriber() {
            }

            public void expire(int i, Subscription subscription) {
                boolean z;
                synchronized (ResultSink.this) {
                    try {
                        if (ResultSink.this.rightMap.remove(Integer.valueOf(i)) == null || !ResultSink.this.rightMap.isEmpty() || !ResultSink.this.rightDone) {
                            z = false;
                        } else {
                            z = true;
                        }
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
                if (z) {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                    return;
                }
                ResultSink.this.group.remove(subscription);
            }

            public void onCompleted() {
                boolean z;
                synchronized (ResultSink.this) {
                    try {
                        ResultSink resultSink = ResultSink.this;
                        z = true;
                        resultSink.rightDone = true;
                        if (!resultSink.leftDone) {
                            if (!resultSink.rightMap.isEmpty()) {
                                z = false;
                            }
                        }
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
                if (z) {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                    return;
                }
                ResultSink.this.group.remove(this);
            }

            public void onError(Throwable th) {
                ResultSink.this.subscriber.onError(th);
                ResultSink.this.subscriber.unsubscribe();
            }

            public void onNext(TRight tright) {
                int i;
                int i2;
                synchronized (ResultSink.this) {
                    ResultSink resultSink = ResultSink.this;
                    i = resultSink.rightId;
                    resultSink.rightId = i + 1;
                    resultSink.rightMap.put(Integer.valueOf(i), tright);
                    i2 = ResultSink.this.leftId;
                }
                ResultSink.this.group.add(new SerialSubscription());
                try {
                    RightDurationSubscriber rightDurationSubscriber = new RightDurationSubscriber(i);
                    ResultSink.this.group.add(rightDurationSubscriber);
                    OnSubscribeJoin.this.rightDurationSelector.call(tright).unsafeSubscribe(rightDurationSubscriber);
                    ArrayList arrayList = new ArrayList();
                    synchronized (ResultSink.this) {
                        for (Map.Entry entry : ResultSink.this.leftMap().entrySet()) {
                            if (((Integer) entry.getKey()).intValue() < i2) {
                                arrayList.add(entry.getValue());
                            }
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ResultSink.this.subscriber.onNext(OnSubscribeJoin.this.resultSelector.call(it.next(), tright));
                    }
                } catch (Throwable th) {
                    Exceptions.throwOrReport(th, (Observer<?>) this);
                }
            }
        }

        public ResultSink(Subscriber<? super R> subscriber2) {
            this.subscriber = subscriber2;
        }

        public HashMap<Integer, TLeft> leftMap() {
            return this;
        }

        public void run() {
            this.subscriber.add(this.group);
            LeftSubscriber leftSubscriber = new LeftSubscriber();
            RightSubscriber rightSubscriber = new RightSubscriber();
            this.group.add(leftSubscriber);
            this.group.add(rightSubscriber);
            OnSubscribeJoin.this.left.unsafeSubscribe(leftSubscriber);
            OnSubscribeJoin.this.right.unsafeSubscribe(rightSubscriber);
        }
    }

    public OnSubscribeJoin(Observable<TLeft> observable, Observable<TRight> observable2, Func1<TLeft, Observable<TLeftDuration>> func1, Func1<TRight, Observable<TRightDuration>> func12, Func2<TLeft, TRight, R> func2) {
        this.left = observable;
        this.right = observable2;
        this.leftDurationSelector = func1;
        this.rightDurationSelector = func12;
        this.resultSelector = func2;
    }

    public void call(Subscriber<? super R> subscriber) {
        new ResultSink(new SerializedSubscriber(subscriber)).run();
    }
}
