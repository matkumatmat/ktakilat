package com.katkilat.baidu_face.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.katkilat.baidu_face.R;
import com.katkilat.baidu_face.widget.FaceDetectRoundView;
import com.ktakilat.cbase.databinding.ModernAppBarBinding;

public final class ActivityLivenessBaiduBinding implements ViewBinding {
    @NonNull
    public final RelativeLayout addImageLayout;
    @NonNull
    public final FaceDetectRoundView faceRound;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView secondTipsTv;
    @NonNull
    public final ImageView soundImage;
    @NonNull
    public final FrameLayout surfaceLayout;
    @NonNull
    public final ModernAppBarBinding titleInclude;
    @NonNull
    public final TextView topTipsTv;

    private ActivityLivenessBaiduBinding(@NonNull ConstraintLayout constraintLayout, @NonNull RelativeLayout relativeLayout, @NonNull FaceDetectRoundView faceDetectRoundView, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull ModernAppBarBinding modernAppBarBinding, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.addImageLayout = relativeLayout;
        this.faceRound = faceDetectRoundView;
        this.secondTipsTv = textView;
        this.soundImage = imageView;
        this.surfaceLayout = frameLayout;
        this.titleInclude = modernAppBarBinding;
        this.topTipsTv = textView2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        r0 = com.katkilat.baidu_face.R.id.title_include;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.katkilat.baidu_face.databinding.ActivityLivenessBaiduBinding bind(@androidx.annotation.NonNull android.view.View r11) {
        /*
            int r0 = com.katkilat.baidu_face.R.id.add_image_layout
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r4 = r1
            android.widget.RelativeLayout r4 = (android.widget.RelativeLayout) r4
            if (r4 == 0) goto L_0x0058
            int r0 = com.katkilat.baidu_face.R.id.face_round
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r5 = r1
            com.katkilat.baidu_face.widget.FaceDetectRoundView r5 = (com.katkilat.baidu_face.widget.FaceDetectRoundView) r5
            if (r5 == 0) goto L_0x0058
            int r0 = com.katkilat.baidu_face.R.id.second_tips_tv
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x0058
            int r0 = com.katkilat.baidu_face.R.id.sound_image
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r7 = r1
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x0058
            int r0 = com.katkilat.baidu_face.R.id.surface_layout
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r8 = r1
            android.widget.FrameLayout r8 = (android.widget.FrameLayout) r8
            if (r8 == 0) goto L_0x0058
            int r0 = com.katkilat.baidu_face.R.id.title_include
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r1 == 0) goto L_0x0058
            com.ktakilat.cbase.databinding.ModernAppBarBinding r9 = com.ktakilat.cbase.databinding.ModernAppBarBinding.bind(r1)
            int r0 = com.katkilat.baidu_face.R.id.top_tips_tv
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0058
            com.katkilat.baidu_face.databinding.ActivityLivenessBaiduBinding r0 = new com.katkilat.baidu_face.databinding.ActivityLivenessBaiduBinding
            r3 = r11
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        L_0x0058:
            android.content.res.Resources r11 = r11.getResources()
            java.lang.String r11 = r11.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r11 = r1.concat(r11)
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.katkilat.baidu_face.databinding.ActivityLivenessBaiduBinding.bind(android.view.View):com.katkilat.baidu_face.databinding.ActivityLivenessBaiduBinding");
    }

    @NonNull
    public static ActivityLivenessBaiduBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityLivenessBaiduBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_liveness_baidu, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
