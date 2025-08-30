package defpackage;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.facebook.appevents.AppEventsConstants;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.loan.http.AppHttp;
import com.ktakilat.loan.http.login.MobileCheckResp;
import com.ktakilat.loan.mobile_check.MobileCheckV2Activity;
import com.ktakilat.loan.mobile_check.MobileCheckViewModel;
import com.ktakilat.loan.mobile_check.MobileCheckViewModel$checkMobile$1;
import com.trello.rxlifecycle2.LifecycleTransformer;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: uc  reason: default package */
public final /* synthetic */ class uc implements View.OnClickListener {
    public final /* synthetic */ int c;
    public final /* synthetic */ MobileCheckV2Activity d;

    public /* synthetic */ uc(MobileCheckV2Activity mobileCheckV2Activity, int i) {
        this.c = i;
        this.d = mobileCheckV2Activity;
    }

    public final void onClick(View view) {
        MobileCheckV2Activity mobileCheckV2Activity = this.d;
        switch (this.c) {
            case 0:
                int i = MobileCheckV2Activity.g;
                KtaCollect.n_ojk_disclaimer_pop_up(AppEventsConstants.EVENT_PARAM_VALUE_YES);
                mobileCheckV2Activity.o().getClass();
                AppHttp.ojkStatementSave((LifecycleTransformer<BaseResponse<Object>>) null).subscribe();
                return;
            default:
                int i2 = MobileCheckV2Activity.g;
                String valueOf = String.valueOf(mobileCheckV2Activity.n().editText.getText());
                KtaCollect.n_phone_judge_page_clc_continue();
                MobileCheckViewModel o = mobileCheckV2Activity.o();
                o.getClass();
                Intrinsics.checkNotNullParameter(valueOf, "mobile");
                ((MutableLiveData) o.f529a.getValue()).setValue(Boolean.TRUE);
                AppHttp.mobileCheck((LifecycleTransformer<BaseResponse<MobileCheckResp>>) null, valueOf).subscribe(new MobileCheckViewModel$checkMobile$1(o));
                return;
        }
    }
}
