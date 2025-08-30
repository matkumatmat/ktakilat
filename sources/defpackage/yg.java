package defpackage;

import android.app.Activity;
import com.ktakilat.loan.R;
import com.ktakilat.loan.verify_face.BaseVerifyFaceActivity;
import com.ktakilat.loan.weiget.dialog.DialogUtils;

/* renamed from: yg  reason: default package */
public final /* synthetic */ class yg implements BaseVerifyFaceActivity.PermissionCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f848a;
    public final /* synthetic */ Activity b;

    public /* synthetic */ yg(Activity activity, int i) {
        this.f848a = i;
        this.b = activity;
    }

    public final void c(boolean z) {
        switch (this.f848a) {
            case 0:
                if (!z) {
                    Activity activity = this.b;
                    DialogUtils.h(activity, activity.getString(R.string.camera), (DialogUtils.SettingStatusCall) null);
                    return;
                }
                return;
            case 1:
                if (!z) {
                    Activity activity2 = this.b;
                    DialogUtils.h(activity2, activity2.getString(R.string.camera), (DialogUtils.SettingStatusCall) null);
                    return;
                }
                return;
            case 2:
                if (!z) {
                    Activity activity3 = this.b;
                    DialogUtils.h(activity3, activity3.getString(R.string.camera), (DialogUtils.SettingStatusCall) null);
                    return;
                }
                return;
            default:
                if (!z) {
                    Activity activity4 = this.b;
                    DialogUtils.h(activity4, activity4.getString(R.string.camera), (DialogUtils.SettingStatusCall) null);
                    return;
                }
                return;
        }
    }
}
