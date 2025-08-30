package com.chad.library.adapter.base.module;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
final class BaseLoadMoreModule$setupViewHolder$1 implements View.OnClickListener {
    public final /* synthetic */ BaseLoadMoreModule c;

    public BaseLoadMoreModule$setupViewHolder$1(BaseLoadMoreModule baseLoadMoreModule) {
        this.c = baseLoadMoreModule;
    }

    public final void onClick(View view) {
        LoadMoreStatus loadMoreStatus;
        BaseLoadMoreModule baseLoadMoreModule = this.c;
        LoadMoreStatus loadMoreStatus2 = baseLoadMoreModule.f185a;
        LoadMoreStatus loadMoreStatus3 = LoadMoreStatus.Fail;
        int i = -1;
        BaseQuickAdapter baseQuickAdapter = baseLoadMoreModule.b;
        if (loadMoreStatus2 == loadMoreStatus3) {
            LoadMoreStatus loadMoreStatus4 = LoadMoreStatus.Loading;
            if (loadMoreStatus2 != loadMoreStatus4) {
                baseLoadMoreModule.f185a = loadMoreStatus4;
                if (!baseQuickAdapter.g()) {
                    i = baseQuickAdapter.f179a.size() + (baseQuickAdapter.i() ? 1 : 0) + (baseQuickAdapter.h() ? 1 : 0);
                }
                baseQuickAdapter.notifyItemChanged(i);
                baseLoadMoreModule.f185a = loadMoreStatus4;
                RecyclerView recyclerView = baseQuickAdapter.j;
                if (recyclerView != null) {
                    recyclerView.post(new BaseLoadMoreModule$invokeLoadMoreListener$$inlined$let$lambda$1(baseLoadMoreModule));
                }
            }
        } else if (loadMoreStatus2 == LoadMoreStatus.Complete && loadMoreStatus2 != (loadMoreStatus = LoadMoreStatus.Loading)) {
            baseLoadMoreModule.f185a = loadMoreStatus;
            if (!baseQuickAdapter.g()) {
                i = baseQuickAdapter.f179a.size() + (baseQuickAdapter.i() ? 1 : 0) + (baseQuickAdapter.h() ? 1 : 0);
            }
            baseQuickAdapter.notifyItemChanged(i);
            baseLoadMoreModule.f185a = loadMoreStatus;
            RecyclerView recyclerView2 = baseQuickAdapter.j;
            if (recyclerView2 != null) {
                recyclerView2.post(new BaseLoadMoreModule$invokeLoadMoreListener$$inlined$let$lambda$1(baseLoadMoreModule));
            }
        }
    }
}
