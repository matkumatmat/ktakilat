package com.ktakilat.cbase.ui;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.trello.rxlifecycle2.components.support.RxFragment;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class BaseFragment extends RxFragment {
    public Disposable d;

    public final BaseActivity b() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof BaseActivity) {
                return (BaseActivity) context;
            }
        }
        return null;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof BaseFragment) {
            ((BaseFragment) parentFragment).c.hide().subscribe(new Observer<FragmentEvent>() {
                public final void onComplete() {
                }

                public final void onError(Throwable th) {
                }

                public final void onNext(Object obj) {
                    FragmentEvent fragmentEvent = (FragmentEvent) obj;
                    BaseFragment baseFragment = BaseFragment.this;
                    if (baseFragment.d == null) {
                        return;
                    }
                    if (fragmentEvent == FragmentEvent.RESUME) {
                        baseFragment.getUserVisibleHint();
                    } else if (fragmentEvent == FragmentEvent.PAUSE) {
                        baseFragment.getUserVisibleHint();
                    }
                }

                public final void onSubscribe(Disposable disposable) {
                    BaseFragment.this.d = disposable;
                }
            });
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Disposable disposable = this.d;
        if (disposable != null) {
            disposable.dispose();
            this.d = null;
        }
    }

    public void onPause() {
        super.onPause();
        getUserVisibleHint();
    }

    public void onResume() {
        super.onResume();
        getUserVisibleHint();
    }

    public final void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (isAdded()) {
            for (Fragment next : getChildFragmentManager().getFragments()) {
                if (isAdded()) {
                    next.setUserVisibleHint(z);
                }
            }
        }
    }
}
