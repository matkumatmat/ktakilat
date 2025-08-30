package defpackage;

import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;
import com.ktakilat.loan.normal_ui.SearchAddressActivity;

/* renamed from: ie  reason: default package */
public final /* synthetic */ class ie implements TextView.OnEditorActionListener {
    public final /* synthetic */ SearchAddressActivity c;

    public /* synthetic */ ie(SearchAddressActivity searchAddressActivity) {
        this.c = searchAddressActivity;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        SearchAddressActivity searchAddressActivity = this.c;
        if (i != 6) {
            int i2 = SearchAddressActivity.t;
            searchAddressActivity.getClass();
            return true;
        } else if (TextUtils.isEmpty(searchAddressActivity.p.et.getText().toString())) {
            return true;
        } else {
            Intent intent = new Intent();
            intent.putExtra("address", searchAddressActivity.p.et.getText().toString());
            searchAddressActivity.setResult(-1, intent);
            searchAddressActivity.finish();
            return true;
        }
    }
}
