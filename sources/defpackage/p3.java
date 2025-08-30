package defpackage;

import android.content.Context;
import androidx.activity.ComponentActivity;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.fragment.app.FragmentActivity;

/* renamed from: p3  reason: default package */
public final /* synthetic */ class p3 implements OnContextAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f208a;
    public final /* synthetic */ ComponentActivity b;

    public /* synthetic */ p3(ComponentActivity componentActivity, int i) {
        this.f208a = i;
        this.b = componentActivity;
    }

    public final void onContextAvailable(Context context) {
        switch (this.f208a) {
            case 0:
                ComponentActivity._init_$lambda$5(this.b, context);
                return;
            default:
                ((FragmentActivity) this.b).lambda$init$3(context);
                return;
        }
    }
}
