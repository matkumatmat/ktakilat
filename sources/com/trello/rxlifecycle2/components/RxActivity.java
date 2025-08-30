package com.trello.rxlifecycle2.components;

import android.app.Activity;
import android.os.Bundle;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import io.reactivex.subjects.BehaviorSubject;

public abstract class RxActivity extends Activity implements LifecycleProvider<ActivityEvent> {
    public final BehaviorSubject c = new BehaviorSubject();

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c.onNext(ActivityEvent.CREATE);
    }

    public final void onDestroy() {
        this.c.onNext(ActivityEvent.DESTROY);
        super.onDestroy();
    }

    public final void onPause() {
        this.c.onNext(ActivityEvent.PAUSE);
        super.onPause();
    }

    public final void onResume() {
        super.onResume();
        this.c.onNext(ActivityEvent.RESUME);
    }

    public final void onStart() {
        super.onStart();
        this.c.onNext(ActivityEvent.START);
    }

    public final void onStop() {
        this.c.onNext(ActivityEvent.STOP);
        super.onStop();
    }
}
