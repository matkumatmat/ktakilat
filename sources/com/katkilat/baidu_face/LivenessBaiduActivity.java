package com.katkilat.baidu_face;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.idl.face.platform.FaceStatusNewEnum;
import com.baidu.idl.face.platform.model.ImageInfo;
import com.baidu.idl.face.platform.utils.Base64Utils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.katkilat.baidu_face.widget.TimeoutDialog;
import com.ktakilat.cbase.datacollect.KtaCollect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/katkilat/baidu_face/LivenessBaiduActivity;", "Lcom/katkilat/baidu_face/BaseLivenessBaiduActivity;", "Lcom/katkilat/baidu_face/widget/TimeoutDialog$OnTimeoutDialogClickListener;", "<init>", "()V", "baidu_face_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLivenessBaiduActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LivenessBaiduActivity.kt\ncom/katkilat/baidu_face/LivenessBaiduActivity\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,158:1\n37#2:159\n36#2,3:160\n37#2:163\n36#2,3:164\n*S KotlinDebug\n*F\n+ 1 LivenessBaiduActivity.kt\ncom/katkilat/baidu_face/LivenessBaiduActivity\n*L\n77#1:159\n77#1:160,3\n79#1:163\n79#1:164,3\n*E\n"})
public final class LivenessBaiduActivity extends BaseLivenessBaiduActivity implements TimeoutDialog.OnTimeoutDialogClickListener {
    public static final /* synthetic */ int G = 0;
    public TimeoutDialog F;

    public final void a() {
        TimeoutDialog timeoutDialog = this.F;
        if (timeoutDialog != null) {
            if (timeoutDialog != null) {
                timeoutDialog.dismiss();
            }
            this.A = false;
        }
        onResume();
    }

    public final void b() {
        TimeoutDialog timeoutDialog = this.F;
        if (timeoutDialog != null) {
            if (timeoutDialog != null) {
                timeoutDialog.dismiss();
            }
            this.A = false;
        }
        finish();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KtaCollect.n_liveness_exposure();
    }

    public final void onLivenessCompletion(FaceStatusNewEnum faceStatusNewEnum, String str, HashMap hashMap, HashMap hashMap2, int i) {
        Intrinsics.checkNotNullParameter(faceStatusNewEnum, "status");
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        super.onLivenessCompletion(faceStatusNewEnum, str, hashMap, hashMap2, i);
        if (faceStatusNewEnum == FaceStatusNewEnum.OK && this.s) {
            KtaCollect.n_face_result(AppEventsConstants.EVENT_PARAM_VALUE_YES);
            String str2 = null;
            if (hashMap2 != null && hashMap2.size() > 0) {
                ArrayList arrayList = new ArrayList(hashMap2.entrySet());
                Collections.sort(arrayList, new a7(new e3(7), 1));
                ImageInfo imageInfo = (ImageInfo) ((Map.Entry) arrayList.get(0)).getValue();
                if (imageInfo != null) {
                    str2 = imageInfo.getBase64();
                }
            }
            if (str2 != null && !StringsKt.t(str2)) {
                int i2 = R.string.verify_success;
                byte[] decode = Base64Utils.decode(str2, 2);
                Intrinsics.checkNotNullExpressionValue(decode, "decode(...)");
                String string = getResources().getString(i2);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("result", string);
                bundle.putInt("code", i2);
                bundle.putString("delta", "");
                bundle.putByteArray(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO, decode);
                intent.putExtra("self-result", bundle);
                setResult(-1, intent);
                finish();
            }
        } else if (faceStatusNewEnum == FaceStatusNewEnum.DetectRemindCodeTimeout) {
            KtaCollect.n_face_result(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            TimeoutDialog timeoutDialog = new TimeoutDialog(this, new LivenessBaiduActivity$showMessageDialog$1(this));
            this.F = timeoutDialog;
            timeoutDialog.setCanceledOnTouchOutside(false);
            TimeoutDialog timeoutDialog2 = this.F;
            if (timeoutDialog2 != null) {
                timeoutDialog2.setCancelable(false);
            }
            TimeoutDialog timeoutDialog3 = this.F;
            if (timeoutDialog3 != null) {
                timeoutDialog3.show();
            }
            this.A = true;
            onPause();
        }
    }
}
