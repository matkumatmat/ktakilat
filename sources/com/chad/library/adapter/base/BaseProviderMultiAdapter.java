package com.chad.library.adapter.base;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "T", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
public abstract class BaseProviderMultiAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {
    public final void b(BaseViewHolder baseViewHolder, int i) {
        Intrinsics.e(baseViewHolder, "viewHolder");
        super.b(baseViewHolder, i);
        if (this.f == null) {
            baseViewHolder.itemView.setOnClickListener(new BaseProviderMultiAdapter$bindClick$1(this, baseViewHolder));
        }
        if (this.g == null) {
            baseViewHolder.itemView.setOnLongClickListener(new BaseProviderMultiAdapter$bindClick$2(this, baseViewHolder));
        }
        throw null;
    }

    public final void c(BaseViewHolder baseViewHolder, Object obj) {
        Intrinsics.e(baseViewHolder, "holder");
        baseViewHolder.getItemViewType();
        throw null;
    }

    public final void d(BaseViewHolder baseViewHolder, Object obj, List list) {
        Intrinsics.e(baseViewHolder, "holder");
        Intrinsics.e(list, "payloads");
        baseViewHolder.getItemViewType();
        throw null;
    }

    public final int f(int i) {
        return p();
    }

    public final BaseViewHolder m(ViewGroup viewGroup) {
        Intrinsics.e(viewGroup, "parent");
        throw null;
    }

    public final void n(BaseViewHolder baseViewHolder) {
        Intrinsics.e(baseViewHolder, "holder");
        super.onViewAttachedToWindow(baseViewHolder);
        baseViewHolder.getItemViewType();
        throw null;
    }

    public final /* bridge */ /* synthetic */ void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        n((BaseViewHolder) viewHolder);
        throw null;
    }

    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        BaseViewHolder baseViewHolder = (BaseViewHolder) viewHolder;
        Intrinsics.e(baseViewHolder, "holder");
        super.onViewDetachedFromWindow(baseViewHolder);
        baseViewHolder.getItemViewType();
        throw null;
    }

    public abstract int p();
}
