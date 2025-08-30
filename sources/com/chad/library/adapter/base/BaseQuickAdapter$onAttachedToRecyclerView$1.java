package com.chad.library.adapter.base;

import androidx.recyclerview.widget.GridLayoutManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/chad/library/adapter/base/BaseQuickAdapter$onAttachedToRecyclerView$1", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
public final class BaseQuickAdapter$onAttachedToRecyclerView$1 extends GridLayoutManager.SpanSizeLookup {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseQuickAdapter f180a;
    public final /* synthetic */ GridLayoutManager b;
    public final /* synthetic */ GridLayoutManager.SpanSizeLookup c;

    public BaseQuickAdapter$onAttachedToRecyclerView$1(BaseQuickAdapter baseQuickAdapter, GridLayoutManager gridLayoutManager, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        this.f180a = baseQuickAdapter;
        this.b = gridLayoutManager;
        this.c = spanSizeLookup;
    }

    public final int getSpanSize(int i) {
        BaseQuickAdapter baseQuickAdapter = this.f180a;
        if (baseQuickAdapter.j(baseQuickAdapter.getItemViewType(i))) {
            return this.b.getSpanCount();
        }
        return this.c.getSpanSize(i);
    }
}
