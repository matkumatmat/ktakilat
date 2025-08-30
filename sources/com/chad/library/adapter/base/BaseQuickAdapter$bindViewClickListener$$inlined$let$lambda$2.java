package com.chad.library.adapter.base;

import android.view.View;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b¨\u0006\t"}, d2 = {"<anonymous>", "", "T", "VH", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/chad/library/adapter/base/BaseQuickAdapter$bindViewClickListener$2$1"}, k = 3, mv = {1, 1, 16})
final class BaseQuickAdapter$bindViewClickListener$$inlined$let$lambda$2 implements View.OnLongClickListener {
    public final /* synthetic */ BaseQuickAdapter c;
    public final /* synthetic */ BaseViewHolder d;

    public BaseQuickAdapter$bindViewClickListener$$inlined$let$lambda$2(BaseQuickAdapter baseQuickAdapter, BaseViewHolder baseViewHolder) {
        this.c = baseQuickAdapter;
        this.d = baseViewHolder;
    }

    public final boolean onLongClick(View view) {
        int adapterPosition = this.d.getAdapterPosition();
        if (adapterPosition == -1) {
            return false;
        }
        BaseQuickAdapter baseQuickAdapter = this.c;
        int i = adapterPosition - (baseQuickAdapter.i() ? 1 : 0);
        Intrinsics.b(view, "v");
        OnItemLongClickListener onItemLongClickListener = baseQuickAdapter.g;
        if (onItemLongClickListener == null) {
            return false;
        }
        onItemLongClickListener.c(baseQuickAdapter, i);
        return true;
    }
}
