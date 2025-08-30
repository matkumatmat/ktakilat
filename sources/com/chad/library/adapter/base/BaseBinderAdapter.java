package com.chad.library.adapter.base;

import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/chad/library/adapter/base/BaseBinderAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "ItemCallback", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
public class BaseBinderAdapter extends BaseQuickAdapter<Object, BaseViewHolder> {

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/chad/library/adapter/base/BaseBinderAdapter$ItemCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
    public final class ItemCallback extends DiffUtil.ItemCallback<Object> {
        public final boolean areContentsTheSame(Object obj, Object obj2) {
            Intrinsics.e(obj, "oldItem");
            Intrinsics.e(obj2, "newItem");
            if (!obj.getClass().equals(obj2.getClass())) {
                return true;
            }
            throw null;
        }

        public final boolean areItemsTheSame(Object obj, Object obj2) {
            Intrinsics.e(obj, "oldItem");
            Intrinsics.e(obj2, "newItem");
            if (!obj.getClass().equals(obj2.getClass())) {
                return obj.equals(obj2);
            }
            throw null;
        }

        public final Object getChangePayload(Object obj, Object obj2) {
            Intrinsics.e(obj, "oldItem");
            Intrinsics.e(obj2, "newItem");
            if (!obj.getClass().equals(obj2.getClass())) {
                return null;
            }
            throw null;
        }
    }

    public final void b(BaseViewHolder baseViewHolder, int i) {
        Intrinsics.e(baseViewHolder, "viewHolder");
        super.b(baseViewHolder, i);
        if (this.f == null) {
            baseViewHolder.itemView.setOnClickListener(new BaseBinderAdapter$bindClick$1(this, baseViewHolder));
        }
        if (this.g == null) {
            baseViewHolder.itemView.setOnLongClickListener(new BaseBinderAdapter$bindClick$2(this, baseViewHolder));
        }
        throw null;
    }

    public final void c(BaseViewHolder baseViewHolder, Object obj) {
        Intrinsics.e(baseViewHolder, "holder");
        Intrinsics.e(obj, "item");
        baseViewHolder.getItemViewType();
        throw null;
    }

    public final void d(BaseViewHolder baseViewHolder, Object obj, List list) {
        Intrinsics.e(baseViewHolder, "holder");
        Intrinsics.e(obj, "item");
        Intrinsics.e(list, "payloads");
        baseViewHolder.getItemViewType();
        throw null;
    }

    public final int f(int i) {
        this.f179a.get(i).getClass();
        throw null;
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

    public final boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        BaseViewHolder baseViewHolder = (BaseViewHolder) viewHolder;
        Intrinsics.e(baseViewHolder, "holder");
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
}
