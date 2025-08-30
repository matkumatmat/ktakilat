package defpackage;

import android.view.KeyEvent;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.view.KeyEventDispatcher;

/* renamed from: b0  reason: default package */
public final /* synthetic */ class b0 implements KeyEventDispatcher.Component {
    public final /* synthetic */ AppCompatDialog c;

    public /* synthetic */ b0(AppCompatDialog appCompatDialog) {
        this.c = appCompatDialog;
    }

    public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return this.c.superDispatchKeyEvent(keyEvent);
    }
}
