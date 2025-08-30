package com.chad.library.adapter.base.module;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.LoadMoreListenerImp;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/chad/library/adapter/base/module/BaseLoadMoreModule;", "Lcom/chad/library/adapter/base/listener/LoadMoreListenerImp;", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
public class BaseLoadMoreModule implements LoadMoreListenerImp {

    /* renamed from: a  reason: collision with root package name */
    public LoadMoreStatus f185a = LoadMoreStatus.Complete;
    public final BaseQuickAdapter b;

    public BaseLoadMoreModule(BaseQuickAdapter baseQuickAdapter) {
        this.b = baseQuickAdapter;
    }

    public final void a(BaseViewHolder baseViewHolder) {
        baseViewHolder.itemView.setOnClickListener(new BaseLoadMoreModule$setupViewHolder$1(this));
    }
}
