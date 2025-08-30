package com.ktakilat.loan.mobile_check;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.ktakilat.loan.device.DeviceUtil;
import com.ktakilat.loan.web.CommonWebActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/ktakilat/loan/mobile_check/MobileCheckV2Activity$updateLink$linkSpanB$1", "Landroid/text/style/ClickableSpan;", "ktakilat_5.3.4(534)_2025-07-10-08-28_ktaInRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MobileCheckV2Activity$updateLink$linkSpanB$1 extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MobileCheckV2Activity f528a;

    public MobileCheckV2Activity$updateLink$linkSpanB$1(MobileCheckV2Activity mobileCheckV2Activity) {
        this.f528a = mobileCheckV2Activity;
    }

    public final void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "widget");
        MobileCheckV2Activity mobileCheckV2Activity = this.f528a;
        CommonWebActivity.C(mobileCheckV2Activity, DeviceUtil.f(mobileCheckV2Activity), "/Protocol/PrivacyPolicy", false, 0);
    }

    public final void updateDrawState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "ds");
        textPaint.setUnderlineText(true);
    }
}
