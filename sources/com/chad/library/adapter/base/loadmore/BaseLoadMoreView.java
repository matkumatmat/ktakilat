package com.chad.library.adapter.base.loadmore;

import android.view.View;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/chad/library/adapter/base/loadmore/BaseLoadMoreView;", "", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
public abstract class BaseLoadMoreView {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f183a;

        static {
            int[] iArr = new int[LoadMoreStatus.values().length];
            f183a = iArr;
            iArr[LoadMoreStatus.Complete.ordinal()] = 1;
            iArr[LoadMoreStatus.Loading.ordinal()] = 2;
            iArr[LoadMoreStatus.Fail.ordinal()] = 3;
            iArr[LoadMoreStatus.End.ordinal()] = 4;
        }
    }

    public final void a(BaseViewHolder baseViewHolder, LoadMoreStatus loadMoreStatus) {
        Intrinsics.e(baseViewHolder, "holder");
        Intrinsics.e(loadMoreStatus, "loadMoreStatus");
        int i = WhenMappings.f183a[loadMoreStatus.ordinal()];
        if (i == 1) {
            e(baseViewHolder).setVisibility(8);
            b(baseViewHolder).setVisibility(0);
            d(baseViewHolder).setVisibility(8);
            c(baseViewHolder).setVisibility(8);
        } else if (i == 2) {
            e(baseViewHolder).setVisibility(0);
            b(baseViewHolder).setVisibility(8);
            d(baseViewHolder).setVisibility(8);
            c(baseViewHolder).setVisibility(8);
        } else if (i == 3) {
            e(baseViewHolder).setVisibility(8);
            b(baseViewHolder).setVisibility(8);
            d(baseViewHolder).setVisibility(0);
            c(baseViewHolder).setVisibility(8);
        } else if (i == 4) {
            e(baseViewHolder).setVisibility(8);
            b(baseViewHolder).setVisibility(8);
            d(baseViewHolder).setVisibility(8);
            c(baseViewHolder).setVisibility(0);
        }
    }

    public abstract View b(BaseViewHolder baseViewHolder);

    public abstract View c(BaseViewHolder baseViewHolder);

    public abstract View d(BaseViewHolder baseViewHolder);

    public abstract View e(BaseViewHolder baseViewHolder);
}
