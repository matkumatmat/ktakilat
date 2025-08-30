package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ktakilat.loan.R;
import com.ktakilat.loan.weiget.ExcelEditView;

public final class DialogEktpVerifyBinding implements ViewBinding {
    @NonNull
    public final View bg1View;
    @NonNull
    public final View bg2View;
    @NonNull
    public final View bg3View;
    @NonNull
    public final View bg4View;
    @NonNull
    public final View bg5View;
    @NonNull
    public final View bg6View;
    @NonNull
    public final ImageView closeIv;
    @NonNull
    public final ExcelEditView ektpEt;
    @NonNull
    public final TextView ektpNoTv;
    @NonNull
    private final RelativeLayout rootView;

    private DialogEktpVerifyBinding(@NonNull RelativeLayout relativeLayout, @NonNull View view, @NonNull View view2, @NonNull View view3, @NonNull View view4, @NonNull View view5, @NonNull View view6, @NonNull ImageView imageView, @NonNull ExcelEditView excelEditView, @NonNull TextView textView) {
        this.rootView = relativeLayout;
        this.bg1View = view;
        this.bg2View = view2;
        this.bg3View = view3;
        this.bg4View = view4;
        this.bg5View = view5;
        this.bg6View = view6;
        this.closeIv = imageView;
        this.ektpEt = excelEditView;
        this.ektpNoTv = textView;
    }

    @NonNull
    public static DialogEktpVerifyBinding bind(@NonNull View view) {
        int i = R.id.bg_1_view;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.bg_1_view);
        if (findChildViewById != null) {
            i = R.id.bg_2_view;
            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.bg_2_view);
            if (findChildViewById2 != null) {
                i = R.id.bg_3_view;
                View findChildViewById3 = ViewBindings.findChildViewById(view, R.id.bg_3_view);
                if (findChildViewById3 != null) {
                    i = R.id.bg_4_view;
                    View findChildViewById4 = ViewBindings.findChildViewById(view, R.id.bg_4_view);
                    if (findChildViewById4 != null) {
                        i = R.id.bg_5_view;
                        View findChildViewById5 = ViewBindings.findChildViewById(view, R.id.bg_5_view);
                        if (findChildViewById5 != null) {
                            i = R.id.bg_6_view;
                            View findChildViewById6 = ViewBindings.findChildViewById(view, R.id.bg_6_view);
                            if (findChildViewById6 != null) {
                                i = R.id.close_iv;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.close_iv);
                                if (imageView != null) {
                                    i = R.id.ektp_et;
                                    ExcelEditView excelEditView = (ExcelEditView) ViewBindings.findChildViewById(view, R.id.ektp_et);
                                    if (excelEditView != null) {
                                        i = R.id.ektp_no_tv;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.ektp_no_tv);
                                        if (textView != null) {
                                            return new DialogEktpVerifyBinding((RelativeLayout) view, findChildViewById, findChildViewById2, findChildViewById3, findChildViewById4, findChildViewById5, findChildViewById6, imageView, excelEditView, textView);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static DialogEktpVerifyBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DialogEktpVerifyBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_ektp_verify, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
