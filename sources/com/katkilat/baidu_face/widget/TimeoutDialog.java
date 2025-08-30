package com.katkilat.baidu_face.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.databinding.DataBindingUtil;
import com.baidu.idl.face.platform.utils.DensityUtils;
import com.facebook.places.model.PlaceFields;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.katkilat.baidu_face.R;
import com.katkilat.baidu_face.databinding.DialogTimeOutBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/katkilat/baidu_face/widget/TimeoutDialog;", "Landroid/app/Dialog;", "OnTimeoutDialogClickListener", "baidu_face_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TimeoutDialog extends Dialog {
    public final OnTimeoutDialogClickListener c;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/katkilat/baidu_face/widget/TimeoutDialog$OnTimeoutDialogClickListener;", "", "baidu_face_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface OnTimeoutDialogClickListener {
        void a();

        void b();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TimeoutDialog(Context context, OnTimeoutDialogClickListener onTimeoutDialogClickListener) {
        super(context, R.style.DefaultDialog);
        Intrinsics.checkNotNullParameter(context, PlaceFields.CONTEXT);
        Intrinsics.checkNotNullParameter(onTimeoutDialogClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.c = onTimeoutDialogClickListener;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WindowManager.LayoutParams layoutParams = null;
        DialogTimeOutBinding dialogTimeOutBinding = (DialogTimeOutBinding) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.dialog_time_out, (ViewGroup) null, false);
        setContentView(dialogTimeOutBinding.getRoot());
        Window window = getWindow();
        if (window != null) {
            window.setGravity(1);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            layoutParams = window2.getAttributes();
        }
        int px2dip = DensityUtils.px2dip(getContext(), (float) DensityUtils.getDisplayWidth(getContext())) - 40;
        if (layoutParams != null) {
            layoutParams.width = DensityUtils.dip2px(getContext(), (float) px2dip);
        }
        if (layoutParams != null) {
            layoutParams.height = -2;
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setAttributes(layoutParams);
        }
        dialogTimeOutBinding.btnDialogRecollect.setOnClickListener(new zf(this, 0));
        dialogTimeOutBinding.btnDialogReturn.setOnClickListener(new zf(this, 1));
    }
}
