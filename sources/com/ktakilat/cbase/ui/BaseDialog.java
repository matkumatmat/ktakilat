package com.ktakilat.cbase.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import androidx.annotation.NonNull;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class BaseDialog extends Dialog {
    public Disposable c;
    public OnWindowFocusChangeCall d;

    public interface OnWindowFocusChangeCall {
        void a(boolean z);
    }

    public BaseDialog(@NonNull Context context) {
        super(context);
        if (context instanceof Activity) {
            setOwnerActivity((Activity) context);
        }
        Activity ownerActivity = getOwnerActivity();
        if (ownerActivity instanceof RxAppCompatActivity) {
            ((RxAppCompatActivity) ownerActivity).c.hide().subscribe(new Observer<ActivityEvent>() {
                public final void onComplete() {
                }

                public final void onError(Throwable th) {
                }

                public final void onNext(Object obj) {
                    ActivityEvent activityEvent = (ActivityEvent) obj;
                    BaseDialog baseDialog = BaseDialog.this;
                    if (baseDialog.c == null) {
                        return;
                    }
                    if ((activityEvent != ActivityEvent.RESUME || !baseDialog.isShowing()) && activityEvent == ActivityEvent.PAUSE) {
                        baseDialog.isShowing();
                    }
                }

                public final void onSubscribe(Disposable disposable) {
                    BaseDialog.this.c = disposable;
                }
            });
        }
    }

    public final void onStop() {
        super.onStop();
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
            this.c = null;
        }
    }

    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        OnWindowFocusChangeCall onWindowFocusChangeCall = this.d;
        if (onWindowFocusChangeCall != null) {
            onWindowFocusChangeCall.a(z);
        }
    }

    public BaseDialog(Context context, int i) {
        super(context, i);
        if (context instanceof Activity) {
            setOwnerActivity((Activity) context);
        }
        Activity ownerActivity = getOwnerActivity();
        if (ownerActivity instanceof RxAppCompatActivity) {
            ((RxAppCompatActivity) ownerActivity).c.hide().subscribe(new Observer<ActivityEvent>() {
                public final void onComplete() {
                }

                public final void onError(Throwable th) {
                }

                public final void onNext(Object obj) {
                    ActivityEvent activityEvent = (ActivityEvent) obj;
                    BaseDialog baseDialog = BaseDialog.this;
                    if (baseDialog.c == null) {
                        return;
                    }
                    if ((activityEvent != ActivityEvent.RESUME || !baseDialog.isShowing()) && activityEvent == ActivityEvent.PAUSE) {
                        baseDialog.isShowing();
                    }
                }

                public final void onSubscribe(Disposable disposable) {
                    BaseDialog.this.c = disposable;
                }
            });
        }
    }
}
