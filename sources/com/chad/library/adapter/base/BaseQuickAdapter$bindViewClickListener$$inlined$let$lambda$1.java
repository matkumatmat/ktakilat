package com.chad.library.adapter.base;

import android.content.Intent;
import android.view.View;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.ktakilat.loan.banks.BanksActivity;
import com.ktakilat.loan.http.bank_card.BankResp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b¨\u0006\t"}, d2 = {"<anonymous>", "", "T", "VH", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/chad/library/adapter/base/BaseQuickAdapter$bindViewClickListener$1$1"}, k = 3, mv = {1, 1, 16})
final class BaseQuickAdapter$bindViewClickListener$$inlined$let$lambda$1 implements View.OnClickListener {
    public final /* synthetic */ BaseQuickAdapter c;
    public final /* synthetic */ BaseViewHolder d;

    public BaseQuickAdapter$bindViewClickListener$$inlined$let$lambda$1(BaseQuickAdapter baseQuickAdapter, BaseViewHolder baseViewHolder) {
        this.c = baseQuickAdapter;
        this.d = baseViewHolder;
    }

    public final void onClick(View view) {
        int adapterPosition = this.d.getAdapterPosition();
        if (adapterPosition != -1) {
            BaseQuickAdapter baseQuickAdapter = this.c;
            int i = adapterPosition - (baseQuickAdapter.i() ? 1 : 0);
            Intrinsics.b(view, "v");
            k0 k0Var = baseQuickAdapter.f;
            if (k0Var != null) {
                int i2 = BanksActivity.l;
                BanksActivity banksActivity = (BanksActivity) k0Var.d;
                banksActivity.getClass();
                Intent intent = new Intent();
                intent.putExtra("bank_result", (BankResp) baseQuickAdapter.f179a.get(i));
                banksActivity.setResult(-1, intent);
                banksActivity.onBackPressed();
            }
        }
    }
}
