package com.ktakilat.loan.web;

import com.ktakilat.loan.web.CommonWebFragment;
import com.pendanaan.kta.databinding.CFragmentCommonWebviewBinding;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ CommonWebFragment.AnonymousClass1 c;

    public /* synthetic */ a(CommonWebFragment.AnonymousClass1 r1) {
        this.c = r1;
    }

    public final void run() {
        CFragmentCommonWebviewBinding cFragmentCommonWebviewBinding = CommonWebFragment.this.v;
        if (cFragmentCommonWebviewBinding != null) {
            cFragmentCommonWebviewBinding.refreshLayout.setRefreshing(false);
        }
    }
}
