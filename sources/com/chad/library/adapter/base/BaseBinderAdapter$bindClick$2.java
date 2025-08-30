package com.chad.library.adapter.base;

import android.view.View;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k = 3, mv = {1, 1, 16})
final class BaseBinderAdapter$bindClick$2 implements View.OnLongClickListener {
    public final /* synthetic */ BaseBinderAdapter c;
    public final /* synthetic */ BaseViewHolder d;

    public BaseBinderAdapter$bindClick$2(BaseBinderAdapter baseBinderAdapter, BaseViewHolder baseViewHolder) {
        this.c = baseBinderAdapter;
        this.d = baseViewHolder;
    }

    public final boolean onLongClick(View view) {
        BaseViewHolder baseViewHolder = this.d;
        if (baseViewHolder.getAdapterPosition() == -1) {
            return false;
        }
        BaseBinderAdapter baseBinderAdapter = this.c;
        baseBinderAdapter.i();
        baseViewHolder.getItemViewType();
        baseBinderAdapter.getClass();
        throw null;
    }
}
