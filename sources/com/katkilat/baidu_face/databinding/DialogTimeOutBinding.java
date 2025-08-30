package com.katkilat.baidu_face.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.katkilat.baidu_face.R;

public abstract class DialogTimeOutBinding extends ViewDataBinding {
    @NonNull
    public final Button btnDialogRecollect;
    @NonNull
    public final Button btnDialogReturn;
    @NonNull
    public final ImageView imageIcon;
    @NonNull
    public final TextView textTitle;
    @NonNull
    public final View viewLine1;
    @NonNull
    public final View viewLine2;

    public DialogTimeOutBinding(Object obj, View view, int i, Button button, Button button2, ImageView imageView, TextView textView, View view2, View view3) {
        super(obj, view, i);
        this.btnDialogRecollect = button;
        this.btnDialogReturn = button2;
        this.imageIcon = imageView;
        this.textTitle = textView;
        this.viewLine1 = view2;
        this.viewLine2 = view3;
    }

    public static DialogTimeOutBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static DialogTimeOutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogTimeOutBinding bind(@NonNull View view, @Nullable Object obj) {
        return (DialogTimeOutBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_time_out);
    }

    @NonNull
    @Deprecated
    public static DialogTimeOutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (DialogTimeOutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_time_out, viewGroup, z, obj);
    }

    @NonNull
    public static DialogTimeOutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static DialogTimeOutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (DialogTimeOutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_time_out, (ViewGroup) null, false, obj);
    }
}
