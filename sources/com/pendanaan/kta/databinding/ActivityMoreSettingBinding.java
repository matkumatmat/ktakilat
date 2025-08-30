package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ktakilat.cbase.databinding.CWidgetActionBarBinding;
import com.ktakilat.loan.R;

public final class ActivityMoreSettingBinding implements ViewBinding {
    @NonNull
    public final CardView faceCardView;
    @NonNull
    public final TextView forgetPassTv;
    @NonNull
    public final CWidgetActionBarBinding pageTitle;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView setFaceOffTv;
    @NonNull
    public final TextView setFaceOnTv;
    @NonNull
    public final TextView setGestureTv;

    private ActivityMoreSettingBinding(@NonNull LinearLayout linearLayout, @NonNull CardView cardView, @NonNull TextView textView, @NonNull CWidgetActionBarBinding cWidgetActionBarBinding, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.rootView = linearLayout;
        this.faceCardView = cardView;
        this.forgetPassTv = textView;
        this.pageTitle = cWidgetActionBarBinding;
        this.setFaceOffTv = textView2;
        this.setFaceOnTv = textView3;
        this.setGestureTv = textView4;
    }

    @NonNull
    public static ActivityMoreSettingBinding bind(@NonNull View view) {
        int i = R.id.face_card_view;
        CardView cardView = (CardView) ViewBindings.findChildViewById(view, R.id.face_card_view);
        if (cardView != null) {
            i = R.id.forget_pass_tv;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.forget_pass_tv);
            if (textView != null) {
                i = R.id.page_title;
                View findChildViewById = ViewBindings.findChildViewById(view, R.id.page_title);
                if (findChildViewById != null) {
                    CWidgetActionBarBinding bind = CWidgetActionBarBinding.bind(findChildViewById);
                    i = R.id.set_face_off_tv;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.set_face_off_tv);
                    if (textView2 != null) {
                        i = R.id.set_face_on_tv;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.set_face_on_tv);
                        if (textView3 != null) {
                            i = R.id.set_gesture_tv;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.set_gesture_tv);
                            if (textView4 != null) {
                                return new ActivityMoreSettingBinding((LinearLayout) view, cardView, textView, bind, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ActivityMoreSettingBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityMoreSettingBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_more_setting, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
