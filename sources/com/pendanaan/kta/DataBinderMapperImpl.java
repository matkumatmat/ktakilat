package com.pendanaan.kta;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {

    /* renamed from: a  reason: collision with root package name */
    public static final SparseIntArray f628a = new SparseIntArray(0);

    public static class InnerBrLookup {

        /* renamed from: a  reason: collision with root package name */
        public static final SparseArray f629a;

        static {
            SparseArray sparseArray = new SparseArray(1);
            f629a = sparseArray;
            sparseArray.put(0, "_all");
        }
    }

    public static class InnerLayoutIdLookup {

        /* renamed from: a  reason: collision with root package name */
        public static final HashMap f630a = new HashMap(0);
    }

    public final List collectDependencies() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.chad.library.DataBinderMapperImpl());
        arrayList.add(new com.katkilat.baidu_face.DataBinderMapperImpl());
        return arrayList;
    }

    public final String convertBrIdToString(int i) {
        return (String) InnerBrLookup.f629a.get(i);
    }

    public final ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        if (f628a.get(i) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public final int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = (Integer) InnerLayoutIdLookup.f630a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || f628a.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
