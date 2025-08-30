package rx.subjects;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.internal.operators.NotificationLite;
import rx.schedulers.TestScheduler;
import rx.subjects.SubjectSubscriptionManager;

public final class TestSubject<T> extends Subject<T, T> {
    private final Scheduler.Worker innerScheduler;
    private final SubjectSubscriptionManager<T> state;

    public TestSubject(Observable.OnSubscribe<T> onSubscribe, SubjectSubscriptionManager<T> subjectSubscriptionManager, TestScheduler testScheduler) {
        super(onSubscribe);
        this.state = subjectSubscriptionManager;
        this.innerScheduler = testScheduler.createWorker();
    }

    public static <T> TestSubject<T> create(TestScheduler testScheduler) {
        final SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
        AnonymousClass1 r1 = new Action1<SubjectSubscriptionManager.SubjectObserver<T>>() {
            public void call(SubjectSubscriptionManager.SubjectObserver<T> subjectObserver) {
                subjectObserver.emitFirst(subjectSubscriptionManager.getLatest());
            }
        };
        subjectSubscriptionManager.onAdded = r1;
        subjectSubscriptionManager.onTerminated = r1;
        return new TestSubject<>(subjectSubscriptionManager, subjectSubscriptionManager, testScheduler);
    }

    public boolean hasObservers() {
        if (this.state.observers().length > 0) {
            return true;
        }
        return false;
    }

    public void internalOnCompleted() {
        SubjectSubscriptionManager<T> subjectSubscriptionManager = this.state;
        if (subjectSubscriptionManager.active) {
            for (SubjectSubscriptionManager.SubjectObserver onCompleted : subjectSubscriptionManager.terminate(NotificationLite.completed())) {
                onCompleted.onCompleted();
            }
        }
    }

    public void internalOnError(Throwable th) {
        SubjectSubscriptionManager<T> subjectSubscriptionManager = this.state;
        if (subjectSubscriptionManager.active) {
            for (SubjectSubscriptionManager.SubjectObserver onError : subjectSubscriptionManager.terminate(NotificationLite.error(th))) {
                onError.onError(th);
            }
        }
    }

    public void internalOnNext(T t) {
        for (SubjectSubscriptionManager.SubjectObserver onNext : this.state.observers()) {
            onNext.onNext(t);
        }
    }

    public void onCompleted() {
        onCompleted(0);
    }

    public void onError(Throwable th) {
        onError(th, 0);
    }

    public void onNext(T t) {
        onNext(t, 0);
    }

    public void onCompleted(long j) {
        this.innerScheduler.schedule(new Action0() {
            public void call() {
                TestSubject.this.internalOnCompleted();
            }
        }, j, TimeUnit.MILLISECONDS);
    }

    public void onError(final Throwable th, long j) {
        this.innerScheduler.schedule(new Action0() {
            public void call() {
                TestSubject.this.internalOnError(th);
            }
        }, j, TimeUnit.MILLISECONDS);
    }

    public void onNext(final T t, long j) {
        this.innerScheduler.schedule(new Action0() {
            public void call() {
                TestSubject.this.internalOnNext(t);
            }
        }, j, TimeUnit.MILLISECONDS);
    }
}
