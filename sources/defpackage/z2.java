package defpackage;

import android.content.Intent;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.ktakilat.loan.R;
import com.ktakilat.loan.http.division.DivisionEnum;
import com.ktakilat.loan.http.division.DivisionItem;
import com.ktakilat.loan.widgets.CityPickerActivity;
import com.ktakilat.loan.widgets.CityPickerFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: z2  reason: default package */
public final /* synthetic */ class z2 implements Function1 {
    public final /* synthetic */ int c;
    public final /* synthetic */ CityPickerActivity d;

    public /* synthetic */ z2(CityPickerActivity cityPickerActivity, int i) {
        this.c = i;
        this.d = cityPickerActivity;
    }

    public final Object invoke(Object obj) {
        String str;
        String str2;
        Integer num;
        String str3;
        Integer num2;
        Integer num3;
        Integer num4 = null;
        int i = -1;
        CityPickerActivity cityPickerActivity = this.d;
        switch (this.c) {
            case 0:
                DivisionItem divisionItem = (DivisionItem) obj;
                int i2 = CityPickerActivity.g;
                if (divisionItem == null || divisionItem.getName() == null) {
                    cityPickerActivity.n().provinceSwitch.setText(cityPickerActivity.getString(R.string.please_select));
                } else {
                    cityPickerActivity.n().provinceSwitch.setText(divisionItem.getName());
                }
                return Unit.f696a;
            case 1:
                DivisionItem divisionItem2 = (DivisionItem) obj;
                int i3 = CityPickerActivity.g;
                TextView textView = cityPickerActivity.n().citySwitch;
                if (divisionItem2 == null || (str = divisionItem2.getName()) == null) {
                    str = cityPickerActivity.getString(R.string.please_select);
                    Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
                }
                textView.setText(str);
                return Unit.f696a;
            case 2:
                DivisionItem divisionItem3 = (DivisionItem) obj;
                int i4 = CityPickerActivity.g;
                if (divisionItem3 != null) {
                    Intent intent = new Intent();
                    DivisionItem divisionItem4 = (DivisionItem) cityPickerActivity.o().b().getValue();
                    if (divisionItem4 != null) {
                        str2 = divisionItem4.getName();
                    } else {
                        str2 = null;
                    }
                    intent.putExtra("provName", str2);
                    DivisionItem divisionItem5 = (DivisionItem) cityPickerActivity.o().b().getValue();
                    if (divisionItem5 != null) {
                        num = divisionItem5.getId();
                    } else {
                        num = null;
                    }
                    intent.putExtra("provId", num);
                    DivisionItem divisionItem6 = (DivisionItem) cityPickerActivity.o().a().getValue();
                    if (divisionItem6 != null) {
                        str3 = divisionItem6.getName();
                    } else {
                        str3 = null;
                    }
                    intent.putExtra("cityName", str3);
                    DivisionItem divisionItem7 = (DivisionItem) cityPickerActivity.o().a().getValue();
                    if (divisionItem7 != null) {
                        num4 = divisionItem7.getId();
                    }
                    intent.putExtra("cityId", num4);
                    intent.putExtra("districtName", divisionItem3.getName());
                    Integer id = divisionItem3.getId();
                    Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
                    intent.putExtra("districtId", id.intValue());
                    cityPickerActivity.setResult(-1, intent);
                    cityPickerActivity.finish();
                }
                return Unit.f696a;
            default:
                DivisionEnum divisionEnum = (DivisionEnum) obj;
                int i5 = CityPickerActivity.g;
                cityPickerActivity.d = cityPickerActivity.getSupportFragmentManager();
                if (divisionEnum != null) {
                    i = CityPickerActivity.WhenMappings.f614a[divisionEnum.ordinal()];
                }
                if (i == 1) {
                    cityPickerActivity.e = CityPickerFragment.Companion.a("province", (Integer) null);
                    cityPickerActivity.n().citySwitch.setVisibility(8);
                    cityPickerActivity.n().districtSwitch.setVisibility(8);
                } else if (i == 2) {
                    DivisionItem divisionItem8 = (DivisionItem) cityPickerActivity.o().b().getValue();
                    if (divisionItem8 != null) {
                        num2 = divisionItem8.getId();
                    } else {
                        num2 = null;
                    }
                    cityPickerActivity.e = CityPickerFragment.Companion.a("city", num2);
                    cityPickerActivity.n().districtSwitch.setVisibility(8);
                    cityPickerActivity.n().citySwitch.setVisibility(0);
                } else if (i == 3) {
                    DivisionItem divisionItem9 = (DivisionItem) cityPickerActivity.o().a().getValue();
                    if (divisionItem9 != null) {
                        num3 = divisionItem9.getId();
                    } else {
                        num3 = null;
                    }
                    cityPickerActivity.e = CityPickerFragment.Companion.a("district", num3);
                    cityPickerActivity.n().districtSwitch.setVisibility(0);
                }
                FragmentManager fragmentManager = cityPickerActivity.d;
                if (fragmentManager != null) {
                    FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
                    int id2 = cityPickerActivity.n().fragmentContainer.getId();
                    CityPickerFragment cityPickerFragment = cityPickerActivity.e;
                    if (cityPickerFragment != null) {
                        beginTransaction.replace(id2, cityPickerFragment).commit();
                        return Unit.f696a;
                    }
                    Intrinsics.k("stateFrag");
                    throw null;
                }
                Intrinsics.k("fm");
                throw null;
        }
    }
}
