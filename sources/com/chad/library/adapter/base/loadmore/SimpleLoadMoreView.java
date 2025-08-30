package com.chad.library.adapter.base.loadmore;

import android.view.View;
import com.chad.library.R;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/chad/library/adapter/base/loadmore/SimpleLoadMoreView;", "Lcom/chad/library/adapter/base/loadmore/BaseLoadMoreView;", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
public final class SimpleLoadMoreView extends BaseLoadMoreView {
    public final View b(BaseViewHolder baseViewHolder) {
        Intrinsics.e(baseViewHolder, "holder");
        return baseViewHolder.getView(R.id.load_more_load_complete_view);
    }

    public final View c(BaseViewHolder baseViewHolder) {
        Intrinsics.e(baseViewHolder, "holder");
        return baseViewHolder.getView(R.id.load_more_load_end_view);
    }

    public final View d(BaseViewHolder baseViewHolder) {
        Intrinsics.e(baseViewHolder, "holder");
        return baseViewHolder.getView(R.id.load_more_load_fail_view);
    }

    public final View e(BaseViewHolder baseViewHolder) {
        Intrinsics.e(baseViewHolder, "holder");
        return baseViewHolder.getView(R.id.load_more_loading_view);
    }
}
