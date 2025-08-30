package com.chad.library.adapter.base.dragswipe;

import android.graphics.Canvas;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.BaseDraggableModule;
import java.util.Collections;
import kotlin.jvm.internal.Intrinsics;

public class DragAndSwipeCallback extends ItemTouchHelper.Callback {

    /* renamed from: a  reason: collision with root package name */
    public BaseDraggableModule f182a;
    public float b;
    public float c;
    public int d;
    public int e;

    public static boolean a(RecyclerView.ViewHolder viewHolder) {
        int itemViewType = viewHolder.getItemViewType();
        if (itemViewType == 268435729 || itemViewType == 268436002 || itemViewType == 268436275 || itemViewType == 268436821) {
            return true;
        }
        return false;
    }

    public final void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        if (!a(viewHolder)) {
            View view = viewHolder.itemView;
            int i = R.id.BaseQuickAdapter_dragging_support;
            if (view.getTag(i) != null && ((Boolean) viewHolder.itemView.getTag(i)).booleanValue()) {
                viewHolder.itemView.setTag(i, Boolean.FALSE);
            }
            View view2 = viewHolder.itemView;
            int i2 = R.id.BaseQuickAdapter_swiping_support;
            if (view2.getTag(i2) != null && ((Boolean) viewHolder.itemView.getTag(i2)).booleanValue()) {
                viewHolder.itemView.setTag(i2, Boolean.FALSE);
            }
        }
    }

    public final float getMoveThreshold(RecyclerView.ViewHolder viewHolder) {
        return this.b;
    }

    public final int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        if (a(viewHolder)) {
            return ItemTouchHelper.Callback.makeMovementFlags(0, 0);
        }
        return ItemTouchHelper.Callback.makeMovementFlags(this.d, this.e);
    }

    public final float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
        return this.c;
    }

    public final boolean isItemViewSwipeEnabled() {
        BaseDraggableModule baseDraggableModule = this.f182a;
        if (baseDraggableModule != null) {
            baseDraggableModule.getClass();
        }
        return false;
    }

    public final boolean isLongPressDragEnabled() {
        BaseDraggableModule baseDraggableModule = this.f182a;
        if (baseDraggableModule != null) {
            baseDraggableModule.getClass();
        }
        return false;
    }

    public final void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
        super.onChildDrawOver(canvas, recyclerView, viewHolder, f, f2, i, z);
        if (i == 1 && !a(viewHolder)) {
            View view = viewHolder.itemView;
            canvas.save();
            if (f > 0.0f) {
                canvas.clipRect((float) view.getLeft(), (float) view.getTop(), ((float) view.getLeft()) + f, (float) view.getBottom());
                canvas.translate((float) view.getLeft(), (float) view.getTop());
            } else {
                canvas.clipRect(((float) view.getRight()) + f, (float) view.getTop(), (float) view.getRight(), (float) view.getBottom());
                canvas.translate(((float) view.getRight()) + f, (float) view.getTop());
            }
            canvas.restore();
        }
    }

    public final boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        if (viewHolder.getItemViewType() == viewHolder2.getItemViewType()) {
            return true;
        }
        return false;
    }

    public final void onMoved(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i, RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4) {
        super.onMoved(recyclerView, viewHolder, i, viewHolder2, i2, i3, i4);
        BaseDraggableModule baseDraggableModule = this.f182a;
        if (baseDraggableModule != null) {
            Intrinsics.e(viewHolder, "source");
            Intrinsics.e(viewHolder2, TypedValues.AttributesType.S_TARGET);
            int adapterPosition = viewHolder.getAdapterPosition();
            BaseQuickAdapter baseQuickAdapter = baseDraggableModule.b;
            int i5 = adapterPosition - (baseQuickAdapter.i() ? 1 : 0);
            int adapterPosition2 = viewHolder2.getAdapterPosition() - (baseQuickAdapter.i() ? 1 : 0);
            if (baseDraggableModule.a(i5) && baseDraggableModule.a(adapterPosition2)) {
                if (i5 < adapterPosition2) {
                    while (i5 < adapterPosition2) {
                        int i6 = i5 + 1;
                        Collections.swap(baseQuickAdapter.f179a, i5, i6);
                        i5 = i6;
                    }
                } else {
                    int i7 = adapterPosition2 + 1;
                    if (i5 >= i7) {
                        while (true) {
                            Collections.swap(baseQuickAdapter.f179a, i5, i5 - 1);
                            if (i5 == i7) {
                                break;
                            }
                            i5--;
                        }
                    }
                }
                baseQuickAdapter.notifyItemMoved(viewHolder.getAdapterPosition(), viewHolder2.getAdapterPosition());
            }
        }
    }

    public final void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
        if (i == 2 && !a(viewHolder)) {
            viewHolder.itemView.setTag(R.id.BaseQuickAdapter_dragging_support, Boolean.TRUE);
        } else if (i == 1 && !a(viewHolder)) {
            viewHolder.itemView.setTag(R.id.BaseQuickAdapter_swiping_support, Boolean.TRUE);
        }
        super.onSelectedChanged(viewHolder, i);
    }

    public final void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        BaseDraggableModule baseDraggableModule;
        if (!a(viewHolder) && (baseDraggableModule = this.f182a) != null) {
            int adapterPosition = viewHolder.getAdapterPosition();
            BaseQuickAdapter baseQuickAdapter = baseDraggableModule.b;
            int i2 = adapterPosition - (baseQuickAdapter.i() ? 1 : 0);
            if (baseDraggableModule.a(i2)) {
                baseQuickAdapter.f179a.remove(i2);
                baseQuickAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        }
    }
}
