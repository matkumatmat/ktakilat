package com.google.android.material.timepicker;

import com.google.android.material.button.MaterialButtonToggleGroup;

public final /* synthetic */ class c implements MaterialButtonToggleGroup.OnButtonCheckedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f244a;
    public final /* synthetic */ Object b;

    public /* synthetic */ c(Object obj, int i) {
        this.f244a = i;
        this.b = obj;
    }

    public final void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z) {
        switch (this.f244a) {
            case 0:
                ((TimePickerTextInputPresenter) this.b).lambda$setupPeriodToggle$0(materialButtonToggleGroup, i, z);
                return;
            default:
                ((TimePickerView) this.b).lambda$new$0(materialButtonToggleGroup, i, z);
                return;
        }
    }
}
