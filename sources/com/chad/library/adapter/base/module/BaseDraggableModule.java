package com.chad.library.adapter.base.module;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.DraggableListenerImp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/chad/library/adapter/base/module/BaseDraggableModule;", "Lcom/chad/library/adapter/base/listener/DraggableListenerImp;", "Companion", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
public class BaseDraggableModule implements DraggableListenerImp {

    /* renamed from: a  reason: collision with root package name */
    public final ItemTouchHelper f184a;
    public final BaseQuickAdapter b;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/chad/library/adapter/base/module/BaseDraggableModule$Companion;", "", "", "NO_TOGGLE_VIEW", "I", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [com.chad.library.adapter.base.dragswipe.DragAndSwipeCallback, androidx.recyclerview.widget.ItemTouchHelper$Callback] */
    public BaseDraggableModule(BaseQuickAdapter baseQuickAdapter) {
        this.b = baseQuickAdapter;
        ? callback = new ItemTouchHelper.Callback();
        callback.b = 0.1f;
        callback.c = 0.7f;
        callback.d = 15;
        callback.e = 32;
        callback.f182a = this;
        this.f184a = new ItemTouchHelper(callback);
    }

    public final boolean a(int i) {
        if (i < 0 || i >= this.b.f179a.size()) {
            return false;
        }
        return true;
    }
}
