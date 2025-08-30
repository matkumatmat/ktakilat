package com.ktakilat.loan.widgets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.loan.global.AppKv;
import com.ktakilat.loan.http.AppHttp;
import com.ktakilat.loan.http.division.DivisionEnum;
import com.ktakilat.loan.http.division.DivisionItem;
import com.pendanaan.kta.databinding.FragmentCityPickerBinding;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;
import com.trello.rxlifecycle2.LifecycleTransformer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ktakilat/loan/widgets/CityPickerFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "Companion", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CityPickerFragment extends Fragment {
    public String c = "province";
    public DivisionEnum d = DivisionEnum.PROVINCE;
    public Integer e;
    public FragmentCityPickerBinding f;
    public List g;
    public CityPickerFragViewModel i;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0003\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ktakilat/loan/widgets/CityPickerFragment$Companion;", "", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public static CityPickerFragment a(String str, Integer num) {
            Intrinsics.checkNotNullParameter(str, "type");
            CityPickerFragment cityPickerFragment = new CityPickerFragment();
            Bundle c = e.c("type", str);
            if (num != null) {
                c.putInt("parentCode", num.intValue());
            }
            cityPickerFragment.setArguments(c);
            return cityPickerFragment;
        }
    }

    public final FragmentCityPickerBinding b() {
        FragmentCityPickerBinding fragmentCityPickerBinding = this.f;
        if (fragmentCityPickerBinding != null) {
            return fragmentCityPickerBinding;
        }
        Intrinsics.k("binding");
        throw null;
    }

    public final void c() {
        int i2;
        Integer num;
        b().refresher.setRefreshing(true);
        String str = this.c;
        Integer num2 = this.e;
        if (num2 != null) {
            i2 = num2.intValue();
        } else {
            i2 = 0;
        }
        List i3 = AppKv.i(i2, str);
        Collection collection = i3;
        if (collection != null && !collection.isEmpty()) {
            d(i3);
        }
        DivisionEnum divisionEnum = this.d;
        Integer num3 = this.e;
        if ((num3 != null && num3.intValue() == 0) || (num = this.e) == null) {
            num = null;
        }
        AppHttp.getDivision((LifecycleTransformer<BaseResponse<List<DivisionItem>>>) null, divisionEnum, num).subscribe(new CityPickerFragment$loadData$1(this));
    }

    public final void d(List list) {
        Intrinsics.checkNotNullParameter(list, "values");
        this.g = list;
        RecyclerView.Adapter adapter = b().regionList.getAdapter();
        Intrinsics.d(adapter, "null cannot be cast to non-null type com.ktakilat.loan.widgets.RegionAdapter");
        RegionAdapter regionAdapter = (RegionAdapter) adapter;
        Intrinsics.checkNotNullParameter(list, "values");
        ArrayList arrayList = regionAdapter.d;
        arrayList.clear();
        arrayList.addAll(list);
        regionAdapter.notifyDataSetChanged();
    }

    public final void onCreate(Bundle bundle) {
        DivisionEnum divisionEnum;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("type");
            if (string == null) {
                string = "province";
            }
            this.c = string;
            int hashCode = string.hashCode();
            if (hashCode != -987485392) {
                if (hashCode != 3053931) {
                    if (hashCode == 288961422 && string.equals("district")) {
                        divisionEnum = DivisionEnum.DISTRUCT;
                        this.d = divisionEnum;
                        this.e = Integer.valueOf(arguments.getInt("parentCode"));
                    }
                } else if (string.equals("city")) {
                    divisionEnum = DivisionEnum.CITY;
                    this.d = divisionEnum;
                    this.e = Integer.valueOf(arguments.getInt("parentCode"));
                }
            } else if (string.equals("province")) {
                divisionEnum = DivisionEnum.PROVINCE;
                this.d = divisionEnum;
                this.e = Integer.valueOf(arguments.getInt("parentCode"));
            }
            divisionEnum = DivisionEnum.PROVINCE;
            this.d = divisionEnum;
            this.e = Integer.valueOf(arguments.getInt("parentCode"));
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentCityPickerBinding inflate = FragmentCityPickerBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullParameter(inflate, "<set-?>");
        this.f = inflate;
        LinearLayout root = b().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        this.i = (CityPickerFragViewModel) new ViewModelProvider((ViewModelStoreOwner) requireActivity).get(CityPickerFragViewModel.class);
        FastScrollRecyclerView fastScrollRecyclerView = b().regionList;
        fastScrollRecyclerView.setLayoutManager(new LinearLayoutManager(fastScrollRecyclerView.getContext()));
        fastScrollRecyclerView.setAutoHideEnabled(false);
        CityPickerFragViewModel cityPickerFragViewModel = this.i;
        if (cityPickerFragViewModel != null) {
            fastScrollRecyclerView.setAdapter(new RegionAdapter(cityPickerFragViewModel, this.d, this.c));
            c();
            b().refresher.setOnRefreshListener(new k0(this, 10));
            b().searchBar.addTextChangedListener(new CityPickerFragment$onViewCreated$3(this));
            return;
        }
        Intrinsics.k("vm");
        throw null;
    }
}
