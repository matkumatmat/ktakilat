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
import com.ktakilat.cbase.databinding.CWidgetActionBarBinding;
import com.ktakilat.loan.R;

public final class CActivityLoginFaceBinding implements ViewBinding {
    @NonNull
    public final TextView loginTv;
    @NonNull
    public final ImageView loginV1Tip1;
    @NonNull
    public final TextView mobileTv;
    @NonNull
    public final TextView moreTv;
    @NonNull
    public final CWidgetActionBarBinding pageTitle;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final TextView tip3Tv;

    private CActivityLoginFaceBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull CWidgetActionBarBinding cWidgetActionBarBinding, @NonNull TextView textView4) {
        this.rootView = relativeLayout;
        this.loginTv = textView;
        this.loginV1Tip1 = imageView;
        this.mobileTv = textView2;
        this.moreTv = textView3;
        this.pageTitle = cWidgetActionBarBinding;
        this.tip3Tv = textView4;
    }

    @NonNull
    public static CActivityLoginFaceBinding bind(@NonNull View view) {
        int i = R.id.login_tv;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.login_tv);
        if (textView != null) {
            i = R.id.login_v1_tip_1;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.login_v1_tip_1);
            if (imageView != null) {
                i = R.id.mobile_tv;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.mobile_tv);
                if (textView2 != null) {
                    i = R.id.more_tv;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.more_tv);
                    if (textView3 != null) {
                        i = R.id.page_title;
                        View findChildViewById = ViewBindings.findChildViewById(view, R.id.page_title);
                        if (findChildViewById != null) {
                            CWidgetActionBarBinding bind = CWidgetActionBarBinding.bind(findChildViewById);
                            i = R.id.tip_3_tv;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tip_3_tv);
                            if (textView4 != null) {
                                return new CActivityLoginFaceBinding((RelativeLayout) view, textView, imageView, textView2, textView3, bind, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static CActivityLoginFaceBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CActivityLoginFaceBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.c_activity_login_face, viewGroup, false);
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
