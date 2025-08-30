package com.ktakilat.loan.widgets;

import com.ktakilat.cbase.cache.KvSave;
import com.ktakilat.cbase.http.ApiObserver;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.cbase.utils.JsonUtil;
import com.ktakilat.loan.global.AppKv;
import com.ktakilat.loan.http.division.DivisionItem;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001¨\u0006\u0005"}, d2 = {"com/ktakilat/loan/widgets/CityPickerFragment$loadData$1", "Lcom/ktakilat/cbase/http/ApiObserver;", "Lcom/ktakilat/cbase/http/BaseResponse;", "", "Lcom/ktakilat/loan/http/division/DivisionItem;", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CityPickerFragment$loadData$1 extends ApiObserver<BaseResponse<List<? extends DivisionItem>>> {
    public final /* synthetic */ CityPickerFragment c;

    public CityPickerFragment$loadData$1(CityPickerFragment cityPickerFragment) {
        this.c = cityPickerFragment;
    }

    public final void a(BaseResponse baseResponse) {
        this.c.b().refresher.setRefreshing(false);
    }

    public final void b(BaseResponse baseResponse) {
        List list;
        int i;
        CityPickerFragment cityPickerFragment = this.c;
        if (!(baseResponse == null || (list = (List) baseResponse.getData()) == null)) {
            String str = cityPickerFragment.c;
            Integer num = cityPickerFragment.e;
            if (num != null) {
                i = num.intValue();
            } else {
                i = 0;
            }
            KvSave g = AppKv.g();
            g.b("region_info_" + str + "_" + i, JsonUtil.a(list));
            cityPickerFragment.d(list);
        }
        cityPickerFragment.b().refresher.setRefreshing(false);
    }
}
