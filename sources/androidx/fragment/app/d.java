package androidx.fragment.app;

import androidx.fragment.app.SpecialEffectsController;

public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ SpecialEffectsController d;
    public final /* synthetic */ SpecialEffectsController.FragmentStateManagerOperation e;

    public /* synthetic */ d(SpecialEffectsController specialEffectsController, SpecialEffectsController.FragmentStateManagerOperation fragmentStateManagerOperation, int i) {
        this.c = i;
        this.d = specialEffectsController;
        this.e = fragmentStateManagerOperation;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                SpecialEffectsController.enqueue$lambda$4$lambda$2(this.d, this.e);
                return;
            default:
                SpecialEffectsController.enqueue$lambda$4$lambda$3(this.d, this.e);
                return;
        }
    }
}
