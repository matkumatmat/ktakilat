package com.chad.library.adapter.base;

import android.view.View;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "T", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k = 3, mv = {1, 1, 16})
final class BaseProviderMultiAdapter$bindClick$2 implements View.OnLongClickListener {
    public final /* synthetic */ BaseProviderMultiAdapter c;
    public final /* synthetic */ BaseViewHolder d;

    public BaseProviderMultiAdapter$bindClick$2(BaseProviderMultiAdapter baseProviderMultiAdapter, BaseViewHolder baseViewHolder) {
        this.c = baseProviderMultiAdapter;
        this.d = baseViewHolder;
    }

    public final boolean onLongClick(View view) {
        BaseViewHolder baseViewHolder = this.d;
        if (baseViewHolder.getAdapterPosition() == -1) {
            return false;
        }
        BaseProviderMultiAdapter baseProviderMultiAdapter = this.c;
        baseProviderMultiAdapter.i();
        baseViewHolder.getItemViewType();
        baseProviderMultiAdapter.getClass();
        throw null;
    }
}
