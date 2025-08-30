package com.trello.rxlifecycle2.components.support;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.ActivityEvent;
import io.reactivex.subjects.BehaviorSubject;

public abstract class RxAppCompatActivity extends AppCompatActivity implements LifecycleProvider<ActivityEvent> {
    public final BehaviorSubject c = new BehaviorSubject();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c.onNext(ActivityEvent.CREATE);
    }

    public void onDestroy() {
        this.c.onNext(ActivityEvent.DESTROY);
        super.onDestroy();
    }

    public void onPause() {
        this.c.onNext(ActivityEvent.PAUSE);
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.c.onNext(ActivityEvent.RESUME);
    }

    public void onStart() {
        super.onStart();
        this.c.onNext(ActivityEvent.START);
    }

    public void onStop() {
        this.c.onNext(ActivityEvent.STOP);
        super.onStop();
    }
}
