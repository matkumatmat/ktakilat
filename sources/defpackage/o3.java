package defpackage;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.SavedStateHandle;
import androidx.savedstate.SavedStateRegistry;

/* renamed from: o3  reason: default package */
public final /* synthetic */ class o3 implements SavedStateRegistry.SavedStateProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f206a;
    public final /* synthetic */ Object b;

    public /* synthetic */ o3(Object obj, int i) {
        this.f206a = i;
        this.b = obj;
    }

    public final Bundle saveState() {
        switch (this.f206a) {
            case 0:
                return ComponentActivity._init_$lambda$4((ComponentActivity) this.b);
            case 1:
                return ((FragmentActivity) this.b).lambda$init$0();
            case 2:
                return ((FragmentManager) this.b).lambda$attachController$5();
            default:
                return SavedStateHandle.savedStateProvider$lambda$0((SavedStateHandle) this.b);
        }
    }
}
