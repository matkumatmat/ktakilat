package com.chad.library.adapter.base;

import com.chad.library.adapter.base.entity.SectionEntity;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¨\u0006\u0006"}, d2 = {"Lcom/chad/library/adapter/base/BaseSectionQuickAdapter;", "Lcom/chad/library/adapter/base/entity/SectionEntity;", "T", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "VH", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
public abstract class BaseSectionQuickAdapter<T extends SectionEntity, VH extends BaseViewHolder> extends BaseMultiItemQuickAdapter<T, VH> {
    public final boolean j(int i) {
        if (super.j(i) || i == -99) {
            return true;
        }
        return false;
    }

    /* renamed from: k */
    public final void onBindViewHolder(BaseViewHolder baseViewHolder, int i) {
        Intrinsics.e(baseViewHolder, "holder");
        if (baseViewHolder.getItemViewType() == -99) {
            SectionEntity sectionEntity = (SectionEntity) this.f179a.get(i - (i() ? 1 : 0));
            p();
            return;
        }
        super.onBindViewHolder(baseViewHolder, i);
    }

    /* renamed from: l */
    public final void onBindViewHolder(BaseViewHolder baseViewHolder, int i, List list) {
        Intrinsics.e(baseViewHolder, "holder");
        Intrinsics.e(list, "payloads");
        if (list.isEmpty()) {
            onBindViewHolder(baseViewHolder, i);
        } else if (baseViewHolder.getItemViewType() == -99) {
            Intrinsics.e((SectionEntity) this.f179a.get(i - (i() ? 1 : 0)), "item");
        } else {
            super.onBindViewHolder(baseViewHolder, i, list);
        }
    }

    public abstract void p();
}
