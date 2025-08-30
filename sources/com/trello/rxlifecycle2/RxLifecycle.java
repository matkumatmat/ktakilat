package com.trello.rxlifecycle2;

import com.trello.rxlifecycle2.android.ActivityEvent;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Predicate;

public class RxLifecycle {

    /* renamed from: com.trello.rxlifecycle2.RxLifecycle$2  reason: invalid class name */
    final class AnonymousClass2 implements BiFunction<Object, Object, Boolean> {
        public final Object apply(Object obj, Object obj2) {
            return Boolean.valueOf(obj2.equals(obj));
        }
    }

    public static LifecycleTransformer a(Observable observable, final ActivityEvent activityEvent) {
        if (observable == null) {
            throw new NullPointerException("lifecycle == null");
        } else if (activityEvent != null) {
            return new LifecycleTransformer(observable.filter(new Predicate<Object>() {
                public final boolean test(Object obj) {
                    return obj.equals(ActivityEvent.this);
                }
            }));
        } else {
            throw new NullPointerException("event == null");
        }
    }
}
