package com.chad.library.adapter.base;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.chad.library.R;
import com.chad.library.adapter.base.listener.BaseListenerImp;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.chad.library.adapter.base.module.BaseDraggableModule;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.chad.library.adapter.base.module.DraggableModule;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.module.LoadMoreModuleConfig;
import com.chad.library.adapter.base.module.UpFetchModule;
import com.chad.library.adapter.base.util.AdapterUtilsKt;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericSignatureFormatError;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\b\u0012\u0004\u0012\u00028\u00010\u00042\u00020\u00052\u00020\u0006:\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/chad/library/adapter/base/BaseQuickAdapter;", "T", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "VH", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapterModuleImp;", "Lcom/chad/library/adapter/base/listener/BaseListenerImp;", "AnimationType", "Companion", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
public abstract class BaseQuickAdapter<T, VH extends BaseViewHolder> extends RecyclerView.Adapter<VH> implements BaseQuickAdapterModuleImp, BaseListenerImp {

    /* renamed from: a  reason: collision with root package name */
    public List f179a;
    public final boolean b = true;
    public LinearLayout c;
    public LinearLayout d;
    public FrameLayout e;
    public k0 f;
    public OnItemLongClickListener g;
    public final BaseDraggableModule h;
    public final BaseLoadMoreModule i;
    public RecyclerView j;
    public final int k;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/chad/library/adapter/base/BaseQuickAdapter$AnimationType;", "", "AlphaIn", "ScaleIn", "SlideInBottom", "SlideInLeft", "SlideInRight", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
    public enum AnimationType {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/chad/library/adapter/base/BaseQuickAdapter$Companion;", "", "", "EMPTY_VIEW", "I", "FOOTER_VIEW", "HEADER_VIEW", "LOAD_MORE_VIEW", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[AnimationType.values().length];
            iArr[AnimationType.AlphaIn.ordinal()] = 1;
            iArr[AnimationType.ScaleIn.ordinal()] = 2;
            iArr[AnimationType.SlideInBottom.ordinal()] = 3;
            iArr[AnimationType.SlideInLeft.ordinal()] = 4;
            iArr[AnimationType.SlideInRight.ordinal()] = 5;
        }
    }

    public BaseQuickAdapter(int i2, ArrayList arrayList) {
        this.k = i2;
        this.f179a = arrayList;
        if (this instanceof LoadMoreModule) {
            this.i = new BaseLoadMoreModule(this);
        }
        boolean z = this instanceof UpFetchModule;
        if (this instanceof DraggableModule) {
            this.h = new BaseDraggableModule(this);
        }
        new LinkedHashSet();
        new LinkedHashSet();
    }

    public void b(BaseViewHolder baseViewHolder, int i2) {
        Intrinsics.e(baseViewHolder, "viewHolder");
        if (this.f != null) {
            baseViewHolder.itemView.setOnClickListener(new BaseQuickAdapter$bindViewClickListener$$inlined$let$lambda$1(this, baseViewHolder));
        }
        if (this.g != null) {
            baseViewHolder.itemView.setOnLongClickListener(new BaseQuickAdapter$bindViewClickListener$$inlined$let$lambda$2(this, baseViewHolder));
        }
    }

    public abstract void c(BaseViewHolder baseViewHolder, Object obj);

    public void d(BaseViewHolder baseViewHolder, Object obj, List list) {
        Intrinsics.e(baseViewHolder, "holder");
        Intrinsics.e(list, "payloads");
    }

    public final BaseViewHolder e(View view) {
        BaseViewHolder baseViewHolder;
        BaseViewHolder baseViewHolder2;
        Class cls;
        Intrinsics.e(view, "view");
        Class cls2 = getClass();
        BaseViewHolder baseViewHolder3 = null;
        Class cls3 = null;
        while (cls3 == null && cls2 != null) {
            try {
                Type genericSuperclass = cls2.getGenericSuperclass();
                if (genericSuperclass instanceof ParameterizedType) {
                    Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                    Intrinsics.b(actualTypeArguments, "type.actualTypeArguments");
                    int length = actualTypeArguments.length;
                    int i2 = 0;
                    while (i2 < length) {
                        Type type = actualTypeArguments[i2];
                        Class<BaseViewHolder> cls4 = BaseViewHolder.class;
                        if (!(type instanceof Class)) {
                            if (type instanceof ParameterizedType) {
                                Type rawType = ((ParameterizedType) type).getRawType();
                                Intrinsics.b(rawType, "temp.rawType");
                                if ((rawType instanceof Class) && cls4.isAssignableFrom((Class) rawType)) {
                                    cls = (Class) rawType;
                                }
                            } else {
                                continue;
                            }
                            i2++;
                        } else if (cls4.isAssignableFrom((Class) type)) {
                            cls = (Class) type;
                        } else {
                            i2++;
                        }
                        cls3 = cls;
                        break;
                    }
                }
            } catch (GenericSignatureFormatError e2) {
                e2.printStackTrace();
            } catch (TypeNotPresentException e3) {
                e3.printStackTrace();
            } catch (MalformedParameterizedTypeException e4) {
                e4.printStackTrace();
            }
            cls3 = null;
            cls2 = cls2.getSuperclass();
        }
        if (cls3 == null) {
            baseViewHolder = new BaseViewHolder(view);
        } else {
            try {
                Class<View> cls5 = View.class;
                if (cls3.isMemberClass()) {
                    if (!Modifier.isStatic(cls3.getModifiers())) {
                        Constructor declaredConstructor = cls3.getDeclaredConstructor(new Class[]{getClass(), cls5});
                        Intrinsics.b(declaredConstructor, "z.getDeclaredConstructor…aClass, View::class.java)");
                        declaredConstructor.setAccessible(true);
                        Object newInstance = declaredConstructor.newInstance(new Object[]{this, view});
                        if (newInstance != null) {
                            baseViewHolder2 = (BaseViewHolder) newInstance;
                            baseViewHolder3 = baseViewHolder2;
                            baseViewHolder = baseViewHolder3;
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type VH");
                        }
                    }
                }
                Constructor declaredConstructor2 = cls3.getDeclaredConstructor(new Class[]{cls5});
                Intrinsics.b(declaredConstructor2, "z.getDeclaredConstructor(View::class.java)");
                declaredConstructor2.setAccessible(true);
                Object newInstance2 = declaredConstructor2.newInstance(new Object[]{view});
                if (newInstance2 != null) {
                    baseViewHolder2 = (BaseViewHolder) newInstance2;
                    baseViewHolder3 = baseViewHolder2;
                    baseViewHolder = baseViewHolder3;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type VH");
                }
            } catch (NoSuchMethodException e5) {
                e5.printStackTrace();
            } catch (IllegalAccessException e6) {
                e6.printStackTrace();
            } catch (InstantiationException e7) {
                e7.printStackTrace();
            } catch (InvocationTargetException e8) {
                e8.printStackTrace();
            }
        }
        if (baseViewHolder != null) {
            return baseViewHolder;
        }
        return new BaseViewHolder(view);
    }

    public int f(int i2) {
        return super.getItemViewType(i2);
    }

    public final boolean g() {
        FrameLayout frameLayout = this.e;
        if (frameLayout == null || frameLayout.getChildCount() == 0 || !this.b) {
            return false;
        }
        return this.f179a.isEmpty();
    }

    public final int getItemCount() {
        if (g()) {
            return 1;
        }
        return (h() ? 1 : 0) + this.f179a.size() + (i() ? 1 : 0);
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final int getItemViewType(int i2) {
        if (!g()) {
            boolean i3 = i();
            if (i3 && i2 == 0) {
                return 268435729;
            }
            if (i3) {
                i2--;
            }
            int size = this.f179a.size();
            if (i2 < size) {
                return f(i2);
            }
            if (i2 - size < h()) {
                return 268436275;
            }
            return 268436002;
        } else if (i2 == 0 || (i2 != 1 && i2 != 2)) {
            return 268436821;
        } else {
            return 268436275;
        }
    }

    public final boolean h() {
        LinearLayout linearLayout = this.d;
        if (linearLayout == null) {
            return false;
        }
        if (linearLayout == null) {
            Intrinsics.k("mFooterLayout");
            throw null;
        } else if (linearLayout.getChildCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean i() {
        LinearLayout linearLayout = this.c;
        if (linearLayout == null) {
            return false;
        }
        if (linearLayout == null) {
            Intrinsics.k("mHeaderLayout");
            throw null;
        } else if (linearLayout.getChildCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean j(int i2) {
        return i2 == 268436821 || i2 == 268435729 || i2 == 268436275 || i2 == 268436002;
    }

    /* renamed from: k */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        Intrinsics.e(baseViewHolder, "holder");
        switch (baseViewHolder.getItemViewType()) {
            case 268435729:
            case 268436275:
            case 268436821:
                return;
            case 268436002:
                BaseLoadMoreModule baseLoadMoreModule = this.i;
                if (baseLoadMoreModule != null) {
                    LoadMoreModuleConfig.f186a.a(baseViewHolder, baseLoadMoreModule.f185a);
                    return;
                }
                return;
            default:
                c(baseViewHolder, this.f179a.get(i2 - (i() ? 1 : 0)));
                return;
        }
    }

    /* renamed from: l */
    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2, List list) {
        Intrinsics.e(baseViewHolder, "holder");
        Intrinsics.e(list, "payloads");
        if (list.isEmpty()) {
            onBindViewHolder(baseViewHolder, i2);
            return;
        }
        switch (baseViewHolder.getItemViewType()) {
            case 268435729:
            case 268436275:
            case 268436821:
                return;
            case 268436002:
                BaseLoadMoreModule baseLoadMoreModule = this.i;
                if (baseLoadMoreModule != null) {
                    LoadMoreModuleConfig.f186a.a(baseViewHolder, baseLoadMoreModule.f185a);
                    return;
                }
                return;
            default:
                d(baseViewHolder, this.f179a.get(i2 - (i() ? 1 : 0)), list);
                return;
        }
    }

    public BaseViewHolder m(ViewGroup viewGroup) {
        Intrinsics.e(viewGroup, "parent");
        return e(AdapterUtilsKt.a(viewGroup, this.k));
    }

    /* renamed from: n */
    public void onViewAttachedToWindow(BaseViewHolder baseViewHolder) {
        Intrinsics.e(baseViewHolder, "holder");
        super.onViewAttachedToWindow(baseViewHolder);
        if (j(baseViewHolder.getItemViewType())) {
            View view = baseViewHolder.itemView;
            Intrinsics.b(view, "holder.itemView");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
            }
        }
    }

    public void o(List list) {
        if (list != this.f179a) {
            if (list == null) {
                list = new ArrayList();
            }
            this.f179a = list;
            notifyDataSetChanged();
        }
    }

    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.e(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        new WeakReference(recyclerView);
        this.j = recyclerView;
        Intrinsics.b(recyclerView.getContext(), "recyclerView.context");
        BaseDraggableModule baseDraggableModule = this.h;
        if (baseDraggableModule != null) {
            ItemTouchHelper itemTouchHelper = baseDraggableModule.f184a;
            if (itemTouchHelper != null) {
                itemTouchHelper.attachToRecyclerView(recyclerView);
            } else {
                Intrinsics.k("itemTouchHelper");
                throw null;
            }
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new BaseQuickAdapter$onAttachedToRecyclerView$1(this, (GridLayoutManager) layoutManager, gridLayoutManager.getSpanSizeLookup()));
        }
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        Intrinsics.e(viewGroup, "parent");
        switch (i2) {
            case 268435729:
                LinearLayout linearLayout = this.c;
                if (linearLayout != null) {
                    ViewParent parent = linearLayout.getParent();
                    if (parent instanceof ViewGroup) {
                        ViewGroup viewGroup2 = (ViewGroup) parent;
                        LinearLayout linearLayout2 = this.c;
                        if (linearLayout2 != null) {
                            viewGroup2.removeView(linearLayout2);
                        } else {
                            Intrinsics.k("mHeaderLayout");
                            throw null;
                        }
                    }
                    LinearLayout linearLayout3 = this.c;
                    if (linearLayout3 != null) {
                        return e(linearLayout3);
                    }
                    Intrinsics.k("mHeaderLayout");
                    throw null;
                }
                Intrinsics.k("mHeaderLayout");
                throw null;
            case 268436002:
                BaseLoadMoreModule baseLoadMoreModule = this.i;
                if (baseLoadMoreModule == null) {
                    Intrinsics.i();
                }
                baseLoadMoreModule.getClass();
                BaseViewHolder e2 = e(AdapterUtilsKt.a(viewGroup, R.layout.brvah_quick_view_load_more));
                BaseLoadMoreModule baseLoadMoreModule2 = this.i;
                if (baseLoadMoreModule2 == null) {
                    Intrinsics.i();
                }
                baseLoadMoreModule2.a(e2);
                return e2;
            case 268436275:
                LinearLayout linearLayout4 = this.d;
                if (linearLayout4 != null) {
                    ViewParent parent2 = linearLayout4.getParent();
                    if (parent2 instanceof ViewGroup) {
                        ViewGroup viewGroup3 = (ViewGroup) parent2;
                        LinearLayout linearLayout5 = this.d;
                        if (linearLayout5 != null) {
                            viewGroup3.removeView(linearLayout5);
                        } else {
                            Intrinsics.k("mFooterLayout");
                            throw null;
                        }
                    }
                    LinearLayout linearLayout6 = this.d;
                    if (linearLayout6 != null) {
                        return e(linearLayout6);
                    }
                    Intrinsics.k("mFooterLayout");
                    throw null;
                }
                Intrinsics.k("mFooterLayout");
                throw null;
            case 268436821:
                FrameLayout frameLayout = this.e;
                if (frameLayout != null) {
                    ViewParent parent3 = frameLayout.getParent();
                    if (parent3 instanceof ViewGroup) {
                        ViewGroup viewGroup4 = (ViewGroup) parent3;
                        FrameLayout frameLayout2 = this.e;
                        if (frameLayout2 != null) {
                            viewGroup4.removeView(frameLayout2);
                        } else {
                            Intrinsics.k("mEmptyLayout");
                            throw null;
                        }
                    }
                    FrameLayout frameLayout3 = this.e;
                    if (frameLayout3 != null) {
                        return e(frameLayout3);
                    }
                    Intrinsics.k("mEmptyLayout");
                    throw null;
                }
                Intrinsics.k("mEmptyLayout");
                throw null;
            default:
                BaseViewHolder m = m(viewGroup);
                b(m, i2);
                return m;
        }
    }

    public final void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Intrinsics.e(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.j = null;
    }
}
