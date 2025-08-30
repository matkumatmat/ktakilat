package com.ktakilat.loan.widgets;

import androidx.activity.OnBackPressedCallback;
import com.ktakilat.cbase.datacollect.KtaCollect;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/ktakilat/loan/widgets/CityPickerActivity$setupButton$3", "Landroidx/activity/OnBackPressedCallback;", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CityPickerActivity$setupButton$3 extends OnBackPressedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CityPickerActivity f616a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CityPickerActivity$setupButton$3(CityPickerActivity cityPickerActivity) {
        super(true);
        this.f616a = cityPickerActivity;
    }

    public final void handleOnBackPressed() {
        KtaCollect.n_city_picker_clc_back();
        if (isEnabled()) {
            setEnabled(false);
            this.f616a.getOnBackPressedDispatcher().onBackPressed();
        }
    }
}
