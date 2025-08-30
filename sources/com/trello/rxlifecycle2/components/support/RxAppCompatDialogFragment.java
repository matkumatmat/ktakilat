package com.trello.rxlifecycle2.components.support;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.android.FragmentEvent;
import io.reactivex.subjects.BehaviorSubject;

public abstract class RxAppCompatDialogFragment extends AppCompatDialogFragment implements LifecycleProvider<FragmentEvent> {
    public final BehaviorSubject c = new BehaviorSubject();

    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        this.c.onNext(FragmentEvent.ATTACH);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c.onNext(FragmentEvent.CREATE);
    }

    public final void onDestroy() {
        this.c.onNext(FragmentEvent.DESTROY);
        super.onDestroy();
    }

    public final void onDestroyView() {
        this.c.onNext(FragmentEvent.DESTROY_VIEW);
        super.onDestroyView();
    }

    public final void onDetach() {
        this.c.onNext(FragmentEvent.DETACH);
        super.onDetach();
    }

    public final void onPause() {
        this.c.onNext(FragmentEvent.PAUSE);
        super.onPause();
    }

    public final void onResume() {
        super.onResume();
        this.c.onNext(FragmentEvent.RESUME);
    }

    public final void onStart() {
        super.onStart();
        this.c.onNext(FragmentEvent.START);
    }

    public final void onStop() {
        this.c.onNext(FragmentEvent.STOP);
        super.onStop();
    }

    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.c.onNext(FragmentEvent.CREATE_VIEW);
    }
}
