package com.ktakilat.loan.gesture_create;

import android.view.LayoutInflater;
import android.view.View;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.utils.FastClickUtil;
import com.ktakilat.loan.weiget.dialog.DialogUtils;
import com.pendanaan.kta.databinding.DialogGestureSkipBinding;

public final /* synthetic */ class a implements View.OnClickListener {
    public final /* synthetic */ GestureCreateActivity c;

    public /* synthetic */ a(GestureCreateActivity gestureCreateActivity) {
        this.c = gestureCreateActivity;
    }

    public final void onClick(View view) {
        int i = GestureCreateActivity.o;
        GestureCreateActivity gestureCreateActivity = this.c;
        gestureCreateActivity.getClass();
        if (FastClickUtil.a(view)) {
            KtaCollect.n_pattern_pwd_clc_skip();
            KtaCollect.n_pattern_pwd_pop1_exposure();
            DialogGestureSkipBinding inflate = DialogGestureSkipBinding.inflate(LayoutInflater.from(gestureCreateActivity));
            DialogUtils.c(gestureCreateActivity, inflate.getRoot(), inflate.nextTv, inflate.cancelTv, new DialogUtils.CommonOkAndCancleClickListern() {
                public final void a() {
                    KtaCollect.n_pattern_pwd_pop1_clc_exit();
                    GestureCreateActivity.this.onBackPressed();
                }

                public final void b() {
                    KtaCollect.n_pattern_pwd_pop1_clc_con();
                }
            }).show();
        }
    }
}
