package defpackage;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.loan.http.division.DivisionEnum;
import com.ktakilat.loan.http.division.DivisionItem;
import com.ktakilat.loan.widgets.CityPickerFragViewModel;
import com.ktakilat.loan.widgets.RegionAdapter;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: rd  reason: default package */
public final /* synthetic */ class rd implements View.OnClickListener {
    public final /* synthetic */ RegionAdapter c;
    public final /* synthetic */ int d;

    public /* synthetic */ rd(RegionAdapter regionAdapter, int i) {
        this.c = regionAdapter;
        this.d = i;
    }

    public final void onClick(View view) {
        RegionAdapter regionAdapter = this.c;
        DivisionItem divisionItem = (DivisionItem) regionAdapter.d.get(this.d);
        KtaCollect.n_city_picker_clc_item(regionAdapter.c, divisionItem.getName());
        int i = RegionAdapter.WhenMappings.f619a[regionAdapter.b.ordinal()];
        CityPickerFragViewModel cityPickerFragViewModel = regionAdapter.f618a;
        if (i == 1) {
            cityPickerFragViewModel.b().setValue(divisionItem);
            ((MutableLiveData) cityPickerFragViewModel.f617a.getValue()).setValue(DivisionEnum.CITY);
        } else if (i == 2) {
            cityPickerFragViewModel.a().setValue(divisionItem);
            ((MutableLiveData) cityPickerFragViewModel.f617a.getValue()).setValue(DivisionEnum.DISTRUCT);
        } else if (i == 3) {
            ((MutableLiveData) cityPickerFragViewModel.d.getValue()).setValue(divisionItem);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
