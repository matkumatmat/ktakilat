package defpackage;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.ktakilat.loan.http.division.DivisionEnum;
import com.ktakilat.loan.widgets.CityPickerActivity;

/* renamed from: y2  reason: default package */
public final /* synthetic */ class y2 implements View.OnClickListener {
    public final /* synthetic */ int c;
    public final /* synthetic */ CityPickerActivity d;

    public /* synthetic */ y2(CityPickerActivity cityPickerActivity, int i) {
        this.c = i;
        this.d = cityPickerActivity;
    }

    public final void onClick(View view) {
        CityPickerActivity cityPickerActivity = this.d;
        switch (this.c) {
            case 0:
                int i = CityPickerActivity.g;
                cityPickerActivity.o().a().setValue(null);
                ((MutableLiveData) cityPickerActivity.o().d.getValue()).setValue(null);
                cityPickerActivity.o().b().setValue(null);
                ((MutableLiveData) cityPickerActivity.o().f617a.getValue()).setValue(DivisionEnum.PROVINCE);
                return;
            default:
                int i2 = CityPickerActivity.g;
                ((MutableLiveData) cityPickerActivity.o().d.getValue()).setValue(null);
                cityPickerActivity.o().a().setValue(null);
                ((MutableLiveData) cityPickerActivity.o().f617a.getValue()).setValue(DivisionEnum.CITY);
                return;
        }
    }
}
