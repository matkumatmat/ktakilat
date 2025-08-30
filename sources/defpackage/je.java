package defpackage;

import android.content.Intent;
import android.view.View;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.loan.normal_ui.SearchAddressActivity;

/* renamed from: je  reason: default package */
public final /* synthetic */ class je implements View.OnClickListener {
    public final /* synthetic */ int c;
    public final /* synthetic */ SearchAddressActivity d;

    public /* synthetic */ je(SearchAddressActivity searchAddressActivity, int i) {
        this.c = i;
        this.d = searchAddressActivity;
    }

    public final void onClick(View view) {
        SearchAddressActivity searchAddressActivity = this.d;
        switch (this.c) {
            case 0:
                int i = SearchAddressActivity.t;
                searchAddressActivity.getClass();
                KtaCollect.n_company_search_clc_confirm();
                Intent intent = new Intent();
                intent.putExtra("address", searchAddressActivity.p.et.getText().toString());
                searchAddressActivity.setResult(-1, intent);
                searchAddressActivity.finish();
                return;
            default:
                int i2 = SearchAddressActivity.t;
                searchAddressActivity.onBackPressed();
                return;
        }
    }
}
