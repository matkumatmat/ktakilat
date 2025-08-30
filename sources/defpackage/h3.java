package defpackage;

import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.ktakilat.loan.web.CommonWebActivity;
import com.ktakilat.loan.web.CommonWebFragment;

/* renamed from: h3  reason: default package */
public final /* synthetic */ class h3 implements CommonWebFragment.WebCallback, OnApplyWindowInsetsListener {
    public final /* synthetic */ CommonWebActivity c;

    public /* synthetic */ h3(CommonWebActivity commonWebActivity) {
        this.c = commonWebActivity;
    }

    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        int i = CommonWebActivity.p;
        CommonWebActivity commonWebActivity = this.c;
        Insets insets = windowInsetsCompat.getInsets(commonWebActivity.r());
        try {
            view.setPadding(0, insets.top, 0, insets.bottom);
            commonWebActivity.B();
        } catch (Exception unused) {
        }
        return WindowInsetsCompat.CONSUMED;
    }
}
