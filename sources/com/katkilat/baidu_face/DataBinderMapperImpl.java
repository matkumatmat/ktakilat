package com.katkilat.baidu_face;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.katkilat.baidu_face.databinding.DialogTimeOutBindingImpl;
import com.katkilat.baidu_face.databinding.WidgetActionBar2BindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {

    /* renamed from: a  reason: collision with root package name */
    public static final SparseIntArray f454a;

    public static class InnerBrLookup {

        /* renamed from: a  reason: collision with root package name */
        public static final SparseArray f455a;

        static {
            SparseArray sparseArray = new SparseArray(1);
            f455a = sparseArray;
            sparseArray.put(0, "_all");
        }
    }

    public static class InnerLayoutIdLookup {

        /* renamed from: a  reason: collision with root package name */
        public static final HashMap f456a;

        static {
            HashMap hashMap = new HashMap(2);
            f456a = hashMap;
            hashMap.put("layout/dialog_time_out_0", Integer.valueOf(R.layout.dialog_time_out));
            hashMap.put("layout/widget_action_bar2_0", Integer.valueOf(R.layout.widget_action_bar2));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(2);
        f454a = sparseIntArray;
        sparseIntArray.put(R.layout.dialog_time_out, 1);
        sparseIntArray.put(R.layout.widget_action_bar2, 2);
    }

    public final List collectDependencies() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.chad.library.DataBinderMapperImpl());
        return arrayList;
    }

    public final String convertBrIdToString(int i) {
        return (String) InnerBrLookup.f455a.get(i);
    }

    public final ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = f454a.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        } else if (i2 != 1) {
            if (i2 != 2) {
                return null;
            }
            if ("layout/widget_action_bar2_0".equals(tag)) {
                return new WidgetActionBar2BindingImpl(dataBindingComponent, view);
            }
            throw new IllegalArgumentException("The tag for widget_action_bar2 is invalid. Received: " + tag);
        } else if ("layout/dialog_time_out_0".equals(tag)) {
            return new DialogTimeOutBindingImpl(dataBindingComponent, view);
        } else {
            throw new IllegalArgumentException("The tag for dialog_time_out is invalid. Received: " + tag);
        }
    }

    public final int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = (Integer) InnerLayoutIdLookup.f456a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || f454a.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
