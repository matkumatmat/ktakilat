package com.trello.rxlifecycle2.android;

import android.os.Looper;
import android.view.View;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.MainThreadDisposable;

final class ViewDetachesOnSubscribe implements ObservableOnSubscribe<Object> {
    public static final Object c = new Object();

    public class EmitterListener extends MainThreadDisposable implements View.OnAttachStateChangeListener {
        public final ObservableEmitter d;

        public EmitterListener(ObservableEmitter observableEmitter) {
            this.d = observableEmitter;
        }

        public final void a() {
            ViewDetachesOnSubscribe.this.getClass();
            throw null;
        }

        public final void onViewAttachedToWindow(View view) {
        }

        public final void onViewDetachedFromWindow(View view) {
            this.d.onNext(ViewDetachesOnSubscribe.c);
        }
    }

    public final void d(ObservableEmitter observableEmitter) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            observableEmitter.a(new EmitterListener(observableEmitter));
            throw null;
        }
        throw new IllegalStateException("Expected to be called on the main thread but was " + Thread.currentThread().getName());
    }
}
